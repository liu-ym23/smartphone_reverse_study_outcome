package c41;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRoom f22375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<g90.a> f22376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Unit> f22377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f22378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f22379e;

    public final Context getContext() {
        return this.f22378d;
    }

    public a(Context r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f22378d = r100;
        this.f22379e = r101;
        this.f22376b = new MutableLiveData();
        this.f22377c = new MutableLiveData();
    }
}
