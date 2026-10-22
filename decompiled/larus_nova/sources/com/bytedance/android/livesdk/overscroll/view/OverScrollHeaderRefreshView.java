package com.bytedance.android.livesdk.overscroll.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/overscroll/view/OverScrollHeaderRefreshView;", "Landroid/widget/FrameLayout;", "", "refreshing", "", "setRefreshing", "", "alpha", "setTextAlpha", "getTextAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrollHeaderRefreshView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoubleColorBallAnimationView f154185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f154186b;

    public OverScrollHeaderRefreshView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OverScrollHeaderRefreshView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getTextAlpha() {
        TextView r100 = this.f154186b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getAlpha();
    }

    public final void setRefreshing(boolean r100) {
        if (r100 == false) goto L12;
        TextView r101 = this.f154186b;
        if (r101 == null) goto L6;
        r101.setText(s1.B(R.string.ttlive_pull_refresh_text_refreshing));
    L6:
        DoubleColorBallAnimationView r102 = this.f154185a;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        DoubleColorBallAnimationView r103 = this.f154185a;
        if (r103 == null) goto L19;
        r103.a();
        r103.f154173i = true;
        r103.f154170f = true;
        r103.postInvalidate();
        return;
    L19:
        return;
    L12:
        DoubleColorBallAnimationView r104 = this.f154185a;
        if (r104 == null) goto L15;
        r104.setVisibility(8);
    L15:
        TextView r105 = this.f154186b;
        if (r105 == null) goto L21;
        r105.setText(s1.B(R.string.ttlive_pull_refresh_text_pull_refresh));
        return;
    }

    public final void setTextAlpha(float r100) {
        TextView r101 = this.f154186b;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    public OverScrollHeaderRefreshView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_over_scroll_header_refresh_view, this, true);
        this.f154185a = (DoubleColorBallAnimationView) findViewById(R.id.double_ball_icon);
        TextView r103 = (TextView) findViewById(R.id.refresh_text);
        this.f154186b = r103;
        if (r103 == null) goto L6;
        r103.setText(s1.B(R.string.ttlive_pull_refresh_text_pull_refresh));
        return;
    }

    public /* synthetic */ OverScrollHeaderRefreshView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
