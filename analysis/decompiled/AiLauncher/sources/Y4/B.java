package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class B {
    public final FrameLayout actionArea;
    public final FrameLayout iconPlaceholder;
    public final ImageView ivSkillIcon;
    private final LinearLayout rootView;
    public final TextView tvCli;
    public final TextView tvDescription;
    public final TextView tvSkillIconChar;
    public final TextView tvSourceDownload;
    public final TextView tvTitle;
    public final TextView tvUpdateBadge;
    public final TextView txtSource;

    public B(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.actionArea = frameLayout;
        this.iconPlaceholder = frameLayout2;
        this.ivSkillIcon = imageView;
        this.tvCli = textView;
        this.tvDescription = textView2;
        this.tvSkillIconChar = textView3;
        this.tvSourceDownload = textView4;
        this.tvTitle = textView5;
        this.tvUpdateBadge = textView6;
        this.txtSource = textView7;
    }

    public static B a(View view) {
        int i10 = R$id.action_area;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.icon_placeholder;
            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R$id.iv_skill_icon;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.tv_cli;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.tv_description;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tv_skill_icon_char;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tv_source_download;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    i10 = R$id.tv_title;
                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                    if (textView5 != null) {
                                        i10 = R$id.tv_update_badge;
                                        TextView textView6 = (TextView) C5437a.a(view, i10);
                                        if (textView6 != null) {
                                            i10 = R$id.txt_source;
                                            TextView textView7 = (TextView) C5437a.a(view, i10);
                                            if (textView7 != null) {
                                                return new B((LinearLayout) view, frameLayout, frameLayout2, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static B c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_skill_card, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
