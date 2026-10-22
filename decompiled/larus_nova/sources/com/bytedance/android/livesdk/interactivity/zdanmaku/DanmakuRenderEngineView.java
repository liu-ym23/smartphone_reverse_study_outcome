package com.bytedance.android.livesdk.interactivity.zdanmaku;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.k1;
import ec2.t;
import ec2.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/DanmakuRenderEngineView;", "Lcom/bytedance/live/zdanmaku/render/canvas/RenderEngineView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DanmakuRenderEngineView extends RenderEngineView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RenderRequest f141438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f141439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f141440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f141441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f141442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f141443m;

    public static final class a {
    }

    static {
    }

    public DanmakuRenderEngineView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DanmakuRenderEngineView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final boolean k() {
        return this.f141440j;
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final void e(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f141439i == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L17;
        if (r100.getAction() != 0) goto L17;
        final float r101 = r100.getX();
        final float r102 = r100.getY();
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        RenderRequest r104 = this.f141438h;
        if (r104 == null) goto L8;
        r104.a(new DanmakuRenderEngineView$findClickableItem$1(r101, r102, r103));
    L8:
        tc2.d r105 = (tc2.d) r103.element;
        if (r105 == null) goto L17;
        r105.onClick(this);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        ALogger.e("DanmakuRenderEngineView", e);
        return true;
    L17:
        return super.onTouchEvent(r100);
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final void g(final Canvas r100, RenderRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "request");
        this.f141443m++;
        if (this.f141441k <= 0) goto L7;
        long r102 = this.f141442l + (System.currentTimeMillis() - this.f141441k);
        this.f141442l = r102;
        if (r102 < 1000) goto L7;
        this.f141442l = 0;
        com.bytedance.android.livesdk.interactivity.utils.j.f141392a.debug("DanmakuRender", "一秒刷新 " + this.f141443m + " 帧");
        this.f141443m = 0;
    L7:
        this.f141441k = System.currentTimeMillis();
        r101.a(new DanmakuRenderEngineView$render$1(this, r100));
        this.f141438h = r101;
    }

    public DanmakuRenderEngineView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f141439i = t.f472057a.getValue().booleanValue();
        this.f141440j = u.f472060a.getValue().booleanValue();
        k1.f472032a.getValue().booleanValue();
    }

    public /* synthetic */ DanmakuRenderEngineView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
