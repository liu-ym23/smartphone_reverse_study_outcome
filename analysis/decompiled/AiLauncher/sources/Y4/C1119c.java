package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* renamed from: Y4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1119c {
    public final ImageButton btnAccountLink;
    public final ImageButton btnBack;
    public final ImageButton btnCopyUrl;
    public final ImageButton btnScan;
    public final LinearLayout contentColumn;
    private final LinearLayout rootView;
    public final FrameLayout topNav;
    public final TextView tvTitle;

    public C1119c(LinearLayout linearLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView) {
        this.rootView = linearLayout;
        this.btnAccountLink = imageButton;
        this.btnBack = imageButton2;
        this.btnCopyUrl = imageButton3;
        this.btnScan = imageButton4;
        this.contentColumn = linearLayout2;
        this.topNav = frameLayout;
        this.tvTitle = textView;
    }

    public static C1119c a(View view) {
        int i10 = R$id.btn_account_link;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.btn_back;
            ImageButton imageButton2 = (ImageButton) C5437a.a(view, i10);
            if (imageButton2 != null) {
                i10 = R$id.btn_copy_url;
                ImageButton imageButton3 = (ImageButton) C5437a.a(view, i10);
                if (imageButton3 != null) {
                    i10 = R$id.btn_scan;
                    ImageButton imageButton4 = (ImageButton) C5437a.a(view, i10);
                    if (imageButton4 != null) {
                        i10 = R$id.content_column;
                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R$id.top_nav;
                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout != null) {
                                i10 = R$id.tv_title;
                                TextView textView = (TextView) C5437a.a(view, i10);
                                if (textView != null) {
                                    return new C1119c((LinearLayout) view, imageButton, imageButton2, imageButton3, imageButton4, linearLayout, frameLayout, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1119c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C1119c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_connect_step_agent, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
