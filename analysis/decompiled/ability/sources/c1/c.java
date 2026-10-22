package c1;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f2083a;
    public String b;
    public long c;
    public double d;
    public String e;
    public String f;
    public long g;
    public int h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2083a == cVar.f2083a && this.b.equals(cVar.b);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2083a), this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ThreadExceptionItem{threadId=");
        sb.append(this.f2083a);
        sb.append(", threadName='");
        sb.append(this.b);
        sb.append("', threadCpuTime=");
        sb.append(this.c);
        sb.append(", processCpuTime=");
        sb.append(this.g);
        sb.append(", cpuUsage=");
        sb.append(this.d);
        sb.append(", weight=");
        sb.append(this.e);
        sb.append(", nice=");
        return B7.a.o(sb, this.h, '}');
    }
}
