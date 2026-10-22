package io.ktor.server.cio.internal;

import Ua.C1058h;
import Ua.I;
import Ua.M;
import Ua.Y;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u0018\u0010\f\u001a\u00020\t*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "", "block", "runBlockingBridge", "(Lp9/p;)Ljava/lang/Object;", "LUa/Y;", "LUa/I;", "getIOBridge", "(LUa/Y;)LUa/I;", "IOBridge", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineUtilsJvmKt {
    public static final I getIOBridge(Y y10) {
        p.i(y10, "<this>");
        return Y.b();
    }

    public static final <T> T runBlockingBridge(p9.p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> block) {
        p.i(block, "block");
        return (T) C1058h.b(null, block, 1, null);
    }
}
