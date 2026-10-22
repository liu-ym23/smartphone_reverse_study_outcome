package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroCardAnimController implements ff.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f148347k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.intro.manager.a f148348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<com.bytedance.android.livesdk.livecommerce.intro.manager.a> f148349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.intro.manager.a f148350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f148351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f148352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Message> f148353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Message> f148354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f148355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RoomContextController f148356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f148357j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroCardAnimController f148358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f148359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f148360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Set f148361d;

        public b(IntroCardAnimController r100, Function0 r101, Ref.ObjectRef r102, Set r103) {
            this.f148358a = r100;
            this.f148359b = r101;
            this.f148360c = r102;
            this.f148361d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f148358a.f148355h.get() == true) goto L5;
            this.f148359b.invoke();     // Catch: Throwable -> L9
        L5:
            Message r100 = (Message) this.f148360c.element;     // Catch: Throwable -> L9
            if (r100 == null) goto L12;
            this.f148361d.remove(r100);     // Catch: Throwable -> L9
            return;
        }
    }

    static {
    }

    public static final void c(IntroCardAnimController r100) {
        if (r100.f148349b.isEmpty() == false) goto L6;
        return;
    L6:
        if (r100.f148349b.size() <= 1) goto L50;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r101 = r100.f148350c;
        if (r101 != null) goto L10;
    L31:
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r102 = null;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r103 = null;
    L32:
        if (r102 == null) goto L34;
    L41:
        r100.f148349b.clear();
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r104 = r100.f148350c;
        if (r104 != null) goto L44;
    L47:
        if (r102 == null) goto L49;
        r100.f148349b.offerLast(r102);
    L49:
        Objects.toString(r100.f148348a);
        Objects.toString(r103);
        Objects.toString(r102);
        Objects.toString(r100.f148349b);
        goto L50
    L44:
        if (r104.f148378d != 0) goto L47;
        if (r103 == null) goto L47;
        r100.f148349b.offerLast(r103);
    L34:
        if (r100.f148349b.isEmpty() == true) goto L41;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r105 = r100.f148349b.pollLast();
        if (r105 == null) goto L41;
        if (r105.f148378d != 0) goto L34;
        r102 = r105;
        goto L41
    L10:
        if (r101.f148378d != 0) goto L31;
        r102 = null;
    L13:
        if (r100.f148349b.isEmpty() == true) goto L30;
        r103 = r100.f148349b.pollLast();
        if (r103 == null) goto L30;
        String r106 = r103.f148376b;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r107 = r100.f148350c;
        if (r107 == null) goto L20;
        String r108 = r107.f148376b;
    L22:
        if (Intrinsics.areEqual(r106, r108) == true) goto L24;
    L26:
        if (r102 != null) goto L13;
        if (r103.f148378d != 0) goto L13;
        r102 = r103;
        goto L13
    L24:
        if (r103.f148378d != 1) goto L26;
    L20:
        r108 = null;
    L30:
        r103 = null;
    L50:
        Objects.toString(r100.f148348a);
        Objects.toString(r100.f148349b);
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r109 = r100.f148349b.pollFirst();
        r100.f148348a = r109;
        Objects.toString(r109);
        if (r109 != null) goto L53;
        return;
    L53:
        if (r109.f148378d != 0) goto L55;
        r100.f148350c = r109;
    L66:
        r109.f148375a = 1;
        r100.d(new IntroCardAnimController$executeAnim$$inlined$let$lambda$1(r109, r100));
        return;
    L55:
        String r110 = r109.f148376b;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r111 = r100.f148350c;
        if (r111 == null) goto L58;
        String r112 = r111.f148376b;
    L60:
        if (Intrinsics.areEqual(r110, r112) == false) goto L66;
        int r113 = r109.f148378d;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r114 = r100.f148350c;
        if (r114 != null) goto L64;
    L65:
        r100.f148350c = null;
        goto L66
    L64:
        if (r113 == r114.f148378d) goto L66;
    L58:
        r112 = null;
        goto L60
    }

    public final void d(Function0<Unit> r100) {
        if (ECLiveABUtils.INSTANCE.getEnableLiveAnimControllerNotChangeThread() == false) goto L13;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        if (IntroCardLoadOpt.f148509n == false) goto L13;
        IntroCardLoadOpt.f148509n = false;
        goto L13
    L7:
        r101 = false;
    L13:
        if (IntroCardLoadOpt.f148509n == false) goto L15;
        r100.invoke();
        return;
    L15:
        e(this.f148351d, this.f148353f, r100);
    }

    public final void f(final com.bytedance.android.livesdk.livecommerce.intro.manager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "animRequest");
        if (r100.f148376b.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Function0<Unit> r102 = new IntroCardAnimController$postAnimation$1(this, r100);
        if (IntroCardLoadOpt.f148509n == false) goto L11;
        r102.invoke();
        return;
    L11:
        e((Handler) this.f148352e.getValue(), this.f148354g, r102);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public IntroCardAnimController(RoomContextController r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "roomContextController");
        Intrinsics.checkNotNullParameter(r101, "animDelegate");
        this.f148356i = r100;
        this.f148357j = r101;
        this.f148349b = new LinkedList();
        this.f148351d = com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.f151988b;
        this.f148352e = LazyKt.lazy(IntroCardAnimController$work$2.INSTANCE);
        this.f148353f = Collections.synchronizedSet(new HashSet());
        this.f148354g = Collections.synchronizedSet(new HashSet());
        this.f148355h = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, android.os.Message, java.lang.Object] */
    public final void e(Handler r100, Set<Message> r101, Function0<Unit> r102) {
        if (this.f148355h.get() == false) goto L5;
        return;
    L5:
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        ?? r104 = Message.obtain(r100, new b(this, r102, r103, r101));
        r103.element = r104;
        if (r104 == 0) goto L9;
        r101.add(r104);
        r100.sendMessage(r104);
        return;
    }

    @Override // ff.a
    @Deprecated(message = "未被使用，仅接口实现")
    public final void a(View r110, Function0 r111, Function0 r112, Function0 r113, Function0 r114) {
        Intrinsics.checkNotNullParameter("100", "id");
        Intrinsics.checkNotNullParameter(r110, "view");
        f(new g(r112, r113, r114, r110, r111, r110, new IntroCardAnimController$postShowLinkAnimation$2(this, r111)));
    }

    @Override // ff.a
    @Deprecated(message = "未被使用，仅接口实现")
    public final void b(View r110, Function0 r111, Function0 r112, Function0 r113, Function0 r114) {
        Intrinsics.checkNotNullParameter("100", "id");
        Intrinsics.checkNotNullParameter(r110, "view");
        f(new f(r112, r113, r114, r110, r111, r110, new IntroCardAnimController$postHideLinkAnimation$2(this, r111)));
    }
}
