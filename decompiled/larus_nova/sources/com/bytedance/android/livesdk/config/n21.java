package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/n21;", "", "", "useDouyinAccessKey", "Z", "c", "()Z", "useDouyinHost", "d", "", "", "removeEffectTabList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "removeInteractSticker", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f120803a = 0;

    @SerializedName("remove_effect_tab_list")
    private final List<String> removeEffectTabList;

    @SerializedName("remove_interact_sticker")
    private final Boolean removeInteractSticker;

    @SerializedName("use_douyin_access_key")
    private final boolean useDouyinAccessKey;

    @SerializedName("use_douyin_access_host")
    private final boolean useDouyinHost;

    public static final class a {
        public static boolean a() {
            return mq.f120775a.getValue().c();
        }
    }

    static {
    }

    public n21() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n21) == false) goto L14;
        n21 r101 = (n21) r100;
        if (this.useDouyinAccessKey == r101.useDouyinAccessKey) goto L8;
        return false;
    L8:
        if (this.useDouyinHost == r101.useDouyinHost) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.removeEffectTabList, r101.removeEffectTabList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.removeInteractSticker, r101.removeInteractSticker) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r100 = this.useDouyinAccessKey;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.useDouyinHost;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        List<String> r106 = this.removeEffectTabList;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        Boolean r110 = this.removeInteractSticker;
        if (r110 == null) goto L17;
        r107 = r110.hashCode();
    L17:
        return r109 + r107;
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "LiveEffectSaasInitConfig(useDouyinAccessKey=" + this.useDouyinAccessKey + ", useDouyinHost=" + this.useDouyinHost + ", removeEffectTabList=" + this.removeEffectTabList + ", removeInteractSticker=" + this.removeInteractSticker + ")";
    }

    public final List<String> a() {
        return this.removeEffectTabList;
    }

    public final Boolean b() {
        return this.removeInteractSticker;
    }

    public final boolean c() {
        return this.useDouyinAccessKey;
    }

    public final boolean d() {
        return this.useDouyinHost;
    }

    public n21(Object r100) {
        List<String> r101 = CollectionsKt.listOf("41931");
        Boolean r102 = Boolean.TRUE;
        this.useDouyinAccessKey = true;
        this.useDouyinHost = true;
        this.removeEffectTabList = r101;
        this.removeInteractSticker = r102;
    }
}
