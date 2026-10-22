package f7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19541a;

    public b(List r10) {
        q.g(r10, "viewData");
        this.f19541a = r10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        q.g(r10, "container");
        q.g(r12, "any");
        r10.removeView((View) this.f19541a.get(r11));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f19541a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r10, int r11) {
        q.g(r10, "container");
        ImageView r12 = (ImageView) this.f19541a.get(r11);
        r10.addView(r12, 0);
        return r12;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r10, Object r11) {
        q.g(r10, "view");
        q.g(r11, "o");
        if (r10 != r11) goto L5;
        return true;
    L5:
        return false;
    }
}
