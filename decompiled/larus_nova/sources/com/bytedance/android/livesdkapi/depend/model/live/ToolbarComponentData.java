package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ToolBarComponentData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R \u0010%\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001e\u0010(\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ToolbarComponentData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarComponentData;", "()V", "dataStatus", "", "getDataStatus", "()J", "setDataStatus", "(J)V", ControlRule.KEY_EXTRA_DATA, "", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "groupId", "", "getGroupId", "()I", "setGroupId", "(I)V", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "id", "getId", "setId", "name", "getName", "setName", "operate", "getOperate", "setOperate", "scheme", "getScheme", "setScheme", "showType", "getShowType", "setShowType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarComponentData extends FlexModelBase<IToolbarComponentData> implements IToolbarComponentData, h {

    @SerializedName("data_status")
    protected long dataStatus;

    @SerializedName("extra")
    protected String extraData;

    @SerializedName("group_id")
    protected int groupId;

    @SerializedName("icon")
    protected ImageModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("component_type")
    protected int f162610id;

    @SerializedName("text")
    protected String name;

    @SerializedName("op_type")
    protected int operate;

    @SerializedName(a.KEY_SCHEMA_URL)
    protected String scheme;

    @SerializedName("show_type")
    protected int showType;

    public ToolbarComponentData() {
        super(IToolbarComponentData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public /* bridge */ /* synthetic */ k getIcon() {
        return getIcon();
    }

    public final long getDataStatus() {
        return this.dataStatus;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public int getGroupId() {
        return this.groupId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public int getId() {
        return this.f162610id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public int getOperate() {
        return this.operate;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public String getScheme() {
        return this.scheme;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public int getShowType() {
        return this.showType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public ImageModel getIcon() {
        return this.icon;
    }

    public ToolbarComponentData(g r100) {
        super(IToolbarComponentData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 99) goto L7;
        this.extraData = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this.dataStatus = r100.j();
        goto L3
    L10:
        this.showType = (int) r100.j();
        goto L3
    L11:
        this.icon = x.a(r100);
        goto L3
    L12:
        this.scheme = am3.h.c(r100);
        goto L3
    L13:
        this.name = am3.h.c(r100);
        goto L3
    L14:
        this.operate = r100.i();
        goto L3
    L15:
        this.f162610id = r100.i();
        goto L3
    L16:
        this.groupId = r100.i();
        goto L3
    L8:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setDataStatus(long r100) {
        this.dataStatus = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setExtraData(String r100) {
        this.extraData = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setGroupId(int r100) {
        this.groupId = r100;
    }

    public void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setId(int r100) {
        this.f162610id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setName(String r100) {
        this.name = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setOperate(int r100) {
        this.operate = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setScheme(String r100) {
        this.scheme = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData
    public void setShowType(int r100) {
        this.showType = r100;
    }
}
