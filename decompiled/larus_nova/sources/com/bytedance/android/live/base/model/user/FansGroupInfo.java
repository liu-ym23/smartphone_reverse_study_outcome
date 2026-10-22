package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.FansGroupInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/user/FansGroupInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/u;", "", "_fansGroupUrl", "Ljava/lang/String;", "get_fansGroupUrl", "()Ljava/lang/String;", "set_fansGroupUrl", "(Ljava/lang/String;)V", "value", "getFansGroupUrl", "setFansGroupUrl", "fansGroupUrl", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansGroupInfo extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("list_fans_group_url")
    protected String _fansGroupUrl;

    public FansGroupInfo() {
        super(u.class);
    }

    public FansGroupInfo(am3.g r100) {
        super(u.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._fansGroupUrl = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.u
    public String getFansGroupUrl() {
        return this._fansGroupUrl;
    }

    public final String get_fansGroupUrl() {
        return this._fansGroupUrl;
    }

    @Override // com.bytedance.android.live.base.model.user.u
    public void setFansGroupUrl(String r100) {
        this._fansGroupUrl = r100;
    }

    public final void set_fansGroupUrl(String r100) {
        this._fansGroupUrl = r100;
    }
}
