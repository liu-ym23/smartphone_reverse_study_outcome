package l5;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.view.ImeDismissFrameLayout;
import s1.C5437a;

/* renamed from: l5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4873b {
    public final ImageView btnSearchClear;
    public final ImageView btnSearchClose;
    public final EditText etSearch;
    private final ImeDismissFrameLayout rootView;
    public final RecyclerView rvSearchResults;
    public final LinearLayout searchBottomBar;
    public final FrameLayout searchContent;
    public final LinearLayout searchEmptyHint;
    public final LinearLayout searchHints;
    public final LinearLayout searchInitialHint;
    public final FrameLayout searchInputContainer;
    public final NestedScrollView searchResultScroll;
    public final ImeDismissFrameLayout searchRoot;
    public final FrameLayout searchTopBar;

    public C4873b(ImeDismissFrameLayout imeDismissFrameLayout, ImageView imageView, ImageView imageView2, EditText editText, RecyclerView recyclerView, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, FrameLayout frameLayout2, NestedScrollView nestedScrollView, ImeDismissFrameLayout imeDismissFrameLayout2, FrameLayout frameLayout3) {
        this.rootView = imeDismissFrameLayout;
        this.btnSearchClear = imageView;
        this.btnSearchClose = imageView2;
        this.etSearch = editText;
        this.rvSearchResults = recyclerView;
        this.searchBottomBar = linearLayout;
        this.searchContent = frameLayout;
        this.searchEmptyHint = linearLayout2;
        this.searchHints = linearLayout3;
        this.searchInitialHint = linearLayout4;
        this.searchInputContainer = frameLayout2;
        this.searchResultScroll = nestedScrollView;
        this.searchRoot = imeDismissFrameLayout2;
        this.searchTopBar = frameLayout3;
    }

    public static C4873b a(View view) {
        int i10 = R$id.btnSearchClear;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btnSearchClose;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.etSearch;
                EditText editText = (EditText) C5437a.a(view, i10);
                if (editText != null) {
                    i10 = R$id.rvSearchResults;
                    RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                    if (recyclerView != null) {
                        i10 = R$id.searchBottomBar;
                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R$id.searchContent;
                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout != null) {
                                i10 = R$id.searchEmptyHint;
                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R$id.searchHints;
                                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout3 != null) {
                                        i10 = R$id.searchInitialHint;
                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout4 != null) {
                                            i10 = R$id.searchInputContainer;
                                            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                                            if (frameLayout2 != null) {
                                                i10 = R$id.searchResultScroll;
                                                NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                                                if (nestedScrollView != null) {
                                                    ImeDismissFrameLayout imeDismissFrameLayout = (ImeDismissFrameLayout) view;
                                                    i10 = R$id.searchTopBar;
                                                    FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                                    if (frameLayout3 != null) {
                                                        return new C4873b(imeDismissFrameLayout, imageView, imageView2, editText, recyclerView, linearLayout, frameLayout, linearLayout2, linearLayout3, linearLayout4, frameLayout2, nestedScrollView, imeDismissFrameLayout, frameLayout3);
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
