package a8;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final i f231a;

    static {
        i iVar = new i();
        iVar.f9730c = new ConcurrentHashMap();
        iVar.f9731f = new ConcurrentHashMap();
        iVar.f9732g = new ConcurrentHashMap();
        iVar.f9733h = Arrays.asList("jsv-messages");
        VarHandle.storeStoreFence();
        f231a = iVar;
    }
}
