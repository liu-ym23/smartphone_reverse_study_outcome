package coil.util;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class Time$provider$1 extends FunctionReferenceImpl implements InterfaceC5063a<Long> {

    /* renamed from: a, reason: collision with root package name */
    public static final Time$provider$1 f15820a = new Time$provider$1();

    public Time$provider$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    @Override // p9.InterfaceC5063a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
