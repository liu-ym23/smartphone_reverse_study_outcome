package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f11297a = null;

    static {
        f11297a = new n();
    }

    private n() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof AuditoryRecordingEntity) == false) goto L24;
        AuditoryRecordingEntity r11 = (AuditoryRecordingEntity) r10;
        int r12 = (((((r11.getName().hashCode() * 31) + Integer.hashCode(r11.getState())) * 31) + r11.getFile().hashCode()) * 31) + Integer.hashCode(r11.getDuration());
        FileEntity r13 = r11.getTranscript();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        String r14 = r11.getSummary();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.hashCode();
    L10:
        List<String> r15 = r11.getTodoList();
        if (r15 == null) goto L13;
        r12 = (r12 * 31) + r15.hashCode();
    L13:
        List<Integer> r16 = r11.getMarkers();
        if (r16 == null) goto L16;
        r12 = (r12 * 31) + r16.hashCode();
    L16:
        String r17 = r11.getSourceAppName();
        if (r17 == null) goto L19;
        r12 = (r12 * 31) + r17.hashCode();
    L19:
        String r18 = r11.getSourceAppPackage();
        if (r18 != null) goto L22;
        return r12;
    L22:
        return (r12 * 31) + r18.hashCode();
    L24:
        throw new IllegalStateException("Check failed.");
    }
}
