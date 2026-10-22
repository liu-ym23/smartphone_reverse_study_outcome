package com.bytedance.android.livesdk.chatroom.replay.cache.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.customui.CacheProgressBar;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.customui.SwipeMenuLayout;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import lm3.c;
import lm3.d;
import py.k;
import tp1.b;
import zk1.g;
import zk1.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CommonViewHolder", "FooterViewHolder", "SeasonTitleViewHolder", "TitleViewHolder", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayCacheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f108140a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheAdapter$CommonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommonViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f108141a;

        public CommonViewHolder(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            super(r100);
            this.f108141a = r100;
            CacheProgressBar r102 = (CacheProgressBar) r100.findViewById(R.id.vs_cache_progress);
            if (r102 == null) goto L9;
            Resources r103 = r100.getContext().getResources();
            if (r101 == false) goto L7;
            int r104 = R.color.ttlive_vs_cache_host_progress_bar_bg;
        L8:
            r102.setBarBgColor(r103.getColor(r104));
            goto L9
        L7:
            r104 = R.color.ttlive_vs_cache_progress_bar_bg;
        L9:
            CacheProgressBar r105 = (CacheProgressBar) r100.findViewById(R.id.vs_cache_progress);
            if (r105 == null) goto L16;
            Resources r106 = r100.getContext().getResources();
            if (r101 == false) goto L14;
            int r107 = R.color.ttlive_vs_cache_host_progress_bar_start_bg;
        L15:
            r105.setBarStartColor(r106.getColor(r107));
            goto L16
        L14:
            r107 = R.color.ttlive_vs_cache_progress_bar_start_bg;
        L16:
            CacheProgressBar r108 = (CacheProgressBar) r100.findViewById(R.id.vs_cache_progress);
            if (r108 == null) goto L23;
            Resources r109 = r100.getContext().getResources();
            if (r101 == false) goto L21;
            int r110 = R.color.ttlive_vs_cache_host_progress_bar_stop_bg;
        L22:
            r108.setBarStopColor(r109.getColor(r110));
            goto L23
        L21:
            r110 = R.color.ttlive_vs_cache_progress_bar_stop_bg;
        L23:
            CacheProgressBar r111 = (CacheProgressBar) r100.findViewById(R.id.vs_cache_progress);
            if (r111 == null) goto L26;
            r111.setBarRadius(s1.e(3.0f));
        L26:
            ((Group) r100.findViewById(R.id.vs_caching_group)).setReferencedIds(new int[]{R.id.vs_cache_progress, R.id.vs_cache_progress_detail, R.id.vs_cache_progress_ratio});
            Group r112 = (Group) r100.findViewById(R.id.vs_cache_group);
            if (r112 == null) goto L30;
            r112.setReferencedIds(new int[]{R.id.vs_cache_size, R.id.vs_history, R.id.vs_history_phone});
            return;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f108142a;

        public FooterViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            super(r100);
            this.f108142a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheAdapter$SeasonTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SeasonTitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f108143a;

        public SeasonTitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            super(r100);
            this.f108143a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f108144a;

        public TitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            super(r100);
            this.f108144a = r100;
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayCacheAdapter f108145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ yk1.a f108146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f108147c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheAdapter$a$a, reason: collision with other inner class name */
        public static final class C1641a implements c.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f108148b;

            public C1641a(a r100) {
                this.f108148b = r100;
            }

            @Override // lm3.c.a
            public final void onAction(d r100) {
                e<VideoResolutionItem> r101 = nq1.d.f520092a;
                e<Boolean> r102 = nq1.d.f520097f;
                Boolean r103 = Boolean.TRUE;
                r102.getClass();
                f.d(r102, r103);
                a r104 = this.f108148b;
                r104.f108145a.f108140a.g(r104.f108147c);
            }
        }

        public a(ReplayCacheAdapter r100, yk1.a r101, int r102) {
            this.f108145a = r100;
            this.f108146b = r101;
            this.f108147c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ReplayCacheAdapter.y2(this.f108145a, "vs_download_episode_delete_click", this.f108146b);
            e<VideoResolutionItem> r101 = nq1.d.f520092a;
            if (nq1.d.f520097f.getValue().booleanValue() == true) goto L7;
            Context r102 = this.f108145a.f108140a.f572583d;
            if (r102 == null) goto L9;
            ArrayList r103 = new ArrayList();
            c r104 = new c();
            r104.f509864b = "取消";
            r103.add(r104);
            c r105 = new c();
            r105.f509864b = "确认";
            r105.f509865c = new C1641a(this);
            r103.add(r105);
            d.a r106 = new d.a(r102);
            r106.f509871b = "本视频已下载的内容将会被删除，请确认操作";
            r106.f509874e = r103;
            r106.a();
            return;
        L9:
            return;
        L7:
            this.f108145a.f108140a.g(this.f108147c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f108140a.f572585f).size();
    }

    public ReplayCacheAdapter(h r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataContext");
        this.f108140a = r100;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "adapter");
        r100.f572589j = this;
        r100.b();
    }

    public static void D2(CommonViewHolder r100) {
        AbstractDraweeController r101 = Fresco.newDraweeControllerBuilder().setUri("asset://com.ss.android.ies.live.sdk/ttlive_vs_playing.webp").setAutoPlayAnimations(true).build();
        HSImageView r102 = (HSImageView) r100.f108141a.findViewById(R.id.vs_cache_play_state_iv);
        if (r102 == null) goto L6;
        r102.setController(r101);
        return;
    }

    public final void C2(CommonViewHolder r100) {
        RelativeLayout r101 = (RelativeLayout) r100.f108141a.findViewById(R.id.vs_cache_state_container);
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ImageView r102 = (ImageView) r100.f108141a.findViewById(R.id.vs_cache_state_iv);
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        RelativeLayout r103 = (RelativeLayout) r100.f108141a.findViewById(R.id.vs_cache_state_container);
        if (r103 == null) goto L11;
        r103.setBackgroundResource(R.drawable.ttlive_bg_vs_cache_cover_with_frame);
    L11:
        HSImageView r104 = (HSImageView) r100.f108141a.findViewById(R.id.vs_cache_play_state_iv);
        if (r104 == null) goto L14;
        r104.setVisibility(0);
    L14:
        D2(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((h.a) ListProtector.get(this.f108140a.f572585f, r100)).f572596d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r210) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        int r100 = ((h.a) ListProtector.get(this.f108140a.f572585f, r210)).f572596d;
        if (r100 != 0) goto L10;
        TitleViewHolder r101 = (TitleViewHolder) r110;
        TextView r102 = (TextView) r101.f108144a.findViewById(R.id.vs_cache_definition);
        IDefinitionInfo r103 = this.f108140a.f572580a;
        if (r103 == null) goto L7;
        String r104 = r103.getText();
    L8:
        r102.setText(r104);
        r101.f108144a.setOnClickListener(new g(this));
        return;
    L7:
        r104 = null;
        goto L8
    L10:
        if (r100 != 1) goto L197;
        CommonViewHolder r105 = (CommonViewHolder) r110;
        h.a r106 = (h.a) ListProtector.get(this.f108140a.f572585f, r210);
        yk1.a r107 = r106.f572593a;
        if (r107 == null) goto L201;
        tp1.a r108 = r107.f568119a;
        ConstraintLayout r109 = (ConstraintLayout) r105.f108141a.findViewById(R.id.vs_cache_real_container);
        if (r109 == null) goto L16;
        r109.setOnClickListener(new zk1.d(this, r210));
    L16:
        ImageLoader.bindImage((HSImageView) r105.f108141a.findViewById(R.id.vs_cache_cover), r107.f568119a.f547005f);
        Long r111 = r107.f568119a.f547014o.position;
        if (r111 != null) goto L19;
    L36:
        tp1.a r112 = r107.f568119a;
        if (r112 == null) goto L39;
        String r113 = r112.f547001b;
    L40:
        if (r113 != null) goto L42;
    L45:
        boolean r114 = true;
    L46:
        if (r114 == true) goto L48;
        r113 = r113 + " | ";
    L48:
        TextView r115 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_info_title);
        if (r115 == null) goto L51;
        r115.setText(Intrinsics.stringPlus(r113, r107.f568119a.f547002c));
    L51:
        TextView r116 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_delete);
        if (r116 == null) goto L54;
        r116.setOnClickListener(new zk1.e(this, r107, r210));
    L54:
        SwipeMenuLayout r117 = (SwipeMenuLayout) r105.f108141a.findViewById(R.id.vs_cache_item_container);
        if (r117 == null) goto L57;
        r117.setShowListener(new zk1.f(this, r107));
    L57:
        ImageView r118 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r118 == null) goto L60;
        r118.setClickable(false);
    L60:
        int r119 = r108.f547013n.f547020c;
        if (r119 == 0) goto L157;
        if (r119 == 1) goto L156;
        if (r119 == 2) goto L155;
        if (r119 != 3) goto L66;
        z2(r105, r107, r106.f572594b, r210);
        return;
    L66:
        if (r119 != 5) goto L68;
        HashMap r120 = new HashMap();
        if (this.f108140a.f572592m == false) goto L77;
        String r121 = com.bytedance.android.ec.core.event.a.VALUE_PERSONAL_HOMEPAGE;
    L78:
        r120.put("enter_from_merge", r121);
        if (this.f108140a.f572592m == false) goto L81;
        String r122 = "my_download_list";
    L82:
        r120.put("enter_method", r122);
        r120.put("is_vs", "1");
        List<String> r123 = zk1.a.f572567a;
        if (zk1.a.g(r107.f568120b, r107.f568119a.f547006g) == false) goto L85;
        r120.put("vs_watch_record", String.valueOf(zk1.a.j(r107.f568120b, r107.f568119a.f547006g)));
    L85:
        r120.put("vs_episode_type", "formal");
        r120.put("vs_episode_stage", "record");
        r120.put("video_id", r107.f568119a.f547000a);
        r120.put("vs_episode_id", String.valueOf(r107.f568119a.f547011l));
        r120.put("vs_season_id", r107.f568119a.f547004e);
        r120.put("vs_download_status", "download_done");
        com.bytedance.android.livesdk.chatroom.replay.cache.c.c("vs_video_show", r120);
        Group r124 = (Group) r105.f108141a.findViewById(R.id.vs_caching_group);
        if (r124 == null) goto L88;
        r124.setVisibility(8);
    L88:
        Group r125 = (Group) r105.f108141a.findViewById(R.id.vs_cache_group);
        if (r125 == null) goto L91;
        r125.setVisibility(0);
    L91:
        long r126 = r107.f568119a.f547011l;
        h r127 = this.f108140a;
        long r128 = r127.f572584e;
        if (r126 == r128) goto L94;
    L98:
        ImageView r129 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_state_iv);
        if (r129 == null) goto L101;
        r129.setVisibility(8);
    L101:
        RelativeLayout r130 = (RelativeLayout) r105.f108141a.findViewById(R.id.vs_cache_state_container);
        if (r130 == null) goto L104;
        r130.setVisibility(8);
    L104:
        TextView r131 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_text_tag);
        if (r131 == null) goto L107;
        r131.setVisibility(0);
    L107:
        TextView r132 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_size);
        if (r132 == null) goto L111;
        r132.setText(zk1.a.i(r107.f568119a.f547013n.f547019b));
    L111:
        if (zk1.a.g(r107.f568120b, r107.f568119a.f547006g) == true) goto L127;
        TextView r133 = (TextView) r105.f108141a.findViewById(R.id.vs_history);
        if (r133 == null) goto L115;
        r133.setText(null);
    L115:
        ImageView r134 = (ImageView) r105.f108141a.findViewById(R.id.vs_history_phone);
        if (r134 == null) goto L118;
        r134.setImageDrawable(null);
    L118:
        ImageView r135 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r135 == null) goto L121;
        r135.setVisibility(0);
    L121:
        ImageView r136 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r136 == null) goto L124;
        r136.setAlpha(0.5f);
    L124:
        ImageView r137 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r137 == null) goto L150;
        r137.setImageResource(R.drawable.ttlive_ic_vs_cache_play);
    L150:
        if (this.f108140a.f572592m == false) goto L204;
        TextView r138 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_info_title);
        if (r138 == null) goto L205;
        r138.setMaxLines(2);
        return;
    L205:
        return;
    L204:
        return;
    L127:
        ImageView r139 = (ImageView) r105.f108141a.findViewById(R.id.vs_history_phone);
        if (r139 == null) goto L130;
        r139.setVisibility(0);
    L130:
        ImageView r140 = (ImageView) r105.f108141a.findViewById(R.id.vs_history_phone);
        if (r140 != null) goto L133;
    L137:
        int r141 = zk1.a.j(r107.f568120b, r107.f568119a.f547006g);
        TextView r142 = (TextView) r105.f108141a.findViewById(R.id.vs_history);
        if (r142 == null) goto L140;
        StringCompanionObject r143 = StringCompanionObject.INSTANCE;
        String r144 = r105.f108141a.getResources().getString(R.string.ttlive_vs_cache_watch);
        StringBuilder r145 = new StringBuilder();
        r145.append(r141);
        r145.append('%');
        r142.setText(String.format(r144, Arrays.copyOf(new Object[]{r145.toString()}, 1)));
    L140:
        ImageView r146 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r146 == null) goto L143;
        r146.setVisibility(0);
    L143:
        ImageView r147 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r147 == null) goto L146;
        r147.setAlpha(0.5f);
    L146:
        ImageView r148 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r148 == null) goto L150;
        r148.setImageResource(R.drawable.ttlive_ic_vs_cache_play);
        goto L150
    L133:
        if (this.f108140a.f572592m == false) goto L135;
        int r149 = R.drawable.ttlive_ic_vs_host_cache_phone;
    L136:
        r140.setImageResource(r149);
        goto L137
    L135:
        r149 = R.drawable.ttlive_ic_vs_cache_phone;
        goto L136
    L94:
        if (r128 == 0) goto L98;
        if (r127.f572592m == true) goto L98;
        C2(r105);
        goto L104
    L81:
        r122 = "download_list";
        goto L82
    L77:
        r121 = "vs_player_detail";
        goto L78
    L68:
        if (r119 != 6) goto L70;
        z2(r105, r107, r106.f572594b, r210);
        return;
    L70:
        if (r119 != 7) goto L214;
        z2(r105, r107, r106.f572594b, r210);
        return;
    L214:
        return;
    L155:
        z2(r105, r107, r106.f572594b, r210);
        return;
    L156:
        z2(r105, r107, r106.f572594b, r210);
        return;
    L157:
        Group r150 = (Group) r105.f108141a.findViewById(R.id.vs_caching_group);
        if (r150 == null) goto L160;
        r150.setVisibility(8);
    L160:
        Group r151 = (Group) r105.f108141a.findViewById(R.id.vs_cache_group);
        if (r151 == null) goto L163;
        r151.setVisibility(0);
    L163:
        long r152 = r108.f547011l;
        long r153 = this.f108140a.f572584e;
        if (r152 == r153) goto L166;
    L168:
        RelativeLayout r154 = (RelativeLayout) r105.f108141a.findViewById(R.id.vs_cache_state_container);
        if (r154 == null) goto L171;
        r154.setVisibility(8);
    L171:
        TextView r155 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_text_tag);
        if (r155 == null) goto L174;
        r155.setVisibility(4);
    L174:
        TextView r156 = (TextView) r105.f108141a.findViewById(R.id.vs_history);
        if (r156 == null) goto L177;
        r156.setText(null);
    L177:
        ImageView r157 = (ImageView) r105.f108141a.findViewById(R.id.vs_history_phone);
        if (r157 == null) goto L180;
        r157.setImageResource(0);
    L180:
        TextView r158 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_size);
        if (r158 == null) goto L183;
        r158.setText(zk1.a.i(r108.f547013n.f547019b));
    L183:
        ImageView r159 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r159 == null) goto L186;
        r159.setVisibility(0);
    L186:
        ImageView r160 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r160 == null) goto L189;
        r160.setAlpha(1.0f);
    L189:
        ImageView r161 = (ImageView) r105.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r161 == null) goto L193;
        r161.setImageResource(R.drawable.ttlive_ic_vs_cache_download);
    L193:
        if (this.f108140a.f572592m == false) goto L210;
        TextView r162 = (TextView) r105.f108141a.findViewById(R.id.vs_cache_info_title);
        if (r162 == null) goto L211;
        r162.setMaxLines(2);
        return;
    L211:
        return;
    L210:
        return;
    L166:
        if (r153 == 0) goto L168;
        C2(r105);
        goto L171
    L42:
        if (r113.length() == 0) goto L45;
        r114 = false;
        goto L46
    L39:
        r113 = null;
        goto L40
    L19:
        if (r111.longValue() == (-1)) goto L36;
        HSImageView r163 = new HSImageView(r105.f108141a.getContext());
        HSImageView r164 = new HSImageView(r105.f108141a.getContext());
        k r165 = r107.f568119a.f().icon;
        if (r165 == null) goto L25;
        List<String> r166 = r165.getUrls();
        if (r166 == null) goto L25;
        String r167 = (String) ListProtector.get(r166, 0);
    L26:
        if (r167 == null) goto L28;
        ImageUtil.loadImage(r163, r107.f568119a.f().icon, 0);
    L28:
        k r168 = r107.f568119a.d().icon;
        if (r168 == null) goto L33;
        List<String> r169 = r168.getUrls();
        if (r169 == null) goto L33;
        String r170 = (String) ListProtector.get(r169, 0);
    L34:
        if (r170 == null) goto L36;
        ImageUtil.loadImage(r164, r107.f568119a.d().icon, 0);
    L33:
        r170 = null;
    L25:
        r167 = null;
        goto L26
    L201:
        return;
    L197:
        if (r100 != 3) goto L213;
        ((TextView) ((SeasonTitleViewHolder) r110).f108143a.findViewById(R.id.vs_cache_season_title)).setText(((h.a) ListProtector.get(this.f108140a.f572585f, r210)).f572595c);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 0) goto L6;
        return new TitleViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_replay_cache_item_header, r100, false));
    L6:
        if (r101 != 1) goto L13;
        if (this.f108140a.f572592m == false) goto L10;
        int r102 = R.layout.ttlive_replay_cache_item_for_host;
    L18:
        return new CommonViewHolder(LayoutInflater.from(r100.getContext()).inflate(r102, r100, false), this.f108140a.f572592m);
    L10:
        r102 = R.layout.ttlive_replay_cache_item;
        goto L18
    L13:
        if (r101 != 2) goto L16;
        return new FooterViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_replay_cache_item_footer, r100, false));
    L16:
        return new SeasonTitleViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_replay_cache_season_title_item, r100, false));
    }

    public static final void y2(ReplayCacheAdapter r100, String r101, yk1.a r102) {
        r100.getClass();
        HashMap r103 = new HashMap();
        r103.put("enter_from_merge", com.bytedance.android.ec.core.event.a.VALUE_PERSONAL_HOMEPAGE);
        r103.put("enter_method", "my_download_list");
        r103.put("is_vs", "1");
        List<String> r104 = zk1.a.f572567a;
        if (zk1.a.g(r102.f568120b, r102.f568119a.f547006g) == false) goto L5;
        r103.put("vs_watch_record", String.valueOf(zk1.a.j(r102.f568120b, r102.f568119a.f547006g)));
    L5:
        r103.put("vs_download_status", com.bytedance.android.livesdk.chatroom.replay.cache.c.a(r102.f568119a.f547013n.f547020c));
        r103.put("vs_downloadlist_episode_id", String.valueOf(r102.f568119a.f547011l));
        String r105 = r102.f568119a.f547007h;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r103.put("vs_downloadlist_screen_clarity", r105);
        com.bytedance.android.livesdk.chatroom.replay.cache.c.c(r101, r103);
    }

    public final void A2(CommonViewHolder r100, b r101, boolean r102) {
        CacheProgressBar r103 = (CacheProgressBar) r100.f108141a.findViewById(R.id.vs_cache_progress);
        if (r103 == null) goto L5;
        r103.setVisibility(0);
    L5:
        CacheProgressBar r104 = (CacheProgressBar) r100.f108141a.findViewById(R.id.vs_cache_progress);
        if (r104 == null) goto L8;
        r104.f108173c = true;
        r104.invalidate();
    L8:
        CacheProgressBar r105 = (CacheProgressBar) r100.f108141a.findViewById(R.id.vs_cache_progress);
        if (r105 == null) goto L11;
        r105.setProgressRange(r101.f547019b);
    L11:
        CacheProgressBar r106 = (CacheProgressBar) r100.f108141a.findViewById(R.id.vs_cache_progress);
        if (r106 == null) goto L14;
        r106.setCurrentProgress(r101.f547018a);
    L14:
        TextView r107 = (TextView) r100.f108141a.findViewById(R.id.vs_cache_progress_ratio);
        if (r107 == null) goto L17;
        r107.setText(zk1.a.c(r101.f547018a, r101.f547019b));
    L17:
        B2(r100, R.drawable.ttlive_ic_vs_cache_pause, r102);
        TextView r108 = (TextView) r100.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r108 == null) goto L24;
        Resources r109 = r100.f108141a.getContext().getResources();
        if (this.f108140a.f572592m == false) goto L22;
        int r110 = R.color.ttlive_vs_cache_host_download_detail_error_color;
    L23:
        r108.setTextColor(r109.getColor(r110));
        goto L24
    L22:
        r110 = R.color.ttlive_vs_cache_download_detail_error_color;
    L24:
        TextView r111 = (TextView) r100.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r111 == null) goto L28;
        r111.setText(r100.f108141a.getContext().getText(R.string.ttlive_vs_cache_stop));
        return;
    }

    public final void B2(CommonViewHolder r100, int r101, boolean r102) {
        RelativeLayout r103 = (RelativeLayout) r100.f108141a.findViewById(R.id.vs_cache_state_container);
        if (r103 == null) goto L5;
        r103.setVisibility(0);
    L5:
        RelativeLayout r104 = (RelativeLayout) r100.f108141a.findViewById(R.id.vs_cache_state_container);
        if (r104 == null) goto L14;
        if (r102 == false) goto L10;
        int r105 = R.drawable.ttlive_bg_vs_cache_cover_with_frame;
    L13:
        r104.setBackgroundResource(r105);
        goto L14
    L10:
        if (this.f108140a.f572592m == false) goto L12;
        r105 = R.drawable.ttlive_bg_vs_cache_host_cover_bg;
        goto L13
    L12:
        r105 = R.drawable.ttlive_bg_vs_cache_cover_bg;
    L14:
        ImageView r106 = (ImageView) r100.f108141a.findViewById(R.id.vs_cache_state_iv);
        if (r106 == null) goto L17;
        r106.setVisibility(0);
    L17:
        ImageView r107 = (ImageView) r100.f108141a.findViewById(R.id.vs_cache_state_iv);
        if (r107 == null) goto L20;
        r107.setImageResource(r101);
    L20:
        ImageView r108 = (ImageView) r100.f108141a.findViewById(R.id.vs_cache_state_iv);
        if (r108 == null) goto L24;
        r108.setAlpha(0.9f);
    L24:
        if (r102 == false) goto L28;
        D2(r100);
        HSImageView r109 = (HSImageView) r100.f108141a.findViewById(R.id.vs_cache_play_state_iv);
        if (r109 == null) goto L32;
        r109.setVisibility(0);
        return;
    L32:
        return;
    L28:
        HSImageView r110 = (HSImageView) r100.f108141a.findViewById(R.id.vs_cache_play_state_iv);
        if (r110 == null) goto L34;
        r110.setVisibility(8);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if ((!r102.isEmpty()) == true) goto L5;
    L23:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((r100 instanceof CommonViewHolder) == false) goto L23;
        CommonViewHolder r103 = (CommonViewHolder) r100;
        h.a r104 = (h.a) ListProtector.get(this.f108140a.f572585f, r101);
        yk1.a r105 = r104.f572593a;
        if (r105 == null) goto L25;
        b r106 = r105.f568119a.f547013n;
        CacheProgressBar r107 = (CacheProgressBar) r103.f108141a.findViewById(R.id.vs_cache_progress);
        if (r107 == null) goto L11;
        r107.f108173c = false;
        r107.invalidate();
    L11:
        CacheProgressBar r108 = (CacheProgressBar) r103.f108141a.findViewById(R.id.vs_cache_progress);
        if (r108 == null) goto L14;
        r108.setProgressRange(r106.f547019b);
    L14:
        CacheProgressBar r109 = (CacheProgressBar) r103.f108141a.findViewById(R.id.vs_cache_progress);
        if (r109 == null) goto L17;
        r109.setCurrentProgress(r106.f547018a);
    L17:
        TextView r110 = (TextView) r103.f108141a.findViewById(R.id.vs_cache_progress_ratio);
        if (r110 == null) goto L20;
        r110.setText(zk1.a.c(r106.f547018a, r106.f547019b));
    L20:
        TextView r111 = (TextView) r103.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r111 == null) goto L26;
        r111.setText(zk1.a.d(r104.f572594b.f572599a));
        return;
    L26:
        return;
    }

    public final void z2(CommonViewHolder r110, yk1.a r111, h.c r112, int r113) {
        Group r100 = (Group) r110.f108141a.findViewById(R.id.vs_cache_group);
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        Group r101 = (Group) r110.f108141a.findViewById(R.id.vs_caching_group);
        if (r101 == null) goto L8;
        r101.setVisibility(0);
    L8:
        ImageView r102 = (ImageView) r110.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r102 == null) goto L11;
        r102.setAlpha(1.0f);
    L11:
        ImageView r103 = (ImageView) r110.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r103 == null) goto L14;
        r103.setClickable(true);
    L14:
        ImageView r104 = (ImageView) r110.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r104 == null) goto L17;
        r104.setImageResource(R.drawable.ttlive_ic_vs_cache_cancel);
    L17:
        ImageView r105 = (ImageView) r110.f108141a.findViewById(R.id.vs_cache_op_ic);
        if (r105 == null) goto L20;
        r105.setOnClickListener(new a(this, r111, r113));
    L20:
        TextView r114 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_text_tag);
        if (r114 == null) goto L23;
        r114.setVisibility(4);
    L23:
        TextView r115 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_info_title);
        if (r115 == null) goto L26;
        r115.setLines(1);
    L26:
        tp1.a r116 = r111.f568119a;
        b r117 = r116.f547013n;
        long r106 = r116.f547011l;
        long r107 = this.f108140a.f572584e;
        if (r106 == r107) goto L29;
    L31:
        boolean r118 = false;
    L32:
        int r108 = r117.f547020c;
        int r109 = R.color.ttlive_vs_cache_host_sub_content_color;
        if (r108 != 1) goto L35;
        CacheProgressBar r119 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r119 == null) goto L101;
        r119.setVisibility(0);
    L101:
        CacheProgressBar r120 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r120 == null) goto L104;
        r120.f108173c = false;
        r120.invalidate();
    L104:
        CacheProgressBar r121 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r121 == null) goto L107;
        r121.setProgressRange(r117.f547019b);
    L107:
        CacheProgressBar r122 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r122 == null) goto L110;
        r122.setCurrentProgress(r117.f547018a);
    L110:
        TextView r123 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_ratio);
        if (r123 == null) goto L113;
        r123.setText(zk1.a.c(r117.f547018a, r117.f547019b));
    L113:
        B2(r110, R.drawable.ttlive_ic_vs_cache_downloading, r118);
        TextView r124 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r124 == null) goto L120;
        Resources r125 = r110.f108141a.getResources();
        if (this.f108140a.f572592m == true) goto L119;
        r109 = R.color.ttlive_vs_cache_50_white;
    L119:
        r124.setTextColor(r125.getColor(r109));
    L120:
        TextView r126 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r126 == null) goto L131;
        r126.setText(zk1.a.d(r112.f572599a));
        return;
    L131:
        return;
    L35:
        if (r108 != 2) goto L37;
        A2(r110, r117, r118);
        return;
    L37:
        if (r108 != 3) goto L39;
        CacheProgressBar r127 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r127 == null) goto L75;
        r127.setVisibility(0);
    L75:
        CacheProgressBar r128 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r128 == null) goto L78;
        r128.f108173c = true;
        r128.invalidate();
    L78:
        CacheProgressBar r129 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r129 == null) goto L81;
        r129.setProgressRange(r117.f547019b);
    L81:
        CacheProgressBar r130 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r130 == null) goto L84;
        r130.setCurrentProgress(r117.f547018a);
    L84:
        TextView r131 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_ratio);
        if (r131 == null) goto L87;
        r131.setText(zk1.a.c(r117.f547018a, r117.f547019b));
    L87:
        B2(r110, R.drawable.ttlive_ic_vs_cache_loading, r118);
        TextView r132 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r132 == null) goto L94;
        Resources r133 = r110.f108141a.getContext().getResources();
        if (this.f108140a.f572592m == true) goto L93;
        r109 = R.color.ttlive_vs_cache_50_white;
    L93:
        r132.setTextColor(r133.getColor(r109));
    L94:
        TextView r134 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r134 == null) goto L128;
        r134.setText(r110.f108141a.getContext().getResources().getText(R.string.ttlive_vs_cache_waitting));
        return;
    L128:
        return;
    L39:
        if (r108 != 6) goto L41;
        int r135 = r117.f547021d;
        int r136 = xk1.c.f564136a;
        if (r135 != 32) goto L47;
        A2(r110, r117, r118);
        return;
    L47:
        CacheProgressBar r137 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r137 == null) goto L50;
        r137.setVisibility(0);
    L50:
        CacheProgressBar r138 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r138 == null) goto L53;
        r138.f108173c = true;
        r138.invalidate();
    L53:
        CacheProgressBar r139 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r139 == null) goto L56;
        r139.setProgressRange(r117.f547019b);
    L56:
        CacheProgressBar r140 = (CacheProgressBar) r110.f108141a.findViewById(R.id.vs_cache_progress);
        if (r140 == null) goto L59;
        r140.setCurrentProgress(r117.f547018a);
    L59:
        TextView r141 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_ratio);
        if (r141 == null) goto L62;
        r141.setText(zk1.a.c(r117.f547018a, r117.f547019b));
    L62:
        B2(r110, R.drawable.ttlive_ic_vs_cache_error, r118);
        TextView r142 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r142 == null) goto L69;
        Resources r143 = r110.f108141a.getContext().getResources();
        if (this.f108140a.f572592m == false) goto L67;
        int r144 = R.color.ttlive_vs_cache_host_download_detail_error_color;
    L68:
        r142.setTextColor(r143.getColor(r144));
        goto L69
    L67:
        r144 = R.color.ttlive_vs_cache_download_detail_error_color;
    L69:
        TextView r145 = (TextView) r110.f108141a.findViewById(R.id.vs_cache_progress_detail);
        if (r145 == null) goto L126;
        r145.setText(r110.f108141a.getContext().getText(R.string.ttlive_vs_cache_error));
        return;
    L126:
        return;
    L41:
        if (r108 != 7) goto L132;
        A2(r110, r117, r118);
        return;
    L132:
        return;
    L29:
        if (r107 == 0) goto L31;
        r118 = true;
        goto L32
    }
}
