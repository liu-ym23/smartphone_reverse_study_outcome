package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f45665a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.util.g<String, SoftReference<Bitmap>> f45666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.util.g<String, Bitmap> f45667c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p1 f45668d = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45669a;

        public a(List r100) {
            this.f45669a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Object[] r101 = (Object[]) r100;
            Intrinsics.checkNotNullParameter(r101, "rets");
            Iterator<T> r102 = ArraysKt.sortedWith(r101, new o1()).iterator();
        L4:
            if (r102.hasNext() == false) goto L12;
            T r103 = r102.next();
            if ((r103 instanceof m1) == true) goto L8;
            r103 = (T) null;
        L8:
            m1 r104 = r103;
            if (r104 == null) goto L4;
            this.f45669a.add(r104.f45645b);
            goto L4
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f45671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f45672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f45673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TextView f45674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Float f45675f;

        public b(List r100, String r101, float r102, float r103, TextView r104, Float r105) {
            this.f45670a = r100;
            this.f45671b = r101;
            this.f45672c = r102;
            this.f45673d = r103;
            this.f45674e = r104;
            this.f45675f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            p1 r102 = p1.f45668d;
            List r103 = this.f45670a;
            String r104 = this.f45671b;
            float r105 = this.f45672c;
            float r106 = this.f45673d;
            TextView r107 = this.f45674e;
            Float r108 = this.f45675f;
            r102.getClass();
            p1.g(r103, r104, r105, r106, r107, r108);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f45676a = null;

        static {
            f45676a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = r101.getMessage();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            ECExceptionMonitor.f(r101, r102);
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45677a;

        public d(List r100) {
            this.f45677a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Object[] r101 = (Object[]) r100;
            Intrinsics.checkNotNullParameter(r101, "rets");
            Iterator<T> r102 = ArraysKt.sortedWith(r101, new q1()).iterator();
        L4:
            if (r102.hasNext() == false) goto L12;
            T r103 = r102.next();
            if ((r103 instanceof m1) == true) goto L8;
            r103 = (T) null;
        L8:
            m1 r104 = r103;
            if (r104 == null) goto L4;
            this.f45677a.add(r104.f45645b);
            goto L4
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f45679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f45680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f45681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TextView f45682e;

        public e(List r100, String r101, float r102, float r103, TextView r104) {
            this.f45678a = r100;
            this.f45679b = r101;
            this.f45680c = r102;
            this.f45681d = r103;
            this.f45682e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            p1.h(p1.f45668d, this.f45678a, this.f45679b, this.f45680c, this.f45681d, this.f45682e);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f45683a = null;

        static {
            f45683a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = r101.getMessage();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            ECExceptionMonitor.f(r101, r102);
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45684a;

        public g(List r100) {
            this.f45684a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Object[] r101 = (Object[]) r100;
            Intrinsics.checkNotNullParameter(r101, "tasks");
            Iterator<T> r102 = ArraysKt.sortedWith(r101, new v1()).iterator();
        L4:
            if (r102.hasNext() == false) goto L16;
            T r103 = r102.next();
            if ((r103 instanceof m1) == true) goto L8;
            r103 = (T) null;
        L8:
            m1 r104 = r103;
            if (r104 == null) goto L4;
            this.f45684a.add(r104.f45645b);
            String r105 = r104.f45646c;
            if (r105 == null) goto L4;
            if ((!StringsKt.isBlank(r105)) != true) goto L4;
            p1.f45666b.d(r104.f45646c, new SoftReference(r104.f45645b));
            goto L4
        L16:
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f45686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f45687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f45688d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TextView f45689e;

        public h(List r100, String r101, float r102, float r103, TextView r104) {
            this.f45685a = r100;
            this.f45686b = r101;
            this.f45687c = r102;
            this.f45688d = r103;
            this.f45689e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            p1.h(p1.f45668d, this.f45685a, this.f45686b, this.f45687c, this.f45688d, this.f45689e);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f45690a = null;

        static {
            f45690a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = r101.getMessage();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            ECExceptionMonitor.f(r101, r102);
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f45691a;

        public j(Function1 r100) {
            this.f45691a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Function1 r101 = this.f45691a;
            r101.invoke((Integer) r100);
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f45692a = null;

        static {
            f45692a = new k();
        }

        public k() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            m1 r111 = (m1) r110;
            Intrinsics.checkNotNullParameter(r111, "it");
            p1 r100 = p1.f45668d;
            Bitmap r112 = r111.f45645b;
            r100.getClass();
            int r101 = r112.getHeight() - 1;
            int r102 = r112.getWidth();
            int r103 = r102 - 1;
            int r104 = 0;
            int r105 = 0;
            int r106 = 0;
            int r107 = 0;
            int r108 = 0;
        L3:
            if (r104 >= r103) goto L6;
            int r109 = r112.getPixel(r104, r101);
            r105 = r105 + ((r109 & ((int) 4278190080L)) >> 24);
            r108 = r108 + ((16711680 & r109) >> 16);
            r106 = r106 + ((65280 & r109) >> 8);
            r107 = r107 + (r109 & 255);
            r104 = r104 + 1;
            goto L3
        L6:
            return Integer.valueOf(((((r105 / r102) << 24) | ((r108 / r102) << 16)) | ((r106 / r102) << 8)) | (r107 / r102));
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f45693a = null;

        static {
            f45693a = new l();
        }

        public l() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public p1() {
    }

    static {
        f45668d = new p1();
        f45665a = 2.0f;
        f45666b = new com.bytedance.frameworks.baselib.network.http.util.g(20);
        f45667c = new com.bytedance.frameworks.baselib.network.http.util.g(20);
    }

    public static void f(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "getColor");
        if (r100 == null) goto L6;
        f45668d.getClass();
        Observable.create(new x1(r100, 0)).map(k.f45692a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r101), l.f45693a);
        return;
    }

    public final Disposable c(Map r100, List r101, String r110, TextView r111) {
        Intrinsics.checkNotNullParameter("ecom_shop_product_shop_sellpoint", "ritTagKey");
        Intrinsics.checkNotNullParameter(r111, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        if (r100 == null) goto L5;
        List r102 = (List) r100.get("ecom_shop_product_shop_sellpoint");
    L6:
        if (r102 == null) goto L12;
        if ((!r102.isEmpty()) != true) goto L12;
        return d("ecom_shop_product_shop_sellpoint", r100, r110, 3.0f, 14.0f, r111);
    L12:
        return a(r101, r110, 3.0f, 14.0f, r111, null);
    L5:
        r102 = null;
        goto L6
    }

    public static Disposable a(List r100, String r101, float r110, float r111, TextView r112, Float r113) {
        Intrinsics.checkNotNullParameter(r112, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        r112.setText(r101);
        List r102 = r100;
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        g(CollectionsKt.emptyList(), r101, r110, r111, r112, r113);
        return null;
    L12:
        ArrayList r105 = new ArrayList();
        List r106 = CollectionsKt.filterNotNull(r100);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        int r114 = r103 + 1;
        if (r103 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        f45668d.getClass();
        Observable r115 = Observable.create(new w1((ECUrlModel) r109, r103));
        if (r115 == null) goto L21;
        r107.add(r115);
    L21:
        r103 = r114;
        goto L14
    L23:
        return Observable.zip(r107, new a(r105)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r105, r101, r110, r111, r112, r113), c.f45676a);
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static /* synthetic */ Disposable b(p1 r100, List r101, String r102, float r103, float r110, TextView r111) {
        r100.getClass();
        return a(r101, r102, r103, r110, r111, null);
    }

    public static void g(List r100, String r110, float r111, float r112, TextView r113, Float r114) {
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        Iterator r102 = r100.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L15;
        Bitmap r104 = (Bitmap) r102.next();
        if (r104.isRecycled() == true) goto L3;
        int r105 = (int) com.bytedance.common.utility.UIUtils.dip2Px(r113.getContext(), r112);
        Bitmap r106 = Bitmap.createScaledBitmap(r104, (int) (((r105 * 1.0f) / r104.getHeight()) * r104.getWidth()), r105, true);
        SpannableString r107 = new SpannableString(" ");
        com.bytedance.android.ec.core.widget.a r108 = new com.bytedance.android.ec.core.widget.a(r113.getContext(), r106);
        if (r100.indexOf(r104) != (r100.size() - 1)) goto L10;
        r108.f46061a = vf4.a.b(Float.valueOf(r111));
    L14:
        r107.setSpan(r108, 0, 1, 17);
        r101.append(r107);
        goto L3
    L10:
        if (r114 == null) goto L12;
        int r109 = vf4.a.b(r114);
    L13:
        r108.f46061a = r109;
        goto L14
    L12:
        r109 = vf4.a.b(Float.valueOf(f45665a));
        goto L13
    L15:
        if (r110 != null) goto L17;
    L21:
        r113.setText(r101);
        return;
    L17:
        if (r110.length() <= 0) goto L19;
        r103 = true;
    L19:
        if (r103 != true) goto L21;
        r101.append(r110);
        goto L21
    }

    public static /* synthetic */ void h(p1 r100, List r101, String r102, float r103, float r110, TextView r111) {
        r100.getClass();
        g(r101, r102, r103, r110, r111, null);
    }

    public final Disposable d(String r110, Map<String, ? extends List<ECRitTag>> r111, String r112, float r113, float r114, TextView r115) {
        Intrinsics.checkNotNullParameter(r110, "ritTagKey");
        Intrinsics.checkNotNullParameter(r115, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        r115.setText(r112);
        if (r111 == null) goto L5;
        List<ECRitTag> r100 = r111.get(r110);
    L6:
        List<ECRitTag> r101 = r100;
        int r102 = 0;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        h(this, CollectionsKt.emptyList(), r112, r113, r114, r115);
        return null;
    L16:
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r100.iterator();
    L18:
        if (r106.hasNext() == false) goto L30;
        Object r107 = r106.next();
        int r108 = r102 + 1;
        if (r102 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r109 = ((ECRitTag) r107).getFirstIconUrl();
        if (r109 == null) goto L25;
        f45668d.getClass();
        Observable r116 = Observable.create(new x1(r109, r102));
    L26:
        if (r116 == null) goto L28;
        r105.add(r116);
    L28:
        r102 = r108;
        goto L18
    L25:
        r116 = null;
        goto L26
    L30:
        return Observable.zip(r105, new d(r104)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r104, r112, r113, r114, r115), f.f45683a);
    L9:
        if (r101.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r100 = null;
        goto L6
    }

    public final Disposable e(String r110, Map<String, ? extends List<ECRitTag>> r111, String r112, float r113, float r114, TextView r115) {
        Intrinsics.checkNotNullParameter(r110, "ritTagKey");
        Intrinsics.checkNotNullParameter(r115, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        r115.setText(r112);
        if (r111 == null) goto L5;
        List<ECRitTag> r100 = r111.get(r110);
    L6:
        List<ECRitTag> r101 = r100;
        int r102 = 0;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        h(this, CollectionsKt.emptyList(), r112, r113, r114, r115);
        return null;
    L16:
        List<ECRitTag> r104 = r100;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        String r107 = ((ECRitTag) r106.next()).getFirstIconUrl();
        if (r107 == null) goto L18;
        r105.add(r107);
        goto L18
    L22:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r105.iterator();
    L24:
        if (r109.hasNext() == false) goto L36;
        SoftReference<Bitmap> r116 = f45666b.b((String) r109.next());
        if (r116 == null) goto L32;
        Bitmap r117 = r116.get();
        if (r117 == null) goto L32;
        if ((!r117.isRecycled()) == false) goto L32;
    L33:
        if (r117 == null) goto L24;
        r108.add(r117);
    L32:
        r117 = null;
        goto L33
    L36:
        if (r108.size() != r105.size()) goto L39;
        h(this, r108, r112, r113, r114, r115);
        return null;
    L39:
        ArrayList r118 = new ArrayList();
        ArrayList r119 = new ArrayList();
        Iterator r120 = r104.iterator();
    L41:
        if (r120.hasNext() == false) goto L53;
        Object r121 = r120.next();
        int r122 = r102 + 1;
        if (r102 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        String r123 = ((ECRitTag) r121).getFirstIconUrl();
        if (r123 == null) goto L48;
        f45668d.getClass();
        Observable r124 = Observable.create(new x1(r123, r102));
    L49:
        if (r124 == null) goto L51;
        r119.add(r124);
    L51:
        r102 = r122;
        goto L41
    L48:
        r124 = null;
        goto L49
    L53:
        return Observable.zip(r119, new g(r118)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r118, r112, r113, r114, r115), i.f45690a);
    L9:
        if (r101.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r100 = null;
        goto L6
    }
}
