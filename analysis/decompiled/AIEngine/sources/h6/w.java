package h6;

import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.process.OtaRuntime;
import com.stepos.core.ota.storage.OtaFailureMarker;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f9354a = new w();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f9355b = new ConcurrentHashMap<>();

    public static boolean a(String str) {
        Object objA;
        try {
            OtaRuntime otaRuntime = OtaRuntime.INSTANCE;
            OtaStateSnapshot otaStateSnapshot = otaRuntime.taskStateFlow().getValue().get(str);
            if (otaStateSnapshot == null || !otaStateSnapshot.isForeground()) {
                OtaStateSnapshot otaStateSnapshot2 = otaRuntime.snapshot().get(str);
                objA = otaStateSnapshot2 != null ? Boolean.valueOf(otaStateSnapshot2.isForeground()) : null;
            } else {
                objA = Boolean.TRUE;
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Boolean bool = (Boolean) (objA instanceof Result.Failure ? null : objA);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static boolean b(String str) {
        Object objA;
        boolean zContainsKey = f9355b.containsKey(str);
        boolean zA = a(str);
        try {
            objA = Boolean.valueOf(OtaTaskSnapshotStore.INSTANCE.isUserManaged(str));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return zContainsKey || zA || ((Boolean) objA).booleanValue();
    }

    public static boolean c(String otaId) {
        Object objA;
        Object objA2;
        kotlin.jvm.internal.g.f(otaId, "otaId");
        if (b(otaId)) {
            return false;
        }
        try {
            objA = (OtaStateSnapshot) OtaRuntime.INSTANCE.taskStateFlow().getValue().get(otaId);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        OtaStateSnapshot otaStateSnapshot = (OtaStateSnapshot) objA;
        try {
            objA2 = Boolean.valueOf(OtaTaskSnapshotStore.INSTANCE.hasUnfinished(otaId));
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Object obj = Boolean.FALSE;
        if (objA2 instanceof Result.Failure) {
            objA2 = obj;
        }
        return otaStateSnapshot != null || ((Boolean) objA2).booleanValue();
    }

    public static boolean d(String otaId) {
        Object objA;
        Object objA2;
        Object objA3;
        kotlin.jvm.internal.g.f(otaId, "otaId");
        boolean zContainsKey = f9355b.containsKey(otaId);
        boolean zA = a(otaId);
        try {
            objA = Boolean.valueOf(OtaFailureMarker.INSTANCE.isSilentFailure(otaId));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        try {
            objA2 = Boolean.valueOf(OtaTaskSnapshotStore.INSTANCE.hasUnfinished(otaId));
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Object obj2 = Boolean.FALSE;
        if (objA2 instanceof Result.Failure) {
            objA2 = obj2;
        }
        boolean zBooleanValue2 = ((Boolean) objA2).booleanValue();
        try {
            objA3 = Boolean.valueOf(OtaTaskSnapshotStore.INSTANCE.isUserManaged(otaId));
        } catch (Throwable th3) {
            objA3 = kotlin.c.a(th3);
        }
        Object obj3 = Boolean.FALSE;
        if (objA3 instanceof Result.Failure) {
            objA3 = obj3;
        }
        boolean zBooleanValue3 = ((Boolean) objA3).booleanValue();
        boolean zC = c(otaId);
        if (zContainsKey || zA || zBooleanValue3) {
            return false;
        }
        if (zBooleanValue || zBooleanValue2) {
            return true;
        }
        return zC;
    }
}
