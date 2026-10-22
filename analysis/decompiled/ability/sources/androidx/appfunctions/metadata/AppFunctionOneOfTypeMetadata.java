package androidx.appfunctions.metadata;

import D7.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB1\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0019R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionOneOfTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "matchOneOf", "", "qualifiedName", "", "isNullable", "", "description", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getMatchOneOf", "()Ljava/util/List;", "getQualifiedName", "()Ljava/lang/String;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "equals", "other", "", "hashCode", "", "toString", "getObjectMetadataForOneOfType", "getObjectMetadataForOneOfType$appfunctions", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionOneOfTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 14;
    private final List<AppFunctionDataTypeMetadata> matchOneOf;
    private final String qualifiedName;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionOneOfTypeMetadata(List<? extends AppFunctionDataTypeMetadata> matchOneOf, String qualifiedName, boolean z10) {
        this(matchOneOf, qualifiedName, z10, null, 8, null);
        k.f(matchOneOf, "matchOneOf");
        k.f(qualifiedName, "qualifiedName");
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (!super.equals(other) || !(other instanceof AppFunctionOneOfTypeMetadata)) {
            return false;
        }
        AppFunctionOneOfTypeMetadata appFunctionOneOfTypeMetadata = (AppFunctionOneOfTypeMetadata) other;
        if (k.b(this.qualifiedName, appFunctionOneOfTypeMetadata.qualifiedName)) {
            return k.b(this.matchOneOf, appFunctionOneOfTypeMetadata.matchOneOf);
        }
        return false;
    }

    public final List<AppFunctionDataTypeMetadata> getMatchOneOf() {
        return this.matchOneOf;
    }

    public final AppFunctionDataTypeMetadata getObjectMetadataForOneOfType$appfunctions(String qualifiedName) {
        boolean zB;
        k.f(qualifiedName, "qualifiedName");
        Iterator<T> it = this.matchOneOf.iterator();
        Object obj = null;
        boolean z10 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = (AppFunctionDataTypeMetadata) next;
                if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
                    zB = k.b(((AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata).getQualifiedName(), qualifiedName);
                } else if (appFunctionDataTypeMetadata instanceof AppFunctionReferenceTypeMetadata) {
                    zB = k.b(((AppFunctionReferenceTypeMetadata) appFunctionDataTypeMetadata).getReferenceDataType(), qualifiedName);
                } else {
                    if (!(appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata)) {
                        throw new IllegalArgumentException("Unexpected data type " + appFunctionDataTypeMetadata + " for one of type");
                    }
                    zB = k.b(((AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata).getQualifiedName(), qualifiedName);
                }
                if (zB) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj2 = next;
                }
            } else if (z10) {
                obj = obj2;
            }
        }
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata2 = (AppFunctionDataTypeMetadata) obj;
        if (appFunctionDataTypeMetadata2 != null) {
            return appFunctionDataTypeMetadata2;
        }
        throw new IllegalArgumentException(qualifiedName.concat(" does not match any of the oneOf types"));
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public int hashCode() {
        return this.qualifiedName.hashCode() + a.e(this.matchOneOf, super.hashCode() * 31, 31);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions() {
        List<AppFunctionDataTypeMetadata> list = this.matchOneOf;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionDataTypeMetadata) it.next()).toAppFunctionDataTypeMetadataDocument$appfunctions());
        }
        boolean isNullable = getIsNullable();
        String str = this.qualifiedName;
        String description = getDescription();
        if (description.length() == 0) {
            description = null;
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 14, null, null, null, arrayList, null, null, isNullable, str, description, null, 4539, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionOneOfTypeMetadata(matchOneOf=" + this.matchOneOf + ", isNullable=" + getIsNullable() + ", description=" + getDescription() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionOneOfTypeMetadata(List<? extends AppFunctionDataTypeMetadata> matchOneOf, String qualifiedName, boolean z10, String description) {
        super(z10, description);
        k.f(matchOneOf, "matchOneOf");
        k.f(qualifiedName, "qualifiedName");
        k.f(description, "description");
        this.matchOneOf = matchOneOf;
        this.qualifiedName = qualifiedName;
    }

    public /* synthetic */ AppFunctionOneOfTypeMetadata(List list, String str, boolean z10, String str2, int i, e eVar) {
        this(list, str, z10, (i & 8) != 0 ? "" : str2);
    }
}
