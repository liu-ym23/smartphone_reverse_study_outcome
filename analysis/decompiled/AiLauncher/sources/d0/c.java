package d0;

import Z8.AbstractC1156d;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\tJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ld0/c;", ExifInterface.LONGITUDE_EAST, "", "Ld0/b;", "", "fromIndex", "toIndex", "subList", "(II)Ld0/c;", Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface c<E> extends List<E>, b<E>, InterfaceC5162a {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0016¨\u0006\u0018"}, d2 = {"Ld0/c$a;", ExifInterface.LONGITUDE_EAST, "Ld0/c;", "LZ8/d;", "source", "", "fromIndex", "toIndex", "<init>", "(Ld0/c;II)V", "index", "get", "(I)Ljava/lang/Object;", "subList", "(II)Ld0/c;", Const.INTENT_KEY_PKGNAME, "Ld0/c;", "c", "I", Const.INTENT_KEY_UMID, "e", "_size", "()I", ContentDisposition.Parameters.Size, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a<E> extends AbstractC1156d<E> implements c<E> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final c<E> source;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int fromIndex;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final int toIndex;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int _size;

        /* JADX WARN: Multi-variable type inference failed */
        public a(c<? extends E> cVar, int i10, int i11) {
            this.source = cVar;
            this.fromIndex = i10;
            this.toIndex = i11;
            h0.d.c(i10, i11, cVar.size());
            this._size = i11 - i10;
        }

        @Override // Z8.AbstractC1154b
        /* renamed from: c, reason: from getter */
        public int get_size() {
            return this._size;
        }

        @Override // Z8.AbstractC1156d, java.util.List
        public E get(int index) {
            h0.d.a(index, this._size);
            return this.source.get(this.fromIndex + index);
        }

        @Override // Z8.AbstractC1156d, java.util.List
        public c<E> subList(int fromIndex, int toIndex) {
            h0.d.c(fromIndex, toIndex, this._size);
            c<E> cVar = this.source;
            int i10 = this.fromIndex;
            return new a(cVar, fromIndex + i10, i10 + toIndex);
        }
    }

    @Override // java.util.List
    default c<E> subList(int fromIndex, int toIndex) {
        return new a(this, fromIndex, toIndex);
    }
}
