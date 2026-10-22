package androidx.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5200a;

    public c() {
        this.f5200a = new ArrayList();
    }

    public void a(ViewPager2.PageTransformer r10) {
        this.f5200a.add(r10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r10, float r11) {
        Iterator r12 = this.f5200a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((ViewPager2.PageTransformer) r12.next()).transformPage(r10, r11);
        goto L4
    }
}
