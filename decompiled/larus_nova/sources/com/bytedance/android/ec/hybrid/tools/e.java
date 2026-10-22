package com.bytedance.android.ec.hybrid.tools;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/hybrid/tools/e;", "", "", "favCardCeiType", "I", "b", "()I", "", "fitBigScreen", "Z", "c", "()Z", "checkSameCardTag", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "removeLivingPageName", "Ljava/util/List;", "d", "()Ljava/util/List;", "removeLivingTab", "e", "reportLiveDuration", "f", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f47633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f47634b = null;

    @SerializedName("check_same_card_tag")
    private final boolean checkSameCardTag;

    @SerializedName("favorite_card_ceiling_type")
    private final int favCardCeiType;

    @SerializedName("fit_big_screen")
    private final boolean fitBigScreen;

    @SerializedName("mall_remove_live_page_name")
    private final List<String> removeLivingPageName;

    @SerializedName("mall_remove_live_tab")
    private final List<String> removeLivingTab;

    @SerializedName("report_live_duration")
    private final boolean reportLiveDuration;

    public static final class a {
        public a() {
        }

        public final e getType() {
            return e.f47633a;
        }
    }

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.favCardCeiType == r101.favCardCeiType) goto L8;
        return false;
    L8:
        if (this.fitBigScreen == r101.fitBigScreen) goto L10;
        return false;
    L10:
        if (this.checkSameCardTag == r101.checkSameCardTag) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.removeLivingPageName, r101.removeLivingPageName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.removeLivingTab, r101.removeLivingTab) == true) goto L16;
        return false;
    L16:
        if (this.reportLiveDuration == r101.reportLiveDuration) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.favCardCeiType * 31;
        boolean r101 = this.fitBigScreen;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.checkSameCardTag;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        List<String> r108 = this.removeLivingPageName;
        int r109 = 0;
        if (r108 == null) goto L11;
        int r110 = r108.hashCode();
    L12:
        int r111 = (r107 + r110) * 31;
        List<String> r112 = this.removeLivingTab;
        if (r112 == null) goto L15;
        r109 = r112.hashCode();
    L15:
        int r113 = (r111 + r109) * 31;
        boolean r114 = this.reportLiveDuration;
        if (r114 == true) goto L20;
        r102 = r114;
    L20:
        return r113 + r102;
    L11:
        r110 = 0;
        goto L12
    }

    public final String toString() {
        return "MallNativeCardSetting(favCardCeiType=" + this.favCardCeiType + ", fitBigScreen=" + this.fitBigScreen + ", checkSameCardTag=" + this.checkSameCardTag + ", removeLivingPageName=" + this.removeLivingPageName + ", removeLivingTab=" + this.removeLivingTab + ", reportLiveDuration=" + this.reportLiveDuration + ")";
    }

    static {
        f47634b = new a();
        int r100 = com.bytedance.android.ec.base.settings.c.f42815a;
        Object r101 = null;
        Object r102 = new e(null);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L83
        Object r104 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_native_card_config");     // Catch: Throwable -> L56
        if (r104 != null) goto L8;
    L53:
        Object r105 = null;
    L54:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L56
    L58:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L83
        if (r107 == null) goto L62;
        EnsureManager.ensureNotReachHere(r107);     // Catch: Throwable -> L83
    L62:
        if (Result.m9455isFailureimpl(r106) == false) goto L65;
        r106 = null;
    L65:
        if ((r106 instanceof e) == true) goto L67;
        r106 = null;
    L67:
        e r108 = (e) r106;     // Catch: Throwable -> L83
        if (r108 == null) goto L70;
        r102 = r108;
    L91:
        f47633a = (e) r102;
        return;
    L70:
        IHybridHostService r109 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L83
        if (r109 == null) goto L73;
        Object r110 = r109.getHostABValue("mall_native_card_config", r102);     // Catch: Throwable -> L83
    L74:
        if (r110 == null) goto L91;
        if ((r110 instanceof e) == false) goto L79;
        r101 = r110;
    L79:
        e r111 = (e) r101;     // Catch: Throwable -> L83
        if (r111 == null) goto L91;
        r102 = r111;
        goto L91
    L73:
        r110 = null;
        goto L74
    L8:
        if ((r104 instanceof e) == true) goto L10;
        Object r112 = null;
    L11:
        r105 = (e) r112;     // Catch: Throwable -> L56
        if (r105 != null) goto L54;
        if ((r104 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r113 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L56
        if ((r113 instanceof e) == true) goto L21;
        r113 = null;
    L21:
        r105 = (e) r113;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r114 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L56
        if ((r114 instanceof e) == true) goto L27;
        r114 = null;
    L27:
        r105 = (e) r114;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r115 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L56
        if ((r115 instanceof e) == true) goto L33;
        r115 = null;
    L33:
        r105 = (e) r115;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r116 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L56
        if ((r116 instanceof e) == true) goto L39;
        r116 = null;
    L39:
        r105 = (e) r116;     // Catch: Throwable -> L56
    L41:
        if ((r104 instanceof JSONObject) == false) goto L43;
    L97:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L49
        Object r117 = SDKSettingsCacheManager.a().fromJson(r104.toString(), e.class);     // Catch: Throwable -> L49
        if ((r117 instanceof e) == true) goto L47;
        r117 = null;
    L47:
        Object r118 = Result.m9449constructorimpl((e) r117);     // Catch: Throwable -> L49
    L51:
        r105 = r118;
        if (Result.m9455isFailureimpl(r105) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L56
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r104 instanceof JSONArray) == false) goto L53;
    L10:
        r112 = r104;
    L56:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L83
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Object r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L88;
        EnsureManager.ensureNotReachHere(r123);
    L88:
        if (Result.m9455isFailureimpl(r122) == true) goto L91;
        r102 = r122;
        goto L91
    }

    public final boolean a() {
        return this.checkSameCardTag;
    }

    public final int b() {
        return this.favCardCeiType;
    }

    public final boolean c() {
        return this.fitBigScreen;
    }

    public final List<String> d() {
        return this.removeLivingPageName;
    }

    public final List<String> e() {
        return this.removeLivingTab;
    }

    public final boolean f() {
        return this.reportLiveDuration;
    }

    public e(Object r100) {
        this.favCardCeiType = 0;
        this.fitBigScreen = false;
        this.checkSameCardTag = true;
        this.removeLivingPageName = null;
        this.removeLivingTab = null;
        this.reportLiveDuration = false;
    }
}
