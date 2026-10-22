package C0;

import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase f306a;

    public i(WorkDatabase workDatabase, int i4) {
        if (i4 == 1) {
            this.f306a = workDatabase;
        } else {
            Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
            this.f306a = workDatabase;
        }
    }
}
