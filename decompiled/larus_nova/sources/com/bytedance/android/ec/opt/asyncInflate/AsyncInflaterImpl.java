package com.bytedance.android.ec.opt.asyncInflate;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.ec.opt.asynctask.x;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\n\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0017R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/opt/asyncInflate/AsyncInflaterImpl;", "Lcom/bytedance/android/ec/opt/asyncInflate/ILifecycleInflater;", "", LiveCommonConstants.REASON_ON_DEDTROY, "Landroid/app/Activity;", ce.f26391f, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "InflateTask", "b", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class AsyncInflaterImpl implements ILifecycleInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, LinkedList<View>> f48009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Integer> f48010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, String> f48011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<w> f48012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f48013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f48014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f48015g;

    public final class InflateTask implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f48016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f48017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f48018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AsyncInflaterImpl f48019d;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final k r() {
            r r100 = new r();
            r100.f48048c = true;
            x r101 = r100.f48052g;
            r101.f48041b = true;
            return r101.f48042c;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f48019d.getActivity().isFinishing() == false) goto L5;
            return;
        L5:
            long r100 = SystemClock.elapsedRealtime();
            System.out.println("Django: Task: async inflate");     // Catch: Throwable -> L47 Exception -> L49
            Iterator<T> r101 = this.f48018c.f48021a.iterator();     // Catch: Throwable -> L47 Exception -> L49
        L8:
            if (r101.hasNext() == false) goto L28;
            Pair r102 = (Pair) r101.next();     // Catch: Throwable -> L47 Exception -> L49
            Object r103 = r102.getFirst();     // Catch: Throwable -> L47 Exception -> L49
            int r104 = ((Number) r102.getSecond()).intValue();     // Catch: Throwable -> L47 Exception -> L49
            int r105 = ((Number) r103).intValue();     // Catch: Throwable -> L47 Exception -> L49
            Integer r106 = this.f48019d.f48010b.get(Integer.valueOf(r105));     // Catch: Throwable -> L47 Exception -> L49
            if (r106 != null) goto L12;
            r106 = 0;     // Catch: Throwable -> L47 Exception -> L49
        L12:
            int r107 = r106.intValue();     // Catch: Throwable -> L47 Exception -> L49
            if (r107 > 0) goto L14;
            LinkedList<View> r108 = this.f48019d.f48009a.get(Integer.valueOf(r105));     // Catch: Throwable -> L47 Exception -> L49
            if (r108 != null) goto L18;
            r108 = new LinkedList();     // Catch: Throwable -> L47 Exception -> L49
            this.f48019d.f48009a.put(Integer.valueOf(r105), r108);     // Catch: Throwable -> L47 Exception -> L49
        L18:
            int r109 = 0;
        L19:
            if (r109 >= r104) goto L8;
            View r110 = ((LayoutInflater) this.f48016a.getValue()).inflate(r105, (FrameLayout) this.f48017b.getValue(), false);     // Catch: Throwable -> L47 Exception -> L49
            monitor-enter(r108);     // Catch: Throwable -> L47 Exception -> L49
            r108.offer(r110);     // Catch: Throwable -> L25
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L25
            monitor-exit(r108);     // Catch: Throwable -> L47 Exception -> L49
            r109 = r109 + 1;     // Catch: Throwable -> L47 Exception -> L49
        L25:
            th = move-exception;
            throw th;     // Catch: Throwable -> L47 Exception -> L49
        L14:
            this.f48019d.f48010b.put(Integer.valueOf(r105), Integer.valueOf(r107 - 1));     // Catch: Throwable -> L47 Exception -> L49
            System.out.println("Django: Task: first: dirty id");     // Catch: Throwable -> L47 Exception -> L49
            goto L8
        L28:
            Iterator<Map.Entry<Integer, Integer>> r112 = this.f48019d.f48010b.entrySet().iterator();     // Catch: Throwable -> L47 Exception -> L49
        L30:
            if (r112.hasNext() == false) goto L46;
            Map.Entry<Integer, Integer> r113 = r112.next();     // Catch: Throwable -> L47 Exception -> L49
            LinkedList<View> r114 = this.f48019d.f48009a.get(r113.getKey());     // Catch: Throwable -> L47 Exception -> L49
            if (r114 == null) goto L30;
            if (r113.getValue().intValue() <= 0) goto L30;
            int r115 = r113.getValue().intValue();     // Catch: Throwable -> L47 Exception -> L49
            int r116 = 0;
        L36:
            if (r116 >= r115) goto L44;
            monitor-enter(r114);     // Catch: Throwable -> L47 Exception -> L49
            System.out.println("Django: Task: double check: dirty id");     // Catch: Throwable -> L41
            r114.poll();     // Catch: Throwable -> L41
            Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L41
            monitor-exit(r114);     // Catch: Throwable -> L47 Exception -> L49
            r116 = r116 + 1;     // Catch: Throwable -> L47 Exception -> L49
        L41:
            th = move-exception;
            throw th;     // Catch: Throwable -> L47 Exception -> L49
        L44:
            this.f48019d.f48010b.put(r113.getKey(), Integer.valueOf(r113.getValue().intValue() - 1));     // Catch: Throwable -> L47 Exception -> L49
            goto L30
        L46:
            StringBuilder r118 = new StringBuilder("Django: Task: Transaction@");
        L52:
            r118.append(this.f48018c.hashCode());
            r118.append(" finished, duration = ");
            r118.append(SystemClock.elapsedRealtime() - r100);
            System.out.println(r118.toString());
            return;
        L47:
            th = move-exception;
            System.out.println("Django: Task: Transaction@" + this.f48018c.hashCode() + " finished, duration = " + (SystemClock.elapsedRealtime() - r100));
            throw th;
        L49:
            e = move-exception;
            System.out.println("Django: async inflate: " + e);     // Catch: Throwable -> L47
            r118 = new StringBuilder("Django: Task: Transaction@");
            goto L52
        }

        public InflateTask(AsyncInflaterImpl r100, b r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f48019d = r100;
            this.f48018c = r101;
            this.f48016a = LazyKt.lazy(new AsyncInflaterImpl$InflateTask$inflater$2(this));
            this.f48017b = LazyKt.lazy(new AsyncInflaterImpl$InflateTask$container$2(this));
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncInflaterImpl f48020a;

        public a(AsyncInflaterImpl r100) {
            this.f48020a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((LifecycleOwner) this.f48020a.getActivity()).getLifecycle().addObserver(this.f48020a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Pair<Integer, Integer>> f48021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f48022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AsyncInflaterImpl f48023c;

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final void commit() {
            if (this.f48022b == false) goto L5;
            AsyncInflaterImpl r100 = this.f48023c;
            r100.getClass();
            t.b(new com.bytedance.android.ec.opt.asyncInflate.a(r100, this));
            return;
        L5:
            AsyncInflaterImpl r101 = this.f48023c;
            r101.getClass();
            InflateTask r102 = new InflateTask(r101, this);
            ((ArrayList) r101.f48012d).add(r102);
            t.b(r102);
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d d(int r100) {
            this.f48023c.f48011c.put(Integer.valueOf(r100), "");
            List<Pair<Integer, Integer>> r101 = this.f48021a;
            ArrayList r102 = (ArrayList) r101;
            r102.add(TuplesKt.to(Integer.valueOf(r100), 1));
            return this;
        }

        public b(AsyncInflaterImpl r100, boolean r101) {
            this.f48023c = r100;
            this.f48022b = r101;
            this.f48021a = new ArrayList();
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d a(int r100, int r101) {
            this.f48023c.f48011c.put(Integer.valueOf(r100), "");
            List<Pair<Integer, Integer>> r102 = this.f48021a;
            ArrayList r103 = (ArrayList) r102;
            r103.add(TuplesKt.to(Integer.valueOf(r100), Integer.valueOf(r101)));
            return this;
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d b(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "name");
            this.f48023c.f48011c.put(Integer.valueOf(r100), r101);
            List<Pair<Integer, Integer>> r102 = this.f48021a;
            ArrayList r103 = (ArrayList) r102;
            r103.add(TuplesKt.to(Integer.valueOf(r100), 1));
            return this;
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d c(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "name");
            this.f48023c.f48011c.put(Integer.valueOf(r100), r102);
            List<Pair<Integer, Integer>> r103 = this.f48021a;
            ArrayList r104 = (ArrayList) r103;
            r104.add(TuplesKt.to(Integer.valueOf(r100), Integer.valueOf(r101)));
            return this;
        }
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ILifecycleInflater
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        System.out.println("Django: AsyncInflate: destroy task");
        this.f48009a.clear();
        Iterator r100 = ((ArrayList) this.f48012d).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        w r101 = (w) r100.next();
        int r102 = t.f48055a;
        if (r101 == null) goto L4;
        t.a(r101, 1);
        goto L4
    }

    public final Activity getActivity() {
        return this.f48015g;
    }

    public AsyncInflaterImpl(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f48015g = r100;
        this.f48009a = new ConcurrentHashMap();
        this.f48010b = new ConcurrentHashMap();
        this.f48011c = new LinkedHashMap();
        this.f48012d = new ArrayList();
        Lazy r101 = LazyKt.lazy(AsyncInflaterImpl$mainHandler$2.INSTANCE);
        this.f48013e = r101;
        this.f48014f = LazyKt.lazy(AsyncInflaterImpl$mAsyncInflateHandler$2.INSTANCE);
        if ((r100 instanceof LifecycleOwner) == false) goto L6;
        ((Handler) r101.getValue()).post(new a(this));
        return;
    }

    public final View aU(int r100, ViewGroup r101, boolean r102) {
        LinkedList<View> r103 = this.f48009a.get(Integer.valueOf(r100));
        if (r103 == null) goto L22;
        monitor-enter(r103);
        View r104 = r103.poll();     // Catch: Throwable -> L18
        if (r104 == null) goto L15;
        StringBuilder r105 = new StringBuilder("Django: AsyncInflate: has view, name = ");     // Catch: Throwable -> L18
        Map<Integer, String> r106 = this.f48011c;     // Catch: Throwable -> L18
        LinkedHashMap r107 = (LinkedHashMap) r106;     // Catch: Throwable -> L18
        r105.append((String) r107.get(Integer.valueOf(r100)));     // Catch: Throwable -> L18
        String r108 = r105.toString();     // Catch: Throwable -> L18
        System.out.println(r108);     // Catch: Throwable -> L18
        if (r101 == null) goto L12;
        if (r102 == false) goto L12;
        r101.addView(r104);     // Catch: Throwable -> L18
    L13:
        monitor-exit(r103);
        return r101;
    L12:
        r101 = r104;
        goto L13
    L15:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r103);
    L18:
        th = move-exception;
        throw th;
    L22:
        if (this.f48011c.containsKey(Integer.valueOf(r100)) == false) goto L28;
        StringBuilder r110 = new StringBuilder("Django: AsyncInflate: no view, name = ");
        Map<Integer, String> r111 = this.f48011c;
        LinkedHashMap r112 = (LinkedHashMap) r111;
        r110.append((String) r112.get(Integer.valueOf(r100)));
        String r113 = r110.toString();
        System.out.println(r113);
        Integer r114 = this.f48010b.get(Integer.valueOf(r100));
        if (r114 != null) goto L26;
        this.f48010b.put(Integer.valueOf(r100), 1);
        goto L28
    L26:
        this.f48010b.put(Integer.valueOf(r100), Integer.valueOf(r114.intValue() + 1));
    L28:
        return LayoutInflater.from(this.f48015g).cloneInContext(this.f48015g).inflate(r100, r101, r102);
    }
}
