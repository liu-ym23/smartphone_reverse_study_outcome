package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.gift.PageNameStyleInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PageNameStyleInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/b3;", "Lcom/bytedance/android/livesdk/gift/model/a3;", "<set-?>", "styleBeforeSelected$delegate", "Ljava/lang/Object;", "getStyleBeforeSelected", "()Lcom/bytedance/android/livesdk/gift/model/a3;", "setStyleBeforeSelected", "(Lcom/bytedance/android/livesdk/gift/model/a3;)V", "styleBeforeSelected", "styleAfterSelected$delegate", "getStyleAfterSelected", "setStyleAfterSelected", "styleAfterSelected", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PageNameStyleInfoFlexImpl extends FlexModelBase<b3> implements b3, vh7.h {

    @SerializedName("style_after_selected")
    protected a3 _$$styleAfterSelected;

    @SerializedName("style_before_selected")
    protected a3 _$$styleBeforeSelected;

    public PageNameStyleInfoFlexImpl() {
        super(b3.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.gift.model.a3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.gift.model.a3, java.lang.Object] */
    public PageNameStyleInfoFlexImpl(am3.g r100) {
        super(b3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$styleBeforeSelected = vh7.f.a(r100, a3.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$styleAfterSelected = vh7.f.a(r100, a3.class);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.b3
    public final a3 getStyleAfterSelected() {
        return this._$$styleAfterSelected;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b3
    public final a3 getStyleBeforeSelected() {
        return this._$$styleBeforeSelected;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b3
    public final void setStyleAfterSelected(a3 r100) {
        this._$$styleAfterSelected = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b3
    public final void setStyleBeforeSelected(a3 r100) {
        this._$$styleBeforeSelected = r100;
    }
}
