package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f32072a = null;

    static {
        f32072a = new y();
    }

    private y() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, AuditoryRecordingEntity.class) == false) goto L24;
        AuditoryRecordingEntity r1 = (AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r2, AuditoryRecordingEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((((((r1.getName().hashCode() + 0) * 31) + Integer.hashCode(r1.getState())) * 31) + r1.getFile().hashCode()) * 31) + Integer.hashCode(r1.getDuration());
        FileEntity r0 = r1.getTranscript();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        String r4 = r1.getSummary();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        List<String> r5 = r1.getTodoList();
        if (r5 == null) goto L13;
        r3 = (r3 * 31) + r5.hashCode();
    L13:
        List<Integer> r6 = r1.getMarkers();
        if (r6 == null) goto L16;
        r3 = (r3 * 31) + r6.hashCode();
    L16:
        String r7 = r1.getSourceAppName();
        if (r7 == null) goto L19;
        r3 = (r3 * 31) + r7.hashCode();
    L19:
        String r8 = r1.getSourceAppPackage();
        if (r8 != null) goto L22;
        return r3;
    L22:
        return (r3 * 31) + r8.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
