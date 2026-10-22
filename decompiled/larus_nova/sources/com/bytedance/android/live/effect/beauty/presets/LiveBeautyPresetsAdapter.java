package com.bytedance.android.live.effect.beauty.presets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsAdapter$PresetsItemViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PresetsItemViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyPresetsAdapter extends RecyclerView.Adapter<PresetsItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<BeautifyPreset> f67409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f67410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f67411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveBeautyPresetsHelper f67412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f67413e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsAdapter$PresetsItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PresetsItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f67414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f67415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f67416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f67417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f67418e;

        public PresetsItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f67414a = (TextView) r100.findViewById(R.id.preset_text);
            this.f67415b = r100.findViewById(R.id.background);
            this.f67416c = (ImageView) r100.findViewById(R.id.delete_icon);
            this.f67417d = (ImageView) r100.findViewById(R.id.rename_icon);
            this.f67418e = r100.findViewById(R.id.select_border);
        }
    }

    public interface a {
        void a(BeautifyPreset r100);

        void b(BeautifyPreset r100);

        void c(BeautifyPreset r100);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautyPresetsAdapter f67419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f67420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BeautifyPreset f67421c;

        public b(LiveBeautyPresetsAdapter r100, Map r101, BeautifyPreset r102) {
            this.f67419a = r100;
            this.f67420b = r101;
            this.f67421c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveBeautyPresetsAdapter r101 = this.f67419a;
            if (r101.f67411c == false) goto L6;
            r101.B2(false);
            return;
        L6:
            if ((!this.f67420b.isEmpty()) == false) goto L15;
            ALogger.i("LiveBeautyPresetsTrace", "click repel item, presetId = " + this.f67421c.getPresetId());
            if (this.f67420b.values().contains("livedigitavatar") == false) goto L11;
            f2.b(R.string.ttlive_effect_digit_avatar_repel_body_beauty_toast, 0);
            return;
        L11:
            if (this.f67420b.values().contains(d0.f66753c) == false) goto L22;
            f2.b(R.string.ttlive_effect_sticker_repel_beauty_toast_new, 0);
            return;
        L22:
            return;
        L15:
            if ((!Intrinsics.areEqual(this.f67419a.f67412d.j(), this.f67421c.getPresetId())) == false) goto L19;
            a r102 = this.f67419a.f67410b;
            if (r102 == null) goto L24;
            r102.c(this.f67421c);
            return;
        L24:
            return;
        L19:
            ALogger.i("LiveBeautyPresetsTrace", "click same item, presetId = " + this.f67421c.getPresetId());
        }
    }

    public static final class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautyPresetsAdapter f67422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f67423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BeautifyPreset f67424c;

        public c(LiveBeautyPresetsAdapter r100, Map r101, BeautifyPreset r102) {
            this.f67422a = r100;
            this.f67423b = r101;
            this.f67424c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            if ((!this.f67423b.isEmpty()) == false) goto L10;
            ALogger.i("LiveBeautyPresetsTrace", "click repel item, presetId = " + this.f67424c.getPresetId());
            if (this.f67423b.values().contains("livedigitavatar") == false) goto L8;
            f2.b(R.string.ttlive_effect_digit_avatar_repel_body_beauty_toast, 0);
        L11:
            return true;
        L8:
            if (this.f67423b.values().contains(d0.f66753c) == false) goto L11;
            f2.b(R.string.ttlive_effect_sticker_repel_beauty_toast_new, 0);
            goto L11
        L10:
            this.f67422a.B2(true);
            goto L11
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautyPresetsAdapter f67425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BeautifyPreset f67426b;

        public d(LiveBeautyPresetsAdapter r100, BeautifyPreset r101) {
            this.f67425a = r100;
            this.f67426b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f67425a.f67410b;
            if (r101 == null) goto L6;
            r101.b(this.f67426b);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautyPresetsAdapter f67427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BeautifyPreset f67428b;

        public e(LiveBeautyPresetsAdapter r100, BeautifyPreset r101) {
            this.f67427a = r100;
            this.f67428b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f67427a.f67410b;
            if (r101 == null) goto L6;
            r101.a(this.f67428b);
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f67409a.size();
    }

    public final void B2(boolean r100) {
        if (this.f67411c == r100) goto L6;
        this.f67411c = r100;
        notifyItemRangeChanged(0, this.f67409a.size(), PresetOperationType.EDIT_MODE);
        return;
    }

    public LiveBeautyPresetsAdapter(LiveBeautyPresetsHelper r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        this.f67412d = r100;
        this.f67413e = r101;
        this.f67409a = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        z2((PresetsItemViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (this.f67413e == false) goto L5;
        int r103 = R.layout.ttlive_effect_item_beauty_presets_item_v2;
    L7:
        return new PresetsItemViewHolder(r102.inflate(r103, r100, false));
    L5:
        r103 = R.layout.ttlive_effect_item_beauty_presets_item;
        goto L7
    }

    public final void y2(PresetsItemViewHolder r100, int r101) {
        if (Intrinsics.areEqual(((BeautifyPreset) ListProtector.get(this.f67409a, r101)).getPresetId(), this.f67412d.j()) == false) goto L5;
        r100.f67418e.setVisibility(0);
        return;
    L5:
        r100.f67418e.setVisibility(8);
    }

    public final void z2(PresetsItemViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r101 >= 0) goto L5;
    L25:
        ALogger.e("LiveBeautyPresetsTrace", "Invalid position " + r101 + " with presets size " + this.f67409a.size());
        return;
    L5:
        if (r101 >= this.f67409a.size()) goto L25;
        BeautifyPreset r102 = (BeautifyPreset) ListProtector.get(this.f67409a, r101);
        r100.f67414a.setText(r102.getPresetName());
        ImageView r103 = r100.f67416c;
        int r104 = 0;
        if (this.f67411c == false) goto L10;
        int r105 = 0;
    L11:
        r103.setVisibility(r105);
        ImageView r106 = r100.f67417d;
        if (this.f67411c == false) goto L14;
        int r107 = 0;
    L15:
        r106.setVisibility(r107);
        View r108 = r100.f67418e;
        if (Intrinsics.areEqual(this.f67412d.j(), r102.getPresetId()) == true) goto L19;
        r104 = 8;
    L19:
        r108.setVisibility(r104);
        Map<Long, String> r109 = this.f67412d.h(r102);
        if ((!r109.isEmpty()) == false) goto L22;
        r100.itemView.setAlpha(0.5f);
    L23:
        r100.itemView.setOnClickListener(new b(this, r109, r102));
        r100.itemView.setOnLongClickListener(new c(this, r109, r102));
        r100.f67416c.setOnClickListener(new d(this, r102));
        r100.f67417d.setOnClickListener(new e(this, r102));
        return;
    L22:
        r100.itemView.setAlpha(1.0f);
        goto L23
    L14:
        r107 = 8;
        goto L15
    L10:
        r105 = 8;
        goto L11
    }

    public final void A2(List<BeautifyPreset> r100, PresetOperationType r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f67409a = r100;     // Catch: Throwable -> L20
        int r103 = com.bytedance.android.live.effect.beauty.presets.c.f67478a[r101.ordinal()];     // Catch: Throwable -> L20
        if (r103 != 1) goto L6;
        notifyDataSetChanged();     // Catch: Throwable -> L20
    L23:
        return;
    L6:
        if (r103 != 2) goto L8;
        notifyItemInserted(r102);     // Catch: Throwable -> L20
        notifyItemRangeChanged(0, this.f67409a.size(), PresetOperationType.ADD_PRESET);     // Catch: Throwable -> L20
        goto L23
    L8:
        if (r103 != 3) goto L10;
        notifyItemRemoved(r102);     // Catch: Throwable -> L20
        goto L23
    L10:
        if (r103 != 4) goto L12;
        notifyItemChanged(r102);     // Catch: Throwable -> L20
        goto L23
    L12:
        if (r103 != 5) goto L23;
        notifyItemRangeChanged(0, this.f67409a.size(), PresetOperationType.SELECT_PRESET);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "LiveBeautyPresetsAdapter#setData ", th);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        PresetsItemViewHolder r103 = (PresetsItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        z2(r103, r101);
        return;
    L5:
        Iterator r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L33;
        Object r105 = r104.next();
        if ((r105 instanceof PresetOperationType) == false) goto L7;
        switch(com.bytedance.android.live.effect.beauty.presets.c.f67479b[((PresetOperationType) r105).ordinal()]) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L13;
            default: goto L7;
        };
    L13:
        ImageView r106 = r103.f67416c;
        int r107 = 0;
        if (this.f67411c == false) goto L16;
        int r108 = 0;
    L17:
        r106.setVisibility(r108);
        ImageView r109 = r103.f67417d;
        if (this.f67411c == true) goto L21;
        r107 = 8;
    L21:
        r109.setVisibility(r107);
        y2(r103, r101);
        goto L7
    L16:
        r108 = 8;
        goto L17
    L22:
        y2(r103, r101);
        goto L7
    }
}
