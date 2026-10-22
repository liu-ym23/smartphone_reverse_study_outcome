package com.obric.capabilitykit.common.execution.eca;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0000H\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAJob;", "Lcom/obric/capabilitykit/common/execution/eca/ECAModifiable;", "actions", "", "Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "getActions", "()Ljava/util/List;", "update", "", "another", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ECAJob extends ECAModifiable {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isDirty(ECAJob r0) {
            return ECAModifiable.DefaultImpls.isDirty(r0);
        }

        public static boolean update(ECAJob r4, ECAJob r5) {
            int r0 = 0;
            if (r5 != null) goto L5;
            return false;
        L5:
            List<ECAAction> r6 = r4.getActions();
            List<ECAAction> r7 = r5.getActions();
            int r1 = Math.min(r6.size(), r7.size());
        L6:
            if (r0 >= r1) goto L9;
            r6.get(r0).mergeWith(r7.get(r0));
            r0 = r0 + 1;
            goto L6
        L9:
            if (r1 < r7.size()) goto L11;
            return true;
        L11:
            if (TypeIntrinsics.isMutableList(r6) == false) goto L17;
            r6.addAll(r7.subList(r1, r7.size()));
            return true;
        L17:
            return true;
        }
    }

    List<ECAAction> getActions();

    boolean update(ECAJob r1);
}
