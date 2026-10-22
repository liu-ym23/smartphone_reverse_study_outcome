package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: classes44.dex */
public final class MutableConstraintOptions extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<a.C0846a<? extends Object>> f49277i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, a.C0846a<? extends Object>> f49278j = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.virtualview.MutableConstraintOptions$a$a, reason: collision with other inner class name */
        public static final class C0846a<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f49279a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function1<Object, T> f49280b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final fo.a<T> f49281c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final KMutableProperty1<ConstraintLayout.LayoutParams, T> f49282d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0846a(String r100, Function1<Object, ? extends T> r101, fo.a<T> r102, KMutableProperty1<ConstraintLayout.LayoutParams, T> r103) {
                Intrinsics.checkNotNullParameter(r100, "name");
                Intrinsics.checkNotNullParameter(r101, "inputTransformer");
                Intrinsics.checkNotNullParameter(r102, "key");
                Intrinsics.checkNotNullParameter(r103, "prop");
                this.f49279a = r100;
                this.f49280b = r101;
                this.f49281c = r102;
                this.f49282d = r103;
            }
        }
    }

    static {
        List<a.C0846a<? extends Object>> r100 = CollectionsKt.listOf(new a.C0846a[]{new a.C0846a("horizontal_bias", MutableConstraintOptions$Companion$supportedOptions$1.INSTANCE, c.f49293c, MutableConstraintOptions$Companion$supportedOptions$2.INSTANCE), new a.C0846a("vertical_bias", MutableConstraintOptions$Companion$supportedOptions$3.INSTANCE, c.f49294d, MutableConstraintOptions$Companion$supportedOptions$4.INSTANCE), new a.C0846a("horizontal_chain_style", MutableConstraintOptions$Companion$supportedOptions$5.INSTANCE, c.f49295e, MutableConstraintOptions$Companion$supportedOptions$6.INSTANCE), new a.C0846a("vertical_chain_style", MutableConstraintOptions$Companion$supportedOptions$7.INSTANCE, c.f49296f, MutableConstraintOptions$Companion$supportedOptions$8.INSTANCE), new a.C0846a("width_constrained", MutableConstraintOptions$Companion$supportedOptions$9.INSTANCE, c.f49297g, MutableConstraintOptions$Companion$supportedOptions$10.INSTANCE), new a.C0846a("height_constrained", MutableConstraintOptions$Companion$supportedOptions$11.INSTANCE, c.f49298h, MutableConstraintOptions$Companion$supportedOptions$12.INSTANCE)});
        f49277i = r100;
        List<a.C0846a<? extends Object>> r101 = r100;
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.put(((a.C0846a) r104).f49279a, r104);
        goto L4
    L6:
        f49278j = r102;
    }

    public MutableConstraintOptions() {
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.c
    public final void a(ConstraintLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "lp");
        Iterator<a.C0846a<? extends Object>> r101 = f49277i.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        a.C0846a<? extends Object> r102 = r101.next();
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "options");
        Intrinsics.checkNotNullParameter(r100, "lp");
        fo.a<? extends Object> r103 = r102.f49281c;
        Intrinsics.checkNotNullParameter(r103, "key");
        Object r104 = this.f49299a.a(r103);
        if (r104 == null) goto L4;
        r102.f49282d.set(r100, r104);
        goto L4
    }
}
