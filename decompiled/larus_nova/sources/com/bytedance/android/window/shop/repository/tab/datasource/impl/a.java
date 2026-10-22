package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.dto.WindowExtensionDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.CardPosition;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mq3.a;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<P extends mq3.a, C extends ShopWindowDataSourceConfig<P>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f189450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f189451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f189452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.window.shop.c f189453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C f189454e;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.repository.tab.datasource.impl.a$a, reason: collision with other inner class name */
    public static final class C2761a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f189455a;

        public C2761a(a r100) {
            this.f189455a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            WindowTabDataListResponseDTODeprecated r101 = (WindowTabDataListResponseDTODeprecated) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r102 = WindowDataMapper.f189480a;
            List r103 = WindowDataMapper.c(r101.getMixFullCards());
            a r104 = this.f189455a;
            List<com.bytedance.android.window.shop.repository.dto.c> r105 = r101.getGlobalMixFullCards();
            r104.getClass();
            ArrayList r106 = new ArrayList();
            if (r105 == null) goto L18;
            Iterator<T> r107 = r105.iterator();
        L6:
            if (r107.hasNext() == false) goto L18;
            com.bytedance.android.window.shop.repository.dto.c r108 = (com.bytedance.android.window.shop.repository.dto.c) r107.next();
            Integer r109 = r108.c();
            if (r109 == null) goto L6;
            int r110 = r109.intValue();
            if (com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a(r110) == true) goto L11;
            com.bytedance.android.window.shop.repository.tab.entity.f r111 = WindowDataMapper.f(r108);
            if (r111 != null) goto L16;
            r106.addAll(WindowDataMapper.g(r108));
            goto L6
        L16:
            r106.add(r111);
            goto L6
        L11:
            v r112 = WindowDataMapper.e(r108, r110);
            if (r112 == null) goto L6;
            r106.add(r112);
        L18:
            Iterator r113 = r106.iterator();
        L20:
            if (r113.hasNext() == false) goto L22;
            com.bytedance.android.window.shop.repository.tab.entity.f r114 = (com.bytedance.android.window.shop.repository.tab.entity.f) r113.next();
            CardPosition r115 = CardPosition.GLOBAL;
            r114.getClass();
            Intrinsics.checkNotNullParameter(r115, "<set-?>");
            r114.f189556e = r115;
            goto L20
        L22:
            ((ArrayList) r103).addAll(r106);
            Unit r116 = Unit.INSTANCE;
            return TuplesKt.to(r101, r103);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f189456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c f189457b;

        public b(a r100, com.bytedance.android.window.shop.repository.tab.datasource.c r101) {
            this.f189456a = r100;
            this.f189457b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            WindowTabDataListResponseDTODeprecated r102 = (WindowTabDataListResponseDTODeprecated) r101.component1();
            List<com.bytedance.android.window.shop.repository.tab.entity.f> r103 = (List) r101.component2();
            a.a(this.f189456a, r103);
            com.bytedance.android.window.shop.repository.dto.v r104 = r102.getExtensionCardControl();
            if (r104 != null) goto L5;
        L6:
            this.f189456a.f189451b.update(r102.getHasMore());
        L7:
            this.f189456a.b(r102, r103, this.f189457b);
            a r105 = this.f189456a;
            r105.f((mq3.a) r105.f189454e.b(), r102);
            if (r102.getHasMore() == false) goto L18;
            List<com.bytedance.android.window.shop.repository.dto.c> r106 = r102.getMixFullCards();
            if (r106 != null) goto L12;
        L15:
            boolean r107 = true;
        L16:
            if (r107 == false) goto L18;
            this.f189456a.c(this.f189457b);
            goto L18
        L12:
            if (r106.isEmpty() == true) goto L15;
            r107 = false;
        L18:
            com.bytedance.android.window.shop.repository.dto.v r108 = r102.getExtensionCardControl();
            if (r108 != null) goto L21;
            return;
        L21:
            if (r108.b() != true) goto L33;
            a r109 = this.f189456a;
            com.bytedance.android.window.shop.repository.tab.datasource.c r110 = this.f189457b;
            r109.getClass();
            ShopRepository r111 = ShopRepository.f189409a;
            mq3.a r112 = (mq3.a) r109.f189454e.b();
            r111.getClass();
            Intrinsics.checkNotNullParameter(r112, "reqParam");
            ReplaySubject r113 = ReplaySubject.a();
            int r114 = kq3.a.f505586a;
            Intrinsics.checkNotNullParameter(r112, "reqParam");
            r112.getExtensionCardParam();
            ECWindowApi.f189411a.getClass();
            ECWindowApi r115 = ECWindowApi.a.f189412a;
            if (r115 == null) goto L29;
            String r116 = r112.getSecAuthorId();
            String r117 = r112.getExtensionCardParam();
            if (r117 != null) goto L27;
            r117 = "";
        L27:
            Observable<WindowExtensionDataListResponseDTO> r118 = r115.getWindowExtensionData(r116, r117);
            if (r118 == null) goto L29;
        L30:
            r118.subscribeOn(Schedulers.io()).subscribe(r113);
            Disposable r119 = bg4.b.b(r113.map(com.bytedance.android.window.shop.repository.tab.datasource.impl.b.f189465a)).subscribe(new com.bytedance.android.window.shop.repository.tab.datasource.impl.c(r109, r110), new com.bytedance.android.window.shop.repository.tab.datasource.impl.d(r109, r110));
            CompositeDisposable r120 = r109.f189450a;
            Intrinsics.checkNotNullParameter(r119, "$this$addTo");
            Intrinsics.checkNotNullParameter(r120, "d");
            r120.add(r119);
            return;
        L29:
            r118 = Observable.error(new Throwable("ECNetworkService not init"));
            goto L30
        L33:
            return;
        L5:
            if (r104.b() == true) goto L7;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f189458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c f189459b;

        public c(a r100, com.bytedance.android.window.shop.repository.tab.datasource.c r101) {
            this.f189458a = r100;
            this.f189459b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECExceptionMonitor.e((Throwable) r100);
            this.f189459b.onError("");
            this.f189458a.f189451b.f189471b = false;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f189460a = null;

        static {
            f189460a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            WindowTabDataListResponseDTODeprecated r101 = (WindowTabDataListResponseDTODeprecated) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r102 = WindowDataMapper.f189480a;
            return TuplesKt.to(r101, WindowDataMapper.c(r101.getMixFullCards()));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f189461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c f189462b;

        public e(a r100, com.bytedance.android.window.shop.repository.tab.datasource.c r101) {
            this.f189461a = r100;
            this.f189462b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            WindowTabDataListResponseDTODeprecated r102 = (WindowTabDataListResponseDTODeprecated) r101.component1();
            List<com.bytedance.android.window.shop.repository.tab.entity.f> r103 = (List) r101.component2();
            a.a(this.f189461a, r103);
            this.f189461a.f189451b.update(r102.getHasMore());
            this.f189461a.b(r102, r103, this.f189462b);
            a r104 = this.f189461a;
            r104.f((mq3.a) r104.f189454e.b(), r102);
            if (r102.getHasMore() == false) goto L14;
            List<com.bytedance.android.window.shop.repository.dto.c> r105 = r102.getMixFullCards();
            if (r105 != null) goto L7;
        L10:
            boolean r106 = true;
        L11:
            if (r106 == false) goto L15;
            this.f189461a.d(this.f189462b);
            return;
        L15:
            return;
        L7:
            if (r105.isEmpty() == true) goto L10;
            r106 = false;
            goto L11
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f189463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c f189464b;

        public f(a r100, com.bytedance.android.window.shop.repository.tab.datasource.c r101) {
            this.f189463a = r100;
            this.f189464b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f189464b.onError("");
            this.f189463a.f189451b.f189471b = false;
            ECExceptionMonitor.e((Throwable) r100);
        }
    }

    public final com.bytedance.android.window.shop.c getType() {
        return this.f189453d;
    }

    public static boolean e(WindowTabDataListResponseDTODeprecated r100) {
        Intrinsics.checkNotNullParameter(r100, "dto");
        if (r100.getHideEmptyStatus() == false) goto L6;
        return true;
    L6:
        if (r100.getMixFullCards() != null) goto L8;
        return false;
    L8:
        List<com.bytedance.android.window.shop.repository.dto.c> r101 = r100.getMixFullCards();
        if ((r101 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r102 = r101.iterator();
    L15:
        if (r102.hasNext() == false) goto L31;
        com.bytedance.android.window.shop.repository.dto.c r103 = (com.bytedance.android.window.shop.repository.dto.c) r102.next();
        Integer r104 = r103.c();
        if (r104 != null) goto L20;
    L21:
        Integer r105 = r103.c();
        if (r105 != null) goto L25;
    L27:
        boolean r106 = false;
    L29:
        if (r106 == false) goto L15;
        return true;
    L25:
        if (r105.intValue() != 208) goto L27;
    L28:
        r106 = true;
        goto L29
    L20:
        if (r104.intValue() == 101) goto L28;
    L31:
        return false;
    L11:
        if (r101.isEmpty() == false) goto L13;
        goto L13
    }

    public final synchronized void c(com.bytedance.android.window.shop.repository.tab.datasource.c r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "callback");     // Catch: Throwable -> L21
        g r101 = this.f189451b;     // Catch: Throwable -> L21
        if (r101.f189471b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r101.f189470a == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        r101.f189471b = true;     // Catch: Throwable -> L21
        mq3.a r102 = (mq3.a) this.f189454e.b();     // Catch: Throwable -> L21
        if (r102.getPageNum() == 0) goto L15;
    L17:
        r102.setFirstEnter(false);     // Catch: Throwable -> L21
        ShopRepository.f189409a.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r102, "reqParam");     // Catch: Throwable -> L21
        Observable r103 = kq3.a.c(r102);     // Catch: Throwable -> L21
    L18:
        Disposable r104 = bg4.b.b(r103.map(new C2761a(this))).subscribe(new b(this, r100), new c(this, r100));     // Catch: Throwable -> L21
        CompositeDisposable r105 = this.f189450a;     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r104, "$this$addTo");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r105, "d");     // Catch: Throwable -> L21
        r105.add(r104);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L15:
        if (this.f189454e.f189429b == null) goto L17;
        r102.setFirstEnter(true);     // Catch: Throwable -> L21
        C r106 = this.f189454e;     // Catch: Throwable -> L21
        WindowTabDataListResponseDTODeprecated r107 = r106.f189429b;     // Catch: Throwable -> L21
        r106.f189429b = null;     // Catch: Throwable -> L21
        r103 = Observable.just(r107);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(com.bytedance.android.window.shop.repository.tab.datasource.c r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "callback");     // Catch: Throwable -> L15
        g r101 = this.f189451b;     // Catch: Throwable -> L15
        if (r101.f189471b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r101.f189470a == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        r101.f189471b = true;     // Catch: Throwable -> L15
        ShopRepository r102 = ShopRepository.f189409a;     // Catch: Throwable -> L15
        mq3.a r103 = (mq3.a) this.f189454e.b();     // Catch: Throwable -> L15
        r102.getClass();     // Catch: Throwable -> L15
        Disposable r104 = bg4.b.b(ShopRepository.b(r103).map(d.f189460a)).subscribe(new e(this, r100), new f(this, r100));     // Catch: Throwable -> L15
        CompositeDisposable r105 = this.f189450a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r104, "$this$addTo");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r105, "d");     // Catch: Throwable -> L15
        r105.add(r104);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public a(com.bytedance.android.window.shop.c r100, C r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f189453d = r100;
        this.f189454e = r101;
        ((mq3.a) r101.b()).setTabType(r100.getType());
        this.f189450a = new CompositeDisposable();
        this.f189451b = new g();
        this.f189452c = 1;
    }

    public static final void a(a r100, List r101) {
        r100.f189452c = 0;
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L38;
        com.bytedance.android.window.shop.repository.tab.entity.f r103 = (com.bytedance.android.window.shop.repository.tab.entity.f) r102.next();
        com.bytedance.android.window.shop.repository.tab.entity.f r104 = null;
        if ((r103 instanceof m) == true) goto L8;
        com.bytedance.android.window.shop.repository.tab.entity.f r105 = null;
    L9:
        m r106 = (m) r105;
        if (r106 == null) goto L23;
        rq3.a r107 = r106.f189598j;
        if (r107 == null) goto L23;
        fo.b r108 = r107.C;
        if (r108 == null) goto L23;
        fo.a<Integer> r109 = wn.a.C;
        if (((Integer) r108.a(r109)) != null) goto L4;
        int r110 = r100.f189452c + 1;
        r100.f189452c = r110;
        Integer r111 = r103.f189553b;
        if (r111 == null) goto L21;
        r110 = r111.intValue();
    L21:
        Integer r112 = (Integer) r108.b(r109, Integer.valueOf(r110));
    L23:
        if ((r103 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == false) goto L26;
        r104 = r103;
    L26:
        if (r104 == null) goto L4;
        WindowV2ProductItemVO r113 = r104.c();
        if (r113 == null) goto L4;
        fo.b r114 = r113.C;
        if (r114 == null) goto L4;
        fo.a<Integer> r115 = wn.a.C;
        if (r114.a(r115) != null) goto L4;
        int r116 = r100.f189452c + 1;
        r100.f189452c = r116;
        Integer r117 = r103.f189553b;
        if (r117 == null) goto L37;
        r116 = r117.intValue();
    L37:
        r114.b(r115, Integer.valueOf(r116));
        goto L4
    L8:
        r105 = r103;
        goto L9
    }

    public void f(P r100, WindowTabDataListResponseDTODeprecated r101) {
        Intrinsics.checkNotNullParameter(r100, "reqParam");
        Intrinsics.checkNotNullParameter(r101, "windowTabDataListResponseDTO");
        r100.setPageNum(r101.getCursor());
        r100.setCommonPassThroughParam(r101.getCommonPassThrough());
        com.bytedance.android.window.shop.repository.dto.v r102 = r101.getExtensionCardControl();
        if (r102 != null) goto L5;
    L7:
        String r103 = null;
    L8:
        r100.setExtensionCardParam(r103);
        return;
    L5:
        if (r102.b() != true) goto L7;
        r103 = r101.getExtensionCardControl().a();
        goto L8
    }

    public void b(WindowTabDataListResponseDTODeprecated r100, List<com.bytedance.android.window.shop.repository.tab.entity.f> r101, com.bytedance.android.window.shop.repository.tab.datasource.c r102) {
        Intrinsics.checkNotNullParameter(r100, "dto");
        Intrinsics.checkNotNullParameter(r101, "voList");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if ((!r101.isEmpty()) == false) goto L6;
        r102.y(new n0(r101, this.f189453d, null, 12), ShopWindowVODataType.NORMAL);
    L6:
        if (r100.getHasMore() == true) goto L9;
        r102.c(this);
        return;
    }
}
