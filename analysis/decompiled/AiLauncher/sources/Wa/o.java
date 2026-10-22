package Wa;

import Ua.K;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"LWa/o;", ExifInterface.LONGITUDE_EAST, "LWa/h;", "LWa/p;", "Lkotlin/coroutines/d;", "parentContext", "LWa/g;", "channel", "<init>", "(Lkotlin/coroutines/d;LWa/g;)V", "LY8/t;", UxipConstants.f30680s, "c1", "(LY8/t;)V", "", "cause", "", "handled", "V0", "(Ljava/lang/Throwable;Z)V", Const.INTENT_KEY_PKGNAME, "()Z", "isActive", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class o<E> extends h<E> implements p<E> {
    public o(kotlin.coroutines.d dVar, g<E> gVar) {
        super(dVar, gVar, true, true);
    }

    @Override // kotlinx.coroutines.a
    public void V0(Throwable cause, boolean handled) {
        if (Z0().close(cause) || handled) {
            return;
        }
        K.a(getContext(), cause);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.g
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.coroutines.a
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void W0(Y8.t value) {
        s.a(Z0(), null, 1, null);
    }

    @Override // Wa.p
    public /* bridge */ /* synthetic */ s getChannel() {
        return getChannel();
    }
}
