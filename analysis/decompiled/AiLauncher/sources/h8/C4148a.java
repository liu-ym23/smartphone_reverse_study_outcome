package h8;

import Y8.t;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.logbox.LogMasker;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJC\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u001aJ)\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u001aJ)\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u001aJ1\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010 \u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010\u001aJ1\u0010!\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R*\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001b\u0010&\u0012\u0004\b+\u0010\u0003\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lh8/a;", "", "<init>", "()V", "", "release", "LY8/t;", "m", "(Z)V", "l", "()Z", "", "priority", "", "tag", "rawMsg", "", "tr", "sensitive", "mask", "v", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;ZZ)I", "msg", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)I", "o", "(Ljava/lang/String;Ljava/lang/String;Z)I", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "s", "r", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Z)I", "f", "e", Const.INTENT_KEY_PKGNAME, "Z", "releaseMode", "Lh8/i;", "Lh8/i;", "getSensitiveSink", "()Lh8/i;", "n", "(Lh8/i;)V", "getSensitiveSink$annotations", "sensitiveSink", "logbox_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: h8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4148a {

    /* renamed from: a, reason: collision with root package name */
    public static final C4148a f32969a = new C4148a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean releaseMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static volatile i sensitiveSink;

    public static final int a(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return f32969a.v(4, tag, msg, null, false, false);
    }

    public static final int b(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return d(tag, msg, false, 4, null);
    }

    public static final int c(String tag, String msg, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return w(f32969a, 3, tag, msg, null, sensitive, false, 32, null);
    }

    public static /* synthetic */ int d(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return c(str, str2, z10);
    }

    public static final int e(String tag, String msg, Throwable tr, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        p.i(tr, "tr");
        return w(f32969a, 6, tag, msg, tr, sensitive, false, 32, null);
    }

    public static final int f(String tag, String msg, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return w(f32969a, 6, tag, msg, null, sensitive, false, 32, null);
    }

    public static /* synthetic */ int g(String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return e(str, str2, th, z10);
    }

    public static /* synthetic */ int h(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return f(str, str2, z10);
    }

    public static final int i(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return k(tag, msg, false, 4, null);
    }

    public static final int j(String tag, String msg, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return w(f32969a, 4, tag, msg, null, sensitive, false, 32, null);
    }

    public static /* synthetic */ int k(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return j(str, str2, z10);
    }

    public static final boolean l() {
        return releaseMode;
    }

    public static final void m(boolean release) {
        releaseMode = release;
    }

    public static final void n(i iVar) {
        sensitiveSink = iVar;
    }

    public static final int o(String tag, String msg, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return w(f32969a, 2, tag, msg, null, sensitive, false, 32, null);
    }

    public static /* synthetic */ int p(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return o(str, str2, z10);
    }

    public static final int q(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return u(tag, msg, false, 4, null);
    }

    public static final int r(String tag, String msg, Throwable tr, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        p.i(tr, "tr");
        return w(f32969a, 5, tag, msg, tr, sensitive, false, 32, null);
    }

    public static final int s(String tag, String msg, boolean sensitive) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        return w(f32969a, 5, tag, msg, null, sensitive, false, 32, null);
    }

    public static /* synthetic */ int t(String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return r(str, str2, th, z10);
    }

    public static /* synthetic */ int u(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return s(str, str2, z10);
    }

    public static /* synthetic */ int w(C4148a c4148a, int i10, String str, String str2, Throwable th, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            z11 = true;
        }
        return c4148a.v(i10, str, str2, th, z10, z11);
    }

    public final int v(int priority, String tag, String rawMsg, Throwable tr, boolean sensitive, boolean mask) {
        Object objB;
        String strA = f.f32973a.a(tag);
        String strI = mask ? LogMasker.f32018a.i(rawMsg) : rawMsg;
        int i10 = 0;
        if (releaseMode && (sensitive || (mask && !p.d(strI, rawMsg)))) {
            i iVar = sensitiveSink;
            if (iVar != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    iVar.a(priority, strA, rawMsg, tr);
                    objB = Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Result.a(objB);
            }
            return 0;
        }
        String stackTraceString = tr != null ? Log.getStackTraceString(tr) : null;
        if (strI.length() <= 3000) {
            if (stackTraceString != null) {
                strI = strI + "\n" + stackTraceString;
            }
            return Log.println(priority, strA, strI);
        }
        int length = (strI.length() + 2999) / 3000;
        int i11 = length < 64 ? length : 64;
        int iPrintln = 0;
        while (i10 < i11) {
            int i12 = i10 * 3000;
            int length2 = i12 + 3000;
            if (length2 >= strI.length()) {
                length2 = strI.length();
            }
            i10++;
            String strSubstring = strI.substring(i12, length2);
            p.h(strSubstring, "substring(...)");
            iPrintln = Log.println(priority, strA, "[" + i10 + "/" + length + "] " + strSubstring);
        }
        int length3 = strI.length() - (i11 * 3000);
        if (length3 > 0) {
            iPrintln = Log.println(priority, strA, "[共 " + length + " 段/" + strI.length() + " 字符，超出 64 段上限，省略末尾 " + length3 + " 字符]");
        }
        return stackTraceString != null ? Log.println(priority, strA, stackTraceString) : iPrintln;
    }
}
