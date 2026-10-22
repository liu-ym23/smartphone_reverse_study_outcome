package com.bytedance.android.format.model.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/message/RecallMsgType;", "", "", "type", "I", "getType", "()I", "RecallType_Unknown", "RecallType_HighRisk", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RecallMsgType extends Enum<RecallMsgType> {
    public static final RecallMsgType RecallType_HighRisk = null;
    public static final RecallMsgType RecallType_Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecallMsgType[] f51362a = null;
    private final int type;

    static {
        RecallMsgType r100 = new RecallMsgType("RecallType_Unknown", 0, 0);
        RecallType_Unknown = r100;
        RecallMsgType r101 = new RecallMsgType("RecallType_HighRisk", 1, 1);
        RecallType_HighRisk = r101;
        f51362a = new RecallMsgType[]{r100, r101};
    }

    public static RecallMsgType valueOf(String r100) {
        return (RecallMsgType) a.a(RecallMsgType.class, r100);
    }

    public static RecallMsgType[] values() {
        return (RecallMsgType[]) f51362a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public RecallMsgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
