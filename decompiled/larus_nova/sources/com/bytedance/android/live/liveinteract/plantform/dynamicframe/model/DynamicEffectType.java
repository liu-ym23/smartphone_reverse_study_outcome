package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/DynamicEffectType;", "", UserProfileEvent.POSITION_NONE, "ADD_COMPOSER_COEXISTLIST", "SET_LOKI_EFFECT", "REMOVE_LOKI_EFFECT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicEffectType extends Enum<DynamicEffectType> {
    public static final DynamicEffectType ADD_COMPOSER_COEXISTLIST = null;
    public static final DynamicEffectType NONE = null;
    public static final DynamicEffectType REMOVE_LOKI_EFFECT = null;
    public static final DynamicEffectType SET_LOKI_EFFECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicEffectType[] f77073a = null;

    static {
        DynamicEffectType r100 = new DynamicEffectType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        DynamicEffectType r101 = new DynamicEffectType("ADD_COMPOSER_COEXISTLIST", 1);
        ADD_COMPOSER_COEXISTLIST = r101;
        DynamicEffectType r102 = new DynamicEffectType("SET_LOKI_EFFECT", 2);
        SET_LOKI_EFFECT = r102;
        DynamicEffectType r103 = new DynamicEffectType("REMOVE_LOKI_EFFECT", 3);
        REMOVE_LOKI_EFFECT = r103;
        f77073a = new DynamicEffectType[]{r100, r101, r102, r103};
    }

    public static DynamicEffectType valueOf(String r100) {
        return (DynamicEffectType) a.a(DynamicEffectType.class, r100);
    }

    public static DynamicEffectType[] values() {
        return (DynamicEffectType[]) f77073a.clone();
    }

    public DynamicEffectType(String r100, int r101) {
        super(r100, r101);
    }
}
