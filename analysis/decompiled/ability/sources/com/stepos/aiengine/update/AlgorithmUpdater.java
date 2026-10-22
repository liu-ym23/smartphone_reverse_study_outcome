package com.stepos.aiengine.update;

import D7.q;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/update/AlgorithmUpdater;", "", "Landroid/content/Context;", "context", "", "", "algorithms", "", "checkUpdates", "(Landroid/content/Context;[Ljava/lang/String;)J", "Landroid/os/Bundle;", "getUpdates", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/os/Bundle;", "", "Lcom/stepos/aiengine/model/AvailableModelInfo;", "getAvailableModels", "(Landroid/content/Context;)Ljava/util/List;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlgorithmUpdater {
    public static final AlgorithmUpdater INSTANCE = new AlgorithmUpdater();

    public final long checkUpdates(Context context, String[] algorithms) {
        k.f(context, "context");
        k.f(algorithms, "algorithms");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Log.i("AlgorithmUpdater", "checkUpdates begin: count=" + algorithms.length + " ids=" + q.x0(algorithms, null, null, null, null, 63));
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        if (iOtaDeepBinderService == null) {
            Log.w("AlgorithmUpdater", "checkUpdates: OtaService unavailable, returning -1");
            return -1L;
        }
        for (String str : algorithms) {
            Log.d("AlgorithmUpdater", "triggerCheckUpdate → " + str);
            iOtaDeepBinderService.triggerCheckUpdate(str);
        }
        Log.i("AlgorithmUpdater", "checkUpdates end: elapsed=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms deadlineIn=6000ms");
        return System.currentTimeMillis() + 6000;
    }

    public final List<AvailableModelInfo> getAvailableModels(Context context) {
        Object objA;
        k.f(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        if (iOtaDeepBinderService == null) {
            Log.w("AlgorithmUpdater", "getAvailableModels: OtaService unavailable");
            return EmptyList.f4893a;
        }
        try {
            objA = iOtaDeepBinderService.getAvailableModels();
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e("AlgorithmUpdater", "getAvailableModels failed", thA);
        }
        EmptyList emptyList = EmptyList.f4893a;
        if (objA instanceof Result.Failure) {
            objA = emptyList;
        }
        return (List) objA;
    }

    public final Bundle getUpdates(Context context, String[] algorithms) {
        Object objA;
        k.f(context, "context");
        k.f(algorithms, "algorithms");
        Bundle bundle = new Bundle();
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        if (iOtaDeepBinderService == null) {
            Log.w("AlgorithmUpdater", "getUpdates: OtaService unavailable");
            bundle.putLong(AlgorithmUpdateBundle.KEY_CHECK_TIME, -1L);
            bundle.putStringArrayList(AlgorithmUpdateBundle.KEY_UPDATES, new ArrayList<>());
            return bundle;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : algorithms) {
            try {
                objA = iOtaDeepBinderService.getUpdateInfo(str);
            } catch (Throwable th) {
                objA = b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            Bundle bundle2 = (Bundle) objA;
            Log.d("AlgorithmUpdater", "getUpdates: " + str + " → hasUpdate=" + (bundle2 != null));
            if (bundle2 != null) {
                arrayList.add(str);
                bundle.putBundle(str + ".model", bundle2);
            }
        }
        Log.i("AlgorithmUpdater", "getUpdates result: " + arrayList);
        bundle.putLong(AlgorithmUpdateBundle.KEY_CHECK_TIME, System.currentTimeMillis());
        bundle.putStringArrayList(AlgorithmUpdateBundle.KEY_UPDATES, arrayList);
        return bundle;
    }
}
