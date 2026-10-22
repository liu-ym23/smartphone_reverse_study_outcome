package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.ComboHintData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ExtraComboHintDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/v;", "Lpy/k;", "hintImg", "Lpy/k;", "getHintImg", "()Lpy/k;", "setHintImg", "(Lpy/k;)V", "", "count$delegate", "Ljava/lang/Object;", "getCount", "()J", "count", "", "comboHintType$delegate", "getComboHintType", "()I", "comboHintType", "", "name$delegate", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExtraComboHintDataFlexImpl extends FlexModelBase<v> implements v, vh7.h {

    @SerializedName("combo_hint_type")
    protected int _$$comboHintType;

    @SerializedName("count")
    protected long _$$count;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("hint_img")
    protected py.k hintImg;

    public ExtraComboHintDataFlexImpl() {
        super(v.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.v
    public final int getComboHintType() {
        return this._$$comboHintType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v
    public final long getCount() {
        return this._$$count;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v
    public py.k getHintImg() {
        return this.hintImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v
    public final String getName() {
        return this._$$name;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public ExtraComboHintDataFlexImpl(am3.g r100) {
        super(v.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$count = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.hintImg = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$comboHintType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$name = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setHintImg(py.k r100) {
        this.hintImg = r100;
    }
}
