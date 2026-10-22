package com.bytedance.android.live.matchroom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/matchroom/MatchLandFullShadowLinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/matchroom/c;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getInputColors", "()Ljava/lang/String;", "setInputColors", "(Ljava/lang/String;)V", "inputColors", "b", "getInputPositions", "setInputPositions", "inputPositions", "", "c", "Z", "getEnableShader", "()Z", "setEnableShader", "(Z)V", "enableShader", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchLandFullShadowLinearLayout extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f82828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f82829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f82830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f82831d;

    public MatchLandFullShadowLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MatchLandFullShadowLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.live.matchroom.c
    public boolean getEnableShader() {
        return this.f82830c;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public String getInputColors() {
        return this.f82828a;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public String getInputPositions() {
        return this.f82829b;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getEnableShader() == false) goto L5;
        setBackground(null);
    L5:
        Paint r101 = this.f82831d;
        float r102 = getHeight();
        float r103 = getWidth();
        Intrinsics.checkNotNullParameter(r101, "paint");
        Intrinsics.checkNotNullParameter("MatchLandFullShadowLinearLayout", "logTag");
        c.a.a(this, r100, r101, r102, r103, "MatchLandFullShadowLinearLayout");
        super.onDraw(r100);
    }

    public void setEnableShader(boolean r100) {
        this.f82830c = r100;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public void setInputColors(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f82828a = r100;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public void setInputPositions(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f82829b = r100;
    }

    public MatchLandFullShadowLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f82828a = "";
        this.f82829b = "";
        this.f82830c = true;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.enableShadowDefault, R.attr.shadowColors, R.attr.shadowPositions}, r102, 0);
        String r104 = r103.getString(1);
        if (r104 != null) goto L5;
        r104 = "#00000000,#26000000,#4D000000,#73000000,#99000000,#B2000000,#C7000000,#D9000000,#E5000000";
    L5:
        setInputColors(r104);
        String r105 = r103.getString(2);
        if (r105 != null) goto L8;
        r105 = "0.0,0.11,0.21,0.32,0.45,0.58,0.7,0.84,1.0";
    L8:
        setInputPositions(r105);
        setEnableShader(r103.getBoolean(0, true));
        setWillNotDraw(false);
        this.f82831d = new Paint();
    }

    public /* synthetic */ MatchLandFullShadowLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.live.matchroom.c
    public final void Y0(Paint r100, float r101, float r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r103, "logTag");
        c.a.b(this, r100, r101, r102, r103);
    }
}
