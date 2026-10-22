package com.bytedance.android.ec.core.hybrid.prefetch;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class NativePrefetchLepus extends NativePrefetch {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, a> f44207k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f44208l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchLepus$SyncCallback;", "", "fail", "", "result", "", "success", "isFromNetEnd", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface SyncCallback {
        void fail(String r100);

        void success(String r100, boolean r101);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SyncCallback f44209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f44210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q f44211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f44212d;

        public a() {
            this(null, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f44209a, r101.f44209a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f44210b, r101.f44210b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f44211c, r101.f44211c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f44212d, r101.f44212d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            SyncCallback r100 = this.f44209a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            o r104 = this.f44210b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            q r107 = this.f44211c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            JSONObject r110 = this.f44212d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "SyncApiKeyRequestModel(prefetchSyncCallback=" + this.f44209a + ", prefetchingSync=" + this.f44210b + ", prefetchTimingSync=" + this.f44211c + ", extraInfo=" + this.f44212d + ")";
        }

        public a(o r100, int r101) {
            if ((r101 & 2) == 0) goto L5;
            r100 = null;
        L5:
            this.f44209a = null;
            this.f44210b = r100;
            this.f44211c = null;
            this.f44212d = null;
        }
    }

    public NativePrefetchLepus() {
        this.f44207k = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final void y() {
        super.y();
        this.f44208l = Long.valueOf(System.currentTimeMillis());
    }

    private final q r(String r100) {
        a r101 = (a) ((LinkedHashMap) this.f44207k).get(r100);
        if (r101 == null) goto L6;
        q r102 = r101.f44211c;
        if (r102 == null) goto L6;
    L7:
        r102.g(this.f44208l);
        r102.h(this.f44208l);
        return r102;
    L6:
        r102 = new q(0);
        goto L7
    }

    public final synchronized void I(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L6
        this.f44207k.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void i(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L6
        super.i(r100);     // Catch: Throwable -> L6
        I(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        super.t(r100);
        this.f44207k.put(r100, new a(new o("", -999, ""), 13));
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void w(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L8
        super.w(r100);     // Catch: Throwable -> L8
        q r101 = r(r100);     // Catch: Throwable -> L8
        r101.f(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L8
        a r102 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.f44211c = r101;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void x(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L8
        super.x(r100);     // Catch: Throwable -> L8
        q r101 = r(r100);     // Catch: Throwable -> L8
        r101.i(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L8
        a r102 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.f44211c = r101;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void A(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "apiKey");     // Catch: Throwable -> L27
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        ConcurrentHashMap<String, NativePrefetch> r102 = NativePrefetchUtil.f44218a;     // Catch: Throwable -> L27
        if (StringsKt.isBlank(r100) == false) goto L10;
        boolean r103 = true;
    L11:
        NativePrefetch r104 = null;
        if (r103 == false) goto L14;
        NativePrefetch r105 = null;
    L16:
        if ((r105 instanceof NativePrefetchLepus) == false) goto L19;
        r104 = r105;
    L19:
        NativePrefetchLepus r106 = (NativePrefetchLepus) r104;     // Catch: Throwable -> L27
        if (r106 == null) goto L24;
        a r107 = (a) ((LinkedHashMap) r106.f44207k).get(r101);     // Catch: Throwable -> L27
        if (r107 == null) goto L24;
        this.f44207k.put(r101, r107);     // Catch: Throwable -> L27
    L24:
        super.A(r100, r101);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L14:
        r105 = NativePrefetchUtil.f44218a.get(r100);     // Catch: Throwable -> L27
        goto L16
    L10:
        r103 = false;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void B(String r100, int r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L18
        super.B(r100, r101);     // Catch: Throwable -> L18
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        a r103 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        a r104 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L14
        if (r104 == null) goto L10;
        JSONObject r105 = r104.f44212d;     // Catch: Throwable -> L14
        if (r105 == null) goto L10;
    L11:
        r105.putOpt("na_prefetch_config_from", Integer.valueOf(r101));     // Catch: Throwable -> L14
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r103.f44212d = r105;     // Catch: Throwable -> L14
    L10:
        r105 = new JSONObject();     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void C(String r100, JSONObject r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L8
        super.C(r100, r101);     // Catch: Throwable -> L8
        q r102 = r(r100);     // Catch: Throwable -> L8
        r102.f44255a = r101;     // Catch: Throwable -> L8
        a r103 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.f44211c = r102;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void D(o r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "data");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r101, "apiKey");     // Catch: Throwable -> L24
        a r102 = (a) ((LinkedHashMap) this.f44207k).get(r101);     // Catch: Throwable -> L24
        if (r102 == null) goto L6;
        SyncCallback r103 = r102.f44209a;     // Catch: Throwable -> L24
    L7:
        if (r103 != null) goto L11;
        a r104 = (a) ((LinkedHashMap) this.f44207k).get(r101);     // Catch: Throwable -> L24
        if (r104 == null) goto L18;
        r104.f44210b = r100;     // Catch: Throwable -> L24
    L18:
        a r105 = (a) ((LinkedHashMap) this.f44207k).get(r101);     // Catch: Throwable -> L24
        if (r105 == null) goto L21;
        r105.f44209a = null;     // Catch: Throwable -> L24
    L21:
        super.D(r100, r101);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L11:
        int r106 = r100.f44253b;     // Catch: Throwable -> L24
        if (r106 != 1) goto L14;
        r103.success(r100.f44252a, true);     // Catch: Throwable -> L24
        goto L18
    L14:
        if (r106 != 2) goto L18;
        r103.fail("");     // Catch: Throwable -> L24
        goto L18
    L6:
        r103 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void E(String r100, JSONObject r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "apiKey");     // Catch: Throwable -> L26
        if (r101 != null) goto L31;
        monitor-exit(this);
        return;
    L31:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        a r103 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L21
        if (r103 == null) goto L19;
        a r104 = (a) ((LinkedHashMap) this.f44207k).get(r100);     // Catch: Throwable -> L21
        if (r104 == null) goto L13;
        JSONObject r105 = r104.f44212d;     // Catch: Throwable -> L21
        if (r105 == null) goto L13;
    L14:
        Iterator<String> r106 = r101.keys();     // Catch: Throwable -> L21
    L16:
        if (r106.hasNext() == false) goto L18;
        String r107 = r106.next();     // Catch: Throwable -> L21
        r105.putOpt(r107, r101.opt(r107));     // Catch: Throwable -> L21
        goto L16
    L18:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r103.f44212d = r105;     // Catch: Throwable -> L21
    L13:
        r105 = new JSONObject();     // Catch: Throwable -> L21
    L19:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        super.E(r100, r101);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L26
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
