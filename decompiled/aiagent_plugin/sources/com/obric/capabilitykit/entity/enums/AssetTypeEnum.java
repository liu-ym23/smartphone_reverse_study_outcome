package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum AssetTypeEnum extends Enum<AssetTypeEnum> {
    private static final /* synthetic */ AssetTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final AssetTypeEnum PHOTO = null;
    public static final AssetTypeEnum VIDEO = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final AssetTypeEnum a(String r3) {
            AssetTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = AssetTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(AssetTypeEnum.class).b() + ' ');
        L9:
            return (AssetTypeEnum) ZeusTransformUtils.preCheckCast(r2, AssetTypeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ AssetTypeEnum[] $values() {
        return new AssetTypeEnum[]{PHOTO, VIDEO};
    }

    static {
        PHOTO = new AssetTypeEnum("PHOTO", 0);
        VIDEO = new AssetTypeEnum("VIDEO", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private AssetTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static AssetTypeEnum valueOf(String r2) {
        return (AssetTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssetTypeEnum.class, r2), AssetTypeEnum.class, "com.obric.aiagent.plugin");
    }

    public static AssetTypeEnum[] values() {
        return (AssetTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssetTypeEnum[].class, "com.obric.aiagent.plugin");
    }
}
