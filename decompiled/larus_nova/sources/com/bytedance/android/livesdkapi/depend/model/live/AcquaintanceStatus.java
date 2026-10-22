package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AcquaintanceStatus;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "Friends", "Private", "Couples", "Bosom", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AcquaintanceStatus extends Enum<AcquaintanceStatus> {
    private static final /* synthetic */ AcquaintanceStatus[] $VALUES = null;
    public static final AcquaintanceStatus Bosom = null;
    public static final AcquaintanceStatus Couples = null;
    public static final AcquaintanceStatus Friends = null;
    public static final AcquaintanceStatus Private = null;
    private final long value;

    static {
        AcquaintanceStatus r100 = new AcquaintanceStatus("Friends", 0, 1);
        Friends = r100;
        AcquaintanceStatus r101 = new AcquaintanceStatus("Private", 1, 2);
        Private = r101;
        AcquaintanceStatus r102 = new AcquaintanceStatus("Couples", 2, 3);
        Couples = r102;
        AcquaintanceStatus r103 = new AcquaintanceStatus("Bosom", 3, 4);
        Bosom = r103;
        $VALUES = new AcquaintanceStatus[]{r100, r101, r102, r103};
    }

    public static AcquaintanceStatus valueOf(String r100) {
        return (AcquaintanceStatus) a.a(AcquaintanceStatus.class, r100);
    }

    public static AcquaintanceStatus[] values() {
        return (AcquaintanceStatus[]) $VALUES.clone();
    }

    public final long getValue() {
        return this.value;
    }

    private AcquaintanceStatus(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
