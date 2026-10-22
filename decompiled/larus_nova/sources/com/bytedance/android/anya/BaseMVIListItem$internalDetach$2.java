package com.bytedance.android.anya;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "", AbsMethodDelegate.TAG_INVOKE, "()I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final /* synthetic */ class BaseMVIListItem$internalDetach$2 extends FunctionReference implements Function0<Integer> {
    public BaseMVIListItem$internalDetach$2(BaseMVIListItem r100) {
        super(0, r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "defaultPosition";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseMVIListItem.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "defaultPosition()I";
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        ((BaseMVIListItem) this.receiver).getClass();
        return -1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
