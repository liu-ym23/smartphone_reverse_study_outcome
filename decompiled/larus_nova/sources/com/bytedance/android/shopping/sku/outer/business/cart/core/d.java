package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f183081a = null;

    static {
        f183081a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SsResponse r101 = (SsResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "ssResp");
        String r102 = (String) r101.body();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r102 = SliceInitService.DEFAULT_SWITCH;
    L11:
        th3.c r104 = new th3.c(new JSONObject(r102));
        Iterator<T> r105 = r101.headers().iterator();
    L12:
        String r106 = null;
        if (r105.hasNext() == false) goto L17;
        T r107 = r105.next();
        if (Intrinsics.areEqual(((Header) r107).getName(), Constants.Keys.KEY_X_TT_LOGID.toLowerCase(Locale.getDefault())) == false) goto L12;
    L18:
        Header r108 = r107;
        if (r108 == null) goto L21;
        r106 = r108.getValue();
    L21:
        r104.f545931d = r106;
        return r104;
    L17:
        r107 = (T) null;
        goto L18
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }
}
