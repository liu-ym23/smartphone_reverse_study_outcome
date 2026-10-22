package B4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class a {
    public final ImageView ivToolExpand;
    public final LinearLayout llMcpTitle;
    private final LinearLayout rootView;
    public final LinearLayout toolDetailLayout;
    public final TextView toolParams;
    public final TextView toolParamsTitle;
    public final TextView toolResult;
    public final TextView toolResultTitle;
    public final TextView tvMcpTitle;

    public a(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.ivToolExpand = imageView;
        this.llMcpTitle = linearLayout2;
        this.toolDetailLayout = linearLayout3;
        this.toolParams = textView;
        this.toolParamsTitle = textView2;
        this.toolResult = textView3;
        this.toolResultTitle = textView4;
        this.tvMcpTitle = textView5;
    }

    public static a a(View view) {
        int i10 = R$id.iv_tool_expand;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.ll_mcp_title;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.tool_detail_layout;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.tool_params;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.tool_params_title;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tool_result;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tool_result_title;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    i10 = R$id.tv_mcp_title;
                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                    if (textView5 != null) {
                                        return new a((LinearLayout) view, imageView, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5);
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

    public static a b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_message_tool_execute, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
