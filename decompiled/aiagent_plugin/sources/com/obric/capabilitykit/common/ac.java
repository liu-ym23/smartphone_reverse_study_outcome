package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ac implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac f32034a = null;

    static {
        f32034a = new ac();
    }

    private ac() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, CallHistoryEntity.class) == false) goto L24;
        CallHistoryEntity r1 = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r2, CallHistoryEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((((r1.getTelephones().hashCode() + 0) * 31) + r1.getCallType().name().hashCode()) * 31) + Integer.hashCode(r1.getDuration());
        String r0 = r1.getTag();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        int r4 = (((r3 * 31) + Boolean.hashCode(r1.isAIPickup())) * 31) + Boolean.hashCode(r1.getHasTranscript());
        String r5 = r1.getTranscript();
        if (r5 == null) goto L10;
        r4 = (r4 * 31) + r5.hashCode();
    L10:
        List<String> r6 = r1.getCarriers();
        if (r6 == null) goto L13;
        r4 = (r4 * 31) + r6.hashCode();
    L13:
        List<String> r7 = r1.getTodoList();
        if (r7 == null) goto L16;
        r4 = (r4 * 31) + r7.hashCode();
    L16:
        String r8 = r1.getTranscriptTitle();
        if (r8 == null) goto L19;
        r4 = (r4 * 31) + r8.hashCode();
    L19:
        String r9 = r1.getSourceNumber();
        if (r9 != null) goto L22;
        return r4;
    L22:
        return (r4 * 31) + r9.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
