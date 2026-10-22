package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.e0;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f61109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.live.broadcastgame.opengame.test.a> f61110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<String> f61111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f61112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f61113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f61114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f61115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f61116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f61117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f61118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f61119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f61120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f61121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f61122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f61123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ i20.a f61124p;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61125a;

        public a(ViewGroup r100) {
            this.f61125a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f61125a.getVisibility() != 0) goto L5;
            this.f61125a.setVisibility(8);
            return;
        L5:
            this.f61125a.setVisibility(0);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f61126a;

        public b(d r100) {
            this.f61126a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r100), Boolean.FALSE) == false) goto L6;
            d r101 = this.f61126a;
            r101.f61113e = 0.0f;
            r101.f61114f = 0.0f;
            r101.f61121m = 0;
            r101.f61122n = 0;
            return;
        }
    }

    public static class c {
        public c() {
        }

        public c(int r100) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.test.d$d, reason: collision with other inner class name */
    public static final class C1012d {
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f61127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f61128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f61129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f61130d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f61131e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f61132f;

        public e(String r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "avgCpu");
            Intrinsics.checkNotNullParameter(r101, "avgMem");
            Intrinsics.checkNotNullParameter(r102, "avgStutter");
            Intrinsics.checkNotNullParameter(r103, "avgFps");
            Intrinsics.checkNotNullParameter(r104, "lowFpsRate");
            Intrinsics.checkNotNullParameter(r105, "maxTemperature");
            super(0);
            this.f61127a = r100;
            this.f61128b = r101;
            this.f61129c = r102;
            this.f61130d = r103;
            this.f61131e = r104;
            this.f61132f = r105;
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f61133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f61134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f61135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f61136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f61137e;

        public f(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "cpu");
            Intrinsics.checkNotNullParameter(r101, DocFeed$Value$DataSource.MEM);
            Intrinsics.checkNotNullParameter(r102, "stutter");
            Intrinsics.checkNotNullParameter(r103, "fps");
            Intrinsics.checkNotNullParameter(r104, IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE);
            super(0);
            this.f61133a = r100;
            this.f61134b = r101;
            this.f61135c = r102;
            this.f61136d = r103;
            this.f61137e = r104;
        }
    }

    public static final class g<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f61138a;

        public g(d r100) {
            this.f61138a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<c> r210) {
            Intrinsics.checkNotNullParameter(r210, "it");
            float r100 = d.a(this.f61138a).b();
            float r101 = d.a(this.f61138a).c();
            float r102 = d.a(this.f61138a).a();
            float r103 = d.a(this.f61138a).getUIStallRate();
            float r104 = d.a(this.f61138a).d();
            AnchorGameContext.Companion.getClass();
            AnchorGameContext r105 = AnchorGameContext.a.a();
            if (r105 == null) goto L9;
            m<Boolean> r106 = r105.getOpenGamePerfUploadState();
            if (r106 == null) goto L9;
            if (r106.getValue().booleanValue() != true) goto L9;
            this.f61138a.getClass();
            String r110 = d.b(r101);
            StringCompanionObject r107 = StringCompanionObject.INSTANCE;
            String r111 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r102)}, 1));
            this.f61138a.getClass();
            r210.onNext(new f(r110, r111, d.b(r103), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r100)}, 1)), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r104)}, 1))));
        L16:
            r210.onComplete();
            return;
        L9:
            d r108 = this.f61138a;
            int r112 = r108.f61121m + 1;
            r108.f61121m = r112;
            float r113 = r108.f61115g + r101;
            r108.f61115g = r113;
            float r109 = r112;
            float r114 = r113 / r109;
            float r115 = r108.f61117i + r102;
            r108.f61117i = r115;
            r108.f61116h = r115 / r109;
            float r116 = r108.f61119k + r103;
            r108.f61119k = r116;
            r108.f61118j = r116 / r109;
            float r117 = r108.f61114f + r100;
            r108.f61114f = r117;
            r108.f61113e = r117 / r109;
            if (r104 <= r108.f61120l) goto L13;
            r108.f61120l = r104;
        L13:
            if (r100 >= 13) goto L15;
            r108.f61122n++;
        L15:
            r108.f61123o = r108.f61122n / r109;
            String r118 = d.b(r114);
            StringCompanionObject r119 = StringCompanionObject.INSTANCE;
            r210.onNext(new e(r118, String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.f61138a.f61116h)}, 1)), d.b(this.f61138a.f61118j), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.f61138a.f61113e)}, 1)), d.b(this.f61138a.f61123o), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.f61138a.f61120l)}, 1))));
            goto L16
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f61139a;

        public h(d r100) {
            this.f61139a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            c r101 = (c) r100;
            this.f61139a.f61111c.clear();
            if ((r101 instanceof f) == false) goto L6;
            LinkedList<String> r102 = this.f61139a.f61111c;
            StringBuilder r103 = new StringBuilder("CPU(瞬时): ");
            f r104 = (f) r101;
            r103.append(r104.f61133a);
            r102.add(r103.toString());
            this.f61139a.f61111c.add("内存(MB)(瞬时) : " + r104.f61134b);
            this.f61139a.f61111c.add("卡顿率(瞬时) : " + r104.f61135c);
            this.f61139a.f61111c.add("推流帧率(瞬时) : " + r104.f61136d);
            this.f61139a.f61111c.add("温度(瞬时): " + r104.f61137e);
        L8:
            RecyclerView.Adapter r105 = this.f61139a.f61112d.getAdapter();
            if (r105 == null) goto L12;
            r105.notifyDataSetChanged();
            return;
        L12:
            return;
        L6:
            if ((r101 instanceof e) == false) goto L8;
            LinkedList<String> r106 = this.f61139a.f61111c;
            StringBuilder r107 = new StringBuilder("CPU(均值): ");
            e r108 = (e) r101;
            r107.append(r108.f61127a);
            r106.add(r107.toString());
            this.f61139a.f61111c.add("内存(MB)(均值) : " + r108.f61128b);
            this.f61139a.f61111c.add("卡顿率(均值): " + r108.f61129c);
            this.f61139a.f61111c.add("推流帧率(均值): " + r108.f61130d);
            this.f61139a.f61111c.add("推流帧率低值占比: " + r108.f61131e);
            this.f61139a.f61111c.add("温度最大值: " + r108.f61132f);
            goto L8
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f61140a = null;

        static {
            f61140a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.d("OpenPlatformPerformancePanel", ((Throwable) r100).toString());
        }
    }

    static {
    }

    public final void c() {
        Disposable r100 = Observable.create(new g(this)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this), i.f61140a);
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f61124p.a(r100);
    }

    private final e0 getOpenPlatformPerfProvider() {
        return OpenPlatformPerfDog.f60705p;
    }

    public static final /* synthetic */ e0 a(d r100) {
        return r100.getOpenPlatformPerfProvider();
    }

    public static String b(float r100) {
        if (r100 >= 0) goto L9;
        r100 = 0.0f;
    L9:
        NumberFormat r101 = NumberFormat.getPercentInstance();     // Catch: ParseException -> L7
        r101.setMaximumFractionDigits(2);     // Catch: ParseException -> L7
        return r101.format(Float.valueOf(r100));
    L7:
        return "0";
    }

    public d(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        super(r100);
        i20.a r102 = new i20.a();
        this.f61124p = r102;
        ArrayList<com.bytedance.android.live.broadcastgame.opengame.test.a> r103 = new ArrayList();
        this.f61110b = r103;
        LinkedList<String> r104 = new LinkedList();
        this.f61111c = r104;
        setVisibility(8);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(s1.f(185), -2);
        r105.topMargin = s1.f(176);
        r105.rightMargin = s1.f(10);
        r105.gravity = GravityCompat.END;
        r101.addView(this, r105);
        View r106 = FrameLayout.inflate(r100, R.layout.ttlive_open_game_debug_performance_monitor_panel, null);
        RecyclerView r107 = (RecyclerView) r106.findViewById(R.id.data_list);
        r107.setAdapter(new GroupDataAdapter(r103, r100));
        r107.setLayoutManager(new LinearLayoutManager(r100, 1, false));
        Unit r108 = Unit.INSTANCE;
        this.f61112d = r107;
        ((TextView) r106.findViewById(R.id.title)).setOnClickListener(new a((ViewGroup) r106.findViewById(R.id.data_panel)));
        addView(r106);
        r103.add(new com.bytedance.android.live.broadcastgame.opengame.test.a(r104));
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r109 = AnchorGameContext.a.a();
        if (r109 == null) goto L12;
        n<Boolean> r110 = r109.getHasOpenGameLaunch();
        if (r110 == null) goto L13;
        Observable<sh6.b<Boolean>> r111 = r110.a();
        if (r111 == null) goto L14;
        Disposable r112 = r111.subscribe(new b(this));
        if (r112 == null) goto L15;
        Intrinsics.checkNotNullParameter(r112, "$this$autoDispose");
        r102.a(r112);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
