package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0007j\u0002`\bH\n¢\u0006\u0002\b\t"}, d2 = {"syncApiParams", "", "apiParamsMap", "", "", "", "nativeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/shopping/mall/homepage/pagecard/dynamicparams/ApiDynamicParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class DynamicParamsController$syncLocalDynamicParams$1 extends Lambda implements Function2<Map<String, ? extends Object>, ConcurrentHashMap<String, Map<String, ? extends Object>>, Unit> {
    public static final DynamicParamsController$syncLocalDynamicParams$1 INSTANCE = null;

    static {
        INSTANCE = new DynamicParamsController$syncLocalDynamicParams$1();
    }

    public DynamicParamsController$syncLocalDynamicParams$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> r100, ConcurrentHashMap<String, Map<String, Object>> r101) {
        Intrinsics.checkNotNullParameter(r100, "apiParamsMap");
        Intrinsics.checkNotNullParameter(r101, "nativeMap");
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Map) == true) goto L8;
        r105 = null;
    L8:
        Map<String, Object> r106 = (Map) r105;
        if (r106 == null) goto L4;
        r101.put(r104, r106);
        goto L4
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> r100, ConcurrentHashMap<String, Map<String, ? extends Object>> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
