package com.android.server.input;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.hardware.input.AppLaunchData;
import android.hardware.input.InputGestureData;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.android.internal.policy.IShortcutService;
import com.android.internal.util.XmlUtils;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class AppLaunchShortcutManager {
    private static final String ATTRIBUTE_CATEGORY = "category";
    private static final String ATTRIBUTE_CLASS = "class";
    private static final String ATTRIBUTE_PACKAGE = "package";
    private static final String ATTRIBUTE_ROLE = "role";
    private static final String ATTRIBUTE_SHIFT = "shift";
    private static final String ATTRIBUTE_SHORTCUT = "shortcut";
    private static final int SHORTCUT_CODE_META_MASK = 69635;
    private static final String TAG = "AppShortcutManager";
    private static final String TAG_BOOKMARK = "bookmark";
    private static final String TAG_BOOKMARKS = "bookmarks";
    private static final SparseArray<String> sApplicationLaunchKeyCategories = null;
    private static final SparseArray<String> sApplicationLaunchKeyRoles = null;
    private final Map<InputGestureData.Trigger, InputGestureData> mBookmarks;
    private boolean mConsumeSearchKeyUp;
    private final Context mContext;
    private boolean mSearchKeyShortcutPending;
    private LongSparseArray<IShortcutService> mShortcutKeyServices;

    public static final class InterceptKeyResult extends Record {
        private static final InterceptKeyResult CONSUME_KEY = null;
        private static final InterceptKeyResult DO_NOTHING = null;
        private final AppLaunchData appLaunchData;
        private final boolean consumed;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof InterceptKeyResult) == false) goto L10;
            InterceptKeyResult r4 = (InterceptKeyResult) r3;
            if (this.consumed == r4.consumed) goto L7;
            return false;
        L7:
            if (Objects.equals(this.appLaunchData, r4.appLaunchData) == false) goto L13;
            return true;
        L13:
            return false;
        L10:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Boolean.valueOf(this.consumed), this.appLaunchData};
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetCONSUME_KEY, reason: not valid java name */
        static /* bridge */ /* synthetic */ InterceptKeyResult m4467$$Nest$sfgetCONSUME_KEY() {
            return CONSUME_KEY;
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetDO_NOTHING, reason: not valid java name */
        static /* bridge */ /* synthetic */ InterceptKeyResult m4468$$Nest$sfgetDO_NOTHING() {
            return DO_NOTHING;
        }

        public InterceptKeyResult(boolean consumed, AppLaunchData appLaunchData) {
            this.consumed = consumed;
            this.appLaunchData = appLaunchData;
        }

        public AppLaunchData appLaunchData() {
            return this.appLaunchData;
        }

        public boolean consumed() {
            return this.consumed;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return AppLaunchShortcutManager$InterceptKeyResult$$ExternalSyntheticRecord0.m(this.consumed, this.appLaunchData);
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), InterceptKeyResult.class, "consumed;appLaunchData");
        }

        static {
            DO_NOTHING = new InterceptKeyResult(false, null);
            CONSUME_KEY = new InterceptKeyResult(true, null);
        }
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

    AppLaunchShortcutManager(Context context) {
        this.mShortcutKeyServices = new LongSparseArray();
        this.mSearchKeyShortcutPending = false;
        this.mConsumeSearchKeyUp = true;
        this.mBookmarks = new HashMap();
        this.mContext = context;
    }

    public void init() {
        loadShortcuts();
    }

    private void loadShortcuts() {
        int r0 = 0;
        int r2 = 1;
        XmlResourceParser parser = this.mContext.getResources().getXml(R.xml.bookmarks);     // Catch: Throwable -> L11
        XmlUtils.beginDocument(parser, TAG_BOOKMARKS);     // Catch: Throwable -> L11
        KeyCharacterMap virtualKcm = KeyCharacterMap.load(-1);     // Catch: Throwable -> L11
    L4:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11
        if (parser.getEventType() == r2) goto L70;
        if (TAG_BOOKMARK.equals(parser.getName()) == false) goto L9;
        String packageName = parser.getAttributeValue(null, "package");     // Catch: Throwable -> L11
        String className = parser.getAttributeValue(null, ATTRIBUTE_CLASS);     // Catch: Throwable -> L11
        String categoryName = parser.getAttributeValue(null, ATTRIBUTE_CATEGORY);     // Catch: Throwable -> L11
        String shiftName = parser.getAttributeValue(null, ATTRIBUTE_SHIFT);     // Catch: Throwable -> L11
        String roleName = parser.getAttributeValue(null, ATTRIBUTE_ROLE);     // Catch: Throwable -> L11
        String shortcut = parser.getAttributeValue(null, ATTRIBUTE_SHORTCUT);     // Catch: Throwable -> L11
        TypedArray a = this.mContext.getResources().obtainAttributes(parser, com.android.internal.R.styleable.Bookmark);     // Catch: Throwable -> L11
        int keycode = a.getInt(r0, r0);     // Catch: Throwable -> L55
        int modifierState = a.getInt(r2, r0);     // Catch: Throwable -> L55
        a.recycle();     // Catch: Throwable -> L11 Throwable -> L11
        if (keycode == 0) goto L18;
    L25:
        r0 = r0;
    L27:
        if (keycode == 0) goto L28;
        if (modifierState != 0) goto L40;
        if (shiftName != null) goto L32;
    L34:
        int r3 = r0;
    L36:
        if (r3 == 0) goto L38;
        int r15 = 1;
    L39:
        modifierState = r15 | 65536;     // Catch: Throwable -> L11 Throwable -> L11
        goto L40
    L38:
        r15 = r0;
        goto L39
    L32:
        if (shiftName.toLowerCase(Locale.ROOT).equals("true") == false) goto L34;
        r3 = 1;
    L40:
        AppLaunchData launchData = null;
        if (TextUtils.isEmpty(packageName) == true) goto L46;
        if (TextUtils.isEmpty(className) == true) goto L46;
        launchData = AppLaunchData.createLaunchDataForComponent(packageName, className);     // Catch: Throwable -> L11 Throwable -> L11
    L51:
        if (launchData == null) goto L54;
        Log.d(TAG, "adding shortcut " + launchData + " modifierState=" + modifierState + " keycode=" + keycode);     // Catch: Throwable -> L11 Throwable -> L11
        InputGestureData bookmark = new InputGestureData.Builder().setTrigger(InputGestureData.createKeyTrigger(keycode, modifierState)).setKeyGestureType(51).setAppLaunchData(launchData).build();     // Catch: Throwable -> L11 Throwable -> L11
        this.mBookmarks.put(bookmark.getTrigger(), bookmark);     // Catch: Throwable -> L11 Throwable -> L11
    L54:
        parser = parser;
        r2 = 1;
    L46:
        if (TextUtils.isEmpty(categoryName) == true) goto L49;
        launchData = AppLaunchData.createLaunchDataForCategory(categoryName);     // Catch: Throwable -> L11 Throwable -> L11
        goto L51
    L49:
        if (TextUtils.isEmpty(roleName) == true) goto L51;
        launchData = AppLaunchData.createLaunchDataForRole(roleName);     // Catch: Throwable -> L11 Throwable -> L11
        goto L51
    L28:
        Log.w(TAG, "Keycode required for bookmark with category=" + categoryName + " packageName=" + packageName + " className=" + className + " role=" + roleName + " shiftName=" + shiftName + " shortcut=" + shortcut + " modifierState=" + modifierState);     // Catch: Throwable -> L11 Throwable -> L11
        r2 = 1;
        goto L4
    L18:
        if (TextUtils.isEmpty(shortcut) == true) goto L25;
        char r16 = shortcut.toLowerCase(Locale.ROOT).charAt(r0);     // Catch: Throwable -> L11 Throwable -> L11
        r0 = r0;
        char[] r1 = new char[r2];     // Catch: Throwable -> L11 Throwable -> L11
        r1[r0] = r16;     // Catch: Throwable -> L11 Throwable -> L11
        KeyEvent[] events = virtualKcm.getEvents(r1);     // Catch: Throwable -> L11 Throwable -> L11
        if (events == null) goto L27;
        if (events.length != 2) goto L27;
        keycode = events[r0].getKeyCode();     // Catch: Throwable -> L11 Throwable -> L11
    L55:
        th = move-exception;
        a.recycle();     // Catch: Throwable -> L11 Throwable -> L11
        throw th;     // Catch: Throwable -> L11 Throwable -> L11
    L9:
        Log.w(TAG, "TAG_BOOKMARK not found");     // Catch: Throwable -> L11
    L70:
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Got exception parsing bookmarks.", e);
    }

    public void registerShortcutKey(long shortcutCode, IShortcutService shortcutService) throws RemoteException {
        IShortcutService service = this.mShortcutKeyServices.get(shortcutCode);
        if (service != null) goto L5;
    L9:
        this.mShortcutKeyServices.put(shortcutCode, shortcutService);
        return;
    L5:
        if (service.asBinder().pingBinder() == false) goto L9;
        throw new RemoteException("Key: " + shortcutCode + ", already exists.");
    }

    public boolean handleShortcutService(KeyEvent event) {
        long shortcutCodeMeta = event.getMetaState() & SHORTCUT_CODE_META_MASK;
        if (shortcutCodeMeta != 0) goto L5;
        return false;
    L5:
        long shortcutCode = ((long) event.getKeyCode()) | (shortcutCodeMeta << 32);
        IShortcutService shortcutService = this.mShortcutKeyServices.get(shortcutCode);
        if (shortcutService != null) goto L14;
        return false;
    L14:
        shortcutService.notifyShortcutKeyPressed(shortcutCode);     // Catch: RemoteException -> L9
        return true;
    L10:
        Log.w(TAG, "Shortcut key service not found, deleting shortcut code: " + shortcutCode);
        this.mShortcutKeyServices.delete(shortcutCode);
        return true;
    }

    private AppLaunchData interceptShortcut(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int modifierState = keyEvent.getMetaState() & SHORTCUT_CODE_META_MASK;
        if (this.mSearchKeyShortcutPending == false) goto L11;
        KeyCharacterMap kcm = keyEvent.getKeyCharacterMap();
        if (kcm != null) goto L7;
    L10:
        return null;
    L7:
        if (kcm.isPrintingKey(keyCode) == false) goto L10;
        this.mConsumeSearchKeyUp = true;
        this.mSearchKeyShortcutPending = false;
    L19:
        if (keyCode != 0) goto L21;
        return null;
    L21:
        InputGestureData gesture = this.mBookmarks.get(InputGestureData.createKeyTrigger(keyCode, modifierState));
        if (gesture != null) goto L25;
        return null;
    L25:
        return gesture.getAction().appLaunchData();
    L11:
        if (modifierState != 0) goto L19;
        String role = sApplicationLaunchKeyRoles.get(keyCode);
        String category = sApplicationLaunchKeyCategories.get(keyCode);
        if (TextUtils.isEmpty(role) == true) goto L16;
        AppLaunchData appLaunchData = AppLaunchData.createLaunchDataForRole(role);
        return appLaunchData;
    L16:
        if (TextUtils.isEmpty(category) == true) goto L27;
        AppLaunchData appLaunchData2 = AppLaunchData.createLaunchDataForCategory(category);
        return appLaunchData2;
    L27:
        return null;
    }

    public InterceptKeyResult interceptKey(KeyEvent event) {
        if (event.getRepeatCount() != 0) goto L5;
        int keyCode = event.getKeyCode();
        if (keyCode != 84) goto L18;
        if (event.getAction() != 0) goto L11;
        this.mSearchKeyShortcutPending = true;
        this.mConsumeSearchKeyUp = false;
    L16:
        return InterceptKeyResult.m4468$$Nest$sfgetDO_NOTHING();
    L11:
        this.mSearchKeyShortcutPending = false;
        if (this.mConsumeSearchKeyUp == false) goto L16;
        this.mConsumeSearchKeyUp = false;
        return InterceptKeyResult.m4467$$Nest$sfgetCONSUME_KEY();
    L18:
        if (event.getAction() == 0) goto L22;
        return InterceptKeyResult.m4468$$Nest$sfgetDO_NOTHING();
    L22:
        return new InterceptKeyResult(false, interceptShortcut(event));
    L5:
        return InterceptKeyResult.m4468$$Nest$sfgetDO_NOTHING();
    }

    public List<InputGestureData> getBookmarks() {
        return new ArrayList(this.mBookmarks.values());
    }

    public void dump(IndentingPrintWriter ipw) {
        ipw.println("AppLaunchShortcutManager:");
        ipw.increaseIndent();
        Iterator<InputGestureData> r0 = this.mBookmarks.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        InputGestureData data = r0.next();
        ipw.println(data);
        goto L4
    L6:
        ipw.decreaseIndent();
    }
}
