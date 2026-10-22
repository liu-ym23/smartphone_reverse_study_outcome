package w2;

import com.apm.insight.CrashType;
import java.io.File;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public File f6833a;
    public long b = -1;
    public long c = -1;
    public CrashType d;
    public String e;

    public d(File file, CrashType crashType) {
        this.f6833a = file;
        this.d = crashType;
        this.e = file.getName();
    }
}
