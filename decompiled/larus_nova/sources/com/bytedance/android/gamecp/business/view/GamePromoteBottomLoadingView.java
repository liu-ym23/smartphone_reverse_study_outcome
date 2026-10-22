package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.ui.DouyinBallLoadingAnimationView;
import com.bytedance.android.gamecp.common.ui.e;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/GamePromoteBottomLoadingView;", "Landroid/widget/FrameLayout;", "", "getLoadErrorContent", "", "size", "", "setTextSize", "", "msg", "setMessage", "", "colorId", "setMessageTextColor", "setErrorTextColor", "Lkotlin/Function0;", "action", "setOnRetryClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteBottomLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DouyinBallLoadingAnimationView f56464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f56465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f56466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f56467d;

    public GamePromoteBottomLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GamePromoteBottomLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f56464a.setVisibility(8);
        this.f56465b.setVisibility(8);
        this.f56466c.setVisibility(8);
    }

    public final void b() {
        this.f56465b.setText(y0.i(R.string.ttlive_game_promote_comment_detail_no_more));
        this.f56465b.setVisibility(0);
        this.f56464a.setVisibility(8);
        this.f56466c.setVisibility(8);
    }

    public final void c() {
        this.f56466c.setVisibility(8);
        this.f56464a.setVisibility(0);
        this.f56465b.setVisibility(8);
    }

    private final CharSequence getLoadErrorContent() {
        String r100 = y0.i(R.string.gamecp_game_detail_load_more_error);
        String r101 = y0.i(R.string.gamecp_game_detail_load_more_error_reload);
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        final int r102 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        if (r102 >= 0) goto L9;
        return "";
    L9:
        final int r103 = r101.length() + r102;
        final int r104 = ColorProtector.parseColor("#04498D");
        SpannableStringBuilder r105 = new SpannableStringBuilder(r100);
        r105.setSpan(new e(r104, new GamePromoteBottomLoadingView$getLoadErrorContent$$inlined$apply$lambda$1(this, r104, r102, r103)), r102, r103, 33);
        return r105;
    L11:
        return "";
    }

    public final void setErrorTextColor(int r100) {
        this.f56466c.setTextColor(y0.c(r100));
    }

    public final void setMessage(String r100) {
        this.f56465b.setText(r100);
    }

    public final void setMessageTextColor(int r100) {
        this.f56465b.setTextColor(y0.c(r100));
    }

    public final void setOnRetryClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f56467d = r100;
    }

    public final void setTextSize(float r100) {
        this.f56465b.setTextSize(2, r100);
        this.f56466c.setTextSize(2, r100);
    }

    public GamePromoteBottomLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        DouyinBallLoadingAnimationView r103 = new DouyinBallLoadingAnimationView(r100, null, 6, 0);
        this.f56464a = r103;
        TextView r104 = new TextView(r100);
        this.f56465b = r104;
        TextView r105 = new TextView(r100);
        this.f56466c = r105;
        this.f56467d = GamePromoteBottomLoadingView$mRetryAction$1.INSTANCE;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, y0.b(60.0f));
        r106.gravity = 17;
        setLayoutParams(r106);
        r103.setVisibility(8);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(y0.b(36.0f), y0.b(36.0f));
        r107.gravity = 17;
        r103.setLayoutParams(r107);
        r104.setVisibility(8);
        r104.setTextColor(y0.c(R.color.gamecp_game_57161823));
        r104.setText(y0.i(R.string.ttlive_game_promote_comment_detail_no_more));
        r104.setTextSize(2, 14.0f);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.gravity = 17;
        r104.setLayoutParams(r108);
        r105.setVisibility(8);
        r105.setTextColor(y0.c(R.color.gamecp_game_66161823));
        r105.setText(getLoadErrorContent());
        r105.setTextSize(2, 12.0f);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.gravity = 17;
        r105.setLayoutParams(r109);
        r105.setMovementMethod(LinkMovementMethod.getInstance());
        addView(r103);
        addView(r104);
        addView(r105);
    }

    public /* synthetic */ GamePromoteBottomLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
