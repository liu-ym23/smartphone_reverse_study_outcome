package rb;

import Z8.C1165m;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0012"}, d2 = {"Lrb/h;", "", "<init>", "()V", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[C", "array", "LY8/t;", Const.INTENT_KEY_APIKEY, "([C)V", "LZ8/m;", "LZ8/m;", "arrays", "I", "charsTotal", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5258h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C1165m<char[]> arrays = new C1165m<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int charsTotal;

    public final void a(char[] array) {
        kotlin.jvm.internal.p.i(array, "array");
        synchronized (this) {
            try {
                if (this.charsTotal + array.length < C5256f.f38982a) {
                    this.charsTotal += array.length;
                    this.arrays.addLast(array);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final char[] b(int size) {
        char[] cArrX;
        synchronized (this) {
            cArrX = this.arrays.x();
            if (cArrX != null) {
                this.charsTotal -= cArrX.length;
            } else {
                cArrX = null;
            }
        }
        return cArrX == null ? new char[size] : cArrX;
    }
}
