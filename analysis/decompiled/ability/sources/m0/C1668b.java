package m0;

/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1668b {

    /* renamed from: a, reason: collision with root package name */
    public long f5292a;
    public boolean b;
    public long c;
    public String d;
    public boolean e;
    public String f;
    public long g;
    public String h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public String f5293j;
    public boolean k;
    public String l;

    public C1668b(boolean z10, String str, long j5, long j6) {
        this.b = z10;
        this.c = j5;
        this.d = str;
        this.g = j6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BatteryLogEntity{id=");
        sb.append(this.f5292a);
        sb.append(", front=");
        sb.append(this.b);
        sb.append(", time=");
        sb.append(this.c);
        sb.append(", type='");
        sb.append(this.d);
        sb.append("', status=");
        sb.append(this.e);
        sb.append(", scene='");
        sb.append(this.f);
        sb.append("', accumulation=");
        sb.append(this.g);
        sb.append(", source='");
        sb.append(this.h);
        sb.append("', versionId=");
        sb.append(this.i);
        sb.append(", processName='");
        sb.append(this.f5293j);
        sb.append("', mainProcess=");
        sb.append(this.k);
        sb.append(", startUuid='");
        return B7.a.q(sb, this.l, "', deleteFlag=false}");
    }
}
