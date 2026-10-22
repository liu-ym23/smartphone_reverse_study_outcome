package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;
import com.stepos.common.widget.EmptyView;
import com.stepos.common.widget.ImageFontCompatView;
import com.stepos.common.widget.SearchEditText;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public final class ActivityAddressMainBinding {

    @NonNull
    public final NestedScrollView actionBarContainer;

    @NonNull
    public final LinearLayout addressContentLayout;

    @NonNull
    public final TextView addressTitle;

    @NonNull
    public final Button btLocation;

    @NonNull
    public final TextView cancel;

    @NonNull
    public final RelativeLayout loadingViewLayout;

    @NonNull
    public final LinearLayout mainAddressLayout;

    @NonNull
    public final StepOSRecyclerView mainAddressListview;

    @NonNull
    public final EmptyView mainEmptyView;

    @NonNull
    public final FrameLayout mapView;

    @NonNull
    public final CardView mapViewLayout;

    @NonNull
    public final ImageView mcInputClear;

    @NonNull
    public final SearchEditText mcSearchEdit;

    @NonNull
    public final ImageFontCompatView mcSearchIcon;

    @NonNull
    public final RelativeLayout mcSearchLayout;

    @NonNull
    public final ImageFontCompatView mcVoiceIcon;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final TextView save;

    @NonNull
    public final FrameLayout searchAddressLayout;

    @NonNull
    public final StepOSRecyclerView searchAddressListview;

    @NonNull
    public final EmptyView searchEmptyView;

    @NonNull
    public final Toolbar titleBar;

    @NonNull
    public final TextView toolbarTitle;

    private ActivityAddressMainBinding(@NonNull LinearLayout linearLayout, @NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull Button button, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout3, @NonNull StepOSRecyclerView stepOSRecyclerView, @NonNull EmptyView emptyView, @NonNull FrameLayout frameLayout, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull SearchEditText searchEditText, @NonNull ImageFontCompatView imageFontCompatView, @NonNull RelativeLayout relativeLayout2, @NonNull ImageFontCompatView imageFontCompatView2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout2, @NonNull StepOSRecyclerView stepOSRecyclerView2, @NonNull EmptyView emptyView2, @NonNull Toolbar toolbar, @NonNull TextView textView4) {
        this.rootView = linearLayout;
        this.actionBarContainer = nestedScrollView;
        this.addressContentLayout = linearLayout2;
        this.addressTitle = textView;
        this.btLocation = button;
        this.cancel = textView2;
        this.loadingViewLayout = relativeLayout;
        this.mainAddressLayout = linearLayout3;
        this.mainAddressListview = stepOSRecyclerView;
        this.mainEmptyView = emptyView;
        this.mapView = frameLayout;
        this.mapViewLayout = cardView;
        this.mcInputClear = imageView;
        this.mcSearchEdit = searchEditText;
        this.mcSearchIcon = imageFontCompatView;
        this.mcSearchLayout = relativeLayout2;
        this.mcVoiceIcon = imageFontCompatView2;
        this.save = textView3;
        this.searchAddressLayout = frameLayout2;
        this.searchAddressListview = stepOSRecyclerView2;
        this.searchEmptyView = emptyView2;
        this.titleBar = toolbar;
        this.toolbarTitle = textView4;
    }

    @NonNull
    public static ActivityAddressMainBinding bind(@NonNull View view) {
        int i4 = R.id.action_bar_container;
        NestedScrollView nestedScrollView = (NestedScrollView) h.n(i4, view);
        if (nestedScrollView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i4 = R.id.address_title;
            TextView textView = (TextView) h.n(i4, view);
            if (textView != null) {
                i4 = R.id.bt_location;
                Button button = (Button) h.n(i4, view);
                if (button != null) {
                    i4 = R.id.cancel;
                    TextView textView2 = (TextView) h.n(i4, view);
                    if (textView2 != null) {
                        i4 = R.id.loadingViewLayout;
                        RelativeLayout relativeLayout = (RelativeLayout) h.n(i4, view);
                        if (relativeLayout != null) {
                            i4 = R.id.main_address_layout;
                            LinearLayout linearLayout2 = (LinearLayout) h.n(i4, view);
                            if (linearLayout2 != null) {
                                i4 = R.id.main_address_listview;
                                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) h.n(i4, view);
                                if (stepOSRecyclerView != null) {
                                    i4 = R.id.main_emptyView;
                                    EmptyView emptyView = (EmptyView) h.n(i4, view);
                                    if (emptyView != null) {
                                        i4 = R.id.map_view;
                                        FrameLayout frameLayout = (FrameLayout) h.n(i4, view);
                                        if (frameLayout != null) {
                                            i4 = R.id.map_view_layout;
                                            CardView cardView = (CardView) h.n(i4, view);
                                            if (cardView != null) {
                                                i4 = R.id.mc_input_clear;
                                                ImageView imageView = (ImageView) h.n(i4, view);
                                                if (imageView != null) {
                                                    i4 = R.id.mc_search_edit;
                                                    SearchEditText searchEditText = (SearchEditText) h.n(i4, view);
                                                    if (searchEditText != null) {
                                                        i4 = R.id.mc_search_icon;
                                                        ImageFontCompatView imageFontCompatView = (ImageFontCompatView) h.n(i4, view);
                                                        if (imageFontCompatView != null) {
                                                            i4 = R.id.mc_search_layout;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) h.n(i4, view);
                                                            if (relativeLayout2 != null) {
                                                                i4 = R.id.mc_voice_icon;
                                                                ImageFontCompatView imageFontCompatView2 = (ImageFontCompatView) h.n(i4, view);
                                                                if (imageFontCompatView2 != null) {
                                                                    i4 = R.id.save;
                                                                    TextView textView3 = (TextView) h.n(i4, view);
                                                                    if (textView3 != null) {
                                                                        i4 = R.id.search_address_layout;
                                                                        FrameLayout frameLayout2 = (FrameLayout) h.n(i4, view);
                                                                        if (frameLayout2 != null) {
                                                                            i4 = R.id.search_address_listview;
                                                                            StepOSRecyclerView stepOSRecyclerView2 = (StepOSRecyclerView) h.n(i4, view);
                                                                            if (stepOSRecyclerView2 != null) {
                                                                                i4 = R.id.search_emptyView;
                                                                                EmptyView emptyView2 = (EmptyView) h.n(i4, view);
                                                                                if (emptyView2 != null) {
                                                                                    i4 = R.id.title_bar;
                                                                                    Toolbar toolbar = (Toolbar) h.n(i4, view);
                                                                                    if (toolbar != null) {
                                                                                        i4 = R.id.toolbar_title;
                                                                                        TextView textView4 = (TextView) h.n(i4, view);
                                                                                        if (textView4 != null) {
                                                                                            return new ActivityAddressMainBinding(linearLayout, nestedScrollView, linearLayout, textView, button, textView2, relativeLayout, linearLayout2, stepOSRecyclerView, emptyView, frameLayout, cardView, imageView, searchEditText, imageFontCompatView, relativeLayout2, imageFontCompatView2, textView3, frameLayout2, stepOSRecyclerView2, emptyView2, toolbar, textView4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityAddressMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAddressMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_address_main, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
