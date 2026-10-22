package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class d0 implements ReadOnlyProperty<Object, com.bytedance.android.ec.core.imagex.common.p<com.bytedance.android.ec.core.imagex.common.z>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44847b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44848a;

    static {
        f44847b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(d0.class, "value", "getValue()Lcom/google/gson/internal/LinkedTreeMap;", 0))};
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final com.bytedance.android.ec.core.imagex.common.p<com.bytedance.android.ec.core.imagex.common.z> getValue(Object r100, KProperty r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (this.f44848a == false) goto L6;
        ColdLaunchExpFilter.f45205e.b(null);
        throw null;
    L6:
        KProperty r102 = f44847b[0];
        throw null;
    }
}
