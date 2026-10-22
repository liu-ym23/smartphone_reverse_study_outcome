package com.bytedance.android.livesdkapi.interact.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/data/LinkmicAIGuestType;", "", "(Ljava/lang/String;I)V", "None", "Normal", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicAIGuestType extends Enum<LinkmicAIGuestType> {
    private static final /* synthetic */ LinkmicAIGuestType[] $VALUES = null;
    public static final LinkmicAIGuestType None = null;
    public static final LinkmicAIGuestType Normal = null;

    static {
        LinkmicAIGuestType r100 = new LinkmicAIGuestType("None", 0);
        None = r100;
        LinkmicAIGuestType r101 = new LinkmicAIGuestType("Normal", 1);
        Normal = r101;
        $VALUES = new LinkmicAIGuestType[]{r100, r101};
    }

    public static LinkmicAIGuestType valueOf(String r100) {
        return (LinkmicAIGuestType) a.a(LinkmicAIGuestType.class, r100);
    }

    public static LinkmicAIGuestType[] values() {
        return (LinkmicAIGuestType[]) $VALUES.clone();
    }

    private LinkmicAIGuestType(String r100, int r101) {
        super(r100, r101);
    }
}
