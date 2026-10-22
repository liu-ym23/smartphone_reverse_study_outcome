package org.yaml.snakeyaml.events;

import com.autonavi.aps.amapapi.config.Const;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes5.dex */
public final class ScalarEvent extends NodeEvent {
    private final ImplicitTuple implicit;
    private final DumperOptions.ScalarStyle style;
    private final String tag;
    private final String value;

    public ScalarEvent(String str, String str2, ImplicitTuple implicitTuple, String str3, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(str, mark, mark2);
        this.tag = str2;
        this.implicit = implicitTuple;
        if (str3 == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.value = str3;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = scalarStyle;
    }

    @Override // org.yaml.snakeyaml.events.NodeEvent, org.yaml.snakeyaml.events.Event
    public String getArguments() {
        return super.getArguments() + ", tag=" + this.tag + ", style=" + this.style + Const.STR_MART_COMMA + this.implicit + ", value=" + this.value;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.Scalar;
    }

    public ImplicitTuple getImplicit() {
        return this.implicit;
    }

    public DumperOptions.ScalarStyle getScalarStyle() {
        return this.style;
    }

    public String getTag() {
        return this.tag;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isDQuoted() {
        return this.style == DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    public boolean isFolded() {
        return this.style == DumperOptions.ScalarStyle.FOLDED;
    }

    public boolean isJson() {
        return this.style == DumperOptions.ScalarStyle.JSON_SCALAR_STYLE;
    }

    public boolean isLiteral() {
        return this.style == DumperOptions.ScalarStyle.LITERAL;
    }

    public boolean isPlain() {
        return this.style == DumperOptions.ScalarStyle.PLAIN;
    }

    public boolean isSQuoted() {
        return this.style == DumperOptions.ScalarStyle.SINGLE_QUOTED;
    }
}
