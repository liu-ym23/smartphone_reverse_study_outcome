package com.bytedance.android.live.core.utils.rxutils;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f66373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f66374b;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f66375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f66376b;

        public a(s r100, b r101) {
            this.f66375a = r100;
            this.f66376b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f66375a.f66373a.removeOnAttachStateChangeListener(this.f66376b);
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f66377a;

        public b(ObservableEmitter r100) {
            this.f66377a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f66377a.onNext(Boolean.TRUE);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f66377a.onNext(Boolean.FALSE);
        }
    }

    public s(View r100) {
        this.f66373a = r100;
        this.f66374b = true;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        if (this.f66374b == true) goto L5;
    L7:
        b r101 = new b(r100);
        this.f66373a.addOnAttachStateChangeListener(r101);
        r100.setCancellable(new a(this, r101));
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(this.f66373a) == false) goto L7;
        r100.onNext(Boolean.TRUE);
        goto L7
    }
}
