package com.bytedance.android.accessibilityLib_Core.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class AppWindows$initHookIfNeeded$1 extends MutablePropertyReference0 {
    public AppWindows$initHookIfNeeded$1(AppWindows r100) {
        super(r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "windowSession";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AppWindows.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getWindowSession()Ljava/lang/Object;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        Object r100 = ((AppWindows) this.receiver).f38256b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("windowSession");
    L5:
        return r100;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ((AppWindows) this.receiver).f38256b = r100;
    }
}
