package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0004\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "TargetViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineTargetAdapterV2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f79703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f79704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f79705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f79706d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineTargetAdapterV2$TargetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class TargetViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f79707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f79708b;

        public TargetViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f79707a = (TextView) r100.findViewById(R.id.tv_duration);
            this.f79708b = (ViewGroup) r100.findViewById(R.id.item_container);
        }
    }

    public interface a {
        void k0(String r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<String> r100 = this.f79704b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final Context getContext() {
        return this.f79703a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        if ((r100 instanceof TargetViewHolder) == false) goto L16;
        TargetViewHolder r102 = (TargetViewHolder) r100;
        TextView r103 = r102.f79707a;
        List<String> r104 = this.f79704b;
        if (r104 == null) goto L7;
        String r105 = (String) CollectionsKt.getOrNull(r104, r101);
    L8:
        r103.setText(r105);
        if (r102.f79707a.getText() != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        r102.f79707a.setSelected(r106);
        r102.f79708b.setSelected(r106);
        r102.f79708b.setOnClickListener(x0.a(new AnonymousClass1(this, r100)));
        return;
    L11:
        if (Intrinsics.areEqual(r102.f79707a.getText().toString(), this.f79705c) == false) goto L13;
        r106 = true;
        goto L14
    L7:
        r105 = null;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new TargetViewHolder(LayoutInflater.from(this.f79703a).inflate(R.layout.ttlive_item_self_discipline_target_v2, r100, false));
    }

    public SelfDisciplineTargetAdapterV2(Context r100, List<String> r101, String r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f79703a = r100;
        this.f79704b = r101;
        this.f79705c = r102;
        this.f79706d = r103;
    }
}
