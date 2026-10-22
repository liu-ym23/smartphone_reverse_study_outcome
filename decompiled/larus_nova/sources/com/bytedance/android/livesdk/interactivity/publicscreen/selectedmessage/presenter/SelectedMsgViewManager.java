package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.m3;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.m4;
import com.bytedance.android.livesdkapi.depend.model.live.AIPublicScreenContainer;
import com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer;
import com.bytedance.android.livesdkapi.depend.model.live.IPSSelectedMessageInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/presenter/SelectedMsgViewManager;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lfa2/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedMsgViewManager implements l, Observer<KVData>, fa2.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f139411m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f139412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f139413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f139414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f139415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f139416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f139417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f139418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AIPublicScreenContainer f139419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f139420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f139421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e52.a f139422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final fa2.d f139423l;

    public static final class a {
    }

    public final ha2.a d() {
        return (ha2.a) this.f139412a.getValue();
    }

    static {
        f139411m = new com.bytedance.android.livesdk.sharedpref.e("anchor_change_public_screen_height_when_open", Boolean.FALSE);
    }

    @Override // fa2.a
    public final boolean c() {
        if (this.f139417f != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // fa2.a
    public final boolean a() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f139418g != 1) goto L7;
        return true;
    }

    @Override // fa2.a
    public final boolean b() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f139418g != 2) goto L7;
        return true;
    }

    @Override // fa2.a
    public final AIPublicScreenContainer getAiPublicScreenContainer() {
        return this.f139419h;
    }

    public final void e(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f139413b = r100;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(this.f139420i).b(o42.b.class).subscribe(new e(this)), this.f139415d);
        RxUtilKt.c(xs2.b.a().b(o42.d.class).subscribe(new f(this)), this.f139415d);
        vlc.d r101 = (vlc.d) this.f139420i.get("data_message_manager");
        if (r101 == null) goto L5;
        r101.addMessageListener("WebcastFeaturedPublicScreenSettingMessage", this);
        r101.addMessageListener("WebcastFeaturedAIMessage", this);
    L5:
        this.f139420i.observe("data_link_state", this);
        IInteractivityInjectService r102 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r102 == null) goto L8;
        r102.subscribeVideoTalkRoomSubScene(this.f139420i, this.f139415d, new g(this));
    L8:
        MiddlewareRoomContext r103 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.f139420i, 0, 2);
        if (r103 == null) goto L13;
        j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r104 = r103.getVoiceTalkRoomSubScene();
        if (r104 == null) goto L13;
        r104.c(new SelectedMsgViewManager$initEvents$5(this));
    L13:
        IPSSelectedMessageInfo r105 = null;
        if (SelectedMsgABHelper.c(this.f139420i) == false) goto L26;
        IRoom r106 = this.f139413b;
        if (r106 == null) goto L26;
        IPSSelectedMessageInfo r107 = r106.getPSSelectedMessageInfo();
        if (r107 == null) goto L26;
        if (r107.getStatus() != 1) goto L26;
        this.f139416e = true;
        IRoom r108 = this.f139413b;
        if (r108 == null) goto L24;
        IPSSelectedMessageInfo r109 = r108.getPSSelectedMessageInfo();
    L25:
        g(r109);
        d().b(true, null, "live_take_show", "new_open");
        return;
    L24:
        r109 = null;
    L26:
        IRoom r110 = this.f139413b;
        if (r110 == null) goto L38;
        IPSSelectedMessageInfo r111 = r110.getPSSelectedMessageInfo();
        if (r111 != null) goto L31;
        return;
    L31:
        if (r111.getStatus() != 1) goto L40;
        this.f139416e = true;
        IRoom r112 = this.f139413b;
        if (r112 == null) goto L35;
        r105 = r112.getPSSelectedMessageInfo();
    L35:
        g(r105);
        return;
    L40:
        return;
    }

    public final void f(m3 r100) {
        this.f139417f = r100.getMode();
        AIPublicScreenContainer r101 = r100.getAiPublicScreenContainer();
        if (r101 == null) goto L5;
        long r102 = r101.getRole();
    L6:
        this.f139418g = r102;
        this.f139419h = r100.getAiPublicScreenContainer();
        int r103 = ga2.d.f480547a;
        ga2.d.a("saveModeInfo message, info: " + r100);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void g(IPSSelectedMessageInfo r100) {
        long r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.getMode();
    L6:
        this.f139417f = r102;
        if (r100 == null) goto L11;
        IAIPublicScreenContainer r103 = r100.getAiPublicScreenContainer();
        if (r103 == null) goto L11;
        r101 = r103.getRole();
    L11:
        this.f139418g = r101;
        IAIPublicScreenContainer r104 = null;
        if (r100 == null) goto L14;
        IAIPublicScreenContainer r105 = r100.getAiPublicScreenContainer();
    L16:
        if ((r105 instanceof AIPublicScreenContainer) == false) goto L19;
        r104 = r105;
    L19:
        this.f139419h = (AIPublicScreenContainer) r104;
        int r106 = ga2.d.f480547a;
        ga2.d.a("saveModeInfo enterRoom, info: " + r100);
        return;
    L14:
        r105 = null;
        goto L16
    L5:
        r102 = 0;
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L33;
        String r102 = r101.getKey();
        if (r102.hashCode() == 872172481) goto L9;
        return;
    L9:
        if (r102.equals("data_link_state") == true) goto L11;
        return;
    L11:
        if (this.f139416e == true) goto L13;
    L15:
        boolean r103 = false;
    L17:
        if (this.f139414c == true) goto L20;
        if (r103 == true) goto L20;
        return;
    L20:
        Integer r104 = (Integer) r101.getData(0);
        if (r104 != null) goto L23;
        r104 = 0;
    L23:
        int r105 = r104.intValue();
        if (SelectedMsgABHelper.f(this.f139420i, Integer.valueOf(r105)) == false) goto L27;
        d().a(true, null, r103);
        return;
    L27:
        if (this.f139414c == false) goto L36;
        d().a(false, s1.B(R.string.ttlive_selected_message_auto_close_toast_public_screen), false);
        return;
    L36:
        return;
    L13:
        if (this.f139414c == true) goto L15;
        r103 = true;
        goto L17
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        boolean r100 = r110 instanceof m3;
        boolean r101 = false;
        if (r100 == false) goto L41;
        if (r100 == true) goto L6;
        r110 = null;
    L6:
        m3 r111 = (m3) r110;
        if (r111 != null) goto L9;
        return;
    L9:
        long r102 = r111.getStatus();
        if (r102 != 1) goto L13;
        this.f139416e = true;
        f(r111);
        d().b(true, r111.getToast(), r111.getSettingSource(), "new_open");
    L39:
        int r103 = ga2.d.f480547a;
        Intrinsics.checkNotNullParameter(r111, "msg");
        ALogger.i("PSSelectedMessage", "receive setting message. msg id: " + r111.getMessageId() + ", status: " + r111.getStatus() + ", source: " + r111.getSource());
        return;
    L13:
        if (r102 != 2) goto L19;
        this.f139416e = false;
        if (this.f139414c == true) goto L17;
        return;
    L17:
        ha2.a.C6116a.a(d(), false, r111.getToast(), 12);
        goto L39
    L19:
        if (r102 != 3) goto L39;
        this.f139416e = true;
        long r104 = this.f139417f;
        f(r111);
        if (r104 == this.f139417f) goto L23;
        r101 = true;
    L23:
        d().f(r111.getToast(), r101);
        if (r101 == false) goto L39;
        if (d().d() == false) goto L39;
        ha2.a r105 = d();
        String r106 = r111.getSettingSource();
        long r107 = this.f139417f;
        if (r104 != 2) goto L33;
        if (r107 != 1) goto L33;
        String r108 = "mode_change#1";
    L38:
        r105.g(r106, r108);
    L33:
        if (r104 == 1) goto L35;
    L37:
        r108 = "";
        goto L38
    L35:
        if (r107 != 2) goto L37;
        r108 = "mode_change#2";
        goto L38
    L41:
        if ((r110 instanceof m4) == true) goto L43;
        return;
    L43:
        if (this.f139414c == false) goto L59;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r109 = this.f139423l.f((t) r110);
        if (r109 == null) goto L47;
        d().getMessageHandler().s(r109);
    L47:
        Long r112 = ((m4) r110).aiMsgType;
        if (r112 != null) goto L51;
    L53:
        boolean r113 = false;
    L54:
        if (r113 == false) goto L60;
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_take_detail");
        r114.put("module_name", "ai_mode_notice");
        r114.put("msg_show_area", "selected_msg");
        j0.l().sendLog("livesdk_public_screen_message_module_show", r114, new Object[]{Room.class});
        return;
    L60:
        return;
    L51:
        if (r112.longValue() != 3) goto L53;
        r113 = true;
        goto L54
    }

    public SelectedMsgViewManager(DataCenter r100, ViewGroup r101, q92.a r102, aa2.a r103) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r103, "msgSource");
        this.f139420i = r100;
        this.f139421j = r101;
        this.f139422k = r102;
        this.f139423l = r103;
        this.f139412a = LazyKt.lazy(new SelectedMsgViewManager$selectedMsgView$2(this));
        this.f139415d = new CompositeDisposable();
    }
}
