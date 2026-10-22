package eb;

import Za.C;
import Za.F;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\f\"\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010\"\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010\"\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010\"\u0014\u0010\u0019\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\f¨\u0006\u001a"}, d2 = {"", "permits", "acquiredPermits", "Leb/g;", Const.INTENT_KEY_APIKEY, "(II)Leb/g;", "", "id", "Leb/k;", "prev", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(JLeb/k;)Leb/k;", "I", "MAX_SPIN_CYCLES", "LZa/C;", Const.INTENT_KEY_PKGNAME, "LZa/C;", "PERMIT", "c", "TAKEN", Const.INTENT_KEY_UMID, "BROKEN", "e", "CANCELLED", "f", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int f32437a = F.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* renamed from: b, reason: collision with root package name */
    public static final C f32438b = new C("PERMIT");

    /* renamed from: c, reason: collision with root package name */
    public static final C f32439c = new C("TAKEN");

    /* renamed from: d, reason: collision with root package name */
    public static final C f32440d = new C("BROKEN");

    /* renamed from: e, reason: collision with root package name */
    public static final C f32441e = new C("CANCELLED");

    /* renamed from: f, reason: collision with root package name */
    public static final int f32442f = F.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final g a(int i10, int i11) {
        return new i(i10, i11);
    }

    public static /* synthetic */ g b(int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return a(i10, i11);
    }

    public static final k j(long j10, k kVar) {
        return new k(j10, kVar, 0);
    }
}
