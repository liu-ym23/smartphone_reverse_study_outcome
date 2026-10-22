package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletList;", "", "appletList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "signaturePublicKeyVersion", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppletList", "()Ljava/util/List;", "getSignaturePublicKeyVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformAppletList {

    @SerializedName("applet_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformAppletItem> appletList;

    @SerializedName("sign_public_key_version")
    private final String signaturePublicKeyVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformAppletList() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformAppletList copy$default(OpenPlatformAppletList r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appletList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.signaturePublicKeyVersion;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<OpenPlatformAppletItem> component1() {
        return this.appletList;
    }

    public final String component2() {
        return this.signaturePublicKeyVersion;
    }

    public final OpenPlatformAppletList copy(List<OpenPlatformAppletItem> r100, String r101) {
        return new OpenPlatformAppletList(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformAppletList) == true) goto L8;
        return false;
    L8:
        OpenPlatformAppletList r101 = (OpenPlatformAppletList) r100;
        if (Intrinsics.areEqual(this.appletList, r101.appletList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signaturePublicKeyVersion, r101.signaturePublicKeyVersion) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<OpenPlatformAppletItem> r100 = this.appletList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.signaturePublicKeyVersion;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformAppletList(appletList=" + this.appletList + ", signaturePublicKeyVersion=" + this.signaturePublicKeyVersion + ')';
    }

    public final List<OpenPlatformAppletItem> getAppletList() {
        return this.appletList;
    }

    public final String getSignaturePublicKeyVersion() {
        return this.signaturePublicKeyVersion;
    }

    public OpenPlatformAppletList(List<OpenPlatformAppletItem> r100, String r101) {
        this.appletList = r100;
        this.signaturePublicKeyVersion = r101;
    }

    public /* synthetic */ OpenPlatformAppletList(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
