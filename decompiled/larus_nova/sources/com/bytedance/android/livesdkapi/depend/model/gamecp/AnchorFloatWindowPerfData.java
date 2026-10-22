package com.bytedance.android.livesdkapi.depend.model.gamecp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatWindowPerfData;", "", "msgWhat", "", "tempLevel", "netLevel", "micLevel", "perfLevel", "(IIIII)V", "getMicLevel", "()I", "getMsgWhat", "getNetLevel", "getPerfLevel", "getTempLevel", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorFloatWindowPerfData {
    private final int micLevel;
    private final int msgWhat;
    private final int netLevel;
    private final int perfLevel;
    private final int tempLevel;

    public final int getMicLevel() {
        return this.micLevel;
    }

    public final int getMsgWhat() {
        return this.msgWhat;
    }

    public final int getNetLevel() {
        return this.netLevel;
    }

    public final int getPerfLevel() {
        return this.perfLevel;
    }

    public final int getTempLevel() {
        return this.tempLevel;
    }

    public AnchorFloatWindowPerfData(int r100, int r101, int r102, int r103, int r104) {
        this.msgWhat = r100;
        this.tempLevel = r101;
        this.netLevel = r102;
        this.micLevel = r103;
        this.perfLevel = r104;
    }
}
