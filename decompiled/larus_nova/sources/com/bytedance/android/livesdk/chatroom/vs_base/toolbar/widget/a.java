package com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<InterfaceC1745a> f118159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f118160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Disposable f118161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f118162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f118163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function0<Unit> f118164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f118165g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC1745a {
        void a();

        void b();

        void c();

        void d();
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f118166a = null;

        static {
            f118166a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            long r102 = a.f118163e;
            if (r102 != 0) goto L5;
            UtilityKotlinExtentionsKt.g(ReplayScheduleCloseTimeManager$startCountDown$1$1.INSTANCE);
            return;
        L5:
            a.f118163e = r102 - 1000;
            Iterator r103 = ((ArrayList) a.f118159a).iterator();
        L7:
            if (r103.hasNext() == false) goto L11;
            InterfaceC1745a r104 = (InterfaceC1745a) r103.next();
            List<InterfaceC1745a> r105 = a.f118159a;
            r104.a();
            goto L7
        }
    }

    public static void a() {
        f118162d = 0;
        f118163e = -2;
        Iterator r100 = ((ArrayList) f118159a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((InterfaceC1745a) r100.next()).c();
        goto L4
    }

    static {
        f118159a = new ArrayList();
        f118163e = -2;
        f118165g = "";
    }

    public static void b(long r100) {
        Disposable r101 = f118161c;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        f118163e = r100;
        j.a r102 = j.f66356a;
        f118161c = j.a(0, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(b.f118166a);
    }
}
