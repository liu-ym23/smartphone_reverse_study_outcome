package androidx.work.impl.constraints;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(List<String> r100);

    void onAllConstraintsNotMet(List<String> r100);
}
