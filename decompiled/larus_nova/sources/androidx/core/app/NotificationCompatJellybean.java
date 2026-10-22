package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class NotificationCompatJellybean {
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = null;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = null;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sExtrasLock = new Object();
        sActionsLock = new Object();
    }

    private static boolean ensureActionReflectionReadyLocked() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            boolean r0 = androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed
            if (r0 == 0) goto L6
            r0 = 0
            return r0
        L6:
            r0 = 1
            java.lang.reflect.Field r1 = androidx.core.app.NotificationCompatJellybean.sActionsField     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            if (r1 != 0) goto L3d
            java.lang.String r1 = "android.app.Notification$Action"
            java.lang.Class r1 = INVOKESTATIC_androidx_core_app_NotificationCompatJellybean_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1)     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            java.lang.String r2 = "icon"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            androidx.core.app.NotificationCompatJellybean.sActionIconField = r2     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            java.lang.String r2 = "title"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            androidx.core.app.NotificationCompatJellybean.sActionTitleField = r2     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            java.lang.String r2 = "actionIntent"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            androidx.core.app.NotificationCompatJellybean.sActionIntentField = r1     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            java.lang.Class<android.app.Notification> r1 = android.app.Notification.class
            java.lang.String r2 = "actions"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            androidx.core.app.NotificationCompatJellybean.sActionsField = r1     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            r1.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L38 java.lang.ClassNotFoundException -> L3b
            goto L3d
        L38:
            androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed = r0
            goto L3d
        L3b:
            androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed = r0
        L3d:
            boolean r1 = androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompatJellybean.ensureActionReflectionReadyLocked():boolean");
    }

    private NotificationCompatJellybean() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_app_NotificationCompatJellybean_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> r100) {
        int r101 = r100.size();
        SparseArray<Bundle> r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        Bundle r104 = (Bundle) ListProtector.get(r100, r103);
        if (r104 == null) goto L9;
        if (r102 != null) goto L8;
        r102 = new SparseArray();
    L8:
        r102.put(r103, r104);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return r102;
    }

    private static RemoteInput fromBundle(Bundle r100) {
        ArrayList<String> r101 = r100.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet r102 = new HashSet();
        if (r101 == null) goto L9;
        Iterator<String> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r102.add(r103.next());
    L9:
        return new RemoteInput(r100.getString(KEY_RESULT_KEY), r100.getCharSequence("label"), r100.getCharSequenceArray(KEY_CHOICES), r100.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), 0, r100.getBundle("extras"), r102);
    }

    private static RemoteInput[] fromBundleArray(Bundle[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        RemoteInput[] r101 = new RemoteInput[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = fromBundle(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static int getActionCount(Notification r100) {
        Object r101 = sActionsLock;
        monitor-enter(r101);
        Object[] r102 = getActionObjectsLocked(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        int r103 = r102.length;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r103;
    L7:
        r103 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public static NotificationCompat.Action getActionFromBundle(Bundle r110) {
        Bundle r100 = r110.getBundle("extras");
        if (r100 == null) goto L5;
        boolean r111 = r100.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
    L7:
        return new NotificationCompat.Action(r110.getInt("icon"), r110.getCharSequence("title"), (PendingIntent) r110.getParcelable(KEY_ACTION_INTENT), r110.getBundle("extras"), fromBundleArray(getBundleArrayFromBundle(r110, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(r110, KEY_DATA_ONLY_REMOTE_INPUTS)), r111, r110.getInt(KEY_SEMANTIC_ACTION), r110.getBoolean(KEY_SHOWS_USER_INTERFACE), false, false);
    L5:
        r111 = false;
        goto L7
    }

    private static Object[] getActionObjectsLocked(Notification r100) {
        Object r101 = sActionsLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (ensureActionReflectionReadyLocked() == true) goto L17;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return null;
    L17:
        Object[] r102 = (Object[]) sActionsField.get(r100);     // Catch: IllegalAccessException -> L11 Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r102;
    L11:
        sActionsAccessFailed = true;     // Catch: Throwable -> L14
        return null;
    }

    public static Bundle getBundleForAction(NotificationCompat.Action r100) {
        Bundle r101 = new Bundle();
        IconCompat r102 = r100.getIconCompat();
        if (r102 == null) goto L5;
        int r103 = r102.getResId();
    L6:
        r101.putInt("icon", r103);
        r101.putCharSequence("title", r100.getTitle());
        r101.putParcelable(KEY_ACTION_INTENT, r100.getActionIntent());
        if (r100.getExtras() == null) goto L9;
        Bundle r104 = new Bundle(r100.getExtras());
    L10:
        r104.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r100.getAllowGeneratedReplies());
        r101.putBundle("extras", r104);
        r101.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(r100.getRemoteInputs()));
        r101.putBoolean(KEY_SHOWS_USER_INTERFACE, r100.getShowsUserInterface());
        r101.putInt(KEY_SEMANTIC_ACTION, r100.getSemanticAction());
        return r101;
    L9:
        r104 = new Bundle();
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public static Bundle getExtras(Notification r100) {
        Object r101 = sExtrasLock;
        monitor-enter(r101);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (sExtrasFieldAccessFailed == false) goto L29;
        monitor-exit(r101);     // Catch: Throwable -> L25
        return null;
    L29:
    L22:
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L25
        return null;
    L10:
        if (sExtrasField != null) goto L17;
        Field r102 = Notification.class.getDeclaredField("extras");     // Catch: Throwable -> L22 Throwable -> L25
        if (Bundle.class.isAssignableFrom(r102.getType()) == true) goto L16;
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L22 Throwable -> L25
        monitor-exit(r101);     // Catch: Throwable -> L25
        return null;
    L16:
        r102.setAccessible(true);     // Catch: Throwable -> L22 Throwable -> L22 Throwable -> L25
        sExtrasField = r102;     // Catch: Throwable -> L22 Throwable -> L22 Throwable -> L25
    L17:
        Bundle r103 = (Bundle) sExtrasField.get(r100);     // Catch: Throwable -> L22 Throwable -> L22 Throwable -> L25
        if (r103 != null) goto L20;
        r103 = new Bundle();     // Catch: Throwable -> L22 Throwable -> L22 Throwable -> L25
        sExtrasField.set(r100, r103);     // Catch: Throwable -> L22 Throwable -> L22 Throwable -> L25
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return r103;
    }

    private static Bundle toBundle(RemoteInput r100) {
        Bundle r101 = new Bundle();
        r101.putString(KEY_RESULT_KEY, r100.getResultKey());
        r101.putCharSequence("label", r100.getLabel());
        r101.putCharSequenceArray(KEY_CHOICES, r100.getChoices());
        r101.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, r100.getAllowFreeFormInput());
        r101.putBundle("extras", r100.getExtras());
        Set<String> r102 = r100.getAllowedDataTypes();
        if (r102 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r102.isEmpty() == true) goto L11;
        ArrayList<String> r103 = new ArrayList(r102.size());
        Iterator<String> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r103.add(r104.next());
        goto L8
    L10:
        r101.putStringArrayList(KEY_ALLOWED_DATA_TYPES, r103);
        goto L11
    }

    private static Bundle[] toBundleArray(RemoteInput[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Bundle[] r101 = new Bundle[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = toBundle(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static NotificationCompat.Action getAction(Notification r100, int r101) {
        Object r102 = sActionsLock;
        monitor-enter(r102);
        Object[] r103 = getActionObjectsLocked(r100);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r103 == null) goto L19;
        Object r104 = r103[r101];     // Catch: Throwable -> L16 IllegalAccessException -> L18
        Bundle r105 = getExtras(r100);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r105 == null) goto L12;
        SparseArray r106 = r105.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r106 == null) goto L12;
        Bundle r107 = (Bundle) r106.get(r101);     // Catch: Throwable -> L16 IllegalAccessException -> L18
    L13:
        NotificationCompat.Action r108 = readAction(sActionIconField.getInt(r104), (CharSequence) sActionTitleField.get(r104), (PendingIntent) sActionIntentField.get(r104), r107);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r108;
    L12:
        r107 = null;
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return null;
    L18:
        sActionsAccessFailed = true;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle r100, String r101) {
        Parcelable[] r102 = r100.getParcelableArray(r101);
        if ((r102 instanceof Bundle[]) == true) goto L9;
        if (r102 == null) goto L9;
        Bundle[] r103 = (Bundle[]) Arrays.copyOf(r102, r102.length, Bundle[].class);
        r100.putParcelableArray(r101, r103);
        return r103;
    L9:
        return (Bundle[]) r102;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder r100, NotificationCompat.Action r101) {
        IconCompat r102 = r101.getIconCompat();
        if (r102 == null) goto L5;
        int r103 = r102.getResId();
    L6:
        r100.addAction(r103, r101.getTitle(), r101.getActionIntent());
        Bundle r104 = new Bundle(r101.getExtras());
        if (r101.getRemoteInputs() == null) goto L10;
        r104.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(r101.getRemoteInputs()));
    L10:
        if (r101.getDataOnlyRemoteInputs() == null) goto L12;
        r104.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(r101.getDataOnlyRemoteInputs()));
    L12:
        r104.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r101.getAllowGeneratedReplies());
        return r104;
    L5:
        r103 = 0;
        goto L6
    }

    public static NotificationCompat.Action readAction(int r110, CharSequence r111, PendingIntent r112, Bundle r113) {
        if (r113 == null) goto L5;
        RemoteInput[] r100 = fromBundleArray(getBundleArrayFromBundle(r113, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
        RemoteInput[] r101 = r100;
        RemoteInput[] r102 = fromBundleArray(getBundleArrayFromBundle(r113, EXTRA_DATA_ONLY_REMOTE_INPUTS));
        boolean r103 = r113.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
    L7:
        return new NotificationCompat.Action(r110, r111, r112, r113, r101, r102, r103, 0, true, false, false);
    L5:
        r101 = null;
        r102 = null;
        r103 = false;
        goto L7
    }
}
