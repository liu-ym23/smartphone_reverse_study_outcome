package com.android.ttcjpaysdk.base.ui.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0017J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0017J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"com/android/ttcjpaysdk/base/ui/anim/CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1", "Landroid/widget/EdgeEffect;", "pullDistance", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", VideoEventOneOutSync.END_TYPE_FINISH, "", "getDistance", "handlePull", "deltaDistance", "isFinished", "onAbsorb", "velocity", "", "onPull", "displacement", "onPullDistance", "onRelease", "resetState", "updatePullDistance", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1 extends EdgeEffect {
    final /* synthetic */ CJUnifySpringEdgeEffect.SpringController $controller;
    final /* synthetic */ int $direction;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ int $viewOrientation;
    private float pullDistance;
    final /* synthetic */ CJUnifySpringEdgeEffect this$0;

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        return false;
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.pullDistance = 0.0f;
        CJUnifySpringEdgeEffect.SpringController r100 = this.$controller;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public final void resetState() {
        this.pullDistance = 0.0f;
        CJUnifySpringEdgeEffect.SpringController r100 = this.$controller;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    @Override // android.widget.EdgeEffect
    public boolean isFinished() {
        if (this.pullDistance != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L14;
        CJUnifySpringEdgeEffect.SpringController r101 = this.$controller;
        if (r101 == null) goto L10;
        boolean r102 = r101.isFinished();
    L11:
        if (r102 == false) goto L15;
        return true;
    L15:
        return false;
    L10:
        r102 = true;
        goto L11
    L14:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.widget.EdgeEffect
    public void finish() {
        resetState();
    }

    @Override // android.widget.EdgeEffect
    public float getDistance() {
        return this.pullDistance;
    }

    private final void handlePull(float r100) {
        CJUnifySpringEdgeEffect.SpringController r101 = this.$controller;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = -1;
        boolean r103 = true;
        if (this.$viewOrientation != 1) goto L26;
        boolean r104 = false;
        if (this.$direction != 3) goto L14;
        if ((this.this$0.getCanPullVerticalDirection() & 1) == 1) goto L17;
        r103 = false;
    L17:
        if (r103 == true) goto L19;
        return;
    L19:
        CJUnifySpringEdgeEffect.OnPullCallback r105 = this.this$0.getOnPullCallback();
        if (r105 != null) goto L22;
    L24:
        r101.pull(((r102 * this.$recyclerView.getHeight()) * r100) * 0.2f);
        return;
    L22:
        if (r105.onPull(r100) == false) goto L24;
        return;
    L14:
        if ((this.this$0.getCanPullVerticalDirection() & 16) != 16) goto L16;
        r104 = true;
    L16:
        r103 = r104;
        r102 = 1;
        goto L17
    L26:
        if (this.$direction == 2) goto L29;
        r102 = 1;
    L29:
        r101.pull(((r102 * this.$recyclerView.getWidth()) * r100) * 0.2f);
    }

    private final float updatePullDistance(float r100) {
        float r101 = this.pullDistance;
        float r102 = RangesKt.coerceIn(r100 + r101, 0.0f, 1.0f);
        this.pullDistance = r102;
        return r102 - r101;
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int r100) {
        this.pullDistance = 0.0f;
        if (this.this$0.getEnableAbsorbImpact() == true) goto L5;
        return;
    L5:
        CJUnifySpringEdgeEffect.SpringController r101 = this.$controller;
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = this.$direction;
        if (r102 != 2) goto L11;
    L13:
        int r103 = -1;
    L14:
        r101.absorb(RangesKt.coerceIn((r103 * r100) * 0.1f, -2000.0f, 2000.0f));
        return;
    L11:
        if (r102 == 3) goto L13;
        r103 = 1;
        goto L14
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r100) {
        float r101 = updatePullDistance(r100);
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        handlePull(r101);
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r100, float r101) {
        onPull(r100);
    }

    @Override // android.widget.EdgeEffect
    public float onPullDistance(float r100, float r101) {
        float r102 = updatePullDistance(r100);
        if (r102 != 0.0f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        handlePull(r102);
    L8:
        return r102;
    L5:
        r103 = false;
        goto L6
    }

    public CJUnifySpringEdgeEffect$createEdgeEffect$edgeEffect$1(CJUnifySpringEdgeEffect.SpringController r100, int r101, int r102, CJUnifySpringEdgeEffect r103, RecyclerView r104, Context r105) {
        this.$controller = r100;
        this.$viewOrientation = r101;
        this.$direction = r102;
        this.this$0 = r103;
        this.$recyclerView = r104;
        super(r105);
    }
}
