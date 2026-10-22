package o4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lo4/b;", "Lo4/c;", "<init>", "()V", "", "reason", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lo4/b$a;", "cancelCallback", "Lo4/b$a;", "getCancelCallback", "()Lo4/b$a;", Const.INTENT_KEY_PKGNAME, "(Lo4/b$a;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: o4.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5001b implements InterfaceC5002c {
    private a cancelCallback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lo4/b$a;", "", "LY8/t;", "cancel", "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: o4.b$a */
    public interface a {
        void cancel();
    }

    @Override // o4.InterfaceC5002c
    public void a(String reason) {
        p.i(reason, "reason");
        a aVar = this.cancelCallback;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public final void b(a aVar) {
        this.cancelCallback = aVar;
    }
}
