package i3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3143a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3144b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f3145c;
    public final a d;

    public b(Context context, String servicePackageName, a4.b bVar) {
        p.e(servicePackageName, "servicePackageName");
        this.f3143a = context;
        this.f3144b = servicePackageName;
        this.f3145c = new AtomicReference();
        this.d = new a(this);
    }

    public final void a() {
        Intent intent = new Intent("com.stepos.agentcache.action.BIND_AGENT_CACHE_SERVICE");
        String str = this.f3144b;
        intent.setPackage(str);
        Log.d("LogSdkClient", "bind requested, result=" + this.f3143a.bindService(intent, this.d, 1) + ", package=" + str);
    }
}
