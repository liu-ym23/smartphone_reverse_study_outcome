package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.TitleArea.Button")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IButtonAreaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/p3;", "", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/lang/String;", "text", "textColor$delegate", "getTextColor", "textColor", "bgColor$delegate", "getBgColor", "bgColor", "", "actType$delegate", "getActType", "()Ljava/lang/Long;", "actType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IButtonAreaFlexImpl extends FlexModelBase<p3> implements p3, vh7.h {

    @SerializedName("action_type")
    protected Long _$$actType;

    @SerializedName("background_color")
    protected String _$$bgColor;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("text_color")
    protected String _$$textColor;

    public IButtonAreaFlexImpl() {
        super(p3.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.p3
    public final Long getActType() {
        return this._$$actType;
    }

    @Override // com.bytedance.android.livesdk.link.model.p3
    public final String getBgColor() {
        return this._$$bgColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.p3
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.link.model.p3
    public final String getTextColor() {
        return this._$$textColor;
    }

    public IButtonAreaFlexImpl(am3.g r100) {
        super(p3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$text = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$textColor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$bgColor = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$actType = Long.valueOf(r100.j());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
