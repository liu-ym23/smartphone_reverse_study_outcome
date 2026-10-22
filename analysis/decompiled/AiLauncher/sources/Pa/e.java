package Pa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import q9.InterfaceC5163b;
import q9.f;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000bJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"LPa/e;", ExifInterface.LONGITUDE_EAST, "LPa/c;", "", "", "elements", "addAll", "(Ljava/util/Collection;)LPa/e;", "LPa/e$a;", "builder", "()LPa/e$a;", Const.INTENT_KEY_APIKEY, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface e<E> extends c<E>, b {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LPa/e$a;", ExifInterface.LONGITUDE_EAST, "", "", "LPa/e;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()LPa/e;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<E> extends Set<E>, Collection, InterfaceC5163b, f {
        e<E> build();
    }

    @Override // java.util.Set, java.util.Collection
    e<E> addAll(Collection<? extends E> elements);

    a<E> builder();
}
