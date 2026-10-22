package Ua;

import Za.C1188h;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u000e\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/l;", "Lkotlinx/coroutines/b;", "handler", "LY8/t;", "c", "(LUa/l;Lkotlinx/coroutines/b;)V", "Le9/c;", "delegate", "Lkotlinx/coroutines/c;", Const.INTENT_KEY_PKGNAME, "(Le9/c;)Lkotlinx/coroutines/c;", "LUa/a0;", "handle", Const.INTENT_KEY_APIKEY, "(LUa/l;LUa/a0;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1072o {
    public static final void a(InterfaceC1066l<?> interfaceC1066l, InterfaceC1045a0 interfaceC1045a0) {
        c(interfaceC1066l, new C1047b0(interfaceC1045a0));
    }

    public static final <T> kotlinx.coroutines.c<T> b(InterfaceC4014c<? super T> interfaceC4014c) {
        if (!(interfaceC4014c instanceof C1188h)) {
            return new kotlinx.coroutines.c<>(interfaceC4014c, 1);
        }
        kotlinx.coroutines.c<T> cVarN = ((C1188h) interfaceC4014c).n();
        if (cVarN != null) {
            if (!cVarN.R()) {
                cVarN = null;
            }
            if (cVarN != null) {
                return cVarN;
            }
        }
        return new kotlinx.coroutines.c<>(interfaceC4014c, 2);
    }

    public static final <T> void c(InterfaceC1066l<? super T> interfaceC1066l, kotlinx.coroutines.b bVar) {
        if (!(interfaceC1066l instanceof kotlinx.coroutines.c)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((kotlinx.coroutines.c) interfaceC1066l).L(bVar);
    }
}
