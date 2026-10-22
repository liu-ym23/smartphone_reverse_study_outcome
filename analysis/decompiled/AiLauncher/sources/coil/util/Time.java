package coil.util;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcoil/util/Time;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()J", "Lkotlin/Function0;", Const.INTENT_KEY_PKGNAME, "Lp9/a;", Const.JSON_KEY_PROVIDER, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Time {

    /* renamed from: a, reason: collision with root package name */
    public static final Time f15818a = new Time();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static InterfaceC5063a<Long> provider = Time$provider$1.f15820a;

    public final long a() {
        return provider.invoke().longValue();
    }
}
