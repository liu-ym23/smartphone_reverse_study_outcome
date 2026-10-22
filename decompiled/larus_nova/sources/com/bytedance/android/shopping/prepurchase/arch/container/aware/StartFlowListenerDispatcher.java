package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class StartFlowListenerDispatcher implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f180721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, a> f180722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f180723c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<c, Unit> f180724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f180725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Stage f180726c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f180724a, r101.f180724a) == true) goto L8;
            return false;
        L8:
            if (this.f180725b == r101.f180725b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f180726c, r101.f180726c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            Function1<c, Unit> r100 = this.f180724a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            boolean r104 = this.f180725b;
            ?? r105 = r104;
            if (r104 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r103 + r105) * 31;
            Stage r107 = this.f180726c;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            return r106 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Holder(callback=" + this.f180724a + ", isFinish=" + this.f180725b + ", stage=" + this.f180726c + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super c, Unit> r100, boolean r101, Stage r102) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            Intrinsics.checkNotNullParameter(r102, "stage");
            this.f180724a = r100;
            this.f180725b = r101;
            this.f180726c = r102;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onPageCreateFinish$1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onPageCreateStart$1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
        ECHybridExtensionsKt.f(new AnonymousClass1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
        ECHybridExtensionsKt.f(new C103891(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onQueryStart$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StartFlowListenerDispatcher(List<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        this.f180723c = r100;
        this.f180722b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(final k.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onQueryFailed$1(this, r100));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(final k.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onQuerySuccess$1(this, r100));
    }

    public final void c(Stage r100, boolean r101, Function1<? super c, Unit> r102) {
        int r103 = (int) Math.ceil(((double) this.f180721a) / 2.0d);
        int r104 = r100.getValue() * 2;
        boolean r105 = false;
        if (r101 == false) goto L5;
        int r106 = 0;
    L6:
        int r107 = r104 + r106;
        int r108 = this.f180721a;
        if ((r108 % 2) != 0) goto L9;
        boolean r109 = true;
    L10:
        if (r107 != r108) goto L13;
        return;
    L13:
        if (r103 != (r100.getValue() - 1)) goto L17;
        if (r109 == false) goto L17;
        if (r101 == true) goto L17;
    L24:
        r105 = true;
    L25:
        if (r105 == false) goto L33;
        Iterator<T> r110 = this.f180723c.iterator();
    L28:
        if (r110.hasNext() == false) goto L30;
        r102.invoke((c) r110.next());
        goto L28
    L30:
        this.f180721a = r107;
        a r111 = this.f180722b.remove(Integer.valueOf(r107 + 1));
        if (r111 == null) goto L36;
        c(r111.f180726c, r111.f180725b, r111.f180724a);
        return;
    L36:
        return;
    L33:
        this.f180722b.put(Integer.valueOf(r107), new a(r102, r101, r100));
        return;
    L17:
        if (r103 != r100.getValue()) goto L21;
        if (r109 == true) goto L21;
        if (r101 == true) goto L24;
    L21:
        if (r103 != r100.getValue()) goto L25;
        if (r109 == false) goto L25;
        if (r101 == true) goto L25;
    L9:
        r109 = false;
        goto L10
    L5:
        r106 = -1;
        goto L6
    }
}
