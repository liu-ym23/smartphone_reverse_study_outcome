package com.bytedance.android.shopping.anchorv4.helper;

import android.widget.Toast;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f166962a;

    public l(Function0 r100) {
        this.f166962a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JisooResponse r101 = (JisooResponse) r100;
        Disposable r102 = JisooManager.f166873a;
        StringBuilder r103 = new StringBuilder("request success, time=");
        r103.append(r101.b());
        r103.append(" hasDTO=");
        boolean r104 = true;
        if (r101.a() == null) goto L5;
        boolean r105 = true;
    L6:
        r103.append(r105);
        JisooManager.b(r103.toString());
        if (JisooManager.f166876d.a() == false) goto L21;
        k r106 = JisooManager.f166874b.peekFirst();
        if (r106 == null) goto L21;
        Intrinsics.checkNotNullParameter(r101, "jisooResponse");
        PackResponseDTO r107 = r101.a();
        if (r107 == null) goto L17;
        String r108 = r106.f166960a;
        if (r108 != null) goto L15;
    L16:
        JisooManager.b("pack changed, start bind again");
        r106.f166960a = r101.b();
        r106.f166961b.a(r107);
    L19:
        if (Boolean.valueOf(r104).booleanValue() == false) goto L21;
        Intrinsics.checkNotNullParameter("bind by jisoo", "msg");
        Toast.makeText(ECAppInfoService.f48114e.getApplicationContext(), "bind by jisoo", 0).show();
        goto L21
    L15:
        if ((!Intrinsics.areEqual(r108, r101.b())) == true) goto L16;
    L17:
        r104 = false;
    L21:
        Function0 r109 = this.f166962a;
        if (r109 == null) goto L25;
        Unit r110 = (Unit) r109.invoke();
        return;
    L25:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
