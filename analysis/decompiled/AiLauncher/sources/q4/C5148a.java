package q4;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w4.ArtifactAvailabilityRow;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lq4/a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "", "", "fileIds", "Lw4/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "fileId", "", "availability", "", "checkedAt", "LY8/t;", "c", "(Ljava/lang/String;IJ)V", "STATE_NORMAL", "I", "STATE_UNAVAILABLE", "STATE_BLOCKED", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: q4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5148a {
    public static final C5148a INSTANCE = new C5148a();
    public static final int STATE_BLOCKED = 2;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_UNAVAILABLE = 1;

    public final boolean a() {
        return FwkDatabase.INSTANCE.B();
    }

    public final List<ArtifactAvailabilityRow> b(List<String> fileIds) {
        p.i(fileIds, "fileIds");
        if (!fileIds.isEmpty()) {
            FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
            if (companion.B()) {
                return companion.n().p0().g(fileIds);
            }
        }
        return C1173v.m();
    }

    public final void c(String fileId, int availability, long checkedAt) {
        p.i(fileId, "fileId");
        FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
        if (companion.B()) {
            companion.n().p0().h(fileId, availability, checkedAt);
        }
    }
}
