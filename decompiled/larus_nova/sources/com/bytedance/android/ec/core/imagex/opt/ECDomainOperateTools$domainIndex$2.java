package com.bytedance.android.ec.core.imagex.opt;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECDomainOperateTools$domainIndex$2 extends Lambda implements Function0<Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ q this$0;

    public ECDomainOperateTools$domainIndex$2(q r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<? extends Integer, ? extends Integer> invoke2() {
        this.this$0.getClass();
        Integer r100 = null;
        int r101 = StringsKt.indexOf$default(null, "://", 0, false, 6, null);
        if (r101 < 0) goto L5;
        Integer r102 = Integer.valueOf(r101);
    L6:
        if (r102 == null) goto L13;
        r102.intValue();
        this.this$0.getClass();
        int r103 = StringsKt.indexOf$default(null, HTTP.URL_DEFAULT, r102.intValue() + 3, false, 4, null);
        if (r103 <= 0) goto L10;
        r100 = Integer.valueOf(r103);
        goto L13
    L10:
        this.this$0.getClass();
        throw null;
    L13:
        return new Pair(r102, r100);
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke() {
        return invoke2();
    }
}
