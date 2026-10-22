package com.bytedance.android.livesdk.urge;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/urge/UrgeSendGiftEventCode;", "", "SUCCESS", "CANCEL", "INSUFFICIENTFUND", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UrgeSendGiftEventCode extends Enum<UrgeSendGiftEventCode> {
    public static final UrgeSendGiftEventCode CANCEL = null;
    public static final UrgeSendGiftEventCode INSUFFICIENTFUND = null;
    public static final UrgeSendGiftEventCode SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UrgeSendGiftEventCode[] f158630a = null;

    static {
        UrgeSendGiftEventCode r100 = new UrgeSendGiftEventCode("SUCCESS", 0);
        SUCCESS = r100;
        UrgeSendGiftEventCode r101 = new UrgeSendGiftEventCode("CANCEL", 1);
        CANCEL = r101;
        UrgeSendGiftEventCode r102 = new UrgeSendGiftEventCode("INSUFFICIENTFUND", 2);
        INSUFFICIENTFUND = r102;
        f158630a = new UrgeSendGiftEventCode[]{r100, r101, r102};
    }

    public static UrgeSendGiftEventCode valueOf(String r100) {
        return (UrgeSendGiftEventCode) a.a(UrgeSendGiftEventCode.class, r100);
    }

    public static UrgeSendGiftEventCode[] values() {
        return (UrgeSendGiftEventCode[]) f158630a.clone();
    }

    public UrgeSendGiftEventCode(String r100, int r101) {
        super(r100, r101);
    }
}
