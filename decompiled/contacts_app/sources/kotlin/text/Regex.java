package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Regex implements Serializable {
    public static final Companion Companion = null;
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final int ensureUnicodeCase(int r1) {
            if ((r1 & 2) != 0) goto L5;
            return r1;
        L5:
            return r1 | 64;
        }

        private Companion() {
        }

        public static final /* synthetic */ int access$ensureUnicodeCase(Companion r0, int r1) {
            return r0.ensureUnicodeCase(r1);
        }

        public final Regex fromLiteral(String r2) {
            Intrinsics.checkNotNullParameter(r2, "literal");
            return new Regex(r2, RegexOption.LITERAL);
        }

        public final String escape(String r1) {
            Intrinsics.checkNotNullParameter(r1, "literal");
            String r0 = Pattern.quote(r1);
            Intrinsics.checkNotNullExpressionValue(r0, "quote(...)");
            return r0;
        }

        public final String escapeReplacement(String r1) {
            Intrinsics.checkNotNullParameter(r1, "literal");
            String r0 = Matcher.quoteReplacement(r1);
            Intrinsics.checkNotNullExpressionValue(r0, "quoteReplacement(...)");
            return r0;
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* JADX INFO: compiled from: Regex.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Serialized(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "pattern");
            this.pattern = r2;
            this.flags = r3;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern r2 = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(r2, "compile(...)");
            return new Regex(r2);
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult r1) {
            Intrinsics.checkNotNullParameter(r1, "p0");
            return r1.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    static final class C05141 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Regex this$0;

        C05141(Regex r1, CharSequence r2, int r3, Continuation<? super C05141> r4) {
            this.this$0 = r1;
            this.$input = r2;
            this.$limit = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C05141 r0 = new C05141(this.this$0, this.$input, this.$limit, r5);
            r0.L$0 = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super String> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super String> r1, Continuation<? super Unit> r2) {
            return ((C05141) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0071 -> B:21:0x0074). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r2 = this.I$0;
            Matcher r5 = (Matcher) this.L$1;
            SequenceScope r6 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            Matcher r11 = r5;
        L21:
            int r7 = r11.end();
            r2 = r2 + 1;
            if (r2 != (this.$limit - 1)) goto L24;
        L25:
            CharSequence r12 = this.$input;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r6.yield(r12.subSequence(r7, r12.length()).toString(), this) != r0) goto L29;
            return r0;
        L24:
            if (r11.find() == false) goto L25;
        L18:
            this.L$0 = r6;
            this.L$1 = r11;
            this.I$0 = r2;
            this.label = 2;
            if (r6.yield(this.$input.subSequence(r7, r11.start()).toString(), this) != r0) goto L21;
            return r0;
        L11:
            ResultKt.throwOnFailure(r10);
        L34:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);
            SequenceScope r13 = (SequenceScope) this.L$0;
            Matcher r3 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
            if (this.$limit != 1) goto L15;
        L30:
            this.label = 1;
            if (r13.yield(this.$input.toString(), this) != r0) goto L34;
            return r0;
        L15:
            if (r3.find() == false) goto L30;
            r7 = 0;
            r6 = r13;
            r11 = r3;
            r2 = 0;
            goto L18
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Regex(Pattern r2) {
        Intrinsics.checkNotNullParameter(r2, "nativePattern");
        this.nativePattern = r2;
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r0) {
        return r0.nativePattern;
    }

    public Regex(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Pattern r3 = Pattern.compile(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "compile(...)");
        this(r3);
    }

    public Regex(String r2, RegexOption r3) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Intrinsics.checkNotNullParameter(r3, "option");
        Pattern r4 = Pattern.compile(r2, Companion.access$ensureUnicodeCase(Companion, r3.getValue()));
        Intrinsics.checkNotNullExpressionValue(r4, "compile(...)");
        this(r4);
    }

    public Regex(String r2, Set<? extends RegexOption> r3) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Intrinsics.checkNotNullParameter(r3, "options");
        Pattern r4 = Pattern.compile(r2, Companion.access$ensureUnicodeCase(Companion, RegexKt.access$toInt(r3)));
        Intrinsics.checkNotNullExpressionValue(r4, "compile(...)");
        this(r4);
    }

    public final String getPattern() {
        String r1 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(r1, "pattern(...)");
        return r1;
    }

    public final Set<RegexOption> getOptions() {
        Set r0 = this._options;
        if (r0 != null) goto L6;
        final int r1 = this.nativePattern.flags();
        EnumSet r2 = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull(r2);
        CollectionsKt.retainAll(r2, new Regex$special$$inlined$fromInt$1(r1));
        Set<RegexOption> r3 = Collections.unmodifiableSet(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "unmodifiableSet(...)");
        this._options = r3;
        return r3;
    L6:
        return r0;
    }

    public final boolean matches(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return this.nativePattern.matcher(r2).matches();
    }

    public final boolean containsMatchIn(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return this.nativePattern.matcher(r2).find();
    }

    public static /* synthetic */ MatchResult find$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.find(r1, r2);
    }

    public final MatchResult find(CharSequence r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Matcher r1 = this.nativePattern.matcher(r2);
        Intrinsics.checkNotNullExpressionValue(r1, "matcher(...)");
        return RegexKt.access$findNext(r1, r3, r2);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.findAll(r1, r2);
    }

    public final Sequence<MatchResult> findAll(final CharSequence r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        if (r4 < 0) goto L9;
        if (r4 > r3.length()) goto L9;
        return SequencesKt.generateSequence(new AnonymousClass1(this, r3, r4), AnonymousClass2.INSTANCE);
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r4 + ", input length: " + r3.length());
    }

    public final MatchResult matchEntire(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Matcher r1 = this.nativePattern.matcher(r2);
        Intrinsics.checkNotNullExpressionValue(r1, "matcher(...)");
        return RegexKt.access$matchEntire(r1, r2);
    }

    public final MatchResult matchAt(CharSequence r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Matcher r1 = this.nativePattern.matcher(r2).useAnchoringBounds(false).useTransparentBounds(true).region(r3, r2.length());
        if (r1.lookingAt() == false) goto L5;
        Intrinsics.checkNotNull(r1);
        MatcherMatchResult r4 = new MatcherMatchResult(r1, r2);
    L7:
        return r4;
    L5:
        r4 = null;
        goto L7
    }

    public final boolean matchesAt(CharSequence r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return this.nativePattern.matcher(r2).useAnchoringBounds(false).useTransparentBounds(true).region(r3, r2.length()).lookingAt();
    }

    public final String replace(CharSequence r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        String r1 = this.nativePattern.matcher(r2).replaceAll(r3);
        Intrinsics.checkNotNullExpressionValue(r1, "replaceAll(...)");
        return r1;
    }

    public final String replace(CharSequence r5, Function1<? super MatchResult, ? extends CharSequence> r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "transform");
        int r2 = 0;
        MatchResult r4 = find$default(this, r5, 0, 2, null);
        if (r4 == null) goto L5;
        int r0 = r5.length();
        StringBuilder r1 = new StringBuilder(r0);
    L7:
        r1.append(r5, r2, r4.getRange().getStart().intValue());
        r1.append(r6.invoke(r4));
        r2 = r4.getRange().getEndInclusive().intValue() + 1;
        r4 = r4.next();
        if (r2 >= r0) goto L10;
        if (r4 != null) goto L7;
    L10:
        if (r2 >= r0) goto L12;
        r1.append(r5, r2, r0);
    L12:
        String r7 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    L5:
        return r5.toString();
    }

    public final String replaceFirst(CharSequence r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        String r1 = this.nativePattern.matcher(r2).replaceFirst(r3);
        Intrinsics.checkNotNullExpressionValue(r1, "replaceFirst(...)");
        return r1;
    }

    public static /* synthetic */ List split$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.split(r1, r2);
    }

    public final List<String> split(CharSequence r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        StringsKt.requireNonNegativeLimit(r5);
        Matcher r3 = this.nativePattern.matcher(r4);
        if (r5 == 1) goto L20;
        if (r3.find() == false) goto L20;
        int r2 = 10;
        if (r5 <= 0) goto L10;
        r2 = RangesKt.coerceAtMost(r5, 10);
    L10:
        ArrayList r1 = new ArrayList(r2);
        int r6 = r5 - 1;
        int r0 = 0;
    L11:
        r1.add(r4.subSequence(r0, r3.start()).toString());
        r0 = r3.end();
        if (r6 < 0) goto L16;
        if (r1.size() != r6) goto L16;
    L17:
        r1.add(r4.subSequence(r0, r4.length()).toString());
        return r1;
    L16:
        if (r3.find() == true) goto L11;
    L20:
        return CollectionsKt.listOf(r4.toString());
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.splitToSequence(r1, r2);
    }

    public final Sequence<String> splitToSequence(CharSequence r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        StringsKt.requireNonNegativeLimit(r4);
        return SequencesKt.sequence(new C05141(this, r3, r4, null));
    }

    public String toString() {
        String r1 = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String r1 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(r1, "pattern(...)");
        return new Serialized(r1, this.nativePattern.flags());
    }
}
