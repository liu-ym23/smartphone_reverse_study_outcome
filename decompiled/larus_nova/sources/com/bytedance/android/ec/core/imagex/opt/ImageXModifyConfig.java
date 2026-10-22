package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.facebook.keyframes.model.KFAnimation;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ImageXModifyConfig;", "Lcom/bytedance/android/ec/core/imagex/common/z;", "Lcom/bytedance/android/ec/core/imagex/opt/e0;", SubInfo.KEY_FORMAT, "Lcom/bytedance/android/ec/core/imagex/opt/e0;", "d", "()Lcom/bytedance/android/ec/core/imagex/opt/e0;", "Lcom/bytedance/android/ec/core/imagex/opt/f0;", GearStrategyConsts.EV_QUALITY, "Lcom/bytedance/android/ec/core/imagex/opt/f0;", "f", "()Lcom/bytedance/android/ec/core/imagex/opt/f0;", "Lcom/bytedance/android/ec/core/imagex/opt/g0;", "resize", "Lcom/bytedance/android/ec/core/imagex/opt/g0;", "h", "()Lcom/bytedance/android/ec/core/imagex/opt/g0;", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageXModifyConfig extends com.bytedance.android.ec.core.imagex.common.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f44809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44810b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f44811c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f44812d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f44813e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f44814f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f44815g = null;

    @SerializedName(SubInfo.KEY_FORMAT)
    private final e0 format;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private final f0 quality;

    @SerializedName("resize")
    private final g0 resize;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0004"}, d2 = {"com/bytedance/android/ec/core/opt/ab/LazyFastSDKMultiSettingsKt$lazyFastSDKMultiSettingsOrNull$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/ec/core/imagex/common/r;", "ec-core_saasRelease", "com/bytedance/android/ec/core/imagex/opt/b0"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<com.bytedance.android.ec.core.imagex.common.r<ImageXModifyConfig>> {
        public a() {
        }
    }

    public static final class b implements ReadOnlyProperty<Object, com.bytedance.android.ec.core.imagex.common.p<ImageXModifyConfig>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f44816g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f44817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LazyOptGetSettings f44818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.bytedance.android.ec.core.imagex.common.p<ImageXModifyConfig> f44819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f44820d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f44821e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0 f44822f;

        static {
            f44816g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(b.class, "value", "getValue()Lcom/google/gson/internal/LinkedTreeMap;", 0))};
        }

        public b(Function0 r100) {
            final String r101 = "ec_image_tmpl_modify_config";
            this.f44821e = "ec_image_tmpl_modify_config";
            this.f44822f = r100;
            this.f44817a = new a0().getType();
            final LinkedTreeMap r102 = new LinkedTreeMap();
            ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$2 r103 = new ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$2(this);
            if (z.b() == false) goto L5;
            LazyOptGetSettings r104 = new LazyFastSDKSettings("ec_image_tmpl_modify_config", r102, null, r100, r103, new ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$3(r101, r102));
        L6:
            this.f44818b = r104;
            return;
        L5:
            r104 = com.bytedance.android.ec.core.opt.ab.h.a("ec_image_tmpl_modify_config", r102, null, r100, r103);
            goto L6
        }

        @Override // kotlin.properties.ReadOnlyProperty
        public final com.bytedance.android.ec.core.imagex.common.p<ImageXModifyConfig> getValue(Object r100, KProperty r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f44820d == true) goto L5;
            LinkedTreeMap r102 = (LinkedTreeMap) this.f44818b.getValue(this, f44816g[0]);
        L9:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f44821e) == true) goto L9;
            return this.f44819c;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f44823a = null;

        static {
            f44823a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(c.class, "config", "getConfig()Lcom/bytedance/android/ec/core/imagex/common/MultiMapConfig;", 0))};
        }

        public c() {
        }

        public static float a() {
            return ((Number) ImageXModifyConfig.f44814f.getValue()).floatValue();
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageXModifyConfig) == false) goto L12;
        ImageXModifyConfig r101 = (ImageXModifyConfig) r100;
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.quality, r101.quality) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resize, r101.resize) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        e0 r100 = this.format;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f0 r104 = this.quality;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g0 r107 = this.resize;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageXModifyConfig(format=" + this.format + ", quality=" + this.quality + ", resize=" + this.resize + ")";
    }

    static {
        f44815g = new c();
        f44809a = LazyKt.lazy(ImageXModifyConfig$Companion$enable$2.INSTANCE);
        f44810b = LazyKt.lazy(ImageXModifyConfig$Companion$tmplResizeLevelEnableValue$2.INSTANCE);
        f44811c = LazyKt.lazy(ImageXModifyConfig$Companion$tmplResizeLevelEnable$2.INSTANCE);
        ImageXModifyConfig$Companion$config$2 r100 = ImageXModifyConfig$Companion$config$2.INSTANCE;
        if (z.b() == false) goto L5;
        ReadOnlyProperty r101 = new com.bytedance.android.ec.core.opt.ab.e(r100, new a().getType());
    L6:
        f44812d = r101;
        f44813e = LazyKt.lazy(ImageXModifyConfig$Companion$deviceWidth$2.INSTANCE);
        f44814f = LazyKt.lazy(ImageXModifyConfig$Companion$deviceDensity$2.INSTANCE);
        return;
    L5:
        r101 = new b(r100);
        goto L6
    }

    public ImageXModifyConfig() {
        this.format = null;
        this.quality = null;
        this.resize = null;
    }

    public final e0 d() {
        return this.format;
    }

    public final f0 f() {
        return this.quality;
    }

    public final g0 h() {
        return this.resize;
    }
}
