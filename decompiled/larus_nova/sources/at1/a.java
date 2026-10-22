package at1;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f16210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f16211c;

    public final Context getContext() {
        return this.f16209a;
    }

    public a(Context r100, DataCenter r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f16209a = r100;
        this.f16210b = r101;
        this.f16211c = r102;
    }
}
