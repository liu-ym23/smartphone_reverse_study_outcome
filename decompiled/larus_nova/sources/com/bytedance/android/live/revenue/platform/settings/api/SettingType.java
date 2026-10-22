package com.bytedance.android.live.revenue.platform.settings.api;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.foundation.SettingType")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/settings/api/SettingType;", "", "", "typeIndex", "I", "getTypeIndex", "()I", "INT", "DOUBLE", "ARRAY", "OBJECT", "STRING", "BOOL", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SettingType extends Enum<SettingType> {
    public static final SettingType ARRAY = null;
    public static final SettingType BOOL = null;
    public static final SettingType DOUBLE = null;
    public static final SettingType INT = null;
    public static final SettingType OBJECT = null;
    public static final SettingType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingType[] f91651a = null;
    private final int typeIndex;

    static {
        SettingType r100 = new SettingType("INT", 0, 0);
        INT = r100;
        SettingType r101 = new SettingType("DOUBLE", 1, 1);
        DOUBLE = r101;
        SettingType r102 = new SettingType("ARRAY", 2, 2);
        ARRAY = r102;
        SettingType r103 = new SettingType("OBJECT", 3, 3);
        OBJECT = r103;
        SettingType r104 = new SettingType("STRING", 4, 4);
        STRING = r104;
        SettingType r105 = new SettingType("BOOL", 5, 5);
        BOOL = r105;
        f91651a = new SettingType[]{r100, r101, r102, r103, r104, r105};
    }

    public static SettingType valueOf(String r100) {
        return (SettingType) a.a(SettingType.class, r100);
    }

    public static SettingType[] values() {
        return (SettingType[]) f91651a.clone();
    }

    public final int getTypeIndex() {
        return this.typeIndex;
    }

    public SettingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeIndex = r102;
    }
}
