package com.bytedance.android.live.broadcastgame.xplay.perf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0011\u0012B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/perf/XplayPerfPanelView;", "Landroid/widget/FrameLayout;", "Lj20/c;", "", "isVisible", "", "setPerformancePanelVisible", "Landroid/view/View;", "getView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayPerfPanelView extends FrameLayout implements j20.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m20.a f62312o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f62313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f62314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f62315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f62316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f62317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f62318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f62319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f62320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f62321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f62322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f62323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f62324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f62325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OpenPlatformPerfDog f62326n;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XplayPerfPanelView f62327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f62328b;

        public a(XplayPerfPanelView r100, View r101) {
            this.f62327a = r100;
            this.f62328b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            XplayPerfPanelView r101 = this.f62327a;
            boolean r102 = !r101.f62325m;
            r101.f62325m = r102;
            if (r102 == false) goto L7;
            ImageView r103 = r101.f62314b;
            if (r103 == null) goto L10;
            r103.setImageResource(R.drawable.ttlive_ic_close);
        L10:
            View r104 = this.f62328b.findViewById(R.id.title);
            if (r104 == null) goto L13;
            UtilityKotlinExtentionsKt.v(r104, this.f62327a.f62325m);
        L13:
            View r105 = this.f62328b.findViewById(R.id.data_panel);
            if (r105 == null) goto L16;
            UtilityKotlinExtentionsKt.v(r105, this.f62327a.f62325m);
        L16:
            View r106 = this.f62328b.findViewById(R.id.divider_line);
            if (r106 == null) goto L20;
            UtilityKotlinExtentionsKt.v(r106, this.f62327a.f62325m);
            return;
        L20:
            return;
        L7:
            ImageView r107 = r101.f62314b;
            if (r107 == null) goto L10;
            r107.setImageResource(R.drawable.ttlive_ic_more);
            goto L10
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f62329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f62330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f62331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f62332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f62333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f62334f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L18;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f62329a, r101.f62329a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f62330b, r101.f62330b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f62331c, r101.f62331c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f62332d, r101.f62332d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f62333e, r101.f62333e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f62334f, r101.f62334f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f62329a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f62330b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f62331c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f62332d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f62333e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f62334f;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
            return "DebugPerfData(avgCpu=" + this.f62329a + ", avgGpu=" + this.f62330b + ", avgMem=" + this.f62331c + ", avgStutter=" + this.f62332d + ", avgFps=" + this.f62333e + ", maxTemperature=" + this.f62334f + ")";
        }

        public c(String r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "avgCpu");
            Intrinsics.checkNotNullParameter(r101, "avgGpu");
            Intrinsics.checkNotNullParameter(r102, "avgMem");
            Intrinsics.checkNotNullParameter(r103, "avgStutter");
            Intrinsics.checkNotNullParameter(r104, "avgFps");
            Intrinsics.checkNotNullParameter(r105, "maxTemperature");
            this.f62329a = r100;
            this.f62330b = r101;
            this.f62331c = r102;
            this.f62332d = r103;
            this.f62333e = r104;
            this.f62334f = r105;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XplayPerfPanelView f62335a;

        public d(XplayPerfPanelView r100) {
            this.f62335a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            XplayPerfPanelView r102 = this.f62335a;
            m20.a r103 = XplayPerfPanelView.f62312o;
            r102.getClass();
            r102.f62317e = Observable.create(new m20.b(r102)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m20.c(r102), m20.d.f511638a);
        }
    }

    public XplayPerfPanelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public XplayPerfPanelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // j20.c
    public View getView() {
        return this;
    }

    static {
        f62312o = new m20.a(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPerformancePanelVisible(false);
    }

    @Override // j20.c
    public void setPerformancePanelVisible(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        int r101 = 0;
        if (r100 == false) goto L9;
        setVisibility(0);
        this.f62316d = Observable.interval(0, 5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this));
        return;
    L9:
        this.f62324l = 0;
        float[] r102 = new float[6];
        r102[0] = this.f62318f;
        r102[1] = this.f62319g;
        r102[2] = this.f62320h;
        r102[3] = this.f62321i;
        r102[4] = this.f62322j;
        r102[5] = this.f62323k;
    L10:
        if (r101 >= 6) goto L12;
        r102[r101] = 0.0f;
        r101 = r101 + 1;
        goto L10
    L12:
        setVisibility(8);
        Disposable r103 = this.f62316d;
        if (r103 == null) goto L15;
        r103.dispose();
    L15:
        this.f62316d = null;
        Disposable r104 = this.f62317e;
        if (r104 == null) goto L21;
        r104.dispose();
        return;
    L21:
        return;
    L4:
        if (getVisibility() != 0) goto L6;
    }

    public XplayPerfPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ArrayList r103 = new ArrayList();
        this.f62315c = r103;
        this.f62325m = true;
        this.f62326n = OpenPlatformPerfDog.f60705p;
        setVisibility(8);
        View r104 = FrameLayout.inflate(r100, R.layout.ttlive_xplay_perf_panel_layout, this);
        ImageView r105 = (ImageView) r104.findViewById(R.id.iv_close);
        r105.setOnClickListener(new a(this, r104));
        Unit r106 = Unit.INSTANCE;
        this.f62314b = r105;
        RecyclerView r107 = (RecyclerView) r104.findViewById(R.id.data_list);
        r107.setAdapter(new GroupDataAdapter(r103, r100));
        r107.setLayoutManager(new LinearLayoutManager(r100, 1, false));
        this.f62313a = r107;
    }

    public static String a(XplayPerfPanelView r100, float r101, int r102) {
        r100.getClass();
        float r103 = r101 / r102;
        float r104 = (float) Math.pow(10.0f, 2);
        return String.valueOf(((int) ((r103 * r104) + 0.5f)) / r104);
    }

    public /* synthetic */ XplayPerfPanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
