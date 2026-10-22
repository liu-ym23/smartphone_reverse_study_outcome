package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum FormatModeEnum extends Enum<FormatModeEnum> {
    private static final /* synthetic */ FormatModeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final FormatModeEnum MARKDOWN = null;
    public static final FormatModeEnum RTF = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final FormatModeEnum a(String r3) {
            FormatModeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = FormatModeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(FormatModeEnum.class).b() + ' ');
        L9:
            return (FormatModeEnum) ZeusTransformUtils.preCheckCast(r2, FormatModeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ FormatModeEnum[] $values() {
        return new FormatModeEnum[]{MARKDOWN, RTF};
    }

    static {
        MARKDOWN = new FormatModeEnum("MARKDOWN", 0);
        RTF = new FormatModeEnum("RTF", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private FormatModeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static FormatModeEnum valueOf(String r2) {
        return (FormatModeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(FormatModeEnum.class, r2), FormatModeEnum.class, "com.obric.aiagent.plugin");
    }

    public static FormatModeEnum[] values() {
        return (FormatModeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FormatModeEnum[].class, "com.obric.aiagent.plugin");
    }
}
