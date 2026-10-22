package com.bytedance.android.shopping.anchorv3.comment.holders;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.abtest.SettingKeys;
import com.bytedance.commerce.base.json.b;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/holders/MeaninglessCommentShrinkExplainVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MeaninglessCommentShrinkExplainVH extends RecyclerView.ViewHolder {
    public MeaninglessCommentShrinkExplainVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        TextView r101 = (TextView) r100.findViewById(R.id.ec_why_shrink_comment_tv);
        TextView r102 = (TextView) r100.findViewById(R.id.ec_shrink_comment_explain_tv);
        JSONObject r103 = b.a(SettingKeys.getSHRINK_MEANINGLESS_COMMENT_EXPLAIN());
        r101.setText(JSONObjectProtectorUtils.getString(r103, "why"));
        r102.setText(JSONObjectProtectorUtils.getString(r103, "explain"));
    }
}
