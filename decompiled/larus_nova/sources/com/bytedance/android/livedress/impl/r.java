package com.bytedance.android.livedress.impl;

import com.bytedance.android.live.profit.dress.config.DressResource;
import com.bytedance.android.live.profit.dress.config.x;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r {
    public static final p a() {
        Class<?> r100 = ((JsonAdapter) p.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = vh7.b.f554981a;
        Constructor r102 = r101.get(r100);
        if (r102 != null) goto L12;
        r102 = r100.getConstructor(new Class[0]);
        if (r102 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r103 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
        if (r103 == null) goto L12;
        r102 = r103;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r104 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
        if (r104 == null) goto L59;
        p r105 = (p) r104;
        Class<?> r106 = ((JsonAdapter) s.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r107 = r101.get(r106);
        if (r107 != null) goto L24;
        r107 = r106.getConstructor(new Class[0]);
        if (r107 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r108 = r101.putIfAbsent(r106, r107);
        if (r108 == null) goto L24;
        r107 = r108;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r109 = r107.newInstance(new Object[0]).createInstance();
        if (r109 == null) goto L57;
        r105.P5((s) r109);
        Class<?> r110 = ((JsonAdapter) s.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r111 = r101.get(r110);
        if (r111 != null) goto L36;
        r111 = r110.getConstructor(new Class[0]);
        if (r111 == null) goto L35;
        Constructor<? extends SerializableObjectJsonAdapterBase> r112 = r101.putIfAbsent(r110, r111);
        if (r112 == null) goto L36;
        r111 = r112;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r113 = r111.newInstance(new Object[0]).createInstance();
        if (r113 == null) goto L55;
        r105.F5((s) r113);
        Class<?> r114 = ((JsonAdapter) s.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r115 = r101.get(r114);
        if (r115 != null) goto L48;
        r115 = r114.getConstructor(new Class[0]);
        if (r115 == null) goto L47;
        Constructor<? extends SerializableObjectJsonAdapterBase> r116 = r101.putIfAbsent(r114, r115);
        if (r116 == null) goto L48;
        r115 = r116;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r117 = r115.newInstance(new Object[0]).createInstance();
        if (r117 == null) goto L53;
        r105.o9((s) r117);
        return r105;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livedress.impl.ProfileImageMeta");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livedress.impl.ProfileImageMeta");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livedress.impl.ProfileImageMeta");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livedress.impl.ProfileAssetMeta");
    }

    public static final py.k c(s r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$toIImageModel");
        Intrinsics.checkNotNullParameter(r101, "path");
        py.k r102 = (py.k) vh7.f.c(py.k.class);
        r102.setUrls(com.bytedance.revenue.platform.api.core.c.a(new String[]{r101}));
        int r103 = r100.getWidth();
        Intrinsics.checkNotNullParameter(r102, "$this$widthKt");
        r102.setWidth(r103);
        int r104 = r100.getHeight();
        Intrinsics.checkNotNullParameter(r102, "$this$heightKt");
        r102.setHeight(r104);
        return r102;
    }

    public static final void b(x r100, String r101, p r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$setToProfileResource");
        Intrinsics.checkNotNullParameter(r101, "baseDir");
        Intrinsics.checkNotNullParameter(r102, "resource");
        py.k r104 = c(r102.a0(), MSkiaImageRegionDecoder.FILE_PREFIX + r101 + "/border_begin.webp");
        Intrinsics.checkNotNullParameter(r104, "$this$widthKt");
        if (r104.getWidth() == 0) goto L7;
        Intrinsics.checkNotNullParameter(r104, "$this$heightKt");
        if (r104.getHeight() == 0) goto L7;
        DressResource.a<? extends py.k> r105 = new DressResource.a.d(r104, r103);
    L8:
        r100.d(r105);
        py.k r106 = c(r102.u5(), MSkiaImageRegionDecoder.FILE_PREFIX + r101 + "/border_loop.webp");
        Intrinsics.checkNotNullParameter(r106, "$this$widthKt");
        if (r106.getWidth() == 0) goto L13;
        Intrinsics.checkNotNullParameter(r106, "$this$heightKt");
        if (r106.getHeight() == 0) goto L13;
        DressResource.a<? extends py.k> r107 = new DressResource.a.d(r106, r103);
    L14:
        r100.e(r107);
        py.k r108 = c(r102.P4(), MSkiaImageRegionDecoder.FILE_PREFIX + r101 + "/exit_anim.webp");
        Intrinsics.checkNotNullParameter(r108, "$this$widthKt");
        if (r108.getWidth() == 0) goto L19;
        Intrinsics.checkNotNullParameter(r108, "$this$heightKt");
        if (r108.getHeight() == 0) goto L19;
        DressResource.a<? extends py.k> r109 = new DressResource.a.d(r108, r103);
    L20:
        r100.g(r109);
        return;
    L19:
        r109 = new DressResource.a.C1332a();
    L13:
        r107 = new DressResource.a.C1332a();
    L7:
        r105 = new DressResource.a.C1332a();
        goto L8
    }
}
