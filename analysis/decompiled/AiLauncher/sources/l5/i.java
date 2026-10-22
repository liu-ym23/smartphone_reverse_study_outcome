package l5;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.ailauncher.chat.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class i {
    public final ViewPager2 chatPager;
    public final View chatPagerGlass;
    private final FrameLayout rootView;

    public i(FrameLayout frameLayout, ViewPager2 viewPager2, View view) {
        this.rootView = frameLayout;
        this.chatPager = viewPager2;
        this.chatPagerGlass = view;
    }

    public static i a(View view) {
        View viewA;
        int i10 = R$id.chat_pager;
        ViewPager2 viewPager2 = (ViewPager2) C5437a.a(view, i10);
        if (viewPager2 == null || (viewA = C5437a.a(view, (i10 = R$id.chat_pager_glass))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        return new i((FrameLayout) view, viewPager2, viewA);
    }
}
