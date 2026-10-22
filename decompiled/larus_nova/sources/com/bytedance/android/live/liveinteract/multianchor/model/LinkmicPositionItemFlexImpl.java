package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.LinkmicPositionItem")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R+\u0010!\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R+\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\n¨\u0006("}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItemFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "", "<set-?>", "position$delegate", "Ljava/lang/Object;", "getPosition", "()J", "setPosition", "(J)V", "position", "", "status$delegate", "getStatus", "()I", "setStatus", "(I)V", "status", "", "activeName$delegate", "getActiveName", "()Ljava/lang/String;", "setActiveName", "(Ljava/lang/String;)V", "activeName", "verifyStatus$delegate", "getVerifyStatus", "setVerifyStatus", "verifyStatus", "positionType$delegate", "getPositionType", "setPositionType", "positionType", "clientUIPosition$delegate", "getClientUIPosition", "setClientUIPosition", "clientUIPosition", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicPositionItemFlexImpl extends FlexModelBase<LinkmicPositionItem> implements LinkmicPositionItem, vh7.h {

    @SerializedName("active_name")
    protected String _$$activeName;

    @SerializedName("client_ui_position")
    protected long _$$clientUIPosition;

    @SerializedName("position")
    protected long _$$position;

    @SerializedName("position_type")
    protected int _$$positionType;

    @SerializedName("status")
    protected int _$$status;

    @SerializedName("verify_status")
    protected int _$$verifyStatus;

    public LinkmicPositionItemFlexImpl() {
        super(LinkmicPositionItem.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final String getActiveName() {
        return this._$$activeName;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final long getClientUIPosition() {
        return this._$$clientUIPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final long getPosition() {
        return this._$$position;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final int getPositionType() {
        return this._$$positionType;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final int getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final int getVerifyStatus() {
        return this._$$verifyStatus;
    }

    public LinkmicPositionItemFlexImpl(am3.g r100) {
        super(LinkmicPositionItem.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$clientUIPosition = r100.j();
        goto L3
    L9:
        this._$$positionType = r100.i();
        goto L3
    L10:
        this._$$verifyStatus = r100.i();
        goto L3
    L11:
        this._$$activeName = am3.h.c(r100);
        goto L3
    L12:
        this._$$status = r100.i();
        goto L3
    L13:
        this._$$position = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final void setActiveName(String r100) {
        this._$$activeName = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final void setClientUIPosition(long r100) {
        this._$$clientUIPosition = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final void setPosition(long r100) {
        this._$$position = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final void setPositionType(int r100) {
        this._$$positionType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final void setStatus(int r100) {
        this._$$status = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem
    public final void setVerifyStatus(int r100) {
        this._$$verifyStatus = r100;
    }
}
