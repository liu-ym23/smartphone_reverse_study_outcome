package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class TmplConvConfig$editUrlGlobalMather$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    public TmplConvConfig$editUrlGlobalMather$2(TmplConvConfig r100) {
        super(0, r100, TmplConvConfig.class, "enable", "enable()Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        ((TmplConvConfig) this.receiver).getClass();
        return TmplConvConfig.a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }
}
