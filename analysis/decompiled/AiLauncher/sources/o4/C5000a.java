package o4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lo4/a;", "Lo4/c;", "<init>", "()V", "", "reason", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lo4/a$a;", "cancelCallback", "Lo4/a$a;", "getCancelCallback", "()Lo4/a$a;", Const.INTENT_KEY_PKGNAME, "(Lo4/a$a;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: o4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5000a implements InterfaceC5002c {
    private InterfaceC0479a cancelCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lo4/a$a;", "", "", "reason", "LY8/t;", "cancel", "(Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: o4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0479a {
        void cancel(String reason);
    }

    @Override // o4.InterfaceC5002c
    public void a(String reason) {
        p.i(reason, "reason");
        InterfaceC0479a interfaceC0479a = this.cancelCallback;
        if (interfaceC0479a != null) {
            interfaceC0479a.cancel(reason);
        }
    }

    public final void b(InterfaceC0479a interfaceC0479a) {
        this.cancelCallback = interfaceC0479a;
    }
}
