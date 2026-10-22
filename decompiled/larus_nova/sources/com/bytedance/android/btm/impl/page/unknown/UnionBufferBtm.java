package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.api.model.BufferBtm;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0000J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "Ljava/io/Serializable;", "btm", "", "unionStep", "", "pageId", "bufferBtm", "Lcom/bytedance/android/btm/api/model/BufferBtm;", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/android/btm/api/model/BufferBtm;)V", "getBtm", "()Ljava/lang/String;", "getBufferBtm", "()Lcom/bytedance/android/btm/api/model/BufferBtm;", "getPageId", "getUnionStep", "()I", "copy", "toString", "btm-impl_cnRelease"}, k = 1, mv = {1, 1, 16})
public final class UnionBufferBtm implements Serializable {
    private final String btm;
    private final BufferBtm bufferBtm;
    private final String pageId;
    private final int unionStep;

    public final UnionBufferBtm copy() {
        return new UnionBufferBtm(this.btm, this.unionStep, this.pageId, this.bufferBtm);
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("btm", this.btm);     // Catch: Throwable -> L6
        r100.put("union_step", this.unionStep);     // Catch: Throwable -> L6
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, this.pageId);     // Catch: Throwable -> L6
        r100.put("buffer_btm", this.bufferBtm);     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    public final String getBtm() {
        return this.btm;
    }

    public final BufferBtm getBufferBtm() {
        return this.bufferBtm;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final int getUnionStep() {
        return this.unionStep;
    }

    public UnionBufferBtm(String r100, int r101, String r102, BufferBtm r103) {
        this.btm = r100;
        this.unionStep = r101;
        this.pageId = r102;
        this.bufferBtm = r103;
    }
}
