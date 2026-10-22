package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: PageTransformerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f2964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager2.g f2965b;

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int r1) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int r1) {
    }

    f(LinearLayoutManager r1) {
        this.f2964a = r1;
    }

    ViewPager2.g a() {
        return this.f2965b;
    }

    void a(ViewPager2.g r3) {
        this.f2965b = (ViewPager2.g) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.g.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int r5, float r6, int r7) {
        if (this.f2965b != null) goto L5;
        return;
    L5:
        float r8 = -r6;
        int r0 = 0;
    L7:
        if (r0 >= this.f2964a.x()) goto L13;
        View r1 = this.f2964a.i(r0);
        if (r1 == null) goto L12;
        this.f2965b.a(r1, (this.f2964a.d(r1) - r5) + r8);
        r0 = r0 + 1;
        goto L7
    L12:
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(r0), Integer.valueOf(this.f2964a.x())}));
    }
}
