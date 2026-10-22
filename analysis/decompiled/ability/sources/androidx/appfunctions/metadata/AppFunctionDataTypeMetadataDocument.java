package androidx.appfunctions.metadata;

import D7.v;
import D7.w;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import androidx.appsearch.annotation.Document;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Document
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0081\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010'\u001a\u00020(H\u0007J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J±\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0014\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010:\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001e¨\u0006;"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "", "namespace", "", "id", "type", "", "itemType", "properties", "", "Landroidx/appfunctions/metadata/AppFunctionNamedDataTypeMetadataDocument;", "allOf", "oneOf", "required", "dataTypeReference", "isNullable", "", "objectQualifiedName", "description", "enumValues", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ILandroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getType", "()I", "getItemType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "getProperties", "()Ljava/util/List;", "getAllOf", "getOneOf", "getRequired", "getDataTypeReference", "()Z", "getObjectQualifiedName", "getDescription", "getEnumValues", "toAppFunctionDataTypeMetadata", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppFunctionDataTypeMetadataDocument {

    @Document.DocumentProperty
    private final List<AppFunctionDataTypeMetadataDocument> allOf;

    @Document.StringProperty
    private final String dataTypeReference;

    @Document.StringProperty
    private final String description;

    @Document.StringProperty
    private final List<String> enumValues;

    @Document.Id
    private final String id;

    @Document.BooleanProperty
    private final boolean isNullable;

    @Document.DocumentProperty
    private final AppFunctionDataTypeMetadataDocument itemType;

    @Document.Namespace
    private final String namespace;

    @Document.StringProperty
    private final String objectQualifiedName;

    @Document.DocumentProperty
    private final List<AppFunctionDataTypeMetadataDocument> oneOf;

    @Document.DocumentProperty
    private final List<AppFunctionNamedDataTypeMetadataDocument> properties;

    @Document.StringProperty
    private final List<String> required;

    @Document.LongProperty
    private final int type;

    public AppFunctionDataTypeMetadataDocument(String namespace, String id, int i, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, List<AppFunctionNamedDataTypeMetadataDocument> properties, List<AppFunctionDataTypeMetadataDocument> allOf, List<AppFunctionDataTypeMetadataDocument> oneOf, List<String> required, String str, boolean z10, String str2, String str3, List<String> enumValues) {
        k.f(namespace, "namespace");
        k.f(id, "id");
        k.f(properties, "properties");
        k.f(allOf, "allOf");
        k.f(oneOf, "oneOf");
        k.f(required, "required");
        k.f(enumValues, "enumValues");
        this.namespace = namespace;
        this.id = id;
        this.type = i;
        this.itemType = appFunctionDataTypeMetadataDocument;
        this.properties = properties;
        this.allOf = allOf;
        this.oneOf = oneOf;
        this.required = required;
        this.dataTypeReference = str;
        this.isNullable = z10;
        this.objectQualifiedName = str2;
        this.description = str3;
        this.enumValues = enumValues;
    }

    public static /* synthetic */ AppFunctionDataTypeMetadataDocument copy$default(AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str, String str2, int i, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument2, List list, List list2, List list3, List list4, String str3, boolean z10, String str4, String str5, List list5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = appFunctionDataTypeMetadataDocument.namespace;
        }
        return appFunctionDataTypeMetadataDocument.copy(str, (i6 & 2) != 0 ? appFunctionDataTypeMetadataDocument.id : str2, (i6 & 4) != 0 ? appFunctionDataTypeMetadataDocument.type : i, (i6 & 8) != 0 ? appFunctionDataTypeMetadataDocument.itemType : appFunctionDataTypeMetadataDocument2, (i6 & 16) != 0 ? appFunctionDataTypeMetadataDocument.properties : list, (i6 & 32) != 0 ? appFunctionDataTypeMetadataDocument.allOf : list2, (i6 & 64) != 0 ? appFunctionDataTypeMetadataDocument.oneOf : list3, (i6 & 128) != 0 ? appFunctionDataTypeMetadataDocument.required : list4, (i6 & 256) != 0 ? appFunctionDataTypeMetadataDocument.dataTypeReference : str3, (i6 & 512) != 0 ? appFunctionDataTypeMetadataDocument.isNullable : z10, (i6 & 1024) != 0 ? appFunctionDataTypeMetadataDocument.objectQualifiedName : str4, (i6 & 2048) != 0 ? appFunctionDataTypeMetadataDocument.description : str5, (i6 & 4096) != 0 ? appFunctionDataTypeMetadataDocument.enumValues : list5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    /* renamed from: component11, reason: from getter */
    public final String getObjectQualifiedName() {
        return this.objectQualifiedName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component13() {
        return this.enumValues;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final AppFunctionDataTypeMetadataDocument getItemType() {
        return this.itemType;
    }

    public final List<AppFunctionNamedDataTypeMetadataDocument> component5() {
        return this.properties;
    }

    public final List<AppFunctionDataTypeMetadataDocument> component6() {
        return this.allOf;
    }

    public final List<AppFunctionDataTypeMetadataDocument> component7() {
        return this.oneOf;
    }

    public final List<String> component8() {
        return this.required;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDataTypeReference() {
        return this.dataTypeReference;
    }

    public final AppFunctionDataTypeMetadataDocument copy(String namespace, String id, int type, AppFunctionDataTypeMetadataDocument itemType, List<AppFunctionNamedDataTypeMetadataDocument> properties, List<AppFunctionDataTypeMetadataDocument> allOf, List<AppFunctionDataTypeMetadataDocument> oneOf, List<String> required, String dataTypeReference, boolean isNullable, String objectQualifiedName, String description, List<String> enumValues) {
        k.f(namespace, "namespace");
        k.f(id, "id");
        k.f(properties, "properties");
        k.f(allOf, "allOf");
        k.f(oneOf, "oneOf");
        k.f(required, "required");
        k.f(enumValues, "enumValues");
        return new AppFunctionDataTypeMetadataDocument(namespace, id, type, itemType, properties, allOf, oneOf, required, dataTypeReference, isNullable, objectQualifiedName, description, enumValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionDataTypeMetadataDocument)) {
            return false;
        }
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument = (AppFunctionDataTypeMetadataDocument) other;
        return k.b(this.namespace, appFunctionDataTypeMetadataDocument.namespace) && k.b(this.id, appFunctionDataTypeMetadataDocument.id) && this.type == appFunctionDataTypeMetadataDocument.type && k.b(this.itemType, appFunctionDataTypeMetadataDocument.itemType) && k.b(this.properties, appFunctionDataTypeMetadataDocument.properties) && k.b(this.allOf, appFunctionDataTypeMetadataDocument.allOf) && k.b(this.oneOf, appFunctionDataTypeMetadataDocument.oneOf) && k.b(this.required, appFunctionDataTypeMetadataDocument.required) && k.b(this.dataTypeReference, appFunctionDataTypeMetadataDocument.dataTypeReference) && this.isNullable == appFunctionDataTypeMetadataDocument.isNullable && k.b(this.objectQualifiedName, appFunctionDataTypeMetadataDocument.objectQualifiedName) && k.b(this.description, appFunctionDataTypeMetadataDocument.description) && k.b(this.enumValues, appFunctionDataTypeMetadataDocument.enumValues);
    }

    public final List<AppFunctionDataTypeMetadataDocument> getAllOf() {
        return this.allOf;
    }

    public final String getDataTypeReference() {
        return this.dataTypeReference;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getEnumValues() {
        return this.enumValues;
    }

    public final String getId() {
        return this.id;
    }

    public final AppFunctionDataTypeMetadataDocument getItemType() {
        return this.itemType;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final String getObjectQualifiedName() {
        return this.objectQualifiedName;
    }

    public final List<AppFunctionDataTypeMetadataDocument> getOneOf() {
        return this.oneOf;
    }

    public final List<AppFunctionNamedDataTypeMetadataDocument> getProperties() {
        return this.properties;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.type, B7.a.c(this.namespace.hashCode() * 31, 31, this.id), 31);
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument = this.itemType;
        int iE = a.e(this.required, a.e(this.oneOf, a.e(this.allOf, a.e(this.properties, (iA + (appFunctionDataTypeMetadataDocument == null ? 0 : appFunctionDataTypeMetadataDocument.hashCode())) * 31, 31), 31), 31), 31);
        String str = this.dataTypeReference;
        int iD = a.d((iE + (str == null ? 0 : str.hashCode())) * 31, 31, this.isNullable);
        String str2 = this.objectQualifiedName;
        int iHashCode = (iD + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return this.enumValues.hashCode() + ((iHashCode + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    @SuppressLint({"WrongConstant"})
    public final AppFunctionDataTypeMetadata toAppFunctionDataTypeMetadata() {
        String str;
        switch (this.type) {
            case 0:
                boolean z10 = this.isNullable;
                String str2 = this.description;
                return new AppFunctionUnitTypeMetadata(z10, str2 != null ? str2 : "");
            case 1:
                boolean z11 = this.isNullable;
                String str3 = this.description;
                return new AppFunctionBooleanTypeMetadata(z11, str3 != null ? str3 : "");
            case 2:
                boolean z12 = this.isNullable;
                String str4 = this.description;
                return new AppFunctionBytesTypeMetadata(z12, str4 != null ? str4 : "");
            case 3:
                if (this.properties.isEmpty()) {
                    throw new IllegalStateException("Properties must be present for object type can't be empty");
                }
                List<AppFunctionNamedDataTypeMetadataDocument> list = this.properties;
                int iP = kotlin.collections.a.P(w.c0(list, 10));
                if (iP < 16) {
                    iP = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
                for (AppFunctionNamedDataTypeMetadataDocument appFunctionNamedDataTypeMetadataDocument : list) {
                    linkedHashMap.put(appFunctionNamedDataTypeMetadataDocument.getName(), appFunctionNamedDataTypeMetadataDocument.getDataTypeMetadata().toAppFunctionDataTypeMetadata());
                }
                List<String> list2 = this.required;
                String str5 = this.objectQualifiedName;
                boolean z13 = this.isNullable;
                String str6 = this.description;
                return new AppFunctionObjectTypeMetadata(linkedHashMap, list2, str5, z13, str6 == null ? "" : str6);
            case 4:
                boolean z14 = this.isNullable;
                String str7 = this.description;
                return new AppFunctionDoubleTypeMetadata(z14, str7 != null ? str7 : "");
            case 5:
                boolean z15 = this.isNullable;
                String str8 = this.description;
                return new AppFunctionFloatTypeMetadata(z15, str8 != null ? str8 : "");
            case 6:
                boolean z16 = this.isNullable;
                String str9 = this.description;
                return new AppFunctionLongTypeMetadata(z16, str9 != null ? str9 : "");
            case 7:
                boolean z17 = this.isNullable;
                String str10 = this.description;
                str = str10 != null ? str10 : "";
                List<String> list3 = this.enumValues;
                ArrayList arrayList = new ArrayList(w.c0(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
                }
                Set setJ1 = v.j1(arrayList);
                return new AppFunctionIntTypeMetadata(z17, str, setJ1.isEmpty() ? null : setJ1);
            case 8:
                boolean z18 = this.isNullable;
                String str11 = this.description;
                str = str11 != null ? str11 : "";
                Set setJ12 = v.j1(this.enumValues);
                return new AppFunctionStringTypeMetadata(z18, str, setJ12.isEmpty() ? null : setJ12);
            case 9:
            default:
                throw new IllegalArgumentException("Unknown type: " + this.type);
            case 10:
                AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument = this.itemType;
                if (appFunctionDataTypeMetadataDocument == null) {
                    throw new IllegalStateException("Item type must be present for array type");
                }
                AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = appFunctionDataTypeMetadataDocument.toAppFunctionDataTypeMetadata();
                boolean z19 = this.isNullable;
                String str12 = this.description;
                return new AppFunctionArrayTypeMetadata(appFunctionDataTypeMetadata, z19, str12 != null ? str12 : "");
            case 11:
                String str13 = this.dataTypeReference;
                if (str13 == null) {
                    throw new IllegalStateException("Data type reference must be present for reference type");
                }
                boolean z20 = this.isNullable;
                String str14 = this.description;
                return new AppFunctionReferenceTypeMetadata(str13, z20, str14 != null ? str14 : "");
            case 12:
                List<AppFunctionDataTypeMetadataDocument> list4 = this.allOf;
                ArrayList arrayList2 = new ArrayList(w.c0(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((AppFunctionDataTypeMetadataDocument) it2.next()).toAppFunctionDataTypeMetadata());
                }
                String str15 = this.objectQualifiedName;
                boolean z21 = this.isNullable;
                String str16 = this.description;
                return new AppFunctionAllOfTypeMetadata(arrayList2, str15, z21, str16 != null ? str16 : "");
            case 13:
                String name = this.objectQualifiedName;
                if (name == null) {
                    name = PendingIntent.class.getName();
                }
                boolean z22 = this.isNullable;
                String str17 = this.description;
                return new AppFunctionParcelableTypeMetadata(name, z22, str17 != null ? str17 : "");
            case 14:
                List<AppFunctionDataTypeMetadataDocument> list5 = this.oneOf;
                ArrayList arrayList3 = new ArrayList(w.c0(list5, 10));
                Iterator<T> it3 = list5.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(((AppFunctionDataTypeMetadataDocument) it3.next()).toAppFunctionDataTypeMetadata());
                }
                String str18 = this.objectQualifiedName;
                if (str18 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                boolean z23 = this.isNullable;
                String str19 = this.description;
                return new AppFunctionOneOfTypeMetadata(arrayList3, str18, z23, str19 != null ? str19 : "");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionDataTypeMetadataDocument(namespace=");
        sb.append(this.namespace);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", itemType=");
        sb.append(this.itemType);
        sb.append(", properties=");
        sb.append(this.properties);
        sb.append(", allOf=");
        sb.append(this.allOf);
        sb.append(", oneOf=");
        sb.append(this.oneOf);
        sb.append(", required=");
        sb.append(this.required);
        sb.append(", dataTypeReference=");
        sb.append(this.dataTypeReference);
        sb.append(", isNullable=");
        sb.append(this.isNullable);
        sb.append(", objectQualifiedName=");
        sb.append(this.objectQualifiedName);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", enumValues=");
        return B7.a.r(sb, this.enumValues, ')');
    }

    public AppFunctionDataTypeMetadataDocument(String str, String str2, int i, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, List list, List list2, List list3, List list4, String str3, boolean z10, String str4, String str5, List list5, int i6, e eVar) {
        this((i6 & 1) != 0 ? AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE : str, (i6 & 2) != 0 ? AppFunctionMetadataKt.APP_FUNCTION_ID_EMPTY : str2, i, (i6 & 8) != 0 ? null : appFunctionDataTypeMetadataDocument, (i6 & 16) != 0 ? EmptyList.f4893a : list, (i6 & 32) != 0 ? EmptyList.f4893a : list2, (i6 & 64) != 0 ? EmptyList.f4893a : list3, (i6 & 128) != 0 ? EmptyList.f4893a : list4, (i6 & 256) != 0 ? null : str3, (i6 & 512) != 0 ? false : z10, (i6 & 1024) != 0 ? null : str4, (i6 & 2048) != 0 ? null : str5, (i6 & 4096) != 0 ? EmptyList.f4893a : list5);
    }
}
