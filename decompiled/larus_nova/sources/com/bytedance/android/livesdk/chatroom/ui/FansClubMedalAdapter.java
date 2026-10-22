package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.FansClubMedal;
import com.bytedance.android.live.base.model.user.FansClubData;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class FansClubMedalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FansClubMedal> f112170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FansClubData f112171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f112173d;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f112174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f112175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f112176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f112177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f112178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f112179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public FansClubMedal f112180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f112181h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ FansClubMedalAdapter f112182i;

        public b(FansClubMedalAdapter r100, View r101, int r102) {
            this.f112182i = r100;
            super(r101);
            this.f112181h = r102;
            HSImageView r103 = (HSImageView) r101.findViewById(R.id.fans_club_medal);
            this.f112174a = r103;
            this.f112175b = (TextView) r101.findViewById(R.id.title);
            this.f112176c = (TextView) r101.findViewById(R.id.level);
            this.f112178e = r101.findViewById(R.id.selected_icon);
            this.f112177d = (TextView) r101.findViewById(R.id.anchor_name);
            r103.setOnClickListener(new j6(this));
            TextView r104 = (TextView) r101.findViewById(R.id.fans_calub_unselected);
            this.f112179f = r104;
            r104.setOnClickListener(new k6(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<FansClubMedal> r100 = this.f112170a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != (this.f112170a.size() - 1)) goto L5;
        return 1;
    L5:
        return 0;
    }

    public static void z2(FansClubMedalAdapter r100, FansClubMedal r101) {
        if (r101 == null) goto L4;
        r100.getClass();
        r101.setSelected(true);
    L4:
        Iterator<FansClubMedal> r102 = r100.f112170a.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        FansClubMedal r103 = r102.next();
        if (r103 == null) goto L6;
        if (r103.equals(r101) == true) goto L6;
        r103.setSelected(false);
        goto L6
    L12:
        r100.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        FansClubMedal r103 = (FansClubMedal) ListProtector.get(this.f112170a, r101);
        r102.f112180g = r103;
        int r104 = 0;
        if (r102.f112181h != 1) goto L5;
        y2(r102.f112182i, r102.f112179f, 0);
        y2(r102.f112182i, r102.f112174a, 8);
        y2(r102.f112182i, r102.f112175b, 8);
        y2(r102.f112182i, r102.f112176c, 8);
        y2(r102.f112182i, r102.f112177d, 8);
    L20:
        if (r103 == null) goto L27;
        View r105 = r102.f112178e;
        if (r103.isSelected() == true) goto L25;
        r104 = 4;
    L25:
        r105.setVisibility(r104);
        return;
    L27:
        return;
    L5:
        y2(r102.f112182i, r102.f112179f, 8);
        y2(r102.f112182i, r102.f112174a, 0);
        y2(r102.f112182i, r102.f112175b, 0);
        y2(r102.f112182i, r102.f112176c, 0);
        y2(r102.f112182i, r102.f112177d, 0);
        if (r103.getBadge() == null) goto L8;
        ImageLoader.bindImage(r102.f112174a, r103.getBadge().getIcon());
        r102.f112175b.setText(r103.getBadge().getTitle());
    L8:
        r102.f112176c.setText(com.bytedance.android.live.core.utils.s1.C(R.string.ttlive_fans_club_level, new Object[]{String.valueOf(r103.getLevel())}));
        if (r103.getAnchor() == null) goto L11;
        r102.f112177d.setText(r103.getAnchor().getNickName());
    L11:
        FansClubMedalAdapter r106 = r102.f112182i;
        if (r106.f112172c == false) goto L20;
        FansClubData r107 = r106.f112171b;
        if (r107 == null) goto L20;
        if (TextUtils.isEmpty(r107.getClubName()) == true) goto L20;
        if (r102.f112182i.f112171b.getClubName().equals(r103.getBadge().getTitle()) == false) goto L20;
        r103.setSelected(true);
        r102.f112182i.f112172c = false;
        goto L20
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new b(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_fans_club_medal, r100, false), r101);
    }

    public FansClubMedalAdapter(List r100, FansClubData r101, r7 r102) {
        this.f112172c = true;
        if (r100 == null) goto L8;
        FansClubMedal r103 = new FansClubMedal();
        if (r101 != null) goto L7;
        r103.setSelected(true);
    L7:
        r100.add(r103);
    L8:
        this.f112170a = r100;
        this.f112171b = r101;
        this.f112173d = r102;
    }

    public static void y2(FansClubMedalAdapter r100, View r101, int r102) {
        r100.getClass();
        if (r101 == null) goto L6;
        r101.setVisibility(r102);
        return;
    }
}
