package com.bytedance.android.live.base.model.message;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/android/live/base/model/message/f;", "", "", "displayItemType", "I", "getDisplayItemType", "()I", "l", "(I)V", "", "comboFresh", "Z", "getComboFresh", "()Z", "setComboFresh", "(Z)V", "numberRoll", "e", "m", "Lcom/bytedance/android/live/base/model/message/m6;", "schemaInfo", "Lcom/bytedance/android/live/base/model/message/m6;", "f", "()Lcom/bytedance/android/live/base/model/message/m6;", "setSchemaInfo", "(Lcom/bytedance/android/live/base/model/message/m6;)V", "Lcom/bytedance/android/live/base/model/message/a;", "aggregateInfo", "Lcom/bytedance/android/live/base/model/message/a;", "getAggregateInfo", "()Lcom/bytedance/android/live/base/model/message/a;", "setAggregateInfo", "(Lcom/bytedance/android/live/base/model/message/a;)V", "Lcom/bytedance/android/live/base/model/message/y5;", "imagesItem", "Lcom/bytedance/android/live/base/model/message/y5;", "d", "()Lcom/bytedance/android/live/base/model/message/y5;", "setImagesItem", "(Lcom/bytedance/android/live/base/model/message/y5;)V", "Lcom/bytedance/android/live/base/model/message/o6;", "textItem", "Lcom/bytedance/android/live/base/model/message/o6;", ce.f26391f, "()Lcom/bytedance/android/live/base/model/message/o6;", OfficeSDKRequestTag.KEY_NEW_USER, "(Lcom/bytedance/android/live/base/model/message/o6;)V", "Lcom/bytedance/android/live/base/model/message/g;", SubInfo.KEY_FORMAT, "Lcom/bytedance/android/live/base/model/message/g;", "c", "()Lcom/bytedance/android/live/base/model/message/g;", "setFormat", "(Lcom/bytedance/android/live/base/model/message/g;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f implements vh7.h {

    @SerializedName("aggregate_info")
    protected a aggregateInfo;

    @SerializedName("combo_fresh")
    protected boolean comboFresh;

    @SerializedName("display_item_type")
    protected int displayItemType;

    @SerializedName(SubInfo.KEY_FORMAT)
    protected g format;

    @SerializedName("images_item")
    protected y5 imagesItem;

    @SerializedName("number_roll")
    protected boolean numberRoll;

    @SerializedName("schema_info")
    protected m6 schemaInfo;

    @SerializedName("text_item")
    protected o6 textItem;

    public f() {
    }

    public final void l() {
        this.displayItemType = 2;
    }

    public final void m() {
        this.numberRoll = false;
    }

    public final boolean a() {
        a r100 = this.aggregateInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.canAggregate != true) goto L7;
        return true;
    }

    public final String b() {
        a r100 = this.aggregateInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.aggregateSeq;
    }

    public final boolean h() {
        if (this.displayItemType != 1) goto L17;
        y5 r100 = this.imagesItem;
        if (r100 == null) goto L18;
        List<py.k> r101 = r100.images;
        if (r101 == null) goto L13;
        py.k r102 = (py.k) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L13;
        if (r102.isAnimated() != true) goto L13;
        boolean r103 = true;
    L14:
        if (r103 != true) goto L19;
        return true;
    L19:
        return false;
    L13:
        r103 = false;
        goto L14
    L18:
        return false;
    L17:
        return false;
    }

    public final boolean j() {
        if (this.displayItemType == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.imagesItem == null) goto L7;
        return true;
    }

    public final boolean k() {
        if (this.displayItemType == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.textItem == null) goto L7;
        return true;
    }

    public final g c() {
        return this.format;
    }

    public final y5 d() {
        return this.imagesItem;
    }

    public final boolean e() {
        return this.numberRoll;
    }

    public final m6 f() {
        return this.schemaInfo;
    }

    public final o6 g() {
        return this.textItem;
    }

    public final boolean i() {
        return this.comboFresh;
    }

    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        if (r102 != 1) goto L8;
        this.displayItemType = r100.i();
        goto L3
    L8:
        if (r102 != 100) goto L10;
        this.format = new g(r100);
        goto L3
    L10:
        if (r102 != 50) goto L12;
        this.imagesItem = new y5(r100);
        goto L3
    L12:
        if (r102 != 51) goto L13;
        this.textItem = new o6(r100);
        goto L3
    L13:
        switch(r102) {
            case 20: goto L18;
            case 21: goto L17;
            case 22: goto L16;
            case 23: goto L15;
            default: goto L14;
        };
    L15:
        this.numberRoll = am3.h.a(r100);
        goto L3
    L16:
        this.aggregateInfo = new a(r100);
        goto L3
    L17:
        this.schemaInfo = new m6(r100);
        goto L3
    L18:
        this.comboFresh = am3.h.a(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
    }

    public final void n(o6 r100) {
        this.textItem = r100;
    }
}
