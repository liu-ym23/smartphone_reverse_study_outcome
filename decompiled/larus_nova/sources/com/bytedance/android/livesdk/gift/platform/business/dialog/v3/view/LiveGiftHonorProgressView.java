package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0007\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/LiveGiftHonorProgressView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/LiveGiftHonorProgressView$b;", "honorProgressCallBack", "", "setHonorProgressCallBack", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getMProgress", "()F", "setMProgress", "(F)V", "mProgress", "", "getHighlightWidth", "()I", "highlightWidth", "getHighlightMargin", "highlightMargin", "getHighlightHeight", "highlightHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftHonorProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f128603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GradientDrawable f128604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GradientDrawable f128605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GradientDrawable f128606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ClipDrawable f128607e;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final void setHonorProgressCallBack(b r100) {
    }

    public final void a() {
        GradientDrawable r100 = new GradientDrawable();
        this.f128604b = r100;
        r100.setShape(0);
        if (getContext() != null) goto L5;
    L13:
        GradientDrawable r101 = this.f128604b;
        if (r101 == null) goto L16;
        r101.setColor(s1.h(R.color.ttlive_level_honor_progress_background));
    L16:
        GradientDrawable r102 = new GradientDrawable();
        this.f128606d = r102;
        r102.setShape(0);
        GradientDrawable r103 = this.f128606d;
        if (r103 == null) goto L19;
        r103.setColor(ColorProtector.parseColor("#55ffffff"));
    L19:
        Drawable r104 = s1.m(R.drawable.ttlive_bg_honor_progress_add);
        if ((r104 instanceof ClipDrawable) == false) goto L22;
        this.f128607e = (ClipDrawable) r104;
    L22:
        Drawable r105 = s1.m(R.drawable.ttlive_bg_honor_progress_highlight);
        if ((r105 instanceof GradientDrawable) == false) goto L25;
        this.f128605c = (GradientDrawable) r105;
        return;
    L25:
        GradientDrawable r106 = new GradientDrawable();
        this.f128605c = r106;
        r106.setColor(ColorProtector.parseColor("#face15"));
        GradientDrawable r107 = this.f128605c;
        if (r107 == null) goto L30;
        r107.setShape(0);
        return;
    L30:
        return;
    L5:
        if (getContext().getResources() == null) goto L13;
        if (getContext().getResources().getConfiguration() == null) goto L13;
        if (getContext().getResources().getConfiguration().orientation != 2) goto L13;
        GradientDrawable r108 = this.f128604b;
        if (r108 == null) goto L16;
        r108.setColor(ColorProtector.parseColor("#161823"));
        goto L16
    }

    private final int getHighlightHeight() {
        return s1.j(R.dimen.ttlive_gift_honor_level_progress_highlight_height);
    }

    private final int getHighlightMargin() {
        return s1.j(R.dimen.ttlive_gift_honor_level_progress_highlight_margin);
    }

    private final int getHighlightWidth() {
        return getWidth() - (s1.j(R.dimen.ttlive_gift_honor_level_progress_highlight_margin) * 2);
    }

    public final float getMProgress() {
        return this.f128603a;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LiveGiftHonorProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        new ArrayList();
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        GradientDrawable r101 = this.f128604b;
        if (r101 == null) goto L5;
        r101.setCornerRadius(getHeight() / 2);
    L5:
        GradientDrawable r102 = this.f128604b;
        if (r102 == null) goto L8;
        r102.setBounds(0, 0, getWidth(), getHeight());
    L8:
        int r103 = (int) (getHighlightWidth() * 0.0f);
        GradientDrawable r104 = this.f128605c;
        if (r104 == null) goto L11;
        r104.setBounds(getHighlightMargin(), getHighlightMargin(), r103 + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
    L11:
        GradientDrawable r105 = this.f128605c;
        if (r105 == null) goto L14;
        r105.setCornerRadius(getHighlightHeight() / 2);
    L14:
        GradientDrawable r106 = this.f128606d;
        if (r106 == null) goto L17;
        r106.setBounds(0, 0, (int) (getWidth() * 0.0f), getHeight());
    L17:
        GradientDrawable r107 = this.f128606d;
        if (r107 == null) goto L20;
        r107.setCornerRadius(getHeight() / 2);
    L20:
        ClipDrawable r108 = this.f128607e;
        if (r108 == null) goto L27;
        if (r108 == null) goto L24;
        r108.setBounds(getHighlightMargin(), getHighlightMargin(), getHighlightWidth() + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
    L24:
        ClipDrawable r109 = this.f128607e;
        if (r109 == null) goto L27;
        r109.setLevel((int) (10000 * 0.0f));
    L27:
        GradientDrawable r110 = this.f128604b;
        if (r110 == null) goto L31;
        r110.draw(r100);
    L31:
        if (0.0f > 0) goto L33;
    L41:
        GradientDrawable r111 = this.f128605c;
        if (r111 == null) goto L45;
        r111.draw(r100);
        return;
    L45:
        return;
    L33:
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_CORE_HONOR_VIEW_USE_PIC, Boolean.FALSE)).booleanValue() == false) goto L38;
        ClipDrawable r112 = this.f128607e;
        if (r112 == null) goto L38;
        if (r112 == null) goto L41;
        r112.draw(r100);
    L38:
        GradientDrawable r113 = this.f128606d;
        if (r113 == null) goto L41;
        r113.draw(r100);
        goto L41
    }

    public final void setMProgress(float r100) {
        this.f128603a = r100;
    }

    public LiveGiftHonorProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        new ArrayList();
        a();
    }

    public LiveGiftHonorProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        new ArrayList();
        a();
    }
}
