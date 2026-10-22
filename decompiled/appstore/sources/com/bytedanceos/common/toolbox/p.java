package com.bytedanceos.common.toolbox;

import android.view.View;
import com.jakewharton.rxbinding.view.RxView;
import java.util.concurrent.TimeUnit;
import rx.Observer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    public static abstract class a implements Observer {
        public a() {
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
        }
    }

    public static void a(View r10, long r11, Observer r12) {
        RxView.clicks(r10).u(r11, TimeUnit.MILLISECONDS).p(r12);
    }

    public static void b(View r10, Observer r11) {
        a(r10, 500, r11);
    }
}
