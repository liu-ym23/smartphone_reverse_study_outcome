package com.bytedance.android.gamecp.business.download.util;

import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f52953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f52954b;

    public e(Ref.ObjectRef r100, Function1 r101) {
        this.f52953a = r100;
        this.f52954b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        Disposable r102 = (Disposable) this.f52953a.element;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        Pair[] r103 = new Pair[2];
        r103[0] = TuplesKt.to("if_eqry_bag_success", "success");
        if (r101.isEmpty() == false) goto L8;
        String r104 = BdpAppEventConstant.NO;
    L9:
        r103[1] = TuplesKt.to("if_have_bag", r104);
        Map r105 = MapsKt.mutableMapOf(r103);
        if ((!r101.isEmpty()) == true) goto L24;
    L22:
        this.f52954b.invoke(r105);
        return;
    L24:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(e1.a(r101));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r107) == false) goto L18;
        r107 = null;
    L18:
        String r108 = (String) r107;
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        r105.put("have_bag_name", r108);
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L8:
        r104 = BdpAppEventConstant.YES;
        goto L9
    }
}
