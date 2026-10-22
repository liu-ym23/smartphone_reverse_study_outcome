package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.MatchEffect")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/MatchEffectDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/t0;", "", "<set-?>", "showEffect$delegate", "Ljava/lang/Object;", "getShowEffect", "()Z", "setShowEffect", "(Z)V", "showEffect", "Lpy/k;", "matchEffect$delegate", "getMatchEffect", "()Lpy/k;", "setMatchEffect", "(Lpy/k;)V", "matchEffect", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MatchEffectDataFlexImpl extends FlexModelBase<t0> implements t0, vh7.h {

    @SerializedName("effect_resource")
    protected py.k _$$matchEffect;

    @SerializedName("show_effect")
    protected boolean _$$showEffect;

    public MatchEffectDataFlexImpl() {
        super(t0.class);
        this._$$showEffect = false;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, py.k] */
    public MatchEffectDataFlexImpl(am3.g r100) {
        super(t0.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$showEffect = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        if (r103 != 2) goto L9;
        this._$$matchEffect = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L25;
        this._$$showEffect = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.t0
    public final py.k getMatchEffect() {
        return this._$$matchEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.t0
    public final boolean getShowEffect() {
        return this._$$showEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.t0
    public final void setMatchEffect(py.k r100) {
        this._$$matchEffect = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.t0
    public final void setShowEffect(boolean r100) {
        this._$$showEffect = r100;
    }
}
