package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/IMProgressBarLayout;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMProgressBarLayout extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f96885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f96886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f96887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f96888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f96889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f96890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f96891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f96892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f96893i;

    public static final class a {
    }

    static {
    }

    public IMProgressBarLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f96885a = new RectF();
        this.f96886b = new RectF();
        this.f96887c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f96888d = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_left);
        this.f96889e = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_right);
        this.f96890f = s1.h(R.color.ttlive_pk_im_feed_view_votebar_bg);
        Paint r101 = new Paint();
        this.f96891g = r101;
        this.f96892h = 0.5f;
        r101.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = (this.f96892h * (getWidth() - 30)) + 15;
        RectF r102 = this.f96885a;
        r102.top = 0.0f;
        r102.bottom = getHeight();
        RectF r103 = this.f96885a;
        r103.left = 0.0f;
        r103.right = r101;
        RectF r104 = this.f96886b;
        r104.top = 0.0f;
        r104.bottom = getHeight();
        RectF r105 = this.f96886b;
        r105.left = r101;
        r105.right = getWidth();
        if (this.f96893i == false) goto L5;
        this.f96891g.setColor(this.f96890f);
        r100.drawRect(this.f96887c, this.f96891g);
    L5:
        this.f96891g.setColor(this.f96888d);
        r100.drawRect(this.f96885a, this.f96891g);
        this.f96891g.setColor(this.f96889e);
        r100.drawRect(this.f96886b, this.f96891g);
    }

    public IMProgressBarLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f96885a = new RectF();
        this.f96886b = new RectF();
        this.f96887c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f96888d = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_left);
        this.f96889e = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_right);
        this.f96890f = s1.h(R.color.ttlive_pk_im_feed_view_votebar_bg);
        Paint r102 = new Paint();
        this.f96891g = r102;
        this.f96892h = 0.5f;
        r102.setStyle(Paint.Style.FILL);
    }

    public IMProgressBarLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f96885a = new RectF();
        this.f96886b = new RectF();
        this.f96887c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f96888d = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_left);
        this.f96889e = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_right);
        this.f96890f = s1.h(R.color.ttlive_pk_im_feed_view_votebar_bg);
        Paint r103 = new Paint();
        this.f96891g = r103;
        this.f96892h = 0.5f;
        r103.setStyle(Paint.Style.FILL);
    }

    public final void a(boolean r100, long r101, long r102) {
        this.f96893i = r100;
        if (r100 == false) goto L5;
        this.f96888d = s1.h(R.color.ttlive_pk_im_feed_view_votebar_left);
        this.f96889e = s1.h(R.color.ttlive_pk_im_feed_view_votebar_right);
    L6:
        long r103 = r102 + r101;
        if (r103 == 0) goto L9;
        this.f96892h = (r101 * 1.0f) / (r103 * 1.0f);
    L10:
        invalidate();
        return;
    L9:
        this.f96892h = 0.5f;
        goto L10
    L5:
        this.f96888d = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_left);
        this.f96889e = s1.h(R.color.ttlive_pk_im_feed_view_pkbar_right);
        goto L6
    }
}
