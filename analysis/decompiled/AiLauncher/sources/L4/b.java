package L4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"LL4/b;", "", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "", "holdMillis", "", "priority", "c", "(LL4/l;JI)LL4/b;", "", "freeze", Const.INTENT_KEY_PKGNAME, "(LL4/l;Z)LL4/b;", "LL4/f;", "place", Const.INTENT_KEY_APIKEY, "(LL4/f;)LL4/b;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface b {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ b a(b bVar, l lVar, long j10, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
            }
            if ((i11 & 2) != 0) {
                j10 = 0;
            }
            if ((i11 & 4) != 0) {
                i10 = lVar.getDefaultPriority();
            }
            return bVar.c(lVar, j10, i10);
        }
    }

    b a(AgentPlace place);

    b b(l state, boolean freeze);

    b c(l state, long holdMillis, int priority);
}
