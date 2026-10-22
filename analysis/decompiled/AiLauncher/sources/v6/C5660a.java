package v6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.ailauncher.taskstore.R$layout;
import s1.C5437a;

/* renamed from: v6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5660a {
    public final TextView btnMediumCardAction;
    public final TextView btnMediumCardActionDoublePrimary;
    public final TextView btnMediumCardActionDoubleSecondary;
    public final TextView btnMediumCardActionSingle;
    public final TextView btnMediumCardActionTriplePrimary;
    public final TextView btnMediumCardActionTripleSecondary;
    public final TextView btnMediumCardActionTripleTertiary;
    public final ImageView ivMediumCardDecoration;
    public final ImageView ivMediumCardIcon;
    public final LinearLayout layoutMediumCardActionDouble;
    public final LinearLayout layoutMediumCardActionRow;
    public final LinearLayout layoutMediumCardActionSingle;
    public final LinearLayout layoutMediumCardActionTriple;
    public final LinearLayout layoutMediumCardActions;
    public final LinearLayout layoutMediumCardHeader;
    public final LinearLayout layoutMediumCardStatusRow;
    public final LinearLayout layoutMediumCardText;
    public final FrameLayout layoutMediumCardVisual;
    private final LinearLayout rootView;
    public final SweepTextView tvMediumCardSubtitle;
    public final TextView tvMediumCardTitle;
    public final TextView tvMediumCardToolcallName;

    public C5660a(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, FrameLayout frameLayout, SweepTextView sweepTextView, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.btnMediumCardAction = textView;
        this.btnMediumCardActionDoublePrimary = textView2;
        this.btnMediumCardActionDoubleSecondary = textView3;
        this.btnMediumCardActionSingle = textView4;
        this.btnMediumCardActionTriplePrimary = textView5;
        this.btnMediumCardActionTripleSecondary = textView6;
        this.btnMediumCardActionTripleTertiary = textView7;
        this.ivMediumCardDecoration = imageView;
        this.ivMediumCardIcon = imageView2;
        this.layoutMediumCardActionDouble = linearLayout2;
        this.layoutMediumCardActionRow = linearLayout3;
        this.layoutMediumCardActionSingle = linearLayout4;
        this.layoutMediumCardActionTriple = linearLayout5;
        this.layoutMediumCardActions = linearLayout6;
        this.layoutMediumCardHeader = linearLayout7;
        this.layoutMediumCardStatusRow = linearLayout8;
        this.layoutMediumCardText = linearLayout9;
        this.layoutMediumCardVisual = frameLayout;
        this.tvMediumCardSubtitle = sweepTextView;
        this.tvMediumCardTitle = textView8;
        this.tvMediumCardToolcallName = textView9;
    }

    public static C5660a a(View view) {
        int i10 = R$id.btn_medium_card_action;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.btn_medium_card_action_double_primary;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.btn_medium_card_action_double_secondary;
                TextView textView3 = (TextView) C5437a.a(view, i10);
                if (textView3 != null) {
                    i10 = R$id.btn_medium_card_action_single;
                    TextView textView4 = (TextView) C5437a.a(view, i10);
                    if (textView4 != null) {
                        i10 = R$id.btn_medium_card_action_triple_primary;
                        TextView textView5 = (TextView) C5437a.a(view, i10);
                        if (textView5 != null) {
                            i10 = R$id.btn_medium_card_action_triple_secondary;
                            TextView textView6 = (TextView) C5437a.a(view, i10);
                            if (textView6 != null) {
                                i10 = R$id.btn_medium_card_action_triple_tertiary;
                                TextView textView7 = (TextView) C5437a.a(view, i10);
                                if (textView7 != null) {
                                    i10 = R$id.iv_medium_card_decoration;
                                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                                    if (imageView != null) {
                                        i10 = R$id.iv_medium_card_icon;
                                        ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                        if (imageView2 != null) {
                                            i10 = R$id.layout_medium_card_action_double;
                                            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout != null) {
                                                i10 = R$id.layout_medium_card_action_row;
                                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout2 != null) {
                                                    i10 = R$id.layout_medium_card_action_single;
                                                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout3 != null) {
                                                        i10 = R$id.layout_medium_card_action_triple;
                                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                                        if (linearLayout4 != null) {
                                                            i10 = R$id.layout_medium_card_actions;
                                                            LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                            if (linearLayout5 != null) {
                                                                i10 = R$id.layout_medium_card_header;
                                                                LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                                if (linearLayout6 != null) {
                                                                    i10 = R$id.layout_medium_card_status_row;
                                                                    LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                                                    if (linearLayout7 != null) {
                                                                        i10 = R$id.layout_medium_card_text;
                                                                        LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                                                        if (linearLayout8 != null) {
                                                                            i10 = R$id.layout_medium_card_visual;
                                                                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                                                                            if (frameLayout != null) {
                                                                                i10 = R$id.tv_medium_card_subtitle;
                                                                                SweepTextView sweepTextView = (SweepTextView) C5437a.a(view, i10);
                                                                                if (sweepTextView != null) {
                                                                                    i10 = R$id.tv_medium_card_title;
                                                                                    TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                    if (textView8 != null) {
                                                                                        i10 = R$id.tv_medium_card_toolcall_name;
                                                                                        TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                        if (textView9 != null) {
                                                                                            return new C5660a((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, frameLayout, sweepTextView, textView8, textView9);
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

    public static C5660a b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_taskstore_card_medium, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
