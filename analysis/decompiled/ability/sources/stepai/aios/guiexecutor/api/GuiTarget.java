package stepai.aios.guiexecutor.api;

import B7.a;
import android.graphics.Point;
import android.graphics.Rect;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiTarget;", "", "type", "Lstepai/aios/guiexecutor/api/TargetType;", "coordinate", "Landroid/graphics/Point;", "selector", "Lstepai/aios/guiexecutor/api/ElementSelector;", "bounds", "Landroid/graphics/Rect;", "description", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/TargetType;Landroid/graphics/Point;Lstepai/aios/guiexecutor/api/ElementSelector;Landroid/graphics/Rect;Ljava/lang/String;)V", "getType", "()Lstepai/aios/guiexecutor/api/TargetType;", "getCoordinate", "()Landroid/graphics/Point;", "getSelector", "()Lstepai/aios/guiexecutor/api/ElementSelector;", "getBounds", "()Landroid/graphics/Rect;", "getDescription", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTarget {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Rect bounds;
    private final Point coordinate;
    private final String description;
    private final ElementSelector selector;
    private final TargetType type;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiTarget$Companion;", "", AppAgent.CONSTRUCT, "()V", "coordinate", "Lstepai/aios/guiexecutor/api/GuiTarget;", "x", "", "y", "element", "selector", "Lstepai/aios/guiexecutor/api/ElementSelector;", "screen", "bounds", "rect", "Landroid/graphics/Rect;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final GuiTarget bounds(Rect rect) {
            k.f(rect, "rect");
            return new GuiTarget(TargetType.BOUNDS, null, null, rect, null, 22, null);
        }

        public final GuiTarget coordinate(int x10, int y) {
            return new GuiTarget(TargetType.COORDINATE, new Point(x10, y), null, null, null, 28, null);
        }

        public final GuiTarget element(ElementSelector selector) {
            k.f(selector, "selector");
            return new GuiTarget(TargetType.ELEMENT, null, selector, null, null, 26, null);
        }

        public final GuiTarget screen() {
            return new GuiTarget(TargetType.SCREEN, null, null, null, null, 30, null);
        }

        private Companion() {
        }
    }

    public GuiTarget(TargetType type, Point point, ElementSelector elementSelector, Rect rect, String str) {
        k.f(type, "type");
        this.type = type;
        this.coordinate = point;
        this.selector = elementSelector;
        this.bounds = rect;
        this.description = str;
    }

    public static /* synthetic */ GuiTarget copy$default(GuiTarget guiTarget, TargetType targetType, Point point, ElementSelector elementSelector, Rect rect, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            targetType = guiTarget.type;
        }
        if ((i & 2) != 0) {
            point = guiTarget.coordinate;
        }
        if ((i & 4) != 0) {
            elementSelector = guiTarget.selector;
        }
        if ((i & 8) != 0) {
            rect = guiTarget.bounds;
        }
        if ((i & 16) != 0) {
            str = guiTarget.description;
        }
        String str2 = str;
        ElementSelector elementSelector2 = elementSelector;
        return guiTarget.copy(targetType, point, elementSelector2, rect, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final TargetType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final Point getCoordinate() {
        return this.coordinate;
    }

    /* renamed from: component3, reason: from getter */
    public final ElementSelector getSelector() {
        return this.selector;
    }

    /* renamed from: component4, reason: from getter */
    public final Rect getBounds() {
        return this.bounds;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuiTarget copy(TargetType type, Point coordinate, ElementSelector selector, Rect bounds, String description) {
        k.f(type, "type");
        return new GuiTarget(type, coordinate, selector, bounds, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTarget)) {
            return false;
        }
        GuiTarget guiTarget = (GuiTarget) other;
        return this.type == guiTarget.type && k.b(this.coordinate, guiTarget.coordinate) && k.b(this.selector, guiTarget.selector) && k.b(this.bounds, guiTarget.bounds) && k.b(this.description, guiTarget.description);
    }

    public final Rect getBounds() {
        return this.bounds;
    }

    public final Point getCoordinate() {
        return this.coordinate;
    }

    public final String getDescription() {
        return this.description;
    }

    public final ElementSelector getSelector() {
        return this.selector;
    }

    public final TargetType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Point point = this.coordinate;
        int iHashCode2 = (iHashCode + (point == null ? 0 : point.hashCode())) * 31;
        ElementSelector elementSelector = this.selector;
        int iHashCode3 = (iHashCode2 + (elementSelector == null ? 0 : elementSelector.hashCode())) * 31;
        Rect rect = this.bounds;
        int iHashCode4 = (iHashCode3 + (rect == null ? 0 : rect.hashCode())) * 31;
        String str = this.description;
        return iHashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        TargetType targetType = this.type;
        Point point = this.coordinate;
        ElementSelector elementSelector = this.selector;
        Rect rect = this.bounds;
        String str = this.description;
        StringBuilder sb = new StringBuilder("GuiTarget(type=");
        sb.append(targetType);
        sb.append(", coordinate=");
        sb.append(point);
        sb.append(", selector=");
        sb.append(elementSelector);
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", description=");
        return a.q(sb, str, ")");
    }

    public /* synthetic */ GuiTarget(TargetType targetType, Point point, ElementSelector elementSelector, Rect rect, String str, int i, e eVar) {
        this(targetType, (i & 2) != 0 ? null : point, (i & 4) != 0 ? null : elementSelector, (i & 8) != 0 ? null : rect, (i & 16) != 0 ? null : str);
    }
}
