package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.CityEffect")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R;\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/CityEffectDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/c;", "Lpy/k;", "<set-?>", "cityEffect$delegate", "Ljava/lang/Object;", "getCityEffect", "()Lpy/k;", "setCityEffect", "(Lpy/k;)V", "cityEffect", "", "city$delegate", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "city", "", "", "showEffectUserIdList$delegate", "getShowEffectUserIdList", "()Ljava/util/List;", "setShowEffectUserIdList", "(Ljava/util/List;)V", "showEffectUserIdList", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CityEffectDataFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("city")
    protected String _$$city;

    @SerializedName("effect_resource")
    protected py.k _$$cityEffect;

    @SerializedName("show_effect_user_id_list")
    protected List<Long> _$$showEffectUserIdList;

    public CityEffectDataFlexImpl() {
        super(c.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c
    public final String getCity() {
        return this._$$city;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c
    public final py.k getCityEffect() {
        return this._$$cityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c
    public final List<Long> getShowEffectUserIdList() {
        return this._$$showEffectUserIdList;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public CityEffectDataFlexImpl(am3.g r100) {
        super(c.class);
        this._$$showEffectUserIdList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$cityEffect = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$city = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$showEffectUserIdList.add(Long.valueOf(r100.j()));
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c
    public final void setCity(String r100) {
        this._$$city = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c
    public final void setCityEffect(py.k r100) {
        this._$$cityEffect = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.c
    public final void setShowEffectUserIdList(List<Long> r100) {
        this._$$showEffectUserIdList = r100;
    }
}
