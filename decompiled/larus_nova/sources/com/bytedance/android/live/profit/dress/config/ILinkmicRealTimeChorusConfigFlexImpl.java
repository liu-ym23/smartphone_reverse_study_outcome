package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.LinkmicRealTimeChorusConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ILinkmicRealTimeChorusConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/m;", "", "globalValid$delegate", "Ljava/lang/Object;", "getGlobalValid", "()Ljava/lang/Boolean;", "globalValid", "", "allowListId$delegate", "getAllowListId", "()Ljava/lang/Long;", "allowListId", "", "Lcom/bytedance/android/live/profit/dress/config/ILinkmicRealTimeChorusStageFlexImpl;", "stageList$delegate", "getStageList", "()Ljava/util/List;", "stageList", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicRealTimeChorusConfigFlexImpl extends FlexModelBase<m> implements m, vh7.h {

    @SerializedName("allow_list_id")
    protected Long _$$allowListId;

    @SerializedName("global_valid")
    protected Boolean _$$globalValid;

    @SerializedName("stage_list")
    protected List<ILinkmicRealTimeChorusStageFlexImpl> _$$stageList;

    public ILinkmicRealTimeChorusConfigFlexImpl() {
        super(m.class);
    }

    @Override // com.bytedance.android.live.profit.dress.config.m
    public final Long getAllowListId() {
        return this._$$allowListId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.m
    public final Boolean getGlobalValid() {
        return this._$$globalValid;
    }

    @Override // com.bytedance.android.live.profit.dress.config.m
    public final List<ILinkmicRealTimeChorusStageFlexImpl> getStageList() {
        return this._$$stageList;
    }

    public ILinkmicRealTimeChorusConfigFlexImpl(am3.g r100) {
        super(m.class);
        this._$$stageList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$globalValid = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$allowListId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$stageList.add(new ILinkmicRealTimeChorusStageFlexImpl(r100));
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}
