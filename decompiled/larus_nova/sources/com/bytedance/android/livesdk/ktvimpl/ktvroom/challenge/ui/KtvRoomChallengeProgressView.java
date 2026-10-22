package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/ui/KtvRoomChallengeProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "", "setProgressBarRange", "challengeType", "setChallengeTypeText", "", RXScreenCaptureService.KEY_INDEX, "Z", "isHideSongNameChallenging", "()Z", "setHideSongNameChallenging", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomChallengeProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f144603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f144604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f144605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f144606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f144607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f144608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f144609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f144610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f144611i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvRoomChallengeProgressView f144612a;

        public b(KtvRoomChallengeProgressView r100) {
            this.f144612a = r100;
        }

        public final void a() {
            TextView r100 = this.f144612a.f144608f;
            if (r100 == null) goto L5;
            r100.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        L5:
            TextView r101 = this.f144612a.f144608f;
            if (r101 == null) goto L8;
            r101.setSingleLine(true);
        L8:
            TextView r102 = this.f144612a.f144608f;
            if (r102 == null) goto L11;
            r102.setSelected(true);
        L11:
            TextView r103 = this.f144612a.f144608f;
            if (r103 == null) goto L14;
            r103.setEnabled(true);
        L14:
            TextView r104 = this.f144612a.f144608f;
            if (r104 == null) goto L17;
            r104.setFocusable(true);
        L17:
            TextView r105 = this.f144612a.f144608f;
            if (r105 == null) goto L21;
            r105.setFocusableInTouchMode(true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public KtvRoomChallengeProgressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvRoomChallengeProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5(long r100) {
        if (r100 > 10) goto L5;
        String r101 = "#FF3372";
    L6:
        TextView r102 = this.f144607e;
        if (r102 == null) goto L9;
        r102.setTextColor(ColorProtector.parseColor(r101));
    L9:
        TextView r103 = this.f144607e;
        if (r103 == null) goto L13;
        r103.setText(KtvUtilsKt.e(r100));
        return;
    L13:
        return;
    L5:
        r101 = CustomHeaderConfig.COLOR_LIGHT;
        goto L6
    }

    public final void S5(int r100) {
        ProgressBar r101 = this.f144603a;
        if (r101 == null) goto L5;
        r101.setProgress(r100);
    L5:
        TextView r102 = this.f144605c;
        if (r102 == null) goto L9;
        r102.setText(String.valueOf(r100));
        return;
    }

    public final void setChallengeTypeText(int r100) {
        if (r100 != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L11;
        TextView r101 = this.f144606d;
        if (r101 == null) goto L7;
        r101.setText("");
    L7:
        Drawable r102 = s1.m(R.drawable.ttlive_ktv_mv_singer_hot_icon);
        r102.setBounds(0, 0, UtilityKotlinExtentionsKt.i(15), UtilityKotlinExtentionsKt.i(15));
        TextView r103 = this.f144606d;
        if (r103 == null) goto L27;
        r103.setCompoundDrawables(r102, null, null, null);
        return;
    L27:
        return;
    L11:
        if (r100 != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L19;
        TextView r104 = this.f144606d;
        if (r104 == null) goto L15;
        r104.setCompoundDrawables(null, null, null, null);
    L15:
        TextView r105 = this.f144606d;
        if (r105 == null) goto L29;
        r105.setText(s1.B(R.string.ttlive_ktv_challenge_progress_score));
        return;
    L29:
        return;
    L19:
        if (r100 != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L31;
        TextView r106 = this.f144606d;
        if (r106 == null) goto L23;
        r106.setCompoundDrawables(null, null, null, null);
    L23:
        TextView r107 = this.f144606d;
        if (r107 == null) goto L32;
        r107.setText(s1.B(R.string.ttlive_ktv_challenge_progress_like));
        return;
    L32:
        return;
    }

    public final void setHideSongNameChallenging(boolean r100) {
        this.f144611i = r100;
    }

    public final void setProgressBarRange(int r100) {
        ProgressBar r101 = this.f144603a;
        if (r101 == null) goto L5;
        r101.setProgress(0);
    L5:
        TextView r102 = this.f144605c;
        if (r102 == null) goto L8;
        r102.setText("0");
    L8:
        ProgressBar r103 = this.f144603a;
        if (r103 == null) goto L11;
        r103.setMax(r100);
    L11:
        TextView r104 = this.f144604b;
        if (r104 == null) goto L15;
        r104.setText(HTTP.URL_DEFAULT + r100);
        return;
    }

    public final void T5(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "songName");
        TextView r102 = this.f144608f;
        if (r102 != null) goto L5;
    L10:
        TextView r103 = this.f144608f;
        if (r103 == null) goto L13;
        r103.setText(r100);
    L13:
        TextView r104 = this.f144608f;
        if (r104 == null) goto L16;
        r104.setMaxEms(5);
    L16:
        i0.c().post(new b(this));
        return;
    L5:
        if (r102.getVisibility() != 0) goto L10;
        if (r101 == true) goto L10;
        TextView r105 = this.f144608f;
        if (r105 == null) goto L10;
        r105.setVisibility(8);
        goto L10
    }

    public KtvRoomChallengeProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_room_challenge_progress_layout, this);
        this.f144603a = (ProgressBar) findViewById(R.id.ktv_challenge_progress_bar);
        this.f144604b = (TextView) findViewById(R.id.ktv_challenge_target_value);
        this.f144605c = (TextView) findViewById(R.id.ktv_challenge_current_value);
        this.f144606d = (TextView) findViewById(R.id.ktv_challenge_count_type);
        this.f144607e = (TextView) findViewById(R.id.ktv_challenge_count_down);
        this.f144608f = (TextView) findViewById(R.id.ktv_challenge_song_title);
        this.f144610h = findViewById(R.id.ktv_challenge_count_down_container);
        this.f144609g = (TextView) findViewById(R.id.ktv_challenge_result_tv);
        TextView r103 = this.f144606d;
        if (r103 == null) goto L6;
        r103.setOnClickListener(f.f144638a);
        return;
    }

    public /* synthetic */ KtvRoomChallengeProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
