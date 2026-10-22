package l5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class h {
    public final LinearLayout agentBottomBar;
    public final NestedScrollView agentContent;
    public final LinearLayout agentSearchContainer;
    public final LinearLayout appBottomBar;
    public final NestedScrollView appContent;
    public final LinearLayout appSearchContainer;
    public final ImageView btnInstalledAgents;
    public final ImageView btnInstalledApps;
    public final ImageView btnInstalledSkills;
    public final ImageView btnStoreClose;
    public final LinearLayout cardAiApps;
    public final LinearLayout cardCommunityWorks;
    public final LinearLayout cardMarket;
    public final LinearLayout cardMustHaves;
    public final LinearLayout cardOtherSkills;
    public final LinearLayout cellConnect;
    public final View dotInstalledSkillsUnread;
    public final LinearLayout emptyStateStore;
    public final FrameLayout flStoreSearchHost;
    public final LinearLayout headerCommunityWorks;
    public final LinearLayout headerMustHaves;
    public final TextView headerOtherSkills;
    private final FrameLayout rootView;
    public final RecyclerView rvAiApps;
    public final RecyclerView rvCommunityWorks;
    public final RecyclerView rvMarket;
    public final RecyclerView rvMustHaves;
    public final RecyclerView rvOtherSkills;
    public final LinearLayout skillBottomBar;
    public final NestedScrollView skillContent;
    public final LinearLayout skillSearchContainer;
    public final View storeBottomBlur;
    public final FrameLayout storeRoot;
    public final ConstraintLayout storeTopBar;
    public final View storeTopBlur;
    public final TextView tabAgent;
    public final TextView tabApp;
    public final FrameLayout tabBar;
    public final View tabIndicator;
    public final LinearLayout tabOptions;
    public final TextView tabSkill;

    public h(FrameLayout frameLayout, LinearLayout linearLayout, NestedScrollView nestedScrollView, LinearLayout linearLayout2, LinearLayout linearLayout3, NestedScrollView nestedScrollView2, LinearLayout linearLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, View view, LinearLayout linearLayout11, FrameLayout frameLayout2, LinearLayout linearLayout12, LinearLayout linearLayout13, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, RecyclerView recyclerView5, LinearLayout linearLayout14, NestedScrollView nestedScrollView3, LinearLayout linearLayout15, View view2, FrameLayout frameLayout3, ConstraintLayout constraintLayout, View view3, TextView textView2, TextView textView3, FrameLayout frameLayout4, View view4, LinearLayout linearLayout16, TextView textView4) {
        this.rootView = frameLayout;
        this.agentBottomBar = linearLayout;
        this.agentContent = nestedScrollView;
        this.agentSearchContainer = linearLayout2;
        this.appBottomBar = linearLayout3;
        this.appContent = nestedScrollView2;
        this.appSearchContainer = linearLayout4;
        this.btnInstalledAgents = imageView;
        this.btnInstalledApps = imageView2;
        this.btnInstalledSkills = imageView3;
        this.btnStoreClose = imageView4;
        this.cardAiApps = linearLayout5;
        this.cardCommunityWorks = linearLayout6;
        this.cardMarket = linearLayout7;
        this.cardMustHaves = linearLayout8;
        this.cardOtherSkills = linearLayout9;
        this.cellConnect = linearLayout10;
        this.dotInstalledSkillsUnread = view;
        this.emptyStateStore = linearLayout11;
        this.flStoreSearchHost = frameLayout2;
        this.headerCommunityWorks = linearLayout12;
        this.headerMustHaves = linearLayout13;
        this.headerOtherSkills = textView;
        this.rvAiApps = recyclerView;
        this.rvCommunityWorks = recyclerView2;
        this.rvMarket = recyclerView3;
        this.rvMustHaves = recyclerView4;
        this.rvOtherSkills = recyclerView5;
        this.skillBottomBar = linearLayout14;
        this.skillContent = nestedScrollView3;
        this.skillSearchContainer = linearLayout15;
        this.storeBottomBlur = view2;
        this.storeRoot = frameLayout3;
        this.storeTopBar = constraintLayout;
        this.storeTopBlur = view3;
        this.tabAgent = textView2;
        this.tabApp = textView3;
        this.tabBar = frameLayout4;
        this.tabIndicator = view4;
        this.tabOptions = linearLayout16;
        this.tabSkill = textView4;
    }

    public static h a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i10 = R$id.agentBottomBar;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.agentContent;
            NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
            if (nestedScrollView != null) {
                i10 = R$id.agentSearchContainer;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.appBottomBar;
                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R$id.appContent;
                        NestedScrollView nestedScrollView2 = (NestedScrollView) C5437a.a(view, i10);
                        if (nestedScrollView2 != null) {
                            i10 = R$id.appSearchContainer;
                            LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout4 != null) {
                                i10 = R$id.btnInstalledAgents;
                                ImageView imageView = (ImageView) C5437a.a(view, i10);
                                if (imageView != null) {
                                    i10 = R$id.btnInstalledApps;
                                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R$id.btnInstalledSkills;
                                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                        if (imageView3 != null) {
                                            i10 = R$id.btnStoreClose;
                                            ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                            if (imageView4 != null) {
                                                i10 = R$id.cardAiApps;
                                                LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout5 != null) {
                                                    i10 = R$id.cardCommunityWorks;
                                                    LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout6 != null) {
                                                        i10 = R$id.cardMarket;
                                                        LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                                        if (linearLayout7 != null) {
                                                            i10 = R$id.cardMustHaves;
                                                            LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                                            if (linearLayout8 != null) {
                                                                i10 = R$id.cardOtherSkills;
                                                                LinearLayout linearLayout9 = (LinearLayout) C5437a.a(view, i10);
                                                                if (linearLayout9 != null) {
                                                                    i10 = R$id.cellConnect;
                                                                    LinearLayout linearLayout10 = (LinearLayout) C5437a.a(view, i10);
                                                                    if (linearLayout10 != null && (viewA = C5437a.a(view, (i10 = R$id.dotInstalledSkillsUnread))) != null) {
                                                                        i10 = R$id.emptyStateStore;
                                                                        LinearLayout linearLayout11 = (LinearLayout) C5437a.a(view, i10);
                                                                        if (linearLayout11 != null) {
                                                                            i10 = R$id.fl_store_search_host;
                                                                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                                                                            if (frameLayout != null) {
                                                                                i10 = R$id.headerCommunityWorks;
                                                                                LinearLayout linearLayout12 = (LinearLayout) C5437a.a(view, i10);
                                                                                if (linearLayout12 != null) {
                                                                                    i10 = R$id.headerMustHaves;
                                                                                    LinearLayout linearLayout13 = (LinearLayout) C5437a.a(view, i10);
                                                                                    if (linearLayout13 != null) {
                                                                                        i10 = R$id.headerOtherSkills;
                                                                                        TextView textView = (TextView) C5437a.a(view, i10);
                                                                                        if (textView != null) {
                                                                                            i10 = R$id.rvAiApps;
                                                                                            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                                                                            if (recyclerView != null) {
                                                                                                i10 = R$id.rv_community_works;
                                                                                                RecyclerView recyclerView2 = (RecyclerView) C5437a.a(view, i10);
                                                                                                if (recyclerView2 != null) {
                                                                                                    i10 = R$id.rvMarket;
                                                                                                    RecyclerView recyclerView3 = (RecyclerView) C5437a.a(view, i10);
                                                                                                    if (recyclerView3 != null) {
                                                                                                        i10 = R$id.rv_must_haves;
                                                                                                        RecyclerView recyclerView4 = (RecyclerView) C5437a.a(view, i10);
                                                                                                        if (recyclerView4 != null) {
                                                                                                            i10 = R$id.rv_other_skills;
                                                                                                            RecyclerView recyclerView5 = (RecyclerView) C5437a.a(view, i10);
                                                                                                            if (recyclerView5 != null) {
                                                                                                                i10 = R$id.skillBottomBar;
                                                                                                                LinearLayout linearLayout14 = (LinearLayout) C5437a.a(view, i10);
                                                                                                                if (linearLayout14 != null) {
                                                                                                                    i10 = R$id.skillContent;
                                                                                                                    NestedScrollView nestedScrollView3 = (NestedScrollView) C5437a.a(view, i10);
                                                                                                                    if (nestedScrollView3 != null) {
                                                                                                                        i10 = R$id.skillSearchContainer;
                                                                                                                        LinearLayout linearLayout15 = (LinearLayout) C5437a.a(view, i10);
                                                                                                                        if (linearLayout15 != null && (viewA2 = C5437a.a(view, (i10 = R$id.storeBottomBlur))) != null) {
                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) view;
                                                                                                                            i10 = R$id.storeTopBar;
                                                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
                                                                                                                            if (constraintLayout != null && (viewA3 = C5437a.a(view, (i10 = R$id.storeTopBlur))) != null) {
                                                                                                                                i10 = R$id.tabAgent;
                                                                                                                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                                                                                                                if (textView2 != null) {
                                                                                                                                    i10 = R$id.tabApp;
                                                                                                                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                                                                                    if (textView3 != null) {
                                                                                                                                        i10 = R$id.tabBar;
                                                                                                                                        FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                                                                                                                        if (frameLayout3 != null && (viewA4 = C5437a.a(view, (i10 = R$id.tabIndicator))) != null) {
                                                                                                                                            i10 = R$id.tabOptions;
                                                                                                                                            LinearLayout linearLayout16 = (LinearLayout) C5437a.a(view, i10);
                                                                                                                                            if (linearLayout16 != null) {
                                                                                                                                                i10 = R$id.tabSkill;
                                                                                                                                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                                                                                if (textView4 != null) {
                                                                                                                                                    return new h(frameLayout2, linearLayout, nestedScrollView, linearLayout2, linearLayout3, nestedScrollView2, linearLayout4, imageView, imageView2, imageView3, imageView4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, viewA, linearLayout11, frameLayout, linearLayout12, linearLayout13, textView, recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5, linearLayout14, nestedScrollView3, linearLayout15, viewA2, frameLayout2, constraintLayout, viewA3, textView2, textView3, frameLayout3, viewA4, linearLayout16, textView4);
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
}
