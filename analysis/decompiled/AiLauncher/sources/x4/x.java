package x4;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.B1;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import kotlin.Metadata;
import w4.TaskSessionLink;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lx4/x;", "Lx4/g;", "<init>", "()V", "Lw4/l;", "link", "LY8/t;", "c", "(Lw4/l;)V", "", "subSessionKey", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lw4/l;", "taskId", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "()Lw4/l;", "Lcom/stepos/agentframework/chatcore/session/db/B1;", "e", "()Lcom/stepos/agentframework/chatcore/session/db/B1;", "dao", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class x implements g {
    public TaskSessionLink a(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (H.x0(taskId)) {
            return null;
        }
        return e().e(taskId);
    }

    @Override // x4.g
    public TaskSessionLink b(String subSessionKey) {
        kotlin.jvm.internal.p.i(subSessionKey, "subSessionKey");
        if (H.x0(subSessionKey)) {
            return null;
        }
        return e().b(subSessionKey);
    }

    @Override // x4.g
    public void c(TaskSessionLink link) {
        kotlin.jvm.internal.p.i(link, "link");
        if (H.x0(link.getSubSessionKey()) || H.x0(link.getRequestSessionKey())) {
            return;
        }
        e().c(link);
    }

    @Override // x4.g
    public TaskSessionLink d() {
        return e().d();
    }

    public final B1 e() {
        return FwkDatabase.INSTANCE.n().r0();
    }
}
