package com.bytedance.android.live.revlink.impl.mergepk.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/params/LinkmicBizType;", "", "", "type", "I", "getType", "()I", "LinkmicBizTypeUnknown", "LinkmicBizTypeOpenGame", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicBizType extends Enum<LinkmicBizType> {
    public static final LinkmicBizType LinkmicBizTypeOpenGame = null;
    public static final LinkmicBizType LinkmicBizTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicBizType[] f92673a = null;
    private final int type;

    static {
        LinkmicBizType r100 = new LinkmicBizType("LinkmicBizTypeUnknown", 0, 0);
        LinkmicBizTypeUnknown = r100;
        LinkmicBizType r101 = new LinkmicBizType("LinkmicBizTypeOpenGame", 1, 1);
        LinkmicBizTypeOpenGame = r101;
        f92673a = new LinkmicBizType[]{r100, r101};
    }

    public static LinkmicBizType valueOf(String r100) {
        return (LinkmicBizType) a.a(LinkmicBizType.class, r100);
    }

    public static LinkmicBizType[] values() {
        return (LinkmicBizType[]) f92673a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LinkmicBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
