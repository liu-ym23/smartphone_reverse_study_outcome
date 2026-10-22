package b02;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import java.util.Random;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboProgressAnimationView f16832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16833b;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    public g(ComboProgressAnimationView r100, boolean r101) {
        this.f16832a = r100;
        this.f16833b = r101;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void b(py.k r100, Exception r101) {
        ConstraintLayout r102 = (ConstraintLayout) this.f16832a.a(R.id.combo_count_container);
        if (r102 == null) goto L6;
        r102.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        HSImageView r104 = this.f16832a.f128661w;
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L5;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
    L7:
        if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L19;
        float r107 = r101 / r102;
        HSImageView r108 = this.f16832a.f128661w;
        if (r108 == null) goto L11;
        r105 = r108.getLayoutParams();
    L11:
        if (r105 == null) goto L13;
        r105.height = (int) this.f16832a.getContext().getResources().getDimension(R.dimen.ttlive_gift_special_combo_view_height);
    L13:
        if (r105 == null) goto L15;
        r105.width = (int) (r105.height * r107);
    L15:
        HSImageView r109 = this.f16832a.f128661w;
        if (r109 == null) goto L19;
        r109.setLayoutParams(r105);
    L19:
        if ((new Random().nextInt(10) % 2) != 0) goto L21;
        float r110 = -5.0f;
    L22:
        HSImageView r111 = this.f16832a.f128661w;
        if (r111 == null) goto L26;
        r111.setRotation(r110);
    L26:
        if (this.f16833b == false) goto L29;
        ComboProgressAnimationView.c(this.f16832a, false, false);
        return;
    L29:
        return;
    L21:
        r110 = 5.0f;
        goto L22
    L5:
        r106 = null;
        goto L7
    }
}
