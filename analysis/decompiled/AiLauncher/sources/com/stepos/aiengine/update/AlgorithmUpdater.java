package com.stepos.aiengine.update;

import Z8.C1173v;
import Z8.r;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.aiengine.model.AvailableModelInfo;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/update/AlgorithmUpdater;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "", "algorithms", "", "checkUpdates", "(Landroid/content/Context;[Ljava/lang/String;)J", "Landroid/os/Bundle;", "getUpdates", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/os/Bundle;", "", "Lcom/stepos/aiengine/model/AvailableModelInfo;", "getAvailableModels", "(Landroid/content/Context;)Ljava/util/List;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AlgorithmUpdater {
    public static final AlgorithmUpdater INSTANCE = new AlgorithmUpdater();

    public final long checkUpdates(Context context, String[] algorithms) {
        p.i(context, "context");
        p.i(algorithms, "algorithms");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Log.i("AlgorithmUpdater", "checkUpdates begin: count=" + algorithms.length + " ids=" + r.w0(algorithms, null, null, null, 0, null, null, 63, null));
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
        Object objB;
        p.i(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        if (iOtaDeepBinderService == null) {
            Log.w("AlgorithmUpdater", "getAvailableModels: OtaService unavailable");
            return C1173v.m();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(iOtaDeepBinderService.getAvailableModels());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("AlgorithmUpdater", "getAvailableModels failed", thE);
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        return (List) objB;
    }

    public final Bundle getUpdates(Context context, String[] algorithms) {
        Object objB;
        p.i(context, "context");
        p.i(algorithms, "algorithms");
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
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(iOtaDeepBinderService.getUpdateInfo(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            Bundle bundle2 = (Bundle) objB;
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
