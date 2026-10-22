package com.bytedance.android.window.shop.home.tab.tabplugin;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \n*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "Ljava/io/Serializable;", ExifInterface.GPS_DIRECTION_TRUE, "param", "Ljava/io/Serializable;", "getParam", "()Ljava/io/Serializable;", "", "useLast", "Z", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowNavigationParam<T extends Serializable> implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WindowNavigationParam f188929a = null;
    private final T param;
    private final boolean useLast;

    public static final class a {
        public static WindowNavigationParam b() {
            WindowNavigationParam r100 = WindowNavigationParam.access$getUseLastParam$cp();
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam<T>");
        }

        public a() {
        }

        public static WindowNavigationParam c(Serializable r100) {
            return new WindowNavigationParam(r100, false, null);
        }

        public static Serializable a(WindowNavigationParam r100, Serializable r101) {
            if (r100 != null) goto L4;
        L6:
            if (r100 != null) goto L10;
            return null;
        L10:
            return r100.getParam();
        L4:
            if (WindowNavigationParam.access$getUseLast$p(r100) != true) goto L6;
            return r101;
        }
    }

    static {
        Companion = new a();
        f188929a = new WindowNavigationParam(null, true);
    }

    public static final /* synthetic */ WindowNavigationParam access$getUseLastParam$cp() {
        return f188929a;
    }

    public final T getParam() {
        return this.param;
    }

    public static final /* synthetic */ boolean access$getUseLast$p(WindowNavigationParam r100) {
        return r100.useLast;
    }

    public WindowNavigationParam(T r100, boolean r101) {
        this.param = r100;
        this.useLast = r101;
    }

    public /* synthetic */ WindowNavigationParam(Serializable r100, boolean r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public /* synthetic */ WindowNavigationParam(Serializable r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
