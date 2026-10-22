package androidx.viewpager2.widget;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CompositePageTransformer.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ViewPager2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.g> f2957a;

    public c() {
        this.f2957a = new ArrayList();
    }

    public void a(ViewPager2.g r3) {
        ViewPager2.g r4 = (ViewPager2.g) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.g.class, "com.obric.aiagent.plugin");
        this.f2957a.add(r4);
    }

    public void b(ViewPager2.g r3) {
        ViewPager2.g r4 = (ViewPager2.g) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.g.class, "com.obric.aiagent.plugin");
        this.f2957a.remove(r4);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.g
    public void a(View r4, float r5) {
        Iterator<ViewPager2.g> r3 = this.f2957a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ViewPager2.g) ZeusTransformUtils.preCheckCast(r3.next(), ViewPager2.g.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L4
    }
}
