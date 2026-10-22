package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c<OWNER extends MVIState<?>, T> implements com.bytedance.android.anya.v<OWNER, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f41672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f41673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f41674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<c<OWNER, ?>, Unit> f41675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<c<OWNER, ?>, Unit> f41676e;

    public final T c() {
        T r100 = this.f41673b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(("No value present in StateProperty: " + this + ". Please check corresponding ViewModel is bound.").toString());
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{ \"name\": \"");
        r100.append(this.f41672a);
        r100.append("@p\", \"value\": ");
        T r101 = this.f41673b;
        if (r101 == null) goto L5;
        String r102 = "\"" + r101 + Typography.quote;
    L6:
        r100.append(r102);
        r100.append(" }");
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.anya.v
    public final String getName() {
        return this.f41672a;
    }

    public final void a(T r100) {
        if (b(r100) == false) goto L6;
        this.f41675d.invoke(this);
        this.f41674c++;
        return;
    }

    public boolean b(T r100) {
        boolean r101 = !Intrinsics.areEqual(this.f41673b, r100);
        this.f41673b = r100;
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object r100, Function1 r101, Function1 r102) {
        this.f41675d = r101;
        this.f41676e = r102;
        this.f41672a = "unknown";
        this.f41673b = r100;
        if (r100 != 0) goto L5;
        int r103 = 0;
    L6:
        this.f41674c = r103;
        return;
    L5:
        r103 = 1;
        goto L6
    }
}
