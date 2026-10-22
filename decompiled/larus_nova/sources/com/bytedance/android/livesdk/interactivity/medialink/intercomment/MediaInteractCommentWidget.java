package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.e80;
import com.bytedance.android.livesdk.config.u51;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/MediaInteractCommentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaInteractCommentWidget extends LiveWidget implements com.bytedance.android.livesdk.interactivity.medialink.intercomment.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f138186p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaInteractCommentDataContext f138187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f138188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoomContext f138189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f138190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public hy.e f138191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f138192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f138193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f138194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f138195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f138196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f138197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f138198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f138199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f138200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<ViewGroup> f138201o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentWidget f138202a;

        public b(MediaInteractCommentWidget r100) {
            this.f138202a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MediaInteractCommentWidget.wq(this.f138202a);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentWidget f138203a;

        public c(MediaInteractCommentWidget r100) {
            this.f138203a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            MediaInteractCommentWidget r102 = this.f138203a;
            int r103 = MediaInteractCommentWidget.f138186p;
            r102.Bq();
        }
    }

    static {
    }

    public MediaInteractCommentWidget() {
        throw null;
    }

    public final void Bq() {
        Integer r100 = null;
        boolean r101 = true;
        if (this.f138190d == true) goto L5;
    L26:
        boolean r102 = false;
    L28:
        if (this.f138190d == false) goto L30;
    L52:
        boolean r103 = false;
    L53:
        ViewGroup r104 = yq();
        if (r102 == true) goto L56;
        if (r103 == false) goto L69;
        if (r104 == null) goto L71;
        this.f138193g.c(false);
        if (r104.getVisibility() == 0) goto L71;
        r104.setVisibility(0);
    L71:
        MediaInteractCommentDataContext r105 = this.f138187a;
        if (r105 == null) goto L81;
        MutableLiveData<Boolean> r106 = r105.getShowInterCommentIcon();
        if (r106 == null) goto L82;
        if (r102 == true) goto L79;
        if (r103 == true) goto L79;
        r101 = false;
    L79:
        r106.setValue(Boolean.valueOf(r101));
        return;
    L82:
        return;
    L81:
        return;
    L69:
        if (r104 == null) goto L71;
        r104.setVisibility(8);
        goto L71
    L56:
        if (this.f138195i == false) goto L58;
    L60:
        if (r104 == null) goto L71;
        if (r104.getVisibility() == 0) goto L71;
        r104.setVisibility(0);
        goto L71
    L58:
        if (this.f138196j == 0) goto L60;
        this.f138195i = true;
        this.f138193g.c(true);
        goto L60
    L30:
        if (Aq(this.f138199m) == false) goto L52;
        MediaInteractCommentDataContext r107 = this.f138187a;
        if (r107 == null) goto L36;
        LiveData<Integer> r108 = r107.getInterComState();
        if (r108 == null) goto L36;
        r100 = r108.getValue();
    L36:
        if (r100 == null) goto L52;
        if (r100.intValue() != 4) goto L52;
        hy.e r109 = this.f138191e;
        if (r109 == null) goto L45;
        List<AnchorLinkUser> r110 = r109.getOnlineUserList();
        if (r110 == null) goto L45;
        int r111 = r110.size();
    L46:
        if (r111 > 2) goto L52;
        if (Intrinsics.areEqual(e80.f120094a.getValue().commentAudienceStatusSync, Boolean.TRUE) == false) goto L52;
        if (e92.a.a() == true) goto L52;
        r103 = true;
    L45:
        r111 = 0;
        goto L46
    L5:
        if (Aq(this.f138199m) == true) goto L16;
        MediaInteractCommentDataContext r112 = this.f138187a;
        if (r112 == null) goto L11;
        LiveData<Integer> r113 = r112.getInterComState();
        if (r113 == null) goto L11;
        Integer r114 = r113.getValue();
    L12:
        if (r114 == null) goto L26;
        if (r114.intValue() != 4) goto L26;
    L11:
        r114 = null;
    L16:
        hy.e r115 = this.f138191e;
        if (r115 == null) goto L21;
        List<AnchorLinkUser> r116 = r115.getOnlineUserList();
        if (r116 == null) goto L21;
        int r117 = r116.size();
    L22:
        if (r117 > 2) goto L26;
        if (e92.a.a() == true) goto L26;
        r102 = true;
    L21:
        r117 = 0;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.b
    public final boolean a0() {
        MediaInteractCommentDataContext r100 = this.f138187a;
        if (r100 == null) goto L7;
        LiveData<Integer> r101 = r100.getInterComState();
        if (r101 == null) goto L7;
        Integer r102 = r101.getValue();
    L8:
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.intValue() != 4) goto L13;
        return true;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.b
    public final void ao() {
        MediaInteractCommentDataContext r100 = this.f138187a;
        if (r100 == null) goto L7;
        LiveData<Integer> r101 = r100.getInterComState();
        if (r101 == null) goto L7;
        Integer r102 = r101.getValue();
    L8:
        int r103 = R.drawable.ttlive_inter_com_state_icon;
        if (r102 != null) goto L12;
    L20:
        if (r102 != null) goto L23;
    L31:
        Bq();
        return;
    L23:
        if (r102.intValue() != 0) goto L31;
        MediaInteractCommentView r104 = zq();
        if (r104 == null) goto L31;
        boolean r105 = !this.f138190d;
        HSImageView r106 = (HSImageView) r104.a(R.id.media_inter_comment_icon);
        if (r105 == true) goto L30;
        r103 = R.drawable.ttlive_inter_com_close_icon;
    L30:
        ImageLoader.bindDrawableResource(r106, r103);
        goto L31
    L12:
        if (r102.intValue() != 4) goto L20;
        MediaInteractCommentView r107 = zq();
        if (r107 == null) goto L31;
        boolean r108 = !this.f138190d;
        HSImageView r109 = (HSImageView) r107.a(R.id.media_inter_comment_icon);
        if (r108 == true) goto L19;
        r103 = R.drawable.ttlive_inter_com_open_icon;
    L19:
        ImageLoader.bindDrawableResource(r109, r103);
    L7:
        r102 = null;
        goto L8
    }

    public final ViewGroup yq() {
        ViewGroup r100 = this.f138200n;
        if (r100 != null) goto L9;
        Function0<ViewGroup> r101 = this.f138201o;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.invoke();
    L9:
        return r100;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        Pair r100 = com.bytedance.live.datacontext.d.a(new MediaInteractCommentWidget$onCreate$dataPair$1(this));
        this.f138187a = (MediaInteractCommentDataContext) r100.getFirst();
        com.bytedance.live.datacontext.b.a((DataContext) r100.getFirst(), MediaInteractCommentDataContext.TAG);
        ((MediaInteractCommentDataContext) r100.getFirst()).getService().d(this);
        this.f138188b.add((Disposable) r100.getSecond());
        if (this.f138199m != 17) goto L11;
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r101 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r101 == null) goto L7;
        hy.e r102 = r101.Np();
    L8:
        this.f138191e = r102;
        if (r102 == null) goto L11;
        r102.i(this.f138197k);
        goto L11
    L7:
        r102 = null;
    L11:
        MediaInteractCommentDataContext r103 = this.f138187a;
        if (r103 == null) goto L16;
        LiveData<Integer> r104 = r103.getInterComState();
        if (r104 == null) goto L16;
        r104.observeForever(this.f138198l);
    L16:
        Bq();
        MediaInteractCommentDataContext r105 = this.f138187a;
        if (r105 == null) goto L25;
        com.bytedance.live.datacontext.k<Object> r106 = r105.getOnIconClickEvent();
        if (r106 == null) goto L25;
        PublishSubject r107 = r106.onEvent();
        if (r107 == null) goto L25;
        Disposable r108 = r107.subscribe(new b(this));
        if (r108 == null) goto L25;
        this.f138188b.add(r108);
    L25:
        ViewGroup r109 = yq();
        if (r109 == null) goto L28;
        r109.setOnClickListener(x0.a(new AnonymousClass3(this)));
    L28:
        u51 r110 = e80.f120094a.getValue();
        Boolean r111 = r110.commentIntroEnable;
        Boolean r112 = Boolean.TRUE;
        int r113 = 1;
        if (Intrinsics.areEqual(r111, r112) == false) goto L37;
        Integer r114 = r110.commentIntroVersion;
        if (r114 == null) goto L33;
        int r115 = r114.intValue();
    L35:
        if (r115 <= com.bytedance.android.livesdk.sharedpref.b.f158121a3.getValue().intValue()) goto L37;
        boolean r116 = true;
    L38:
        if (r116 == false) goto L46;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r117 = com.bytedance.android.livesdk.sharedpref.b.f158126b3;
        if (r117.getValue().booleanValue() == true) goto L42;
        com.bytedance.android.livesdk.sharedpref.f.d(r117, r112);
    L42:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r118 = com.bytedance.android.livesdk.sharedpref.b.f158121a3;
        Integer r119 = r110.commentIntroVersion;
        if (r119 == null) goto L45;
        r113 = r119.intValue();
    L45:
        Integer r120 = Integer.valueOf(r113);
        r118.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r118, r120);
    L46:
        RoomContext r121 = this.f138189c;
        if (r121 == null) goto L56;
        com.bytedance.live.datacontext.m<Integer> r122 = r121.getCleanMode();
        if (r122 == null) goto L56;
        Observable<Integer> r123 = r122.a();
        if (r123 == null) goto L56;
        Disposable r124 = r123.subscribe(new c(this));
        if (r124 == null) goto L56;
        RxUtilKt.c(r124, this.f138188b);
    L56:
        if (this.f138190d == true) goto L59;
        u.l().addSendLogFilter(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.interactivity.medialink.intercomment.c.class), com.bytedance.android.livesdk.interactivity.medialink.intercomment.c.f138204a);
        return;
    L59:
        return;
    L33:
        r115 = 1;
    L37:
        r116 = false;
        goto L38
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        ViewGroup r100 = yq();
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f138188b.dispose();
        MediaInteractCommentDataContext r101 = this.f138187a;
        if (r101 == null) goto L10;
        LiveData<Integer> r102 = r101.getInterComState();
        if (r102 == null) goto L10;
        r102.removeObserver(this.f138198l);
    L10:
        hy.e r103 = this.f138191e;
        if (r103 == null) goto L14;
        r103.h(this.f138197k);
    L14:
        if (this.f138190d == true) goto L17;
        u.l().removeSendLogFilter(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.interactivity.medialink.intercomment.c.class));
        return;
    }

    public final MediaInteractCommentView zq() {
        ViewGroup r100 = yq();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (MediaInteractCommentView) r100.findViewById(R.id.inter_comment_icon_view);
    }

    public MediaInteractCommentWidget(Function0 r100) {
        this.f138199m = 17;
        DataContext r101 = null;
        this.f138200n = null;
        this.f138201o = r100;
        this.f138188b = new CompositeDisposable();
        DataContext r102 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r102 instanceof RoomContext) == false) goto L6;
        r101 = r102;
    L6:
        RoomContext r103 = (RoomContext) r101;
        this.f138189c = r103;
        if (r103 == null) goto L13;
        com.bytedance.live.datacontext.i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L13;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L13;
        boolean r106 = r105.booleanValue();
    L14:
        this.f138190d = r106;
        this.f138193g = new d();
        this.f138197k = new j(this);
        this.f138198l = new k(this);
        return;
    L13:
        r106 = false;
        goto L14
    }

    public static final void wq(MediaInteractCommentWidget r100) {
        MediaInteractCommentDataContext r101 = r100.f138187a;
        if (r101 == null) goto L8;
        LiveData<Integer> r102 = r101.getInterComState();
        if (r102 == null) goto L8;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L8;
    L9:
        int r104 = r103.intValue();
        if (r100.f138190d == true) goto L15;
        if (r104 != 4) goto L13;
        f2.b(R.string.ttlive_media_inter_comment_click_audience, 0);
    L13:
        r100.f138193g.getClass();
        d.b(r104, false);
        return;
    L15:
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L35;
        f2.b(R.string.ttlive_media_inter_comment_click_when_inviting, 0);
    L50:
        if (r100.f138190d == false) goto L57;
        r100.f138193g.getClass();
        d.b(r104, true);
        return;
    L57:
        return;
    L35:
        if (r104 != 4) goto L50;
        z0 r105 = z0.a();
        Context r106 = r100.getContext();
        r105.getClass();
        com.bytedance.android.livesdk.widget.x0.b r107 = new com.bytedance.android.livesdk.widget.x0.b(r106, 4);
        r107.m(R.string.ttlive_media_inter_comment_close_confirm_title);
        if (r100.f138192f < 3) goto L39;
    L47:
        int r108 = R.string.ttlive_media_inter_comment_close_confirm_message2;
    L48:
        r107.l(r108);
        r107.i(0, R.string.ttlive_ok, new l(r100));
        r107.i(1, R.string.ttlive_cancel, m.f138211a);
        r107.n();
        goto L50
    L39:
        if (System.currentTimeMillis() > r100.f138194h) goto L41;
    L43:
        boolean r109 = false;
    L44:
        if (r109 == true) goto L47;
        r108 = R.string.ttlive_media_inter_comment_close_confirm_message1;
        goto L48
    L41:
        if ((System.currentTimeMillis() - r100.f138194h) > 30000) goto L43;
        r109 = true;
        goto L44
    L17:
        if (com.bytedance.android.livesdk.sharedpref.b.f158126b3.getValue().booleanValue() == false) goto L24;
        MediaInteractCommentInviteDialog r110 = new MediaInteractCommentInviteDialog(r100.context, new o(r100));
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r110);
    L29:
        MediaInteractCommentView r111 = r100.zq();
        if (r111 == null) goto L32;
        r111.a(R.id.media_guide_dot).setVisibility(8);
    L32:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r112 = com.bytedance.android.livesdk.sharedpref.b.Z2;
        r112.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r112, 2);
        goto L50
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L22:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L29
    L24:
        if (r100.f138190d == false) goto L26;
        r100.f138193g.getClass();
        d.e(false, false);
    L26:
        MediaInteractCommentDataContext r113 = r100.f138187a;
        if (r113 == null) goto L29;
        r113.invite();
    L8:
        r103 = 0;
        goto L9
    }

    public static final void xq(MediaInteractCommentWidget r100) {
        r100.getClass();
        String r101 = e80.f120094a.getValue().commentIntroLynxUrl;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        ((ILiveActionHandler) jc1.k.n(ILiveActionHandler.class)).handle(r100.context, r101);
        return;
    }

    public final boolean Aq(int r100) {
        if (r100 != 17) goto L18;
        RoomContext r101 = this.f138189c;
        if (r101 == null) goto L18;
        com.bytedance.live.datacontext.m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L18;
        Room r103 = r102.getValue();
        if (r103 == null) goto L18;
        Map<String, String> r104 = r103.anchorAbMap;
        if (r104 == null) goto L18;
        if (r104.containsKey("chat_intercommunicate_multi_anchor") == true) goto L16;
        r104 = null;
    L16:
        if (r104 == null) goto L18;
        return Intrinsics.areEqual(r104.get("chat_intercommunicate_multi_anchor"), "2");
    L18:
        return false;
    }
}
