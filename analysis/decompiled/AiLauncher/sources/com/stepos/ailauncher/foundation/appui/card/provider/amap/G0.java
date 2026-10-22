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
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.C2414z;
import com.stepos.ailauncher.amap.route.GeoPoint;
import com.stepos.ailauncher.amap.route.TravelMode;
import com.stepos.ailauncher.amap.route.Z;
import com.stepos.ailauncher.foundation.R$dimen;
import com.stepos.ailauncher.foundation.R$drawable;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 {2\u00020\u0001:\u0001|B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\u0014J\u000f\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010\u0014J\u000f\u0010#\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010\u0014J\u001f\u0010'\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010 JU\u00105\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\r2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\n2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J=\u00107\u001a\u00020\u00102\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\r2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b7\u00108JE\u00109\u001a\u00020\u00102\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\r2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0010H\u0002¢\u0006\u0004\b;\u0010\u0014J\u000f\u0010<\u001a\u00020\u0010H\u0002¢\u0006\u0004\b<\u0010\u0014J/\u0010?\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$2\u0006\u00102\u001a\u00020\n2\u0006\u0010>\u001a\u00020=2\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0010H\u0002¢\u0006\u0004\bA\u0010\u0014J\u000f\u0010B\u001a\u000203H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u0002032\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010G\u001a\u00020\u00102\b\b\u0002\u0010F\u001a\u000203H\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0010H\u0002¢\u0006\u0004\bI\u0010\u0014J/\u0010J\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\bJ\u0010\u0012J\u000f\u0010K\u001a\u00020\u0010H\u0002¢\u0006\u0004\bK\u0010\u0014J\u0015\u0010M\u001a\u0004\u0018\u00010,*\u00020LH\u0002¢\u0006\u0004\bM\u0010NJ\u0013\u0010O\u001a\u00020\n*\u00020\u000eH\u0002¢\u0006\u0004\bO\u0010PJ\u0013\u0010Q\u001a\u000203*\u00020\u000eH\u0002¢\u0006\u0004\bQ\u0010RJ\u0013\u0010S\u001a\u000203*\u00020\u000eH\u0002¢\u0006\u0004\bS\u0010RJ\u0013\u0010T\u001a\u000203*\u00020\u000eH\u0002¢\u0006\u0004\bT\u0010RR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010UR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010VR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010]R\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010]R\u0016\u0010l\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010cR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010rR\u0018\u0010t\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010rR\u0018\u0010u\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010rR\u0016\u0010v\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010jR\u0016\u0010w\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010jR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010z¨\u0006}"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/G0;", "", "Landroid/widget/FrameLayout;", "slot", "Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", "loadingIndicator", "<init>", "(Landroid/widget/FrameLayout;Landroid/widget/ImageView;Landroid/view/View;)V", "", "cardId", "modeKey", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;", "waypoints", "LY8/t;", "o", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Q", "()V", "N", "x", "l0", ExifInterface.LATITUDE_SOUTH, "r", "w", "U", "s", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "reason", "O", "(Ljava/lang/String;)V", "a0", "q", "G", "Lcom/amap/api/maps/MapView;", "mv", "from", "R", "(Lcom/amap/api/maps/MapView;Ljava/lang/String;)V", "M", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/stepos/ailauncher/amap/route/x;", "origin", "dest", "vias", "Lcom/stepos/ailauncher/amap/route/TravelMode;", "mode", "key", "", "repaint", "J", "(Lcom/amap/api/maps/MapView;Lcom/amap/api/maps/AMap;Lcom/stepos/ailauncher/amap/route/x;Lcom/stepos/ailauncher/amap/route/x;Ljava/util/List;Lcom/stepos/ailauncher/amap/route/TravelMode;Ljava/lang/String;Z)V", "y", "(Lcom/stepos/ailauncher/amap/route/x;Lcom/stepos/ailauncher/amap/route/x;Ljava/util/List;Lcom/stepos/ailauncher/amap/route/TravelMode;Ljava/lang/String;)V", "H", "(Lcom/amap/api/maps/AMap;Lcom/stepos/ailauncher/amap/route/x;Lcom/stepos/ailauncher/amap/route/x;Ljava/util/List;Lcom/stepos/ailauncher/amap/route/TravelMode;Ljava/lang/String;)V", "t", "B", "", "delayMs", ExifInterface.LONGITUDE_WEST, "(Lcom/amap/api/maps/MapView;Ljava/lang/String;JLjava/lang/String;)V", "v", "e0", "()Z", "D", "(Lcom/amap/api/maps/MapView;)Z", "showLoading", "Y", "(Z)V", "P", "j0", "u", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "c0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;)Lcom/stepos/ailauncher/amap/route/x;", "d0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;)Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;)Z", "C", "F", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "Landroid/view/View;", "currentMapView", "Lcom/amap/api/maps/MapView;", "currentAMap", "Lcom/amap/api/maps/AMap;", "pendingKey", "Ljava/lang/String;", "lastCardId", "lastModeKey", "lastWaypoints", "Ljava/util/List;", "hasDisplayedMap", "Z", "layersIntact", "Landroid/view/View$OnLayoutChangeListener;", "pendingLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "", "paintToken", "I", "activePaintKey", "paintInFlight", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "hardReleaseRunnable", "Ljava/lang/Runnable;", "deferredSoftDetachRunnable", "stableRevealRunnable", "acquireWatchdog", "acquireRetry", "bindGeneration", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry;", "visibilityRetry", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G0 {

    @Deprecated
    public static final long ACQUIRE_TIMEOUT_MS = 3000;

    @Deprecated
    public static final long COLD_REVEAL_DELAY_MS = 180;

    @Deprecated
    public static final String JANK_TAG = "MapScrollJank";

    @Deprecated
    public static final int MAX_ACQUIRE_RETRY = 2;

    @Deprecated
    public static final long REATTACH_GRACE_MS = 2000;

    @Deprecated
    public static final String TAG = "RouteLiveMapBinder";

    @Deprecated
    public static final long WARM_REVEAL_DELAY_MS = 300;
    private int acquireRetry;
    private Runnable acquireWatchdog;
    private String activePaintKey;
    private int bindGeneration;
    private AMap currentAMap;
    private MapView currentMapView;
    private Runnable deferredSoftDetachRunnable;
    private Runnable hardReleaseRunnable;
    private boolean hasDisplayedMap;
    private final ImageView imageView;
    private String lastCardId;
    private String lastModeKey;
    private List<RouteWaypoint> lastWaypoints;
    private boolean layersIntact;
    private final View loadingIndicator;
    private final Handler mainHandler;
    private boolean paintInFlight;
    private int paintToken;
    private String pendingKey;
    private View.OnLayoutChangeListener pendingLayoutListener;
    private final FrameLayout slot;
    private Runnable stableRevealRunnable;
    private final MapSlotVisibilityRetry visibilityRetry;
    private static final a Companion = new a(null);
    private static final Set<String> ORIGIN_TYPES = Z8.Y.j("origin", "start", "from", "起点");
    private static final Set<String> DEST_TYPES = Z8.Y.j("destination", "dest", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "to", "终点");
    private static final Set<String> VIA_TYPES = Z8.Y.j("via", "waypoint", "pass", "途经", "途径");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/G0$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "JANK_TAG", "", "REATTACH_GRACE_MS", "J", "ACQUIRE_TIMEOUT_MS", "COLD_REVEAL_DELAY_MS", "WARM_REVEAL_DELAY_MS", "", "MAX_ACQUIRE_RETRY", "I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public G0(FrameLayout slot, ImageView imageView, View loadingIndicator) {
        kotlin.jvm.internal.p.i(slot, "slot");
        kotlin.jvm.internal.p.i(imageView, "imageView");
        kotlin.jvm.internal.p.i(loadingIndicator, "loadingIndicator");
        this.slot = slot;
        this.imageView = imageView;
        this.loadingIndicator = loadingIndicator;
        this.lastWaypoints = C1173v.m();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.visibilityRetry = new MapSlotVisibilityRetry(slot, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.s0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(G0.f0(this.f27283a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.x0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return G0.g0(this.f27319a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.y0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return G0.h0(this.f27320a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.z0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return G0.i0(this.f27321a);
            }
        });
        imageView.setBackgroundResource(R$drawable.bg_map_slot_top_rounded);
    }

    public static final Y8.t I(G0 g02, String str, int i10, Z.b result) {
        String str2;
        kotlin.jvm.internal.p.i(result, "result");
        g02.paintInFlight = false;
        g02.paintToken = 0;
        if (kotlin.jvm.internal.p.d(g02.activePaintKey, str)) {
            g02.activePaintKey = null;
        }
        if (!kotlin.jvm.internal.p.d(g02.pendingKey, str) || i10 != g02.bindGeneration) {
            return Y8.t.f7040a;
        }
        MapView mapView = g02.currentMapView;
        if ((mapView != null ? mapView.getParent() : null) != g02.slot) {
            C4148a.k(TAG, "paint result stale (not owned) key=" + str, false, 4, null);
            return Y8.t.f7040a;
        }
        if (result instanceof Z.b.C0271b) {
            g02.layersIntact = true;
            MapView mapView2 = g02.currentMapView;
            if (mapView2 != null) {
                str2 = str;
                g02.W(mapView2, str2, 180L, "route-success");
            } else {
                str2 = str;
            }
            C4148a.k(TAG, "route drawn key=" + str2 + " " + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
        } else {
            if (!(result instanceof Z.b.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            C4148a.u(TAG, "route draw fail " + ((Z.b.Failure) result).getReason() + " key=" + str, false, 4, null);
            g02.layersIntact = false;
            if (g02.currentMapView == null) {
                g02.Y(false);
            } else {
                g02.Y(false);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t K(boolean z10, G0 g02, AMap aMap, GeoPoint geoPoint, GeoPoint geoPoint2, List list, TravelMode travelMode, String str, MapView mapView) {
        if (z10) {
            g02.Y(true);
            g02.H(aMap, geoPoint, geoPoint2, list, travelMode, str);
        } else {
            com.stepos.ailauncher.amap.route.K.INSTANCE.d0(mapView);
            g02.W(mapView, str, 300L, "same-slot");
        }
        g02.visibilityRetry.v();
        return Y8.t.f7040a;
    }

    public static final Y8.t L(G0 g02, MapView mapView, String str, boolean z10, GeoPoint geoPoint, GeoPoint geoPoint2, List list, TravelMode travelMode, AMap ready) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(ready, "ready");
        if (g02.currentMapView != mapView) {
            g02.R(mapView, "reattach");
            return Y8.t.f7040a;
        }
        g02.currentAMap = ready;
        g02.G();
        if (!kotlin.jvm.internal.p.d(g02.pendingKey, str)) {
            g02.M("reattach");
            return Y8.t.f7040a;
        }
        int dimensionPixelSize = g02.slot.getResources().getDimensionPixelSize(R$dimen.card_map_logo_inset);
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        k10.T(mapView, dimensionPixelSize);
        k10.a0(mapView);
        if (z10) {
            g02.H(ready, geoPoint, geoPoint2, list, travelMode, str);
        } else {
            g02.W(mapView, str, 300L, "reattach");
        }
        g02.visibilityRetry.v();
        C4148a.k(TAG, "reattach ok repaint=" + z10 + " layersIntact=" + g02.layersIntact + " key=" + str, false, 4, null);
        return Y8.t.f7040a;
    }

    public static final void T(G0 g02) {
        g02.w();
    }

    public static final void V(G0 g02) {
        g02.A();
    }

    public static final void X(G0 g02, int i10, String str, MapView mapView, String str2) {
        g02.stableRevealRunnable = null;
        if (i10 == g02.bindGeneration && kotlin.jvm.internal.p.d(g02.pendingKey, str) && g02.currentMapView == mapView) {
            ViewParent parent = mapView.getParent();
            FrameLayout frameLayout = g02.slot;
            if (parent == frameLayout && frameLayout.isAttachedToWindow() && g02.layersIntact && !g02.paintInFlight) {
                if (g02.e0()) {
                    g02.hasDisplayedMap = true;
                    C4148a.k(TAG, "stable reveal from=" + str2 + " key=" + str, false, 4, null);
                    return;
                }
                g02.hasDisplayedMap = false;
                g02.visibilityRetry.v();
                C4148a.u(TAG, "stable reveal rejected from=" + str2 + " key=" + str, false, 4, null);
                return;
            }
        }
        C4148a.k(TAG, "stable reveal stale from=" + str2 + " key=" + str, false, 4, null);
    }

    public static /* synthetic */ void Z(G0 g02, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        g02.Y(z10);
    }

    public static final void b0(G0 g02) {
        String str;
        g02.acquireWatchdog = null;
        if (g02.currentAMap == null && (str = g02.lastCardId) != null) {
            int i10 = g02.acquireRetry;
            if (i10 >= 2) {
                C4148a.u(TAG, "acquire watchdog give up retry=" + i10 + " cardId=" + str, false, 4, null);
                Z(g02, false, 1, null);
                return;
            }
            int i11 = i10 + 1;
            g02.acquireRetry = i11;
            C4148a.u(TAG, "acquire watchdog fired retry=" + i11 + " cardId=" + str, false, 4, null);
            g02.O("watchdog");
            g02.pendingKey = null;
            Z(g02, false, 1, null);
            g02.o(str, g02.lastModeKey, g02.lastWaypoints);
        }
    }

    public static final boolean f0(G0 g02) {
        return !g02.hasDisplayedMap;
    }

    public static final Y8.t g0(G0 g02) {
        String str = g02.lastCardId;
        if (str == null) {
            return Y8.t.f7040a;
        }
        g02.o(str, g02.lastModeKey, g02.lastWaypoints);
        return Y8.t.f7040a;
    }

    public static final Y8.t h0(G0 g02) {
        g02.r();
        g02.s();
        MapView mapView = g02.currentMapView;
        if (mapView != null && mapView.getParent() == g02.slot) {
            if (g02.D(mapView) || g02.currentAMap == null || g02.paintInFlight) {
                com.stepos.ailauncher.amap.route.K.INSTANCE.d0(mapView);
            } else {
                if (mapView.getVisibility() != 0 || g02.imageView.getVisibility() != 8) {
                    g02.Y(true);
                }
                com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
                k10.d0(mapView);
                k10.a0(mapView);
                String str = g02.pendingKey;
                if (str != null && g02.layersIntact && !g02.paintInFlight) {
                    g02.W(mapView, str, 300L, "visible");
                }
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t i0(G0 g02) {
        g02.l0();
        return Y8.t.f7040a;
    }

    public static final void k0(G0 g02, String str, String str2, List list, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (g02.slot.getWidth() <= 0 || g02.slot.getHeight() <= 0) {
            return;
        }
        g02.u();
        g02.o(str, str2, list);
    }

    public static final CharSequence p(GeoPoint it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getLat() + Const.STR_MART_COMMA + it.getLng();
    }

    public static final Y8.t z(G0 g02, MapView mapView, String str, GeoPoint geoPoint, GeoPoint geoPoint2, List list, TravelMode travelMode, AMap aMap) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(aMap, "aMap");
        if (g02.currentMapView != mapView) {
            g02.R(mapView, "acquire");
            return Y8.t.f7040a;
        }
        g02.currentAMap = aMap;
        g02.G();
        if (!kotlin.jvm.internal.p.d(g02.pendingKey, str)) {
            g02.M("acquire");
            return Y8.t.f7040a;
        }
        int dimensionPixelSize = g02.slot.getResources().getDimensionPixelSize(R$dimen.card_map_logo_inset);
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        k10.T(mapView, dimensionPixelSize);
        k10.a0(mapView);
        g02.H(aMap, geoPoint, geoPoint2, list, travelMode, str);
        g02.visibilityRetry.v();
        return Y8.t.f7040a;
    }

    public final void A() {
        this.hardReleaseRunnable = null;
        q();
        t();
        v();
        B();
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
        P();
    }

    public final void B() {
        this.bindGeneration++;
    }

    public final boolean C(RouteWaypoint routeWaypoint) {
        return DEST_TYPES.contains(d0(routeWaypoint));
    }

    public final boolean D(MapView mv) {
        return this.hasDisplayedMap && this.layersIntact && !this.paintInFlight && this.pendingKey != null && mv.getParent() == this.slot && mv.getVisibility() == 0 && this.imageView.getVisibility() == 8;
    }

    public final boolean E(RouteWaypoint routeWaypoint) {
        return ORIGIN_TYPES.contains(d0(routeWaypoint));
    }

    public final boolean F(RouteWaypoint routeWaypoint) {
        return VIA_TYPES.contains(d0(routeWaypoint));
    }

    public final void G() {
        q();
        this.acquireRetry = 0;
    }

    public final void H(AMap aMap, GeoPoint origin, GeoPoint dest, List<GeoPoint> vias, TravelMode mode, final String key) {
        if (this.paintInFlight && kotlin.jvm.internal.p.d(this.activePaintKey, key)) {
            C4148a.k(TAG, "paintRoute coalesce key=" + key, false, 4, null);
            return;
        }
        t();
        v();
        this.layersIntact = false;
        this.paintInFlight = true;
        this.activePaintKey = key;
        final int i10 = this.bindGeneration;
        MapView mapView = this.currentMapView;
        com.stepos.ailauncher.amap.route.Z z10 = com.stepos.ailauncher.amap.route.Z.INSTANCE;
        Context context = this.slot.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        this.paintToken = z10.C(context, aMap, new Z.Request(origin, dest, vias, mode, this.slot.getWidth(), this.slot.getHeight(), mapView), new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.w0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return G0.I(this.f27315a, key, i10, (Z.b) obj);
            }
        });
    }

    public final void J(final MapView mv, final AMap aMap, final GeoPoint origin, final GeoPoint dest, final List<GeoPoint> vias, final TravelMode mode, final String key, final boolean repaint) {
        InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.B0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return G0.K(repaint, this, aMap, origin, dest, vias, mode, key, mv);
            }
        };
        if (mv.getParent() == this.slot) {
            interfaceC5063a.invoke();
        } else {
            Y(true);
            com.stepos.ailauncher.amap.route.K.INSTANCE.p(mv, this.slot, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.C0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return G0.L(this.f27194a, mv, key, repaint, origin, dest, vias, mode, (AMap) obj);
                }
            });
        }
    }

    public final void M(String from) {
        String str = this.lastCardId;
        if (str == null) {
            return;
        }
        C4148a.k(TAG, "ready but key changed from=" + from + ", rebind latest", false, 4, null);
        o(str, this.lastModeKey, this.lastWaypoints);
    }

    public final void N() {
        u();
        q();
        v();
        t();
        this.visibilityRetry.w();
        MapView mapView = this.currentMapView;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str = this.lastCardId;
        boolean z10 = mapView != null;
        boolean z11 = this.hasDisplayedMap;
        boolean z12 = (mapView != null ? mapView.getParent() : null) == this.slot;
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " ROUTE_RELEASE cardId=" + str + " hasMap=" + z10 + " displayed=" + z11 + " parentSlot=" + z12 + " pool=" + k10.I(), false, 4, null);
        if (mapView == null) {
            P();
            return;
        }
        if (mapView.getParent() == this.slot) {
            k10.Z(mapView);
            S();
        } else {
            this.hasDisplayedMap = false;
            Z(this, false, 1, null);
            U();
        }
    }

    public final void O(String reason) {
        MapView mapView = this.currentMapView;
        if (mapView == null) {
            return;
        }
        q();
        t();
        v();
        B();
        com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
        this.currentMapView = null;
        this.currentAMap = null;
        this.hasDisplayedMap = false;
        this.layersIntact = false;
        if (mapView.getParent() == this.slot) {
            com.stepos.ailauncher.amap.route.K.INSTANCE.c0(mapView);
        } else {
            com.stepos.ailauncher.amap.route.K.INSTANCE.k0(mapView);
        }
        C4148a.k(TAG, "releaseHeldMap reason=" + reason + " " + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
    }

    public final void P() {
        Y(false);
    }

    public final void Q() {
        Object next;
        RouteWaypoint routeWaypointPrevious;
        List<GeoPoint> listM;
        LatLng location;
        LatLng location2;
        s();
        r();
        if (this.lastCardId == null || this.lastWaypoints.isEmpty()) {
            return;
        }
        MapView mapView = this.currentMapView;
        AMap aMap = this.currentAMap;
        if (mapView != null && aMap != null && this.pendingKey != null) {
            Iterator<T> it = this.lastWaypoints.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (E((RouteWaypoint) next)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            RouteWaypoint routeWaypoint = (RouteWaypoint) next;
            GeoPoint geoPointC0 = (routeWaypoint == null || (location2 = routeWaypoint.getLocation()) == null) ? null : c0(location2);
            List<RouteWaypoint> list = this.lastWaypoints;
            ListIterator<RouteWaypoint> listIterator = list.listIterator(list.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    routeWaypointPrevious = listIterator.previous();
                    if (C(routeWaypointPrevious)) {
                        break;
                    }
                } else {
                    routeWaypointPrevious = null;
                    break;
                }
            }
            RouteWaypoint routeWaypoint2 = routeWaypointPrevious;
            GeoPoint geoPointC02 = (routeWaypoint2 == null || (location = routeWaypoint2.getLocation()) == null) ? null : c0(location);
            if (geoPointC0 != null && geoPointC02 != null) {
                if (com.stepos.ailauncher.amap.route.K.INSTANCE.l0(mapView) || mapView.getParent() == this.slot) {
                    TravelMode travelModeA = TravelMode.INSTANCE.a(this.lastModeKey);
                    if (travelModeA == TravelMode.WALKING || travelModeA == TravelMode.RIDING) {
                        listM = C1173v.m();
                    } else {
                        List<RouteWaypoint> list2 = this.lastWaypoints;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list2) {
                            if (F((RouteWaypoint) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        listM = new ArrayList<>();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            LatLng location3 = ((RouteWaypoint) it2.next()).getLocation();
                            GeoPoint geoPointC03 = location3 != null ? c0(location3) : null;
                            if (geoPointC03 != null) {
                                listM.add(geoPointC03);
                            }
                        }
                    }
                    String str = this.pendingKey;
                    kotlin.jvm.internal.p.f(str);
                    if (mapView.getParent() != this.slot && this.paintInFlight) {
                        C4148a.k(TAG, "retry reclaimed off-slot, cancel dead paint key=" + this.activePaintKey, false, 4, null);
                        t();
                        v();
                    }
                    if (D(mapView)) {
                        com.stepos.ailauncher.amap.route.K.INSTANCE.d0(mapView);
                        this.visibilityRetry.v();
                        return;
                    }
                    if (this.paintInFlight && kotlin.jvm.internal.p.d(this.activePaintKey, str) && mapView.getParent() == this.slot) {
                        Y(true);
                        this.visibilityRetry.v();
                        C4148a.k(TAG, "retry coalesce paint in-flight key=" + str, false, 4, null);
                        return;
                    }
                    boolean z10 = this.layersIntact;
                    if (!z10 || this.stableRevealRunnable == null) {
                        J(mapView, aMap, geoPointC0, geoPointC02, listM, travelModeA, str, !z10);
                        return;
                    }
                    this.visibilityRetry.v();
                    C4148a.k(TAG, "retry coalesce stable reveal key=" + str, false, 4, null);
                    return;
                }
                this.currentMapView = null;
                this.currentAMap = null;
                this.hasDisplayedMap = false;
                this.layersIntact = false;
            }
        }
        if (this.currentMapView != null && this.currentAMap == null) {
            a0();
        }
        this.visibilityRetry.v();
        this.visibilityRetry.x();
    }

    public final void R(MapView mv, String from) {
        C4148a.u(TAG, "attach callback stray from=" + from + ", return to pool", false, 4, null);
        if (mv.getParent() == this.slot) {
            com.stepos.ailauncher.amap.route.K.INSTANCE.c0(mv);
        }
    }

    public final void S() {
        r();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.u0
            @Override // java.lang.Runnable
            public final void run() {
                G0.T(this.f27299a);
            }
        };
        this.deferredSoftDetachRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 2000L);
        C4148a.k(TAG, "yield pause, soft detach in 2000ms", false, 4, null);
    }

    public final void U() {
        s();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.D0
            @Override // java.lang.Runnable
            public final void run() {
                G0.V(this.f27202a);
            }
        };
        this.hardReleaseRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 2000L);
        C4148a.k(TAG, "soft release, hard in 2000ms", false, 4, null);
    }

    public final void W(final MapView mv, final String key, long delayMs, final String from) {
        if (this.stableRevealRunnable == null) {
            Y(true);
            final int i10 = this.bindGeneration;
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.v0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.X(this.f27303a, i10, key, mv, from);
                }
            };
            this.stableRevealRunnable = runnable;
            this.mainHandler.postDelayed(runnable, delayMs);
            return;
        }
        C4148a.k(TAG, "stable reveal already pending from=" + from + " key=" + key, false, 4, null);
    }

    public final void Y(boolean showLoading) {
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

    public final void a0() {
        q();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.F0
            @Override // java.lang.Runnable
            public final void run() {
                G0.b0(this.f27208a);
            }
        };
        this.acquireWatchdog = runnable;
        this.mainHandler.postDelayed(runnable, 3000L);
    }

    public final GeoPoint c0(LatLng latLng) {
        Double lat = latLng.getLat();
        if (lat == null) {
            return null;
        }
        double dDoubleValue = lat.doubleValue();
        Double lng = latLng.getLng();
        if (lng != null) {
            return new GeoPoint(dDoubleValue, lng.doubleValue());
        }
        return null;
    }

    public final String d0(RouteWaypoint routeWaypoint) {
        String string;
        String type = routeWaypoint.getType();
        if (type == null || (string = La.H.D1(type).toString()) == null) {
            return "";
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase == null ? "" : lowerCase;
    }

    public final boolean e0() {
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        MapView mapView = this.currentMapView;
        if (mapView == null || !k10.e0(mapView)) {
            return false;
        }
        this.loadingIndicator.setVisibility(8);
        this.imageView.setVisibility(8);
        this.imageView.setAlpha(0.0f);
        return true;
    }

    public final void j0(final String cardId, final String modeKey, final List<RouteWaypoint> waypoints) {
        u();
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.E0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                G0.k0(this.f27203a, cardId, modeKey, waypoints, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.pendingLayoutListener = onLayoutChangeListener;
        this.slot.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public final void l0() {
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
            Z(this, false, 1, null);
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str = this.lastCardId;
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " ROUTE_YIELD_PAUSE cardId=" + str + " pool=" + k10.I(), false, 4, null);
        Y(true);
        k10.Z(mapView);
        S();
    }

    public final void o(String cardId, String modeKey, List<RouteWaypoint> waypoints) {
        Object next;
        RouteWaypoint routeWaypointPrevious;
        List<GeoPoint> listM;
        int i10;
        LatLng location;
        LatLng location2;
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(waypoints, "waypoints");
        s();
        r();
        u();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int size = waypoints.size();
        boolean z10 = this.currentMapView != null;
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " ROUTE_BIND cardId=" + cardId + " mode=" + modeKey + " wps=" + size + " hasMap=" + z10 + " displayed=" + this.hasDisplayedMap + " slot=" + this.slot.getWidth() + "x" + this.slot.getHeight() + " pool=" + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
        List<RouteWaypoint> list = waypoints;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (E((RouteWaypoint) next)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        RouteWaypoint routeWaypoint = (RouteWaypoint) next;
        GeoPoint geoPointC0 = (routeWaypoint == null || (location2 = routeWaypoint.getLocation()) == null) ? null : c0(location2);
        ListIterator<RouteWaypoint> listIterator = waypoints.listIterator(waypoints.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                routeWaypointPrevious = listIterator.previous();
                if (C(routeWaypointPrevious)) {
                    break;
                }
            } else {
                routeWaypointPrevious = null;
                break;
            }
        }
        RouteWaypoint routeWaypoint2 = routeWaypointPrevious;
        GeoPoint geoPointC02 = (routeWaypoint2 == null || (location = routeWaypoint2.getLocation()) == null) ? null : c0(location);
        if (geoPointC0 == null || geoPointC02 == null) {
            if (kotlin.jvm.internal.p.d(this.lastCardId, cardId) && this.currentMapView != null) {
                C4148a.k(TAG, "bind skip missing endpoints, keep map cardId=" + cardId, false, 4, null);
                return;
            }
            this.pendingKey = null;
            t();
            Z(this, false, 1, null);
            return;
        }
        TravelMode travelModeA = TravelMode.INSTANCE.a(modeKey);
        if (travelModeA == TravelMode.WALKING || travelModeA == TravelMode.RIDING) {
            listM = C1173v.m();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (F((RouteWaypoint) obj)) {
                    arrayList.add(obj);
                }
            }
            listM = new ArrayList<>();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                LatLng location3 = ((RouteWaypoint) it2.next()).getLocation();
                GeoPoint geoPointC03 = location3 != null ? c0(location3) : null;
                if (geoPointC03 != null) {
                    listM.add(geoPointC03);
                }
            }
        }
        int width = this.slot.getWidth();
        int height = this.slot.getHeight();
        if (width <= 0 || height <= 0) {
            j0(cardId, modeKey, waypoints);
            if (this.currentMapView == null) {
                Z(this, false, 1, null);
                return;
            }
            return;
        }
        List<GeoPoint> list2 = listM;
        GeoPoint geoPoint = geoPointC0;
        GeoPoint geoPoint2 = geoPointC02;
        String str = cardId + "|" + travelModeA.name() + "|" + geoPointC0.getLat() + Const.STR_MART_COMMA + geoPointC0.getLng() + "|" + geoPointC02.getLat() + Const.STR_MART_COMMA + geoPointC02.getLng() + "|" + Z8.F.A0(list2, Const.STR_MART_SEMICOLON, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.A0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return G0.p((GeoPoint) obj2);
            }
        }, 30, null);
        String str2 = this.lastCardId;
        boolean z11 = (str2 == null || kotlin.jvm.internal.p.d(str2, cardId)) ? false : true;
        String str3 = this.pendingKey;
        boolean z12 = (str3 == null || kotlin.jvm.internal.p.d(str3, str)) ? false : true;
        if (z11 || z12) {
            t();
            v();
            B();
            com.stepos.ailauncher.amap.route.U.INSTANCE.p(this.currentMapView);
            i10 = 0;
            this.hasDisplayedMap = false;
            this.layersIntact = false;
            this.pendingKey = null;
        } else {
            i10 = 0;
        }
        if (z11) {
            this.acquireRetry = i10;
        }
        this.lastCardId = cardId;
        this.lastModeKey = modeKey;
        this.lastWaypoints = waypoints;
        MapView mapView = this.currentMapView;
        boolean z13 = mapView != null && D(mapView);
        if (!C2414z.INSTANCE.d(this.slot) && !z13) {
            Y(false);
            this.visibilityRetry.v();
            C4148a.k(TAG, "bind defer offscreen key=" + str, false, 4, null);
            return;
        }
        MapView mapView2 = this.currentMapView;
        AMap aMap = this.currentAMap;
        if (mapView2 != null && aMap != null) {
            if (com.stepos.ailauncher.amap.route.K.INSTANCE.l0(mapView2) || mapView2.getParent() == this.slot) {
                if (mapView2.getParent() != this.slot && this.paintInFlight) {
                    C4148a.k(TAG, "reclaimed off-slot, cancel dead paint key=" + this.activePaintKey, false, 4, null);
                    t();
                    v();
                }
                if (kotlin.jvm.internal.p.d(str, this.pendingKey) && D(mapView2)) {
                    this.visibilityRetry.v();
                    return;
                }
                if (kotlin.jvm.internal.p.d(str, this.pendingKey) && this.paintInFlight && kotlin.jvm.internal.p.d(this.activePaintKey, str) && mapView2.getParent() == this.slot) {
                    Y(true);
                    this.visibilityRetry.v();
                    C4148a.k(TAG, "bind coalesce paint in-flight key=" + str, false, 4, null);
                    return;
                }
                if (kotlin.jvm.internal.p.d(str, this.pendingKey) && this.layersIntact && this.stableRevealRunnable != null) {
                    this.visibilityRetry.v();
                    C4148a.k(TAG, "bind coalesce stable reveal key=" + str, false, 4, null);
                    return;
                }
                if (kotlin.jvm.internal.p.d(str, this.pendingKey) && this.layersIntact) {
                    J(mapView2, aMap, geoPoint, geoPoint2, list2, travelModeA, str, false);
                    return;
                } else {
                    this.pendingKey = str;
                    J(mapView2, aMap, geoPoint, geoPoint2, list2, travelModeA, str, true);
                    return;
                }
            }
            C4148a.k(TAG, "soft map stolen, re-acquire cardId=" + cardId, false, 4, null);
            this.currentMapView = null;
            this.currentAMap = null;
            this.hasDisplayedMap = false;
            this.layersIntact = false;
        }
        if (this.currentMapView != null && this.currentAMap == null) {
            this.pendingKey = str;
            C4148a.k(TAG, "acquire in flight, update target only key=" + str, false, 4, null);
            return;
        }
        if (kotlin.jvm.internal.p.d(str, this.pendingKey) && this.hasDisplayedMap) {
            MapView mapView3 = this.currentMapView;
            if ((mapView3 != null ? mapView3.getParent() : null) == this.slot) {
                return;
            }
        }
        this.pendingKey = str;
        y(geoPoint, geoPoint2, list2, travelModeA, str);
    }

    public final void q() {
        Runnable runnable = this.acquireWatchdog;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.acquireWatchdog = null;
    }

    public final void r() {
        Runnable runnable = this.deferredSoftDetachRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.deferredSoftDetachRunnable = null;
    }

    public final void s() {
        Runnable runnable = this.hardReleaseRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.hardReleaseRunnable = null;
    }

    public final void t() {
        int i10 = this.paintToken;
        if (i10 != 0) {
            com.stepos.ailauncher.amap.route.Z.INSTANCE.l(i10);
            this.paintToken = 0;
            this.activePaintKey = null;
            if (this.paintInFlight) {
                this.paintInFlight = false;
                this.layersIntact = false;
            }
        }
    }

    public final void u() {
        View.OnLayoutChangeListener onLayoutChangeListener = this.pendingLayoutListener;
        if (onLayoutChangeListener != null) {
            this.slot.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.pendingLayoutListener = null;
    }

    public final void v() {
        Runnable runnable = this.stableRevealRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.stableRevealRunnable = null;
    }

    public final void w() {
        this.deferredSoftDetachRunnable = null;
        MapView mapView = this.currentMapView;
        if (mapView != null && mapView.getParent() == this.slot) {
            t();
            v();
            B();
            com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String str = this.lastCardId;
            com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
            C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " ROUTE_YIELD_DETACH cardId=" + str + " pool=" + k10.I(), false, 4, null);
            k10.G(mapView);
            this.hasDisplayedMap = false;
            Z(this, false, 1, null);
            U();
        }
    }

    public final void x() {
        u();
        q();
        s();
        r();
        v();
        this.visibilityRetry.w();
        t();
        B();
        MapView mapView = this.currentMapView;
        com.stepos.ailauncher.amap.route.U.INSTANCE.p(mapView);
        this.currentMapView = null;
        this.currentAMap = null;
        this.hasDisplayedMap = false;
        this.layersIntact = false;
        this.pendingKey = null;
        this.lastCardId = null;
        this.lastModeKey = null;
        this.lastWaypoints = C1173v.m();
        if (mapView != null) {
            if (mapView.getParent() == this.slot) {
                com.stepos.ailauncher.amap.route.K.INSTANCE.c0(mapView);
            } else {
                com.stepos.ailauncher.amap.route.K.INSTANCE.k0(mapView);
            }
        }
        C4148a.k("MapScrollJank", "t=" + SystemClock.elapsedRealtime() + " ROUTE_DESTROY pool=" + com.stepos.ailauncher.amap.route.K.INSTANCE.I(), false, 4, null);
        P();
    }

    public final void y(final GeoPoint origin, final GeoPoint dest, final List<GeoPoint> vias, final TravelMode mode, final String key) {
        O("re-acquire");
        com.stepos.ailauncher.amap.route.K k10 = com.stepos.ailauncher.amap.route.K.INSTANCE;
        Context context = this.slot.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final MapView mapViewM = k10.m(context);
        if (mapViewM != null) {
            this.currentMapView = mapViewM;
            a0();
            Y(true);
            k10.p(mapViewM, this.slot, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.t0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return G0.z(this.f27291a, mapViewM, key, origin, dest, vias, mode, (AMap) obj);
                }
            });
            return;
        }
        C4148a.k(TAG, "pool full, placeholder " + k10.I(), false, 4, null);
        Y(false);
        this.visibilityRetry.v();
    }
}
