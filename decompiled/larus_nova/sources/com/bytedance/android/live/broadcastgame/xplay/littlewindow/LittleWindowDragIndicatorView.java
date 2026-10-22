package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/LittleWindowDragIndicatorView;", "Landroid/view/View;", "Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/LittleWindowLayoutManager;", "layoutManager", "", "setLayoutManager", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LittleWindowDragIndicatorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f62200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f62201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f62202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LittleWindowLayoutManager f62203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<RectF> f62204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f62205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f62206g;

    public LittleWindowDragIndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LittleWindowDragIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        LittleWindowLayoutManager r100 = this.f62203d;
        if (r100 != null) goto L5;
        return;
    L5:
        LittleWindowPos[] r101 = LittleWindowPos.values();
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        LittleWindowPos r104 = r101[r103];
        Rect r105 = r100.a(LittleWindowLayoutManager.LayoutMode.DragIndicator, r104, 0.0f, 0.0f);
        RectF r106 = (RectF) ListProtector.get(this.f62204e, r104.ordinal());
        r106.left = r105.left;
        r106.top = r105.top;
        r106.right = r105.right;
        r106.bottom = r105.bottom;
        r103 = r103 + 1;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        RectF r101 = (RectF) ListProtector.get(this.f62204e, LittleWindowPos.TOP.ordinal());
        RectF r102 = (RectF) ListProtector.get(this.f62204e, LittleWindowPos.LEFT.ordinal());
        RectF r103 = (RectF) ListProtector.get(this.f62204e, LittleWindowPos.RIGHT.ordinal());
        RectF r104 = (RectF) ListProtector.get(this.f62204e, LittleWindowPos.RIGHT_BOTTOM.ordinal());
        this.f62206g.setEmpty();
        this.f62206g.union(r101);
        this.f62206g.union(r102);
        this.f62206g.union(r103);
        RectF r105 = this.f62206g;
        float r106 = this.f62202c;
        r100.drawRoundRect(r105, r106, r106, this.f62201b);
        a(r100, r101);
        a(r100, r102);
        a(r100, r103);
        float r107 = this.f62202c;
        r100.drawRoundRect(r104, r107, r107, this.f62201b);
    }

    public final void setLayoutManager(LittleWindowLayoutManager r100) {
        this.f62203d = r100;
        b();
    }

    public final void a(Canvas r100, RectF r101) {
        this.f62205f.reset();
        Path r102 = this.f62205f;
        float r103 = this.f62202c;
        r102.addRoundRect(r101, r103, r103, Path.Direction.CW);
        r100.drawPath(this.f62205f, this.f62200a);
    }

    public LittleWindowDragIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f62200a = r103;
        Paint r104 = new Paint();
        this.f62201b = r104;
        float r105 = t6.a(r100, 1.0f);
        float r106 = t6.a(r100, 6.0f);
        this.f62202c = t6.a(r100, 3.0f);
        r103.setColor(-1);
        r103.setAlpha(178);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(r105);
        int r107 = 0;
        r103.setPathEffect(new DashPathEffect(new float[]{r106, r106}, r106));
        r103.setAntiAlias(true);
        r104.setColor(-1);
        r104.setAlpha(77);
        r104.setStyle(Paint.Style.FILL);
        r104.setAntiAlias(true);
        LittleWindowPos[] r108 = LittleWindowPos.values();
        ArrayList r109 = new ArrayList(r108.length);
        int r110 = r108.length;
    L4:
        if (r107 >= r110) goto L6;
        LittleWindowPos r111 = r108[r107];
        r109.add(new RectF(0.0f, 0.0f, 0.0f, 0.0f));
        r107 = r107 + 1;
        goto L4
    L6:
        this.f62204e = r109;
        this.f62205f = new Path();
        this.f62206g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ LittleWindowDragIndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        b();
    }
}
