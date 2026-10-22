package androidx.work.impl.constraints;

import androidx.work.impl.model.o;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/work/impl/constraints/WorkConstraintsCallback;", "", "", "Landroidx/work/impl/model/o;", "workSpecs", "", "onAllConstraintsMet", "(Ljava/util/List;)V", "onAllConstraintsNotMet", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(@NotNull List<o> r10);

    void onAllConstraintsNotMet(@NotNull List<o> r10);
}
