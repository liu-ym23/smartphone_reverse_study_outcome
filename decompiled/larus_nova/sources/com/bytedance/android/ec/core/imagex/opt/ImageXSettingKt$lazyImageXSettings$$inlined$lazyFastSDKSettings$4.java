package com.bytedance.android.ec.core.imagex.opt;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Config", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;", "com/bytedance/android/ec/core/opt/ab/LazyFastSDKSettingsKt$lazyFastSDKSettings$1"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class ImageXSettingKt$lazyImageXSettings$$inlined$lazyFastSDKSettings$4 extends Lambda implements Function0<Object> {
    final /* synthetic */ String $configKey;
    final /* synthetic */ Object $defaultConfig;

    public ImageXSettingKt$lazyImageXSettings$$inlined$lazyFastSDKSettings$4(String r100, Object r101) {
        this.$configKey = r100;
        this.$defaultConfig = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int r100 = com.bytedance.android.ec.base.settings.b.f42814a;
        String r101 = this.$configKey;
        Object r102 = this.$defaultConfig;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L69
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L69
        SDKSettingsCacheManager r104 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L69
        Object r105 = null;
        r104.getClass();     // Catch: Throwable -> L13
        Object r106 = SDKSettingsCacheManager.f42809b.get(r101);     // Catch: Throwable -> L13
        if (r106 != null) goto L10;
        r106 = null;
    L11:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L13
    L15:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L69
        if (r108 == null) goto L19;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L69
    L19:
        if (Result.m9455isFailureimpl(r107) == false) goto L21;
        r107 = null;
    L21:
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L69
        if (r107 != null) goto L25;
        r104.getClass();     // Catch: Throwable -> L69
        r107 = SDKSettingsCacheManager.f42808a.get(r101);     // Catch: Throwable -> L69
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L69
    L25:
        if (r107 != null) goto L88;
        int r109 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L69
    L56:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L69
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
    L59:
        if (Result.m9452exceptionOrNullimpl(r105) != null) goto L84;
    L60:
        Object r111 = r105;
    L67:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L69
        SDKSettingsCacheManager.e(r101, r111);     // Catch: Throwable -> L69
        return r111;
    L84:
        IECHybridKevaService r112 = (IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class);     // Catch: Throwable -> L63
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L63
        Object r113 = r112.getSDKSettingsValueFromRepo(r101, Object.class, r102);     // Catch: Throwable -> L63
    L64:
        if (r113 != null) goto L66;
        r111 = r102;
        goto L67
    L66:
        r111 = r113;
    L63:
        r113 = r102;
        goto L64
    L79:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L36
        Object r114 = SDKSettingsCacheManager.f42809b.get(r101);     // Catch: Throwable -> L36
        if (r114 != null) goto L33;
        r114 = null;
    L34:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L36
    L38:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L56
        if (r116 == null) goto L42;
        EnsureManager.ensureNotReachHere(r116);     // Catch: Throwable -> L56
    L42:
        if (Result.m9455isFailureimpl(r115) == true) goto L45;
        r105 = r115;
    L45:
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L56
        if (r105 == null) goto L48;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L56
        goto L60
    L48:
        jj4.b r117 = jj4.b.f499326b;     // Catch: Throwable -> L56
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L56
        Object r118 = jj4.a.a(r101, Object.class, r102, false);     // Catch: Throwable -> L56
        if (r118 != null) goto L51;
        Intrinsics.throwNpe();     // Catch: Throwable -> L56
    L51:
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L56
        if (r118 != null) goto L54;
        r118 = r102;
    L54:
        r105 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L56
        goto L59
    L33:
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L56
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L38
    L88:
        return r107;
    L10:
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L69
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Object r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L74;
        EnsureManager.ensureNotReachHere(r123);
    L74:
        if (Result.m9455isFailureimpl(r122) == true) goto L78;
        r102 = r122;
    L78:
        return r102;
    }
}
