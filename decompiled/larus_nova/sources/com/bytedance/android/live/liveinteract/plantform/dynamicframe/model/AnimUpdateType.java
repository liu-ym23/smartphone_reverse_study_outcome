package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/AnimUpdateType;", "", "START_WEBP_ANIM", "SEAT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnimUpdateType extends Enum<AnimUpdateType> {
    public static final AnimUpdateType SEAT = null;
    public static final AnimUpdateType START_WEBP_ANIM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimUpdateType[] f77071a = null;

    static {
        AnimUpdateType r100 = new AnimUpdateType("START_WEBP_ANIM", 0);
        START_WEBP_ANIM = r100;
        AnimUpdateType r101 = new AnimUpdateType("SEAT", 1);
        SEAT = r101;
        f77071a = new AnimUpdateType[]{r100, r101};
    }

    public static AnimUpdateType valueOf(String r100) {
        return (AnimUpdateType) a.a(AnimUpdateType.class, r100);
    }

    public static AnimUpdateType[] values() {
        return (AnimUpdateType[]) f77071a.clone();
    }

    public AnimUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
