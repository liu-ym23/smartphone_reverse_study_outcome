package com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/PRELOAD_DISABLE_REASON;", "", SocialConstants.PARAM_APP_DESC, "", "value", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getValue", "()I", "DISABLE_REASON_NONE", "DISABLE_REASON_LANDSCAPE", "DISABLE_REASON_MEMORY", "DISABLE_REASON_ANR", "DISABLE_REASON_PREDICTION", "DISABLE_REASON_DEGRADE", "DISABLE_REASON_SMART", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PRELOAD_DISABLE_REASON extends Enum<PRELOAD_DISABLE_REASON> {
    private static final /* synthetic */ PRELOAD_DISABLE_REASON[] $VALUES = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_ANR = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_DEGRADE = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_LANDSCAPE = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_MEMORY = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_NONE = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_PREDICTION = null;
    public static final PRELOAD_DISABLE_REASON DISABLE_REASON_SMART = null;
    private final String desc;
    private final int value;

    static {
        PRELOAD_DISABLE_REASON r100 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_NONE", 0, "不break", 0);
        DISABLE_REASON_NONE = r100;
        PRELOAD_DISABLE_REASON r101 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_LANDSCAPE", 1, "横屏场景屏", 1);
        DISABLE_REASON_LANDSCAPE = r101;
        PRELOAD_DISABLE_REASON r102 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_MEMORY", 2, "触发了最大内存占用", 2);
        DISABLE_REASON_MEMORY = r102;
        PRELOAD_DISABLE_REASON r103 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_ANR", 3, "快ANR场景", 3);
        DISABLE_REASON_ANR = r103;
        PRELOAD_DISABLE_REASON r104 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_PREDICTION", 4, "recommend break", 4);
        DISABLE_REASON_PREDICTION = r104;
        PRELOAD_DISABLE_REASON r105 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_DEGRADE", 5, "性能降级", 5);
        DISABLE_REASON_DEGRADE = r105;
        PRELOAD_DISABLE_REASON r106 = new PRELOAD_DISABLE_REASON("DISABLE_REASON_SMART", 6, "smart break", 6);
        DISABLE_REASON_SMART = r106;
        $VALUES = new PRELOAD_DISABLE_REASON[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static PRELOAD_DISABLE_REASON valueOf(String r100) {
        return (PRELOAD_DISABLE_REASON) a.a(PRELOAD_DISABLE_REASON.class, r100);
    }

    public static PRELOAD_DISABLE_REASON[] values() {
        return (PRELOAD_DISABLE_REASON[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    private PRELOAD_DISABLE_REASON(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.desc = r102;
        this.value = r103;
    }
}
