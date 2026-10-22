package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.BMapManagerInternal;
import com.baidu.mapsdkplatform.comapi.MapAuthListener;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import com.baidu.mapsdkplatform.comapi.map.c;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.y;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.h;
import com.stepos.alphame.app.AppStateEngine;
import com.stepos.alphame.utils.Property;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL10;
import kotlin.time.DurationKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public final class TextureMapView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6976a = "TextureMapView";

    /* renamed from: b, reason: collision with root package name */
    private static String f6977b;

    /* renamed from: c, reason: collision with root package name */
    private static int f6978c;

    /* renamed from: d, reason: collision with root package name */
    private static int f6979d;

    /* renamed from: e, reason: collision with root package name */
    private static final SparseArray<Integer> f6980e;

    /* renamed from: A, reason: collision with root package name */
    private int f6981A;

    /* renamed from: B, reason: collision with root package name */
    private int f6982B;

    /* renamed from: C, reason: collision with root package name */
    private int f6983C;

    /* renamed from: D, reason: collision with root package name */
    private int f6984D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f6985E;

    /* renamed from: f, reason: collision with root package name */
    private MapTextureView f6986f;

    /* renamed from: g, reason: collision with root package name */
    private BaiduMap f6987g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f6988h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f6989i;

    /* renamed from: j, reason: collision with root package name */
    private y f6990j;

    /* renamed from: k, reason: collision with root package name */
    private Point f6991k;

    /* renamed from: l, reason: collision with root package name */
    private Point f6992l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f6993m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f6994n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f6995o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f6996p;

    /* renamed from: q, reason: collision with root package name */
    private Context f6997q;

    /* renamed from: r, reason: collision with root package name */
    private final Object f6998r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6999s;

    /* renamed from: t, reason: collision with root package name */
    private MapAuthListener f7000t;

    /* renamed from: u, reason: collision with root package name */
    private float f7001u;

    /* renamed from: v, reason: collision with root package name */
    private int f7002v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7003w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7004x;

    /* renamed from: y, reason: collision with root package name */
    private int f7005y;

    /* renamed from: z, reason: collision with root package name */
    private int f7006z;

    public class a implements MapAuthListener {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.MapAuthListener
        public void setAuthParam(String str) {
            synchronized (TextureMapView.this.f6998r) {
                try {
                    if (TextureMapView.this.f6999s) {
                        return;
                    }
                    if (str != null) {
                        h.b().a(str, com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace.a() | com.baidu.platform.comjni.base.sdkauth.a.WaterMark.a());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class b implements c.InterfaceC0029c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomMapStyleCallBack f7008a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapCustomStyleOptions f7009b;

        public b(CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
            this.f7008a = customMapStyleCallBack;
            this.f7009b = mapCustomStyleOptions;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onCustomMapStyleLoadFailed(int i4, String str, String str2) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f7008a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadFailed(i4, str, str2)) && !TextureMapView.this.f6985E) {
                TextureMapView.this.a(str2, this.f7009b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onCustomMapStyleLoadSuccess(boolean z4, String str) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f7008a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadSuccess(z4, str)) && !TextUtils.isEmpty(str)) {
                TextureMapView.this.a(str, "");
                TextureMapView.this.setMapCustomStyleEnable(true);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onPreLoadLastCustomMapStyle(String str) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f7008a;
            if (customMapStyleCallBack == null || !customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
                TextureMapView.this.a(str, this.f7009b);
                TextureMapView.this.f6985E = true;
            }
        }
    }

    public class c implements v {
        public c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void e(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void f(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void g(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void onFirstMapTileLoaded() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(MotionEvent motionEvent) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(s sVar) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(s sVar) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(GeoPoint geoPoint) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean d(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GL10 gl10, s sVar) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(String str) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean c(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z4) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean b(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z4, int i4) {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, Point point2, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(MotionEvent motionEvent, float f4, float f5, s sVar) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(BmDrawItem bmDrawItem) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(String str) {
            return false;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(s sVar) {
            if (TextureMapView.this.f6986f == null || TextureMapView.this.f6986f.getController() == null) {
                return;
            }
            float zoomLevel = TextureMapView.this.f6986f.getZoomLevel();
            if (zoomLevel < TextureMapView.this.f6986f.getController().mMinZoomLevel) {
                zoomLevel = TextureMapView.this.f6986f.getController().mMinZoomLevel;
            } else if (zoomLevel > TextureMapView.this.f6986f.getController().mMaxZoomLevel) {
                zoomLevel = TextureMapView.this.f6986f.getController().mMaxZoomLevel;
            }
            if (Math.abs(TextureMapView.this.f7001u - zoomLevel) > Property.DEFAULT_FLOAT_VALUE) {
                TextureMapView.this.updateScaleUI(zoomLevel);
            }
            TextureMapView.this.a();
            TextureMapView.this.requestLayout();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            float zoomLevel = TextureMapView.this.f6986f.getZoomLevel();
            float fFloor = zoomLevel - 1.0f;
            double d4 = zoomLevel;
            if (Math.floor(d4) != d4) {
                fFloor = (float) Math.floor(d4);
            }
            float fMax = Math.max(fFloor, TextureMapView.this.f6986f.getController().mMinZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            TextureMapView.this.f6986f.setZoomLevel(fMax);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            float zoomLevel = TextureMapView.this.f6986f.getZoomLevel();
            float fCeil = 1.0f + zoomLevel;
            double d4 = zoomLevel;
            if (((int) Math.ceil(d4)) != ((int) zoomLevel)) {
                fCeil = (float) Math.ceil(d4);
            }
            float fMin = Math.min(fCeil, TextureMapView.this.f6986f.getController().mMaxZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            TextureMapView.this.f6986f.setZoomLevel(fMin);
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7014a;

        public f(View view) {
            this.f7014a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextureMapView.this.removeView(this.f7014a);
        }
    }

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f6980e = sparseArray;
        AbstractC0351g.x(2000000, sparseArray, 3, DurationKt.NANOS_IN_MILLIS, 4);
        AbstractC0351g.x(500000, sparseArray, 5, 200000, 6);
        AbstractC0351g.x(ComplexPt.TEN_THOUSAND, sparseArray, 7, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 8);
        AbstractC0351g.x(AppStateEngine.QUICK_CHECK_TIME, sparseArray, 9, 20000, 10);
        AbstractC0351g.x(10000, sparseArray, 11, 5000, 12);
        AbstractC0351g.x(2000, sparseArray, 13, 1000, 14);
        AbstractC0351g.x(500, sparseArray, 15, 200, 16);
        AbstractC0351g.x(100, sparseArray, 17, 50, 18);
        AbstractC0351g.x(20, sparseArray, 19, 10, 20);
        AbstractC0351g.x(5, sparseArray, 21, 2, 22);
    }

    public TextureMapView(Context context) throws IOException {
        super(context);
        this.f6998r = new Object();
        this.f6999s = false;
        this.f7000t = new a();
        this.f7002v = LogoPosition.logoPostionleftBottom.ordinal();
        this.f7003w = true;
        this.f7004x = true;
        this.f6985E = false;
        a(context, (BaiduMapOptions) null);
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
        if (!new File(str).exists()) {
            throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
        }
        f6977b = str;
    }

    @Deprecated
    public static void setIconCustom(int i4) {
        f6979d = i4;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i4) {
        f6978c = i4;
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z4) {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            super.addView(view, layoutParams);
        }
    }

    public final LogoPosition getLogoPosition() {
        int i4 = this.f7002v;
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f6987g;
        baiduMap.f6201i0 = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return f6980e.get((int) this.f6986f.getBaseMap().y().f8099a).intValue();
    }

    public Point getScaleControlPosition() {
        return this.f6991k;
    }

    public int getScaleControlViewHeight() {
        return this.f6983C;
    }

    public int getScaleControlViewWidth() {
        return this.f6984D;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.f6991k != null) {
            this.f6991k = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.f6992l != null) {
            this.f6992l = (Point) bundle.getParcelable("zoomPosition");
        }
        this.f7003w = bundle.getBoolean("mZoomControlEnabled");
        this.f7004x = bundle.getBoolean("mScaleControlEnabled");
        this.f7002v = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
    }

    public final void onDestroy() {
        synchronized (this.f6998r) {
            try {
                if (this.f6997q != null) {
                    this.f6986f.onDestroy();
                }
                h.a();
                this.f6999s = true;
                Bitmap bitmap = this.f6989i;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f6989i.recycle();
                }
                BMapManagerInternal.getInstance().removeMapAuthListener(this.f7000t);
                this.f6990j.d();
                BMapManager.destroy();
                com.baidu.mapsdkplatform.comapi.map.e.a();
                this.f6997q = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        float width;
        float height;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        int childCount = getChildCount();
        a(this.f6988h);
        if (((getWidth() - this.f7005y) - this.f7006z) - this.f6988h.getMeasuredWidth() <= 0 || ((getHeight() - this.f6981A) - this.f6982B) - this.f6988h.getMeasuredHeight() <= 0) {
            this.f7005y = 0;
            this.f7006z = 0;
            this.f6982B = 0;
            this.f6981A = 0;
            width = 1.0f;
            height = 1.0f;
        } else {
            width = ((getWidth() - this.f7005y) - this.f7006z) / getWidth();
            height = ((getHeight() - this.f6981A) - this.f6982B) / getHeight();
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != null) {
                MapTextureView mapTextureView = this.f6986f;
                if (childAt == mapTextureView) {
                    mapTextureView.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.f6988h;
                    if (childAt == imageView) {
                        float f4 = width * 5.0f;
                        int width2 = (int) (this.f7005y + f4);
                        int i9 = (int) (this.f7006z + f4);
                        float f5 = 5.0f * height;
                        int measuredHeight2 = (int) (this.f6981A + f5);
                        int i10 = (int) (this.f6982B + f5);
                        int i11 = this.f7002v;
                        if (i11 == 1) {
                            measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                            measuredWidth = this.f6988h.getMeasuredWidth() + width2;
                        } else if (i11 == 2) {
                            measuredHeight = getHeight() - i10;
                            measuredHeight2 = measuredHeight - this.f6988h.getMeasuredHeight();
                            width2 = (((getWidth() - this.f6988h.getMeasuredWidth()) + this.f7005y) - this.f7006z) / 2;
                            measuredWidth = (((this.f6988h.getMeasuredWidth() + getWidth()) + this.f7005y) - this.f7006z) / 2;
                        } else if (i11 != 3) {
                            if (i11 == 4) {
                                measuredHeight = getHeight() - i10;
                                measuredHeight2 = measuredHeight - this.f6988h.getMeasuredHeight();
                                measuredWidth = getWidth() - i9;
                                measuredWidth2 = this.f6988h.getMeasuredWidth();
                            } else if (i11 != 5) {
                                measuredHeight = getHeight() - i10;
                                measuredWidth = this.f6988h.getMeasuredWidth() + width2;
                                measuredHeight2 = measuredHeight - this.f6988h.getMeasuredHeight();
                            } else {
                                measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                                measuredWidth = getWidth() - i9;
                                measuredWidth2 = this.f6988h.getMeasuredWidth();
                            }
                            width2 = measuredWidth - measuredWidth2;
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                            width2 = (((getWidth() - this.f6988h.getMeasuredWidth()) + this.f7005y) - this.f7006z) / 2;
                            measuredWidth = (((this.f6988h.getMeasuredWidth() + getWidth()) + this.f7005y) - this.f7006z) / 2;
                        }
                        this.f6988h.layout(width2, measuredHeight2, measuredWidth, measuredHeight);
                    } else {
                        y yVar = this.f6990j;
                        if (childAt != yVar) {
                            RelativeLayout relativeLayout = this.f6993m;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point = this.f6991k;
                                if (point == null) {
                                    this.f6984D = this.f6993m.getMeasuredWidth();
                                    this.f6983C = this.f6993m.getMeasuredHeight();
                                    int i12 = (int) ((5.0f * width) + this.f7005y);
                                    int height2 = (getHeight() - ((int) (((height * 5.0f) + this.f6982B) + 56.0f))) - this.f6988h.getMeasuredHeight();
                                    this.f6993m.layout(i12, height2, this.f6984D + i12, this.f6983C + height2);
                                } else {
                                    RelativeLayout relativeLayout2 = this.f6993m;
                                    int i13 = point.x;
                                    relativeLayout2.layout(i13, point.y, relativeLayout2.getMeasuredWidth() + i13, this.f6993m.getMeasuredHeight() + this.f6991k.y);
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    Point pointA = mapViewLayoutParams.f6585c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6584b : this.f6986f.getBaseMap() != null ? this.f6986f.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.f6583a)) : new Point();
                                    a(childAt);
                                    int measuredWidth3 = childAt.getMeasuredWidth();
                                    int measuredHeight3 = childAt.getMeasuredHeight();
                                    float f6 = mapViewLayoutParams.f6586d;
                                    float f7 = mapViewLayoutParams.f6587e;
                                    int i14 = ((int) (pointA.x - (f6 * measuredWidth3))) + mapViewLayoutParams.f6589g;
                                    int i15 = ((int) (pointA.y - (f7 * measuredHeight3))) + mapViewLayoutParams.f6588f;
                                    childAt.layout(i14, i15, measuredWidth3 + i14, measuredHeight3 + i15);
                                }
                            }
                        } else if (yVar.c()) {
                            a(this.f6990j);
                            Point point2 = this.f6992l;
                            if (point2 == null) {
                                int height3 = (int) (((getHeight() - 15) * height) + this.f6981A);
                                int width3 = (int) (((getWidth() - 15) * width) + this.f7005y);
                                int measuredWidth4 = width3 - this.f6990j.getMeasuredWidth();
                                int measuredHeight4 = height3 - this.f6990j.getMeasuredHeight();
                                if (this.f7002v == 4) {
                                    height3 -= this.f6988h.getMeasuredHeight();
                                    measuredHeight4 -= this.f6988h.getMeasuredHeight();
                                }
                                this.f6990j.layout(measuredWidth4, measuredHeight4, width3, height3);
                            } else {
                                y yVar2 = this.f6990j;
                                int i16 = point2.x;
                                yVar2.layout(i16, point2.y, yVar2.getMeasuredWidth() + i16, this.f6990j.getMeasuredHeight() + this.f6992l.y);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f6986f.onPause();
    }

    public final void onResume() {
        this.f6986f.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f6987g) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f6991k;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f6992l;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.f7003w);
        bundle.putBoolean("mScaleControlEnabled", this.f7004x);
        bundle.putInt("logoPosition", this.f7002v);
        bundle.putInt("paddingLeft", this.f7005y);
        bundle.putInt("paddingTop", this.f6981A);
        bundle.putInt("paddingRight", this.f7006z);
        bundle.putInt("paddingBottom", this.f6982B);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f6988h) {
            return;
        }
        if (c()) {
            super.removeView(view);
        } else {
            MapTaskManager.postToMainThread(new f(view), 0L);
        }
    }

    public void setCustomStyleFilePathAndMode(String str, int i4) {
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.f7002v = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.f7002v = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.c.a().a(this.f6997q, customMapStyleId, new b(customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, "");
    }

    public void setMapCustomStyleEnable(boolean z4) {
        MapTextureView mapTextureView = this.f6986f;
        if (mapTextureView == null || mapTextureView.getBaseMap() == null) {
            return;
        }
        this.f6986f.getBaseMap().r(z4);
    }

    public void setMapCustomStylePath(String str) {
        a(str, "");
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f7005y = i4;
        this.f6981A = i5;
        this.f7006z = i6;
        this.f6982B = i7;
    }

    public void setScaleControlPosition(Point point) {
        int i4;
        if (point != null && (i4 = point.x) >= 0 && point.y >= 0 && i4 <= getWidth() && point.y <= getHeight()) {
            this.f6991k = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i4;
        if (point != null && (i4 = point.x) >= 0 && point.y >= 0 && i4 <= getWidth() && point.y <= getHeight()) {
            this.f6992l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z4) {
        this.f6993m.setVisibility(z4 ? 0 : 8);
        this.f7004x = z4;
    }

    public void showZoomControls(boolean z4) {
        if (this.f6990j.c()) {
            this.f6990j.setVisibility(z4 ? 0 : 8);
            this.f7003w = z4;
        }
    }

    public void updateScaleUI(float f4) {
        MapTextureView mapTextureView = this.f6986f;
        if (mapTextureView == null || mapTextureView.getController() == null) {
            return;
        }
        Integer num = f6980e.get(Math.round(f4));
        int iIntValue = num.intValue();
        int zoomUnitsInMeter = (int) (iIntValue / this.f6986f.getController().getZoomUnitsInMeter());
        ImageView imageView = this.f6996p;
        if (imageView != null) {
            int i4 = zoomUnitsInMeter / 2;
            imageView.setPadding(i4, 0, i4, 0);
        }
        String str = iIntValue >= 1000 ? this.f6987g.getMapLanguage() == MapLanguage.ENGLISH ? String.format(" %dkm ", Integer.valueOf(iIntValue / 1000)) : String.format(" %d公里 ", Integer.valueOf(iIntValue / 1000)) : this.f6987g.getMapLanguage() == MapLanguage.ENGLISH ? String.format(" %dm ", num) : String.format(" %d米 ", num);
        TextView textView = this.f6994n;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f6995o;
        if (textView2 != null) {
            textView2.setText(str);
        }
        this.f7001u = f4;
    }

    private boolean b() throws ClassNotFoundException {
        try {
            Class.forName("com.baidu.bmfmap.map.FlutterTextureMapView");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void c(Context context) {
        y yVar = new y(context);
        this.f6990j = yVar;
        if (yVar.c()) {
            this.f6990j.setOnZoomOutClickListener(new d());
            this.f6990j.setOnZoomInClickListener(new e());
            addView(this.f6990j);
        }
    }

    private void d() {
        HashMap map = new HashMap();
        if (b()) {
            map.put(ExifInterface.GPS_DIRECTION_TRUE, "1");
        } else {
            map.put(ExifInterface.GPS_DIRECTION_TRUE, "0");
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0.1", map);
    }

    private void b(Context context) throws IOException {
        this.f6993m = new RelativeLayout(context);
        this.f6993m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f6994n = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f6994n.setTextColor(Color.parseColor("#FFFFFF"));
        this.f6994n.setTextSize(2, 11.0f);
        TextView textView = this.f6994n;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f6994n.setLayoutParams(layoutParams);
        this.f6994n.setId(Integer.MAX_VALUE);
        this.f6993m.addView(this.f6994n);
        this.f6995o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.f6995o.setTextColor(Color.parseColor("#000000"));
        this.f6995o.setTextSize(2, 11.0f);
        this.f6995o.setLayoutParams(layoutParams2);
        this.f6993m.addView(this.f6995o);
        this.f6996p = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f6994n.getId());
        this.f6996p.setLayoutParams(layoutParams3);
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", context);
        byte[] ninePatchChunk = bitmapLoadAssetsFile.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.f6996p.setBackgroundDrawable(new NinePatchDrawable(bitmapLoadAssetsFile, ninePatchChunk, new Rect(), null));
        this.f6993m.addView(this.f6996p);
        addView(this.f6993m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "");
            setMapCustomStyleEnable(true);
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (TextUtils.isEmpty(localCustomStyleFilePath)) {
            return;
        }
        a(localCustomStyleFilePath, "");
        setMapCustomStyleEnable(true);
    }

    private boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public TextureMapView(Context context, AttributeSet attributeSet) throws IOException {
        super(context, attributeSet);
        this.f6998r = new Object();
        this.f6999s = false;
        this.f7000t = new a();
        this.f7002v = LogoPosition.logoPostionleftBottom.ordinal();
        this.f7003w = true;
        this.f7004x = true;
        this.f6985E = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) throws IOException {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        setBackgroundColor(-1);
        this.f6997q = context;
        com.baidu.mapsdkplatform.comapi.map.e.c();
        BMapManager.init();
        if (SysOSUtil.getAuthToken() != null) {
            synchronized (this.f6998r) {
                h.b().a(SysOSUtil.getAuthToken(), com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace.a());
                this.f6999s = false;
            }
        } else {
            BMapManagerInternal.getInstance().setMapAuthListener(this.f7000t);
            PermissionCheck.permissionCheck();
        }
        a(context, baiduMapOptions, f6977b, f6979d);
        a(context);
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6256h) {
            this.f6990j.setVisibility(4);
        }
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6257i) {
            this.f6993m.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.f6258j) != null) {
            this.f7002v = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.f6260l) != null) {
            this.f6992l = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.f6259k) != null) {
            this.f6991k = point;
        }
        d();
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i4) throws IOException {
        super(context, attributeSet, i4);
        this.f6998r = new Object();
        this.f6999s = false;
        this.f7000t = new a();
        this.f7002v = LogoPosition.logoPostionleftBottom.ordinal();
        this.f7003w = true;
        this.f7004x = true;
        this.f6985E = false;
        a(context, (BaiduMapOptions) null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) throws IOException {
        super(context);
        this.f6998r = new Object();
        this.f6999s = false;
        this.f7000t = new a();
        this.f7002v = LogoPosition.logoPostionleftBottom.ordinal();
        this.f7003w = true;
        this.f7004x = true;
        this.f6985E = false;
        a(context, baiduMapOptions);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i4) {
        MapTextureView mapTextureView = new MapTextureView(context);
        this.f6986f = mapTextureView;
        addView(mapTextureView);
        if (baiduMapOptions != null) {
            this.f6987g = new BaiduMap(context, this.f6986f, baiduMapOptions.a());
        } else {
            this.f6987g = new BaiduMap(context, this.f6986f, (q) null);
        }
        this.f6986f.getBaseMap().a(new c());
    }

    private void a(Context context) throws IOException {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.f6989i = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.f6989i = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix2, true);
        } else {
            this.f6989i = bitmapLoadAssetsFile;
        }
        if (this.f6989i != null) {
            ImageView imageView = new ImageView(context);
            this.f6988h = imageView;
            imageView.setImageBitmap(this.f6989i);
            addView(this.f6988h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        y yVar = this.f6990j;
        if (yVar == null || !yVar.c()) {
            return;
        }
        float f4 = this.f6986f.getBaseMap().y().f8099a;
        this.f6990j.setIsZoomOutEnabled(f4 > this.f6986f.getBaseMap().f8003e);
        this.f6990j.setIsZoomInEnabled(f4 < this.f6986f.getBaseMap().f8002d);
    }

    private void a(View view) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i4 = layoutParams.width;
        if (i4 > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        int i5 = layoutParams.height;
        if (i5 > 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapTextureView mapTextureView = this.f6986f;
        if (mapTextureView == null || mapTextureView.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f6976a, "customStyleFilePath is empty or null, please check!");
            return;
        }
        if (!str.endsWith(".sty")) {
            Log.e(f6976a, "customStyleFile format is incorrect , please check!");
        } else if (!new File(str).exists()) {
            Log.e(f6976a, "customStyleFile does not exist , please check!");
        } else {
            this.f6986f.getBaseMap().a(str, str2);
        }
    }
}
