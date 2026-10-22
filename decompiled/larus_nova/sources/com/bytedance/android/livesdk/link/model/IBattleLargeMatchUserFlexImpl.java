package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.LargeMatchBizExtra.LargeMatchUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleLargeMatchUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/p1;", "", "roomID$delegate", "Ljava/lang/Object;", "getRoomID", "()Ljava/lang/Long;", "roomID", "userID$delegate", "getUserID", "userID", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleLargeMatchUserFlexImpl extends FlexModelBase<p1> implements p1, vh7.h {

    @SerializedName("room_id")
    protected Long _$$roomID;

    @SerializedName("user_id")
    protected Long _$$userID;

    public IBattleLargeMatchUserFlexImpl() {
        super(p1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.p1
    public final Long getRoomID() {
        return this._$$roomID;
    }

    @Override // com.bytedance.android.livesdk.link.model.p1
    public final Long getUserID() {
        return this._$$userID;
    }

    public IBattleLargeMatchUserFlexImpl(am3.g r100) {
        super(p1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$roomID = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$userID = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
