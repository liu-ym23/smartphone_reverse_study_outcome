package u6;

import com.stepos.taskrobot.vdbroadcast.VdTaskState;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import m9.q0;

/* renamed from: u6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2041a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6711a;
    public final String b;
    public final String c;
    public final long d;
    public final String e;
    public final String f;
    public final long g;
    public volatile VdTaskState h;
    public volatile q0 i;

    /* renamed from: j, reason: collision with root package name */
    public volatile q0 f6712j;
    public final AtomicBoolean k;

    public C2041a(String requestId, String packageName, String taskName, long j5, String callbackPackage, String str, long j6) {
        k.f(requestId, "requestId");
        k.f(packageName, "packageName");
        k.f(taskName, "taskName");
        k.f(callbackPackage, "callbackPackage");
        this.f6711a = requestId;
        this.b = packageName;
        this.c = taskName;
        this.d = j5;
        this.e = callbackPackage;
        this.f = str;
        this.g = j6;
        this.h = VdTaskState.f4076a;
        this.k = new AtomicBoolean(false);
    }

    public final String toString() {
        String str = this.f6711a;
        String str2 = this.b;
        String str3 = this.c;
        long j5 = this.d;
        VdTaskState vdTaskState = this.h;
        String str4 = this.e;
        StringBuilder sbW = B7.a.w("VdTask(requestId=", str, ", pkg=", str2, ", taskName=");
        B7.a.y(j5, str3, ", timeoutMs=", sbW);
        sbW.append(", state=");
        sbW.append(vdTaskState);
        sbW.append(", callbackPackage=");
        sbW.append(str4);
        sbW.append(")");
        return sbW.toString();
    }
}
