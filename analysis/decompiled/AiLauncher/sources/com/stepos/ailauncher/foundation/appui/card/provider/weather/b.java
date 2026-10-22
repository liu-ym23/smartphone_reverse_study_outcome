package com.stepos.ailauncher.foundation.appui.card.provider.weather;

import N5.d;
import N5.n;
import T5.A;
import T5.B;
import T5.C;
import Z8.C1173v;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardModel;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 22\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010\u001aJ\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b)\u0010\u0017J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/b;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UxipConstants.f30680s, "c0", "(I)I", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "e0", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/a;)V", "X", "b0", "Y", ExifInterface.LONGITUDE_WEST, "a0", "Landroid/widget/ImageView;", "view", "resId", "Z", "(Landroid/widget/ImageView;I)V", "", "range", "g0", "(Ljava/lang/String;)Ljava/lang/String;", "U", "Landroid/widget/TextView;", "tv", "", "d0", "(Landroid/widget/TextView;)F", "LT5/A;", "itemBinding", "LT5/A;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends d {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int HOURLY_COLUMN_HEIGHT_WITH_POP_DP = 85;

    @Deprecated
    public static final String TEMP_UNIT = "°C";
    private A itemBinding;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/weather/b$a;", "", "<init>", "()V", "", "TEMP_UNIT", "Ljava/lang/String;", "", "HOURLY_COLUMN_HEIGHT_WITH_POP_DP", "I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
    }

    private final int c0(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    public static final void f0(b bVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        bVar.U();
    }

    @Override // N5.d
    public void C(n model) {
        p.i(model, "model");
        if (model instanceof WeatherCardModel) {
            e0();
            WeatherCardModel weatherCardModel = (WeatherCardModel) model;
            V(weatherCardModel);
            X(weatherCardModel);
            b0(weatherCardModel);
            Y(weatherCardModel);
            W(weatherCardModel);
            a0(weatherCardModel);
        }
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        p.i(container, "container");
        A aB = A.b(LayoutInflater.from(getContext()), container, true);
        p.h(aB, "inflate(...)");
        this.itemBinding = aB;
        getBinding().tvCardTitle.setVisibility(8);
        getBinding().tvCardStatus.setVisibility(8);
        A a10 = this.itemBinding;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        a10.tvWeatherTemp.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: Q5.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                com.stepos.ailauncher.foundation.appui.card.provider.weather.b.f0(this.f5425a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
    }

    public final void U() {
        int baseline;
        A a10 = this.itemBinding;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        TextView tvWeatherTemp = a10.tvWeatherTemp;
        p.h(tvWeatherTemp, "tvWeatherTemp");
        A a11 = this.itemBinding;
        if (a11 == null) {
            p.A("itemBinding");
            a11 = null;
        }
        TextView tvWeatherTempUnit = a11.tvWeatherTempUnit;
        p.h(tvWeatherTempUnit, "tvWeatherTempUnit");
        if (tvWeatherTemp.getVisibility() == 0 && tvWeatherTempUnit.getVisibility() == 0 && (baseline = tvWeatherTemp.getBaseline()) >= 0) {
            float fD0 = baseline + d0(tvWeatherTemp);
            float fD02 = (-tvWeatherTempUnit.getPaint().ascent()) + d0(tvWeatherTempUnit);
            ViewGroup.LayoutParams layoutParams = tvWeatherTempUnit.getLayoutParams();
            tvWeatherTempUnit.setTranslationY(fD0 - (((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r2.topMargin : 0) + fD02));
        }
    }

    public final void V(WeatherCardModel model) {
        if (model.getBackgroundRes() != 0) {
            A a10 = this.itemBinding;
            if (a10 == null) {
                p.A("itemBinding");
                a10 = null;
            }
            a10.llWeatherCard.setBackgroundResource(model.getBackgroundRes());
        }
    }

    public final void W(WeatherCardModel model) {
        A a10 = this.itemBinding;
        A a11 = null;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        LinearLayout llWeatherDaily = a10.llWeatherDaily;
        p.h(llWeatherDaily, "llWeatherDaily");
        llWeatherDaily.removeAllViews();
        List<WeatherCardModel.DailyItem> listE = model.e();
        if (model.getCardType() != 2 || listE.isEmpty()) {
            listE = null;
        }
        if (listE == null) {
            llWeatherDaily.setVisibility(8);
            A a12 = this.itemBinding;
            if (a12 == null) {
                p.A("itemBinding");
            } else {
                a11 = a12;
            }
            a11.vWeatherDailyHeaderDivider.setVisibility(8);
            return;
        }
        llWeatherDaily.setVisibility(0);
        A a13 = this.itemBinding;
        if (a13 == null) {
            p.A("itemBinding");
            a13 = null;
        }
        a13.vWeatherDailyHeaderDivider.setVisibility(0);
        String lifeIndexTip = model.getLifeIndexTip();
        boolean z10 = lifeIndexTip == null || lifeIndexTip.length() == 0;
        int i10 = 0;
        for (Object obj : listE) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            WeatherCardModel.DailyItem dailyItem = (WeatherCardModel.DailyItem) obj;
            B bC = B.c(LayoutInflater.from(getContext()), llWeatherDaily, false);
            p.h(bC, "inflate(...)");
            TextView tvDailyWeek = bC.tvDailyWeek;
            p.h(tvDailyWeek, "tvDailyWeek");
            n(tvDailyWeek, dailyItem.getWeekLabel());
            TextView tvDailyDate = bC.tvDailyDate;
            p.h(tvDailyDate, "tvDailyDate");
            n(tvDailyDate, dailyItem.getDateLabel());
            TextView tvDailyCondition = bC.tvDailyCondition;
            p.h(tvDailyCondition, "tvDailyCondition");
            n(tvDailyCondition, dailyItem.getConditionText());
            TextView tvDailyTempRange = bC.tvDailyTempRange;
            p.h(tvDailyTempRange, "tvDailyTempRange");
            String tempRangeText = dailyItem.getTempRangeText();
            n(tvDailyTempRange, tempRangeText != null ? g0(tempRangeText) : null);
            TextView tvDailyPop = bC.tvDailyPop;
            p.h(tvDailyPop, "tvDailyPop");
            n(tvDailyPop, dailyItem.getPopText());
            ImageView ivDailyIcon = bC.ivDailyIcon;
            p.h(ivDailyIcon, "ivDailyIcon");
            Z(ivDailyIcon, dailyItem.getIconRes());
            bC.vDailyDivider.setVisibility((i10 == C1173v.o(listE) && z10) ? 8 : 0);
            llWeatherDaily.addView(bC.b());
            i10 = i11;
        }
    }

    public final void X(WeatherCardModel model) {
        boolean z10 = model.getCardType() == 2;
        A a10 = this.itemBinding;
        A a11 = null;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        a10.groupWeatherSingleHeader.setVisibility(z10 ? 8 : 0);
        A a12 = this.itemBinding;
        if (a12 == null) {
            p.A("itemBinding");
            a12 = null;
        }
        a12.groupWeatherDailyHeader.setVisibility(z10 ? 0 : 8);
        if (z10) {
            A a13 = this.itemBinding;
            if (a13 == null) {
                p.A("itemBinding");
                a13 = null;
            }
            TextView tvWeatherDailyLocation = a13.tvWeatherDailyLocation;
            p.h(tvWeatherDailyLocation, "tvWeatherDailyLocation");
            n(tvWeatherDailyLocation, model.getLocationText());
            A a14 = this.itemBinding;
            if (a14 == null) {
                p.A("itemBinding");
            } else {
                a11 = a14;
            }
            TextView tvWeatherDayLabel = a11.tvWeatherDayLabel;
            p.h(tvWeatherDayLabel, "tvWeatherDayLabel");
            n(tvWeatherDayLabel, model.getDayLabel());
            return;
        }
        A a15 = this.itemBinding;
        if (a15 == null) {
            p.A("itemBinding");
            a15 = null;
        }
        TextView tvWeatherLocation = a15.tvWeatherLocation;
        p.h(tvWeatherLocation, "tvWeatherLocation");
        n(tvWeatherLocation, model.getLocationText());
        A a16 = this.itemBinding;
        if (a16 == null) {
            p.A("itemBinding");
        } else {
            a11 = a16;
        }
        ImageView ivWeatherIcon = a11.ivWeatherIcon;
        p.h(ivWeatherIcon, "ivWeatherIcon");
        Z(ivWeatherIcon, model.getIconRes());
    }

    public final void Y(WeatherCardModel model) {
        boolean z10;
        A a10 = this.itemBinding;
        A a11 = null;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        LinearLayout llWeatherHourly = a10.llWeatherHourly;
        p.h(llWeatherHourly, "llWeatherHourly");
        llWeatherHourly.removeAllViews();
        List<WeatherCardModel.HourlyItem> listG = model.g();
        if (model.getCardType() != 3 || listG.isEmpty()) {
            listG = null;
        }
        if (listG == null) {
            A a12 = this.itemBinding;
            if (a12 == null) {
                p.A("itemBinding");
                a12 = null;
            }
            a12.hsvWeatherHourly.setVisibility(8);
            A a13 = this.itemBinding;
            if (a13 == null) {
                p.A("itemBinding");
            } else {
                a11 = a13;
            }
            a11.vWeatherHourlyDivider.setVisibility(8);
            return;
        }
        A a14 = this.itemBinding;
        if (a14 == null) {
            p.A("itemBinding");
            a14 = null;
        }
        a14.hsvWeatherHourly.setVisibility(0);
        A a15 = this.itemBinding;
        if (a15 == null) {
            p.A("itemBinding");
        } else {
            a11 = a15;
        }
        a11.vWeatherHourlyDivider.setVisibility(0);
        List<WeatherCardModel.HourlyItem> list = listG;
        if ((list instanceof Collection) && list.isEmpty()) {
            z10 = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((WeatherCardModel.HourlyItem) it.next()).getPopText() != null) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        for (WeatherCardModel.HourlyItem hourlyItem : list) {
            C c10 = C.c(LayoutInflater.from(getContext()), llWeatherHourly, false);
            p.h(c10, "inflate(...)");
            TextView tvHourlyTime = c10.tvHourlyTime;
            p.h(tvHourlyTime, "tvHourlyTime");
            n(tvHourlyTime, hourlyItem.getTimeLabel());
            TextView tvHourlyTemp = c10.tvHourlyTemp;
            p.h(tvHourlyTemp, "tvHourlyTemp");
            n(tvHourlyTemp, hourlyItem.getTempText());
            TextView tvHourlyPop = c10.tvHourlyPop;
            p.h(tvHourlyPop, "tvHourlyPop");
            n(tvHourlyPop, hourlyItem.getPopText());
            ImageView ivHourlyIcon = c10.ivHourlyIcon;
            p.h(ivHourlyIcon, "ivHourlyIcon");
            Z(ivHourlyIcon, hourlyItem.getIconRes());
            if (z10) {
                c10.b().getLayoutParams().height = c0(85);
            }
            llWeatherHourly.addView(c10.b());
        }
    }

    public final void Z(ImageView view, int resId) {
        if (resId == 0) {
            view.setVisibility(4);
        } else {
            view.setImageResource(resId);
            view.setVisibility(0);
        }
    }

    public final void a0(WeatherCardModel model) {
        String lifeIndexTip = model.getLifeIndexTip();
        boolean z10 = true;
        int i10 = 0;
        boolean z11 = model.getCardType() == 2;
        if (lifeIndexTip != null && lifeIndexTip.length() != 0) {
            z10 = false;
        }
        A a10 = this.itemBinding;
        A a11 = null;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        a10.groupWeatherUvSingle.setVisibility((z10 || z11) ? 8 : 0);
        A a12 = this.itemBinding;
        if (a12 == null) {
            p.A("itemBinding");
            a12 = null;
        }
        a12.tvWeatherUvTipDaily.setVisibility((z10 || !z11) ? 8 : 0);
        if (!z10) {
            A a13 = this.itemBinding;
            if (a13 == null) {
                p.A("itemBinding");
                a13 = null;
            }
            a13.tvWeatherUvTipSingle.setText(lifeIndexTip);
            A a14 = this.itemBinding;
            if (a14 == null) {
                p.A("itemBinding");
                a14 = null;
            }
            a14.tvWeatherUvTipDaily.setText(lifeIndexTip);
        }
        A a15 = this.itemBinding;
        if (a15 == null) {
            p.A("itemBinding");
        } else {
            a11 = a15;
        }
        View view = a11.vWeatherBottomSpacer;
        if (z11 && z10) {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    public final void b0(WeatherCardModel model) {
        boolean z10 = model.getCardType() == 2;
        A a10 = this.itemBinding;
        A a11 = null;
        if (a10 == null) {
            p.A("itemBinding");
            a10 = null;
        }
        a10.groupWeatherSingleBody.setVisibility(z10 ? 8 : 0);
        if (z10) {
            return;
        }
        A a12 = this.itemBinding;
        if (a12 == null) {
            p.A("itemBinding");
            a12 = null;
        }
        TextView tvWeatherTemp = a12.tvWeatherTemp;
        p.h(tvWeatherTemp, "tvWeatherTemp");
        n(tvWeatherTemp, model.getTempText());
        A a13 = this.itemBinding;
        if (a13 == null) {
            p.A("itemBinding");
            a13 = null;
        }
        TextView textView = a13.tvWeatherTempUnit;
        A a14 = this.itemBinding;
        if (a14 == null) {
            p.A("itemBinding");
            a14 = null;
        }
        textView.setVisibility(a14.tvWeatherTemp.getVisibility());
        U();
        A a15 = this.itemBinding;
        if (a15 == null) {
            p.A("itemBinding");
            a15 = null;
        }
        TextView tvWeatherCondition = a15.tvWeatherCondition;
        p.h(tvWeatherCondition, "tvWeatherCondition");
        n(tvWeatherCondition, model.getConditionText());
        A a16 = this.itemBinding;
        if (a16 == null) {
            p.A("itemBinding");
            a16 = null;
        }
        TextView tvWeatherTempRange = a16.tvWeatherTempRange;
        p.h(tvWeatherTempRange, "tvWeatherTempRange");
        String tempRangeText = model.getTempRangeText();
        n(tvWeatherTempRange, tempRangeText != null ? g0(tempRangeText) : null);
        A a17 = this.itemBinding;
        if (a17 == null) {
            p.A("itemBinding");
        } else {
            a11 = a17;
        }
        TextView tvWeatherMeta = a11.tvWeatherMeta;
        p.h(tvWeatherMeta, "tvWeatherMeta");
        n(tvWeatherMeta, model.getMetaText());
    }

    public final float d0(TextView tv) {
        CharSequence text = tv.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return 0.0f;
        }
        tv.getPaint().getTextBounds(string, 0, string.length(), new Rect());
        return r0.top;
    }

    public final void e0() {
        boolean z10 = getBinding().llSearchHeader.getVisibility() == 0;
        getBinding().b().setPadding(0, z10 ? c0(12) : 0, 0, 0);
        getBinding().llLinks.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = getBinding().flCustomContent.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            int iC0 = z10 ? c0(8) : 0;
            if (marginLayoutParams.topMargin != iC0) {
                marginLayoutParams.topMargin = iC0;
                getBinding().flCustomContent.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final String g0(String range) {
        return range + " °C";
    }

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
