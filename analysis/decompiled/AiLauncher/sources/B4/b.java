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
public final class b {
    public final ImageView ivToolGroupExpand;
    public final LinearLayout llToolGroupCard;
    public final LinearLayout llToolGroupContainer;
    public final LinearLayout llToolGroupHeader;
    private final LinearLayout rootView;
    public final TextView tvToolGroupSeparator;
    public final TextView tvToolGroupSubtitle;
    public final TextView tvToolGroupTitle;

    public b(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.ivToolGroupExpand = imageView;
        this.llToolGroupCard = linearLayout2;
        this.llToolGroupContainer = linearLayout3;
        this.llToolGroupHeader = linearLayout4;
        this.tvToolGroupSeparator = textView;
        this.tvToolGroupSubtitle = textView2;
        this.tvToolGroupTitle = textView3;
    }

    public static b a(View view) {
        int i10 = R$id.iv_tool_group_expand;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.ll_tool_group_card;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.ll_tool_group_container;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.ll_tool_group_header;
                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R$id.tv_tool_group_separator;
                        TextView textView = (TextView) C5437a.a(view, i10);
                        if (textView != null) {
                            i10 = R$id.tv_tool_group_subtitle;
                            TextView textView2 = (TextView) C5437a.a(view, i10);
                            if (textView2 != null) {
                                i10 = R$id.tv_tool_group_title;
                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                if (textView3 != null) {
                                    return new b((LinearLayout) view, imageView, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_message_tool_execute_group, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
