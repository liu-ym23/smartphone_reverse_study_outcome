package com.bytedance.android.live.broadcastgame.opengame.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/test/GroupDataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/opengame/test/GroupDataViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupDataAdapter extends RecyclerView.Adapter<GroupDataViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.broadcastgame.opengame.test.a> f61091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f61092b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f61091a.size();
    }

    public GroupDataAdapter(List<com.bytedance.android.live.broadcastgame.opengame.test.a> r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f61091a = r100;
        this.f61092b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        GroupDataViewHolder r102 = (GroupDataViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.f61094b.removeAllViews();
        UtilityKotlinExtentionsKt.z(r102.f61093a, false);
        Iterator<String> r103 = ((com.bytedance.android.live.broadcastgame.opengame.test.a) ListProtector.get(this.f61091a, r101)).f61101b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        TextView r105 = new TextView(this.f61092b);
        r105.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r105.setAlpha(0.8f);
        r105.setTextSize(1, 12.0f);
        r105.setText(r104);
        r102.f61094b.addView(r105);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new GroupDataViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_open_platform_debug_performance_data_item, r100, false));
    }
}
