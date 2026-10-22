package r6;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.task.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class i {
    public final NestedScrollView agentContent;
    public final NestedScrollView appContent;
    public final ImageView btnBack;
    public final LinearLayout emptyState;
    public final LinearLayout guideCardAgent;
    public final LinearLayout guideCardSkill;
    public final ImageView ivLoadingAgent;
    public final ImageView ivLoadingApp;
    public final ImageView ivLoadingSkill;
    public final LinearLayout loadingAgent;
    public final LinearLayout loadingApp;
    public final LinearLayout loadingSkill;
    private final FrameLayout rootView;
    public final RecyclerView rvAgents;
    public final RecyclerView rvApps;
    public final RecyclerView rvSkills;
    public final NestedScrollView skillContent;
    public final TextView tabAgent;
    public final TextView tabApp;
    public final FrameLayout tabBar;
    public final View tabIndicator;
    public final TextView tabSkill;
    public final View topChromeBlur;
    public final TextView tvTitle;

    public i(FrameLayout frameLayout, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, NestedScrollView nestedScrollView3, TextView textView, TextView textView2, FrameLayout frameLayout2, View view, TextView textView3, View view2, TextView textView4) {
        this.rootView = frameLayout;
        this.agentContent = nestedScrollView;
        this.appContent = nestedScrollView2;
        this.btnBack = imageView;
        this.emptyState = linearLayout;
        this.guideCardAgent = linearLayout2;
        this.guideCardSkill = linearLayout3;
        this.ivLoadingAgent = imageView2;
        this.ivLoadingApp = imageView3;
        this.ivLoadingSkill = imageView4;
        this.loadingAgent = linearLayout4;
        this.loadingApp = linearLayout5;
        this.loadingSkill = linearLayout6;
        this.rvAgents = recyclerView;
        this.rvApps = recyclerView2;
        this.rvSkills = recyclerView3;
        this.skillContent = nestedScrollView3;
        this.tabAgent = textView;
        this.tabApp = textView2;
        this.tabBar = frameLayout2;
        this.tabIndicator = view;
        this.tabSkill = textView3;
        this.topChromeBlur = view2;
        this.tvTitle = textView4;
    }

    public static i a(View view) {
        View viewA;
        View viewA2;
        int i10 = R$id.agentContent;
        NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
        if (nestedScrollView != null) {
            i10 = R$id.appContent;
            NestedScrollView nestedScrollView2 = (NestedScrollView) C5437a.a(view, i10);
            if (nestedScrollView2 != null) {
                i10 = R$id.btnBack;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.emptyState;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R$id.guideCardAgent;
                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R$id.guideCardSkill;
                            LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout3 != null) {
                                i10 = R$id.ivLoadingAgent;
                                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                if (imageView2 != null) {
                                    i10 = R$id.ivLoadingApp;
                                    ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                    if (imageView3 != null) {
                                        i10 = R$id.ivLoadingSkill;
                                        ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                        if (imageView4 != null) {
                                            i10 = R$id.loadingAgent;
                                            LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout4 != null) {
                                                i10 = R$id.loadingApp;
                                                LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout5 != null) {
                                                    i10 = R$id.loadingSkill;
                                                    LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout6 != null) {
                                                        i10 = R$id.rvAgents;
                                                        RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                                        if (recyclerView != null) {
                                                            i10 = R$id.rvApps;
                                                            RecyclerView recyclerView2 = (RecyclerView) C5437a.a(view, i10);
                                                            if (recyclerView2 != null) {
                                                                i10 = R$id.rvSkills;
                                                                RecyclerView recyclerView3 = (RecyclerView) C5437a.a(view, i10);
                                                                if (recyclerView3 != null) {
                                                                    i10 = R$id.skillContent;
                                                                    NestedScrollView nestedScrollView3 = (NestedScrollView) C5437a.a(view, i10);
                                                                    if (nestedScrollView3 != null) {
                                                                        i10 = R$id.tabAgent;
                                                                        TextView textView = (TextView) C5437a.a(view, i10);
                                                                        if (textView != null) {
                                                                            i10 = R$id.tabApp;
                                                                            TextView textView2 = (TextView) C5437a.a(view, i10);
                                                                            if (textView2 != null) {
                                                                                i10 = R$id.tabBar;
                                                                                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                                                                                if (frameLayout != null && (viewA = C5437a.a(view, (i10 = R$id.tabIndicator))) != null) {
                                                                                    i10 = R$id.tabSkill;
                                                                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                                    if (textView3 != null && (viewA2 = C5437a.a(view, (i10 = R$id.topChromeBlur))) != null) {
                                                                                        i10 = R$id.tvTitle;
                                                                                        TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                        if (textView4 != null) {
                                                                                            return new i((FrameLayout) view, nestedScrollView, nestedScrollView2, imageView, linearLayout, linearLayout2, linearLayout3, imageView2, imageView3, imageView4, linearLayout4, linearLayout5, linearLayout6, recyclerView, recyclerView2, recyclerView3, nestedScrollView3, textView, textView2, frameLayout, viewA, textView3, viewA2, textView4);
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
