package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class SeiDataInterceptor$instance$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public SeiDataInterceptor$instance$1(s r100) {
        super(1, r100, s.class, "defaultSeiFilter", "defaultSeiFilter(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r110) {
        Intrinsics.checkNotNullParameter(r110, "p1");
        s r100 = (s) this.receiver;
        s r101 = s.f143338a;
        r100.getClass();
        if (r110.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        pd2.d.J(pd2.d.f528658n, "data_empty", null, null, null, 30);
        return null;
    L10:
        if (StringsKt.startsWith$default(r110, "JSON", false, 2, null) == false) goto L13;
        r110 = r110.substring(4);
    L13:
        if (StringsKt.contains$default(r110, "ktv_", false, 2, null) == true) goto L15;
        return null;
    L15:
        return r110;
    L5:
        r102 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
