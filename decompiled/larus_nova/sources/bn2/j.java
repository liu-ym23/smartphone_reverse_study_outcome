package bn2;

import com.bytedance.android.live.user.IUserService;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f19728c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f19729d = null;

    public j() {
    }

    static {
        f19729d = new j();
        f19728c = com.bytedance.android.livesdk.sharedpref.b.Q2.getValue();
    }

    public final void update(boolean r100) {
        f19726a = r100;
        Map<String, Boolean> r101 = f19728c;
        r101.put(((IUserService) jc1.k.n(IUserService.class)).user().n(), Boolean.valueOf(f19726a));
        com.bytedance.android.livesdk.sharedpref.e<Map<String, Boolean>> r102 = com.bytedance.android.livesdk.sharedpref.b.Q2;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r101);
    }
}
