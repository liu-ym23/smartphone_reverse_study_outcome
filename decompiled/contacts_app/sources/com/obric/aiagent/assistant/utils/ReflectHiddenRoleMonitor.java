package com.obric.aiagent.assistant.utils;

import android.app.role.RoleManager;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectRoleHolderMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020#J\u0014\u0010&\u001a\u00020#2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030\rH\u0003J\b\u0010(\u001a\u00020#H\u0003J\n\u0010)\u001a\u0004\u0018\u00010!H\u0003J\u0012\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001fH\u0003J\b\u0010.\u001a\u00020\u001fH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;", "", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "roleManager", "Landroid/app/role/RoleManager;", "getRoleManager", "()Landroid/app/role/RoleManager;", "roleManager$delegate", "Lkotlin/Lazy;", "roleChangeListenerClass", "Ljava/lang/Class;", "getRoleChangeListenerClass", "()Ljava/lang/Class;", "roleChangeListenerClass$delegate", "roleChangeListenerProxy", "mainUserHandle", "Landroid/os/UserHandle;", "getMainUserHandle", "()Landroid/os/UserHandle;", "mainUserHandle$delegate", "mainExecutor", "Ljava/util/concurrent/Executor;", "getMainExecutor", "()Ljava/util/concurrent/Executor;", "mainExecutor$delegate", "switchListener", "Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;", "isListening", "", "lastAssistantPkg", "", "startListening", "", "listener", "stopListening", "createProxyInstance", "listenerClass", "handleAssistantSwitch", "getCurrentAssistantPkg", "createUserHandleByReflection", AccountInfoBundleKey.USER_ID, "", "hasObserveRolesPermission", "hasManageRoleHoldersPermission", "Companion", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReflectHiddenRoleMonitor {
    public static final String CALLBACK_METHOD = "onRoleHoldersChanged";
    public static final Companion Companion = null;
    private static volatile ReflectHiddenRoleMonitor INSTANCE = null;
    public static final String METHOD_ADD_AS_USER = "addOnRoleHoldersChangedListenerAsUser";
    public static final String METHOD_REMOVE_AS_USER = "removeOnRoleHoldersChangedListenerAsUser";
    private static final String PERMISSION_MANAGE_ROLE_HOLDERS = null;
    public static final String PERMISSION_OBSERVE_ROLE_HOLDERS = "android.permission.OBSERVE_ROLE_HOLDERS";
    public static final String TAG = "ReflectHiddenRoleMonitor";
    private final Context appContext;
    private boolean isListening;
    private String lastAssistantPkg;
    private final Lazy mainExecutor$delegate;
    private final Lazy mainUserHandle$delegate;
    private final Lazy roleChangeListenerClass$delegate;
    private Object roleChangeListenerProxy;
    private final Lazy roleManager$delegate;
    private OnAssistantSwitchListener switchListener;

    /* JADX INFO: compiled from: ReflectRoleHolderMonitor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor$Companion;", "", "<init>", "()V", "TAG", "", "METHOD_ADD_AS_USER", "METHOD_REMOVE_AS_USER", "CALLBACK_METHOD", "PERMISSION_OBSERVE_ROLE_HOLDERS", "PERMISSION_MANAGE_ROLE_HOLDERS", "INSTANCE", "Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;", "getInstance", "context", "Landroid/content/Context;", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ReflectHiddenRoleMonitor getInstance(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            ReflectHiddenRoleMonitor r0 = ReflectHiddenRoleMonitor.access$getINSTANCE$cp();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = ReflectHiddenRoleMonitor.access$getINSTANCE$cp();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            Context r4 = r3.getApplicationContext();     // Catch: Throwable -> L10
            Intrinsics.checkNotNullExpressionValue(r4, "getApplicationContext(...)");     // Catch: Throwable -> L10
            r0 = new ReflectHiddenRoleMonitor(r4, null);     // Catch: Throwable -> L10
            Companion r5 = ReflectHiddenRoleMonitor.Companion;     // Catch: Throwable -> L10
            ReflectHiddenRoleMonitor.access$setINSTANCE$cp(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    public static /* synthetic */ Class $r8$lambda$089xRqRVsKfo8Bxi4PfobuH5PXk() {
        return roleChangeListenerClass_delegate$lambda$1();
    }

    public static /* synthetic */ RoleManager $r8$lambda$TZQivBIEE7udyS5mX8MVnH80uo4(ReflectHiddenRoleMonitor r0) {
        return roleManager_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Executor $r8$lambda$XBh3wL2HgFd2nccjq3jmeqdC3ks(ReflectHiddenRoleMonitor r0) {
        return mainExecutor_delegate$lambda$3(r0);
    }

    public static /* synthetic */ UserHandle $r8$lambda$iJbXjkRI6grfwDyN8TyVcF8sAe0(ReflectHiddenRoleMonitor r0) {
        return mainUserHandle_delegate$lambda$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$vdiCFPAvZ_OdoGn3gf-c5khpPgk, reason: not valid java name */
    public static /* synthetic */ Object m310$r8$lambda$vdiCFPAvZ_OdoGn3gfc5khpPgk(int r0, ReflectHiddenRoleMonitor r1, Object r2, Method r3, Object[] r4) {
        return createProxyInstance$lambda$9(r0, r1, r2, r3, r4);
    }

    public /* synthetic */ ReflectHiddenRoleMonitor(Context r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static final /* synthetic */ ReflectHiddenRoleMonitor access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ReflectHiddenRoleMonitor r0) {
        INSTANCE = r0;
    }

    private ReflectHiddenRoleMonitor(Context r1) {
        this.appContext = r1;
        this.roleManager$delegate = LazyKt.lazy(new ReflectHiddenRoleMonitor$$ExternalSyntheticLambda1(this));
        this.roleChangeListenerClass$delegate = LazyKt.lazy(new ReflectHiddenRoleMonitor$$ExternalSyntheticLambda2());
        this.mainUserHandle$delegate = LazyKt.lazy(new ReflectHiddenRoleMonitor$$ExternalSyntheticLambda3(this));
        this.mainExecutor$delegate = LazyKt.lazy(new ReflectHiddenRoleMonitor$$ExternalSyntheticLambda4(this));
    }

    private final RoleManager getRoleManager() {
        return (RoleManager) this.roleManager$delegate.getValue();
    }

    private static final RoleManager roleManager_delegate$lambda$0(ReflectHiddenRoleMonitor r3) {
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r4 = r3.appContext.getSystemService("role");
        if ((r4 instanceof RoleManager) == true) goto L7;
        return null;
    L7:
        return (RoleManager) r4;
    L8:
        return null;
    }

    private final Class<?> getRoleChangeListenerClass() {
        return (Class) this.roleChangeListenerClass$delegate.getValue();
    }

    private static final Class roleChangeListenerClass_delegate$lambda$1() {
        return Class.forName("android.app.role.OnRoleHoldersChangedListener");
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "找不到隐藏接口：" + e.getMessage());
        return null;
    }

    private final UserHandle getMainUserHandle() {
        return (UserHandle) this.mainUserHandle$delegate.getValue();
    }

    private static final UserHandle mainUserHandle_delegate$lambda$2(ReflectHiddenRoleMonitor r1) {
        return r1.createUserHandleByReflection(0);
    }

    private final Executor getMainExecutor() {
        Object r1 = this.mainExecutor$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (Executor) r1;
    }

    private static final Executor mainExecutor_delegate$lambda$3(ReflectHiddenRoleMonitor r0) {
        return ContextCompat.getMainExecutor(r0.appContext);
    }

    static {
        Companion = new Companion(null);
        PERMISSION_MANAGE_ROLE_HOLDERS = "android.permission.MANAGE_ROLE_HOLDERS";
    }

    public final void startListening(OnAssistantSwitchListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        RoleManager r0 = getRoleManager();
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "RoleManager实例为空（版本<33）");
        return;
    L6:
        Class<?> r2 = getRoleChangeListenerClass();
        if (r2 != null) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "隐藏监听器接口Class为空");
        return;
    L11:
        if (Build.VERSION.SDK_INT >= 33) goto L13;
    L35:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "启动监听前置条件不满足");
        return;
    L13:
        if (hasObserveRolesPermission() == false) goto L35;
        if (this.isListening == true) goto L35;
        this.switchListener = r10;
        createProxyInstance(r2);     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        Object r11 = this.roleChangeListenerProxy;     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        if (r11 == null) goto L21;
        Method r3 = r0.getClass().getMethod(METHOD_ADD_AS_USER, (Class[]) Arrays.copyOf(new Class[]{Executor.class, r2, UserHandle.class}, 3));     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        r3.setAccessible(true);     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        r3.invoke(r0, new Object[]{getMainExecutor(), r11, getMainUserHandle()});     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        this.isListening = true;     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        this.lastAssistantPkg = getCurrentAssistantPkg();     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "监听启动成功（反射UserHandle，主用户ID=0）");     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
        return;
    L21:
        throw new IllegalStateException("代理实例为空");     // Catch: Exception -> L22 InvocationTargetException -> L24 IllegalAccessException -> L30 NoSuchMethodException -> L32
    L30:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "无法访问隐藏方法addOnRoleHoldersChangedListenerAsUser", e);
        e.printStackTrace();
        return;
    L32:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "未找到方法addOnRoleHoldersChangedListenerAsUser（参数签名不匹配）", e);
        e.printStackTrace();
        return;
    L24:
        e = move-exception;
        StringBuilder r12 = new StringBuilder("调用方法失败：");
        Throwable r1 = e.getCause();
        if (r1 == null) goto L28;
        String r4 = r1.getMessage();
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r12.append(r4).toString(), e);
        e.printStackTrace();
        return;
    L28:
        r4 = null;
    L22:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "启动监听异常", e);
        e.printStackTrace();
    }

    public final void stopListening() {
        if (this.isListening == true) goto L5;
        return;
    L5:
        RoleManager r0 = getRoleManager();
        if (r0 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "RoleManager为空，无需注销");
        return;
    L9:
        Class<?> r2 = getRoleChangeListenerClass();
        if (r2 != null) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "监听器接口Class为空，无需注销");
        return;
    L13:
        Object r3 = this.roleChangeListenerProxy;
        if (r3 != null) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "代理实例为空，无需注销");
        return;
    L28:
        Method r4 = r0.getClass().getMethod(METHOD_REMOVE_AS_USER, (Class[]) Arrays.copyOf(new Class[]{r2, UserHandle.class}, 2));     // Catch: Throwable -> L20 Exception -> L22
        r4.setAccessible(true);     // Catch: Throwable -> L20 Exception -> L22
        r4.invoke(r0, new Object[]{r3, getMainUserHandle()});     // Catch: Throwable -> L20 Exception -> L22
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "监听注销成功");     // Catch: Throwable -> L20 Exception -> L22
    L24:
        this.isListening = false;
        this.switchListener = null;
        this.lastAssistantPkg = null;
        this.roleChangeListenerProxy = null;
        return;
    L20:
        th = move-exception;
        this.isListening = false;
        this.switchListener = null;
        this.lastAssistantPkg = null;
        this.roleChangeListenerProxy = null;
        throw th;
    L22:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "注销监听异常", e);     // Catch: Throwable -> L20
        goto L24
    }

    private final void createProxyInstance(Class<?> r5) {
        final int r0 = System.identityHashCode(this);
        InvocationHandler r1 = new ReflectHiddenRoleMonitor$$ExternalSyntheticLambda0(r0, this);
        this.roleChangeListenerProxy = Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, r1);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "动态代理实例创建成功（处理hashCode/equals/toString）");
    }

    private static final Object createProxyInstance$lambda$9(int r8, ReflectHiddenRoleMonitor r9, Object r10, Method r11, Object[] r12) {
        String r1 = r11.getName();
        String r2 = r11.getDeclaringClass().getName();
        if (Intrinsics.areEqual(r1, "hashCode") == true) goto L5;
    L8:
        boolean r6 = true;
        if (Intrinsics.areEqual(r1, "equals") == false) goto L22;
        if (Intrinsics.areEqual(r2, "java.lang.Object") == false) goto L22;
        if (r12 == null) goto L22;
        if (r12.length != 1) goto L22;
        if (r10 == r12[0]) goto L19;
        r6 = false;
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "代理调用equals()，结果：" + r6);
        return Boolean.valueOf(r6);
    L22:
        if (Intrinsics.areEqual(r1, "toString") == false) goto L28;
        if (Intrinsics.areEqual(r2, "java.lang.Object") == false) goto L28;
        String r13 = "OnRoleHoldersChangedListenerProxy@" + r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "代理调用toString()，返回：" + r13);
        return r13;
    L28:
        if (Intrinsics.areEqual(r1, CALLBACK_METHOD) == false) goto L53;
        if (r12 == null) goto L53;
        Object r14 = ArraysKt.getOrNull(r12, 0);     // Catch: Exception -> L50
        if ((r14 instanceof String) == false) goto L33;
        String r15 = (String) r14;     // Catch: Exception -> L50
    L34:
        if (r15 != null) goto L36;
        return null;
    L36:
        Object r16 = ArraysKt.getOrNull(r12, 1);     // Catch: Exception -> L50
        if ((r16 instanceof UserHandle) == false) goto L39;
        UserHandle r17 = (UserHandle) r16;     // Catch: Exception -> L50
    L40:
        if (r17 != null) goto L42;
        return null;
    L42:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "监听到角色变更：role=" + r15 + "，holders=" + r17);     // Catch: Exception -> L50
        if (Intrinsics.areEqual(r15, "android.app.role.ASSISTANT") == true) goto L45;
    L52:
        return null;
    L45:
        if (r9.isListening == false) goto L52;
        if (r9.switchListener == null) goto L52;
        r9.handleAssistantSwitch();     // Catch: Exception -> L50
        goto L52
    L39:
        r17 = null;
        goto L40
    L33:
        r15 = null;
    L50:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "处理回调异常", e);
    L53:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "代理调用未处理的方法：" + r1);
        String r18 = r11.getReturnType().getName();
        if (r18 != null) goto L56;
        return null;
    L56:
        switch(r18.hashCode()) {
            case 104431: goto L71;
            case 3327612: goto L67;
            case 64711720: goto L63;
            case 1195259493: goto L59;
            default: goto L81;
        };
    L81:
        return null;
    L59:
        if (r18.equals("java.lang.String") == false) goto L82;
        return "";
    L82:
        return null;
    L63:
        if (r18.equals("boolean") == true) goto L79;
        return null;
    L79:
        return false;
    L67:
        if (r18.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == true) goto L80;
        return null;
    L80:
        return 0L;
    L71:
        if (r18.equals("int") == true) goto L74;
        return null;
    L74:
        return 0;
    L5:
        if (Intrinsics.areEqual(r2, "java.lang.Object") == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "代理调用hashCode()，返回：" + r8);
        return Integer.valueOf(r8);
    }

    private final void handleAssistantSwitch() {
        String r0 = getCurrentAssistantPkg();
        boolean r1 = true;
        if (r0 != null) goto L8;
        if (this.lastAssistantPkg != null) goto L11;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "默认助手切换：" + this.lastAssistantPkg + " → " + r0);
        OnAssistantSwitchListener r2 = this.switchListener;
        if (r2 == null) goto L15;
        r2.onAssistantSwitched(this.lastAssistantPkg, r0);
    L15:
        this.lastAssistantPkg = r0;
        return;
    L17:
        return;
    L8:
        if (Intrinsics.areEqual(r0, this.lastAssistantPkg) == true) goto L10;
        goto L10
    }

    private final String getCurrentAssistantPkg() {
        RoleManager r0 = getRoleManager();
        if (r0 != null) goto L18;
        return null;
    L18:
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "获取默认助手包名失败", e);
        return null;
    L6:
        if (hasManageRoleHoldersPermission() == true) goto L8;
        return null;
    L8:
        Method r7 = r0.getClass().getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L15
        r7.setAccessible(true);     // Catch: Exception -> L15
        Object r8 = r7.invoke(r0, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L15
        if ((r8 instanceof List) == false) goto L11;
        List r9 = (List) r8;     // Catch: Exception -> L15
    L12:
        if (r9 == null) goto L20;
        return (String) CollectionsKt.getOrNull(r9, 0);
    L20:
        return null;
    L11:
        r9 = null;
        goto L12
    }

    private final UserHandle createUserHandleByReflection(int r9) {
        Method r2 = UserHandle.class.getMethod("of", new Class[]{Integer.TYPE});     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        r2.setAccessible(true);     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        Object r3 = r2.invoke(null, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        if ((r3 instanceof UserHandle) == false) goto L6;
        UserHandle r4 = (UserHandle) r3;     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "反射创建UserHandle实例成功（userId=" + r9 + 65289);     // Catch: Exception -> L9 InvocationTargetException -> L11 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
    L26:
        return r4;
    L6:
        r4 = null;
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "找不到UserHandle类：" + e.getMessage(), e);
        return null;
    L17:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "无法访问UserHandle.of方法：" + e.getMessage(), e);
        return null;
    L19:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "找不到UserHandle.of(int)方法：" + e.getMessage(), e);
        return null;
    L11:
        e = move-exception;
        StringBuilder r0 = new StringBuilder("调用UserHandle.of方法失败：");
        Throwable r5 = e.getCause();
        if (r5 == null) goto L15;
        String r6 = r5.getMessage();
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r0.append(r6).toString(), e);
        return null;
    L15:
        r6 = null;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "反射创建UserHandle失败：" + e.getMessage(), e);
        return null;
    }

    private final boolean hasObserveRolesPermission() {
        if (this.appContext.checkSelfPermission(PERMISSION_OBSERVE_ROLE_HOLDERS) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean hasManageRoleHoldersPermission() {
        if (this.appContext.checkSelfPermission(PERMISSION_MANAGE_ROLE_HOLDERS) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
