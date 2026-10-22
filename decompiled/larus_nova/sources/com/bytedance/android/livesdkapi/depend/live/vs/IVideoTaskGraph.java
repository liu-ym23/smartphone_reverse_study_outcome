package com.bytedance.android.livesdkapi.depend.live.vs;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTaskGraph;", "", "isDestroyed", "", "()Z", "setDestroyed", "(Z)V", "start", "", "task", "Ljava/lang/Class;", "Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTask;", "extra", "", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVideoTaskGraph {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void start$default(IVideoTaskGraph r100, Class r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = MapsKt.emptyMap();
        L6:
            r100.start(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    boolean isDestroyed();

    void setDestroyed(boolean r100);

    void start(Class<? extends IVideoTask> r100, Map<String, ? extends Object> r101);
}
