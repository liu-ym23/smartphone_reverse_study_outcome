package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class v {
    public final ImageButton btnMore;
    public final View dotStatus;
    public final LinearLayout itemRoot;
    public final ImageView ivAgentIcon;
    private final LinearLayout rootView;
    public final TextView tvDeviceDir;
    public final TextView tvDeviceName;

    public v(LinearLayout linearLayout, ImageButton imageButton, View view, LinearLayout linearLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnMore = imageButton;
        this.dotStatus = view;
        this.itemRoot = linearLayout2;
        this.ivAgentIcon = imageView;
        this.tvDeviceDir = textView;
        this.tvDeviceName = textView2;
    }

    public static v a(View view) {
        View viewA;
        int i10 = R$id.btn_more;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null && (viewA = C5437a.a(view, (i10 = R$id.dot_status))) != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R$id.iv_agent_icon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.tv_device_dir;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tv_device_name;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        return new v(linearLayout, imageButton, viewA, linearLayout, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static v c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_agent_connected_device, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
