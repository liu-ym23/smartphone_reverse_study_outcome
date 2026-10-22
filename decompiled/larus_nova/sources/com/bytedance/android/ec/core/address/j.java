package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.GetAddressResponse;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f43692a = null;

    static {
        f43692a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        GetAddressResponse r101 = (GetAddressResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        List<AddressItemVO> r102 = r101.getAddressList();
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        ((AddressItemVO) r103.next()).parseAddress();
    L8:
        return r101;
    }
}
