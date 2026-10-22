package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.FastMatchResultTag")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/FastMatchResultTag;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/c1;", "", "getTagName", "getValue", "_tagName", "Ljava/lang/String;", "get_tagName", "()Ljava/lang/String;", "set_tagName", "(Ljava/lang/String;)V", "_value", "get_value", "set_value", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastMatchResultTag extends FlexModelBase<c1> implements c1, vh7.h {

    @SerializedName("tag_name")
    protected String _tagName;

    @SerializedName("value")
    protected String _value;

    public FastMatchResultTag() {
        super(c1.class);
    }

    public FastMatchResultTag(am3.g r100) {
        super(c1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._tagName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._value = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.c1
    public String getTagName() {
        return this._tagName;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.c1
    public String getValue() {
        return this._value;
    }

    public final String get_tagName() {
        return this._tagName;
    }

    public final String get_value() {
        return this._value;
    }

    public final void set_tagName(String r100) {
        this._tagName = r100;
    }

    public final void set_value(String r100) {
        this._value = r100;
    }
}
