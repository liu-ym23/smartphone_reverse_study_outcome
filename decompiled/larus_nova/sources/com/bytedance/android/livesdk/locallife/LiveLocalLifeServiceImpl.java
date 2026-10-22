package com.bytedance.android.livesdk.locallife;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLifeInfoHandler;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermState;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermStateListener;
import com.bytedance.android.livesdk.performance.j0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JB\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\fH\u0016J\"\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u001dH\u0016J&\u0010-\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010.\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/locallife/LiveLocalLifeServiceImpl;", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLocalLifeService;", "()V", "addShortTermStateListener", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "listener", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermStateListener;", "attachWindow", "Landroid/app/Activity;", "businessName", "", "dialogWindow", "Landroid/view/Window;", "Lkotlin/Function2;", "", "", "detachWindow", "getAnchorShelfSchema", "getCurrentRoomInfo", "Lorg/json/JSONObject;", "getLiveLocalRoomInfo", "Landroid/os/Bundle;", "uniqueKey", "isPreview", "getRoomInfoByUniqueKey", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getShortTermState", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "getTimeStamp", "", "scene", "milestone", "injectLiveLifeInfoHandler", "handler", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLifeInfoHandler;", "removeEnterActionParams", "removeLiveLocalRoomInfo", "key", "removeShortTermStateListener", "setLifeShareId", "lifeShareId", "setShortTermState", "state", "toFullScreen", "toHalfScreen", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveLocalLifeServiceImpl implements ILiveLocalLifeService {
    public LiveLocalLifeServiceImpl() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void removeLiveLocalRoomInfo(FragmentActivity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "key");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public String getAnchorShelfSchema() {
        String r100 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.b();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        return String.valueOf(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.a());
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public JSONObject getCurrentRoomInfo(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        boolean r101 = false;
        Bundle r102 = getLiveLocalRoomInfo(r100, null, false);
        if (r102 == null) goto L5;
        String r103 = r102.getString(RoomState.EXTRA_DATA_ENTER_LOCALLIFT_LIVE_PARAMS);
    L6:
        if (r102 == null) goto L8;
        String r104 = r102.getString("log_enter_params");
    L9:
        Room r105 = LiveLocalLifeDataViewModel.getRoom$default((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class), null, 1, null);
        if (r105 == null) goto L12;
        String r106 = r105.lifeShareId;
    L36:
        JSONObject r107 = new JSONObject(r104);     // Catch: Exception -> L35
        r107.put(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS, r103);     // Catch: Exception -> L35
        if (r106 == null) goto L16;
        r107.put("life_share_id", r106);     // Catch: Exception -> L35
    L16:
        if (r102 == null) goto L18;
        String r108 = r102.getString("extra_params");     // Catch: Exception -> L35
    L19:
        if (r108 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == true) goto L34;
        String r110 = new JSONObject(r108).optString(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO);     // Catch: Exception -> L35
        if (r110 != null) goto L29;
    L30:
        r101 = true;
    L31:
        if (r101 == true) goto L34;
        r107.put(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO, r110);     // Catch: Exception -> L35
    L29:
        if (r110.length() != 0) goto L31;
    L34:
        return r107;
    L21:
        if (r108.length() == 0) goto L24;
        r109 = false;
        goto L25
    L18:
        r108 = null;
    L38:
        return null;
    L12:
        r106 = null;
        goto L36
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeServiceForSaas
    public Bundle getLiveLocalRoomInfo(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return getLiveLocalRoomInfo(r100, null, false);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public ShortTermState getShortTermState(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).getShortTermState();
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void addShortTermStateListener(FragmentActivity r100, ShortTermStateListener r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "listener");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).addShortTermStateListener(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public Room getRoomInfoByUniqueKey(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).getRoom(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public long getTimeStamp(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "milestone");
        ILiveUxTracer r102 = (ILiveUxTracer) k.f(ILiveUxTracer.class);
        if (r102 != null) goto L7;
        return 0;
    L7:
        return r102.getTimeStamp(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void injectLiveLifeInfoHandler(FragmentActivity r100, ILiveLifeInfoHandler r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "handler");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).setLiveLifeInfoHandler(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void removeEnterActionParams(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).removeEnterActionParams(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeServiceForSaas
    public void removeLiveLocalRoomInfo(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "key");
        removeLiveLocalRoomInfo(r100, r101, null);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void removeShortTermStateListener(FragmentActivity r100, ShortTermStateListener r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "listener");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).removeShortTermStateListener(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void setLifeShareId(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).setLifeShareId(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void setShortTermState(FragmentActivity r100, ShortTermState r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "state");
        ((LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class)).setShortTermState(r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void detachWindow(Activity r100, String r101, Window r102) {
        j0.g().d(r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public Bundle getLiveLocalRoomInfo(FragmentActivity r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LiveLocalLifeDataViewModel r103 = (LiveLocalLifeDataViewModel) ViewModelProviders.of(r100).get(LiveLocalLifeDataViewModel.class);
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        Bundle r105 = r103.getData().getValue();
    L14:
        Room r106 = r103.getRoom(r101);
        if (r106 == null) goto L17;
        String r107 = r106.lifeShareId;
    L18:
        if (r107 == null) goto L21;
        if (r105 == null) goto L21;
        r105.putString("life_share_id", r107);
    L21:
        return r105;
    L17:
        r107 = null;
        goto L18
    L11:
        r105 = r103.getMultiRoomData().get(r101);
        if (r105 != null) goto L14;
        r105 = r103.getData().getValue();
        goto L14
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void toFullScreen(Activity r100, String r101, Window r102) {
        j0.g().i(r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void toHalfScreen(Activity r100, String r101, Window r102) {
        j0.g().j(r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService
    public void attachWindow(Activity r100, String r101, Window r102, Function2<? super Boolean, ? super Integer, Unit> r103) {
        j0.g().b(r100, r101, r102, r103);
    }
}
