package com.bytedance.android.livesdk.overscroll.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/overscroll/view/OverScrollFooterView;", "Landroid/widget/FrameLayout;", "", "refreshing", "", "setLoading", "", "alpha", "setTextAlpha", "getTextAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrollFooterView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f154180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f154181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f154182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f154183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f154184e;

    public OverScrollFooterView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OverScrollFooterView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getTextAlpha() {
        if (this.f154184e == false) goto L7;
        TextView r100 = this.f154183d;
        if (r100 != null) goto L12;
        return 0.0f;
    L12:
        return r100.getAlpha();
    L7:
        TextView r101 = this.f154182c;
        if (r101 != null) goto L10;
        return 0.0f;
    L10:
        return r101.getAlpha();
    }

    public final void setLoading(boolean r100) {
        if (this.f154184e == false) goto L26;
        LinearLayout r101 = this.f154180a;
        if (r101 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r101);
    L7:
        TextView r102 = this.f154182c;
        if (r102 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r102);
    L10:
        if (r100 == false) goto L20;
        TextView r103 = this.f154183d;
        if (r103 == null) goto L14;
        r103.setText(s1.B(R.string.ttlive_load_more_text_loading));
    L14:
        LiveDoubleColorBallAnimationView r104 = this.f154181b;
        if (r104 == null) goto L17;
        r104.setVisibility(0);
    L17:
        LiveDoubleColorBallAnimationView r105 = this.f154181b;
        if (r105 == null) goto L33;
        r105.b();
        return;
    L33:
        return;
    L20:
        LiveDoubleColorBallAnimationView r106 = this.f154181b;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
    L23:
        TextView r107 = this.f154183d;
        if (r107 == null) goto L35;
        r107.setText(s1.B(R.string.ttlive_load_more_text_load_more));
        return;
    L35:
        return;
    L26:
        TextView r108 = this.f154182c;
        if (r108 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r108);
    L29:
        LinearLayout r109 = this.f154180a;
        if (r109 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r109);
        return;
    }

    public final void setTextAlpha(float r100) {
        if (this.f154184e == false) goto L7;
        TextView r101 = this.f154183d;
        if (r101 == null) goto L11;
        r101.setAlpha(r100);
        return;
    L11:
        return;
    L7:
        TextView r102 = this.f154182c;
        if (r102 == null) goto L13;
        r102.setAlpha(r100);
        return;
    }

    public OverScrollFooterView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f154184e = true;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_over_scroll_load_more_footer_view, this, true);
        this.f154181b = (LiveDoubleColorBallAnimationView) findViewById(R.id.double_ball_icon);
        this.f154183d = (TextView) findViewById(R.id.load_txt);
        this.f154180a = (LinearLayout) findViewById(R.id.loadmore_containner);
        this.f154182c = (TextView) findViewById(R.id.load_no_more);
        TextView r103 = this.f154183d;
        if (r103 == null) goto L6;
        r103.setText(s1.B(R.string.ttlive_load_more_text_load_more));
        return;
    }

    public /* synthetic */ OverScrollFooterView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
