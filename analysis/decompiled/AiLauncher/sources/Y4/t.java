package Y4;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.agent.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class t {
    public final LinearLayout emptyView;
    public final EditText etSearch;
    public final View indicatorCli;
    public final View indicatorSkills;
    public final ImageView ivBack;
    public final ImageView ivClear;
    public final ImageView ivSearchClearInline;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final RecyclerView rvInstalled;
    public final NestedScrollView scrollInstalled;
    public final LinearLayout tabCli;
    public final LinearLayout tabSkill;
    public final TextView tvEmptyMain;
    public final TextView tvEmptySub;
    public final TextView tvTabCli;
    public final TextView tvTabSkills;
    public final TextView tvTitle;

    public t(LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, View view, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout3, RecyclerView recyclerView, NestedScrollView nestedScrollView, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.emptyView = linearLayout2;
        this.etSearch = editText;
        this.indicatorCli = view;
        this.indicatorSkills = view2;
        this.ivBack = imageView;
        this.ivClear = imageView2;
        this.ivSearchClearInline = imageView3;
        this.root = linearLayout3;
        this.rvInstalled = recyclerView;
        this.scrollInstalled = nestedScrollView;
        this.tabCli = linearLayout4;
        this.tabSkill = linearLayout5;
        this.tvEmptyMain = textView;
        this.tvEmptySub = textView2;
        this.tvTabCli = textView3;
        this.tvTabSkills = textView4;
        this.tvTitle = textView5;
    }

    public static t a(View view) {
        View viewA;
        View viewA2;
        int i10 = R$id.empty_view;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.et_search;
            EditText editText = (EditText) C5437a.a(view, i10);
            if (editText != null && (viewA = C5437a.a(view, (i10 = R$id.indicator_cli))) != null && (viewA2 = C5437a.a(view, (i10 = R$id.indicator_skills))) != null) {
                i10 = R$id.iv_back;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.iv_clear;
                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R$id.iv_search_clear_inline;
                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                        if (imageView3 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view;
                            i10 = R$id.rv_installed;
                            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                            if (recyclerView != null) {
                                i10 = R$id.scroll_installed;
                                NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                                if (nestedScrollView != null) {
                                    i10 = R$id.tab_cli;
                                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout3 != null) {
                                        i10 = R$id.tab_skill;
                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout4 != null) {
                                            i10 = R$id.tv_empty_main;
                                            TextView textView = (TextView) C5437a.a(view, i10);
                                            if (textView != null) {
                                                i10 = R$id.tv_empty_sub;
                                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                                if (textView2 != null) {
                                                    i10 = R$id.tv_tab_cli;
                                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                                    if (textView3 != null) {
                                                        i10 = R$id.tv_tab_skills;
                                                        TextView textView4 = (TextView) C5437a.a(view, i10);
                                                        if (textView4 != null) {
                                                            i10 = R$id.tv_title;
                                                            TextView textView5 = (TextView) C5437a.a(view, i10);
                                                            if (textView5 != null) {
                                                                return new t(linearLayout2, linearLayout, editText, viewA, viewA2, imageView, imageView2, imageView3, linearLayout2, recyclerView, nestedScrollView, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5);
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
