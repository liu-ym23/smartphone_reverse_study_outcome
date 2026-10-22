package com.bytedance.android.livesdk.ceremony.view;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f104972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageModel f104973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f104974c;

    public static final class a extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f104975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f104976b;

        public a(m r100, ObservableEmitter r101) {
            this.f104975a = r100;
            this.f104976b = r101;
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void f(py.k r100, Exception r101) {
            this.f104976b.onError(new Throwable());
        }

        @Override // com.bytedance.android.live.core.utils.q0
        public final void h(py.k r100, int r101, int r102) {
            ViewGroup.LayoutParams r103 = this.f104975a.f104972a.getLayoutParams();
            m r104 = this.f104975a;
            float r105 = r104.f104974c;
            r103.width = (int) (r101 * r105);
            r103.height = (int) (r102 * r105);
            r104.f104972a.setLayoutParams(r103);
            this.f104976b.onComplete();
        }
    }

    public m(HSImageView r100, ImageModel r101, float r102) {
        this.f104972a = r100;
        this.f104973b = r101;
        this.f104974c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ImageLoader.bindImage(this.f104972a, this.f104973b, new a(this, r100), false);
    }
}
