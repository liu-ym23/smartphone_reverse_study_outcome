package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0015\u0010\u0002\u001a\u00110\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lkotlin/ParameterName;", "name", "rawSeiData", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class SeiDataInterceptor$ktvRoomInstance$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public SeiDataInterceptor$ktvRoomInstance$1(s r100) {
        super(1, r100, s.class, "ktvSeiFilter", "ktvSeiFilter(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        s r101 = (s) this.receiver;
        s r102 = s.f143338a;
        r101.getClass();
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        return null;
    L10:
        if (StringsKt.startsWith$default(r100, "JSON", false, 2, null) == false) goto L13;
        r100 = r100.substring(4);
    L13:
        if (StringsKt.contains$default(r100, "ktv_", false, 2, null) == true) goto L15;
        return null;
    L15:
        return r100;
    L5:
        r103 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
