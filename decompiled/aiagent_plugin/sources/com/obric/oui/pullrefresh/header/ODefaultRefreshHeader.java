package com.obric.oui.pullrefresh.header;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: ODefaultRefreshHeader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ODefaultRefreshHeader extends FrameLayout implements com.obric.oui.pullrefresh.header.a {
    private ObjectAnimator arrowAnimator;
    private boolean arrowPointUp;
    private final ImageView arrowView;
    private final ODownloadProgressView progressBar;
    private final ImageView successView;
    private CharSequence textPull;
    private CharSequence textRefreshing;
    private CharSequence textRelease;
    private CharSequence textSuccess;
    private final TextView titleView;

    /* JADX INFO: compiled from: ODefaultRefreshHeader.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36116a = null;

        static {
            int[] r0 = new int[c.values().length];
            r0[c.f36112b.ordinal()] = 1;
            r0[c.f36111a.ordinal()] = 2;
            r0[c.f36113c.ordinal()] = 3;
            r0[c.f36114d.ordinal()] = 4;
            r0[c.f36115e.ordinal()] = 5;
            f36116a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ODefaultRefreshHeader(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ODefaultRefreshHeader(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public ODefaultRefreshHeader(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        String r8 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_pull_to_refresh, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_pull_to_refresh"));
        o.c(r8, "context.getString(R.string.oui_pull_to_refresh)");
        this.textPull = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        String r9 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_release_to_refresh, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_release_to_refresh"));
        o.c(r9, "context.getString(R.string.oui_release_to_refresh)");
        this.textRelease = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        String r10 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_refreshing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_refreshing"));
        o.c(r10, "context.getString(R.string.oui_refreshing)");
        this.textRefreshing = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        String r11 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_refresh_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_refresh_success"));
        o.c(r11, "context.getString(R.string.oui_refresh_success)");
        this.textSuccess = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.o_pullrefresh_default_header, "layout", "o_pullrefresh_default_header"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_iv_arrow, DbHelper.COL_ID, "pr_iv_arrow"));
        o.c(r12, "findViewById(R.id.pr_iv_arrow)");
        this.arrowView = (ImageView) ZeusTransformUtils.preCheckCast(r12, ImageView.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_iv_success, DbHelper.COL_ID, "pr_iv_success"));
        o.c(r13, "findViewById(R.id.pr_iv_success)");
        this.successView = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.aiagent.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_progress, DbHelper.COL_ID, "pr_progress"));
        o.c(r14, "findViewById(R.id.pr_progress)");
        this.progressBar = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r14, ODownloadProgressView.class, "com.obric.aiagent.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_tv_title, DbHelper.COL_ID, "pr_tv_title"));
        o.c(r15, "findViewById(R.id.pr_tv_title)");
        this.titleView = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.aiagent.plugin");
        setAlpha(0.0f);
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public void onPulling(OPullRefreshLayout r1, float r2, float r3, float r4) {
        o.e(r1, "layout");
        setAlpha(n.a(r2, 0.0f, 1.0f));
        if (r1.getState() != c.f36111a) goto L5;
    L6:
        this.titleView.setText(this.textPull);
        this.progressBar.setVisibility(8);
        this.successView.setVisibility(8);
        this.arrowView.setVisibility(0);
        if (this.arrowPointUp == false) goto L11;
        this.arrowView.setRotation(0.0f);
        this.arrowPointUp = false;
        return;
    L11:
        return;
    L5:
        if (r1.getState() == c.f36112b) goto L6;
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public void onStateChanged(OPullRefreshLayout r3, c r4, c r5) {
        o.e(r3, "layout");
        o.e(r4, "oldState");
        o.e(r5, "newState");
        int r6 = a.f36116a[r5.ordinal()];
        boolean r7 = false;
        boolean r0 = true;
        if (r6 != 1) goto L5;
    L19:
        this.titleView.setText(this.textPull);
        showArrow();
        if (r4 == c.f36113c) goto L23;
        r0 = false;
    L23:
        rotateArrow(false, r0);
        return;
    L5:
        if (r6 == 2) goto L19;
        if (r6 != 3) goto L9;
        this.titleView.setText(this.textRelease);
        showArrow();
        if (r4 != c.f36112b) goto L18;
        r7 = true;
    L18:
        rotateArrow(true, r7);
        return;
    L9:
        if (r6 != 4) goto L11;
        this.titleView.setText(this.textRefreshing);
        showProgress();
        return;
    L11:
        if (r6 != 5) goto L28;
        this.titleView.setText(this.textSuccess);
        showSuccess();
        return;
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public void onFinish(OPullRefreshLayout r1, boolean r2) {
        o.e(r1, "layout");
        ObjectAnimator r3 = this.arrowAnimator;
        if (r3 == null) goto L6;
        r3.cancel();
    L6:
        this.arrowView.setRotation(0.0f);
        this.arrowPointUp = false;
    }

    private final void showArrow() {
        this.progressBar.setVisibility(8);
        this.successView.setVisibility(8);
        this.arrowView.setVisibility(0);
    }

    private final void showProgress() {
        this.successView.setVisibility(8);
        this.arrowView.setVisibility(8);
        this.progressBar.setVisibility(0);
        setAlpha(1.0f);
    }

    private final void showSuccess() {
        this.arrowView.setVisibility(8);
        this.progressBar.setVisibility(8);
        this.successView.setVisibility(0);
        setAlpha(1.0f);
    }

    private final void rotateArrow(boolean r6, boolean r7) {
        if (this.arrowPointUp != r6) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.arrowAnimator;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        float r1 = 0.0f;
        if (r6 == false) goto L12;
        float r2 = 0.0f;
    L13:
        if (r6 == false) goto L15;
        r1 = 180.0f;
    L15:
        if (r7 == false) goto L17;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.arrowView, View.ROTATION, new float[]{r2, r1});
        r8.setDuration(200);
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r8.start();
        this.arrowAnimator = r8;
    L18:
        this.arrowPointUp = r6;
        return;
    L17:
        this.arrowView.setRotation(r1);
        goto L18
    L12:
        r2 = 180.0f;
        goto L13
    }

    public static /* synthetic */ void setTexts$default(ODefaultRefreshHeader r1, CharSequence r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r10 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r11 = null;
    L14:
        r1.setTexts(r8, r9, r10, r11);
    }

    public final void setTexts(CharSequence r3, CharSequence r4, CharSequence r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L5;
        this.textPull = r7;
    L5:
        if (r8 == null) goto L7;
        this.textRelease = r8;
    L7:
        if (r9 == null) goto L9;
        this.textRefreshing = r9;
    L9:
        if (r10 == null) goto L11;
        this.textSuccess = r10;
    L11:
        TextView r11 = this.titleView;
        if (this.progressBar.getVisibility() != 0) goto L15;
        CharSequence r2 = this.textRefreshing;
    L21:
        r11.setText(r2);
        return;
    L15:
        if (this.successView.getVisibility() != 0) goto L18;
        r2 = this.textSuccess;
        goto L21
    L18:
        if (this.arrowPointUp == false) goto L20;
        r2 = this.textRelease;
        goto L21
    L20:
        r2 = this.textPull;
        goto L21
    }

    public final void setTextColor(int r1) {
        this.titleView.setTextColor(r1);
    }

    public final void setTextColor(ColorStateList r2) {
        o.e(r2, "colors");
        this.titleView.setTextColor(r2);
    }

    public final void setIconColor(int r2) {
        this.progressBar.setProcessingColor(r2);
        this.arrowView.setColorFilter(r2);
        this.successView.setColorFilter(r2);
    }

    public final void setProgressBackgroundColor(int r1) {
        this.progressBar.setProgressBackgroundColor(r1);
    }
}
