package x4;

import La.H;
import android.database.sqlite.SQLiteConstraintException;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import com.stepos.agentframework.chatcore.session.O;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.Q;
import java.util.List;
import kotlin.Metadata;
import x4.InterfaceC5848a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010!J\u001f\u0010#\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010!J'\u0010%\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010*J'\u0010,\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010-J'\u0010/\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u00100J'\u00102\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u000fH\u0016¢\u0006\u0004\b2\u00100J\u000f\u00103\u001a\u00020\u0013H\u0016¢\u0006\u0004\b3\u0010\u0003J'\u00104\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b4\u00105J?\u00108\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\u00020:2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b;\u0010<J'\u0010>\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010=\u001a\u00020:H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000fH\u0002¢\u0006\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lx4/d;", "Lx4/e;", "<init>", "()V", "", "sessionId", "Lw4/e;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Lw4/e;", "agentId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/util/List;", "l", "()Ljava/util/List;", "", "r", "(Ljava/lang/String;)J", "title", "LY8/t;", "m", "(Lw4/e;)V", "tempSessionId", "", "useOpenClawSessionKindRules", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "lastReadAt", "q", "(Ljava/lang/String;Ljava/lang/String;J)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)V", "p", "(Ljava/lang/String;Ljava/lang/String;)Z", "s", "k", "newTitle", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "label", "Lx4/a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Lx4/a;", "failed", "o", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "lastActiveAt", "u", "(Ljava/lang/String;Ljava/lang/String;J)Z", "at", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;Z)V", "tempTitle", "savedTitle", "w", "(Ljava/lang/String;Ljava/lang/String;ZLw4/e;Lw4/e;)V", "", "B", "(Ljava/lang/String;Z)I", "status", "v", "(Ljava/lang/String;Ljava/lang/String;I)V", "requested", "e", "(J)J", "Lcom/stepos/agentframework/chatcore/session/db/Q;", "f", "()Lcom/stepos/agentframework/chatcore/session/db/Q;", "dao", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d implements e {
    public static /* synthetic */ void x(d dVar, String str, String str2, boolean z10, w4.e eVar, w4.e eVar2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            eVar = dVar.f().c(str);
        }
        w4.e eVar3 = eVar;
        if ((i10 & 16) != 0) {
            eVar2 = dVar.f().c(str2);
        }
        dVar.w(str, str2, z10, eVar3, eVar2);
    }

    public static final void y(d dVar, String str, String str2, boolean z10) {
        dVar.A(str, str2, z10);
    }

    public static final void z(d dVar, String str, String str2, boolean z10) {
        x(dVar, str, str2, z10, null, null, 24, null);
    }

    public final void A(String tempSessionId, String sessionId, boolean useOpenClawSessionKindRules) {
        w4.e eVarC = f().c(tempSessionId);
        if (eVarC == null) {
            return;
        }
        w4.e eVarC2 = f().c(sessionId);
        int iB = B(sessionId, useOpenClawSessionKindRules);
        if (eVarC2 != null) {
            w(tempSessionId, sessionId, useOpenClawSessionKindRules, eVarC, eVarC2);
        } else {
            f().l(tempSessionId, sessionId, false);
            f().d(sessionId, iB);
        }
    }

    public final int B(String sessionId, boolean useOpenClawSessionKindRules) {
        return useOpenClawSessionKindRules ? ConversationSessionKind.INSTANCE.b(sessionId).getCode() : ConversationSessionKind.NORMAL.getCode();
    }

    @Override // x4.e
    public void a() {
        f().a();
    }

    @Override // x4.e
    public InterfaceC5848a b(String sessionId, String label) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(label, "label");
        String string = H.D1(label).toString();
        if (sessionId.length() == 0 || string.length() == 0) {
            return InterfaceC5848a.c.INSTANCE;
        }
        f().b(sessionId, string);
        w4.e eVarC = f().c(sessionId);
        return eVarC == null ? InterfaceC5848a.b.INSTANCE : (eVarC.getTitleSource() == 1 && kotlin.jvm.internal.p.d(eVarC.getTitle(), string)) ? new InterfaceC5848a.Applied(eVarC) : InterfaceC5848a.c.INSTANCE;
    }

    public final long e(long requested) {
        long jP = f().p();
        return requested > jP ? requested : jP + 1;
    }

    public final Q f() {
        return FwkDatabase.INSTANCE.n().i0();
    }

    @Override // x4.e
    public w4.e g(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        w4.e eVarC = f().c(sessionId);
        if (eVarC != null && eVarC.m()) {
            O.INSTANCE.c(sessionId);
        }
        return eVarC;
    }

    @Override // x4.e
    public void h(String agentId, String sessionId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        f().g(sessionId);
        O.INSTANCE.d(sessionId);
    }

    @Override // x4.e
    public boolean i(String agentId, String sessionId, long at) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (agentId.length() == 0 || sessionId.length() == 0) {
            return false;
        }
        return f().s(sessionId, e(at)) > 0;
    }

    @Override // x4.e
    public List<w4.e> j(String agentId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        return f().q();
    }

    @Override // x4.e
    public boolean k(String agentId, String sessionId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (H.x0(sessionId)) {
            return false;
        }
        boolean z10 = f().h(sessionId) > 0;
        if (z10) {
            O.INSTANCE.d(sessionId);
        }
        return z10;
    }

    @Override // x4.e
    public List<w4.e> l() {
        return f().w();
    }

    @Override // x4.e
    public void m(w4.e title) {
        kotlin.jvm.internal.p.i(title, "title");
        String sessionId = title.getSessionId();
        if (sessionId == null || H.x0(sessionId)) {
            return;
        }
        w4.e eVarC = f().c(title.getSessionId());
        if (eVarC == null || !eVarC.n()) {
            if (eVarC != null && eVarC.getDeleteStatus() == 1) {
                title.r(1);
            }
            f().r(title);
        }
    }

    @Override // x4.e
    public void n(String agentId, final String tempSessionId, final String sessionId, final boolean useOpenClawSessionKindRules) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(tempSessionId, "tempSessionId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (tempSessionId.length() == 0 || sessionId.length() == 0 || kotlin.jvm.internal.p.d(tempSessionId, sessionId)) {
            return;
        }
        w4.e eVarC = f().c(tempSessionId);
        boolean z10 = true;
        if (eVarC != null && eVarC.n()) {
            s(agentId, sessionId);
            return;
        }
        w4.e eVarC2 = f().c(sessionId);
        if (eVarC2 != null && eVarC2.n()) {
            s(agentId, tempSessionId);
            return;
        }
        if ((eVarC == null || eVarC.getDeleteStatus() != 1) && (eVarC2 == null || eVarC2.getDeleteStatus() != 1)) {
            z10 = false;
        }
        FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
        try {
            fwkDatabaseN.Q(new Runnable() { // from class: x4.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.y(this.f43483a, tempSessionId, sessionId, useOpenClawSessionKindRules);
                }
            });
        } catch (SQLiteConstraintException unused) {
            fwkDatabaseN.Q(new Runnable() { // from class: x4.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.z(this.f43487a, tempSessionId, sessionId, useOpenClawSessionKindRules);
                }
            });
        }
        if (z10) {
            p(agentId, sessionId);
        }
    }

    @Override // x4.e
    public boolean o(String agentId, String sessionId, boolean failed) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return (agentId.length() == 0 || sessionId.length() == 0 || f().t(sessionId, failed) <= 0) ? false : true;
    }

    @Override // x4.e
    public boolean p(String agentId, String sessionId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (H.x0(sessionId)) {
            return false;
        }
        if (f().o(sessionId) > 0) {
            O.INSTANCE.c(sessionId);
            return false;
        }
        w4.e eVarC = f().c(sessionId);
        if (eVarC != null) {
            if (eVarC.m()) {
                O.INSTANCE.c(sessionId);
            }
            return false;
        }
        v(agentId, sessionId, 1);
        O.INSTANCE.c(sessionId);
        return true;
    }

    @Override // x4.e
    public void q(String agentId, String sessionId, long lastReadAt) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        f().k(sessionId, lastReadAt);
    }

    @Override // x4.e
    public long r(String agentId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        if (agentId.length() == 0) {
            return 0L;
        }
        return f().p();
    }

    @Override // x4.e
    public boolean s(String agentId, String sessionId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (H.x0(sessionId)) {
            return false;
        }
        if (f().i(sessionId) > 0) {
            O.INSTANCE.c(sessionId);
            return true;
        }
        w4.e eVarC = f().c(sessionId);
        if (eVarC != null && eVarC.getDeleteStatus() == 2) {
            O.INSTANCE.c(sessionId);
            return true;
        }
        if (eVarC != null) {
            return false;
        }
        v(agentId, sessionId, 2);
        O.INSTANCE.c(sessionId);
        return true;
    }

    @Override // x4.e
    public void t(String agentId, String sessionId, String newTitle) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(newTitle, "newTitle");
        f().f(sessionId, newTitle);
    }

    @Override // x4.e
    public boolean u(String agentId, String sessionId, long lastActiveAt) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (agentId.length() == 0 || sessionId.length() == 0) {
            return false;
        }
        return f().m(sessionId, e(lastActiveAt)) > 0;
    }

    public final void v(String agentId, String sessionId, int status) {
        f().r(new w4.e(0, sessionId, "", agentId, null, 0L, 0L, 0L, false, 0, false, 0, status, 3825, null));
    }

    public final void w(String tempSessionId, String sessionId, boolean useOpenClawSessionKindRules, w4.e tempTitle, w4.e savedTitle) {
        if (tempTitle == null) {
            return;
        }
        int iB = B(sessionId, useOpenClawSessionKindRules);
        if (savedTitle == null) {
            f().l(tempSessionId, sessionId, false);
            f().d(sessionId, iB);
            return;
        }
        if (H.x0(savedTitle.getTitle()) && !H.x0(tempTitle.getTitle())) {
            f().n(sessionId, tempTitle.getTitle());
        }
        f().j(sessionId, false);
        f().d(sessionId, iB);
        f().g(tempSessionId);
    }
}
