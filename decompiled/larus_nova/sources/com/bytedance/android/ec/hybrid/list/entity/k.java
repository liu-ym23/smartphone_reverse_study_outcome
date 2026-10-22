package com.bytedance.android.ec.hybrid.list.entity;

import com.bytedance.android.ec.hybrid.api.card.mita.ECHybridMitaCardConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f47128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f47129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<i> f47130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f47131d;

    public static final class a implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f47132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ECHybridMitaCardConfig f47133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function1<? super Map<String, ? extends Object>, Unit> f47134c;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f47132a, r101.f47132a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f47133b, r101.f47133b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f47134c, r101.f47134c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            f r100 = this.f47132a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ECHybridMitaCardConfig r104 = this.f47133b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Function1<? super Map<String, ? extends Object>, Unit> r107 = this.f47134c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ECHybridListItemConfig(lynxConfig=" + this.f47132a + ", mitaCardConfig=" + this.f47133b + ", monitorExtraDataAction=" + this.f47134c + ")";
        }

        public final a a() {
            Object r100 = null;
            a r101 = new a(null);
            f r102 = this.f47132a;
            if (r102 == null) goto L5;
            f r103 = r102.a();
        L6:
            r101.f47132a = r103;
            ECHybridMitaCardConfig r104 = this.f47133b;
            if (r104 == null) goto L9;
            Object r105 = r104.clone();
        L11:
            if ((r105 instanceof ECHybridMitaCardConfig) == false) goto L14;
            r100 = r105;
        L14:
            r101.f47133b = (ECHybridMitaCardConfig) r100;
            r101.f47134c = this.f47134c;
            return r101;
        L9:
            r105 = null;
            goto L11
        L5:
            r103 = null;
            goto L6
        }

        public final /* bridge */ /* synthetic */ Object clone() {
            return a();
        }

        public a(Object r100) {
            this.f47132a = null;
            this.f47133b = null;
            this.f47134c = null;
        }
    }

    public k() {
    }

    public final k a() {
        k r100 = new k();
        j r101 = this.f47128a;
        Map<String, String> r102 = null;
        if (r101 == null) goto L5;
        j r103 = r101.a();
    L6:
        r100.f47128a = r103;
        HashMap<String, a> r104 = new HashMap();
        HashMap<String, a> r105 = this.f47129b;
        if (r105 == null) goto L12;
        Iterator<Map.Entry<String, a>> r106 = r105.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        Map.Entry<String, a> r107 = r106.next();
        r104.put(r107.getKey(), r107.getValue().a());
    L12:
        Unit r108 = Unit.INSTANCE;
        r100.f47129b = r104;
        ArrayList<i> r109 = new ArrayList();
        ArrayList<i> r110 = this.f47130c;
        if (r110 == null) goto L18;
        Iterator<T> r111 = r110.iterator();
    L16:
        if (r111.hasNext() == false) goto L18;
        r109.add(((i) r111.next()).a());
    L18:
        Unit r112 = Unit.INSTANCE;
        r100.f47130c = r109;
        Map<String, String> r113 = this.f47131d;
        if (r113 == null) goto L21;
        r102 = MapsKt.toMap(r113);
    L21:
        r100.f47131d = r102;
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
