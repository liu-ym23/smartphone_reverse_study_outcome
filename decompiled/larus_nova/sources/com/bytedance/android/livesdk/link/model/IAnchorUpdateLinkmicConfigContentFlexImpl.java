package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.AnchorUpdateLinkmicConfigContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorUpdateLinkmicConfigContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x;", "", "forbidInviteByGeneral$delegate", "Ljava/lang/Object;", "getForbidInviteByGeneral", "()Z", "forbidInviteByGeneral", "forbidApplyFromOther$delegate", "getForbidApplyFromOther", "forbidApplyFromOther", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorUpdateLinkmicConfigContentFlexImpl extends FlexModelBase<x> implements x, vh7.h {

    @SerializedName("forbid_apply_from_other")
    protected boolean _$$forbidApplyFromOther;

    @SerializedName("forbid_invite_by_general")
    protected boolean _$$forbidInviteByGeneral;

    public IAnchorUpdateLinkmicConfigContentFlexImpl() {
        super(x.class);
        this._$$forbidInviteByGeneral = false;
        this._$$forbidApplyFromOther = false;
    }

    public IAnchorUpdateLinkmicConfigContentFlexImpl(am3.g r100) {
        super(x.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$forbidInviteByGeneral = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this._$$forbidApplyFromOther = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L8:
        am3.h.d(r104, r100);
        goto L3
    L11:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L15;
        this._$$forbidInviteByGeneral = false;
    L15:
        if ((r102 & 2) != 0) goto L27;
        this._$$forbidApplyFromOther = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.x
    public final boolean getForbidApplyFromOther() {
        return this._$$forbidApplyFromOther;
    }

    @Override // com.bytedance.android.livesdk.link.model.x
    public final boolean getForbidInviteByGeneral() {
        return this._$$forbidInviteByGeneral;
    }
}
