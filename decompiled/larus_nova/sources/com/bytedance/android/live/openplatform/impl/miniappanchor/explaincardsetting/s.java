package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<T> f84447a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f84448a;

        public a(Function1 r100) {
            this.f84448a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            this.f84448a.invoke(r100);
        }
    }

    public s() {
        this.f84447a = new MutableLiveData();
    }

    public final void a(LifecycleOwner r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f84447a.observe(r100, new a(r101));
    }
}
