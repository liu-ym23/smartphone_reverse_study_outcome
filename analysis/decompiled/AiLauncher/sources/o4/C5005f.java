package o4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.i;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lo4/f;", "Lo4/c;", "<init>", "()V", "", "reason", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/adapter/netcore/i;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30739f, "Lcom/stepos/agentframework/adapter/netcore/i;", "getEventSource", "()Lcom/stepos/agentframework/adapter/netcore/i;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/adapter/netcore/i;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: o4.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5005f implements InterfaceC5002c {
    private i eventSource;

    @Override // o4.InterfaceC5002c
    public void a(String reason) {
        p.i(reason, "reason");
        C4148a.k("ThirdPartClientRequester", "cancelRequest reason:" + reason + " eventSource is null:" + (this.eventSource == null), false, 4, null);
        i iVar = this.eventSource;
        if (iVar != null) {
            iVar.cancel(reason);
        }
        this.eventSource = null;
    }

    public final void b(i iVar) {
        this.eventSource = iVar;
    }
}
