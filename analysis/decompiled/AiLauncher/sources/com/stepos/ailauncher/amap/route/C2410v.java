package com.stepos.ailauncher.amap.route;

import Z8.C1173v;
import android.content.Context;
import android.os.SystemClock;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.UiSettings;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001YB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001f¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020!¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001f¢\u0006\u0004\b*\u0010&J)\u0010.\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+¢\u0006\u0004\b.\u0010/JQ\u00105\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u00020+2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0018\b\u0002\u00104\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b5\u00106Jy\u0010@\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u00107\u001a\u0002002\u0006\u00108\u001a\u0002002\u0006\u00109\u001a\u0002002\u0006\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0018\b\u0002\u0010?\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b@\u0010AJ1\u0010F\u001a\u00020E2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010C\u001a\u00020B2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\bF\u0010GJ\u0019\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bH\u0010IJ\u001d\u0010J\u001a\u00020E2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bN\u0010MR\u0014\u0010O\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020B8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010RR\u0014\u0010V\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010RR\u0014\u0010W\u001a\u00020B8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010TR\u0014\u0010X\u001a\u00020B8\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010T¨\u0006Z"}, d2 = {"Lcom/stepos/ailauncher/amap/route/v;", "", "<init>", "()V", "", "result", "Lcom/stepos/ailauncher/amap/route/v$a;", "c0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/amap/route/v$a;", "Lcom/amap/api/maps/MapView;", "mapView", "", "logoInsetPx", "attempt", "Lkotlin/Function1;", "LY8/t;", "scheduleRetry", "M", "(Lcom/amap/api/maps/MapView;IILp9/l;)V", "Landroid/view/View;", Parameters.ROOT, "f0", "(Landroid/view/View;)V", "b0", "Landroid/webkit/WebView;", "Y", "(Landroid/view/View;)Landroid/webkit/WebView;", "Landroid/content/Context;", "context", "L", "(Landroid/content/Context;)V", "Lcom/amap/api/maps/AMap;", "onReady", "", "m0", "(Lcom/amap/api/maps/MapView;Lp9/l;)Z", "aMap", "Z", "(Lcom/amap/api/maps/AMap;)V", x5.d.EXTRA_ENABLED, "o0", "(Lcom/amap/api/maps/AMap;Z)V", "v", "", "maxZoom", "minZoom", ExifInterface.LONGITUDE_WEST, "(Lcom/amap/api/maps/AMap;FF)V", "", Const.JSON_KEY_LAT, "lng", "zoom", "onComplete", ExifInterface.LONGITUDE_EAST, "(Lcom/amap/api/maps/MapView;DDFILp9/l;)V", "southwestLat", "southwestLng", "northeastLat", "northeastLng", "paddingTopPx", "paddingRightPx", "paddingBottomPx", "paddingLeftPx", "onVerified", "w", "(Lcom/amap/api/maps/MapView;DDDDIIIIILp9/l;)V", "", "timeoutMs", "onDone", "Ljava/lang/Runnable;", "O", "(Lcom/amap/api/maps/MapView;JLp9/l;)Ljava/lang/Runnable;", "d0", "(Lcom/amap/api/maps/AMap;)Ljava/lang/Integer;", "g0", "(Lcom/amap/api/maps/MapView;I)Ljava/lang/Runnable;", "a0", "(Lcom/amap/api/maps/MapView;)V", "e0", "TAG", "Ljava/lang/String;", "MAX_PIXEL_COPY_RETRIES", "I", "PIXEL_COPY_RETRY_INTERVAL_MS", "J", "LITE_MAP_DARK_COLOR", "LOGO_INSET_MAX_ATTEMPTS", "LOGO_INSET_RETRY_MS", "DARK_STYLE_POLL_MS", Const.INTENT_KEY_APIKEY, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.amap.route.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2410v {
    private static final long DARK_STYLE_POLL_MS = 50;
    public static final C2410v INSTANCE = new C2410v();
    private static final int LITE_MAP_DARK_COLOR = -14935010;
    private static final int LOGO_INSET_MAX_ATTEMPTS = 8;
    private static final long LOGO_INSET_RETRY_MS = 200;
    private static final int MAX_PIXEL_COPY_RETRIES = 5;
    private static final long PIXEL_COPY_RETRY_INTERVAL_MS = 300;
    private static final String TAG = "AmapMapCompat";

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/amap/route/v$a;", "", "", "zoom", "", "centerLng", "centerLat", "<init>", "(FDD)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "c", "()F", "D", Const.INTENT_KEY_PKGNAME, "()D", Const.INTENT_KEY_APIKEY, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.amap.route.v$a, reason: from toString */
    public static final /* data */ class LiteCameraSnapshot {
        private final double centerLat;
        private final double centerLng;
        private final float zoom;

        public LiteCameraSnapshot(float f10, double d10, double d11) {
            this.zoom = f10;
            this.centerLng = d10;
            this.centerLat = d11;
        }

        /* renamed from: a, reason: from getter */
        public final double getCenterLat() {
            return this.centerLat;
        }

        /* renamed from: b, reason: from getter */
        public final double getCenterLng() {
            return this.centerLng;
        }

        /* renamed from: c, reason: from getter */
        public final float getZoom() {
            return this.zoom;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LiteCameraSnapshot)) {
                return false;
            }
            LiteCameraSnapshot liteCameraSnapshot = (LiteCameraSnapshot) other;
            return Float.compare(this.zoom, liteCameraSnapshot.zoom) == 0 && Double.compare(this.centerLng, liteCameraSnapshot.centerLng) == 0 && Double.compare(this.centerLat, liteCameraSnapshot.centerLat) == 0;
        }

        public int hashCode() {
            return (((Float.hashCode(this.zoom) * 31) + Double.hashCode(this.centerLng)) * 31) + Double.hashCode(this.centerLat);
        }

        public String toString() {
            return "LiteCameraSnapshot(zoom=" + this.zoom + ", centerLng=" + this.centerLng + ", centerLat=" + this.centerLat + ")";
        }
    }

    public static final void A(C2410v c2410v, MapView mapView, double d10, double d11, double d12, double d13, int i10, int i11, int i12, int i13, int i14, InterfaceC5074l interfaceC5074l) {
        c2410v.w(mapView, d10, d11, d12, d13, i10, i11, i12, i13, i14 + 1, interfaceC5074l);
    }

    public static final void B(WebView webView, final C2410v c2410v, final InterfaceC5074l interfaceC5074l) {
        webView.evaluateJavascript("(function(){\n  var m=window.map;\n  if(!m) return 'no-map';\n  try {\n    var b=m.getBounds();\n    var sw=b&&(typeof b.getSouthWest==='function' ? b.getSouthWest() : (b.southwest||b.southWest));\n    var ne=b&&(typeof b.getNorthEast==='function' ? b.getNorthEast() : (b.northeast||b.northEast));\n    var c=typeof m.getCenter==='function' ? m.getCenter() : null;\n    return JSON.stringify({\n      zoom:m.getZoom(),\n      center:c ? [c.lng,c.lat] : null,\n      southwest:sw ? [sw.lng,sw.lat] : null,\n      northeast:ne ? [ne.lng,ne.lat] : null\n    });\n  } catch(e) { return 'err:'+String(e); }\n})();", new ValueCallback() { // from class: com.stepos.ailauncher.amap.route.n
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C2410v.C(this.f24665a, interfaceC5074l, (String) obj);
            }
        });
    }

    public static final void C(C2410v c2410v, InterfaceC5074l interfaceC5074l, String str) {
        C4148a.k(TAG, "applyLiteBoundsJs verified+300ms result=" + str, false, 4, null);
        LiteCameraSnapshot liteCameraSnapshotC0 = c2410v.c0(str);
        C4148a.k(TAG, "applyLiteBoundsJs parsedCamera=" + liteCameraSnapshotC0 + " raw=" + str, false, 4, null);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(liteCameraSnapshotC0);
        }
    }

    public static final int D(float f10, int i10) {
        return C5227b.b(C5685n.f(i10, 0) / f10);
    }

    public static final void G(MapView mapView, double d10, double d11, float f10, int i10, InterfaceC5074l interfaceC5074l) {
        INSTANCE.E(mapView, d10, d11, f10, i10 + 1, interfaceC5074l);
    }

    public static final void H(final int i10, final float f10, final MapView mapView, final WebView webView, final C2410v c2410v, final double d10, final double d11, final InterfaceC5074l interfaceC5074l, String str) {
        C4148a.k(TAG, "applyLiteZoomJs attempt=" + i10 + " result=" + str + " zoom=" + f10, false, 4, null);
        if ((kotlin.jvm.internal.p.d(str, "\"no-map\"") || kotlin.jvm.internal.p.d(str, "null") || kotlin.jvm.internal.p.d(str, "\"null\"")) && i10 < 8) {
            mapView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.o
                @Override // java.lang.Runnable
                public final void run() {
                    C2410v.I(this.f24667a, mapView, d10, d11, f10, i10, interfaceC5074l);
                }
            }, 200L);
        } else {
            webView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.p
                @Override // java.lang.Runnable
                public final void run() {
                    C2410v.J(webView, f10, interfaceC5074l, c2410v);
                }
            }, 300L);
        }
    }

    public static final void I(C2410v c2410v, MapView mapView, double d10, double d11, float f10, int i10, InterfaceC5074l interfaceC5074l) {
        c2410v.E(mapView, d10, d11, f10, i10 + 1, interfaceC5074l);
    }

    public static final void J(WebView webView, final float f10, final InterfaceC5074l interfaceC5074l, final C2410v c2410v) {
        webView.evaluateJavascript("(function(){\n  var m=window.map||window.amap||window.aMap;\n  if(!m) return 'no-map';\n  try {\n    var c=typeof m.getCenter==='function' ? m.getCenter() : null;\n    return JSON.stringify({\n      zoom:typeof m.getZoom==='function' ? m.getZoom() : null,\n      center:c ? [c.lng,c.lat] : null\n    });\n  } catch(e) { return 'err:'+String(e); }\n})();", new ValueCallback() { // from class: com.stepos.ailauncher.amap.route.q
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C2410v.K(f10, interfaceC5074l, c2410v, (String) obj);
            }
        });
    }

    public static final void K(float f10, InterfaceC5074l interfaceC5074l, C2410v c2410v, String str) {
        C4148a.k(TAG, "applyLiteZoomJs verified+300ms result=" + str + " want=" + f10, false, 4, null);
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(c2410v.c0(str));
        }
    }

    public static final void N(int i10, int i11, InterfaceC5074l interfaceC5074l, String str) {
        C4148a.k(TAG, "polishLiteMapChrome logoCss=" + i10 + " attempt=" + i11 + " result=" + str, false, 4, null);
        if ((kotlin.jvm.internal.p.d(str, "false") || kotlin.jvm.internal.p.d(str, "null")) && i11 < 8) {
            interfaceC5074l.invoke(Integer.valueOf(i11 + 1));
        }
    }

    public static final void P(Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef, MapView mapView) {
        ref$BooleanRef.f34815a = true;
        Runnable runnable = (Runnable) ref$ObjectRef.f34820a;
        if (runnable != null) {
            mapView.removeCallbacks(runnable);
        }
        ref$ObjectRef.f34820a = null;
    }

    public static final void Q(final Ref$BooleanRef ref$BooleanRef, final MapView mapView, final long j10, final InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, final Ref$ObjectRef<Runnable> ref$ObjectRef) {
        Object objB;
        if (ref$BooleanRef.f34815a) {
            return;
        }
        WebView webViewY = INSTANCE.Y(mapView);
        if (webViewY == null) {
            if (SystemClock.elapsedRealtime() < j10) {
                U(ref$ObjectRef, mapView, ref$BooleanRef, new InterfaceC5063a() { // from class: com.stepos.ailauncher.amap.route.d
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return C2410v.R(ref$BooleanRef, mapView, j10, interfaceC5074l, ref$ObjectRef);
                    }
                });
                return;
            } else {
                C4148a.u(TAG, "awaitLiteDarkStyle timeout: no WebView", false, 4, null);
                interfaceC5074l.invoke(Boolean.FALSE);
                return;
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            webViewY.evaluateJavascript("(function(){\n  try {\n    var m=window.map;\n    if(!m||typeof m.getMapStyle!=='function') return 'no-map';\n    return String(m.getMapStyle());\n  } catch(e) { return 'err:'+String(e); }\n})();", new ValueCallback() { // from class: com.stepos.ailauncher.amap.route.e
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    C2410v.S(ref$BooleanRef, interfaceC5074l, j10, mapView, ref$ObjectRef, (String) obj);
                }
            });
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "awaitLiteDarkStyle eval failed", thE, false, 8, null);
            interfaceC5074l.invoke(Boolean.FALSE);
        }
    }

    public static final Y8.t R(Ref$BooleanRef ref$BooleanRef, MapView mapView, long j10, InterfaceC5074l interfaceC5074l, Ref$ObjectRef ref$ObjectRef) {
        Q(ref$BooleanRef, mapView, j10, interfaceC5074l, ref$ObjectRef);
        return Y8.t.f7040a;
    }

    public static final void S(final Ref$BooleanRef ref$BooleanRef, final InterfaceC5074l interfaceC5074l, final long j10, final MapView mapView, final Ref$ObjectRef ref$ObjectRef, String str) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        if (str != null && La.H.g0(str, "dark", false, 2, null)) {
            C4148a.k(TAG, "awaitLiteDarkStyle ok style=" + str, false, 4, null);
            interfaceC5074l.invoke(Boolean.TRUE);
            return;
        }
        if (SystemClock.elapsedRealtime() < j10) {
            U(ref$ObjectRef, mapView, ref$BooleanRef, new InterfaceC5063a() { // from class: com.stepos.ailauncher.amap.route.k
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2410v.T(ref$BooleanRef, mapView, j10, interfaceC5074l, ref$ObjectRef);
                }
            });
            return;
        }
        C4148a.u(TAG, "awaitLiteDarkStyle timeout style=" + str, false, 4, null);
        interfaceC5074l.invoke(Boolean.FALSE);
    }

    public static final Y8.t T(Ref$BooleanRef ref$BooleanRef, MapView mapView, long j10, InterfaceC5074l interfaceC5074l, Ref$ObjectRef ref$ObjectRef) {
        Q(ref$BooleanRef, mapView, j10, interfaceC5074l, ref$ObjectRef);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.stepos.ailauncher.amap.route.m, java.lang.Runnable] */
    public static final void U(Ref$ObjectRef<Runnable> ref$ObjectRef, MapView mapView, final Ref$BooleanRef ref$BooleanRef, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        ?? r02 = new Runnable() { // from class: com.stepos.ailauncher.amap.route.m
            @Override // java.lang.Runnable
            public final void run() {
                C2410v.V(ref$BooleanRef, interfaceC5063a);
            }
        };
        ref$ObjectRef.f34820a = r02;
        mapView.postDelayed(r02, 50L);
    }

    public static final void V(Ref$BooleanRef ref$BooleanRef, InterfaceC5063a interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static /* synthetic */ void X(C2410v c2410v, AMap aMap, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 20.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 3.0f;
        }
        c2410v.W(aMap, f10, f11);
    }

    public static final Y8.t h0(Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef, MapView mapView, int i10, int i11) {
        if (!ref$BooleanRef.f34815a) {
            j0(ref$ObjectRef, mapView, ref$BooleanRef, i10, i11);
        }
        return Y8.t.f7040a;
    }

    public static final void i0(Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef, MapView mapView) {
        ref$BooleanRef.f34815a = true;
        Runnable runnable = (Runnable) ref$ObjectRef.f34820a;
        if (runnable != null) {
            mapView.removeCallbacks(runnable);
        }
        ref$ObjectRef.f34820a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.stepos.ailauncher.amap.route.c, java.lang.Runnable] */
    public static final void j0(final Ref$ObjectRef<Runnable> ref$ObjectRef, final MapView mapView, final Ref$BooleanRef ref$BooleanRef, final int i10, final int i11) {
        ?? r02 = new Runnable() { // from class: com.stepos.ailauncher.amap.route.c
            @Override // java.lang.Runnable
            public final void run() {
                C2410v.k0(ref$BooleanRef, mapView, i10, i11, ref$ObjectRef);
            }
        };
        ref$ObjectRef.f34820a = r02;
        mapView.postDelayed(r02, 200L);
    }

    public static final void k0(final Ref$BooleanRef ref$BooleanRef, final MapView mapView, final int i10, int i11, final Ref$ObjectRef ref$ObjectRef) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        INSTANCE.M(mapView, i10, i11, new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2410v.l0(ref$ObjectRef, mapView, ref$BooleanRef, i10, ((Integer) obj).intValue());
            }
        });
    }

    public static final Y8.t l0(Ref$ObjectRef ref$ObjectRef, MapView mapView, Ref$BooleanRef ref$BooleanRef, int i10, int i11) {
        j0(ref$ObjectRef, mapView, ref$BooleanRef, i10, i11);
        return Y8.t.f7040a;
    }

    public static final Object n0(InterfaceC5074l interfaceC5074l, Object obj, Method method, Object[] objArr) {
        Object objJ0 = objArr != null ? Z8.r.j0(objArr, 0) : null;
        AMap aMap = objJ0 instanceof AMap ? (AMap) objJ0 : null;
        C4148a.k(TAG, "resolveAMap async callback amap=" + (aMap != null ? Integer.valueOf(System.identityHashCode(aMap)) : "null"), false, 4, null);
        if (aMap != null) {
            interfaceC5074l.invoke(aMap);
        }
        return null;
    }

    public static final void y(MapView mapView, double d10, double d11, double d12, double d13, int i10, int i11, int i12, int i13, int i14, InterfaceC5074l interfaceC5074l) {
        INSTANCE.w(mapView, d10, d11, d12, d13, i10, i11, i12, i13, i14 + 1, interfaceC5074l);
    }

    public static final void z(final int i10, int i11, int i12, int i13, int i14, final MapView mapView, final WebView webView, final C2410v c2410v, final double d10, final double d11, final double d12, final double d13, final int i15, final int i16, final int i17, final int i18, final InterfaceC5074l interfaceC5074l, String str) {
        C4148a.k(TAG, "applyLiteBoundsJs attempt=" + i10 + " result=" + str + " pad(t,b,l,r)=[" + i11 + Const.STR_MART_COMMA + i12 + Const.STR_MART_COMMA + i13 + Const.STR_MART_COMMA + i14 + "]", false, 4, null);
        if ((kotlin.jvm.internal.p.d(str, "\"no-setBounds\"") || kotlin.jvm.internal.p.d(str, "null")) && i10 < 8) {
            mapView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.i
                @Override // java.lang.Runnable
                public final void run() {
                    C2410v.A(this.f24635a, mapView, d10, d11, d12, d13, i15, i16, i17, i18, i10, interfaceC5074l);
                }
            }, 200L);
        } else {
            webView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.j
                @Override // java.lang.Runnable
                public final void run() {
                    C2410v.B(webView, c2410v, interfaceC5074l);
                }
            }, 300L);
        }
    }

    public final void E(final MapView mapView, final double lat, final double lng, final float zoom, final int attempt, final InterfaceC5074l<? super LiteCameraSnapshot, Y8.t> onComplete) {
        Object objB;
        kotlin.jvm.internal.p.i(mapView, "mapView");
        final WebView webViewY = Y(mapView);
        if (webViewY == null) {
            if (attempt < 8) {
                mapView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2410v.G(mapView, lat, lng, zoom, attempt, onComplete);
                    }
                }, 200L);
                return;
            }
            C4148a.u(TAG, "applyLiteZoomJs: no WebView", false, 4, null);
            if (onComplete != null) {
                onComplete.invoke(null);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            (function(){\n              var zoom=");
        sb2.append(zoom);
        sb2.append(", lng=");
        sb2.append(lng);
        sb2.append(", lat=");
        sb2.append(lat);
        sb2.append(";\n              function go(m){\n                if(!m) return null;\n                try{\n                  var before=typeof m.getZoom==='function' ? m.getZoom() : null;\n                  if(typeof m.setStatus==='function') m.setStatus({animateEnable:false});\n                  if(typeof m.setZoomAndCenter==='function'){\n                    m.setZoomAndCenter(zoom,[lng,lat],true,0);\n                    return JSON.stringify({method:'setZoomAndCenter',before:before,after:m.getZoom()});\n                  }\n                  if(typeof m.setZoom==='function' && typeof m.setCenter==='function'){\n                    m.setZoom(zoom,true,0); m.setCenter([lng,lat],true,0);\n                    return JSON.stringify({method:'setZoom+setCenter',before:before,after:m.getZoom()});\n                  }\n                  if(typeof m.setZoom==='function' && typeof m.panTo==='function'){\n                    m.setZoom(zoom,true,0); m.panTo([lng,lat],0);\n                    return JSON.stringify({method:'setZoom+panTo',before:before,after:m.getZoom()});\n                  }\n                }catch(e){ return 'err:'+String(e); }\n                return null;\n              }\n              var r = go(window.map) || go(window.amap) || go(window.aMap);\n              if(r) return r;\n              var c=document.getElementById('container');\n              if(c){\n                r = go(c.__amap__) || go(c._amap) || go(c.map);\n                if(r) return 'container:'+r;\n              }\n              var nodes=document.querySelectorAll('.amap-container');\n              for(var i=0;i<nodes.length;i++){\n                r = go(nodes[i].__amap__) || go(nodes[i]._amap);\n                if(r) return 'node:'+r;\n              }\n              return 'no-map';\n            })();\n            ");
        String strN = La.w.n(sb2.toString());
        try {
            Result.Companion companion = Result.INSTANCE;
            webViewY.evaluateJavascript(strN, new ValueCallback() { // from class: com.stepos.ailauncher.amap.route.l
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    C2410v.H(attempt, zoom, mapView, webViewY, this, lat, lng, onComplete, (String) obj);
                }
            });
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "applyLiteZoomJs failed", thE, false, 8, null);
        }
    }

    public final void L(Context context) {
        Class cls = Boolean.TYPE;
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        try {
            Result.Companion companion = Result.INSTANCE;
            MapsInitializer.initialize(applicationContext);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            Method method = MapsInitializer.class.getMethod("updatePrivacyShow", Context.class, cls, cls);
            Boolean bool = Boolean.TRUE;
            Result.b(method.invoke(null, applicationContext, bool, bool));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        try {
            Result.b(MapsInitializer.class.getMethod("updatePrivacyAgree", Context.class, cls).invoke(null, applicationContext, Boolean.TRUE));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
    }

    public final void M(MapView mapView, int logoInsetPx, final int attempt, final InterfaceC5074l<? super Integer, Y8.t> scheduleRetry) {
        String str;
        Object objB;
        a0(mapView);
        WebView webViewY = Y(mapView);
        if (webViewY == null) {
            if (attempt < 8) {
                scheduleRetry.invoke(Integer.valueOf(attempt + 1));
                return;
            }
            C4148a.u(TAG, "polishLiteMapChrome: no WebView after " + attempt + " attempts", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            webViewY.setBackgroundColor(LITE_MAP_DARK_COLOR);
            webViewY.setLayerType(0, null);
            webViewY.setElevation(0.0f);
            webViewY.setTranslationZ(0.0f);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        e0(mapView);
        final int iF = logoInsetPx > 0 ? C5685n.f((int) (logoInsetPx / C5685n.e(mapView.getResources().getDisplayMetrics().density, 1.0f)), 8) : 0;
        if (iF > 0) {
            str = ".amap-logo{bottom:" + iF + "px!important;left:" + iF + "px!important;}";
        } else {
            str = "";
        }
        try {
            webViewY.evaluateJavascript(La.w.n("\n            (function(){\n              var id='ailauncher-map-chrome';\n              var s=document.getElementById(id);\n              if(!s){\n                s=document.createElement('style');\n                s.id=id;\n                (document.head||document.documentElement).appendChild(s);\n              }\n              s.textContent=[\n                'html,body{margin:0!important;padding:0!important;background:#1C1C1E!important;overflow:hidden!important;}',\n                '#container,.amap-container,.amap-layers,.amap-maps{',\n                'margin:0!important;padding:0!important;border:none!important;outline:none!important;',\n                'background:#1C1C1E!important;box-shadow:none!important;}',\n                'canvas{display:block!important;}',\n                '" + str + "'\n              ].join('');\n              return !!document.querySelector('.amap-logo') || !!document.getElementById('container');\n            })();\n            "), new ValueCallback() { // from class: com.stepos.ailauncher.amap.route.t
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    C2410v.N(iF, attempt, scheduleRetry, (String) obj);
                }
            });
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "polishLiteMapChrome evaluate failed", thE, false, 8, null);
            if (attempt < 8) {
                scheduleRetry.invoke(Integer.valueOf(attempt + 1));
            }
        }
    }

    public final Runnable O(final MapView mapView, long timeoutMs, InterfaceC5074l<? super Boolean, Y8.t> onDone) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        kotlin.jvm.internal.p.i(onDone, "onDone");
        long jElapsedRealtime = SystemClock.elapsedRealtime() + timeoutMs;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Q(ref$BooleanRef, mapView, jElapsedRealtime, onDone, ref$ObjectRef);
        return new Runnable() { // from class: com.stepos.ailauncher.amap.route.b
            @Override // java.lang.Runnable
            public final void run() {
                C2410v.P(ref$BooleanRef, ref$ObjectRef, mapView);
            }
        };
    }

    public final void W(AMap aMap, float maxZoom, float minZoom) {
        Object objB;
        Object objB2;
        Object objB3;
        Object objB4;
        Object objB5;
        Object objB6;
        kotlin.jvm.internal.p.i(aMap, "aMap");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Float.valueOf(aMap.getMaxZoomLevel()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Float f10 = (Float) objB;
        try {
            objB2 = Result.b(Float.valueOf(aMap.getMinZoomLevel()));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        Float f11 = (Float) objB2;
        float fMax = Math.max(maxZoom, f10 != null ? f10.floatValue() : maxZoom);
        try {
            aMap.setMaxZoomLevel(fMax);
            objB3 = Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB3 = Result.b(C4849c.a(th3));
        }
        Throwable thE = Result.e(objB3);
        if (thE != null) {
            C4148a.t(TAG, "setMaxZoomLevel failed", thE, false, 8, null);
        }
        try {
            aMap.setMinZoomLevel(minZoom);
            objB4 = Result.b(Y8.t.f7040a);
        } catch (Throwable th4) {
            Result.Companion companion5 = Result.INSTANCE;
            objB4 = Result.b(C4849c.a(th4));
        }
        Throwable thE2 = Result.e(objB4);
        if (thE2 != null) {
            C4148a.t(TAG, "setMinZoomLevel failed", thE2, false, 8, null);
        }
        try {
            objB5 = Result.b(Float.valueOf(aMap.getMaxZoomLevel()));
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.INSTANCE;
            objB5 = Result.b(C4849c.a(th5));
        }
        if (Result.g(objB5)) {
            objB5 = null;
        }
        Float f12 = (Float) objB5;
        try {
            objB6 = Result.b(Float.valueOf(aMap.getMinZoomLevel()));
        } catch (Throwable th6) {
            Result.Companion companion7 = Result.INSTANCE;
            objB6 = Result.b(C4849c.a(th6));
        }
        if (Result.g(objB6)) {
            objB6 = null;
        }
        Float f13 = (Float) objB6;
        if (kotlin.jvm.internal.p.c(f10, f12) && kotlin.jvm.internal.p.c(f11, f13)) {
            C4148a.k(TAG, "ensureZoomRange min=" + f13 + " max=" + f12 + " (unchanged)", false, 4, null);
            return;
        }
        C4148a.k(TAG, "ensureZoomRange min " + f11 + "→" + f13 + " max " + f10 + "→" + f12 + " want=[" + minZoom + Const.STR_MART_COMMA + fMax + "]", false, 4, null);
    }

    public final WebView Y(View root) {
        if (root instanceof WebView) {
            return (WebView) root;
        }
        if (!(root instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) root;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            WebView webViewY = Y(childAt);
            if (webViewY != null) {
                return webViewY;
            }
        }
        return null;
    }

    public final void Z(AMap aMap) {
        Object objB;
        kotlin.jvm.internal.p.i(aMap, "aMap");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(aMap.getUiSettings());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        UiSettings uiSettings = (UiSettings) objB;
        if (uiSettings == null) {
            return;
        }
        for (String str : C1173v.p("setZoomControlsEnabled", "setScaleControlsEnabled", "setCompassEnabled", "setMyLocationButtonEnabled", "setAllGesturesEnabled", "setZoomGesturesEnabled", "setScrollGesturesEnabled", "setRotateGesturesEnabled", "setTiltGesturesEnabled")) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(UiSettings.class.getMethod(str, Boolean.TYPE).invoke(uiSettings, Boolean.FALSE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }
    }

    public final void a0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        mapView.setBackgroundColor(LITE_MAP_DARK_COLOR);
        b0(mapView);
        e0(mapView);
    }

    public final void b0(View root) {
        try {
            Result.Companion companion = Result.INSTANCE;
            root.setBackgroundColor(LITE_MAP_DARK_COLOR);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (root instanceof WebView) {
            try {
                ((WebView) root).setBackgroundColor(LITE_MAP_DARK_COLOR);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        } else if (root instanceof SurfaceView) {
            try {
                root.setBackgroundColor(LITE_MAP_DARK_COLOR);
                ((SurfaceView) root).setZOrderOnTop(false);
                ((SurfaceView) root).setZOrderMediaOverlay(false);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.b(C4849c.a(th3));
            }
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                b0(childAt);
            }
        }
    }

    public final LiteCameraSnapshot c0(String result) {
        Object objB;
        Object objB2;
        if (result == null || kotlin.jvm.internal.p.d(result, "null")) {
            return null;
        }
        String string = La.H.D1(result).toString();
        if (La.D.X(string, "\"", false, 2, null) && La.D.K(string, "\"", false, 2, null)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Object objNextValue = new JSONTokener(string).nextValue();
                objB2 = Result.b(objNextValue instanceof String ? (String) objNextValue : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            if (Result.g(objB2)) {
                objB2 = null;
            }
            String str = (String) objB2;
            if (str != null) {
                string = str;
            }
        }
        if (kotlin.jvm.internal.p.d(string, "no-map") || La.D.X(string, "err:", false, 2, null)) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(string);
            Double dValueOf = Double.valueOf(jSONObject.optDouble("zoom", -1.0d));
            if (dValueOf.doubleValue() <= 0.0d) {
                dValueOf = null;
            }
            Float fValueOf = dValueOf != null ? Float.valueOf((float) dValueOf.doubleValue()) : null;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("center");
            Double dValueOf2 = jSONArrayOptJSONArray != null ? Double.valueOf(jSONArrayOptJSONArray.optDouble(0, Double.NaN)) : null;
            Double dValueOf3 = jSONArrayOptJSONArray != null ? Double.valueOf(jSONArrayOptJSONArray.optDouble(1, Double.NaN)) : null;
            objB = Result.b((fValueOf == null || dValueOf2 == null || dValueOf3 == null || Double.isNaN(dValueOf2.doubleValue()) || Double.isNaN(dValueOf3.doubleValue())) ? null : new LiteCameraSnapshot(fValueOf.floatValue(), dValueOf2.doubleValue(), dValueOf3.doubleValue()));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "parseLiteCameraSnapshot failed decoded=" + string, thE, false, 8, null);
        }
        return (LiteCameraSnapshot) (Result.g(objB) ? null : objB);
    }

    public final Integer d0(AMap aMap) {
        Object objB;
        if (aMap == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objInvoke = AMap.class.getMethod("getMapType", null).invoke(aMap, null);
            objB = Result.b(objInvoke instanceof Integer ? (Integer) objInvoke : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Integer) (Result.g(objB) ? null : objB);
    }

    public final void e0(MapView mapView) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        mapView.setElevation(0.0f);
        mapView.setTranslationZ(0.0f);
        f0(mapView);
    }

    public final void f0(View root) {
        if (root instanceof WebView) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ((WebView) root).setElevation(0.0f);
                ((WebView) root).setTranslationZ(0.0f);
                if (((WebView) root).getLayerType() != 0) {
                    ((WebView) root).setLayerType(0, null);
                }
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        } else if (root instanceof SurfaceView) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                ((SurfaceView) root).setZOrderOnTop(false);
                ((SurfaceView) root).setZOrderMediaOverlay(false);
                ((SurfaceView) root).setElevation(0.0f);
                ((SurfaceView) root).setTranslationZ(0.0f);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                f0(childAt);
            }
        }
    }

    public final Runnable g0(final MapView mapView, final int logoInsetPx) {
        kotlin.jvm.internal.p.i(mapView, "mapView");
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        M(mapView, logoInsetPx, 0, new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C2410v.h0(ref$BooleanRef, ref$ObjectRef, mapView, logoInsetPx, ((Integer) obj).intValue());
            }
        });
        return new Runnable() { // from class: com.stepos.ailauncher.amap.route.s
            @Override // java.lang.Runnable
            public final void run() {
                C2410v.i0(ref$BooleanRef, ref$ObjectRef, mapView);
            }
        };
    }

    public final boolean m0(MapView mapView, final InterfaceC5074l<? super AMap, Y8.t> onReady) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(mapView, "mapView");
        kotlin.jvm.internal.p.i(onReady, "onReady");
        C4148a.k(TAG, "resolveAMap enter mvClass=" + mapView.getClass().getSimpleName() + " size=" + mapView.getWidth() + "x" + mapView.getHeight() + " attached=" + mapView.isAttachedToWindow(), false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objInvoke = mapView.getClass().getMethod("getMap", null).invoke(mapView, null);
            objB = Result.b(objInvoke instanceof AMap ? (AMap) objInvoke : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        AMap aMap = (AMap) objB;
        if (aMap != null) {
            C4148a.k(TAG, "resolveAMap sync amap=" + System.identityHashCode(aMap), false, 4, null);
            onReady.invoke(aMap);
            return true;
        }
        try {
            mapView.getClass().getMethod("getMapAsyn", AMap.OnMapReadyListener.class).invoke(mapView, Proxy.newProxyInstance(AMap.OnMapReadyListener.class.getClassLoader(), new Class[]{AMap.OnMapReadyListener.class}, new InvocationHandler() { // from class: com.stepos.ailauncher.amap.route.u
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return C2410v.n0(onReady, obj, method, objArr);
                }
            }));
            C4148a.k(TAG, "resolveAMap async registered (waiting for callback)", false, 4, null);
            objB2 = Result.b(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB2);
        if (thE != null) {
            C4148a.t(TAG, "resolveAMap failed", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB2)) {
            objB2 = bool;
        }
        return ((Boolean) objB2).booleanValue();
    }

    public final void o0(AMap aMap, boolean enabled) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(aMap, "aMap");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(aMap.getUiSettings());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        UiSettings uiSettings = (UiSettings) objB;
        if (uiSettings == null) {
            return;
        }
        try {
            UiSettings.class.getMethod("setAllGesturesEnabled", Boolean.TYPE).invoke(uiSettings, Boolean.valueOf(enabled));
            objB2 = Result.b(Integer.valueOf(C4148a.k(TAG, "setAllGesturesEnabled enabled=" + enabled, false, 4, null)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB2);
        if (thE != null) {
            C4148a.t(TAG, "setAllGesturesEnabled(" + enabled + ") failed", thE, false, 8, null);
        }
    }

    public final void v(AMap aMap) {
        Object objB;
        Object objB2;
        Object objB3;
        kotlin.jvm.internal.p.i(aMap, "aMap");
        try {
            Result.Companion companion = Result.INSTANCE;
            try {
                Object objInvoke = aMap.getClass().getMethod("getMapType", null).invoke(aMap, null);
                objB2 = Result.b(objInvoke instanceof Integer ? (Integer) objInvoke : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            if (Result.g(objB2)) {
                objB2 = null;
            }
            Integer num = (Integer) objB2;
            if (num == null || num.intValue() != 3) {
                aMap.getClass().getMethod("setMapType", Integer.TYPE).invoke(aMap, 3);
            }
            try {
                Object objInvoke2 = aMap.getClass().getMethod("getMapType", null).invoke(aMap, null);
                objB3 = Result.b(objInvoke2 instanceof Integer ? (Integer) objInvoke2 : null);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB3 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB3)) {
                objB3 = null;
            }
            Integer num2 = (Integer) objB3;
            objB = Result.b(Integer.valueOf(C4148a.k(TAG, "applyDarkStyle before=" + num + " after=" + num2 + " night=3 changed=" + (!kotlin.jvm.internal.p.d(num, num2)) + " t=" + SystemClock.elapsedRealtime(), false, 4, null)));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th3));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "applyDarkStyle failed", thE, false, 8, null);
        }
        X(this, aMap, 0.0f, 0.0f, 6, null);
    }

    public final void w(final MapView mapView, final double southwestLat, final double southwestLng, final double northeastLat, final double northeastLng, final int paddingTopPx, final int paddingRightPx, final int paddingBottomPx, final int paddingLeftPx, final int attempt, final InterfaceC5074l<? super LiteCameraSnapshot, Y8.t> onVerified) {
        Object objB;
        kotlin.jvm.internal.p.i(mapView, "mapView");
        final WebView webViewY = Y(mapView);
        if (webViewY == null) {
            if (attempt < 8) {
                mapView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2410v.y(mapView, southwestLat, southwestLng, northeastLat, northeastLng, paddingTopPx, paddingRightPx, paddingBottomPx, paddingLeftPx, attempt, onVerified);
                    }
                }, 200L);
                return;
            }
            C4148a.u(TAG, "applyLiteBoundsJs: no WebView", false, 4, null);
            if (onVerified != null) {
                onVerified.invoke(null);
                return;
            }
            return;
        }
        Float fValueOf = Float.valueOf(mapView.getResources().getDisplayMetrics().density);
        Float f10 = fValueOf.floatValue() > 0.0f ? fValueOf : null;
        float fFloatValue = f10 != null ? f10.floatValue() : 1.0f;
        final int iD = D(fFloatValue, paddingTopPx);
        final int iD2 = D(fFloatValue, paddingRightPx);
        final int iD3 = D(fFloatValue, paddingBottomPx);
        final int iD4 = D(fFloatValue, paddingLeftPx);
        String strN = La.w.n("\n            (function(){\n              try {\n                if(typeof window.setBounds!=='function') return 'no-setBounds';\n                var m=window.map;\n                var before=m&&typeof m.getZoom==='function' ? m.getZoom() : null;\n                window.setBounds(\n                  [" + southwestLng + Const.STR_MART_COMMA + southwestLat + "],\n                  [" + northeastLng + Const.STR_MART_COMMA + northeastLat + "],\n                  false,\n                  [" + iD + Const.STR_MART_COMMA + iD3 + Const.STR_MART_COMMA + iD4 + Const.STR_MART_COMMA + iD2 + "]\n                );\n                var after=m&&typeof m.getZoom==='function' ? m.getZoom() : null;\n                return JSON.stringify({method:'control.setBounds',before:before,after:after});\n              } catch(e) { return 'err:'+String(e); }\n            })();\n            ");
        try {
            Result.Companion companion = Result.INSTANCE;
            webViewY.evaluateJavascript(strN, new ValueCallback() { // from class: com.stepos.ailauncher.amap.route.g
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    C2410v.z(attempt, iD, iD3, iD4, iD2, mapView, webViewY, this, southwestLat, southwestLng, northeastLat, northeastLng, paddingTopPx, paddingRightPx, paddingBottomPx, paddingLeftPx, onVerified, (String) obj);
                }
            });
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "applyLiteBoundsJs failed", thE, false, 8, null);
        }
    }
}
