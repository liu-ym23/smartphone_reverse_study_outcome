package com.bytedance.android.livesdk.revenue.util;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T, U> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f157530e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f157531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f157532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<T> f157533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<T, U> f157534d;

    public static final class a {
        public a() {
        }
    }

    static {
        f157530e = new a();
    }

    public final U a() {
        T r100 = this.f157533c.invoke();
        if (this.f157532b != f157530e) goto L5;
    L6:
        this.f157531a = r100;
        this.f157532b = this.f157534d.invoke(r100);
    L8:
        return (U) this.f157532b;
    L5:
        if ((!Intrinsics.areEqual(this.f157531a, r100)) == false) goto L8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<? extends T> r100, Function1<? super T, ? extends U> r101) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "transformer");
        this.f157533c = r100;
        this.f157534d = r101;
        a r102 = f157530e;
        this.f157531a = r102;
        this.f157532b = r102;
    }

    public final U b(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return a();
    }
}
