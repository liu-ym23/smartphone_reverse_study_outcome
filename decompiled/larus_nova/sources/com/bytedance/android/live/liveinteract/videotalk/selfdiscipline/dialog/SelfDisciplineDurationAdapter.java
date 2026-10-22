package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineDurationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineDurationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f79671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f79672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79673c;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79672b.size() + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        int r101 = this.f79672b.size();
        if (1 > r100) goto L9;
        if (r101 < r100) goto L9;
        return 1;
    L9:
        return 2;
    }

    public SelfDisciplineDurationAdapter(List<Integer> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "durationList");
        this.f79672b = r100;
        this.f79673c = r101;
        this.f79671a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof DurationViewHolder) == false) goto L13;
        DurationViewHolder r102 = (DurationViewHolder) r100;
        int r103 = r101 - 1;
        int r104 = ((Number) ListProtector.get(this.f79672b, r103)).intValue();
        r102.f79670b = r104;
        r102.f79669a.setText(com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.a.a(r104));
        r102.f79669a.setTextColor(ColorProtector.parseColor("#80161823"));
        if (this.f79671a == true) goto L7;
        return;
    L7:
        if (((Number) ListProtector.get(this.f79672b, r103)).intValue() != this.f79673c) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L15;
        r102.T3(true);
        this.f79671a = false;
        return;
    L15:
        return;
    L9:
        r105 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L5;
        View r102 = new View(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(48.0f)));
        return new EmptyViewHolder(r102);
    L5:
        if (r101 == 1) goto L11;
        View r103 = new View(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(81.0f)));
        return new EmptyViewHolder(r103);
    L11:
        return new DurationViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_guest_battle_time, r100, false));
    }
}
