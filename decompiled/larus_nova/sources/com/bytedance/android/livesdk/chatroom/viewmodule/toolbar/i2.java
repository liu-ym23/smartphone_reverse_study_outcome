package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f116348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f116349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f116350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f116351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f116352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f116353f;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f116354a = null;

        static {
            f116354a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            long r102 = i2.f116352e;
            if (r102 != 0) goto L5;
            UtilityKotlinExtentionsKt.s(0, false, false, ScheduleCloseTimeManager$startCountDown$1$1.INSTANCE, 7);
            return;
        L5:
            i2.f116352e = r102 - 1000;
            Iterator r103 = ((ArrayList) i2.f116348a).iterator();
        L7:
            if (r103.hasNext() == false) goto L11;
            a r104 = (a) r103.next();
            List<a> r105 = i2.f116348a;
            r104.a();
            goto L7
        }
    }

    public static void a() {
        f116351d = 0;
        f116352e = -2;
        Iterator r100 = ((ArrayList) f116348a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).c();
        goto L4
    }

    static {
        f116348a = new ArrayList();
        f116352e = -2;
        f116353f = "";
    }

    public static void b(long r100) {
        Disposable r101 = f116350c;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        f116352e = r100;
        com.bytedance.android.live.core.utils.rxutils.j.a r102 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        f116350c = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(b.f116354a);
    }
}
