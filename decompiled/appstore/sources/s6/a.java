package s6;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f24510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f24515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f24516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f24519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f24520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f24521n;

    public a() {
        this.f24508a = false;
        this.f24509b = true;
        this.f24510c = null;
        this.f24511d = 10;
        this.f24512e = 3;
        this.f24513f = 3;
        this.f24514g = 10;
        this.f24515h = 3;
        this.f24516i = 3;
        this.f24517j = 900;
        this.f24518k = 120;
        this.f24519l = null;
        this.f24520m = 0;
        this.f24521n = 0;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(" localEnable: ");
        r10.append(this.f24508a);
        r10.append(" probeEnable: ");
        r10.append(this.f24509b);
        r10.append(" hostFilter: ");
        Map r11 = this.f24510c;
        if (r11 == null) goto L5;
        int r12 = r11.size();
    L6:
        r10.append(r12);
        r10.append(" reqTo: ");
        r10.append(this.f24511d);
        r10.append("#");
        r10.append(this.f24512e);
        r10.append("#");
        r10.append(this.f24513f);
        r10.append(" reqErr: ");
        r10.append(this.f24514g);
        r10.append("#");
        r10.append(this.f24515h);
        r10.append("#");
        r10.append(this.f24516i);
        r10.append(" updateInterval: ");
        r10.append(this.f24517j);
        r10.append(" updateRandom: ");
        r10.append(this.f24518k);
        r10.append(" httpBlack: ");
        r10.append(this.f24519l);
        return r10.toString();
    L5:
        r12 = 0;
        goto L6
    }
}
