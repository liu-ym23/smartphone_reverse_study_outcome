package com.stepos.deepbinder.core.provider;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import com.stepos.deepbinder.annotation.method.UIThread;
import com.stepos.deepbinder.core.api.IClientService;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.internal.InternalMethod;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.g;
import mb.l;
import n9.b;
import n9.d;
import w9.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class ClientServiceProvider extends Binder implements IClientService {
    public static final a Companion = new a();
    private static final String TAG = "ClientServiceProvider";
    private static volatile ClientServiceProvider instance;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CallbackRunnable implements Callable<Object>, Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final InternalMethod f7633a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f7634b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f7635c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f7636d;

        /* renamed from: e, reason: collision with root package name */
        public final CountDownLatch f7637e;
        public Throwable h;

        /* renamed from: j, reason: collision with root package name */
        public Object f7638j;

        public CallbackRunnable(InternalMethod method, Object callback, Object[] parameters, boolean z) {
            g.f(method, "method");
            g.f(callback, "callback");
            g.f(parameters, "parameters");
            this.f7633a = method;
            this.f7634b = callback;
            this.f7635c = parameters;
            this.f7636d = z;
            this.f7637e = new CountDownLatch(1);
        }

        @Override // java.util.concurrent.Callable
        @f.a
        public Object call() throws InterruptedException {
            if (this.f7636d) {
                e.f13612e.b(this, true, false);
                this.f7637e.await();
            } else {
                run();
            }
            return this.f7638j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CountDownLatch countDownLatch = this.f7637e;
            boolean z = this.f7636d;
            try {
                InternalMethod internalMethod = this.f7633a;
                Object obj = this.f7634b;
                Object[] objArr = this.f7635c;
                this.f7638j = internalMethod.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } catch (Throwable th) {
                try {
                    this.h = th;
                    if (z) {
                        countDownLatch.countDown();
                    }
                } finally {
                    if (z) {
                        countDownLatch.countDown();
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public ClientServiceProvider() {
        String str = q9.a.f11629a;
        attachInterface(this, q9.a.f11629a);
    }

    private final boolean determineUIThreadStatus(Callback callback, Object obj) {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        g.e(interfaces, "getInterfaces(...)");
        for (Class<?> cls : interfaces) {
            Annotation[] annotations = cls.getAnnotations();
            g.d(annotations, "null cannot be cast to non-null type kotlin.Array<java.lang.annotation.Annotation>");
            int length = annotations.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (Callback.class.isInstance(annotations[i10])) {
                    n9.e eVarA = n9.e.f10682e.a();
                    MethodWrapper methodWrapper = callback.getMethodWrapper();
                    g.c(methodWrapper);
                    String name = methodWrapper.getName();
                    if (name == null) {
                        name = "";
                    }
                    ParameterWrapper[] parameterWrappers = callback.getParameterWrappers();
                    if (parameterWrappers == null) {
                        parameterWrappers = new ParameterWrapper[0];
                    }
                    String strJ0 = l.j0(parameterWrappers, new d(5), 30);
                    String str = name + "(" + (strJ0 != null ? strJ0 : "") + ")";
                    MethodWrapper methodWrapper2 = callback.getMethodWrapper();
                    g.c(methodWrapper2);
                    ParameterWrapper[] parameterWrappers2 = callback.getParameterWrappers();
                    if (parameterWrappers2 == null) {
                        parameterWrappers2 = new ParameterWrapper[0];
                    }
                    Method method = eVarA.d(cls, str, methodWrapper2, parameterWrappers2).getMethod();
                    g.c(method);
                    Annotation[] annotations2 = method.getAnnotations();
                    g.d(annotations2, "null cannot be cast to non-null type kotlin.Array<java.lang.annotation.Annotation>");
                    for (Annotation annotation : annotations2) {
                        if (UIThread.class.isInstance(annotation)) {
                            return true;
                        }
                    }
                } else {
                    i10++;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleSyncCallback(java.lang.Object r4, com.stepos.deepbinder.core.entity.internal.InternalMethod r5, java.lang.Object[] r6, boolean r7, com.stepos.deepbinder.core.entity.Reply r8, java.util.List<java.lang.Integer> r9) {
        /*
            r3 = this;
            r3 = 0
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L49
            android.os.Looper r1 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L49
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L49
            if (r0 != 0) goto L52
            if (r7 == 0) goto L52
            com.stepos.deepbinder.core.provider.ClientServiceProvider$CallbackRunnable r0 = new com.stepos.deepbinder.core.provider.ClientServiceProvider$CallbackRunnable     // Catch: java.lang.Throwable -> L49
            r0.<init>(r5, r4, r6, r7)     // Catch: java.lang.Throwable -> L49
            w9.e$a r4 = w9.e.f13612e     // Catch: java.lang.Throwable -> L49
            w9.e r4 = r4.a()     // Catch: java.lang.Throwable -> L49
            java.util.concurrent.ThreadPoolExecutor r4 = r4.f13617d     // Catch: java.lang.Throwable -> L49
            java.util.concurrent.Future r4 = r4.submit(r0)     // Catch: java.lang.Throwable -> L49
            java.lang.String r6 = "submit(...)"
            kotlin.jvm.internal.g.e(r4, r6)     // Catch: java.lang.Throwable -> L49
            java.lang.reflect.Method r5 = r5.getMethod()     // Catch: java.lang.Throwable -> L49
            kotlin.jvm.internal.g.c(r5)     // Catch: java.lang.Throwable -> L49
            java.lang.Class r5 = r5.getReturnType()     // Catch: java.lang.Throwable -> L49
            java.lang.String r6 = "getReturnType(...)"
            kotlin.jvm.internal.g.e(r5, r6)     // Catch: java.lang.Throwable -> L49
            java.lang.Class r6 = java.lang.Void.TYPE     // Catch: java.lang.Throwable -> L49
            boolean r5 = kotlin.jvm.internal.g.b(r6, r5)     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L4b
            boolean r5 = r9.isEmpty()     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L4b
            r8.setResult(r3)     // Catch: java.lang.Throwable -> L49
            goto L4f
        L49:
            r4 = move-exception
            goto L5c
        L4b:
            java.lang.Object r3 = r4.get()     // Catch: java.lang.Throwable -> L49
        L4f:
            java.lang.Throwable r4 = r0.h     // Catch: java.lang.Throwable -> L49
            goto L66
        L52:
            int r7 = r6.length     // Catch: java.lang.Throwable -> L49
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch: java.lang.Throwable -> L49
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch: java.lang.Throwable -> L49
            goto L69
        L5c:
            boolean r5 = r4 instanceof java.lang.reflect.InvocationTargetException
            if (r5 == 0) goto L66
            java.lang.reflect.InvocationTargetException r4 = (java.lang.reflect.InvocationTargetException) r4
            java.lang.Throwable r4 = r4.getTargetException()
        L66:
            r2 = r4
            r4 = r3
            r3 = r2
        L69:
            if (r3 != 0) goto L6f
            r8.setResult(r4)
            return
        L6f:
            com.stepos.deepbinder.core.exception.IPCException r4 = new com.stepos.deepbinder.core.exception.IPCException
            r5 = 4
            r4.<init>(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.core.provider.ClientServiceProvider.handleSyncCallback(java.lang.Object, com.stepos.deepbinder.core.entity.internal.InternalMethod, java.lang.Object[], boolean, com.stepos.deepbinder.core.entity.Reply, java.util.List):void");
    }

    private final Reply prepareAndSendSyncCallback(Callback callback) {
        ArrayList arrayList = new ArrayList();
        Object objRetrieveCallbackObject = retrieveCallbackObject(callback);
        InternalMethod internalMethodRetrieveInternalMethod = retrieveInternalMethod(callback, objRetrieveCallbackObject);
        Object[] objArrRetrieveParameters = retrieveParameters(callback, arrayList);
        boolean zDetermineUIThreadStatus = determineUIThreadStatus(callback, objRetrieveCallbackObject);
        Reply replyObtain = Reply.CREATOR.obtain();
        handleSyncCallback(objRetrieveCallbackObject, internalMethodRetrieveInternalMethod, objArrRetrieveParameters, zDetermineUIThreadStatus, replyObtain, arrayList);
        if (!arrayList.isEmpty()) {
            replyObtain.setFlowParameterWrappers(x9.e.a(objArrRetrieveParameters, arrayList));
        }
        return replyObtain;
    }

    private final Object retrieveCallbackObject(Callback callback) {
        Object objA;
        b bVar = b.f10675a;
        long timeStamp = callback.getTimeStamp();
        ConcurrentHashMap<Pair<String, Long>, b.a> concurrentHashMap = b.f10676b;
        Set<Map.Entry<Pair<String, Long>, b.a>> setEntrySet = concurrentHashMap.entrySet();
        g.e(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            Long l10 = (Long) ((Pair) ((Map.Entry) obj).getKey()).second;
            if (l10 != null && l10.longValue() == timeStamp) {
                arrayList.add(obj);
            }
        }
        Set setR0 = kotlin.collections.a.R0(arrayList);
        if (setR0.isEmpty()) {
            IPCLog.INSTANCE.d("CallbackCache", "[getCallback][Null]", "timeStamp", Long.valueOf(timeStamp));
            objA = null;
        } else {
            Object objS0 = kotlin.collections.a.s0(setR0);
            g.e(objS0, "first(...)");
            Map.Entry entry = (Map.Entry) objS0;
            objA = ((b.a) entry.getValue()).a();
            if (objA == null || ((b.a) entry.getValue()).f10677a) {
                IPCLog.INSTANCE.d("CallbackCache", "[getCallback][Recycled]", "key", entry.getKey());
                concurrentHashMap.remove(entry.getKey());
            }
            IPCLog.INSTANCE.d("CallbackCache", "[getCallback][Success]", "key", entry.getKey());
        }
        if (objA != null) {
            return objA;
        }
        throw new IPCException(6, "The callback could not be found on the calling side, perhaps it was recycled or the calling process was restarted");
    }

    private final InternalMethod retrieveInternalMethod(Callback callback, Object obj) {
        n9.e eVarA = n9.e.f10682e.a();
        Class<?> cls = obj.getClass();
        MethodWrapper methodWrapper = callback.getMethodWrapper();
        g.c(methodWrapper);
        String name = methodWrapper.getName();
        if (name == null) {
            name = "";
        }
        ParameterWrapper[] parameterWrappers = callback.getParameterWrappers();
        if (parameterWrappers == null) {
            parameterWrappers = new ParameterWrapper[0];
        }
        String strJ0 = l.j0(parameterWrappers, new d(5), 30);
        String str = name + "(" + (strJ0 != null ? strJ0 : "") + ")";
        MethodWrapper methodWrapper2 = callback.getMethodWrapper();
        g.c(methodWrapper2);
        ParameterWrapper[] parameterWrappers2 = callback.getParameterWrappers();
        if (parameterWrappers2 == null) {
            parameterWrappers2 = new ParameterWrapper[0];
        }
        return eVarA.d(cls, str, methodWrapper2, parameterWrappers2);
    }

    private final Object[] retrieveParameters(Callback callback, List<Integer> list) {
        String callerProcessName = callback.getCallerProcessName();
        if (callerProcessName == null) {
            callerProcessName = "";
        }
        return x9.e.c(callerProcessName, callback.getParameterWrappers(), list, callback.getProtocolVersion());
    }

    private final Reply sendAsyncCallback(Callback callback) {
        e.f13612e.b(new androidx.appcompat.app.l(20, this, callback), false, false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Reply sendSyncCallback(Callback callback) {
        try {
            return prepareAndSendSyncCallback(callback);
        } catch (IPCException e10) {
            IPCLog.INSTANCE.w(TAG, "[sendCallbackSync]" + callback, e10);
            return Reply.CREATOR.obtain().withIPCException(e10);
        } finally {
            callback.recycle();
        }
    }

    @Override // android.os.Binder
    @f.a
    public boolean onTransact(int i10, Parcel data, Parcel parcel, int i11) {
        g.f(data, "data");
        if (i10 == 3) {
            Callback callbackCreateFromParcel = Callback.CREATOR.createFromParcel(data);
            boolean zIsOneway = callbackCreateFromParcel.isOneway();
            MethodWrapper methodWrapper = callbackCreateFromParcel.getMethodWrapper();
            boolean zIsVoid = methodWrapper != null ? methodWrapper.isVoid() : true;
            int protocolVersion = callbackCreateFromParcel.getProtocolVersion();
            Reply replySendCallback = sendCallback(callbackCreateFromParcel);
            if (!zIsOneway && (!zIsVoid || replySendCallback.getIpcException() != null || replySendCallback.getFlowParameterWrappers() != null)) {
                replySendCallback.setProtocolVersion(protocolVersion);
                g.c(parcel);
                replySendCallback.writeToParcel(parcel, 0);
            }
        } else if (i10 == 4) {
            int i12 = data.readInt();
            long[] jArrCreateLongArray = data.createLongArray();
            if (jArrCreateLongArray == null) {
                jArrCreateLongArray = new long[0];
            }
            e.f13612e.b(new b.l(i12, 3, this, jArrCreateLongArray), false, false);
            return true;
        }
        return true;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int i10, long[] timestamps) {
        g.f(timestamps, "timestamps");
        for (long j10 : timestamps) {
            IPCLog.INSTANCE.d(TAG, com.stepos.core.ota.d.f(j10, "[recycle] timeStamp="), new Object[0]);
            b bVar = b.f10675a;
            b.a(j10);
        }
    }

    @Override // com.stepos.deepbinder.core.api.IClientService
    public Reply sendCallback(Callback callback) {
        g.f(callback, "callback");
        if (!callback.isOneway()) {
            return sendSyncCallback(callback);
        }
        Reply replySendAsyncCallback = sendAsyncCallback(callback);
        return replySendAsyncCallback == null ? Reply.CREATOR.obtain() : replySendAsyncCallback;
    }

    @Override // android.os.IInterface
    @f.a
    public IBinder asBinder() {
        return this;
    }
}
