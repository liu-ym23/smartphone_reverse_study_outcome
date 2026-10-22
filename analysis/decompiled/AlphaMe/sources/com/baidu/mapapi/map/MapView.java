package com.baidu.mapapi.map;

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
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
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
import com.baidu.platform.comapi.map.MapSurfaceView;
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
public final class MapView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6543a = "MapView";

    /* renamed from: b, reason: collision with root package name */
    private static String f6544b;

    /* renamed from: c, reason: collision with root package name */
    private static int f6545c;

    /* renamed from: d, reason: collision with root package name */
    private static int f6546d;

    /* renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f6547e;

    /* renamed from: A, reason: collision with root package name */
    private int f6548A;

    /* renamed from: B, reason: collision with root package name */
    private int f6549B;

    /* renamed from: C, reason: collision with root package name */
    private int f6550C;

    /* renamed from: D, reason: collision with root package name */
    private int f6551D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f6552E;

    /* renamed from: f, reason: collision with root package name */
    private MapSurfaceView f6553f;

    /* renamed from: g, reason: collision with root package name */
    private BaiduMap f6554g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f6555h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f6556i;

    /* renamed from: j, reason: collision with root package name */
    private y f6557j;

    /* renamed from: k, reason: collision with root package name */
    private Point f6558k;

    /* renamed from: l, reason: collision with root package name */
    private Point f6559l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f6560m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f6561n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f6562o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f6563p;

    /* renamed from: q, reason: collision with root package name */
    private Context f6564q;

    /* renamed from: r, reason: collision with root package name */
    private final Object f6565r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6566s;

    /* renamed from: t, reason: collision with root package name */
    private MapAuthListener f6567t;

    /* renamed from: u, reason: collision with root package name */
    private int f6568u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6569v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f6570w;

    /* renamed from: x, reason: collision with root package name */
    private float f6571x;

    /* renamed from: y, reason: collision with root package name */
    private int f6572y;

    /* renamed from: z, reason: collision with root package name */
    private int f6573z;

    public class a implements MapAuthListener {
        public a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.MapAuthListener
        public void setAuthParam(String str) {
            synchronized (MapView.this.f6565r) {
                try {
                    if (MapView.this.f6566s) {
                        return;
                    }
                    if (str != null) {
                        h.b().a(str, com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace.a());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class b implements c.InterfaceC0029c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomMapStyleCallBack f6575a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapCustomStyleOptions f6576b;

        public b(CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
            this.f6575a = customMapStyleCallBack;
            this.f6576b = mapCustomStyleOptions;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onCustomMapStyleLoadFailed(int i4, String str, String str2) {
            HashMap map = new HashMap();
            map.put("O", "local");
            map.put(ExifInterface.LONGITUDE_EAST, "0");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "CS", "0", map);
            CustomMapStyleCallBack customMapStyleCallBack = this.f6575a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadFailed(i4, str, str2)) && !MapView.this.f6552E) {
                MapView.this.a(str2, this.f6576b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onCustomMapStyleLoadSuccess(boolean z4, String str) {
            HashMap map = new HashMap();
            map.put("O", "online");
            map.put(ExifInterface.LONGITUDE_EAST, "1");
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "CS", "0", map);
            CustomMapStyleCallBack customMapStyleCallBack = this.f6575a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadSuccess(z4, str)) && z4 && !TextUtils.isEmpty(str)) {
                MapView.this.a(str, "");
                MapView.this.setMapCustomStyleEnable(true);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onPreLoadLastCustomMapStyle(String str) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f6575a;
            if (customMapStyleCallBack == null || !customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
                MapView.this.a(str, this.f6576b);
                MapView.this.f6552E = true;
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
            if (MapView.this.f6553f == null || MapView.this.f6553f.getController() == null) {
                return;
            }
            float zoomLevel = MapView.this.f6553f.getZoomLevel();
            if (zoomLevel < MapView.this.f6553f.getController().mMinZoomLevel) {
                zoomLevel = MapView.this.f6553f.getController().mMinZoomLevel;
            } else if (zoomLevel > MapView.this.f6553f.getController().mMaxZoomLevel) {
                zoomLevel = MapView.this.f6553f.getController().mMaxZoomLevel;
            }
            if (Math.abs(MapView.this.f6571x - zoomLevel) > Property.DEFAULT_FLOAT_VALUE) {
                MapView.this.updateScaleUI(zoomLevel);
            }
            MapView.this.a();
            MapView.this.requestLayout();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            float zoomLevel = MapView.this.f6553f.getZoomLevel();
            float fFloor = zoomLevel - 1.0f;
            double d4 = zoomLevel;
            if (Math.floor(d4) != d4) {
                fFloor = (float) Math.floor(d4);
            }
            if (MapView.this.f6553f.getController() == null) {
                return;
            }
            float fMax = Math.max(fFloor, MapView.this.f6553f.getController().mMinZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            MapView.this.f6553f.setZoomLevel(fMax);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            float zoomLevel = MapView.this.f6553f.getZoomLevel();
            float fCeil = 1.0f + zoomLevel;
            double d4 = zoomLevel;
            if (((int) Math.ceil(d4)) != ((int) zoomLevel)) {
                fCeil = (float) Math.ceil(d4);
            }
            if (MapView.this.f6553f.getController() == null) {
                return;
            }
            float fMin = Math.min(fCeil, MapView.this.f6553f.getController().mMaxZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            MapView.this.f6553f.setZoomLevel(fMin);
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6581a;

        public f(View view) {
            this.f6581a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            MapView.this.removeView(this.f6581a);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6547e = sparseIntArray;
        sparseIntArray.append(3, 2000000);
        sparseIntArray.append(4, DurationKt.NANOS_IN_MILLIS);
        sparseIntArray.append(5, 500000);
        sparseIntArray.append(6, 200000);
        sparseIntArray.append(7, ComplexPt.TEN_THOUSAND);
        sparseIntArray.append(8, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        sparseIntArray.append(9, AppStateEngine.QUICK_CHECK_TIME);
        sparseIntArray.append(10, 20000);
        sparseIntArray.append(11, 10000);
        sparseIntArray.append(12, 5000);
        sparseIntArray.append(13, 2000);
        sparseIntArray.append(14, 1000);
        sparseIntArray.append(15, 500);
        sparseIntArray.append(16, 200);
        sparseIntArray.append(17, 100);
        sparseIntArray.append(18, 50);
        sparseIntArray.append(19, 20);
        sparseIntArray.append(20, 10);
        sparseIntArray.append(21, 5);
        sparseIntArray.append(22, 2);
        sparseIntArray.append(23, 2);
        sparseIntArray.append(24, 2);
        sparseIntArray.append(25, 2);
        sparseIntArray.append(26, 2);
    }

    public MapView(Context context) throws IOException {
        super(context);
        this.f6565r = new Object();
        this.f6566s = false;
        this.f6567t = new a();
        this.f6568u = LogoPosition.logoPostionleftBottom.ordinal();
        this.f6569v = true;
        this.f6570w = true;
        this.f6552E = false;
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
        f6544b = str;
    }

    @Deprecated
    public static void setIconCustom(int i4) {
        f6546d = i4;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i4) {
        f6545c = i4;
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

    public void cancelRenderMap() {
    }

    public final LogoPosition getLogoPosition() {
        int i4 = this.f6568u;
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f6554g;
        baiduMap.f6199h0 = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return f6547e.get(Math.round(this.f6553f.getZoomLevel()));
    }

    public Point getScaleControlPosition() {
        return this.f6558k;
    }

    public int getScaleControlViewHeight() {
        return this.f6550C;
    }

    public int getScaleControlViewWidth() {
        return this.f6551D;
    }

    public Point getZoomControlsPosition() {
        return this.f6559l;
    }

    public boolean handleMultiTouch(float f4, float f5, float f6, float f7) {
        return false;
    }

    public void handleTouchDown(float f4, float f5) {
    }

    public boolean handleTouchMove(float f4, float f5) {
        return false;
    }

    public boolean handleTouchUp(float f4, float f5) {
        return false;
    }

    public boolean inRangeOfView(float f4, float f5) {
        MapSurfaceView mapSurfaceView = this.f6553f;
        return mapSurfaceView != null && mapSurfaceView.inRangeOfView(f4, f5);
    }

    public boolean isSetBackgroundDraw() {
        MapSurfaceView mapSurfaceView = this.f6553f;
        if (mapSurfaceView == null) {
            return false;
        }
        return mapSurfaceView.isSetBackgroundDraw();
    }

    public boolean isShowScaleControl() {
        return this.f6570w;
    }

    public void onCreate(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.f6558k != null) {
            this.f6558k = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.f6559l != null) {
            this.f6559l = (Point) bundle.getParcelable("zoomPosition");
        }
        this.f6569v = bundle.getBoolean("mZoomControlEnabled");
        this.f6570w = bundle.getBoolean("mScaleControlEnabled");
        this.f6568u = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
    }

    public final void onDestroy() {
        synchronized (this.f6565r) {
            try {
                BaiduMap baiduMap = this.f6554g;
                if (baiduMap != null) {
                    baiduMap.d();
                }
                h.a();
                this.f6566s = true;
                MapSurfaceView mapSurfaceView = this.f6553f;
                if (mapSurfaceView != null) {
                    mapSurfaceView.unInit();
                }
                Bitmap bitmap = this.f6556i;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f6556i.recycle();
                    this.f6556i = null;
                }
                if (f6544b != null) {
                    f6544b = null;
                }
                BMapManagerInternal.getInstance().removeMapAuthListener(this.f6567t);
                this.f6557j.d();
                BMapManager.destroy();
                com.baidu.mapsdkplatform.comapi.map.e.a();
                this.f6564q = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        float width;
        float height;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        int childCount = getChildCount();
        a(this.f6555h);
        if (((getWidth() - this.f6572y) - this.f6573z) - this.f6555h.getMeasuredWidth() <= 0 || ((getHeight() - this.f6548A) - this.f6549B) - this.f6555h.getMeasuredHeight() <= 0) {
            this.f6572y = 0;
            this.f6573z = 0;
            this.f6549B = 0;
            this.f6548A = 0;
            width = 1.0f;
            height = 1.0f;
        } else {
            width = ((getWidth() - this.f6572y) - this.f6573z) / getWidth();
            height = ((getHeight() - this.f6548A) - this.f6549B) / getHeight();
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != null) {
                MapSurfaceView mapSurfaceView = this.f6553f;
                if (childAt == mapSurfaceView) {
                    mapSurfaceView.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.f6555h;
                    if (childAt == imageView) {
                        float f4 = width * 5.0f;
                        int width2 = (int) (this.f6572y + f4);
                        int i9 = (int) (this.f6573z + f4);
                        float f5 = 5.0f * height;
                        int measuredHeight2 = (int) (this.f6548A + f5);
                        int i10 = (int) (this.f6549B + f5);
                        int i11 = this.f6568u;
                        if (i11 == 1) {
                            measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                            measuredWidth = this.f6555h.getMeasuredWidth() + width2;
                        } else if (i11 == 2) {
                            measuredHeight = getHeight() - i10;
                            measuredHeight2 = measuredHeight - this.f6555h.getMeasuredHeight();
                            width2 = (((getWidth() - this.f6555h.getMeasuredWidth()) + this.f6572y) - this.f6573z) / 2;
                            measuredWidth = (((this.f6555h.getMeasuredWidth() + getWidth()) + this.f6572y) - this.f6573z) / 2;
                        } else if (i11 != 3) {
                            if (i11 == 4) {
                                measuredHeight = getHeight() - i10;
                                measuredHeight2 = measuredHeight - this.f6555h.getMeasuredHeight();
                                measuredWidth = getWidth() - i9;
                                measuredWidth2 = this.f6555h.getMeasuredWidth();
                            } else if (i11 != 5) {
                                measuredHeight = getHeight() - i10;
                                measuredWidth = this.f6555h.getMeasuredWidth() + width2;
                                measuredHeight2 = measuredHeight - this.f6555h.getMeasuredHeight();
                            } else {
                                measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                                measuredWidth = getWidth() - i9;
                                measuredWidth2 = this.f6555h.getMeasuredWidth();
                            }
                            width2 = measuredWidth - measuredWidth2;
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + measuredHeight2;
                            width2 = (((getWidth() - this.f6555h.getMeasuredWidth()) + this.f6572y) - this.f6573z) / 2;
                            measuredWidth = (((this.f6555h.getMeasuredWidth() + getWidth()) + this.f6572y) - this.f6573z) / 2;
                        }
                        this.f6555h.layout(width2, measuredHeight2, measuredWidth, measuredHeight);
                    } else {
                        y yVar = this.f6557j;
                        if (childAt != yVar) {
                            RelativeLayout relativeLayout = this.f6560m;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point = this.f6558k;
                                if (point == null) {
                                    this.f6551D = this.f6560m.getMeasuredWidth();
                                    this.f6550C = this.f6560m.getMeasuredHeight();
                                    int i12 = (int) ((5.0f * width) + this.f6572y);
                                    int height2 = (getHeight() - ((int) (((height * 5.0f) + this.f6549B) + 56.0f))) - this.f6555h.getMeasuredHeight();
                                    this.f6560m.layout(i12, height2, this.f6551D + i12, this.f6550C + height2);
                                } else {
                                    RelativeLayout relativeLayout2 = this.f6560m;
                                    int i13 = point.x;
                                    relativeLayout2.layout(i13, point.y, relativeLayout2.getMeasuredWidth() + i13, this.f6560m.getMeasuredHeight() + this.f6558k.y);
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    Point pointA = mapViewLayoutParams.f6585c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6584b : this.f6553f.getBaseMap() != null ? this.f6553f.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.f6583a)) : new Point();
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
                            a(this.f6557j);
                            Point point2 = this.f6559l;
                            if (point2 == null) {
                                int height3 = (int) (((getHeight() - 15) * height) + this.f6548A);
                                int width3 = (int) (((getWidth() - 15) * width) + this.f6572y);
                                int measuredWidth4 = width3 - this.f6557j.getMeasuredWidth();
                                int measuredHeight4 = height3 - this.f6557j.getMeasuredHeight();
                                if (this.f6568u == 4) {
                                    height3 -= this.f6555h.getMeasuredHeight();
                                    measuredHeight4 -= this.f6555h.getMeasuredHeight();
                                }
                                this.f6557j.layout(measuredWidth4, measuredHeight4, width3, height3);
                            } else {
                                y yVar2 = this.f6557j;
                                int i16 = point2.x;
                                yVar2.layout(i16, point2.y, yVar2.getMeasuredWidth() + i16, this.f6557j.getMeasuredHeight() + this.f6559l.y);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.f6553f.onPause();
    }

    public final void onResume() {
        this.f6553f.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f6554g) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        bundle.putBoolean("mZoomControlEnabled", this.f6569v);
        bundle.putBoolean("mScaleControlEnabled", this.f6570w);
        bundle.putInt("logoPosition", this.f6568u);
        bundle.putInt("paddingLeft", this.f6572y);
        bundle.putInt("paddingTop", this.f6548A);
        bundle.putInt("paddingRight", this.f6573z);
        bundle.putInt("paddingBottom", this.f6549B);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f6555h) {
            return;
        }
        if (d()) {
            super.removeView(view);
        } else {
            MapTaskManager.postToMainThread(new f(view), 0L);
        }
    }

    public void renderMap() {
    }

    public void setCustomStyleFilePathAndMode(String str, int i4) {
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            this.f6568u = LogoPosition.logoPostionleftBottom.ordinal();
        } else {
            this.f6568u = logoPosition.ordinal();
        }
        requestLayout();
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.c.a().a(this.f6564q, customMapStyleId, new b(customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, "");
        setMapCustomStyleEnable(true);
    }

    public void setMapCustomStyleEnable(boolean z4) {
        MapSurfaceView mapSurfaceView = this.f6553f;
        if (mapSurfaceView == null || mapSurfaceView.getBaseMap() == null) {
            return;
        }
        this.f6553f.getBaseMap().r(z4);
    }

    public void setMapCustomStylePath(String str) {
        HashMap map = new HashMap();
        map.put("O", "local");
        map.put(ExifInterface.LONGITUDE_EAST, "1");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "CS", "0", map);
        a(str, "");
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f6572y = i4;
        this.f6548A = i5;
        this.f6573z = i6;
        this.f6549B = i7;
    }

    public void setScaleControlPosition(Point point) {
        int i4;
        if (point != null && (i4 = point.x) >= 0 && point.y >= 0 && i4 <= getWidth() && point.y <= getHeight()) {
            this.f6558k = point;
            requestLayout();
        }
    }

    public void setSupBackgroundDraw(boolean z4) {
        MapSurfaceView mapSurfaceView = this.f6553f;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.setSupBackgroundDraw(z4);
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.f6553f.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z4) {
        MapSurfaceView mapSurfaceView = this.f6553f;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.setZOrderMediaOverlay(z4);
    }

    public void setZoomControlsPosition(Point point) {
        int i4;
        if (point != null && (i4 = point.x) >= 0 && point.y >= 0 && i4 <= getWidth() && point.y <= getHeight()) {
            this.f6559l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z4) {
        this.f6560m.setVisibility(z4 ? 0 : 8);
        this.f6570w = z4;
    }

    public void showZoomControls(boolean z4) {
        if (this.f6557j.c()) {
            this.f6557j.setVisibility(z4 ? 0 : 8);
            this.f6569v = z4;
        }
    }

    public void updateScaleUI(float f4) {
        MapSurfaceView mapSurfaceView = this.f6553f;
        if (mapSurfaceView == null || mapSurfaceView.getController() == null) {
            return;
        }
        int i4 = f6547e.get(Math.round(f4));
        int zoomUnitsInMeter = (int) (i4 / this.f6553f.getController().getZoomUnitsInMeter());
        ImageView imageView = this.f6563p;
        if (imageView != null) {
            int i5 = zoomUnitsInMeter / 2;
            imageView.setPadding(i5, 0, i5, 0);
        }
        String str = i4 >= 1000 ? this.f6554g.getMapLanguage() == MapLanguage.ENGLISH ? String.format(" %dkm ", Integer.valueOf(i4 / 1000)) : String.format(" %d公里 ", Integer.valueOf(i4 / 1000)) : this.f6554g.getMapLanguage() == MapLanguage.ENGLISH ? String.format(" %dm ", Integer.valueOf(i4)) : String.format(" %d米 ", Integer.valueOf(i4));
        TextView textView = this.f6561n;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f6562o;
        if (textView2 != null) {
            textView2.setText(str);
        }
        this.f6571x = f4;
    }

    private void b() {
        this.f6554g.setMapLanguage(com.baidu.platform.comapi.c.b.c().b(), false);
    }

    private boolean c() throws ClassNotFoundException {
        try {
            Class.forName("com.baidu.bmfmap.map.FlutterMapView");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void e() {
        HashMap map = new HashMap();
        if (c()) {
            map.put(ExifInterface.GPS_DIRECTION_TRUE, "1");
        } else {
            map.put(ExifInterface.GPS_DIRECTION_TRUE, "0");
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel("B", "M", "0", map);
    }

    private void c(Context context) {
        y yVar = new y(context, false);
        this.f6557j = yVar;
        if (yVar.c()) {
            this.f6557j.setOnZoomOutClickListener(new d());
            this.f6557j.setOnZoomInClickListener(new e());
            addView(this.f6557j);
        }
    }

    private void b(Context context) throws IOException {
        this.f6560m = new RelativeLayout(context);
        this.f6560m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f6561n = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f6561n.setTextColor(Color.parseColor("#FFFFFF"));
        this.f6561n.setTextSize(2, 11.0f);
        TextView textView = this.f6561n;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f6561n.setLayoutParams(layoutParams);
        this.f6561n.setId(Integer.MAX_VALUE);
        this.f6560m.addView(this.f6561n);
        this.f6562o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.f6562o.setTextColor(Color.parseColor("#000000"));
        this.f6562o.setTextSize(2, 11.0f);
        this.f6562o.setLayoutParams(layoutParams2);
        this.f6560m.addView(this.f6562o);
        this.f6563p = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f6561n.getId());
        ImageView imageView = this.f6563p;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams3);
            Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", context);
            if (bitmapLoadAssetsFile != null) {
                byte[] ninePatchChunk = bitmapLoadAssetsFile.getNinePatchChunk();
                if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    this.f6563p.setBackgroundDrawable(new NinePatchDrawable(bitmapLoadAssetsFile, ninePatchChunk, new Rect(), null));
                }
            }
            this.f6560m.addView(this.f6563p);
        }
        addView(this.f6560m);
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

    public MapView(Context context, AttributeSet attributeSet) throws IOException {
        super(context, attributeSet);
        this.f6565r = new Object();
        this.f6566s = false;
        this.f6567t = new a();
        this.f6568u = LogoPosition.logoPostionleftBottom.ordinal();
        this.f6569v = true;
        this.f6570w = true;
        this.f6552E = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) throws IOException {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        this.f6564q = context;
        com.baidu.mapsdkplatform.comapi.map.e.c();
        BMapManager.init();
        if (SysOSUtil.getAuthToken() != null) {
            synchronized (this.f6565r) {
                h.b().a(SysOSUtil.getAuthToken(), com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace.a() | com.baidu.platform.comjni.base.sdkauth.a.WaterMark.a());
                this.f6566s = false;
            }
        } else {
            BMapManagerInternal.getInstance().setMapAuthListener(this.f6567t);
            PermissionCheck.permissionCheck();
        }
        a(context, baiduMapOptions, f6544b, f6545c);
        a(context);
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6256h) {
            this.f6557j.setVisibility(4);
        }
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6257i) {
            this.f6560m.setVisibility(4);
        }
        if (baiduMapOptions != null && (logoPosition = baiduMapOptions.f6258j) != null) {
            this.f6568u = logoPosition.ordinal();
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.f6260l) != null) {
            this.f6559l = point2;
        }
        if (baiduMapOptions != null && (point = baiduMapOptions.f6259k) != null) {
            this.f6558k = point;
        }
        e();
        b();
    }

    public MapView(Context context, AttributeSet attributeSet, int i4) throws IOException {
        super(context, attributeSet, i4);
        this.f6565r = new Object();
        this.f6566s = false;
        this.f6567t = new a();
        this.f6568u = LogoPosition.logoPostionleftBottom.ordinal();
        this.f6569v = true;
        this.f6570w = true;
        this.f6552E = false;
        a(context, (BaiduMapOptions) null);
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) throws IOException {
        super(context);
        this.f6565r = new Object();
        this.f6566s = false;
        this.f6567t = new a();
        this.f6568u = LogoPosition.logoPostionleftBottom.ordinal();
        this.f6569v = true;
        this.f6570w = true;
        this.f6552E = false;
        a(context, baiduMapOptions);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i4) {
        MapSurfaceView mapSurfaceView = new MapSurfaceView(context);
        this.f6553f = mapSurfaceView;
        if (baiduMapOptions != null) {
            this.f6554g = new BaiduMap(context, mapSurfaceView, baiduMapOptions.a());
        } else {
            this.f6554g = new BaiduMap(context, mapSurfaceView, (q) null);
        }
        addView(this.f6553f);
        c cVar = new c();
        if (this.f6553f.getBaseMap() != null) {
            this.f6553f.getBaseMap().a(cVar);
        }
    }

    private void a(Context context) throws IOException {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (bitmapLoadAssetsFile == null) {
            return;
        }
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.f6556i = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
        } else if (densityDpi > 320) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.f6556i = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix2, true);
        } else {
            this.f6556i = bitmapLoadAssetsFile;
        }
        if (this.f6556i != null) {
            ImageView imageView = new ImageView(context);
            this.f6555h = imageView;
            imageView.setImageBitmap(this.f6556i);
            addView(this.f6555h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        y yVar = this.f6557j;
        if (yVar == null || !yVar.c() || this.f6553f.getBaseMap() == null) {
            return;
        }
        float f4 = this.f6553f.getBaseMap().y().f8099a;
        this.f6557j.setIsZoomOutEnabled(f4 > this.f6553f.getBaseMap().f8003e);
        this.f6557j.setIsZoomInEnabled(f4 < this.f6553f.getBaseMap().f8002d);
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
        MapSurfaceView mapSurfaceView = this.f6553f;
        if (mapSurfaceView == null || mapSurfaceView.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f6543a, "customStyleFilePath is empty or null, please check!");
            return;
        }
        if (!str.endsWith(".sty")) {
            Log.e(f6543a, "customStyleFile format is incorrect , please check!");
        } else if (!new File(str).exists()) {
            Log.e(f6543a, "customStyleFile does not exist , please check!");
        } else {
            this.f6553f.getBaseMap().a(str, str2);
        }
    }
}
