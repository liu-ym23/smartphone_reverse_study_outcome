package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lstepai/aios/guiagent/llm/ToolChoice;", "", AppAgent.CONSTRUCT, "()V", "None", "Auto", "Required", "Lstepai/aios/guiagent/llm/ToolChoice$Auto;", "Lstepai/aios/guiagent/llm/ToolChoice$None;", "Lstepai/aios/guiagent/llm/ToolChoice$Required;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ToolChoice {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lstepai/aios/guiagent/llm/ToolChoice$Auto;", "Lstepai/aios/guiagent/llm/ToolChoice;", AppAgent.CONSTRUCT, "()V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Auto extends ToolChoice {
        public static final Auto INSTANCE = new Auto();

        private Auto() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lstepai/aios/guiagent/llm/ToolChoice$None;", "Lstepai/aios/guiagent/llm/ToolChoice;", AppAgent.CONSTRUCT, "()V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class None extends ToolChoice {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lstepai/aios/guiagent/llm/ToolChoice$Required;", "Lstepai/aios/guiagent/llm/ToolChoice;", "tools", "", "Lstepai/aios/guiagent/llm/Tool;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getTools", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Required extends ToolChoice {
        private final List<Tool> tools;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Required(List<Tool> tools) {
            super(null);
            k.f(tools, "tools");
            this.tools = tools;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Required copy$default(Required required, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = required.tools;
            }
            return required.copy(list);
        }

        public final List<Tool> component1() {
            return this.tools;
        }

        public final Required copy(List<Tool> tools) {
            k.f(tools, "tools");
            return new Required(tools);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Required) && k.b(this.tools, ((Required) other).tools);
        }

        public final List<Tool> getTools() {
            return this.tools;
        }

        public int hashCode() {
            return this.tools.hashCode();
        }

        public String toString() {
            return "Required(tools=" + this.tools + ")";
        }
    }

    public /* synthetic */ ToolChoice(e eVar) {
        this();
    }

    private ToolChoice() {
    }
}
