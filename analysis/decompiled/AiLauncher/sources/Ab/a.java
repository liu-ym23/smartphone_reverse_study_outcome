package Ab;

import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.u;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0012"}, d2 = {"LAb/a;", "", "LMb/f;", "source", "<init>", "(LMb/f;)V", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Ltb/u;", Const.INTENT_KEY_APIKEY, "()Ltb/u;", "LMb/f;", "getSource", "()LMb/f;", "", "J", "headerLimit", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0968f source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long headerLimit;

    public a(InterfaceC0968f source) {
        p.i(source, "source");
        this.source = source;
        this.headerLimit = 262144L;
    }

    public final u a() throws IOException {
        u.a aVar = new u.a();
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                return aVar.f();
            }
            aVar.c(strB);
        }
    }

    public final String b() throws IOException {
        String strI = this.source.I(this.headerLimit);
        this.headerLimit -= strI.length();
        return strI;
    }
}
