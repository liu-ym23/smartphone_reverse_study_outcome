package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.like.DigAccessibilityWidget;
import com.bytedance.android.livesdk.interactivity.like.DiggApi;
import com.bytedance.android.livesdk.interactivity.like.DiggWidget;
import com.bytedance.android.livesdk.interactivity.like.controller.DiggCountFlipperLayoutControllerImpl;
import com.bytedance.android.livesdk.interactivity.like.controller.DoubleLikeManager;
import com.bytedance.android.livesdk.interactivity.like.f1;
import com.bytedance.android.livesdk.interactivity.like.v0;
import com.bytedance.android.livesdk.interactivity.like.view.FakeDiggView;
import com.bytedance.android.livesdk.interactivity.like.x0;
import com.bytedance.android.livesdkapi.depend.live.IBarrageLauncher;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.view.IFakeDiggView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016J \u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020'2\u0006\u0010)\u001a\u00020(H\u0016J\"\u00101\u001a\u0002002\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00103\u001a\u0002022\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020+H\u0016J\u001e\u00105\u001a\u0004\u0018\u0001042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u001c\u00108\u001a\u0004\u0018\u0001072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u000206H\u0016¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/DiggService;", "Lcom/bytedance/android/livesdk/interactivity/api/IDiggService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getDiggWidgetClass", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "", "count", "", "sendDiggMessage", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdkapi/view/IFakeDiggView;", "getFakeDiggView", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "Lcom/bytedance/android/livesdkapi/depend/live/IBarrageLauncher;", "provideDiggBarrageLauncher", "Lu32/a$a;", "initializer", "Lu32/a;", "provideDiggAvatarAnimationController", "Lu32/h$a;", "Lu32/h;", "provideDiggHeartAnimationController", "Lu32/o$a;", "Lu32/o;", "provideDiggThankAnimationController", "Lu32/d$a;", "Lu32/d;", "provideDiggCountFlipperLayoutController", "digAccessibilityWidget", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lu32/l;", "provideDoubleLikeManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "loadInPublicScreenContext", "", "roomId", "", "diggTargetUid", "diggExtraInfo", "Lu32/j;", "provideDiggHandler", "", "needPerformHapticFeedback", "Lv32/b;", "getLikeView", "Lv32/d;", "Lv32/a;", "getDefaultTapController", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DiggService implements IDiggService {

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132747a;

        public a(int r100) {
            this.f132747a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            com.bytedance.android.livesdk.interactivity.api.base.b.a r102 = com.bytedance.android.livesdk.interactivity.api.base.b.f132890m;
            q r103 = q.f133747a;
            int r104 = this.f132747a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "$this$onDigg");
            h r105 = i.b(null, 3);
            if (r105 == null) goto L10;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.base.b> r106 = r105.getInteractivityStat();
            if (r106 == null) goto L11;
            com.bytedance.android.livesdk.interactivity.api.base.b r107 = r106.getValue();
            if (r107 == null) goto L12;
            r107.f132896f += r104;
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public DiggService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public Class<? extends LiveRecyclableWidget> digAccessibilityWidget() {
        return DigAccessibilityWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public Class<? extends LiveRecyclableWidget> getDiggWidgetClass() {
        return DiggWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public IFakeDiggView getFakeDiggView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new FakeDiggView(r100, null, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.a provideDiggAvatarAnimationController(u32.a.InterfaceC7825a r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        return new com.bytedance.android.livesdk.interactivity.like.controller.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.d provideDiggCountFlipperLayoutController(u32.d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        return new DiggCountFlipperLayoutControllerImpl(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.h provideDiggHeartAnimationController(u32.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        return new u32.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.o provideDiggThankAnimationController(u32.o.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        return new u32.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.l provideDoubleLikeManager(MiddlewareRoomContext r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        DoubleLikeManager r101 = new DoubleLikeManager(r100);
        r101.addListener(com.bytedance.android.livesdk.interactivity.like.utils.c.f137724a, false);
        r101.addListener(com.bytedance.android.livesdk.interactivity.like.utils.d.f137725a, false);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public v32.a getDefaultTapController(Context r100, v32.d r101) {
        Intrinsics.checkNotNullParameter(r101, "initializer");
        if (r100 != null) goto L7;
        return null;
    L7:
        return new f1(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public v32.b getLikeView(Context r100, DataCenter r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return new x0(r100, r101);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public boolean needPerformHapticFeedback(DataCenter r100, long r101) {
        RoomContext.Companion.getClass();
        RoomContext r102 = RoomContext.a.a(r100, r101);
        if (r102 == null) goto L11;
        DiggContext r103 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(r102);
        if (r103 == null) goto L11;
        com.bytedance.live.datacontext.n<u32.k> r104 = r103.getDiggWidget();
        if (r104 == null) goto L11;
        u32.k r105 = r104.getValue();
        if (r105 == null) goto L11;
        return r105.needPerformHapticFeedback();
    L11:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public IBarrageLauncher provideDiggBarrageLauncher(Context r100, ViewGroup r101) {
        return new com.bytedance.android.livesdk.interactivity.like.barrage.b(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public void sendDiggMessage(Room r110, int r111) {
        if (((IUserService) jc1.k.n(IUserService.class)).user().isLogin() == false) goto L21;
        if (r110 == null) goto L10;
        RoomAuthStatus r100 = r110.getRoomAuthStatus();
        if (r100 == null) goto L10;
        if (r100.getEnableDigg() == true) goto L10;
        return;
    L10:
        if (r110 == null) goto L22;
        DiggApi r101 = (DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class);
        long r102 = r110.f162599id;
        nm1.m r103 = pm1.f.l();
        long r104 = 0;
        if (r103 == null) goto L19;
        Long r105 = null;
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L18;
        com.bytedance.live.datacontext.m<Long> r107 = r106.getCameraId();
        if (r107 == null) goto L18;
        r105 = r107.getValue();
    L18:
        r104 = r103.k(r110, r105);
    L19:
        DiggApi.a.a(r101, r102, r111, r104, null, null, 56).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r111), RxUtil.getNoOpThrowable());
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IDiggService
    public void loadInPublicScreenContext(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r100, RoomContext r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        int r103 = v0.f137750c;
        Intrinsics.checkNotNullParameter(r100, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        if (r101.isVSRoom() == true) goto L7;
        r100.registerPlugin(new v0(r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IBaseDiggService
    public u32.j provideDiggHandler(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "diggTargetUid");
        return new com.bytedance.android.livesdk.interactivity.like.d(r100, r101, r102);
    }
}
