package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f32065a = null;

    static {
        f32065a = new r();
    }

    private r() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, RecordingEntity.class) == false) goto L33;
        RecordingEntity r1 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r2, RecordingEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((((r1.getName().hashCode() + 0) * 31) + r1.getFile().hashCode()) * 31) + Integer.hashCode(r1.getDuration());
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
        if (r8 == null) goto L22;
        r3 = (r3 * 31) + r8.hashCode();
    L22:
        String r9 = r1.getSourceDevice();
        if (r9 == null) goto L25;
        r3 = (r3 * 31) + r9.hashCode();
    L25:
        String r10 = r1.getRecordType();
        if (r10 == null) goto L28;
        r3 = (r3 * 31) + r10.hashCode();
    L28:
        String r11 = r1.getRecordStatus();
        if (r11 != null) goto L31;
        return r3;
    L31:
        return (r3 * 31) + r11.hashCode();
    L33:
        throw new IllegalStateException("Check failed.".toString());
    }
}
