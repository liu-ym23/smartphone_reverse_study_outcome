package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes5.dex */
public abstract class CollectionStartEvent extends NodeEvent {
    private final DumperOptions.FlowStyle flowStyle;
    private final boolean implicit;
    private final String tag;

    public CollectionStartEvent(String str, String str2, boolean z10, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(str, mark, mark2);
        this.tag = str2;
        this.implicit = z10;
        if (flowStyle == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.flowStyle = flowStyle;
    }

    @Override // org.yaml.snakeyaml.events.NodeEvent, org.yaml.snakeyaml.events.Event
    public String getArguments() {
        return super.getArguments() + ", tag=" + this.tag + ", implicit=" + this.implicit;
    }

    public DumperOptions.FlowStyle getFlowStyle() {
        return this.flowStyle;
    }

    public boolean getImplicit() {
        return this.implicit;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isFlow() {
        return DumperOptions.FlowStyle.FLOW == this.flowStyle;
    }
}
