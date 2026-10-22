package com.bytedance.android.ec.opt.messagequeue;

import android.os.Build;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ForceDoFrameMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f48059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f48060b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f48061c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f48062d = null;

    public static final class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f48063a = null;

        static {
            f48063a = new a();
        }

        public a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            boolean r101 = ForceDoFrameMessage.f48059a;
            Iterator<T> r102 = ForceDoFrameMessage.f48060b.iterator();
        L4:
            if (r102.hasNext() == false) goto L13;
            int r103 = ((Number) r102.next()).intValue();
            boolean r104 = ForceDoFrameMessage.f48059a;
            if (Build.VERSION.SDK_INT < 23) goto L4;
            Method r105 = (Method) ForceDoFrameMessage.f48062d.getValue();     // Catch: Exception -> L11
            if (r105 == null) goto L4;
            r105.invoke(Looper.getMainLooper().getQueue(), new Object[]{Integer.valueOf(r103)});     // Catch: Exception -> L11
        L11:
            e = move-exception;
            System.out.println("[Django] >> DoFrameMessage: reflect 'removeSyncBarrier' fail: " + e);
            goto L4
        L13:
            boolean r106 = ForceDoFrameMessage.f48059a;
            ForceDoFrameMessage.f48060b.clear();
            ForceDoFrameMessage.f48059a = false;
        }
    }

    static {
        f48060b = new LinkedHashSet();
        f48061c = LazyKt.lazy(ForceDoFrameMessage$postSyncBarrier$2.INSTANCE);
        f48062d = LazyKt.lazy(ForceDoFrameMessage$removeSyncBarrier$2.INSTANCE);
    }

    public static void a() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L27;
    L22:
        if (r100 == true) goto L24;
        return;
    L24:
        if (f48059a == true) goto L30;
        f48059a = true;
        Choreographer.getInstance().postFrameCallback(a.f48063a);
        return;
    L30:
        return;
    L27:
        Method r101 = (Method) f48061c.getValue();     // Catch: Exception -> L20
        Object r102 = null;
        if (r101 == null) goto L7;
        Object r103 = r101.invoke(Looper.getMainLooper().getQueue(), new Object[]{0L});     // Catch: Exception -> L20
    L9:
        if ((r103 instanceof Integer) == false) goto L12;
        r102 = r103;
    L12:
        Integer r104 = (Integer) r102;     // Catch: Exception -> L20
        if (r104 == null) goto L15;
        int r105 = r104.intValue();     // Catch: Exception -> L20
    L16:
        if (r105 == (-1)) goto L22;
        f48060b.add(Integer.valueOf(r105));     // Catch: Exception -> L20
        r100 = true;
        goto L22
    L15:
        r105 = -1;
        goto L16
    L7:
        r103 = null;
    L20:
        e = move-exception;
        System.out.println("[Django] >> DoFrameMessage: reflect 'postSyncBarrier' fail: " + e);
        goto L22
    }
}
