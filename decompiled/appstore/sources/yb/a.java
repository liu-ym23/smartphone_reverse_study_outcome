package yb;

import android.util.Log;
import com.obric.download.L;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements L.Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f26191b;

    public a(String r10, boolean r11) {
        q.g(r10, "baseTag");
        this.f26190a = r10;
        this.f26191b = r11;
    }

    @Override // com.obric.download.L.Logger
    public void flush() {
        L.Logger.a.a(this);
    }

    @Override // com.obric.download.L.Logger
    public void writeLog(String r10, int r11, String r12, Throwable r13) {
        q.g(r12, "msg");
        if (r10 == null) goto L9;
        if (r10.length() == 0) goto L9;
        r12 = r10 + "-->" + r12;
    L9:
        if (this.f26191b == false) goto L12;
        StringBuilder r14 = new StringBuilder();
        r14.append('[');
        Thread r15 = Thread.currentThread();
        q.f(r15, "Thread.currentThread()");
        r14.append(r15.getName());
        r14.append("]|");
        r14.append(r12);
        r12 = r14.toString();
    L12:
        if (r11 != 1) goto L14;
        Log.v(this.f26190a, r12);
        return;
    L14:
        if (r11 != 2) goto L16;
        Log.d(this.f26190a, r12);
        return;
    L16:
        if (r11 != 4) goto L18;
        Log.i(this.f26190a, r12);
        return;
    L18:
        if (r11 != 8) goto L20;
        String r16 = this.f26190a;
        if (r13 != null) goto L29;
        Log.w(r16, r12);
        return;
    L29:
        Log.w(r16, r12, r13);
        return;
    L20:
        if (r11 != 16) goto L40;
        String r17 = this.f26190a;
        if (r13 != null) goto L25;
        Log.e(r17, r12);
        return;
    L25:
        Log.e(r17, r12, r13);
        return;
    }
}
