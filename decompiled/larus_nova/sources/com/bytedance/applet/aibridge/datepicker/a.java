package com.bytedance.applet.aibridge.datepicker;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.applet.aibridge.datepicker.picker.reels.views.OReelPickerMulti;
import com.bytedance.applet.aibridge.datepicker.picker.reels.views.WheelView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import hv3.f;
import hv3.g;
import hv3.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kv3.e;
import l3.d;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f191008a;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.datepicker.a$a, reason: collision with other inner class name */
    public static final class C2771a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f191009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f191010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f191011c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C2771a) == true) goto L8;
            return false;
        L8:
            C2771a r101 = (C2771a) r100;
            if (this.f191009a == r101.f191009a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f191010b, r101.f191010b) == true) goto L15;
            return false;
        L15:
            if (this.f191011c == r101.f191011c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f191009a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f191010b.hashCode()) * 31) + this.f191011c;
        }

        public final String toString() {
            return "PendingCol(token=" + this.f191009a + ", entries=" + this.f191010b + ", selectedIndex=" + this.f191011c + ')';
        }

        public C2771a(long r100, List<String> r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "entries");
            this.f191009a = r100;
            this.f191010b = r101;
            this.f191011c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f191012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<List<String>> f191013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f191014c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f191012a == r101.f191012a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f191013b, r101.f191013b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f191014c, r101.f191014c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f191012a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f191013b.hashCode()) * 31) + Arrays.hashCode(this.f191014c);
        }

        public final String toString() {
            return "PendingRebuild(token=" + this.f191012a + ", columns=" + this.f191013b + ", selectedIndices=" + Arrays.toString(this.f191014c) + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(long r100, List<? extends List<String>> r101, int[] r102) {
            Intrinsics.checkNotNullParameter(r101, "columns");
            Intrinsics.checkNotNullParameter(r102, "selectedIndices");
            this.f191012a = r100;
            this.f191013b = r101;
            this.f191014c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f191015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f191016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<? extends List<String>> f191017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f191018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f191019e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean[] f191020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean[] f191021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int[] f191022h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<Integer, C2771a> f191023i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b f191024j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f191025k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<WheelView> f191026l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Map<Integer, Runnable> f191027m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f191028n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final long f191029o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final WeakReference<Activity> f191030p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public com.bytedance.applet.aibridge.datepicker.b f191031q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f191032r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final WeakReference<AppCompatDialog> f191033s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final WeakReference<FrameLayout> f191034t;

        /* JADX INFO: renamed from: com.bytedance.applet.aibridge.datepicker.a$c$a, reason: collision with other inner class name */
        public static final class C2772a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f191035a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f191036b;

            @Override // kv3.e
            public final void a(int r110) {
                c r100 = this.f191035a;
                boolean[] r101 = r100.f191020f;
                int r102 = this.f191036b;
                r101[r102] = false;
                C2771a r103 = r100.f191023i.remove(Integer.valueOf(r102));
                if (r103 != null) goto L5;
            L22:
                boolean r104 = false;
            L23:
                if (r104 == false) goto L27;
                this.f191035a.f();
                return;
            L27:
                if (Intrinsics.areEqual(ArraysKt.getOrNull(this.f191035a.f191021g, this.f191036b), Boolean.TRUE) == false) goto L30;
                c r111 = this.f191035a;
                r111.f191021g[this.f191036b] = false;
                r111.f();
                return;
            L30:
                this.f191035a.d(this.f191036b);
                this.f191035a.e(this.f191036b, r110, true);
                this.f191035a.f();
                return;
            L5:
                if (r103.f191009a != r100.f191025k) goto L7;
                boolean r105 = true;
            L8:
                if (r105 == true) goto L11;
                r103 = null;
            L11:
                if (r103 == null) goto L22;
                r100.a(r102, r103.f191010b, r103.f191011c);
                List<? extends List<String>> r106 = CollectionsKt.toMutableList(r100.f191017c);
                if (r102 >= 0) goto L16;
            L18:
                boolean r107 = false;
            L19:
                if (r107 == false) goto L21;
                ListProtector.set(r106, r102, r103.f191010b);
            L21:
                r100.f191017c = r106;
                r104 = true;
                goto L23
            L16:
                if (r102 >= r106.size()) goto L18;
                r107 = true;
                goto L19
            L7:
                r105 = false;
                goto L8
            }

            @Override // kv3.e
            public final void onChanged(final int r100) {
                Boolean r101 = ArraysKt.getOrNull(this.f191035a.f191021g, this.f191036b);
                Boolean r102 = Boolean.TRUE;
                if (Intrinsics.areEqual(r101, r102) == false) goto L5;
                this.f191035a.f191021g[this.f191036b] = false;
            L5:
                final c r103 = this.f191035a;
                boolean[] r104 = r103.f191020f;
                final int r105 = this.f191036b;
                r104[r105] = true;
                if (Intrinsics.areEqual(ArraysKt.getOrNull(r103.f191021g, r105), r102) == true) goto L18;
                Runnable r106 = r103.f191027m.remove(Integer.valueOf(r105));
                if (r106 == null) goto L13;
                FrameLayout r107 = r103.f191034t.get();
                if (r107 == null) goto L13;
                r107.removeCallbacks(r106);
            L13:
                Runnable r108 = new g(r103, r105, r100);
                Integer r109 = Integer.valueOf(r105);
                r103.f191027m.put(r109, r108);
                FrameLayout r110 = r103.f191034t.get();
                if (r110 == null) goto L17;
                r110.postDelayed(r108, r103.f191029o);
                return;
            L17:
                return;
            }

            public C2772a(c r100, int r101) {
                this.f191035a = r100;
                this.f191036b = r101;
            }
        }

        public final void c() {
            Iterator<T> r100 = this.f191027m.values().iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            Runnable r101 = (Runnable) r100.next();
            FrameLayout r102 = this.f191034t.get();
            if (r102 == null) goto L4;
            r102.removeCallbacks(r101);
            goto L4
        L8:
            this.f191027m.clear();
        }

        public final void f() {
            b r100 = this.f191024j;
            if (r100 == null) goto L47;
            boolean r101 = true;
            if (r100.f191012a != this.f191025k) goto L7;
            boolean r102 = true;
        L8:
            ViewGroup r103 = null;
            if (r102 == true) goto L12;
            r100 = null;
        L12:
            if (r100 == null) goto L51;
            boolean[] r104 = this.f191020f;
            int r105 = r104.length;
            int r106 = 0;
        L15:
            if (r106 >= r105) goto L20;
            if (r104[r106] == true) goto L21;
            r106 = r106 + 1;
        L21:
            if (r101 == false) goto L23;
            return;
        L23:
            this.f191024j = null;
            List<List<String>> r107 = r100.f191013b;
            this.f191017c = r107;
            int[] r108 = r100.f191014c;
            this.f191018d = r108;
            c();
            ((LinkedHashMap) this.f191023i).clear();
            this.f191024j = null;
            this.f191020f = new boolean[r107.size()];
            this.f191021g = new boolean[r107.size()];
            int r109 = r107.size();
            int[] r110 = new int[r109];
            int r111 = 0;
        L25:
            if (r111 >= r109) goto L27;
            r110[r111] = -1;
            r111 = r111 + 1;
            goto L25
        L27:
            this.f191022h = r110;
            int r112 = r107.size();
            ArrayList r113 = new ArrayList(r112);
            int r114 = 0;
        L28:
            if (r114 >= r112) goto L30;
            r113.add(null);
            r114 = r114 + 1;
            goto L28
        L30:
            this.f191026l = r113;
            FrameLayout r115 = this.f191034t.get();
            if (r115 == null) goto L48;
            final View r116 = r115.getChildAt(0);
            View r117 = b(r107, r108);
            if (r117 == null) goto L49;
            ViewParent r118 = r117.getParent();
            if ((r118 instanceof ViewGroup) == false) goto L37;
            r103 = (ViewGroup) r118;
        L37:
            if (r103 == null) goto L39;
            r103.removeView(r117);
        L39:
            r117.setAlpha(0.0f);
            r115.addView(r117, new FrameLayout.LayoutParams(-1, -2, 17));
            r117.animate().alpha(1.0f).setDuration(120).start();
            if (r116 == null) goto L50;
            r116.animate().alpha(0.0f).setDuration(120).withEndAction(new h(r116)).start();
            return;
        L50:
            return;
        L49:
            return;
        L48:
            return;
        L20:
            r101 = false;
            goto L21
        L51:
            return;
        L7:
            r102 = false;
            goto L8
        }

        public final void d(int r100) {
            Runnable r101 = this.f191027m.remove(Integer.valueOf(r100));
            if (r101 != null) goto L5;
            return;
        L5:
            FrameLayout r102 = this.f191034t.get();
            if (r102 == null) goto L9;
            r102.removeCallbacks(r101);
            return;
        }

        public final View b(List<? extends List<String>> r110, int[] r111) {
            AppCompatDialog r100 = this.f191033s.get();
            ViewGroup r101 = null;
            if (r100 == null) goto L39;
            OReelPickerMulti.a r102 = new OReelPickerMulti.a();
            Iterator<T> r103 = r110.iterator();
            int r104 = 0;
            int r105 = 0;
        L6:
            if (r103.hasNext() == false) goto L15;
            Object r106 = r103.next();
            int r107 = r105 + 1;
            if (r105 >= 0) goto L10;
            CollectionsKt.throwIndexOverflow();
        L10:
            List r108 = (List) r106;
            int r109 = this.f191028n + r105;
            Resources r112 = Resources.getSystem();
            Integer r113 = Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 72, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()))));
            Integer r114 = ArraysKt.getOrNull(r111, r105);
            if (r114 == null) goto L13;
            int r115 = r114.intValue();
        L14:
            iv3.a r116 = new iv3.a(r109, r108, r113, r115);
            Intrinsics.checkNotNullParameter(r116, "reel");
            ((ArrayList) r102.f191041a).add(r116);
            r105 = r107;
            goto L6
        L13:
            r115 = r108.size() / 2;
            goto L14
        L15:
            OReelPickerMulti r117 = r102.a(r100.getContext(), null, 0);
            Iterator<Integer> r118 = CollectionsKt.getIndices(r110).iterator();
        L17:
            if (r118.hasNext() == false) goto L23;
            int r119 = ((IntIterator) r118).nextInt();
            List<WheelView> r120 = CollectionsKt.toMutableList(this.f191026l);
            WheelView r121 = r117.R5(r119);
            if (r121 == null) goto L21;
            r121.setSelectedTextColor(this.f191015a);
            r121.setNormalTextColor(this.f191016b);
            Unit r122 = Unit.INSTANCE;
        L22:
            ListProtector.set(r120, r119, r121);
            this.f191026l = r120;
            goto L17
        L21:
            r121 = null;
            goto L22
        L23:
            Iterator<T> r123 = this.f191026l.iterator();
        L25:
            if (r123.hasNext() == false) goto L33;
            Object r124 = r123.next();
            int r125 = r104 + 1;
            if (r104 >= 0) goto L29;
            CollectionsKt.throwIndexOverflow();
        L29:
            WheelView r126 = (WheelView) r124;
            if (r126 == null) goto L32;
            r126.setOnWheelChangedListener(new C2772a(this, r104));
        L32:
            r104 = r125;
            goto L25
        L33:
            ViewParent r127 = r117.getParent();
            if ((r127 instanceof ViewGroup) == false) goto L36;
            r101 = (ViewGroup) r127;
        L36:
            if (r101 == null) goto L38;
            r101.removeView(r117);
        L38:
            return r117;
        L39:
            return null;
        }

        public final void a(int r100, List<String> r101, int r102) {
            final WheelView r103 = (WheelView) CollectionsKt.getOrNull(this.f191026l, r100);
            if (r103 != null) goto L5;
            return;
        L5:
            this.f191021g[r100] = true;
            d(r100);
            r103.setEntries(r101);
            final int r104 = RangesKt.coerceIn(r102, 0, RangesKt.coerceAtLeast(r101.size() - 1, 0));
            r103.post(new f(this, r103, r104));
        }

        public final void e(int r100, int r101, boolean r102) {
            Integer r103 = ArraysKt.getOrNull(this.f191022h, r100);
            if (r103 != null) goto L6;
        L9:
            if (r100 >= 0) goto L11;
        L13:
            boolean r104 = false;
        L14:
            if (r104 == false) goto L16;
            this.f191022h[r100] = r101;
        L16:
            this.f191019e++;
            Lazy r105 = d.f507201a;
            JsonObject r106 = new JsonObject();
            r106.addProperty("column", Integer.valueOf(r100));
            r106.addProperty("selectedIndex", Integer.valueOf(r101));
            r106.addProperty(DecodeProducer.EXTRA_IS_FINAL, Boolean.valueOf(r102));
            r106.addProperty("version", Long.valueOf(this.f191019e));
            Unit r107 = Unit.INSTANCE;
            d.c(new l3.a("applet.onCustomPickerOptionChanged", r106, 4));
            return;
        L11:
            if (r100 >= this.f191022h.length) goto L13;
            r104 = true;
            goto L14
        L6:
            if (r103.intValue() != r101) goto L9;
            if (r102 == true) goto L9;
        }

        public c(AppCompatDialog r100, Context r101, FrameLayout r102, int r103, int r104, List<? extends List<String>> r110, int[] r111) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            Intrinsics.checkNotNullParameter(r101, "ctx");
            Intrinsics.checkNotNullParameter(r102, "contentContainer");
            Intrinsics.checkNotNullParameter(r110, "columns");
            Intrinsics.checkNotNullParameter(r111, "selectedIndices");
            this.f191015a = r103;
            this.f191016b = r104;
            this.f191017c = r110;
            this.f191018d = r111;
            this.f191020f = new boolean[r110.size()];
            this.f191021g = new boolean[r110.size()];
            int r105 = r110.size();
            int[] r106 = new int[r105];
            int r107 = 0;
            int r108 = 0;
        L4:
            if (r108 >= r105) goto L6;
            r106[r108] = -1;
            r108 = r108 + 1;
            goto L4
        L6:
            this.f191022h = r106;
            this.f191023i = new LinkedHashMap();
            int r109 = r110.size();
            ArrayList r112 = new ArrayList(r109);
            int r113 = 0;
        L8:
            if (r113 >= r109) goto L10;
            r112.add(null);
            r113 = r113 + 1;
            goto L8
        L10:
            this.f191026l = r112;
            this.f191027m = new LinkedHashMap();
            this.f191028n = 9000;
            this.f191029o = 80;
            this.f191030p = new WeakReference((Activity) r101);
            this.f191033s = new WeakReference(r100);
            this.f191034t = new WeakReference(r102);
            c();
            ((LinkedHashMap) this.f191023i).clear();
            this.f191024j = null;
            this.f191020f = new boolean[r110.size()];
            this.f191021g = new boolean[r110.size()];
            int r114 = r110.size();
            int[] r115 = new int[r114];
            int r116 = 0;
        L11:
            if (r116 >= r114) goto L13;
            r115[r116] = -1;
            r116 = r116 + 1;
            goto L11
        L13:
            this.f191022h = r115;
            int r117 = r110.size();
            ArrayList r118 = new ArrayList(r117);
        L14:
            if (r107 >= r117) goto L16;
            r118.add(null);
            r107 = r107 + 1;
            goto L14
        L16:
            this.f191026l = r118;
            FrameLayout r119 = this.f191034t.get();
            if (r119 == null) goto L19;
            r119.removeAllViews();
        L19:
            View r120 = b(r110, r111);
            if (r120 == null) goto L25;
            FrameLayout r121 = this.f191034t.get();
            if (r121 == null) goto L25;
            r121.addView(r120, new FrameLayout.LayoutParams(-1, -2, 17));
        L25:
            if (this.f191030p.get() == null) goto L33;
            com.bytedance.applet.aibridge.datepicker.b r122 = new com.bytedance.applet.aibridge.datepicker.b(this);
            this.f191031q = r122;
            AppHost.f326268a.a().e(r122);
            return;
        }
    }

    static {
    }

    public static c b() {
        c r100 = f191008a;
        if (r100 != null) goto L5;
        return null;
    L5:
        AppCompatDialog r101 = r100.f191033s.get();
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.isShowing() != true) goto L10;
    L11:
        if (r102 == false) goto L13;
        return r100;
    L13:
        a(r100);
        return null;
    L10:
        r102 = false;
        goto L11
    }

    public static void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (f191008a != r100) goto L12;
        f191008a = null;
        if (r100.f191032r == true) goto L13;
        r100.f191032r = true;
        r100.c();
        com.bytedance.applet.aibridge.datepicker.b r101 = r100.f191031q;
        if (r101 == null) goto L10;
        AppHost.f326268a.a().f(r101);
    L10:
        r100.f191031q = null;
        return;
    L13:
        return;
    }
}
