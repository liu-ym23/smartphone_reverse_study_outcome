package z4;

import Y8.t;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R<\u0010\u0014\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0012j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lz4/h;", "", "<init>", "()V", "Lkotlin/Function1;", "", "LY8/t;", "listener", Const.INTENT_KEY_APIKEY, "(Lp9/l;)V", Const.INTENT_KEY_PKGNAME, UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(I)V", "offset", "I", "c", "()I", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "listeners", "Ljava/util/LinkedHashSet;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h {
    private final LinkedHashSet<InterfaceC5074l<Integer, t>> listeners = new LinkedHashSet<>();
    private int offset;

    public final void a(InterfaceC5074l<? super Integer, t> listener) {
        p.i(listener, "listener");
        this.listeners.add(listener);
    }

    public final void b(InterfaceC5074l<? super Integer, t> listener) {
        p.i(listener, "listener");
        this.listeners.remove(listener);
    }

    /* renamed from: c, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    public final void d(int value) {
        int iF = C5685n.f(value, 0);
        if (iF == this.offset) {
            return;
        }
        this.offset = iF;
        Iterator it = F.m1(this.listeners).iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(Integer.valueOf(iF));
        }
    }
}
