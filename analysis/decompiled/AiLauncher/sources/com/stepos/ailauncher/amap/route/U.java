package com.stepos.ailauncher.amap.route;

import Z8.C1173v;
import Z8.C1174w;
import android.graphics.PointF;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.C2410v;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002cdB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017JQ\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001cJ!\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b$\u0010%J\u00ad\u0001\u00104\u001a\u0002032\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010,\u001a\u00020+2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010-2\u0018\b\u0002\u00100\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020#\u0018\u00010/2(\b\u0002\u00102\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020#\u0018\u000101¢\u0006\u0004\b4\u00105JS\u00108\u001a\u00020#2\u0006\u0010'\u001a\u00020&2\u0006\u00106\u001a\u00020\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2(\b\u0002\u00107\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020#\u0018\u000101¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bH\u0002¢\u0006\u0004\b>\u0010<J\u0017\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002¢\u0006\u0004\b@\u0010<J\u0017\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000bH\u0002¢\u0006\u0004\bB\u0010<J\u0017\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000bH\u0002¢\u0006\u0004\bD\u0010<J\u0017\u0010F\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0002¢\u0006\u0004\bF\u0010<J\u001f\u0010H\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bH\u0010IJ\u001f\u0010L\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bL\u0010MJ'\u0010C\u001a\u0004\u0018\u00010J2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\bC\u0010NJ\u0017\u0010O\u001a\u00020J2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bO\u0010PJ/\u0010Q\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020J2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\bQ\u0010RJ\u001f\u0010U\u001a\u00020S2\u0006\u0010\"\u001a\u00020!2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VR&\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0X0W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010\u001dR\u0014\u0010\\\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010]R\u0014\u0010_\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010]R\u0014\u0010`\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010]R\u0014\u0010a\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010]R\u0014\u0010b\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010]¨\u0006e"}, d2 = {"Lcom/stepos/ailauncher/amap/route/U;", "", "<init>", "()V", "Lcom/amap/api/maps/model/LatLngBounds;", "bounds", "", "widthPx", "heightPx", "Lcom/stepos/ailauncher/amap/route/U$b;", "padding", "", "minSpanMeters", "", "density", "Lcom/amap/api/maps/model/CameraPosition;", "G", "(Lcom/amap/api/maps/model/LatLngBounds;IILcom/stepos/ailauncher/amap/route/U$b;DF)Lcom/amap/api/maps/model/CameraPosition;", "", "Lcom/stepos/ailauncher/amap/route/x;", "points", "Landroid/graphics/PointF;", "C", "(Ljava/util/List;IILcom/stepos/ailauncher/amap/route/U$b;D)Ljava/util/List;", "centerLat", "centerLng", "zoom", ExifInterface.LONGITUDE_EAST, "(Ljava/util/List;DDDIIF)Ljava/util/List;", "F", "Lkotlin/Pair;", "r", "(Lcom/amap/api/maps/model/LatLngBounds;)Lkotlin/Pair;", "Lcom/amap/api/maps/MapView;", "mapView", "LY8/t;", "p", "(Lcom/amap/api/maps/MapView;)V", "Lcom/amap/api/maps/AMap;", "aMap", "computed", "mapWidthPx", "mapHeightPx", "", "enforceComputedZoom", "Lkotlin/Function0;", "onSettled", "Lkotlin/Function1;", "onSettledZoom", "Lkotlin/Function3;", "onSettledCamera", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/amap/api/maps/AMap;Lcom/amap/api/maps/model/LatLngBounds;Lcom/stepos/ailauncher/amap/route/U$b;Lcom/amap/api/maps/model/CameraPosition;IILcom/amap/api/maps/MapView;ZLp9/a;Lp9/l;Lp9/q;)Ljava/lang/String;", "want", "onComplete", "s", "(Lcom/amap/api/maps/AMap;Lcom/amap/api/maps/model/CameraPosition;Lcom/amap/api/maps/MapView;Lp9/q;)V", "lng", "J", "(D)D", Const.JSON_KEY_LAT, "K", "wx", "y", "wy", "x", "v", "z", "meters", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "atLat", "B", "(DD)D", "Lcom/stepos/ailauncher/amap/route/U$a;", "rect", "u", "(Lcom/stepos/ailauncher/amap/route/U$a;D)Lcom/stepos/ailauncher/amap/route/U$a;", "(Ljava/util/List;D)Lcom/stepos/ailauncher/amap/route/U$a;", "w", "(Lcom/amap/api/maps/model/LatLngBounds;)Lcom/stepos/ailauncher/amap/route/U$a;", "q", "(Lcom/stepos/ailauncher/amap/route/U$a;IILcom/stepos/ailauncher/amap/route/U$b;)D", "Ljava/lang/Runnable;", "runnable", "H", "(Lcom/amap/api/maps/MapView;Ljava/lang/Runnable;)Ljava/lang/Runnable;", "Ljava/util/WeakHashMap;", "", "pendingLiteCamera", "Ljava/util/WeakHashMap;", "BOUNDS_PADDING_DP", "MIN_SPAN_METERS", "D", "POI_MIN_SPAN_METERS", "ROUTE_MIN_SPAN_METERS", "TILE", "MIN_ZOOM", "MAX_ZOOM", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U {
    public static final float BOUNDS_PADDING_DP = 24.0f;
    private static final double MAX_ZOOM = 19.0d;
    public static final double MIN_SPAN_METERS = 80.0d;
    private static final double MIN_ZOOM = 3.0d;
    public static final double POI_MIN_SPAN_METERS = 60.0d;
    public static final double ROUTE_MIN_SPAN_METERS = 25.0d;
    private static final double TILE = 256.0d;
    public static final U INSTANCE = new U();
    private static final WeakHashMap<MapView, List<Runnable>> pendingLiteCamera = new WeakHashMap<>();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010 \u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/amap/route/U$a;", "", "", "minLat", "maxLat", "minLng", "maxLng", "<init>", "(DDDD)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", Const.INTENT_KEY_BACKGROUND_COMMAND, "()D", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", Const.INTENT_KEY_APIKEY, "centerLat", Const.INTENT_KEY_PKGNAME, "centerLng", "c", "latSpan", Const.INTENT_KEY_UMID, "lngSpan", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.amap.route.U$a, reason: from toString */
    public static final /* data */ class GeoRect {
        private final double maxLat;
        private final double maxLng;
        private final double minLat;
        private final double minLng;

        public GeoRect(double d10, double d11, double d12, double d13) {
            this.minLat = d10;
            this.maxLat = d11;
            this.minLng = d12;
            this.maxLng = d13;
        }

        public final double a() {
            return (this.minLat + this.maxLat) / 2.0d;
        }

        public final double b() {
            return (this.minLng + this.maxLng) / 2.0d;
        }

        public final double c() {
            return this.maxLat - this.minLat;
        }

        public final double d() {
            return this.maxLng - this.minLng;
        }

        /* renamed from: e, reason: from getter */
        public final double getMaxLat() {
            return this.maxLat;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GeoRect)) {
                return false;
            }
            GeoRect geoRect = (GeoRect) other;
            return Double.compare(this.minLat, geoRect.minLat) == 0 && Double.compare(this.maxLat, geoRect.maxLat) == 0 && Double.compare(this.minLng, geoRect.minLng) == 0 && Double.compare(this.maxLng, geoRect.maxLng) == 0;
        }

        /* renamed from: f, reason: from getter */
        public final double getMaxLng() {
            return this.maxLng;
        }

        /* renamed from: g, reason: from getter */
        public final double getMinLat() {
            return this.minLat;
        }

        /* renamed from: h, reason: from getter */
        public final double getMinLng() {
            return this.minLng;
        }

        public int hashCode() {
            return (((((Double.hashCode(this.minLat) * 31) + Double.hashCode(this.maxLat)) * 31) + Double.hashCode(this.minLng)) * 31) + Double.hashCode(this.maxLng);
        }

        public String toString() {
            return "GeoRect(minLat=" + this.minLat + ", maxLat=" + this.maxLat + ", minLng=" + this.minLng + ", maxLng=" + this.maxLng + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0016B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/amap/route/U$b;", "", "", "left", "top", "right", "bottom", "<init>", "(IIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, "Companion", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.amap.route.U$b, reason: from toString */
    public static final /* data */ class Padding {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/amap/route/U$b$a;", "", "<init>", "()V", "", "px", "Lcom/stepos/ailauncher/amap/route/U$b;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/ailauncher/amap/route/U$b;", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.amap.route.U$b$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final Padding a(int px) {
                return new Padding(px, px, px, px);
            }

            public Companion() {
            }
        }

        public Padding(int i10, int i11, int i12, int i13) {
            this.left = i10;
            this.top = i11;
            this.right = i12;
            this.bottom = i13;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        /* renamed from: b, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: c, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        /* renamed from: d, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Padding)) {
                return false;
            }
            Padding padding = (Padding) other;
            return this.left == padding.left && this.top == padding.top && this.right == padding.right && this.bottom == padding.bottom;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
        }

        public String toString() {
            return "Padding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }
    }

    public static /* synthetic */ List D(U u10, List list, int i10, int i11, Padding padding, double d10, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            d10 = 80.0d;
        }
        return u10.C(list, i10, i11, padding, d10);
    }

    public static final void I(Runnable runnable, MapView mapView, Ref$ObjectRef ref$ObjectRef) {
        Runnable runnable2;
        WeakHashMap<MapView, List<Runnable>> weakHashMap = pendingLiteCamera;
        synchronized (weakHashMap) {
            try {
                List<Runnable> list = weakHashMap.get(mapView);
                if (list != null) {
                    T t10 = ref$ObjectRef.f34820a;
                    if (t10 == 0) {
                        kotlin.jvm.internal.p.A("tracked");
                        runnable2 = null;
                    } else {
                        runnable2 = (Runnable) t10;
                    }
                    list.remove(runnable2);
                    if (list.isEmpty()) {
                        weakHashMap.remove(mapView);
                    }
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        runnable.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String h(U u10, AMap aMap, LatLngBounds latLngBounds, Padding padding, CameraPosition cameraPosition, int i10, int i11, MapView mapView, boolean z10, InterfaceC5063a interfaceC5063a, InterfaceC5074l interfaceC5074l, p9.q qVar, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i10 = 0;
        }
        if ((i12 & 32) != 0) {
            i11 = 0;
        }
        if ((i12 & 64) != 0) {
            mapView = null;
        }
        if ((i12 & 128) != 0) {
            z10 = true;
        }
        if ((i12 & 256) != 0) {
            interfaceC5063a = null;
        }
        if ((i12 & 512) != 0) {
            interfaceC5074l = null;
        }
        if ((i12 & 1024) != 0) {
            qVar = null;
        }
        return u10.g(aMap, latLngBounds, padding, cameraPosition, i10, i11, mapView, z10, interfaceC5063a, interfaceC5074l, qVar);
    }

    public static final void i(final MapView mapView, final float f10, Float f11, int i10, int i11, final Padding padding, final LatLngBounds latLngBounds, final boolean z10, final AMap aMap, final CameraPosition cameraPosition, final InterfaceC5074l interfaceC5074l, final p9.q qVar, final InterfaceC5063a interfaceC5063a) {
        Object objB;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (mapView != null) {
            C2410v c2410v = C2410v.INSTANCE;
            LatLng latLng = latLngBounds.southwest;
            double d10 = latLng.latitude;
            double d11 = latLng.longitude;
            LatLng latLng2 = latLngBounds.northeast;
            c2410v.w(mapView, d10, d11, latLng2.latitude, latLng2.longitude, padding.getTop(), padding.getRight(), padding.getBottom(), padding.getLeft(), (512 & 512) != 0 ? 0 : 0, (512 & 1024) != 0 ? null : new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.P
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return U.j(ref$ObjectRef, f10, z10, ref$BooleanRef, aMap, cameraPosition, mapView, latLngBounds, padding, mapView, interfaceC5074l, qVar, interfaceC5063a, (C2410v.LiteCameraSnapshot) obj);
                }
            });
            mapView.postDelayed(INSTANCE.H(mapView, new Runnable() { // from class: com.stepos.ailauncher.amap.route.Q
                @Override // java.lang.Runnable
                public final void run() {
                    U.l(mapView, ref$ObjectRef, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a);
                }
            }), 1200L);
        } else {
            o(mapView, ref$ObjectRef, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, false, 128, null);
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
        C4148a.k("OverviewMapViewport", "liteBounds scheduled want=" + f10 + " before=" + f11 + " nativeAfter=" + ((Float) objB) + " size=" + i10 + "x" + i11 + " pad=" + padding.getLeft() + Const.STR_MART_COMMA + padding.getTop() + Const.STR_MART_COMMA + padding.getRight() + Const.STR_MART_COMMA + padding.getBottom(), false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Y8.t j(final Ref$ObjectRef ref$ObjectRef, float f10, boolean z10, final Ref$BooleanRef ref$BooleanRef, final AMap aMap, CameraPosition cameraPosition, MapView mapView, LatLngBounds latLngBounds, Padding padding, final MapView mapView2, final InterfaceC5074l interfaceC5074l, final p9.q qVar, final InterfaceC5063a interfaceC5063a, C2410v.LiteCameraSnapshot liteCameraSnapshot) {
        ref$ObjectRef.f34820a = liteCameraSnapshot;
        Float fValueOf = liteCameraSnapshot != 0 ? Float.valueOf(liteCameraSnapshot.getZoom()) : null;
        C4148a.k("OverviewMapViewport", "liteBounds js verified zoom=" + fValueOf + " want=" + f10, false, 4, null);
        if (fValueOf == null) {
            m(aMap, latLngBounds, padding);
            n(mapView2, ref$ObjectRef, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, true);
        } else if (!z10 || Math.abs(fValueOf.floatValue() - f10) <= 0.6f) {
            o(mapView2, ref$ObjectRef, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, false, 128, null);
        } else {
            C4148a.k("OverviewMapViewport", "liteBounds zoom mismatch, enforceLiteZoom zoom=" + fValueOf + " want=" + f10, false, 4, null);
            ref$BooleanRef.f34815a = false;
            INSTANCE.s(aMap, cameraPosition, mapView, new p9.q() { // from class: com.stepos.ailauncher.amap.route.S
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return U.k(ref$ObjectRef, mapView2, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, (Float) obj, (Double) obj2, (Double) obj3);
                }
            });
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.stepos.ailauncher.amap.route.v$a] */
    public static final Y8.t k(Ref$ObjectRef ref$ObjectRef, MapView mapView, Ref$BooleanRef ref$BooleanRef, AMap aMap, InterfaceC5074l interfaceC5074l, p9.q qVar, InterfaceC5063a interfaceC5063a, Float f10, Double d10, Double d11) {
        Ref$ObjectRef ref$ObjectRef2;
        if (f10 == null || d10 == null || d11 == null) {
            ref$ObjectRef2 = ref$ObjectRef;
        } else {
            ref$ObjectRef2 = ref$ObjectRef;
            ref$ObjectRef2.f34820a = new C2410v.LiteCameraSnapshot(f10.floatValue(), d11.doubleValue(), d10.doubleValue());
        }
        o(mapView, ref$ObjectRef2, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, false, 128, null);
        return Y8.t.f7040a;
    }

    public static final void l(MapView mapView, Ref$ObjectRef ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, AMap aMap, InterfaceC5074l interfaceC5074l, p9.q qVar, InterfaceC5063a interfaceC5063a) {
        n(mapView, ref$ObjectRef, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, true);
    }

    public static final void m(AMap aMap, LatLngBounds latLngBounds, Padding padding) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            aMap.moveCamera(CameraUpdateFactory.newLatLngBoundsRect(latLngBounds, padding.getLeft(), padding.getRight(), padding.getTop(), padding.getBottom()));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("OverviewMapViewport", "newLatLngBoundsRect fallback failed", thE, false, 8, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(MapView mapView, Ref$ObjectRef<C2410v.LiteCameraSnapshot> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, AMap aMap, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, p9.q<? super Float, ? super Double, ? super Double, Y8.t> qVar, InterfaceC5063a<Y8.t> interfaceC5063a, boolean z10) {
        Object objB;
        if (mapView == null || mapView.getParent() != null) {
            if (mapView != null && ref$ObjectRef.f34820a == null && !z10) {
                C4148a.u("OverviewMapViewport", "liteBounds settle skipped: JS camera was not verified", false, 4, null);
                return;
            }
            if (ref$BooleanRef.f34815a) {
                return;
            }
            ref$BooleanRef.f34815a = true;
            C2410v.INSTANCE.o0(aMap, false);
            if (ref$ObjectRef.f34820a == null && z10) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    CameraPosition cameraPosition = aMap.getCameraPosition();
                    float f10 = cameraPosition.zoom;
                    LatLng latLng = cameraPosition.target;
                    objB = Result.b(new C2410v.LiteCameraSnapshot(f10, latLng.longitude, latLng.latitude));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                boolean zG = Result.g(objB);
                T t10 = objB;
                if (zG) {
                    t10 = 0;
                }
                ref$ObjectRef.f34820a = t10;
            }
            if (interfaceC5074l != null) {
                C2410v.LiteCameraSnapshot liteCameraSnapshot = ref$ObjectRef.f34820a;
                interfaceC5074l.invoke(liteCameraSnapshot != null ? Float.valueOf(liteCameraSnapshot.getZoom()) : null);
            }
            if (qVar != null) {
                C2410v.LiteCameraSnapshot liteCameraSnapshot2 = ref$ObjectRef.f34820a;
                Float fValueOf = liteCameraSnapshot2 != null ? Float.valueOf(liteCameraSnapshot2.getZoom()) : null;
                C2410v.LiteCameraSnapshot liteCameraSnapshot3 = ref$ObjectRef.f34820a;
                Double dValueOf = liteCameraSnapshot3 != null ? Double.valueOf(liteCameraSnapshot3.getCenterLat()) : null;
                C2410v.LiteCameraSnapshot liteCameraSnapshot4 = ref$ObjectRef.f34820a;
                qVar.invoke(fValueOf, dValueOf, liteCameraSnapshot4 != null ? Double.valueOf(liteCameraSnapshot4.getCenterLng()) : null);
            }
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
    }

    public static /* synthetic */ void o(MapView mapView, Ref$ObjectRef ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, AMap aMap, InterfaceC5074l interfaceC5074l, p9.q qVar, InterfaceC5063a interfaceC5063a, boolean z10, int i10, Object obj) {
        n(mapView, ref$ObjectRef, ref$BooleanRef, aMap, interfaceC5074l, qVar, interfaceC5063a, (i10 & 128) != 0 ? false : z10);
    }

    public static final Y8.t t(p9.q qVar, C2410v.LiteCameraSnapshot liteCameraSnapshot) {
        if (qVar != null) {
            qVar.invoke(liteCameraSnapshot != null ? Float.valueOf(liteCameraSnapshot.getZoom()) : null, liteCameraSnapshot != null ? Double.valueOf(liteCameraSnapshot.getCenterLat()) : null, liteCameraSnapshot != null ? Double.valueOf(liteCameraSnapshot.getCenterLng()) : null);
        }
        return Y8.t.f7040a;
    }

    public final double A(double meters) {
        return meters / 111320.0d;
    }

    public final double B(double meters, double atLat) {
        return meters / (C5685n.d(Math.cos(Math.toRadians(atLat)), 0.2d) * 111320.0d);
    }

    public final List<PointF> C(List<GeoPoint> points, int widthPx, int heightPx, Padding padding, double minSpanMeters) {
        kotlin.jvm.internal.p.i(points, "points");
        kotlin.jvm.internal.p.i(padding, "padding");
        if (points.isEmpty() || widthPx <= 0 || heightPx <= 0) {
            return C1173v.m();
        }
        GeoRect geoRectV = v(points, minSpanMeters);
        if (geoRectV == null) {
            return C1173v.m();
        }
        double dPow = Math.pow(2.0d, q(geoRectV, widthPx, heightPx, padding)) * TILE;
        double dJ = J(geoRectV.b()) * dPow;
        double dK = K(geoRectV.a()) * dPow;
        double left = ((padding.getLeft() + widthPx) - padding.getRight()) / 2.0d;
        double top = ((padding.getTop() + heightPx) - padding.getBottom()) / 2.0d;
        List<GeoPoint> list = points;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (GeoPoint geoPoint : list) {
            U u10 = INSTANCE;
            double d10 = top;
            arrayList.add(new PointF(C5685n.m((float) ((((u10.J(geoPoint.getLng()) * dPow) - dJ) + left) / widthPx), 0.0f, 1.0f), C5685n.m((float) ((d10 + ((u10.K(geoPoint.getLat()) * dPow) - dK)) / heightPx), 0.0f, 1.0f)));
            top = d10;
            dPow = dPow;
        }
        return arrayList;
    }

    public final List<PointF> E(List<GeoPoint> points, double centerLat, double centerLng, double zoom, int widthPx, int heightPx, float density) {
        kotlin.jvm.internal.p.i(points, "points");
        List<PointF> listF = F(points, centerLat, centerLng, zoom, widthPx, heightPx, density);
        ArrayList arrayList = new ArrayList(C1174w.x(listF, 10));
        for (PointF pointF : listF) {
            arrayList.add(new PointF(C5685n.m(pointF.x / widthPx, 0.0f, 1.0f), C5685n.m(pointF.y / heightPx, 0.0f, 1.0f)));
        }
        return arrayList;
    }

    public final List<PointF> F(List<GeoPoint> points, double centerLat, double centerLng, double zoom, int widthPx, int heightPx, float density) {
        kotlin.jvm.internal.p.i(points, "points");
        if (points.isEmpty() || widthPx <= 0 || heightPx <= 0) {
            return C1173v.m();
        }
        Float fValueOf = Float.valueOf(density);
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        double dPow = Math.pow(2.0d, zoom) * TILE * (fValueOf != null ? fValueOf.floatValue() : 1.0f);
        double dJ = J(centerLng) * dPow;
        double dK = K(centerLat) * dPow;
        double d10 = widthPx / 2.0d;
        double d11 = heightPx / 2.0d;
        List<GeoPoint> list = points;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (GeoPoint geoPoint : list) {
            U u10 = INSTANCE;
            double d12 = d11;
            arrayList.add(new PointF((float) (((u10.J(geoPoint.getLng()) * dPow) - dJ) + d10), (float) (d12 + ((u10.K(geoPoint.getLat()) * dPow) - dK))));
            d11 = d12;
            dJ = dJ;
        }
        return arrayList;
    }

    public final CameraPosition G(LatLngBounds bounds, int widthPx, int heightPx, Padding padding, double minSpanMeters, float density) {
        kotlin.jvm.internal.p.i(bounds, "bounds");
        kotlin.jvm.internal.p.i(padding, "padding");
        GeoRect geoRectU = u(w(bounds), minSpanMeters);
        Float fValueOf = Float.valueOf(density);
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        float fFloatValue = fValueOf != null ? fValueOf.floatValue() : 1.0f;
        int iF = C5685n.f(C5227b.b(widthPx / fFloatValue), 1);
        int iF2 = C5685n.f(C5227b.b(heightPx / fFloatValue), 1);
        double dQ = q(geoRectU, iF, iF2, new Padding(C5227b.b(padding.getLeft() / fFloatValue), C5227b.b(padding.getTop() / fFloatValue), C5227b.b(padding.getRight() / fFloatValue), C5227b.b(padding.getBottom() / fFloatValue)));
        double dPow = Math.pow(2.0d, dQ) * TILE;
        return new CameraPosition(new LatLng(x(K(geoRectU.a()) - (((((r7.getTop() + iF2) - r7.getBottom()) / 2.0d) - (iF2 / 2.0d)) / dPow)), y(J(geoRectU.b()) - (((((r7.getLeft() + iF) - r7.getRight()) / 2.0d) - (iF / 2.0d)) / dPow))), (float) dQ, 0.0f, 0.0f);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.stepos.ailauncher.amap.route.O] */
    public final Runnable H(final MapView mapView, final Runnable runnable) {
        Runnable runnable2;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f34820a = new Runnable() { // from class: com.stepos.ailauncher.amap.route.O
            @Override // java.lang.Runnable
            public final void run() {
                U.I(runnable, mapView, ref$ObjectRef);
            }
        };
        WeakHashMap<MapView, List<Runnable>> weakHashMap = pendingLiteCamera;
        synchronized (weakHashMap) {
            try {
                List<Runnable> arrayList = weakHashMap.get(mapView);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    weakHashMap.put(mapView, arrayList);
                }
                List<Runnable> list = arrayList;
                T t10 = ref$ObjectRef.f34820a;
                if (t10 == 0) {
                    kotlin.jvm.internal.p.A("tracked");
                    runnable2 = null;
                } else {
                    runnable2 = (Runnable) t10;
                }
                list.add(runnable2);
            } catch (Throwable th) {
                throw th;
            }
        }
        T t11 = ref$ObjectRef.f34820a;
        if (t11 != 0) {
            return (Runnable) t11;
        }
        kotlin.jvm.internal.p.A("tracked");
        return null;
    }

    public final double J(double lng) {
        return (lng + 180.0d) / 360.0d;
    }

    public final double K(double lat) {
        return 0.5d - (Math.log(Math.tan((Math.toRadians(C5685n.l(lat, -85.05112878d, 85.05112878d)) / 2.0d) + 0.7853981633974483d)) / 6.283185307179586d);
    }

    public final String g(final AMap aMap, final LatLngBounds bounds, final Padding padding, final CameraPosition computed, final int mapWidthPx, final int mapHeightPx, final MapView mapView, final boolean enforceComputedZoom, final InterfaceC5063a<Y8.t> onSettled, final InterfaceC5074l<? super Float, Y8.t> onSettledZoom, final p9.q<? super Float, ? super Double, ? super Double, Y8.t> onSettledCamera) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(aMap, "aMap");
        kotlin.jvm.internal.p.i(bounds, "bounds");
        kotlin.jvm.internal.p.i(padding, "padding");
        kotlin.jvm.internal.p.i(computed, "computed");
        C2410v c2410v = C2410v.INSTANCE;
        C2410v.X(c2410v, aMap, 0.0f, 0.0f, 6, null);
        c2410v.o0(aMap, true);
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
        final Float f10 = (Float) objB;
        final float f11 = computed.zoom;
        p(mapView);
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.amap.route.N
            @Override // java.lang.Runnable
            public final void run() {
                U.i(mapView, f11, f10, mapWidthPx, mapHeightPx, padding, bounds, enforceComputedZoom, aMap, computed, onSettledZoom, onSettledCamera, onSettled);
            }
        };
        if (mapView != null) {
            mapView.postDelayed(H(mapView, runnable), 80L);
        } else {
            try {
                aMap.moveCamera(CameraUpdateFactory.newLatLngBoundsRect(bounds, padding.getLeft(), padding.getRight(), padding.getTop(), padding.getBottom()));
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                C4148a.t("OverviewMapViewport", "newLatLngBoundsRect failed", thE, false, 8, null);
            }
            runnable.run();
        }
        return "liteBounds scheduled want=" + f11 + " before=" + f10 + " size=" + mapWidthPx + "x" + mapHeightPx;
    }

    public final void p(MapView mapView) {
        List<Runnable> listRemove;
        if (mapView == null) {
            return;
        }
        WeakHashMap<MapView, List<Runnable>> weakHashMap = pendingLiteCamera;
        synchronized (weakHashMap) {
            listRemove = weakHashMap.remove(mapView);
        }
        if (listRemove == null) {
            return;
        }
        Iterator<T> it = listRemove.iterator();
        while (it.hasNext()) {
            mapView.removeCallbacks((Runnable) it.next());
        }
    }

    public final double q(GeoRect rect, int widthPx, int heightPx, Padding padding) {
        double dMax = Math.max((widthPx - padding.getLeft()) - padding.getRight(), 1);
        double dMax2 = Math.max((heightPx - padding.getTop()) - padding.getBottom(), 1);
        double dJ = J(rect.getMaxLng()) - J(rect.getMinLng());
        double dK = K(rect.getMinLat()) - K(rect.getMaxLat());
        double dZ = MAX_ZOOM;
        double dZ2 = dJ > 1.0E-12d ? z(dMax / (dJ * TILE)) : 19.0d;
        if (dK > 1.0E-12d) {
            dZ = z(dMax2 / (dK * TILE));
        }
        return C5685n.l(Math.min(dZ2, dZ), MIN_ZOOM, MAX_ZOOM);
    }

    public final Pair<Double, Double> r(LatLngBounds bounds) {
        kotlin.jvm.internal.p.i(bounds, "bounds");
        LatLng latLng = bounds.northeast;
        double d10 = latLng.latitude;
        LatLng latLng2 = bounds.southwest;
        double d11 = latLng2.latitude;
        return Y8.j.a(Double.valueOf((d10 - d11) * 111320.0d), Double.valueOf((latLng.longitude - latLng2.longitude) * 111320.0d * C5685n.d(Math.cos(Math.toRadians((d10 + d11) / 2.0d)), 0.2d)));
    }

    public final void s(AMap aMap, CameraPosition want, MapView mapView, final p9.q<? super Float, ? super Double, ? super Double, Y8.t> onComplete) {
        Object objB;
        Object objB2;
        Object objB3;
        kotlin.jvm.internal.p.i(aMap, "aMap");
        kotlin.jvm.internal.p.i(want, "want");
        C2410v.X(C2410v.INSTANCE, aMap, 0.0f, 0.0f, 6, null);
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
        float fFloatValue = f10 != null ? f10.floatValue() : 20.0f;
        float fI = C5685n.i(want.zoom, fFloatValue);
        try {
            objB2 = Result.b(aMap.getCameraPosition());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        CameraPosition cameraPosition = (CameraPosition) objB2;
        if (cameraPosition == null) {
            return;
        }
        if (Math.abs(cameraPosition.zoom - fI) <= 0.35f) {
            if (onComplete != null) {
                onComplete.invoke(null, null, null);
                return;
            }
            return;
        }
        try {
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(want.target, fI));
            Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
        try {
            aMap.moveCamera(CameraUpdateFactory.zoomTo(fI));
            Result.b(Y8.t.f7040a);
        } catch (Throwable th4) {
            Result.Companion companion5 = Result.INSTANCE;
            Result.b(C4849c.a(th4));
        }
        if (mapView != null) {
            C2410v c2410v = C2410v.INSTANCE;
            LatLng latLng = want.target;
            c2410v.E(mapView, latLng.latitude, latLng.longitude, fI, (16 & 16) != 0 ? 0 : 0, (16 & 32) != 0 ? null : new InterfaceC5074l() { // from class: com.stepos.ailauncher.amap.route.T
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return U.t(onComplete, (C2410v.LiteCameraSnapshot) obj);
                }
            });
        } else if (onComplete != null) {
            onComplete.invoke(null, null, null);
        }
        try {
            objB3 = Result.b(aMap.getCameraPosition());
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.INSTANCE;
            objB3 = Result.b(C4849c.a(th5));
        }
        if (Result.g(objB3)) {
            objB3 = null;
        }
        CameraPosition cameraPosition2 = (CameraPosition) objB3;
        C4148a.k("PoiMapZoom", "enforceLiteZoom was=" + cameraPosition.zoom + " want=" + fI + " maxZ=" + fFloatValue + " after=" + (cameraPosition2 != null ? Float.valueOf(cameraPosition2.zoom) : null), false, 4, null);
    }

    public final GeoRect u(GeoRect rect, double minSpanMeters) {
        double dC = rect.c() * 111320.0d;
        double d10 = rect.d() * 111320.0d * C5685n.d(Math.cos(Math.toRadians(rect.a())), 0.2d);
        if (dC >= minSpanMeters && d10 >= minSpanMeters) {
            return rect;
        }
        double dA = A(minSpanMeters);
        double dB = B(minSpanMeters, rect.a());
        double dMax = Math.max(rect.c(), dA) / 2.0d;
        double dMax2 = Math.max(rect.d(), dB) / 2.0d;
        return new GeoRect(C5685n.l(rect.a() - dMax, -85.0d, 85.0d), C5685n.l(rect.a() + dMax, -85.0d, 85.0d), rect.b() - dMax2, rect.b() + dMax2);
    }

    public final GeoRect v(List<GeoPoint> points, double minSpanMeters) {
        GeoRect geoRect;
        if (points.isEmpty()) {
            return null;
        }
        if (points.size() == 1) {
            GeoPoint geoPoint = points.get(0);
            geoRect = new GeoRect(geoPoint.getLat(), geoPoint.getLat(), geoPoint.getLng(), geoPoint.getLng());
        } else {
            List<GeoPoint> list = points;
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            double lat = ((GeoPoint) it.next()).getLat();
            while (it.hasNext()) {
                lat = Math.min(lat, ((GeoPoint) it.next()).getLat());
            }
            Iterator<T> it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            double lat2 = ((GeoPoint) it2.next()).getLat();
            while (it2.hasNext()) {
                lat2 = Math.max(lat2, ((GeoPoint) it2.next()).getLat());
            }
            Iterator<T> it3 = list.iterator();
            if (!it3.hasNext()) {
                throw new NoSuchElementException();
            }
            double lng = ((GeoPoint) it3.next()).getLng();
            while (it3.hasNext()) {
                lng = Math.min(lng, ((GeoPoint) it3.next()).getLng());
            }
            Iterator<T> it4 = list.iterator();
            if (!it4.hasNext()) {
                throw new NoSuchElementException();
            }
            double lng2 = ((GeoPoint) it4.next()).getLng();
            while (it4.hasNext()) {
                lng2 = Math.max(lng2, ((GeoPoint) it4.next()).getLng());
            }
            geoRect = new GeoRect(lat, lat2, lng, lng2);
        }
        return u(geoRect, minSpanMeters);
    }

    public final GeoRect w(LatLngBounds bounds) {
        LatLng latLng = bounds.southwest;
        double d10 = latLng.latitude;
        LatLng latLng2 = bounds.northeast;
        return new GeoRect(d10, latLng2.latitude, latLng.longitude, latLng2.longitude);
    }

    public final double x(double wy) {
        return C5685n.l(Math.toDegrees((Math.atan(Math.exp((0.5d - wy) * 6.283185307179586d)) - 0.7853981633974483d) * 2.0d), -85.05112878d, 85.05112878d);
    }

    public final double y(double wx) {
        return (wx * 360.0d) - 180.0d;
    }

    public final double z(double v10) {
        return Math.log(v10) / Math.log(2.0d);
    }
}
