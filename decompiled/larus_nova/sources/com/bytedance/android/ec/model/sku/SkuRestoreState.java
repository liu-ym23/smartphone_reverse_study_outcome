package com.bytedance.android.ec.model.sku;

import com.bytedance.android.shopping.anchorv3.a;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00106\u001a\u00020\u0010J\u0006\u00107\u001a\u00020\u0000J\u0006\u00108\u001a\u00020\u0010J\u0006\u00109\u001a\u00020\u0017J\u001f\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u00032\b\u0010=\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010>J_\u0010?\u001a\u00020;2\u0010\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010,2\b\u0010A\u001a\u0004\u0018\u00010#2\b\u0010B\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010F\u001a\u00020\u0003¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u0004R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR6\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,@FX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00103\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "Ljava/io/Serializable;", "specGroupCount", "", "(I)V", "addCartGuide", "Lcom/bytedance/android/ec/model/sku/SkuStateAddCartGuideInfo;", "getAddCartGuide", "()Lcom/bytedance/android/ec/model/sku/SkuStateAddCartGuideInfo;", "setAddCartGuide", "(Lcom/bytedance/android/ec/model/sku/SkuStateAddCartGuideInfo;)V", "backType", "getBackType", "()I", "setBackType", "canAddCart", "", "getCanAddCart", "()Ljava/lang/Boolean;", "setCanAddCart", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checkNames", "", "getCheckNames", "()Ljava/lang/String;", "setCheckNames", "(Ljava/lang/String;)V", "lastBehavior", "getLastBehavior", "setLastBehavior", "lowerLimit", "getLowerLimit", "setLowerLimit", "productCount", "", "getProductCount", "()J", "setProductCount", "(J)V", "selectAvatar", "getSelectAvatar", "setSelectAvatar", "value", "", "selectSkuKeys", "getSelectSkuKeys", "()[Ljava/lang/String;", "setSelectSkuKeys", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "selectedSkuId", "getSelectedSkuId", "setSelectedSkuId", "allSelected", "deepCopy", "hasSelectedSku", "joinedKey", "saveAddCartGuideInfo", "", "guideType", "guideText", "(Ljava/lang/Integer;Ljava/lang/String;)V", "saveSelectedSpec", "specKeys", "count", "skuId", "checkedNames", "currentAvatar", "currentCanAddCart", "currentLowerLimit", "([Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;I)V", "setElementToNull", "index", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuRestoreState implements Serializable {
    private SkuStateAddCartGuideInfo addCartGuide;
    private int backType;
    private Boolean canAddCart;
    private String checkNames;
    private String lastBehavior;
    private int lowerLimit;
    private long productCount;
    private String selectAvatar;
    private String[] selectSkuKeys;
    private String selectedSkuId;
    private int specGroupCount;

    public final boolean allSelected() {
        String[] r100 = this.selectSkuKeys;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (a.b(r100[r102]) == false) goto L12;
        r102 = r102 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    public final SkuRestoreState deepCopy() {
        SkuRestoreState r100 = new SkuRestoreState(this.selectSkuKeys.length);
        String[] r101 = this.selectSkuKeys;
        r100.setSelectSkuKeys((String[]) Arrays.copyOf(r101, r101.length));
        r100.productCount = this.productCount;
        r100.selectedSkuId = this.selectedSkuId;
        return r100;
    }

    public final boolean hasSelectedSku() {
        String[] r100 = this.selectSkuKeys;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L19;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L14;
        r102 = r102 + 1;
        goto L3
    L14:
        return true;
    L7:
        if (r103.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        r104 = true;
        goto L13
    L9:
        r105 = false;
        goto L10
    L19:
        return false;
    }

    public final String joinedKey() {
        if (allSelected() == false) goto L18;
        String[] r100 = this.selectSkuKeys;
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "";
    L11:
        if (r100.length != 1) goto L15;
        String r102 = r100[0];
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L15:
        r102 = ArraysKt.joinToString$default(r100, "_", null, null, 0, null, null, 62, null);
        goto L17
    L7:
        r101 = false;
        goto L8
    L18:
        return "";
    }

    public final SkuStateAddCartGuideInfo getAddCartGuide() {
        return this.addCartGuide;
    }

    public final int getBackType() {
        return this.backType;
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final String getCheckNames() {
        return this.checkNames;
    }

    public final String getLastBehavior() {
        return this.lastBehavior;
    }

    public final int getLowerLimit() {
        return this.lowerLimit;
    }

    public final long getProductCount() {
        return this.productCount;
    }

    public final String getSelectAvatar() {
        return this.selectAvatar;
    }

    public final String[] getSelectSkuKeys() {
        return this.selectSkuKeys;
    }

    public final String getSelectedSkuId() {
        return this.selectedSkuId;
    }

    public SkuRestoreState(int r100) {
        this.specGroupCount = r100;
        this.selectSkuKeys = new String[r100];
        this.lowerLimit = 1;
    }

    public final void setAddCartGuide(SkuStateAddCartGuideInfo r100) {
        this.addCartGuide = r100;
    }

    public final void setBackType(int r100) {
        this.backType = r100;
    }

    public final void setCanAddCart(Boolean r100) {
        this.canAddCart = r100;
    }

    public final void setCheckNames(String r100) {
        this.checkNames = r100;
    }

    public final void setElementToNull(int r100) {
        String[] r101 = this.selectSkuKeys;
        if (r101.length <= r100) goto L6;
        r101[r100] = null;
        this.selectedSkuId = null;
        return;
    }

    public final void setLastBehavior(String r100) {
        this.lastBehavior = r100;
    }

    public final void setLowerLimit(int r100) {
        this.lowerLimit = r100;
    }

    public final void setProductCount(long r100) {
        this.productCount = r100;
    }

    public final void setSelectAvatar(String r100) {
        this.selectAvatar = r100;
    }

    public final void setSelectSkuKeys(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.selectSkuKeys = r100;
        this.specGroupCount = r100.length;
    }

    public final void setSelectedSkuId(String r100) {
        this.selectedSkuId = r100;
    }

    public final void saveAddCartGuideInfo(Integer r100, String r101) {
        if (r100 == null) goto L8;
        r100.intValue();
        if (r101 != null) goto L6;
        return;
    L6:
        this.addCartGuide = new SkuStateAddCartGuideInfo(r100.intValue(), r101, null, 4, null);
        return;
    }

    public final void saveSelectedSpec(String[] r100, Long r101, String r102, String r103, String r104, Boolean r105, int r106) {
        if (r100 == null) goto L4;
        setSelectSkuKeys(r100);
    L4:
        if (r101 == null) goto L6;
        this.productCount = r101.longValue();
    L6:
        this.selectedSkuId = r102;
        if (r104 == null) goto L9;
        this.selectAvatar = r104;
    L9:
        if (r103 != null) goto L11;
    L13:
        this.canAddCart = r105;
        this.lowerLimit = r106;
        return;
    L11:
        if (StringsKt.startsWith$default(r103, "请选择", false, 2, null) == true) goto L13;
        this.checkNames = r103;
        goto L13
    }

    public static /* synthetic */ void saveSelectedSpec$default(SkuRestoreState r110, String[] r111, Long r112, String r113, String r114, String r115, Boolean r116, int r117, int r118, Object r119) {
        if ((r118 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r118 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r118 & 32) == 0) goto L13;
        Boolean r102 = null;
    L15:
        if ((r118 & 64) == 0) goto L17;
        int r103 = 1;
    L18:
        r110.saveSelectedSpec(r111, r112, r113, r100, r101, r102, r103);
        return;
    L17:
        r103 = r117;
        goto L18
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
