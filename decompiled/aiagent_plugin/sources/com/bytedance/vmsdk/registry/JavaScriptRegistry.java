package com.bytedance.vmsdk.registry;

import android.text.TextUtils;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.bytedance.vmsdk.jsbridge.utils.e;
import com.bytedance.vmsdk.worker.JsWorker;
import com.bytedance.vmsdk.worker.VmSdkException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class JavaScriptRegistry {
    HashMap<Class<? extends com.bytedance.vmsdk.registry.a>, com.bytedance.vmsdk.registry.a> mFunctionMap;
    HashMap<Class<? extends com.bytedance.vmsdk.registry.b>, com.bytedance.vmsdk.registry.b> mModuleMap;

    private static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JsWorker f11772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Class<? extends com.bytedance.vmsdk.registry.a> f11773b;

        public a(JsWorker r1, Class<? extends com.bytedance.vmsdk.registry.a> r2) {
            this.f11772a = r1;
            this.f11773b = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r6, Method r7, Object[] r8) {
            JavaOnlyArray r9 = JavaOnlyArray.a(r8);
            Class<?>[] r10 = r7.getExceptionTypes();
            int r0 = r10.length;
            boolean r1 = false;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (VmSdkException.class == r10[r2]) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            r1 = true;
        L9:
            return this.f11772a.invokeJavaScriptFunction(r7.getName(), r9, JavaScriptRegistry.returnTypeToChar(r7.getReturnType()), r1);
        }
    }

    private static class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JsWorker f11774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f11775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<? extends com.bytedance.vmsdk.registry.b> f11776c;

        public b(JsWorker r1, Class<? extends com.bytedance.vmsdk.registry.b> r2) {
            this.f11774a = r1;
            this.f11776c = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r5, Method r6, Object[] r7) {
            JavaOnlyArray r8 = JavaOnlyArray.a(r7);
            Class<?>[] r9 = r6.getExceptionTypes();
            int r0 = r9.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            if (VmSdkException.class == r9[r1]) goto L9;
            r1 = r1 + 1;
        L9:
            return this.f11774a.invokeJavaScriptModule(a(), r6.getName(), r8, JavaScriptRegistry.returnTypeToChar(r6.getReturnType()));
        }

        private String a() {
            if (TextUtils.isEmpty(this.f11775b) == false) goto L9;
            String r0 = ((e) ZeusTransformUtils.preCheckCast(this.f11776c.getAnnotation(e.class), e.class, "com.obric.aiagent.plugin")).a();
            if ("".equals(r0) == false) goto L7;
            r0 = this.f11776c.getSimpleName();
        L7:
            this.f11775b = r0;
        L9:
            return this.f11775b;
        }
    }

    public JavaScriptRegistry() {
        this.mModuleMap = new HashMap();
        this.mFunctionMap = new HashMap();
    }

    public <T extends com.bytedance.vmsdk.registry.b> T getJavaScriptModule(JsWorker r5, Class<? extends com.bytedance.vmsdk.registry.b> r6) {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.mModuleMap.get(r6), com.bytedance.vmsdk.registry.b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        T r7 = (T) ZeusTransformUtils.preCheckCast(Proxy.newProxyInstance(r6.getClassLoader(), new Class[]{r6}, new b(r5, r6)), com.bytedance.vmsdk.registry.b.class, "com.obric.aiagent.plugin");
        this.mModuleMap.put(r6, r7);
        return r7;
    }

    public <T extends com.bytedance.vmsdk.registry.a> T getJavaScriptFunction(JsWorker r5, Class<? extends com.bytedance.vmsdk.registry.a> r6) {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.mFunctionMap.get(r6), com.bytedance.vmsdk.registry.a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        T r7 = (T) ZeusTransformUtils.preCheckCast(Proxy.newProxyInstance(r6.getClassLoader(), new Class[]{r6}, new a(r5, r6)), com.bytedance.vmsdk.registry.a.class, "com.obric.aiagent.plugin");
        this.mFunctionMap.put(r6, r7);
        return r7;
    }

    public static char returnTypeToChar(Class r3) {
        char r0 = commonTypeToChar(r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (r3 != Void.TYPE) goto L10;
        return 'v';
    L10:
        if (r3 != WritableMap.class) goto L14;
        return 'M';
    L14:
        if (r3 != WritableArray.class) goto L18;
        return 'A';
    L18:
        throw new RuntimeException("Got unknown return class: " + r3.getSimpleName());
    }

    private static char commonTypeToChar(Class r1) {
        if (r1 != Boolean.TYPE) goto L7;
        return 'z';
    L7:
        if (r1 != Boolean.class) goto L11;
        return 'Z';
    L11:
        if (r1 != Integer.TYPE) goto L15;
        return 'i';
    L15:
        if (r1 != Integer.class) goto L19;
        return 'I';
    L19:
        if (r1 != Short.TYPE) goto L23;
        return 's';
    L23:
        if (r1 != Short.class) goto L27;
        return 'S';
    L27:
        if (r1 != Double.TYPE) goto L31;
        return 'd';
    L31:
        if (r1 != Double.class) goto L35;
        return 'D';
    L35:
        if (r1 != Float.TYPE) goto L39;
        return 'f';
    L39:
        if (r1 != Float.class) goto L43;
        return 'F';
    L43:
        if (r1 != String.class) goto L47;
        return 'T';
    L47:
        if (r1 != Byte.TYPE) goto L51;
        return 'b';
    L51:
        if (r1 != Byte.class) goto L55;
        return 'B';
    L55:
        if (r1 != Long.TYPE) goto L59;
        return 'l';
    L59:
        if (r1 != Long.class) goto L63;
        return 'L';
    L63:
        if (r1 != byte[].class) goto L66;
        return 'a';
    L66:
        return 0;
    }
}
