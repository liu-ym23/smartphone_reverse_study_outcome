package com.bytedance.android.ec.window.base.utils;

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
public final class WindowForceDoFrameMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f49711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f49712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f49713c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f49714d = null;

    public static final class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f49715a = null;

        static {
            f49715a = new a();
        }

        public a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            boolean r101 = WindowForceDoFrameMessage.f49711a;
            Iterator<T> r102 = WindowForceDoFrameMessage.f49712b.iterator();
        L4:
            if (r102.hasNext() == false) goto L13;
            int r103 = ((Number) r102.next()).intValue();
            boolean r104 = WindowForceDoFrameMessage.f49711a;
            if (Build.VERSION.SDK_INT < 23) goto L4;
            Method r105 = (Method) WindowForceDoFrameMessage.f49714d.getValue();     // Catch: Exception -> L11
            if (r105 == null) goto L4;
            r105.invoke(Looper.getMainLooper().getQueue(), new Object[]{Integer.valueOf(r103)});     // Catch: Exception -> L11
        L11:
            e = move-exception;
            e.toString();
            goto L4
        L13:
            boolean r106 = WindowForceDoFrameMessage.f49711a;
            WindowForceDoFrameMessage.f49712b.clear();
            WindowForceDoFrameMessage.f49711a = false;
        }
    }

    static {
        f49712b = new LinkedHashSet();
        f49713c = LazyKt.lazy(WindowForceDoFrameMessage$postSyncBarrier$2.INSTANCE);
        f49714d = LazyKt.lazy(WindowForceDoFrameMessage$removeSyncBarrier$2.INSTANCE);
    }

    public static void a() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L27;
    L22:
        if (r100 == true) goto L24;
        return;
    L24:
        if (f49711a == true) goto L30;
        f49711a = true;
        Choreographer.getInstance().postFrameCallback(a.f49715a);
        return;
    L30:
        return;
    L27:
        Method r101 = (Method) f49713c.getValue();     // Catch: Exception -> L20
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
        f49712b.add(Integer.valueOf(r105));     // Catch: Exception -> L20
        r100 = true;
        goto L22
    L15:
        r105 = -1;
        goto L16
    L7:
        r103 = null;
    L20:
        e = move-exception;
        e.toString();
        goto L22
    }
}
