package com.bytedance.android.ec.core.anchorv3;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import com.bytedance.android.ec.core.utils.UIUtils;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpMessageOptWorkerV2 extends BasePdpMessageOptWorker {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f43764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f43765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f43766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PdpMessageOptImageHelper f43767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f43768o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Message f43769p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f43770q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f43771r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f43772s;

    public static final class a {
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpMessageOptWorkerV2 f43773a;

        public b(PdpMessageOptWorkerV2 r100) {
            this.f43773a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            PdpMessageOptWorkerV2 r101 = this.f43773a;
            r101.f43747d = false;
            int r102 = r101.f43764k;
            if (r102 < 3) goto L6;
            r101.f43766m++;
        L6:
            if (r101.f43765l == false) goto L9;
            if (r102 <= 1) goto L9;
            r101.j();
        L9:
            boolean r103 = PdpMessageOpt.f43751a;
            PdpMessageOpt.e("doFrame count=" + this.f43773a.f43766m);
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void g() {
        this.f43765l = true;
        if (this.f43772s == true) goto L5;
        return;
    L5:
        if (PdpMessageOpt.c() == true) goto L7;
        return;
    L7:
        if (this.f43765l == false) goto L13;
        h();
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void b() {
        boolean r100 = PdpMessageOpt.f43751a;
        Intrinsics.checkNotNullParameter("call onCreate", "msg");
        this.f43764k = 1;
        Boolean r101 = PdpMessageOpt.f43752b.c();
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        if (r102 == false) goto L9;
        f();
        j();
        return;
    L9:
        return;
    L5:
        r102 = PdpMessageOpt.c();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void d() {
        int r100 = this.f43764k;
        if (r100 == 0) goto L26;
        if (r100 != 2) goto L7;
        boolean r101 = this.f43767n.a();
        if (r101 == false) goto L23;
        this.f43767n.b();
        f();
    L23:
        if (PdpMessageOpt.f43751a == false) goto L99;
        PdpMessageOpt.e("call monitorMessage state=PRELOAD_RENDER hasPendingMsg=" + r101);
        return;
    L99:
        return;
    L7:
        if (r100 != 3) goto L104;
        boolean r102 = this.f43767n.a();
        if (this.f43766m >= 3) goto L14;
        if (r102 == false) goto L13;
        this.f43767n.b();
    L13:
        f();
    L17:
        if (PdpMessageOpt.f43751a == false) goto L97;
        PdpMessageOpt.e("call monitorMessage state=STATE_FULL_RENDER hasPendingMsg=" + r102 + " frameCount=" + this.f43766m);
        return;
    L97:
        return;
    L14:
        if (r102 == false) goto L17;
        this.f43767n.b();
        f();
        goto L17
    L104:
        return;
    L26:
        if (this.f43772s == true) goto L28;
        return;
    L28:
        if (PdpMessageOpt.c() == false) goto L102;
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        final Ref.IntRef r104 = new Ref.IntRef();
        int r105 = 0;
        r104.element = 0;
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = null;
        Message r107 = this.f43769p;
        Long r108 = this.f43770q;
        Function2<Message, Integer, Boolean> r109 = new PdpMessageOptWorkerV2$onMonitorMessage$1(this, r106, r103, r104);
        Intrinsics.checkNotNullParameter(r109, "action");
        if (Build.VERSION.SDK_INT < 23) goto L32;
        MessageQueue r110 = Looper.getMainLooper().getQueue();
    L33:
        if (r110 == null) goto L74;
        if (r107 == null) goto L45;
        long r111 = r107.getWhen();
        if (r108 != null) goto L40;
    L42:
        boolean r112 = false;
    L43:
        if (r112 == false) goto L45;
    L46:
        if (r107 != null) goto L92;
        r107 = BasePdpMessageOptWorker.a.a(BasePdpMessageOptWorker.f43743j, r110);
        if (r107 == null) goto L74;
    L92:
        monitor-enter(r110);     // Catch: Exception -> L73
    L51:
        if (r107 == null) goto L67;
    L70:
        th = move-exception;
        throw th;     // Catch: Exception -> L73
    L53:
        if (r109.invoke(r107, Integer.valueOf(r105)).booleanValue() == true) goto L67;
        BasePdpMessageOptWorker.f43743j.getClass();     // Catch: Throwable -> L70
        Field r113 = (Field) BasePdpMessageOptWorker.f43741h.getValue();     // Catch: Exception -> L65 Throwable -> L70
        if (r113 == null) goto L59;
        Object r114 = r113.get(r107);     // Catch: Exception -> L65 Throwable -> L70
    L61:
        if ((r114 instanceof Message) == true) goto L63;
        r114 = null;
    L63:
        r107 = (Message) r114;     // Catch: Exception -> L65 Throwable -> L70
    L66:
        r105 = r105 + 1;
        goto L51
    L59:
        r114 = null;
    L65:
        r107 = null;
    L67:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L70
        monitor-exit(r110);     // Catch: Exception -> L73
        goto L74
        goto L74
    L40:
        if (r111 != r108.longValue()) goto L42;
        r112 = true;
    L45:
        r107 = null;
    L74:
        Message r116 = (Message) r106.element;
        if (r116 == null) goto L80;
        Intrinsics.checkNotNullParameter(r116, "message");
        Handler r117 = r116.getTarget();
        if (r117 == null) goto L80;
        Message r118 = Message.obtain(r116);
        r117.removeMessages(r116.what, r116.obj);
        r117.sendMessageAtFrontOfQueue(r118);
    L80:
        if (PdpMessageOpt.f43751a == false) goto L103;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L83
        PdpMessageOpt.e("call monitorMessage state=INIT messageToMove=" + ((Message) r106.element) + " loopTimes=" + r104.element);     // Catch: Throwable -> L83
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L83
        return;
    L83:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L103:
        return;
    L32:
        r110 = null;
        goto L33
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void i() {
        if (this.f43765l == true) goto L5;
        return;
    L5:
        boolean r100 = PdpMessageOpt.f43751a;
        Intrinsics.checkNotNullParameter("call stop", "msg");
        if (this.f43744a == false) goto L8;
        Looper.getMainLooper().setMessageLogging(this.f43745b);
    L8:
        this.f43744a = false;
        this.f43765l = false;
        PdpMessageOptImageHelper r101 = this.f43767n;
        r101.f43758a = Boolean.FALSE;
        r101.b();
        Lazy r102 = UIUtils.f45548a;
        UIUtils.e(new l(this));
    }

    public final void j() {
        Choreographer.getInstance().removeFrameCallback(this.f43771r);
        Choreographer.getInstance().postFrameCallback(this.f43771r);
    }

    public PdpMessageOptWorkerV2(boolean r100) {
        this.f43772s = r100;
        this.f43767n = new PdpMessageOptImageHelper();
        this.f43771r = new b(this);
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        if (this.f43765l == true) goto L5;
        return;
    L5:
        if (this.f43768o == false) goto L13;
        PdpMessageOptImageHelper r101 = this.f43767n;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "controller");
        PdpMessageOptImageHelper.b r102 = PdpMessageOptImageHelper.f43757g;     // Catch: Exception -> L9
        PdpMessageOptImageHelper.c r103 = r101.f43761d;     // Catch: Exception -> L9
        r102.getClass();     // Catch: Exception -> L9
        PdpMessageOptImageHelper.b.a(r100, r103);     // Catch: Exception -> L9
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void c(boolean r100) {
        if (this.f43764k < 3) goto L5;
        return;
    L5:
        boolean r101 = PdpMessageOpt.f43751a;
        PdpMessageOpt.e("call onFirstFrame fromPreload=" + r100);
        if (r100 == true) goto L8;
        this.f43764k = 3;
    L12:
        j();
        h();
        return;
    L8:
        if (PdpMessageOpt.d() == true) goto L10;
        return;
    L10:
        this.f43764k = 2;
        goto L12
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void e(boolean r100) {
        boolean r101 = PdpMessageOpt.f43751a;
        PdpMessageOpt.e("call onSubmitData fromPreload=" + r100);
        if (PdpMessageOpt.d() == true) goto L6;
        if (r100 == false) goto L6;
        return;
    L6:
        PdpMessageOptImageHelper r102 = this.f43767n;
        if (r102.f43758a != null) goto L9;
        r102.f43758a = Boolean.TRUE;
    L9:
        this.f43768o = true;
    }
}
