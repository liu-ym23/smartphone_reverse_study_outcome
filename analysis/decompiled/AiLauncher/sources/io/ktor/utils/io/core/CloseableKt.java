package io.ktor.utils.io.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import n9.C4946a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u0006\u001a\u00028\u0001\"\u0010\b\u0000\u0010\u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001\"\u0004\b\u0001\u0010\u0003*\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/Function1;", "block", "use", "(Ljava/io/Closeable;Lp9/l;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t10, InterfaceC5074l<? super T, ? extends R> block) throws Exception {
        p.i(block, "block");
        T t11 = t10;
        try {
            R rInvoke = block.invoke(t11);
            n.b(1);
            C4946a.a(t11, null);
            n.a(1);
            return rInvoke;
        } finally {
        }
    }
}
