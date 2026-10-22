package com.bytedance.android.livesdk.livead;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdNetWorkCallback;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livehostapi.business.depend.livead.LiveAdConstants;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCommitRemoveResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardRemoveRequest;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.k0;
import com.bytedance.android.livesdk.commerce.LiveAdViewModel;
import com.bytedance.android.livesdk.utils.a3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019`\u001aH\u0016J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J \u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livead/LiveAdServiceImpl;", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdService;", "()V", "canShowLiveAdCardWindow", "", "canShowLiveAdLandingPageDialogFragment", "clearAdParamsInLiveContainer", "", "commitCardRemove", "Lio/reactivex/disposables/Disposable;", "cardSwitchRequest", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardRemoveRequest;", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdNetWorkCallback;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCommitRemoveResp;", "getCardCount", "cardCountRequest", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountResp;", "getCurrentRoomInfo", "Lorg/json/JSONObject;", "activity", "Landroidx/fragment/app/FragmentActivity;", "initLiveParamsBeforeOpenMiniApp", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "putAdParamsToLiveContainer", "adParams", "enterFrom", "roomId", "updateCurrentRoomInfo", "key", "value", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveAdServiceImpl implements ILiveAdService {

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILiveAdNetWorkCallback f147604a;

        public a(ILiveAdNetWorkCallback r100) {
            this.f147604a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ILiveAdNetWorkCallback r101 = this.f147604a;
            r101.onSuccess((CardCommitRemoveResp) r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILiveAdNetWorkCallback f147605a;

        public b(ILiveAdNetWorkCallback r100) {
            this.f147605a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ILiveAdNetWorkCallback r101 = this.f147605a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILiveAdNetWorkCallback f147606a;

        public c(ILiveAdNetWorkCallback r100) {
            this.f147606a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ILiveAdNetWorkCallback r101 = this.f147606a;
            r101.onSuccess((CardCountResp) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILiveAdNetWorkCallback f147607a;

        public d(ILiveAdNetWorkCallback r100) {
            this.f147607a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ILiveAdNetWorkCallback r101 = this.f147607a;
            r101.onError((Throwable) r100);
        }
    }

    public LiveAdServiceImpl() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public boolean canShowLiveAdCardWindow() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public boolean canShowLiveAdLandingPageDialogFragment() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public void clearAdParamsInLiveContainer() {
        JSONObject r100 = a3.f158816a;
        a3.f158816a = null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public HashMap<String, String> initLiveParamsBeforeOpenMiniApp() {
        int r100 = k0.f114530a;
        Room r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L7;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L7;
        r101 = r103.getValue();
    L7:
        HashMap<String, String> r104 = k0.c(r101);
        r104.put("scene", "025001");
        r104.put("enterFrom", "ad");
        return r104;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public JSONObject getCurrentRoomInfo(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new JSONObject(((LiveAdViewModel) ViewModelProviders.of(r100).get(LiveAdViewModel.class)).getMobData().getValue());
    L5:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public Disposable commitCardRemove(CardRemoveRequest r100, ILiveAdNetWorkCallback<CardCommitRemoveResp> r101) {
        Intrinsics.checkNotNullParameter(r100, "cardSwitchRequest");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IHostLiveAd r102 = TTLiveSDK.hostService().hostLiveAd();
        if (r102 == null) goto L6;
        String r103 = r102.getHostDomain();
        if (r103 == null) goto L6;
    L7:
        String r104 = r103.concat(LiveAdConstants.cardRemove);
        return ((ILiveAdApi) com.bytedance.android.live.network.c.b().e(ILiveAdApi.class)).commitCardSwitch(r104, r100.getSecUid(), r100.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r101), new b(r101));
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public Disposable getCardCount(CardCountRequest r100, ILiveAdNetWorkCallback<CardCountResp> r101) {
        Intrinsics.checkNotNullParameter(r100, "cardCountRequest");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IHostLiveAd r102 = TTLiveSDK.hostService().hostLiveAd();
        if (r102 == null) goto L6;
        String r103 = r102.getHostDomain();
        if (r103 == null) goto L6;
    L7:
        String r104 = r103.concat(LiveAdConstants.cardCount);
        return ((ILiveAdApi) com.bytedance.android.live.network.c.b().e(ILiveAdApi.class)).getCardCount(r104, r100.getSecUid(), r100.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r101), new d(r101));
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public void putAdParamsToLiveContainer(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "adParams");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        JSONObject r103 = a3.f158816a;
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        a3.f158817b = r101;
        a3.f158818c = r102;
        Intrinsics.checkNotNullParameter(r100, "params");
        a3.f158816a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService
    public void updateCurrentRoomInfo(FragmentActivity r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        JSONObject r103 = getCurrentRoomInfo(r100);
        if (r103 == null) goto L5;
        r103.put(r101, r102);
    L5:
        LiveAdViewModel r104 = (LiveAdViewModel) ViewModelProviders.of(r100).get(LiveAdViewModel.class);
        if (r103 == null) goto L9;
        r104.getMobData().setValue(r103.toString());
        return;
    }
}
