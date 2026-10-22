package com.obric.capabilitykit.common.execution.eca;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0000H\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAJob;", "Lcom/obric/capabilitykit/common/execution/eca/ECAModifiable;", "actions", "", "Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "getActions", "()Ljava/util/List;", "update", "", "another", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ECAJob extends ECAModifiable {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isDirty(@NotNull ECAJob r10) {
            return ECAModifiable.DefaultImpls.isDirty(r10);
        }

        public static boolean update(@NotNull ECAJob r10, @Nullable ECAJob r11) {
            int r12 = 0;
            if (r11 != null) goto L5;
            return false;
        L5:
            List<ECAAction> r13 = r10.getActions();
            List<ECAAction> r14 = r11.getActions();
            int r15 = Math.min(r13.size(), r14.size());
        L6:
            if (r12 >= r15) goto L9;
            r13.get(r12).mergeWith(r14.get(r12));
            r12 = r12 + 1;
            goto L6
        L9:
            if (r15 < r14.size()) goto L11;
            return true;
        L11:
            if (y.l(r13) == false) goto L17;
            r13.addAll(r14.subList(r15, r14.size()));
            return true;
        L17:
            return true;
        }
    }

    @NotNull
    List<ECAAction> getActions();

    boolean update(@Nullable ECAJob r10);
}
