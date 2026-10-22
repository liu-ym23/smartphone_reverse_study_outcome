package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/ui/KtvComponentChallengeResultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "", "setProgressBarRange", "challengeType", "setChallengeTypeText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentChallengeResultView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f144596g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f144597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f144598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f144599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f144600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f144601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f144602f;

    public static final class a {
    }

    static {
    }

    public KtvComponentChallengeResultView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvComponentChallengeResultView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void S5() {
        ViewGroup.LayoutParams r100 = getLayoutParams();
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r100 = null;
    L5:
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r100;
        if (r102 == null) goto L8;
        r102.rightToRight = 0;
        r102.leftToLeft = -1;
    L8:
        setLayoutParams(r102);
        setTranslationX(0.0f);
        View r103 = this.f144601e;
        if (r103 == null) goto L11;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L13:
        if ((r104 instanceof ConstraintLayout.LayoutParams) == false) goto L16;
        r101 = r104;
    L16:
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r101;
        if (r105 == null) goto L19;
        r105.rightToRight = 0;
        r105.leftToLeft = -1;
    L19:
        View r106 = this.f144601e;
        if (r106 == null) goto L22;
        r106.setLayoutParams(r105);
    L22:
        View r107 = this.f144601e;
        if (r107 == null) goto L25;
        r107.setBackgroundResource(R.drawable.ttlive_ktv_component_challenge_result_right_arrow);
    L25:
        TextView r108 = this.f144600d;
        if (r108 == null) goto L28;
        r108.setBackgroundResource(R.drawable.ttlive_bg_ktv_component_challenge_result_right);
    L28:
        View r109 = this.f144602f;
        if (r109 == null) goto L32;
        r109.setBackgroundResource(R.drawable.ttlive_bg_ktv_component_challenge_result_right);
        return;
    L32:
        return;
    L11:
        r104 = null;
        goto L13
    }

    public final void setChallengeTypeText(int r100) {
        if (r100 != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L11;
        TextView r101 = this.f144599c;
        if (r101 == null) goto L7;
        r101.setText("");
    L7:
        Drawable r102 = s1.m(R.drawable.ttlive_ktv_challenge_result_left_drawable);
        r102.setBounds(0, 0, UtilityKotlinExtentionsKt.i(11), UtilityKotlinExtentionsKt.i(11));
        TextView r103 = this.f144599c;
        if (r103 == null) goto L27;
        r103.setCompoundDrawables(r102, null, null, null);
        return;
    L27:
        return;
    L11:
        if (r100 != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L19;
        TextView r104 = this.f144599c;
        if (r104 == null) goto L15;
        r104.setCompoundDrawables(null, null, null, null);
    L15:
        TextView r105 = this.f144599c;
        if (r105 == null) goto L29;
        r105.setText(s1.B(R.string.ttlive_ktv_challenge_progress_score));
        return;
    L29:
        return;
    L19:
        if (r100 != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L31;
        TextView r106 = this.f144599c;
        if (r106 == null) goto L23;
        r106.setCompoundDrawables(null, null, null, null);
    L23:
        TextView r107 = this.f144599c;
        if (r107 == null) goto L32;
        r107.setText(s1.B(R.string.ttlive_ktv_challenge_progress_like));
        return;
    L32:
        return;
    }

    public final void setProgressBarRange(int r100) {
        TextView r101 = this.f144598b;
        if (r101 == null) goto L5;
        r101.setText("0");
    L5:
        TextView r102 = this.f144597a;
        if (r102 == null) goto L9;
        r102.setText(HTTP.URL_DEFAULT + r100);
        return;
    }

    public KtvComponentChallengeResultView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_component_challenge_result_layout, this);
        this.f144597a = (TextView) findViewById(R.id.challenge_target_value);
        this.f144598b = (TextView) findViewById(R.id.challenge_current_value);
        this.f144599c = (TextView) findViewById(R.id.challenge_count_type);
        this.f144600d = (TextView) findViewById(R.id.challenge_result_tv);
        this.f144602f = findViewById(R.id.ktv_challenging_container);
        this.f144601e = findViewById(R.id.challenge_index_view);
    }

    public final void R5(int r100, int r101, int r102) {
        if (r100 < r101) goto L4;
        int r103 = r101;
    L5:
        int r104 = r102 - (getWidth() / 2);
        int r105 = getWidth() / 2;
        float r106 = (r103 / r101) * r102;
        float r107 = r104;
        if (r106 >= r107) goto L8;
        r107 = r106;
    L8:
        float r108 = r105;
        if (r106 >= r108) goto L11;
        setTranslationX(0.0f);
        return;
    L11:
        if (r100 < r101) goto L13;
        setTranslationX(0.0f);
        S5();
        return;
    L13:
        setTranslationX(r107 - r108);
        return;
    L4:
        r103 = r100;
        goto L5
    }

    public /* synthetic */ KtvComponentChallengeResultView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
