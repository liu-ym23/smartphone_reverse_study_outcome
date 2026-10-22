package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/IMidiSkinDressInfo;", "()V", "dressId", "", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "material", "Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinMaterial;", "getMaterial", "()Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinMaterial;", "setMaterial", "(Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinMaterial;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MidiSkinDressInfo extends FlexModelBase<IMidiSkinDressInfo> implements IMidiSkinDressInfo, h {

    @SerializedName("dress_id")
    protected String dressId;

    @SerializedName("material")
    protected MidiSkinMaterial material;

    public MidiSkinDressInfo() {
        super(IMidiSkinDressInfo.class);
    }

    public MidiSkinDressInfo(g r100) {
        super(IMidiSkinDressInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.dressId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.material = new MidiSkinMaterial(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IMidiSkinDressInfo
    public /* bridge */ /* synthetic */ IMidiSkinMaterial getMaterial() {
        return getMaterial();
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IMidiSkinDressInfo
    public String getDressId() {
        return this.dressId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IMidiSkinDressInfo
    public MidiSkinMaterial getMaterial() {
        return this.material;
    }

    public void setDressId(String r100) {
        this.dressId = r100;
    }

    public void setMaterial(MidiSkinMaterial r100) {
        this.material = r100;
    }
}
