package com.bytedance.android.uicomponent.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/uicomponent/text/BorderTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BorderTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f187741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f187743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f187744d;

    public static final class a {
    }

    static {
    }

    public BorderTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BorderTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        this.f187741a.setColor(this.f187742b);
        this.f187741a.setStyle(Paint.Style.STROKE);
        this.f187741a.setStrokeWidth(this.f187743c);
        float r100 = getWidth();
        float r101 = getHeight();
        float r102 = this.f187744d;
        r110.drawRoundRect(0.0f, 0.0f, r100, r101, r102, r102, this.f187741a);
    }

    public BorderTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f187741a = new Paint();
        int r103 = (int) 4278190080L;
        this.f187742b = r103;
        float r104 = e.a(r100, 1.0f);
        this.f187743c = r104;
        float r105 = e.a(r100, 8.0f);
        this.f187744d = r105;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.borderColor, R.attr.borderRadius, R.attr.borderWidth});
        this.f187742b = r106.getColor(0, r103);
        this.f187743c = r106.getDimension(2, r104);
        this.f187744d = r106.getDimension(1, r105);
        r106.recycle();
    }

    public /* synthetic */ BorderTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
