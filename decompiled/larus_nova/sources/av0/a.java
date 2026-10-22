package av0;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.rank.widget.HourEntranceState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import dy0.d;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends d {

    /* JADX INFO: renamed from: av0.a$a, reason: collision with other inner class name */
    public static final class C0235a {
        public static /* synthetic */ void a(a r100, Context r110, int r111, IRoom r112, String r113, long r114, Function1 r115) {
            r100.wg(r110, r111, r112, r113, r114, null, r115);
        }
    }

    public interface b {
        BehaviorSubject<Pair<Boolean, Boolean>> getFromClient();

        BehaviorSubject<Pair<Boolean, Boolean>> getFromLynx();
    }

    Class<? extends Widget> A1();

    void H7(Context r100);

    Class<? extends Widget> Nh();

    void U5(Context r100, long r101, IBaseUser r102, String r103, DialogInterface.OnDismissListener r104);

    HourEntranceState Uc();

    boolean enableHourRank();

    void wg(Context r100, int r101, IRoom r102, String r103, long r104, DialogInterface.OnDismissListener r105, Function1 r106);

    void x8(boolean r100, boolean r101);
}
