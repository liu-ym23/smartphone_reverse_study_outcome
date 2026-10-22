package com.bytedance.android.ec.core.anchorv3;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import com.bytedance.android.ec.core.utils.UIUtils;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j extends BasePdpMessageOptWorker {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f43803u;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f43804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f43805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f43806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f43807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f43808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f43809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PdpMessageOptImageHelper f43810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f43811r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f43812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f43813t;

    public static final class a {
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f43814a;

        public b(j r100) {
            this.f43814a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            if (this.f43814a.f43805l == true) goto L5;
            return;
        L5:
            long r101 = System.currentTimeMillis();
            Long r102 = this.f43814a.f43808o;
            if (r102 == null) goto L13;
            long r103 = r101 - r102.longValue();
            long r104 = 8;
            long r105 = j.f43803u;
            if (r104 > r103) goto L13;
            if (r105 <= r103) goto L13;
            j.f43803u = (int) r103;
        L13:
            this.f43814a.f43808o = Long.valueOf(r101);
            j r106 = this.f43814a;
            int r107 = r106.f43806m + 1;
            r106.f43806m = r107;
            if (r107 >= 3) goto L16;
        L19:
            r106.f43807n = false;
            r106.f43747d = false;
            Choreographer.getInstance().postFrameCallback(r106.f43812s);
            boolean r108 = PdpMessageOpt.f43751a;
            PdpMessageOpt.e("doFrame count=" + this.f43814a.f43806m + " duration=" + j.f43803u);
            return;
        L16:
            if (r106.f43807n == false) goto L18;
            r106.f43809p = 0;
            goto L19
        L18:
            r106.f43809p++;
            goto L19
        }
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void g() {
        this.f43805l = true;
    }

    static {
        f43803u = 16;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void b() {
        boolean r100 = PdpMessageOpt.f43751a;
        Intrinsics.checkNotNullParameter("call onCreate", "msg");
        this.f43804k = 1;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void d() {
        if (this.f43804k != 2) goto L88;
        boolean r100 = false;
        long r101 = 0;
        if (this.f43747d == true) goto L31;
        if (this.f43807n == false) goto L10;
    L13:
        boolean r102 = true;
    L14:
        this.f43807n = r102;
        long r103 = System.currentTimeMillis();
        Long r104 = this.f43808o;
        if (r104 == null) goto L17;
        long r105 = r104.longValue();
    L18:
        long r106 = r103 - r105;
        if (this.f43806m >= 3) goto L26;
        if (r106 < f43803u) goto L23;
    L24:
        this.f43810q.b();
        f();
        goto L31
    L23:
        if (this.f43810q.a() == false) goto L31;
    L26:
        if (r106 < f43803u) goto L31;
        if (this.f43810q.a() == false) goto L31;
        this.f43810q.b();
        f();
        goto L31
    L17:
        r105 = 0;
        goto L18
    L10:
        if (this.f43810q.a() == true) goto L13;
        r102 = false;
    L31:
        if (PdpMessageOpt.f43752b.a() == false) goto L76;
        if (this.f43813t == false) goto L76;
        if (this.f43806m >= 3) goto L76;
        if (this.f43747d == true) goto L76;
        int r107 = Build.VERSION.SDK_INT;
        if (r107 < 23) goto L41;
        MessageQueue r108 = Looper.getMainLooper().getQueue();
    L42:
        if (r108 == null) goto L72;
        Message r109 = BasePdpMessageOptWorker.a.a(BasePdpMessageOptWorker.f43743j, r108);
        if (r109 == null) goto L72;
        Intrinsics.checkNotNullParameter(r109, "message");
        if (r107 >= 28) goto L52;
        int r110 = r109.what;
        if (r110 != 103) goto L50;
    L65:
        boolean r111 = true;
    L67:
        if (r111 == false) goto L72;
        Intrinsics.checkNotNullParameter(r109, "message");
        Handler r112 = r109.getTarget();
        if (r112 == null) goto L71;
        Message r113 = Message.obtain(r109);
        r112.removeMessages(r109.what, r109.obj);
        r112.sendMessage(r113);
    L71:
        boolean r114 = true;
    L73:
        if (r114 == false) goto L76;
        r100 = true;
        goto L76
    L50:
        if (r110 == 104) goto L65;
    L66:
        r111 = false;
        goto L67
    L52:
        if (28 > r107) goto L66;
        if (34 < r107) goto L66;
        if (r109.what != 159) goto L66;
        Object r115 = BasePdpMessageOptWorker.a.b(r109);
        if (r115 == null) goto L61;
        String r116 = r115.getClass().getName();
    L62:
        if (r116 == null) goto L66;
        if (StringsKt.endsWith$default(r116, "StopActivityItem", false, 2, null) != true) goto L66;
    L61:
        r116 = null;
    L72:
        r114 = false;
        goto L73
    L41:
        r108 = null;
    L76:
        if (PdpMessageOpt.f43751a == false) goto L82;
        StringBuilder r117 = new StringBuilder("call monitorMessage state=FIRST_FRAME delayStop=");
        r117.append(r100);
        r117.append(" noFrescoMsgFrameCount=");
        r117.append(this.f43809p);
        r117.append(" hasPendingFrescoMessage=");
        r117.append(this.f43807n);
        r117.append(" frameCount=");
        r117.append(this.f43806m);
        r117.append(" hasScheduledForceDoFrame=");
        r117.append(this.f43747d);
        r117.append(" duration=");
        r117.append(f43803u);
        r117.append(" diff=");
        long r118 = System.currentTimeMillis();
        Long r119 = this.f43808o;
        if (r119 == null) goto L80;
        r101 = r119.longValue();
    L80:
        r117.append(r118 - r101);
        PdpMessageOpt.e(r117.toString());
    L82:
        if (this.f43806m < 10) goto L84;
    L85:
        i();
        return;
    L84:
        if (this.f43809p >= 3) goto L85;
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void i() {
        if (this.f43805l == true) goto L5;
        return;
    L5:
        boolean r100 = PdpMessageOpt.f43751a;
        Intrinsics.checkNotNullParameter("call stop", "msg");
        if (this.f43744a == false) goto L8;
        Looper.getMainLooper().setMessageLogging(this.f43745b);
    L8:
        this.f43744a = false;
        this.f43805l = false;
        PdpMessageOptImageHelper r101 = this.f43810q;
        r101.f43758a = Boolean.FALSE;
        r101.b();
        Lazy r102 = UIUtils.f45548a;
        UIUtils.e(new k(this));
    }

    public j(boolean r100) {
        this.f43813t = r100;
        this.f43810q = new PdpMessageOptImageHelper();
        this.f43812s = new b(this);
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        if (this.f43805l == true) goto L5;
        return;
    L5:
        if (this.f43811r == false) goto L13;
        PdpMessageOptImageHelper r101 = this.f43810q;
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
        if (this.f43804k < 2) goto L5;
        return;
    L5:
        boolean r101 = PdpMessageOpt.f43751a;
        PdpMessageOpt.e("call onFirstFrame fromPreload=" + r100);
        if (r100 == false) goto L8;
        return;
    L8:
        this.f43804k = 2;
        Choreographer.getInstance().postFrameCallback(this.f43812s);
        if (this.f43805l == false) goto L13;
        h();
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void e(boolean r100) {
        boolean r101 = PdpMessageOpt.f43751a;
        PdpMessageOpt.e("call onSubmitData fromPreload=" + r100);
        if (r100 == true) goto L7;
        PdpMessageOptImageHelper r102 = this.f43810q;
        if (r102.f43758a != null) goto L7;
        r102.f43758a = Boolean.TRUE;
    L7:
        this.f43811r = true;
    }
}
