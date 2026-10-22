package com.bytedance.safetyguard.lxc.api.sidecar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum SidecarBrand extends Enum<SidecarBrand> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ SidecarBrand[] $VALUES = null;
    public static final Companion Companion = null;
    public static final SidecarBrand FEISHU = null;
    public static final SidecarBrand LARKSUITE = null;
    private final String accountsBaseUrl;
    private final String cliValue;
    private final String mcpHost;
    private final String openApiHost;
    private final String openBaseUrl;

    /* JADX INFO: compiled from: SidecarModels.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final SidecarBrand fromProduction(String r3) {
            o.e(r3, "production");
            String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            Locale r0 = Locale.US;
            o.c(r0, "US");
            String r4 = r2.toLowerCase(r0);
            o.c(r4, "toLowerCase(...)");
            switch(r4.hashCode()) {
                case -1278276362: goto L24;
                case -1243020381: goto L21;
                case 3179: goto L18;
                case 3668: goto L15;
                case 3314286: goto L12;
                case 94631255: goto L9;
                case 886643018: goto L6;
                default: goto L28;
            };
        L6:
            if (r4.equals("larksuite") == false) goto L28;
        L29:
            return SidecarBrand.LARKSUITE;
        L9:
            if (r4.equals("china") == false) goto L28;
        L26:
            return SidecarBrand.FEISHU;
        L12:
            if (r4.equals("lark") == false) goto L28;
        L15:
            if (r4.equals("sg") == false) goto L28;
        L18:
            if (r4.equals("cn") == false) goto L28;
        L21:
            if (r4.equals("global") == false) goto L28;
        L24:
            if (r4.equals("feishu") == true) goto L26;
        L28:
            throw new IllegalArgumentException("Unsupported sidecar brand: " + r3);
        }
    }

    private static final /* synthetic */ SidecarBrand[] $values() {
        return new SidecarBrand[]{FEISHU, LARKSUITE};
    }

    public static a<SidecarBrand> getEntries() {
        return $ENTRIES;
    }

    public static SidecarBrand valueOf(String r2) {
        return (SidecarBrand) ZeusTransformUtils.preCheckCast(Enum.valueOf(SidecarBrand.class, r2), SidecarBrand.class, "com.obric.aiagent.plugin");
    }

    public static SidecarBrand[] values() {
        return (SidecarBrand[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SidecarBrand[].class, "com.obric.aiagent.plugin");
    }

    private SidecarBrand(String r1, int r2, String r3, String r4, String r5, String r6, String r7) {
        super(r1, r2);
        this.openApiHost = r3;
        this.mcpHost = r4;
        this.openBaseUrl = r5;
        this.accountsBaseUrl = r6;
        this.cliValue = r7;
    }

    public final String getOpenApiHost() {
        return this.openApiHost;
    }

    public final String getMcpHost() {
        return this.mcpHost;
    }

    public final String getOpenBaseUrl() {
        return this.openBaseUrl;
    }

    public final String getAccountsBaseUrl() {
        return this.accountsBaseUrl;
    }

    public final String getCliValue() {
        return this.cliValue;
    }

    static {
        FEISHU = new SidecarBrand("FEISHU", 0, "open.feishu.cn", "mcp.feishu.cn", "https://open.feishu.cn", "https://accounts.feishu.cn", "feishu");
        LARKSUITE = new SidecarBrand("LARKSUITE", 1, "open.larksuite.com", "mcp.larksuite.com", "https://open.larksuite.com", "https://accounts.larksuite.com", "lark");
        SidecarBrand[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        Companion = new Companion(null);
    }

    public final Set<String> getSidecarAllowedHosts$safetyguard_runtime_release() {
        return ax.a(new String[]{this.openApiHost, this.mcpHost});
    }
}
