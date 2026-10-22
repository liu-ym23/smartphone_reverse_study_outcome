package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.ProfileCardPreviewButton")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IButtonConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/d;", "", "enable$delegate", "Ljava/lang/Object;", "getEnable", "()Z", "enable", "", "text$delegate", "getText", "()Ljava/lang/String;", "text", "color$delegate", "getColor", "color", "bgColor$delegate", "getBgColor", "bgColor", "schema$delegate", "getSchema", "schema", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IButtonConfigFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("bg_color")
    protected String _$$bgColor;

    @SerializedName("text_color")
    protected String _$$color;

    @SerializedName("enable")
    protected boolean _$$enable;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("text")
    protected String _$$text;

    public IButtonConfigFlexImpl() {
        super(d.class);
        this._$$enable = false;
        this._$$text = "";
    }

    public IButtonConfigFlexImpl(am3.g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$enable = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$text = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this._$$color = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this._$$bgColor = am3.h.c(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        this._$$schema = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r104, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L25;
        this._$$enable = false;
    L25:
        if (this._$$text != null) goto L46;
        this._$$text = "";
        return;
    }

    @Override // com.bytedance.android.live.profit.dress.config.d
    public final String getBgColor() {
        return this._$$bgColor;
    }

    @Override // com.bytedance.android.live.profit.dress.config.d
    public final String getColor() {
        return this._$$color;
    }

    @Override // com.bytedance.android.live.profit.dress.config.d
    public final boolean getEnable() {
        return this._$$enable;
    }

    @Override // com.bytedance.android.live.profit.dress.config.d
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.live.profit.dress.config.d
    public final String getText() {
        return this._$$text;
    }
}
