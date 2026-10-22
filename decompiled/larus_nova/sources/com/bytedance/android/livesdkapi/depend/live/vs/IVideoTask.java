package com.bytedance.android.livesdkapi.depend.live.vs;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTask;", "", "()V", "taskGraph", "Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTaskGraph;", "getTaskGraph", "()Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTaskGraph;", "setTaskGraph", "(Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTaskGraph;)V", "process", "", "extra", "", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IVideoTask {
    public IVideoTaskGraph taskGraph;

    public IVideoTask() {
    }

    public abstract void process(Map<String, ? extends Object> r100);

    public final IVideoTaskGraph getTaskGraph() {
        IVideoTaskGraph r100 = this.taskGraph;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskGraph");
    L5:
        return r100;
    }

    public final void setTaskGraph(IVideoTaskGraph r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskGraph = r100;
    }
}
