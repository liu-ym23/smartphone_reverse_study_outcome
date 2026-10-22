package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum GenderEnum extends Enum<GenderEnum> {
    private static final /* synthetic */ GenderEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final GenderEnum FEMALE = null;
    public static final GenderEnum MALE = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final GenderEnum a(String r3) {
            GenderEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = GenderEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(GenderEnum.class).b() + ' ');
        L9:
            return (GenderEnum) ZeusTransformUtils.preCheckCast(r2, GenderEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ GenderEnum[] $values() {
        return new GenderEnum[]{MALE, FEMALE};
    }

    static {
        MALE = new GenderEnum("MALE", 0);
        FEMALE = new GenderEnum("FEMALE", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private GenderEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static GenderEnum valueOf(String r2) {
        return (GenderEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(GenderEnum.class, r2), GenderEnum.class, "com.obric.aiagent.plugin");
    }

    public static GenderEnum[] values() {
        return (GenderEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GenderEnum[].class, "com.obric.aiagent.plugin");
    }
}
