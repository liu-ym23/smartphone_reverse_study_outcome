package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\r\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/widget/VSShareReverseView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "type", "", "setShareType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ShareMode", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSShareReverseView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f161389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f161390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f161391c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/VSShareReverseView$ShareMode;", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ShareMode {
    }

    public static final class a {
    }

    static {
    }

    public VSShareReverseView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSShareReverseView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private static /* synthetic */ void getShareType$annotations() {
    }

    @Override // android.view.View
    public final void invalidate() {
        setBackgroundColor(0);
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = getWidth();
        int r101 = getHeight();
        float r102 = UtilityKotlinExtentionsKt.h(15) / 2.0f;
        this.f161390b.reset();
        int r103 = this.f161391c;
        if (r103 == 0) goto L7;
        if (r103 != 1) goto L10;
        float r111 = r100;
        float r104 = 1;
        float r112 = r101;
        float r105 = 2;
        this.f161390b.addCircle((r111 - UtilityKotlinExtentionsKt.h(r104)) - r102, (r112 - r102) + UtilityKotlinExtentionsKt.h(r105), r102 - (UtilityKotlinExtentionsKt.h(r104) / r105), Path.Direction.CCW);
        Path r106 = new Path();
        float r107 = 10;
        r106.addCircle(UtilityKotlinExtentionsKt.h(r107), r112 - UtilityKotlinExtentionsKt.h(r107), UtilityKotlinExtentionsKt.h(r107) + r104, Path.Direction.CCW);
        Path r108 = new Path();
        r108.addCircle(r111 - UtilityKotlinExtentionsKt.h(r107), UtilityKotlinExtentionsKt.h(r107), UtilityKotlinExtentionsKt.h(r107) + r104, Path.Direction.CCW);
        Path r109 = new Path();
        Path r113 = new Path();
        r109.op(this.f161390b, r106, Path.Op.INTERSECT);
        r113.op(this.f161390b, r108, Path.Op.INTERSECT);
        r110.saveLayer(0.0f, 0.0f, r111, r112, null, 31);
        super.onDraw(r110);
        r110.drawPath(r109, this.f161389a);
        r110.drawPath(r113, this.f161389a);
        r110.restore();
        return;
    L10:
        return;
    L7:
        float r114 = r100;
        float r115 = 1;
        float r116 = r101;
        this.f161390b.addCircle((r114 - r102) + UtilityKotlinExtentionsKt.h(r115), (r116 - r102) + UtilityKotlinExtentionsKt.h(3), r102 - (UtilityKotlinExtentionsKt.h(r115) / 2), Path.Direction.CCW);
        Path r117 = new Path();
        float r118 = r114 / 2.0f;
        r117.addCircle(r118, r116 / 2.0f, r118, Path.Direction.CCW);
        this.f161390b.op(r117, Path.Op.INTERSECT);
        r110.saveLayer(0.0f, 0.0f, r114, r116, null, 31);
        super.onDraw(r110);
        r110.drawPath(this.f161390b, this.f161389a);
        r110.restore();
    }

    public final void setShareType(int r100) {
        this.f161391c = r100;
        invalidate();
    }

    public VSShareReverseView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Unit r104 = Unit.INSTANCE;
        this.f161389a = r103;
        setLayerType(1, null);
        this.f161390b = new Path();
    }

    public /* synthetic */ VSShareReverseView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
