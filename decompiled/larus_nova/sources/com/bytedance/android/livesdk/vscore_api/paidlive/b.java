package com.bytedance.android.livesdk.vscore_api.paidlive;

import android.os.Bundle;
import com.bytedance.android.livesdk.vscore_impl.paidlive.NewPaidLiveUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ String a(NewPaidLiveUtils r100, boolean r101) {
            return r100.z(r101, false, null);
        }

        public static /* synthetic */ long b(b r100, DataCenter r101) {
            return r100.u(r101, 0);
        }

        public static /* synthetic */ void c(b r100, ILivePlayerClient r101, String r102, NextLiveData r103, Map r110) {
            r100.a(r101, r102, r103, r110, null);
        }
    }

    void a(ILivePlayerClient r100, String r101, NextLiveData<Boolean> r102, Map<String, String> r103, DataCenter r104);

    String b();

    String c(DataCenter r100);

    boolean d(DataCenter r100);

    Disposable e(RoomBaseSession r100);

    Property<Boolean> f();

    void g(VSCameraInfo r100, Map r101);

    boolean h(DataCenter r100);

    boolean i(CameraPaidInfo r100, String r101);

    boolean j(IRoom r100, Bundle r101);

    String k(List<Integer> r100);

    VSCameraInfo l(DataCenter r100);

    long m(IRoom r100);

    void n(Room r100, Map r101);

    boolean o(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106);

    boolean p(Bundle r100);

    String q(DataCenter r100);

    CameraPaidInfo r(DataCenter r100);

    boolean s(DataCenter r100);

    boolean t(Room r100, long r101);

    long u(DataCenter r100, long r101);

    boolean v(PaidLiveData r100, String r101);

    long w(DataCenter r100);
}
