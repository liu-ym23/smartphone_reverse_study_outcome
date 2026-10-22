package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class BottomRightAnimController implements ff.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f151962j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b f151963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b> f151964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b f151965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f151966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f151967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Message> f151968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Message> f151969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f151970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RoomContextController f151971i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightAnimController f151972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f151973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f151974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Set f151975d;

        public b(BottomRightAnimController r100, Function0 r101, Ref.ObjectRef r102, Set r103) {
            this.f151972a = r100;
            this.f151973b = r101;
            this.f151974c = r102;
            this.f151975d = r103;
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
            if (this.f151972a.f151970h.get() == true) goto L5;
            this.f151973b.invoke();     // Catch: Throwable -> L9
        L5:
            Message r100 = (Message) this.f151974c.element;     // Catch: Throwable -> L9
            if (r100 == null) goto L12;
            this.f151975d.remove(r100);     // Catch: Throwable -> L9
            return;
        }
    }

    static {
    }

    public final void c() {
        if (this.f151964b.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.f151964b.size() <= 1) goto L50;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r100 = this.f151965c;
        if (r100 != null) goto L10;
    L31:
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r101 = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r102 = null;
    L32:
        if (r101 == null) goto L34;
    L41:
        this.f151964b.clear();
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r103 = this.f151965c;
        if (r103 != null) goto L44;
    L47:
        if (r101 == null) goto L49;
        this.f151964b.offerLast(r101);
    L49:
        Objects.toString(this.f151963a);
        Objects.toString(r102);
        Objects.toString(r101);
        Objects.toString(this.f151964b);
        goto L50
    L44:
        if (r103.f151993d != 0) goto L47;
        if (r102 == null) goto L47;
        this.f151964b.offerLast(r102);
    L34:
        if (this.f151964b.isEmpty() == true) goto L41;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r104 = this.f151964b.pollLast();
        if (r104 == null) goto L41;
        if (r104.f151993d != 0) goto L34;
        r101 = r104;
        goto L41
    L10:
        if (r100.f151993d != 0) goto L31;
        r101 = null;
    L13:
        if (this.f151964b.isEmpty() == true) goto L30;
        r102 = this.f151964b.pollLast();
        if (r102 == null) goto L30;
        String r105 = r102.f151991b;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r106 = this.f151965c;
        if (r106 == null) goto L20;
        String r107 = r106.f151991b;
    L22:
        if (Intrinsics.areEqual(r105, r107) == true) goto L24;
    L26:
        if (r101 != null) goto L13;
        if (r102.f151993d != 0) goto L13;
        r101 = r102;
        goto L13
    L24:
        if (r102.f151993d != 1) goto L26;
    L20:
        r107 = null;
    L30:
        r102 = null;
    L50:
        Objects.toString(this.f151963a);
        Objects.toString(this.f151964b);
        final com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r108 = this.f151964b.pollFirst();
        this.f151963a = r108;
        Objects.toString(r108);
        if (r108 == null) goto L99;
        View r109 = r108.f151992c;
        boolean r110 = false;
        if (r109.getVisibility() == 0) goto L55;
    L57:
        boolean r111 = false;
    L58:
        if (r111 == true) goto L60;
    L61:
        View r112 = r108.f151992c;
        if (r112.getVisibility() != 0) goto L64;
    L66:
        if (r110 == false) goto L71;
        if (r108.f151993d != 1) goto L71;
    L69:
        d(new BottomRightAnimController$executeAnim$$inlined$let$lambda$1(this, r108));
        this.f151963a = null;
        c();
        return;
    L71:
        if (r108.f151993d != 0) goto L73;
        this.f151965c = r108;
    L84:
        r108.f151990a = 1;
        d(new BottomRightAnimController$executeAnim$$inlined$let$lambda$2(r108, this, r108));
        return;
    L73:
        String r113 = r108.f151991b;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r114 = this.f151965c;
        if (r114 == null) goto L76;
        String r115 = r114.f151991b;
    L78:
        if (Intrinsics.areEqual(r113, r115) == false) goto L84;
        int r116 = r108.f151993d;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r117 = this.f151965c;
        if (r117 != null) goto L82;
    L83:
        this.f151965c = null;
        goto L84
    L82:
        if (r116 == r117.f151993d) goto L84;
    L76:
        r115 = null;
        goto L78
    L64:
        if (r112.getAlpha() != 0.0f) goto L66;
        r110 = true;
        goto L66
    L60:
        if (r108.f151993d == 0) goto L69;
    L55:
        if (r109.getAlpha() <= 0.0f) goto L57;
        r111 = true;
        goto L58
    }

    public BottomRightAnimController(RoomContextController r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContextController");
        this.f151971i = r100;
        this.f151964b = new LinkedList();
        Handler r101 = com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.f151987a;
        this.f151966d = com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.f151988b;
        this.f151967e = LazyKt.lazy(BottomRightAnimController$work$2.INSTANCE);
        this.f151968f = Collections.synchronizedSet(new HashSet());
        this.f151969g = Collections.synchronizedSet(new HashSet());
        this.f151970h = new AtomicBoolean(false);
    }

    public final void d(Function0<Unit> r100) {
        if (ECLiveABUtils.INSTANCE.getEnableLiveAnimControllerNotChangeThread() == false) goto L13;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        if (t.f152709p == false) goto L13;
        t.f152709p = false;
        goto L13
    L7:
        r101 = false;
    L13:
        if (t.f152709p == false) goto L15;
        r100.invoke();
        return;
    L15:
        e(this.f151966d, this.f151968f, r100);
    }

    public final void f(final com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r100) {
        Intrinsics.checkNotNullParameter(r100, "animRequest");
        if (r100.f151991b.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Function0<Unit> r102 = new BottomRightAnimController$postAnimation$1(this, r100);
        if (t.f152709p == false) goto L11;
        r102.invoke();
        return;
    L11:
        e((Handler) this.f151967e.getValue(), this.f151969g, r102);
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, android.os.Message, java.lang.Object] */
    public final void e(Handler r100, Set<Message> r101, Function0<Unit> r102) {
        if (this.f151970h.get() == false) goto L5;
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
    public final void a(View r110, final Function0 r111, Function0 r112, Function0 r113, Function0 r114) {
        Intrinsics.checkNotNullParameter("100", "id");
        Intrinsics.checkNotNullParameter(r110, "view");
        f(new f(r112, r113, r114, r110, r111, r110, new BottomRightAnimController$postShowLinkAnimation$2(this, r111)));
    }

    @Override // ff.a
    public final void b(View r110, final Function0 r111, Function0 r112, Function0 r113, Function0 r114) {
        Intrinsics.checkNotNullParameter("100", "id");
        Intrinsics.checkNotNullParameter(r110, "view");
        f(new e(r112, r113, r114, r110, r111, r110, new BottomRightAnimController$postHideLinkAnimation$2(this, r111)));
    }
}
