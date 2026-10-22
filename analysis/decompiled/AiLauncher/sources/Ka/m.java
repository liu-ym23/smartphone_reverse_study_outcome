package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001aG\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f*\f\b\u0002\u0010\u000e\"\u00020\r2\u00020\r¨\u0006\u000f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "LKa/l;", "Le9/c;", "LY8/t;", "", "block", "LKa/j;", Const.INTENT_KEY_PKGNAME, "(Lp9/p;)LKa/j;", "", Const.INTENT_KEY_APIKEY, "(Lp9/p;)Ljava/util/Iterator;", "", "State", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes5.dex */
public class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ka/m$a", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements j<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p9.p f4233a;

        public a(p9.p pVar) {
            this.f4233a = pVar;
        }

        @Override // Ka.j
        public Iterator<T> iterator() {
            return m.a(this.f4233a);
        }
    }

    public static <T> Iterator<T> a(p9.p<? super l<? super T>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        k kVar = new k();
        kVar.m(IntrinsicsKt__IntrinsicsJvmKt.b(block, kVar, kVar));
        return kVar;
    }

    public static <T> j<T> b(p9.p<? super l<? super T>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        return new a(block);
    }
}
