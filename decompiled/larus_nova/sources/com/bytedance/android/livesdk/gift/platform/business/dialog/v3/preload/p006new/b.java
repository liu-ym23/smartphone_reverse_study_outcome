package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelPreloadView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<GiftPanelPreloadView, LinkedList<View>> f128200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, GiftPanelPreloadView> f128201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f128202c;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LayoutInflater f128203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FrameLayout f128204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Pair<GiftPanelPreloadView, Integer>> f128205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f128206d;

        public final void b() {
            Iterator r100 = ((ArrayList) this.f128205c).iterator();
        L4:
            if (r100.hasNext() == false) goto L24;
            Pair r101 = (Pair) r100.next();
            GiftPanelPreloadView r102 = (GiftPanelPreloadView) r101.component1();
            int r103 = ((Number) r101.component2()).intValue();
            b r104 = this.f128206d;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r102, "viewInfo");
            LinkedList<View> r105 = r104.f128200a.get(r102);
            if (r105 == null) goto L8;
            int r106 = r105.size();
        L10:
            if (r106 >= r102.getMaxCount()) goto L4;
            int r107 = Math.min(r103, r102.getMaxCount() - r106);
            int r108 = 1;
            if (1 > r107) goto L4;
        L15:
            if (r102.getHasParent() == false) goto L17;
            FrameLayout r109 = this.f128204b;
        L25:
            c(r102, this.f128203a.inflate(r102.getLayoutId(), r109, false));     // Catch: Exception -> L20
        L22:
            if (r108 == r107) goto L4;
            r108 = r108 + 1;
        L20:
            e = move-exception;
            jy0.b.b("ttlive_gift_preload_new", "inflate view for " + r102 + " failed", e);
            goto L22
        L17:
            r109 = null;
            goto L25
        L8:
            r106 = 0;
            goto L10
        }

        public a(b r100) {
            this.f128206d = r100;
            this.f128203a = LayoutInflater.from(r100.getContext()).cloneInContext(r100.getContext());
            this.f128204b = new FrameLayout(r100.getContext());
            this.f128205c = new ArrayList();
        }

        public final void a(GiftPanelPreloadView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            List<Pair<GiftPanelPreloadView, Integer>> r102 = this.f128205c;
            ArrayList r103 = (ArrayList) r102;
            r103.add(TuplesKt.to(r100, Integer.valueOf(r101)));
        }

        public final void c(GiftPanelPreloadView r100, View r101) {
            LinkedList<View> r102 = this.f128206d.f128200a.get(r100);
            if (r102 != null) goto L5;
            ConcurrentHashMap<GiftPanelPreloadView, LinkedList<View>> r103 = this.f128206d.f128200a;
            LinkedList<View> r104 = new LinkedList();
            r104.offer(r101);
            Unit r105 = Unit.INSTANCE;
            r103.put(r100, r104);
            return;
        L5:
            if (r102.size() < r100.getMaxCount()) goto L7;
            jy0.b.d("ttlive_gift_preload_new", r100 + " cache is full, count=" + r102.size());
            return;
        L7:
            r102.add(r101);
        }
    }

    public final Context getContext() {
        return this.f128202c;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f128202c = r100;
        this.f128200a = new ConcurrentHashMap();
        GiftPanelPreloadView[] r101 = GiftPanelPreloadView.values();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r101.length), 16));
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        GiftPanelPreloadView r105 = r101[r104];
        r102.put(Integer.valueOf(r105.getLayoutId()), r105);
        r104 = r104 + 1;
        goto L3
    L5:
        this.f128201b = r102;
    }
}
