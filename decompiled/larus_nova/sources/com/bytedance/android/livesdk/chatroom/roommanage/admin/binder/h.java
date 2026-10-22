package com.bytedance.android.livesdk.chatroom.roommanage.admin.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends me.drakeet.multitype.b<i, PromptViewHolder> {
    public h() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, i r101) {
        PromptViewHolder r102 = (PromptViewHolder) r100;
        i r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        if (r103.f111268b == false) goto L5;
        int r104 = R.color.ttlive_white_90;
    L6:
        int r105 = s1.h(r104);
        r102.f111256a.setTextColor(r105);
        r102.f111258c.setTextColor(r105);
        int r106 = Calendar.getInstance().getTimeZone().getRawOffset();
        r102.f111256a.setText(TimeUtils.formatLiveDuration((int) (((r103.f111267a.b() * 1000) + ((long) r106)) % 86400000)));
        UtilityKotlinExtentionsKt.z(r102.f111257b, r103.f111268b);
        r102.f111258c.setText(r103.f111267a.a());
        return;
    L5:
        r104 = R.color.ttlive_white_50;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PromptViewHolder(r100.inflate(R.layout.ttlive_item_prompt_msg, r101, false));
    }
}
