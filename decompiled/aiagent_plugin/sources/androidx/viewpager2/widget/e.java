package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MarginPageTransformer.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ViewPager2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2963a;

    public e(int r2) {
        androidx.core.util.g.a(r2, "Margin must be non-negative");
        this.f2963a = r2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.g
    public void a(View r2, float r3) {
        ViewPager2 r0 = a(r2);
        float r1 = this.f2963a * r3;
        if (r0.getOrientation() == 0) goto L5;
        r2.setTranslationY(r1);
        return;
    L5:
        if (r0.isRtl() == false) goto L7;
        r1 = -r1;
    L7:
        r2.setTranslationX(r1);
    }

    private ViewPager2 a(View r2) {
        ViewParent r1 = r2.getParent();
        ViewParent r3 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r1, RecyclerView.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, ViewPager2.class) == false) goto L9;
        return (ViewPager2) ZeusTransformUtils.preCheckCast(r3, ViewPager2.class, "com.obric.aiagent.plugin");
    L9:
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
