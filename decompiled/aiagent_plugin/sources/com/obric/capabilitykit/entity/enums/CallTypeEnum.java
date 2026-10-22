package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum CallTypeEnum extends Enum<CallTypeEnum> {
    private static final /* synthetic */ CallTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final CallTypeEnum INCOMING_CALL_ANSWERED = null;
    public static final CallTypeEnum INCOMING_CALL_MISSED = null;
    public static final CallTypeEnum OUTGOING_CALL_ANSWERED = null;
    public static final CallTypeEnum OUTGOING_CALL_MISSED = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final CallTypeEnum a(String r3) {
            CallTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = CallTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(CallTypeEnum.class).b() + ' ');
        L9:
            return (CallTypeEnum) ZeusTransformUtils.preCheckCast(r2, CallTypeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ CallTypeEnum[] $values() {
        return new CallTypeEnum[]{INCOMING_CALL_ANSWERED, INCOMING_CALL_MISSED, OUTGOING_CALL_ANSWERED, OUTGOING_CALL_MISSED};
    }

    static {
        INCOMING_CALL_ANSWERED = new CallTypeEnum("INCOMING_CALL_ANSWERED", 0);
        INCOMING_CALL_MISSED = new CallTypeEnum("INCOMING_CALL_MISSED", 1);
        OUTGOING_CALL_ANSWERED = new CallTypeEnum("OUTGOING_CALL_ANSWERED", 2);
        OUTGOING_CALL_MISSED = new CallTypeEnum("OUTGOING_CALL_MISSED", 3);
        $VALUES = $values();
        Companion = new a(null);
    }

    private CallTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CallTypeEnum valueOf(String r2) {
        return (CallTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(CallTypeEnum.class, r2), CallTypeEnum.class, "com.obric.aiagent.plugin");
    }

    public static CallTypeEnum[] values() {
        return (CallTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CallTypeEnum[].class, "com.obric.aiagent.plugin");
    }
}
