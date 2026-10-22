package androidx.datastore.core.handlers;

import H7.c;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Landroidx/datastore/core/handlers/NoOpCorruptionHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/CorruptionHandler;", AppAgent.CONSTRUCT, "()V", "Landroidx/datastore/core/CorruptionException;", "ex", "handleCorruption", "(Landroidx/datastore/core/CorruptionException;LH7/c;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class NoOpCorruptionHandler<T> implements CorruptionHandler<T> {
    @Override // androidx.datastore.core.CorruptionHandler
    public Object handleCorruption(CorruptionException corruptionException, c<? super T> cVar) throws CorruptionException {
        throw corruptionException;
    }
}
