package com.bytedance.android.livesdk.widgetdescriptor.delegate.element;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.KeyboardViewModel;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import j70.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends l70.a<e0> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widgetdescriptor.delegate.element.a$a, reason: collision with other inner class name */
    public static final class C2481a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f162367a;

        public C2481a(a r100) {
            this.f162367a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KeyboardViewModel.a r101 = (KeyboardViewModel.a) r100;
            v70.a r102 = this.f162367a.f507763b;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        L5:
            if (r101 == null) goto L7;
            float r103 = r101.f133033a;
        L8:
            r102.setTranslationY(r103);
            return;
        L7:
            r103 = 0.0f;
            goto L8
        }
    }

    @Override // l70.a
    public final void d() {
    }

    @Override // l70.a
    public final void c() {
        MutableLiveData<KeyboardViewModel.a> r100 = ((KeyboardViewModel) getViewModel(KeyboardViewModel.class)).getKeyboardData();
        LifecycleOwner r101 = this.f507764c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
    L5:
        r100.observe(r101, new C2481a(this));
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        super(r100);
    }
}
