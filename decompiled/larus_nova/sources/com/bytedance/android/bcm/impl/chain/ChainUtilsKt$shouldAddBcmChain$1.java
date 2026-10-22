package com.bytedance.android.bcm.impl.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"prefixMatch", "", "prefixList", "", "", "btm", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ChainUtilsKt$shouldAddBcmChain$1 extends Lambda implements Function2<List<? extends String>, String, Boolean> {
    public static final ChainUtilsKt$shouldAddBcmChain$1 INSTANCE = null;

    static {
        INSTANCE = new ChainUtilsKt$shouldAddBcmChain$1();
    }

    public ChainUtilsKt$shouldAddBcmChain$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(List<? extends String> r100, String r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(List<String> r100, String r101) {
        if (r101 == null) goto L19;
        List<String> r102 = r100;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L21;
        if (StringsKt.startsWith$default(r101, ((String) r103.next()) + '.', false, 2, null) == false) goto L11;
        return true;
    L21:
        return false;
    L7:
        if (r102.isEmpty() == false) goto L9;
        return false;
    L19:
        return false;
    }
}
