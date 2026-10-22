package stepai.aios.guiagent.llm.cell.config;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.parser.IModelCell;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiagent/llm/cell/config/ModelCellOption;", "", "id", "", "instance", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "displayName", "description", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getInstance", "()Lstepai/aios/guiagent/llm/parser/IModelCell;", "getDisplayName", "getDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ModelCellOption {
    private final String description;
    private final String displayName;
    private final String id;
    private final IModelCell instance;

    public ModelCellOption(String id, IModelCell instance, String displayName, String description) {
        k.f(id, "id");
        k.f(instance, "instance");
        k.f(displayName, "displayName");
        k.f(description, "description");
        this.id = id;
        this.instance = instance;
        this.displayName = displayName;
        this.description = description;
    }

    public static /* synthetic */ ModelCellOption copy$default(ModelCellOption modelCellOption, String str, IModelCell iModelCell, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelCellOption.id;
        }
        if ((i & 2) != 0) {
            iModelCell = modelCellOption.instance;
        }
        if ((i & 4) != 0) {
            str2 = modelCellOption.displayName;
        }
        if ((i & 8) != 0) {
            str3 = modelCellOption.description;
        }
        return modelCellOption.copy(str, iModelCell, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final IModelCell getInstance() {
        return this.instance;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final ModelCellOption copy(String id, IModelCell instance, String displayName, String description) {
        k.f(id, "id");
        k.f(instance, "instance");
        k.f(displayName, "displayName");
        k.f(description, "description");
        return new ModelCellOption(id, instance, displayName, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelCellOption)) {
            return false;
        }
        ModelCellOption modelCellOption = (ModelCellOption) other;
        return k.b(this.id, modelCellOption.id) && k.b(this.instance, modelCellOption.instance) && k.b(this.displayName, modelCellOption.displayName) && k.b(this.description, modelCellOption.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }

    public final IModelCell getInstance() {
        return this.instance;
    }

    public int hashCode() {
        return this.description.hashCode() + a.c((this.instance.hashCode() + (this.id.hashCode() * 31)) * 31, 31, this.displayName);
    }

    public String toString() {
        String str = this.id;
        IModelCell iModelCell = this.instance;
        String str2 = this.displayName;
        String str3 = this.description;
        StringBuilder sb = new StringBuilder("ModelCellOption(id=");
        sb.append(str);
        sb.append(", instance=");
        sb.append(iModelCell);
        sb.append(", displayName=");
        return androidx.appfunctions.metadata.a.p(sb, str2, ", description=", str3, ")");
    }
}
