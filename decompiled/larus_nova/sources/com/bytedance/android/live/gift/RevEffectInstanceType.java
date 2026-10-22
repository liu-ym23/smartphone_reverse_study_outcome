package com.bytedance.android.live.gift;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/gift/RevEffectInstanceType;", "", "DEFAULT", "SPECIAL", "RENDER_FILTER", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevEffectInstanceType extends Enum<RevEffectInstanceType> {
    public static final RevEffectInstanceType DEFAULT = null;
    public static final RevEffectInstanceType RENDER_FILTER = null;
    public static final RevEffectInstanceType SPECIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevEffectInstanceType[] f69004a = null;

    static {
        RevEffectInstanceType r100 = new RevEffectInstanceType("DEFAULT", 0);
        DEFAULT = r100;
        RevEffectInstanceType r101 = new RevEffectInstanceType("SPECIAL", 1);
        SPECIAL = r101;
        RevEffectInstanceType r102 = new RevEffectInstanceType("RENDER_FILTER", 2);
        RENDER_FILTER = r102;
        f69004a = new RevEffectInstanceType[]{r100, r101, r102};
    }

    public static RevEffectInstanceType valueOf(String r100) {
        return (RevEffectInstanceType) a.a(RevEffectInstanceType.class, r100);
    }

    public static RevEffectInstanceType[] values() {
        return (RevEffectInstanceType[]) f69004a.clone();
    }

    public RevEffectInstanceType(String r100, int r101) {
        super(r100, r101);
    }
}
