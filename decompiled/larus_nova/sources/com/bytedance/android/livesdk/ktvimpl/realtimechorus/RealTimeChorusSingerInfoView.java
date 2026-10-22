package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R,\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusSingerInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setSelfVisibility", "Lkotlin/Function0;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/a;", ce.f26395j, "Lkotlin/jvm/functions/Function0;", "getGetCurUserChorusDataCB", "()Lkotlin/jvm/functions/Function0;", "setGetCurUserChorusDataCB", "(Lkotlin/jvm/functions/Function0;)V", "getCurUserChorusDataCB", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusSingerInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f146413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f146414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f146415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f146416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f146417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NumberScrollViewFlipper f146418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f146419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f146420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f146421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a> f146422j;

    public static final class a {
    }

    static {
    }

    public RealTimeChorusSingerInfoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealTimeChorusSingerInfoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Function0<com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a> getGetCurUserChorusDataCB() {
        return this.f146422j;
    }

    public final void S5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chorusScore");
        TextView r101 = this.f146420h;
        if (r101 == null) goto L6;
        r101.setText(s1.C(R.string.ttlive_rt_chorus_chorus_score_text, new Object[]{r100}));
        return;
    }

    public final void setGetCurUserChorusDataCB(Function0<com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a> r100) {
        this.f146422j = r100;
    }

    public final void setSelfVisibility(int r100) {
        setVisibility(r100);
    }

    public final void R5(final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r110, "chorusNum");
        Intrinsics.checkNotNullParameter(r111, "colorString");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        NumberScrollViewFlipper r101 = this.f146418f;
        if (r101 == null) goto L57;
        this.f146416d = r110;
        this.f146417e = r111;
    L21:
        float r102 = 0.0f;
    L22:
        this.f146415c = r102;
        if (r102 >= this.f146414b) goto L26;
        this.f146414b = r102;
    L26:
        if (this.f146413a == false) goto L28;
        return;
    L28:
        NumberScrollViewFlipper r103 = this.f146418f;
        if (r103 == null) goto L31;
        r103.setTextColor(r111);
    L31:
        float r104 = this.f146414b;
        float r105 = this.f146415c;
        Intrinsics.checkNotNullParameter(r110, "chorusNum");
        if (StringsKt.contains(r110, "w", true) == true) goto L34;
        long r106 = d5.c(r110);
        if (100 > r106) goto L45;
        if (10000 < r106) goto L45;
        if ((r105 - r104) > 100.0f) goto L46;
    L47:
        boolean r107 = false;
    L48:
        if (r107 == false) goto L50;
        this.f146414b = r105;
    L50:
        if (r107 == true) goto L52;
        r101.a(r110, false, RealTimeChorusSingerInfoView$updateChorusNumAndTextColor$1$2.INSTANCE);
        return;
    L52:
        if (this.f146413a == true) goto L58;
        this.f146413a = true;
        r101.a(r110, true, new RealTimeChorusSingerInfoView$updateChorusNumAndTextColor$$inlined$let$lambda$1(this, r110, r111));
        return;
    L58:
        return;
    L46:
        r107 = true;
    L45:
        if ((r105 - r104) <= 10.0f) goto L47;
    L34:
        if ((r105 - r104) <= 0.1f) goto L47;
    L12:
        if (StringsKt.contains(r110, "w", true) == false) goto L18;
        int r108 = StringsKt.indexOf$default(r110, "w", 0, false, 6, null);     // Catch: Exception -> L21
        if (r110 == null) goto L17;
        String r109 = r110.substring(0, r108);     // Catch: Exception -> L21
    L19:
        r102 = CastFloatProtector.parseFloat(r109);     // Catch: Exception -> L21
        goto L22
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L21
    L18:
        r109 = r110;
        goto L19
    L57:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public RealTimeChorusSingerInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f146416d = "0";
        this.f146417e = "#ffffff";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_real_time_chorus_singer_info_layout, this);
        this.f146418f = (NumberScrollViewFlipper) findViewById(R.id.chorus_num_text_dynamic);
        TextView r103 = (TextView) findViewById(R.id.chorus_num_text);
        this.f146419g = findViewById(R.id.divider_line);
        this.f146420h = (TextView) findViewById(R.id.chorus_score);
        this.f146421i = (ImageView) findViewById(R.id.chorus_arrow);
        setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusSingerInfoView$initView$1(this)));
        R5("0", "#00FFE0");
        S5("0");
    }

    public /* synthetic */ RealTimeChorusSingerInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
