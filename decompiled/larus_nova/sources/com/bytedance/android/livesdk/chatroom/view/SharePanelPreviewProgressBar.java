package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/SharePanelPreviewProgressBar;", "Landroid/view/View;", "", "", "c", "Lkotlin/Lazy;", "getMStrokeWidth", "()F", "mStrokeWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SharePanelPreviewProgressBar extends View {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f114728e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f114729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f114730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f114731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f114732d;

    public static final class a {
    }

    public SharePanelPreviewProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SharePanelPreviewProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final float getMStrokeWidth() {
        return ((Number) this.f114731c.getValue()).floatValue();
    }

    static {
        f114728e = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        this.f114730b = (getMeasuredWidth() * this.f114729a) / 100;
        float r100 = 2;
        float r101 = (getPaddingTop() / r100) + (getMeasuredHeight() / r100);
        r110.drawLine(0.0f, r101, this.f114730b, r101, this.f114732d);
        float r102 = this.f114730b;
        float r103 = getMStrokeWidth() / r100;
        r110.drawArc(new RectF(r102 - r103, r101 - r103, r102 + r103, r101 + r103), -90.0f, 180.0f, true, this.f114732d);
    }

    public SharePanelPreviewProgressBar(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f114731c = LazyKt.lazy(new SharePanelPreviewProgressBar$mStrokeWidth$2(r100));
        Paint r103 = new Paint(1);
        r103.setAlpha(255);
        r103.setStrokeWidth(getMStrokeWidth());
        r103.setColor(f114728e);
        Unit r104 = Unit.INSTANCE;
        this.f114732d = r103;
    }

    public /* synthetic */ SharePanelPreviewProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
