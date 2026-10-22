package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class t implements ReadOnlyProperty<Object, p<z>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44657b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44658a;

    static {
        f44657b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(t.class, "value", "getValue()Lcom/google/gson/internal/LinkedTreeMap;", 0))};
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final p<z> getValue(Object r100, KProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (this.f44658a == false) goto L6;
        ColdLaunchExpFilter.f45205e.b(null);
        throw null;
    L6:
        KProperty r102 = f44657b[0];
        throw null;
    }
}
