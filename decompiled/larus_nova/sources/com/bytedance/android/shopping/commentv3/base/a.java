package com.bytedance.android.shopping.commentv3.base;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.commentv3.base.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a<State extends b> extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f172672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<State> f172673b;

    public a() {
    }

    public final void e(Function1<? super State, ? extends State> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        MutableLiveData<State> r101 = this.f172673b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L5:
        State r102 = r101.getValue();
        if (r102 == null) goto L8;
        State r103 = r100.invoke(r102);
    L9:
        MutableLiveData<State> r104 = this.f172673b;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L12:
        r104.setValue(r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void d(b r100, BaseUI$bindLogic$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "cb");
        if (this.f172672a == true) goto L5;
        this.f172672a = true;
        this.f172673b = new MutableLiveData(r100);
    L5:
        MutableLiveData<State> r102 = this.f172673b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L8:
        r101.invoke(r102);
    }
}
