package com.mdisdk.action;

import H7.c;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B'\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\n\u001a\u00020\tH @¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/mdisdk/action/Action;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "tag", "", "args", AppAgent.CONSTRUCT, "(Ljava/lang/String;[Ljava/lang/Object;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Action<T> {
    private final Object[] args;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public Action() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Object[] getArgs() {
        return this.args;
    }

    public String getTag() {
        return this.tag;
    }

    public abstract Object perform$mdisdk_release(TaskContext taskContext, c<? super ActionResult<? extends T>> cVar);

    public Action(String tag, Object[] objArr) {
        k.f(tag, "tag");
        this.tag = tag;
        this.args = objArr;
    }

    public /* synthetic */ Action(String str, Object[] objArr, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : objArr);
    }
}
