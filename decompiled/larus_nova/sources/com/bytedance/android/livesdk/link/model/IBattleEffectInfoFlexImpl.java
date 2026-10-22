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
@ProtoMessage("webcast.data.BattleEffectInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleEffectInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/e1;", "", "", "Lcom/bytedance/android/livesdk/link/model/IAnchorEffectFlexImpl;", "anchorEffectMap$delegate", "Ljava/lang/Object;", "getAnchorEffectMap", "()Ljava/util/Map;", "anchorEffectMap", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleEffectInfoFlexImpl extends FlexModelBase<e1> implements e1, vh7.h {

    @SerializedName("open_anchor_effect_map")
    protected Map<String, IAnchorEffectFlexImpl> _$$anchorEffectMap;

    public IBattleEffectInfoFlexImpl() {
        super(e1.class);
    }

    public IBattleEffectInfoFlexImpl(am3.g r110) {
        super(e1.class);
        this._$$anchorEffectMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 5000) goto L7;
        long r103 = r110.c();
        String r104 = null;
        IAnchorEffectFlexImpl r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = am3.h.c(r110);
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = new IAnchorEffectFlexImpl(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<String, IAnchorEffectFlexImpl> r107 = this._$$anchorEffectMap;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L25:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.e1
    public final Map<String, IAnchorEffectFlexImpl> getAnchorEffectMap() {
        return this._$$anchorEffectMap;
    }
}
