package com.bytedance.android.live.broadcastgame.xplay.perf;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/perf/GroupDataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/xplay/perf/GroupDataViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupDataAdapter extends RecyclerView.Adapter<GroupDataViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f62309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f62310b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f62309a.size();
    }

    public GroupDataAdapter(List<String> r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f62309a = r100;
        this.f62310b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        GroupDataViewHolder r102 = (GroupDataViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ListProtector.get(this.f62309a, r101);
        TextView r104 = r102.f62311a;
        r104.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r104.setAlpha(0.8f);
        r104.setTextSize(1, 12.0f);
        r104.setText(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new GroupDataViewHolder(new TextView(this.f62310b));
    }
}
