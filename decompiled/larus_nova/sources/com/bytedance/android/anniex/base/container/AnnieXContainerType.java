package com.bytedance.android.anniex.base.container;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "AnnieX 容器内部闭环处理，外部禁止使用")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/base/container/AnnieXContainerType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "AnnieXContainer", "AnnieXLiteContainer", "AnnieXBullet", "AnnieXLite", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXContainerType extends Enum<AnnieXContainerType> {
    public static final AnnieXContainerType AnnieXBullet = null;
    public static final AnnieXContainerType AnnieXContainer = null;
    public static final AnnieXContainerType AnnieXLite = null;
    public static final AnnieXContainerType AnnieXLiteContainer = null;
    public static final AnnieXContainerType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXContainerType[] f40273a = null;
    private final String type;

    public static AnnieXContainerType valueOf(String r100) {
        return (AnnieXContainerType) a.a(AnnieXContainerType.class, r100);
    }

    public static AnnieXContainerType[] values() {
        return (AnnieXContainerType[]) f40273a.clone();
    }

    static {
        AnnieXContainerType r100 = new AnnieXContainerType("AnnieXContainer", 0, "AnnieXContainer");
        AnnieXContainer = r100;
        AnnieXContainerType r101 = new AnnieXContainerType("AnnieXLiteContainer", 1, "AnnieXLiteContainer");
        AnnieXLiteContainer = r101;
        AnnieXContainerType r102 = new AnnieXContainerType("AnnieXBullet", 2, "AnnieXBullet");
        AnnieXBullet = r102;
        AnnieXContainerType r103 = new AnnieXContainerType("AnnieXLite", 3, "AnnieXLite");
        AnnieXLite = r103;
        AnnieXContainerType r104 = new AnnieXContainerType("UNKNOWN", 4, "UNKNOWN");
        UNKNOWN = r104;
        f40273a = new AnnieXContainerType[]{r100, r101, r102, r103, r104};
    }

    public final String getType() {
        return this.type;
    }

    public AnnieXContainerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
