package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.GroupLiveContainerData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001b\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0011R\u001b\u0010!\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0011R\u001b\u0010&\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GroupContainerDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/v0;", "", "type$delegate", "Ljava/lang/Object;", "getType", "()I", "type", "", "priority$delegate", "getPriority", "()J", "priority", "", "containerPayload$delegate", "getContainerPayload", "()Ljava/lang/String;", "containerPayload", "positionJson$delegate", "getPositionJson", "positionJson", "url$delegate", "getUrl", "url", "foldUrl$delegate", "getFoldUrl", "foldUrl", "horizontalUrl$delegate", "getHorizontalUrl", "horizontalUrl", "previewUrl$delegate", "getPreviewUrl", "previewUrl", "", "canAdjustPosition$delegate", "getCanAdjustPosition", "()Z", "canAdjustPosition", "isLiteMode$delegate", "isLiteMode", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupContainerDataFlexImpl extends FlexModelBase<v0> implements v0, vh7.h {

    @SerializedName("can_adjust_position")
    protected boolean _$$canAdjustPosition;

    @SerializedName("container_payload")
    protected String _$$containerPayload;

    @SerializedName("fold_url")
    protected String _$$foldUrl;

    @SerializedName("horizontal_url")
    protected String _$$horizontalUrl;

    @SerializedName("is_lite_mode")
    protected boolean _$$isLiteMode;

    @SerializedName("position")
    protected String _$$positionJson;

    @SerializedName("preview_url")
    protected String _$$previewUrl;

    @SerializedName("priority")
    protected long _$$priority;

    @SerializedName("type")
    protected int _$$type;

    @SerializedName("url")
    protected String _$$url;

    public GroupContainerDataFlexImpl() {
        super(v0.class);
        this._$$containerPayload = "";
        this._$$positionJson = "";
        this._$$url = "";
        this._$$foldUrl = "";
        this._$$horizontalUrl = "";
        this._$$previewUrl = "";
        this._$$canAdjustPosition = false;
        this._$$isLiteMode = false;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final boolean getCanAdjustPosition() {
        return this._$$canAdjustPosition;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final String getContainerPayload() {
        return this._$$containerPayload;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final String getFoldUrl() {
        return this._$$foldUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final String getHorizontalUrl() {
        return this._$$horizontalUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final String getPositionJson() {
        return this._$$positionJson;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final String getPreviewUrl() {
        return this._$$previewUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final long getPriority() {
        return this._$$priority;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final int getType() {
        return this._$$type;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final String getUrl() {
        return this._$$url;
    }

    @Override // com.bytedance.android.livesdk.gift.model.v0
    public final boolean isLiteMode() {
        return this._$$isLiteMode;
    }

    public GroupContainerDataFlexImpl(am3.g r100) {
        super(v0.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L23;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 9) goto L8;
        this._$$canAdjustPosition = am3.h.a(r100);
        r102 = r102 | 4;
        goto L3
    L8:
        if (r103 != 10) goto L10;
        this._$$isLiteMode = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L10:
        if (r103 != 14) goto L11;
        this._$$previewUrl = am3.h.c(r100);
        goto L3
    L11:
        switch(r103) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L12;
        };
    L13:
        this._$$horizontalUrl = am3.h.c(r100);
        goto L3
    L14:
        this._$$foldUrl = am3.h.c(r100);
        goto L3
    L15:
        this._$$url = am3.h.c(r100);
        goto L3
    L16:
        this._$$positionJson = am3.h.c(r100);
        goto L3
    L17:
        this._$$containerPayload = am3.h.c(r100);
        goto L3
    L18:
        this._$$priority = r100.j();
        r102 = r102 | 2;
        goto L3
    L19:
        this._$$type = r100.i();
        r102 = r102 | 1;
        goto L3
    L12:
        am3.h.d(r104, r100);
        goto L3
    L23:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$containerPayload != null) goto L27;
        this._$$containerPayload = "";
    L27:
        if (this._$$positionJson != null) goto L30;
        this._$$positionJson = "";
    L30:
        if (this._$$url != null) goto L33;
        this._$$url = "";
    L33:
        if (this._$$foldUrl != null) goto L36;
        this._$$foldUrl = "";
    L36:
        if (this._$$horizontalUrl != null) goto L39;
        this._$$horizontalUrl = "";
    L39:
        if (this._$$previewUrl != null) goto L42;
        this._$$previewUrl = "";
    L42:
        if ((r102 & 4) != 0) goto L45;
        this._$$canAdjustPosition = false;
    L45:
        if ((r102 & 8) != 0) goto L75;
        this._$$isLiteMode = false;
        return;
    }
}
