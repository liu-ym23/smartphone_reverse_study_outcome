package io.ktor.util.debug.plugins;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\r¨\u0006\u001e"}, d2 = {"Lio/ktor/util/debug/plugins/PluginTraceElement;", "", "", "pluginName", "handler", "Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "event", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;)Lio/ktor/util/debug/plugins/PluginTraceElement;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPluginName", "getHandler", "Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "getEvent", "PluginEvent", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PluginTraceElement {
    private final PluginEvent event;
    private final String handler;
    private final String pluginName;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/util/debug/plugins/PluginTraceElement$PluginEvent;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "FINISHED", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PluginEvent {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PluginEvent[] $VALUES;
        public static final PluginEvent STARTED = new PluginEvent("STARTED", 0);
        public static final PluginEvent FINISHED = new PluginEvent("FINISHED", 1);

        private static final /* synthetic */ PluginEvent[] $values() {
            return new PluginEvent[]{STARTED, FINISHED};
        }

        static {
            PluginEvent[] pluginEventArr$values = $values();
            $VALUES = pluginEventArr$values;
            $ENTRIES = a.a(pluginEventArr$values);
        }

        private PluginEvent(String str, int i10) {
        }

        public static InterfaceC4149a<PluginEvent> getEntries() {
            return $ENTRIES;
        }

        public static PluginEvent valueOf(String str) {
            return (PluginEvent) Enum.valueOf(PluginEvent.class, str);
        }

        public static PluginEvent[] values() {
            return (PluginEvent[]) $VALUES.clone();
        }
    }

    public PluginTraceElement(String pluginName, String handler, PluginEvent event) {
        p.i(pluginName, "pluginName");
        p.i(handler, "handler");
        p.i(event, "event");
        this.pluginName = pluginName;
        this.handler = handler;
        this.event = event;
    }

    public static /* synthetic */ PluginTraceElement copy$default(PluginTraceElement pluginTraceElement, String str, String str2, PluginEvent pluginEvent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pluginTraceElement.pluginName;
        }
        if ((i10 & 2) != 0) {
            str2 = pluginTraceElement.handler;
        }
        if ((i10 & 4) != 0) {
            pluginEvent = pluginTraceElement.event;
        }
        return pluginTraceElement.copy(str, str2, pluginEvent);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPluginName() {
        return this.pluginName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHandler() {
        return this.handler;
    }

    /* renamed from: component3, reason: from getter */
    public final PluginEvent getEvent() {
        return this.event;
    }

    public final PluginTraceElement copy(String pluginName, String handler, PluginEvent event) {
        p.i(pluginName, "pluginName");
        p.i(handler, "handler");
        p.i(event, "event");
        return new PluginTraceElement(pluginName, handler, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PluginTraceElement)) {
            return false;
        }
        PluginTraceElement pluginTraceElement = (PluginTraceElement) other;
        return p.d(this.pluginName, pluginTraceElement.pluginName) && p.d(this.handler, pluginTraceElement.handler) && this.event == pluginTraceElement.event;
    }

    public final PluginEvent getEvent() {
        return this.event;
    }

    public final String getHandler() {
        return this.handler;
    }

    public final String getPluginName() {
        return this.pluginName;
    }

    public int hashCode() {
        return (((this.pluginName.hashCode() * 31) + this.handler.hashCode()) * 31) + this.event.hashCode();
    }

    public String toString() {
        return "PluginTraceElement(pluginName=" + this.pluginName + ", handler=" + this.handler + ", event=" + this.event + ')';
    }
}
