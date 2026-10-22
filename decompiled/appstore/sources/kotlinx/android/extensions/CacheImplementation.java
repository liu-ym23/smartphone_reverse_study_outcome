package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CacheImplementation extends Enum<CacheImplementation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CacheImplementation[] $VALUES = null;

    @NotNull
    public static final a Companion = null;

    @NotNull
    private static final CacheImplementation DEFAULT = null;
    public static final CacheImplementation HASH_MAP = null;
    public static final CacheImplementation NO_CACHE = null;
    public static final CacheImplementation SPARSE_ARRAY = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    private static final /* synthetic */ CacheImplementation[] $values() {
        return new CacheImplementation[]{SPARSE_ARRAY, HASH_MAP, NO_CACHE};
    }

    static {
        SPARSE_ARRAY = new CacheImplementation("SPARSE_ARRAY", 0);
        CacheImplementation r10 = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = r10;
        NO_CACHE = new CacheImplementation("NO_CACHE", 2);
        CacheImplementation[] r11 = $values();
        $VALUES = r11;
        $ENTRIES = kotlin.enums.a.a(r11);
        Companion = new a(null);
        DEFAULT = r10;
    }

    private CacheImplementation(String r10, int r11) {
        super(r10, r11);
    }

    public static final /* synthetic */ CacheImplementation access$getDEFAULT$cp() {
        return DEFAULT;
    }

    @NotNull
    public static EnumEntries<CacheImplementation> getEntries() {
        return $ENTRIES;
    }

    public static CacheImplementation valueOf(String r10) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, r10);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }
}
