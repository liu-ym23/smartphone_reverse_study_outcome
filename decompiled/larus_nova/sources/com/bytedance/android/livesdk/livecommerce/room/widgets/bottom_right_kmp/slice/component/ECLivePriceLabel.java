package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component;

import android.content.Context;
import android.view.View;
import androidx.core.provider.FontsContractCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLivePriceLabel extends com.bytedance.android.ecom.arch.slice.render.elements.b<PriceView> {
    public PriceView H3;
    public Map<?, ?> I3;
    public Map<?, ?> J3;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel$b;", "", "", "fontFamily", "Ljava/lang/String;", "getFontFamily", "()Ljava/lang/String;", "", "fontSize", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "fontWeight", "b", "", "baselineOffset", "Ljava/lang/Double;", "getBaselineOffset", "()Ljava/lang/Double;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class b {

        @SerializedName("baseline_offset")
        private final Double baselineOffset;

        @SerializedName("font_family")
        private final String fontFamily;

        @SerializedName("font_size")
        private final Integer fontSize;

        @SerializedName(FontsContractCompat.Columns.WEIGHT)
        private final Integer fontWeight;

        public final Integer a() {
            return this.fontSize;
        }

        public final Integer b() {
            return this.fontWeight;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0018\u00010\fR\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0018\u00010\fR\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001a\b\u0018\u00010\fR\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R \u0010\u0016\u001a\b\u0018\u00010\fR\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R \u0010\u0018\u001a\b\u0018\u00010\fR\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel$c;", "", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "minFontScale", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel$b;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel;", "prefix", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel$b;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel$b;", "dollarTag", "b", "priceInteger", "f", "priceDecimal", "e", "suffix", ce.f26391f, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class c {

        @SerializedName("color")
        private final String color;

        @SerializedName("dollar_tag")
        private final b dollarTag;

        @SerializedName("min_font_scale")
        private final Float minFontScale;

        @SerializedName("prefix")
        private final b prefix;

        @SerializedName("decimal")
        private final b priceDecimal;

        @SerializedName("integer")
        private final b priceInteger;

        @SerializedName("suffix")
        private final b suffix;

        public final String a() {
            return this.color;
        }

        public final b b() {
            return this.dollarTag;
        }

        public final Float c() {
            return this.minFontScale;
        }

        public final b d() {
            return this.prefix;
        }

        public final b e() {
            return this.priceDecimal;
        }

        public final b f() {
            return this.priceInteger;
        }

        public final b g() {
            return this.suffix;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right_kmp/slice/component/ECLivePriceLabel$d;", "", "", "prefix", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "priceNum", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "priceStr", "c", "suffix", "e", "", "strikethrough", "Z", "d", "()Z", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class d {

        @SerializedName("prefix")
        private final String prefix;

        @SerializedName("price_num")
        private final Long priceNum;

        @SerializedName("price_str")
        private final String priceStr;

        @SerializedName("strikethrough")
        private final boolean strikethrough;

        @SerializedName("suffix")
        private final String suffix;

        public final String a() {
            return this.prefix;
        }

        public final Long b() {
            return this.priceNum;
        }

        public final String c() {
            return this.priceStr;
        }

        public final boolean d() {
            return this.strikethrough;
        }

        public final String e() {
            return this.suffix;
        }
    }

    static {
    }

    public ECLivePriceLabel(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(final Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        if (k1() != null) goto L5;
        return;
    L5:
        l1().C(new ECLivePriceLabel$onUpdateProp$1(this, r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PriceView r101 = new PriceView(r100, null, 0, 14);
        r101.C(new ECLivePriceLabel$onCreateContentView$$inlined$apply$lambda$1(this));
        Unit r102 = Unit.INSTANCE;
        this.H3 = r101;
        return r101;
    }

    public static final float o1(ECLivePriceLabel r100, b r101) {
        r100.getClass();
        if (r101 == null) goto L7;
        Integer r102 = r101.a();
        if (r102 == null) goto L7;
        return r102.intValue();
    L7:
        return 10.0f;
    }
}
