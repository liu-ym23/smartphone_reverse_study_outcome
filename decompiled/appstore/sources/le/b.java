package le;

import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow f21951b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SharedFlow f21952c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f21954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f21955c;

        public a(String r10, boolean r11, boolean r12) {
            q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
            this.f21953a = r10;
            this.f21954b = r11;
            this.f21955c = r12;
        }

        public final String a() {
            return this.f21953a;
        }

        public final boolean b() {
            return this.f21954b;
        }

        public final boolean c() {
            return this.f21955c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(this.f21953a, r11.f21953a) == true) goto L12;
            return false;
        L12:
            if (this.f21954b == r11.f21954b) goto L15;
            return false;
        L15:
            if (this.f21955c == r11.f21955c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f21953a.hashCode() * 31) + Boolean.hashCode(this.f21954b)) * 31) + Boolean.hashCode(this.f21955c);
        }

        public String toString() {
            return "Event(pkg=" + this.f21953a + ", isAdded=" + this.f21954b + ", isReplacing=" + this.f21955c + ')';
        }
    }

    static {
        f21950a = new b();
        MutableSharedFlow r10 = b1.a(0, Channel.UNLIMITED, BufferOverflow.SUSPEND);
        f21951b = r10;
        f21952c = kotlinx.coroutines.flow.c.a(r10);
    }

    public b() {
    }

    public static final void b(String r10, boolean r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        le.a.d(r10);
        f21951b.tryEmit(new a(r10, true, r11));
    }

    public static final void c(String r10, boolean r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        le.a.e(r10);
        f21951b.tryEmit(new a(r10, false, r11));
    }

    public final SharedFlow a() {
        return f21952c;
    }
}
