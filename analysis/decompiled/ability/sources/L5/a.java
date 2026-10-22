package L5;

import com.stepos.taskrobot.settingsprovider.SettingsConfig;

/* loaded from: classes3.dex */
public final class a extends b {
    public static final byte[] p = U7.a.n("; filename=");
    public final byte[] n;
    public final String o;

    public a(String str, byte[] bArr) {
        this.b = SettingsConfig.KEY_DATA;
        this.c = "application/octet-stream";
        this.d = "ISO-8859-1";
        this.e = "binary";
        if (bArr == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.o = str;
        this.n = bArr;
    }
}
