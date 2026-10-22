package com.bytedance.android.live.browser.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "ch", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnnieLiveResourceServiceImpl$getRedirectImgUrl$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends Integer>> {
    final /* synthetic */ String $url;

    public AnnieLiveResourceServiceImpl$getRedirectImgUrl$1(String r100) {
        this.$url = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<String, Integer> invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ch");
        Integer r101 = Integer.valueOf(StringsKt.indexOf$default(this.$url, r100, 0, false, 6, null));
        if (r101.intValue() <= (-1)) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L12;
        return null;
    L12:
        return new Pair(r100, Integer.valueOf(r101.intValue()));
    L5:
        r102 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends String, ? extends Integer> invoke(String r100) {
        return invoke2(r100);
    }
}
