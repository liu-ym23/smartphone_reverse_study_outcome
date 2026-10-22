package com.android.ttcjpaysdk.integrated.counter.utils;

import android.app.Activity;
import android.view.OrientationEventListener;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayScreenOrientationUtil;", "", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "onRequestedOrientationListener", "Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayScreenOrientationUtil$OnRequestedOrientationListener;", "orEventListener", "Landroid/view/OrientationEventListener;", "orientation", "", "screenOrientationType", "convert2Orientation", "", "rotation", "getOrientation", "initListener", "setOnRequestedOrientationListener", "listener", "setScreenOrientationType", "start", "activity", "Companion", "OnRequestedOrientationListener", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayScreenOrientationUtil {
    public static final Companion Companion = null;
    public static final CJPayScreenOrientationUtil instance = null;
    private WeakReference<Activity> activityRef;
    private OnRequestedOrientationListener onRequestedOrientationListener;
    private OrientationEventListener orEventListener;
    private int orientation;
    private int screenOrientationType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayScreenOrientationUtil$Companion;", "", "()V", "instance", "Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayScreenOrientationUtil;", "getInstance", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final CJPayScreenOrientationUtil getInstance() {
            return CJPayScreenOrientationUtil.instance;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayScreenOrientationUtil$OnRequestedOrientationListener;", "", "onRequestedOrientationSet", "", "orientation", "", "onScreenOrientationRotation", "rotation", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnRequestedOrientationListener {
        void onRequestedOrientationSet(int r100);

        void onScreenOrientationRotation(int r100);
    }

    @JvmStatic
    public static final CJPayScreenOrientationUtil getInstance() {
        return Companion.getInstance();
    }

    static {
        Companion = new Companion(null);
        instance = new CJPayScreenOrientationUtil();
    }

    private final void initListener() {
        WeakReference<Activity> r100 = this.activityRef;
        if (r100 == null) goto L5;
        Activity r101 = r100.get();
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        WeakReference<Activity> r102 = this.activityRef;
        Intrinsics.checkNotNull(r102);
        final Activity r103 = r102.get();
        this.orEventListener = new AnonymousClass1(this, r103);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public CJPayScreenOrientationUtil() {
        this.orientation = 1;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void convert2Orientation(int r100) {
        OnRequestedOrientationListener r101 = this.onRequestedOrientationListener;
        if (r101 == null) goto L6;
        r101.onScreenOrientationRotation(r100);
    L6:
        if (this.screenOrientationType == 2) goto L9;
        return;
    L9:
        if (r100 < 0) goto L12;
        if (r100 >= 46) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L88;
        if (r100 > 315) goto L88;
        if (46 > r100) goto L21;
        if (r100 >= 136) goto L21;
        boolean r103 = true;
    L22:
        if (r103 == false) goto L33;
        if (this.orientation == 8) goto L97;
        this.orientation = 8;
        WeakReference<Activity> r104 = this.activityRef;
        if (r104 == null) goto L98;
        Activity r105 = r104.get();
        if (r105 == null) goto L99;
        r105.setRequestedOrientation(this.orientation);
        OnRequestedOrientationListener r106 = this.onRequestedOrientationListener;
        if (r106 == null) goto L100;
        r106.onRequestedOrientationSet(this.orientation);
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    L33:
        if (136 > r100) goto L36;
        if (r100 >= 226) goto L36;
        boolean r107 = true;
    L37:
        if (r107 == true) goto L39;
        if (226 <= r100) goto L49;
    L51:
        boolean r108 = false;
    L52:
        if (r108 == false) goto L63;
        if (this.orientation == 0) goto L107;
        this.orientation = 0;
        WeakReference<Activity> r109 = this.activityRef;
        if (r109 == null) goto L108;
        Activity r110 = r109.get();
        if (r110 == null) goto L109;
        r110.setRequestedOrientation(this.orientation);
        OnRequestedOrientationListener r111 = this.onRequestedOrientationListener;
        if (r111 == null) goto L110;
        r111.onRequestedOrientationSet(this.orientation);
        return;
    L110:
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L63:
        if (r100 != (-1)) goto L79;
        WeakReference<Activity> r112 = this.activityRef;
        if (r112 == null) goto L112;
        Activity r113 = r112.get();
        if (r113 != null) goto L69;
        return;
    L69:
        if (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r113) >= CJPayBasicUtils.getScreenHeight(r113)) goto L71;
        this.orientation = 1;
        r113.setRequestedOrientation(1);
        OnRequestedOrientationListener r114 = this.onRequestedOrientationListener;
        if (r114 == null) goto L117;
        r114.onRequestedOrientationSet(this.orientation);
        return;
    L117:
        return;
    L71:
        if (this.orientation != 1) goto L114;
        this.orientation = 0;
        r113.setRequestedOrientation(0);
        OnRequestedOrientationListener r115 = this.onRequestedOrientationListener;
        if (r115 == null) goto L115;
        r115.onRequestedOrientationSet(this.orientation);
        return;
    L115:
        return;
    L114:
        return;
    L112:
        return;
    L79:
        if (this.orientation == 1) goto L119;
        this.orientation = 1;
        WeakReference<Activity> r116 = this.activityRef;
        if (r116 == null) goto L120;
        Activity r117 = r116.get();
        if (r117 == null) goto L121;
        r117.setRequestedOrientation(this.orientation);
        OnRequestedOrientationListener r118 = this.onRequestedOrientationListener;
        if (r118 == null) goto L122;
        r118.onRequestedOrientationSet(this.orientation);
        return;
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L49:
        if (r100 >= 316) goto L51;
        r108 = true;
        goto L52
    L39:
        if (this.orientation == 9) goto L102;
        this.orientation = 9;
        WeakReference<Activity> r119 = this.activityRef;
        if (r119 == null) goto L103;
        Activity r120 = r119.get();
        if (r120 == null) goto L104;
        r120.setRequestedOrientation(this.orientation);
        OnRequestedOrientationListener r121 = this.onRequestedOrientationListener;
        if (r121 == null) goto L105;
        r121.onRequestedOrientationSet(this.orientation);
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L36:
        r107 = false;
    L21:
        r103 = false;
    L88:
        if (this.orientation == 1) goto L124;
        this.orientation = 1;
        WeakReference<Activity> r122 = this.activityRef;
        if (r122 == null) goto L125;
        Activity r123 = r122.get();
        if (r123 == null) goto L126;
        r123.setRequestedOrientation(this.orientation);
        OnRequestedOrientationListener r124 = this.onRequestedOrientationListener;
        if (r124 == null) goto L127;
        r124.onRequestedOrientationSet(this.orientation);
        return;
    L127:
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L12:
        r102 = false;
        goto L13
    }

    public final void setOnRequestedOrientationListener(OnRequestedOrientationListener r100) {
        this.onRequestedOrientationListener = r100;
    }

    public final void setScreenOrientationType(int r100) {
        this.screenOrientationType = r100;
    }

    public final void start(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.activityRef = new WeakReference(r100);
        if (this.orEventListener != null) goto L5;
        initListener();
    L5:
        OrientationEventListener r101 = this.orEventListener;
        if (r101 == null) goto L9;
        r101.enable();
        return;
    }
}
