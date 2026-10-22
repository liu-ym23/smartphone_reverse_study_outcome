package com.bytedance.android.ec.core.anchorv3;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.common.profilesdk.snapboost.ClassList;
import com.bytedance.common.profilesdk.snapboost.ProfileEditor;
import com.bytedance.common.profilesdk.snapboost.SnapBoost;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43802a = 0;

    public h() {
    }

    public static final void c() {
        if (com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostAppInfo().getApplicationContext() == null) goto L10;
        a("com.bytedance.android.shopping.slice.preload.SlcCodeWarmUp").getMethod("warmUp", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L6
        return;
    L6:
        Unit r100 = Unit.INSTANCE;
        return;
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static final void b(List r110) {
        long r100 = System.currentTimeMillis();
        if (SnapBoost.hasInited() == true) goto L8;
        Context r101 = com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostAppInfo().getApplicationContext();
        if (r101 == null) goto L48;
        SnapBoost.init(r101, false);
        goto L8
    L48:
        return;
    L8:
        List r111 = r110;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L10:
        if (r112.hasNext() == false) goto L12;
        r102.add(SnapBoost.findClassList((String) r112.next()));
        goto L10
    L12:
        ProfileEditor r113 = SnapBoost.createEditorBuidler().name("ecom_pdp").version("1").build();
        Iterator r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L16;
        r113.addClassList((ClassList) r103.next());
        goto L14
    L16:
        int r114 = r113.commit();
        long r104 = System.currentTimeMillis() - r100;
        long r105 = System.currentTimeMillis();
        if (r114 != ProfileEditor.RESULT_FAILED_UNSUPPORTED) goto L19;
    L30:
        int r106 = ECSdk.f48106a;
        cj.b r107 = (cj.b) ECSdk.a(cj.b.class);
        if (r107 == null) goto L33;
        r107.j(r102);
    L33:
        int r108 = com.bytedance.android.ec.core.opt.b.f45274a;
        Intrinsics.checkNotNullParameter("ShoppingPerfOptPreloadClasses", "scene");
        Iterator r109 = r102.iterator();
    L35:
        if (r109.hasNext() == false) goto L37;
        ((ClassList) r109.next()).tryPreloadClasses();
        goto L35
    L37:
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r116 = r102.iterator();
    L39:
        if (r116.hasNext() == false) goto L41;
        r115.add(Integer.valueOf(((ClassList) r116.next()).getClassNames().size()));
        goto L39
    L41:
        int r117 = CollectionsKt.sumOfInt(r115);
        Lazy r118 = PdpPerfOpt.f43774a;
        PdpPerfOpt.i("preload classes ret=" + r114 + " duration1=" + r104 + " duration2=" + (System.currentTimeMillis() - r105) + " count=" + r117);
        return;
    L19:
        if (r114 == ProfileEditor.RESULT_FAILED_CREATE_LIST) goto L30;
        if (r114 == ProfileEditor.RESULT_FAILED_CREATE_PROFILE) goto L30;
        if (r114 == ProfileEditor.RESULT_FAILED_MERGE_CUR) goto L30;
        if (r114 == ProfileEditor.RESULT_COMPILED_NOIMAGE) goto L30;
        if (r114 == ProfileEditor.RESULT_FAILED_COMPILED) goto L30;
        Lazy r119 = PdpPerfOpt.f43774a;
        PdpPerfOpt.i("preload classes ret=" + r114 + " duration1=" + r104);
    }
}
