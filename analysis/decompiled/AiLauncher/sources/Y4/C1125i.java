package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import s1.C5437a;

/* renamed from: Y4.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1125i {
    public final FrameLayout actionArea;
    public final TextView btnBottomUpdate;
    public final TextView btnReadmeViewFull;
    public final FrameLayout btnTopUninstall;
    public final LinearLayout cardReadme;
    public final FrameLayout flDescriptionWrap;
    public final FrameLayout footerContainer;
    public final LinearLayout groupAssetInfo;
    public final LinearLayout heroRow;
    public final FrameLayout iconPlaceholder;
    public final ImageView ivBack;
    public final ImageView ivSkillIcon;
    public final ImageView ivTopUninstall;
    public final LinearLayout llAuthorRow;
    public final LinearLayout llDescriptionToggle;
    public final LinearLayout llUpdateBanner;
    public final IndeterminateSpinnerView pbBottomUpdate;
    public final IndeterminateSpinnerView pbTopUninstall;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final C rowCategory;
    public final C rowCreated;
    public final C rowDownload;
    public final C rowUpdated;
    public final C rowVersion;
    public final ScrollView scrollView;
    public final LinearLayout toolbar;
    public final TextView tvDescription;
    public final TextView tvDescriptionToggle;
    public final TextView tvMeta;
    public final TextView tvReadme;
    public final TextView tvReadmeSectionTitle;
    public final TextView tvSkillIconChar;
    public final TextView tvThirdPartyTag;
    public final TextView tvTitle;
    public final TextView tvUpdateBannerChangelog;
    public final TextView tvUpdateBannerSize;
    public final TextView tvUpdateBannerTitle;
    public final View vBottomBlur;
    public final View vDescriptionFade;
    public final View vTopFade;

    public C1125i(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2, FrameLayout frameLayout3, LinearLayout linearLayout, FrameLayout frameLayout4, FrameLayout frameLayout5, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout6, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, IndeterminateSpinnerView indeterminateSpinnerView, IndeterminateSpinnerView indeterminateSpinnerView2, FrameLayout frameLayout7, C c10, C c11, C c12, C c13, C c14, ScrollView scrollView, LinearLayout linearLayout7, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, View view, View view2, View view3) {
        this.rootView = frameLayout;
        this.actionArea = frameLayout2;
        this.btnBottomUpdate = textView;
        this.btnReadmeViewFull = textView2;
        this.btnTopUninstall = frameLayout3;
        this.cardReadme = linearLayout;
        this.flDescriptionWrap = frameLayout4;
        this.footerContainer = frameLayout5;
        this.groupAssetInfo = linearLayout2;
        this.heroRow = linearLayout3;
        this.iconPlaceholder = frameLayout6;
        this.ivBack = imageView;
        this.ivSkillIcon = imageView2;
        this.ivTopUninstall = imageView3;
        this.llAuthorRow = linearLayout4;
        this.llDescriptionToggle = linearLayout5;
        this.llUpdateBanner = linearLayout6;
        this.pbBottomUpdate = indeterminateSpinnerView;
        this.pbTopUninstall = indeterminateSpinnerView2;
        this.root = frameLayout7;
        this.rowCategory = c10;
        this.rowCreated = c11;
        this.rowDownload = c12;
        this.rowUpdated = c13;
        this.rowVersion = c14;
        this.scrollView = scrollView;
        this.toolbar = linearLayout7;
        this.tvDescription = textView3;
        this.tvDescriptionToggle = textView4;
        this.tvMeta = textView5;
        this.tvReadme = textView6;
        this.tvReadmeSectionTitle = textView7;
        this.tvSkillIconChar = textView8;
        this.tvThirdPartyTag = textView9;
        this.tvTitle = textView10;
        this.tvUpdateBannerChangelog = textView11;
        this.tvUpdateBannerSize = textView12;
        this.tvUpdateBannerTitle = textView13;
        this.vBottomBlur = view;
        this.vDescriptionFade = view2;
        this.vTopFade = view3;
    }

    public static C1125i a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i10 = R$id.action_area;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.btn_bottom_update;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R$id.btn_readme_view_full;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.btn_top_uninstall;
                    FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                    if (frameLayout2 != null) {
                        i10 = R$id.card_readme;
                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R$id.fl_description_wrap;
                            FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout3 != null) {
                                i10 = R$id.footer_container;
                                FrameLayout frameLayout4 = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout4 != null) {
                                    i10 = R$id.group_asset_info;
                                    LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout2 != null) {
                                        i10 = R$id.hero_row;
                                        LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout3 != null) {
                                            i10 = R$id.icon_placeholder;
                                            FrameLayout frameLayout5 = (FrameLayout) C5437a.a(view, i10);
                                            if (frameLayout5 != null) {
                                                i10 = R$id.iv_back;
                                                ImageView imageView = (ImageView) C5437a.a(view, i10);
                                                if (imageView != null) {
                                                    i10 = R$id.iv_skill_icon;
                                                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                                    if (imageView2 != null) {
                                                        i10 = R$id.iv_top_uninstall;
                                                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                        if (imageView3 != null) {
                                                            i10 = R$id.ll_author_row;
                                                            LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                                            if (linearLayout4 != null) {
                                                                i10 = R$id.ll_description_toggle;
                                                                LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                                if (linearLayout5 != null) {
                                                                    i10 = R$id.ll_update_banner;
                                                                    LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                                    if (linearLayout6 != null) {
                                                                        i10 = R$id.pb_bottom_update;
                                                                        IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                        if (indeterminateSpinnerView != null) {
                                                                            i10 = R$id.pb_top_uninstall;
                                                                            IndeterminateSpinnerView indeterminateSpinnerView2 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                            if (indeterminateSpinnerView2 != null) {
                                                                                FrameLayout frameLayout6 = (FrameLayout) view;
                                                                                i10 = R$id.row_category;
                                                                                View viewA4 = C5437a.a(view, i10);
                                                                                if (viewA4 != null) {
                                                                                    C cA = C.a(viewA4);
                                                                                    i10 = R$id.row_created;
                                                                                    View viewA5 = C5437a.a(view, i10);
                                                                                    if (viewA5 != null) {
                                                                                        C cA2 = C.a(viewA5);
                                                                                        i10 = R$id.row_download;
                                                                                        View viewA6 = C5437a.a(view, i10);
                                                                                        if (viewA6 != null) {
                                                                                            C cA3 = C.a(viewA6);
                                                                                            i10 = R$id.row_updated;
                                                                                            View viewA7 = C5437a.a(view, i10);
                                                                                            if (viewA7 != null) {
                                                                                                C cA4 = C.a(viewA7);
                                                                                                i10 = R$id.row_version;
                                                                                                View viewA8 = C5437a.a(view, i10);
                                                                                                if (viewA8 != null) {
                                                                                                    C cA5 = C.a(viewA8);
                                                                                                    i10 = R$id.scroll_view;
                                                                                                    ScrollView scrollView = (ScrollView) C5437a.a(view, i10);
                                                                                                    if (scrollView != null) {
                                                                                                        i10 = R$id.toolbar;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i10 = R$id.tv_description;
                                                                                                            TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                                                            if (textView3 != null) {
                                                                                                                i10 = R$id.tv_description_toggle;
                                                                                                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                                                if (textView4 != null) {
                                                                                                                    i10 = R$id.tv_meta;
                                                                                                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i10 = R$id.tv_readme;
                                                                                                                        TextView textView6 = (TextView) C5437a.a(view, i10);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i10 = R$id.tv_readme_section_title;
                                                                                                                            TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i10 = R$id.tv_skill_icon_char;
                                                                                                                                TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i10 = R$id.tv_third_party_tag;
                                                                                                                                    TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        i10 = R$id.tv_title;
                                                                                                                                        TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                                                                        if (textView10 != null) {
                                                                                                                                            i10 = R$id.tv_update_banner_changelog;
                                                                                                                                            TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                                                            if (textView11 != null) {
                                                                                                                                                i10 = R$id.tv_update_banner_size;
                                                                                                                                                TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                                                                if (textView12 != null) {
                                                                                                                                                    i10 = R$id.tv_update_banner_title;
                                                                                                                                                    TextView textView13 = (TextView) C5437a.a(view, i10);
                                                                                                                                                    if (textView13 != null && (viewA = C5437a.a(view, (i10 = R$id.v_bottom_blur))) != null && (viewA2 = C5437a.a(view, (i10 = R$id.v_description_fade))) != null && (viewA3 = C5437a.a(view, (i10 = R$id.v_top_fade))) != null) {
                                                                                                                                                        return new C1125i(frameLayout6, frameLayout, textView, textView2, frameLayout2, linearLayout, frameLayout3, frameLayout4, linearLayout2, linearLayout3, frameLayout5, imageView, imageView2, imageView3, linearLayout4, linearLayout5, linearLayout6, indeterminateSpinnerView, indeterminateSpinnerView2, frameLayout6, cA, cA2, cA3, cA4, cA5, scrollView, linearLayout7, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, viewA, viewA2, viewA3);
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

    public static C1125i b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static C1125i c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_skill_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
