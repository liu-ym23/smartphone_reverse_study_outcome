package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k0;", "", "<init>", "()V", "", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "vendor", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Ljava/lang/String;", "DEFAULT_CAOCAO_MCP_INTEGRATION_ID", "Ljava/lang/String;", "caocaoMcpIntegrationId", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class k0 {
    public static final k0 INSTANCE = new k0();
    private static final String DEFAULT_CAOCAO_MCP_INTEGRATION_ID = "caocao-mcp";
    private static volatile String caocaoMcpIntegrationId = DEFAULT_CAOCAO_MCP_INTEGRATION_ID;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L17
            java.lang.CharSequence r0 = La.H.D1(r1)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L17
            int r1 = r0.length()
            if (r1 <= 0) goto L13
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L17
            goto L19
        L17:
            java.lang.String r0 = "caocao-mcp"
        L19:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.k0.caocaoMcpIntegrationId = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.k0.a(java.lang.String):void");
    }

    public final String b(TaxiVendorSpec vendor) {
        kotlin.jvm.internal.p.i(vendor, "vendor");
        return vendor.getPollSource() == TaxiPollSource.MCP_GATEWAY ? caocaoMcpIntegrationId : vendor.getIntegrationId();
    }
}
