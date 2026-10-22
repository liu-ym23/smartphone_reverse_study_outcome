package io.ktor.util.debug.plugins;

import Z8.F;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.a;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Lio/ktor/util/debug/plugins/PluginsTrace;", "Lkotlin/coroutines/a;", "", "Lio/ktor/util/debug/plugins/PluginTraceElement;", "eventOrder", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(Ljava/util/List;)Lio/ktor/util/debug/plugins/PluginsTrace;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getEventOrder", "Key", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PluginsTrace extends a {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<PluginTraceElement> eventOrder;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/util/debug/plugins/PluginsTrace$Key;", "Lkotlin/coroutines/d$c;", "Lio/ktor/util/debug/plugins/PluginsTrace;", "<init>", "()V", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.debug.plugins.PluginsTrace$Key, reason: from kotlin metadata */
    public static final class Companion implements d.c<PluginsTrace> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PluginsTrace() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginsTrace copy$default(PluginsTrace pluginsTrace, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = pluginsTrace.eventOrder;
        }
        return pluginsTrace.copy(list);
    }

    public final List<PluginTraceElement> component1() {
        return this.eventOrder;
    }

    public final PluginsTrace copy(List<PluginTraceElement> eventOrder) {
        p.i(eventOrder, "eventOrder");
        return new PluginsTrace(eventOrder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PluginsTrace) && p.d(this.eventOrder, ((PluginsTrace) other).eventOrder);
    }

    public final List<PluginTraceElement> getEventOrder() {
        return this.eventOrder;
    }

    public int hashCode() {
        return this.eventOrder.hashCode();
    }

    public String toString() {
        return "PluginsTrace(" + F.A0(this.eventOrder, null, null, null, 0, null, null, 63, null) + ')';
    }

    public /* synthetic */ PluginsTrace(List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? new ArrayList() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginsTrace(List<PluginTraceElement> eventOrder) {
        super(INSTANCE);
        p.i(eventOrder, "eventOrder");
        this.eventOrder = eventOrder;
    }
}
