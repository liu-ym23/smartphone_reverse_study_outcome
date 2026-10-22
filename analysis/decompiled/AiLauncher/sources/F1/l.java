package F1;

import Ua.InterfaceC1066l;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5539f;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018¨\u0006\u0019"}, d2 = {"LF1/l;", "Ltb/f;", "Lkotlin/Function1;", "", "LY8/t;", "Lkotlinx/coroutines/CompletionHandler;", "Ltb/e;", "call", "LUa/l;", "Ltb/C;", "continuation", "<init>", "(Ltb/e;LUa/l;)V", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Ltb/e;Ltb/C;)V", "Ljava/io/IOException;", "e", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "cause", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Throwable;)V", "Ltb/e;", "LUa/l;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class l implements InterfaceC5539f, InterfaceC5074l<Throwable, t> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5538e call;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1066l<C5530C> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public l(InterfaceC5538e interfaceC5538e, InterfaceC1066l<? super C5530C> interfaceC1066l) {
        this.call = interfaceC5538e;
        this.continuation = interfaceC1066l;
    }

    @Override // tb.InterfaceC5539f
    public void a(InterfaceC5538e call, C5530C response) {
        this.continuation.resumeWith(Result.b(response));
    }

    public void b(Throwable cause) {
        try {
            this.call.cancel();
        } catch (Throwable unused) {
        }
    }

    @Override // tb.InterfaceC5539f
    public void d(InterfaceC5538e call, IOException e10) {
        if (call.getCanceled()) {
            return;
        }
        InterfaceC1066l<C5530C> interfaceC1066l = this.continuation;
        Result.Companion companion = Result.INSTANCE;
        interfaceC1066l.resumeWith(Result.b(C4849c.a(e10)));
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ t invoke(Throwable th) {
        b(th);
        return t.f7040a;
    }
}
