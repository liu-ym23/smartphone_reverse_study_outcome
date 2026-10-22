package com.stepos.ailauncher.amap.route;

import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.U;
import com.stepos.ailauncher.amap.route.Z;
import g5.C4104a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002wxB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017JS\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010 \u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010!J-\u0010&\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0013JU\u0010+\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b+\u0010,J[\u00100\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b0\u00101J[\u00106\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`42\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b6\u00107JA\u0010;\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u00109\u001a\u0002082\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$H\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b?\u0010@J'\u0010E\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u000eH\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010H\u001a\u00020\u000e2\b\u0010G\u001a\u0004\u0018\u00010AH\u0002¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u000203*\u00020.H\u0002¢\u0006\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020A8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000e0P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010OR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010YR\u0014\u0010[\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010OR\u0014\u0010\\\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\\\u0010OR\u0014\u0010]\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010OR\u0014\u0010^\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010OR\u0014\u0010_\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b_\u0010OR\u0014\u0010`\u001a\u00020W8\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010YR\u0014\u0010a\u001a\u00020W8\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010YR\u0014\u0010b\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010OR\u0014\u0010c\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bc\u0010OR\u0014\u0010d\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010OR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jRT\u0010o\u001aB\u0012\f\u0012\n l*\u0004\u0018\u00010\u000e0\u000e\u0012\f\u0012\n l*\u0004\u0018\u00010m0m l* \u0012\f\u0012\n l*\u0004\u0018\u00010\u000e0\u000e\u0012\f\u0012\n l*\u0004\u0018\u00010m0m\u0018\u00010n0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pRT\u0010r\u001aB\u0012\f\u0012\n l*\u0004\u0018\u00010\u000e0\u000e\u0012\f\u0012\n l*\u0004\u0018\u00010q0q l* \u0012\f\u0012\n l*\u0004\u0018\u00010\u000e0\u000e\u0012\f\u0012\n l*\u0004\u0018\u00010q0q\u0018\u00010n0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010pR \u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020s0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010pR8\u0010v\u001a&\u0012\f\u0012\n l*\u0004\u0018\u00010\u000e0\u000e l*\u0012\u0012\f\u0012\n l*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010P0u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010R¨\u0006y"}, d2 = {"Lcom/stepos/ailauncher/amap/route/Z;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/stepos/ailauncher/amap/route/Z$a;", "request", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/amap/route/Z$b;", "LY8/t;", "onResult", "", "C", "(Landroid/content/Context;Lcom/amap/api/maps/AMap;Lcom/stepos/ailauncher/amap/route/Z$a;Lp9/l;)I", M5.b.CREDENTIAL_TOKEN, "l", "(I)V", "app", "attempt", "D", "(ILandroid/content/Context;Lcom/amap/api/maps/AMap;Lcom/stepos/ailauncher/amap/route/Z$a;Lp9/l;I)V", "code", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ILandroid/content/Context;Lcom/amap/api/maps/AMap;Lcom/stepos/ailauncher/amap/route/Z$a;Lp9/l;II)Z", "z", "w", "(I)Z", "result", "r", "(ILp9/l;Lcom/stepos/ailauncher/amap/route/Z$b;)V", "", "delayMs", "Lkotlin/Function0;", "action", "x", "(IJLp9/a;)V", "m", "Lcom/amap/api/services/route/DrivePath;", "path", "o", "(ILcom/amap/api/maps/AMap;Landroid/content/Context;Lcom/stepos/ailauncher/amap/route/Z$a;ILcom/amap/api/services/route/DrivePath;Lp9/l;)V", "", "Lcom/amap/api/services/core/LatLonPoint;", "points", "q", "(ILcom/amap/api/maps/AMap;Landroid/content/Context;Lcom/stepos/ailauncher/amap/route/Z$a;ILjava/util/List;Lp9/l;)V", "Ljava/util/ArrayList;", "Lcom/amap/api/maps/model/LatLng;", "Lkotlin/collections/ArrayList;", "routePoints", "s", "(ILcom/amap/api/maps/AMap;Landroid/content/Context;Lcom/stepos/ailauncher/amap/route/Z$a;Ljava/util/ArrayList;Lp9/l;)V", "Lcom/amap/api/maps/model/LatLngBounds;", "rawBounds", "onSettled", "u", "(Lcom/amap/api/maps/AMap;Landroid/content/Context;Lcom/stepos/ailauncher/amap/route/Z$a;Lcom/amap/api/maps/model/LatLngBounds;Lp9/a;)V", "p", "(Lcom/amap/api/maps/AMap;Lcom/stepos/ailauncher/amap/route/Z$a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)I", "", "text", "bgColor", "Lcom/amap/api/maps/model/BitmapDescriptor;", "k", "(Landroid/content/Context;Ljava/lang/String;I)Lcom/amap/api/maps/model/BitmapDescriptor;", "status", "n", "(Ljava/lang/String;)I", ExifInterface.LONGITUDE_EAST, "(Lcom/amap/api/services/core/LatLonPoint;)Lcom/amap/api/maps/model/LatLng;", "TAG", "Ljava/lang/String;", "AMAP_SUCCESS", "I", "", "NETWORK_ERROR_CODES", "Ljava/util/Set;", "MAX_NETWORK_RETRY", "", "NETWORK_RETRY_DELAYS_MS", "[J", "", "ROUTE_WIDTH_PX", "F", "BOUNDS_PADDING_DP", "COLOR_UNKNOWN", "COLOR_SMOOTH", "COLOR_SLOW", "COLOR_CONGESTED", "COLOR_SEVERE", "MARKER_DIAMETER_DP", "MARKER_TEXT_SP", "MARKER_COLOR_ORIGIN", "MARKER_COLOR_DEST", "MARKER_COLOR_VIA", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextToken", "Ljava/util/concurrent/atomic/AtomicInteger;", "", "kotlin.jvm.PlatformType", "Lcom/amap/api/services/route/RouteSearch;", "", "activeSearches", "Ljava/util/Map;", "Lcom/amap/api/maps/MapView;", "tokenMapViews", "Ljava/lang/Runnable;", "retryRunnables", "", "activeTokens", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    private static final int AMAP_SUCCESS = 1000;
    private static final float BOUNDS_PADDING_DP = 24.0f;
    private static final int COLOR_CONGESTED = -1032145;
    private static final int COLOR_SEVERE = -6414569;
    private static final int COLOR_SLOW = -20447;
    private static final int COLOR_SMOOTH = -12925591;
    private static final int COLOR_UNKNOWN = -12925591;
    private static final int MARKER_COLOR_DEST = -50384;
    private static final int MARKER_COLOR_ORIGIN = -13318311;
    private static final int MARKER_COLOR_VIA = -7434605;
    private static final float MARKER_DIAMETER_DP = 22.0f;
    private static final float MARKER_TEXT_SP = 11.0f;
    private static final int MAX_NETWORK_RETRY = 3;
    private static final float ROUTE_WIDTH_PX = 20.0f;
    private static final String TAG = "RouteMapPainter";
    public static final Z INSTANCE = new Z();
    private static final Set<Integer> NETWORK_ERROR_CODES = Z8.Y.j(Integer.valueOf(AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION), Integer.valueOf(AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION), Integer.valueOf(AMapException.CODE_AMAP_CLIENT_NETWORK_EXCEPTION));
    private static final long[] NETWORK_RETRY_DELAYS_MS = {600, 1500, 3000};
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final AtomicInteger nextToken = new AtomicInteger(1);
    private static final Map<Integer, RouteSearch> activeSearches = Collections.synchronizedMap(new LinkedHashMap());
    private static final Map<Integer, MapView> tokenMapViews = Collections.synchronizedMap(new LinkedHashMap());
    private static final Map<Integer, Runnable> retryRunnables = new LinkedHashMap();
    private static final Set<Integer> activeTokens = Collections.synchronizedSet(new LinkedHashSet());

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010\u0014R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b%\u0010\u0014R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/amap/route/Z$a;", "", "Lcom/stepos/ailauncher/amap/route/x;", "origin", "destination", "", "vias", "Lcom/stepos/ailauncher/amap/route/TravelMode;", "mode", "", "mapWidthPx", "mapHeightPx", "Lcom/amap/api/maps/MapView;", "mapView", "<init>", "(Lcom/stepos/ailauncher/amap/route/x;Lcom/stepos/ailauncher/amap/route/x;Ljava/util/List;Lcom/stepos/ailauncher/amap/route/TravelMode;IILcom/amap/api/maps/MapView;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/amap/route/x;", "f", "()Lcom/stepos/ailauncher/amap/route/x;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "Lcom/stepos/ailauncher/amap/route/TravelMode;", "e", "()Lcom/stepos/ailauncher/amap/route/TravelMode;", "I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Lcom/amap/api/maps/MapView;", "c", "()Lcom/amap/api/maps/MapView;", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.amap.route.Z$a, reason: from toString */
    public static final /* data */ class Request {
        private final GeoPoint destination;
        private final int mapHeightPx;
        private final MapView mapView;
        private final int mapWidthPx;
        private final TravelMode mode;
        private final GeoPoint origin;
        private final List<GeoPoint> vias;

        public Request(GeoPoint origin, GeoPoint destination, List<GeoPoint> vias, TravelMode mode, int i10, int i11, MapView mapView) {
            kotlin.jvm.internal.p.i(origin, "origin");
            kotlin.jvm.internal.p.i(destination, "destination");
            kotlin.jvm.internal.p.i(vias, "vias");
            kotlin.jvm.internal.p.i(mode, "mode");
            this.origin = origin;
            this.destination = destination;
            this.vias = vias;
            this.mode = mode;
            this.mapWidthPx = i10;
            this.mapHeightPx = i11;
            this.mapView = mapView;
        }

        /* renamed from: a, reason: from getter */
        public final GeoPoint getDestination() {
            return this.destination;
        }

        /* renamed from: b, reason: from getter */
        public final int getMapHeightPx() {
            return this.mapHeightPx;
        }

        /* renamed from: c, reason: from getter */
        public final MapView getMapView() {
            return this.mapView;
        }

        /* renamed from: d, reason: from getter */
        public final int getMapWidthPx() {
            return this.mapWidthPx;
        }

        /* renamed from: e, reason: from getter */
        public final TravelMode getMode() {
            return this.mode;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request) other;
            return kotlin.jvm.internal.p.d(this.origin, request.origin) && kotlin.jvm.internal.p.d(this.destination, request.destination) && kotlin.jvm.internal.p.d(this.vias, request.vias) && this.mode == request.mode && this.mapWidthPx == request.mapWidthPx && this.mapHeightPx == request.mapHeightPx && kotlin.jvm.internal.p.d(this.mapView, request.mapView);
        }

        /* renamed from: f, reason: from getter */
        public final GeoPoint getOrigin() {
            return this.origin;
        }

        public final List<GeoPoint> g() {
            return this.vias;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.origin.hashCode() * 31) + this.destination.hashCode()) * 31) + this.vias.hashCode()) * 31) + this.mode.hashCode()) * 31) + Integer.hashCode(this.mapWidthPx)) * 31) + Integer.hashCode(this.mapHeightPx)) * 31;
            MapView mapView = this.mapView;
            return iHashCode + (mapView == null ? 0 : mapView.hashCode());
        }

        public String toString() {
            return "Request(origin=" + this.origin + ", destination=" + this.destination + ", vias=" + this.vias + ", mode=" + this.mode + ", mapWidthPx=" + this.mapWidthPx + ", mapHeightPx=" + this.mapHeightPx + ", mapView=" + this.mapView + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/amap/route/Z$b;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/amap/route/Z$b$a;", "Lcom/stepos/ailauncher/amap/route/Z$b$b;", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class b {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/amap/route/Z$b$a;", "Lcom/stepos/ailauncher/amap/route/Z$b;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.amap.route.Z$b$a, reason: from toString */
        public static final /* data */ class Failure extends b {
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(String reason) {
                super(null);
                kotlin.jvm.internal.p.i(reason, "reason");
                this.reason = reason;
            }

            /* renamed from: a, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failure) && kotlin.jvm.internal.p.d(this.reason, ((Failure) other).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Failure(reason=" + this.reason + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/amap/route/Z$b$b;", "Lcom/stepos/ailauncher/amap/route/Z$b;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.amap.route.Z$b$b, reason: collision with other inner class name */
        public static final /* data */ class C0271b extends b {
            public static final C0271b INSTANCE = new C0271b();

            public C0271b() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof C0271b);
            }

            public int hashCode() {
                return -711790293;
            }

            public String toString() {
                return "Success";
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TravelMode.values().length];
            try {
                iArr[TravelMode.WALKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TravelMode.RIDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TravelMode.DRIVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/amap/route/Z$d", "Lcom/amap/api/services/route/RouteSearch$OnRouteSearchListener;", "Lcom/amap/api/services/route/DriveRouteResult;", "result", "", "code", "LY8/t;", "onDriveRouteSearched", "(Lcom/amap/api/services/route/DriveRouteResult;I)V", "Lcom/amap/api/services/route/WalkRouteResult;", "onWalkRouteSearched", "(Lcom/amap/api/services/route/WalkRouteResult;I)V", "Lcom/amap/api/services/route/RideRouteResult;", "onRideRouteSearched", "(Lcom/amap/api/services/route/RideRouteResult;I)V", "Lcom/amap/api/services/route/BusRouteResult;", "onBusRouteSearched", "(Lcom/amap/api/services/route/BusRouteResult;I)V", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements RouteSearch.OnRouteSearchListener {
        final /* synthetic */ AMap $aMap;
        final /* synthetic */ Context $app;
        final /* synthetic */ int $attempt;
        final /* synthetic */ InterfaceC5074l<b, Y8.t> $onResult;
        final /* synthetic */ Request $request;
        final /* synthetic */ int $token;

        /* JADX WARN: Multi-variable type inference failed */
        public d(int i10, int i11, Context context, AMap aMap, Request request, InterfaceC5074l<? super b, Y8.t> interfaceC5074l) {
            this.$token = i10;
            this.$attempt = i11;
            this.$app = context;
            this.$aMap = aMap;
            this.$request = request;
            this.$onResult = interfaceC5074l;
        }

        public static final void d(int i10, int i11, int i12, DriveRouteResult driveRouteResult, Context context, AMap aMap, Request request, InterfaceC5074l interfaceC5074l) {
            List<DrivePath> paths;
            List<DrivePath> paths2;
            Z z10 = Z.INSTANCE;
            DrivePath drivePath = null;
            C4148a.k(Z.TAG, "onDriveRouteSearched token=" + i10 + " attempt=" + i11 + " active=" + z10.w(i10) + " code=" + i12 + " paths=" + ((driveRouteResult == null || (paths2 = driveRouteResult.getPaths()) == null) ? -1 : paths2.size()), false, 4, null);
            if (z10.w(i10) && !z10.A(i10, context, aMap, request, interfaceC5074l, i12, i11)) {
                if (driveRouteResult != null && (paths = driveRouteResult.getPaths()) != null) {
                    drivePath = (DrivePath) Z8.F.s0(paths);
                }
                z10.o(i10, aMap, context, request, i12, drivePath, interfaceC5074l);
            }
        }

        public static final void e(int i10, int i11, int i12, RideRouteResult rideRouteResult, Context context, AMap aMap, Request request, InterfaceC5074l interfaceC5074l) {
            List<RidePath> paths;
            RidePath ridePath;
            List<RideStep> steps;
            List<RidePath> paths2;
            Z z10 = Z.INSTANCE;
            ArrayList arrayList = null;
            C4148a.k(Z.TAG, "onRideRouteSearched token=" + i10 + " attempt=" + i11 + " active=" + z10.w(i10) + " code=" + i12 + " paths=" + ((rideRouteResult == null || (paths2 = rideRouteResult.getPaths()) == null) ? -1 : paths2.size()), false, 4, null);
            if (z10.w(i10) && !z10.A(i10, context, aMap, request, interfaceC5074l, i12, i11)) {
                if (rideRouteResult != null && (paths = rideRouteResult.getPaths()) != null && (ridePath = (RidePath) Z8.F.s0(paths)) != null && (steps = ridePath.getSteps()) != null) {
                    arrayList = new ArrayList();
                    Iterator<T> it = steps.iterator();
                    while (it.hasNext()) {
                        List<LatLonPoint> polyline = ((RideStep) it.next()).getPolyline();
                        if (polyline == null) {
                            polyline = C1173v.m();
                        }
                        Z8.A.E(arrayList, polyline);
                    }
                }
                Z.INSTANCE.q(i10, aMap, context, request, i12, arrayList, interfaceC5074l);
            }
        }

        public static final void f(int i10, int i11, int i12, WalkRouteResult walkRouteResult, Context context, AMap aMap, Request request, InterfaceC5074l interfaceC5074l) {
            List<WalkPath> paths;
            WalkPath walkPath;
            List<WalkStep> steps;
            List<WalkPath> paths2;
            Z z10 = Z.INSTANCE;
            ArrayList arrayList = null;
            C4148a.k(Z.TAG, "onWalkRouteSearched token=" + i10 + " attempt=" + i11 + " active=" + z10.w(i10) + " code=" + i12 + " paths=" + ((walkRouteResult == null || (paths2 = walkRouteResult.getPaths()) == null) ? -1 : paths2.size()), false, 4, null);
            if (z10.w(i10) && !z10.A(i10, context, aMap, request, interfaceC5074l, i12, i11)) {
                if (walkRouteResult != null && (paths = walkRouteResult.getPaths()) != null && (walkPath = (WalkPath) Z8.F.s0(paths)) != null && (steps = walkPath.getSteps()) != null) {
                    arrayList = new ArrayList();
                    Iterator<T> it = steps.iterator();
                    while (it.hasNext()) {
                        List<LatLonPoint> polyline = ((WalkStep) it.next()).getPolyline();
                        if (polyline == null) {
                            polyline = C1173v.m();
                        }
                        Z8.A.E(arrayList, polyline);
                    }
                }
                Z.INSTANCE.q(i10, aMap, context, request, i12, arrayList, interfaceC5074l);
            }
        }

        @Override // com.amap.api.services.route.RouteSearch.OnRouteSearchListener
        public void onBusRouteSearched(BusRouteResult result, int code) {
        }

        @Override // com.amap.api.services.route.RouteSearch.OnRouteSearchListener
        public void onDriveRouteSearched(final DriveRouteResult result, final int code) {
            Handler handler = Z.mainHandler;
            final int i10 = this.$token;
            final int i11 = this.$attempt;
            final Context context = this.$app;
            final AMap aMap = this.$aMap;
            final Request request = this.$request;
            final InterfaceC5074l<b, Y8.t> interfaceC5074l = this.$onResult;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.amap.route.a0
                @Override // java.lang.Runnable
                public final void run() {
                    Z.d.d(i10, i11, code, result, context, aMap, request, interfaceC5074l);
                }
            });
        }

        @Override // com.amap.api.services.route.RouteSearch.OnRouteSearchListener
        public void onRideRouteSearched(final RideRouteResult result, final int code) {
            Handler handler = Z.mainHandler;
            final int i10 = this.$token;
            final int i11 = this.$attempt;
            final Context context = this.$app;
            final AMap aMap = this.$aMap;
            final Request request = this.$request;
            final InterfaceC5074l<b, Y8.t> interfaceC5074l = this.$onResult;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.amap.route.b0
                @Override // java.lang.Runnable
                public final void run() {
                    Z.d.e(i10, i11, code, result, context, aMap, request, interfaceC5074l);
                }
            });
        }

        @Override // com.amap.api.services.route.RouteSearch.OnRouteSearchListener
        public void onWalkRouteSearched(final WalkRouteResult result, final int code) {
            Handler handler = Z.mainHandler;
            final int i10 = this.$token;
            final int i11 = this.$attempt;
            final Context context = this.$app;
            final AMap aMap = this.$aMap;
            final Request request = this.$request;
            final InterfaceC5074l<b, Y8.t> interfaceC5074l = this.$onResult;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.amap.route.c0
                @Override // java.lang.Runnable
                public final void run() {
                    Z.d.f(i10, i11, code, result, context, aMap, request, interfaceC5074l);
                }
            });
        }
    }

    public static final Y8.t B(int i10, Context context, AMap aMap, Request request, InterfaceC5074l interfaceC5074l, int i11) {
        INSTANCE.D(i10, context, aMap, request, interfaceC5074l, i11 + 1);
        return Y8.t.f7040a;
    }

    public static final Y8.t t(int i10, InterfaceC5074l interfaceC5074l) {
        INSTANCE.r(i10, interfaceC5074l, b.C0271b.INSTANCE);
        return Y8.t.f7040a;
    }

    public static final void v(AMap aMap) {
        C2410v.INSTANCE.o0(aMap, false);
    }

    public static final void y(InterfaceC5063a interfaceC5063a, int i10, Ref$ObjectRef ref$ObjectRef) {
        Runnable runnable;
        boolean z10;
        Map<Integer, Runnable> map = retryRunnables;
        synchronized (map) {
            try {
                Runnable runnable2 = map.get(Integer.valueOf(i10));
                T t10 = ref$ObjectRef.f34820a;
                if (t10 == 0) {
                    kotlin.jvm.internal.p.A("task");
                    runnable = null;
                } else {
                    runnable = (Runnable) t10;
                }
                if (runnable2 == runnable) {
                    map.remove(Integer.valueOf(i10));
                    z10 = true;
                } else {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            interfaceC5063a.invoke();
        }
    }

    public final boolean A(final int token, final Context app, final AMap aMap, final Request request, final InterfaceC5074l<? super b, Y8.t> onResult, int code, final int attempt) {
        if (!NETWORK_ERROR_CODES.contains(Integer.valueOf(code)) || attempt >= 3) {
            return false;
        }
        long[] jArr = NETWORK_RETRY_DELAYS_MS;
        long jX0 = (attempt < 0 || attempt >= jArr.length) ? Z8.r.x0(jArr) : jArr[attempt];
        C4148a.u(TAG, "route net error code=" + code + ", retry #" + (attempt + 1) + " in " + jX0 + "ms token=" + token, false, 4, null);
        z(token);
        x(token, jX0, new InterfaceC5063a() { // from class: com.stepos.ailauncher.amap.route.Y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Z.B(token, app, aMap, request, onResult, attempt);
            }
        });
        return true;
    }

    public final int C(Context context, AMap aMap, Request request, InterfaceC5074l<? super b, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(aMap, "aMap");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        int andIncrement = nextToken.getAndIncrement();
        C4104a.INSTANCE.a(context);
        activeTokens.add(Integer.valueOf(andIncrement));
        MapView mapView = request.getMapView();
        if (mapView != null) {
            Map<Integer, MapView> tokenMapViews2 = tokenMapViews;
            kotlin.jvm.internal.p.h(tokenMapViews2, "tokenMapViews");
            tokenMapViews2.put(Integer.valueOf(andIncrement), mapView);
        }
        C4148a.k(TAG, "searchAndDraw token=" + andIncrement + " mode=" + request.getMode() + " from=" + request.getOrigin().getLat() + Const.STR_MART_COMMA + request.getOrigin().getLng() + " to=" + request.getDestination().getLat() + Const.STR_MART_COMMA + request.getDestination().getLng(), false, 4, null);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        D(andIncrement, applicationContext, aMap, request, onResult, 0);
        return andIncrement;
    }

    public final void D(int token, Context app, AMap aMap, Request request, InterfaceC5074l<? super b, Y8.t> onResult, int attempt) {
        Object objB;
        if (w(token)) {
            if (attempt > 0) {
                C4104a.INSTANCE.a(app);
            }
            RouteSearch routeSearch = new RouteSearch(app);
            RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(new LatLonPoint(request.getOrigin().getLat(), request.getOrigin().getLng()), new LatLonPoint(request.getDestination().getLat(), request.getDestination().getLng()));
            routeSearch.setRouteSearchListener(new d(token, attempt, app, aMap, request, onResult));
            Map<Integer, RouteSearch> activeSearches2 = activeSearches;
            kotlin.jvm.internal.p.h(activeSearches2, "activeSearches");
            activeSearches2.put(Integer.valueOf(token), routeSearch);
            try {
                Result.Companion companion = Result.INSTANCE;
                int i10 = c.$EnumSwitchMapping$0[request.getMode().ordinal()];
                if (i10 == 1) {
                    routeSearch.calculateWalkRouteAsyn(new RouteSearch.WalkRouteQuery(fromAndTo));
                } else if (i10 == 2) {
                    routeSearch.calculateRideRouteAsyn(new RouteSearch.RideRouteQuery(fromAndTo));
                } else {
                    if (i10 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    routeSearch.calculateDriveRouteAsyn(new RouteSearch.DriveRouteQuery(fromAndTo, 0, null, null, ""));
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "calculateRoute failed", thE, false, 8, null);
                INSTANCE.r(token, onResult, new b.Failure("route_calc_exception"));
            }
        }
    }

    public final LatLng E(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    public final int j(Context context) {
        float f10 = context.getResources().getDisplayMetrics().density;
        return Math.max((int) (24.0f * f10), (int) (f10 * MARKER_TEXT_SP));
    }

    public final BitmapDescriptor k(Context context, String text, int bgColor) {
        float f10 = context.getResources().getDisplayMetrics().density;
        int iF = C5685n.f((int) ((22.0f * f10) + 0.5f), 1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f11 = iF / 2.0f;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Y8.t tVar = Y8.t.f7040a;
        canvas.drawCircle(f11, f11, f11, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(bgColor);
        paint2.setStyle(style);
        canvas.drawCircle(f11, f11, f11 - (1.5f * f10), paint2);
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        paint3.setTextSize(f10 * MARKER_TEXT_SP);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setFakeBoldText(true);
        paint3.getTextBounds(text, 0, text.length(), new Rect());
        canvas.drawText(text, f11, f11 - ((paint3.descent() + paint3.ascent()) / 2.0f), paint3);
        BitmapDescriptor bitmapDescriptorFromBitmap = BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
        kotlin.jvm.internal.p.h(bitmapDescriptorFromBitmap, "fromBitmap(...)");
        return bitmapDescriptorFromBitmap;
    }

    public final void l(int token) {
        activeTokens.remove(Integer.valueOf(token));
        m(token);
        z(token);
        MapView mapViewRemove = tokenMapViews.remove(Integer.valueOf(token));
        if (mapViewRemove != null) {
            U.INSTANCE.p(mapViewRemove);
        }
    }

    public final void m(int token) {
        Runnable runnableRemove;
        Map<Integer, Runnable> map = retryRunnables;
        synchronized (map) {
            runnableRemove = map.remove(Integer.valueOf(token));
        }
        if (runnableRemove != null) {
            mainHandler.removeCallbacks(runnableRemove);
        }
    }

    public final int n(String status) {
        if (status == null) {
            return -12925591;
        }
        switch (status.hashCode()) {
            case 807408:
                if (status.equals("拥堵")) {
                    return COLOR_CONGESTED;
                }
                return -12925591;
            case 967541:
                status.equals("畅通");
                return -12925591;
            case 1043353:
                if (status.equals("缓行")) {
                    return COLOR_SLOW;
                }
                return -12925591;
            case 632645688:
                if (status.equals("严重拥堵")) {
                    return COLOR_SEVERE;
                }
                return -12925591;
            default:
                return -12925591;
        }
    }

    public final void o(int token, AMap aMap, Context context, Request request, int code, DrivePath path, InterfaceC5074l<? super b, Y8.t> onResult) {
        Object objB;
        List listM;
        int i10;
        boolean z10;
        List listM2;
        List listM3;
        List listM4;
        List<DriveStep> steps;
        if (w(token)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                aMap.clear();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "aMap.clear failed before drive commit", thE, false, 8, null);
            }
            C4148a.k(TAG, "drawDrive enter token=" + token + " code=" + code + " pathNull=" + (path == null) + " steps=" + ((path == null || (steps = path.getSteps()) == null) ? -1 : steps.size()), false, 4, null);
            if (code != 1000 || path == null) {
                C4148a.u(TAG, "drive fail code=" + code + " pathNull=" + (path == null) + ", fallback endpoints+odLine", false, 4, null);
                p(aMap, request);
                s(token, aMap, context, request, new ArrayList<>(), onResult);
                return;
            }
            List<DriveStep> steps2 = path.getSteps();
            if (steps2 != null) {
                listM = new ArrayList();
                Iterator<T> it = steps2.iterator();
                while (it.hasNext()) {
                    List<LatLonPoint> polyline = ((DriveStep) it.next()).getPolyline();
                    if (polyline != null) {
                        List<LatLonPoint> list = polyline;
                        listM4 = new ArrayList(C1174w.x(list, 10));
                        for (LatLonPoint latLonPoint : list) {
                            Z z11 = INSTANCE;
                            kotlin.jvm.internal.p.f(latLonPoint);
                            listM4.add(z11.E(latLonPoint));
                        }
                    } else {
                        listM4 = null;
                    }
                    if (listM4 == null) {
                        listM4 = C1173v.m();
                    }
                    Z8.A.E(listM, listM4);
                }
            } else {
                listM = null;
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            if (listM.size() >= 2) {
                aMap.addPolyline(new PolylineOptions().addAll(listM).width(20.0f).color(-12925591));
            }
            ArrayList arrayList = new ArrayList();
            List<DriveStep> steps3 = path.getSteps();
            if (steps3 != null) {
                int i11 = 0;
                boolean z12 = false;
                for (DriveStep driveStep : steps3) {
                    List<TMC> tMCs = driveStep.getTMCs();
                    List<TMC> list2 = tMCs;
                    if (list2 == null || list2.isEmpty()) {
                        List<LatLonPoint> polyline2 = driveStep.getPolyline();
                        if (polyline2 != null) {
                            List<LatLonPoint> list3 = polyline2;
                            listM2 = new ArrayList(C1174w.x(list3, 10));
                            for (LatLonPoint latLonPoint2 : list3) {
                                Z z13 = INSTANCE;
                                kotlin.jvm.internal.p.f(latLonPoint2);
                                listM2.add(z13.E(latLonPoint2));
                            }
                        } else {
                            listM2 = null;
                        }
                        if (listM2 == null) {
                            listM2 = C1173v.m();
                        }
                        if (listM2.size() >= 2) {
                            aMap.addPolyline(new PolylineOptions().addAll(listM2).width(20.0f).color(-12925591));
                            arrayList.addAll(listM2);
                            z12 = true;
                        }
                    } else {
                        for (TMC tmc : tMCs) {
                            List<LatLonPoint> polyline3 = tmc.getPolyline();
                            if (polyline3 != null) {
                                List<LatLonPoint> list4 = polyline3;
                                listM3 = new ArrayList(C1174w.x(list4, 10));
                                for (LatLonPoint latLonPoint3 : list4) {
                                    Z z14 = INSTANCE;
                                    kotlin.jvm.internal.p.f(latLonPoint3);
                                    listM3.add(z14.E(latLonPoint3));
                                }
                            } else {
                                listM3 = null;
                            }
                            if (listM3 == null) {
                                listM3 = C1173v.m();
                            }
                            if (listM3.size() >= 2) {
                                aMap.addPolyline(new PolylineOptions().addAll(listM3).width(20.0f).color(INSTANCE.n(tmc.getStatus())));
                                arrayList.addAll(listM3);
                                i11++;
                                z12 = true;
                            }
                        }
                    }
                }
                i10 = i11;
                z10 = z12;
            } else {
                i10 = 0;
                z10 = false;
            }
            List list5 = listM.size() >= 2 ? listM : arrayList;
            List<DriveStep> steps4 = path.getSteps();
            int size = steps4 != null ? steps4.size() : 0;
            C4148a.k(TAG, "drawDrive steps=" + size + " mainPoints=" + listM.size() + " tmcSegments=" + i10 + " tmcPoints=" + arrayList.size() + " drewAny=" + z10, false, 4, null);
            if (list5.size() >= 2 || z10) {
                s(token, aMap, context, request, new ArrayList<>(list5), onResult);
                return;
            }
            C4148a.u(TAG, "drive empty polyline, fallback endpoints+odLine", false, 4, null);
            p(aMap, request);
            s(token, aMap, context, request, new ArrayList<>(), onResult);
        }
    }

    public final void p(AMap aMap, Request request) {
        Object objB;
        LatLng latLng = new LatLng(request.getOrigin().getLat(), request.getOrigin().getLng());
        LatLng latLng2 = new LatLng(request.getDestination().getLat(), request.getDestination().getLng());
        try {
            Result.Companion companion = Result.INSTANCE;
            aMap.addPolyline(new PolylineOptions().add(latLng, latLng2).width(20.0f).color(-12925591));
            objB = Result.b(Integer.valueOf(C4148a.k(TAG, "drawOdFallbackLine ok", false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "drawOdFallbackLine failed", thE, false, 8, null);
        }
    }

    public final void q(int token, AMap aMap, Context context, Request request, int code, List<? extends LatLonPoint> points, InterfaceC5074l<? super b, Y8.t> onResult) {
        Object objB;
        List<? extends LatLonPoint> list;
        if (w(token)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                aMap.clear();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "aMap.clear failed before walk/ride commit", thE, false, 8, null);
            }
            C4148a.k(TAG, "drawSingleColor enter token=" + token + " mode=" + request.getMode() + " code=" + code + " size=" + (points != null ? points.size() : -1), false, 4, null);
            if (code != 1000 || (list = points) == null || list.isEmpty()) {
                C4148a.u(TAG, "walk/ride fail code=" + code + " size=" + (points != null ? points.size() : -1) + ", fallback endpoints+odLine", false, 4, null);
                p(aMap, request);
                s(token, aMap, context, request, new ArrayList<>(), onResult);
                return;
            }
            List<? extends LatLonPoint> list2 = points;
            ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.E((LatLonPoint) it.next()));
            }
            if (arrayList.size() < 2) {
                C4148a.u(TAG, "walk/ride too few points, fallback endpoints", false, 4, null);
                s(token, aMap, context, request, new ArrayList<>(), onResult);
            } else {
                aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(20.0f).color(-12925591));
                s(token, aMap, context, request, new ArrayList<>(arrayList), onResult);
            }
        }
    }

    public final void r(int token, InterfaceC5074l<? super b, Y8.t> onResult, b result) {
        if (activeTokens.remove(Integer.valueOf(token))) {
            m(token);
            z(token);
            tokenMapViews.remove(Integer.valueOf(token));
            onResult.invoke(result);
        }
    }

    public final void s(final int token, AMap aMap, Context context, Request request, ArrayList<LatLng> routePoints, final InterfaceC5074l<? super b, Y8.t> onResult) {
        if (w(token)) {
            LatLng latLng = new LatLng(request.getOrigin().getLat(), request.getOrigin().getLng());
            LatLng latLng2 = new LatLng(request.getDestination().getLat(), request.getDestination().getLng());
            aMap.addMarker(new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).icon(k(context, "起", MARKER_COLOR_ORIGIN)));
            aMap.addMarker(new MarkerOptions().position(latLng2).anchor(0.5f, 0.5f).icon(k(context, "终", MARKER_COLOR_DEST)));
            int i10 = 0;
            for (Object obj : request.g()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                GeoPoint geoPoint = (GeoPoint) obj;
                aMap.addMarker(new MarkerOptions().position(new LatLng(geoPoint.getLat(), geoPoint.getLng())).anchor(0.5f, 0.5f).icon(INSTANCE.k(context, String.valueOf(i11), MARKER_COLOR_VIA)));
                i10 = i11;
            }
            LatLngBounds.Builder builderInclude = new LatLngBounds.Builder().include(latLng).include(latLng2);
            Iterator<T> it = routePoints.iterator();
            while (it.hasNext()) {
                builderInclude.include((LatLng) it.next());
            }
            for (GeoPoint geoPoint2 : request.g()) {
                builderInclude.include(new LatLng(geoPoint2.getLat(), geoPoint2.getLng()));
            }
            LatLngBounds latLngBoundsBuild = builderInclude.build();
            kotlin.jvm.internal.p.h(latLngBoundsBuild, "build(...)");
            u(aMap, context, request, latLngBoundsBuild, new InterfaceC5063a() { // from class: com.stepos.ailauncher.amap.route.V
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Z.t(token, onResult);
                }
            });
        }
    }

    public final void u(final AMap aMap, Context context, Request request, LatLngBounds rawBounds, InterfaceC5063a<Y8.t> onSettled) {
        Object objB;
        int mapWidthPx = request.getMapWidthPx();
        int mapHeightPx = request.getMapHeightPx();
        U u10 = U.INSTANCE;
        Pair<Double, Double> pairR = u10.r(rawBounds);
        double dDoubleValue = pairR.a().doubleValue();
        double dDoubleValue2 = pairR.b().doubleValue();
        if (mapWidthPx > 0 && mapHeightPx > 0) {
            U.Padding paddingA = U.Padding.INSTANCE.a(j(context));
            C4148a.k(TAG, "fitRouteCamera slot=" + mapWidthPx + "x" + mapHeightPx + " span≈" + ((int) dDoubleValue) + "x" + ((int) dDoubleValue2) + "m " + U.h(u10, aMap, rawBounds, paddingA, u10.G(rawBounds, mapWidthPx, mapHeightPx, paddingA, 25.0d, context.getResources().getDisplayMetrics().density), mapWidthPx, mapHeightPx, request.getMapView(), false, onSettled, null, null, 1664, null), false, 4, null);
            return;
        }
        int i10 = 4;
        String str = " span≈";
        C2410v c2410v = C2410v.INSTANCE;
        C2410v.X(c2410v, aMap, 0.0f, 0.0f, 6, null);
        c2410v.o0(aMap, true);
        int iJ = j(context);
        try {
            Result.Companion companion = Result.INSTANCE;
            aMap.moveCamera(CameraUpdateFactory.newLatLngBounds(rawBounds, iJ));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "fitRouteCamera newLatLngBounds failed", thE, false, 8, null);
        }
        mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.amap.route.X
            @Override // java.lang.Runnable
            public final void run() {
                Z.v(aMap);
            }
        }, 500L);
        C4148a.k(TAG, "fitRouteCamera slot=0x0 pad=" + iJ + str + ((int) dDoubleValue) + "x" + ((int) dDoubleValue2) + "m", false, i10, null);
        if (onSettled != null) {
            onSettled.invoke();
        }
    }

    public final boolean w(int token) {
        return activeTokens.contains(Integer.valueOf(token));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.stepos.ailauncher.amap.route.W] */
    public final void x(final int token, long delayMs, final InterfaceC5063a<Y8.t> action) {
        Runnable runnable;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f34820a = new Runnable() { // from class: com.stepos.ailauncher.amap.route.W
            @Override // java.lang.Runnable
            public final void run() {
                Z.y(action, token, ref$ObjectRef);
            }
        };
        Map<Integer, Runnable> map = retryRunnables;
        synchronized (map) {
            try {
                Runnable runnableRemove = map.remove(Integer.valueOf(token));
                if (runnableRemove != null) {
                    mainHandler.removeCallbacks(runnableRemove);
                }
                Integer numValueOf = Integer.valueOf(token);
                T t10 = ref$ObjectRef.f34820a;
                Runnable runnable2 = null;
                if (t10 == 0) {
                    kotlin.jvm.internal.p.A("task");
                    runnable = null;
                } else {
                    runnable = (Runnable) t10;
                }
                map.put(numValueOf, runnable);
                Handler handler = mainHandler;
                T t11 = ref$ObjectRef.f34820a;
                if (t11 == 0) {
                    kotlin.jvm.internal.p.A("task");
                } else {
                    runnable2 = (Runnable) t11;
                }
                handler.postDelayed(runnable2, delayMs);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(int token) {
        Object objB;
        RouteSearch routeSearchRemove = activeSearches.remove(Integer.valueOf(token));
        if (routeSearchRemove != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                routeSearchRemove.setRouteSearchListener(null);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
    }
}
