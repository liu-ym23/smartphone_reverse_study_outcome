package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.BattleSeasonPKResultMessage.UpgradeResult")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IUpGradeResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w9;", "Lpy/k;", "upgradeImg", "Lpy/k;", "getUpgradeImg", "()Lpy/k;", "setUpgradeImg", "(Lpy/k;)V", "gradeImg", "getGradeImg", "setGradeImg", "descBgImg", "getDescBgImg", "setDescBgImg", "beforeGradeImg", "getBeforeGradeImg", "setBeforeGradeImg", "", "upradeDesc$delegate", "Ljava/lang/Object;", "getUpradeDesc", "()Ljava/lang/String;", "upradeDesc", "preGradeDesc$delegate", "getPreGradeDesc", "preGradeDesc", "afterGradeDesc$delegate", "getAfterGradeDesc", "afterGradeDesc", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IUpGradeResultFlexImpl extends FlexModelBase<w9> implements w9, vh7.h {

    @SerializedName("after_grade_desc")
    protected String _$$afterGradeDesc;

    @SerializedName("pre_grade_desc")
    protected String _$$preGradeDesc;

    @SerializedName("upgrade_desc")
    protected String _$$upradeDesc;

    @SerializedName("before_upgrade_img")
    protected py.k beforeGradeImg;

    @SerializedName("desc_bg_img")
    protected py.k descBgImg;

    @SerializedName("grade_img")
    protected py.k gradeImg;

    @SerializedName("upgrade_img")
    protected py.k upgradeImg;

    public IUpGradeResultFlexImpl() {
        super(w9.class);
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public IUpGradeResultFlexImpl(am3.g r100) {
        super(w9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this.beforeGradeImg = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        this._$$afterGradeDesc = am3.h.c(r100);
        goto L3
    L10:
        this._$$preGradeDesc = am3.h.c(r100);
        goto L3
    L11:
        this.descBgImg = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        this._$$upradeDesc = am3.h.c(r100);
        goto L3
    L13:
        this.upgradeImg = vh7.f.a(r100, py.k.class);
        goto L3
    L14:
        this.gradeImg = vh7.f.a(r100, py.k.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public final String getAfterGradeDesc() {
        return this._$$afterGradeDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public py.k getBeforeGradeImg() {
        return this.beforeGradeImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public py.k getDescBgImg() {
        return this.descBgImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public py.k getGradeImg() {
        return this.gradeImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public final String getPreGradeDesc() {
        return this._$$preGradeDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public py.k getUpgradeImg() {
        return this.upgradeImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.w9
    public final String getUpradeDesc() {
        return this._$$upradeDesc;
    }

    public void setBeforeGradeImg(py.k r100) {
        this.beforeGradeImg = r100;
    }

    public void setDescBgImg(py.k r100) {
        this.descBgImg = r100;
    }

    public void setGradeImg(py.k r100) {
        this.gradeImg = r100;
    }

    public void setUpgradeImg(py.k r100) {
        this.upgradeImg = r100;
    }
}
