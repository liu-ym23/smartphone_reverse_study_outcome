package l5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.view.ViewportFadeRecyclerView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class j {
    public final ImageView btnSessionCenterClose;
    public final ImageView btnSessionCenterNewChat;
    public final LinearLayout btnSessionCenterSearch;
    public final ImageView btnSessionCenterSettings;
    public final LinearLayout btnSessionCenterStore;
    public final FrameLayout flSessionCenterList;
    public final FrameLayout flSessionCenterSearchHost;
    public final ImageView ivSessionCenterStoreBadge;
    public final LinearLayout llBottomContainer;
    public final LinearLayout llTopContainer;
    private final ConstraintLayout rootView;
    public final ViewportFadeRecyclerView rvSessionCenter;

    public j(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, LinearLayout linearLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView4, LinearLayout linearLayout3, LinearLayout linearLayout4, ViewportFadeRecyclerView viewportFadeRecyclerView) {
        this.rootView = constraintLayout;
        this.btnSessionCenterClose = imageView;
        this.btnSessionCenterNewChat = imageView2;
        this.btnSessionCenterSearch = linearLayout;
        this.btnSessionCenterSettings = imageView3;
        this.btnSessionCenterStore = linearLayout2;
        this.flSessionCenterList = frameLayout;
        this.flSessionCenterSearchHost = frameLayout2;
        this.ivSessionCenterStoreBadge = imageView4;
        this.llBottomContainer = linearLayout3;
        this.llTopContainer = linearLayout4;
        this.rvSessionCenter = viewportFadeRecyclerView;
    }

    public static j a(View view) {
        int i10 = R$id.btn_session_center_close;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btn_session_center_new_chat;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.btn_session_center_search;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.btn_session_center_settings;
                    ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                    if (imageView3 != null) {
                        i10 = R$id.btn_session_center_store;
                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R$id.fl_session_center_list;
                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout != null) {
                                i10 = R$id.fl_session_center_search_host;
                                FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout2 != null) {
                                    i10 = R$id.iv_session_center_store_badge;
                                    ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                    if (imageView4 != null) {
                                        i10 = R$id.llBottomContainer;
                                        LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout3 != null) {
                                            i10 = R$id.llTopContainer;
                                            LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout4 != null) {
                                                i10 = R$id.rv_session_center;
                                                ViewportFadeRecyclerView viewportFadeRecyclerView = (ViewportFadeRecyclerView) C5437a.a(view, i10);
                                                if (viewportFadeRecyclerView != null) {
                                                    return new j((ConstraintLayout) view, imageView, imageView2, linearLayout, imageView3, linearLayout2, frameLayout, frameLayout2, imageView4, linearLayout3, linearLayout4, viewportFadeRecyclerView);
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

    public static j b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_session_center, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
