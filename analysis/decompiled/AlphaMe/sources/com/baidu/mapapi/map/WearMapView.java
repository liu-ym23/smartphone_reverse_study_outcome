package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import com.baidu.mapsdkplatform.comapi.map.c;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.y;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.v;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.app.AppStateEngine;
import com.stepos.alphame.utils.Property;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.opengles.GL10;
import kotlin.time.DurationKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

@TargetApi(20)
/* loaded from: classes.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;

    /* renamed from: a, reason: collision with root package name */
    private static final String f7078a = "MapView";

    /* renamed from: b, reason: collision with root package name */
    private static String f7079b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f7080c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static int f7081d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f7082e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static int f7083f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f7084g = 10;

    /* renamed from: h, reason: collision with root package name */
    private static final SparseArray<Integer> f7085h;

    /* renamed from: A, reason: collision with root package name */
    private float f7086A;

    /* renamed from: B, reason: collision with root package name */
    private int f7087B;

    /* renamed from: C, reason: collision with root package name */
    private int f7088C;

    /* renamed from: D, reason: collision with root package name */
    private int f7089D;

    /* renamed from: E, reason: collision with root package name */
    private int f7090E;

    /* renamed from: F, reason: collision with root package name */
    private int f7091F;

    /* renamed from: G, reason: collision with root package name */
    private int f7092G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f7093H;

    /* renamed from: i, reason: collision with root package name */
    private MapSurfaceView f7094i;

    /* renamed from: j, reason: collision with root package name */
    private BaiduMap f7095j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f7096k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f7097l;

    /* renamed from: m, reason: collision with root package name */
    private y f7098m;
    public AnimationTask mTask;
    public Timer mTimer;
    public f mTimerHandler;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7099n;

    /* renamed from: o, reason: collision with root package name */
    private Point f7100o;

    /* renamed from: p, reason: collision with root package name */
    private Point f7101p;

    /* renamed from: q, reason: collision with root package name */
    private RelativeLayout f7102q;

    /* renamed from: r, reason: collision with root package name */
    private SwipeDismissView f7103r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f7104s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f7105t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f7106u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7107v;

    /* renamed from: w, reason: collision with root package name */
    private Context f7108w;

    /* renamed from: x, reason: collision with root package name */
    ScreenShape f7109x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f7110y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7111z;

    public class AnimationTask extends TimerTask {
        public AnimationTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            WearMapView.this.mTimerHandler.sendMessage(message);
        }
    }

    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    public enum ScreenShape {
        ROUND,
        RECTANGLE,
        UNDETECTED
    }

    public class a implements c.InterfaceC0029c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomMapStyleCallBack f7114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MapCustomStyleOptions f7115b;

        public a(CustomMapStyleCallBack customMapStyleCallBack, MapCustomStyleOptions mapCustomStyleOptions) {
            this.f7114a = customMapStyleCallBack;
            this.f7115b = mapCustomStyleOptions;
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onCustomMapStyleLoadFailed(int i4, String str, String str2) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f7114a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadFailed(i4, str, str2)) && !WearMapView.this.f7093H) {
                WearMapView.this.a(str2, this.f7115b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onCustomMapStyleLoadSuccess(boolean z4, String str) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f7114a;
            if ((customMapStyleCallBack == null || !customMapStyleCallBack.onCustomMapStyleLoadSuccess(z4, str)) && !TextUtils.isEmpty(str)) {
                WearMapView.this.a(str, "");
                WearMapView.this.setMapCustomStyleEnable(true);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.c.InterfaceC0029c
        public void onPreLoadLastCustomMapStyle(String str) {
            CustomMapStyleCallBack customMapStyleCallBack = this.f7114a;
            if (customMapStyleCallBack == null || !customMapStyleCallBack.onPreLoadLastCustomMapStyle(str)) {
                WearMapView.this.f7093H = true;
                WearMapView.this.a(str, this.f7115b);
            }
        }
    }

    public class b implements v {
        public b() {
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
            String str;
            if (WearMapView.this.f7094i == null || WearMapView.this.f7094i.getBaseMap() == null) {
                return;
            }
            float zoomLevel = WearMapView.this.f7094i.getZoomLevel();
            if (zoomLevel < WearMapView.this.f7094i.getController().mMinZoomLevel) {
                zoomLevel = WearMapView.this.f7094i.getController().mMinZoomLevel;
            } else if (zoomLevel > WearMapView.this.f7094i.getController().mMaxZoomLevel) {
                zoomLevel = WearMapView.this.f7094i.getController().mMaxZoomLevel;
            }
            if (Math.abs(WearMapView.this.f7086A - zoomLevel) > Property.DEFAULT_FLOAT_VALUE) {
                Integer num = (Integer) WearMapView.f7085h.get(Math.round(zoomLevel));
                int iIntValue = num.intValue();
                int zoomUnitsInMeter = ((int) (iIntValue / WearMapView.this.f7094i.getController().getZoomUnitsInMeter())) / 2;
                WearMapView.this.f7106u.setPadding(zoomUnitsInMeter, 0, zoomUnitsInMeter, 0);
                if (iIntValue >= 1000) {
                    str = String.format(" %d公里 ", Integer.valueOf(iIntValue / 1000));
                } else {
                    str = String.format(" %d米 ", num);
                }
                WearMapView.this.f7104s.setText(str);
                WearMapView.this.f7105t.setText(str);
                WearMapView.this.f7086A = zoomLevel;
            }
            WearMapView.this.requestLayout();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s sVarY = WearMapView.this.f7094i.getBaseMap().y();
            sVarY.f8099a -= 1.0f;
            WearMapView.this.f7094i.getBaseMap().a(sVarY, UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s sVarY = WearMapView.this.f7094i.getBaseMap().y();
            sVarY.f8099a += 1.0f;
            WearMapView.this.f7094i.getBaseMap().a(sVarY, UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7120a;

        public e(View view) {
            this.f7120a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7120a.setVisibility(4);
            super.onAnimationEnd(animator);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f7122a;

        public f(Context context) {
            this.f7122a = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f7122a.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && WearMapView.this.f7098m != null) {
                WearMapView.this.a(true);
            }
        }
    }

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f7085h = sparseArray;
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

    public WearMapView(Context context) throws IOException {
        super(context);
        this.f7099n = true;
        this.f7107v = true;
        this.f7109x = ScreenShape.ROUND;
        this.f7110y = true;
        this.f7111z = true;
        this.f7093H = false;
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
        f7079b = str;
    }

    @Deprecated
    public static void setIconCustom(int i4) {
        f7081d = i4;
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i4) {
        f7080c = i4;
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z4) {
    }

    private static void setScreenSize(Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public final BaiduMap getMap() {
        BaiduMap baiduMap = this.f7095j;
        baiduMap.f6203j0 = this;
        return baiduMap;
    }

    public final int getMapLevel() {
        return f7085h.get((int) this.f7094i.getZoomLevel()).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.f7091F;
    }

    public int getScaleControlViewWidth() {
        return this.f7092G;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (windowInsets.isRound()) {
            this.f7109x = ScreenShape.ROUND;
        } else {
            this.f7109x = ScreenShape.RECTANGLE;
        }
        return windowInsets;
    }

    public void onCreate(Context context, Bundle bundle) throws IOException {
        if (bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.f7100o != null) {
            this.f7100o = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.f7101p != null) {
            this.f7101p = (Point) bundle.getParcelable("zoomPosition");
        }
        this.f7110y = bundle.getBoolean("mZoomControlEnabled");
        this.f7111z = bundle.getBoolean("mScaleControlEnabled");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        if (this.f7108w != null) {
            this.f7094i.unInit();
        }
        Bitmap bitmap = this.f7097l;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7097l.recycle();
            this.f7097l = null;
        }
        this.f7098m.d();
        BMapManager.destroy();
        com.baidu.mapsdkplatform.comapi.map.e.a();
        AnimationTask animationTask = this.mTask;
        if (animationTask != null) {
            animationTask.cancel();
        }
        this.f7108w = null;
    }

    public final void onDismiss() {
        removeAllViews();
    }

    public final void onEnterAmbient(Bundle bundle) {
        a(0);
    }

    public void onExitAmbient() {
        a(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.mTimer = new Timer();
                AnimationTask animationTask = this.mTask;
                if (animationTask != null) {
                    animationTask.cancel();
                }
                AnimationTask animationTask2 = new AnimationTask();
                this.mTask = animationTask2;
                this.mTimer.schedule(animationTask2, 5000L);
            }
        } else if (this.f7098m.getVisibility() == 0) {
            Timer timer = this.mTimer;
            if (timer != null) {
                if (this.mTask != null) {
                    timer.cancel();
                    this.mTask.cancel();
                }
                this.mTimer = null;
                this.mTask = null;
            }
        } else if (this.f7098m.getVisibility() == 4) {
            if (this.mTimer != null) {
                AnimationTask animationTask3 = this.mTask;
                if (animationTask3 != null) {
                    animationTask3.cancel();
                }
                this.mTimer.cancel();
                this.mTask = null;
                this.mTimer = null;
            }
            a(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        float width;
        float height;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int childCount = getChildCount();
        a(this.f7096k);
        if (((getWidth() - this.f7087B) - this.f7088C) - this.f7096k.getMeasuredWidth() <= 0 || ((getHeight() - this.f7089D) - this.f7090E) - this.f7096k.getMeasuredHeight() <= 0) {
            this.f7087B = 0;
            this.f7088C = 0;
            this.f7090E = 0;
            this.f7089D = 0;
            width = 1.0f;
            height = 1.0f;
        } else {
            width = ((getWidth() - this.f7087B) - this.f7088C) / getWidth();
            height = ((getHeight() - this.f7089D) - this.f7090E) / getHeight();
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            View view = this.f7094i;
            if (childAt == view) {
                view.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.f7096k) {
                int i9 = (int) ((12.0f * height) + this.f7090E);
                if (this.f7109x == ScreenShape.ROUND) {
                    a(this.f7098m);
                    int i10 = f7082e / 2;
                    iA3 = a(i10, this.f7098m.getMeasuredWidth() / 2);
                    iA4 = ((f7082e / 2) - a(i10, i10 - iA3)) + f7084g;
                } else {
                    iA3 = 0;
                    iA4 = 0;
                }
                int i11 = (f7083f - iA3) - i9;
                int measuredHeight = i11 - this.f7096k.getMeasuredHeight();
                int i12 = f7082e - iA4;
                this.f7096k.layout(i12 - this.f7096k.getMeasuredWidth(), measuredHeight, i12, i11);
            } else {
                y yVar = this.f7098m;
                if (childAt == yVar) {
                    if (yVar.c()) {
                        a(this.f7098m);
                        Point point = this.f7101p;
                        if (point == null) {
                            int iA5 = (int) ((12.0f * height) + this.f7089D + (this.f7109x == ScreenShape.ROUND ? a(f7083f / 2, this.f7098m.getMeasuredWidth() / 2) : 0));
                            int measuredWidth = (f7082e - this.f7098m.getMeasuredWidth()) / 2;
                            this.f7098m.layout(measuredWidth, iA5, this.f7098m.getMeasuredWidth() + measuredWidth, this.f7098m.getMeasuredHeight() + iA5);
                        } else {
                            y yVar2 = this.f7098m;
                            int i13 = point.x;
                            yVar2.layout(i13, point.y, yVar2.getMeasuredWidth() + i13, this.f7098m.getMeasuredHeight() + this.f7101p.y);
                        }
                    }
                } else if (childAt == this.f7102q) {
                    if (this.f7109x == ScreenShape.ROUND) {
                        a(yVar);
                        int i14 = f7082e / 2;
                        iA = a(i14, this.f7098m.getMeasuredWidth() / 2);
                        iA2 = ((f7082e / 2) - a(i14, i14 - iA)) + f7084g;
                    } else {
                        iA = 0;
                        iA2 = 0;
                    }
                    a(this.f7102q);
                    Point point2 = this.f7100o;
                    if (point2 == null) {
                        this.f7092G = this.f7102q.getMeasuredWidth();
                        this.f7091F = this.f7102q.getMeasuredHeight();
                        int i15 = (int) ((5.0f * width) + this.f7087B + iA2);
                        int i16 = (f7083f - ((int) ((12.0f * height) + this.f7090E))) - iA;
                        this.f7102q.layout(i15, i16 - this.f7102q.getMeasuredHeight(), this.f7092G + i15, i16);
                    } else {
                        RelativeLayout relativeLayout = this.f7102q;
                        int i17 = point2.x;
                        relativeLayout.layout(i17, point2.y, relativeLayout.getMeasuredWidth() + i17, this.f7102q.getMeasuredHeight() + this.f7100o.y);
                    }
                } else {
                    View view2 = this.f7103r;
                    if (childAt == view2) {
                        a(view2);
                        this.f7103r.layout(0, 0, this.f7103r.getMeasuredWidth(), f7083f);
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof MapViewLayoutParams) {
                            MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                            Point pointA = mapViewLayoutParams.f6585c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f6584b : this.f7094i.getBaseMap() != null ? this.f7094i.getBaseMap().a(CoordUtil.ll2mc(mapViewLayoutParams.f6583a)) : new Point();
                            a(childAt);
                            int measuredWidth2 = childAt.getMeasuredWidth();
                            int measuredHeight2 = childAt.getMeasuredHeight();
                            int i18 = (int) (pointA.x - (mapViewLayoutParams.f6586d * measuredWidth2));
                            int i19 = ((int) (pointA.y - (mapViewLayoutParams.f6587e * measuredHeight2))) + mapViewLayoutParams.f6588f;
                            childAt.layout(i18, i19, measuredWidth2 + i18, measuredHeight2 + i19);
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        if (bundle == null || (baiduMap = this.f7095j) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f7100o;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f7101p;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.f7110y);
        bundle.putBoolean("mScaleControlEnabled", this.f7111z);
        bundle.putInt("paddingLeft", this.f7087B);
        bundle.putInt("paddingTop", this.f7089D);
        bundle.putInt("paddingRight", this.f7088C);
        bundle.putInt("paddingBottom", this.f7090E);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view == this.f7096k) {
            return;
        }
        super.removeView(view);
    }

    public void setCustomStyleFilePathAndMode(String str, int i4) {
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        if (mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.c.a().a(this.f7108w, customMapStyleId, new a(customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath == null || localCustomStyleFilePath.isEmpty()) {
            return;
        }
        a(localCustomStyleFilePath, "");
    }

    public void setMapCustomStyleEnable(boolean z4) {
    }

    public void setMapCustomStylePath(String str) {
        a(str, "");
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.f7103r;
        if (swipeDismissView == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f7087B = i4;
        this.f7089D = i5;
        this.f7088C = i6;
        this.f7090E = i7;
    }

    public void setScaleControlPosition(Point point) {
        int i4;
        if (point != null && (i4 = point.x) >= 0 && point.y >= 0 && i4 <= getWidth() && point.y <= getHeight()) {
            this.f7100o = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.f7109x = screenShape;
    }

    public void setViewAnimitionEnable(boolean z4) {
        this.f7099n = z4;
    }

    public void setZoomControlsPosition(Point point) {
        int i4;
        if (point != null && (i4 = point.x) >= 0 && point.y >= 0 && i4 <= getWidth() && point.y <= getHeight()) {
            this.f7101p = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z4) {
        this.f7102q.setVisibility(z4 ? 0 : 8);
        this.f7111z = z4;
    }

    public void showZoomControls(boolean z4) {
        if (this.f7098m.c()) {
            this.f7098m.setVisibility(z4 ? 0 : 8);
            this.f7110y = z4;
        }
    }

    private void d(Context context) {
        y yVar = new y(context, true);
        this.f7098m = yVar;
        if (yVar.c()) {
            this.f7098m.setOnZoomOutClickListener(new c());
            this.f7098m.setOnZoomInClickListener(new d());
            addView(this.f7098m);
        }
    }

    private void e() {
        if (this.f7094i != null && this.f7107v) {
            b();
            this.f7107v = false;
        }
    }

    private void b(Context context) throws IOException {
        this.f7102q = new RelativeLayout(context);
        this.f7102q.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f7104s = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f7104s.setTextColor(Color.parseColor("#FFFFFF"));
        this.f7104s.setTextSize(2, 11.0f);
        TextView textView = this.f7104s;
        textView.setTypeface(textView.getTypeface(), 1);
        this.f7104s.setLayoutParams(layoutParams);
        this.f7104s.setId(Integer.MAX_VALUE);
        this.f7102q.addView(this.f7104s);
        this.f7105t = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(14);
        this.f7105t.setTextColor(Color.parseColor("#000000"));
        this.f7105t.setTextSize(2, 11.0f);
        this.f7105t.setLayoutParams(layoutParams2);
        this.f7102q.addView(this.f7105t);
        this.f7106u = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, this.f7104s.getId());
        this.f7106u.setLayoutParams(layoutParams3);
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", context);
        byte[] ninePatchChunk = bitmapLoadAssetsFile.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.f7106u.setBackgroundDrawable(new NinePatchDrawable(bitmapLoadAssetsFile, ninePatchChunk, new Rect(), null));
        this.f7102q.addView(this.f7106u);
        addView(this.f7102q);
    }

    private void c(Context context) {
        this.f7103r = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), f7083f);
        this.f7103r.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.f7103r.setLayoutParams(layoutParams);
        addView(this.f7103r);
    }

    private int a(int i4, int i5) {
        return i4 - ((int) Math.sqrt(Math.pow(i4, 2.0d) - Math.pow(i5, 2.0d)));
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

    private void d() {
        if (this.f7094i == null || this.f7107v) {
            return;
        }
        a();
        this.f7107v = true;
    }

    public WearMapView(Context context, AttributeSet attributeSet) throws IOException {
        super(context, attributeSet);
        this.f7099n = true;
        this.f7107v = true;
        this.f7109x = ScreenShape.ROUND;
        this.f7110y = true;
        this.f7111z = true;
        this.f7093H = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) throws IOException {
        Point point;
        Point point2;
        setScreenSize(context);
        setOnApplyWindowInsetsListener(this);
        this.f7108w = context;
        this.mTimerHandler = new f(context);
        this.mTimer = new Timer();
        AnimationTask animationTask = this.mTask;
        if (animationTask != null) {
            animationTask.cancel();
        }
        AnimationTask animationTask2 = new AnimationTask();
        this.mTask = animationTask2;
        this.mTimer.schedule(animationTask2, 5000L);
        com.baidu.mapsdkplatform.comapi.map.e.c();
        BMapManager.init();
        a(context, baiduMapOptions, f7079b);
        this.f7094i.getController().set3DGestureEnable(false);
        this.f7094i.getController().setOverlookGestureEnable(false);
        a(context);
        d(context);
        c(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6256h) {
            this.f7098m.setVisibility(4);
        }
        b(context);
        if (baiduMapOptions != null && !baiduMapOptions.f6257i) {
            this.f7102q.setVisibility(4);
        }
        if (baiduMapOptions != null && (point2 = baiduMapOptions.f6260l) != null) {
            this.f7101p = point2;
        }
        if (baiduMapOptions == null || (point = baiduMapOptions.f6259k) == null) {
            return;
        }
        this.f7100o = point;
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i4) throws IOException {
        super(context, attributeSet, i4);
        this.f7099n = true;
        this.f7107v = true;
        this.f7109x = ScreenShape.ROUND;
        this.f7110y = true;
        this.f7111z = true;
        this.f7093H = false;
        a(context, (BaiduMapOptions) null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) throws IOException {
        super(context);
        this.f7099n = true;
        this.f7107v = true;
        this.f7109x = ScreenShape.ROUND;
        this.f7110y = true;
        this.f7111z = true;
        this.f7093H = false;
        a(context, baiduMapOptions);
    }

    private void b() {
        MapSurfaceView mapSurfaceView = this.f7094i;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.onForeground();
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        MapSurfaceView mapSurfaceView = new MapSurfaceView(context);
        this.f7094i = mapSurfaceView;
        if (baiduMapOptions != null) {
            this.f7095j = new BaiduMap(context, mapSurfaceView, baiduMapOptions.a());
        } else {
            this.f7095j = new BaiduMap(context, mapSurfaceView, (q) null);
        }
        addView(this.f7094i);
        this.f7094i.getBaseMap().a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z4) {
        if (this.f7099n) {
            a(this.f7098m, z4);
        }
    }

    private void a(Context context) throws IOException {
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            Matrix matrix = new Matrix();
            matrix.postScale(2.0f, 2.0f);
            this.f7097l = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
        } else if (densityDpi > 320 && densityDpi <= 480) {
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.5f, 1.5f);
            this.f7097l = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix2, true);
        } else {
            this.f7097l = bitmapLoadAssetsFile;
        }
        if (this.f7097l != null) {
            ImageView imageView = new ImageView(context);
            this.f7096k = imageView;
            imageView.setImageBitmap(this.f7097l);
            addView(this.f7096k);
        }
    }

    private void a() {
        MapSurfaceView mapSurfaceView = this.f7094i;
        if (mapSurfaceView == null) {
            return;
        }
        mapSurfaceView.onBackground();
    }

    private void a(int i4) {
        MapSurfaceView mapSurfaceView = this.f7094i;
        if (mapSurfaceView == null) {
            return;
        }
        if (i4 == 0) {
            mapSurfaceView.onPause();
            d();
        } else {
            if (i4 != 1) {
                return;
            }
            mapSurfaceView.onResume();
            e();
        }
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

    private void a(View view, boolean z4) {
        if (z4) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", Property.DEFAULT_FLOAT_VALUE, -50.0f), ObjectAnimator.ofFloat(view, ViewTweenItem.ALPHA, 1.0f, Property.DEFAULT_FLOAT_VALUE));
            animatorSet.addListener(new e(view));
            animatorSet.setDuration(1200L);
            animatorSet.start();
            return;
        }
        view.setVisibility(0);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", -50.0f, Property.DEFAULT_FLOAT_VALUE), ObjectAnimator.ofFloat(view, ViewTweenItem.ALPHA, Property.DEFAULT_FLOAT_VALUE, 1.0f));
        animatorSet2.setDuration(1200L);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView = this.f7094i;
        if (mapSurfaceView == null || mapSurfaceView.getBaseMap() == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f7078a, "customStyleFilePath is empty or null, please check!");
            return;
        }
        if (!str.endsWith(".sty")) {
            Log.e(f7078a, "customStyleFile format is incorrect , please check!");
        } else if (!new File(str).exists()) {
            Log.e(f7078a, "customStyleFile does not exist , please check!");
        } else {
            this.f7094i.getBaseMap().a(str, "");
        }
    }
}
