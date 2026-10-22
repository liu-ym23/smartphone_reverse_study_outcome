package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/LiveEndRemindWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEndRemindWidget extends LiveRecyclableWidget implements Observer<KVData>, vlc.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f114977d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f114978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c9 f114979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c9 f114980c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void yq() {
        Disposable r100 = this.f114978a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f114978a = null;
        c9 r101 = this.f114979b;
        if (r101 == null) goto L8;
        wq(r101);
    L8:
        this.f114979b = null;
        c9 r102 = this.f114980c;
        if (r102 == null) goto L11;
        wq(r102);
    L11:
        this.f114980c = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r100 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        if (r100 == null) goto L5;
        r100.removeMessageListener(MessageType.REMIND.getIntType(), this);
    L5:
        this.dataCenter.removeObserver(this);
        yq();
    }

    public LiveEndRemindWidget() {
    }

    public static String Aq(Text r100) {
        return sb2.a.h(r100, "", false).toString();
    }

    public static void wq(c9 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final void xq(LiveEndRemindWidget r100) {
        r100.getClass();
        HashMap<String, String> r101 = new HashMap();
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L9;
        Room r104 = r103.getValue();
        if (r104 == null) goto L9;
        r101.put("room_id", String.valueOf(r104.f162599id));
        r101.put("anchor_id", r104.getOwnerUserIdString());
        LiveMode r105 = r104.getStreamType();
        int r106 = com.bytedance.android.live.core.utils.h1.f66189a;
        r101.put("live_type", com.bytedance.android.live.core.utils.i1.a(r105));
    L9:
        xs2.b r107 = xs2.b.a();
        zg1.h1 r108 = new zg1.h1(49);
        r108.f571840e = r101;
        Unit r109 = Unit.INSTANCE;
        r107.post(r108);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L13;
        String r102 = r101.getKey();
        if (r102.hashCode() == (-774172322)) goto L9;
        return;
    L9:
        if (r102.equals("cmd_dismiss_dialog_end") == false) goto L12;
        yq();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        vlc.d r101 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        if (r101 == null) goto L5;
        r101.addMessageListener(MessageType.REMIND.getIntType(), this);
    L5:
        this.dataCenter.observe("cmd_dismiss_dialog_end", this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.String] */
    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if ((r110 instanceof kj) == false) goto L58;
        kj r100 = (kj) r110;
        switch(r100.s()) {
            case 12: goto L35;
            case 13: goto L10;
            case 14: goto L10;
            default: goto L59;
        };
    L10:
        int r101 = r100.s();
        yq();
        int r102 = r100.noticeTime;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        Text r104 = r100.buttonConfirm;
        if (r104 == null) goto L13;
        ?? r105 = Aq(r104);
    L14:
        r103.element = r105;
        if (r105 != 0) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        r103.element = "立即关播";
    L23:
        Context r107 = this.context;
        c9.b r111 = new c9.b();
        r111.f112681a = r107;
        r111.f112682b = 1;
        r111.f112683c = R.layout.ttlive_dialog_room_elderly_block_layout;
        r111.f112684d = com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_ic_notice);
        r111.f112696p = false;
        r111.f112697q = false;
        r111.f112685e = Aq(r100.noticeTitle);
        r111.f112686f = Aq(r100.E());
        r111.f112687g = 17;
        String r108 = ((String) r103.element) + '(' + r102 + ")s";
        v1 r109 = new v1(this, r101, r100);
        r111.f112688h = r108;
        r111.f112689i = r109;
        c9 r112 = new c9(r111.f112681a, r111);
        this.f114980c = r112;
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r112);
    L29:
        if (13 != r101) goto L31;
        zq("livesdk_anchor_elderly_midnight2_popup_show", null);
    L34:
        this.f114978a = du2.a.e(0, r102, 1000, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new w1(this, r101, r100)).subscribe(new x1(this, r103, r102));
        return;
    L31:
        String r113 = r100.eventName;
        if (r113 == null) goto L34;
        zq(r113, null);
        goto L34
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L27:
        DialogLancet.beforeDialogShow(r112);
        r112.show();
        DialogLancet.afterDialogShow(r112);
        goto L29
    L17:
        if (r105.length() == 0) goto L20;
        r106 = false;
        goto L21
    L13:
        r105 = 0;
        goto L14
    L35:
        yq();
        Context r114 = this.context;
        c9.b r115 = new c9.b();
        r115.f112681a = r114;
        r115.f112682b = 2;
        r115.f112683c = R.layout.ttlive_dialog_room_elderly_remind_layout;
        r115.f112685e = Aq(r100.noticeTitle);
        r115.f112686f = Aq(r100.E());
        r115.f112687g = 17;
        r115.f112696p = true;
        r115.f112697q = true;
        Text r116 = r100.buttonCancel;
        if (r116 == null) goto L38;
        String r117 = Aq(r116);
    L39:
        y1 r118 = new y1(this);
        r115.f112690j = r117;
        r115.f112691k = r118;
        Text r119 = r100.buttonConfirm;
        if (r119 == null) goto L42;
        String r120 = Aq(r119);
    L43:
        z1 r121 = new z1(this, r100);
        r115.f112692l = r120;
        r115.f112693m = r121;
        c9 r122 = new c9(r115.f112681a, r115);
        this.f114979b = r122;
        if (DialogLancet.shouldBlockDialogShow(r122) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r122);
    L48:
        zq("livesdk_anchor_elderly_midnight1_popup_show", null);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L47:
        DialogLancet.beforeDialogShow(r122);
        r122.show();
        DialogLancet.afterDialogShow(r122);
        goto L48
    L42:
        r120 = null;
        goto L43
    L38:
        r117 = null;
        goto L39
    L59:
        return;
    }

    public static void zq(String r100, String r101) {
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L13;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L14;
        Room r104 = r103.getValue();
        if (r104 == null) goto L15;
        HashMap r105 = new HashMap();
        r105.put("anchor_id", r104.getOwnerUserIdString());
        r105.put("room_id", String.valueOf(r104.getRoomId()));
        LiveMode r106 = r104.getStreamType();
        int r107 = com.bytedance.android.live.core.utils.h1.f66189a;
        r105.put("live_type", com.bytedance.android.live.core.utils.i1.a(r106));
        if (r101 == null) goto L11;
        r105.put("action_type", r101);
    L11:
        com.bytedance.android.livesdk.log.u.l().sendLog(r100, r105, new Object[0]);
        return;
    L15:
        return;
    L14:
        return;
    }
}
