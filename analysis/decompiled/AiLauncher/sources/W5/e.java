package W5;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LW5/e;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;)V", "", "txt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "", "LW5/c;", "observers", "Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final e INSTANCE = new e();
    private static final List<c> observers = new ArrayList();

    public final void a(String txt) {
        p.i(txt, "txt");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(txt);
        }
    }

    public final void b(SpriteStateResult state) {
        p.i(state, "state");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(state);
        }
    }
}
