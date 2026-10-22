package r6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.stepos.ailauncher.task.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class f {
    public final ImageView btnAdd;
    public final ImageView btnBack;
    private final LinearLayout rootView;
    public final TabLayout tabLayout;
    public final ViewPager2 viewPager;

    public f(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.btnAdd = imageView;
        this.btnBack = imageView2;
        this.tabLayout = tabLayout;
        this.viewPager = viewPager2;
    }

    public static f a(View view) {
        int i10 = R$id.btn_add;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btn_back;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.tab_layout;
                TabLayout tabLayout = (TabLayout) C5437a.a(view, i10);
                if (tabLayout != null) {
                    i10 = R$id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) C5437a.a(view, i10);
                    if (viewPager2 != null) {
                        return new f((LinearLayout) view, imageView, imageView2, tabLayout, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
