package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/vc1;", "", "", "enableNewCardLayout", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "enableNewPosterCover", "b", "enableShowSupplementTitle", "c", "", "enableUpdateRightCardPlaceholderOpt", "Z", "d", "()Z", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class vc1 {

    @SerializedName("enable_new_card_layout")
    private final int enableNewCardLayout;

    @SerializedName("enable_new_poster_cover")
    private final int enableNewPosterCover;

    @SerializedName("enable_show_supplement_title")
    private final int enableShowSupplementTitle;

    @SerializedName("enable_update_right_card_placeholder_opt")
    private final boolean enableUpdateRightCardPlaceholderOpt;

    public vc1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof vc1) == false) goto L14;
        vc1 r101 = (vc1) r100;
        if (this.enableNewCardLayout == r101.enableNewCardLayout) goto L8;
        return false;
    L8:
        if (this.enableNewPosterCover == r101.enableNewPosterCover) goto L10;
        return false;
    L10:
        if (this.enableShowSupplementTitle == r101.enableShowSupplementTitle) goto L12;
        return false;
    L12:
        if (this.enableUpdateRightCardPlaceholderOpt == r101.enableUpdateRightCardPlaceholderOpt) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        int r100 = ((((this.enableNewCardLayout * 31) + this.enableNewPosterCover) * 31) + this.enableShowSupplementTitle) * 31;
        boolean r101 = this.enableUpdateRightCardPlaceholderOpt;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "OpenPlatformMicroAppExplainCardConfig(enableNewCardLayout=" + this.enableNewCardLayout + ", enableNewPosterCover=" + this.enableNewPosterCover + ", enableShowSupplementTitle=" + this.enableShowSupplementTitle + ", enableUpdateRightCardPlaceholderOpt=" + this.enableUpdateRightCardPlaceholderOpt + ")";
    }

    public final int a() {
        return this.enableNewCardLayout;
    }

    public final int b() {
        return this.enableNewPosterCover;
    }

    public final int c() {
        return this.enableShowSupplementTitle;
    }

    public final boolean d() {
        return this.enableUpdateRightCardPlaceholderOpt;
    }

    public vc1(int r100) {
        this.enableNewCardLayout = 0;
        this.enableNewPosterCover = 0;
        this.enableShowSupplementTitle = 0;
        this.enableUpdateRightCardPlaceholderOpt = true;
    }
}
