package com.bytedance.android.livesdk.feed.live;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.feed.IHostAvatarBorderController;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.log.filter.m0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.List;
import jw1.l;
import jw1.m;
import kw1.c;

/* JADX INFO: loaded from: classes8.dex */
public class HorFollowLiveFeedViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f124125d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f124126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<FeedItem> f124127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f124128c;

    public class a extends RecyclerView.Adapter<BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorFollowLiveFeedViewHolder f124129a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f124129a.f124127b.size();
        }

        public a(HorFollowLiveFeedViewHolder r100) {
            this.f124129a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
            BaseViewHolder r101 = (BaseViewHolder) r100;
            super.onViewAttachedToWindow(r101);
            int r102 = r101.getPosition();
            if (r102 >= 0) goto L5;
            return;
        L5:
            if (r102 < this.f124129a.f124127b.size()) goto L7;
            return;
        L7:
            if (((FeedItem) ListProtector.get(this.f124129a.f124127b, r102)) != null) goto L10;
            return;
        L10:
            if ((((FeedItem) ListProtector.get(this.f124129a.f124127b, r102)).getItem() instanceof Room) == false) goto L34;
            Room r103 = (Room) ((FeedItem) ListProtector.get(this.f124129a.f124127b, r102)).getItem();
            if (r103.getBaseOwner() != null) goto L15;
            String r104 = "0";
        L16:
            HashMap r105 = new HashMap();
            r105.put("log_pb", r103.getLog_pb());
            r105.put("anchor_id", String.valueOf(r104));
            r105.put("request_id", r103.getRequestId());
            r105.put("room_id", String.valueOf(r103.getId()));
            r105.put("show_type", "stay");
            if (r103.isLiveTypeAudio() == false) goto L19;
            String r106 = "voice_live";
        L20:
            r105.put("live_type", r106);
            if (r103.isThirdParty() == false) goto L23;
            String r107 = "thirdparty";
        L24:
            r105.put("streaming_type", r107);
            r105.put("enter_from_merge", "live_merge");
            r105.put("enter_method", "follow_live");
            r105.put("event_belong", "live_view");
            r105.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live");
            r105.put("event_type", "core");
            r105.put("event_module", "live");
            r105.put("action_type", "click");
            r105.putAll(h1.a(r103));
            o r108 = u.l().c(x.class);
            if ((r108 instanceof n0) == false) goto L29;
            String r109 = ((n0) r108).f153312i;
            if (r109 == null) goto L29;
            r105.put("distribute_source", r109);
        L29:
            m0.J(r105);
            c.d("livesdk_live_show", r105);
            return;
        L23:
            r107 = "general";
            goto L24
        L19:
            r106 = "video_live";
            goto L20
        L15:
            r104 = r103.getBaseOwner().getIdString();
            goto L16
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            BaseViewHolder r102 = (BaseViewHolder) r100;
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (r101 < this.f124129a.f124127b.size()) goto L8;
            return;
        L8:
            if (ListProtector.get(this.f124129a.f124127b, r101) == null) goto L14;
            r102.bind(ListProtector.get(this.f124129a.f124127b, r101), r101);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return new b(this.f124129a, r100);
        }
    }

    public class b extends BaseViewHolder<FeedItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f124130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f124131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f124132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IHostAvatarBorderController f124133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f124134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ HorFollowLiveFeedViewHolder f124135f;

        public class a implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f124136a;

            public a(b r100) {
                this.f124136a = r100;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View r100) {
                IHostAvatarBorderController r101 = this.f124136a.f124133d;
                if (r101 == null) goto L6;
                r101.playAnimation();
                return;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View r100) {
                IHostAvatarBorderController r101 = this.f124136a.f124133d;
                if (r101 == null) goto L6;
                r101.stopAnimation();
                return;
            }
        }

        @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
        public final void onViewAttachedToWindow() {
            super.onViewAttachedToWindow();
            IHostAvatarBorderController r100 = this.f124133d;
            if (r100 == null) goto L6;
            r100.playAnimation();
            return;
        }

        @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
        public final void onViewDetachedFromWindow() {
            super.onViewDetachedFromWindow();
            IHostAvatarBorderController r100 = this.f124133d;
            if (r100 == null) goto L6;
            r100.stopAnimation();
            return;
        }

        public b(HorFollowLiveFeedViewHolder r100, ViewGroup r101) {
            this.f124135f = r100;
            super(LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_follow_hor_item_view, r101, false));
            this.f124134e = new a(this);
            this.f124130a = (HSImageView) this.itemView.findViewById(R.id.ttlive_item_avatar_image);
            this.f124131b = (TextView) this.itemView.findViewById(R.id.ttlive_item_user_name);
            Object r102 = TTLiveSDK.hostService().hostApp().liveCircleView(r101.getContext());
            if ((r102 instanceof View) == false) goto L6;
            View r103 = (View) r102;
            this.f124132c = r103;
            r103.setLayoutParams(this.itemView.findViewById(R.id.ttlive_item_live_circle).getLayoutParams());
            int r104 = (int) UIUtils.dip2Px(r101.getContext(), 3.0f);
            r103.setPadding(r104, r104, r104, r104);
            ((FrameLayout) this.itemView.findViewById(R.id.ttlive_avatar)).addView(r103, 0);
            this.itemView.findViewById(R.id.icon_tag).setVisibility(0);
            return;
        }

        @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
        public final void bind(FeedItem r100, int r101) {
            final FeedItem r102 = r100;
            if (r102 != null) goto L6;
            return;
        L6:
            if ((r102.getItem() instanceof Room) == false) goto L22;
            User r103 = (User) ((Room) r102.getItem()).getBaseOwner();
            if (r103 == null) goto L16;
            ImageModel r104 = r103.getAvatarThumb();
            if (r104 != null) goto L13;
        L15:
            this.f124131b.setText(r103.getNickName());
            goto L16
        L13:
            if (Lists.isEmpty(r104.getUrls()) == true) goto L15;
            this.f124130a.setImageURI((String) ListProtector.get(r104.getUrls(), 0));
        L16:
            this.f124130a.setVisibility(8);
            this.f124130a.setVisibility(0);
            IHostAvatarBorderController r105 = LiveFeedContext.hostService().hostApp().avatarBorderController();
            this.f124133d = r105;
            if (r105 == null) goto L19;
            r105.bindAvatarAndBorder(this.f124130a, this.f124132c, true);
            this.f124133d.setBorderVisibility(0);
            this.f124133d.playAnimation();
            this.f124130a.addOnAttachStateChangeListener(this.f124134e);
        L19:
            this.itemView.setOnClickListener(new m(this, r102));
            return;
        }
    }

    public HorFollowLiveFeedViewHolder(View r100, BannerSwipeRefreshLayout.a r101) {
        super(r100);
        Context r102 = r100.getContext();
        this.f124128c = r102;
        RecyclerView r103 = (RecyclerView) this.itemView.findViewById(R.id.ttlive_item_recyclerview);
        this.f124126a = r103;
        r103.setLayoutManager(new SSLinearLayoutManager(r102, 0));
        r103.setOnTouchListener(new l(this));
        r101.b(r103);
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        if ((r102 instanceof com.bytedance.android.livesdk.feed.feed.c) == false) goto L7;
        this.f124127b = ((com.bytedance.android.livesdk.feed.feed.c) r102).f124011a;
        this.f124126a.setAdapter(new a(this));
        return;
    }
}
