package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.LinkmicSubtitleStatus")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR+\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\n¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkmicSubtitleSettingStatusFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "", "<set-?>", "subtitleStyle$delegate", "Ljava/lang/Object;", "getSubtitleStyle", "()I", "setSubtitleStyle", "(I)V", "subtitleStyle", "", "x$delegate", "getX", "()D", "setX", "(D)V", "x", "y$delegate", "getY", "setY", "y", "subtitleType$delegate", "getSubtitleType", "setSubtitleType", "subtitleType", "activateStatus$delegate", "getActivateStatus", "setActivateStatus", "activateStatus", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleSettingStatusFlexImpl extends FlexModelBase<q2> implements q2, vh7.h {

    @SerializedName("activate_status")
    protected int _$$activateStatus;

    @SerializedName("subtitle_style")
    protected int _$$subtitleStyle;

    @SerializedName("subtitle_type")
    protected int _$$subtitleType;

    @SerializedName("x")
    protected double _$$x;

    @SerializedName("y")
    protected double _$$y;

    public LinkmicSubtitleSettingStatusFlexImpl() {
        super(q2.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final int getActivateStatus() {
        return this._$$activateStatus;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final int getSubtitleStyle() {
        return this._$$subtitleStyle;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final int getSubtitleType() {
        return this._$$subtitleType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final double getX() {
        return this._$$x;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final double getY() {
        return this._$$y;
    }

    public LinkmicSubtitleSettingStatusFlexImpl(am3.g r100) {
        super(q2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$subtitleStyle = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$x = Double.longBitsToDouble(r100.h());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$y = Double.longBitsToDouble(r100.h());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$subtitleType = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$activateStatus = r100.i();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final void setActivateStatus(int r100) {
        this._$$activateStatus = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final void setSubtitleStyle(int r100) {
        this._$$subtitleStyle = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final void setSubtitleType(int r100) {
        this._$$subtitleType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final void setX(double r100) {
        this._$$x = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.q2
    public final void setY(double r100) {
        this._$$y = r100;
    }
}
