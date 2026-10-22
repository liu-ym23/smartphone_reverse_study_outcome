package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/TrayContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getDrawMask", "()Z", "setDrawMask", "(Z)V", "drawMask", "", "b", FaceService.girlLabel, "getMaskWidth", "()F", "setMaskWidth", "(F)V", "maskWidth", "c", "isPk", "setPk", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrayContainerView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f129892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f129893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f129894c;

    public TrayContainerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TrayContainerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getDrawMask() {
        return this.f129892a;
    }

    public final float getMaskWidth() {
        return this.f129893b;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f129892a == false) goto L11;
        Path r101 = new Path();
        if (this.f129894c == false) goto L7;
        r101.addRoundRect(new RectF(0.0f, (s1.j(R.dimen.ttlive_gift_tray_container_height_pk) - s1.j(R.dimen.ttlive_gift_bg_view_height_pk)) - com.bytedance.android.live.revenue.common.i.a(4), this.f129893b, s1.j(R.dimen.ttlive_gift_tray_container_height_pk)), s1.j(R.dimen.ttlive_gift_tray_mask_radius), s1.j(R.dimen.ttlive_gift_tray_mask_radius), Path.Direction.CW);
    L8:
        if (r100 == null) goto L10;
        r100.clipPath(r101);
    L10:
        this.f129892a = false;
        goto L11
    L7:
        r101.addRoundRect(new RectF(0.0f, s1.j(R.dimen.ttlive_gift_tray_container_height) - s1.j(R.dimen.ttlive_gift_bg_view_height), this.f129893b, s1.j(R.dimen.ttlive_gift_tray_container_height)), s1.j(R.dimen.ttlive_gift_tray_mask_radius), s1.j(R.dimen.ttlive_gift_tray_mask_radius), Path.Direction.CW);
    L11:
        super.dispatchDraw(r100);
    }

    public final void setDrawMask(boolean r100) {
        this.f129892a = r100;
    }

    public final void setMaskWidth(float r100) {
        this.f129893b = r100;
    }

    public final void setPk(boolean r100) {
        this.f129894c = r100;
    }

    public TrayContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ TrayContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
