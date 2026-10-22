package io.ktor.utils.io.core;

import Y8.t;
import fb.C4074a;
import fb.s;
import fb.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lfb/s;", "LY8/t;", "block", "Lfb/v;", "buildPacket", "(Lp9/l;)Lfb/v;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuilderKt {
    public static final v buildPacket(InterfaceC5074l<? super s, t> block) {
        p.i(block, "block");
        C4074a c4074a = new C4074a();
        block.invoke(c4074a);
        return c4074a;
    }
}
