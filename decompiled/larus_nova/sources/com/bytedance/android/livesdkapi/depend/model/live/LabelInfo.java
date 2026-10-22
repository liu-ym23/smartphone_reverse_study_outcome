package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LabelInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JM\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo;", "labelType", "", "displayType", "spliceLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/SpliceLabel;", "wholeLabel", "Lcom/bytedance/android/live/base/model/ImageModel;", "extra", "", "profilePicSpliceLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/ProfilePicSpliceLabel;", "(JJLcom/bytedance/android/livesdkapi/depend/model/live/SpliceLabel;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/live/ProfilePicSpliceLabel;)V", "getDisplayType", "()J", "getExtra", "()Ljava/lang/String;", "getLabelType", "setLabelType", "(J)V", "getProfilePicSpliceLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ProfilePicSpliceLabel;", "getSpliceLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/SpliceLabel;", "getWholeLabel", "()Lcom/bytedance/android/live/base/model/ImageModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LabelInfo extends FlexModelBase<ILabelInfo> implements ILabelInfo, h {

    @SerializedName("display_type")
    protected long displayType;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("label_type")
    protected long labelType;

    @SerializedName("profile_pic_splice_label")
    protected ProfilePicSpliceLabel profilePicSpliceLabel;

    @SerializedName("splice_label")
    protected SpliceLabel spliceLabel;

    @SerializedName("whole_label")
    protected ImageModel wholeLabel;

    public LabelInfo(long r100, long r101, SpliceLabel r102, ImageModel r103, String r104, ProfilePicSpliceLabel r105) {
        super(ILabelInfo.class);
        this.labelType = r100;
        this.displayType = r101;
        this.spliceLabel = r102;
        this.wholeLabel = r103;
        this.extra = r104;
        this.profilePicSpliceLabel = r105;
    }

    public static /* synthetic */ LabelInfo copy$default(LabelInfo r100, long r101, long r110, SpliceLabel r111, ImageModel r112, String r113, ProfilePicSpliceLabel r114, int r115, Object r116) {
        if ((r115 & 1) == 0) goto L5;
        long r102 = r100.getLabelType();
    L7:
        if ((r115 & 2) == 0) goto L9;
        long r103 = r100.getDisplayType();
    L11:
        if ((r115 & 4) == 0) goto L13;
        SpliceLabel r104 = r100.getSpliceLabel();
    L15:
        if ((r115 & 8) == 0) goto L17;
        ImageModel r105 = r100.getWholeLabel();
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r106 = r100.getExtra();
    L23:
        if ((r115 & 32) == 0) goto L25;
        ProfilePicSpliceLabel r107 = r100.getProfilePicSpliceLabel();
    L27:
        return r100.copy(r102, r103, r104, r105, r106, r107);
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return getLabelType();
    }

    public final long component2() {
        return getDisplayType();
    }

    public final SpliceLabel component3() {
        return getSpliceLabel();
    }

    public final ImageModel component4() {
        return getWholeLabel();
    }

    public final String component5() {
        return getExtra();
    }

    public final ProfilePicSpliceLabel component6() {
        return getProfilePicSpliceLabel();
    }

    public final LabelInfo copy(long r110, long r111, SpliceLabel r112, ImageModel r113, String r114, ProfilePicSpliceLabel r115) {
        return new LabelInfo(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LabelInfo) == false) goto L18;
        LabelInfo r101 = (LabelInfo) r100;
        if (getLabelType() == r101.getLabelType()) goto L8;
        return false;
    L8:
        if (getDisplayType() == r101.getDisplayType()) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getSpliceLabel(), r101.getSpliceLabel()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getWholeLabel(), r101.getWholeLabel()) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getExtra(), r101.getExtra()) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(getProfilePicSpliceLabel(), r101.getProfilePicSpliceLabel()) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        long r100 = getLabelType();
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = getDisplayType();
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        SpliceLabel r104 = getSpliceLabel();
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        ImageModel r108 = getWholeLabel();
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = getExtra();
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        ProfilePicSpliceLabel r114 = getProfilePicSpliceLabel();
        if (r114 == null) goto L18;
        r105 = r114.hashCode();
    L18:
        return r113 + r105;
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public String toString() {
        return "LabelInfo(labelType=" + getLabelType() + ", displayType=" + getDisplayType() + ", spliceLabel=" + getSpliceLabel() + ", wholeLabel=" + getWholeLabel() + ", extra=" + getExtra() + ", profilePicSpliceLabel=" + getProfilePicSpliceLabel() + ")";
    }

    public LabelInfo() {
        super(ILabelInfo.class);
        ILabelInfo.Companion r100 = ILabelInfo.Companion;
        this.labelType = r100.getTYPE_UNKNOWN();
        this.displayType = r100.getDISPLAY_TYPE_UNKNOWN();
        this.spliceLabel = null;
        this.wholeLabel = null;
        this.extra = null;
        this.profilePicSpliceLabel = null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public /* bridge */ /* synthetic */ IProfilePicSpliceLabel getProfilePicSpliceLabel() {
        return getProfilePicSpliceLabel();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public /* bridge */ /* synthetic */ ISpliceLabel getSpliceLabel() {
        return getSpliceLabel();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public /* bridge */ /* synthetic */ k getWholeLabel() {
        return getWholeLabel();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public long getDisplayType() {
        return this.displayType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public long getLabelType() {
        return this.labelType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public ProfilePicSpliceLabel getProfilePicSpliceLabel() {
        return this.profilePicSpliceLabel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public SpliceLabel getSpliceLabel() {
        return this.spliceLabel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public ImageModel getWholeLabel() {
        return this.wholeLabel;
    }

    public LabelInfo(g r100) {
        super(ILabelInfo.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.profilePicSpliceLabel = new ProfilePicSpliceLabel(r100);
        goto L3
    L9:
        this.extra = am3.h.c(r100);
        goto L3
    L10:
        this.wholeLabel = x.a(r100);
        goto L3
    L11:
        this.spliceLabel = new SpliceLabel(r100);
        goto L3
    L12:
        this.displayType = r100.j();
        r101 = r101 | 2;
        goto L3
    L13:
        this.labelType = r100.j();
        r101 = r101 | 1;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L14:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L18;
        this.labelType = ILabelInfo.Companion.getTYPE_UNKNOWN();
    L18:
        if ((r101 & 2) != 0) goto L21;
        this.displayType = ILabelInfo.Companion.getDISPLAY_TYPE_UNKNOWN();
    L21:
        if (this.spliceLabel != null) goto L24;
        this.spliceLabel = null;
    L24:
        if (this.wholeLabel != null) goto L27;
        this.wholeLabel = null;
    L27:
        if (this.extra != null) goto L30;
        this.extra = null;
    L30:
        if (this.profilePicSpliceLabel != null) goto L49;
        this.profilePicSpliceLabel = null;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo
    public void setLabelType(long r100) {
        this.labelType = r100;
    }

    public /* synthetic */ LabelInfo(long r110, long r111, SpliceLabel r112, ImageModel r113, String r114, ProfilePicSpliceLabel r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        long r100 = ILabelInfo.Companion.getTYPE_UNKNOWN();
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r101 = ILabelInfo.Companion.getDISPLAY_TYPE_UNKNOWN();
    L10:
        ProfilePicSpliceLabel r102 = null;
        if ((r116 & 4) == 0) goto L13;
        SpliceLabel r103 = null;
    L15:
        if ((r116 & 8) == 0) goto L17;
        ImageModel r104 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r116 & 32) != 0) goto L26;
        r102 = r115;
    L26:
        this(r100, r101, r103, r104, r105, r102);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
