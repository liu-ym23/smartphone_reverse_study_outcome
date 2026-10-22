package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.f4;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.p1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.ReplayMessageTracer;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.dto.ShowChatResponse;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.repo.CommentApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView;
import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.e1;
import com.bytedance.android.livesdk.utils.l1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import fq1.j;
import fq1.t;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ku2.e;
import org.json.JSONObject;
import py.g;
import vh7.f;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayCommentPresenter extends lq1.a<IView> implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f108846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Episode f108847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f108848f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/comment/ReplayCommentPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/view/IReplayWidgetView;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IReplayWidgetView {
        void M3();

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView
        /* synthetic */ Context getContext();

        Context getViewContext();

        void h8(Exception r100);

        void x80(q5 r100);
    }

    public static final class a implements Observer<Response<ShowChatResponse>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayCommentPresenter f108849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SendReplayTextEvent f108850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f108851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f108852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f108853e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f108854f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f108855g;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            r.f().y(this.f108850b, false);
            ReplayCommentPresenter r101 = this.f108849a;
            r101.f108846d = true;
            if (((IView) r101.f510284a) != null) goto L6;
            return;
        L6:
            if ((r100 instanceof Exception) == false) goto L11;
            ReplayMessageTracer.a("send commend failed due to " + r100.getMessage());
            IView r102 = (IView) this.f108849a.f510284a;
            if (r102 == null) goto L12;
            r102.h8((Exception) r100);
            return;
        L12:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public final void onNext(Response<ShowChatResponse> r210) {
            Response<ShowChatResponse> r100 = r210;
            Intrinsics.checkNotNullParameter(r100, "r");
            r.f().y(this.f108850b, true);
            this.f108849a.f108846d = true;
            int r101 = ReplayCommentStatisticLog.f108856a;
            long r110 = r100.data.getMsgId();
            if (((Long) this.f108851c.element) == null) goto L5;
            boolean r102 = true;
        L6:
            boolean r111 = this.f108852d;
            boolean r112 = this.f108853e.element;
            String r113 = this.f108854f;
            String r114 = (String) this.f108855g.element;
            boolean r115 = l1.a(this.f108850b.f118382a);
            String r103 = this.f108850b.f118382a;
            int r104 = r103.length();
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L12;
            if (l1.b(r103.charAt(r105)) == true) goto L10;
            r105 = r105 + 1;
            goto L7
        L10:
            boolean r116 = true;
        L13:
            b r106 = new b(r110, r102, r111, r112, r113, r114, r115, r116);
            DataCenter r107 = this.f108849a.f510285b;
            Intrinsics.checkNotNullParameter(r106, "data");
            String r108 = "";
            if (r107 == null) goto L50;
            HashMap r109 = ReplayCommentStatisticLog.a(r107);
            Pair[] r117 = new Pair[11];
            r117[0] = TuplesKt.to("comment_id", String.valueOf(r110));
            String r118 = "1";
            if (r102 == false) goto L19;
            Object r119 = "1";
        L20:
            r117[1] = TuplesKt.to("is_vs_comment_plus1", r119);
            if (r111 == false) goto L23;
            Object r120 = "1";
        L24:
            r117[2] = TuplesKt.to("vs_is_emoji", r120);
            r117[3] = TuplesKt.to("vs_comment_colour", r113);
            r117[4] = TuplesKt.to("vs_comment_plus1_type", r114);
            if (r112 == false) goto L27;
            Object r121 = "1";
        L28:
            r117[5] = TuplesKt.to("is_from_welcome_comment", r121);
            if (TextUtils.equals("", ScoreTags.SCORE_TYPE_STAR) == false) goto L31;
            Object r122 = "1";
        L32:
            r117[6] = TuplesKt.to("vs_is_star_comment", r122);
            r117[7] = TuplesKt.to("has_gif_emoji", "0");
            if (r115 == false) goto L35;
            Object r123 = "1";
        L36:
            r117[8] = TuplesKt.to("has_system_emoji", r123);
            if (r116 == true) goto L40;
            r118 = "0";
        L40:
            r117[9] = TuplesKt.to("has_keyboard_emoji", r118);
            r117[10] = TuplesKt.to("vs_comment_type", "");
            Map r124 = MapsKt.mutableMapOf(r117);
            LinkedHashMap r125 = new LinkedHashMap();
            Iterator r126 = r124.entrySet().iterator();
        L42:
            if (r126.hasNext() == false) goto L49;
            Map.Entry r127 = (Map.Entry) r126.next();
            if (r127.getValue() == null) goto L46;
            boolean r128 = true;
        L47:
            if (r128 == false) goto L42;
            r125.put(r127.getKey(), r127.getValue());
            goto L42
        L46:
            r128 = false;
            goto L47
        L49:
            r109.putAll(new HashMap(r125));
            d.a(r107).d("comment", r109, new Object[0]);
            goto L50
        L35:
            r123 = "0";
            goto L36
        L31:
            r122 = "0";
            goto L32
        L27:
            r121 = "0";
            goto L28
        L23:
            r120 = "0";
            goto L24
        L19:
            r119 = "0";
        L50:
            int r129 = e1.f158934a;
            DataCenter r130 = this.f108849a.f510285b;
            if (r130 == null) goto L62;
            if (((Boolean) r130.get("enter_from_dou_plus", Boolean.FALSE)).booleanValue() == false) goto L62;
            Map<String, String> r131 = c1.e(r130);
            r131.put("event_type", "vs_video_native_action");
            r131.remove("refer");
            JSONObject r132 = e1.a(r130);
            if (r132 == null) goto L62;
            ILiveDouPlusService r133 = (ILiveDouPlusService) k.f(ILiveDouPlusService.class);
            if (r133 == null) goto L62;
            r131.put("ad_extra_data", String.valueOf(r132));
            r133.logEvent(true, "vs_ad", "comment", r131);
        L62:
            if (((IView) this.f108849a.f510284a) == null) goto L168;
            ShowChatResponse r134 = r100.data;
            IBaseUser r135 = t.a().b();
            if (r135 == null) goto L166;
            Episode r136 = this.f108849a.f108847e;
            IBaseUser r137 = r134.getUser();
            Long r138 = (Long) this.f108851c.element;
            q5 r139 = xq1.b.b().i();
            m0 r140 = (m0) f.c(m0.class);
            long r141 = 0;
            if (r136 == null) goto L69;
            long r142 = r136.roomId;
        L70:
            r140.setRoomId(r142);
            r140.setMessageId(r134.getMsgId());
            r140.setShowMsg(true);
            String r143 = r139.getMessageMethod();
            Intrinsics.checkNotNull(r143);
            r140.setMethod(r143);
            a5 r144 = r134.getDisplayText();
            if (r144 == null) goto L73;
            r140.setDisplayText(r144);
        L73:
            r139.setBaseMessage(r140);
            a5 r145 = r134.getDisplayText();
            py.k r146 = null;
            if (r145 != null) goto L76;
        L103:
            IBaseUser r147 = null;
        L104:
            r139.setBackground(r134.getBackground());
            r139.setContent(r134.getContent());
            if (r147 == null) goto L107;
            r139.setUserInfo(r147);
        L110:
            List<String> r148 = r134.getColorValueForDamu();
            if (r148 == null) goto L113;
            r139.K1(r148);
        L113:
            p1 r149 = r134.getLandscapeAreaCommon();
            if (r149 == null) goto L116;
            r139.f1(r149);
        L116:
            r139.setSelfSendFake(true);
            r139.setMsgId(String.valueOf(r134.getMsgId()));
            if (r138 == null) goto L119;
            long r150 = r138.longValue();
        L120:
            r139.c1(r150);
            if (r136 == null) goto L123;
            r141 = r136.getId();
        L123:
            r139.setEpisodeId(r141);
            r139.R0(xq1.b.b().j());
            VSShowChatMessageCommentRoleConfig r151 = r139.G0();
            if (r151 == null) goto L129;
            g r152 = r134.getCommentRoleConfig();
            if (r152 == null) goto L128;
            r146 = r152.getCharactorAvatarExt();
        L128:
            r151.setCharacterAvatar(r146);
        L129:
            VSShowChatMessageCommentRoleConfig r153 = r139.G0();
            if (r153 == null) goto L138;
            g r154 = r134.getCommentRoleConfig();
            if (r154 == null) goto L137;
            String r155 = r154.getCharactorName();
            if (r155 == null) goto L137;
            r108 = r155;
        L137:
            r153.setCharacterName(r108);
        L138:
            VSShowChatMessageCommentRoleConfig r156 = r139.G0();
            if (r156 == null) goto L147;
            g r157 = r134.getCommentRoleConfig();
            if (r157 == null) goto L145;
            Long r158 = r157.getRoleId();
            if (r158 == null) goto L145;
            long r159 = r158.longValue();
        L146:
            r156.setId(r159);
        L145:
            r159 = -1;
        L147:
            r139.w1(r134.convertShowCommentEffectType());
            r139.setMsgId(String.valueOf(r134.getMsgId()));
            ReplayMessageTracer.a("send commend success}");
            IView r160 = (IView) this.f108849a.f510284a;
            if (r160 == null) goto L167;
            r160.x80(r139);
            return;
        L167:
            return;
        L119:
            r150 = r134.getMsgId();
            goto L120
        L107:
            if (r137 == null) goto L109;
            r139.setUserInfo(r137);
            goto L110
        L109:
            r139.setUserInfo(r135);
            goto L110
        L76:
            if (CollectionUtils.isEmpty(r145.getPieces()) == true) goto L103;
            List<c5> r161 = r145.getPieces();
            Intrinsics.checkNotNull(r161);
            Iterator<c5> r162 = r161.iterator();
        L79:
            if (r162.hasNext() == false) goto L103;
            c5 r163 = r162.next();
            if (TextUtils.isEmpty(r135.getIdString()) == true) goto L91;
            i5 r164 = r163.getUserValue();
            if (r164 == null) goto L87;
            IBaseUser r165 = r164.getUser();
            if (r165 == null) goto L87;
            String r166 = r165.getIdString();
        L89:
            if (TextUtils.equals(r166, r135.getIdString()) == false) goto L91;
            boolean r167 = true;
        L93:
            if (r163.getUserValue() == null) goto L79;
            i5 r168 = r163.getUserValue();
            if (r168 == null) goto L97;
            IBaseUser r169 = r168.getUser();
        L98:
            if (r169 == null) goto L79;
            if (r167 == false) goto L79;
            i5 r170 = r163.getUserValue();
            if (r170 == null) goto L103;
            r147 = r170.getUser();
            goto L104
        L97:
            r169 = null;
        L87:
            r166 = null;
        L91:
            r167 = false;
            goto L93
        L69:
            r142 = 0;
            goto L70
        L166:
            return;
        L168:
            return;
        L12:
            r116 = false;
            goto L13
        L5:
            r102 = false;
            goto L6
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            CompositeDisposable r101 = this.f108849a.f108848f;
            if (r101 == null) goto L6;
            r101.add(r100);
            return;
        }

        public a(ReplayCommentPresenter r100, SendReplayTextEvent r101, Ref.ObjectRef r102, boolean r103, Ref.BooleanRef r104, String r105, Ref.ObjectRef r106) {
            this.f108849a = r100;
            this.f108850b = r101;
            this.f108851c = r102;
            this.f108852d = r103;
            this.f108853e = r104;
            this.f108854f = r105;
            this.f108855g = r106;
        }
    }

    public ReplayCommentPresenter() {
        this.f108846d = true;
    }

    @Override // lq1.a
    public final void f() {
        super.f();
        CompositeDisposable r100 = this.f108848f;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.dispose();
    L5:
        this.f108847e = null;
        this.f108848f = null;
    }

    public final void g(IView r100) {
        Intrinsics.checkNotNullParameter(r100, "iView");
        e(r100);
        DataCenter r101 = this.f510285b;
        if (r101 == null) goto L5;
        Episode r102 = h.a(r101);
    L6:
        this.f108847e = r102;
        this.f108846d = true;
        vlc.d r103 = this.f510286c;
        if (r103 == null) goto L9;
        ku2.d r104 = e.f506189a;
        r103.addMessageListener(xq1.b.a(e.f506190b), this);
    L9:
        CompositeDisposable r105 = this.f108848f;
        if (r105 == null) goto L12;
        r105.dispose();
    L12:
        this.f108848f = new CompositeDisposable();
        Disposable r106 = r.f().s(new ReplayCommentPresenter$attachView$1(this));
        if (r106 == null) goto L18;
        CompositeDisposable r107 = this.f108848f;
        if (r107 == null) goto L19;
        r107.add(r106);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v71, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v74, types: [T, java.lang.Long] */
    public final void h(SendReplayTextEvent r210) {
        Episode r100 = this.f108847e;
        Integer r101 = 0;
        if (this.f108848f != null) goto L5;
    L92:
        r.f().y(r210, false);
        return;
    L5:
        if (TextUtils.isEmpty(r210.f118382a) == true) goto L92;
        if (this.f108846d == false) goto L92;
        if (r100 == null) goto L92;
        SendReplayTextEvent.Sender r102 = r210.f118383b;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = null;
        Ref.BooleanRef r105 = new Ref.BooleanRef();
        r105.element = false;
        SendReplayTextEvent.Sender r110 = SendReplayTextEvent.Sender.VsPlusOne;
        if (r102 != r110) goto L19;
        if ((r210.f118384c.get("agreeIdLong") instanceof Long) == false) goto L16;
        r103.element = (Long) r210.f118384c.get("agreeIdLong");
    L16:
        if ((r210.f118384c.get("plus_one_comment_type") instanceof String) == false) goto L19;
        r104.element = (String) r210.f118384c.get("plus_one_comment_type");
    L19:
        if ((r210.f118384c.get("vs_welcome_comment") instanceof Boolean) == false) goto L25;
        Object r106 = r210.f118384c.get("vs_welcome_comment");
        if (r106 == null) goto L24;
        r105.element = ((Boolean) r106).booleanValue();
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L25:
        this.f108846d = false;
        if ((r210.f118384c.get("liveEmojiCountInt") instanceof Integer) == false) goto L34;
        Object r107 = r210.f118384c.get("liveEmojiCountInt");
        if (r107 == null) goto L33;
        if (((Integer) r107).intValue() <= 0) goto L34;
        boolean r111 = true;
    L35:
        long r112 = r100.getId();
        int r108 = EpisodeMod.EpisodeStageType.REPLAY;
        long r113 = com.bytedance.android.livesdk.chatroom.replay.util.f.a(this.f510285b);
        EpisodeBasicInfo r109 = r100.episodeBasicInfo;
        if (r109 == null) goto L38;
        Long r114 = Long.valueOf(r109.getGroupId());
    L40:
        if (r210.f118383b != r110) goto L42;
        String r115 = "ffffff";
    L46:
        Integer r116 = Integer.valueOf(r108);
        String r117 = r210.f118382a;
        Long r118 = Long.valueOf(r113);
        Long r119 = 0L;
        Long r120 = (Long) r103.element;
        Intrinsics.checkNotNullParameter(r117, "content");
        Pair[] r121 = new Pair[9];
        r121[0] = TuplesKt.to("episode_id", String.valueOf(r112));
        if (r116 == null) goto L49;
        String r122 = String.valueOf(r116.intValue());
    L50:
        r121[1] = TuplesKt.to("elapsed_stage", r122);
        r121[2] = TuplesKt.to("content", r117);
        if (r118 == null) goto L53;
        String r123 = String.valueOf(r118.longValue());
    L54:
        r121[3] = TuplesKt.to(LocationMonitorConst.BPEA_CHECK_DURATION, r123);
        if (r119 == null) goto L57;
        String r124 = String.valueOf(r119.longValue());
    L58:
        r121[4] = TuplesKt.to("flow_time", r124);
        if (r120 == null) goto L61;
        String r125 = String.valueOf(r120.longValue());
    L62:
        r121[5] = TuplesKt.to("agree_msg_id", r125);
        r121[6] = TuplesKt.to("color_value", r115);
        if (r101 == null) goto L65;
        String r126 = String.valueOf(r101.intValue());
    L66:
        r121[7] = TuplesKt.to("effect_type", r126);
        if (r101 == null) goto L69;
        String r127 = String.valueOf(r101.intValue());
    L70:
        r121[8] = TuplesKt.to("vs_message_type", r127);
        Map r128 = MapsKt.mapOf(r121);
        LinkedHashMap r129 = new LinkedHashMap();
        Iterator r130 = r128.entrySet().iterator();
    L72:
        if (r130.hasNext() == false) goto L79;
        Map.Entry r131 = (Map.Entry) r130.next();
        if (r131.getValue() == null) goto L76;
        boolean r132 = true;
    L77:
        if (r132 == false) goto L72;
        r129.put(r131.getKey(), r131.getValue());
        goto L72
    L76:
        r132 = false;
        goto L77
    L79:
        HashMap r133 = new HashMap(r129);
        if (r114 == null) goto L90;
        r114.longValue();
        if (r114.longValue() == 0) goto L84;
        boolean r134 = true;
    L85:
        if (r134 == true) goto L88;
        r114 = null;
    L88:
        if (r114 == null) goto L90;
        r133.put("group_id", String.valueOf(r114.longValue()));
        goto L90
    L84:
        r134 = false;
    L90:
        int r135 = ReplayMessageTracer.f108844a;
        Intrinsics.checkNotNullParameter("send vs comment", "info");
        Intrinsics.checkNotNullParameter(r133, "params");
        HashMap r136 = new HashMap();
        r136.putAll(r133);
        r136.put("info", "send vs comment");
        fq1.r.a().c("VSMessage_" + ReplayMessageTracer.SubTag.Comment.getTag(), r136);
        ((CommentApi) r.n().getService(CommentApi.class)).sendVSTextMessage(r133).compose(RxUtil.rxSchedulerHelper()).subscribe(new wl1.b(j.a().b0(), new a(this, r210, r103, r111, r105, r115, r104)));
        return;
    L69:
        r127 = null;
        goto L70
    L65:
        r126 = null;
        goto L66
    L61:
        r125 = null;
        goto L62
    L57:
        r124 = null;
        goto L58
    L53:
        r123 = null;
        goto L54
    L49:
        r122 = null;
        goto L50
    L42:
        Object r137 = r210.f118384c.get("color_values");
        if ((r137 instanceof String) == true) goto L45;
        r137 = null;
    L45:
        r115 = (String) r137;
        goto L46
    L38:
        r114 = null;
        goto L40
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L34:
        r111 = false;
        goto L35
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (this.f510284a == 0) goto L36;
        if (r100 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100.getMessageMethod(), xq1.b.a(e.f506190b)) == true) goto L9;
        return;
    L9:
        if ((r100 instanceof f4) == false) goto L38;
        Episode r101 = this.f108847e;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.getRoomAuthStatus() == null) goto L45;
        f4 r102 = (f4) r100;
        int r103 = r102.C();
        r102.y();
        if (r103 != 3) goto L25;
        Episode r104 = this.f108847e;
        if (r104 == null) goto L22;
        IRoomAuthStatus r105 = r104.getRoomAuthStatus();
        if (r105 == null) goto L22;
        r105.setEnableChat(false);
    L22:
        IView r106 = (IView) this.f510284a;
        if (r106 == null) goto L40;
        r106.M3();
        return;
    L40:
        return;
    L25:
        r102.B();
        if (r103 != 4) goto L42;
        Episode r107 = this.f108847e;
        if (r107 == null) goto L32;
        IRoomAuthStatus r108 = r107.getRoomAuthStatus();
        if (r108 == null) goto L32;
        r108.setEnableChat(true);
    L32:
        IView r109 = (IView) this.f510284a;
        if (r109 == null) goto L43;
        r109.M3();
        return;
    L43:
        return;
    L42:
        return;
    L45:
        return;
    L38:
        return;
    }
}
