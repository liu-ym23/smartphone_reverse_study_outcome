package com.bytedance.android.livesdk.livecommerce.multitype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import fh2.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BaseMultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ui2.a f149482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f149483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f149484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f149485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f149486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f149487f;

    public class a extends RecyclerView.ViewHolder {
        public a(View r100) {
            super(r100);
        }
    }

    public interface b {
    }

    public interface c {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return (((ui2.c) this.f149482a).b() + 0) + (this.f149485d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        int r101 = r100 + 0;
        ((ui2.c) this.f149482a).a(r101);
        int r102 = getItemViewType(r101);
        ((com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) this.f149483b).f149490b, r102)).getClass();
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f149485d == true) goto L5;
    L8:
        Object r101 = ((ui2.c) this.f149482a).a(r100 - 0);
        f r102 = this.f149483b;
        Class<?> r103 = r101.getClass();
        d r104 = (d) r102;
        r104.getClass();
        int r105 = ((ArrayList) r104.f149489a).indexOf(r103);
        if (r105 != (-1)) goto L19;
        r105 = 0;
    L13:
        if (r105 >= ((ArrayList) r104.f149489a).size()) goto L18;
        if (((Class) ListProtector.get(r104.f149489a, r105)).isAssignableFrom(r103) == true) goto L19;
        r105 = r105 + 1;
        goto L13
    L18:
        r105 = -1;
    L19:
        if (r105 == (-1)) goto L23;
        ((com.bytedance.android.livesdk.livecommerce.multitype.c) ListProtector.get(((d) this.f149483b).f149491c, r105)).index();
        return r105 + 0;
    L23:
        throw new BinderNotFoundException(r101.getClass());
    L5:
        if (r100 != (getItemCount() - 1)) goto L8;
        return -2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        if (r100.getItemViewType() != (-1)) goto L6;
        return false;
    L6:
        if (r100.getItemViewType() != (-2)) goto L8;
        return false;
    L8:
        y2(r100);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        if (r100.getItemViewType() != (-1)) goto L6;
        return;
    L6:
        if (r100.getItemViewType() != (-2)) goto L8;
        return;
    L8:
        y2(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        if (r100.getItemViewType() != (-1)) goto L6;
        return;
    L6:
        if (r100.getItemViewType() != (-2)) goto L8;
        return;
    L8:
        y2(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        if (r100.getItemViewType() != (-1)) goto L6;
        return;
    L6:
        if (r100.getItemViewType() != (-2)) goto L8;
        return;
    L8:
        y2(r100);
    }

    public final void y2(RecyclerView.ViewHolder r100) {
        if (r100.getItemViewType() >= 0) goto L5;
        return;
    L5:
        f r101 = this.f149483b;
        int r102 = r100.getItemViewType();
        com.bytedance.android.livesdk.livecommerce.multitype.b r103 = (com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) r101).f149490b, r102);
    }

    public BaseMultiTypeAdapter(ui2.c r100, d r101) {
        this.f149482a = r100;
        this.f149483b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        throw new IllegalAccessError("You should not call this method. Call RecyclerView.Adapter#onBindViewHolder(holder, position, payloads) instead.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 == (-2)) goto L5;
    L8:
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        com.bytedance.android.livesdk.livecommerce.multitype.b r103 = (com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) this.f149483b).f149490b, r101);
        r103.getClass();
        return r103.b(r102, r100);
    L5:
        if (this.f149486e == null) goto L8;
        return new a(((q) this.f149486e).f476985a.f147690r);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        if (getItemViewType(r101) != (-1)) goto L6;
        return;
    L6:
        if (getItemViewType(r101) != (-2)) goto L18;
        c r103 = this.f149487f;
        if (r103 == null) goto L16;
        com.bytedance.android.livesdk.livecommerce.broadcast.ui.b r104 = (com.bytedance.android.livesdk.livecommerce.broadcast.ui.b) r103;
        if (r104.f147703a.getContext() == null) goto L16;
        LiveRoomCouponListFragment r105 = r104.f147703a;
        int r106 = LiveRoomCouponListFragment.f147680x;
        if (((LiveRoomCouponListViewModel) r105.f147650g).hasMore() == false) goto L15;
        LiveRoomCouponListFragment r107 = r104.f147703a;
        r107.f147690r.setText(th.a.g(r107.getContext(), R.string.ec_loading_text));
        LiveRoomCouponListFragment r108 = r104.f147703a;
        ((LiveRoomCouponListViewModel) r108.f147650g).requestMore(r108.f147693u, new com.bytedance.android.livesdk.livecommerce.broadcast.ui.a(r104));
        goto L16
    L15:
        LiveRoomCouponListFragment r109 = r104.f147703a;
        r109.f147690r.setText(th.a.g(r109.getContext(), R.string.ec_search_no_more));
    L16:
        this.f149484c = r100.itemView;
        return;
    L18:
        ui2.c r110 = (ui2.c) this.f149482a;
        Object r111 = r110.a(r101 + 0);
        int r112 = r100.getItemViewType();
        com.bytedance.android.livesdk.livecommerce.multitype.b r113 = (com.bytedance.android.livesdk.livecommerce.multitype.b) ListProtector.get(((d) this.f149483b).f149490b, r112);
        ((ui2.c) this.f149482a).b();
        r113.a(r100, r111);
    }
}
