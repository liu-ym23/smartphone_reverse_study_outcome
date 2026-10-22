package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.utils.y;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class SlcBgDecorProjectionOptimizedView extends SlcFlexElementView {
    public static final Paint P = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public final boolean D;
    public final String E;
    public long F;
    public volatile long G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f183224J;
    public volatile int K;
    public volatile boolean L;
    public volatile boolean M;
    public final SlcBgDecorProjectionOptimizedView$headScrollListener$1 N;
    public final com.bytedance.android.shopping.anchorv4.voavhs.blur.f O;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnonymousClass1 f183225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f183226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayoutManager f183227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<RecyclerView> f183228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, Bitmap> f183229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Integer, Integer> f183230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Integer, String> f183231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<Integer> f183232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<Integer> f183233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Integer, CloseableReference<Bitmap>> f183234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayDeque<d> f183235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f183236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnchorV4HeadV2VO f183237q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f183238r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f183239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f183240t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f183241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f183242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f183243w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f183244x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f183245y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f183246z;

    public static final class a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f183249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f183250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f183251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f183252d;

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f183250b = 1728053247;
            this.f183251c = new Rect();
            this.f183252d = new Rect();
        }

        @Override // android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            super.onDraw(r100);
            Bitmap r101 = this.f183249a;
            if (r101 != null) goto L5;
            return;
        L5:
            if ((!r101.isRecycled()) == true) goto L8;
            r101 = null;
        L8:
            if (r101 == null) goto L13;
            this.f183251c.set(0, 0, r101.getWidth(), r101.getHeight());
            this.f183252d.set(0, 0, getWidth(), getHeight());
            r100.drawBitmap(r101, this.f183251c, this.f183252d, SlcBgDecorProjectionOptimizedView.P);
            r100.drawColor(this.f183250b);
            return;
        }
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f183253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, Bitmap> f183254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<Integer, Integer> f183255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183256d;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long getItemId(int r100) {
            return r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f183253a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            Bitmap r103 = this.f183254b.get(Integer.valueOf(r101));
            SlcBgDecorProjectionOptimizedView r104 = this.f183256d;
            Integer r105 = (Integer) ((LinkedHashMap) r104.f183230j).get(Integer.valueOf(r101));
            boolean r106 = true;
            if (r105 != null) goto L5;
        L13:
            WeakReference<RecyclerView> r107 = r104.f183228h;
            if (r107 == null) goto L22;
            RecyclerView r108 = r107.get();
            if (r108 == null) goto L22;
            RecyclerView.LayoutManager r109 = r108.getLayoutManager();
            if (r109 == null) goto L22;
            View r110 = r109.findViewByPosition(r101);
            if (r110 == null) goto L22;
            int r111 = r110.getWidth();
        L23:
            if (r111 <= 0) goto L31;
            int r112 = r104.f183245y;
            if (1 > r101) goto L29;
            if (r112 <= r101) goto L29;
            int r113 = r104.f183239s;
        L30:
            int r114 = r113 + r111;
        L41:
            ViewGroup.LayoutParams r115 = r102.itemView.getLayoutParams();
            r115.width = r114;
            r115.height = -1;
            r102.itemView.setLayoutParams(r115);
            r102.f183257a.setBackgroundColor(0);
            a r116 = r102.f183257a;
            int r117 = this.f183256d.H;
            if (r116.f183250b == r117) goto L45;
            r116.f183250b = r117;
            r116.invalidate();
        L45:
            if (r103 != null) goto L47;
        L49:
            a r118 = r102.f183257a;
            r118.f183249a = null;
            r118.invalidate();
            return;
        L47:
            if (r103.isRecycled() == true) goto L49;
            a r119 = r102.f183257a;
            r119.f183249a = r103;
            r119.invalidate();
            return;
        L29:
            r113 = 0;
            goto L30
        L31:
            Integer r120 = Integer.valueOf(r104.f183244x);
            if (r120.intValue() > 0) goto L35;
            r106 = false;
        L35:
            if (r106 == true) goto L38;
            r120 = null;
        L38:
            if (r120 == null) goto L40;
            r114 = r120.intValue();
            goto L41
        L40:
            int r121 = y.f187160a;
            r114 = y.e(r104.getContext(), null, 2);
        L22:
            r111 = 0;
            goto L23
        L5:
            if (r105.intValue() <= 0) goto L7;
            boolean r122 = true;
        L8:
            if (r122 == true) goto L11;
            r105 = null;
        L11:
            if (r105 == null) goto L13;
            r114 = r105.intValue();
            goto L41
        L7:
            r122 = false;
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            a r102 = new a(r100.getContext());
            r102.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            return new c(r102);
        }

        public b(SlcBgDecorProjectionOptimizedView r100, Map<Integer, Bitmap> r101, Map<Integer, Integer> r102) {
            Intrinsics.checkNotNullParameter(r101, "bitmapCache");
            Intrinsics.checkNotNullParameter(r102, "itemWidthMap");
            this.f183256d = r100;
            this.f183254b = r101;
            this.f183255c = r102;
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f183257a;

        public c(a r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f183257a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f183258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CloseableReference<Bitmap> f183259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f183260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f183261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f183262e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L16;
            d r101 = (d) r100;
            if (this.f183258a == r101.f183258a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f183259b, r101.f183259b) == true) goto L10;
            return false;
        L10:
            if (this.f183260c == r101.f183260c) goto L12;
            return false;
        L12:
            if (this.f183261d == r101.f183261d) goto L14;
            return false;
        L14:
            if (this.f183262e == r101.f183262e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f183258a * 31;
            CloseableReference<Bitmap> r101 = this.f183259b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return ((((((r100 + r102) * 31) + this.f183260c) * 31) + this.f183261d) * 31) + this.f183262e;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "BitmapTask(position=" + this.f183258a + ", bitmapRef=" + this.f183259b + ", targetWidth=" + this.f183260c + ", targetHeight=" + this.f183261d + ", version=" + this.f183262e + ")";
        }

        public d(int r100, CloseableReference<Bitmap> r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r101, "bitmapRef");
            this.f183258a = r100;
            this.f183259b = r101;
            this.f183260c = r102;
            this.f183261d = r103;
            this.f183262e = r104;
        }
    }

    public static final class e {
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnchorV4HeadV2VO f183264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f183265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f183266d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f183267e;

        public f(SlcBgDecorProjectionOptimizedView r100, AnchorV4HeadV2VO r101, float r102, int r103, boolean r104) {
            this.f183263a = r100;
            this.f183264b = r101;
            this.f183265c = r102;
            this.f183266d = r103;
            this.f183267e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f183263a.h(this.f183264b, this.f183265c, this.f183266d, this.f183267e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f183269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f183270c;

        public g(SlcBgDecorProjectionOptimizedView r100, int r101, List r102) {
            this.f183268a = r100;
            this.f183269b = r101;
            this.f183270c = r102;
        }

        public final void a() {
            if (this.f183268a.L == false) goto L5;
            return;
        L5:
            if (this.f183268a.M == false) goto L7;
            return;
        L7:
            if (this.f183269b != this.f183268a.K) goto L80;
            int r100 = RangesKt.coerceAtLeast(this.f183268a.getHeight(), 1);
            this.f183268a.j();
            SlcBgDecorProjectionOptimizedView r101 = this.f183268a;
            IntRange r102 = CollectionsKt.getIndices(this.f183270c);
            r101.getClass();
            Set r103 = CollectionsKt.toSet(r102);
            Set r104 = ((LinkedHashMap) r101.f183229i).keySet();
            ArrayList r105 = new ArrayList();
            Iterator r106 = r104.iterator();
        L11:
            if (r106.hasNext() == false) goto L15;
            Object r107 = r106.next();
            if ((!r102.contains(((Number) r107).intValue())) == false) goto L11;
            r105.add(r107);
            goto L11
        L15:
            Iterator r108 = r105.iterator();
        L17:
            if (r108.hasNext() == false) goto L19;
            r101.t(((Number) r108.next()).intValue());
            goto L17
        L19:
            Set r109 = r103;
            ((LinkedHashMap) r101.f183230j).keySet().retainAll(r109);
            ((LinkedHashMap) r101.f183231k).keySet().retainAll(r109);
            r101.f183232l.retainAll(r109);
            r101.f183233m.retainAll(r109);
            int r110 = this.f183270c.size();
            int r111 = 0;
        L20:
            if (r111 >= r110) goto L51;
            HeaderContentModel r112 = (HeaderContentModel) ListProtector.get(this.f183270c, r111);
            SlcBgDecorProjectionOptimizedView r113 = this.f183268a;
            float r114 = r113.f183240t;
            if (r111 >= r113.f183245y) goto L26;
            if (r111 != 0) goto L25;
            int r115 = r113.f183243w;
        L27:
            r113.f183230j.put(Integer.valueOf(r111), Integer.valueOf((int) (r115 + ((r113.f183244x - r115) * r114))));
            HeaderMediaModel r116 = r112.getMedia();
            String r117 = null;
            if (r116 == null) goto L32;
            ECUrlModel r118 = HeaderMediaModel.getImageUrl$default(r116, false, 1, null);
            if (r118 == null) goto L32;
            r117 = r118.getUri();
        L32:
            Bitmap r119 = (Bitmap) ((LinkedHashMap) this.f183268a.f183229i).get(Integer.valueOf(r111));
            if (r117 != null) goto L35;
        L40:
            boolean r120 = false;
        L42:
            if (r112.getMedia() == null) goto L49;
            if (r117 == null) goto L45;
            this.f183268a.f183231k.put(Integer.valueOf(r111), r117);
        L46:
            this.f183268a.f183232l.add(Integer.valueOf(r111));
            if (r120 == true) goto L50;
            this.f183268a.f183233m.remove(Integer.valueOf(r111));
            this.f183268a.t(r111);
        L50:
            r111 = r111 + 1;
            goto L20
        L45:
            this.f183268a.f183231k.remove(Integer.valueOf(r111));
            goto L46
        L49:
            this.f183268a.f183231k.remove(Integer.valueOf(r111));
            this.f183268a.f183232l.remove(Integer.valueOf(r111));
            this.f183268a.f183233m.remove(Integer.valueOf(r111));
            this.f183268a.t(r111);
            goto L50
        L35:
            if (Intrinsics.areEqual(r117, (String) ((LinkedHashMap) this.f183268a.f183231k).get(Integer.valueOf(r111))) == false) goto L40;
            if (r119 == null) goto L40;
            if (r119.isRecycled() == true) goto L40;
            r120 = true;
            goto L42
        L25:
            r115 = r113.f183242v;
            goto L27
        L26:
            r115 = r113.f183244x;
            goto L27
        L51:
            b r121 = this.f183268a.f183226f;
            r121.f183253a = this.f183270c.size();
            r121.notifyDataSetChanged();
            this.f183268a.w();
            SlcBgDecorProjectionOptimizedView r122 = this.f183268a;
            r122.A = false;
            int r123 = this.f183269b;
            Map r124 = MapsKt.toMap(r122.f183234n);
            ((LinkedHashMap) r122.f183234n).clear();
            Iterator r125 = r124.entrySet().iterator();
        L53:
            if (r125.hasNext() == false) goto L59;
            Map.Entry r126 = (Map.Entry) r125.next();
            int r127 = ((Number) r126.getKey()).intValue();
            CloseableReference<Bitmap> r128 = (CloseableReference) r126.getValue();
            Integer r129 = (Integer) ((LinkedHashMap) r122.f183230j).get(Integer.valueOf(r127));
            if (r122.f183232l.contains(Integer.valueOf(r127)) == false) goto L58;
            if (r129 == null) goto L58;
            r122.k(r127, r128, r129.intValue(), r100, r123);
        L58:
            r128.close();
            goto L53
        L59:
            SlcBgDecorProjectionOptimizedView.n(this.f183268a, "bind_ready", "version=" + this.f183269b + " media_count=" + this.f183268a.f183232l.size(), 2);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183271a;

        public h(SlcBgDecorProjectionOptimizedView r100) {
            this.f183271a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f183271a.o();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f183274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CloseableReference f183275c;

        public i(SlcBgDecorProjectionOptimizedView r100, int r101, CloseableReference r102) {
            this.f183273a = r100;
            this.f183274b = r101;
            this.f183275c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f183273a.p(this.f183274b, this.f183275c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f183277b;

        public j(SlcBgDecorProjectionOptimizedView r100, boolean r101) {
            this.f183276a = r100;
            this.f183277b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f183276a.q(this.f183277b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f183279b;

        public k(SlcBgDecorProjectionOptimizedView r100, float r101) {
            this.f183278a = r100;
            this.f183279b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f183278a.r(this.f183279b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183280a;

        public l(SlcBgDecorProjectionOptimizedView r100) {
            this.f183280a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f183280a.s();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        P = new Paint(2);
    }

    public final void i() {
        this.K++;
        j();
        Iterator r100 = ((LinkedHashMap) this.f183234n).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((CloseableReference) r100.next()).close();
        goto L4
    L6:
        ((LinkedHashMap) this.f183234n).clear();
        this.A = false;
        this.C = true;
        if (this.B == true) goto L11;
        this.C = false;
        this.O.d(false);
        return;
    }

    public final void j() {
        Iterator<T> r100 = this.f183235o.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).f183259b.close();
        goto L4
    L6:
        this.f183235o.clear();
    }

    public final void v() {
        if (this.B == false) goto L5;
        return;
    L5:
        if (this.L == false) goto L7;
        return;
    L7:
        if (this.M == true) goto L16;
        final d r100 = this.f183235o.pollFirst();
        if (r100 != null) goto L12;
        return;
    L12:
        this.B = true;
        this.f183236p = r100;
        final long r101 = SystemClock.elapsedRealtimeNanos();
        m("task_start", r100.f183258a, "version=" + r100.f183262e + " target_width=" + r100.f183260c + " target_height=" + r100.f183261d);
        b2.b(new SlcBgDecorProjectionOptimizedView$startNextBitmapTask$1(this, r100, r101));
        return;
    }

    public final boolean w() {
        WeakReference<RecyclerView> r100 = this.f183228h;
        int r101 = 0;
        if (r100 == null) goto L43;
        RecyclerView r102 = r100.get();
        if (r102 == null) goto L43;
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        ViewGroup.LayoutParams r104 = null;
        if ((r103 instanceof LinearLayoutManager) == true) goto L10;
        r103 = null;
    L10:
        LinearLayoutManager r105 = (LinearLayoutManager) r103;
        if (r105 != null) goto L13;
        return false;
    L13:
        Integer r106 = Integer.valueOf(this.f183241u);
        int r107 = r106.intValue();
        int r108 = this.f183226f.f183253a;
        if (r107 < 0) goto L20;
        if (r108 <= r107) goto L20;
        if (r105.findViewByPosition(r107) == null) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == true) goto L24;
        r106 = null;
    L24:
        if (r106 == null) goto L26;
        int r110 = r106.intValue();
    L27:
        int r111 = this.f183226f.f183253a;
        if (r110 < 0) goto L43;
        if (r111 <= r110) goto L43;
        View r112 = r105.findViewByPosition(r110);
        if (r112 != null) goto L34;
        return false;
    L34:
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        r104 = r113;
    L38:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r104;
        if (r114 == null) goto L41;
        r101 = r114.leftMargin;
    L41:
        this.f183227g.scrollToPositionWithOffset(r110, ((int) r112.getX()) - r101);
        return true;
    L26:
        r110 = r105.findFirstVisibleItemPosition();
    L20:
        r109 = false;
    L43:
        return false;
    }

    public final void o() {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r100 = UIUtils.f45548a;
        UIUtils.c().post(new h(this));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        if (this.L == true) goto L37;
        WeakReference<RecyclerView> r101 = this.f183228h;
        int r102 = -1;
        if (r101 == null) goto L31;
        RecyclerView r103 = r101.get();
        if (r103 == null) goto L31;
        float r104 = r103.getWidth() / 2.0f;
        int r105 = r103.getChildCount();
        int r106 = 0;
        float r107 = Float.MAX_VALUE;
        int r108 = 0;
        int r109 = -1;
    L17:
        if (r108 >= r105) goto L22;
        View r110 = r103.getChildAt(r108);
        float r111 = Math.abs((r110.getX() + (r110.getWidth() / 2.0f)) - r104);
        if (r111 >= r107) goto L21;
        r109 = r108;
        r107 = r111;
    L21:
        r108 = r108 + 1;
        goto L17
    L22:
        if (r109 != 1) goto L26;
        View r112 = r103.getChildAt(0);
        if ((r112.getWidth() + r112.getX()) <= (r112.getWidth() * 0.75f)) goto L26;
    L27:
        View r113 = r103.getChildAt(r106);
        if (r113 == null) goto L31;
        r102 = r103.getChildAdapterPosition(r113);
    L26:
        r106 = r109;
    L31:
        this.f183241u = r102;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.M == false) goto L5;
        return;
    L5:
        if (this.L == false) goto L21;
        boolean r100 = false;
        this.L = false;
        n(this, "attached", null, 6);
        WeakReference<RecyclerView> r101 = this.f183228h;
        if (r101 == null) goto L12;
        RecyclerView r102 = r101.get();
        if (r102 == null) goto L12;
        r102.removeOnScrollListener(this.N);
        r102.addOnScrollListener(this.N);
    L12:
        AnchorV4HeadV2VO r103 = this.f183237q;
        if (r103 == null) goto L20;
        float r104 = this.f183240t;
        float r105 = this.f183238r;
        int r106 = this.f183239s;
        if (r104 != 1.0f) goto L17;
        r100 = true;
    L17:
        h(r103, r105, r106, r100);
        r(r104);
        return;
    L20:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.M == false) goto L5;
        return;
    L5:
        this.L = true;
        this.f183241u = -1;
        WeakReference<RecyclerView> r100 = this.f183228h;
        if (r100 == null) goto L10;
        RecyclerView r101 = r100.get();
        if (r101 == null) goto L10;
        r101.removeOnScrollListener(this.N);
    L10:
        n(this, "detached", null, 6);
        i();
    }

    public final void s() {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r100 = UIUtils.f45548a;
        UIUtils.c().post(new l(this));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        this.M = true;
        this.L = true;
        this.f183241u = -1;
        WeakReference<RecyclerView> r101 = this.f183228h;
        if (r101 == null) goto L14;
        RecyclerView r102 = r101.get();
        if (r102 == null) goto L14;
        r102.removeOnScrollListener(this.N);
    L14:
        this.f183228h = null;
        this.f183237q = null;
        n(this, "release_before", null, 6);
        u("release_before", 0);
        i();
        this.f183246z = null;
        int r103 = getChildCount();
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L23;
        View r105 = getChildAt(r104);
        if ((r105 instanceof a) == true) goto L19;
        r105 = null;
    L19:
        a r106 = (a) r105;
        if (r106 == null) goto L22;
        r106.f183249a = null;
        r106.invalidate();
    L22:
        r104 = r104 + 1;
        goto L15
    L23:
        Iterator r107 = ((LinkedHashMap) this.f183229i).values().iterator();
    L25:
        if (r107.hasNext() == false) goto L27;
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b((Bitmap) r107.next());
        goto L25
    L27:
        ((LinkedHashMap) this.f183229i).clear();
        ((LinkedHashMap) this.f183230j).clear();
        ((LinkedHashMap) this.f183231k).clear();
        this.f183232l.clear();
        this.f183233m.clear();
        this.f183226f.f183253a = 0;
        n(this, "release_after", null, 6);
        u("release_after_1s", 1000);
        u("release_after_5s", 5000);
    }

    public final RecyclerView getRecyclerView() {
        return this.f183225e;
    }

    public final void q(boolean r100) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        Lazy r101 = UIUtils.f45548a;
        UIUtils.c().post(new j(this, r100));
        return;
    L6:
        if (r100 == false) goto L8;
        float r102 = 1.0f;
    L9:
        r(r102);
        this.f183241u = -1;
        return;
    L8:
        r102 = 0.0f;
        goto L9
    }

    public final void r(float r100) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r101 = UIUtils.f45548a;
        UIUtils.c().post(new k(this, r100));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        this.f183240t = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.L == false) goto L12;
        return;
    L12:
        AnchorV4HeadV2VO r102 = this.f183237q;
        if (r102 == null) goto L51;
        List<HeaderContentModel> r103 = r102.getCells();
        if (r103 == null) goto L52;
        int r104 = r103.size();
        int r105 = 0;
        int r106 = 0;
        boolean r107 = false;
    L18:
        if (r106 >= r104) goto L32;
        float r108 = this.f183240t;
        if (r106 >= this.f183245y) goto L24;
        if (r106 != 0) goto L23;
        int r109 = this.f183243w;
    L25:
        int r110 = (int) (r109 + ((this.f183244x - r109) * r108));
        Integer r111 = (Integer) ((LinkedHashMap) this.f183230j).get(Integer.valueOf(r106));
        if (r111 != null) goto L29;
    L30:
        this.f183230j.put(Integer.valueOf(r106), Integer.valueOf(r110));
        r107 = true;
    L31:
        r106 = r106 + 1;
        goto L18
    L29:
        if (r111.intValue() == r110) goto L31;
    L23:
        r109 = this.f183242v;
        goto L25
    L24:
        r109 = this.f183244x;
        goto L25
    L32:
        if (r107 == false) goto L42;
        int r112 = getChildCount();
    L34:
        if (r105 >= r112) goto L41;
        View r113 = getChildAt(r105);
        int r114 = getChildAdapterPosition(r113);
        Integer r115 = (Integer) ((LinkedHashMap) this.f183230j).get(Integer.valueOf(r114));
        if (r115 == null) goto L40;
        int r116 = r115.intValue();
        if (r113.getLayoutParams().width == r116) goto L40;
        ViewGroup.LayoutParams r117 = r113.getLayoutParams();
        r117.width = r116;
        Unit r118 = Unit.INSTANCE;
        r113.setLayoutParams(r117);
    L40:
        r105 = r105 + 1;
        goto L34
    L41:
        requestLayout();
    L42:
        w();
        return;
    L52:
        return;
    }

    public final void t(int r100) {
        RecyclerView.ViewHolder r101 = findViewHolderForAdapterPosition(r100);
        if ((r101 instanceof c) == true) goto L5;
        r101 = null;
    L5:
        c r102 = (c) r101;
        if (r102 == null) goto L10;
        a r103 = r102.f183257a;
        if (r103 == null) goto L10;
        r103.f183249a = null;
        r103.invalidate();
    L10:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(this.f183229i.remove(Integer.valueOf(r100)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.bytedance.android.shopping.slice.elements.bgdecorprojection.SlcBgDecorProjectionOptimizedView$headScrollListener$1] */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.view.View, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.shopping.slice.elements.bgdecorprojection.SlcBgDecorProjectionOptimizedView$1] */
    public SlcBgDecorProjectionOptimizedView(final Context r100, com.bytedance.android.shopping.anchorv4.voavhs.blur.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "blurManager");
        super(r100, null, 6, 0);
        this.O = r101;
        PagerSnapHelper r102 = new PagerSnapHelper();
        LinkedHashMap r103 = new LinkedHashMap();
        this.f183229i = r103;
        LinkedHashMap r104 = new LinkedHashMap();
        this.f183230j = r104;
        this.f183231k = new LinkedHashMap();
        this.f183232l = new LinkedHashSet();
        this.f183233m = new LinkedHashSet();
        this.f183234n = new LinkedHashMap();
        this.f183235o = new ArrayDeque();
        this.f183241u = -1;
        this.D = ECAppInfoService.f48114e.i();
        this.E = Integer.toHexString(System.identityHashCode(this));
        this.H = 1728053247;
        this.f183224J = Integer.MIN_VALUE;
        this.N = new SlcBgDecorProjectionOptimizedView$headScrollListener$1(this);
        ?? r105 = new AnonymousClass1(r100);
        r105.setItemAnimator(null);
        r105.setNestedScrollingEnabled(false);
        Unit r106 = Unit.INSTANCE;
        this.f183225e = r105;
        LinearLayoutManager r107 = new LinearLayoutManager(r100, 0, false);
        this.f183227g = r107;
        r105.setLayoutManager(r107);
        b r108 = new b(this, r103, r104);
        this.f183226f = r108;
        r108.setHasStableIds(true);
        r105.setAdapter(r108);
        r105.setItemAnimator(null);
        r102.attachToRecyclerView(r105);
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        addView(r105, new ViewGroup.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS)), com.bytedance.android.ec.hybrid.list.util.c.d(80)));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        measure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, 1073741824));
        setMeasuredDimension(r102, r103);
    }

    public final void p(int r110, CloseableReference<Bitmap> r111) {
        Intrinsics.checkNotNullParameter(r111, "bitmapRef");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r100 = UIUtils.f45548a;
        UIUtils.c().post(new i(this, r110, r111));
        return;
    L7:
        if (this.L == false) goto L9;
    L25:
        r111.close();
        return;
    L9:
        if (this.M == true) goto L25;
        Integer r101 = (Integer) ((LinkedHashMap) this.f183230j).get(Integer.valueOf(r110));
        if (this.A == true) goto L21;
        if (r101 == null) goto L21;
        if (this.f183232l.contains(Integer.valueOf(r110)) == true) goto L19;
        r111.close();
        return;
    L19:
        k(r110, r111, r101.intValue(), RangesKt.coerceAtLeast(getHeight(), 1), this.K);
        return;
    L21:
        CloseableReference<Bitmap> r112 = this.f183234n.put(Integer.valueOf(r110), r111);
        if (r112 == null) goto L27;
        r112.close();
        return;
    }

    public final void u(final String r100, long r101) {
        if (this.D == true) goto L5;
        return;
    L5:
        final String r102 = this.E;
        Runnable r103 = new SlcBgDecorProjectionOptimizedView$Companion$scheduleProcessMemorySnapshot$action$1(r102, r100);
        if (r101 <= 0) goto L8;
        Lazy r104 = UIUtils.f45548a;
        UIUtils.c().postDelayed(r103, r101);
        return;
    L8:
        r103.run();
    }

    public final void m(String r100, int r101, String r102) {
        if (this.D == true) goto L23;
        return;
    L23:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L20
        Iterator r104 = ((LinkedHashMap) this.f183229i).values().iterator();     // Catch: Throwable -> L20
        long r105 = 0;
    L7:
        if (r104.hasNext() == false) goto L9;
        r105 = r105 + com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a((Bitmap) r104.next());     // Catch: Throwable -> L20
        goto L7
    L9:
        this.F = Math.max(this.F, r105);     // Catch: Throwable -> L20
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L20
        r106.append("event=" + r100 + " impl=optimized instance=" + this.E);     // Catch: Throwable -> L20
        if (r101 == (-1)) goto L12;
        r106.append(" position=" + r101);     // Catch: Throwable -> L20
    L12:
        r106.append(" version=" + this.K);     // Catch: Throwable -> L20
        r106.append(" cache_count=" + this.f183229i.size());     // Catch: Throwable -> L20
        r106.append(" cache_kb=" + (r105 / 1024));     // Catch: Throwable -> L20
        r106.append(" cache_peak_kb=" + (this.F / 1024));     // Catch: Throwable -> L20
        r106.append(" working_peak_kb=" + (this.G / 1024));     // Catch: Throwable -> L20
        r106.append(" pending=" + this.f183235o.size());     // Catch: Throwable -> L20
        r106.append(" waiting=" + this.f183234n.size());     // Catch: Throwable -> L20
        r106.append(" processing=" + this.B);     // Catch: Throwable -> L20
        r106.append(" detached=" + this.L + " destroyed=" + this.M);     // Catch: Throwable -> L20
        if (r102.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        r106.append(' ');     // Catch: Throwable -> L20
        r106.append(r102);     // Catch: Throwable -> L20
    L18:
        dm.a.a("PdpBgDecorMem").i(r106.toString());     // Catch: Throwable -> L20
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L15:
        r107 = false;
    L20:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void n(SlcBgDecorProjectionOptimizedView r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        int r104 = -1;
    L7:
        if ((r103 & 4) == 0) goto L9;
        r102 = "";
    L9:
        r100.m(r101, r104, r102);
        return;
    L5:
        r104 = 0;
        goto L7
    }

    public final void h(AnchorV4HeadV2VO r100, float r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r101 = UIUtils.f45548a;
        UIUtils.c().post(new f(this, r100, r110, r111, r112));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        this.f183237q = r100;
        this.f183238r = r110;
        this.f183239s = r111;
        if (r112 == false) goto L12;
        float r113 = 1.0f;
    L13:
        this.f183240t = r113;
        if (this.L == false) goto L16;
        return;
    L16:
        List<HeaderContentModel> r114 = r100.getCells();
        if (r114 != null) goto L19;
        return;
    L19:
        this.f183245y = r100.getChangeKeyPosition();
        int r115 = ECSettingKeys.A0().f();
        int r102 = y.f187160a;
        this.f183244x = y.e(getContext(), null, 2);
        int r103 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.f169180k;
        int r104 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.a.b(getContext(), r110, false);
        this.f183243w = r104;
        int r105 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f183242v = r104 + com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r115));
        StringBuilder r116 = new StringBuilder();
        r116.append(r100.hashCode());
        r116.append('#');
        r116.append(Float.floatToIntBits(r110));
        r116.append('#');
        r116.append(this.f183244x);
        r116.append('#');
        r116.append(this.f183239s);
        String r106 = r116.toString();
        if (Intrinsics.areEqual(r106, this.f183246z) == false) goto L23;
        r(this.f183240t);
        return;
    L23:
        this.f183246z = r106;
        this.A = true;
        this.K++;
        int r107 = this.K;
        n(this, "bind_start", "version=" + r107 + " cells=" + r114.size() + " change_key_position=" + this.f183245y, 2);
        if (this.I == true) goto L26;
        this.I = true;
        u("bind_start", 0);
    L26:
        post(new g(this, r107, r114));
        return;
    L12:
        r113 = 0.0f;
        goto L13
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static final Bitmap g(SlcBgDecorProjectionOptimizedView r110, Bitmap r210, int r211, int r212, int r213) {
        r110.getClass();
        String r111 = "success";
        long r100 = SystemClock.elapsedRealtimeNanos();
        int r112 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r212, r210.getHeight()), 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        int r113 = RangesKt.coerceAtLeast(r211, 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        Float r101 = Float.valueOf(r110.O.f168048e);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        if (r101.floatValue() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        float r103 = r101.floatValue();     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
    L13:
        int r104 = RangesKt.coerceAtLeast((int) (r113 / r103), 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        int r105 = RangesKt.coerceAtLeast((int) (r112 / r103), 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.RGB_565);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        Canvas r114 = new Canvas(r106);     // Catch: Throwable -> L47 Exception -> L49 OutOfMemoryError -> L51
        r114.scale(1.0f, -1.0f, r104 / 2.0f, r105 / 2.0f);     // Catch: Throwable -> L47 Exception -> L49 OutOfMemoryError -> L51
        r114.drawBitmap(r210, new Rect(0, r210.getHeight() - r112, r210.getWidth(), r210.getHeight()), new Rect(0, 0, r104, r105), P);     // Catch: Throwable -> L47 Exception -> L49 OutOfMemoryError -> L51
        if (r110.L == true) goto L32;
    L29:
        th = th;
    L54:
        Throwable r115 = th;
        Bitmap r116 = r106;
        Bitmap r117 = null;
    L97:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L80
        long r108 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r116);     // Catch: Throwable -> L80
        long r109 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r117);     // Catch: Throwable -> L80
        Throwable r214 = r115;
        Bitmap r215 = r116;
        r110.G = Math.max(r110.G, r108 + r109);     // Catch: Throwable -> L78
        r110.l(r213, r210, r108, r109, (SystemClock.elapsedRealtimeNanos() - r100) / 1000000, "success");     // Catch: Throwable -> L78
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L78
    L83:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(r215);
        throw r214;
    L78:
        th = th;
    L82:
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L80:
        th = th;
        r214 = r115;
        r215 = r116;
        goto L82
    L17:
        if (r110.M == true) goto L32;
        Bitmap r119 = com.bytedance.android.shopping.anchorv4.voavhs.blur.f.b(r110.O, r106, r113, r112, null, 48);     // Catch: Throwable -> L29 Exception -> L49 OutOfMemoryError -> L51
        if (r119 != null) goto L28;
        r111 = "empty";
    L28:
        Bitmap r120 = r119;
        Bitmap r121 = r120;
    L95:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L43
        long r123 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r106);     // Catch: Throwable -> L43
        long r124 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r120);     // Catch: Throwable -> L43
        r110.G = Math.max(r110.G, r123 + r124);     // Catch: Throwable -> L41
        Bitmap r125 = r106;
        r110.l(r213, r210, r123, r124, (SystemClock.elapsedRealtimeNanos() - r100) / 1000000, r111);     // Catch: Throwable -> L39
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L46:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(r125);
        return r121;
    L39:
        th = th;
    L45:
        Result.Companion r126 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L41:
        th = th;
        r125 = r106;
    L43:
        th = th;
        r125 = r106;
        goto L45
    L32:
        r111 = "cancelled";
        r120 = null;
        r121 = null;
    L47:
        th = th;
        Bitmap r127 = r106;
        Bitmap r128 = null;
    L73:
        r116 = r127;
        r117 = r128;
        r115 = th;
    L49:
        e = e;
        Bitmap r129 = r106;
        Bitmap r130 = null;
    L101:
        String r131 = "error_".concat(e.getClass().getSimpleName());     // Catch: Throwable -> L71
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L61
        long r133 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r129);     // Catch: Throwable -> L61
        long r134 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r130);     // Catch: Throwable -> L61
        r110.G = Math.max(r110.G, r133 + r134);     // Catch: Throwable -> L61
        r110.l(r213, r210, r133, r134, (SystemClock.elapsedRealtimeNanos() - r100) / 1000000, r131);     // Catch: Throwable -> L61
    L66:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L69:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(r129);
        return null;
    L71:
        th = th;
        r127 = r129;
        r128 = r130;
    L51:
        r129 = r106;
        Bitmap r135 = null;
    L65:
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L61
        long r137 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r129);     // Catch: Throwable -> L61
        long r138 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r135);     // Catch: Throwable -> L61
        r110.G = Math.max(r110.G, r137 + r138);     // Catch: Throwable -> L61
        r110.l(r213, r210, r137, r138, (SystemClock.elapsedRealtimeNanos() - r100) / 1000000, "oom");     // Catch: Throwable -> L61
        goto L66
    L12:
        r103 = 4.0f;
        goto L13
    L6:
        r102 = false;
    L61:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L55:
        e = e;
        r130 = null;
        r129 = null;
    L63:
        r135 = null;
        r129 = null;
    L52:
        th = th;
        r106 = null;
        goto L54
    }

    public final void k(int r100, CloseableReference<Bitmap> r110, int r111, int r112, int r113) {
        if (this.f183233m.contains(Integer.valueOf(r100)) == true) goto L22;
        d r101 = this.f183236p;
        if (r101 != null) goto L7;
    L14:
        Iterator<d> r102 = this.f183235o.iterator();
    L16:
        if (r102.hasNext() == false) goto L20;
        d r103 = r102.next();
        if (r103.f183258a != r100) goto L16;
        r102.remove();
        r103.f183259b.close();
    L20:
        this.f183235o.addLast(new d(r100, r110, r111, r112, r113));
        v();
        return;
    L7:
        if (r101.f183258a == r100) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 != true) goto L14;
    L9:
        if (r101.f183262e != r113) goto L11;
        r104 = true;
    L22:
        r110.close();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        layout(0, 0, r103 - r101, r104 - r102);
    }

    public final void l(int r110, Bitmap r111, long r112, long r113, long r210, String r211) {
        if (this.D == true) goto L10;
        return;
    L10:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        long r101 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r111);     // Catch: Throwable -> L7
        dm.a.a("PdpBgDecorMem").i("event=blur_finish impl=optimized instance=" + this.E + " position=" + r110 + " result=" + r211 + " cost_ms=" + r210 + " source_width=" + r111.getWidth() + " source_height=" + r111.getHeight() + " source_config=" + r111.getConfig() + " source_ref_kb=" + (r101 / 1024) + " projection_kb=" + (r112 / 1024) + " output_kb=" + (r113 / 1024) + " working_kb=" + ((r112 + r113) / 1024) + " working_peak_kb=" + (this.G / 1024));     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
