package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class r {
    public final LinearLayout cardAutoFix;
    public final LinearLayout cardRestart;
    public final LinearLayout cardRestore;
    public final LinearLayout cardRevoke;
    public final LinearLayout cardThirdPartyAuth;
    public final View dividerTestSpace;
    public final ImageView ivAutoFix;
    public final ImageView ivRestart;
    public final ImageView ivRestore;
    public final LinearLayout layoutThirdParty;
    private final LinearLayout rootView;
    public final LinearLayout rowMemory;
    public final LinearLayout rowMyTasks;
    public final LinearLayout rowSafety;
    public final LinearLayout rowSubscription;
    public final LinearLayout rowTestSpace;

    public r(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12) {
        this.rootView = linearLayout;
        this.cardAutoFix = linearLayout2;
        this.cardRestart = linearLayout3;
        this.cardRestore = linearLayout4;
        this.cardRevoke = linearLayout5;
        this.cardThirdPartyAuth = linearLayout6;
        this.dividerTestSpace = view;
        this.ivAutoFix = imageView;
        this.ivRestart = imageView2;
        this.ivRestore = imageView3;
        this.layoutThirdParty = linearLayout7;
        this.rowMemory = linearLayout8;
        this.rowMyTasks = linearLayout9;
        this.rowSafety = linearLayout10;
        this.rowSubscription = linearLayout11;
        this.rowTestSpace = linearLayout12;
    }

    public static r a(View view) {
        View viewA;
        int i10 = R$id.card_auto_fix;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.card_restart;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.card_restore;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R$id.card_revoke;
                    LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout4 != null) {
                        i10 = R$id.card_third_party_auth;
                        LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout5 != null && (viewA = C5437a.a(view, (i10 = R$id.divider_test_space))) != null) {
                            i10 = R$id.iv_auto_fix;
                            ImageView imageView = (ImageView) C5437a.a(view, i10);
                            if (imageView != null) {
                                i10 = R$id.iv_restart;
                                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                if (imageView2 != null) {
                                    i10 = R$id.iv_restore;
                                    ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                    if (imageView3 != null) {
                                        i10 = R$id.layout_third_party;
                                        LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout6 != null) {
                                            i10 = R$id.row_memory;
                                            LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout7 != null) {
                                                i10 = R$id.row_my_tasks;
                                                LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout8 != null) {
                                                    i10 = R$id.row_safety;
                                                    LinearLayout linearLayout9 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout9 != null) {
                                                        i10 = R$id.row_subscription;
                                                        LinearLayout linearLayout10 = (LinearLayout) C5437a.a(view, i10);
                                                        if (linearLayout10 != null) {
                                                            i10 = R$id.row_test_space;
                                                            LinearLayout linearLayout11 = (LinearLayout) C5437a.a(view, i10);
                                                            if (linearLayout11 != null) {
                                                                return new r((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, viewA, imageView, imageView2, imageView3, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11);
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

    public static r b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_repair_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
