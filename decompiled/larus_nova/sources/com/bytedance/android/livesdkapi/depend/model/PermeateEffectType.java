package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/PermeateEffectType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "Recommend", "Campaign", "Interact", "Config", "Other", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PermeateEffectType extends Enum<PermeateEffectType> {
    private static final /* synthetic */ PermeateEffectType[] $VALUES = null;
    public static final PermeateEffectType Campaign = null;
    public static final PermeateEffectType Config = null;
    public static final PermeateEffectType Interact = null;
    public static final PermeateEffectType Other = null;
    public static final PermeateEffectType Recommend = null;
    private final String typeName;

    static {
        PermeateEffectType r100 = new PermeateEffectType("Recommend", 0, "recommend");
        Recommend = r100;
        PermeateEffectType r101 = new PermeateEffectType("Campaign", 1, "campaign");
        Campaign = r101;
        PermeateEffectType r102 = new PermeateEffectType("Interact", 2, IHostPlugin.ENTER_FROM_LINKMIC_TYPE);
        Interact = r102;
        PermeateEffectType r103 = new PermeateEffectType("Config", 3, "config");
        Config = r103;
        PermeateEffectType r104 = new PermeateEffectType("Other", 4, "other");
        Other = r104;
        $VALUES = new PermeateEffectType[]{r100, r101, r102, r103, r104};
    }

    public static PermeateEffectType valueOf(String r100) {
        return (PermeateEffectType) a.a(PermeateEffectType.class, r100);
    }

    public static PermeateEffectType[] values() {
        return (PermeateEffectType[]) $VALUES.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    private PermeateEffectType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
