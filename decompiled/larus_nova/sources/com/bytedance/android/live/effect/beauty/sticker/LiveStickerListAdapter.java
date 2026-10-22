package com.bytedance.android.live.effect.beauty.sticker;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerComposerListAdapterKt;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.live.effect.sticker.ui.StickerItemView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\n\u000bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerListAdapter$StickerViewHolder;", "Lcom/bytedance/android/live/effect/api/k$f;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerListAdapter extends RecyclerView.Adapter<StickerViewHolder> implements k.f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f67753q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f67754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Sticker> f67755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f67756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveStickerComposerListAdapterKt.b f67757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f67758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Sticker f67759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Long> f67760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Long, Long> f67761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f67762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashSet<Integer> f67763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f67764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.live.effect.base.e f67765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Sticker> f67766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f67768o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f67769p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerListAdapter$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f67770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f67771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f67772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f67773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f67774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final MarqueeTextView f67775f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f67776g;

        public StickerViewHolder(StickerItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f67770a = (ImageView) r100.findViewById(R.id.image);
            this.f67771b = r100.findViewById(R.id.select_border);
            this.f67772c = r100.findViewById(R.id.download_icon);
            this.f67773d = r100.findViewById(R.id.loading);
            this.f67774e = r100.findViewById(R.id.dot);
            this.f67775f = (MarqueeTextView) r100.findViewById(R.id.title);
            this.f67776g = (TextView) r100.findViewById(R.id.sticker_item_view_tips);
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerListAdapter f67777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StickerViewHolder f67778b;

        public b(LiveStickerListAdapter r100, StickerViewHolder r101) {
            this.f67777a = r100;
            this.f67778b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveStickerListAdapter r101 = this.f67777a;
            long r102 = r101.f67754a;
            if (r102 != 0) goto L5;
            return;
        L5:
            r101.f67754a = 0;
            List<Long> r103 = r101.f67756c;
            ArrayList r104 = (ArrayList) r103;
            int r105 = r104.indexOf(Long.valueOf(r102));
            if (r105 < 0) goto L8;
            this.f67777a.notifyItemChanged(r105, 1);
        L8:
            View r106 = this.f67778b.f67771b;
            if (r106 == null) goto L11;
            r106.setVisibility(0);
        L11:
            LiveStickerComposerListAdapterKt.b r107 = this.f67777a.f67757d;
            if (r107 == null) goto L15;
            r107.a(null, null);
            return;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerListAdapter f67779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f67780b;

        public c(LiveStickerListAdapter r100, Sticker r101) {
            this.f67779a = r100;
            this.f67780b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            r100.onNext(Boolean.valueOf(this.f67779a.f67768o.q(this.f67780b)));
        }
    }

    public static final class d implements Observer<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Sticker f67781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StickerViewHolder f67782b;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
        }

        @Override // io.reactivex.Observer
        public final void onNext(Boolean r100) {
            if (r100.booleanValue() == false) goto L11;
            this.f67781a.setDownloading(false);
            this.f67781a.setDownloaded(true);
            View r101 = this.f67782b.f67773d;
            if (r101 == null) goto L7;
            r101.setVisibility(8);
        L7:
            View r102 = this.f67782b.f67772c;
            if (r102 == null) goto L12;
            r102.setVisibility(8);
            return;
        L12:
            return;
        }

        public d(Sticker r100, StickerViewHolder r101) {
            this.f67781a = r100;
            this.f67782b = r101;
        }
    }

    public static final class e implements IIsTagNeedUpdatedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StickerViewHolder f67783a;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
        public final void onTagNeedNotUpdate() {
            View r100 = this.f67783a.f67774e;
            if (r100 == null) goto L6;
            r100.setVisibility(8);
            return;
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
        public final void onTagNeedUpdate() {
            View r100 = this.f67783a.f67774e;
            if (r100 == null) goto L6;
            r100.setVisibility(0);
            return;
        }

        public e(StickerViewHolder r100) {
            this.f67783a = r100;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveStickerListAdapter f67784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f67785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ StickerViewHolder f67786c;

        public static final class a implements IUpdateTagListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f67787a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Sticker f67788b;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.sticker.LiveStickerListAdapter$f$a$a, reason: collision with other inner class name */
            public static final class C1111a implements IIsTagNeedUpdatedListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f67789a;

                @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
                public final void onTagNeedNotUpdate() {
                    View r100 = this.f67789a.f67787a.f67786c.f67774e;
                    if (r100 == null) goto L6;
                    r100.setVisibility(8);
                    return;
                }

                @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
                public final void onTagNeedUpdate() {
                    View r100 = this.f67789a.f67787a.f67786c.f67774e;
                    if (r100 == null) goto L6;
                    r100.setVisibility(0);
                    return;
                }

                public C1111a(a r100) {
                    this.f67789a = r100;
                }
            }

            public a(f r100, Sticker r101) {
                this.f67787a = r100;
                this.f67788b = r101;
            }

            @Override // com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener
            public final void onFinally() {
                LiveStickerListAdapter r100 = this.f67787a.f67784a;
                Sticker r101 = this.f67788b;
                C1111a r102 = new C1111a(this);
                int r103 = LiveStickerListAdapter.f67753q;
                r100.z2(r101, r102);
            }
        }

        public f(LiveStickerListAdapter r100, int r101, StickerViewHolder r102) {
            this.f67784a = r100;
            this.f67785b = r101;
            this.f67786c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Sticker r101 = (Sticker) ListProtector.get(this.f67784a.f67755b, this.f67785b);
            if (r101 != null) goto L5;
            return;
        L5:
            long r102 = r101.getId();
            LiveStickerListAdapter r103 = this.f67784a;
            if (r102 != r103.f67754a) goto L8;
            return;
        L8:
            r103.f67768o.n(r101.getRealId(), r101.getTagsUpdatedAt(), new a(this, r101));
            if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L11;
            LiveStickerListAdapter r104 = this.f67784a;
            com.bytedance.android.live.effect.base.e r105 = new com.bytedance.android.live.effect.base.e();
            r105.f67000f = System.currentTimeMillis();
            r105.f66998d = RenderTriggerType.SelectByUser;
            Unit r106 = Unit.INSTANCE;
            r104.f67765l = r105;
        L11:
            LiveStickerListAdapter r107 = this.f67784a;
            r107.f67764k = true;
            if (r107.f67768o.q(r101) == false) goto L14;
        L16:
            LiveStickerListAdapter r108 = this.f67784a;
            long r109 = r108.f67754a;
            r108.f67754a = r101.getId();
            List<Long> r110 = this.f67784a.f67756c;
            ArrayList r111 = (ArrayList) r110;
            if (r111.contains(Long.valueOf(r109)) == false) goto L21;
            List<Long> r112 = this.f67784a.f67756c;
            ArrayList r113 = (ArrayList) r112;
            int r114 = r113.indexOf(Long.valueOf(r109));
            if (r114 < 0) goto L21;
            this.f67784a.notifyItemChanged(r114, 1);
        L21:
            LiveStickerListAdapter r115 = this.f67784a;
            StickerViewHolder r116 = this.f67786c;
            if (r115.f67754a == 0) goto L24;
            boolean r117 = true;
        L25:
            r115.B2(r116, r101, r117);
            com.bytedance.android.live.effect.base.e r118 = this.f67784a.f67765l;
            if (r118 == null) goto L28;
            r118.f67001g = System.currentTimeMillis();
            r118.f66999e = true;
            r118.f66996b = r101;
            String r119 = this.f67784a.f67769p;
            Intrinsics.checkNotNullParameter(r119, "<set-?>");
            r118.f66997c = r119;
        L28:
            LiveStickerListAdapter r120 = this.f67784a;
            LiveStickerComposerListAdapterKt.b r121 = r120.f67757d;
            if (r121 == null) goto L33;
            r121.a(r101, r120.f67765l);
            return;
        L33:
            return;
        L24:
            r117 = false;
            goto L25
        L14:
            if (this.f67784a.f67754a == r101.getId()) goto L16;
            this.f67784a.f67761h.put(Long.valueOf(r101.getId()), Long.valueOf(System.currentTimeMillis()));
            LiveStickerListAdapter r122 = this.f67784a;
            r122.f67759f = r101;
            List<Long> r123 = r122.f67760g;
            ArrayList r124 = (ArrayList) r123;
            r124.add(Long.valueOf(r101.getId()));
            LiveStickerListAdapter r125 = this.f67784a;
            r125.f67768o.g(d0.f66753c, r101, r125);
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f67755b).size();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67767n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        StickerViewHolder r101 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        this.f67763j.remove(Integer.valueOf(r101.getAdapterPosition()));
    }

    public final void A2(MarqueeTextView r100, boolean r101) {
        if (r100 == null) goto L4;
        r100.setMarqueeEnable(r101);
    L4:
        if (r100 == null) goto L6;
        r100.setSelected(r101);
    L6:
        if (r100 == null) goto L11;
        if (r101 == false) goto L9;
        TextUtils.TruncateAt r102 = TextUtils.TruncateAt.MARQUEE;
    L10:
        r100.setEllipsize(r102);
        goto L11
    L9:
        r102 = null;
    L11:
        if (r100 == null) goto L17;
        if (r101 == false) goto L14;
        int r103 = GravityCompat.START;
    L15:
        r100.setGravity(r103);
        return;
    L14:
        r103 = 17;
        goto L15
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r100, Sticker r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        r101.setDownloaded(true);
        r101.setStickerPanel(r100);
        Sticker r102 = this.f67759f;
        if (r102 != null) goto L7;
    L22:
        List<Long> r103 = this.f67760g;
        ArrayList r104 = (ArrayList) r103;
        if (r104.contains(Long.valueOf(r101.getId())) == false) goto L30;
        List<Long> r105 = this.f67756c;
        ArrayList r106 = (ArrayList) r105;
        int r107 = r106.indexOf(Long.valueOf(r101.getId()));
        if (r107 >= 0) goto L27;
    L29:
        List<Long> r108 = this.f67760g;
        ArrayList r109 = (ArrayList) r108;
        r109.remove(Long.valueOf(r101.getId()));
        goto L30
    L27:
        if (r107 >= ((ArrayList) this.f67755b).size()) goto L29;
        ListProtector.set(this.f67755b, r107, r101);
    L30:
        List<Long> r110 = this.f67756c;
        ArrayList r111 = (ArrayList) r110;
        int r112 = r111.indexOf(Long.valueOf(r101.getId()));
        if (r112 < 0) goto L34;
        notifyItemChanged(r112, 1);
        return;
    L34:
        return;
    L7:
        if (r102.getId() != r101.getId()) goto L22;
        long r113 = this.f67754a;
        long r114 = r101.getId();
        this.f67754a = r114;
        List<Sticker> r115 = this.f67755b;
        List<Long> r116 = this.f67756c;
        ArrayList r117 = (ArrayList) r116;
        ListProtector.set(r115, r117.indexOf(Long.valueOf(r114)), r101);
        List<Long> r118 = this.f67756c;
        ArrayList r119 = (ArrayList) r118;
        if (r119.contains(Long.valueOf(r113)) == false) goto L13;
        List<Long> r120 = this.f67756c;
        ArrayList r121 = (ArrayList) r120;
        int r122 = r121.indexOf(Long.valueOf(r113));
        if (r122 < 0) goto L13;
        notifyItemChanged(r122, 1);
    L13:
        com.bytedance.android.live.effect.base.e r123 = this.f67765l;
        if (r123 == null) goto L19;
        r123.f67001g = System.currentTimeMillis();
        r123.f66999e = false;
        r123.f66996b = r101;
        if (r100 != null) goto L18;
        r100 = "";
    L18:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r123.f66997c = r100;
    L19:
        LiveStickerComposerListAdapterKt.b r124 = this.f67757d;
        if (r124 == null) goto L22;
        r124.a(r101, this.f67765l);
        goto L22
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r100, Sticker r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        List<Long> r102 = this.f67756c;
        ArrayList r103 = (ArrayList) r102;
        int r104 = r103.indexOf(Long.valueOf(r101.getId()));
        if (r104 < 0) goto L8;
        notifyItemChanged(r104, 1);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((StickerViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new StickerViewHolder(new StickerItemView(r100.getContext(), null, 6, 0));
    }

    public final void y2(StickerViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        int r100 = 0;
        if (r111 != 0) goto L27;
        MarqueeTextView r112 = r110.f67775f;
        if (r112 == null) goto L7;
        r112.setText("无");
    L7:
        ImageView r113 = r110.f67770a;
        if (r113 == null) goto L10;
        r113.setImageResource(R.drawable.ttlive_effect_beauty_sticker_empty_item);
    L10:
        View r114 = r110.f67773d;
        if (r114 == null) goto L13;
        r114.setVisibility(4);
    L13:
        View r115 = r110.f67772c;
        if (r115 == null) goto L16;
        r115.setVisibility(4);
    L16:
        View r116 = r110.f67774e;
        if (r116 == null) goto L19;
        r116.setVisibility(4);
    L19:
        View r117 = r110.f67771b;
        if (r117 != null) goto L22;
    L26:
        r110.itemView.setOnClickListener(new b(this, r110));
        return;
    L22:
        if (this.f67754a == 0) goto L25;
        r100 = 4;
    L25:
        r117.setVisibility(r100);
        goto L26
    L27:
        Sticker r101 = (Sticker) ListProtector.get(this.f67755b, r111);
        if (r101 != null) goto L31;
        return;
    L31:
        if (r101.isDownloaded() == true) goto L33;
        Observable.create(new c(this, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r101, r110));
    L33:
        ImageView r102 = r110.f67770a;
        UrlModel r103 = r101.getIcon();
        if (r103 == null) goto L36;
        py.k r104 = r103.toImgModel();
    L37:
        ImageUtil.loadImage(r102, r104, 0);
        View r105 = r110.f67773d;
        if (r105 != null) goto L40;
    L44:
        View r106 = r110.f67772c;
        if (r106 != null) goto L47;
    L51:
        boolean r107 = true;
        if (this.f67754a != r101.getId()) goto L54;
        boolean r108 = true;
    L55:
        MarqueeTextView r109 = r110.f67775f;
        if (r109 == null) goto L58;
        r109.setText(r101.getName());
    L58:
        B2(r110, r101, r108);
        String r118 = r101.getTopTips();
        if (r118 != null) goto L61;
    L64:
        if (r107 == true) goto L68;
        TextView r119 = r110.f67776g;
        if (r119 == null) goto L71;
        r119.setVisibility(0);
        r110.f67776g.setText(r101.getTopTips());
    L71:
        z2(r101, new e(r110));
        r110.itemView.setOnClickListener(new f(this, r111, r110));
        return;
    L68:
        TextView r120 = r110.f67776g;
        if (r120 == null) goto L71;
        r120.setVisibility(8);
        goto L71
    L61:
        if (r118.length() == 0) goto L64;
        r107 = false;
        goto L64
    L54:
        r108 = false;
        goto L55
    L47:
        if (r101.isDownloaded() == false) goto L49;
        int r121 = 8;
    L50:
        r106.setVisibility(r121);
        goto L51
    L49:
        r121 = 0;
        goto L50
    L40:
        if (r101.isDownloading() == false) goto L42;
        int r122 = 0;
    L43:
        r105.setVisibility(r122);
        goto L44
    L42:
        r122 = 8;
        goto L43
    L36:
        r104 = null;
        goto L37
    }

    public final void z2(Sticker r100, IIsTagNeedUpdatedListener r101) {
        List<String> r102 = r100.getTags();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L17;
        List<String> r104 = r100.getTags();
        if (r104 == null) goto L17;
        if (r104.contains("new") != true) goto L17;
        this.f67768o.b(r100.getRealId(), r100.getTagsUpdatedAt(), r101);
        return;
    L17:
        r101.onTagNeedNotUpdate();
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public LiveStickerListAdapter(LiveEffectContextFactoryDelegate$Type r100, k r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "presenter");
        Intrinsics.checkNotNullParameter(r102, "panel");
        this.f67767n = r100;
        this.f67768o = r101;
        this.f67769p = r102;
        this.f67755b = new ArrayList();
        this.f67756c = new ArrayList();
        this.f67760g = new ArrayList();
        this.f67761h = new LinkedHashMap();
        this.f67763j = new HashSet();
        this.f67766m = new ArrayList();
    }

    public final void B2(StickerViewHolder r100, Sticker r101, boolean r102) {
        if (r102 == false) goto L16;
        View r103 = r100.f67771b;
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        r101.setDownloaded(true);
        View r104 = r100.f67772c;
        if (r104 == null) goto L11;
        r104.setVisibility(4);
    L11:
        if (r101.getName() == null) goto L15;
        String r105 = r101.getName();
        Intrinsics.checkNotNull(r105);
        if (r105.length() <= 5) goto L15;
        A2(r100.f67775f, true);
        return;
    L15:
        A2(r100.f67775f, false);
        return;
    L16:
        View r106 = r100.f67771b;
        if (r106 == null) goto L19;
        r106.setVisibility(4);
    L19:
        A2(r100.f67775f, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        StickerViewHolder r103 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        boolean r104 = false;
        int r105 = 0;
        if (r102.isEmpty() == false) goto L15;
        y2(r103, r101);
        if (this.f67763j.contains(Integer.valueOf(r101)) == true) goto L51;
        this.f67763j.add(Integer.valueOf(r101));
        Sticker r106 = (Sticker) ListProtector.get(this.f67755b, r101);
        if (r106 != null) goto L10;
        return;
    L10:
        if (this.f67764k == false) goto L12;
        this.f67764k = false;
        return;
    L12:
        i r107 = this.f67758e;
        if (r107 == null) goto L47;
        r107.a(r106, r101 + 1);
        return;
    L47:
        return;
    L51:
        return;
    L15:
        if (r101 != 0) goto L23;
        View r108 = r103.f67771b;
        if (r108 != null) goto L19;
        return;
    L19:
        if (this.f67754a == 0) goto L22;
        r105 = 4;
    L22:
        r108.setVisibility(r105);
        return;
    L23:
        Sticker r109 = (Sticker) ListProtector.get(this.f67755b, r101);
        if (r109 == null) goto L52;
        View r110 = r103.f67773d;
        int r111 = 8;
        if (r110 != null) goto L29;
    L33:
        View r112 = r103.f67772c;
        if (r112 == null) goto L41;
        if (r109.isDownloaded() == true) goto L39;
        r111 = 0;
    L39:
        r112.setVisibility(r111);
    L41:
        if (this.f67754a != r109.getId()) goto L43;
        r104 = true;
    L43:
        B2(r103, r109, r104);
        return;
    L29:
        if (r109.isDownloading() == false) goto L31;
        int r113 = 0;
    L32:
        r110.setVisibility(r113);
        goto L33
    L31:
        r113 = 8;
        goto L32
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r100, Sticker r101, ExceptionResult r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        f2.b(R.string.ttlive_effect_live_sticker_download_failed, 0);
        List<Long> r103 = this.f67756c;
        ArrayList r104 = (ArrayList) r103;
        int r105 = r104.indexOf(Long.valueOf(r101.getId()));
        Sticker r106 = (Sticker) CollectionsKt.getOrNull(this.f67755b, r105);
        if (r106 == null) goto L7;
        r106.setDownloading(false);
    L7:
        if (r105 < 0) goto L9;
        notifyItemChanged(r105, 1);
    L9:
        com.bytedance.android.live.effect.base.e r107 = this.f67765l;
        if (r107 == null) goto L13;
        List<String> r108 = LiveEffectContext.f66734h;
        ((com.bytedance.android.live.effect.api.f) LiveEffectContext.a.a(this.f67767n).f66740f.getValue()).a(r107, "live_take_detail");
        return;
    }
}
