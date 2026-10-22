package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AnchorPointItem")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorPointItem;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorPointItem;", "()V", "buttonSchemaUrl", "", "getButtonSchemaUrl", "()Ljava/lang/String;", "buttonText", "getButtonText", "content", "getContent", "disappearTimeInterval", "", "getDisappearTimeInterval", "()Ljava/lang/Integer;", "setDisappearTimeInterval", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "extra", "", "getExtra", "()Ljava/util/Map;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "showTimeInterval", "getShowTimeInterval", "setShowTimeInterval", "type", "getType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPointItem extends FlexModelBase<IAnchorPointItem> implements IAnchorPointItem, h {

    @SerializedName("button_schema_url")
    protected String buttonSchemaUrl;

    @SerializedName("button_text")
    protected String buttonText;

    @SerializedName("content")
    protected String content;

    @SerializedName("disappear_time_interval")
    protected Integer disappearTimeInterval;

    @SerializedName("extra")
    protected Map<String, String> extra;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("show_time_interval")
    protected Integer showTimeInterval;

    @SerializedName("type")
    protected Integer type;

    public AnchorPointItem() {
        super(IAnchorPointItem.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public /* bridge */ /* synthetic */ k getIcon() {
        return getIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public String getButtonSchemaUrl() {
        return this.buttonSchemaUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public String getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public String getContent() {
        return this.content;
    }

    public final Integer getDisappearTimeInterval() {
        return this.disappearTimeInterval;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public Map<String, String> getExtra() {
        return this.extra;
    }

    public final Integer getShowTimeInterval() {
        return this.showTimeInterval;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public Integer getType() {
        return this.type;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAnchorPointItem
    public ImageModel getIcon() {
        return this.icon;
    }

    public AnchorPointItem(g r110) {
        super(IAnchorPointItem.class);
        this.extra = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L32;
        g.a r102 = decodeExtensionFields(r101, r110);
        switch(r101) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.disappearTimeInterval = Integer.valueOf(r110.i());
        goto L3
    L9:
        this.showTimeInterval = Integer.valueOf(r110.i());
        goto L3
    L10:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L19;
        if (r106 != 1) goto L15;
        r104 = am3.h.c(r110);
        goto L11
    L15:
        if (r106 != 2) goto L16;
        r105 = am3.h.c(r110);
        goto L11
    L16:
        am3.h.e(r110);
        goto L11
    L19:
        r110.d(r103);
        Map<String, String> r107 = this.extra;
        if (r104 == null) goto L26;
        if (r105 == null) goto L24;
        r107.put(r104, r105);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L27:
        this.buttonSchemaUrl = am3.h.c(r110);
        goto L3
    L28:
        this.buttonText = am3.h.c(r110);
        goto L3
    L29:
        this.content = am3.h.c(r110);
        goto L3
    L30:
        this.icon = x.a(r110);
        goto L3
    L31:
        this.type = Integer.valueOf(r110.i());
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L32:
        r110.d(r100);
        setThreadSafe(true);
    }

    public final void setDisappearTimeInterval(Integer r100) {
        this.disappearTimeInterval = r100;
    }

    public final void setShowTimeInterval(Integer r100) {
        this.showTimeInterval = r100;
    }
}
