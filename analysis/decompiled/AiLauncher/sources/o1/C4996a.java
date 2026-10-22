package o1;

import android.os.Trace;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u0003J\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u0007*\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lo1/a;", "", "<init>", "()V", "", "c", "()Z", "", "label", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "counterName", "", "counterValue", Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)V", "e", "(Ljava/lang/String;)Ljava/lang/String;", "tracing"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4996a {

    /* renamed from: a, reason: collision with root package name */
    public static final C4996a f37463a = new C4996a();

    public static final void a(String label) {
        p.i(label, "label");
        Trace.beginSection(f37463a.e(label));
    }

    public static final void b() {
        Trace.endSection();
    }

    public static final boolean c() {
        return C4997b.f37464a.a();
    }

    public static final void d(String counterName, int counterValue) {
        p.i(counterName, "counterName");
        C4997b.f37464a.b(f37463a.e(counterName), counterValue);
    }

    public final String e(String str) {
        String str2 = str.length() <= 127 ? str : null;
        if (str2 != null) {
            return str2;
        }
        String strSubstring = str.substring(0, 127);
        p.h(strSubstring, "substring(...)");
        return strSubstring;
    }
}
