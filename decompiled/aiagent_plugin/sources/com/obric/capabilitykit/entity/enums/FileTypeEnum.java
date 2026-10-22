package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum FileTypeEnum extends Enum<FileTypeEnum> {
    private static final /* synthetic */ FileTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final FileTypeEnum DIRECTORY = null;
    public static final FileTypeEnum FILE = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final FileTypeEnum a(String r3) {
            FileTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = FileTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(FileTypeEnum.class).b() + ' ');
        L9:
            return (FileTypeEnum) ZeusTransformUtils.preCheckCast(r2, FileTypeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ FileTypeEnum[] $values() {
        return new FileTypeEnum[]{FILE, DIRECTORY};
    }

    static {
        FILE = new FileTypeEnum("FILE", 0);
        DIRECTORY = new FileTypeEnum("DIRECTORY", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private FileTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static FileTypeEnum valueOf(String r2) {
        return (FileTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileTypeEnum.class, r2), FileTypeEnum.class, "com.obric.aiagent.plugin");
    }

    public static FileTypeEnum[] values() {
        return (FileTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileTypeEnum[].class, "com.obric.aiagent.plugin");
    }
}
