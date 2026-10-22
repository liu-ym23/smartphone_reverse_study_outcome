package com.android.ttcjpaysdk.base.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u001a\b\u0002\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00110\u000eJH\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u000eJ\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJStringUtils;", "", "()V", "UNCHECK_COLOR", "", "getAgreementSpan", "Landroid/text/SpannableStringBuilder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isChecked", "", "assetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "agreementClick", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "", "guideMessage", "protocolGroupNames", "", "getColorText", "text", "color", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStringUtils {
    public static final CJStringUtils INSTANCE = null;
    private static final String UNCHECK_COLOR = "#FE2C55";

    static {
        INSTANCE = new CJStringUtils();
    }

    private CJStringUtils() {
    }

    private final SpannableStringBuilder getColorText(String r110, int r111) {
        SpannableStringBuilder r100 = new SpannableStringBuilder();
        int r101 = 0;
    L3:
        int r102 = StringsKt.indexOf$default(r110, "$$", r101, false, 4, null);
        if (r102 == (-1)) goto L5;
        r100.append(r110.substring(r101, r102));
        int r103 = r102 + 2;
        int r104 = StringsKt.indexOf$default(r110, "$$", r103, false, 4, null);
        if (r104 == (-1)) goto L8;
        String r105 = r110.substring(r103, r104);
        int r106 = r100.length();
        r100.append(r105);
        int r107 = r100.length();
        r100.setSpan(new ForegroundColorSpan(r111), r106, r107, 33);
        r101 = r104 + 2;
        goto L3
    L8:
        r100.append(r110.substring(r103));
    L9:
        return r100;
    L5:
        r100.append(r110.substring(r101));
        goto L9
    }

    public final SpannableStringBuilder getAgreementSpan(final Context r100, boolean r101, final AssetInfoBean r110, final Function1<? super ArrayList<JSONObject>, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "assetInfo");
        Intrinsics.checkNotNullParameter(r111, "agreementClick");
        String r102 = r110.asset_extension_show_info.function_guidance_material.guide_desc + ' ';
        if (r101 == false) goto L5;
        int r103 = CJPayThemeUtils.getColor(r100, R.attr.cj_pay_text_tertiary);
    L6:
        SpannableStringBuilder r104 = getColorText(r102, r103);
        int r105 = r104.length();
        HashMap<String, String> r106 = r110.asset_extension_show_info.function_guidance_material.protocol_group_names;
        Iterator<String> r107 = r106.keySet().iterator();
    L8:
        if (r107.hasNext() == false) goto L14;
        final String r108 = r107.next();
        String r109 = r106.get(r108);
        r104.append(r109);
        CJPayDebouncingClickableSpan r112 = new CJStringUtils$getAgreementSpan$2$clickableSpan$1(r100, r111, r110, r108);
        if (r109 == null) goto L12;
        int r113 = r109.length();
    L13:
        int r114 = r113 + r105;
        r104.setSpan(r112, r105, r114, 33);
        r104.append("、");
        r105 = r114 + 1;
        goto L8
    L12:
        r113 = 0;
        goto L13
    L14:
        return r104;
    L5:
        r103 = CJPayColorHelper.safeParseColor$default("#FE2C55", 0, 2, null);
        goto L6
    }

    public final SpannableStringBuilder getAgreementSpan(final Context r100, boolean r101, String r102, Map<String, String> r103, final Function1<? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "guideMessage");
        Intrinsics.checkNotNullParameter(r103, "protocolGroupNames");
        Intrinsics.checkNotNullParameter(r104, "agreementClick");
        String r105 = r102 + ' ';
        if (r101 == false) goto L5;
        int r106 = CJPayThemeUtils.getColor(r100, R.attr.cj_pay_text_tertiary);
    L6:
        SpannableStringBuilder r107 = getColorText(r105, r106);
        int r108 = r107.length();
        Iterator<Map.Entry<String, String>> r109 = r103.entrySet().iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        Map.Entry<String, String> r110 = r109.next();
        final String r111 = r110.getKey();
        String r112 = r110.getValue();
        r107.append(r112);
        CJPayDebouncingClickableSpan r113 = new CJStringUtils$getAgreementSpan$4$clickableSpan$1(r100, r104, r111);
        int r114 = r112.length() + r108;
        r107.setSpan(r113, r108, r114, 33);
        r107.append("、");
        r108 = r114 + 1;
        goto L8
    L10:
        return r107;
    L5:
        r106 = CJPayColorHelper.safeParseColor$default("#FE2C55", 0, 2, null);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpannableStringBuilder getAgreementSpan$default(CJStringUtils r100, Context r101, boolean r102, AssetInfoBean r103, Function1 r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r104 = AnonymousClass1.INSTANCE;
    L6:
        return r100.getAgreementSpan(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpannableStringBuilder getAgreementSpan$default(CJStringUtils r100, Context r101, boolean r102, String r103, Map r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L6;
        r111 = AnonymousClass3.INSTANCE;
    L6:
        return r100.getAgreementSpan(r101, r102, r103, r110, r111);
    }
}
