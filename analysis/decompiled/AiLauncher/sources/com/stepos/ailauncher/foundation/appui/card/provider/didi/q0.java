package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/q0;", "", "<init>", "()V", "", "bizChannel", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "DIDI", "Ljava/lang/String;", "CAOCAO", "PKG_DIDI", "PKG_CAOCAO", "", "DIDI_PRODUCT_CATEGORY_NAMES", "Ljava/util/Map;", "", "", "TAXI_POLL_INTERVALS_MS", "DIDI_SPEC", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "CAOCAO_SPEC", "specs", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q0 {
    public static final String CAOCAO = "caocao";
    private static final TaxiVendorSpec CAOCAO_SPEC;
    public static final String DIDI = "didi";
    private static final Map<String, String> DIDI_PRODUCT_CATEGORY_NAMES;
    private static final TaxiVendorSpec DIDI_SPEC;
    public static final q0 INSTANCE = new q0();
    private static final String PKG_CAOCAO = "cn.caocaokeji.user";
    private static final String PKG_DIDI = "com.sdu.didi.psnger";
    private static final Map<Integer, Long> TAXI_POLL_INTERVALS_MS;
    private static final Map<String, TaxiVendorSpec> specs;

    static {
        Map<String, String> mapM = kotlin.collections.a.m(Y8.j.a("1", "快车"), Y8.j.a("8", "专车"), Y8.j.a("9", "六座专车"), Y8.j.a("17", "豪华车"), Y8.j.a("191", "惊喜特价"), Y8.j.a("201", "特惠快车"));
        DIDI_PRODUCT_CATEGORY_NAMES = mapM;
        Map<Integer, Long> mapM2 = kotlin.collections.a.m(Y8.j.a(2, 5000L), Y8.j.a(3, 5000L), Y8.j.a(4, 5000L), Y8.j.a(5, 10000L));
        TAXI_POLL_INTERVALS_MS = mapM2;
        TaxiPollSource taxiPollSource = TaxiPollSource.DIDI_ADAPTER;
        int i10 = R$drawable.ic_card_didi_app;
        int i11 = R$color.card_didi_highlight;
        TaxiVendorSpec taxiVendorSpec = new TaxiVendorSpec(PKG_DIDI, true, null, true, true, false, null, null, taxiPollSource, mapM2, i10, i11, mapM, 224, null);
        DIDI_SPEC = taxiVendorSpec;
        TaxiVendorSpec taxiVendorSpec2 = new TaxiVendorSpec(PKG_CAOCAO, false, "caocao-mcp", true, false, false, null, null, TaxiPollSource.MCP_GATEWAY, mapM2, R$drawable.ic_card_caocao_app, i11, kotlin.collections.a.i(), 208, null);
        CAOCAO_SPEC = taxiVendorSpec2;
        specs = kotlin.collections.a.m(Y8.j.a(DIDI, taxiVendorSpec), Y8.j.a(CAOCAO, taxiVendorSpec2));
    }

    public final String a(String bizChannel) {
        return kotlin.jvm.internal.p.d(N5.j.INSTANCE.d(bizChannel), CAOCAO) ? "曹操出行" : "滴滴";
    }

    public final TaxiVendorSpec b(String bizChannel) {
        TaxiVendorSpec taxiVendorSpec = specs.get(N5.j.INSTANCE.d(bizChannel));
        return taxiVendorSpec == null ? DIDI_SPEC : taxiVendorSpec;
    }
}
