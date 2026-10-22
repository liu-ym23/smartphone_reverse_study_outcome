package ci0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f23841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f23842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f23843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f23845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f23847k;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AdventureLinkEngineConfig(rtcExtInfo='");
        r100.append(this.f23837a);
        r100.append("', appId='");
        r100.append(this.f23838b);
        r100.append("', vendor=");
        r100.append(this.f23839c);
        r100.append(", vendorName='");
        r100.append(this.f23840d);
        r100.append("', appSignature=");
        byte[] r101 = this.f23841e;
        if (r101 == null) goto L5;
        String r102 = Arrays.toString(r101);
    L6:
        r100.append(r102);
        r100.append(", channelId='");
        r100.append(this.f23842f);
        r100.append("', token='");
        r100.append(this.f23843g);
        r100.append("', userId='");
        r100.append(this.f23844h);
        r100.append("', interactId='");
        r100.append(this.f23845i);
        r100.append("', interactIdMode=");
        r100.append(this.f23846j);
        r100.append(", businessId='");
        r100.append(this.f23847k);
        r100.append("')");
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public a() {
        this.f23837a = "";
        this.f23838b = "";
        this.f23840d = "";
        this.f23842f = "";
        this.f23843g = "";
        this.f23844h = "";
        this.f23845i = "";
        this.f23847k = "";
    }
}
