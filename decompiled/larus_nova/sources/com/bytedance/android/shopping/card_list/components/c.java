package com.bytedance.android.shopping.card_list.components;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f171462a;

    public final class a implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f171463a;

        public a(Function1 r100) {
            this.f171463a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f171463a.invoke(r100);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f171464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f171465b;

        public b(Ref.IntRef r100, Function1 r101) {
            this.f171464a = r100;
            this.f171465b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            if (this.f171464a.element < 1) goto L5;
            this.f171465b.invoke(r100);
        L5:
            this.f171464a.element++;
        }
    }

    public LifecycleOwner a() {
        return this.f171462a;
    }

    public c(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f171462a = r100;
    }

    public final <T> void b(MutableLiveData<T> r100, Function1<? super T, Unit> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "liveData");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r102 == false) goto L5;
    L8:
        r100.observe(a(), new a(r101));
        return;
    L5:
        if (r100.getValue() == null) goto L8;
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = 0;
        r100.observe(a(), new b(r103, r101));
    }
}
