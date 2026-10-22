package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/SoloKtvMusicTimeInfoBar;", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMTvDuration", "()Landroid/widget/TextView;", "mTvDuration", "b", "getMTvCountDown", "mTvCountDown", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvMusicTimeInfoBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f101776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f101777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f101778c;

    public final TextView getMTvCountDown() {
        return (TextView) this.f101777b.getValue();
    }

    public final TextView getMTvDuration() {
        return (TextView) this.f101776a.getValue();
    }

    public SoloKtvMusicTimeInfoBar(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f101776a = LazyKt.lazy(new SoloKtvMusicTimeInfoBar$mTvDuration$2(this, r100));
        this.f101777b = LazyKt.lazy(new SoloKtvMusicTimeInfoBar$mTvCountDown$2(this, r100));
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.time_info_enable_font_scale});
        this.f101778c = r102.getBoolean(0, false);
        r102.recycle();
        setOrientation(0);
        addView(getMTvCountDown());
        View r103 = new View(r100);
        r103.setBackgroundColor(ColorProtector.parseColor("#96ffffff"));
        Unit r104 = Unit.INSTANCE;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(1), UtilityKotlinExtentionsKt.i(12));
        r105.leftMargin = UtilityKotlinExtentionsKt.i(3);
        r105.rightMargin = UtilityKotlinExtentionsKt.i(3);
        r105.topMargin = UtilityKotlinExtentionsKt.i(3);
        r105.bottomMargin = UtilityKotlinExtentionsKt.i(3);
        r105.gravity = 16;
        addView(r103, r105);
        addView(getMTvDuration());
    }
}
