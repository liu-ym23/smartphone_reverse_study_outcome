package m8;

import com.autonavi.aps.amapapi.config.Const;
import j8.InterfaceC4782h;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lm8/k;", "", "<init>", "()V", "", "name", "Lvc/c;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lvc/c;", "jLogger", "Lj8/h;", Const.INTENT_KEY_PKGNAME, "(Lvc/c;)Lj8/h;", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f37189a = new k();

    public final vc.c a(String name) {
        p.i(name, "name");
        vc.c cVarM = vc.e.m(name);
        p.h(cVarM, "getLogger(...)");
        return cVarM;
    }

    public final InterfaceC4782h b(vc.c jLogger) {
        p.i(jLogger, "jLogger");
        return jLogger instanceof xc.c ? new h((xc.c) jLogger) : new i(jLogger);
    }
}
