package com.android.ttcjpaysdk.base.smart;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.smart.CJPaySmartConfig;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oe4.b;
import oe4.d;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!J(\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J(\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R)\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/base/smart/CJPaySmartTemperatureHelper;", "Lcom/android/ttcjpaysdk/base/smart/CJPaySmartBaseHelper;", "Loe4/d;", "result", "", "", "templates", "mapResultWithTemplate", BdpAppEventConstant.PARAMS_OUTPUT, "pickTemplateByOutput", "map", "getTradePrompt", "taskName", "Loe4/b;", "callback", "", "runSmartTemperature", "processAndExtractNumber", "Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "smartConfig$delegate", "Lkotlin/Lazy;", "getSmartConfig", "()Lcom/bytedance/caijing/sdk/infra/base/api/smart/CJPaySmartConfig;", "smartConfig", "temperatureTemplates$delegate", "getTemperatureTemplates", "()Ljava/util/Map;", "temperatureTemplates", "", "getEnableSwitch", "()Z", "enableSwitch", "<init>", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJPaySmartTemperatureHelper extends CJPaySmartBaseHelper {
    public static final Companion Companion = null;
    public static final String FRONT_ICON_URL = "https://p26-infras.byteimg.com/static-assets/920430c22ed791e1ca4c1c1de2bedce4.png~tplv-49obo7mizy-image.png";
    private static final String SMART_CONFIG_AB_KEY = "caijing_llm_tempeture_config";
    private final Lazy smartConfig$delegate;
    private final Lazy temperatureTemplates$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/smart/CJPaySmartTemperatureHelper$Companion;", "", "()V", "FRONT_ICON_URL", "", "SMART_CONFIG_AB_KEY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.base.smart.CJPaySmartBaseHelper
    public boolean getEnableSwitch() {
        return true;
    }

    private final Map<String, String> getTemperatureTemplates() {
        return (Map) this.temperatureTemplates$delegate.getValue();
    }

    @Override // com.android.ttcjpaysdk.base.smart.CJPaySmartBaseHelper
    public CJPaySmartConfig getSmartConfig() {
        return (CJPaySmartConfig) this.smartConfig$delegate.getValue();
    }

    public CJPaySmartTemperatureHelper() {
        this.smartConfig$delegate = LazyKt.lazy(CJPaySmartTemperatureHelper$smartConfig$2.INSTANCE);
        this.temperatureTemplates$delegate = LazyKt.lazy(CJPaySmartTemperatureHelper$temperatureTemplates$2.INSTANCE);
    }

    public static final /* synthetic */ Map access$getTemperatureTemplates(CJPaySmartTemperatureHelper r100) {
        return r100.getTemperatureTemplates();
    }

    public final String getTradePrompt(Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "map");
        if (getEnableSwitch() == true) goto L5;
        return null;
    L5:
        String r100 = r110.get("merchant_name");
        String r101 = r110.get("trade_title");
        String r102 = r110.get("trade_desc");
        String r111 = r110.get("shop_name");
        ArrayList r103 = new ArrayList();
        boolean r112 = false;
        if (r100 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        r103.add("商户名：" + r100);
    L14:
        if (r101 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        if (r105 == true) goto L22;
        r103.add("订单标题：" + r101);
    L22:
        if (r102 != null) goto L24;
    L25:
        r112 = true;
    L26:
        if (r112 == true) goto L29;
        r103.add("订单描述：" + r102);
    L29:
        if (r103.isEmpty() == false) goto L32;
        return null;
    L32:
        return CollectionsKt.joinToString$default(r103, " ", null, null, 0, null, null, 62, null);
    L24:
        if (r102.length() != 0) goto L26;
    L16:
        if (r101.length() == 0) goto L19;
        r105 = false;
        goto L20
    L8:
        if (r100.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    public final String processAndExtractNumber(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        String r101 = StringsKt.trim(r100).toString();
        if (r101.length() >= 2) goto L7;
    L11:
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 != null) goto L14;
        int r103 = r101.length();
        int r104 = 0;
    L17:
        if (r104 >= r103) goto L22;
        if (Character.isDigit(r101.charAt(r104)) == true) goto L23;
        r104 = r104 + 1;
    L23:
        if (r104 == (-1)) goto L38;
        String r105 = r101.substring(r104);
        int r106 = r105.length();
        int r107 = 0;
    L25:
        if (r107 >= r106) goto L30;
        if (Character.isDigit(r105.charAt(r107)) == false) goto L28;
        r107 = r107 + 1;
        goto L25
    L28:
        r105 = r105.substring(0, r107);
    L30:
        Integer r108 = StringsKt.toIntOrNull(r105);
        if (r108 != null) goto L33;
        return r101;
    L33:
        return r108.toString();
    L38:
        return r101;
    L22:
        r104 = -1;
        goto L23
    L14:
        return r102.toString();
    L7:
        if (StringsKt.startsWith$default(r101, "\"", false, 2, null) == false) goto L11;
        if (StringsKt.endsWith$default(r101, "\"", false, 2, null) == false) goto L11;
        r101 = r101.substring(1, r101.length() - 1);
        goto L11
    }

    private final d mapResultWithTemplate(d r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        return null;
    L12:
        return new d(pickTemplateByOutput(processAndExtractNumber(r100.f522996a), r101), r100.f522997b, r100.f522998c);
    L4:
        if (r101.isEmpty() == true) goto L7;
        r102 = false;
        goto L8
    }

    private final String pickTemplateByOutput(String r100, Map<String, String> r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return null;
    L10:
        if (r101.isEmpty() == false) goto L13;
        return null;
    L13:
        return r101.get(StringsKt.trim(r100).toString());
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r102 = false;
        goto L8
    }

    public static final /* synthetic */ d access$mapResultWithTemplate(CJPaySmartTemperatureHelper r100, d r101, Map r102) {
        return r100.mapResultWithTemplate(r101, r102);
    }

    public final void runSmartTemperature(String r110, Map<String, String> r111, b r112) {
        Intrinsics.checkNotNullParameter(r110, "taskName");
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = getTradePrompt(r111);
        if (r100 != null) goto L5;
        return;
    L5:
        CJPaySmartBaseHelper.runSmartTask$default(this, r110, r100, r112, null, new AnonymousClass1(this), 8, null);
    }
}
