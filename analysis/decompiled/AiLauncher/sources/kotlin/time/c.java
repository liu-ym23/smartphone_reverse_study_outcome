package kotlin.time;

import com.autonavi.aps.amapapi.config.Const;
import i9.C4179b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\t\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/time/Instant;", "instant", "", Const.INTENT_KEY_APIKEY, "(Lkotlin/time/Instant;)Ljava/lang/Object;", "LMa/a;", "LMa/a;", "getSystemClock$annotations", "()V", "systemClock", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Ma.a f36193a = C4179b.f33080a.d();

    public static final Object a(Instant instant) {
        p.i(instant, "instant");
        return new InstantSerialized(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
    }
}
