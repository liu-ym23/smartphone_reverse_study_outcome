package v6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.agentframework.chatui.view.NestedScrollableHost;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.ailauncher.taskstore.R$layout;
import com.stepos.ailauncher.taskstore.widget.HalftoneShaderView;
import s1.C5437a;

/* renamed from: v6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5661b {
    public final TextView btnTtiCardAction;
    public final NestedScrollableHost hostTtiCardMultiImage;
    public final ImageView ivTtiCardFailIcon;
    public final ImageView ivTtiCardIcon;
    public final ImageView ivTtiCardResultImage;
    public final LinearLayout layoutTtiCardActionRow;
    public final FrameLayout layoutTtiCardExpiredOverlay;
    public final FrameLayout layoutTtiCardFailOverlay;
    public final FrameLayout layoutTtiCardGeneratingOverlay;
    public final LinearLayout layoutTtiCardHeader;
    public final NestedScrollableHost layoutTtiCardSingleImage;
    public final LinearLayout layoutTtiCardStatusRow;
    public final LinearLayout layoutTtiCardText;
    public final ConstraintLayout layoutTtiCardVisual;
    private final LinearLayout rootView;
    public final RecyclerView rvTtiCardMultiImage;
    public final HalftoneShaderView shaderTtiCardLoading;
    public final TextView tvTtiCardExpired;
    public final TextView tvTtiCardGeneratingText;
    public final SweepTextView tvTtiCardSubtitle;
    public final TextView tvTtiCardTitle;
    public final TextView tvTtiCardToolcallName;

    public C5661b(LinearLayout linearLayout, TextView textView, NestedScrollableHost nestedScrollableHost, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout3, NestedScrollableHost nestedScrollableHost2, LinearLayout linearLayout4, LinearLayout linearLayout5, ConstraintLayout constraintLayout, RecyclerView recyclerView, HalftoneShaderView halftoneShaderView, TextView textView2, TextView textView3, SweepTextView sweepTextView, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnTtiCardAction = textView;
        this.hostTtiCardMultiImage = nestedScrollableHost;
        this.ivTtiCardFailIcon = imageView;
        this.ivTtiCardIcon = imageView2;
        this.ivTtiCardResultImage = imageView3;
        this.layoutTtiCardActionRow = linearLayout2;
        this.layoutTtiCardExpiredOverlay = frameLayout;
        this.layoutTtiCardFailOverlay = frameLayout2;
        this.layoutTtiCardGeneratingOverlay = frameLayout3;
        this.layoutTtiCardHeader = linearLayout3;
        this.layoutTtiCardSingleImage = nestedScrollableHost2;
        this.layoutTtiCardStatusRow = linearLayout4;
        this.layoutTtiCardText = linearLayout5;
        this.layoutTtiCardVisual = constraintLayout;
        this.rvTtiCardMultiImage = recyclerView;
        this.shaderTtiCardLoading = halftoneShaderView;
        this.tvTtiCardExpired = textView2;
        this.tvTtiCardGeneratingText = textView3;
        this.tvTtiCardSubtitle = sweepTextView;
        this.tvTtiCardTitle = textView4;
        this.tvTtiCardToolcallName = textView5;
    }

    public static C5661b a(View view) {
        int i10 = R$id.btn_tti_card_action;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.host_tti_card_multi_image;
            NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) C5437a.a(view, i10);
            if (nestedScrollableHost != null) {
                i10 = R$id.iv_tti_card_fail_icon;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.iv_tti_card_icon;
                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R$id.iv_tti_card_result_image;
                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                        if (imageView3 != null) {
                            i10 = R$id.layout_tti_card_action_row;
                            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout != null) {
                                i10 = R$id.layout_tti_card_expired_overlay;
                                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout != null) {
                                    i10 = R$id.layout_tti_card_fail_overlay;
                                    FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                                    if (frameLayout2 != null) {
                                        i10 = R$id.layout_tti_card_generating_overlay;
                                        FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                        if (frameLayout3 != null) {
                                            i10 = R$id.layout_tti_card_header;
                                            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout2 != null) {
                                                i10 = R$id.layout_tti_card_single_image;
                                                NestedScrollableHost nestedScrollableHost2 = (NestedScrollableHost) C5437a.a(view, i10);
                                                if (nestedScrollableHost2 != null) {
                                                    i10 = R$id.layout_tti_card_status_row;
                                                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout3 != null) {
                                                        i10 = R$id.layout_tti_card_text;
                                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                                        if (linearLayout4 != null) {
                                                            i10 = R$id.layout_tti_card_visual;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
                                                            if (constraintLayout != null) {
                                                                i10 = R$id.rv_tti_card_multi_image;
                                                                RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                                                if (recyclerView != null) {
                                                                    i10 = R$id.shader_tti_card_loading;
                                                                    HalftoneShaderView halftoneShaderView = (HalftoneShaderView) C5437a.a(view, i10);
                                                                    if (halftoneShaderView != null) {
                                                                        i10 = R$id.tv_tti_card_expired;
                                                                        TextView textView2 = (TextView) C5437a.a(view, i10);
                                                                        if (textView2 != null) {
                                                                            i10 = R$id.tv_tti_card_generating_text;
                                                                            TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                            if (textView3 != null) {
                                                                                i10 = R$id.tv_tti_card_subtitle;
                                                                                SweepTextView sweepTextView = (SweepTextView) C5437a.a(view, i10);
                                                                                if (sweepTextView != null) {
                                                                                    i10 = R$id.tv_tti_card_title;
                                                                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                    if (textView4 != null) {
                                                                                        i10 = R$id.tv_tti_card_toolcall_name;
                                                                                        TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                                        if (textView5 != null) {
                                                                                            return new C5661b((LinearLayout) view, textView, nestedScrollableHost, imageView, imageView2, imageView3, linearLayout, frameLayout, frameLayout2, frameLayout3, linearLayout2, nestedScrollableHost2, linearLayout3, linearLayout4, constraintLayout, recyclerView, halftoneShaderView, textView2, textView3, sweepTextView, textView4, textView5);
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

    public static C5661b b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_taskstore_card_text_to_image, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
