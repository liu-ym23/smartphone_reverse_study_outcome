package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.SurvivalInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/l9;", "", "", "Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoRef_IAnchorInfoFlexImpl;", "anchorInfoMap$delegate", "Ljava/lang/Object;", "getAnchorInfoMap", "()Ljava/util/Map;", "anchorInfoMap", "", "stage$delegate", "getStage", "()J", "stage", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISurvivalInfoFlexImpl extends FlexModelBase<l9> implements l9, vh7.h {

    @SerializedName("open_anchor_info_map")
    protected Map<String, ISurvivalInfoRef_IAnchorInfoFlexImpl> _$$anchorInfoMap;

    @SerializedName("stage")
    protected long _$$stage;

    public ISurvivalInfoFlexImpl() {
        super(l9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.l9
    public final Map<String, ISurvivalInfoRef_IAnchorInfoFlexImpl> getAnchorInfoMap() {
        return this._$$anchorInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.l9
    public final long getStage() {
        return this._$$stage;
    }

    public ISurvivalInfoFlexImpl(am3.g r110) {
        super(l9.class);
        this._$$anchorInfoMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L28;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$stage = r110.j();
        goto L3
    L8:
        if (r101 != 5000) goto L9;
        long r103 = r110.c();
        String r104 = null;
        ISurvivalInfoRef_IAnchorInfoFlexImpl r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L19;
        if (r106 != 1) goto L15;
        r104 = am3.h.c(r110);
        goto L11
    L15:
        if (r106 != 2) goto L16;
        r105 = new ISurvivalInfoRef_IAnchorInfoFlexImpl(r110);
        goto L11
    L16:
        am3.h.e(r110);
        goto L11
    L19:
        r110.d(r103);
        Map<String, ISurvivalInfoRef_IAnchorInfoFlexImpl> r107 = this._$$anchorInfoMap;
        if (r104 == null) goto L26;
        if (r105 == null) goto L24;
        r107.put(r104, r105);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r102, r110);
        goto L3
    L28:
        r110.d(r100);
        setThreadSafe(true);
    }
}
