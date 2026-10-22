package r6;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class j {
    public final ImageView btnBack;
    public final TextView btnRevoke;
    public final TextView btnSaveKey;
    public final ImageView ivAppIcon;
    public final LinearLayout layoutAuthNotices;
    public final LinearLayout layoutKeyFields;
    public final LinearLayout layoutKeySection;
    private final FrameLayout rootView;
    public final View topChromeBlur;
    public final TextView tvAppName;
    public final TextView tvAuthTime;
    public final TextView tvStatus;

    public j(FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.btnBack = imageView;
        this.btnRevoke = textView;
        this.btnSaveKey = textView2;
        this.ivAppIcon = imageView2;
        this.layoutAuthNotices = linearLayout;
        this.layoutKeyFields = linearLayout2;
        this.layoutKeySection = linearLayout3;
        this.topChromeBlur = view;
        this.tvAppName = textView3;
        this.tvAuthTime = textView4;
        this.tvStatus = textView5;
    }

    public static j a(View view) {
        View viewA;
        int i10 = R$id.btn_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btn_revoke;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R$id.btn_save_key;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.iv_app_icon;
                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R$id.layout_auth_notices;
                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R$id.layout_key_fields;
                            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R$id.layout_key_section;
                                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout3 != null && (viewA = C5437a.a(view, (i10 = R$id.topChromeBlur))) != null) {
                                    i10 = R$id.tv_app_name;
                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                    if (textView3 != null) {
                                        i10 = R$id.tv_auth_time;
                                        TextView textView4 = (TextView) C5437a.a(view, i10);
                                        if (textView4 != null) {
                                            i10 = R$id.tv_status;
                                            TextView textView5 = (TextView) C5437a.a(view, i10);
                                            if (textView5 != null) {
                                                return new j((FrameLayout) view, imageView, textView, textView2, imageView2, linearLayout, linearLayout2, linearLayout3, viewA, textView3, textView4, textView5);
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
