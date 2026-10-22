package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductPriceView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f85059a;

    public final View a(int r100) {
        if (this.f85059a != null) goto L5;
        this.f85059a = new LinkedHashMap();
    L5:
        View r101 = this.f85059a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f85059a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(ProductPriceInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "priceInfo");
        String r100 = r110.currentPrefix;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        UtilityKotlinExtentionsKt.t(a(R.id.current_price_prefix));
    L13:
        String r103 = r110.currentSuffix;
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L21:
        if (r104 == false) goto L23;
        UtilityKotlinExtentionsKt.t(a(R.id.current_price_suffix));
    L24:
        String r105 = r110.currentPrice;
        if (r105 != null) goto L27;
    L30:
        boolean r106 = true;
    L32:
        if (r106 == false) goto L34;
        UtilityKotlinExtentionsKt.t(a(R.id.current_price_integer));
        UtilityKotlinExtentionsKt.t(a(R.id.current_price_decimal));
    L39:
        String r107 = r110.originalPrice;
        if (r107 != null) goto L42;
    L43:
        r101 = true;
    L45:
        if (r101 == false) goto L47;
        UtilityKotlinExtentionsKt.t(a(R.id.original_price));
        return;
    L47:
        ((TextView) a(R.id.original_price)).setText("¥" + r110.originalPrice);
        ((TextView) a(R.id.original_price)).getPaint().setFlags(17);
        UtilityKotlinExtentionsKt.w(a(R.id.original_price));
        return;
    L42:
        if (StringsKt.isBlank(r107) == false) goto L45;
    L34:
        String r108 = r110.currentPrice;
        Intrinsics.checkNotNull(r108);
        List r109 = StringsKt.split$default(r108, new String[]{"."}, false, 0, 6, null);
        if (r109.size() != 1) goto L37;
        UtilityKotlinExtentionsKt.t(a(R.id.current_price_decimal));
    L38:
        ((TextView) a(R.id.current_price_integer)).setText((CharSequence) ListProtector.get(r109, 0));
        UtilityKotlinExtentionsKt.w(a(R.id.current_price_integer));
        UtilityKotlinExtentionsKt.w(a(R.id.money_type));
        goto L39
    L37:
        ((TextView) a(R.id.current_price_decimal)).setText("." + ((String) ListProtector.get(r109, 1)));
        UtilityKotlinExtentionsKt.w(a(R.id.current_price_decimal));
        goto L38
    L27:
        if (StringsKt.isBlank(r105) == true) goto L30;
        r106 = false;
        goto L32
    L23:
        ((TextView) a(R.id.current_price_suffix)).setText(r110.currentSuffix);
        UtilityKotlinExtentionsKt.w(a(R.id.current_price_suffix));
        goto L24
    L16:
        if (StringsKt.isBlank(r103) == true) goto L19;
        r104 = false;
        goto L21
    L12:
        ((TextView) a(R.id.current_price_prefix)).setText(r110.currentPrefix);
        UtilityKotlinExtentionsKt.w(a(R.id.current_price_prefix));
        goto L13
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    public CommonProductPriceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f85059a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_miniapp_product_price_view, this);
    }
}
