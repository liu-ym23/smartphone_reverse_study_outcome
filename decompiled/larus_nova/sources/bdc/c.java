package bdc;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends com.ss.android.lark.widget.photopicker.animation.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cdc.a f18715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeInterpolator f18716b;

    public c(cdc.a r100) {
        this.f18715a = r100;
    }

    @Override // com.ss.android.lark.widget.photopicker.animation.b
    public final void a(FragmentActivity r110) {
        if (this.f18716b != null) goto L5;
        this.f18716b = new DecelerateInterpolator();
    L5:
        cdc.a r100 = this.f18715a;
        TimeInterpolator r101 = this.f18716b;
        b r102 = new b(r110);
        Object r111 = cdc.c.f23435a;
        View r112 = r100.f23429f;
        int r103 = r100.f23428e;
        int r104 = r100.f23424a;
        int r105 = r100.f23425b;
        float r106 = r100.f23426c;
        long r107 = r103;
        r112.animate().setDuration(r107).scaleX(r106).scaleY(r100.f23427d).setInterpolator(r101).translationX(r104).setListener(null).translationY(r105);
        r112.postDelayed(r102, r107);
    }
}
