package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.core.imagex.opt.ImageXModifyConfig;
import com.bytedance.android.ec.core.imagex.opt.ImageXSettingKt$lazyImageXSettingsOrNull$4;
import com.bytedance.android.ec.core.imagex.opt.z;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.shopping.api.image.h;
import com.bytedance.android.shopping.api.image.p0;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class TmplConvConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44983a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f44984b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f44985c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f44986d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f44987e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f44988f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f44989g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f44990h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f44991i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f44992j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final TmplConvConfig f44993k = null;

    public static final class a implements ReadOnlyProperty<Object, p0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f44994g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f44995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p0 f44996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f44997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f44998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f44999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f45000f;

        static {
            f44994g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.p0, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final p0 getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f44996b != null) goto L5;
            LazyFastSDKSettings r102 = this.f44995a;
            KProperty<?>[] r103 = f44994g;
            if (r102.getValue(this, r103[0]) == this.f44998d) goto L15;
            this.f44996b = this.f44995a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f44997c) == true) goto L15;
            return this.f44996b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f44997c) == false) goto L8;
            return null;
        L8:
            return this.f44996b;
        }

        public a(final p0 r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_image_tmpl_convergence";
            this.f44997c = "ec_image_tmpl_convergence";
            this.f44998d = r100;
            this.f44999e = r110;
            this.f45000f = r111;
            this.f44995a = new LazyFastSDKSettings("ec_image_tmpl_convergence", r100, null, r110, r111, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$1$1(r101, r100));
        }
    }

    public static final class b implements ReadOnlyProperty<Object, p0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f45001g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f45002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p0 f45003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f45004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f45005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f45006e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f45007f;

        static {
            f45001g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(b.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.p0, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final p0 getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f45003b != null) goto L5;
            LazyFastSDKSettings r102 = this.f45002a;
            KProperty<?>[] r103 = f45001g;
            if (r102.getValue(this, r103[0]) == this.f45005d) goto L15;
            this.f45003b = this.f45002a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f45004c) == true) goto L15;
            return this.f45003b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f45004c) == false) goto L8;
            return null;
        L8:
            return this.f45003b;
        }

        public b(final p0 r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_image_format_convergence";
            this.f45004c = "ec_image_format_convergence";
            this.f45005d = r100;
            this.f45006e = r110;
            this.f45007f = r111;
            this.f45002a = new LazyFastSDKSettings("ec_image_format_convergence", r100, null, r110, r111, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$2$1(r101, r100));
        }
    }

    public static final class c implements ReadOnlyProperty<Object, h> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f45008g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f45009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f45010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f45011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f45012d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f45013e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f45014f;

        static {
            f45008g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(c.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.h, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final h getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f45010b != null) goto L5;
            LazyFastSDKSettings r102 = this.f45009a;
            KProperty<?>[] r103 = f45008g;
            if (r102.getValue(this, r103[0]) == this.f45012d) goto L15;
            this.f45010b = this.f45009a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f45011c) == true) goto L15;
            return this.f45010b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f45011c) == false) goto L8;
            return null;
        L8:
            return this.f45010b;
        }

        public c(final h r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_tmpl_conv_global_mather";
            this.f45011c = "ec_tmpl_conv_global_mather";
            this.f45012d = r100;
            this.f45013e = r110;
            this.f45014f = r111;
            this.f45009a = new LazyFastSDKSettings("ec_tmpl_conv_global_mather", r100, null, r110, r111, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$3$1(r101, r100));
        }
    }

    public static final class d implements ReadOnlyProperty<Object, h> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f45015g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f45016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f45017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f45018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f45019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f45020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f45021f;

        static {
            f45015g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(d.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.h, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final h getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f45017b != null) goto L5;
            LazyFastSDKSettings r102 = this.f45016a;
            KProperty<?>[] r103 = f45015g;
            if (r102.getValue(this, r103[0]) == this.f45019d) goto L15;
            this.f45017b = this.f45016a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f45018c) == true) goto L15;
            return this.f45017b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f45018c) == false) goto L8;
            return null;
        L8:
            return this.f45017b;
        }

        public d(final h r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_edit_url_global_mather";
            this.f45018c = "ec_edit_url_global_mather";
            this.f45019d = r100;
            this.f45020e = r110;
            this.f45021f = r111;
            this.f45016a = new LazyFastSDKSettings("ec_edit_url_global_mather", r100, null, r110, r111, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$4$1(r101, r100));
        }
    }

    public static final class e implements ReadOnlyProperty<Object, h> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f45022g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f45023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f45024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f45025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f45026d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f45027e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f45028f;

        static {
            f45022g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(e.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.h, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final h getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f45024b != null) goto L5;
            LazyFastSDKSettings r102 = this.f45023a;
            KProperty<?>[] r103 = f45022g;
            if (r102.getValue(this, r103[0]) == this.f45026d) goto L15;
            this.f45024b = this.f45023a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f45025c) == true) goto L15;
            return this.f45024b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f45025c) == false) goto L8;
            return null;
        L8:
            return this.f45024b;
        }

        public e(final h r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_big_image_cache_opt_config";
            this.f45025c = "ec_big_image_cache_opt_config";
            this.f45026d = r100;
            this.f45027e = r110;
            this.f45028f = r111;
            this.f45023a = new LazyFastSDKSettings("ec_big_image_cache_opt_config", r100, null, r110, r111, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$5$1(r101, r100));
        }
    }

    static {
        f44983a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "tmplConfig", "getTmplConfig()Lcom/bytedance/android/shopping/api/image/TmplConvModel;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "formatConfig", "getFormatConfig()Lcom/bytedance/android/shopping/api/image/TmplConvModel;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "globalMather", "getGlobalMather()Lcom/bytedance/android/shopping/api/image/GlobalMather;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "editUrlGlobalMather", "getEditUrlGlobalMather()Lcom/bytedance/android/shopping/api/image/GlobalMather;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "bigImageCacheOptMather", "getBigImageCacheOptMather()Lcom/bytedance/android/shopping/api/image/GlobalMather;", 0))};
        final TmplConvConfig r100 = new TmplConvConfig();
        f44993k = r100;
        p0 r101 = new p0(null);
        TmplConvConfig$tmplConfig$2 r102 = new TmplConvConfig$tmplConfig$2(r100);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r103 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r104 = new a(r101, r102, r103);
    L6:
        f44984b = r104;
        p0 r105 = new p0(null);
        PropertyReference0Impl r106 = new TmplConvConfig$formatConfig$2(r100);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r107 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L9;
        ReadOnlyProperty r108 = new b(r105, r106, r107);
    L10:
        f44985c = r108;
        h r109 = new h(null);
        TmplConvConfig$globalMather$2 r110 = new TmplConvConfig$globalMather$2(r100);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r111 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L13;
        ReadOnlyProperty r112 = new c(r109, r110, r111);
    L14:
        f44986d = r112;
        h r113 = new h(null);
        TmplConvConfig$editUrlGlobalMather$2 r114 = new TmplConvConfig$editUrlGlobalMather$2(r100);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r115 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L17;
        ReadOnlyProperty r116 = new d(r113, r114, r115);
    L18:
        f44987e = r116;
        h r117 = new h(null);
        PropertyReference0Impl r118 = new TmplConvConfig$bigImageCacheOptMather$2(r100);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r119 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L21;
        ReadOnlyProperty r120 = new e(r117, r118, r119);
    L22:
        f44988f = r120;
        f44989g = LazyKt.lazy(TmplConvConfig$tmplEnable$2.INSTANCE);
        f44990h = LazyKt.lazy(TmplConvConfig$formatEnable$2.INSTANCE);
        f44991i = LazyKt.lazy(TmplConvConfig$offlineUrlTransformEnable$2.INSTANCE);
        f44992j = LazyKt.lazy(TmplConvConfig$bigImageCacheOptEnable$2.INSTANCE);
        return;
    L21:
        r120 = com.bytedance.android.ec.core.opt.ab.h.b("ec_big_image_cache_opt_config", r117, null, r118, r119);
        goto L22
    L17:
        r116 = com.bytedance.android.ec.core.opt.ab.h.b("ec_edit_url_global_mather", r113, null, r114, r115);
        goto L18
    L13:
        r112 = com.bytedance.android.ec.core.opt.ab.h.b("ec_tmpl_conv_global_mather", r109, null, r110, r111);
        goto L14
    L9:
        r108 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_format_convergence", r105, null, r106, r107);
        goto L10
    L5:
        r104 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_tmpl_convergence", r101, null, r102, r103);
        goto L6
    }

    public TmplConvConfig() {
    }

    public final p0 b() {
        return (p0) f44984b.getValue(this, f44983a[0]);
    }

    public static boolean a() {
        if (((Boolean) f44989g.getValue()).booleanValue() == false) goto L5;
    L12:
        return true;
    L5:
        if (((Boolean) f44990h.getValue()).booleanValue() == true) goto L12;
        ECImageMultiSizeReuseOpt.f44769e.getClass();
        if (ECImageMultiSizeReuseOpt.g() == true) goto L12;
        ImageXModifyConfig.f44815g.getClass();
        if (((Boolean) ImageXModifyConfig.f44809a.getValue()).booleanValue() == true) goto L12;
        return false;
    }
}
