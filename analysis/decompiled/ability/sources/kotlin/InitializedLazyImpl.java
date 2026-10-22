package kotlin;

import C7.f;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/InitializedLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LC7/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InitializedLazyImpl<T> implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4884a;

    public InitializedLazyImpl(Object obj) {
        this.f4884a = obj;
    }

    @Override // C7.f
    /* renamed from: getValue, reason: from getter */
    public final Object getF4884a() {
        return this.f4884a;
    }

    @Override // C7.f
    public final boolean isInitialized() {
        return true;
    }

    public final String toString() {
        return String.valueOf(this.f4884a);
    }
}
