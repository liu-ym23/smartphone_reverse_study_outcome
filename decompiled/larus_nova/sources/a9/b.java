package a9;

import android.content.Context;
import com.bytedance.android.annie.bridge.method.LoadingMethods$HideLoadingMethod;
import com.bytedance.android.annie.bridge.method.LoadingMethods$ShowLoadingMethod;
import com.bytedance.android.annie.bridge.method.b1;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7.x0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements h {
    public b() {
    }

    @Override // a9.h
    public final void B0(b1 r100) {
        Intrinsics.checkNotNullParameter(r100, "modalBuilder");
    }

    @Override // a9.h
    public final void C(Context r100, v7.b r101, x0 r102, LoadingMethods$ShowLoadingMethod.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "showLoadingMethodParams");
        Intrinsics.checkNotNullParameter(r103, "callback");
        String r104 = r102.a();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        if (r101 == null) goto L7;
        r101.e(r104);
    L7:
        if (r101 == null) goto L9;
        r101.d();
    L9:
        r103.a();
    }

    @Override // a9.h
    public final void E1(Context r100, v7.b r101, JSONObject r102, LoadingMethods$HideLoadingMethod.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "showLoadingMethodParams");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r101 == null) goto L5;
        r101.c();
    L5:
        r103.a();
    }
}
