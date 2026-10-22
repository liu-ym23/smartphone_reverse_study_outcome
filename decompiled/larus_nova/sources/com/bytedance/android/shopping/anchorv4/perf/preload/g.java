package com.bytedance.android.shopping.anchorv4.perf.preload;

import com.bytedance.android.ec.core.utils.u0;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/perf/preload/g;", "", "", "hideWireframeHalf", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "hideWireframeFull", "c", "", "", "Lcom/bytedance/android/shopping/anchorv4/perf/preload/l;", "aheadScene", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "maxCacheSize", "e", "maxPreloadNum", "f", "", "enablePreloadAhead", "Z", "b", "()Z", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f167319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f167320b = null;

    @SerializedName("ahead_scene")
    private final Map<String, l> aheadScene;

    @SerializedName("enable_preload_ahead")
    private final boolean enablePreloadAhead;

    @SerializedName("hide_wireframe_full")
    private final Integer hideWireframeFull;

    @SerializedName("hide_wireframe_half")
    private final Integer hideWireframeHalf;

    @SerializedName("max_cache_size")
    private final Integer maxCacheSize;

    @SerializedName("max_preload_num")
    private final Integer maxPreloadNum;

    public static final class a {
    }

    static {
        String r100 = com.bytedance.android.ec.core.abtest.d.e();
        f167319a = r100;
        g r101 = (g) u0.b(r100, g.class);     // Catch: Exception -> L5
    L6:
        f167320b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public g() {
        this.enablePreloadAhead = true;
    }

    public final Map<String, l> a() {
        return this.aheadScene;
    }

    public final boolean b() {
        return this.enablePreloadAhead;
    }

    public final Integer c() {
        return this.hideWireframeFull;
    }

    public final Integer d() {
        return this.hideWireframeHalf;
    }

    public final Integer e() {
        return this.maxCacheSize;
    }

    public final Integer f() {
        return this.maxPreloadNum;
    }

    public final boolean g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, l> r102 = this.aheadScene;
        List<String> r103 = null;
        if (r102 == null) goto L5;
        l r104 = r102.get(r100);
    L6:
        if (r104 == null) goto L8;
        r103 = r104.a();
    L8:
        List<String> r105 = r103;
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L30;
        if (r101 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L30;
        if (r104 == null) goto L33;
        List<String> r108 = r104.a();
        if (r108 != null) goto L28;
        return false;
    L28:
        if (r108.contains(r101) != true) goto L35;
        return true;
    L35:
        return false;
    L33:
        return false;
    L18:
        if (r101.length() == 0) goto L21;
        r107 = false;
    L30:
        if (r104 != null) goto L32;
        return false;
    L32:
        return r104.d();
    L11:
        if (r105.isEmpty() == true) goto L14;
        r106 = false;
        goto L15
    L5:
        r104 = null;
        goto L6
    }
}
