package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Arrays;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0010@RX\u0090\u000e¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lpb/m1;", "Lpb/M0;", "LY8/p;", "bufferWithData", "<init>", "([JLkotlin/jvm/internal/i;)V", "", "requiredCapacity", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(I)V", "LY8/o;", "c", "e", "(J)V", "f", "()[J", Const.INTENT_KEY_APIKEY, "[J", "buffer", UxipConstants.f30680s, "I", Const.INTENT_KEY_UMID, "()I", "position", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class m1 extends M0<Y8.p> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long[] buffer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int position;

    public /* synthetic */ m1(long[] jArr, kotlin.jvm.internal.i iVar) {
        this(jArr);
    }

    @Override // pb.M0
    public /* bridge */ /* synthetic */ Y8.p a() {
        return Y8.p.b(f());
    }

    @Override // pb.M0
    public void b(int requiredCapacity) {
        if (Y8.p.n(this.buffer) < requiredCapacity) {
            long[] jArr = this.buffer;
            long[] jArrCopyOf = Arrays.copyOf(jArr, C5685n.f(requiredCapacity, Y8.p.n(jArr) * 2));
            kotlin.jvm.internal.p.h(jArrCopyOf, "copyOf(...)");
            this.buffer = Y8.p.e(jArrCopyOf);
        }
    }

    @Override // pb.M0
    /* renamed from: d, reason: from getter */
    public int getPosition() {
        return this.position;
    }

    public final void e(long c10) {
        M0.c(this, 0, 1, null);
        long[] jArr = this.buffer;
        int position = getPosition();
        this.position = position + 1;
        Y8.p.t(jArr, position, c10);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.buffer, getPosition());
        kotlin.jvm.internal.p.h(jArrCopyOf, "copyOf(...)");
        return Y8.p.e(jArrCopyOf);
    }

    public m1(long[] bufferWithData) {
        kotlin.jvm.internal.p.i(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = Y8.p.n(bufferWithData);
        b(10);
    }
}
