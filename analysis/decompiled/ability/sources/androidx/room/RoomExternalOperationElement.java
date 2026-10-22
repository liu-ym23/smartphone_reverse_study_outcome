package androidx.room;

import H7.f;
import H7.g;
import H7.h;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import z2.l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/room/RoomExternalOperationElement;", "LH7/f;", "LH7/g;", AppAgent.CONSTRUCT, "()V", "getKey", "()LH7/g;", "key", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoomExternalOperationElement implements f, g {
    public static final RoomExternalOperationElement INSTANCE = new RoomExternalOperationElement();

    private RoomExternalOperationElement() {
    }

    @Override // H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) l.w(this, r5, nVar);
    }

    @Override // H7.h
    public <E extends f> E get(g gVar) {
        return (E) l.x(this, gVar);
    }

    @Override // H7.f
    public g getKey() {
        return INSTANCE;
    }

    @Override // H7.h
    public h minusKey(g gVar) {
        return l.C(this, gVar);
    }

    @Override // H7.h
    public h plus(h hVar) {
        return l.H(this, hVar);
    }
}
