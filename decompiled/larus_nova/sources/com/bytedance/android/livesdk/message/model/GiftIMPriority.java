package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.GiftIMPriority")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/GiftIMPriority;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/m7;", "", "", "_queueSizes", "Ljava/util/List;", "get_queueSizes", "()Ljava/util/List;", "set_queueSizes", "(Ljava/util/List;)V", "_selfQueuePriority", "J", "get_selfQueuePriority", "()J", "set_selfQueuePriority", "(J)V", "", "_priority", "I", "get_priority", "()I", "set_priority", "(I)V", "getQueueSizes", "queueSizes", "getSelfQueuePriority", "selfQueuePriority", "getPriority", "priority", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftIMPriority extends FlexModelBase<m7> implements m7, vh7.h {

    @SerializedName("priority")
    protected int _priority;

    @SerializedName("queue_sizes")
    protected List<Long> _queueSizes;

    @SerializedName("self_queue_priority")
    protected long _selfQueuePriority;

    public GiftIMPriority() {
        super(m7.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.m7
    public int getPriority() {
        return this._priority;
    }

    @Override // com.bytedance.android.livesdk.message.model.m7
    public List<Long> getQueueSizes() {
        return this._queueSizes;
    }

    @Override // com.bytedance.android.livesdk.message.model.m7
    public long getSelfQueuePriority() {
        return this._selfQueuePriority;
    }

    public final int get_priority() {
        return this._priority;
    }

    public final List<Long> get_queueSizes() {
        return this._queueSizes;
    }

    public final long get_selfQueuePriority() {
        return this._selfQueuePriority;
    }

    public GiftIMPriority(am3.g r100) {
        super(m7.class);
        this._queueSizes = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._queueSizes.add(Long.valueOf(r100.j()));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._selfQueuePriority = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._priority = (int) r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void set_priority(int r100) {
        this._priority = r100;
    }

    public final void set_queueSizes(List<Long> r100) {
        this._queueSizes = r100;
    }

    public final void set_selfQueuePriority(long r100) {
        this._selfQueuePriority = r100;
    }
}
