package U6;

import La.H;
import Y8.j;
import a7.InterfaceC1237a;
import a7.InterfaceC1238b;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.C4851b;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR8\u0010!\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\f0\u001ej\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\f`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010 ¨\u0006\""}, d2 = {"LU6/a;", "", "<init>", "()V", Const.LBS_FAIL_BD_ENTITY, "", "overrideEntityId", "LU6/a$b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;Ljava/lang/Long;)LU6/a$b;", "Ljava/lang/Class;", "cls", "LU6/a$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Class;)LU6/a$a;", "Ljava/lang/reflect/Field;", "field", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/reflect/Field;)Z", "f", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Long;", "", "e", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;", "raw", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "classMetadataCache", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6291a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final HashMap<Class<?>, ClassMetadata> classMetadataCache = new HashMap<>();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR)\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR)\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b \u0010\u001fR)\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b\u0019\u0010\u001f¨\u0006!"}, d2 = {"LU6/a$a;", "", "", "collection", "Ljava/lang/reflect/Field;", "idField", "", "Lkotlin/Pair;", "La7/a;", "ftsFields", "vectorFields", "filterFields", "<init>", "(Ljava/lang/String;Ljava/lang/reflect/Field;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/reflect/Field;", Const.INTENT_KEY_UMID, "()Ljava/lang/reflect/Field;", "c", "Ljava/util/List;", "()Ljava/util/List;", "e", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: U6.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class ClassMetadata {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String collection;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Field idField;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Pair<Field, InterfaceC1237a>> ftsFields;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Pair<Field, InterfaceC1237a>> vectorFields;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Pair<Field, InterfaceC1237a>> filterFields;

        /* JADX WARN: Multi-variable type inference failed */
        public ClassMetadata(String collection, Field field, List<? extends Pair<Field, ? extends InterfaceC1237a>> ftsFields, List<? extends Pair<Field, ? extends InterfaceC1237a>> vectorFields, List<? extends Pair<Field, ? extends InterfaceC1237a>> filterFields) {
            p.i(collection, "collection");
            p.i(ftsFields, "ftsFields");
            p.i(vectorFields, "vectorFields");
            p.i(filterFields, "filterFields");
            this.collection = collection;
            this.idField = field;
            this.ftsFields = ftsFields;
            this.vectorFields = vectorFields;
            this.filterFields = filterFields;
        }

        /* renamed from: a, reason: from getter */
        public final String getCollection() {
            return this.collection;
        }

        public final List<Pair<Field, InterfaceC1237a>> b() {
            return this.filterFields;
        }

        public final List<Pair<Field, InterfaceC1237a>> c() {
            return this.ftsFields;
        }

        /* renamed from: d, reason: from getter */
        public final Field getIdField() {
            return this.idField;
        }

        public final List<Pair<Field, InterfaceC1237a>> e() {
            return this.vectorFields;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassMetadata)) {
                return false;
            }
            ClassMetadata classMetadata = (ClassMetadata) other;
            return p.d(this.collection, classMetadata.collection) && p.d(this.idField, classMetadata.idField) && p.d(this.ftsFields, classMetadata.ftsFields) && p.d(this.vectorFields, classMetadata.vectorFields) && p.d(this.filterFields, classMetadata.filterFields);
        }

        public int hashCode() {
            int iHashCode = this.collection.hashCode() * 31;
            Field field = this.idField;
            return ((((((iHashCode + (field == null ? 0 : field.hashCode())) * 31) + this.ftsFields.hashCode()) * 31) + this.vectorFields.hashCode()) * 31) + this.filterFields.hashCode();
        }

        public String toString() {
            return "ClassMetadata(collection=" + this.collection + ", idField=" + this.idField + ", ftsFields=" + this.ftsFields + ", vectorFields=" + this.vectorFields + ", filterFields=" + this.filterFields + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001e\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b \u0010&R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\"\u0010%\u001a\u0004\b$\u0010&¨\u0006'"}, d2 = {"LU6/a$b;", "", "", "collection", "", "entityId", "entityType", "ftsContent", "embedText", "", "metadata", "", "hasFtsFields", "hasVectorFields", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "J", "c", "()J", Const.INTENT_KEY_UMID, "e", "f", "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "()Z", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: U6.a$b, reason: from toString */
    public static final /* data */ class IndexBundle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String collection;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long entityId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String entityType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String ftsContent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String embedText;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final Map<String, Object> metadata;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean hasFtsFields;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean hasVectorFields;

        public IndexBundle(String collection, long j10, String entityType, String ftsContent, String embedText, Map<String, ? extends Object> metadata, boolean z10, boolean z11) {
            p.i(collection, "collection");
            p.i(entityType, "entityType");
            p.i(ftsContent, "ftsContent");
            p.i(embedText, "embedText");
            p.i(metadata, "metadata");
            this.collection = collection;
            this.entityId = j10;
            this.entityType = entityType;
            this.ftsContent = ftsContent;
            this.embedText = embedText;
            this.metadata = metadata;
            this.hasFtsFields = z10;
            this.hasVectorFields = z11;
        }

        /* renamed from: a, reason: from getter */
        public final String getCollection() {
            return this.collection;
        }

        /* renamed from: b, reason: from getter */
        public final String getEmbedText() {
            return this.embedText;
        }

        /* renamed from: c, reason: from getter */
        public final long getEntityId() {
            return this.entityId;
        }

        /* renamed from: d, reason: from getter */
        public final String getEntityType() {
            return this.entityType;
        }

        /* renamed from: e, reason: from getter */
        public final String getFtsContent() {
            return this.ftsContent;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IndexBundle)) {
                return false;
            }
            IndexBundle indexBundle = (IndexBundle) other;
            return p.d(this.collection, indexBundle.collection) && this.entityId == indexBundle.entityId && p.d(this.entityType, indexBundle.entityType) && p.d(this.ftsContent, indexBundle.ftsContent) && p.d(this.embedText, indexBundle.embedText) && p.d(this.metadata, indexBundle.metadata) && this.hasFtsFields == indexBundle.hasFtsFields && this.hasVectorFields == indexBundle.hasVectorFields;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getHasFtsFields() {
            return this.hasFtsFields;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getHasVectorFields() {
            return this.hasVectorFields;
        }

        public final Map<String, Object> h() {
            return this.metadata;
        }

        public int hashCode() {
            return (((((((((((((this.collection.hashCode() * 31) + Long.hashCode(this.entityId)) * 31) + this.entityType.hashCode()) * 31) + this.ftsContent.hashCode()) * 31) + this.embedText.hashCode()) * 31) + this.metadata.hashCode()) * 31) + Boolean.hashCode(this.hasFtsFields)) * 31) + Boolean.hashCode(this.hasVectorFields);
        }

        public String toString() {
            return "IndexBundle(collection=" + this.collection + ", entityId=" + this.entityId + ", entityType=" + this.entityType + ", ftsContent=" + this.ftsContent + ", embedText=" + this.embedText + ", metadata=" + this.metadata + ", hasFtsFields=" + this.hasFtsFields + ", hasVectorFields=" + this.hasVectorFields + ")";
        }
    }

    public final ClassMetadata a(Class<?> cls) throws SecurityException {
        InterfaceC1238b interfaceC1238b = (InterfaceC1238b) cls.getAnnotation(InterfaceC1238b.class);
        String strCollection = interfaceC1238b != null ? interfaceC1238b.collection() : null;
        if (strCollection == null) {
            strCollection = "";
        }
        String str = strCollection;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Field field = null;
        for (Class<?> superclass = cls; superclass != null && !p.d(superclass, Object.class); superclass = superclass.getSuperclass()) {
            Iterator itA = C4851b.a(superclass.getDeclaredFields());
            while (itA.hasNext()) {
                Field field2 = (Field) itA.next();
                field2.setAccessible(true);
                InterfaceC1237a interfaceC1237a = (InterfaceC1237a) field2.getAnnotation(InterfaceC1237a.class);
                if (interfaceC1237a != null) {
                    if (interfaceC1237a.fts()) {
                        arrayList.add(j.a(field2, interfaceC1237a));
                    }
                    if (interfaceC1237a.vector()) {
                        if (H.x0(str)) {
                            Log.w("EntityIndexScanner", cls.getSimpleName() + "." + field2.getName() + ": @Searchable(vector=true) 但类没有 @Vectorized(collection=...)；向量索引会被跳过");
                        } else {
                            arrayList2.add(j.a(field2, interfaceC1237a));
                        }
                    }
                    if (interfaceC1237a.filter()) {
                        arrayList3.add(j.a(field2, interfaceC1237a));
                    }
                }
                if (field == null) {
                    p.f(field2);
                    if (b(field2)) {
                        field = field2;
                    }
                }
            }
        }
        return new ClassMetadata(str, field, arrayList, arrayList2, arrayList3);
    }

    public final boolean b(Field field) {
        if (!p.d(field.getName(), "id")) {
            return false;
        }
        Class<?> type = field.getType();
        return p.d(type, Long.TYPE) || p.d(type, Long.class) || p.d(type, Integer.TYPE) || p.d(type, Integer.class);
    }

    public final Object c(Object raw) {
        if ((raw instanceof Boolean) || (raw instanceof Integer) || (raw instanceof Long) || (raw instanceof Float) || (raw instanceof Double) || (raw instanceof String)) {
            return raw;
        }
        if (raw instanceof Enum) {
            return ((Enum) raw).name();
        }
        return null;
    }

    public final Object d(Field field, Object entity) {
        try {
            return field.get(entity);
        } catch (Exception e10) {
            Log.w("EntityIndexScanner", "readFieldRaw failed on " + field.getName(), e10);
            return null;
        }
    }

    public final String e(Field field, Object entity) throws IllegalAccessException, IllegalArgumentException {
        try {
            Object obj = field.get(entity);
            if (obj == null) {
                return null;
            }
            return obj instanceof String ? (String) obj : obj instanceof Enum ? ((Enum) obj).name() : obj.toString();
        } catch (Exception e10) {
            Log.w("EntityIndexScanner", "readFieldString failed on " + field.getName(), e10);
            return null;
        }
    }

    public final Long f(Field field, Object entity) throws IllegalAccessException, IllegalArgumentException {
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(entity);
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (obj instanceof Integer) {
                return Long.valueOf(((Number) obj).intValue());
            }
            return null;
        } catch (Exception e10) {
            Log.w("EntityIndexScanner", "readIdValue failed on " + field.getName(), e10);
            return null;
        }
    }

    public final IndexBundle g(Object entity, Long overrideEntityId) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        long jLongValue;
        p.i(entity, "entity");
        Class<?> cls = entity.getClass();
        HashMap<Class<?>, ClassMetadata> map = classMetadataCache;
        ClassMetadata classMetadataA = map.get(cls);
        if (classMetadataA == null) {
            classMetadataA = f6291a.a(cls);
            map.put(cls, classMetadataA);
        }
        ClassMetadata classMetadata = classMetadataA;
        StringBuilder sb2 = new StringBuilder();
        for (Pair<Field, InterfaceC1237a> pair : classMetadata.c()) {
            Field fieldA = pair.a();
            InterfaceC1237a interfaceC1237aB = pair.b();
            String strE = f6291a.e(fieldA, entity);
            if (strE != null && !H.x0(strE)) {
                int iF = C5685n.f((int) interfaceC1237aB.priority().getWeightMultiplier(), 1);
                for (int i10 = 0; i10 < iF; i10++) {
                    if (sb2.length() > 0) {
                        sb2.append(' ');
                    }
                    sb2.append(strE);
                }
            }
        }
        String string = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        Iterator<Pair<Field, InterfaceC1237a>> it = classMetadata.e().iterator();
        while (it.hasNext()) {
            String strE2 = f6291a.e(it.next().a(), entity);
            if (strE2 != null && !H.x0(strE2)) {
                if (sb3.length() > 0) {
                    sb3.append(' ');
                }
                sb3.append(strE2);
            }
        }
        String string2 = sb3.toString();
        if (overrideEntityId != null) {
            jLongValue = overrideEntityId.longValue();
        } else {
            Long lF = f(classMetadata.getIdField(), entity);
            jLongValue = lF != null ? lF.longValue() : 0L;
        }
        long j10 = jLongValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("entityId", Long.valueOf(j10));
        linkedHashMap.put("entityType", cls.getSimpleName());
        Iterator<Pair<Field, InterfaceC1237a>> it2 = classMetadata.b().iterator();
        while (it2.hasNext()) {
            Field fieldA2 = it2.next().a();
            Object objD = d(fieldA2, entity);
            if (objD != null) {
                Object objC = c(objD);
                if (objC != null) {
                    linkedHashMap.put(fieldA2.getName(), objC);
                } else {
                    Log.w("EntityIndexScanner", "@Searchable(filter=true) field '" + fieldA2.getName() + "' value type " + objD.getClass().getSimpleName() + " not supported; skipped");
                }
            }
        }
        String collection = classMetadata.getCollection();
        String simpleName = cls.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return new IndexBundle(collection, j10, simpleName, string, string2, linkedHashMap, !classMetadata.c().isEmpty(), !classMetadata.e().isEmpty());
    }
}
