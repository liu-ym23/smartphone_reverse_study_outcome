package com.bytedance.android.livesdk.chatroom.replay.cache.ui.customui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/customui/CacheProgressBar;", "Landroid/view/View;", "", FilterData.FilterOptionItem.Type.RANGE, "", "setProgressRange", "progress", "setCurrentProgress", "", "color", "setBarStartColor", "setBarBgColor", "setBarStopColor", "radius", "setBarRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CacheProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f108171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f108172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f108173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f108174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f108175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f108176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f108177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f108178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f108179i;

    public CacheProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CacheProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        RectF r101 = this.f108178h;
        r101.left = 0.0f;
        r101.right = getWidth();
        RectF r102 = this.f108178h;
        r102.top = 0.0f;
        r102.bottom = getHeight();
        RectF r103 = this.f108178h;
        float r104 = this.f108174d;
        r100.drawRoundRect(r103, r104, r104, this.f108175e);
        RectF r105 = this.f108179i;
        r105.left = 0.0f;
        r105.right = (this.f108171a / this.f108172b) * getWidth();
        RectF r106 = this.f108179i;
        r106.top = 0.0f;
        r106.bottom = getHeight();
        RectF r107 = this.f108179i;
        float r108 = this.f108174d;
        if (this.f108173c == false) goto L5;
        Paint r109 = this.f108176f;
    L6:
        r100.drawRoundRect(r107, r108, r108, r109);
        return;
    L5:
        r109 = this.f108177g;
        goto L6
    }

    public final void setBarBgColor(int r100) {
        if (this.f108175e.getColor() == r100) goto L6;
        this.f108175e.setColor(r100);
        invalidate();
        return;
    }

    public final void setBarRadius(float r100) {
        this.f108174d = r100;
        invalidate();
    }

    public final void setBarStartColor(int r100) {
        if (this.f108177g.getColor() == r100) goto L6;
        this.f108177g.setColor(r100);
        invalidate();
        return;
    }

    public final void setBarStopColor(int r100) {
        if (this.f108176f.getColor() == r100) goto L6;
        this.f108176f.setColor(r100);
        invalidate();
        return;
    }

    public final void setCurrentProgress(float r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        this.f108171a = r100;
        invalidate();
    }

    public final void setProgressRange(float r100) {
        this.f108172b = r100;
        invalidate();
    }

    public CacheProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f108172b = 100.0f;
        this.f108174d = 1.0f;
        this.f108175e = new Paint();
        this.f108176f = new Paint();
        this.f108177g = new Paint();
        this.f108178h = new RectF();
        this.f108179i = new RectF();
    }

    public /* synthetic */ CacheProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
