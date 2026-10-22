package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.f.j;
import com.bumptech.glide.f.k;
import com.bumptech.glide.load.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class GifFrameLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RequestManager f3867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.b.a f3868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f3869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f3870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3871e;
    private boolean f;
    private boolean g;
    private boolean h;
    private com.bumptech.glide.g<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private m<Bitmap> n;
    private a o;
    private c p;
    private int q;
    private int r;
    private int s;

    private class FrameLoaderCallback implements Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;
        final /* synthetic */ GifFrameLoader this$0;

        FrameLoaderCallback(GifFrameLoader r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r4) {
            if (r4.what != 1) goto L7;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4.obj, a.class, "com.obric.aiagent.plugin");
            this.this$0.a(r5);
            return true;
        L7:
            if (r4.what != 2) goto L11;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r4.obj, a.class, "com.obric.aiagent.plugin");
            this.this$0.f3867a.clear(r6);
            return false;
        L11:
            return false;
        }
    }

    static class a extends com.bumptech.glide.request.target.c<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f3872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f3873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f3874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap f3875d;

        @Override // com.bumptech.glide.request.target.i
        public /* synthetic */ void a(Object r3, com.bumptech.glide.request.a.b r4) {
            com.bumptech.glide.request.a.b<? super Bitmap> r5 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");
            a((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.aiagent.plugin"), r5);
        }

        a(Handler r1, int r2, long r3) {
            this.f3873b = r1;
            this.f3872a = r2;
            this.f3874c = r3;
        }

        Bitmap b() {
            return this.f3875d;
        }

        public void a(Bitmap r3, com.bumptech.glide.request.a.b<? super Bitmap> r4) {
            com.bumptech.glide.request.a.b r5 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");
            this.f3875d = r3;
            Message r6 = this.f3873b.obtainMessage(1, this);
            this.f3873b.sendMessageAtTime(r6, this.f3874c);
        }

        @Override // com.bumptech.glide.request.target.i
        public void c(Drawable r1) {
            this.f3875d = null;
        }
    }

    public interface b {
        void onFrameReady();
    }

    interface c {
        void a();
    }

    GifFrameLoader(Glide r11, com.bumptech.glide.b.a r12, int r13, int r14, m<Bitmap> r15, Bitmap r16) {
        com.bumptech.glide.b.a r5 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.b.a.class, "com.obric.aiagent.plugin");
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r15, m.class, "com.obric.aiagent.plugin");
        this(r11.getBitmapPool(), Glide.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r5, null, a(Glide.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r13, r14), r8, r16);
    }

    GifFrameLoader(com.bumptech.glide.load.engine.a.e r3, RequestManager r4, com.bumptech.glide.b.a r5, Handler r6, com.bumptech.glide.g<Bitmap> r7, m<Bitmap> r8, Bitmap r9) {
        com.bumptech.glide.load.engine.a.e r10 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.b.a r11 = (com.bumptech.glide.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.b.a.class, "com.obric.aiagent.plugin");
        m<Bitmap> r12 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        this.f3870d = new ArrayList();
        this.f3867a = r4;
        if (r6 != null) goto L5;
        r6 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this));
    L5:
        this.f3871e = r10;
        this.f3869c = r6;
        this.i = r7;
        this.f3868b = r11;
        a(r12, r9);
    }

    void a(m<Bitmap> r4, Bitmap r5) {
        m<Bitmap> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        this.n = (m) ZeusTransformUtils.preCheckCast(j.a(r6), m.class, "com.obric.aiagent.plugin");
        this.m = (Bitmap) ZeusTransformUtils.preCheckCast(j.a(r5), Bitmap.class, "com.obric.aiagent.plugin");
        this.i = this.i.a(new com.bumptech.glide.request.h().a(r6));
        this.q = k.a(r5);
        this.r = r5.getWidth();
        this.s = r5.getHeight();
    }

    m<Bitmap> a() {
        return this.n;
    }

    Bitmap b() {
        return this.m;
    }

    void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.k == true) goto L13;
        if (this.f3870d.contains(r4) == true) goto L11;
        boolean r0 = this.f3870d.isEmpty();
        this.f3870d.add(r4);
        if (r0 == false) goto L14;
        m();
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("Cannot subscribe twice in a row");
    L13:
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f3870d.remove(r4);
        if (this.f3870d.isEmpty() == false) goto L6;
        n();
        return;
    }

    int c() {
        return this.r;
    }

    int d() {
        return this.s;
    }

    int e() {
        return this.f3868b.h() + this.q;
    }

    int f() {
        a r0 = this.j;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.f3872a;
    }

    ByteBuffer g() {
        return this.f3868b.a().asReadOnlyBuffer();
    }

    int h() {
        return this.f3868b.d();
    }

    int i() {
        return this.f3868b.g();
    }

    private void m() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        this.k = false;
        o();
    }

    private void n() {
        this.f = false;
    }

    void j() {
        this.f3870d.clear();
        p();
        n();
        a r0 = this.j;
        if (r0 == null) goto L5;
        this.f3867a.clear(r0);
        this.j = null;
    L5:
        a r1 = this.l;
        if (r1 == null) goto L8;
        this.f3867a.clear(r1);
        this.l = null;
    L8:
        a r2 = this.o;
        if (r2 == null) goto L11;
        this.f3867a.clear(r2);
        this.o = null;
    L11:
        this.f3868b.j();
        this.k = true;
    }

    Bitmap k() {
        a r0 = this.j;
        if (r0 == null) goto L6;
        return r0.b();
    L6:
        return this.m;
    }

    private void o() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.g == false) goto L8;
        return;
    L8:
        if (this.h == true) goto L10;
    L14:
        a r0 = this.o;
        if (r0 == null) goto L18;
        this.o = null;
        a(r0);
        return;
    L18:
        this.g = true;
        long r1 = SystemClock.uptimeMillis() + ((long) this.f3868b.c());
        this.f3868b.b();
        this.l = new a(this.f3869c, this.f3868b.e(), r1);
        this.i.a(com.bumptech.glide.request.h.b(q())).a(this.f3868b).a(this.l);
        return;
    L10:
        if (this.o != null) goto L12;
        boolean r2 = true;
    L13:
        j.a(r2, "Pending target must be null when starting from the first frame");
        this.f3868b.f();
        this.h = false;
        goto L14
    L12:
        r2 = false;
        goto L13
    }

    private void p() {
        Bitmap r0 = this.m;
        if (r0 == null) goto L6;
        this.f3871e.a(r0);
        this.m = null;
        return;
    }

    void l() {
        j.a(!this.f, "Can't restart a running animation");
        this.h = true;
        a r0 = this.o;
        if (r0 == null) goto L6;
        this.f3867a.clear(r0);
        this.o = null;
        return;
    }

    void a(a r6) {
        c r0 = this.p;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.g = false;
        if (this.k == false) goto L10;
        this.f3869c.obtainMessage(2, r6).sendToTarget();
        return;
    L10:
        if (this.f == true) goto L14;
        this.o = r6;
        return;
    L14:
        if (r6.b() == null) goto L20;
        p();
        a r1 = this.j;
        this.j = r6;
        int r7 = this.f3870d.size() - 1;
    L16:
        if (r7 < 0) goto L18;
        ((b) ZeusTransformUtils.preCheckCast(this.f3870d.get(r7), b.class, "com.obric.aiagent.plugin")).onFrameReady();
        r7 = r7 - 1;
        goto L16
    L18:
        if (r1 == null) goto L20;
        this.f3869c.obtainMessage(2, r1).sendToTarget();
    L20:
        o();
    }

    private static com.bumptech.glide.g<Bitmap> a(RequestManager r4, int r5, int r6) {
        return r4.asBitmap().a(((com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.h.b(com.bumptech.glide.load.engine.j.f3676b).a(true), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin")).b(true), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin")).b(r5, r6));
    }

    private static com.bumptech.glide.load.g q() {
        return new com.bumptech.glide.e.d(Double.valueOf(Math.random()));
    }
}
