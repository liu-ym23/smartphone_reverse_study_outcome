package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class p implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f11299a = null;

    static {
        f11299a = new p();
    }

    private p() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof CallHistoryEntity) == false) goto L21;
        CallHistoryEntity r11 = (CallHistoryEntity) r10;
        int r12 = (((r11.getTelephones().hashCode() * 31) + r11.getCallType().name().hashCode()) * 31) + Integer.hashCode(r11.getDuration());
        String r13 = r11.getTag();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        int r14 = (((r12 * 31) + Boolean.hashCode(r11.isAIPickup())) * 31) + Boolean.hashCode(r11.getHasTranscript());
        String r15 = r11.getTranscript();
        if (r15 == null) goto L10;
        r14 = (r14 * 31) + r15.hashCode();
    L10:
        List<String> r16 = r11.getCarriers();
        if (r16 == null) goto L13;
        r14 = (r14 * 31) + r16.hashCode();
    L13:
        List<String> r17 = r11.getTodoList();
        if (r17 == null) goto L16;
        r14 = (r14 * 31) + r17.hashCode();
    L16:
        String r18 = r11.getTranscriptTitle();
        if (r18 != null) goto L19;
        return r14;
    L19:
        return (r14 * 31) + r18.hashCode();
    L21:
        throw new IllegalStateException("Check failed.");
    }
}
