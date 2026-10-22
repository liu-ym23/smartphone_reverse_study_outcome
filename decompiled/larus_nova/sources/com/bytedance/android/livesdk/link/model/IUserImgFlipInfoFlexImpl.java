package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleUserInfo.UserImgFlipInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IUserImgFlipInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y9;", "Lpy/k;", "flipImage", "Lpy/k;", "getFlipImage", "()Lpy/k;", "setFlipImage", "(Lpy/k;)V", "pkStageMedal", "getPkStageMedal", "setPkStageMedal", "", "pkStageDesc$delegate", "Ljava/lang/Object;", "getPkStageDesc", "()Ljava/lang/String;", "pkStageDesc", "scheme$delegate", "getScheme", "scheme", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IUserImgFlipInfoFlexImpl extends FlexModelBase<y9> implements y9, vh7.h {

    @SerializedName("pk_stage_desc")
    protected String _$$pkStageDesc;

    @SerializedName("scheme")
    protected String _$$scheme;

    @SerializedName("flip_image")
    protected py.k flipImage;

    @SerializedName("pk_stage_medal")
    protected py.k pkStageMedal;

    public IUserImgFlipInfoFlexImpl() {
        super(y9.class);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public IUserImgFlipInfoFlexImpl(am3.g r100) {
        super(y9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.flipImage = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.pkStageMedal = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$pkStageDesc = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$scheme = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.y9
    public py.k getFlipImage() {
        return this.flipImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.y9
    public final String getPkStageDesc() {
        return this._$$pkStageDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.y9
    public py.k getPkStageMedal() {
        return this.pkStageMedal;
    }

    @Override // com.bytedance.android.livesdk.link.model.y9
    public final String getScheme() {
        return this._$$scheme;
    }

    public void setFlipImage(py.k r100) {
        this.flipImage = r100;
    }

    public void setPkStageMedal(py.k r100) {
        this.pkStageMedal = r100;
    }
}
