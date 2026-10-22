package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f11289a = null;

    static {
        f11289a = new j();
    }

    private j() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof AlarmEntity) == false) goto L18;
        AlarmEntity r11 = (AlarmEntity) r10;
        int r12 = (((r11.getName().hashCode() * 31) + r11.getStartTime().hashCode()) * 31) + Boolean.hashCode(r11.isEnabled());
        List<Integer> r13 = r11.getRepeatDayOfWeek();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        int r14 = (r12 * 31) + Boolean.hashCode(r11.getCloseInHoliday());
        String r15 = r11.getDate();
        if (r15 == null) goto L10;
        r14 = (r14 * 31) + r15.hashCode();
    L10:
        Boolean r16 = r11.isRinging();
        if (r16 == null) goto L13;
        r14 = (r14 * 31) + Boolean.hashCode(r16.booleanValue());
    L13:
        Integer r17 = r11.getRepeatType();
        if (r17 != null) goto L16;
        return r14;
    L16:
        return (r14 * 31) + Integer.hashCode(r17.intValue());
    L18:
        throw new IllegalStateException("Check failed.");
    }
}
