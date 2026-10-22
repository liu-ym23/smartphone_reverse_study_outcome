package Z8;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\u001a&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/Enumeration;)Ljava/util/Iterator;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* renamed from: Z8.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1175x extends C1174w {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Z8/x$a", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Z8.x$a */
    public static final class a<T> implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Enumeration<T> f7704a;

        public a(Enumeration<T> enumeration) {
            this.f7704a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7704a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f7704a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static <T> Iterator<T> A(Enumeration<T> enumeration) {
        kotlin.jvm.internal.p.i(enumeration, "<this>");
        return new a(enumeration);
    }
}
