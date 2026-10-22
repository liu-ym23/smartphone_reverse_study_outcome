package com.bytedance.android.shopping.base;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fa3.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/base/ActionObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lfa3/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionObserver<T> implements Observer<a<? extends T>> {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        a r101 = (a) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f476019a == true) goto L10;
        r101.f476019a = true;
        return;
    }
}
