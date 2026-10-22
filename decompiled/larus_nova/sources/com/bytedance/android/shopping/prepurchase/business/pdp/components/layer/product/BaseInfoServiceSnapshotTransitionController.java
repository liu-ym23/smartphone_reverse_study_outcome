package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class BaseInfoServiceSnapshotTransitionController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f181597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f181598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f181599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f181600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f181601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f181602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.a f181603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f181604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f181605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f181606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f181607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f181608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f181609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f181610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f181611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f181612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RecyclerView f181613q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ProductDetailInfoAdapter f181614r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final vg3.v f181615s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<Window> f181616t;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BitmapDrawable f181617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ColorDrawable f181618b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f181617a, r101.f181617a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f181618b, r101.f181618b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            BitmapDrawable r100 = this.f181617a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ColorDrawable r104 = this.f181618b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ActiveOverlay(snapshotDrawable=" + this.f181617a + ", whiteDrawable=" + this.f181618b + ")";
        }

        public a(BitmapDrawable r100, ColorDrawable r101) {
            Intrinsics.checkNotNullParameter(r100, "snapshotDrawable");
            Intrinsics.checkNotNullParameter(r101, "whiteDrawable");
            this.f181617a = r100;
            this.f181618b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.ecom.arch.slice.g f181619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.ecom.arch.slice.slices.a f181620b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f181619a, r101.f181619a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f181620b, r101.f181620b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.ecom.arch.slice.g r100 = this.f181619a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.ecom.arch.slice.slices.a r104 = this.f181620b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AttachedSlice(slice=" + this.f181619a + ", holder=" + this.f181620b + ")";
        }

        public b(com.bytedance.android.ecom.arch.slice.g r100, com.bytedance.android.ecom.arch.slice.slices.a r101) {
            Intrinsics.checkNotNullParameter(r100, "slice");
            Intrinsics.checkNotNullParameter(r101, "holder");
            this.f181619a = r100;
            this.f181620b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f181621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f181622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f181623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bitmap f181624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f181625e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L16;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f181621a, r101.f181621a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f181622b, r101.f181622b) == true) goto L10;
            return false;
        L10:
            if (this.f181623c == r101.f181623c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f181624d, r101.f181624d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f181625e, r101.f181625e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public final int hashCode() {
            RecyclerView r100 = this.f181621a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Rect r104 = this.f181622b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f181623c;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            int r109 = (r106 + r108) * 31;
            Bitmap r110 = this.f181624d;
            if (r110 == null) goto L16;
            int r111 = r110.hashCode();
        L17:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.f181625e;
            if (r113 == null) goto L21;
            r101 = r113.hashCode();
        L21:
            return r112 + r101;
        L16:
            r111 = 0;
            goto L17
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CachedSnapshot(host=" + this.f181621a + ", bounds=" + this.f181622b + ", isExpanded=" + this.f181623c + ", bitmap=" + this.f181624d + ", topFromHeaderBottom=" + this.f181625e + ")";
        }

        public c(RecyclerView r100, Rect r101, boolean r102, Bitmap r103, Integer r104) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "bounds");
            Intrinsics.checkNotNullParameter(r103, SimplayerImageStrategy.RESULT_BITMAP);
            this.f181621a = r100;
            this.f181622b = r101;
            this.f181623c = r102;
            this.f181624d = r103;
            this.f181625e = r104;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f181626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f181627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f181628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f181629d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L14;
            d r101 = (d) r100;
            if (this.f181626a == r101.f181626a) goto L8;
            return false;
        L8:
            if (this.f181627b == r101.f181627b) goto L10;
            return false;
        L10:
            if (this.f181628c == r101.f181628c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f181629d, r101.f181629d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r100 = ((this.f181626a * 31) + this.f181627b) * 31;
            boolean r101 = this.f181628c;
            ?? r102 = r101;
            if (r101 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = (r100 + r102) * 31;
            Rect r104 = this.f181629d;
            if (r104 == null) goto L8;
            int r105 = r104.hashCode();
        L10:
            return r103 + r105;
        L8:
            r105 = 0;
            goto L10
        }

        public final String toString() {
            return "PendingCapture(requestId=" + this.f181626a + ", generation=" + this.f181627b + ", isExpanded=" + this.f181628c + ", bounds=" + this.f181629d + ")";
        }

        public d(int r100, int r101, boolean r102, Rect r103) {
            Intrinsics.checkNotNullParameter(r103, "bounds");
            this.f181626a = r100;
            this.f181627b = r101;
            this.f181628c = r102;
            this.f181629d = r103;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewTreeObserver.OnPreDrawListener f181630a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f181630a, ((e) r100).f181630a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ViewTreeObserver.OnPreDrawListener r100 = this.f181630a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "PendingPreDraw(listener=" + this.f181630a + ")";
        }

        public e(h r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f181630a = r100;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f181631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f181632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f181633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f181634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f181635e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L16;
            f r101 = (f) r100;
            if (this.f181631a == r101.f181631a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f181632b, r101.f181632b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f181633c, r101.f181633c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f181634d, r101.f181634d) == true) goto L14;
            return false;
        L14:
            if (Float.compare(this.f181635e, r101.f181635e) == 0) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public final int hashCode() {
            boolean r100 = this.f181631a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = r101 * 31;
            Rect r103 = this.f181632b;
            int r104 = 0;
            if (r103 == null) goto L8;
            int r105 = r103.hashCode();
        L9:
            int r106 = (r102 + r105) * 31;
            View r107 = this.f181633c;
            if (r107 == null) goto L12;
            int r108 = r107.hashCode();
        L13:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f181634d;
            if (r110 == null) goto L17;
            r104 = r110.hashCode();
        L17:
            return ((r109 + r104) * 31) + Float.floatToIntBits(this.f181635e);
        L12:
            r108 = 0;
            goto L13
        L8:
            r105 = 0;
            goto L9
        }

        public final String toString() {
            return "Transition(targetExpanded=" + this.f181631a + ", snapshotBounds=" + this.f181632b + ", headerView=" + this.f181633c + ", snapshotTopFromHeaderBottom=" + this.f181634d + ", progress=" + this.f181635e + ")";
        }

        public f(boolean r100, Rect r101, View r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r101, "snapshotBounds");
            this.f181631a = r100;
            this.f181632b = r101;
            this.f181633c = r102;
            this.f181634d = r103;
            this.f181635e = 0.0f;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.ecom.arch.slice.p f181636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.ecom.arch.slice.slices.a f181637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f181638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f181639d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == false) goto L14;
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f181636a, r101.f181636a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f181637b, r101.f181637b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f181638c, r101.f181638c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f181639d, r101.f181639d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.ecom.arch.slice.p r100 = this.f181636a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.ecom.arch.slice.slices.a r104 = this.f181637b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            View r107 = this.f181638c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Rect r110 = this.f181639d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "TransitionTarget(baseInfoGroup=" + this.f181636a + ", serviceHolder=" + this.f181637b + ", headerView=" + this.f181638c + ", bounds=" + this.f181639d + ")";
        }

        public g(com.bytedance.android.ecom.arch.slice.p r100, com.bytedance.android.ecom.arch.slice.slices.a r101, View r102, Rect r103) {
            Intrinsics.checkNotNullParameter(r100, "baseInfoGroup");
            Intrinsics.checkNotNullParameter(r103, "bounds");
            this.f181636a = r100;
            this.f181637b = r101;
            this.f181638c = r102;
            this.f181639d = r103;
        }
    }

    public static final class h implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseInfoServiceSnapshotTransitionController f181640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f181641b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f181640a.f181613q.getViewTreeObserver().isAlive() == false) goto L5;
            this.f181640a.f181613q.getViewTreeObserver().removeOnPreDrawListener(this);
        L5:
            this.f181640a.f181602f = null;
            this.f181641b.invoke();
            return true;
        }

        public h(BaseInfoServiceSnapshotTransitionController r100, Function0 r101) {
            this.f181640a = r100;
            this.f181641b = r101;
        }
    }

    public final g e() {
        if (ViewCompat.isAttachedToWindow(this.f181613q) == true) goto L5;
    L141:
        g("recycler_not_ready");
        return null;
    L5:
        if (this.f181613q.getWidth() <= 0) goto L141;
        if (this.f181613q.getHeight() <= 0) goto L141;
        final String r100 = "BaseInfoGroupV2";
        b r101 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r100));
        if (r101 != null) goto L12;
        final String r102 = "BaseInfoGroup";
        r101 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r102));
    L12:
        if (r101 != null) goto L14;
        r101 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedBaseInfoGroup$1(this));
    L14:
        if (r101 != null) goto L17;
        g("base_info_not_attached");
        return null;
    L17:
        com.bytedance.android.ecom.arch.slice.g r103 = r101.f181619a;
        if ((r103 instanceof com.bytedance.android.ecom.arch.slice.p) == true) goto L20;
        r103 = null;
    L20:
        com.bytedance.android.ecom.arch.slice.p r104 = (com.bytedance.android.ecom.arch.slice.p) r103;
        if (r104 != null) goto L24;
        g("base_info_not_group");
        return null;
    L24:
        View r105 = r101.f181620b.s0();
        final String r106 = "service";
        b r107 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r106));
        if (r107 == null) goto L27;
        com.bytedance.android.ecom.arch.slice.g r108 = r107.f181619a;
    L29:
        if ((r108 instanceof com.bytedance.android.ecom.arch.slice.p) == true) goto L31;
        r108 = null;
    L31:
        com.bytedance.android.ecom.arch.slice.p r109 = (com.bytedance.android.ecom.arch.slice.p) r108;
        if (r109 != null) goto L47;
        List<com.bytedance.android.ecom.arch.slice.g> r110 = this.f181614r.E2();
        ArrayList r111 = new ArrayList();
        Iterator r112 = ((ArrayList) r110).iterator();
    L35:
        if (r112.hasNext() == false) goto L39;
        Object r113 = r112.next();
        if ((r113 instanceof com.bytedance.android.ecom.arch.slice.p) == false) goto L35;
        r111.add(r113);
        goto L35
    L39:
        Iterator r114 = r111.iterator();
    L41:
        if (r114.hasNext() == false) goto L45;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.p) r115).getSliceId(), "service") == false) goto L41;
    L46:
        r109 = (com.bytedance.android.ecom.arch.slice.p) r115;
        goto L47
    L45:
        r115 = null;
    L47:
        if (r109 != null) goto L50;
        g("service_group_missing");
        return null;
    L50:
        if (r107 == null) goto L52;
        com.bytedance.android.ecom.arch.slice.slices.a r116 = r107.f181620b;
    L53:
        if (r116 == null) goto L59;
        View r117 = r116.s0();
        if (r117 == null) goto L59;
        if (f(r117) == false) goto L59;
    L61:
        if (f(r105) == true) goto L65;
        g("base_info_view_detached");
        return null;
    L65:
        if ((r105 instanceof RecyclerView) == true) goto L67;
        View r118 = null;
    L68:
        RecyclerView r119 = (RecyclerView) r118;
        if (r119 == null) goto L91;
        int r120 = r119.getChildCount();
        int r121 = 0;
    L72:
        if (r121 >= r120) goto L91;
        View r122 = r119.getChildAt(r121);
        int r123 = com.bytedance.android.ecom.arch.slice.adapter.e.f50008e;
        Intrinsics.checkNotNullParameter(r122, "view");
        Object r124 = r122.getTag(R.id.slc_adapter_item_data);
        if ((r124 instanceof com.bytedance.android.ecom.arch.slice.adapter.b) == true) goto L76;
        r124 = null;
    L76:
        com.bytedance.android.ecom.arch.slice.adapter.b r125 = (com.bytedance.android.ecom.arch.slice.adapter.b) r124;
        if ((r125 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L79;
        r125 = null;
    L79:
        com.bytedance.android.ecom.arch.slice.g r126 = (com.bytedance.android.ecom.arch.slice.g) r125;
        if (r126 == null) goto L87;
        if (Intrinsics.areEqual(r126.getSliceId(), "title_v2") == true) goto L89;
        if (Intrinsics.areEqual(r126.getViewType(), "pfz_title") == false) goto L87;
    L89:
        if (f(r122) == false) goto L91;
    L92:
        if (r122 != null) goto L95;
        g("title_not_attached");
        return null;
    L95:
        final String r127 = "BaseInfoOffset";
        b r128 = d(new BaseInfoServiceSnapshotTransitionController$findAttachedSlice$1(r127));
        if (r128 == null) goto L104;
        com.bytedance.android.ecom.arch.slice.slices.a r129 = r128.f181620b;
        if (r129 == null) goto L104;
        View r130 = r129.s0();
        if (r130 == null) goto L104;
        if (f(r130) == false) goto L104;
    L105:
        List r131 = CollectionsKt.distinct(CollectionsKt.plus(CollectionsKt.listOf(r105), CollectionsKt.listOfNotNull(new View[]{r117, r130})));
        if (r122.getVisibility() != 8) goto L108;
    L123:
        Rect r132 = null;
    L124:
        if (r132 != null) goto L127;
        g("target_bounds_empty");
        return null;
    L127:
        int r133 = this.f181613q.getChildCount();
        int r134 = 0;
    L128:
        if (r134 >= r133) goto L138;
        View r135 = this.f181613q.getChildAt(r134);
        int r136 = this.f181613q.getChildAdapterPosition(r135);
        if (r136 == (-1)) goto L137;
        if ((DiffableAdapter.DefaultImpls.getItem$default(this.f181614r, r136, false, 2, null) instanceof AnchorV4HeadV2VO) == false) goto L137;
        if (f(r135) == false) goto L138;
    L139:
        this.f181606j = null;
        return new g(r104, r116, r135, r132);
    L137:
        r134 = r134 + 1;
    L138:
        r135 = null;
        goto L139
    L108:
        if (r122.getHeight() <= 0) goto L123;
        this.f181613q.getLocationInWindow(this.f181611o);
        r122.getLocationInWindow(this.f181612p);
        int r137 = (this.f181612p[1] - this.f181611o[1]) + r122.getHeight();
        Iterator r138 = r131.iterator();
        int r139 = Integer.MIN_VALUE;
    L112:
        if (r138.hasNext() == false) goto L119;
        View r140 = (View) r138.next();
        if (r140.getVisibility() == 8) goto L112;
        if (r140.getHeight() <= 0) goto L112;
        r140.getLocationInWindow(this.f181612p);
        r139 = Math.max(r139, (this.f181612p[1] - this.f181611o[1]) + r140.getHeight());
        goto L112
    L119:
        int r141 = RangesKt.coerceAtLeast(r137, 0);
        int r142 = RangesKt.coerceAtMost(r139, this.f181613q.getHeight());
        if (r142 <= r141) goto L123;
        r132 = new Rect(0, r141, this.f181613q.getWidth(), r142);
    L104:
        r130 = null;
    L87:
        r121 = r121 + 1;
    L91:
        r122 = null;
        goto L92
    L67:
        r118 = r105;
    L59:
        r117 = null;
        goto L61
    L52:
        r116 = null;
        goto L53
    L27:
        r108 = null;
        goto L29
    }

    public final void j() {
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.a r100 = this.f181603g;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f181613q.getViewTreeObserver().isAlive() == false) goto L8;
        this.f181613q.getViewTreeObserver().removeOnPreDrawListener(r100);
    L8:
        this.f181603g = null;
    }

    public final void k() {
        e r100 = this.f181602f;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f181613q.getViewTreeObserver().isAlive() == false) goto L8;
        this.f181613q.getViewTreeObserver().removeOnPreDrawListener(r100.f181630a);
    L8:
        this.f181602f = null;
    }

    public final void c() {
        j();
        a r100 = this.f181601e;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f181613q.getOverlay().remove(r100.f181617a);
        this.f181613q.getOverlay().remove(r100.f181618b);
        r100.f181617a.setCallback(null);
        r100.f181618b.setCallback(null);
        this.f181601e = null;
    }

    public final b d(Function1<? super String, Boolean> r100) {
        int r101 = this.f181613q.getChildCount();
        int r102 = 0;
    L3:
        Object r103 = null;
        if (r102 >= r101) goto L29;
        View r104 = this.f181613q.getChildAt(r102);
        int r105 = this.f181613q.getChildAdapterPosition(r104);
        if (r105 == (-1)) goto L26;
        Object r106 = DiffableAdapter.DefaultImpls.getItem$default(this.f181614r, r105, false, 2, null);
        if ((r106 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L11;
        r106 = null;
    L11:
        com.bytedance.android.ecom.arch.slice.g r107 = (com.bytedance.android.ecom.arch.slice.g) r106;
        if (r107 == null) goto L26;
        String r108 = r107.getSliceId();
        if (r108 == null) goto L26;
        if (r100.invoke(r108).booleanValue() == false) goto L26;
        RecyclerView.ViewHolder r109 = this.f181613q.getChildViewHolder(r104);
        if ((r109 instanceof com.bytedance.android.ecom.arch.slice.slices.a) == false) goto L24;
        r103 = r109;
    L24:
        com.bytedance.android.ecom.arch.slice.slices.a r110 = (com.bytedance.android.ecom.arch.slice.slices.a) r103;
        if (r110 == null) goto L26;
        return new b(r107, r110);
    L26:
        r102 = r102 + 1;
        goto L3
    L29:
        return null;
    }

    public final boolean f(View r100) {
        if (ViewCompat.isAttachedToWindow(r100) == true) goto L5;
        return false;
    L5:
        ViewParent r101 = r100.getParent();
    L6:
        if (r101 == null) goto L12;
        if (r101 == this.f181613q) goto L9;
        r101 = r101.getParent();
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public final void g(String r100) {
        if (Intrinsics.areEqual(this.f181606j, r100) == false) goto L5;
        return;
    L5:
        this.f181606j = r100;
        dm.a.a("PdpSnapshotTransition").b("skip reason=" + r100 + " childCount=" + this.f181613q.getChildCount(), null);
    }

    public final void h(final boolean r100) {
        if (this.f181605i == false) goto L5;
        return;
    L5:
        f r101 = this.f181598b;
        this.f181597a = r100;
        this.f181607k = false;
        this.f181604h++;
        k();
        j();
        if (r101 != null) goto L10;
        n(e(), r100);
        i(r100);
        return;
    L10:
        if (r100 == r101.f181631a) goto L14;
        a r102 = this.f181601e;
        if (r102 == null) goto L14;
        r102.f181617a.setAlpha(255);
        r102.f181618b.setAlpha(0);
    L14:
        n(e(), r100);
        this.f181598b = null;
        final int r103 = this.f181604h;
        l(new BaseInfoServiceSnapshotTransitionController$onSettled$2(this, r103, r100));
    }

    public final void i(final boolean r100) {
        if (this.f181605i == false) goto L5;
        return;
    L5:
        if (this.f181598b != null) goto L20;
        this.f181597a = r100;
        if (r100 == false) goto L10;
        c r101 = this.f181600d;
    L11:
        if (r101 == null) goto L13;
        RecyclerView r102 = r101.f181621a;
    L15:
        if (r102 != this.f181613q) goto L17;
        return;
    L17:
        l(new BaseInfoServiceSnapshotTransitionController$prepareStableSnapshot$1(this, r100));
        return;
    L13:
        r102 = null;
        goto L15
    L10:
        r101 = this.f181599c;
        goto L11
    }

    public final void l(Function0<Unit> r100) {
        k();
        if (ViewCompat.isAttachedToWindow(this.f181613q) == true) goto L6;
        r100.invoke();
        return;
    L6:
        h r101 = new h(this, r100);
        this.f181602f = new e(r101);
        this.f181613q.getViewTreeObserver().addOnPreDrawListener(r101);
        this.f181613q.invalidate();
    }

    public final void m(f r110) {
        a r100 = this.f181601e;
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = r110.f181634d;
        if (r101 == null) goto L17;
        int r102 = r101.intValue();
        View r103 = r110.f181633c;
        Integer r104 = null;
        if (r103 != null) goto L10;
    L15:
        if (r104 == null) goto L17;
        int r105 = r104.intValue();
    L18:
        boolean r106 = r110.f181631a;
        if (r106 == false) goto L21;
        float r107 = 0.0f;
    L22:
        if (r106 == false) goto L24;
        float r108 = 0.42f;
    L25:
        if (r106 == false) goto L27;
        float r109 = 0.1f;
    L28:
        if (r106 == false) goto L30;
        float r111 = 0.58f;
    L31:
        float r112 = RangesKt.coerceIn((r110.f181635e - r107) / (r108 - r107), 0.0f, 1.0f);
        float r113 = RangesKt.coerceIn((r110.f181635e - r109) / (r111 - r109), 0.0f, 1.0f);
        r100.f181617a.setAlpha(RangesKt.coerceIn(MathKt.roundToInt((1.0f - ((r112 * r112) * (3.0f - (r112 * 2.0f)))) * 255.0f), 0, 255));
        r100.f181618b.setAlpha(RangesKt.coerceIn(MathKt.roundToInt((1.0f - ((r113 * r113) * (3.0f - (r113 * 2.0f)))) * 255.0f), 0, 255));
        BitmapDrawable r114 = r100.f181617a;
        Rect r115 = r110.f181632b;
        r114.setBounds(r115.left, r105, r115.right, r115.height() + r105);
        r100.f181618b.setBounds(r100.f181617a.getBounds());
        return;
    L30:
        r111 = 0.92f;
        goto L31
    L27:
        r109 = 0.32f;
        goto L28
    L24:
        r108 = 0.6f;
        goto L25
    L21:
        r107 = 0.05f;
        goto L22
    L10:
        if (f(r103) == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        this.f181613q.getLocationInWindow(this.f181611o);
        r103.getLocationInWindow(this.f181612p);
        r104 = Integer.valueOf(((this.f181612p[1] - this.f181611o[1]) + r103.getHeight()) + r102);
    L17:
        r105 = r110.f181632b.top;
        goto L18
    }

    public final void n(g r100, boolean r101) {
        this.f181614r.F2(r101);
        boolean r102 = this.f181615s.Y0(r101);
        dm.a.b r103 = dm.a.a("PdpSnapshotTransition");
        StringBuilder r104 = new StringBuilder("update target expanded=");
        r104.append(r101);
        r104.append(" dispatched=");
        r104.append(r102);
        r104.append(" baseInfo=");
        if (r100 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.p r105 = r100.f181636a;
        if (r105 == null) goto L7;
        String r106 = r105.getSliceId();
    L8:
        r104.append(r106);
        r104.append(" serviceAttached=");
        if (r100 == null) goto L11;
        com.bytedance.android.ecom.arch.slice.slices.a r107 = r100.f181637b;
    L12:
        if (r107 == null) goto L14;
        boolean r108 = true;
    L15:
        r104.append(r108);
        r103.b(r104.toString(), null);
        return;
    L14:
        r108 = false;
        goto L15
    L11:
        r107 = null;
    L7:
        r106 = null;
        goto L8
    }

    public static final void a(final BaseInfoServiceSnapshotTransitionController r110, g r111, final boolean r112) {
        if (r110.f181598b == null) goto L5;
        return;
    L5:
        if (r110.f181601e != null) goto L65;
        if (r112 == false) goto L9;
        c r100 = r110.f181600d;
    L11:
        if (r100 == null) goto L13;
        RecyclerView r101 = r100.f181621a;
    L15:
        if (r101 == r110.f181613q) goto L66;
        Rect r102 = new Rect(r111.f181639d);
        View r103 = r111.f181638c;
        if (r103 == null) goto L20;
        r110.f181613q.getLocationInWindow(r110.f181611o);
        r103.getLocationInWindow(r110.f181612p);
        Integer r104 = Integer.valueOf(r111.f181639d.top - ((r110.f181612p[1] - r110.f181611o[1]) + r103.getHeight()));
    L21:
        final int r113 = r110.f181604h;
        d r105 = r110.f181609m;
        if (r105 != null) goto L24;
    L30:
        final int r106 = r110.f181608l + 1;
        r110.f181608l = r106;
        r110.f181609m = new d(r106, r113, r112, r102);
        Function1<c, Unit> r114 = new BaseInfoServiceSnapshotTransitionController$captureStableSnapshot$1(r110, r106, r113, r112);
        if (ViewCompat.isAttachedToWindow(r110.f181613q) == true) goto L33;
    L53:
        r110.g("capture_invalid_bounds:" + r102);
        r114.invoke(null);
        return;
    L33:
        if (r102.width() <= 0) goto L53;
        if (r102.height() <= 0) goto L53;
        if (Build.VERSION.SDK_INT < 26) goto L52;
        Window r115 = r110.f181616t.invoke();
        if (r115 != null) goto L42;
        r110.g("capture_window_missing");
        r114.invoke(null);
        return;
    L42:
        r110.f181613q.getLocationInWindow(r110.f181611o);
        int[] r107 = r110.f181611o;
        int r108 = r107[0];
        int r109 = r102.left + r108;
        int r116 = r107[1];
        Rect r117 = new Rect(r109, r102.top + r116, r108 + r102.right, r116 + r102.bottom);
        Bitmap r118 = Bitmap.createBitmap(r102.width(), r102.height(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L48 IllegalArgumentException -> L50
        PixelCopy.request(r115, r117, r118, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.b(r110, r102, r112, r114, r118, r104), r110.f181610n);     // Catch: IllegalArgumentException -> L46
        return;
    L46:
        e = move-exception;
        r110.g("capture_pixel_copy_illegal_argument:" + e.getMessage());
        r114.invoke(null);
        return;
    L50:
        e = move-exception;
        r110.g("capture_illegal_argument:" + e.getMessage());
        r114.invoke(null);
        return;
    L48:
        e = move-exception;
        r110.g("capture_oom:" + e.getMessage());
        r114.invoke(null);
        return;
    L52:
        r114.invoke(r110.b(r102, r112, r104));
        return;
    L24:
        if (r105.f181627b != r113) goto L30;
        if (r105.f181628c != r112) goto L30;
        if (Intrinsics.areEqual(r105.f181629d, r102) == false) goto L30;
        return;
    L20:
        r104 = null;
        goto L21
    L66:
        return;
    L13:
        r101 = null;
        goto L15
    L9:
        r100 = r110.f181599c;
        goto L11
    }

    public final c b(Rect r110, boolean r111, Integer r112) {
        if (ViewCompat.isAttachedToWindow(this.f181613q) == true) goto L5;
    L16:
        g("capture_invalid_bounds:" + r110);
        return null;
    L5:
        if (r110.width() <= 0) goto L16;
        if (r110.height() <= 0) goto L16;
        Bitmap r100 = Bitmap.createBitmap(r110.width(), r110.height(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        Canvas r101 = new Canvas(r100);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        r101.translate(-r110.left, -r110.top);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        this.f181613q.draw(r101);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        this.f181606j = null;     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
        dm.a.a("PdpSnapshotTransition").b("capture success mode=canvas bounds=" + r110 + " expanded=" + r111, null);     // Catch: OutOfMemoryError -> L11 IllegalArgumentException -> L13
    L20:
        return new c(this.f181613q, new Rect(r110), r111, r100, r112);
    L13:
        e = move-exception;
        g("capture_illegal_argument:" + e.getMessage());
        return null;
    L11:
        e = move-exception;
        g("capture_oom:" + e.getMessage());
        return null;
    }

    public BaseInfoServiceSnapshotTransitionController(BasePdpRecyclerView r100, ProductDetailInfoAdapter r101, vg3.v r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "dynamicFeatureAbility");
        Intrinsics.checkNotNullParameter(r103, "containerWindowProvider");
        this.f181613q = r100;
        this.f181614r = r101;
        this.f181615s = r102;
        this.f181616t = r103;
        this.f181610n = new Handler(Looper.getMainLooper());
        this.f181611o = new int[2];
        this.f181612p = new int[2];
    }
}
