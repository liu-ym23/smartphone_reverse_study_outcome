package cb;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.selects.OnTimeout;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"R", "Lcb/c;", "", "timeMillis", "Lkotlin/Function1;", "Le9/c;", "", "block", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcb/c;JLp9/l;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> void a(c<? super R> cVar, long j10, InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l) {
        cVar.a(new OnTimeout(j10).c(), interfaceC5074l);
    }
}
