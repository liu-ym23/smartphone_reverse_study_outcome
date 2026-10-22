package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes.dex */
public final class WifiParsedResult extends ParsedResult {
    private final boolean hidden;
    private final String networkEncryption;
    private final String password;
    private final String ssid;

    public WifiParsedResult(String r2, String r3, String r4) {
        this(r2, r3, r4, false);
    }

    public WifiParsedResult(String r2, String r3, String r4, boolean r5) {
        super(ParsedResultType.WIFI);
        this.ssid = r3;
        this.networkEncryption = r2;
        this.password = r4;
        this.hidden = r5;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(80);
        maybeAppend(this.ssid, r0);
        maybeAppend(this.networkEncryption, r0);
        maybeAppend(this.password, r0);
        maybeAppend(Boolean.toString(this.hidden), r0);
        return r0.toString();
    }
}
