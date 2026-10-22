package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.RushLuckyBoxResponse.CaijingVoucher")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IMainLuckyBoxRushResult_CaijingVoucherFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/p1$a;", "", "Lcom/bytedance/android/livesdk/chatroom/model/p1$d;", "<set-?>", "voucherList$delegate", "Ljava/lang/Object;", "getVoucherList", "()Ljava/util/List;", "setVoucherList", "(Ljava/util/List;)V", "voucherList", "", "activityId$delegate", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "activityId", "voucherName$delegate", "getVoucherName", "setVoucherName", "voucherName", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMainLuckyBoxRushResult_CaijingVoucherFlexImpl extends FlexModelBase<p1.a> implements p1.a, vh7.h {

    @SerializedName("activity_id")
    protected String _$$activityId;

    @SerializedName("voucher_group")
    protected List<? extends p1.d> _$$voucherList;

    @SerializedName("voucher_name")
    protected String _$$voucherName;

    public IMainLuckyBoxRushResult_CaijingVoucherFlexImpl() {
        super(p1.a.class);
    }

    public IMainLuckyBoxRushResult_CaijingVoucherFlexImpl(am3.g r100) {
        super(p1.a.class);
        this._$$voucherList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$voucherList.add(vh7.f.a(r100, p1.d.class));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$voucherName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$activityId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.a
    public final String getActivityId() {
        return this._$$activityId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.a
    public final List<p1.d> getVoucherList() {
        return this._$$voucherList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.a
    public final String getVoucherName() {
        return this._$$voucherName;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.a
    public final void setActivityId(String r100) {
        this._$$activityId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.a
    public final void setVoucherList(List<? extends p1.d> r100) {
        this._$$voucherList = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.p1.a
    public final void setVoucherName(String r100) {
        this._$$voucherName = r100;
    }
}
