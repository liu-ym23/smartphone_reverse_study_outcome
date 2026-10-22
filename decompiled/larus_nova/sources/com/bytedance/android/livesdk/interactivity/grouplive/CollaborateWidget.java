package com.bytedance.android.livesdk.interactivity.grouplive;

import am2.x;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.data.c;
import com.bytedance.android.live.base.model.message.i0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomCacheManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.jz;
import com.bytedance.android.livesdk.config.kz;
import com.bytedance.android.livesdk.config.yh0;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ICloudCollaborateData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/grouplive/CollaborateWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollaborateWidget extends RoomRecyclableWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f136879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f136880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f136881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f136882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f136883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f136884f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICloudCollaborateData f136885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f136886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Room f136887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CollaborateWidget f136888d;

        public b(ICloudCollaborateData r100, Map r101, Room r102, CollaborateWidget r103) {
            this.f136885a = r100;
            this.f136886b = r101;
            this.f136887c = r102;
            this.f136888d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            if (r111 == null) goto L11;
            if (r111.longValue() != 0) goto L11;
            ViewGroup r100 = this.f136888d.containerView;
            if (r100 == null) goto L11;
            UtilityKotlinExtentionsKt.z(r100, true);
        L11:
            if (((this.f136885a.getJumpCollaborateRoomTime() - r111.longValue()) - 1) <= 0) goto L15;
            TextView r101 = this.f136888d.f136879a;
            if (r101 == null) goto L17;
            r101.setText(String.valueOf((this.f136885a.getJumpCollaborateRoomTime() - r111.longValue()) - 1));
            return;
        L17:
            return;
        L15:
            CollaborateWidget.xq(this.f136888d, this.f136885a.getCollaborateRoomId(), this.f136886b, this.f136887c.getOwnerUserIdString(), Long.valueOf(this.f136887c.f162599id), true, EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_ENTER_ROOM, false, 64);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_collaborate_jump_count_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        f.d(this);
        o r100 = z51.a.h(this.dataCenter, 2);
        if (r100 == null) goto L9;
        j<d> r101 = r100.getMessageManager();
        if (r101 == null) goto L9;
        d r102 = r101.getValue();
        if (r102 == null) goto L9;
        r102.removeMessageListener(this);
    L9:
        Disposable r103 = this.f136881c;
        if (r103 != null) goto L12;
    L16:
        this.f136881c = null;
        Disposable r104 = this.f136882d;
        if (r104 != null) goto L19;
    L23:
        this.f136882d = null;
        if (this.f136883e == true) goto L28;
        IGroupLiveService r105 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r105 == null) goto L29;
        r105.setAnchorIdBeforeJump("");
        r105.setRoomIdBeforeJump(0);
        r105.setRequestIdBeforeJump("");
    L29:
        ViewGroup r106 = this.containerView;
        if (r106 == null) goto L33;
        UtilityKotlinExtentionsKt.z(r106, false);
        return;
    L33:
        return;
    L28:
        this.f136883e = false;
        goto L29
    L19:
        if (r104.isDisposed() == true) goto L23;
        Disposable r107 = this.f136882d;
        if (r107 == null) goto L23;
        r107.dispose();
        goto L23
    L12:
        if (r103.isDisposed() == true) goto L16;
        Disposable r108 = this.f136881c;
        if (r108 == null) goto L16;
        r108.dispose();
        goto L16
    }

    public CollaborateWidget() {
    }

    public static boolean wq(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        if ((!Intrinsics.areEqual(r100, "0")) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f136879a = (TextView) findViewById(R.id.jump_count_number);
        this.f136880b = (TextView) findViewById(R.id.jump_desc);
        IHostService r101 = TTLiveSDK.hostService();
        if (r101 == null) goto L12;
        IHostLiveOpenPlatform r102 = r101.hostOpenPlatform();
        if (r102 == null) goto L13;
        Typeface r103 = r102.getDuxFontSync(this.context);
        if (r103 == null) goto L14;
        TextView r104 = this.f136879a;
        if (r104 == null) goto L15;
        r104.setTypeface(r103, 2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        if (yh0.f121689a.getValue().booleanValue() == false) goto L14;
        if (z.e(this.dataCenter, false) == true) goto L14;
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L14;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L14;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L14;
        a1.o(this.containerView, UtilityKotlinExtentionsKt.i(UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(this.context)) + 138));
    L14:
        if (this.f136884f == false) goto L18;
        this.f136884f = false;
        IGroupLiveService r111 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r111 == null) goto L18;
        r111.setAnchorIdBeforeJump("");
        r111.setRoomIdBeforeJump(0);
        r111.setRequestIdBeforeJump("");
    L18:
        f.c(this);
        ViewGroup r112 = this.containerView;
        if (r112 == null) goto L21;
        UtilityKotlinExtentionsKt.z(r112, false);
    L21:
        StringBuilder r113 = new StringBuilder("onLoad anchorIdBeforeJump:");
        IGroupLiveService r100 = (IGroupLiveService) k.f(IGroupLiveService.class);
        ICloudCollaborateData r101 = null;
        if (r100 == null) goto L24;
        String r102 = r100.getAnchorIdBeforeJump();
    L25:
        r113.append(r102);
        ALogger.d("CollaborateWidget", r113.toString());
        RoomContext r114 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r114 == null) goto L54;
        d r103 = r114.getMessageManager().getValue();
        if (r103 == null) goto L30;
        r103.addMessageListener("WebcastCloudCollaborateMemberMessage", this);
    L30:
        Room r115 = r114.getRoom().getValue();
        StringBuilder r104 = new StringBuilder("onLoad cloudCollaborateData:, ");
        RoomOthersData r105 = r115.others;
        if (r105 == null) goto L35;
        ICloudCollaborateData r106 = r105.getCloudCollaborateData();
        if (r106 == null) goto L35;
        Long r107 = Long.valueOf(r106.getCollaborateRoomId());
    L36:
        r104.append(r107);
        ALogger.d("CollaborateWidget", r104.toString());
        RoomOthersData r108 = r115.others;
        if (r108 == null) goto L55;
        ICloudCollaborateData r109 = r108.getCloudCollaborateData();
        if (r109 != null) goto L41;
        return;
    L41:
        if (r109.getCollaborateRoomId() != 0) goto L43;
    L45:
        boolean r116 = false;
    L46:
        if (r116 == false) goto L48;
        r101 = r109;
    L48:
        if (r101 == null) goto L57;
        Map r117 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_grouped_lived", "1")});
        TextView r118 = this.f136880b;
        if (r118 == null) goto L52;
        r118.setText(s1.B(R.string.ttlive_jump_to_collaborate_room));
    L52:
        this.f136881c = Observable.interval(1, TimeUnit.SECONDS).take(r101.getJumpCollaborateRoomTime()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(r101, r117, r115, this));
        return;
    L57:
        return;
    L43:
        if (r109.getCollaborateRoomId() == r115.f162599id) goto L45;
        r116 = true;
        goto L46
    L55:
        return;
    L35:
        r107 = null;
        goto L36
    L54:
        return;
    L24:
        r102 = null;
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13, types: [T, com.bytedance.android.live.base.model.data.d] */
    @Override // vlc.l
    public final void onMessage(tlc.d r210) {
        if ((r210 instanceof i0) == false) goto L201;
        c r100 = ((i0) r210).getCollaborateInfo();
        if (r100 == null) goto L202;
        List<com.bytedance.android.live.base.model.data.d> r101 = r100.a();
        if (r101 != null) goto L9;
        return;
    L9:
        if ((!r101.isEmpty()) == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L204;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        IGroupLiveService r103 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r103 == null) goto L24;
        String r104 = r103.getAnchorIdBeforeJump();
        if (r104 == null) goto L24;
        if (wq(r104) == true) goto L21;
        r104 = null;
    L21:
        if (r104 == null) goto L24;
    L37:
        boolean r105 = wq(r104);
        o r106 = z51.a.h(this.dataCenter, 2);
        if (r106 == null) goto L205;
        m<IRoom> r107 = r106.getRoom();
        if (r107 == null) goto L206;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L207;
        long r109 = r108.getId();
        Iterator<T> r110 = r101.iterator();
        com.bytedance.android.live.base.model.data.d r111 = 0;
        com.bytedance.android.live.base.model.data.d r112 = 0;
    L45:
        if (r110.hasNext() == false) goto L63;
        ?? r113 = (com.bytedance.android.live.base.model.data.d) r110.next();
        r111 = r111;
        if (r113.d() != r109) goto L50;
        r111 = r113;
    L50:
        if (r113.c() == 1) goto L51;
        if (r105 == false) goto L45;
        if (r113.c() != 2) goto L45;
        IBaseUser r114 = r113.f();
        if (r114 == null) goto L58;
        String r115 = r114.getIdString();
    L60:
        if (Intrinsics.areEqual(r115, r104) == false) goto L45;
        r102.element = r113;
        goto L45
    L58:
        r115 = null;
        goto L60
    L51:
        r112 = r113;
        goto L45
    L63:
        if (r112 != 0) goto L83;
        StringBuilder r116 = new StringBuilder("Dispose roomLeaveDisposable Group Room Closed，Join Dispose:");
        Disposable r117 = this.f136881c;
        if (r117 == null) goto L67;
        Boolean r118 = Boolean.valueOf(r117.isDisposed());
    L68:
        r116.append(r118);
        r116.append(", Leave Dispose:");
        Disposable r119 = this.f136882d;
        if (r119 == null) goto L71;
        Boolean r120 = Boolean.valueOf(r119.isDisposed());
    L72:
        r116.append(r120);
        ALogger.d("CollaborateWidget", r116.toString());
        Disposable r121 = this.f136881c;
        if (r121 != null) goto L75;
        return;
    L75:
        if (r121.isDisposed() == true) goto L209;
        ViewGroup r122 = this.containerView;
        if (r122 == null) goto L79;
        UtilityKotlinExtentionsKt.z(r122, false);
    L79:
        Disposable r123 = this.f136881c;
        if (r123 == null) goto L82;
        r123.dispose();
    L82:
        this.f136881c = null;
        return;
    L209:
        return;
    L71:
        r120 = null;
        goto L72
    L67:
        r118 = null;
        goto L68
    L83:
        StringBuilder r124 = new StringBuilder("find collaborateGroupRoom:");
        r124.append(r112);
        r124.append("，needFindAnchorRoom:");
        r124.append(r105);
        r124.append(", collaborateAnchorRoom:");
        r124.append((com.bytedance.android.live.base.model.data.d) r102.element);
        r124.append(", Join Dispose:");
        Disposable r125 = this.f136881c;
        if (r125 == null) goto L86;
        Object r126 = Boolean.valueOf(r125.isDisposed());
    L87:
        r124.append(r126);
        r124.append(", Leave Dispose:");
        Disposable r127 = this.f136882d;
        if (r127 == null) goto L90;
        Object r128 = Boolean.valueOf(r127.isDisposed());
    L91:
        r124.append(r128);
        ALogger.d("CollaborateWidget", r124.toString());
        if (r111 == 0) goto L211;
        StringBuilder r129 = new StringBuilder("currentRoomId:");
        r129.append(r111.d());
        r129.append("， collaborateAnchorRoom:");
        com.bytedance.android.live.base.model.data.d r130 = (com.bytedance.android.live.base.model.data.d) r102.element;
        if (r130 == null) goto L96;
        Integer r131 = Integer.valueOf(r130.e());
    L97:
        r129.append(r131);
        ALogger.d("CollaborateWidget", r129.toString());
        if (r112.d() != r111.d()) goto L147;
        com.bytedance.android.live.base.model.data.d r132 = (com.bytedance.android.live.base.model.data.d) r102.element;
        if (r132 != null) goto L102;
    L127:
        StringBuilder r133 = new StringBuilder("Dispose roomLeaveDisposable If Need，Join Dispose:");
        Disposable r134 = this.f136881c;
        if (r134 == null) goto L130;
        Boolean r135 = Boolean.valueOf(r134.isDisposed());
    L131:
        r133.append(r135);
        r133.append(", Leave Dispose:");
        Disposable r136 = this.f136882d;
        if (r136 == null) goto L134;
        Boolean r137 = Boolean.valueOf(r136.isDisposed());
    L135:
        r133.append(r137);
        ALogger.d("CollaborateWidget", r133.toString());
        Disposable r138 = this.f136882d;
        if (r138 != null) goto L138;
        return;
    L138:
        if (r138.isDisposed() == true) goto L214;
        ViewGroup r139 = this.containerView;
        if (r139 == null) goto L142;
        UtilityKotlinExtentionsKt.z(r139, false);
    L142:
        Disposable r140 = this.f136882d;
        if (r140 == null) goto L145;
        r140.dispose();
    L145:
        this.f136882d = null;
        return;
    L214:
        return;
    L134:
        r137 = null;
        goto L135
    L130:
        r135 = null;
        goto L131
    L102:
        if (r132.e() == 2) goto L104;
    L106:
        boolean r141 = false;
    L107:
        if (r141 == true) goto L110;
        r132 = null;
    L110:
        if (r132 == null) goto L127;
        Disposable r142 = this.f136882d;
        if (r142 != null) goto L114;
    L116:
        ALogger.d("CollaborateWidget", "jumpToRoom targetRoom:" + r132);
        if (r132.a() <= r132.b()) goto L119;
        long r143 = 1000;
        long r144 = Random.Default.nextLong(r132.b() * r143, r143 * r132.a());
    L120:
        Map r145 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_grouped_lived", "0")});
        Ref.LongRef r146 = new Ref.LongRef();
        long r147 = 1000;
        r146.element = r144 / r147;
        ViewGroup r148 = this.containerView;
        if (r148 == null) goto L123;
        UtilityKotlinExtentionsKt.z(r148, true);
    L123:
        TextView r149 = this.f136880b;
        if (r149 == null) goto L126;
        r149.setText(s1.B(R.string.ttlive_back_to_own_room));
    L126:
        this.f136882d = Observable.interval(r144 % r147, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new z72.a(r146, r132, r145, this));
        return;
    L119:
        r144 = r132.a() * ((long) 1000);
        goto L120
    L114:
        if (r142.isDisposed() == true) goto L116;
        return;
    L104:
        if (r132.d() <= 0) goto L106;
        r141 = true;
        goto L107
    L147:
        if (r112.d() > 0) goto L149;
    L151:
        boolean r150 = false;
    L152:
        if (r150 == true) goto L155;
        r112 = 0;
    L155:
        if (r112 == 0) goto L169;
        Disposable r151 = this.f136881c;
        if (r151 != null) goto L159;
    L161:
        ALogger.d("CollaborateWidget", "jumpToRoom targetRoom:" + r112);
        if (r112.a() <= r112.b()) goto L164;
        long r152 = 1000;
        long r153 = Random.Default.nextLong(r112.b() * r152, r152 * r112.a());
    L165:
        Map r154 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_grouped_lived", "1")});
        Ref.LongRef r155 = new Ref.LongRef();
        long r156 = 1000;
        r155.element = r153 / r156;
        TextView r157 = this.f136880b;
        if (r157 == null) goto L168;
        r157.setText(s1.B(R.string.ttlive_jump_to_collaborate_room));
    L168:
        this.f136881c = Observable.interval(r153 % r156, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new z72.b(r155, r112, r154, r111, this));
        return;
    L164:
        r153 = r112.a() * ((long) 1000);
        goto L165
    L159:
        if (r151.isDisposed() == true) goto L161;
        return;
    L169:
        StringBuilder r158 = new StringBuilder("Dispose roomJoinDisposable If Need，Join Dispose:");
        Disposable r159 = this.f136881c;
        if (r159 == null) goto L172;
        Boolean r160 = Boolean.valueOf(r159.isDisposed());
    L173:
        r158.append(r160);
        r158.append(", Leave Dispose:");
        Disposable r161 = this.f136882d;
        if (r161 == null) goto L176;
        Boolean r162 = Boolean.valueOf(r161.isDisposed());
    L177:
        r158.append(r162);
        ALogger.d("CollaborateWidget", r158.toString());
        Disposable r163 = this.f136881c;
        if (r163 != null) goto L180;
        return;
    L180:
        if (r163.isDisposed() == true) goto L218;
        ViewGroup r164 = this.containerView;
        if (r164 == null) goto L184;
        UtilityKotlinExtentionsKt.z(r164, false);
    L184:
        Disposable r165 = this.f136881c;
        if (r165 == null) goto L187;
        r165.dispose();
    L187:
        this.f136881c = null;
        return;
    L218:
        return;
    L176:
        r162 = null;
        goto L177
    L172:
        r160 = null;
        goto L173
    L149:
        if (r111.e() != 1) goto L151;
        r150 = true;
        goto L152
    L96:
        r131 = null;
        goto L97
    L211:
        return;
    L90:
        r128 = null;
        goto L91
    L86:
        r126 = null;
        goto L87
    L207:
        return;
    L206:
        return;
    L205:
        return;
    L24:
        if (kz.f120639a.getValue().booleanValue() == false) goto L36;
        o r166 = z51.a.h(this.dataCenter, 2);
        if (r166 == null) goto L36;
        m<IRoom> r167 = r166.getRoom();
        if (r167 == null) goto L36;
        IRoom r168 = r167.getValue();
        if (r168 == null) goto L36;
        IRoomOthersData r169 = r168.getRoomOthers();
        if (r169 == null) goto L36;
        IChangeRoomInfo r170 = r169.getChangeRoomInfo();
        if (r170 == null) goto L36;
        r104 = String.valueOf(r170.getBeforeAnchorId());
    L36:
        r104 = null;
        goto L37
    L204:
        return;
    L202:
        return;
    }

    public static void xq(CollaborateWidget r110, long r111, Map r112, String r210, Long r211, boolean r212, EnterRoomRedirect r213, boolean r214, int r215) {
        Long r100 = null;
        if ((r215 & 4) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r215 & 8) != 0) goto L11;
        r100 = r211;
    L11:
        if ((r215 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r215 & 64) == 0) goto L17;
        boolean r103 = false;
    L18:
        r110.getClass();
        long r104 = 0;
        if (r111 == 0) goto L58;
        com.bytedance.android.livesdk.log.filter.o r113 = u.l().c(x.class);
        String r114 = "";
        if (r113.getMap().containsKey("enter_from_merge") == false) goto L24;
        String r115 = r113.getMap().get("enter_from_merge");
    L26:
        if (r113.getMap().containsKey("enter_method") == false) goto L28;
        String r116 = r113.getMap().get("enter_method");
    L29:
        Bundle r117 = new Bundle();
        r117.putString("enter_from_merge", r115);
        r117.putString("enter_method", r116);
        r117.putInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_REDIRECT_FORM, r213.getValue());
        if (r102 == true) goto L32;
    L34:
        JumpToOtherRoomEvent r105 = new JumpToOtherRoomEvent(r111, "live_detail", r117);
        r105.source = IBackRoomStackKt.JUMP_SOURCE_CLOUD_COLLABORATE;
        r105.jumpSource = IBackRoomStackKt.JUMP_SOURCE_CLOUD_COLLABORATE;
        r105.isBackPreRoom = false;
        j0.l().sendLog("livesdk_live_show", r112, new Object[]{am2.u.class, PadLoggerData.class});
        IGroupLiveService r106 = (IGroupLiveService) k.f(IGroupLiveService.class);
        if (r106 != null) goto L37;
    L56:
        r110.f136883e = true;
        xs2.b.a().post(r105);
        return;
    L37:
        if (wq(r101) == false) goto L55;
        if (r101 != null) goto L40;
        r101 = "";
    L40:
        r106.setAnchorIdBeforeJump(r101);
        if (r100 == null) goto L43;
        r104 = r100.longValue();
    L43:
        r106.setRoomIdBeforeJump(r104);
        com.bytedance.android.livesdk.log.filter.o r107 = u.l().c(Room.class);
        if (r107 == null) goto L51;
        Map<String, String> r108 = r107.getMap();
        if (r108 == null) goto L51;
        String r109 = r108.get("request_id");
        if (r109 == null) goto L51;
        r114 = r109;
    L51:
        r106.setRequestIdBeforeJump(r114);
        if (r103 == false) goto L56;
        if (r100 == null) goto L56;
        ((LiveRoomCacheManager) ((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).roomCacheManager()).d(r100.longValue());
        goto L56
    L55:
        r110.f136884f = true;
        goto L56
    L32:
        if (jz.f120562a.getValue().booleanValue() == false) goto L34;
        r117.putBoolean("finish_current_activity", true);
        goto L34
    L28:
        r116 = "";
        goto L29
    L24:
        r115 = "";
        goto L26
    L58:
        return;
    L17:
        r103 = r214;
        goto L18
    L13:
        r102 = r212;
        goto L15
    L5:
        r101 = r210;
        goto L7
    }
}
