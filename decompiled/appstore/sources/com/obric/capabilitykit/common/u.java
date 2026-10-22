package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CountdownEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class u implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f11306a = null;

    static {
        f11306a = new u();
    }

    private u() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof CountdownEntity) == false) goto L12;
        CountdownEntity r11 = (CountdownEntity) r10;
        int r12 = Long.hashCode(r11.getCountdownSeconds());
        String r13 = r11.getLabel();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        CountdownStatusEnum r14 = r11.getStatus();
        if (r14 != null) goto L10;
        return r12;
    L10:
        return (r12 * 31) + r14.name().hashCode();
    L12:
        throw new IllegalStateException("Check failed.");
    }
}
