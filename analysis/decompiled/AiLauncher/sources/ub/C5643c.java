package ub;

import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LMb/f;", "", "codePointLimit", "", Const.INTENT_KEY_APIKEY, "(LMb/f;J)Z", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: ub.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5643c {
    public static final boolean a(InterfaceC0968f interfaceC0968f, long j10) throws IOException {
        kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
        try {
            InterfaceC0968f interfaceC0968fPeek = interfaceC0968f.peek();
            for (long j11 = 0; j11 < j10; j11++) {
                if (interfaceC0968fPeek.k()) {
                    return true;
                }
                int iU0 = interfaceC0968fPeek.U0();
                if (Character.isISOControl(iU0) && !Character.isWhitespace(iU0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
