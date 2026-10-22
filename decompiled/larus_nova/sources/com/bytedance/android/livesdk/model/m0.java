package com.bytedance.android.livesdk.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/model/m0;", "", "", "focusID", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "", "layoutType", "I", "c", "()I", ce.f26395j, "(I)V", "ownerIndex", "d", "l", "mixOwnerIndex", "getMixOwnerIndex", ce.f26396k, "scaleType", "getScaleType", "m", "alignMode", "getAlignMode", "f", "isHorizontal", "e", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/livesdk/model/r0;", "content", "Lcom/bytedance/android/livesdk/model/r0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/model/r0;", ce.f26391f, "(Lcom/bytedance/android/livesdk/model/r0;)V", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m0 {

    @SerializedName("align_mode")
    private int alignMode;

    @SerializedName("content")
    private r0 content;

    @SerializedName("focus_id")
    private String focusID;

    @SerializedName("is_horizontal")
    private int isHorizontal;

    @SerializedName("layout_type")
    private int layoutType;

    @SerializedName("mix_owner_index")
    private int mixOwnerIndex;

    @SerializedName("owner_index")
    private int ownerIndex;

    @SerializedName("scale_type")
    private int scaleType;

    public final int hashCode() {
        String r100 = this.focusID;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((r101 * 31) + this.layoutType) * 31) + this.ownerIndex) * 31) + this.scaleType) * 31) + this.alignMode;
    L5:
        r101 = 0;
        goto L7
    }

    public m0() {
        this.focusID = "0";
        this.content = new r0();
    }

    public final r0 a() {
        return this.content;
    }

    public final String b() {
        return this.focusID;
    }

    public final int c() {
        return this.layoutType;
    }

    public final int d() {
        return this.ownerIndex;
    }

    public final int e() {
        return this.isHorizontal;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (Reflection.getOrCreateKotlinClass(r100.getClass()).isInstance(this) == false) goto L26;
        m0 r101 = (m0) r100;
        if ((!Intrinsics.areEqual(this.focusID, r101.focusID)) == false) goto L14;
        return false;
    L14:
        if (this.layoutType == r101.layoutType) goto L17;
        return false;
    L17:
        if (this.ownerIndex == r101.ownerIndex) goto L20;
        return false;
    L20:
        if (this.scaleType == r101.scaleType) goto L23;
        return false;
    L23:
        if (this.alignMode == r101.alignMode) goto L25;
        return false;
    L25:
        return true;
    }

    public final void f(int r100) {
        this.alignMode = r100;
    }

    public final void g(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void h(String r100) {
        this.focusID = r100;
    }

    public final void i(int r100) {
        this.isHorizontal = r100;
    }

    public final void j(int r100) {
        this.layoutType = r100;
    }

    public final void k(int r100) {
        this.mixOwnerIndex = r100;
    }

    public final void l(int r100) {
        this.ownerIndex = r100;
    }

    public final void m(int r100) {
        this.scaleType = r100;
    }
}
