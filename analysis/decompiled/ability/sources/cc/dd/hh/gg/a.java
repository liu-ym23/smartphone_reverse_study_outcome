package cc.dd.hh.gg;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final File f2145a;
    public final boolean b;
    public final long c;
    public final long d;
    public final String e;
    public final long f;
    public final String g;
    public final long h;
    public final long i;

    public a(H1.a aVar) {
        this.b = aVar.f727a;
        this.c = aVar.h;
        this.d = aVar.i;
        this.f2145a = aVar.b;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.c;
        this.h = aVar.f;
        this.i = aVar.g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" heapDumpFilePath ");
        File file = this.f2145a;
        sb.append(file.getPath());
        sb.append("\n heapDumpFileSize ");
        sb.append(file.length());
        sb.append("\n referenceName ");
        sb.append(this.e);
        sb.append("\n isDebug ");
        sb.append(this.b);
        sb.append("\n currentTime ");
        sb.append(this.c);
        sb.append("\n sidTime ");
        sb.append(this.d);
        sb.append("\n watchDurationMs ");
        sb.append(this.f);
        sb.append("ms\n gcDurationMs ");
        sb.append(this.h);
        sb.append("ms\n shrinkFilePath ");
        sb.append(this.g);
        sb.append("\n heapDumpDurationMs ");
        return androidx.constraintlayout.core.dsl.a.e(this.i, "ms\n", sb);
    }
}
