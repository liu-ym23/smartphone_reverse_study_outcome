package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum CountdownStatusEnum extends Enum<CountdownStatusEnum> {
    private static final /* synthetic */ CountdownStatusEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final CountdownStatusEnum PAUSED = null;
    public static final CountdownStatusEnum RUNNING = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final CountdownStatusEnum a(String r3) {
            CountdownStatusEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = CountdownStatusEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(CountdownStatusEnum.class).b() + ' ');
        L9:
            return (CountdownStatusEnum) ZeusTransformUtils.preCheckCast(r2, CountdownStatusEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ CountdownStatusEnum[] $values() {
        return new CountdownStatusEnum[]{RUNNING, PAUSED};
    }

    static {
        RUNNING = new CountdownStatusEnum("RUNNING", 0);
        PAUSED = new CountdownStatusEnum("PAUSED", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private CountdownStatusEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CountdownStatusEnum valueOf(String r2) {
        return (CountdownStatusEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(CountdownStatusEnum.class, r2), CountdownStatusEnum.class, "com.obric.aiagent.plugin");
    }

    public static CountdownStatusEnum[] values() {
        return (CountdownStatusEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CountdownStatusEnum[].class, "com.obric.aiagent.plugin");
    }
}
