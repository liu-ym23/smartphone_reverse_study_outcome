package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.PanelTitle")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPanelTitleFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/q7;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "titleIcon", "getTitleIcon", "setTitleIcon", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "desc$delegate", "getDesc", SocialConstants.PARAM_APP_DESC, "tag$delegate", "getTag", "tag", "iconSchema$delegate", "getIconSchema", "iconSchema", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPanelTitleFlexImpl extends FlexModelBase<q7> implements q7, vh7.h {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String _$$desc;

    @SerializedName("icon_schema_url")
    protected String _$$iconSchema;

    @SerializedName("desc_tag_text")
    protected String _$$tag;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("icon_bg_image")
    protected py.k icon;

    @SerializedName("icon")
    protected py.k titleIcon;

    public IPanelTitleFlexImpl() {
        super(q7.class);
        this._$$title = "";
        this._$$desc = "";
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public IPanelTitleFlexImpl(am3.g r100) {
        super(q7.class);
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
        this._$$iconSchema = am3.h.c(r100);
        goto L3
    L9:
        this.titleIcon = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        this._$$tag = am3.h.c(r100);
        goto L3
    L11:
        this.icon = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        this._$$desc = am3.h.c(r100);
        goto L3
    L13:
        this._$$title = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$title != null) goto L18;
        this._$$title = "";
    L18:
        if (this._$$desc != null) goto L37;
        this._$$desc = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.q7
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.livesdk.link.model.q7
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.link.model.q7
    public final String getIconSchema() {
        return this._$$iconSchema;
    }

    @Override // com.bytedance.android.livesdk.link.model.q7
    public final String getTag() {
        return this._$$tag;
    }

    @Override // com.bytedance.android.livesdk.link.model.q7
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.link.model.q7
    public py.k getTitleIcon() {
        return this.titleIcon;
    }

    public void setIcon(py.k r100) {
        this.icon = r100;
    }

    public void setTitleIcon(py.k r100) {
        this.titleIcon = r100;
    }
}
