package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.DIYPageEnterButton")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/DIYPageEnterButtonFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/q;", "Lcom/bytedance/android/live/base/model/message/a5;", "<set-?>", "text$delegate", "Ljava/lang/Object;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "text", "", "schema$delegate", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "schema", "", "locked$delegate", "getLocked", "()Z", "setLocked", "(Z)V", "locked", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DIYPageEnterButtonFlexImpl extends FlexModelBase<q> implements q, vh7.h {

    @SerializedName("locked")
    protected boolean _$$locked;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("text")
    protected a5 _$$text;

    public DIYPageEnterButtonFlexImpl() {
        super(q.class);
        this._$$locked = false;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public DIYPageEnterButtonFlexImpl(am3.g r100) {
        super(q.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$text = vh7.f.a(r100, a5.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$schema = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this._$$locked = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L31;
        this._$$locked = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q
    public final boolean getLocked() {
        return this._$$locked;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q
    public final a5 getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q
    public final void setLocked(boolean r100) {
        this._$$locked = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q
    public final void setSchema(String r100) {
        this._$$schema = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.q
    public final void setText(a5 r100) {
        this._$$text = r100;
    }
}
