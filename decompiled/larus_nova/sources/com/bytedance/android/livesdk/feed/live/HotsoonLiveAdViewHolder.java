package com.bytedance.android.livesdk.feed.live;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.depend.ad.IAdViewTrackService;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import g60.c;
import io.reactivex.subjects.PublishSubject;
import jw1.n;
import jw1.o;
import jw1.p;
import jw1.q;
import jw1.r;
import jw1.s;
import jw1.t;
import jw1.w;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class HotsoonLiveAdViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f124137s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f124138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f124139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f124140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f124141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f124142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f124143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FeedItem f124144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f124145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f124146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f124147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f124148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f124149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final n f124150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PublishSubject<Object> f124151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PublishSubject<Object> f124152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final IAdViewTrackService f124153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f124154q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FeedDataKey f124155r;

    public final void V3() {
        if (this.f124153p == null) goto L12;
        FeedItem r100 = this.f124144g;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getItem() != null) goto L9;
        return;
    L9:
        if ((this.f124144g.getItem() instanceof HotsoonAd) == false) goto L15;
        HotsoonAd r101 = (HotsoonAd) this.f124144g.getItem();
        this.f124153p.bind(r101.getTrackMixId(1), this.itemView);
        return;
    L15:
        return;
    }

    public final void W3() {
        LiveFeedContext.hostService().hsHostFunc().tryBindDownloadManager(this.itemView.getContext(), this.itemView.hashCode(), this.f124150m, this.f124144g.adJSONObject);
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        FeedItem r100 = this.f124144g;
        if (r100 != null) goto L5;
    L9:
        V3();
        return;
    L5:
        if (r100.getItem() == null) goto L9;
        if ((this.f124144g.getItem() instanceof HotsoonAd) == false) goto L9;
        HotsoonAd r101 = (HotsoonAd) this.f124144g.getItem();
        LiveFeedContext.hostService().hsHostFunc().adLog(this.itemView.getContext(), "feed_ad", "show", r101.getId(), 0, r101.buildEventCommonParams());
        LiveFeedContext.hostService().hsHostFunc().sendAdStats(this.itemView.getContext(), r101.getTrackUrlList(), false, new Object[]{this.f124144g.adJSONObject, "show"});
        goto L9
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        if (this.f124153p == null) goto L21;
        FeedItem r100 = this.f124144g;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getItem() != null) goto L9;
        return;
    L9:
        if ((this.f124144g.getItem() instanceof HotsoonAd) == false) goto L24;
        HotsoonAd r101 = (HotsoonAd) this.f124144g.getItem();
        JSONObject r102 = this.f124153p.unbind(r101.getTrackMixId(1));     // Catch: JSONException -> L16
        JSONObject r110 = r101.buildEventCommonParams();     // Catch: JSONException -> L16
        if (r102 == null) goto L14;
        long r103 = r102.optLong("duration", 0);     // Catch: JSONException -> L16
        r102.put("play_50", r102.optLong("play_100", 0));     // Catch: JSONException -> L16
        r102.remove("duration");     // Catch: JSONException -> L16
        r110.put("duration", r103);     // Catch: JSONException -> L16
        r110.put("ad_extra_data", r102);     // Catch: JSONException -> L16
    L14:
        LiveFeedContext.hostService().hsHostFunc().adLog(this.itemView.getContext(), "feed_ad", "show_over", r101.getId(), 0, r110);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void unbind() {
        super.unbind();
        if (this.f124144g == null) goto L6;
        LiveFeedContext.hostService().hsHostFunc().tryUnBindDowloadManager(this.itemView.getContext(), this.itemView.hashCode(), this.f124144g.adJSONObject);
    L6:
        if (this.f124148k == false) goto L11;
        this.f124148k = false;
        if (this.f124144g == null) goto L12;
        LiveFeedContext.hostService().hsHostFunc().unBindHost(this.itemView.getContext(), this.f124144g.adJSONObject);
        return;
    L12:
        return;
    }

    public final void T3(String r110) {
        FeedItem r100 = this.f124144g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getItem() != null) goto L7;
        return;
    L7:
        if ((this.f124144g.getItem() instanceof HotsoonAd) == false) goto L15;
        HotsoonAd r101 = (HotsoonAd) this.f124144g.getItem();
        if (r101.getType().equals("app") == false) goto L11;
        LiveFeedContext.hostService().hsHostFunc().onClickEvent(this.itemView.getContext(), this.f124144g.adJSONObject, "feed_ad", r110, true);
        return;
    L11:
        LiveFeedContext.hostService().hsHostFunc().adLog(this.itemView.getContext(), "feed_ad", "click", r101.getId(), 0, r101.buildEventCommonParams(r110, 0));
        LiveFeedContext.hostService().hsHostFunc().sendAdStats(this.itemView.getContext(), r101.getClickTrackUrlList(), true, new Object[]{this.f124144g.adJSONObject, "click"});
        return;
    }

    public final void U3(FeedItem r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getItem() != null) goto L6;
        return;
    L6:
        if ((r100.getItem() instanceof HotsoonAd) == false) goto L25;
        HotsoonAd r102 = (HotsoonAd) r100.getItem();
        int r103 = 2;
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L14;
        r103 = -1;
    L19:
        if (r101 != 3) goto L21;
        r103 = 4;
    L21:
        LiveFeedContext.hostService().hsHostFunc().onAdActionCLick(this.itemView.getContext(), r100.adJSONObject, r103, new Object[0]);
        return;
    L14:
        if (r102.getDisplayType() != 1) goto L17;
        r103 = 1;
        goto L19
    L17:
        if (r102.isUseCompoundLandPage() == false) goto L19;
        r103 = 3;
        goto L19
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        final FeedItem r102 = r100;
        this.f124144g = r102;
        if (this.f124148k == true) goto L8;
        this.f124148k = true;
        if (r102 == null) goto L8;
        LiveFeedContext.hostService().hsHostFunc().bindHost(this.itemView.getContext(), this.f124144g.adJSONObject, new Object[]{new w(this)});
    L8:
        if (this.f124143f > 0) goto L10;
        this.f124143f = UIUtils.getScreenWidth(this.f124138a.getContext());
    L10:
        HSImageView r103 = this.f124138a;
        int r104 = this.f124143f;
        r103.setLayoutParams(new RelativeLayout.LayoutParams(r104, r104));
        if (r102 != null) goto L13;
        return;
    L13:
        if ((r102.getItem() instanceof HotsoonAd) == false) goto L42;
        HotsoonAd r105 = (HotsoonAd) r102.getItem();
        this.f124139b.setOnClickListener(new o(this, r102));
        this.itemView.setOnClickListener(new p(this, r102));
        if (this.f124146i == false) goto L18;
        this.itemView.setOnLongClickListener(new q(this));
    L19:
        this.f124145h.setOnClickListener(new r(this, r102));
        if (CollectionUtils.isEmpty(r105.getImageList()) == true) goto L27;
        if (ListProtector.get(r105.getImageList(), 0) == null) goto L27;
        if (CollectionUtils.isEmpty(((HotsoonAd.SimpleImage) ListProtector.get(r105.getImageList(), 0)).getUrlList()) == true) goto L27;
        this.f124138a.setImageURI((String) ListProtector.get(((HotsoonAd.SimpleImage) ListProtector.get(r105.getImageList(), 0)).getUrlList(), 0));
    L27:
        if (TextUtils.isEmpty(r105.getTitle()) == true) goto L29;
        this.f124139b.setText(r105.getTitle());
        this.f124139b.setVisibility(0);
    L31:
        if (TextUtils.isEmpty(r105.getLabel()) == true) goto L33;
        this.f124141d.setText(r105.getLabel());
    L33:
        this.f124140c.setText(r105.getButtonText());
        W3();
        PublishSubject<Object> r106 = this.f124151n;
        if (r106 == null) goto L36;
        register(r106.subscribe(new s(this), new c()));
    L36:
        PublishSubject<Object> r107 = this.f124152o;
        if (r107 == null) goto L41;
        register(r107.subscribe(new t(this), new c()));
        return;
    L41:
        return;
    L29:
        this.f124139b.setVisibility(8);
        goto L31
    L18:
        this.itemView.setOnLongClickListener(null);
        goto L19
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [jw1.n] */
    public HotsoonLiveAdViewHolder(View r100, f r101, FeedDataKey r102, j r103, PublishSubject r104, PublishSubject r105) {
        super(r100);
        this.f124143f = -1;
        boolean r106 = false;
        this.f124148k = false;
        this.f124138a = (HSImageView) r100.findViewById(R.id.iv_ad_cover);
        this.f124139b = (TextView) r100.findViewById(R.id.title);
        this.f124140c = (TextView) r100.findViewById(R.id.tv_ad_button);
        this.f124142e = (ImageView) r100.findViewById(R.id.iv_left_icon);
        this.f124145h = r100.findViewById(R.id.ad_view_convert);
        this.f124141d = (TextView) r100.findViewById(R.id.ttlive_ad_label);
        this.f124150m = new n(this);
        if (r102 == null) goto L8;
        if (r103 == null) goto L8;
        if (r103.b(r102.f124005c) == false) goto L8;
        r106 = true;
    L8:
        this.f124146i = r106;
        this.f124154q = r101;
        this.f124155r = r102;
        this.f124151n = r104;
        this.f124152o = r105;
        this.f124153p = LiveFeedContext.hostService().hsHostFunc().provideViewTrackService();
    }
}
