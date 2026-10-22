package com.bytedance.android.scope.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "V", "K", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 128)
public final /* synthetic */ class MultiMapKt$multiMapOf$1 extends FunctionReferenceImpl implements Function0<List<Object>> {
    public static final MultiMapKt$multiMapOf$1 INSTANCE = null;

    static {
        INSTANCE = new MultiMapKt$multiMapOf$1();
    }

    public MultiMapKt$multiMapOf$1() {
        super(0, CollectionsKt.class, "mutableListOf", "mutableListOf()Ljava/util/List;", 1);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<Object> invoke2() {
        return new ArrayList();
    }
}
