package com.bytedance.android.live.profile.ui.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ py.k f86934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f86935b;

    public static final class a extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f86936a;

        public a(ObservableEmitter r100) {
            this.f86936a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            this.f86936a.onComplete();
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            if (r102 == null) goto L4;
            r102.start();
        L4:
            this.f86936a.onComplete();
        }
    }

    public b(py.k r100, HSImageView r101) {
        this.f86934a = r100;
        this.f86935b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = d.f86940a;
        AbstractDraweeController r102 = d.a(this.f86934a);
        if (r102 == null) goto L5;
        r102.addControllerListener(new a(r100));
        this.f86935b.setController(r102);
        return;
    L5:
        r100.onComplete();
    }
}
