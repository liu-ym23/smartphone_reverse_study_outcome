package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.C2414z;
import com.stepos.ailauncher.amap.route.GeoPoint;
import com.stepos.ailauncher.amap.route.U;
import com.stepos.ailauncher.foundation.R$dimen;
import com.stepos.ailauncher.foundation.R$drawable;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u009a\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\fJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001f\u0010\u0016JM\u0010*\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0011\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J=\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b-\u0010.JC\u00104\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\n\b\u0002\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u00103\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u0010\fJO\u00109\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0011\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00132\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u000107H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\fJ\u000f\u0010>\u001a\u00020\nH\u0002¢\u0006\u0004\b>\u0010\fJ\u001d\u0010@\u001a\u00020?2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010\fJ\u0019\u0010D\u001a\u00020\n2\b\b\u0002\u0010C\u001a\u00020(H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\n2\b\b\u0002\u0010C\u001a\u00020(H\u0002¢\u0006\u0004\bF\u0010EJ\u000f\u0010G\u001a\u00020(H\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\nH\u0002¢\u0006\u0004\bI\u0010\fJ/\u0010L\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010K\u001a\u00020J2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\nH\u0002¢\u0006\u0004\bN\u0010\fJ)\u0010O\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\nH\u0002¢\u0006\u0004\bQ\u0010\fJ\u0017\u0010R\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bR\u0010SJ%\u0010T\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\nH\u0002¢\u0006\u0004\bV\u0010\fJ#\u0010W\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\bW\u0010UJ\r\u0010X\u001a\u00020\n¢\u0006\u0004\bX\u0010\fJ\r\u0010Y\u001a\u00020\n¢\u0006\u0004\bY\u0010\fJ\r\u0010Z\u001a\u00020\n¢\u0006\u0004\bZ\u0010\fJ\u000f\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020(¢\u0006\u0004\b^\u0010HR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010_R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010`R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010aR*\u0010b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR0\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR*\u0010o\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010c\u001a\u0004\bp\u0010e\"\u0004\bq\u0010gR*\u0010r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010c\u001a\u0004\bs\u0010e\"\u0004\bt\u0010gR\u0018\u0010u\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010w\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010{\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010zR\u0018\u0010|\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010zR\u001d\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010XR\u0018\u0010\u0082\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010XR\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010zR\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008c\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008c\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008c\u0001R\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010vR\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008c\u0001R\u0019\u0010\u0092\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0094\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008c\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/y;", "", "Landroid/widget/FrameLayout;", "slot", "Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", "loadingIndicator", "<init>", "(Landroid/widget/FrameLayout;Landroid/widget/ImageView;Landroid/view/View;)V", "LY8/t;", "D0", "()V", "b0", "v", ExifInterface.LONGITUDE_EAST, "d0", "w", "J", "", "reason", "X", "(Ljava/lang/String;)V", "u0", "u", "N", "Lcom/amap/api/maps/MapView;", "mv", "from", "a0", "(Lcom/amap/api/maps/MapView;Ljava/lang/String;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/amap/api/maps/AMap;", "aMap", "", "Lcom/stepos/ailauncher/amap/route/x;", "points", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "key", "", "repaint", "R", "(Lcom/amap/api/maps/MapView;Lcom/amap/api/maps/AMap;Ljava/util/List;IILjava/lang/String;Z)V", "cardId", "G", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;II)V", "", "jsZoom", "", "jsCenterLat", "jsCenterLng", "P", "(Ljava/lang/String;Lcom/amap/api/maps/AMap;Ljava/lang/Float;Ljava/lang/Double;Ljava/lang/Double;)V", "B", "Lkotlin/Function0;", "onCameraReady", "l0", "(Lcom/amap/api/maps/AMap;Ljava/util/List;IILjava/lang/String;Lp9/a;)V", "f0", "(Lcom/amap/api/maps/MapView;)V", "y", "L", "Lcom/amap/api/maps/model/LatLngBounds;", "t", "(Ljava/util/List;)Lcom/amap/api/maps/model/LatLngBounds;", "O", "showLoading", "s0", "(Z)V", "C", "w0", "()Z", "Y", "", "delayMs", "h0", "(Lcom/amap/api/maps/MapView;Ljava/lang/String;JLjava/lang/String;)V", "z", "j0", "(Lcom/amap/api/maps/MapView;Ljava/lang/String;Ljava/lang/String;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M", "(Lcom/amap/api/maps/MapView;)Z", "B0", "(Ljava/lang/String;Ljava/util/List;)V", "x", "s", "Z", ExifInterface.LONGITUDE_WEST, "F", "Lcom/amap/api/maps/model/CameraPosition;", "D", "()Lcom/amap/api/maps/model/CameraPosition;", "K", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "Landroid/view/View;", "onMapReady", "Lp9/a;", "getOnMapReady", "()Lp9/a;", "q0", "(Lp9/a;)V", "Lkotlin/Function1;", "onMapFailed", "Lp9/l;", "getOnMapFailed", "()Lp9/l;", "p0", "(Lp9/l;)V", "onCameraSettled", "getOnCameraSettled", "o0", "onMapVisible", "getOnMapVisible", "r0", "currentMapView", "Lcom/amap/api/maps/MapView;", "currentAMap", "Lcom/amap/api/maps/AMap;", "pendingKey", "Ljava/lang/String;", "settledCameraKey", "settledCamera", "Lcom/amap/api/maps/model/CameraPosition;", "lastCardId", "lastPoints", "Ljava/util/List;", "hasDisplayedMap", "layersIntact", "activeCameraKey", "Landroid/view/View$OnLayoutChangeListener;", "pendingLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "hardReleaseRunnable", "Ljava/lang/Runnable;", "deferredSoftDetachRunnable", "stableRevealRunnable", "visualReadyRunnable", "visualReadyMapView", "acquireWatchdog", "acquireRetry", "I", "cameraGeneration", "pinBelowRunnable", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry;", "visibilityRetry", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3284y {

    @Deprecated
    public static final long ACQUIRE_TIMEOUT_MS = 3000;

    @Deprecated
    public static final long COLD_REVEAL_DELAY_MS = 180;
    private static final a Companion = new a(null);

    @Deprecated
    public static final String JANK_TAG = "MapScrollJank";

    @Deprecated
    public static final int MAX_ACQUIRE_RETRY = 2;

    @Deprecated
    public static final long PIN_BELOW_RETRY_MS = 320;

    @Deprecated
    public static final long REATTACH_GRACE_MS = 2000;

    @Deprecated
    public static final String TAG = "LiveOverviewMapBinder";

    @Deprecated
    public static final long WARM_REVEAL_DELAY_MS = 300;
    private int acquireRetry;
    private Runnable acquireWatchdog;
    private String activeCameraKey;
    private int cameraGeneration;
    private AMap currentAMap;
    private MapView currentMapView;
    private Runnable deferredSoftDetachRunnable;
    private Runnable hardReleaseRunnable;
    private boolean hasDisplayedMap;
    private final ImageView imageView;
    private String lastCardId;
    private List<GeoPoint> lastPoints;
    private boolean layersIntact;
    private final View loadingIndicator;
    private final Handler mainHandler;
    private InterfaceC5063a<Y8.t> onCameraSettled;
    private InterfaceC5074l<? super String, Y8.t> onMapFailed;
    private InterfaceC5063a<Y8.t> onMapReady;
    private InterfaceC5063a<Y8.t> onMapVisible;
    private String pendingKey;
    private View.OnLayoutChangeListener pendingLayoutListener;
    private Runnable pinBelowRunnable;
    private CameraPosition settledCamera;
    private String settledCameraKey;
    private final FrameLayout slot;
    private Runnable stableRevealRunnable;
    private final MapSlotVisibilityRetry visibilityRetry;
    private MapView visualReadyMapView;
    private Runnable visualReadyRunnable;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/y$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "JANK_TAG", "", "REATTACH_GRACE_MS", "J", "PIN_BELOW_RETRY_MS", "ACQUIRE_TIMEOUT_MS", "COLD_REVEAL_DELAY_MS", "WARM_REVEAL_DELAY_MS", "", "MAX_ACQUIRE_RETRY", "I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.y$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public C3284y(FrameLayout slot, ImageView imageView, View loadingIndicator) {
        kotlin.jvm.internal.p.i(slot, "slot");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        kotlin.jvm.internal.p.i(loadingIndicator, "loadingIndicator");
        this.slot = slot;
        this.imageView = imageView;
        this.loadingIndicator = loadingIndicator;
        this.lastPoints = C1173v.m();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.visibilityRetry = new MapSlotVisibilityRetry(slot, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(C3284y.x0(this.f27232a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3284y.y0(this.f27273a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3284y.z0(this.f27277a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3284y.A0(this.f27281a);
            }
        });
        imageView.setBackgroundResource(R$drawable.bg_map_slot_top_rounded);
    }

    public static final Y8.t A0(C3284y c3284y) {
        c3284y.D0();
        return Y8.t.f7040a;
    }

    public static final void C0(C3284y c3284y, String str, List list, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (c3284y.slot.getWidth() <= 0 || c3284y.slot.getHeight() <= 0) {
            return;
        }
        c3284y.x();
        c3284y.s(str, list);
    }

    public static final Y8.t H(final C3284y c3284y, final MapView mapView, final String str, List list, int i10, int i11, String str2, AMap aMap) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(aMap, "aMap");
        if (c3284y.currentMapView != mapView) {
            c3284y.a0(mapView, "acquire");
            return Y8.t.f7040a;
        }
        c3284y.currentAMap = aMap;
        c3284y.N();
        if (!kotlin.jvm.internal.p.d(c3284y.pendingKey, str)) {
            c3284y.V("acquire");
            return Y8.t.f7040a;
        }
        c3284y.layersIntact = false;
        c3284y.activeCameraKey = str;
        c3284y.l0(aMap, list, i10, i11, str, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3284y.I(this.f27268a, str, mapView);
            }
        });
        int dimensionPixelSize = c3284y.slot.getResources().getDimensionPixelSize(R$dimen.card_map_logo_inset);
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        k10.T(mapView, dimensionPixelSize);
        k10.a0(mapView);
        c3284y.f0(mapView);
        c3284y.hasDisplayedMap = true;
        c3284y.visibilityRetry.v();
        C4148a.k(TAG, "map ready cardId=" + str2 + " " + k10.I(), false, 4, null);
        c3284y.O();
        return Y8.t.f7040a;
    }

    public static final Y8.t I(C3284y c3284y, String str, MapView mapView) {
        if (!kotlin.jvm.internal.p.d(c3284y.activeCameraKey, str)) {
            return Y8.t.f7040a;
        }
        c3284y.activeCameraKey = null;
        c3284y.layersIntact = true;
        c3284y.h0(mapView, str, 180L, "camera-acquire");
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void Q(C3284y c3284y, String str, AMap aMap, Float f10, Double d10, Double d11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f10 = null;
        }
        if ((i10 & 8) != 0) {
            d10 = null;
        }
        if ((i10 & 16) != 0) {
            d11 = null;
        }
        c3284y.P(str, aMap, f10, d10, d11);
    }

    public static final Y8.t S(C3284y c3284y, String str, MapView mapView) {
        if (!kotlin.jvm.internal.p.d(c3284y.activeCameraKey, str)) {
            return Y8.t.f7040a;
        }
        c3284y.activeCameraKey = null;
        c3284y.layersIntact = true;
        c3284y.h0(mapView, str, 180L, "camera-same-slot");
        return Y8.t.f7040a;
    }

    public static final Y8.t T(final C3284y c3284y, final MapView mapView, final String str, boolean z10, List list, int i10, int i11, AMap ready) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(ready, "ready");
        if (c3284y.currentMapView != mapView) {
            c3284y.a0(mapView, "reattach");
            return Y8.t.f7040a;
        }
        c3284y.currentAMap = ready;
        c3284y.N();
        if (!kotlin.jvm.internal.p.d(c3284y.pendingKey, str)) {
            c3284y.V("reattach");
            return Y8.t.f7040a;
        }
        int dimensionPixelSize = c3284y.slot.getResources().getDimensionPixelSize(R$dimen.card_map_logo_inset);
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        k10.T(mapView, dimensionPixelSize);
        k10.a0(mapView);
        c3284y.f0(mapView);
        if (z10) {
            c3284y.layersIntact = false;
            c3284y.activeCameraKey = str;
            c3284y.l0(ready, list, i10, i11, str, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.l
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C3284y.U(this.f27256a, str, mapView);
                }
            });
        } else {
            c3284y.h0(mapView, str, 300L, "camera-reattach-warm");
            Q(c3284y, str, ready, null, null, null, 28, null);
            InterfaceC5063a<Y8.t> interfaceC5063a = c3284y.onCameraSettled;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        c3284y.hasDisplayedMap = true;
        c3284y.visibilityRetry.v();
        C4148a.k(TAG, "reattach ok repaint=" + z10 + " layersIntact=" + c3284y.layersIntact + " key=" + str + " " + k10.I(), false, 4, null);
        c3284y.O();
        return Y8.t.f7040a;
    }

    public static final Y8.t U(C3284y c3284y, String str, MapView mapView) {
        if (!kotlin.jvm.internal.p.d(c3284y.activeCameraKey, str)) {
            return Y8.t.f7040a;
        }
        c3284y.activeCameraKey = null;
        c3284y.layersIntact = true;
        c3284y.h0(mapView, str, 180L, "camera-reattach");
        return Y8.t.f7040a;
    }

    public static final void c0(C3284y c3284y) {
        c3284y.E();
    }

    public static final void e0(C3284y c3284y) {
        c3284y.J();
    }

    public static final void g0(C3284y c3284y, MapView mapView) {
        c3284y.pinBelowRunnable = null;
        if (c3284y.currentMapView == mapView && mapView.getParent() == c3284y.slot) {
            com.stepos.ailauncher.amap.route.K.INSTANCE.a0(mapView);
        }
    }

    public static final void i0(C3284y c3284y, int i10, String str, MapView mapView, String str2) {
        c3284y.stableRevealRunnable = null;
        if (i10 == c3284y.cameraGeneration && kotlin.jvm.internal.p.d(c3284y.pendingKey, str) && c3284y.currentMapView == mapView) {
            ViewParent parent = mapView.getParent();
            FrameLayout frameLayout = c3284y.slot;
            if (parent == frameLayout && frameLayout.isAttachedToWindow() && c3284y.layersIntact && c3284y.activeCameraKey == null) {
                if (c3284y.w0()) {
                    c3284y.hasDisplayedMap = true;
                    C4148a.k(TAG, "stable reveal from=" + str2 + " key=" + str, false, 4, null);
                    return;
                }
                c3284y.hasDisplayedMap = false;
                c3284y.visibilityRetry.v();
                C4148a.u(TAG, "stable reveal rejected from=" + str2 + " key=" + str, false, 4, null);
                return;
            }
        }
        C4148a.k(TAG, "stable reveal stale from=" + str2 + " key=" + str, false, 4, null);
    }

    public static final void k0(Ref$IntRef ref$IntRef, MapView mapView, Ref$ObjectRef ref$ObjectRef, C3284y c3284y, int i10, String str, String str2) {
        int i11 = ref$IntRef.f34818a;
        ref$IntRef.f34818a = i11 + 1;
        Runnable runnable = null;
        if (i11 == 0) {
            T t10 = ref$ObjectRef.f34820a;
            if (t10 == 0) {
                kotlin.jvm.internal.p.A("r");
            } else {
                runnable = (Runnable) t10;
            }
            mapView.postOnAnimation(runnable);
            return;
        }
        c3284y.visualReadyRunnable = null;
        c3284y.visualReadyMapView = null;
        if (i10 == c3284y.cameraGeneration && kotlin.jvm.internal.p.d(c3284y.pendingKey, str) && c3284y.currentMapView == mapView) {
            ViewParent parent = mapView.getParent();
            FrameLayout frameLayout = c3284y.slot;
            if (parent == frameLayout && frameLayout.isAttachedToWindow() && mapView.getVisibility() == 0 && c3284y.imageView.getVisibility() == 8 && c3284y.hasDisplayedMap) {
                C4148a.k(TAG, "visual ready from=" + str2 + " key=" + str, false, 4, null);
                InterfaceC5063a<Y8.t> interfaceC5063a = c3284y.onMapVisible;
                if (interfaceC5063a != null) {
                    interfaceC5063a.invoke();
                    return;
                }
                return;
            }
        }
        C4148a.k(TAG, "visual ready stale from=" + str2 + " key=" + str, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Y8.t m0(int i10, C3284y c3284y, String str, AMap aMap, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, InterfaceC5063a interfaceC5063a) {
        Object objB;
        if (i10 == c3284y.cameraGeneration) {
            MapView mapView = c3284y.currentMapView;
            if ((mapView != null ? mapView.getParent() : null) == c3284y.slot) {
                c3284y.P(str, aMap, (Float) ref$ObjectRef.f34820a, (Double) ref$ObjectRef2.f34820a, (Double) ref$ObjectRef3.f34820a);
                if (interfaceC5063a != null) {
                    interfaceC5063a.invoke();
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(Float.valueOf(aMap.getCameraPosition().zoom));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                C4148a.k(TAG, "cameraSettled zoom=" + objB, false, 4, null);
                InterfaceC5063a<Y8.t> interfaceC5063a2 = c3284y.onCameraSettled;
                if (interfaceC5063a2 != null) {
                    interfaceC5063a2.invoke();
                }
                return Y8.t.f7040a;
            }
        }
        C4148a.k(TAG, "cameraSettled stale, skip", false, 4, null);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Y8.t n0(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Float f10, Double d10, Double d11) {
        ref$ObjectRef.f34820a = f10;
        ref$ObjectRef2.f34820a = d10;
        ref$ObjectRef3.f34820a = d11;
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void t0(C3284y c3284y, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        c3284y.s0(z10);
    }

    public static final void v0(C3284y c3284y) {
        String str;
        c3284y.acquireWatchdog = null;
        if (c3284y.currentAMap == null && (str = c3284y.lastCardId) != null) {
            int i10 = c3284y.acquireRetry;
            if (i10 >= 2) {
                C4148a.u(TAG, "acquire watchdog give up retry=" + i10 + " cardId=" + str, false, 4, null);
                t0(c3284y, false, 1, null);
                InterfaceC5074l<? super String, Y8.t> interfaceC5074l = c3284y.onMapFailed;
                if (interfaceC5074l != null) {
                    interfaceC5074l.invoke("acquire_timeout");
                    return;
                }
                return;
            }
            int i11 = i10 + 1;
            c3284y.acquireRetry = i11;
            C4148a.u(TAG, "acquire watchdog fired retry=" + i11 + " cardId=" + str, false, 4, null);
            c3284y.X("watchdog");
            c3284y.pendingKey = null;
            t0(c3284y, false, 1, null);
            c3284y.s(str, c3284y.lastPoints);
        }
    }

    public static final boolean x0(C3284y c3284y) {
        return !c3284y.hasDisplayedMap;
    }

    public static final Y8.t y0(C3284y c3284y) {
        String str = c3284y.lastCardId;
        if (str == null) {
            return Y8.t.f7040a;
        }
        c3284y.s(str, c3284y.lastPoints);
        return Y8.t.f7040a;
    }

    public static final Y8.t z0(C3284y c3284y) {
        c3284y.v();
        c3284y.w();
        MapView mapView = c3284y.currentMapView;
        if (mapView != null && mapView.getParent() == c3284y.slot) {
            if (c3284y.M(mapView)) {
                com.stepos.ailauncher.amap.route.K.INSTANCE.d0(mapView);
                c3284y.j0(mapView, c3284y.pendingKey, "warm-resume");
            } else if (c3284y.currentAMap == null || c3284y.activeCameraKey != null) {
                com.stepos.ailauncher.amap.route.K.INSTANCE.d0(mapView);
            } else {
                if (mapView.getVisibility() != 0 || c3284y.imageView.getVisibility() != 8) {
                    c3284y.s0(true);
                }
                com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
                k10.d0(mapView);
                k10.a0(mapView);
                String str = c3284y.pendingKey;
                if (str != null && c3284y.layersIntact && c3284y.activeCameraKey == null) {
                    c3284y.h0(mapView, str, 300L, "visible");
                }
            }
        }
        return Y8.t.f7040a;
    }

    public final void A() {
        MapView mapView = this.visualReadyMapView;
        Runnable runnable = this.visualReadyRunnable;
        if (mapView != null && runnable != null) {
            mapView.removeCallbacks(runnable);
        }
        this.visualReadyRunnable = null;
        this.visualReadyMapView = null;
    }

    public final void B() {
        this.settledCameraKey = null;
        this.settledCamera = null;
    }

    public final void B0(final String cardId, final List<GeoPoint> points) {
        x();
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.i
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                C3284y.C0(this.f27239a, cardId, points, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.pendingLayoutListener = onLayoutChangeListener;
        this.slot.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public final void C(boolean showLoading) {
        s0(showLoading);
    }

    /* renamed from: D, reason: from getter */
    public final CameraPosition getSettledCamera() {
        return this.settledCamera;
    }

    public final void D0() {
        MapView mapView = this.currentMapView;
        if (mapView == null) {
            this.hasDisplayedMap = false;
            return;
        }
        if (mapView.getParent() != this.slot) {
            if (mapView.getParent() != null) {
                C4148a.k(TAG, "yield offscreen stolen cardId=" + this.lastCardId + " " + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
                this.currentMapView = null;
                this.currentAMap = null;
                this.layersIntact = false;
            }
            this.hasDisplayedMap = false;
            A();
            t0(this, false, 1, null);
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str = this.lastCardId;
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " POI_YIELD_PAUSE cardId=" + str + " pool=" + k10.I(), false, 4, null);
        y();
        A();
        s0(true);
        k10.Z(mapView);
        b0();
    }

    public final void E() {
        this.deferredSoftDetachRunnable = null;
        MapView mapView = this.currentMapView;
        if (mapView != null && mapView.getParent() == this.slot) {
            y();
            z();
            L();
            com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String str = this.lastCardId;
            com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
            C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " POI_YIELD_DETACH cardId=" + str + " pool=" + k10.I(), false, 4, null);
            k10.G(mapView);
            this.hasDisplayedMap = false;
            t0(this, false, 1, null);
            d0();
        }
    }

    public final void F() {
        x();
        u();
        y();
        w();
        v();
        z();
        A();
        this.visibilityRetry.w();
        L();
        this.onMapReady = null;
        this.onMapFailed = null;
        this.onCameraSettled = null;
        this.onMapVisible = null;
        MapView mapView = this.currentMapView;
        com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
        this.currentMapView = null;
        this.currentAMap = null;
        this.hasDisplayedMap = false;
        this.layersIntact = false;
        this.activeCameraKey = null;
        this.pendingKey = null;
        this.lastCardId = null;
        this.lastPoints = C1173v.m();
        if (mapView != null) {
            if (mapView.getParent() == this.slot) {
                com.stepos.ailauncher.amap.route.K.INSTANCE.c0(mapView);
            } else {
                com.stepos.ailauncher.amap.route.K.INSTANCE.k0(mapView);
            }
        }
        C4148a.k("MapScrollJank", "t=" + SystemClock.elapsedRealtime() + " POI_DESTROY pool=" + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
        Y();
    }

    public final void G(final String cardId, final List<GeoPoint> points, final String key, final int w10, final int h10) {
        X("re-acquire");
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        Context context = this.slot.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final MapView mapViewM = k10.m(context);
        if (mapViewM != null) {
            this.currentMapView = mapViewM;
            u0();
            C(true);
            k10.p(mapViewM, this.slot, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return C3284y.H(this.f27259a, mapViewM, key, points, w10, h10, cardId, (AMap) obj);
                }
            });
            return;
        }
        C4148a.k(TAG, "pool full, placeholder cardId=" + cardId + " " + k10.I(), false, 4, null);
        s0(false);
        this.visibilityRetry.v();
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = this.onMapFailed;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke("pool_full");
        }
    }

    public final void J() {
        this.hardReleaseRunnable = null;
        u();
        y();
        z();
        L();
        MapView mapView = this.currentMapView;
        com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
        this.currentMapView = null;
        this.currentAMap = null;
        this.hasDisplayedMap = false;
        this.layersIntact = false;
        this.pendingKey = null;
        if (mapView != null) {
            com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
            C4148a.k(TAG, "hard release finished=" + k10.k0(mapView) + " " + k10.I(), false, 4, null);
        }
        Y();
    }

    public final boolean K() {
        return this.settledCamera != null && kotlin.jvm.internal.p.d(this.settledCameraKey, this.pendingKey);
    }

    public final void L() {
        this.cameraGeneration++;
        this.activeCameraKey = null;
        B();
    }

    public final boolean M(MapView mv) {
        return this.hasDisplayedMap && this.layersIntact && this.pendingKey != null && mv.getParent() == this.slot && mv.getVisibility() == 0 && this.imageView.getVisibility() == 8;
    }

    public final void N() {
        u();
        this.acquireRetry = 0;
    }

    public final void O() {
        boolean z10 = this.onMapReady != null;
        C4148a.k(TAG, "notifyMapReady hasCallback=" + z10 + " displayed=" + this.hasDisplayedMap, false, 4, null);
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onMapReady;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void P(String key, AMap aMap, Float jsZoom, Double jsCenterLat, Double jsCenterLng) {
        Object objB;
        if (kotlin.jvm.internal.p.d(key, this.pendingKey)) {
            MapView mapView = this.currentMapView;
            if ((mapView != null ? mapView.getParent() : null) != this.slot) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                CameraPosition cameraPosition = aMap.getCameraPosition();
                if (jsZoom != null && jsCenterLat != null && jsCenterLng != null) {
                    cameraPosition = new CameraPosition(new LatLng(jsCenterLat.doubleValue(), jsCenterLng.doubleValue()), jsZoom.floatValue(), cameraPosition.tilt, cameraPosition.bearing);
                }
                objB = Result.b(cameraPosition);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            this.settledCamera = (CameraPosition) (Result.g(objB) ? null : objB);
            this.settledCameraKey = key;
        }
    }

    public final void R(final MapView mv, AMap aMap, final List<GeoPoint> points, final int w10, final int h10, final String key, final boolean repaint) {
        if (mv.getParent() != this.slot) {
            C(true);
            com.stepos.ailauncher.amap.route.K.INSTANCE.p(mv, this.slot, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.w
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return C3284y.T(this.f27308a, mv, key, repaint, points, w10, h10, (AMap) obj);
                }
            });
            return;
        }
        if (repaint) {
            C(true);
            this.layersIntact = false;
            this.activeCameraKey = key;
            l0(aMap, points, w10, h10, key, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.v
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C3284y.S(this.f27300a, key, mv);
                }
            });
        } else {
            h0(mv, key, 300L, "camera-same-key");
            Q(this, key, aMap, null, null, null, 28, null);
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onCameraSettled;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        k10.d0(mv);
        k10.a0(mv);
        this.hasDisplayedMap = true;
        this.visibilityRetry.v();
        O();
    }

    public final void V(String from) {
        String str = this.lastCardId;
        if (str == null) {
            return;
        }
        C4148a.k(TAG, "ready but key changed from=" + from + ", rebind latest", false, 4, null);
        s(str, this.lastPoints);
    }

    public final void W() {
        x();
        u();
        y();
        z();
        A();
        this.visibilityRetry.w();
        MapView mapView = this.currentMapView;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str = this.lastCardId;
        boolean z10 = mapView != null;
        boolean z11 = this.hasDisplayedMap;
        boolean z12 = (mapView != null ? mapView.getParent() : null) == this.slot;
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " POI_RELEASE cardId=" + str + " hasMap=" + z10 + " displayed=" + z11 + " parentSlot=" + z12 + " pool=" + k10.I(), false, 4, null);
        if (mapView == null) {
            Y();
            return;
        }
        if (mapView.getParent() == this.slot) {
            k10.Z(mapView);
            b0();
        } else {
            this.hasDisplayedMap = false;
            t0(this, false, 1, null);
            d0();
        }
    }

    public final void X(String reason) {
        MapView mapView = this.currentMapView;
        if (mapView == null) {
            return;
        }
        u();
        y();
        z();
        L();
        com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
        this.currentMapView = null;
        this.currentAMap = null;
        this.hasDisplayedMap = false;
        this.layersIntact = false;
        this.activeCameraKey = null;
        if (mapView.getParent() == this.slot) {
            com.stepos.ailauncher.amap.route.K.INSTANCE.c0(mapView);
        } else {
            com.stepos.ailauncher.amap.route.K.INSTANCE.k0(mapView);
        }
        C4148a.k(TAG, "releaseHeldMap reason=" + reason + " " + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
    }

    public final void Y() {
        s0(false);
    }

    public final void Z() {
        String str;
        w();
        v();
        String str2 = this.lastCardId;
        if (str2 == null || this.lastPoints.isEmpty()) {
            return;
        }
        MapView mapView = this.currentMapView;
        AMap aMap = this.currentAMap;
        if (mapView != null && aMap != null) {
            int width = this.slot.getWidth();
            int height = this.slot.getHeight();
            if (width > 0 && height > 0) {
                com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
                if (k10.l0(mapView) || mapView.getParent() == this.slot) {
                    String str3 = this.pendingKey;
                    if (str3 == null) {
                        str3 = str2 + "|" + this.lastPoints.hashCode() + "|" + width + "x" + height;
                    }
                    this.pendingKey = str3;
                    if (mapView.getParent() != this.slot && (str = this.activeCameraKey) != null) {
                        C4148a.k(TAG, "retry reclaimed off-slot, invalidate dead camera flight key=" + str, false, 4, null);
                        L();
                        z();
                    }
                    if (M(mapView)) {
                        k10.d0(mapView);
                        this.visibilityRetry.v();
                        return;
                    }
                    if (kotlin.jvm.internal.p.d(this.activeCameraKey, str3) && mapView.getParent() == this.slot) {
                        s0(true);
                        this.visibilityRetry.v();
                        C4148a.k(TAG, "retry coalesce camera in-flight key=" + str3, false, 4, null);
                        return;
                    }
                    boolean z10 = this.layersIntact;
                    if (!z10 || this.stableRevealRunnable == null) {
                        R(mapView, aMap, this.lastPoints, width, height, str3, !z10);
                        return;
                    }
                    this.visibilityRetry.v();
                    C4148a.k(TAG, "retry coalesce stable reveal key=" + str3, false, 4, null);
                    return;
                }
                this.currentMapView = null;
                this.currentAMap = null;
                this.hasDisplayedMap = false;
                this.layersIntact = false;
            }
        }
        if (this.currentMapView != null && this.currentAMap == null) {
            u0();
        }
        this.visibilityRetry.v();
        this.visibilityRetry.x();
    }

    public final void a0(MapView mv, String from) {
        C4148a.u(TAG, "attach callback stray from=" + from + ", return to pool", false, 4, null);
        if (mv.getParent() == this.slot) {
            com.stepos.ailauncher.amap.route.K.INSTANCE.c0(mv);
        }
    }

    public final void b0() {
        v();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.x
            @Override // java.lang.Runnable
            public final void run() {
                C3284y.c0(this.f27318a);
            }
        };
        this.deferredSoftDetachRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 2000L);
        C4148a.k(TAG, "yield pause, soft detach in 2000ms", false, 4, null);
    }

    public final void d0() {
        w();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.u
            @Override // java.lang.Runnable
            public final void run() {
                C3284y.e0(this.f27298a);
            }
        };
        this.hardReleaseRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 2000L);
        C4148a.k(TAG, "soft release, hard in 2000ms", false, 4, null);
    }

    public final void f0(final MapView mv) {
        y();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.n
            @Override // java.lang.Runnable
            public final void run() {
                C3284y.g0(this.f27266a, mv);
            }
        };
        this.pinBelowRunnable = runnable;
        mv.postDelayed(runnable, 320L);
    }

    public final void h0(final MapView mv, final String key, long delayMs, final String from) {
        if (this.stableRevealRunnable != null) {
            C4148a.k(TAG, "stable reveal already pending from=" + from + " key=" + key, false, 4, null);
            return;
        }
        A();
        s0(true);
        final int i10 = this.cameraGeneration;
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.h
            @Override // java.lang.Runnable
            public final void run() {
                C3284y.i0(this.f27234a, i10, key, mv, from);
            }
        };
        this.stableRevealRunnable = runnable;
        this.mainHandler.postDelayed(runnable, delayMs);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.stepos.ailauncher.foundation.appui.card.provider.amap.t] */
    public final void j0(final MapView mv, final String key, final String from) {
        Runnable runnable;
        if (key == null) {
            return;
        }
        A();
        final int i10 = this.cameraGeneration;
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r02 = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.t
            @Override // java.lang.Runnable
            public final void run() {
                C3284y.k0(ref$IntRef, mv, ref$ObjectRef, this, i10, key, from);
            }
        };
        ref$ObjectRef.f34820a = r02;
        this.visualReadyRunnable = (Runnable) r02;
        this.visualReadyMapView = mv;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("r");
            runnable = null;
        } else {
            runnable = (Runnable) t10;
        }
        mv.postOnAnimation(runnable);
    }

    public final void l0(final AMap aMap, List<GeoPoint> points, int w10, int h10, final String key, final InterfaceC5063a<Y8.t> onCameraReady) {
        l0 l0Var = l0.INSTANCE;
        Context context = this.slot.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        U.Padding paddingA = l0Var.c(context).a();
        LatLngBounds latLngBoundsT = t(points);
        com.stepos.ailauncher.amap.route.U u10 = com.stepos.ailauncher.amap.route.U.INSTANCE;
        CameraPosition cameraPositionG = u10.G(latLngBoundsT, w10, h10, paddingA, 60.0d, this.slot.getContext().getResources().getDisplayMetrics().density);
        final int i10 = this.cameraGeneration;
        MapView mapView = this.currentMapView;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        C4148a.k(TAG, "setCameraPosition " + com.stepos.ailauncher.amap.route.U.h(u10, aMap, latLngBoundsT, paddingA, cameraPositionG, w10, h10, mapView, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3284y.m0(i10, this, key, aMap, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, onCameraReady);
            }
        }, null, new p9.q() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.k
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return C3284y.n0(ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, (Float) obj, (Double) obj2, (Double) obj3);
            }
        }, 512, null), false, 4, null);
    }

    public final void o0(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onCameraSettled = interfaceC5063a;
    }

    public final void p0(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onMapFailed = interfaceC5074l;
    }

    public final void q0(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onMapReady = interfaceC5063a;
    }

    public final void r0(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onMapVisible = interfaceC5063a;
    }

    public final void s(String cardId, List<GeoPoint> points) {
        String str;
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(points, "points");
        w();
        v();
        x();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int size = points.size();
        boolean z10 = true;
        boolean z11 = this.currentMapView != null;
        boolean z12 = this.hasDisplayedMap;
        int width = this.slot.getWidth();
        int height = this.slot.getHeight();
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " POI_BIND cardId=" + cardId + " pts=" + size + " hasMap=" + z11 + " displayed=" + z12 + " slot=" + width + "x" + height + " pool=" + k10.I(), false, 4, null);
        if (points.isEmpty()) {
            if (!kotlin.jvm.internal.p.d(this.lastCardId, cardId) || this.currentMapView == null) {
                this.pendingKey = null;
                B();
                t0(this, false, 1, null);
                return;
            } else {
                C4148a.k(TAG, "bind skip empty points, keep map cardId=" + cardId, false, 4, null);
                return;
            }
        }
        int width2 = this.slot.getWidth();
        int height2 = this.slot.getHeight();
        if (width2 <= 0 || height2 <= 0) {
            B0(cardId, points);
            if (this.currentMapView == null) {
                t0(this, false, 1, null);
                return;
            }
            return;
        }
        String str2 = cardId + "|" + points.hashCode() + "|" + width2 + "x" + height2;
        String str3 = this.lastCardId;
        boolean z13 = (str3 == null || kotlin.jvm.internal.p.d(str3, cardId)) ? false : true;
        String str4 = this.pendingKey;
        boolean z14 = (str4 == null || kotlin.jvm.internal.p.d(str4, str2)) ? false : true;
        if (z13 || z14) {
            z();
            A();
            L();
            com.stepos.ailauncher.amap.route.U.INSTANCE.p(this.currentMapView);
            this.hasDisplayedMap = false;
            this.layersIntact = false;
            this.pendingKey = null;
            B();
        }
        if (z13) {
            this.acquireRetry = 0;
        }
        this.lastCardId = cardId;
        this.lastPoints = points;
        MapView mapView = this.currentMapView;
        boolean z15 = mapView != null && M(mapView);
        if (!C2414z.INSTANCE.d(this.slot) && !z15) {
            s0(false);
            this.visibilityRetry.v();
            C4148a.k(TAG, "bind defer offscreen key=" + str2, false, 4, null);
            return;
        }
        MapView mapView2 = this.currentMapView;
        AMap aMap = this.currentAMap;
        if (mapView2 != null && aMap != null) {
            if (k10.l0(mapView2) || mapView2.getParent() == this.slot) {
                if (mapView2.getParent() != this.slot && (str = this.activeCameraKey) != null) {
                    C4148a.k(TAG, "reclaimed off-slot, invalidate dead camera flight key=" + str, false, 4, null);
                    L();
                    z();
                }
                if (kotlin.jvm.internal.p.d(str2, this.pendingKey) && M(mapView2)) {
                    this.visibilityRetry.v();
                    return;
                }
                if (kotlin.jvm.internal.p.d(str2, this.pendingKey) && kotlin.jvm.internal.p.d(this.activeCameraKey, str2) && mapView2.getParent() == this.slot) {
                    s0(true);
                    this.visibilityRetry.v();
                    C4148a.k(TAG, "bind coalesce camera in-flight key=" + str2, false, 4, null);
                    return;
                }
                if (kotlin.jvm.internal.p.d(str2, this.pendingKey) && this.layersIntact && this.stableRevealRunnable != null) {
                    this.visibilityRetry.v();
                    C4148a.k(TAG, "bind coalesce stable reveal key=" + str2, false, 4, null);
                    return;
                }
                if (kotlin.jvm.internal.p.d(str2, this.pendingKey) && this.layersIntact) {
                    z10 = false;
                }
                this.pendingKey = str2;
                R(mapView2, aMap, points, width2, height2, str2, z10);
                return;
            }
            C4148a.k(TAG, "soft map stolen, re-acquire cardId=" + cardId, false, 4, null);
            this.currentMapView = null;
            this.currentAMap = null;
            this.hasDisplayedMap = false;
            this.layersIntact = false;
        }
        if (this.currentMapView != null && this.currentAMap == null) {
            this.pendingKey = str2;
            C4148a.k(TAG, "acquire in flight, update target only key=" + str2, false, 4, null);
            return;
        }
        if (kotlin.jvm.internal.p.d(str2, this.pendingKey) && this.hasDisplayedMap) {
            MapView mapView3 = this.currentMapView;
            if ((mapView3 != null ? mapView3.getParent() : null) == this.slot) {
                return;
            }
        }
        this.pendingKey = str2;
        G(cardId, points, str2, width2, height2);
    }

    public final void s0(boolean showLoading) {
        A();
        MapView mapView = this.currentMapView;
        if (mapView != null) {
            if (mapView.getParent() != this.slot) {
                mapView = null;
            }
            if (mapView != null) {
                com.stepos.ailauncher.amap.route.K.INSTANCE.Q(mapView);
            }
        }
        this.imageView.setImageResource(R$drawable.ic_map_placeholder);
        this.imageView.setVisibility(0);
        this.imageView.setAlpha(1.0f);
        this.loadingIndicator.setVisibility(showLoading ? 0 : 8);
    }

    public final LatLngBounds t(List<GeoPoint> points) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        if (points.size() == 1) {
            GeoPoint geoPoint = points.get(0);
            builder.include(new LatLng(geoPoint.getLat() - 0.0015d, geoPoint.getLng() - 0.0015d));
            builder.include(new LatLng(geoPoint.getLat() + 0.0015d, geoPoint.getLng() + 0.0015d));
        } else {
            for (GeoPoint geoPoint2 : points) {
                builder.include(new LatLng(geoPoint2.getLat(), geoPoint2.getLng()));
            }
        }
        LatLngBounds latLngBoundsBuild = builder.build();
        com.stepos.ailauncher.amap.route.U u10 = com.stepos.ailauncher.amap.route.U.INSTANCE;
        kotlin.jvm.internal.p.f(latLngBoundsBuild);
        Pair<Double, Double> pairR = u10.r(latLngBoundsBuild);
        double dDoubleValue = pairR.a().doubleValue();
        double dDoubleValue2 = pairR.b().doubleValue();
        if (dDoubleValue > 0.001d || dDoubleValue2 > 0.001d) {
            return latLngBoundsBuild;
        }
        GeoPoint geoPoint3 = (GeoPoint) Z8.F.q0(points);
        LatLngBounds latLngBoundsBuild2 = LatLngBounds.builder().include(new LatLng(geoPoint3.getLat() - 5.0E-5d, geoPoint3.getLng() - 5.0E-5d)).include(new LatLng(geoPoint3.getLat() + 5.0E-5d, geoPoint3.getLng() + 5.0E-5d)).build();
        kotlin.jvm.internal.p.h(latLngBoundsBuild2, "build(...)");
        return latLngBoundsBuild2;
    }

    public final void u() {
        Runnable runnable = this.acquireWatchdog;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.acquireWatchdog = null;
    }

    public final void u0() {
        u();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.s
            @Override // java.lang.Runnable
            public final void run() {
                C3284y.v0(this.f27282a);
            }
        };
        this.acquireWatchdog = runnable;
        this.mainHandler.postDelayed(runnable, 3000L);
    }

    public final void v() {
        Runnable runnable = this.deferredSoftDetachRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.deferredSoftDetachRunnable = null;
    }

    public final void w() {
        Runnable runnable = this.hardReleaseRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.hardReleaseRunnable = null;
    }

    public final boolean w0() {
        MapView mapView = this.currentMapView;
        if (mapView == null || !com.stepos.ailauncher.amap.route.K.INSTANCE.e0(mapView)) {
            return false;
        }
        this.loadingIndicator.setVisibility(8);
        this.imageView.setVisibility(8);
        this.imageView.setAlpha(0.0f);
        j0(mapView, this.pendingKey, "reveal");
        return true;
    }

    public final void x() {
        View.OnLayoutChangeListener onLayoutChangeListener = this.pendingLayoutListener;
        if (onLayoutChangeListener != null) {
            this.slot.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.pendingLayoutListener = null;
    }

    public final void y() {
        Runnable runnable = this.pinBelowRunnable;
        if (runnable == null) {
            return;
        }
        this.pinBelowRunnable = null;
        MapView mapView = this.currentMapView;
        if (mapView != null) {
            mapView.removeCallbacks(runnable);
        }
    }

    public final void z() {
        Runnable runnable = this.stableRevealRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.stableRevealRunnable = null;
    }
}
