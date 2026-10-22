package coil.memory;

import F1.j;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u0011\t\u0005J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H¦\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcoil/memory/MemoryCache;", "", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$b;", Const.INTENT_KEY_APIKEY, "(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$b;", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$b;)V", "clear", "()V", "", "level", "trimMemory", "(I)V", "Key", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MemoryCache {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcoil/memory/MemoryCache$a;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "percent", Const.INTENT_KEY_PKGNAME, "(D)Lcoil/memory/MemoryCache$a;", "Lcoil/memory/MemoryCache;", Const.INTENT_KEY_APIKEY, "()Lcoil/memory/MemoryCache;", "Landroid/content/Context;", "D", "maxSizePercent", "", "c", "I", "maxSizeBytes", "", Const.INTENT_KEY_UMID, "Z", "strongReferencesEnabled", "e", "weakReferencesEnabled", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public double maxSizePercent;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int maxSizeBytes;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public boolean strongReferencesEnabled = true;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean weakReferencesEnabled = true;

        public a(Context context) {
            this.context = context;
            this.maxSizePercent = j.e(context);
        }

        public final MemoryCache a() {
            g aVar;
            h fVar = this.weakReferencesEnabled ? new f() : new b();
            if (this.strongReferencesEnabled) {
                double d10 = this.maxSizePercent;
                int iC = d10 > 0.0d ? j.c(this.context, d10) : this.maxSizeBytes;
                aVar = iC > 0 ? new e(iC, fVar) : new coil.memory.a(fVar);
            } else {
                aVar = new coil.memory.a(fVar);
            }
            return new d(aVar, fVar);
        }

        public final a b(double percent) {
            if (0.0d > percent || percent > 1.0d) {
                throw new IllegalArgumentException("size must be in the range [0.0, 1.0].");
            }
            this.maxSizeBytes = 0;
            this.maxSizePercent = percent;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcoil/memory/MemoryCache$b;", "", "Landroid/graphics/Bitmap;", "bitmap", "", "", "extras", "<init>", "(Landroid/graphics/Bitmap;Ljava/util/Map;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: coil.memory.MemoryCache$b, reason: from toString */
    public static final class Value {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Bitmap bitmap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Map<String, Object> extras;

        public Value(Bitmap bitmap, Map<String, ? extends Object> map) {
            this.bitmap = bitmap;
            this.extras = map;
        }

        /* renamed from: a, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> b() {
            return this.extras;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Value)) {
                return false;
            }
            Value value = (Value) other;
            return p.d(this.bitmap, value.bitmap) && p.d(this.extras, value.extras);
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
        }
    }

    Value a(Key key);

    void b(Key key, Value value);

    void clear();

    void trimMemory(int level);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "", "key", "", "extras", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/util/Map;)Lcoil/memory/MemoryCache$Key;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getKey", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "Companion", Const.INTENT_KEY_PKGNAME, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key implements Parcelable {
        private final Map<String, String> extras;
        private final String key;
        private static final b Companion = new b(null);

        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = new a();

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"coil/memory/MemoryCache$Key$a", "Landroid/os/Parcelable$Creator;", "Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcoil/memory/MemoryCache$Key;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcoil/memory/MemoryCache$Key;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<Key> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Key createFromParcel(Parcel parcel) {
                String string = parcel.readString();
                p.f(string);
                int i10 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
                for (int i11 = 0; i11 < i10; i11++) {
                    String string2 = parcel.readString();
                    p.f(string2);
                    String string3 = parcel.readString();
                    p.f(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new Key(string, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Key[] newArray(int size) {
                return new Key[size];
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcoil/memory/MemoryCache$Key$b;", "", "<init>", "()V", "Landroid/os/Parcelable$Creator;", "Lcoil/memory/MemoryCache$Key;", "CREATOR", "Landroid/os/Parcelable$Creator;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b {
            public /* synthetic */ b(i iVar) {
                this();
            }

            public b() {
            }
        }

        public Key(String str, Map<String, String> map) {
            this.key = str;
            this.extras = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key key, String str, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = key.key;
            }
            if ((i10 & 2) != 0) {
                map = key.extras;
            }
            return key.copy(str, map);
        }

        public final Key copy(String key, Map<String, String> extras) {
            return new Key(key, extras);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return p.d(this.key, key.key) && p.d(this.extras, key.extras);
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        public final String getKey() {
            return this.key;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeString(this.key);
            parcel.writeInt(this.extras.size());
            for (Map.Entry<String, String> entry : this.extras.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                parcel.writeString(key);
                parcel.writeString(value);
            }
        }

        public /* synthetic */ Key(String str, Map map, int i10, i iVar) {
            this(str, (i10 & 2) != 0 ? kotlin.collections.a.i() : map);
        }
    }
}
