package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerUpdateLinkTypeForceOpenCameraContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "linkmicMediaInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getLinkmicMediaInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "setLinkmicMediaInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/j1;)V", "", "fromUserId$delegate", "Ljava/lang/Object;", "getFromUserId", "()Ljava/lang/Long;", "fromUserId", "toUserId$delegate", "getToUserId", "toUserId", "", "linkType$delegate", "getLinkType", "()Ljava/lang/Integer;", "linkType", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "toast", "fromOpenId$delegate", "getFromOpenId", "fromOpenId", "toOpenId$delegate", "getToOpenId", "toOpenId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerUpdateLinkTypeForceOpenCameraContentFlexImpl extends FlexModelBase<ILinkerUpdateLinkTypeForceOpenCameraContent> implements ILinkerUpdateLinkTypeForceOpenCameraContent, h {

    @SerializedName("from_open_id")
    protected String _$$fromOpenId;

    @SerializedName("from_user_id")
    protected Long _$$fromUserId;

    @SerializedName("link_type")
    protected Integer _$$linkType;

    @SerializedName("to_open_id")
    protected String _$$toOpenId;

    @SerializedName(a.KEY_TO_USER_ID)
    protected Long _$$toUserId;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("linkmic_media_info")
    protected j1 linkmicMediaInfo;

    public ILinkerUpdateLinkTypeForceOpenCameraContentFlexImpl() {
        super(ILinkerUpdateLinkTypeForceOpenCameraContent.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public final String getFromOpenId() {
        return this._$$fromOpenId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public final Long getFromUserId() {
        return this._$$fromUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public final Integer getLinkType() {
        return this._$$linkType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public j1 getLinkmicMediaInfo() {
        return this.linkmicMediaInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public final String getToOpenId() {
        return this._$$toOpenId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public final Long getToUserId() {
        return this._$$toUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent
    public final String getToast() {
        return this._$$toast;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.link.model.bridge.j1, java.lang.Object] */
    public ILinkerUpdateLinkTypeForceOpenCameraContentFlexImpl(g r100) {
        super(ILinkerUpdateLinkTypeForceOpenCameraContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$fromUserId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$toUserId = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$linkType = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$toast = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.linkmicMediaInfo = f.a(r100, j1.class);
        goto L3
    L16:
        if (r102 != 5000) goto L18;
        this._$$fromOpenId = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 5001) goto L19;
        this._$$toOpenId = am3.h.c(r100);
        goto L3
    L19:
        am3.h.d(r103, r100);
        goto L3
    L27:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setLinkmicMediaInfo(j1 r100) {
        this.linkmicMediaInfo = r100;
    }
}
