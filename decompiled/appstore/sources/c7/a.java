package c7;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.z;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f6063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f6064g;

    public a(String[] r10, Map r11, FragmentManager r12) {
        q.g(r10, "titles");
        q.g(r11, "tabFragmentsCreators");
        q.g(r12, "fragmentManager");
        super(r12, 1);
        this.f6063f = r10;
        this.f6064g = r11;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f6064g.size();
    }

    @Override // androidx.fragment.app.z
    public Fragment getItem(int r10) {
        Function0 r11 = (Function0) this.f6064g.get(Integer.valueOf(r10));
        if (r11 == null) goto L8;
        Fragment r12 = (Fragment) r11.invoke();
        if (r12 == null) goto L8;
        return r12;
    L8:
        throw new IndexOutOfBoundsException();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r10) {
        return this.f6063f[r10];
    }
}
