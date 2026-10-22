package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.web.resource.ForestWebHelper;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y9.m f39802a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39803a = null;

        static {
            int[] r100 = new int[IHybridComponent.HybridType.values().length];
            r100[IHybridComponent.HybridType.LYNX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[IHybridComponent.HybridType.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f39803a = r100;
        }
    }

    static {
        f39802a = AnnieConfigSettingKeys.FOREST_MEM_CACHE_CONFIG.a();
    }

    @JvmStatic
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).t1(r100);
    }

    @JvmStatic
    public static final boolean c(IHybridComponent.HybridType r100) {
        Intrinsics.checkNotNullParameter(r100, "containerType");
        int r101 = a.f39803a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return f39802a.c();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return f39802a.a();
    }

    @JvmStatic
    public static final boolean f(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return e(r100, AnnieConfigSettingKeys.GECKO_LOADER_TTNET_ENGINE_DISALLOW_LIST.a());
    }

    @JvmStatic
    public static final boolean i(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (AnnieConfigSettingKeys.LIVE_HYBRID_ENABLE_FOREST_SESSION.a().booleanValue() == false) goto L6;
        return true;
    }

    @JvmStatic
    public static final com.bytedance.android.annie.service.resource.d b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).b1(r100, r101);
    }

    @JvmStatic
    public static final String d(String r100, RequestConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        com.bytedance.android.annie.service.resource.e r102 = (com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null);
        if (r102.l(r100) == false) goto L12;
        com.bytedance.android.annie.service.resource.h r103 = r102.o0(r100, r101);
        if (r103 == null) goto L13;
        o r104 = r103.b();
        if (r104 == null) goto L14;
        String r105 = r104.f40038a;
        if (r105 != null) goto L11;
        return null;
    L11:
        return MSkiaImageRegionDecoder.FILE_PREFIX.concat(r105);
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public static boolean e(String r100, List r101) {
        Iterator r102 = r101.iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (StringsKt.contains$default(r100, (String) r104, false, 2, null) == false) goto L3;
        r103 = r104;
    L8:
        if (r103 == null) goto L14;
        return true;
    L14:
        return false;
    }

    @JvmStatic
    public static final com.bytedance.android.annie.service.resource.h h(String r100, RequestConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).o0(r100, r101);
    }

    @JvmStatic
    public static final com.bytedance.android.annie.service.resource.h g(String r100, RequestConfig r101, Function1<? super com.bytedance.android.annie.service.resource.i, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        return ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).x(r100, r101, r102);
    }

    @JvmStatic
    public static final boolean j(String r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "containerType");
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null) instanceof com.bytedance.android.annie.service.resource.b) == false) goto L9;
        return false;
    L9:
        if (AnnieConfigSettingKeys.FORCE_USE_FOREST.a().booleanValue() == false) goto L12;
        return true;
    L12:
        if (AnnieConfigSettingKeys.DISABLE_FOREST_LOADER.a().booleanValue() == false) goto L14;
        return false;
    L14:
        int[] r103 = a.f39803a;
        int r104 = r103[r101.ordinal()];
        if (r104 == 1) goto L22;
        if (r104 == 2) goto L19;
    L24:
        if (r102 != null) goto L27;
        r102 = "";
    L27:
        if (Intrinsics.areEqual(r102, "forest") == false) goto L30;
        return true;
    L30:
        if (Intrinsics.areEqual(r102, "default") == false) goto L32;
        return false;
    L32:
        int r105 = r103[r101.ordinal()];
        if (r105 == 1) goto L59;
        if (r105 == 2) goto L37;
    L61:
        return false;
    L37:
        if (e(r100, AnnieConfigSettingKeys.GECKO_LOADER_WHITE_LIST.a()) == false) goto L39;
        return true;
    L39:
        Iterator<String> r106 = ForestWebHelper.a().b().iterator();
    L41:
        if (r106.hasNext() == false) goto L54;
        if (StringsKt.contains$default(r100, r106.next(), false, 2, null) == false) goto L41;
        if (ForestWebHelper.a().a() <= 0) goto L41;
        Boolean r107 = Boolean.TRUE;
        if (ForestWebHelper.a().a() != 3) goto L49;
    L52:
        boolean r108 = true;
    L53:
        Pair r109 = new Pair(r107, Boolean.valueOf(r108));
    L56:
        if (((Boolean) r109.getFirst()).booleanValue() == false) goto L61;
        return true;
    L49:
        if (ForestWebHelper.a().a() == 4) goto L52;
        r108 = false;
        goto L53
    L54:
        Boolean r110 = Boolean.FALSE;
        r109 = new Pair(r110, r110);
        goto L56
    L59:
        if (e(r100, AnnieConfigSettingKeys.GECKO_LOADER_WHITE_LIST_LYNX.a()) == false) goto L61;
        return true;
    L19:
        if (e(r100, AnnieConfigSettingKeys.GECKO_LOADER_DISALLOW_LIST.a()) == false) goto L24;
        return false;
    L22:
        if (e(r100, AnnieConfigSettingKeys.GECKO_LOADER_DISALLOW_LIST_LYNX.a()) == false) goto L24;
        return false;
    }
}
