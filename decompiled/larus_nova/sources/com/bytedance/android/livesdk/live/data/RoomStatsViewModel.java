package com.bytedance.android.livesdk.live.data;

import ac2.e;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdk.chatroom.model.b3;
import com.bytedance.android.livesdk.chatroom.model.s;
import com.bytedance.android.livesdk.chatroom.model.w3;
import com.bytedance.android.livesdk.live.api.RoomStatApi;
import com.bytedance.android.livesdk.live.api.RoomStateApi;
import com.bytedance.android.livesdk.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kf2.i;
import kf2.j;
import kf2.k;
import kf2.l;
import ng2.f;

/* JADX INFO: loaded from: classes10.dex */
public class RoomStatsViewModel extends RxViewModel {
    private final boolean mChangeRequest;
    private final List<String> mEnterFrom;
    private final MutableLiveData<Map<String, f>> mRoomStatsResponse;

    public class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    public static /* synthetic */ void Mo(RoomStatsViewModel r100, ListResponse r101) {
        r100.lambda$getRoomStats$2(r101);
    }

    public static /* synthetic */ void No(RoomStatsViewModel r100, Throwable r101) {
        r100.lambda$getRoomStats$1(r101);
    }

    public static /* synthetic */ void Oo(RoomStatsViewModel r100, List r101, List r102, s r103) {
        r100.lambda$getRoomStats$0(r101, r102, r103);
    }

    public static /* synthetic */ void yo(RoomStatsViewModel r100, Throwable r101) {
        r100.lambda$getRoomStats$3(r101);
    }

    public RoomStatsViewModel() {
        this.mRoomStatsResponse = new MutableLiveData();
        x0 r100 = x0.f162533a;
        this.mChangeRequest = r100.getValue().getChangeRequest();
        this.mEnterFrom = r100.getValue().getLiveEntranceList();
    }

    public MutableLiveData<Map<String, f>> getRoomStatsResponse() {
        return this.mRoomStatsResponse;
    }

    private /* synthetic */ void lambda$getRoomStats$1(Throwable r100) throws Exception {
        this.mRoomStatsResponse.setValue(new HashMap());
    }

    private /* synthetic */ void lambda$getRoomStats$2(ListResponse r100) throws Exception {
        if (Lists.isEmpty(r100.data) == true) goto L11;
        HashMap r101 = new HashMap();
        Iterator r102 = r100.data.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        f r103 = (f) r102.next();
        r101.put(String.valueOf(r103.roomId), r103);
        goto L6
    L8:
        this.mRoomStatsResponse.setValue(r101);
        return;
    }

    private /* synthetic */ void lambda$getRoomStats$3(Throwable r100) throws Exception {
        this.mRoomStatsResponse.setValue(new HashMap());
    }

    private boolean changeRequestEnable(String r100, String r101) {
        if (this.mEnterFrom != null) goto L5;
        return false;
    L5:
        String r102 = r100 + "-" + r101;
        if (this.mChangeRequest == true) goto L8;
        return false;
    L8:
        if (this.mEnterFrom.contains(r102) == true) goto L12;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ void lambda$getRoomStats$0(List r100, List r110, s r111) throws Exception {
        if (Lists.notEmpty(r111.a()) == false) goto L38;
        HashMap r101 = new HashMap();
        List<w3> r112 = ((b3) ListProtector.get(r111.a(), 0)).b();
        if (Lists.notEmpty(r112) == false) goto L19;
        Iterator<w3> r113 = r112.iterator();
    L8:
        if (r113.hasNext() == false) goto L19;
        w3 r102 = r113.next();
        f r103 = new f();
        r103.roomId = r102.c();
        if (r102.b() != 1) goto L12;
        boolean r104 = true;
    L13:
        r103.alive = r104;
        long r105 = ((Long) ListProtector.get(r110, r100.indexOf(String.valueOf(r102.d())))).longValue();
        if (r102.b() != 1) goto L18;
        if (r102.c() == r105) goto L18;
        r103.roomId = r105;
        r103.alive = false;
    L18:
        r101.put(String.valueOf(r103.roomId), r103);
        goto L8
    L12:
        r104 = false;
    L19:
        int r114 = 0;
    L21:
        if (r114 >= r110.size()) goto L28;
        long r106 = ((Long) ListProtector.get(r110, r114)).longValue();
        String r107 = (String) ListProtector.get(r100, r114);
        if (r101.containsKey(String.valueOf(r106)) == true) goto L27;
        if (n0.b(r107) == false) goto L27;
        f r108 = new f();
        r108.roomId = r106;
        r108.alive = false;
        r101.put(String.valueOf(ListProtector.get(r110, r114)), r108);
    L27:
        r114 = r114 + 1;
        goto L21
    L28:
        this.mRoomStatsResponse.setValue(r101);
        return;
    }

    public void getRoomStats(List<Room> r110, String r111, String r112) {
        if (Lists.isEmpty(r110) == false) goto L6;
        this.mRoomStatsResponse.setValue(new HashMap());
        return;
    L6:
        final LinkedList r100 = new LinkedList();
        final LinkedList r101 = new LinkedList();
        LinkedList r102 = new LinkedList();
        Iterator<Room> r103 = r110.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Room r104 = r103.next();
        if (r104 == null) goto L8;
        r100.add(Long.valueOf(r104.getId()));
        r102.add(3);
        r101.add(r104.getOwnerUserIdString());
        goto L8
    L12:
        String r105 = TextUtils.join(",", r100);
        String r106 = TextUtils.join(",", r102);
        String r107 = TextUtils.join(",", r101);
        a r108 = new a();
        String r113 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(r108).second;
        if (changeRequestEnable(r111, r112) == true) goto L15;
        ((RoomStatApi) c.b().e(RoomStatApi.class)).checkRoom(r113, r105).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this), new l(this));
        return;
    L15:
        if (x0.f162533a.getValue().getReportUseBytelink() == false) goto L17;
        RoomStateApi r109 = (RoomStateApi) e.b().a(RoomStateApi.class);
    L18:
        r109.checkUserLiveStatus(r107, r106, null, null, null, null, r113, "inner_interval", null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r101, r100), new j(this));
        return;
    L17:
        r109 = (RoomStateApi) c.b().e(RoomStateApi.class);
        goto L18
    }
}
