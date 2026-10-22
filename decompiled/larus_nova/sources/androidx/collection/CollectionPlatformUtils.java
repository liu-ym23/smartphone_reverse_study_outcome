package androidx.collection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0080\b¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/collection/CollectionPlatformUtils;", "", "<init>", "()V", "createIndexOutOfBoundsException", "Ljava/lang/IndexOutOfBoundsException;", "Lkotlin/IndexOutOfBoundsException;", "createIndexOutOfBoundsException$collection", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CollectionPlatformUtils {
    public static final CollectionPlatformUtils INSTANCE = null;

    static {
        INSTANCE = new CollectionPlatformUtils();
    }

    private CollectionPlatformUtils() {
    }

    public final IndexOutOfBoundsException createIndexOutOfBoundsException$collection() {
        return new ArrayIndexOutOfBoundsException();
    }
}
