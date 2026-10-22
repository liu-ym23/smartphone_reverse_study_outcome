package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f32064a = null;

    static {
        f32064a = new q();
    }

    private q() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, AlarmEntity.class) == false) goto L18;
        AlarmEntity r1 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r2, AlarmEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((((r1.getName().hashCode() + 0) * 31) + r1.getStartTime().hashCode()) * 31) + Boolean.hashCode(r1.isEnabled());
        List<Integer> r0 = r1.getRepeatDayOfWeek();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        int r4 = (r3 * 31) + Boolean.hashCode(r1.getCloseInHoliday());
        String r5 = r1.getDate();
        if (r5 == null) goto L10;
        r4 = (r4 * 31) + r5.hashCode();
    L10:
        Boolean r6 = r1.isRinging();
        if (r6 == null) goto L13;
        r4 = (r4 * 31) + Boolean.hashCode(r6.booleanValue());
    L13:
        Integer r7 = r1.getRepeatType();
        if (r7 != null) goto L16;
        return r4;
    L16:
        return (r4 * 31) + Integer.hashCode(r7.intValue());
    L18:
        throw new IllegalStateException("Check failed.".toString());
    }
}
