package Ua;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006\"\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0012¨\u0006\u0015"}, d2 = {"", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LZa/C;", Const.INTENT_KEY_APIKEY, "LZa/C;", "COMPLETING_ALREADY", Const.INTENT_KEY_PKGNAME, "COMPLETING_WAITING_CHILDREN", "c", "COMPLETING_RETRY", Const.INTENT_KEY_UMID, "TOO_LATE_TO_CANCEL", "e", "SEALED", "LUa/d0;", "f", "LUa/d0;", "EMPTY_NEW", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Za.C f6402a = new Za.C("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final Za.C f6403b = new Za.C("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    public static final Za.C f6404c = new Za.C("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    public static final Za.C f6405d = new Za.C("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    public static final Za.C f6406e = new Za.C("SEALED");

    /* renamed from: f, reason: collision with root package name */
    public static final C1051d0 f6407f = new C1051d0(false);

    /* renamed from: g, reason: collision with root package name */
    public static final C1051d0 f6408g = new C1051d0(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC1077q0 ? new C1078r0((InterfaceC1077q0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC1077q0 interfaceC1077q0;
        C1078r0 c1078r0 = obj instanceof C1078r0 ? (C1078r0) obj : null;
        return (c1078r0 == null || (interfaceC1077q0 = c1078r0.state) == null) ? obj : interfaceC1077q0;
    }
}
