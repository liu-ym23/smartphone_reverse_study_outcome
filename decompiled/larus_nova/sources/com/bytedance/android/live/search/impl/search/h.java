package com.bytedance.android.live.search.impl.search;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.br0;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.discover.model.SearchNilInfo;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f100754k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f100755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f100756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f100757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f100758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f100759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f100760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ra1.e f100761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f100762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f100763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qa1.d<ra1.f> f100764j;

    public static final class a {
    }

    public static final class b implements qa1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f100765a;

        @Override // qa1.a
        public final void a() {
            h r100 = this.f100765a;
            r100.f100755a = false;
            qa1.d<ra1.f> r101 = r100.f100764j;
            new JsonObject();
            r101.r6();
        }

        public b(h r100) {
            this.f100765a = r100;
        }

        @Override // qa1.a
        public final void c(Throwable r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            h r102 = this.f100765a;
            r102.f100755a = false;
            if (r101 == false) goto L5;
            r102.f100764j.cF(new Exception(r100));
            return;
        L5:
            r102.f100764j.q10(new Exception(r100));
        }

        @Override // qa1.a
        public final void b(ra1.b r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "response");
            Intrinsics.checkNotNullParameter(r102, "keyWord");
            h r103 = this.f100765a;
            r103.f100755a = false;
            r103.f100758d = true;
            List<ra1.f> r104 = r100.f();
            if (r104 != null) goto L5;
        L12:
            if (r101 == true) goto L17;
            this.f100765a.f100764j.r6();
            return;
        L17:
            return;
        L5:
            if ((!r104.isEmpty()) == true) goto L8;
            r104 = null;
        L8:
            if (r104 == null) goto L12;
            if (r101 == false) goto L11;
            h r105 = this.f100765a;
            r105.f100761g = r100.k(r105.f100761g);
            h r106 = this.f100765a;
            r106.f100764j.C6(r104, r106.f100758d);
            return;
        L11:
            this.f100765a.f100761g = r100.a();
            h r107 = this.f100765a;
            r107.f100764j.Hm(r104, r107.f100758d, r102, true);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f100766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f100767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f100768c;

        public c(h r100, long r101, String r102) {
            this.f100766a = r100;
            this.f100767b = r101;
            this.f100768c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ra1.e r101 = (ra1.e) r100;
            long r102 = this.f100767b;
            h r103 = this.f100766a;
            if (r102 != r103.f100759e) goto L54;
            r103.f100761g = r101.a();
            h r104 = this.f100766a;
            boolean r105 = false;
            r104.f100755a = false;
            r104.f100758d = r101.d();
            this.f100766a.f100756b = r101.c();
            this.f100766a.f100757c = r101.e();
            if (r101.i() != 2483) goto L8;
        L40:
            qa1.d<ra1.f> r106 = this.f100766a.f100764j;
            if (r101.i() != 2483) goto L43;
            r105 = true;
        L43:
            r106.dH(r105);
            return;
        L8:
            if (SearchNilInfo.HIT_LIMIT.equals(r101.j()) == true) goto L40;
            this.f100766a.f100764j.Ac(r101.g(), r101.e());
            List<ra1.f> r107 = r101.f();
            if (r107 != null) goto L13;
        L30:
            h r108 = this.f100766a;
            Integer r109 = br0.f119894a.getValue();
            if (r109 != null) goto L34;
        L39:
            r108.f100764j.r6();
            return;
        L34:
            if (r109.intValue() != 1) goto L39;
            if (r101.h() == false) goto L38;
            r108.f100763i.b(false, this.f100768c);
            r108.f100755a = true;
            return;
        L38:
            r108.f100764j.r6();
            return;
        L13:
            if ((!r107.isEmpty()) == true) goto L16;
            r107 = null;
        L16:
            if (r107 == null) goto L30;
            Iterator<T> r110 = r107.iterator();
        L19:
            if (r110.hasNext() == false) goto L29;
            ra1.f r111 = (ra1.f) r110.next();
            ra1.a r112 = r111.a();
            if (r112 == null) goto L23;
            String r113 = r101.e();
            Intrinsics.checkNotNullParameter(r113, "<set-?>");
            r112.f536803a = r113;
        L23:
            ra1.a r114 = r111.a();
            if (r114 == null) goto L19;
            JsonObject r115 = r101.g();
            if (r115 != null) goto L28;
            r115 = new JsonObject();
        L28:
            Intrinsics.checkNotNullParameter(r115, "<set-?>");
            r114.f536804b = r115;
            goto L19
        L29:
            h r116 = this.f100766a;
            r116.f100764j.Hm(r107, r116.f100758d, this.f100768c, false);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f100769a;

        public d(h r100) {
            this.f100769a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            h r101 = this.f100769a;
            r101.f100755a = false;
            r101.f100764j.q10(new Exception((Throwable) r100));
        }
    }

    static {
    }

    public h(qa1.d<ra1.f> r100) {
        Intrinsics.checkNotNullParameter(r100, "presenterCallback");
        this.f100764j = r100;
        this.f100757c = "";
        this.f100758d = true;
        this.f100760f = "normal_search";
        this.f100763i = new e(new b(this));
    }

    public final void a(String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "keyWord");
        if (this.f100755a == false) goto L12;
        Disposable r100 = this.f100762h;
        if (r100 == null) goto L12;
        if (r100.isDisposed() == true) goto L12;
        Disposable r101 = this.f100762h;
        if (r101 == null) goto L12;
        r101.dispose();
    L12:
        if (TextUtils.isEmpty(r111) == true) goto L17;
        if (r111 != null) goto L15;
        String r102 = "";
    L16:
        this.f100760f = r102;
        goto L17
    L15:
        r102 = r111;
    L17:
        String r103 = "normal_search";
        if (Intrinsics.areEqual("default_search_keyword", r111) == false) goto L20;
        this.f100760f = "normal_search";
    L20:
        e r104 = this.f100763i;
        if (r112 == false) goto L23;
        int r105 = 10;
    L24:
        r104.f100735b = r105;
        if (r112 == false) goto L27;
        String r106 = "homepage_fresh-live_cover";
    L28:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r104.f100736c = r106;
        this.f100755a = true;
        long r113 = this.f100759e + 1;
        this.f100759e = r113;
        this.f100756b = 0;
        this.f100764j.showLoading();
        ILiveSearchApi r107 = (ILiveSearchApi) com.bytedance.android.live.network.c.b().e(ILiveSearchApi.class);
        long r108 = this.f100756b;
        if (TextUtils.isEmpty(this.f100760f) == true) goto L32;
        r103 = this.f100760f;
    L32:
        String r109 = r103;
        String r114 = ((IHostBusiness) jc1.k.n(IHostBusiness.class)).getNeedPersonalRecommend();
        if (r114 != null) goto L35;
        r114 = "1";
    L35:
        this.f100762h = r107.searchLiveList("https://search.amemv.com/aweme/v1/live/search/", r108, r110, 12, r109, "aweme_live_square", "", r114, ((IHostBusiness) jc1.k.n(IHostBusiness.class)).getCurrentBcmChain()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r113, r110), new d(this));
        return;
    L27:
        r106 = "live_merge-live_cover";
        goto L28
    L23:
        r105 = 21;
        goto L24
    }
}
