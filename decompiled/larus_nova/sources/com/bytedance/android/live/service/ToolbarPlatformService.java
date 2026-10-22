package com.bytedance.android.live.service;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.arch.data.TbDataFromType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.sq;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomCart;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J<\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/service/ToolbarPlatformService;", "Lcom/bytedance/android/livesdk/toolbarservice/api/IToolbarPlatformService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "checkPreloadView", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "toolbarData", "updateToolbarDataInRoom", "it", "updateCommerceData", "Lot2/b;", "getBottomToolbarLogImpl", "", "isPreload", "Lkotlin/Function2;", "", "onSuccess", "doubleCheckToolbarData", "onInitToolbarData", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/z;", "checkManager", "registerPlaceHold", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarPlatformService implements IToolbarPlatformService {

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarPlatformService f100856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f100857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IRoom f100858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function2 f100859d;

        public a(ToolbarPlatformService r100, DataCenter r101, IRoom r102, Function2 r103) {
            this.f100856a = r100;
            this.f100857b = r101;
            this.f100858c = r102;
            this.f100859d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            if (r101 == null) goto L8;
            Room r102 = (Room) r101.data;
            if (r102 == null) goto L9;
            ToolbarPlatformService.access$updateCommerceData(this.f100856a, r102, this.f100857b);
            ToolbarPlatformService.access$updateToolbarDataInRoom(this.f100856a, this.f100858c, this.f100857b, r102.getToolbarData());
            this.f100857b.put("cmd_new_toolbar_double_check", "commerce");
            this.f100859d.invoke(TbDataFromType.DoubleCheckSuccess.getDesc(), r102.getToolbarData());
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f100860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRoom f100861b;

        public b(Function2 r100, IRoom r101) {
            this.f100860a = r100;
            this.f100861b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.i("NewToolbarLogV2", "Double Check Toolbar Data Error: " + ((Throwable) r100));
            this.f100860a.invoke(TbDataFromType.DoubleCheckFail.getDesc(), this.f100861b.getToolbarData());
        }
    }

    public ToolbarPlatformService() {
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService
    public void onInitToolbarData(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService
    public ot2.b getBottomToolbarLogImpl() {
        return com.bytedance.android.live.utils.a.f102540e;
    }

    private final void checkPreloadView(DataCenter r100) {
        ArrayList r101 = CollectionsKt.arrayListOf(new ExtendedToolbarButton[]{ToolbarButton.COMMERCE.extended(), ToolbarButton.GAME_PROMOTE_AUDIENCE.extended()});
        c0 r102 = y3.m(r100);
        if ((r102 instanceof x3) == true) goto L5;
        r102 = null;
    L5:
        x3 r103 = (x3) r102;
        if (r103 == null) goto L23;
        Map<ExtendedToolbarButton, View> r104 = r103.f116829c;
        if (r104 == null) goto L35;
        Set r105 = ((HashMap) r104).keySet();
        if (r105 == null) goto L36;
        Iterator r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L37;
        ExtendedToolbarButton r107 = (ExtendedToolbarButton) r106.next();
        if (r101.contains(r107) == false) goto L13;
        if (r103.s(r107) != null) goto L13;
        Map<ExtendedToolbarButton, View> r108 = r103.f116829c;
        if (r108 == null) goto L13;
        View r109 = (View) ((HashMap) r108).get(r107);
        if (r109 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r109);
        goto L13
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    private final void updateCommerceData(IRoom r100, DataCenter r101) {
        IRoomCart r102 = r100.getRoomCart();
        if (r102 != null) goto L5;
    L17:
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        if (r103 == null) goto L25;
        m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L26;
        Room r105 = r104.getValue();
        if (r105 == null) goto L27;
        r105.setHasCommerceGoods(r100.isHasCommerceGoods());
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if ((r102 instanceof RoomCart) == true) goto L8;
        r102 = null;
    L8:
        RoomCart r106 = (RoomCart) r102;
        if (r106 == null) goto L17;
        RoomContext r107 = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        if (r107 == null) goto L17;
        m<Room> r108 = r107.getRoom();
        if (r108 == null) goto L17;
        Room r109 = r108.getValue();
        if (r109 == null) goto L17;
        r109.setRoomCart(r106);
        goto L17
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService
    public void registerPlaceHold(DataCenter r100, z r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "checkManager");
        if (com.bytedance.android.live.core.utils.z.e(r100, false) == true) goto L5;
        r101.h(NewToolbarButtonConstants.CommerceCart.INSTANCE);
        r101.h(NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE);
        r101.h(NewToolbarButtonConstants.TransformWidget.INSTANCE);
        r101.h(NewToolbarButtonConstants.MiniGame.INSTANCE);
        r101.h(NewToolbarButtonConstants.ToolbarShare.INSTANCE);
        r101.h(NewToolbarButtonConstants.ToolbarIM.INSTANCE);
        r101.h(NewToolbarButtonConstants.LifeGroupon.INSTANCE);
    L5:
        r101.h(NewToolbarButtonConstants.LittleGame.INSTANCE);
        r101.h(NewToolbarButtonConstants.GamePromote.INSTANCE);
        r101.h(NewToolbarButtonConstants.MiniApp.INSTANCE);
    }

    public static final /* synthetic */ void access$updateCommerceData(ToolbarPlatformService r100, IRoom r101, DataCenter r102) {
        r100.updateCommerceData(r101, r102);
    }

    private final void updateToolbarDataInRoom(IRoom r100, DataCenter r101, ILiveToolbarData r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if ((r102 instanceof LiveToolbarData) == true) goto L7;
        r102 = null;
    L7:
        LiveToolbarData r103 = (LiveToolbarData) r102;
        if (r103 == null) goto L26;
        if (r100 != null) goto L11;
    L17:
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        if (r104 == null) goto L27;
        m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L28;
        Room r106 = r105.getValue();
        if (r106 == null) goto L29;
        r106.setToolbarData(r103);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L11:
        if ((r100 instanceof Room) == true) goto L14;
        r100 = null;
    L14:
        Room r107 = (Room) r100;
        if (r107 == null) goto L17;
        r107.setToolbarData(r103);
        goto L17
    }

    public static final /* synthetic */ void access$updateToolbarDataInRoom(ToolbarPlatformService r100, IRoom r101, DataCenter r102, ILiveToolbarData r103) {
        r100.updateToolbarDataInRoom(r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService
    public void doubleCheckToolbarData(boolean r100, IRoom r101, DataCenter r102, Function2<? super String, ? super ILiveToolbarData, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "onSuccess");
        Boolean r104 = (Boolean) r102.get("data_current_is_preview", Boolean.FALSE);
        boolean r105 = true;
        boolean r106 = false;
        if (r101.getRoomCart() == null) goto L5;
        boolean r107 = true;
    L6:
        boolean r108 = r101.isHasCommerceGoods();
        boolean r109 = com.bytedance.android.live.core.utils.z.e(r102, false);
        if (r107 == true) goto L10;
        if (r108 == false) goto L10;
    L12:
        if (sq.f121245a.getValue().booleanValue() == false) goto L16;
        if (r109 == false) goto L16;
        r105 = false;
    L16:
        if (r104.booleanValue() == true) goto L19;
        r106 = r105;
    L19:
        if (r106 == false) goto L39;
        c r110 = c.b();
        if (r110 == null) goto L41;
        RoomRetrofitApi r111 = (RoomRetrofitApi) r110.e(RoomRetrofitApi.class);
        if (r111 == null) goto L42;
        Observable<Response<Room>> r112 = r111.getRoomInfoByScene(IRoomKtKt.getId(r101), "check_toolbar");
        if (r112 == null) goto L43;
        Observable<Response<Room>> r113 = r112.observeOn(AndroidSchedulers.mainThread());
        if (r113 == null) goto L44;
        Observable<Response<Room>> r114 = r113.subscribeOn(Schedulers.io());
        if (r114 == null) goto L45;
        Disposable r115 = r114.subscribe(new a(this, r102, r101, r103), new b(r103, r101));
        if (r115 == null) goto L46;
        RoomContext r116 = RoomContext.a.c(RoomContext.Companion, r102, 0, 2);
        if (r116 == null) goto L47;
        i<CompositeDisposable> r117 = r116.getCompositeDisposable();
        if (r117 == null) goto L48;
        CompositeDisposable r118 = r117.getValue();
        if (r118 == null) goto L49;
        r118.add(r115);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L39:
        r103.invoke(TbDataFromType.Direct.getDesc(), r101.getToolbarData());
        return;
    L10:
        r105 = false;
        goto L12
    L5:
        r107 = false;
        goto L6
    }
}
