package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkerEnlargeGuestInviteContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u001e¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/LinkerEnlargeGuestInviteContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/linker/k;", "Lpy/k;", "uiImage", "Lpy/k;", "getUiImage", "()Lpy/k;", "setUiImage", "(Lpy/k;)V", "", "inviteType$delegate", "Ljava/lang/Object;", "getInviteType", "()I", "inviteType", "targetEnlargeGuestType$delegate", "getTargetEnlargeGuestType", "targetEnlargeGuestType", "", "_fromUid$delegate", "get_fromUid", "()J", "_fromUid", "_toUid$delegate", "get_toUid", "_toUid", "", "_fromOpenId$delegate", "get_fromOpenId", "()Ljava/lang/String;", "_fromOpenId", "_toOpenId$delegate", "get_toOpenId", "_toOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerEnlargeGuestInviteContentFlexImpl extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("from_openid")
    protected String _$$_fromOpenId;

    @SerializedName("from_user_id")
    protected long _$$_fromUid;

    @SerializedName("to_openid")
    protected String _$$_toOpenId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    protected long _$$_toUid;

    @SerializedName("invite_type")
    protected int _$$inviteType;

    @SerializedName("target_enlarge_guest_type")
    protected int _$$targetEnlargeGuestType;

    @SerializedName("ui_image")
    protected py.k uiImage;

    public LinkerEnlargeGuestInviteContentFlexImpl() {
        super(k.class);
        this._$$_fromOpenId = "";
        this._$$_toOpenId = "";
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public final int getInviteType() {
        return this._$$inviteType;
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public final int getTargetEnlargeGuestType() {
        return this._$$targetEnlargeGuestType;
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public py.k getUiImage() {
        return this.uiImage;
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public final String get_fromOpenId() {
        return this._$$_fromOpenId;
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public final long get_fromUid() {
        return this._$$_fromUid;
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public final String get_toOpenId() {
        return this._$$_toOpenId;
    }

    @Override // com.bytedance.android.livesdk.message.linker.k
    public final long get_toUid() {
        return this._$$_toUid;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public LinkerEnlargeGuestInviteContentFlexImpl(am3.g r100) {
        super(k.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$_fromUid = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$_toUid = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$inviteType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.uiImage = vh7.f.a(r100, py.k.class);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._$$targetEnlargeGuestType = r100.i();
        goto L3
    L16:
        if (r102 != 5000) goto L18;
        this._$$_fromOpenId = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 5001) goto L19;
        this._$$_toOpenId = am3.h.c(r100);
        goto L3
    L19:
        am3.h.d(r103, r100);
        goto L3
    L27:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$_fromOpenId != null) goto L31;
        this._$$_fromOpenId = "";
    L31:
        if (this._$$_toOpenId != null) goto L58;
        this._$$_toOpenId = "";
        return;
    }

    public void setUiImage(py.k r100) {
        this.uiImage = r100;
    }
}
