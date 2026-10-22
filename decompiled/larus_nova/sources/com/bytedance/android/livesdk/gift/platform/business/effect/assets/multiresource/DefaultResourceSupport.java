package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import c12.n;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.live.core.resources.l;
import com.bytedance.android.live.core.resources.m;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class DefaultResourceSupport implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f129117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f129118b;

    public static final class a {
    }

    static {
    }

    public DefaultResourceSupport() {
        this.f129117a = LazyKt.lazy(DefaultResourceSupport$fileCacheService$2.INSTANCE);
        this.f129118b = LazyKt.lazy(DefaultResourceSupport$assetServiceOptConfig$2.INSTANCE);
    }

    public static boolean h(e r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getMD5();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        l r103 = r100.getResourceModel();
        if (r103 != null) goto L17;
        return false;
    L17:
        List<String> r104 = m.a(r103);
        if (r104 != null) goto L20;
        return false;
    L20:
        if (r104.isEmpty() == true) goto L24;
        return true;
    L24:
        return false;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public static boolean i(e r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        j r101 = r100.getH265ResourceModel();
        if (r101 != null) goto L8;
        return false;
    L8:
        String r102 = r101.getMd5();
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        return false;
    L17:
        l r104 = r101.getResourceModel();
        if (r104 != null) goto L20;
        return false;
    L20:
        List<String> r105 = m.a(r104);
        if (r105 != null) goto L23;
        return false;
    L23:
        if (r105.isEmpty() == true) goto L27;
        return true;
    L27:
        return false;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    }

    public final c12.e e(e r110, int r111) {
        if (h(r110) == true) goto L5;
        return null;
    L5:
        if (r110 == null) goto L7;
        l r100 = r110.getResourceModel();
    L8:
        if (r100 == null) goto L16;
        List<String> r101 = m.a(r100);
        if (r101 == null) goto L16;
        Object[] r102 = r101.toArray(new String[0]);
        if (r102 == null) goto L15;
        String[] r103 = (String[]) r102;
    L17:
        if (r103 == null) goto L24;
        if (r110 == null) goto L24;
        if (r110.getMD5() == null) goto L24;
        long r104 = r110.getId();
        String r105 = r110.getMD5();
        Intrinsics.checkNotNull(r105);
        return new c12.e(r104, r103, r105, r111, (GiftResourceFileCacheService) this.f129117a.getValue());
    L24:
        return null;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        r103 = null;
        goto L17
    L7:
        r100 = null;
        goto L8
    }

    public final n f(e r110, int r111) {
        if (r110 == null) goto L35;
        j r100 = r110.getH265ResourceModel();
        if (r100 == null) goto L35;
        String r101 = r100.getMd5();
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L23;
        l r104 = r100.getResourceModel();
        if (r104 == null) goto L23;
        List<String> r105 = m.a(r104);
        if (r105 == null) goto L23;
        if (r105.isEmpty() == true) goto L23;
    L24:
        if (r102 == false) goto L35;
        l r106 = r100.getResourceModel();
        if (r106 == null) goto L35;
        List<String> r107 = m.a(r106);
        if (r107 == null) goto L35;
        Object[] r108 = r107.toArray(new String[0]);
        if (r108 == null) goto L34;
        return new n(r110.getId(), (String[]) r108, r100.getMd5(), r100.getTtmd5(), r111, (GiftResourceFileCacheService) this.f129117a.getValue());
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L23:
        r102 = false;
        goto L24
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
    L35:
        return null;
    }

    public final c12.e g(e r110, int r111) {
        if (r110 == null) goto L35;
        k r100 = r110.getH265SuperResourceModel();
        if (r100 == null) goto L35;
        String r101 = r100.getMd5();
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L23;
        l r104 = r100.getResourceModel();
        if (r104 == null) goto L23;
        List<String> r105 = m.a(r104);
        if (r105 == null) goto L23;
        if (r105.isEmpty() == true) goto L23;
    L24:
        if (r102 == false) goto L35;
        l r106 = r100.getResourceModel();
        if (r106 == null) goto L35;
        List<String> r107 = m.a(r106);
        if (r107 == null) goto L35;
        Object[] r108 = r107.toArray(new String[0]);
        if (r108 == null) goto L34;
        return new c12.e(r110.getId(), (String[]) r108, r100.getMd5(), r111, (GiftResourceFileCacheService) this.f129117a.getValue());
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L23:
        r102 = false;
        goto L24
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
    L35:
        return null;
    }
}
