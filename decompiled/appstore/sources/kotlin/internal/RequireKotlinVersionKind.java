package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@SinceKotlin(version = "1.2")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/internal/RequireKotlinVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum RequireKotlinVersionKind extends Enum<RequireKotlinVersionKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RequireKotlinVersionKind[] $VALUES = null;
    public static final RequireKotlinVersionKind API_VERSION = null;
    public static final RequireKotlinVersionKind COMPILER_VERSION = null;
    public static final RequireKotlinVersionKind LANGUAGE_VERSION = null;

    private static final /* synthetic */ RequireKotlinVersionKind[] $values() {
        return new RequireKotlinVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION};
    }

    static {
        LANGUAGE_VERSION = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
        COMPILER_VERSION = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
        API_VERSION = new RequireKotlinVersionKind("API_VERSION", 2);
        RequireKotlinVersionKind[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = a.a(r10);
    }

    private RequireKotlinVersionKind(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<RequireKotlinVersionKind> getEntries() {
        return $ENTRIES;
    }

    public static RequireKotlinVersionKind valueOf(String r10) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, r10);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) $VALUES.clone();
    }
}
