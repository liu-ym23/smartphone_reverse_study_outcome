package io.ktor.network.util;

import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import io.ktor.util.date.DateJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001aS\u0010\r\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f*\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"LUa/M;", "", "name", "", "timeoutMs", "Lkotlin/Function0;", "clock", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "", "onTimeout", "Lio/ktor/network/util/Timeout;", "createTimeout", "(LUa/M;Ljava/lang/String;JLp9/a;Lp9/l;)Lio/ktor/network/util/Timeout;", ExifInterface.GPS_DIRECTION_TRUE, "block", "withTimeout", "(Lio/ktor/network/util/Timeout;Lp9/a;)Ljava/lang/Object;", "INFINITE_TIMEOUT_MS", "J", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final long INFINITE_TIMEOUT_MS = Long.MAX_VALUE;

    public static final Timeout createTimeout(M m10, String name, long j10, InterfaceC5063a<Long> clock, InterfaceC5074l<? super InterfaceC4014c<? super t>, ? extends Object> onTimeout) {
        p.i(m10, "<this>");
        p.i(name, "name");
        p.i(clock, "clock");
        p.i(onTimeout, "onTimeout");
        return new Timeout(name, j10, clock, m10, onTimeout);
    }

    public static /* synthetic */ Timeout createTimeout$default(M m10, String str, long j10, InterfaceC5063a interfaceC5063a, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 4) != 0) {
            interfaceC5063a = new InterfaceC5063a() { // from class: io.ktor.network.util.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Long.valueOf(DateJvmKt.getTimeMillis());
                }
            };
        }
        return createTimeout(m10, str, j10, interfaceC5063a, interfaceC5074l);
    }

    public static final <T> T withTimeout(Timeout timeout, InterfaceC5063a<? extends T> block) {
        p.i(block, "block");
        if (timeout == null) {
            return block.invoke();
        }
        timeout.start();
        try {
            return block.invoke();
        } finally {
            n.b(1);
            timeout.stop();
            n.a(1);
        }
    }
}
