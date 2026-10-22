package b02;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboIconAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboIconAnimationView f16831a;

    public f(ComboIconAnimationView r100) {
        this.f16831a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        ComboIconAnimationView r102 = this.f16831a;
        r102.f128632d = r101;
        r102.d(r101, r102.f128635g.nextInt(10));
    }
}
