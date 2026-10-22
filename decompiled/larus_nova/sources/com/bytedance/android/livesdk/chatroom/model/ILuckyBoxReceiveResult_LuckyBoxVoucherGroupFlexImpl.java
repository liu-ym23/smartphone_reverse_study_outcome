package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.LuckyBoxVoucherGroup")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILuckyBoxReceiveResult_LuckyBoxVoucherGroupFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/n1$f;", "", "expireTime$delegate", "Ljava/lang/Object;", "getExpireTime", "()J", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "faceValue$delegate", "getFaceValue", "()Ljava/lang/String;", "faceValue", "unit$delegate", "getUnit", Scraps.INNER_UNIT, "title$delegate", "getTitle", "title", "subTitle$delegate", "getSubTitle", "subTitle", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILuckyBoxReceiveResult_LuckyBoxVoucherGroupFlexImpl extends FlexModelBase<n1.f> implements n1.f, vh7.h {

    @SerializedName("valid_end_datetime")
    protected long _$$expireTime;

    @SerializedName("face_value")
    protected String _$$faceValue;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String _$$subTitle;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName(Scraps.INNER_UNIT)
    protected String _$$unit;

    public ILuckyBoxReceiveResult_LuckyBoxVoucherGroupFlexImpl() {
        super(n1.f.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.f
    public final long getExpireTime() {
        return this._$$expireTime;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.f
    public final String getFaceValue() {
        return this._$$faceValue;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.f
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.f
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.n1.f
    public final String getUnit() {
        return this._$$unit;
    }

    public ILuckyBoxReceiveResult_LuckyBoxVoucherGroupFlexImpl(am3.g r100) {
        super(n1.f.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$expireTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$faceValue = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$unit = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$title = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$subTitle = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }
}
