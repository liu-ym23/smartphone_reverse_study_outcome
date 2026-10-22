package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.GiftImage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftImageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/q1;", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "", "fetchFrom$delegate", "Ljava/lang/Object;", "getFetchFrom", "()I", "fetchFrom", "groupId$delegate", "getGroupId", "groupId", "imageType$delegate", "getImageType", "imageType", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftImageFlexImpl extends FlexModelBase<q1> implements q1, vh7.h {

    @SerializedName("fetch_from")
    protected int _$$fetchFrom;

    @SerializedName("group_id")
    protected int _$$groupId;

    @SerializedName("type")
    protected int _$$imageType;

    @SerializedName("image")
    protected py.k image;

    public IGiftImageFlexImpl() {
        super(q1.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.q1
    public final int getFetchFrom() {
        return this._$$fetchFrom;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q1
    public final int getGroupId() {
        return this._$$groupId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q1
    public py.k getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q1
    public final int getImageType() {
        return this._$$imageType;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IGiftImageFlexImpl(am3.g r100) {
        super(q1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$fetchFrom = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$groupId = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$imageType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.image = vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setImage(py.k r100) {
        this.image = r100;
    }
}
