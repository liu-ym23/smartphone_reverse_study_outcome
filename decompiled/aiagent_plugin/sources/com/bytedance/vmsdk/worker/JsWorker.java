package com.bytedance.vmsdk.worker;

import android.util.Log;
import com.bytedance.vmsdk.BuildConfig;
import com.bytedance.vmsdk.a.d;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.registry.JavaScriptRegistry;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsWorker {
    private static final String CACHE_PATH = "/woker_code_cache.bin";
    public static final String DEFAULT_BIZ_NAME = "unknown_android";
    private static final long QJS = 0;
    private static final String TAG = "VMSDK_JsWorker";
    private static final long V8 = 1;
    private static boolean isInitialised = false;
    private boolean isIcuInitialised;
    private EngineType mEngineType;
    private IWorkerExceptionDelegate mExceptionDelegate;
    private InspectorClient mInspectorClient;
    private d mInspectorClientNew;
    private JavaScriptRegistry mJavaScriptModuleRegistry;
    private JSModuleManager mModuleManager;
    private AtomicLong mNativeWorkerPtr;
    private a mOnErrorCallback;
    private a mOnMessageCallback;
    private int mSrcID;
    private b mWorkerDelegate;

    public static final enum EngineType extends Enum<EngineType> {
        private static final /* synthetic */ EngineType[] $VALUES = null;
        public static final EngineType QUICKJS = null;
        public static final EngineType V8 = null;

        static {
            EngineType r0 = new EngineType("QUICKJS", 0);
            QUICKJS = r0;
            EngineType r1 = new EngineType("V8", 1);
            V8 = r1;
            $VALUES = new EngineType[]{r0, r1};
        }

        private EngineType(String r1, int r2) {
            super(r1, r2);
        }

        public static EngineType valueOf(String r2) {
            return (EngineType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EngineType.class, r2), EngineType.class, "com.obric.aiagent.plugin");
        }

        public static EngineType[] values() {
            return (EngineType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EngineType[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.i(r0, r1, r2);
    }

    public static /* synthetic */ int access$004(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$005(String r0, String r1) {
        return Log.i(r0, r1);
    }

    private native void nativeBind(long r1, int r3, int r4);

    private static native long nativeCreateWorker(JsWorker r0, long r1, JSModuleManager r3, String r4, boolean r5, String r6);

    private native void nativeEvaluateCodeCache(long r1, byte[] r3);

    private static native void nativeEvaluateJavaScript(long r0, String r2, String r3, boolean r4);

    private static native byte[] nativeGenCodeCache(String r0, long r1);

    private native long nativeGetNapiEnv(long r1);

    private static native void nativeInitInspector(long r0, InspectorClient r2);

    private static native void nativeInitInspectorFactory(long r0);

    private static native void nativeInitQJSWebAssembly(long r0, long r2);

    private native Object nativeInvokeJavaScriptFunction(long r1, String r3, JavaOnlyArray r4, char r5);

    private native Object nativeInvokeJavaScriptModule(long r1, String r3, String r4, JavaOnlyArray r5, char r6);

    private native void nativeOnCloseInspectorSession(long r1);

    private native void nativeOnInspectorMessage(long r1, String r3);

    private native void nativeOnJSRunner(long r1, Runnable r3);

    private native void nativeOnJSRunnerAtFront(long r1, Runnable r3);

    private native void nativeOnJSRunnerDelay(long r1, Runnable r3, long r4);

    private native void nativeOnOpenInspectorSession(long r1);

    private native void nativeOnPlatformRunner(long r1, Runnable r3);

    private native void nativeOnWorkerRunner(long r1, Runnable r3);

    private static native void nativePostMessage(long r0, String r2);

    private static native void nativeRegisterDelegateFunction(long r0);

    private static native void nativeReject(long r0, String r2, long r3);

    private static native void nativeResolve(long r0, Response r2, long r3);

    private native void nativeSetExceptionDelegate(long r1, IWorkerExceptionDelegate r3);

    private native void nativeSetProperties(long r1, JavaOnlyMap r3);

    private static native void nativeTerminate(long r0);

    private static native void nativeV8PipeInit(long r0, long[] r2);

    @Deprecated
    public static void v8pipeInit(long[] r0) {
    }

    static /* synthetic */ AtomicLong access$000(JsWorker r0) {
        return r0.mNativeWorkerPtr;
    }

    static /* synthetic */ void access$100(long r0, long r2) {
        nativeInitQJSWebAssembly(r0, r2);
    }

    static /* synthetic */ void access$200(long r0, Response r2, long r3) {
        nativeResolve(r0, r2, r3);
    }

    static /* synthetic */ void access$300(long r0, String r2, long r3) {
        nativeReject(r0, r2, r3);
    }

    public static boolean initialize() {
        String[] r0 = {"quick", "napi", "worker"};
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= 3) goto L11;
        System.loadLibrary(r0[r1]);     // Catch: Throwable -> L8
    L10:
        r1 = r1 + 1;
    L8:
        th = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "initialize error: " + th.getMessage());
        r2 = true;
        goto L10
    L11:
        isInitialised = !r2;
        return !r2;
    }

    public static long getWasmRegisterFunctionPtr() {
        return ((Long) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.vmsdk.wasm.RegisterWebAssembly", "com.obric.aiagent.plugin").getMethod("registerWebAssembly", new Class[0]).invoke(null, new Object[0]), Long.class, "com.obric.aiagent.plugin")).longValue();
    L5:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "No webassembly found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
        return 0;
    }

    public static boolean initializeWithoutThrow() {
        String[] r0 = {"quick", "napi", "worker"};
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L6;
        System.loadLibrary(r0[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        isInitialised = true;
        return true;
    }

    public static boolean isIsInitialised() {
        return isInitialised;
    }

    public boolean isIsIcuInitialised() {
        return this.isIcuInitialised;
    }

    public static boolean preLoadPlugin(String r0) {
        return com.bytedance.vmsdk.a.a(r0);
    }

    public static boolean initializeWithPlugin(String r4) {
        boolean r1 = com.bytedance.vmsdk.a.b();     // Catch: Throwable -> L15
        boolean r5 = com.bytedance.vmsdk.a.b(r4);     // Catch: Throwable -> L15
        if (isInitialised == true) goto L11;
        if (r1 == false) goto L9;
        if (r5 == false) goto L9;
        boolean r2 = true;
    L10:
        isInitialised = r2;
    L9:
        r2 = false;
    L11:
        if (r1 == false) goto L20;
        if (r5 == true) goto L14;
        return false;
    L14:
        return true;
    L20:
        return false;
    L15:
        th = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "initializeWithPlugin error: " + th.getMessage());
        return false;
    }

    public static boolean initializeWithPlugin2(String r2) {
        boolean r3 = com.bytedance.vmsdk.a.b(r2);     // Catch: Throwable -> L7
        if (isInitialised == true) goto L6;
        isInitialised = r3;
    L6:
        return r3;
    L7:
        th = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "initializeWithPlugin error: " + th.getMessage());
        return false;
    }

    public JsWorker(c r11) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r11.f(), r11.a(), r11.c(), r11.d(), r11.b(), r11.e(), r11.g(), r11.h());
    }

    @Deprecated
    public JsWorker() {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(null, EngineType.QUICKJS, null, false, DEFAULT_BIZ_NAME, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r11) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r11, EngineType.QUICKJS, null, false, DEFAULT_BIZ_NAME, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r11, EngineType r12) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r11, r12, null, false, DEFAULT_BIZ_NAME, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r11, EngineType r12, boolean r13) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r11, r12, null, r13, DEFAULT_BIZ_NAME, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r10, EngineType r11, String r12) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r10, r11, r12 + CACHE_PATH, false, DEFAULT_BIZ_NAME, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r10, EngineType r11, String r12, boolean r13) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r10, r11, r12 + CACHE_PATH, r13, DEFAULT_BIZ_NAME, false, false, false);
    }

    @Deprecated
    public JsWorker(JSModuleManager r10, EngineType r11, String r12, boolean r13, String r14) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r10, r11, r12 + CACHE_PATH, r13, r14, false, false, false);
    }

    private void init(JSModuleManager r14, EngineType r15, String r16, boolean r17, String r18, boolean r19, boolean r20, boolean r21) {
        if (isInitialised == true) goto L6;
        initialize();
    L6:
        if (r15 != EngineType.QUICKJS) goto L8;
        long r2 = 0;
    L9:
        this.mEngineType = r15;
        if (com.bytedance.vmsdk.c.a.a().a("vmsdk_enable_codecache") == true) goto L12;
        String r5 = null;
    L13:
        this.mNativeWorkerPtr.set(nativeCreateWorker(this, r2, r14, r5, r17, r18));
        if (r20 == false) goto L16;
        registerICU();
    L16:
        this.mJavaScriptModuleRegistry = new JavaScriptRegistry();
        this.mModuleManager = r14;
        if (r19 == false) goto L19;
        this.mInspectorClientNew = new d(this);
    L20:
        if (r21 == false) goto L29;
        long r1 = getWasmRegisterFunctionPtr();
        if (r1 == 0) goto L29;
        initWebAssembly(r1, this.mEngineType);
    L29:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L26
        r0.put("biz_name", r18);     // Catch: Throwable -> L26
        r0.put("init_worker", true);     // Catch: Throwable -> L26
        r0.put("vmsdk_android_version", com.bytedance.vmsdk.a.a());     // Catch: Throwable -> L26
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "new jsworker: " + r0 + " vmsdk_android_version: " + com.bytedance.vmsdk.a.a());     // Catch: Throwable -> L26
        VmSdkMonitor.a("JsWorker", r0, null, null);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "vmsdk monitor data upload error: " + th.getMessage());
        return;
    L19:
        this.mInspectorClientNew = null;
        goto L20
    L12:
        r5 = r16;
        goto L13
    L8:
        r2 = 1;
        goto L9
    }

    public void registerModule(String r2, Class<? extends JSModule> r3, Object r4) {
        if (this.mModuleManager != null) goto L5;
        return;
    L5:
        if (isRunning() == false) goto L9;
        this.mModuleManager.a(r2, r3, r4);
        return;
    }

    public JSModuleManager getModuleManager() {
        return this.mModuleManager;
    }

    public long getNativePtr() {
        return this.mNativeWorkerPtr.get();
    }

    public void evaluateJavaScript(String r4) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r4, null, false);
        return;
    }

    public void evaluateJavaScript(String r3, String r4) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r3, r4, false);
        return;
    }

    public void evaluateJavaScriptWithException(String r3, String r4) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r3, r4, true);
        return;
    }

    public static byte[] genCodeCache(String r2, EngineType r3) {
        if (r3 != EngineType.QUICKJS) goto L5;
        long r0 = 0;
    L7:
        return nativeGenCodeCache(r2, r0);
    L5:
        r0 = 1;
        goto L7
    }

    public void evaluateCodeCache(byte[] r3) {
        if (isRunning() == false) goto L6;
        nativeEvaluateCodeCache(this.mNativeWorkerPtr.get(), r3);
        return;
    }

    public void postOnJSRunner(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (isRunning() == false) goto L6;
        nativeOnJSRunner(this.mNativeWorkerPtr.get(), r4);
        return;
    }

    public void postOnWorkerRunner(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (isRunning() == false) goto L6;
        nativeOnWorkerRunner(this.mNativeWorkerPtr.get(), r4);
        return;
    }

    public void postOnJSRunnerAtFront(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (isRunning() == false) goto L6;
        nativeOnJSRunnerAtFront(this.mNativeWorkerPtr.get(), r4);
        return;
    }

    public void postOnJSRunnerDelay(Runnable r7, long r8) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        nativeOnJSRunnerDelay(this.mNativeWorkerPtr.get(), r3, r8);
        return;
    }

    public void postOnPlatformRunner(Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        nativeOnPlatformRunner(this.mNativeWorkerPtr.get(), r6);
        return;
    }

    private void registerICU() {
        System.loadLibrary("icu");     // Catch: Exception -> L4
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        postOnJSRunner(new $$Lambda$JsWorker$yN2ytU8QVdecrUEYGbkpMFv174(this));
        return;
    L11:
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "fail to load libicu.so: " + e.getMessage());
        r0 = false;
        goto L6
    }

    public /* synthetic */ void lambda$registerICU$0$JsWorker() {
        long r0 = nativeGetNapiEnv(this.mNativeWorkerPtr.get());
        if (r0 == 0) goto L11;
        boolean r2 = false;
        ZeusTransformUtils.forName("com.bytedance.vmsdk.icu.RegisterICU", "com.obric.aiagent.plugin").getMethod("nativeRegisterICUInNapiEnv", new Class[]{Long.TYPE}).invoke(null, new Object[]{Long.valueOf(r0)});     // Catch: Exception -> L7
    L9:
        if (r2 == true) goto L15;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "register icu api in napi success");
        this.isIcuInitialised = true;
        return;
    L15:
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Register ICU api in Napi failed [ " + e.getClass().getSimpleName() + ", " + e.getMessage() + ", " + e.getCause() + " ]");
        r2 = true;
        goto L9
    L11:
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "napi_env is nullptr");
    }

    public void setGlobalProperties(JavaOnlyMap r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.size() > 0) goto L6;
        return;
    L6:
        if (isRunning() == false) goto L11;
        nativeSetProperties(this.mNativeWorkerPtr.get(), r3);
        return;
    }

    public <T extends com.bytedance.vmsdk.registry.b> T getJavaScriptModule(Class<T> r2) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptModule(this, r2);
    }

    public <T extends com.bytedance.vmsdk.registry.a> T getJavaScriptFunction(Class<T> r2) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptFunction(this, r2);
    }

    public Object invokeJavaScriptModule(String r9, String r10, JavaOnlyArray r11, char r12) {
        if (isRunning() == true) goto L5;
        return null;
    L5:
        return nativeInvokeJavaScriptModule(this.mNativeWorkerPtr.get(), r9, r10, r11, r12);
    }

    public Object invokeJavaScriptFunction(String r7, JavaOnlyArray r8, char r9, boolean r10) {
        if (isRunning() == true) goto L5;
        return null;
    L5:
        return nativeInvokeJavaScriptFunction(this.mNativeWorkerPtr.get(), r7, r8, r9);
    }

    public void terminate() {
        InspectorClient r0 = this.mInspectorClient;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        d r1 = this.mInspectorClientNew;
        if (r1 == null) goto L8;
        r1.e();
        this.mInspectorClientNew = null;
    L8:
        JSModuleManager r2 = this.mModuleManager;
        if (r2 == null) goto L12;
        r2.destroy();
        this.mModuleManager = null;
    L12:
        if (this.mNativeWorkerPtr.get() == 0) goto L17;
        isInitialised = false;
        long r3 = this.mNativeWorkerPtr.getAndSet(0);
        if (r3 == 0) goto L18;
        nativeTerminate(r3);
        return;
    L18:
        return;
    }

    public void postMessage(String r3) {
        if (isRunning() == false) goto L6;
        nativePostMessage(this.mNativeWorkerPtr.get(), r3);
        return;
    }

    public void setOnMessageCallback(a r3) {
        this.mOnMessageCallback = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public void setOnErrorCallback(a r3) {
        this.mOnErrorCallback = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public void setWorkerDelegate(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.mWorkerDelegate = r4;
        if (r4 == null) goto L6;
        nativeRegisterDelegateFunction(this.mNativeWorkerPtr.get());
        return;
    }

    public void setDelegate(IWorkerExceptionDelegate r5) {
        IWorkerExceptionDelegate r6 = (IWorkerExceptionDelegate) ZeusTransformUtils.wrapperContextForParams(r5, IWorkerExceptionDelegate.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (this.mNativeWorkerPtr.get() == 0) goto L9;
        this.mExceptionDelegate = r6;
        nativeSetExceptionDelegate(this.mNativeWorkerPtr.get(), r6);
        return;
    }

    public IWorkerExceptionDelegate getDelegate() {
        return this.mExceptionDelegate;
    }

    public boolean isRunning() {
        if (this.mNativeWorkerPtr.get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public EngineType EngineType() {
        return this.mEngineType;
    }

    public static boolean initDevtool() {
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.vmsdk.devtool.DevtoolManager", "com.obric.aiagent.plugin").getMethod("initialize", new Class[0]).invoke(null, new Object[0]), Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.longValue() == 0) goto L10;
        nativeInitInspectorFactory(r0.longValue());     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "[Devtool] Initialize devtool failed:", th);
        return false;
    }

    public void initInspector(InspectorClient r3) {
        InspectorClient r4 = (InspectorClient) ZeusTransformUtils.wrapperContextForParams(r3, InspectorClient.class, "com.obric.aiagent.plugin");
        InspectorClient r0 = this.mInspectorClient;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.mInspectorClient = r4;
        nativeInitInspector(this.mNativeWorkerPtr.get(), r4);
    }

    public static String getCacheFilePath(String r1) {
        return r1 + CACHE_PATH;
    }

    public void initV8Pipe(long[] r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length <= 3) goto L8;
        nativeV8PipeInit(this.mNativeWorkerPtr.get(), r3);
        return;
    }

    public int id() {
        return this.mSrcID;
    }

    public void bind(int r3, int r4) {
        this.mSrcID = r3;
        nativeBind(this.mNativeWorkerPtr.get(), r3, r4);
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "JsWorker id : " + r3 + ", " + r4);
    }

    public d getInspectorClient() {
        return this.mInspectorClientNew;
    }

    public void setInspectorClient(d r1) {
        this.mInspectorClientNew = r1;
    }

    public void onOpenInspectorSession() {
        if (isRunning() == false) goto L6;
        nativeOnOpenInspectorSession(this.mNativeWorkerPtr.get());
        return;
    }

    public void onInspectorMessage(String r3) {
        if (isRunning() == false) goto L6;
        nativeOnInspectorMessage(this.mNativeWorkerPtr.get(), r3);
        return;
    }

    public void onCloseInspectorSession() {
        if (isRunning() == false) goto L6;
        nativeOnCloseInspectorSession(this.mNativeWorkerPtr.get());
        return;
    }

    private void SendInspectorResponse(String r1) {
        d r0 = this.mInspectorClientNew;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void initWebAssembly(final long r3, EngineType r5) {
        if (BuildConfig.ENABLE_WASM.booleanValue() == true) goto L15;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("vmsdk", "Wasm not enabled in worker");
        return;
    L15:
    L11:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("vmsdk", "Could not init WebAssembly in vmsdk playground [ " + e.getMessage() + ", " + e.getCause() + " ]");
        return;
    L7:
        if (r5 != EngineType.QUICKJS) goto L9;
        postOnJSRunner(new AnonymousClass1(this, r3));     // Catch: Exception -> L11
    L14:
        return;
    L9:
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("vmsdk", "JS runtimes other than QJS are not supported in vmsdk playground to init WebAssembly");     // Catch: Exception -> L11
        goto L14
    }

    private void onMessage(String r2) {
        a r1 = this.mOnMessageCallback;
        if (r1 == null) goto L5;
        r1.execute(r2);
    L5:
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "Message from native: " + r2);
    }

    private void onError(String r2) {
        a r1 = this.mOnErrorCallback;
        if (r1 == null) goto L5;
        r1.execute(r2);
    L5:
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Error from native: " + r2);
    }

    private String FetchJsWithUrlSync(String r2) {
        b r1 = this.mWorkerDelegate;
        if (r1 == null) goto L6;
        String r3 = r1.a(r2);
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "FetchJsWithUrlSync js: " + r3);
        return r3;
    L6:
        return "";
    }

    private void Fetch(String r5, String r6, byte[] r7, final long r8) {
        if (this.mWorkerDelegate == null) goto L15;
    L10:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "fail to convert json: " + e.getMessage());
        return;
    L5:
        if (r6.isEmpty() == false) goto L7;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L10
    L8:
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "Fetch params: " + r6);     // Catch: JSONException -> L10
        this.mWorkerDelegate.a(new Request(r5, r1, r7), new AnonymousClass2(this, r8), new AnonymousClass3(this, r8));     // Catch: JSONException -> L10
        return;
    L7:
        r1 = new JSONObject(r6);     // Catch: JSONException -> L10
        goto L8
    }

    private boolean workDelegateExists() {
        if (this.mWorkerDelegate == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
