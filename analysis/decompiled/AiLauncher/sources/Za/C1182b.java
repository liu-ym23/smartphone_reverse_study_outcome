package Za;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\t*\u00028\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a0\u0010\u0013\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"LZa/z;", ExifInterface.LATITUDE_SOUTH, "", "id", "Lkotlin/Function2;", "createNewSegment", "LZa/A;", "c", "(LZa/z;JLp9/p;)Ljava/lang/Object;", "LZa/c;", "N", Const.INTENT_KEY_PKGNAME, "(LZa/c;)LZa/c;", "LOa/c;", "", "delta", "Lkotlin/Function1;", "", "condition", "addConditionally", "(LOa/c;ILp9/l;)Z", "LZa/C;", Const.INTENT_KEY_APIKEY, "LZa/C;", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1182b {

    /* renamed from: a, reason: collision with root package name */
    public static final C f7725a = new C("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [Za.c] */
    public static final <N extends AbstractC1183c<N>> N b(N n10) {
        while (true) {
            Object objG = n10.g();
            if (objG == f7725a) {
                return n10;
            }
            ?? r02 = (AbstractC1183c) objG;
            if (r02 != 0) {
                n10 = r02;
            } else if (n10.m()) {
                return n10;
            }
        }
    }

    public static final <S extends z<S>> Object c(S s10, long j10, p9.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.id >= j10 && !s10.k()) {
                return A.a(s10);
            }
            Object objG = s10.g();
            if (objG == f7725a) {
                return A.a(f7725a);
            }
            S sInvoke = (S) ((AbstractC1183c) objG);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s10.id + 1), s10);
                if (s10.o(sInvoke)) {
                    if (s10.k()) {
                        s10.n();
                    }
                }
            }
            s10 = sInvoke;
        }
    }
}
