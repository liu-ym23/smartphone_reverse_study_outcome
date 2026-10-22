package androidx.datastore.core.handlers;

import H7.c;
import S7.k;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/CorruptionHandler;", "Lkotlin/Function1;", "Landroidx/datastore/core/CorruptionException;", "produceNewData", AppAgent.CONSTRUCT, "(LS7/k;)V", "ex", "handleCorruption", "(Landroidx/datastore/core/CorruptionException;LH7/c;)Ljava/lang/Object;", "LS7/k;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    private final k produceNewData;

    public ReplaceFileCorruptionHandler(k produceNewData) {
        kotlin.jvm.internal.k.f(produceNewData, "produceNewData");
        this.produceNewData = produceNewData;
    }

    @Override // androidx.datastore.core.CorruptionHandler
    public Object handleCorruption(CorruptionException corruptionException, c<? super T> cVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
