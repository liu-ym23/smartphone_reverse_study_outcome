package ud;

import android.util.Log;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements L.Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24933b;

    public a(String r10, boolean r11) {
        q.g(r10, "baseTag");
        this.f24932a = r10;
        this.f24933b = r11;
    }

    @Override // com.obric.oui.utils.log.L.Logger
    public void flush() {
        L.Logger.a.a(this);
    }

    @Override // com.obric.oui.utils.log.L.Logger
    public void writeLog(String r10, int r11, String r12, Throwable r13) {
        q.g(r12, "msg");
        if (r10 == null) goto L9;
        if (r10.length() == 0) goto L9;
        r12 = r10 + "-->" + r12;
    L9:
        if (this.f24933b == false) goto L12;
        r12 = '[' + Thread.currentThread().getName() + "]|" + r12;
    L12:
        if (r11 != 1) goto L14;
        Log.v(this.f24932a, r12);
        return;
    L14:
        if (r11 != 2) goto L16;
        Log.d(this.f24932a, r12);
        return;
    L16:
        if (r11 != 4) goto L18;
        Log.i(this.f24932a, r12);
        return;
    L18:
        if (r11 != 8) goto L20;
        String r14 = this.f24932a;
        if (r13 != null) goto L29;
        Log.w(r14, r12);
        return;
    L29:
        Log.w(r14, r12, r13);
        return;
    L20:
        if (r11 != 16) goto L40;
        String r15 = this.f24932a;
        if (r13 != null) goto L25;
        Log.e(r15, r12);
        return;
    L25:
        Log.e(r15, r12, r13);
        return;
    }

    public /* synthetic */ a(String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        this(r10, r11);
    }
}
