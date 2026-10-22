package com.bytedance.android.ec.core.data;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rg.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/data/ActionObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lrg/a;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionObserver<T> implements Observer<a<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f43962a;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionObserver(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onActionUnhandledContent");
        this.f43962a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        a r101 = (a) r100;
        if (r101 == null) goto L8;
        Object r102 = r101.a();
        if (r102 == null) goto L9;
        this.f43962a.invoke((T) r102);
        return;
    L9:
        return;
    }
}
