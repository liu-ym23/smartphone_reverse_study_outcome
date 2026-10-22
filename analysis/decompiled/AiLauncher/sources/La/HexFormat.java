package La;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0003\r\u0015\u0011B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017¨\u0006\u0019"}, d2 = {"LLa/g;", "", "", "upperCase", "LLa/g$a;", SingleFileBundle.KEY_BYTES, "LLa/g$c;", Const.JSON_KEY_NUMBER, "<init>", "(ZLLa/g$a;LLa/g$c;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", "getUpperCase", "()Z", Const.INTENT_KEY_PKGNAME, "LLa/g$a;", "getBytes", "()LLa/g$a;", "c", "LLa/g$c;", "()LLa/g$c;", Const.INTENT_KEY_UMID, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: La.g, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public final class HexFormat {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final HexFormat f4360e;

    /* renamed from: f, reason: collision with root package name */
    public static final HexFormat f4361f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean upperCase;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final BytesHexFormat bytes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final NumberHexFormat number;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0001\u0014B9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\rR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\rR\u001a\u0010'\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&R\u001a\u0010-\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010&¨\u0006/"}, d2 = {"LLa/g$a;", "", "", "bytesPerLine", "bytesPerGroup", "", "groupSeparator", "byteSeparator", "bytePrefix", "byteSuffix", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", Const.INTENT_KEY_APIKEY, "I", "getBytesPerLine", "()I", "getBytesPerGroup", "c", "Ljava/lang/String;", "getGroupSeparator", Const.INTENT_KEY_UMID, "getByteSeparator", "e", "getBytePrefix", "f", "getByteSuffix", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "getNoLineAndGroupSeparator$kotlin_stdlib", "()Z", "noLineAndGroupSeparator", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "shortByteSeparatorNoPrefixAndSuffix", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "getIgnoreCase$kotlin_stdlib", "ignoreCase", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: La.g$a, reason: from toString */
    public static final class BytesHexFormat {

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: k, reason: collision with root package name */
        public static final BytesHexFormat f4366k = new BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int bytesPerLine;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int bytesPerGroup;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final String groupSeparator;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final String byteSeparator;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final String bytePrefix;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final String byteSuffix;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final boolean noLineAndGroupSeparator;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final boolean shortByteSeparatorNoPrefixAndSuffix;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final boolean ignoreCase;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LLa/g$a$a;", "", "<init>", "()V", "LLa/g$a;", "Default", "LLa/g$a;", Const.INTENT_KEY_APIKEY, "()LLa/g$a;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: La.g$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final BytesHexFormat a() {
                return BytesHexFormat.f4366k;
            }

            public Companion() {
            }
        }

        public BytesHexFormat(int i10, int i11, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            kotlin.jvm.internal.p.i(groupSeparator, "groupSeparator");
            kotlin.jvm.internal.p.i(byteSeparator, "byteSeparator");
            kotlin.jvm.internal.p.i(bytePrefix, "bytePrefix");
            kotlin.jvm.internal.p.i(byteSuffix, "byteSuffix");
            this.bytesPerLine = i10;
            this.bytesPerGroup = i11;
            this.groupSeparator = groupSeparator;
            this.byteSeparator = byteSeparator;
            this.bytePrefix = bytePrefix;
            this.byteSuffix = byteSuffix;
            this.noLineAndGroupSeparator = i10 == Integer.MAX_VALUE && i11 == Integer.MAX_VALUE;
            this.shortByteSeparatorNoPrefixAndSuffix = bytePrefix.length() == 0 && byteSuffix.length() == 0 && byteSeparator.length() <= 1;
            this.ignoreCase = C0958h.b(groupSeparator) || C0958h.b(byteSeparator) || C0958h.b(bytePrefix) || C0958h.b(byteSuffix);
        }

        public final StringBuilder b(StringBuilder sb2, String indent) {
            kotlin.jvm.internal.p.i(sb2, "sb");
            kotlin.jvm.internal.p.i(indent, "indent");
            sb2.append(indent);
            sb2.append("bytesPerLine = ");
            sb2.append(this.bytesPerLine);
            sb2.append(Const.STR_MART_COMMA);
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("bytesPerGroup = ");
            sb2.append(this.bytesPerGroup);
            sb2.append(Const.STR_MART_COMMA);
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("groupSeparator = \"");
            sb2.append(this.groupSeparator);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("byteSeparator = \"");
            sb2.append(this.byteSeparator);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("bytePrefix = \"");
            sb2.append(this.bytePrefix);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("byteSuffix = \"");
            sb2.append(this.byteSuffix);
            sb2.append("\"");
            return sb2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BytesHexFormat(");
            sb2.append('\n');
            b(sb2, "    ").append('\n');
            sb2.append(")");
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LLa/g$b;", "", "<init>", "()V", "LLa/g;", "Default", "LLa/g;", Const.INTENT_KEY_APIKEY, "()LLa/g;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: La.g$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final HexFormat a() {
            return HexFormat.f4360e;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 &2\u00020\u0001:\u0001\u0013B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00060\rj\u0002`\u000e2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001a\u0010#\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u001a\u0010%\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a¨\u0006'"}, d2 = {"LLa/g$c;", "", "", "prefix", "suffix", "", "removeLeadingZeros", "", "minLength", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "toString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, "e", "c", "Z", "getRemoveLeadingZeros", "()Z", "I", "getMinLength", "()I", "getMinLength$annotations", "()V", "f", "isDigitsOnly", "isDigitsOnlyAndNoPadding$kotlin_stdlib", "isDigitsOnlyAndNoPadding", Const.INTENT_KEY_BACKGROUND_COMMAND, "ignoreCase", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: La.g$c, reason: from toString */
    public static final class NumberHexFormat {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: i, reason: collision with root package name */
        public static final NumberHexFormat f4377i = new NumberHexFormat("", "", false, 1);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String prefix;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String suffix;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final boolean removeLeadingZeros;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final int minLength;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final boolean isDigitsOnly;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final boolean isDigitsOnlyAndNoPadding;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final boolean ignoreCase;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LLa/g$c$a;", "", "<init>", "()V", "LLa/g$c;", "Default", "LLa/g$c;", Const.INTENT_KEY_APIKEY, "()LLa/g$c;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: La.g$c$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final NumberHexFormat a() {
                return NumberHexFormat.f4377i;
            }

            public Companion() {
            }
        }

        public NumberHexFormat(String prefix, String suffix, boolean z10, int i10) {
            kotlin.jvm.internal.p.i(prefix, "prefix");
            kotlin.jvm.internal.p.i(suffix, "suffix");
            this.prefix = prefix;
            this.suffix = suffix;
            this.removeLeadingZeros = z10;
            this.minLength = i10;
            boolean z11 = prefix.length() == 0 && suffix.length() == 0;
            this.isDigitsOnly = z11;
            this.isDigitsOnlyAndNoPadding = z11 && i10 == 1;
            this.ignoreCase = C0958h.b(prefix) || C0958h.b(suffix);
        }

        public final StringBuilder b(StringBuilder sb2, String indent) {
            kotlin.jvm.internal.p.i(sb2, "sb");
            kotlin.jvm.internal.p.i(indent, "indent");
            sb2.append(indent);
            sb2.append("prefix = \"");
            sb2.append(this.prefix);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("suffix = \"");
            sb2.append(this.suffix);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("removeLeadingZeros = ");
            sb2.append(this.removeLeadingZeros);
            sb2.append(',');
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("minLength = ");
            sb2.append(this.minLength);
            return sb2;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIgnoreCase() {
            return this.ignoreCase;
        }

        /* renamed from: d, reason: from getter */
        public final String getPrefix() {
            return this.prefix;
        }

        /* renamed from: e, reason: from getter */
        public final String getSuffix() {
            return this.suffix;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsDigitsOnly() {
            return this.isDigitsOnly;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NumberHexFormat(");
            sb2.append('\n');
            b(sb2, "    ").append('\n');
            sb2.append(")");
            return sb2.toString();
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.INSTANCE;
        BytesHexFormat bytesHexFormatA = companion.a();
        NumberHexFormat.Companion companion2 = NumberHexFormat.INSTANCE;
        f4360e = new HexFormat(false, bytesHexFormatA, companion2.a());
        f4361f = new HexFormat(true, companion.a(), companion2.a());
    }

    public HexFormat(boolean z10, BytesHexFormat bytes, NumberHexFormat number) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        kotlin.jvm.internal.p.i(number, "number");
        this.upperCase = z10;
        this.bytes = bytes;
        this.number = number;
    }

    /* renamed from: b, reason: from getter */
    public final NumberHexFormat getNumber() {
        return this.number;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HexFormat(");
        sb2.append('\n');
        sb2.append("    upperCase = ");
        sb2.append(this.upperCase);
        sb2.append(Const.STR_MART_COMMA);
        sb2.append('\n');
        sb2.append("    bytes = BytesHexFormat(");
        sb2.append('\n');
        this.bytes.b(sb2, "        ").append('\n');
        sb2.append("    ),");
        sb2.append('\n');
        sb2.append("    number = NumberHexFormat(");
        sb2.append('\n');
        this.number.b(sb2, "        ").append('\n');
        sb2.append("    )");
        sb2.append('\n');
        sb2.append(")");
        return sb2.toString();
    }
}
