package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.AnchorEffect")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR)\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorEffectFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/j;", "", "Lcom/bytedance/android/livesdk/link/model/IEffectInfoFlexImpl;", "effectList$delegate", "Ljava/lang/Object;", "getEffectList", "()Ljava/util/List;", "effectList", "", "", "Lcom/bytedance/android/livesdk/link/model/IAnchorEffect_EffectInfoListFlexImpl;", "effectMap$delegate", "getEffectMap", "()Ljava/util/Map;", "effectMap", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorEffectFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("effect_list")
    protected List<IEffectInfoFlexImpl> _$$effectList;

    @SerializedName("effect_map")
    protected Map<Long, IAnchorEffect_EffectInfoListFlexImpl> _$$effectMap;

    public IAnchorEffectFlexImpl() {
        super(j.class);
        this._$$effectList = $defaultValue_effectList$();
    }

    public final List<IEffectInfoFlexImpl> $defaultValue_effectList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.j
    public final List<IEffectInfoFlexImpl> getEffectList() {
        return this._$$effectList;
    }

    @Override // com.bytedance.android.livesdk.link.model.j
    public final Map<Long, IAnchorEffect_EffectInfoListFlexImpl> getEffectMap() {
        return this._$$effectMap;
    }

    public IAnchorEffectFlexImpl(am3.g r110) {
        super(j.class);
        this._$$effectList = new ArrayList();
        this._$$effectMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$effectList.add(new IEffectInfoFlexImpl(r110));
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r103 = r110.c();
        Long r104 = null;
        IAnchorEffect_EffectInfoListFlexImpl r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L18;
        if (r106 != 1) goto L14;
        r104 = Long.valueOf(r110.j());
        goto L11
    L14:
        if (r106 != 2) goto L15;
        r105 = new IAnchorEffect_EffectInfoListFlexImpl(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map<Long, IAnchorEffect_EffectInfoListFlexImpl> r107 = this._$$effectMap;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r107.put(r104, r105);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r102, r110);
        goto L3
    L27:
        r110.d(r100);
        setThreadSafe(true);
        if (this._$$effectList.isEmpty() == false) goto L51;
        this._$$effectList = $defaultValue_effectList$();
        return;
    }
}
