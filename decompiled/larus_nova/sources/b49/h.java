package b49;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f17675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f17676i;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("FlowDoraImageInfo(imageUUID=");
        r100.append(this.f17668a);
        r100.append(", data=");
        byte[] r101 = this.f17669b;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.length);
    L6:
        r100.append(r102);
        r100.append(", width=");
        r100.append(this.f17670c);
        r100.append(", height=");
        r100.append(this.f17671d);
        r100.append(", format=");
        r100.append(this.f17672e);
        r100.append(", side=");
        r100.append(this.f17673f);
        r100.append(", linkType=");
        r100.append(this.f17674g);
        r100.append(", mode=");
        r100.append(this.f17676i);
        r100.append(", imageUniqueId=");
        r100.append(this.f17675h);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public h(int r100, byte[] r101, int r102, int r103, int r104, int r105, int r106, int r107, long r108) {
        this.f17668a = r100;
        this.f17669b = r101;
        this.f17670c = r102;
        this.f17671d = r103;
        this.f17672e = r104;
        this.f17673f = r105;
        this.f17674g = r106;
        this.f17675h = r108;
        this.f17676i = r107;
    }
}
