package x8;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.lang.invoke.VarHandle;
import jb.h;
import jb.i;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f15595a;

    public final a a() {
        Object objL;
        try {
            objL = this.f15595a.getContentResolver().call(d.f15596a, "getRunningTaskState", (String) null, (Bundle) null);
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        Throwable thB = i.b(objL);
        if (thB != null) {
            Log.w("TaskStatusClient", "getRunningTaskState call failed", thB);
        }
        if (objL instanceof h) {
            objL = null;
        }
        Bundle bundle = (Bundle) objL;
        Boolean boolValueOf = bundle != null ? Boolean.valueOf(bundle.getBoolean("hasRunningTask", false)) : null;
        Integer numValueOf = bundle != null ? Integer.valueOf(bundle.getInt("runningTaskCount", 0)) : null;
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        if (iIntValue < 0) {
            iIntValue = 0;
        }
        boolean z10 = k.a(boolValueOf, Boolean.TRUE) || iIntValue > 0;
        int i = z10 ? iIntValue > 0 ? iIntValue : 1 : 0;
        a aVar = new a();
        aVar.f15590a = z10;
        aVar.f15591b = i;
        VarHandle.storeStoreFence();
        return aVar;
    }
}
