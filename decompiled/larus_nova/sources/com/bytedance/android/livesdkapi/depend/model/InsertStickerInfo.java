package com.bytedance.android.livesdkapi.depend.model;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003Jg\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/InsertStickerInfo;", "", "insertType", "Lcom/bytedance/android/livesdkapi/depend/model/InsertEffectType;", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "insertTabKey", "", "shouldForcePopUp", "", "shouldForceShowDialog", "newDialog", "secondaryTabKey", "shouldForceInsert", "(Lcom/bytedance/android/livesdkapi/depend/model/InsertEffectType;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;Lcom/ss/android/ugc/effectmanager/effect/model/Effect;Ljava/lang/String;ZZZLjava/lang/String;Z)V", "getEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getInsertTabKey", "()Ljava/lang/String;", "getInsertType", "()Lcom/bytedance/android/livesdkapi/depend/model/InsertEffectType;", "getNewDialog", "()Z", "getSecondaryTabKey", "getShouldForceInsert", "getShouldForcePopUp", "getShouldForceShowDialog", "getSticker", "()Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InsertStickerInfo {
    private final Effect effect;
    private final String insertTabKey;
    private final InsertEffectType insertType;
    private final boolean newDialog;
    private final String secondaryTabKey;
    private final boolean shouldForceInsert;
    private final boolean shouldForcePopUp;
    private final boolean shouldForceShowDialog;
    private final Sticker sticker;

    public static /* synthetic */ InsertStickerInfo copy$default(InsertStickerInfo r110, InsertEffectType r111, Sticker r112, Effect r113, String r114, boolean r115, boolean r116, boolean r117, String r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        InsertEffectType r100 = r110.insertType;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Sticker r101 = r110.sticker;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Effect r102 = r110.effect;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.insertTabKey;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.shouldForcePopUp;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.shouldForceShowDialog;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.newDialog;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.secondaryTabKey;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.shouldForceInsert;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final InsertEffectType component1() {
        return this.insertType;
    }

    public final Sticker component2() {
        return this.sticker;
    }

    public final Effect component3() {
        return this.effect;
    }

    public final String component4() {
        return this.insertTabKey;
    }

    public final boolean component5() {
        return this.shouldForcePopUp;
    }

    public final boolean component6() {
        return this.shouldForceShowDialog;
    }

    public final boolean component7() {
        return this.newDialog;
    }

    public final String component8() {
        return this.secondaryTabKey;
    }

    public final boolean component9() {
        return this.shouldForceInsert;
    }

    public final InsertStickerInfo copy(InsertEffectType r110, Sticker r111, Effect r112, String r113, boolean r114, boolean r115, boolean r116, String r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "insertType");
        Intrinsics.checkNotNullParameter(r113, "insertTabKey");
        Intrinsics.checkNotNullParameter(r117, "secondaryTabKey");
        return new InsertStickerInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InsertStickerInfo) == false) goto L24;
        InsertStickerInfo r101 = (InsertStickerInfo) r100;
        if (Intrinsics.areEqual(this.insertType, r101.insertType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sticker, r101.sticker) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.insertTabKey, r101.insertTabKey) == true) goto L14;
        return false;
    L14:
        if (this.shouldForcePopUp == r101.shouldForcePopUp) goto L16;
        return false;
    L16:
        if (this.shouldForceShowDialog == r101.shouldForceShowDialog) goto L18;
        return false;
    L18:
        if (this.newDialog == r101.newDialog) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.secondaryTabKey, r101.secondaryTabKey) == true) goto L22;
        return false;
    L22:
        if (this.shouldForceInsert == r101.shouldForceInsert) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        InsertEffectType r100 = this.insertType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Sticker r104 = this.sticker;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Effect r107 = this.effect;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.insertTabKey;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.shouldForcePopUp;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        boolean r117 = this.shouldForceShowDialog;
        ?? r118 = r117;
        if (r117 == false) goto L24;
        r118 = 1;
    L24:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.newDialog;
        ?? r121 = r120;
        if (r120 == false) goto L27;
        r121 = 1;
    L27:
        int r122 = (r119 + r121) * 31;
        String r123 = this.secondaryTabKey;
        if (r123 == null) goto L30;
        r101 = r123.hashCode();
    L30:
        int r124 = (r122 + r101) * 31;
        boolean r125 = this.shouldForceInsert;
        if (r125 == true) goto L35;
        r114 = r125;
    L35:
        return r124 + r114;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InsertStickerInfo(insertType=" + this.insertType + ", sticker=" + this.sticker + ", effect=" + this.effect + ", insertTabKey=" + this.insertTabKey + ", shouldForcePopUp=" + this.shouldForcePopUp + ", shouldForceShowDialog=" + this.shouldForceShowDialog + ", newDialog=" + this.newDialog + ", secondaryTabKey=" + this.secondaryTabKey + ", shouldForceInsert=" + this.shouldForceInsert + ")";
    }

    public final Effect getEffect() {
        return this.effect;
    }

    public final String getInsertTabKey() {
        return this.insertTabKey;
    }

    public final InsertEffectType getInsertType() {
        return this.insertType;
    }

    public final boolean getNewDialog() {
        return this.newDialog;
    }

    public final String getSecondaryTabKey() {
        return this.secondaryTabKey;
    }

    public final boolean getShouldForceInsert() {
        return this.shouldForceInsert;
    }

    public final boolean getShouldForcePopUp() {
        return this.shouldForcePopUp;
    }

    public final boolean getShouldForceShowDialog() {
        return this.shouldForceShowDialog;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    public InsertStickerInfo(InsertEffectType r100, Sticker r101, Effect r102, String r103, boolean r104, boolean r105, boolean r106, String r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "insertType");
        Intrinsics.checkNotNullParameter(r103, "insertTabKey");
        Intrinsics.checkNotNullParameter(r107, "secondaryTabKey");
        this.insertType = r100;
        this.sticker = r101;
        this.effect = r102;
        this.insertTabKey = r103;
        this.shouldForcePopUp = r104;
        this.shouldForceShowDialog = r105;
        this.newDialog = r106;
        this.secondaryTabKey = r107;
        this.shouldForceInsert = r110;
    }

    public /* synthetic */ InsertStickerInfo(InsertEffectType r110, Sticker r111, Effect r112, String r113, boolean r114, boolean r115, boolean r210, String r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 64) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r213 & 128) == 0) goto L9;
        String r117 = "";
    L11:
        if ((r213 & 256) == 0) goto L13;
        boolean r118 = false;
    L14:
        this(r110, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L13:
        r118 = r212;
        goto L14
    L9:
        r117 = r211;
        goto L11
    L5:
        r116 = r210;
        goto L7
    }
}
