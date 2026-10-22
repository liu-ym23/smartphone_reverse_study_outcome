package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.GiftTouchLabel")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftTouchLabelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/e2;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "touchUniqueKey$delegate", "Ljava/lang/Object;", "getTouchUniqueKey", "()Ljava/lang/String;", "touchUniqueKey", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftTouchLabelFlexImpl extends FlexModelBase<e2> implements e2, vh7.h {

    @SerializedName("unique_key")
    protected String _$$touchUniqueKey;

    @SerializedName("icon")
    protected py.k icon;

    public IGiftTouchLabelFlexImpl() {
        super(e2.class);
        this._$$touchUniqueKey = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IGiftTouchLabelFlexImpl(am3.g r100) {
        super(e2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.icon = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$touchUniqueKey = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$touchUniqueKey != null) goto L25;
        this._$$touchUniqueKey = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e2
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e2
    public final String getTouchUniqueKey() {
        return this._$$touchUniqueKey;
    }

    public void setIcon(py.k r100) {
        this.icon = r100;
    }
}
