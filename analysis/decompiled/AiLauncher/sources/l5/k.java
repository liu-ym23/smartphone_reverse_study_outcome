package l5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class k {
    public final ImageView btnSessionSearchBack;
    public final ImageView btnSessionSearchClear;
    public final ImageView btnSessionSearchClose;
    public final LinearLayout emptySessionSearch;
    public final EditText etSessionSearch;
    public final ImageView ivSessionSearch;
    public final LinearLayout llSessionSearchBottomBar;
    public final LinearLayout llSessionSearchRoot;
    private final LinearLayout rootView;
    public final RecyclerView rvSessionSearch;
    public final LinearLayout sessionSearchContent;
    public final TextView tvSessionSearchEmpty;
    public final TextView tvSessionSearchTitle;

    public k(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, EditText editText, ImageView imageView4, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, LinearLayout linearLayout5, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnSessionSearchBack = imageView;
        this.btnSessionSearchClear = imageView2;
        this.btnSessionSearchClose = imageView3;
        this.emptySessionSearch = linearLayout2;
        this.etSessionSearch = editText;
        this.ivSessionSearch = imageView4;
        this.llSessionSearchBottomBar = linearLayout3;
        this.llSessionSearchRoot = linearLayout4;
        this.rvSessionSearch = recyclerView;
        this.sessionSearchContent = linearLayout5;
        this.tvSessionSearchEmpty = textView;
        this.tvSessionSearchTitle = textView2;
    }

    public static k a(View view) {
        int i10 = R$id.btn_session_search_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btn_session_search_clear;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.btn_session_search_close;
                ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                if (imageView3 != null) {
                    i10 = R$id.empty_session_search;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R$id.et_session_search;
                        EditText editText = (EditText) C5437a.a(view, i10);
                        if (editText != null) {
                            i10 = R$id.iv_session_search;
                            ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                            if (imageView4 != null) {
                                i10 = R$id.ll_session_search_bottom_bar;
                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) view;
                                    i10 = R$id.rv_session_search;
                                    RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                    if (recyclerView != null) {
                                        i10 = R$id.session_search_content;
                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout4 != null) {
                                            i10 = R$id.tv_session_search_empty;
                                            TextView textView = (TextView) C5437a.a(view, i10);
                                            if (textView != null) {
                                                i10 = R$id.tv_session_search_title;
                                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                                if (textView2 != null) {
                                                    return new k(linearLayout3, imageView, imageView2, imageView3, linearLayout, editText, imageView4, linearLayout2, linearLayout3, recyclerView, linearLayout4, textView, textView2);
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

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_session_search, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
