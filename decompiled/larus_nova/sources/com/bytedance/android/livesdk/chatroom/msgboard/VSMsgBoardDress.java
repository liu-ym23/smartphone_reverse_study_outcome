package com.bytedance.android.livesdk.chatroom.msgboard;

import am3.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010$\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R\"\u0010*\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R$\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u0011\u00101\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/msgboard/VSMsgBoardDress;", "", "", "dressId", "J", "getDressId", "()J", "setDressId", "(J)V", "entityId", "getEntityId", "setEntityId", "", "dressType", "I", "getDressType", "()I", "setDressType", "(I)V", "", "dressName", "Ljava/lang/String;", "getDressName", "()Ljava/lang/String;", "setDressName", "(Ljava/lang/String;)V", "Lpy/k;", "badgeMiniIcon", "Lpy/k;", "getBadgeMiniIcon", "()Lpy/k;", "setBadgeMiniIcon", "(Lpy/k;)V", "dressImage", "getDressImage", "setDressImage", "dressColor", "getDressColor", "setDressColor", "paidType", "getPaidType", "setPaidType", "hasPaid", "getHasPaid", "setHasPaid", "badgeDetailInfo", "getBadgeDetailInfo", "setBadgeDetailInfo", "", "isFree", "()Z", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardDress implements h {

    @SerializedName("badge_detail_info")
    protected String badgeDetailInfo;

    @SerializedName("badge_mini_icon")
    protected k badgeMiniIcon;

    @SerializedName("dress_color")
    protected String dressColor;

    @SerializedName("dress_id")
    protected long dressId;

    @SerializedName("dress_image")
    protected k dressImage;

    @SerializedName("dress_name")
    protected String dressName;

    @SerializedName("dress_type")
    protected int dressType;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    protected long entityId;

    @SerializedName("has_paid")
    protected int hasPaid;

    @SerializedName("paid_type")
    protected int paidType;

    public final boolean isFree() {
        int r100 = this.paidType;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    public VSMsgBoardDress() {
        this.dressName = "";
        this.dressColor = "";
    }

    public final String getBadgeDetailInfo() {
        return this.badgeDetailInfo;
    }

    public final k getBadgeMiniIcon() {
        return this.badgeMiniIcon;
    }

    public final String getDressColor() {
        return this.dressColor;
    }

    public final long getDressId() {
        return this.dressId;
    }

    public final k getDressImage() {
        return this.dressImage;
    }

    public final String getDressName() {
        return this.dressName;
    }

    public final int getDressType() {
        return this.dressType;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final int getHasPaid() {
        return this.hasPaid;
    }

    public final int getPaidType() {
        return this.paidType;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public VSMsgBoardDress(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.badgeDetailInfo = am3.h.c(r100);
        goto L3
    L8:
        this.hasPaid = r100.i();
        goto L3
    L9:
        this.dressColor = am3.h.c(r100);
        goto L3
    L10:
        this.badgeMiniIcon = f.a(r100, k.class);
        goto L3
    L11:
        this.dressImage = f.a(r100, k.class);
        goto L3
    L12:
        this.dressName = am3.h.c(r100);
        goto L3
    L13:
        this.paidType = r100.i();
        goto L3
    L14:
        this.dressType = r100.i();
        goto L3
    L15:
        this.entityId = r100.j();
        goto L3
    L16:
        this.dressId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.dressName != null) goto L21;
        this.dressName = "";
    L21:
        if (this.dressColor != null) goto L48;
        this.dressColor = "";
        return;
    }

    public final void setBadgeDetailInfo(String r100) {
        this.badgeDetailInfo = r100;
    }

    public final void setBadgeMiniIcon(k r100) {
        this.badgeMiniIcon = r100;
    }

    public final void setDressColor(String r100) {
        this.dressColor = r100;
    }

    public final void setDressId(long r100) {
        this.dressId = r100;
    }

    public final void setDressImage(k r100) {
        this.dressImage = r100;
    }

    public final void setDressName(String r100) {
        this.dressName = r100;
    }

    public final void setDressType(int r100) {
        this.dressType = r100;
    }

    public final void setEntityId(long r100) {
        this.entityId = r100;
    }

    public final void setHasPaid(int r100) {
        this.hasPaid = r100;
    }

    public final void setPaidType(int r100) {
        this.paidType = r100;
    }
}
