package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.CountDown")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ICountDownFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/b4;", "", "timestamp$delegate", "Ljava/lang/Object;", "getTimestamp", "()Ljava/lang/Long;", "timestamp", "", "text$delegate", "getText", "()Ljava/lang/String;", "text", "endText$delegate", "getEndText", "endText", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ICountDownFlexImpl extends FlexModelBase<b4> implements b4, vh7.h {

    @SerializedName("end_text")
    protected String _$$endText;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("timestamp")
    protected Long _$$timestamp;

    public ICountDownFlexImpl() {
        super(b4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.b4
    public final String getEndText() {
        return this._$$endText;
    }

    @Override // com.bytedance.android.livesdk.link.model.b4
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.link.model.b4
    public final Long getTimestamp() {
        return this._$$timestamp;
    }

    public ICountDownFlexImpl(am3.g r100) {
        super(b4.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$text = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$timestamp = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$endText = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}
