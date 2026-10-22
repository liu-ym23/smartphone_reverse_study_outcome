package com.bytedance.android.livehostapi.business.depend.publish;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/publish/MatchRecordStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNKONW", "FINISH", "FAIL", "CANCEL", "SUCCESS", GXAnimation.STATE_START, "PROGRESS", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MatchRecordStatus extends Enum<MatchRecordStatus> {
    private static final /* synthetic */ MatchRecordStatus[] $VALUES = null;
    public static final MatchRecordStatus CANCEL = null;
    public static final MatchRecordStatus FAIL = null;
    public static final MatchRecordStatus FINISH = null;
    public static final MatchRecordStatus PROGRESS = null;
    public static final MatchRecordStatus START = null;
    public static final MatchRecordStatus SUCCESS = null;
    public static final MatchRecordStatus UNKONW = null;
    private final int status;

    static {
        MatchRecordStatus r100 = new MatchRecordStatus("UNKONW", 0, 0);
        UNKONW = r100;
        MatchRecordStatus r101 = new MatchRecordStatus("FINISH", 1, 1);
        FINISH = r101;
        MatchRecordStatus r102 = new MatchRecordStatus("FAIL", 2, 2);
        FAIL = r102;
        MatchRecordStatus r103 = new MatchRecordStatus("CANCEL", 3, 3);
        CANCEL = r103;
        MatchRecordStatus r104 = new MatchRecordStatus("SUCCESS", 4, 4);
        SUCCESS = r104;
        MatchRecordStatus r105 = new MatchRecordStatus(GXAnimation.STATE_START, 5, 5);
        START = r105;
        MatchRecordStatus r106 = new MatchRecordStatus("PROGRESS", 6, 6);
        PROGRESS = r106;
        $VALUES = new MatchRecordStatus[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static MatchRecordStatus valueOf(String r100) {
        return (MatchRecordStatus) a.a(MatchRecordStatus.class, r100);
    }

    public static MatchRecordStatus[] values() {
        return (MatchRecordStatus[]) $VALUES.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    private MatchRecordStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
