package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* renamed from: T5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1019c {
    public final TextView btnAlipayPrimary;
    public final TextView btnAlipaySecondary;
    public final TextView btnAlipaySingleCta;
    public final ImageView ivAlipayAuthIcon;
    public final ImageView ivAlipayChannelLogo;
    public final LinearLayout llAlipayAuthHeader;
    public final LinearLayout llAlipayButtons;
    public final LinearLayout llAlipayShell;
    public final LinearLayout llAlipayStoreHeader;
    private final FrameLayout rootView;
    public final ViewStub stubAlipayAppStore;
    public final TextView tvAlipayAuthSubtitle;
    public final TextView tvAlipayAuthTitle;
    public final TextView tvAlipayStoreName;
    public final View vAlipayDimScrim;

    public C1019c(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ViewStub viewStub, TextView textView4, TextView textView5, TextView textView6, View view) {
        this.rootView = frameLayout;
        this.btnAlipayPrimary = textView;
        this.btnAlipaySecondary = textView2;
        this.btnAlipaySingleCta = textView3;
        this.ivAlipayAuthIcon = imageView;
        this.ivAlipayChannelLogo = imageView2;
        this.llAlipayAuthHeader = linearLayout;
        this.llAlipayButtons = linearLayout2;
        this.llAlipayShell = linearLayout3;
        this.llAlipayStoreHeader = linearLayout4;
        this.stubAlipayAppStore = viewStub;
        this.tvAlipayAuthSubtitle = textView4;
        this.tvAlipayAuthTitle = textView5;
        this.tvAlipayStoreName = textView6;
        this.vAlipayDimScrim = view;
    }

    public static C1019c a(View view) {
        View viewA;
        int i10 = R$id.btnAlipayPrimary;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.btnAlipaySecondary;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.btnAlipaySingleCta;
                TextView textView3 = (TextView) C5437a.a(view, i10);
                if (textView3 != null) {
                    i10 = R$id.ivAlipayAuthIcon;
                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                    if (imageView != null) {
                        i10 = R$id.ivAlipayChannelLogo;
                        ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                        if (imageView2 != null) {
                            i10 = R$id.llAlipayAuthHeader;
                            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout != null) {
                                i10 = R$id.llAlipayButtons;
                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R$id.llAlipayShell;
                                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout3 != null) {
                                        i10 = R$id.llAlipayStoreHeader;
                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout4 != null) {
                                            i10 = R$id.stubAlipayAppStore;
                                            ViewStub viewStub = (ViewStub) C5437a.a(view, i10);
                                            if (viewStub != null) {
                                                i10 = R$id.tvAlipayAuthSubtitle;
                                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                                if (textView4 != null) {
                                                    i10 = R$id.tvAlipayAuthTitle;
                                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                                    if (textView5 != null) {
                                                        i10 = R$id.tvAlipayStoreName;
                                                        TextView textView6 = (TextView) C5437a.a(view, i10);
                                                        if (textView6 != null && (viewA = C5437a.a(view, (i10 = R$id.vAlipayDimScrim))) != null) {
                                                            return new C1019c((FrameLayout) view, textView, textView2, textView3, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, viewStub, textView4, textView5, textView6, viewA);
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

    public static C1019c b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_alipay_xui, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
