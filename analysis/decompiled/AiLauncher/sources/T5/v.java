package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class v {
    private final LinearLayout rootView;
    public final TextView tvWaypointBadge;
    public final TextView tvWaypointMeta;
    public final TextView tvWaypointName;
    public final View vWaypointDot;
    public final FrameLayout vWaypointLine;

    public v(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, View view, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.tvWaypointBadge = textView;
        this.tvWaypointMeta = textView2;
        this.tvWaypointName = textView3;
        this.vWaypointDot = view;
        this.vWaypointLine = frameLayout;
    }

    public static v a(View view) {
        View viewA;
        int i10 = R$id.tvWaypointBadge;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.tvWaypointMeta;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.tvWaypointName;
                TextView textView3 = (TextView) C5437a.a(view, i10);
                if (textView3 != null && (viewA = C5437a.a(view, (i10 = R$id.vWaypointDot))) != null) {
                    i10 = R$id.vWaypointLine;
                    FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                    if (frameLayout != null) {
                        return new v((LinearLayout) view, textView, textView2, textView3, viewA, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static v c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_map_waypoint, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
