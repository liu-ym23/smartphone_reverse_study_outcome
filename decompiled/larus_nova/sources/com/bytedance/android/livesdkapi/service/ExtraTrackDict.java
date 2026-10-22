package com.bytedance.android.livesdkapi.service;

import gt1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003JX\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010#R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ExtraTrackDict;", "Lgt1/a;", "", "component1", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "toast", "joinFansClubToast", "fromExpandArea", "giftSource", "giftShowFrom", "joinActionFrom", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/livesdkapi/service/ExtraTrackDict;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getJoinFansClubToast", "setJoinFansClubToast", "Ljava/lang/Integer;", "getFromExpandArea", "setFromExpandArea", "(Ljava/lang/Integer;)V", "getGiftSource", "setGiftSource", "getGiftShowFrom", "setGiftShowFrom", "getJoinActionFrom", "setJoinActionFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExtraTrackDict implements a {
    private Integer fromExpandArea;
    private String giftShowFrom;
    private String giftSource;
    private String joinActionFrom;
    private String joinFansClubToast;
    private String toast;

    public ExtraTrackDict() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ExtraTrackDict copy$default(ExtraTrackDict r100, String r101, String r102, Integer r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.getToast();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.getJoinFansClubToast();
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.getFromExpandArea();
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.getGiftSource();
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.getGiftShowFrom();
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.getJoinActionFrom();
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return getToast();
    }

    public final String component2() {
        return getJoinFansClubToast();
    }

    public final Integer component3() {
        return getFromExpandArea();
    }

    public final String component4() {
        return getGiftSource();
    }

    public final String component5() {
        return getGiftShowFrom();
    }

    public final String component6() {
        return getJoinActionFrom();
    }

    public final ExtraTrackDict copy(String r100, String r110, Integer r111, String r112, String r113, String r114) {
        return new ExtraTrackDict(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ExtraTrackDict) == false) goto L18;
        ExtraTrackDict r101 = (ExtraTrackDict) r100;
        if (Intrinsics.areEqual(getToast(), r101.getToast()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getJoinFansClubToast(), r101.getJoinFansClubToast()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getFromExpandArea(), r101.getFromExpandArea()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getGiftSource(), r101.getGiftSource()) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getGiftShowFrom(), r101.getGiftShowFrom()) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(getJoinActionFrom(), r101.getJoinActionFrom()) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = getToast();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = getJoinFansClubToast();
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = getFromExpandArea();
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = getGiftSource();
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = getGiftShowFrom();
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = getJoinActionFrom();
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "ExtraTrackDict(toast=" + getToast() + ", joinFansClubToast=" + getJoinFansClubToast() + ", fromExpandArea=" + getFromExpandArea() + ", giftSource=" + getGiftSource() + ", giftShowFrom=" + getGiftShowFrom() + ", joinActionFrom=" + getJoinActionFrom() + ")";
    }

    public Integer getFromExpandArea() {
        return this.fromExpandArea;
    }

    public String getGiftShowFrom() {
        return this.giftShowFrom;
    }

    public String getGiftSource() {
        return this.giftSource;
    }

    public String getJoinActionFrom() {
        return this.joinActionFrom;
    }

    public String getJoinFansClubToast() {
        return this.joinFansClubToast;
    }

    public String getToast() {
        return this.toast;
    }

    public void setFromExpandArea(Integer r100) {
        this.fromExpandArea = r100;
    }

    public void setGiftShowFrom(String r100) {
        this.giftShowFrom = r100;
    }

    public void setGiftSource(String r100) {
        this.giftSource = r100;
    }

    public void setJoinActionFrom(String r100) {
        this.joinActionFrom = r100;
    }

    public void setJoinFansClubToast(String r100) {
        this.joinFansClubToast = r100;
    }

    public void setToast(String r100) {
        this.toast = r100;
    }

    public ExtraTrackDict(String r100, String r101, Integer r102, String r103, String r104, String r105) {
        this.toast = r100;
        this.joinFansClubToast = r101;
        this.fromExpandArea = r102;
        this.giftSource = r103;
        this.giftShowFrom = r104;
        this.joinActionFrom = r105;
    }

    public /* synthetic */ ExtraTrackDict(String r100, String r101, Integer r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
