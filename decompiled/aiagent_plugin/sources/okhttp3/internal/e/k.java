package okhttp3.internal.e;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import d.h.b.o;
import java.net.ProtocolException;
import okhttp3.aa;

/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa f39936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f39937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f39938d;

    /* JADX INFO: compiled from: StatusLine.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final k a(String r8) {
            o.e(r8, "statusLine");
            int r5 = 9;
            if (d.o.o.b(r8, "HTTP/1.", false, 2, null) == false) goto L19;
            if (r8.length() < 9) goto L17;
            if (r8.charAt(8) != ' ') goto L17;
            int r7 = r8.charAt(7) - '0';
            if (r7 != 0) goto L11;
            aa r9 = aa.f39694b;
        L21:
            int r1 = r5 + 3;
            if (r8.length() < r1) goto L37;
            String r0 = r8.substring(r5, r1);     // Catch: NumberFormatException -> L34
            o.c(r0, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: NumberFormatException -> L34
            int r2 = Integer.parseInt(r0);     // Catch: NumberFormatException -> L34
            if (r8.length() > r1) goto L27;
            String r10 = "";
        L33:
            return new k(r9, r2, r10);
        L27:
            if (r8.charAt(r1) != ' ') goto L30;
            r10 = r8.substring(r5 + 4);
            o.c(r10, "this as java.lang.String).substring(startIndex)");
            goto L33
        L30:
            throw new ProtocolException("Unexpected status line: " + r8);
        L35:
            throw new ProtocolException("Unexpected status line: " + r8);
        L37:
            throw new ProtocolException("Unexpected status line: " + r8);
        L11:
            if (r7 != 1) goto L14;
            r9 = aa.f39695c;
            goto L21
        L14:
            throw new ProtocolException("Unexpected status line: " + r8);
        L17:
            throw new ProtocolException("Unexpected status line: " + r8);
        L19:
            if (d.o.o.b(r8, "ICY ", false, 2, null) == false) goto L39;
            r9 = aa.f39694b;
            r5 = 4;
            goto L21
        L39:
            throw new ProtocolException("Unexpected status line: " + r8);
        }
    }

    static {
        f39935a = new a(null);
    }

    public k(aa r2, int r3, String r4) {
        o.e(r2, MonitorConstants.PROTOCOL);
        o.e(r4, "message");
        this.f39936b = r2;
        this.f39937c = r3;
        this.f39938d = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f39936b != aa.f39694b) goto L5;
        r0.append("HTTP/1.0");
    L6:
        r0.append(' ').append(this.f39937c);
        r0.append(' ').append(this.f39938d);
        String r4 = r0.toString();
        o.c(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        r0.append("HTTP/1.1");
        goto L6
    }
}
