package com.android.server.policy;

import android.R;
import android.app.role.RoleManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Icon;
import android.hardware.input.AppLaunchData;
import android.hardware.input.InputGestureData;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.KeyboardShortcutInfo;
import com.android.internal.app.ResolverActivity;
import com.android.internal.policy.IShortcutService;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import com.android.server.input.InputManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ModifierShortcutManager {
    private static final String ATTRIBUTE_CATEGORY = "category";
    private static final String ATTRIBUTE_CLASS = "class";
    private static final String ATTRIBUTE_KEYCODE = "keycode";
    private static final String ATTRIBUTE_PACKAGE = "package";
    private static final String ATTRIBUTE_ROLE = "role";
    private static final String ATTRIBUTE_SHIFT = "shift";
    private static final String ATTRIBUTE_SHORTCUT = "shortcut";
    public static final String EXTRA_ROLE = "com.android.server.policy.ModifierShortcutManager.EXTRA_ROLE";
    private static final String TAG = "ModifierShortcutManager";
    private static final String TAG_BOOKMARK = "bookmark";
    private static final String TAG_BOOKMARKS = "bookmarks";
    static SparseArray<String> sApplicationLaunchKeyCategories;
    static SparseArray<String> sApplicationLaunchKeyRoles;
    private final Map<AppLaunchData, Intent> mAppIntentCache;
    private final Map<Pair<Character, Boolean>, Bookmark> mBookmarks;
    private final SparseArray<Intent> mCategoryShortcuts;
    private final Map<ComponentName, Intent> mComponentIntents;
    private final SparseArray<ComponentName> mComponentShortcuts;
    private boolean mConsumeSearchKeyUp;
    private final Context mContext;
    private UserHandle mCurrentUser;
    private final Handler mHandler;
    private final InputManagerInternal mInputManagerInternal;
    private final Map<String, Intent> mRoleIntents;
    private final SparseArray<String> mRoleShortcuts;
    private boolean mSearchKeyShortcutPending;
    private final SparseArray<Intent> mShiftCategoryShortcuts;
    private final SparseArray<ComponentName> mShiftComponentShortcuts;
    private final SparseArray<String> mShiftRoleShortcuts;
    private LongSparseArray<IShortcutService> mShortcutKeyServices;

    private static abstract class Bookmark {
        protected Intent mIntent;
        private final boolean mShift;
        private final char mShortcutChar;

        public abstract Intent getIntent(Context r1);

        Bookmark(char shortcutChar, boolean shift) {
            this.mShortcutChar = shortcutChar;
            this.mShift = shift;
        }

        public char getShortcutChar() {
            return this.mShortcutChar;
        }

        public boolean isShift() {
            return this.mShift;
        }

        public void clearIntent() {
            this.mIntent = null;
        }
    }

    private static final class CategoryBookmark extends Bookmark {
        private final String mCategory;

        CategoryBookmark(char shortcutChar, boolean shift, String category) {
            super(shortcutChar, shift);
            this.mCategory = category;
        }

        @Override // com.android.server.policy.ModifierShortcutManager.Bookmark
        public Intent getIntent(Context context) {
            if (this.mIntent != null) goto L5;
            this.mIntent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", this.mCategory);
            return this.mIntent;
        L5:
            return this.mIntent;
        }
    }

    private static final class ComponentBookmark extends Bookmark {
        private final String mClassName;
        private final String mPackageName;

        ComponentBookmark(char shortcutChar, boolean shift, String packageName, String className) {
            super(shortcutChar, shift);
            this.mPackageName = packageName;
            this.mClassName = className;
        }

        @Override // com.android.server.policy.ModifierShortcutManager.Bookmark
        public Intent getIntent(Context context) {
            if (this.mIntent != null) goto L5;
            this.mIntent = ModifierShortcutManager.m7153$$Nest$smresolveComponentNameIntent(context, this.mPackageName, this.mClassName);
            return this.mIntent;
        L5:
            return this.mIntent;
        }
    }

    private static final class RoleBookmark extends Bookmark {
        private final String mRole;

        RoleBookmark(char shortcutChar, boolean shift, String role) {
            super(shortcutChar, shift);
            this.mRole = role;
        }

        public String getRole() {
            return this.mRole;
        }

        @Override // com.android.server.policy.ModifierShortcutManager.Bookmark
        public Intent getIntent(Context context) {
            if (this.mIntent != null) goto L5;
            this.mIntent = ModifierShortcutManager.m7152$$Nest$smgetRoleLaunchIntent(context, this.mRole);
            return this.mIntent;
        L5:
            return this.mIntent;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$W3KmBtds13Ht6vpLq2KKi1MBK-4, reason: not valid java name */
    public static /* synthetic */ boolean m7151$r8$lambda$W3KmBtds13Ht6vpLq2KKi1MBK4(Bookmark r0) {
        return lambda$clearComponentIntents$4(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$Zs6QXZ1A7pXQwLZywmqj70CJfuk(String r0, Bookmark r1) {
        return lambda$new$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$dqMV3scjH96xksCoywDgcrJhNwk(String r0, Map.Entry r1) {
        return lambda$new$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ksD7kk_KZ17ryxi7p3UXzaqQ4wk(ModifierShortcutManager r0, String r1, UserHandle r2) {
        r0.lambda$new$2(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$wCRuhzp6F_m4uFOcyvutHe8EaOc(Bookmark r0) {
        return lambda$clearRoleIntents$3(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetRoleLaunchIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m7152$$Nest$smgetRoleLaunchIntent(Context r0, String r1) {
        return getRoleLaunchIntent(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smresolveComponentNameIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m7153$$Nest$smresolveComponentNameIntent(Context r0, String r1, String r2) {
        return resolveComponentNameIntent(r0, r1, r2);
    }

    static {
        sApplicationLaunchKeyRoles = new SparseArray();
        sApplicationLaunchKeyCategories = new SparseArray();
        sApplicationLaunchKeyRoles.append(64, "android.app.role.BROWSER");
        sApplicationLaunchKeyCategories.append(65, "android.intent.category.APP_EMAIL");
        sApplicationLaunchKeyCategories.append(207, "android.intent.category.APP_CONTACTS");
        sApplicationLaunchKeyCategories.append(208, "android.intent.category.APP_CALENDAR");
        sApplicationLaunchKeyCategories.append(209, "android.intent.category.APP_MUSIC");
        sApplicationLaunchKeyCategories.append(210, "android.intent.category.APP_CALCULATOR");
    }

    ModifierShortcutManager(Context context, Handler handler, UserHandle currentUser) {
        this.mCategoryShortcuts = new SparseArray();
        this.mShiftCategoryShortcuts = new SparseArray();
        this.mRoleShortcuts = new SparseArray();
        this.mShiftRoleShortcuts = new SparseArray();
        this.mRoleIntents = new HashMap();
        this.mComponentShortcuts = new SparseArray();
        this.mShiftComponentShortcuts = new SparseArray();
        this.mComponentIntents = new HashMap();
        this.mShortcutKeyServices = new LongSparseArray();
        this.mSearchKeyShortcutPending = false;
        this.mConsumeSearchKeyUp = true;
        this.mBookmarks = new HashMap();
        this.mAppIntentCache = new HashMap();
        this.mContext = context;
        this.mHandler = handler;
        RoleManager rm = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        rm.addOnRoleHoldersChangedListenerAsUser(this.mContext.getMainExecutor(), new ModifierShortcutManager$$ExternalSyntheticLambda3(this), UserHandle.ALL);
        this.mCurrentUser = currentUser;
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
    }

    private /* synthetic */ void lambda$new$2(final String roleName, UserHandle user) {
        this.mBookmarks.values().stream().filter(new ModifierShortcutManager$$ExternalSyntheticLambda0(roleName)).forEach(new ModifierShortcutManager$$ExternalSyntheticLambda1());
        Map<AppLaunchData, Intent> r0 = this.mAppIntentCache;
        monitor-enter(r0);
        this.mAppIntentCache.entrySet().removeIf(new ModifierShortcutManager$$ExternalSyntheticLambda2(roleName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$new$0(String roleName, Bookmark b) {
        if ((b instanceof RoleBookmark) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RoleBookmark) b).getRole().equals(roleName) == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$new$1(String roleName, Map.Entry entry) {
        if ((entry.getKey() instanceof AppLaunchData.RoleData) == true) goto L5;
        return false;
    L5:
        return Objects.equals(((AppLaunchData.RoleData) entry.getKey()).getRole(), roleName);
    }

    void onSystemReady() {
        loadShortcuts();
    }

    void setCurrentUser(UserHandle newUser) {
        this.mCurrentUser = newUser;
        clearRoleIntents();
        clearComponentIntents();
        Map<AppLaunchData, Intent> r0 = this.mAppIntentCache;
        monitor-enter(r0);
        this.mAppIntentCache.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void clearRoleIntents() {
        this.mBookmarks.values().stream().filter(new ModifierShortcutManager$$ExternalSyntheticLambda4()).forEach(new ModifierShortcutManager$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ boolean lambda$clearRoleIntents$3(Bookmark b) {
        return b instanceof RoleBookmark;
    }

    void clearComponentIntents() {
        this.mBookmarks.values().stream().filter(new ModifierShortcutManager$$ExternalSyntheticLambda5()).forEach(new ModifierShortcutManager$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ boolean lambda$clearComponentIntents$4(Bookmark b) {
        return b instanceof ComponentBookmark;
    }

    private Intent getIntent(KeyCharacterMap kcm, int keyCode, int metaState) {
        boolean isShiftOn = KeyEvent.metaStateHasModifiers(metaState, 1);
        if (isShiftOn == false) goto L5;
    L7:
        int shortcutChar = kcm.get(keyCode, metaState);
        if (shortcutChar != 0) goto L10;
        return null;
    L10:
        Bookmark bookmark = this.mBookmarks.get(new Pair(Character.valueOf((char) shortcutChar), Boolean.valueOf(isShiftOn)));
        if (bookmark != null) goto L16;
        shortcutChar = Character.toLowerCase(kcm.getDisplayLabel(keyCode));
        if (shortcutChar != 0) goto L15;
        return null;
    L15:
        bookmark = this.mBookmarks.get(new Pair(Character.valueOf((char) shortcutChar), Boolean.valueOf(isShiftOn)));
    L16:
        if (bookmark == null) goto L18;
        Context context = this.mContext.createContextAsUser(this.mCurrentUser, 0);
        Intent shortcutIntent = bookmark.getIntent(context);
        return shortcutIntent;
    L18:
        StringBuilder r1 = new StringBuilder();
        r1.append("No bookmark found for ");
        if (isShiftOn == false) goto L21;
        String r5 = "SHIFT+";
    L22:
        r1.append(r5);
        r1.append((char) shortcutChar);
        Log.d(TAG, r1.toString());
        return null;
    L21:
        r5 = "";
        goto L22
    L5:
        if (KeyEvent.metaStateHasNoModifiers(metaState) == true) goto L7;
        return null;
    }

    private static Intent getRoleLaunchIntent(Context context, String role) {
        Intent intent = null;
        RoleManager rm = (RoleManager) context.getSystemService(RoleManager.class);
        PackageManager pm = context.getPackageManager();
        if (rm.isRoleAvailable(role) == false) goto L12;
        String rolePackage = rm.getDefaultApplication(role);
        if (rolePackage == null) goto L10;
        intent = pm.getLaunchIntentForPackage(rolePackage);
        if (intent == null) goto L9;
        intent.putExtra(EXTRA_ROLE, role);
    L13:
        return intent;
    L9:
        Log.w(TAG, "No launch intent for role " + role);
        goto L13
    L10:
        Log.w(TAG, "No default application for role " + role + " user=" + context.getUser());
        goto L13
    L12:
        Log.w(TAG, "Role " + role + " is not available.");
        goto L13
    }

    private Intent getRoleLaunchIntent(String role) {
        Intent intent = this.mRoleIntents.get(role);
        if (intent != null) goto L7;
        Context context = this.mContext.createContextAsUser(this.mCurrentUser, 0);
        intent = getRoleLaunchIntent(context, role);
        if (intent == null) goto L7;
        this.mRoleIntents.put(role, intent);
    L7:
        return intent;
    }

    private void loadShortcuts() {
        ModifierShortcutManager r1 = this;
        XmlResourceParser parser = r1.mContext.getResources().getXml(R.xml.bookmarks);     // Catch: Throwable -> L17
        XmlUtils.beginDocument(parser, TAG_BOOKMARKS);     // Catch: Throwable -> L17
        KeyCharacterMap virtualKcm = KeyCharacterMap.load(-1);     // Catch: Throwable -> L17
    L4:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L17
        if (parser.getEventType() == 1) goto L58;
        if (TAG_BOOKMARK.equals(parser.getName()) == false) goto L58;
        String packageName = parser.getAttributeValue(null, "package");     // Catch: Throwable -> L17
        String className = parser.getAttributeValue(null, ATTRIBUTE_CLASS);     // Catch: Throwable -> L17
        String shortcutName = parser.getAttributeValue(null, ATTRIBUTE_SHORTCUT);     // Catch: Throwable -> L17
        String categoryName = parser.getAttributeValue(null, ATTRIBUTE_CATEGORY);     // Catch: Throwable -> L17
        String shiftName = parser.getAttributeValue(null, ATTRIBUTE_SHIFT);     // Catch: Throwable -> L17
        String roleName = parser.getAttributeValue(null, ATTRIBUTE_ROLE);     // Catch: Throwable -> L17
        TypedArray a = r1.mContext.getResources().obtainAttributes(parser, com.android.internal.R.styleable.Bookmark);     // Catch: Throwable -> L17
        int keycode = a.getInt(0, 0);     // Catch: Throwable -> L42
        int modifierState = a.getInt(1, 0);     // Catch: Throwable -> L42
        a.recycle();     // Catch: Throwable -> L17 Throwable -> L17
        if (TextUtils.isEmpty(shortcutName) == false) goto L20;
        if (keycode == 0) goto L20;
        shortcutName = String.valueOf(virtualKcm.getDisplayLabel(keycode)).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L17 Throwable -> L17
    L20:
        if (TextUtils.isEmpty(shortcutName) == true) goto L21;
        if (TextUtils.isEmpty(shiftName) == true) goto L26;
        boolean isShiftShortcut = shiftName.equals("true");     // Catch: Throwable -> L17 Throwable -> L17
    L29:
        char shortcutChar = shortcutName.charAt(0);     // Catch: Throwable -> L17 Throwable -> L17
        Bookmark bookmark = null;
        if (packageName == null) goto L33;
        if (className == null) goto L33;
        XmlResourceParser parser2 = parser;
        bookmark = new ComponentBookmark(shortcutChar, isShiftShortcut, packageName, className);     // Catch: Throwable -> L17 Throwable -> L17
    L38:
        if (bookmark == null) goto L41;
        Log.d(TAG, "adding shortcut " + bookmark + " shift=" + isShiftShortcut + " char=" + shortcutChar);     // Catch: Throwable -> L17 Throwable -> L17
        r1.mBookmarks.put(new Pair(Character.valueOf(shortcutChar), Boolean.valueOf(isShiftShortcut)), bookmark);     // Catch: Throwable -> L17 Throwable -> L17
    L41:
        r1 = this;
        parser = parser2;
        virtualKcm = virtualKcm;
    L33:
        parser2 = parser;
        if (categoryName == null) goto L36;
        bookmark = new CategoryBookmark(shortcutChar, isShiftShortcut, categoryName);     // Catch: Throwable -> L17 Throwable -> L17
        goto L38
    L36:
        if (roleName == null) goto L38;
        bookmark = new RoleBookmark(shortcutChar, isShiftShortcut, roleName);     // Catch: Throwable -> L17 Throwable -> L17
        goto L38
    L26:
        if ((modifierState & 1) == 0) goto L28;
        isShiftShortcut = true;
        goto L29
    L28:
        isShiftShortcut = false;
        goto L29
    L21:
        Log.w(TAG, "Shortcut required for bookmark with category=" + categoryName + " packageName=" + packageName + " className=" + className + " role=" + roleName + " shiftName=" + shiftName + " keycode= " + keycode + " modifierState= " + modifierState);     // Catch: Throwable -> L17 Throwable -> L17
    L42:
        th = move-exception;
        a.recycle();     // Catch: Throwable -> L17 Throwable -> L17
        throw th;     // Catch: Throwable -> L17 Throwable -> L17
    L58:
        return;
    L17:
        e = move-exception;
        Log.e(TAG, "Got exception parsing bookmarks.", e);
    }

    private Intent resolveComponentNameIntent(ComponentName componentName) {
        return null;
    }

    private Intent resolveComponentNameIntent(String packageName, String className) {
        return null;
    }

    private static Intent resolveComponentNameIntent(Context context, String packageName, String className) {
        PackageManager pm = context.getPackageManager();
        ComponentName componentName = new ComponentName(packageName, className);
        pm.getActivityInfo(componentName, 262144);     // Catch: PackageManager.NameNotFoundException -> L5
    L8:
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(componentName);
        return intent;
    L6:
        String[] packages = pm.canonicalToCurrentPackageNames(new String[]{packageName});
        componentName = new ComponentName(packages[0], className);
        pm.getActivityInfo(componentName, 262144);     // Catch: PackageManager.NameNotFoundException -> L10
    L11:
        Log.w(TAG, "Unable to add bookmark: " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + className + " not found.");
        return null;
    }

    void registerShortcutKey(long shortcutCode, IShortcutService shortcutService) throws RemoteException {
        IShortcutService service = this.mShortcutKeyServices.get(shortcutCode);
        if (service != null) goto L5;
    L9:
        this.mShortcutKeyServices.put(shortcutCode, shortcutService);
        return;
    L5:
        if (service.asBinder().pingBinder() == false) goto L9;
        throw new RemoteException("Key already exists.");
    }

    private boolean handleShortcutService(int keyCode, int metaState) {
        long shortcutCode = keyCode;
        if ((metaState & 4096) == 0) goto L6;
        shortcutCode = shortcutCode | 17592186044416L;
    L6:
        if ((metaState & 2) == 0) goto L9;
        shortcutCode = shortcutCode | 8589934592L;
    L9:
        if ((metaState & 1) == 0) goto L12;
        shortcutCode = shortcutCode | 4294967296L;
    L12:
        if ((65536 & metaState) == 0) goto L14;
        shortcutCode = shortcutCode | 281474976710656L;
    L14:
        IShortcutService shortcutService = this.mShortcutKeyServices.get(shortcutCode);
        if (shortcutService != null) goto L24;
        return false;
    L24:
        shortcutService.notifyShortcutKeyPressed(shortcutCode);     // Catch: RemoteException -> L18
        return true;
    L19:
        this.mShortcutKeyServices.delete(shortcutCode);
        return true;
    }

    private boolean handleIntentShortcut(KeyCharacterMap kcm, KeyEvent keyEvent, int metaState) {
        int keyCode = keyEvent.getKeyCode();
        if (this.mSearchKeyShortcutPending == false) goto L9;
        if (kcm.isPrintingKey(keyCode) == false) goto L7;
        this.mConsumeSearchKeyUp = true;
        this.mSearchKeyShortcutPending = false;
    L11:
        Intent shortcutIntent = getIntent(kcm, keyCode, metaState);
        if (shortcutIntent == null) goto L20;
        shortcutIntent.addFlags(268435456);
        this.mContext.startActivityAsUser(shortcutIntent, this.mCurrentUser);     // Catch: ActivityNotFoundException -> L16
    L18:
        notifyKeyGestureCompleted(keyEvent, getKeyGestureTypeFromIntent(shortcutIntent));
        return true;
    L17:
        Slog.w(TAG, "Dropping shortcut key combination because the activity to which it is registered was not found: META+ or SEARCH" + KeyEvent.keyCodeToString(keyCode));
        goto L18
    L20:
        return false;
    L7:
        return false;
    L9:
        if ((458752 & metaState) == 0) goto L21;
        metaState = metaState & (-458753);
        goto L11
    L21:
        Intent intent = null;
        String role = sApplicationLaunchKeyRoles.get(keyCode);
        String category = sApplicationLaunchKeyCategories.get(keyCode);
        if (role == null) goto L24;
        intent = getRoleLaunchIntent(role);
    L26:
        if (intent == null) goto L34;
        intent.setFlags(268435456);
        this.mContext.startActivityAsUser(intent, this.mCurrentUser);     // Catch: ActivityNotFoundException -> L30
    L32:
        notifyKeyGestureCompleted(keyEvent, getKeyGestureTypeFromIntent(intent));
        return true;
    L31:
        Slog.w(TAG, "Dropping application launch key because the activity to which it is registered was not found: keyCode=" + KeyEvent.keyCodeToString(keyCode) + ", category=" + category + " role=" + role);
        goto L32
    L34:
        return false;
    L24:
        if (category == null) goto L26;
        intent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", category);
        goto L26
    }

    private void notifyKeyGestureCompleted(KeyEvent event, int gestureType) {
        if (gestureType != 0) goto L4;
        return;
    L4:
        this.mInputManagerInternal.notifyKeyGestureCompleted(event.getDeviceId(), new int[]{event.getKeyCode()}, event.getMetaState(), gestureType);
    }

    boolean interceptKey(KeyEvent event) {
        if (event.getRepeatCount() == 0) goto L5;
        return false;
    L5:
        int metaState = event.getModifiers();
        int keyCode = event.getKeyCode();
        if (keyCode != 84) goto L16;
        if (event.getAction() != 0) goto L10;
        this.mSearchKeyShortcutPending = true;
        this.mConsumeSearchKeyUp = false;
    L14:
        return false;
    L10:
        this.mSearchKeyShortcutPending = false;
        if (this.mConsumeSearchKeyUp == false) goto L14;
        this.mConsumeSearchKeyUp = false;
        return true;
    L16:
        if (event.getAction() == 0) goto L18;
        return false;
    L18:
        KeyCharacterMap kcm = event.getKeyCharacterMap();
        if (handleIntentShortcut(kcm, event, metaState) == false) goto L22;
        return true;
    L22:
        if (handleShortcutService(keyCode, metaState) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public KeyboardShortcutGroup getApplicationLaunchKeyboardShortcuts(int deviceId) {
        List<KeyboardShortcutInfo> shortcuts = new ArrayList();
        Context context = this.mContext.createContextAsUser(this.mCurrentUser, 0);
        Iterator<Bookmark> r2 = this.mBookmarks.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Bookmark b = r2.next();
        KeyboardShortcutInfo info = shortcutInfoFromIntent(b.getShortcutChar(), b.getIntent(context), b.isShift());
        if (info == null) goto L4;
        shortcuts.add(info);
        goto L4
    L10:
        return new KeyboardShortcutGroup(this.mContext.getString(R.string.lockscreen_return_to_call), shortcuts);
    }

    public KeyboardShortcutGroup getApplicationLaunchKeyboardShortcuts(int deviceId, List<InputGestureData> shortcutData) {
        List<KeyboardShortcutInfo> shortcuts = new ArrayList();
        KeyCharacterMap kcm = KeyCharacterMap.load(deviceId);
        Iterator<InputGestureData> r2 = shortcutData.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        InputGestureData data = r2.next();
        InputGestureData.KeyTrigger r4 = data.getTrigger();
        if ((r4 instanceof InputGestureData.KeyTrigger) == false) goto L4;
        InputGestureData.KeyTrigger trigger = r4;
        char r5 = kcm.getDisplayLabel(trigger.getKeycode());
        Intent r6 = getIntentFromAppLaunchData(data.getAction().appLaunchData());
        boolean r8 = true;
        if ((trigger.getModifierState() & 1) != 0) goto L11;
        r8 = false;
    L11:
        KeyboardShortcutInfo info = shortcutInfoFromIntent(r5, r6, r8);
        if (info == null) goto L4;
        shortcuts.add(info);
        goto L4
    L16:
        return new KeyboardShortcutGroup(this.mContext.getString(R.string.lockscreen_return_to_call), shortcuts);
    }

    private Intent getIntentFromAppLaunchData(AppLaunchData data) {
        Context context = this.mContext.createContextAsUser(this.mCurrentUser, 0);
        Map<AppLaunchData, Intent> r1 = this.mAppIntentCache;
        monitor-enter(r1);
        Intent intent = this.mAppIntentCache.get(data);     // Catch: Throwable -> L8
        if (intent == null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return intent;
    L11:
        if ((data instanceof AppLaunchData.CategoryData) == false) goto L14;
        intent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", ((AppLaunchData.CategoryData) data).getCategory());     // Catch: Throwable -> L8
    L19:
        if (intent == null) goto L21;
        this.mAppIntentCache.put(data, intent);     // Catch: Throwable -> L8
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return intent;
    L14:
        if ((data instanceof AppLaunchData.RoleData) == false) goto L17;
        intent = getRoleLaunchIntent(context, ((AppLaunchData.RoleData) data).getRole());     // Catch: Throwable -> L8
        goto L19
    L17:
        if ((data instanceof AppLaunchData.ComponentData) == false) goto L19;
        AppLaunchData.ComponentData componentData = (AppLaunchData.ComponentData) data;     // Catch: Throwable -> L8
        intent = resolveComponentNameIntent(context, componentData.getPackageName(), componentData.getClassName());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    boolean launchApplication(AppLaunchData data) {
        Intent intent = getIntentFromAppLaunchData(data);
        if (intent != null) goto L5;
        return false;
    L5:
        intent.addFlags(268435456);
        this.mContext.startActivityAsUser(intent, this.mCurrentUser);     // Catch: ActivityNotFoundException -> L9
        return true;
    L10:
        Slog.w(TAG, "Not launching app because the activity to which it refers to was not found: " + data);
        return false;
    }

    KeyboardShortcutInfo shortcutInfoFromIntent(char baseChar, Intent intent, boolean shift) {
        if (intent != null) goto L5;
        return null;
    L5:
        Context context = this.mContext.createContextAsUser(this.mCurrentUser, 0);
        PackageManager pm = context.getPackageManager();
        ActivityInfo resolvedActivity = intent.resolveActivityInfo(pm, 65536);
        if (resolvedActivity != null) goto L8;
        return null;
    L8:
        boolean isResolver = ResolverActivity.class.getName().equals(resolvedActivity.name);
        if (isResolver == false) goto L14;
        CharSequence label = getIntentCategoryLabel(context, intent.getSelector().getCategories().iterator().next());
        if (label != null) goto L13;
        return null;
    L13:
        Icon icon = Icon.createWithResource(context, R.drawable.sym_def_app_icon);
    L15:
        int modifiers = 65536;
        if (shift == false) goto L19;
        modifiers = 65536 | 1;
    L19:
        return new KeyboardShortcutInfo(label, icon, baseChar, modifiers);
    L14:
        label = resolvedActivity.loadLabel(pm);
        icon = Icon.createWithResource(resolvedActivity.packageName, resolvedActivity.getIconResource());
        goto L15
    }

    static String getIntentCategoryLabel(Context context, CharSequence category) {
        String r0 = category.toString();
        switch(r0.hashCode()) {
            case -2061526830: goto L27;
            case -1895059731: goto L24;
            case -551167607: goto L21;
            case 431052046: goto L18;
            case 510132385: goto L15;
            case 517776170: goto L12;
            case 645732605: goto L9;
            case 820178937: goto L6;
            default: goto L29;
        };
    L29:
        byte r1 = -1;
    L30:
        switch(r1) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            default: goto L31;
        };
    L31:
        Log.e(TAG, "No label for app category " + category);
        return null;
    L33:
        int resid = R.string.lockscreen_sim_locked_message;
    L42:
        return context.getString(resid);
    L34:
        resid = R.string.lockscreen_storage_locked;
        goto L42
    L35:
        resid = R.string.lockscreen_sound_on_label;
        goto L42
    L36:
        resid = R.string.lockscreen_sound_off_label;
        goto L42
    L37:
        resid = R.string.lockscreen_sim_puk_locked_instructions;
        goto L42
    L38:
        resid = R.string.lockscreen_sim_unlock_progress_dialog_message;
        goto L42
    L39:
        resid = R.string.lockscreen_sim_puk_locked_message;
        goto L42
    L40:
        resid = R.string.lockscreen_screen_locked;
        goto L42
    L6:
        if (r0.equals("android.intent.category.APP_CALENDAR") == false) goto L29;
        r1 = 3;
        goto L30
    L9:
        if (r0.equals("android.intent.category.APP_CALCULATOR") == false) goto L29;
        r1 = 7;
        goto L30
    L12:
        if (r0.equals("android.intent.category.APP_MUSIC") == false) goto L29;
        r1 = 5;
        goto L30
    L15:
        if (r0.equals("android.intent.category.APP_EMAIL") == false) goto L29;
        r1 = 2;
        goto L30
    L18:
        if (r0.equals("android.intent.category.APP_CONTACTS") == false) goto L29;
        r1 = 1;
        goto L30
    L21:
        if (r0.equals("android.intent.category.APP_MESSAGING") == false) goto L29;
        r1 = 6;
        goto L30
    L24:
        if (r0.equals("android.intent.category.APP_BROWSER") == false) goto L29;
        r1 = 0;
        goto L30
    L27:
        if (r0.equals("android.intent.category.APP_MAPS") == false) goto L29;
        r1 = 4;
        goto L30
    }

    private static int getKeyGestureTypeFromIntent(Intent intent) {
        Intent selectorIntent = intent.getSelector();
        if (selectorIntent == null) goto L15;
        Set<String> selectorCategories = selectorIntent.getCategories();
        if (selectorCategories == null) goto L15;
        if (selectorCategories.isEmpty() == true) goto L15;
        Iterator<String> r2 = selectorCategories.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        String intentCategory = r2.next();
        int keyGestureType = getKeyGestureTypeFromSelectorCategory(intentCategory);
        if (keyGestureType == 0) goto L10;
        return keyGestureType;
    L15:
        String role = intent.getStringExtra(EXTRA_ROLE);
        if (TextUtils.isEmpty(role) == false) goto L18;
        Set<String> intentCategories = intent.getCategories();
        if (intentCategories != null) goto L22;
    L31:
        return 0;
    L22:
        if (intentCategories.isEmpty() == true) goto L31;
        if (intentCategories.contains("android.intent.category.LAUNCHER") == false) goto L31;
        if (intent.getComponent() != null) goto L29;
        return 0;
    L29:
        return 51;
    L18:
        return getKeyGestureTypeFromRole(role);
    }

    private static int getKeyGestureTypeFromSelectorCategory(String category) {
        switch(category.hashCode()) {
            case -2061526830: goto L39;
            case -1895059731: goto L36;
            case -822559815: goto L33;
            case -551167607: goto L30;
            case 431052046: goto L27;
            case 510132385: goto L24;
            case 510947196: goto L21;
            case 517776170: goto L18;
            case 645732605: goto L15;
            case 820178937: goto L12;
            case 1401629101: goto L9;
            case 2052651799: goto L6;
            default: goto L41;
        };
    L41:
        byte r0 = -1;
    L42:
        switch(r0) {
            case 0: goto L66;
            case 1: goto L64;
            case 2: goto L62;
            case 3: goto L60;
            case 4: goto L58;
            case 5: goto L56;
            case 6: goto L54;
            case 7: goto L52;
            case 8: goto L50;
            case 9: goto L48;
            case 10: goto L46;
            case 11: goto L44;
            default: goto L43;
        };
    L43:
        return 0;
    L44:
        return 50;
    L46:
        return 49;
    L48:
        return 48;
    L50:
        return 47;
    L52:
        return 46;
    L54:
        return 45;
    L56:
        return 44;
    L58:
        return 43;
    L60:
        return 42;
    L62:
        return 41;
    L64:
        return 40;
    L66:
        return 39;
    L6:
        if (category.equals("android.intent.category.APP_GALLERY") == false) goto L41;
        r0 = 8;
        goto L42
    L9:
        if (category.equals("android.intent.category.APP_FITNESS") == false) goto L41;
        r0 = 11;
        goto L42
    L12:
        if (category.equals("android.intent.category.APP_CALENDAR") == false) goto L41;
        r0 = 3;
        goto L42
    L15:
        if (category.equals("android.intent.category.APP_CALCULATOR") == false) goto L41;
        r0 = 4;
        goto L42
    L18:
        if (category.equals("android.intent.category.APP_MUSIC") == false) goto L41;
        r0 = 5;
        goto L42
    L21:
        if (category.equals("android.intent.category.APP_FILES") == false) goto L41;
        r0 = 9;
        goto L42
    L24:
        if (category.equals("android.intent.category.APP_EMAIL") == false) goto L41;
        r0 = 1;
        goto L42
    L27:
        if (category.equals("android.intent.category.APP_CONTACTS") == false) goto L41;
        r0 = 2;
        goto L42
    L30:
        if (category.equals("android.intent.category.APP_MESSAGING") == false) goto L41;
        r0 = 7;
        goto L42
    L33:
        if (category.equals("android.intent.category.APP_WEATHER") == false) goto L41;
        r0 = 10;
        goto L42
    L36:
        if (category.equals("android.intent.category.APP_BROWSER") == false) goto L41;
        r0 = 0;
        goto L42
    L39:
        if (category.equals("android.intent.category.APP_MAPS") == false) goto L41;
        r0 = 6;
        goto L42
    }

    private static int getKeyGestureTypeFromRole(String role) {
        if ("android.app.role.BROWSER".equals(role) == false) goto L7;
        return 39;
    L7:
        if ("android.app.role.SMS".equals(role) == false) goto L10;
        return 46;
    L10:
        Log.w(TAG, "Keyboard gesture event to launch " + role + " not supported for logging");
        return 0;
    }

    void dump(String prefix, PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ", prefix);
        ipw.println("ModifierShortcutManager shortcuts:");
        ipw.increaseIndent();
        Iterator<Bookmark> r1 = this.mBookmarks.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        Bookmark b = r1.next();
        boolean isShift = b.isShift();
        char shortcutChar = b.getShortcutChar();
        Context context = this.mContext.createContextAsUser(this.mCurrentUser, 0);
        Intent intent = b.getIntent(context);
        if (isShift == false) goto L8;
        String r7 = "SHIFT+";
    L9:
        ipw.print(r7);
        ipw.println(shortcutChar + " " + intent);
        ipw.increaseIndent();
        ipw.increaseIndent();
        KeyboardShortcutInfo info = shortcutInfoFromIntent(shortcutChar, intent, isShift);
        if (info == null) goto L12;
        ipw.println("Resolves to: " + info.getLabel());
    L13:
        ipw.decreaseIndent();
        ipw.decreaseIndent();
        goto L4
    L12:
        ipw.println("<No KeyboardShortcutInfo available for this shortcut>");
        goto L13
    L8:
        r7 = "";
        goto L9
    }
}
