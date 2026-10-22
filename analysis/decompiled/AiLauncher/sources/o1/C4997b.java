package o1;

import android.os.Trace;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lo1/b;", "", "<init>", "()V", "", "counterName", "", "counterValue", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;I)V", "", Const.INTENT_KEY_APIKEY, "()Z", "isEnabled", "tracing"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: o1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4997b {

    /* renamed from: a, reason: collision with root package name */
    public static final C4997b f37464a = new C4997b();

    public final boolean a() {
        return Trace.isEnabled();
    }

    public final void b(String counterName, int counterValue) {
        p.i(counterName, "counterName");
        Trace.setCounter(counterName, counterValue);
    }
}
