package androidx.appfunctions.internal;

import C7.f;
import D7.w;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "Landroidx/appfunctions/internal/AppFunctionInventory;", AppAgent.CONSTRUCT, "()V", "", "", "Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "functionIdToMetadataMap$delegate", "LC7/f;", "getFunctionIdToMetadataMap", "()Ljava/util/Map;", "functionIdToMetadataMap", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "componentsMetadata$delegate", "getComponentsMetadata", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "componentsMetadata", "", "getInventories", "()Ljava/util/List;", "inventories", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class AggregatedAppFunctionInventory implements AppFunctionInventory {

    /* renamed from: componentsMetadata$delegate, reason: from kotlin metadata */
    private final f componentsMetadata;

    /* renamed from: functionIdToMetadataMap$delegate, reason: from kotlin metadata */
    private final f functionIdToMetadataMap;

    public AggregatedAppFunctionInventory() {
        final int i = 0;
        this.functionIdToMetadataMap = kotlin.a.a(new S7.a(this) { // from class: androidx.appfunctions.internal.a
            public final /* synthetic */ AggregatedAppFunctionInventory b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                AggregatedAppFunctionInventory aggregatedAppFunctionInventory = this.b;
                switch (i6) {
                    case 0:
                        return AggregatedAppFunctionInventory.functionIdToMetadataMap_delegate$lambda$0(aggregatedAppFunctionInventory);
                    default:
                        return AggregatedAppFunctionInventory.componentsMetadata_delegate$lambda$0(aggregatedAppFunctionInventory);
                }
            }
        });
        final int i6 = 1;
        this.componentsMetadata = kotlin.a.a(new S7.a(this) { // from class: androidx.appfunctions.internal.a
            public final /* synthetic */ AggregatedAppFunctionInventory b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                AggregatedAppFunctionInventory aggregatedAppFunctionInventory = this.b;
                switch (i62) {
                    case 0:
                        return AggregatedAppFunctionInventory.functionIdToMetadataMap_delegate$lambda$0(aggregatedAppFunctionInventory);
                    default:
                        return AggregatedAppFunctionInventory.componentsMetadata_delegate$lambda$0(aggregatedAppFunctionInventory);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionComponentsMetadata componentsMetadata_delegate$lambda$0(AggregatedAppFunctionInventory aggregatedAppFunctionInventory) {
        if (aggregatedAppFunctionInventory.getInventories().isEmpty()) {
            return new AppFunctionComponentsMetadata(null, 1, null);
        }
        List<AppFunctionInventory> inventories = aggregatedAppFunctionInventory.getInventories();
        ArrayList arrayList = new ArrayList(w.c0(inventories, 10));
        Iterator<T> it = inventories.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionInventory) it.next()).getComponentsMetadata().getDataTypes());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = kotlin.collections.a.T((Map) next, (Map) it2.next());
        }
        return new AppFunctionComponentsMetadata((Map) next);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map functionIdToMetadataMap_delegate$lambda$0(AggregatedAppFunctionInventory aggregatedAppFunctionInventory) {
        if (aggregatedAppFunctionInventory.getInventories().isEmpty()) {
            return kotlin.collections.a.M();
        }
        List<AppFunctionInventory> inventories = aggregatedAppFunctionInventory.getInventories();
        ArrayList arrayList = new ArrayList(w.c0(inventories, 10));
        Iterator<T> it = inventories.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionInventory) it.next()).getFunctionIdToMetadataMap());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = kotlin.collections.a.T((Map) next, (Map) it2.next());
        }
        return (Map) next;
    }

    @Override // androidx.appfunctions.internal.AppFunctionInventory
    public final AppFunctionComponentsMetadata getComponentsMetadata() {
        return (AppFunctionComponentsMetadata) this.componentsMetadata.getF4884a();
    }

    @Override // androidx.appfunctions.internal.AppFunctionInventory
    public final Map<String, CompileTimeAppFunctionMetadata> getFunctionIdToMetadataMap() {
        return (Map) this.functionIdToMetadataMap.getF4884a();
    }

    public abstract List<AppFunctionInventory> getInventories();
}
