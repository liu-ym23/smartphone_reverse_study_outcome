package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.AdventurFont")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/AdventureFont;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/f;", "", "_text", "Ljava/lang/String;", "get_text", "()Ljava/lang/String;", "set_text", "(Ljava/lang/String;)V", "_color", "get_color", "set_color", "getText", "text", "getColor", "color", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdventureFont extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("color")
    protected String _color;

    @SerializedName("text")
    protected String _text;

    public AdventureFont() {
        super(f.class);
        this._text = "";
        this._color = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.f
    public String getColor() {
        return this._color;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.f
    public String getText() {
        return this._text;
    }

    public final String get_color() {
        return this._color;
    }

    public final String get_text() {
        return this._text;
    }

    public AdventureFont(am3.g r100) {
        super(f.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._text = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._color = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._text != null) goto L16;
        this._text = "";
    L16:
        if (this._color != null) goto L28;
        this._color = "";
        return;
    }

    public final void set_color(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._color = r100;
    }

    public final void set_text(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._text = r100;
    }
}
