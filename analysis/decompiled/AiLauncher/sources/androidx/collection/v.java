package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import c0.C1481a;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a)\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {ExifInterface.LONGITUDE_EAST, "Landroidx/collection/u;", "", "key", "c", "(Landroidx/collection/u;I)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroidx/collection/u;)V", "", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "DELETED", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f11747a = new Object();

    public static final <E> E c(u<E> uVar, int i10) {
        E e10;
        kotlin.jvm.internal.p.i(uVar, "<this>");
        int iA = C1481a.a(uVar.f11744b, uVar.f11746d, i10);
        if (iA < 0 || (e10 = (E) uVar.f11745c[iA]) == f11747a) {
            return null;
        }
        return e10;
    }

    public static final <E> void d(u<E> uVar) {
        int i10 = uVar.f11746d;
        int[] iArr = uVar.f11744b;
        Object[] objArr = uVar.f11745c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f11747a) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        uVar.f11743a = false;
        uVar.f11746d = i11;
    }
}
