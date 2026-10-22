package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/RadiusHSImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RadiusHSImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f136517a;

    public RadiusHSImageView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        Path r101 = new Path();
        RectF r102 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r103 = this.f136517a;
        r101.addRoundRect(r102, r103, r103, Path.Direction.CCW);
        Unit r104 = Unit.INSTANCE;
        r100.clipPath(r101);
        super.onDraw(r100);
    }

    public final void setRadius(float r100) {
        this.f136517a = r100;
    }

    public RadiusHSImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setWillNotDraw(false);
    }
}
