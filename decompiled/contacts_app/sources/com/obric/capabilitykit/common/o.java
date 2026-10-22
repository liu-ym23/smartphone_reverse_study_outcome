package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class o implements a0 {
    public static final o a = null;

    static {
        a = new o();
    }

    private o() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof CallHistoryEntity) == false) goto L21;
        CallHistoryEntity r3 = (CallHistoryEntity) r2;
        int r1 = ((((r3.getTelephones().hashCode() + 0) * 31) + r3.getCallType().name().hashCode()) * 31) + Integer.hashCode(r3.getDuration());
        String r0 = r3.getTag();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.hashCode();
    L7:
        int r4 = (((r1 * 31) + Boolean.hashCode(r3.isAIPickup())) * 31) + Boolean.hashCode(r3.getHasTranscript());
        String r5 = r3.getTranscript();
        if (r5 == null) goto L10;
        r4 = (r4 * 31) + r5.hashCode();
    L10:
        List<String> r6 = r3.getCarriers();
        if (r6 == null) goto L13;
        r4 = (r4 * 31) + r6.hashCode();
    L13:
        List<String> r7 = r3.getTodoList();
        if (r7 == null) goto L16;
        r4 = (r4 * 31) + r7.hashCode();
    L16:
        String r8 = r3.getTranscriptTitle();
        if (r8 != null) goto L19;
        return r4;
    L19:
        return (r4 * 31) + r8.hashCode();
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }
}
