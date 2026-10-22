package com.bytedance.android.livesdkapi.util;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import androidx.core.app.BundleCompat;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import java.io.Serializable;
import jc1.g;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0007J\"\u0010\u0014\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0007J\"\u0010\u0015\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/LiveSdkApiBundleOptUtils;", "", "()V", "enableBundleOpt", "", "getEnableBundleOpt", "()Z", "getBundleBinderData", "Landroid/os/Bundle;", "bundle", "key", "", "getParcelableBinderData", "Landroid/os/Parcelable;", "getSerializableBinderData", "Ljava/io/Serializable;", "getStringBinderData", "putParcelableBinderData", "", "value", "putSerializableBinderData", "putStringBinderData", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSdkApiBundleOptUtils {
    public static final LiveSdkApiBundleOptUtils INSTANCE = null;
    private static final boolean enableBundleOpt = false;

    private LiveSdkApiBundleOptUtils() {
    }

    static {
        INSTANCE = new LiveSdkApiBundleOptUtils();
        ILiveService r100 = TTLiveService.getLiveService();
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.getLiveSettingValue("live_bundle_opt_switch", Boolean.TRUE);
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        enableBundleOpt = r102;
        return;
    L7:
        r102 = true;
        goto L8
    }

    @JvmStatic
    public static final boolean enableBundleOpt() {
        return enableBundleOpt;
    }

    public final boolean getEnableBundleOpt() {
        return enableBundleOpt;
    }

    @JvmStatic
    public static final Bundle getBundleBinderData(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r103 = r100.get(r101);
        if (r103 == null) goto L12;
        if ((r103 instanceof Bundle) == false) goto L12;
        return (Bundle) r103;
    L12:
        if (enableBundleOpt() == false) goto L24;
        IBinder r104 = BundleCompat.getBinder(r100, r101);
        if ((r104 instanceof g) == true) goto L16;
        r104 = null;
    L16:
        g r105 = (g) r104;
        if (r105 == null) goto L25;
        Object r106 = r105.f498078a;
        if ((r106 instanceof Bundle) == false) goto L23;
        r102 = r106;
    L23:
        return (Bundle) r102;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final Parcelable getParcelableBinderData(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        IBinder r103 = BundleCompat.getBinder(r100, r101);
        if ((r103 instanceof g) == true) goto L8;
        r103 = null;
    L8:
        g r104 = (g) r103;
        if (r104 != null) goto L11;
        return null;
    L11:
        if ((r104.f498078a instanceof Parcelable) == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L22;
        Object r105 = r104.f498078a;
        if ((r105 instanceof Parcelable) == false) goto L20;
        r102 = r105;
    L20:
        return (Parcelable) r102;
    L22:
        return null;
    }

    @JvmStatic
    public static final Serializable getSerializableBinderData(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r103 = r100.get(r101);
        if (r103 == null) goto L12;
        if ((r103 instanceof Serializable) == false) goto L12;
        return (Serializable) r103;
    L12:
        if (enableBundleOpt() == false) goto L24;
        IBinder r104 = BundleCompat.getBinder(r100, r101);
        if ((r104 instanceof g) == true) goto L16;
        r104 = null;
    L16:
        g r105 = (g) r104;
        if (r105 == null) goto L25;
        Object r106 = r105.f498078a;
        if ((r106 instanceof Serializable) == false) goto L23;
        r102 = r106;
    L23:
        return (Serializable) r102;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final String getStringBinderData(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r103 = r100.get(r101);
        if (r103 == null) goto L12;
        if ((r103 instanceof String) == false) goto L12;
        return (String) r103;
    L12:
        if (enableBundleOpt() == false) goto L24;
        IBinder r104 = BundleCompat.getBinder(r100, r101);
        if ((r104 instanceof g) == true) goto L16;
        r104 = null;
    L16:
        g r105 = (g) r104;
        if (r105 == null) goto L25;
        Object r106 = r105.f498078a;
        if ((r106 instanceof String) == false) goto L23;
        r102 = r106;
    L23:
        return (String) r102;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final void putParcelableBinderData(Bundle r100, String r101, Parcelable r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r100 != null) goto L5;
        return;
    L5:
        BundleCompat.putBinder(r100, r101, new g(r102));
    }

    @JvmStatic
    public static final void putSerializableBinderData(Bundle r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r100 != null) goto L6;
        return;
    L6:
        if (enableBundleOpt() == false) goto L8;
        BundleCompat.putBinder(r100, r101, new g(r102));
        return;
    L8:
        r100.putSerializable(r101, r102);
    }

    @JvmStatic
    public static final void putStringBinderData(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r100 != null) goto L6;
        return;
    L6:
        if (enableBundleOpt() == false) goto L8;
        BundleCompat.putBinder(r100, r101, new g(r102));
        return;
    L8:
        r100.putString(r101, r102);
    }
}
