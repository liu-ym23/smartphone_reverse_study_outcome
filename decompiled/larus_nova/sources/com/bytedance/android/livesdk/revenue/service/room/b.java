package com.bytedance.android.livesdk.revenue.service.room;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.revenue.room.RevLiveMode;
import com.bytedance.android.livesdk.revenue.room.RevRoomPermission;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes11.dex */
public interface b extends dy0.a {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b r110, long r111, Class r112, Function0 r113, Function2 r114, Function3 r115, Function3 r116, CompositeDisposable r117, int r210) {
            if ((r210 & 4) == 0) goto L5;
            Function0 r100 = null;
        L7:
            if ((r210 & 8) == 0) goto L9;
            Function2 r101 = null;
        L11:
            if ((r210 & 16) == 0) goto L13;
            Function3 r102 = null;
        L15:
            if ((r210 & 32) == 0) goto L17;
            Function3 r103 = null;
        L18:
            r110.b4(r111, r112, r100, r101, r102, r103, r117);
            return;
        L17:
            r103 = r116;
            goto L18
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    LiveMode Ad(RevLiveMode r100);

    com.bytedance.android.livesdk.revenue.room.b Bb();

    boolean Ch();

    void F2();

    String P();

    long S6();

    boolean Tm();

    String Ub(DataCenter r100);

    boolean Vm(DataCenter r100, RevRoomPermission r101);

    void W(FragmentActivity r100, String r101);

    Bundle Xk(IRoom r100);

    <T> void b4(long r100, Class<T> r101, Function0<Unit> r102, Function2<? super Long, ? super String, Unit> r103, Function3<? super T, ? super BackendGeneratedData, ? super BackendItem, Unit> r104, Function3<? super List<? extends T>, ? super BackendGeneratedData, ? super BackendItem, Unit> r105, CompositeDisposable r106);

    void fd();

    int getLocationPermissionParam();

    IRoom getRoom();

    String getVrMachineLogStr(DataCenter r100);

    boolean gm();

    boolean isLocalTest();

    com.bytedance.android.livesdk.revenue.room.e q9(DataCenter r100);

    com.bytedance.android.livesdk.revenue.room.c v7();

    boolean we();

    @Deprecated(message = "迁移后的代码请使用宿主服务的IRevRoomService.roomContext或平台层基建的IRoomDataService，这两个都是房间级的，不需要find")
    com.bytedance.android.livesdk.revenue.room.a x2();
}
