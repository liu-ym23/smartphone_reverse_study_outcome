package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveNativeSiteConfig;", "Ljava/io/Serializable;", "renderType", "", "geckoChannel", "", "lynxScheme", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getGeckoChannel", "()Ljava/util/List;", "getLynxScheme", "()Ljava/lang/String;", "getRenderType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveNativeSiteConfig implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;

    @SerializedName("gecko_channel")
    private final List<String> geckoChannel;

    @SerializedName("lynx_scheme")
    private final String lynxScheme;

    @SerializedName("render_type")
    private final String renderType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveNativeSiteConfig$Companion;", "", "()V", "serialVersionUID", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LiveNativeSiteConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveNativeSiteConfig copy$default(LiveNativeSiteConfig r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.renderType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.geckoChannel;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.lynxScheme;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.renderType;
    }

    public final List<String> component2() {
        return this.geckoChannel;
    }

    public final String component3() {
        return this.lynxScheme;
    }

    public final LiveNativeSiteConfig copy(String r100, List<String> r101, String r102) {
        return new LiveNativeSiteConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveNativeSiteConfig) == false) goto L12;
        LiveNativeSiteConfig r101 = (LiveNativeSiteConfig) r100;
        if (Intrinsics.areEqual(this.renderType, r101.renderType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.geckoChannel, r101.geckoChannel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxScheme, r101.lynxScheme) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.renderType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.geckoChannel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lynxScheme;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveNativeSiteConfig(renderType=" + this.renderType + ", geckoChannel=" + this.geckoChannel + ", lynxScheme=" + this.lynxScheme + ")";
    }

    public final List<String> getGeckoChannel() {
        return this.geckoChannel;
    }

    public final String getLynxScheme() {
        return this.lynxScheme;
    }

    public final String getRenderType() {
        return this.renderType;
    }

    public LiveNativeSiteConfig(String r100, List<String> r101, String r102) {
        this.renderType = r100;
        this.geckoChannel = r101;
        this.lynxScheme = r102;
    }

    public /* synthetic */ LiveNativeSiteConfig(String r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
