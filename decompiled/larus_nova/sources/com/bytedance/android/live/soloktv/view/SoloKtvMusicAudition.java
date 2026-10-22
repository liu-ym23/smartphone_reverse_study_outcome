package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/SoloKtvMusicAudition;", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getMTvMusicName", "()Landroid/widget/TextView;", "mTvMusicName", "b", "getMTvAuthorName", "mTvAuthorName", "c", "getMTvDuration", "mTvDuration", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "getMAuditionContainer", "()Landroid/view/ViewGroup;", "setMAuditionContainer", "(Landroid/view/ViewGroup;)V", "mAuditionContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvMusicAudition extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f101772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f101773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f101774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f101775d;

    public final ViewGroup getMAuditionContainer() {
        return this.f101775d;
    }

    public final TextView getMTvAuthorName() {
        return this.f101773b;
    }

    public final TextView getMTvDuration() {
        return this.f101774c;
    }

    public final TextView getMTvMusicName() {
        return this.f101772a;
    }

    public final void setMAuditionContainer(ViewGroup r100) {
        this.f101775d = r100;
    }

    public SoloKtvMusicAudition(Context r110, AttributeSet r111) {
        super(r110, r111);
        TextView r112 = new TextView(r110);
        r112.setTextSize(1, 20.0f);
        r112.setLines(1);
        r112.setMaxEms(10);
        r112.setEllipsize(TextUtils.TruncateAt.END);
        r112.setTextColor(ColorProtector.parseColor("#ffffff"));
        Unit r100 = Unit.INSTANCE;
        this.f101772a = r112;
        TextView r101 = new TextView(r110);
        r101.setTextSize(1, 14.0f);
        r101.setLines(1);
        r101.setMaxEms(10);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setTextColor(ColorProtector.parseColor("#E6ffffff"));
        this.f101773b = r101;
        TextView r102 = new TextView(r110);
        r102.setTextSize(1, 14.0f);
        r102.setTextColor(ColorProtector.parseColor("#E6ffffff"));
        this.f101774c = r102;
        setOrientation(1);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 1;
        addView(r112, r103);
        View r113 = new View(r110);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.i(1));
        r104.topMargin = UtilityKotlinExtentionsKt.i(3);
        r104.bottomMargin = UtilityKotlinExtentionsKt.i(3);
        addView(r113, r104);
        LinearLayout r114 = new LinearLayout(r110);
        this.f101775d = r114;
        r114.addView(r101);
        View r115 = new View(r114.getContext());
        r115.setBackgroundColor(ColorProtector.parseColor("#ffffff"));
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(1), -1);
        r105.leftMargin = UtilityKotlinExtentionsKt.i(3);
        r105.rightMargin = UtilityKotlinExtentionsKt.i(3);
        r105.topMargin = UtilityKotlinExtentionsKt.i(3);
        r105.bottomMargin = UtilityKotlinExtentionsKt.i(3);
        r114.addView(r115, r105);
        r114.addView(r102);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.gravity = 1;
        addView(r114, r116);
    }
}
