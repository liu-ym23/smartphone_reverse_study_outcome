package com.bytedance.android.sdk.bdticketguard;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00060"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/d;", "", "", "scene", "Ljava/lang/String;", "b", "()Ljava/lang/String;", OfficeSDKRequestTag.KEY_NEW_USER, "(Ljava/lang/String;)V", "", "isDeleteOldKey", "Z", "()Z", "f", "(Z)V", "challenge", "getChallenge", "e", "isGenerateKey", "h", "", "certChainSize", "I", "getCertChainSize", "()I", "d", "(I)V", "attestationAdapter", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "oldAdapter", "getOldAdapter", "l", "hasKey", "getHasKey", RXScreenCaptureService.KEY_INDEX, "isTeeChanged", "o", "isReeChanged", "m", "hasResult", "getHasResult", ce.f26395j, "isNeedUpgrade", ce.f26396k, "extraAppData", "getExtraAppData", ce.f26391f, "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Throwable f163568a;

    @SerializedName("attestation_adapter")
    private String attestationAdapter;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Set<String> f163569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f163570c;

    @SerializedName("cert_chain_size")
    private int certChainSize;

    @SerializedName("challenge")
    private String challenge;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f163571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f163572e;

    @SerializedName("extra_app_data")
    private String extraAppData;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient String f163573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient String f163574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Throwable f163575h;

    @SerializedName("has_key")
    private boolean hasKey;

    @SerializedName("has_result")
    private boolean hasResult;

    @SerializedName("is_delete_old_key")
    private boolean isDeleteOldKey;

    @SerializedName("is_generate_key")
    private boolean isGenerateKey;

    @SerializedName("is_need_upgrade")
    private boolean isNeedUpgrade;

    @SerializedName("is_ree_changed")
    private boolean isReeChanged;

    @SerializedName("is_tee_changed")
    private boolean isTeeChanged;

    @SerializedName("old_adapter")
    private String oldAdapter;

    @SerializedName("scene")
    private String scene;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L74:
        return true;
    L5:
        if ((r100 instanceof d) == false) goto L73;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == false) goto L73;
        if (this.isDeleteOldKey != r101.isDeleteOldKey) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L73;
        if (Intrinsics.areEqual(this.challenge, r101.challenge) == false) goto L73;
        if (this.isGenerateKey != r101.isGenerateKey) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L73;
        if (this.certChainSize != r101.certChainSize) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L73;
        if (Intrinsics.areEqual(this.attestationAdapter, r101.attestationAdapter) == false) goto L73;
        if (Intrinsics.areEqual(this.oldAdapter, r101.oldAdapter) == false) goto L73;
        if (this.hasKey != r101.hasKey) goto L32;
        boolean r105 = true;
    L33:
        if (r105 == false) goto L73;
        if (this.isTeeChanged != r101.isTeeChanged) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == false) goto L73;
        if (this.isReeChanged != r101.isReeChanged) goto L42;
        boolean r107 = true;
    L43:
        if (r107 == false) goto L73;
        if (this.hasResult != r101.hasResult) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L73;
        if (this.isNeedUpgrade != r101.isNeedUpgrade) goto L52;
        boolean r109 = true;
    L53:
        if (r109 == false) goto L73;
        if (Intrinsics.areEqual(this.extraAppData, r101.extraAppData) == false) goto L73;
        if (Intrinsics.areEqual(this.f163568a, r101.f163568a) == false) goto L73;
        if (Intrinsics.areEqual(this.f163569b, r101.f163569b) == false) goto L73;
        if (Intrinsics.areEqual(this.f163570c, r101.f163570c) == false) goto L73;
        if (Intrinsics.areEqual(this.f163571d, r101.f163571d) == false) goto L73;
        if (Intrinsics.areEqual(this.f163572e, r101.f163572e) == false) goto L73;
        if (Intrinsics.areEqual(this.f163573f, r101.f163573f) == false) goto L73;
        if (Intrinsics.areEqual(this.f163574g, r101.f163574g) == false) goto L73;
        if (Intrinsics.areEqual(this.f163575h, r101.f163575h) == false) goto L73;
    L52:
        r109 = false;
        goto L53
    L47:
        r108 = false;
        goto L48
    L42:
        r107 = false;
        goto L43
    L37:
        r106 = false;
        goto L38
    L32:
        r105 = false;
        goto L33
    L23:
        r104 = false;
        goto L24
    L18:
        r103 = false;
        goto L19
    L11:
        r102 = false;
    L73:
        return false;
    }

    public final void f() {
        this.isDeleteOldKey = true;
    }

    public final void h() {
        this.isGenerateKey = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.isDeleteOldKey;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.challenge;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.isGenerateKey;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (((r110 + r112) * 31) + this.certChainSize) * 31;
        String r114 = this.attestationAdapter;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        String r117 = this.oldAdapter;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.hasKey;
        ?? r121 = r120;
        if (r120 == false) goto L27;
        r121 = 1;
    L27:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.isTeeChanged;
        ?? r124 = r123;
        if (r123 == false) goto L30;
        r124 = 1;
    L30:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.isReeChanged;
        ?? r127 = r126;
        if (r126 == false) goto L33;
        r127 = 1;
    L33:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.hasResult;
        ?? r130 = r129;
        if (r129 == false) goto L36;
        r130 = 1;
    L36:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.isNeedUpgrade;
        if (r132 == true) goto L40;
        r105 = r132;
    L40:
        int r133 = (r131 + r105) * 31;
        String r134 = this.extraAppData;
        if (r134 == null) goto L43;
        int r135 = r134.hashCode();
    L44:
        int r136 = (r133 + r135) * 31;
        Throwable r137 = this.f163568a;
        if (r137 == null) goto L47;
        int r138 = r137.hashCode();
    L48:
        int r139 = (r136 + r138) * 31;
        Set<String> r140 = this.f163569b;
        if (r140 == null) goto L51;
        int r141 = r140.hashCode();
    L52:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f163570c;
        if (r143 == null) goto L55;
        int r144 = r143.hashCode();
    L56:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f163571d;
        if (r146 == null) goto L59;
        int r147 = r146.hashCode();
    L60:
        int r148 = (r145 + r147) * 31;
        String r149 = this.f163572e;
        if (r149 == null) goto L63;
        int r150 = r149.hashCode();
    L64:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f163573f;
        if (r152 == null) goto L67;
        int r153 = r152.hashCode();
    L68:
        int r154 = (r151 + r153) * 31;
        String r155 = this.f163574g;
        if (r155 == null) goto L71;
        int r156 = r155.hashCode();
    L72:
        int r157 = (r154 + r156) * 31;
        Throwable r158 = this.f163575h;
        if (r158 == null) goto L76;
        r101 = r158.hashCode();
    L76:
        return r157 + r101;
    L71:
        r156 = 0;
        goto L72
    L67:
        r153 = 0;
        goto L68
    L63:
        r150 = 0;
        goto L64
    L59:
        r147 = 0;
        goto L60
    L55:
        r144 = 0;
        goto L56
    L51:
        r141 = 0;
        goto L52
    L47:
        r138 = 0;
        goto L48
    L43:
        r135 = 0;
        goto L44
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final void i() {
        this.hasKey = true;
    }

    public final String toString() {
        return "AttestationSnapshot(scene=" + this.scene + ", isDeleteOldKey=" + this.isDeleteOldKey + ", challenge=" + this.challenge + ", isGenerateKey=" + this.isGenerateKey + ", certChainSize=" + this.certChainSize + ", attestationAdapter=" + this.attestationAdapter + ", oldAdapter=" + this.oldAdapter + ", hasKey=" + this.hasKey + ", isTeeChanged=" + this.isTeeChanged + ", isReeChanged=" + this.isReeChanged + ", hasResult=" + this.hasResult + ", isNeedUpgrade=" + this.isNeedUpgrade + ", extraAppData=" + this.extraAppData + ", getCertChainException=" + this.f163568a + ", requestType=" + this.f163569b + ", teePublicKey=" + this.f163570c + ", reePublicKey=" + this.f163571d + ", clientCert=" + this.f163572e + ", recordTeePublicKey=" + this.f163573f + ", recordReePublicKey=" + this.f163574g + ", getAltRequestParamsException=" + this.f163575h + ")";
    }

    public final String a() {
        return this.attestationAdapter;
    }

    public final String b() {
        return this.scene;
    }

    public d(Object r100) {
        Set<String> r101 = SetsKt.emptySet();
        this.scene = "";
        this.isDeleteOldKey = false;
        this.challenge = null;
        this.isGenerateKey = false;
        this.certChainSize = 0;
        this.attestationAdapter = null;
        this.oldAdapter = null;
        this.hasKey = false;
        this.isTeeChanged = false;
        this.isReeChanged = false;
        this.hasResult = false;
        this.isNeedUpgrade = false;
        this.extraAppData = "";
        this.f163568a = null;
        this.f163569b = r101;
        this.f163570c = null;
        this.f163571d = null;
        this.f163572e = null;
        this.f163573f = null;
        this.f163574g = null;
        this.f163575h = null;
    }

    public final void c(String r100) {
        this.attestationAdapter = r100;
    }

    public final void d(int r100) {
        this.certChainSize = r100;
    }

    public final void e(String r100) {
        this.challenge = r100;
    }

    public final void g(String r100) {
        this.extraAppData = r100;
    }

    public final void j(boolean r100) {
        this.hasResult = r100;
    }

    public final void k(boolean r100) {
        this.isNeedUpgrade = r100;
    }

    public final void l(String r100) {
        this.oldAdapter = r100;
    }

    public final void m(boolean r100) {
        this.isReeChanged = r100;
    }

    public final void n(String r100) {
        this.scene = r100;
    }

    public final void o(boolean r100) {
        this.isTeeChanged = r100;
    }
}
