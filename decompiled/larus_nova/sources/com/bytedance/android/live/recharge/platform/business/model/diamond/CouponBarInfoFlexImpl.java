package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.DiamondBuyPanelExtraInfo.CouponBarInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/CouponBarInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/a;", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "desc$delegate", "getDesc", SocialConstants.PARAM_APP_DESC, "", "canClick$delegate", "getCanClick", "()Ljava/lang/Boolean;", "canClick", "", "descStyle$delegate", "getDescStyle", "()Ljava/lang/Integer;", "descStyle", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CouponBarInfoFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("can_click")
    protected Boolean _$$canClick;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String _$$desc;

    @SerializedName("desc_style")
    protected Integer _$$descStyle;

    @SerializedName("title")
    protected String _$$title;

    public CouponBarInfoFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.a
    public final Boolean getCanClick() {
        return this._$$canClick;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.a
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.a
    public final Integer getDescStyle() {
        return this._$$descStyle;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.a
    public final String getTitle() {
        return this._$$title;
    }

    public CouponBarInfoFlexImpl(am3.g r100) {
        super(a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$desc = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$canClick = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$descStyle = Integer.valueOf(r100.i());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
