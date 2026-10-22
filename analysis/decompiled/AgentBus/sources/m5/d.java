package m5;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6392a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f6392a) {
            case 0:
                q7.k.b(str);
                if (!ga.r.g0(str, "audit-", false) || !ga.r.Z(str, ".log", false)) {
                }
                break;
            default:
                q7.k.b(str);
                if (!ga.r.g0(str, "trace-", false) || !ga.r.Z(str, ".log", false)) {
                }
                break;
        }
        return false;
    }
}
