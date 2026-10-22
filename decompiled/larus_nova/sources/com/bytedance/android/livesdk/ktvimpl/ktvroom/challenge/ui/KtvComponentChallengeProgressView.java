package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/ui/KtvComponentChallengeProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "", "setProgressBarRange", "challengeType", "setChallengeTypeText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentChallengeProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f144594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KtvComponentChallengeResultView f144595b;

    public static final class a {
    }

    static {
    }

    public KtvComponentChallengeProgressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvComponentChallengeProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5(int r100) {
        ProgressBar r101 = this.f144594a;
        if (r101 == null) goto L5;
        r101.setProgress(r100);
    L5:
        KtvComponentChallengeResultView r102 = this.f144595b;
        if (r102 == null) goto L40;
        ProgressBar r103 = this.f144594a;
        if (r103 == null) goto L10;
        int r104 = r103.getMax();
    L11:
        int r105 = getWidth();
        TextView r106 = r102.f144598b;
        if (r106 == null) goto L14;
        r106.setText(String.valueOf(r100));
    L14:
        if (r100 <= 0) goto L41;
        View r107 = r102.f144601e;
        ViewGroup.LayoutParams r108 = null;
        if (r107 == null) goto L18;
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
    L20:
        if ((r109 instanceof ConstraintLayout.LayoutParams) == false) goto L23;
        r108 = r109;
    L23:
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r108;
        if (r110 == null) goto L26;
        r110.rightToRight = R.id.ktv_challenging_container;
        r110.leftToLeft = R.id.ktv_challenging_container;
    L26:
        View r111 = r102.f144601e;
        if (r111 == null) goto L29;
        r111.setLayoutParams(r110);
    L29:
        View r112 = r102.f144601e;
        if (r112 == null) goto L32;
        r112.setBackgroundResource(R.drawable.ttlive_ktv_component_challenge_result_middle_arrow);
    L32:
        TextView r113 = r102.f144600d;
        if (r113 == null) goto L35;
        r113.setBackgroundResource(R.drawable.ttlive_bg_ktv_component_challenge_result);
    L35:
        View r114 = r102.f144602f;
        if (r114 == null) goto L38;
        r114.setBackgroundResource(R.drawable.ttlive_bg_ktv_component_challenge_result);
    L38:
        r102.R5(r100, r104, r105);
        return;
    L18:
        r109 = null;
        goto L20
    L41:
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public final void setChallengeTypeText(int r100) {
        KtvComponentChallengeResultView r101 = this.f144595b;
        if (r101 == null) goto L6;
        r101.setChallengeTypeText(r100);
        return;
    }

    public final void setProgressBarRange(int r100) {
        ProgressBar r101 = this.f144594a;
        if (r101 == null) goto L5;
        r101.setProgress(0);
    L5:
        ProgressBar r102 = this.f144594a;
        if (r102 == null) goto L8;
        r102.setMax(r100);
    L8:
        KtvComponentChallengeResultView r103 = this.f144595b;
        if (r103 == null) goto L12;
        r103.setProgressBarRange(r100);
        return;
    }

    public KtvComponentChallengeProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_component_challenge_progress_layout, this);
        this.f144594a = (ProgressBar) findViewById(R.id.ktv_component_challenge_progress_bar);
        this.f144595b = (KtvComponentChallengeResultView) findViewById(R.id.ktv_component_challenge_result_view);
    }

    public /* synthetic */ KtvComponentChallengeProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
