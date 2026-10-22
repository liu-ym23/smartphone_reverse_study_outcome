package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f123267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f123268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f123269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile List<? extends m> f123270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, m> f123271e = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/state/cloud/a$a;", "", "", "version", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/m;", "factors", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C1965a {

        @SerializedName("factors")
        private final List<m> factors;

        @SerializedName("version")
        private final String version;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1965a) == false) goto L10;
            C1965a r101 = (C1965a) r100;
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.factors, r101.factors) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.version;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<m> r104 = this.factors;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CloudFactorData(version=" + this.version + ", factors=" + this.factors + ")";
        }

        public final List<m> a() {
            return this.factors;
        }

        public final String b() {
            return this.version;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C1965a(String r100, List<? extends m> r101) {
            Intrinsics.checkNotNullParameter(r100, "version");
            this.version = r100;
            this.factors = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/state/cloud/a$b;", "", "", "version", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "", "factors", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("factors")
        private final List<byte[]> factors;

        @SerializedName("version")
        private final String version;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.factors, r101.factors) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.version;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<byte[]> r104 = this.factors;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CloudFactorPBData(version=" + this.version + ", factors=" + this.factors + ")";
        }

        public final List<byte[]> a() {
            return this.factors;
        }

        public final String b() {
            return this.version;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "version");
            this.version = r100;
            this.factors = null;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f123272a = null;

        static {
            f123272a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<C1965a> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            SharedPrefHelper r101 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state_pb");
            boolean r102 = a.f123267a;
            String r103 = r101.j("cloud_state_data_pb", SliceInitService.DEFAULT_SWITCH);
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            b r105 = (b) GsonHelper.get().fromJson(r103, b.class);     // Catch: Throwable -> L8
            if (r105 == null) goto L6;
            C1965a r106 = new C1965a(r105.b(), a.e(r105.a()));     // Catch: Throwable -> L8
        L11:
            r100.onNext(r106);
            r100.onComplete();
            return;
        L6:
            Result.m9449constructorimpl(null);     // Catch: Throwable -> L8
        L10:
            r106 = new C1965a("", CollectionsKt.emptyList());
        L8:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f123273a = null;

        static {
            f123273a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            C1965a r101 = (C1965a) r100;
            boolean r102 = a.f123267a;
            if (a.f123267a == true) goto L9;
            a.f123269c = r101.b();
            List<m> r103 = r101.a();
            if (r103 != null) goto L7;
            r103 = CollectionsKt.emptyList();
        L7:
            a.f123270d = r103;
            a.f123267a = true;
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f123274a = null;

        static {
            f123274a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = k.f510820a;
            StringBuilder r103 = new StringBuilder("Init From Local PB Error ");
            if (r101 == null) goto L5;
            String r104 = r101.getMessage();
        L6:
            r103.append(r104);
            k.a(r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public a() {
    }

    static {
        f123269c = "";
        f123270d = CollectionsKt.emptyList();
        f123271e = new LinkedHashMap();
    }

    public static List c() {
        if (f123267a == true) goto L6;
        d();
    L6:
        if (f123271e.isEmpty() == true) goto L21;
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = f123270d.iterator();
    L10:
        if (r101.hasNext() == false) goto L14;
        m r102 = (m) r101.next();
        if (f123271e.containsKey(r102.name) == true) goto L10;
        r100.add(r102);
        goto L10
    L14:
        r100.addAll(((LinkedHashMap) f123271e).values());
        return r100;
    L21:
        return new ArrayList(f123270d);
    }

    public static void d() {
        if (f123267a == false) goto L5;
        return;
    L5:
        k.a("CloudFactorStore init");
        if (ku1.e.f506183a.getValue().booleanValue() == true) goto L8;
        String r100 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state").j("cloud_state_data", SliceInitService.DEFAULT_SWITCH);
        C1965a r101 = (C1965a) GsonHelper.get().fromJson(r100, C1965a.class);     // Catch: Exception -> L16
        if (r101 != null) goto L17;
        r101 = new C1965a("", CollectionsKt.emptyList());     // Catch: Exception -> L16
    L17:
        f123269c = r101.b();
        List<m> r102 = r101.a();
        if (r102 != null) goto L20;
        r102 = CollectionsKt.emptyList();
    L20:
        f123270d = r102;
        f123267a = true;
        return;
    L16:
        r101 = new C1965a("", CollectionsKt.emptyList());
        goto L17
    L8:
        if (f123268b == false) goto L10;
        return;
    L10:
        f123268b = true;
        Observable.create(c.f123272a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(d.f123273a, e.f123274a);
    }

    public static final void b(String r100) {
        if (f123267a == true) goto L5;
        d();
    L5:
        f123270d = e(null);
        f123269c = r100;
        SharedPrefHelper r101 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state_pb");
        b r102 = new b(r100);
        String r103 = GsonHelper.get().toJson(r102);     // Catch: Exception -> L8
    L9:
        r101.l("cloud_state_data_pb", r103);
        r101.a();
        SharedPrefHelper r104 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state");
        r104.l("cloud_state_data", SliceInitService.DEFAULT_SWITCH);
        r104.a();
        return;
    L8:
        r103 = "";
        goto L9
    }

    public static List e(List r100) {
        if (r100 == null) goto L9;
        am3.c r101 = ((IMiddlewareNetworkService) jc1.k.n(IMiddlewareNetworkService.class)).getProtoDecoder(m.class);
        ArrayList r102 = new ArrayList();
        am3.g r103 = new am3.g();
        Iterator r104 = r100.iterator();
    L5:
        if (r104.hasNext() == false) goto L7;
        byte[] r105 = (byte[]) r104.next();
        r103.l(new am3.b(r105), r105.length);
        r102.add(r101.decode(r103));
        goto L5
    L7:
        return r102;
    L9:
        return CollectionsKt.emptyList();
    }

    public static final void a(List r100, String r101) {
        if (f123267a == true) goto L5;
        d();
    L5:
        int r102 = k.f510820a;
        StringBuilder r103 = new StringBuilder("fetch global features: ");
        if (r100 != null) goto L8;
        List r104 = CollectionsKt.emptyList();
    L9:
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        r106.add(((m) r107.next()).name);
        goto L11
    L13:
        r103.append(TextUtils.join(",", r106));
        k.a(r103.toString());
        if (r100 != null) goto L16;
        r100 = CollectionsKt.emptyList();
    L16:
        f123270d = r100;
        f123269c = r101;
        SharedPrefHelper r108 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state");
        C1965a r109 = new C1965a(f123269c, f123270d);
        String r110 = GsonHelper.get().toJson(r109);     // Catch: Exception -> L19
    L20:
        r108.l("cloud_state_data", r110);
        r108.a();
        if (ku1.d.f506182a.getValue().booleanValue() == false) goto L27;
        SharedPrefHelper r111 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state_pb");
        r111.l("cloud_state_data_pb", SliceInitService.DEFAULT_SWITCH);
        r111.a();
        return;
    L27:
        return;
    L19:
        r110 = "";
        goto L20
    L8:
        r104 = r100;
        goto L9
    }
}
