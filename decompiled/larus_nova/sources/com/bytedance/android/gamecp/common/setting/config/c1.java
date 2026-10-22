package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/c1;", "", "", "enableAnnieX", "Z", "b", "()Z", "enableAsyncJsb", "c", "enableOptInitAnnieX", "f", "enableAsyncPreloadAnnieX", "d", "enableIntroduceCardAnnieX", "e", "", "", "disableTabAnnieX", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c1 {

    @SerializedName("disable_tab_anniex")
    private final List<String> disableTabAnnieX;

    @SerializedName("enable_anniex")
    private final boolean enableAnnieX;

    @SerializedName("enable_async_jsb")
    private final boolean enableAsyncJsb;

    @SerializedName("enable_async_preload_anniex")
    private final boolean enableAsyncPreloadAnnieX;

    @SerializedName("enable_introduce_card_anniex")
    private final boolean enableIntroduceCardAnnieX;

    @SerializedName("enable_opt_init_anniex")
    private final boolean enableOptInitAnnieX;

    public c1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c1) == false) goto L18;
        c1 r101 = (c1) r100;
        if (this.enableAnnieX == r101.enableAnnieX) goto L8;
        return false;
    L8:
        if (this.enableAsyncJsb == r101.enableAsyncJsb) goto L10;
        return false;
    L10:
        if (this.enableOptInitAnnieX == r101.enableOptInitAnnieX) goto L12;
        return false;
    L12:
        if (this.enableAsyncPreloadAnnieX == r101.enableAsyncPreloadAnnieX) goto L14;
        return false;
    L14:
        if (this.enableIntroduceCardAnnieX == r101.enableIntroduceCardAnnieX) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.disableTabAnnieX, r101.disableTabAnnieX) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.enableAnnieX;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enableAsyncJsb;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.enableOptInitAnnieX;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.enableAsyncPreloadAnnieX;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.enableIntroduceCardAnnieX;
        if (r113 == true) goto L18;
        r101 = r113;
    L18:
        int r114 = (r112 + r101) * 31;
        List<String> r115 = this.disableTabAnnieX;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L23:
        return r114 + r116;
    L21:
        r116 = 0;
        goto L23
    }

    public final String toString() {
        return "GameCpAnnieXConfig(enableAnnieX=" + this.enableAnnieX + ", enableAsyncJsb=" + this.enableAsyncJsb + ", enableOptInitAnnieX=" + this.enableOptInitAnnieX + ", enableAsyncPreloadAnnieX=" + this.enableAsyncPreloadAnnieX + ", enableIntroduceCardAnnieX=" + this.enableIntroduceCardAnnieX + ", disableTabAnnieX=" + this.disableTabAnnieX + ")";
    }

    public final List<String> a() {
        return this.disableTabAnnieX;
    }

    public final boolean b() {
        return this.enableAnnieX;
    }

    public final boolean c() {
        return this.enableAsyncJsb;
    }

    public final boolean d() {
        return this.enableAsyncPreloadAnnieX;
    }

    public final boolean e() {
        return this.enableIntroduceCardAnnieX;
    }

    public final boolean f() {
        return this.enableOptInitAnnieX;
    }

    public c1(Object r100) {
        this.enableAnnieX = false;
        this.enableAsyncJsb = false;
        this.enableOptInitAnnieX = false;
        this.enableAsyncPreloadAnnieX = false;
        this.enableIntroduceCardAnnieX = false;
        this.disableTabAnnieX = null;
    }
}
