package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.LinkerCancelContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerCancelContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x5;", "", "inviteSource$delegate", "Ljava/lang/Object;", "getInviteSource", "()I", "inviteSource", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "toast", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerCancelContentFlexImpl extends FlexModelBase<x5> implements x5, vh7.h {

    @SerializedName("invite_source")
    protected int _$$inviteSource;

    @SerializedName("toast")
    protected String _$$toast;

    public ILinkerCancelContentFlexImpl() {
        super(x5.class);
        this._$$toast = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.x5
    public final int getInviteSource() {
        return this._$$inviteSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.x5
    public final String getToast() {
        return this._$$toast;
    }

    public ILinkerCancelContentFlexImpl(am3.g r100) {
        super(x5.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 4) goto L8;
        this._$$inviteSource = r100.i();
        goto L3
    L8:
        if (r102 != 5) goto L9;
        this._$$toast = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$toast != null) goto L25;
        this._$$toast = "";
        return;
    }
}
