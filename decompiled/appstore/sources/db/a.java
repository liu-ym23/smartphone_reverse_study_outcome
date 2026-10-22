package db;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19145a = null;

    static {
        f19145a = new a();
    }

    public a() {
    }

    public final MemoryServiceStatus a(Context r10) {
        q.g(r10, "context");
        ProviderInfo r11 = null;
        r11 = r10.getPackageManager().resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", UiType.FLAG_PHONE_CARD);     // Catch: RuntimeException -> L5 SecurityException -> L7
    L12:
        if (r11 != null) goto L16;
        Log.w("MemoryServiceChecker", "No provider found for authority: com.obric.memorydata.personalcontext.EntityProvider");
        return MemoryServiceStatus.UNAVAILABLE;
    L16:
        if (com.obric.capabilitykit.common.a.f11256a.a(r10, new ComponentName(r11.packageName, r11.name)) == false) goto L18;
        Log.i("MemoryServiceChecker", "Provider is available: " + r11.packageName + '/' + r11.name);
        return MemoryServiceStatus.AVAILABLE;
    L18:
        Log.w("MemoryServiceChecker", "Provider is disabled: " + r11.packageName + '/' + r11.name);
        return MemoryServiceStatus.UNAVAILABLE;
    L7:
        e = e;
        String r12 = "No permission to resolve provider";
    L10:
        Log.w("MemoryServiceChecker", r12, e);
    L5:
        e = e;
        r12 = "Failed to resolve provider";
        goto L10
    }

    public final MemoryServiceStatus b(Context r10) {
        q.g(r10, "context");
        return d(r10, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE", "GlobalSearch");
    }

    public final MemoryServiceStatus c(Context r10) {
        q.g(r10, "context");
        return d(r10, "com.obric.memorydata.action.SEARCH_SERVICE", "Search");
    }

    public final MemoryServiceStatus d(Context r10, String r11, String r12) {
        List<ResolveInfo> r13 = r10.getPackageManager().queryIntentServices(new Intent(r11), UiType.FLAG_PHONE_CARD);     // Catch: RuntimeException -> L5 SecurityException -> L7
        q.f(r13, "{\n            if (Build.…)\n            }\n        }");     // Catch: RuntimeException -> L5 SecurityException -> L7
    L13:
        if (r13.isEmpty() == false) goto L16;
        Log.w("MemoryServiceChecker", "No " + r12 + " services found for action: " + r11);
        return MemoryServiceStatus.UNAVAILABLE;
    L16:
        boolean r14 = false;
        if (r13.isEmpty() == true) goto L32;
        Iterator<T> r15 = r13.iterator();
    L21:
        if (r15.hasNext() == false) goto L32;
        ServiceInfo r16 = ((ResolveInfo) r15.next()).serviceInfo;
        if (r16 == null) goto L29;
        q.f(r16, "serviceInfo");
        boolean r17 = com.obric.capabilitykit.common.a.f11256a.a(r10, new ComponentName(r16.packageName, r16.name));
        if (r17 == false) goto L28;
        StringBuilder r18 = new StringBuilder();
        r18.append(r12);
        String r19 = " service is available: ";
    L27:
        r18.append(r19);
        r18.append(r16.packageName);
        r18.append('/');
        r18.append(r16.name);
        Log.d("MemoryServiceChecker", r18.toString());
    L30:
        if (r17 == false) goto L21;
        r14 = true;
        goto L32
    L28:
        r18 = new StringBuilder();
        r18.append(r12);
        r19 = " service is disabled: ";
        goto L27
    L29:
        r17 = false;
    L32:
        if (r14 == false) goto L35;
        return MemoryServiceStatus.AVAILABLE;
    L35:
        return MemoryServiceStatus.UNAVAILABLE;
    L7:
        e = e;
        StringBuilder r20 = new StringBuilder();
        String r21 = "No permission to query ";
    L10:
        r20.append(r21);
        r20.append(r12);
        r20.append(" services");
        Log.w("MemoryServiceChecker", r20.toString(), e);
        r13 = t.i();
    L5:
        e = e;
        r20 = new StringBuilder();
        r21 = "Failed to query ";
        goto L10
    }
}
