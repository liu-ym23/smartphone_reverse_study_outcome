package ap9;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import by7.e;
import com.larus.platform.api.c1;
import com.larus.platform.model.UserSubInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15860a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<UserSubInfo> f15861b = null;

    public a() {
    }

    @Override // com.larus.platform.api.c1
    public final boolean a() {
        return false;
    }

    @Override // com.larus.platform.api.c1
    public final void b(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // com.larus.platform.api.c1
    public final void c(FragmentActivity r100, String r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "iTrackNode");
    }

    @Override // com.larus.platform.api.c1
    public final void d() {
    }

    static {
        f15860a = new a();
        f15861b = new MutableLiveData();
    }

    @Override // com.larus.platform.api.c1
    public final LiveData e() {
        return f15861b;
    }
}
