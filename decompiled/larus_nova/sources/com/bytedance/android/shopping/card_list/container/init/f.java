package com.bytedance.android.shopping.card_list.container.init;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f171556a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f171557a = null;

        public a() {
        }

        static {
            f171557a = new a();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f171558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f171559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f171560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f171561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Object> f171562e;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f171558a, r101.f171558a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f171559b, r101.f171559b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f171560c, r101.f171560c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f171561d, r101.f171561d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f171562e, r101.f171562e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f171558a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f171559b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f171560c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Map<String, Integer> r110 = this.f171561d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Map<String, Object> r113 = this.f171562e;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
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
            return "SDKParams(bizBtm=" + this.f171558a + ", bizCode=" + this.f171559b + ", sliceTemplateChannel=" + this.f171560c + ", sliceTemplateList=" + this.f171561d + ", abilityParams=" + this.f171562e + ")";
        }

        public /* synthetic */ b(int r100) {
            this(null, "", "", null, MapsKt.emptyMap());
        }

        public b(String r100, String r101, String r102, Map<String, Integer> r103, Map<String, ? extends Object> r104) {
            Intrinsics.checkNotNullParameter(r101, "bizCode");
            Intrinsics.checkNotNullParameter(r102, "sliceTemplateChannel");
            Intrinsics.checkNotNullParameter(r104, "abilityParams");
            this.f171558a = r100;
            this.f171559b = r101;
            this.f171560c = r102;
            this.f171561d = r103;
            this.f171562e = r104;
        }
    }

    static {
        f171556a = a.f171557a;
    }

    void a(CardListObjectContainer r100, View r101);

    void b(CardPassThroughData r100, Function3<? super String, ? super String, ? super Map<String, String>, Unit> r101);

    void c(CardListObjectContainer r100, b r101, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r102, Function2<? super b, ? super com.bytedance.kmp.ec.yata.view.render.delegate.v2.a, Unit> r103);

    void d(Context r100);
}
