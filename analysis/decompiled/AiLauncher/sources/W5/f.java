package W5;

import L4.AgentPlace;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"LW5/f;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;", "stateResult", "LL4/f;", "place", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteStateResult;LL4/f;)V", "", "bubbleTxt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "", "LW5/d;", "observers", "Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    public static final f INSTANCE = new f();
    private static final List<d> observers = new ArrayList();

    public final void a(String bubbleTxt) {
        p.i(bubbleTxt, "bubbleTxt");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(bubbleTxt);
        }
    }

    public final void b(SpriteStateResult stateResult, AgentPlace place) {
        p.i(stateResult, "stateResult");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((d) it.next()).b(stateResult, place);
        }
    }
}
