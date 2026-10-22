package com.bytedance.android.shopping.feed.banner;

import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f174423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f174424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f174425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f174426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f174427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f174428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f174429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f174430h;

    public interface a {
        void a();

        void b(float r100, float r101);
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        if (this.f174423a.hasMessages(1) == false) goto L6;
        this.f174423a.removeMessages(1);
        return;
    }

    public c() {
        this.f174423a = new WeakHandler(this);
        this.f174424b = 20;
        this.f174425c = (20 / 2000) * 100.0f;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 1) goto L34;
        Object r101 = r100.obj;
        if (r101 == null) goto L32;
        float r102 = ((Float) r101).floatValue();
        if (r102 >= 100.0f) goto L18;
        this.f174429g = r102;
        long r103 = this.f174424b;
        this.f174430h = r103;
        float r104 = this.f174425c;
        float r105 = r102 + r104;
        if (r105 < 100.0f) goto L14;
        this.f174430h = (long) ((((100.0f - r102) * 1.0f) / r104) * r103);
        a r106 = this.f174426d;
        if (r106 == null) goto L17;
        r106.b(r102, 100.0f);
    L17:
        Message r107 = Message.obtain();
        r107.what = 1;
        r107.obj = Float.valueOf(r102 + this.f174425c);
        this.f174423a.sendMessageDelayed(r107, this.f174430h);
        return;
    L14:
        a r108 = this.f174426d;
        if (r108 == null) goto L17;
        r108.b(r102, r105);
        goto L17
    L18:
        this.f174429g = 0.0f;
        a();
        a r109 = this.f174426d;
        if (r109 == null) goto L21;
        r109.b(100.0f, 100.0f);
    L21:
        a r110 = this.f174426d;
        if (r110 == null) goto L24;
        r110.a();
        boolean r111 = false;
    L25:
        if (r111 == true) goto L27;
        return;
    L27:
        if (this.f174427e == true) goto L29;
        return;
    L29:
        if (this.f174423a.hasMessages(1) == true) goto L38;
        Message r112 = Message.obtain();
        r112.what = 1;
        r112.obj = Float.valueOf(0.0f);
        this.f174423a.sendMessageDelayed(r112, this.f174424b);
        return;
    L38:
        return;
    L24:
        r111 = true;
        goto L25
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
