package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowBannerData;", "", "canShow", "", "renderParams", "", "", "schemaUrl", "Landroid/net/Uri;", "(ZLjava/util/Map;Landroid/net/Uri;)V", "getCanShow", "()Z", "getRenderParams", "()Ljava/util/Map;", "getSchemaUrl", "()Landroid/net/Uri;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowBannerData {
    private final boolean canShow;
    private final Map<String, Object> renderParams;
    private final Uri schemaUrl;

    public ShowBannerData() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowBannerData copy$default(ShowBannerData r100, boolean r101, Map r102, Uri r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.canShow;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.renderParams;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.schemaUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final Map<String, Object> component2() {
        return this.renderParams;
    }

    public final Uri component3() {
        return this.schemaUrl;
    }

    public final ShowBannerData copy(boolean r100, Map<String, ? extends Object> r101, Uri r102) {
        return new ShowBannerData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowBannerData) == false) goto L12;
        ShowBannerData r101 = (ShowBannerData) r100;
        if (this.canShow == r101.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.renderParams, r101.renderParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schemaUrl, r101.schemaUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.canShow;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Map<String, Object> r103 = this.renderParams;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        Uri r107 = this.schemaUrl;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "ShowBannerData(canShow=" + this.canShow + ", renderParams=" + this.renderParams + ", schemaUrl=" + this.schemaUrl + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final Map<String, Object> getRenderParams() {
        return this.renderParams;
    }

    public final Uri getSchemaUrl() {
        return this.schemaUrl;
    }

    public ShowBannerData(boolean r100, Map<String, ? extends Object> r101, Uri r102) {
        this.canShow = r100;
        this.renderParams = r101;
        this.schemaUrl = r102;
    }

    public /* synthetic */ ShowBannerData(boolean r100, Map r101, Uri r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
