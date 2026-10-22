package com.bytedance.android.livesdk.player.monitor;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class ScreenJumpRenderChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f155810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f155811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScreenJumpRenderChecker$onSceneChanged$1 f155812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f155813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePlayerClient f155814e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f155815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<IRenderView> f155816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f155817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f155818d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f155819e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f155820f;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Rect f155821a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Rect f155822b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Point f155823c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final PointF f155824d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f155825e;

            public final String toString() {
                return "Location(onScreenRect=" + this.f155821a.toShortString() + ", onParentRect=" + this.f155822b.toShortString() + ", translation=" + this.f155823c + ", scale=" + this.f155824d + ", orientation=" + this.f155825e + ')';
            }

            public a() {
                this.f155821a = new Rect(0, 0, 0, 0);
                this.f155822b = new Rect(0, 0, 0, 0);
                this.f155823c = new Point(0, 0);
                this.f155824d = new PointF(0.0f, 0.0f);
                this.f155825e = 1;
            }
        }

        public final void a() {
            a r100 = this.f155817c;
            r100.f155821a.setEmpty();
            r100.f155822b.setEmpty();
            r100.f155823c.set(0, 0);
            r100.f155824d.set(0.0f, 0.0f);
            r100.f155825e = 1;
            this.f155815a = "0";
            this.f155819e = false;
            this.f155816b = null;
        }

        public final int b() {
            int r100 = this.f155817c.f155821a.left;
            b r101 = this.f155818d;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("other");
        L5:
            int r102 = Math.abs(r100 - r101.f155817c.f155821a.left);
            int r103 = this.f155817c.f155821a.top;
            b r104 = this.f155818d;
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("other");
        L8:
            int r105 = Math.abs(r103 - r104.f155817c.f155821a.top);
            int r106 = this.f155817c.f155821a.right;
            b r107 = this.f155818d;
            if (r107 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("other");
        L11:
            int r108 = Math.abs(r106 - r107.f155817c.f155821a.right);
            int r109 = this.f155817c.f155821a.bottom;
            b r110 = this.f155818d;
            if (r110 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("other");
        L14:
            int r111 = Math.abs(r109 - r110.f155817c.f155821a.bottom);
            return RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r102, r105), r108), r111);
        }

        public final void update() {
            WeakReference<IRenderView> r100 = this.f155816b;
            if (r100 == null) goto L7;
            IRenderView r101 = r100.get();
            if (r101 == null) goto L7;
            r101.hashCode();
        L7:
            WeakReference<IRenderView> r102 = this.f155816b;
            if (r102 == null) goto L13;
            IRenderView r103 = r102.get();
            if (r103 == null) goto L14;
            c(r103);
            return;
        L14:
            return;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f155820f = r100;
            this.f155815a = "0";
            this.f155817c = new a();
        }

        public final void c(IRenderView r100) {
            Intrinsics.checkNotNullParameter(r100, "renderView");
            this.f155816b = new WeakReference(r100);
            int[] r101 = {0, 0};
            r100.getSelfView().getLocationOnScreen(r101);
            int r102 = r101[0];
            int r103 = 1;
            int r104 = r101[1];
            int r105 = r100.getWidth();
            int r106 = r100.getHeight();
            if (r105 <= 0) goto L37;
            if (r106 <= 0) goto L38;
            Rect r107 = new Rect(r102, r104, r105 + r102, r106 + r104);
            View r108 = r100.getSelfView();
            int r109 = -1;
            if (r108 == null) goto L15;
            Context r110 = r108.getContext();
            if (r110 == null) goto L15;
            Resources r111 = r110.getResources();
            if (r111 == null) goto L15;
            DisplayMetrics r112 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics());
            if (r112 == null) goto L15;
            int r113 = r112.widthPixels;
        L16:
            View r114 = r100.getSelfView();
            if (r114 == null) goto L26;
            Context r115 = r114.getContext();
            if (r115 == null) goto L26;
            Resources r116 = r115.getResources();
            if (r116 == null) goto L26;
            DisplayMetrics r117 = WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics());
            if (r117 == null) goto L26;
            r109 = r117.heightPixels;
        L26:
            if (new Rect(0, 0, r113, r109).intersect(r107) == true) goto L28;
            return;
        L28:
            this.f155817c.f155821a.set(r107);
            this.f155817c.f155822b.set(r100.getSelfView().getLeft(), r100.getSelfView().getTop(), r100.getSelfView().getRight(), r100.getSelfView().getBottom());
            this.f155817c.f155823c.set((int) r100.getSelfView().getTranslationX(), (int) r100.getSelfView().getTranslationY());
            this.f155817c.f155824d.set(r100.getSelfView().getScaleX(), r100.getSelfView().getScaleY());
            a r118 = this.f155817c;
            Context r119 = r100.getContext();
            if (r119 == null) goto L35;
            Resources r120 = r119.getResources();
            if (r120 == null) goto L35;
            Configuration r121 = r120.getConfiguration();
            if (r121 == null) goto L35;
            r103 = r121.orientation;
        L35:
            r118.f155825e = r103;
            Objects.toString(this.f155817c);
            return;
        L15:
            r113 = -1;
            goto L16
        L38:
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedDeque<String> f155826a;

        public c() {
            this.f155826a = new ConcurrentLinkedDeque();
        }
    }

    static {
    }

    public ScreenJumpRenderChecker(LivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155814e = r100;
        this.f155810a = LazyKt.lazy(ScreenJumpRenderChecker$renderConfig$2.INSTANCE);
        LinkedHashMap r101 = new LinkedHashMap();
        this.f155811b = r101;
        LivePlayerScene r102 = LivePlayerScene.INSTANCE;
        b r103 = new b(r102.getFEED_PREVIEW().getScene());
        b r104 = new b(r102.getINNER_DRAW().getScene());
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f155818d = r104;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r104.f155818d = r103;
        r101.put(r102.getFEED_PREVIEW().getScene(), r103);
        r101.put(r102.getINNER_DRAW().getScene(), r104);
        this.f155812c = new ScreenJumpRenderChecker$onSceneChanged$1(this);
        this.f155813d = new c();
    }
}
