package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class ImageDomainPreConnectConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f44796c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ImageDomainPreConnectConfig f44797d = null;

    public static final class a implements ReadOnlyProperty<Object, com.bytedance.android.shopping.api.image.a0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f44798g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f44799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.android.shopping.api.image.a0 f44800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f44801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f44802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f44803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f44804f;

        static {
            f44798g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.a0, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final com.bytedance.android.shopping.api.image.a0 getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f44800b != null) goto L5;
            LazyFastSDKSettings r102 = this.f44799a;
            KProperty<?>[] r103 = f44798g;
            if (r102.getValue(this, r103[0]) == this.f44802d) goto L15;
            this.f44800b = this.f44799a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f44801c) == true) goto L15;
            return this.f44800b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f44801c) == false) goto L8;
            return null;
        L8:
            return this.f44800b;
        }

        public a(final com.bytedance.android.shopping.api.image.a0 r100, Function0 r110, Function2 r111) {
            final String r101 = "ec_image_host_keep_alive_config";
            this.f44801c = "ec_image_host_keep_alive_config";
            this.f44802d = r100;
            this.f44803e = r110;
            this.f44804f = r111;
            this.f44799a = new LazyFastSDKSettings("ec_image_host_keep_alive_config", r100, null, r110, r111, new ImageDomainPreConnectConfig$$special$$inlined$lazyImageXSettingsOrNull$1$1(r101, r100));
        }
    }

    static {
        f44794a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ImageDomainPreConnectConfig.class, "config", "getConfig()Lcom/bytedance/android/shopping/api/image/ImageDomainPreConnectModel;", 0))};
        f44797d = new ImageDomainPreConnectConfig();
        f44795b = LazyKt.lazy(ImageDomainPreConnectConfig$enable$2.INSTANCE);
        com.bytedance.android.shopping.api.image.a0 r100 = new com.bytedance.android.shopping.api.image.a0(null);
        ImageDomainPreConnectConfig$config$2 r101 = ImageDomainPreConnectConfig$config$2.INSTANCE;
        ImageDomainPreConnectConfig$config$3 r102 = new ImageDomainPreConnectConfig$config$3(DomainPreConnect.f44729c);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r103 = new a(r100, r101, r102);
    L6:
        f44796c = r103;
        return;
    L5:
        r103 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_host_keep_alive_config", r100, null, r101, r102);
        goto L6
    }

    public ImageDomainPreConnectConfig() {
    }
}
