package com.bytedance.android.livesdk.link.model.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/LinkmicAIUserType;", "", "", "type", "I", "getType", "()I", "UnknownAI", "Assistant", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicAIUserType extends Enum<LinkmicAIUserType> {
    public static final LinkmicAIUserType Assistant = null;
    public static final LinkmicAIUserType UnknownAI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicAIUserType[] f147088a = null;
    private final int type;

    static {
        LinkmicAIUserType r100 = new LinkmicAIUserType("UnknownAI", 0, 0);
        UnknownAI = r100;
        LinkmicAIUserType r101 = new LinkmicAIUserType("Assistant", 1, 1);
        Assistant = r101;
        f147088a = new LinkmicAIUserType[]{r100, r101};
    }

    public static LinkmicAIUserType valueOf(String r100) {
        return (LinkmicAIUserType) r27.a.a(LinkmicAIUserType.class, r100);
    }

    public static LinkmicAIUserType[] values() {
        return (LinkmicAIUserType[]) f147088a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LinkmicAIUserType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
