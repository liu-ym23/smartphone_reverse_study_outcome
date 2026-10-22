package androidx.window.core;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.math.BigInteger;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/window/core/Version;", "", "major", "", "minor", "patch", "description", "", "(IIILjava/lang/String;)V", "bigInteger", "Ljava/math/BigInteger;", "getBigInteger", "()Ljava/math/BigInteger;", "bigInteger$delegate", "Lkotlin/Lazy;", "getDescription", "()Ljava/lang/String;", "getMajor", "()I", "getMinor", "getPatch", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Version implements Comparable<Version> {
    private static final Version CURRENT = null;
    public static final Companion Companion = null;
    private static final Version UNKNOWN = null;
    private static final Version VERSION_0_1 = null;
    private static final Version VERSION_1_0 = null;
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    private final Lazy bigInteger$delegate;
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "()V", "CURRENT", "Landroidx/window/core/Version;", "getCURRENT", "()Landroidx/window/core/Version;", "UNKNOWN", "getUNKNOWN", "VERSION_0_1", "getVERSION_0_1", "VERSION_1_0", "getVERSION_1_0", "VERSION_PATTERN_STRING", "", "parse", "versionString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Version getCURRENT() {
            return Version.access$getCURRENT$cp();
        }

        public final Version getUNKNOWN() {
            return Version.access$getUNKNOWN$cp();
        }

        public final Version getVERSION_0_1() {
            return Version.access$getVERSION_0_1$cp();
        }

        public final Version getVERSION_1_0() {
            return Version.access$getVERSION_1_0$cp();
        }

        @JvmStatic
        public final Version parse(String r100) {
            if (r100 != null) goto L5;
        L22:
            return null;
        L5:
            if (StringsKt.isBlank(r100) == true) goto L22;
            Matcher r101 = PatternProtector.compile(Version.VERSION_PATTERN_STRING).matcher(r100);
            if (r101.matches() == true) goto L10;
            return null;
        L10:
            String r102 = r101.group(1);
            if (r102 == null) goto L22;
            int r103 = CastIntegerProtector.parseInt(r102);
            String r104 = r101.group(2);
            if (r104 == null) goto L22;
            int r105 = CastIntegerProtector.parseInt(r104);
            String r106 = r101.group(3);
            if (r106 == null) goto L22;
            int r107 = CastIntegerProtector.parseInt(r106);
            if (r101.group(4) == null) goto L19;
            String r108 = r101.group(4);
        L21:
            return new Version(r103, r105, r107, r108, null);
        L19:
            r108 = "";
            goto L21
        }
    }

    public /* synthetic */ Version(int r100, int r101, int r102, String r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final Version parse(String r100) {
        return Companion.parse(r100);
    }

    static {
        Companion = new Companion(null);
        UNKNOWN = new Version(0, 0, 0, "");
        VERSION_0_1 = new Version(0, 1, 0, "");
        Version r100 = new Version(1, 0, 0, "");
        VERSION_1_0 = r100;
        CURRENT = r100;
    }

    private final BigInteger getBigInteger() {
        return (BigInteger) this.bigInteger$delegate.getValue();
    }

    public int hashCode() {
        return ((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    public String toString() {
        if ((!StringsKt.isBlank(this.description)) == false) goto L5;
        String r100 = "-" + this.description;
    L7:
        return this.major + '.' + this.minor + '.' + this.patch + r100;
    L5:
        r100 = "";
        goto L7
    }

    public static final /* synthetic */ Version access$getCURRENT$cp() {
        return CURRENT;
    }

    public static final /* synthetic */ Version access$getUNKNOWN$cp() {
        return UNKNOWN;
    }

    public static final /* synthetic */ Version access$getVERSION_0_1$cp() {
        return VERSION_0_1;
    }

    public static final /* synthetic */ Version access$getVERSION_1_0$cp() {
        return VERSION_1_0;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Version r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return getBigInteger().compareTo(r100.getBigInteger());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Version) == true) goto L5;
        return false;
    L5:
        Version r101 = (Version) r100;
        if (this.major == r101.major) goto L8;
        return false;
    L8:
        if (this.minor == r101.minor) goto L10;
        return false;
    L10:
        if (this.patch != r101.patch) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Version r100) {
        return compareTo2(r100);
    }

    private Version(int r100, int r101, int r102, String r103) {
        this.major = r100;
        this.minor = r101;
        this.patch = r102;
        this.description = r103;
        this.bigInteger$delegate = LazyKt.lazy(new Version$bigInteger$2(this));
    }
}
