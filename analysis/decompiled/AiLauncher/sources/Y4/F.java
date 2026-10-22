package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class F {
    public final LinearLayout menuCard;
    public final LinearLayout menuItemDisconnect;
    public final LinearLayout menuItemRefresh;
    public final LinearLayout menuItemRename;
    private final FrameLayout rootView;

    public F(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        this.rootView = frameLayout;
        this.menuCard = linearLayout;
        this.menuItemDisconnect = linearLayout2;
        this.menuItemRefresh = linearLayout3;
        this.menuItemRename = linearLayout4;
    }

    public static F a(View view) {
        int i10 = R$id.menu_card;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.menu_item_disconnect;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.menu_item_refresh;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R$id.menu_item_rename;
                    LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout4 != null) {
                        return new F((FrameLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static F c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.popup_agent_menu, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
