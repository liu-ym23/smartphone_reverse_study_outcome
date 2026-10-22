package com.obric.oui.pullrefresh.header;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bg.h;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.RefreshState;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\"\u001a\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010&\u001a\u00020\u00122\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b&\u0010*J\u0015\u0010+\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b+\u0010'J\u0015\u0010,\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b,\u0010'J\u000f\u0010-\u001a\u00020\u0012H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0012H\u0002¢\u0006\u0004\b/\u0010.J\u000f\u00100\u001a\u00020\u0012H\u0002¢\u0006\u0004\b0\u0010.J\u001f\u00103\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u00104R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00106R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u00106R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010=R\u0016\u0010@\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010?R\u0016\u0010B\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010F\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010?R\u0016\u0010I\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lcom/obric/oui/pullrefresh/header/ODefaultRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "layout", "", "fraction", "offsetY", "headerHeight", "", "onPulling", "(Lcom/obric/oui/pullrefresh/OPullRefreshLayout;FFF)V", "Lcom/obric/oui/pullrefresh/RefreshState;", "oldState", "newState", "onStateChanged", "(Lcom/obric/oui/pullrefresh/OPullRefreshLayout;Lcom/obric/oui/pullrefresh/RefreshState;Lcom/obric/oui/pullrefresh/RefreshState;)V", "", "success", "onFinish", "(Lcom/obric/oui/pullrefresh/OPullRefreshLayout;Z)V", "", "pull", "release", "refreshing", "b", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "color", "setTextColor", "(I)V", "Landroid/content/res/ColorStateList;", "colors", "(Landroid/content/res/ColorStateList;)V", "setIconColor", "setProgressBackgroundColor", "c", "()V", "d", "e", "pointUp", "withAnim", "a", "(ZZ)V", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "arrowView", "successView", "Lcom/obric/oui/progress/ODownloadProgressView;", "Lcom/obric/oui/progress/ODownloadProgressView;", "progressBar", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "Ljava/lang/CharSequence;", "textPull", "f", "textRelease", "g", "textRefreshing", "h", "textSuccess", "i", "Z", "arrowPointUp", "Landroid/animation/ObjectAnimator;", "j", "Landroid/animation/ObjectAnimator;", "arrowAnimator", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODefaultRefreshHeader extends FrameLayout implements ORefreshHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f16484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f16485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ODownloadProgressView f16486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f16487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f16488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f16489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f16490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f16491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f16493j;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16494a = null;

        static {
            int[] r10 = new int[RefreshState.values().length];
            r10[RefreshState.PULL_TO_REFRESH.ordinal()] = 1;
            r10[RefreshState.IDLE.ordinal()] = 2;
            r10[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            r10[RefreshState.REFRESHING.ordinal()] = 4;
            r10[RefreshState.FINISH.ordinal()] = 5;
            f16494a = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ODefaultRefreshHeader(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public final void a(boolean r10, boolean r11) {
        if (this.f16492i != r10) goto L5;
        return;
    L5:
        ObjectAnimator r12 = this.f16493j;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        float r13 = 180.0f;
        if (r10 == false) goto L12;
        float r14 = 0.0f;
    L13:
        if (r10 == true) goto L16;
        r13 = 0.0f;
    L16:
        if (r11 == false) goto L18;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.f16484a, View.ROTATION, new float[]{r14, r13});
        r15.setDuration(200);
        r15.setInterpolator(new DecelerateInterpolator());
        r15.start();
        this.f16493j = r15;
    L19:
        this.f16492i = r10;
        return;
    L18:
        this.f16484a.setRotation(r13);
        goto L19
    L12:
        r14 = 180.0f;
        goto L13
    }

    public final void b(CharSequence r10, CharSequence r11, CharSequence r12, CharSequence r13) {
        if (r10 == null) goto L4;
        this.f16488e = r10;
    L4:
        if (r11 == null) goto L6;
        this.f16489f = r11;
    L6:
        if (r12 == null) goto L8;
        this.f16490g = r12;
    L8:
        if (r13 == null) goto L10;
        this.f16491h = r13;
    L10:
        TextView r14 = this.f16487d;
        if (this.f16486c.getVisibility() != 0) goto L14;
        CharSequence r15 = this.f16490g;
    L20:
        r14.setText(r15);
        return;
    L14:
        if (this.f16485b.getVisibility() != 0) goto L17;
        r15 = this.f16491h;
        goto L20
    L17:
        if (this.f16492i == false) goto L19;
        r15 = this.f16489f;
        goto L20
    L19:
        r15 = this.f16488e;
        goto L20
    }

    public final void c() {
        this.f16486c.setVisibility(8);
        this.f16485b.setVisibility(8);
        this.f16484a.setVisibility(0);
    }

    public final void d() {
        this.f16485b.setVisibility(8);
        this.f16484a.setVisibility(8);
        this.f16486c.setVisibility(0);
        setAlpha(1.0f);
    }

    public final void e() {
        this.f16484a.setVisibility(8);
        this.f16486c.setVisibility(8);
        this.f16485b.setVisibility(0);
        setAlpha(1.0f);
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public void onFinish(OPullRefreshLayout r10, boolean r11) {
        q.g(r10, "layout");
        ObjectAnimator r12 = this.f16493j;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        this.f16484a.setRotation(0.0f);
        this.f16492i = false;
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public void onPulling(OPullRefreshLayout r10, float r11, float r12, float r13) {
        q.g(r10, "layout");
        setAlpha(h.j(r11, 0.0f, 1.0f));
        if (r10.getState() != RefreshState.IDLE) goto L5;
    L6:
        this.f16487d.setText(this.f16488e);
        this.f16486c.setVisibility(8);
        this.f16485b.setVisibility(8);
        this.f16484a.setVisibility(0);
        if (this.f16492i == false) goto L11;
        this.f16484a.setRotation(0.0f);
        this.f16492i = false;
        return;
    L11:
        return;
    L5:
        if (r10.getState() == RefreshState.PULL_TO_REFRESH) goto L6;
    }

    @Override // com.obric.oui.pullrefresh.header.ORefreshHeader
    public void onStateChanged(OPullRefreshLayout r10, RefreshState r11, RefreshState r12) {
        q.g(r10, "layout");
        q.g(r11, "oldState");
        q.g(r12, "newState");
        int r13 = a.f16494a[r12.ordinal()];
        boolean r14 = false;
        boolean r15 = true;
        if (r13 != 1) goto L5;
    L19:
        this.f16487d.setText(this.f16488e);
        c();
        if (r11 == RefreshState.RELEASE_TO_REFRESH) goto L23;
        r15 = false;
    L23:
        a(false, r15);
        return;
    L5:
        if (r13 == 2) goto L19;
        if (r13 != 3) goto L9;
        this.f16487d.setText(this.f16489f);
        c();
        if (r11 != RefreshState.PULL_TO_REFRESH) goto L18;
        r14 = true;
    L18:
        a(true, r14);
        return;
    L9:
        if (r13 != 4) goto L11;
        this.f16487d.setText(this.f16490g);
        d();
        return;
    L11:
        if (r13 != 5) goto L28;
        this.f16487d.setText(this.f16491h);
        e();
        return;
    }

    public final void setIconColor(int r10) {
        this.f16486c.setProcessingColor(r10);
        this.f16484a.setColorFilter(r10);
        this.f16485b.setColorFilter(r10);
    }

    public final void setProgressBackgroundColor(int r10) {
        this.f16486c.setProgressBackgroundColor(r10);
    }

    public final void setTextColor(int r10) {
        this.f16487d.setTextColor(r10);
    }

    public /* synthetic */ ODefaultRefreshHeader(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void setTextColor(@NotNull ColorStateList r10) {
        q.g(r10, "colors");
        this.f16487d.setTextColor(r10);
    }

    @JvmOverloads
    public ODefaultRefreshHeader(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        String r12 = r10.getString(R$string.oui_pull_to_refresh);
        q.f(r12, "context.getString(R.string.oui_pull_to_refresh)");
        this.f16488e = r12;
        String r13 = r10.getString(R$string.oui_release_to_refresh);
        q.f(r13, "context.getString(R.string.oui_release_to_refresh)");
        this.f16489f = r13;
        String r14 = r10.getString(R$string.oui_refreshing);
        q.f(r14, "context.getString(R.string.oui_refreshing)");
        this.f16490g = r14;
        String r15 = r10.getString(R$string.oui_refresh_success);
        q.f(r15, "context.getString(R.string.oui_refresh_success)");
        this.f16491h = r15;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(r10).inflate(R$layout.o_pullrefresh_default_header, this, true);
        View r16 = findViewById(R$id.pr_iv_arrow);
        q.f(r16, "findViewById(R.id.pr_iv_arrow)");
        this.f16484a = (ImageView) r16;
        View r17 = findViewById(R$id.pr_iv_success);
        q.f(r17, "findViewById(R.id.pr_iv_success)");
        this.f16485b = (ImageView) r17;
        View r18 = findViewById(R$id.pr_progress);
        q.f(r18, "findViewById(R.id.pr_progress)");
        this.f16486c = (ODownloadProgressView) r18;
        View r19 = findViewById(R$id.pr_tv_title);
        q.f(r19, "findViewById(R.id.pr_tv_title)");
        this.f16487d = (TextView) r19;
        setAlpha(0.0f);
    }
}
