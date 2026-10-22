package androidx.datastore.core;

import H7.c;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001b\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Landroidx/datastore/core/CorruptionHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/datastore/core/CorruptionException;", "ex", "handleCorruption", "(Landroidx/datastore/core/CorruptionException;LH7/c;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public interface CorruptionHandler<T> {
    Object handleCorruption(CorruptionException corruptionException, c<? super T> cVar);
}
