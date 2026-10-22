package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import jc1.k;
import kotlin.jvm.functions.Function0;
import m00.g;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements rj0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f58743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f58744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f58745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f58746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f58747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f58748f;

    public static final class a implements g.a {
        public a() {
        }
    }

    @Override // rj0.a
    public final void c() {
    }

    @Override // rj0.a
    public final boolean a() {
        if (this.f58748f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rj0.a
    public final boolean b() {
        if (this.f58748f != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        Object r100 = this.f58748f;
        if (r100 != null) goto L5;
        a r101 = new a();
        g r102 = ((IMiddlewareBroadcastService) k.n(IMiddlewareBroadcastService.class)).createVideoTalkView(this.f58743a.f58752d, "", true, false, false, r101);
        if (r102 == null) goto L9;
        r102.h();
        return new vc0.a(r102);
    L9:
        return null;
    L5:
        return new vc0.a(r100);
    }

    @Override // rj0.a
    public final void onCancel() {
        this.f58745c.invoke();
    }

    @Override // rj0.a
    public final void onConfirm() {
        this.f58744b.invoke();
    }

    @Override // rj0.a
    public final String getCancelText() {
        return this.f58747e;
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return this.f58746d;
    }

    public d(e r100, Function0 r101, Function0 r102, String r103, String r104, Object r105) {
        this.f58743a = r100;
        this.f58744b = r101;
        this.f58745c = r102;
        this.f58746d = r103;
        this.f58747e = r104;
        this.f58748f = r105;
    }
}
