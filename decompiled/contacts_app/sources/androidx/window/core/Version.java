package androidx.window.core;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Version.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/window/core/Version;", "", "major", "", "minor", CloudControlInf.PATCH, "description", "", "(IIILjava/lang/String;)V", "bigInteger", "Ljava/math/BigInteger;", "getBigInteger", "()Ljava/math/BigInteger;", "bigInteger$delegate", "Lkotlin/Lazy;", "getDescription", "()Ljava/lang/String;", "getMajor", "()I", "getMinor", "getPatch", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* JADX INFO: compiled from: Version.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "()V", "CURRENT", "Landroidx/window/core/Version;", "getCURRENT", "()Landroidx/window/core/Version;", "UNKNOWN", "getUNKNOWN", "VERSION_0_1", "getVERSION_0_1", "VERSION_1_0", "getVERSION_1_0", "VERSION_PATTERN_STRING", "", "parse", "versionString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
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

        public final Version getCURRENT() {
            return Version.access$getCURRENT$cp();
        }

        @JvmStatic
        public final Version parse(String r8) {
            if (r8 == null) goto L34;
            String r9 = r8;
            if (StringsKt.isBlank(r9) == true) goto L35;
            Matcher r10 = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(r9);
            if (r10.matches() == true) goto L10;
            return null;
        L10:
            String r0 = r10.group(1);
            if (r0 != null) goto L13;
            Integer r1 = null;
        L14:
            if (r1 != null) goto L16;
            return null;
        L16:
            int r2 = r1.intValue();
            String r3 = r10.group(2);
            if (r3 != null) goto L19;
            Integer r4 = null;
        L20:
            if (r4 != null) goto L22;
            return null;
        L22:
            int r5 = r4.intValue();
            String r6 = r10.group(3);
            if (r6 != null) goto L25;
            Integer r7 = null;
        L26:
            if (r7 != null) goto L28;
            return null;
        L28:
            int r11 = r7.intValue();
            if (r10.group(4) == null) goto L31;
            String r12 = r10.group(4);
        L32:
            String r13 = r12;
            Intrinsics.checkNotNullExpressionValue(r13, "description");
            return new Version(r2, r5, r11, r13, null);
        L31:
            r12 = "";
            goto L32
        L25:
            r7 = Integer.valueOf(Integer.parseInt(r6));
            goto L26
        L19:
            r4 = Integer.valueOf(Integer.parseInt(r3));
            goto L20
        L13:
            r1 = Integer.valueOf(Integer.parseInt(r0));
            goto L14
        L35:
            return null;
        L34:
            return null;
        }
    }

    public /* synthetic */ Version(int r1, int r2, int r3, String r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final Version parse(String r1) {
        return Companion.parse(r1);
    }

    private Version(int r1, int r2, int r3, String r4) {
        this.major = r1;
        this.minor = r2;
        this.patch = r3;
        this.description = r4;
        this.bigInteger$delegate = LazyKt.lazy(new Version$bigInteger$2(this));
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

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Version r1) {
        return compareTo2(r1);
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

    public final String getDescription() {
        return this.description;
    }

    private final BigInteger getBigInteger() {
        Object r1 = this.bigInteger$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-bigInteger>(...)");
        return (BigInteger) r1;
    }

    public String toString() {
        if ((!StringsKt.isBlank(this.description)) == false) goto L5;
        String r0 = Intrinsics.stringPlus("-", this.description);
    L7:
        return this.major + '.' + this.minor + '.' + this.patch + r0;
    L5:
        r0 = "";
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Version r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        return getBigInteger().compareTo(r2.getBigInteger());
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Version) == true) goto L5;
        return false;
    L5:
        Version r5 = (Version) r4;
        if (this.major == r5.major) goto L8;
        return false;
    L8:
        if (this.minor == r5.minor) goto L10;
        return false;
    L10:
        if (this.patch != r5.patch) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    static {
        Companion = new Companion(null);
        UNKNOWN = new Version(0, 0, 0, "");
        VERSION_0_1 = new Version(0, 1, 0, "");
        Version r0 = new Version(1, 0, 0, "");
        VERSION_1_0 = r0;
        CURRENT = r0;
    }
}
