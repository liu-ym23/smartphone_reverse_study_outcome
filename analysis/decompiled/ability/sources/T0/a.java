package T0;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f1194a;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;
    public boolean e;
    public boolean f;
    public long g;
    public int h;
    public int i;

    public final String toString() {
        StringBuilder sb = new StringBuilder("SlardarHandlerConfig{onceReportMaxSizeBytes=");
        sb.append(this.f1194a);
        sb.append(", reportUrlList=");
        sb.append(this.b);
        sb.append(", exceptionUrl=");
        sb.append(this.c);
        sb.append(", traceReportUrl=");
        sb.append(this.d);
        sb.append(", isEncrypt=");
        sb.append(this.e);
        sb.append(", isUploadInternalExcetpion=");
        sb.append(this.f);
        sb.append(", reportInterval=");
        sb.append(this.g);
        sb.append(", maxSizeMB=");
        sb.append(this.h);
        sb.append(", keepDays=");
        return androidx.appfunctions.metadata.a.o(sb, ", maxSizeMBToday=0}", this.i);
    }
}
