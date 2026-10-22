package com.bytedance.android.live.effect.soundeffect;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.popup.LiveRepelPopupRegion;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/LiveSoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/soundeffect/LiveSoundAdapter$ViewHolder;", "Lcom/bytedance/android/live/effect/soundeffect/LiveSoundEffectHelper$b;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSoundAdapter extends RecyclerView.Adapter<ViewHolder> implements LiveSoundEffectHelper.b, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f68092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveSoundEffectHelper f68093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Sticker> f68094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHandler f68096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yo2.f f68098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68099h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/LiveSoundAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f68100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f68101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f68102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f68103d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f68104e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final HollowCircleProgressView f68105f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f68106g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View f68107h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final View f68108i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f68109j;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f68100a = (ImageView) r100.findViewById(R.id.iv_icon);
            this.f68101b = r100.findViewById(R.id.icon_area);
            this.f68102c = r100.findViewById(R.id.bg_select);
            this.f68103d = r100.findViewById(R.id.iv_long_press_mantel);
            this.f68104e = r100.findViewById(R.id.iv_download_icon);
            this.f68105f = (HollowCircleProgressView) r100.findViewById(R.id.loading);
            this.f68106g = (TextView) r100.findViewById(R.id.tv_sound_effect_title);
            this.f68107h = r100.findViewById(R.id.red_point);
            this.f68108i = r100.findViewById(R.id.item_root);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void onError() {
        f2.b(R.string.ttlive_effect_live_download_fail_tip, 0);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f68094c.size();
    }

    public final Sticker z2() {
        int r100 = this.f68094c.size();
        int r101 = this.f68097f;
        if (r101 < 0) goto L8;
        if (r100 <= r101) goto L8;
        return (Sticker) ListProtector.get(this.f68094c, r101);
    L8:
        ALogger.e("ttlive_anchor_effect_LiveSoundAdapter", "selectIndex illegal, index:" + this.f68097f + ",length = " + this.f68094c.size());
        return null;
    }

    public LiveSoundAdapter(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f68099h = r100;
        this.f68093b = null;
        this.f68094c = new ArrayList();
        this.f68095d = R.layout.ttlive_effect_item_live_sound_effect;
        this.f68096e = new WeakHandler(this);
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void a(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Sticker.Companion.equals(r100, null);
        int r101 = this.f68094c.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (Sticker.Companion.equals(r100, (Sticker) ListProtector.get(this.f68094c, r102)) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        ListProtector.set(this.f68094c, r102, r100);
    L9:
        if (r102 < 0) goto L15;
        notifyItemChanged(r102);
        Sticker r103 = (Sticker) ListProtector.get(this.f68094c, r102);
        LiveSoundEffectHelper r104 = this.f68093b;
        if (r104 == null) goto L13;
        int r105 = LiveSoundEffectHelper.f68110h;
        r104.b(r103, true, true);
    L13:
        notifyDataSetChanged();
        return;
    L15:
        ALogger.e("ttlive_anchor_effect_LiveSoundAdapter", "soundItemList:ArrayIndexOutOfBounds,length = " + this.f68094c.size() + ", index = " + r102 + ", stickerId = " + r100.getId());
        return;
    L8:
        r102 = -1;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 0) goto L12;
        yo2.f r101 = this.f68098g;
        if (r101 == null) goto L9;
        r101.d();
    L9:
        this.f68098g = null;
        return;
    }

    public static final void y2(LiveSoundAdapter r110, ViewHolder r111) {
        r110.f68096e.removeMessages(0);
        yo2.f r100 = r110.f68098g;
        if (r100 == null) goto L5;
        r100.d();
    L5:
        r110.f68098g = null;
        int r101 = yo2.f.f568663x;
        Context r102 = r110.f68092a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L8:
        LiveRepelPopupRegion r103 = LiveRepelPopupRegion.ROOM_BOTTOM;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, EffectConfiguration.KEY_REGION);
        yo2.f r104 = new yo2.f(r102);
        r104.f568642d = null;
        r104.f568643e = R.layout.ttlive_effect_sound_effect_tip;
        r104.f568650l = true;
        r104.a();
        r110.f68098g = r104;
        r104.i(r111.f68108i, 1, 3, s1.f(55.0f) * (-1), 0);
        Message r112 = new Message();
        r112.what = 0;
        r110.f68096e.sendMessageDelayed(r112, 3000);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "viewholer");
        Sticker r103 = (Sticker) ListProtector.get(this.f68094c, r101);
        UrlModel r104 = r103.getIcon();
        if (r104 == null) goto L5;
        ImageUtil.loadImage(r102.f68100a, r104.toImgModel(), 0);
    L5:
        LiveEffectContextFactoryDelegate$Type r105 = this.f68099h;
        Map<String, Long> r106 = h.f68136a;
        Intrinsics.checkNotNullParameter(r103, "sticker");
        Intrinsics.checkNotNullParameter(r105, "type");
        h.c(r103, "live_take_voice_show", r105);
        r102.f68106g.setText(r103.getName());
        if (r103.isDownloaded() == false) goto L8;
        r102.f68104e.setVisibility(8);
        r102.f68105f.setVisibility(8);
    L10:
        if (this.f68093b != null) goto L12;
    L14:
        boolean r107 = Sticker.Companion.equals(z2(), r103);
        TextView r108 = r102.f68106g;
        if (r107 == false) goto L17;
        int r109 = R.color.ttlive_std_brand;
    L18:
        r108.setTextColor(s1.h(r109));
        View r110 = r102.f68102c;
        if (r107 == false) goto L21;
        int r111 = 0;
    L22:
        r110.setVisibility(r111);
        if (Lists.isEmpty(r103.getTags()) == true) goto L26;
        List<String> r112 = r103.getTags();
        Intrinsics.checkNotNull(r112);
        if (r112.contains("new") == false) goto L26;
    L27:
        r102.f68101b.setOnClickListener(new com.bytedance.android.live.effect.soundeffect.a(this, r102));
        r102.f68101b.setOnLongClickListener(new b(this, r102));
        r102.f68101b.setOnTouchListener(new c(this, r102));
        r102.setIsRecyclable(false);
        return;
    L26:
        r102.f68107h.setVisibility(8);
        goto L27
    L21:
        r111 = 8;
        goto L22
    L17:
        r109 = R.color.ttlive_std_text_2;
        goto L18
    L12:
        if (LiveSoundEffectHelper.a(r103) != true) goto L14;
        r102.f68104e.setVisibility(8);
        r102.f68105f.setVisibility(8);
        goto L14
    L8:
        r102.f68104e.setVisibility(0);
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f68092a = r100.getContext();
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(this.f68095d, r100, false));
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void x1(int r100, ViewHolder r101) {
        if (r101 == null) goto L7;
        HollowCircleProgressView r102 = r101.f68105f;
        if (r102 == null) goto L8;
        r102.setProgress(r100);
        return;
    L8:
        return;
    }
}
