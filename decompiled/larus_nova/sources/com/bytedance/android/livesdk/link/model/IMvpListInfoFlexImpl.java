package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleArmy")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMvpListInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h7;", "", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "<set-?>", "rankList$delegate", "Ljava/lang/Object;", "getRankList", "()Ljava/util/List;", "setRankList", "(Ljava/util/List;)V", "rankList", "", "anchorId$delegate", "getAnchorId", "()Ljava/lang/String;", "anchorId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMvpListInfoFlexImpl extends FlexModelBase<h7> implements h7, vh7.h {

    @SerializedName("anchor_open_id")
    protected String _$$anchorId;

    @SerializedName(PbRequest.SwitchType.RANK_LIST)
    protected List<? extends h7.b> _$$rankList;

    public IMvpListInfoFlexImpl() {
        super(h7.class);
    }

    public IMvpListInfoFlexImpl(am3.g r100) {
        super(h7.class);
        this._$$rankList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 2) goto L8;
        this._$$rankList.add(vh7.f.a(r100, h7.b.class));
        goto L3
    L8:
        if (r102 != 5000) goto L9;
        this._$$anchorId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.h7
    public final String getAnchorId() {
        return this._$$anchorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7
    public final List<h7.b> getRankList() {
        return this._$$rankList;
    }

    @Override // com.bytedance.android.livesdk.link.model.h7
    public final void setRankList(List<? extends h7.b> r100) {
        this._$$rankList = r100;
    }
}
