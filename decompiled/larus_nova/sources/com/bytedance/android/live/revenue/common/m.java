package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.log.ALogger;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f90843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w0<T> f90844c;

    public static final class a {
    }

    static {
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return this.f90844c.f91012a.invoke(this.f90842a, this.f90843b);
    L5:
        e = move-exception;
        ALogger.e("HybridProperties", "error reading value of " + this.f90842a + ": " + e);
        return this.f90843b;
    }

    public m(String r100, T r101, w0<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "adapter");
        this.f90842a = r100;
        this.f90843b = r101;
        this.f90844c = r102;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f90844c.f91013b.invoke(this.f90842a, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("HybridProperties", "error writing value of " + this.f90842a + ": " + e);
    }
}
