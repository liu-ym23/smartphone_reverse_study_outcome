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

/* renamed from: Y4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1118b {
    public final ImageButton btnBack;
    public final ImageButton btnCopyStep1Mac;
    public final ImageButton btnCopyStep1Win;
    public final ImageButton btnCopyStep2;
    public final ImageButton btnScan;
    public final LinearLayout contentColumn;
    private final LinearLayout rootView;
    public final FrameLayout topNav;
    public final TextView tvPrerequisiteDesc;
    public final TextView tvPrerequisiteTitle;
    public final TextView tvStep1CmdMac;
    public final TextView tvStep1CmdWin;
    public final TextView tvStep2Cmd;
    public final TextView tvTitle;

    public C1118b(LinearLayout linearLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.btnBack = imageButton;
        this.btnCopyStep1Mac = imageButton2;
        this.btnCopyStep1Win = imageButton3;
        this.btnCopyStep2 = imageButton4;
        this.btnScan = imageButton5;
        this.contentColumn = linearLayout2;
        this.topNav = frameLayout;
        this.tvPrerequisiteDesc = textView;
        this.tvPrerequisiteTitle = textView2;
        this.tvStep1CmdMac = textView3;
        this.tvStep1CmdWin = textView4;
        this.tvStep2Cmd = textView5;
        this.tvTitle = textView6;
    }

    public static C1118b a(View view) {
        int i10 = R$id.btn_back;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.btn_copy_step1_mac;
            ImageButton imageButton2 = (ImageButton) C5437a.a(view, i10);
            if (imageButton2 != null) {
                i10 = R$id.btn_copy_step1_win;
                ImageButton imageButton3 = (ImageButton) C5437a.a(view, i10);
                if (imageButton3 != null) {
                    i10 = R$id.btn_copy_step2;
                    ImageButton imageButton4 = (ImageButton) C5437a.a(view, i10);
                    if (imageButton4 != null) {
                        i10 = R$id.btn_scan;
                        ImageButton imageButton5 = (ImageButton) C5437a.a(view, i10);
                        if (imageButton5 != null) {
                            i10 = R$id.content_column;
                            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout != null) {
                                i10 = R$id.top_nav;
                                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout != null) {
                                    i10 = R$id.tv_prerequisite_desc;
                                    TextView textView = (TextView) C5437a.a(view, i10);
                                    if (textView != null) {
                                        i10 = R$id.tv_prerequisite_title;
                                        TextView textView2 = (TextView) C5437a.a(view, i10);
                                        if (textView2 != null) {
                                            i10 = R$id.tv_step1_cmd_mac;
                                            TextView textView3 = (TextView) C5437a.a(view, i10);
                                            if (textView3 != null) {
                                                i10 = R$id.tv_step1_cmd_win;
                                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                                if (textView4 != null) {
                                                    i10 = R$id.tv_step2_cmd;
                                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                                    if (textView5 != null) {
                                                        i10 = R$id.tv_title;
                                                        TextView textView6 = (TextView) C5437a.a(view, i10);
                                                        if (textView6 != null) {
                                                            return new C1118b((LinearLayout) view, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, linearLayout, frameLayout, textView, textView2, textView3, textView4, textView5, textView6);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1118b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C1118b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_connect_external_agent, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
