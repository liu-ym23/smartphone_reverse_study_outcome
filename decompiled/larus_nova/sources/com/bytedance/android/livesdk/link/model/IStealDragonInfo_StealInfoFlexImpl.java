package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.StealDragonInfo.StealInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_StealInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$d;", "", "cur_top_anchor_id$delegate", "Ljava/lang/Object;", "getCur_top_anchor_id", "()Ljava/lang/String;", "cur_top_anchor_id", "", "version$delegate", "getVersion", "()J", "version", "dragonLevel$delegate", "getDragonLevel", "dragonLevel", "cur_top_anchor_open_id$delegate", "getCur_top_anchor_open_id", "cur_top_anchor_open_id", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IStealDragonInfo_StealInfoFlexImpl extends FlexModelBase<IStealDragonInfo.d> implements IStealDragonInfo.d, vh7.h {

    @SerializedName("cur_top_anchor_id")
    protected String _$$cur_top_anchor_id;

    @SerializedName("cur_top_anchor_open_id")
    protected String _$$cur_top_anchor_open_id;

    @SerializedName("dragon_level")
    protected long _$$dragonLevel;

    @SerializedName("version")
    protected long _$$version;

    public IStealDragonInfo_StealInfoFlexImpl() {
        super(IStealDragonInfo.d.class);
        this._$$cur_top_anchor_id = "";
        this._$$cur_top_anchor_open_id = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.d
    public final String getCur_top_anchor_id() {
        return this._$$cur_top_anchor_id;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.d
    public final String getCur_top_anchor_open_id() {
        return this._$$cur_top_anchor_open_id;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.d
    public final long getDragonLevel() {
        return this._$$dragonLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.d
    public final long getVersion() {
        return this._$$version;
    }

    public IStealDragonInfo_StealInfoFlexImpl(am3.g r100) {
        super(IStealDragonInfo.d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$dragonLevel = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$cur_top_anchor_id = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$version = r100.j();
        goto L3
    L12:
        if (r102 != 5001) goto L13;
        this._$$cur_top_anchor_open_id = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$cur_top_anchor_id != null) goto L22;
        this._$$cur_top_anchor_id = "";
    L22:
        if (this._$$cur_top_anchor_open_id != null) goto L40;
        this._$$cur_top_anchor_open_id = "";
        return;
    }
}
