package com.bytedance.android.live.browser.service;

import android.content.Context;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements z8.b {
    public h() {
    }

    @Override // z8.b
    public final List<Object> M(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        IMiddlewareHostAction r102 = (IMiddlewareHostAction) jc1.k.f(IMiddlewareHostAction.class);
        if (r102 == null) goto L7;
        List<Object> r103 = r102.ecBehaviorAdd(r100, r101);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // z8.b
    public final List r1(Context r100, com.bytedance.android.annie.lynx.resource.h r101) {
        Intrinsics.checkNotNullParameter(r101, "xResourceLoader");
        IMiddlewareHostAction r102 = (IMiddlewareHostAction) jc1.k.f(IMiddlewareHostAction.class);
        if (r102 == null) goto L15;
        List r103 = r102.createHostDefinedLynxBehavior(r100, r101);
        if (r103 == null) goto L15;
        List r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L18;
        Object r107 = r106.next();
        if (r107 == null) goto L13;
        r105.add((com.lynx.tasm.behavior.a) r107);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.Behavior");
    L18:
        return r105;
    L15:
        return CollectionsKt.emptyList();
    }
}
