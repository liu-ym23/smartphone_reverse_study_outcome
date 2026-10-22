package A1;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0003\u0012\"$B\u001d\b\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ!\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0014H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"LA1/l;", "", "Lkotlin/Pair;", "", "LA1/l$c;", "", "entries", "<init>", "(Ljava/util/Map;)V", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "key", "f", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isEmpty", "()Z", "c", "()Ljava/util/Map;", "", "iterator", "()Ljava/util/Iterator;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "LA1/l$a;", "e", "()LA1/l$a;", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A1.l, reason: from toString */
/* loaded from: classes.dex */
public final class Parameters implements Iterable<Pair<? extends String, ? extends Entry>>, InterfaceC5162a {

    /* renamed from: c, reason: collision with root package name */
    public static final Parameters f240c = new Parameters();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Entry> entries;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\r"}, d2 = {"LA1/l$a;", "", "LA1/l;", "parameters", "<init>", "(LA1/l;)V", Const.INTENT_KEY_APIKEY, "()LA1/l;", "", "", "LA1/l$c;", "Ljava/util/Map;", "entries", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: A1.l$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Map<String, Entry> entries;

        public a(Parameters parameters) {
            this.entries = kotlin.collections.a.C(parameters.entries);
        }

        public final Parameters a() {
            return new Parameters(F1.c.b(this.entries), null);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\f\u0010\u000b¨\u0006\u0013"}, d2 = {"LA1/l$c;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", UxipConstants.f30680s, "Ljava/lang/String;", "memoryCacheKey", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: A1.l$c, reason: from toString */
    public static final class Entry {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Object value;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String memoryCacheKey;

        /* renamed from: a, reason: from getter */
        public final String getMemoryCacheKey() {
            return this.memoryCacheKey;
        }

        /* renamed from: b, reason: from getter */
        public final Object getValue() {
            return this.value;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return kotlin.jvm.internal.p.d(this.value, entry.value) && kotlin.jvm.internal.p.d(this.memoryCacheKey, entry.memoryCacheKey);
        }

        public int hashCode() {
            Object obj = this.value;
            int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
            String str = this.memoryCacheKey;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Entry(value=" + this.value + ", memoryCacheKey=" + this.memoryCacheKey + ')';
        }
    }

    public /* synthetic */ Parameters(Map map, kotlin.jvm.internal.i iVar) {
        this(map);
    }

    public final Map<String, String> c() {
        if (isEmpty()) {
            return kotlin.collections.a.i();
        }
        Map<String, Entry> map = this.entries;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Entry> entry : map.entrySet()) {
            String memoryCacheKey = entry.getValue().getMemoryCacheKey();
            if (memoryCacheKey != null) {
                linkedHashMap.put(entry.getKey(), memoryCacheKey);
            }
        }
        return linkedHashMap;
    }

    public final a e() {
        return new a(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Parameters) && kotlin.jvm.internal.p.d(this.entries, ((Parameters) other).entries);
    }

    public final <T> T f(String key) {
        Entry entry = this.entries.get(key);
        if (entry != null) {
            return (T) entry.getValue();
        }
        return null;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends Entry>> iterator() {
        Map<String, Entry> map = this.entries;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Entry> entry : map.entrySet()) {
            arrayList.add(Y8.j.a(entry.getKey(), entry.getValue()));
        }
        return arrayList.iterator();
    }

    public String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    public Parameters(Map<String, Entry> map) {
        this.entries = map;
    }

    public Parameters() {
        this(kotlin.collections.a.i());
    }
}
