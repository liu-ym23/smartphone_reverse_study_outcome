package com.bytedance.android.livesdk.ktvapi.concert_stage.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/enums/ChorusUserType;", "", "", "type", "I", "getType", "()I", "ChorusUserType_Unknow", "ChorusUserType_OnMic", "ChorusUserType_Silence", "ChorusUserType_Cdn", "ChorusUserType_Fallback", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChorusUserType extends Enum<ChorusUserType> {
    public static final ChorusUserType ChorusUserType_Cdn = null;
    public static final ChorusUserType ChorusUserType_Fallback = null;
    public static final ChorusUserType ChorusUserType_OnMic = null;
    public static final ChorusUserType ChorusUserType_Silence = null;
    public static final ChorusUserType ChorusUserType_Unknow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChorusUserType[] f142294a = null;
    private final int type;

    static {
        ChorusUserType r100 = new ChorusUserType("ChorusUserType_Unknow", 0, 0);
        ChorusUserType_Unknow = r100;
        ChorusUserType r101 = new ChorusUserType("ChorusUserType_OnMic", 1, 1);
        ChorusUserType_OnMic = r101;
        ChorusUserType r102 = new ChorusUserType("ChorusUserType_Silence", 2, 2);
        ChorusUserType_Silence = r102;
        ChorusUserType r103 = new ChorusUserType("ChorusUserType_Cdn", 3, 3);
        ChorusUserType_Cdn = r103;
        ChorusUserType r104 = new ChorusUserType("ChorusUserType_Fallback", 4, 4);
        ChorusUserType_Fallback = r104;
        f142294a = new ChorusUserType[]{r100, r101, r102, r103, r104};
    }

    public static ChorusUserType valueOf(String r100) {
        return (ChorusUserType) a.a(ChorusUserType.class, r100);
    }

    public static ChorusUserType[] values() {
        return (ChorusUserType[]) f142294a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ChorusUserType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
