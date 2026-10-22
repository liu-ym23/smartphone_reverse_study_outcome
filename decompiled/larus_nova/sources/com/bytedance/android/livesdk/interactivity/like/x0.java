package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.config.f2;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.like.view.CustomDiggTapView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes9.dex */
public final class x0 extends com.bytedance.android.livesdk.interactivity.like.view.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CustomDiggTapView f137965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<ImageModel> f137966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f137967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Integer> f137968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<Bitmap> f137969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Bitmap> f137970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Room f137971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f137972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f137973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CompositeDisposable f137974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f137975n;

    public static final class a {
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a175";
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a
    public View getView() {
        return this;
    }

    @Override // v32.b
    public final Bitmap a() {
        if ((!this.f137970i.isEmpty()) == true) goto L5;
    L7:
        Bitmap r100 = null;
        if (getContext() != null) goto L11;
    L21:
        return r100;
    L11:
        if (this.f137968g.isEmpty() == true) goto L21;
        int r101 = ((Number) CollectionsKt.random(this.f137968g, Random.Default)).intValue();
        Context r102 = getContext();
        if (r102 == null) goto L21;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L21;
        r100 = this.f137969h.get(r101);
        if (r100 != null) goto L21;
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inPreferredConfig = Bitmap.Config.ARGB_4444;
        Unit r105 = Unit.INSTANCE;
        r100 = BitmapFactory.decodeResource(r103, r101, r104);
        this.f137969h.put(r101, r100);
        goto L21
    L5:
        if (this.f137967f == false) goto L7;
        return (Bitmap) CollectionsKt.random(this.f137970i, Random.Default);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public View getTapView() {
        CustomDiggTapView r100 = this.f137965d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void clear() {
        super.clear();
        int r100 = this.f137969h.size() - 1;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.f137969h.valueAt(r101).recycle();
        r101 = r101 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void init() {
        Context r100 = getContext();
        if (r100 == null) goto L27;
        this.f137965d = new CustomDiggTapView(r100);
        Resources r101 = r100.getResources();
        if (r101 == null) goto L18;
        Room r102 = this.f137971j;
        if (r102 != null) goto L9;
    L14:
        TypedArray r103 = r101.obtainTypedArray(R.array.ttlive_barrage);
        int r104 = r103.length();
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L17;
        this.f137968g.add(Integer.valueOf(r103.getResourceId(r105, 0)));
        r105 = r105 + 1;
        goto L15
    L17:
        r103.recycle();
        goto L18
    L9:
        if (r102.isMediaRoom() != true) goto L14;
        TypedArray r106 = r101.obtainTypedArray(R.array.ttlive_media_barrage);
        int r107 = r106.length();
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L13;
        this.f137968g.add(Integer.valueOf(r106.getResourceId(r108, 0)));
        r108 = r108 + 1;
        goto L11
    L13:
        r106.recycle();
    L18:
        int r109 = com.bytedance.android.livesdk.interactivity.like.utils.b.f137723a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.b(getSpm(), "Start Fetch Digg Icon");
        Room r110 = this.f137971j;
        if (r110 == null) goto L23;
        long r111 = r110.getRoomId();
        Disposable r112 = ((DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class)).getIcons(r111).subscribeOn(Schedulers.io()).flatMap(new y0(this)).filter(z0.f137979a).observeOn(AndroidSchedulers.mainThread()).subscribe(new a1(this), new b1(this), new c1(this));
        CompositeDisposable r113 = this.f137974m;
        if (r113 == null) goto L23;
        r113.add(r112);
    L23:
        super.init();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void load() {
        super.load();
        this.f137974m = new CompositeDisposable();
        CustomDiggTapView r100 = this.f137965d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L5:
        boolean r101 = r100 instanceof com.bytedance.android.livesdk.interactivity.like.view.z;
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.a, v32.b
    public final void unload() {
        super.unload();
        CompositeDisposable r100 = this.f137974m;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        CompositeDisposable r101 = this.f137974m;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        CustomDiggTapView r102 = this.f137965d;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L12:
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L17;
        r102.clear();
        return;
    }

    public final Room getRoom() {
        return this.f137971j;
    }

    public x0(Context r100, DataCenter r101) {
        super(r100, r101);
        this.f137966e = new ArrayList();
        this.f137968g = new ArrayList();
        this.f137969h = new SparseArray();
        this.f137970i = Collections.newSetFromMap(new ConcurrentHashMap());
        if (r101 == null) goto L5;
        Room r102 = com.bytedance.android.live.core.utils.z.o(r101);
    L6:
        this.f137971j = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // v32.b
    public final boolean b(PointF r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "point");
        long r102 = f2.f120170a.getValue().longValue();
        Intrinsics.checkNotNullParameter(r100, "point");
        long r103 = SystemClock.elapsedRealtime();
        boolean r104 = true;
        if (r101 == false) goto L23;
        if ((r103 - this.f137972k) > r102) goto L20;
        Disposable r105 = this.f137973l;     // Catch: Throwable -> L42
        if (r105 == null) goto L9;
        r105.dispose();     // Catch: Throwable -> L42
    L9:
        this.f137973l = Observable.timer(r102, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d1(this));     // Catch: Throwable -> L42
        this.f137975n++;     // Catch: Throwable -> L42
        Iterator<v32.a> r106 = getControllerList().iterator();     // Catch: Throwable -> L42
    L11:
        if (r106.hasNext() == false) goto L15;
        v32.a r107 = r106.next();     // Catch: Throwable -> L42
        if ((r107 instanceof v32.c) == false) goto L11;
        ((v32.c) r107).a(r100, this.f137975n);     // Catch: Throwable -> L42
        goto L11
    L15:
        DiggContext.a r108 = DiggContext.Companion;     // Catch: Throwable -> L42
        DataCenter r109 = getDataCenter();     // Catch: Throwable -> L42
        r108.getClass();     // Catch: Throwable -> L42
        DiggContext r110 = DiggContext.a.a(r109);     // Catch: Throwable -> L42
        if (r110 == null) goto L21;
        com.bytedance.live.datacontext.m<Long> r111 = r110.getDiggTime();     // Catch: Throwable -> L42
        if (r111 == null) goto L21;
        r111.setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
    L21:
        this.f137972k = r103;
        return r104;
    L20:
        r104 = false;
        this.f137975n = 0;     // Catch: Throwable -> L42
        goto L21
    L23:
        if ((r103 - this.f137972k) > r102) goto L25;
        this.f137975n++;     // Catch: Throwable -> L42
    L26:
        Disposable r112 = this.f137973l;     // Catch: Throwable -> L42
        if (r112 == null) goto L29;
        r112.dispose();     // Catch: Throwable -> L42
    L29:
        this.f137973l = Observable.timer(r102, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e1(this));     // Catch: Throwable -> L42
        Iterator<v32.a> r113 = getControllerList().iterator();     // Catch: Throwable -> L42
    L31:
        if (r113.hasNext() == false) goto L35;
        v32.a r114 = r113.next();     // Catch: Throwable -> L42
        if ((r114 instanceof v32.c) == false) goto L31;
        ((v32.c) r114).a(r100, this.f137975n);     // Catch: Throwable -> L42
        goto L31
    L35:
        DiggContext.a r115 = DiggContext.Companion;     // Catch: Throwable -> L42
        DataCenter r116 = getDataCenter();     // Catch: Throwable -> L42
        r115.getClass();     // Catch: Throwable -> L42
        DiggContext r117 = DiggContext.a.a(r116);     // Catch: Throwable -> L42
        if (r117 == null) goto L21;
        com.bytedance.live.datacontext.m<Long> r118 = r117.getDiggTime();     // Catch: Throwable -> L42
        if (r118 == null) goto L21;
        r118.setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
        goto L21
    L25:
        this.f137975n = 1;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.f137972k = r103;
        throw th;
    }
}
