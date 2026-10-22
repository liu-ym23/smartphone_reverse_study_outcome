package stepai.aios.guiexecutor.api;

import W7.c;
import Y7.f;
import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import g1.AbstractC1451a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003J]\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiCommand;", "", "id", "", "type", "Lstepai/aios/guiexecutor/api/GuiCommandType;", TypedValues.AttributesType.S_TARGET, "Lstepai/aios/guiexecutor/api/GuiTarget;", "parameters", "Lstepai/aios/guiexecutor/api/GuiParameters;", "options", "Lstepai/aios/guiexecutor/api/GuiOptions;", "metadata", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lstepai/aios/guiagent/config/Action;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lstepai/aios/guiexecutor/api/GuiCommandType;Lstepai/aios/guiexecutor/api/GuiTarget;Lstepai/aios/guiexecutor/api/GuiParameters;Lstepai/aios/guiexecutor/api/GuiOptions;Ljava/util/Map;Lstepai/aios/guiagent/config/Action;)V", "getId", "()Ljava/lang/String;", "getType", "()Lstepai/aios/guiexecutor/api/GuiCommandType;", "getTarget", "()Lstepai/aios/guiexecutor/api/GuiTarget;", "getParameters", "()Lstepai/aios/guiexecutor/api/GuiParameters;", "getOptions", "()Lstepai/aios/guiexecutor/api/GuiOptions;", "getMetadata", "()Ljava/util/Map;", "getAction", "()Lstepai/aios/guiagent/config/Action;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiCommand {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Action action;
    private final String id;
    private final Map<String, Object> metadata;
    private final GuiOptions options;
    private final GuiParameters parameters;
    private final GuiTarget target;
    private final GuiCommandType type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiCommand$Companion;", "", AppAgent.CONSTRUCT, "()V", "generateId", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String generateId() {
            return "gui_cmd_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(1000, 9999, 1));
        }

        private Companion() {
        }
    }

    public GuiCommand(String id, GuiCommandType type, GuiTarget target, GuiParameters parameters, GuiOptions options, Map<String, ? extends Object> metadata, Action action) {
        k.f(id, "id");
        k.f(type, "type");
        k.f(target, "target");
        k.f(parameters, "parameters");
        k.f(options, "options");
        k.f(metadata, "metadata");
        this.id = id;
        this.type = type;
        this.target = target;
        this.parameters = parameters;
        this.options = options;
        this.metadata = metadata;
        this.action = action;
    }

    public static /* synthetic */ GuiCommand copy$default(GuiCommand guiCommand, String str, GuiCommandType guiCommandType, GuiTarget guiTarget, GuiParameters guiParameters, GuiOptions guiOptions, Map map, Action action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiCommand.id;
        }
        if ((i & 2) != 0) {
            guiCommandType = guiCommand.type;
        }
        if ((i & 4) != 0) {
            guiTarget = guiCommand.target;
        }
        if ((i & 8) != 0) {
            guiParameters = guiCommand.parameters;
        }
        if ((i & 16) != 0) {
            guiOptions = guiCommand.options;
        }
        if ((i & 32) != 0) {
            map = guiCommand.metadata;
        }
        if ((i & 64) != 0) {
            action = guiCommand.action;
        }
        Map map2 = map;
        Action action2 = action;
        GuiOptions guiOptions2 = guiOptions;
        GuiTarget guiTarget2 = guiTarget;
        return guiCommand.copy(str, guiCommandType, guiTarget2, guiParameters, guiOptions2, map2, action2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final GuiCommandType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final GuiTarget getTarget() {
        return this.target;
    }

    /* renamed from: component4, reason: from getter */
    public final GuiParameters getParameters() {
        return this.parameters;
    }

    /* renamed from: component5, reason: from getter */
    public final GuiOptions getOptions() {
        return this.options;
    }

    public final Map<String, Object> component6() {
        return this.metadata;
    }

    /* renamed from: component7, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    public final GuiCommand copy(String id, GuiCommandType type, GuiTarget target, GuiParameters parameters, GuiOptions options, Map<String, ? extends Object> metadata, Action action) {
        k.f(id, "id");
        k.f(type, "type");
        k.f(target, "target");
        k.f(parameters, "parameters");
        k.f(options, "options");
        k.f(metadata, "metadata");
        return new GuiCommand(id, type, target, parameters, options, metadata, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiCommand)) {
            return false;
        }
        GuiCommand guiCommand = (GuiCommand) other;
        return k.b(this.id, guiCommand.id) && this.type == guiCommand.type && k.b(this.target, guiCommand.target) && k.b(this.parameters, guiCommand.parameters) && k.b(this.options, guiCommand.options) && k.b(this.metadata, guiCommand.metadata) && k.b(this.action, guiCommand.action);
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final GuiOptions getOptions() {
        return this.options;
    }

    public final GuiParameters getParameters() {
        return this.parameters;
    }

    public final GuiTarget getTarget() {
        return this.target;
    }

    public final GuiCommandType getType() {
        return this.type;
    }

    public int hashCode() {
        int iF = a.f(this.metadata, (this.options.hashCode() + ((this.parameters.hashCode() + ((this.target.hashCode() + ((this.type.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31)) * 31)) * 31, 31);
        Action action = this.action;
        return iF + (action == null ? 0 : action.hashCode());
    }

    public String toString() {
        return "GuiCommand(id=" + this.id + ", type=" + this.type + ", target=" + this.target + ", parameters=" + this.parameters + ", options=" + this.options + ", metadata=" + this.metadata + ", action=" + this.action + ")";
    }

    public /* synthetic */ GuiCommand(String str, GuiCommandType guiCommandType, GuiTarget guiTarget, GuiParameters guiParameters, GuiOptions guiOptions, Map map, Action action, int i, e eVar) {
        this(str, guiCommandType, guiTarget, guiParameters, (i & 16) != 0 ? GuiOptions.INSTANCE.m7369default() : guiOptions, (i & 32) != 0 ? kotlin.collections.a.M() : map, (i & 64) != 0 ? null : action);
    }
}
