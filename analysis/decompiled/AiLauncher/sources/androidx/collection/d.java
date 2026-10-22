package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import c0.C1481a;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.LONGITUDE_EAST, "Landroidx/collection/b;", "", "hash", Const.INTENT_KEY_PKGNAME, "(Landroidx/collection/b;I)I", "", "key", "c", "(Landroidx/collection/b;Ljava/lang/Object;I)I", Const.INTENT_KEY_UMID, "(Landroidx/collection/b;)I", ContentDisposition.Parameters.Size, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/collection/b;I)V", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {
    public static final <E> void a(b<E> bVar, int i10) {
        kotlin.jvm.internal.p.i(bVar, "<this>");
        bVar.l(new int[i10]);
        bVar.k(new Object[i10]);
    }

    public static final <E> int b(b<E> bVar, int i10) {
        kotlin.jvm.internal.p.i(bVar, "<this>");
        try {
            return C1481a.a(bVar.getHashes(), bVar.i(), i10);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> int c(b<E> bVar, Object obj, int i10) {
        kotlin.jvm.internal.p.i(bVar, "<this>");
        int i11 = bVar.i();
        if (i11 == 0) {
            return -1;
        }
        int iB = b(bVar, i10);
        if (iB < 0 || kotlin.jvm.internal.p.d(obj, bVar.getArray()[iB])) {
            return iB;
        }
        int i12 = iB + 1;
        while (i12 < i11 && bVar.getHashes()[i12] == i10) {
            if (kotlin.jvm.internal.p.d(obj, bVar.getArray()[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iB - 1; i13 >= 0 && bVar.getHashes()[i13] == i10; i13--) {
            if (kotlin.jvm.internal.p.d(obj, bVar.getArray()[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    public static final <E> int d(b<E> bVar) {
        kotlin.jvm.internal.p.i(bVar, "<this>");
        return c(bVar, null, 0);
    }
}
