package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.GameInviteInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/GameInviteInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "", "inviteSource$delegate", "Ljava/lang/Object;", "getInviteSource", "()I", "inviteSource", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameInviteInfoFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("invite_source")
    protected int _$$inviteSource;

    public GameInviteInfoFlexImpl() {
        super(e.class);
        this._$$inviteSource = $defaultValue_inviteSource$();
    }

    public final int $defaultValue_inviteSource$() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.e
    public boolean isGameInvite() {
        if (getInviteSource() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.e
    public final int getInviteSource() {
        return this._$$inviteSource;
    }

    public GameInviteInfoFlexImpl(am3.g r100) {
        super(e.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$inviteSource = r100.i();
        r101 = r101 | true;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L19;
        this._$$inviteSource = $defaultValue_inviteSource$();
        return;
    }
}
