package kotlin.text;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.s;
import kotlin.collections.y;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0011\u0018\u0000 =2\u00060\u0001j\u0002`\u0002:\u0002>?B\u0011\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0005\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0086\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0017J!\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0019H\u0007¢\u0006\u0004\b$\u0010\u001dJ\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0019H\u0007¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\b(\u0010)J)\u0010(\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130*¢\u0006\u0004\b(\u0010,J\u001d\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\b-\u0010)J%\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070/2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u0019¢\u0006\u0004\b0\u00101J'\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u0019H\u0007¢\u0006\u0004\b2\u0010 J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0003¢\u0006\u0004\b5\u00106R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00107R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b:\u00104R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8F¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/regex/Pattern;", "nativePattern", "<init>", "(Ljava/util/regex/Pattern;)V", "", "pattern", "(Ljava/lang/String;)V", "Lkotlin/text/RegexOption;", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "", "options", "(Ljava/lang/String;Ljava/util/Set;)V", "", "writeReplace", "()Ljava/lang/Object;", "", "input", "", "matches", "(Ljava/lang/CharSequence;)Z", "containsMatchIn", "", "startIndex", "Lkotlin/text/MatchResult;", "find", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "Lkotlin/sequences/Sequence;", "findAll", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "matchEntire", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", SlideCard.KEY_INDEX, "matchAt", "matchesAt", "(Ljava/lang/CharSequence;I)Z", "replacement", "replace", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "replaceFirst", CommonColumns.PARAMETER_LIMIT, "", AppInfo.SEARCH_SOURCE_SPLIT, "(Ljava/lang/CharSequence;I)Ljava/util/List;", "splitToSequence", "toString", "()Ljava/lang/String;", "toPattern", "()Ljava/util/regex/Pattern;", "Ljava/util/regex/Pattern;", "_options", "Ljava/util/Set;", "getPattern", "getOptions", "()Ljava/util/Set;", "Companion", "a", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n22#2,3:398\n1#3:401\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n103#1:398,3\n*E\n"})
public final class Regex implements Serializable {

    @NotNull
    public static final a Companion = null;

    @Nullable
    private Set<? extends RegexOption> _options;

    @NotNull
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0013B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "pattern", "", "flags", "<init>", "(Ljava/lang/String;I)V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "I", "getFlags", "()I", "Companion", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Serialized implements Serializable {

        @NotNull
        public static final a Companion = null;
        private static final long serialVersionUID = 0;
        private final int flags;

        @NotNull
        private final String pattern;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            Companion = new a(null);
        }

        public Serialized(@NotNull String r10, int r11) {
            kotlin.jvm.internal.q.g(r10, "pattern");
            this.pattern = r10;
            this.flags = r11;
        }

        private final Object readResolve() {
            Pattern r10 = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.q.f(r10, "compile(...)");
            return new Regex(r10);
        }

        public final int getFlags() {
            return this.flags;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int a(a r10, int r11) {
            return r10.b(r11);
        }

        public final int b(int r10) {
            if ((r10 & 2) != 0) goto L5;
            return r10;
        L5:
            return r10 | 64;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult r10) {
            return invoke2(r10);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(@NotNull MatchResult r10) {
            kotlin.jvm.internal.q.g(r10, "p0");
            return r10.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/g;", "", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    public static final class C04541 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.g, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Regex this$0;

        public C04541(Regex r10, CharSequence r11, int r12, Continuation<? super C04541> r13) {
            this.this$0 = r10;
            this.$input = r11;
            this.$limit = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            C04541 r12 = new C04541(this.this$0, this.$input, this.$limit, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(kotlin.sequences.g r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L12;
            if (r12 == 1) goto L11;
            if (r12 == 2) goto L10;
            if (r12 != 3) goto L9;
            kotlin.c.b(r10);
        L29:
            return Unit.f21064a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r13 = this.I$0;
            Matcher r14 = (Matcher) this.L$1;
            kotlin.sequences.g r15 = (kotlin.sequences.g) this.L$0;
            kotlin.c.b(r10);
            Matcher r16 = r14;
        L21:
            int r17 = r16.end();
            r13 = r13 + 1;
            if (r13 != (this.$limit - 1)) goto L24;
        L25:
            CharSequence r18 = this.$input;
            String r19 = r18.subSequence(r17, r18.length()).toString();
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r15.a(r19, this) != r11) goto L29;
            return r11;
        L24:
            if (r16.find() == false) goto L25;
        L18:
            String r20 = this.$input.subSequence(r17, r16.start()).toString();
            this.L$0 = r15;
            this.L$1 = r16;
            this.I$0 = r13;
            this.label = 2;
            if (r15.a(r20, this) != r11) goto L21;
            return r11;
        L11:
            kotlin.c.b(r10);
        L34:
            return Unit.f21064a;
        L12:
            kotlin.c.b(r10);
            kotlin.sequences.g r110 = (kotlin.sequences.g) this.L$0;
            Matcher r21 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
            if (this.$limit != 1) goto L15;
        L30:
            String r22 = this.$input.toString();
            this.label = 1;
            if (r110.a(r22, this) != r11) goto L34;
            return r11;
        L15:
            if (r21.find() == false) goto L30;
            r17 = 0;
            r15 = r110;
            r16 = r21;
            r13 = 0;
            goto L18
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull kotlin.sequences.g r10, @Nullable Continuation<? super Unit> r11) {
            return ((C04541) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        Companion = new a(null);
    }

    @PublishedApi
    public Regex(@NotNull Pattern r10) {
        kotlin.jvm.internal.q.g(r10, "nativePattern");
        this.nativePattern = r10;
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r10) {
        return r10.nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.find(r11, r12);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.findAll(r11, r12);
    }

    public static /* synthetic */ List split$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.split(r11, r12);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.splitToSequence(r11, r12);
    }

    private final Object writeReplace() {
        String r10 = this.nativePattern.pattern();
        kotlin.jvm.internal.q.f(r10, "pattern(...)");
        return new Serialized(r10, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "input");
        return this.nativePattern.matcher(r10).find();
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        Matcher r12 = this.nativePattern.matcher(r10);
        kotlin.jvm.internal.q.f(r12, "matcher(...)");
        return f.a(r12, r11, r10);
    }

    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull final CharSequence r10, final int r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        if (r11 < 0) goto L9;
        if (r11 > r10.length()) goto L9;
        return SequencesKt__SequencesKt.g(new AnonymousClass1(this, r10, r11), AnonymousClass2.INSTANCE);
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r11 + ", input length: " + r10.length());
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set r10 = this._options;
        if (r10 != null) goto L6;
        final int r11 = this.nativePattern.flags();
        EnumSet r12 = EnumSet.allOf(RegexOption.class);
        kotlin.jvm.internal.q.d(r12);
        y.E(r12, new Regex$special$$inlined$fromInt$1(r11));
        Set<RegexOption> r13 = Collections.unmodifiableSet(r12);
        kotlin.jvm.internal.q.f(r13, "unmodifiableSet(...)");
        this._options = r13;
        return r13;
    L6:
        return r10;
    }

    @NotNull
    public final String getPattern() {
        String r10 = this.nativePattern.pattern();
        kotlin.jvm.internal.q.f(r10, "pattern(...)");
        return r10;
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public final MatchResult matchAt(@NotNull CharSequence r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        Matcher r12 = this.nativePattern.matcher(r10).useAnchoringBounds(false).useTransparentBounds(true).region(r11, r10.length());
        if (r12.lookingAt() == false) goto L5;
        kotlin.jvm.internal.q.d(r12);
        return new MatcherMatchResult(r12, r10);
    L5:
        return null;
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "input");
        Matcher r11 = this.nativePattern.matcher(r10);
        kotlin.jvm.internal.q.f(r11, "matcher(...)");
        return f.b(r11, r10);
    }

    public final boolean matches(@NotNull CharSequence r10) {
        kotlin.jvm.internal.q.g(r10, "input");
        return this.nativePattern.matcher(r10).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean matchesAt(@NotNull CharSequence r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        return this.nativePattern.matcher(r10).useAnchoringBounds(false).useTransparentBounds(true).region(r11, r10.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence r10, @NotNull String r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        kotlin.jvm.internal.q.g(r11, "replacement");
        String r12 = this.nativePattern.matcher(r10).replaceAll(r11);
        kotlin.jvm.internal.q.f(r12, "replaceAll(...)");
        return r12;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence r10, @NotNull String r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        kotlin.jvm.internal.q.g(r11, "replacement");
        String r12 = this.nativePattern.matcher(r10).replaceFirst(r11);
        kotlin.jvm.internal.q.f(r12, "replaceFirst(...)");
        return r12;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        StringsKt__StringsKt.i0(r11);
        Matcher r12 = this.nativePattern.matcher(r10);
        if (r11 == 1) goto L20;
        if (r12.find() == false) goto L20;
        int r13 = 10;
        if (r11 <= 0) goto L10;
        r13 = bg.h.g(r11, 10);
    L10:
        ArrayList r14 = new ArrayList(r13);
        int r15 = r11 - 1;
        int r16 = 0;
    L11:
        r14.add(r10.subSequence(r16, r12.start()).toString());
        r16 = r12.end();
        if (r15 < 0) goto L16;
        if (r14.size() != r15) goto L16;
    L17:
        r14.add(r10.subSequence(r16, r10.length()).toString());
        return r14;
    L16:
        if (r12.find() == true) goto L11;
    L20:
        return s.e(r10.toString());
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public final Sequence<String> splitToSequence(@NotNull CharSequence r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        StringsKt__StringsKt.i0(r11);
        return kotlin.sequences.h.b(new C04541(this, r10, r11, null));
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String r10 = this.nativePattern.toString();
        kotlin.jvm.internal.q.f(r10, "toString(...)");
        return r10;
    }

    @NotNull
    public final String replace(@NotNull CharSequence r10, @NotNull Function1<? super MatchResult, ? extends CharSequence> r11) {
        kotlin.jvm.internal.q.g(r10, "input");
        kotlin.jvm.internal.q.g(r11, "transform");
        int r12 = 0;
        MatchResult r13 = find$default(this, r10, 0, 2, null);
        if (r13 == null) goto L5;
        int r14 = r10.length();
        StringBuilder r15 = new StringBuilder(r14);
    L7:
        r15.append(r10, r12, r13.getRange().i().intValue());
        r15.append(r11.invoke(r13));
        r12 = r13.getRange().h().intValue() + 1;
        r13 = r13.next();
        if (r12 >= r14) goto L10;
        if (r13 != null) goto L7;
    L10:
        if (r12 >= r14) goto L12;
        r15.append(r10, r12, r14);
    L12:
        String r16 = r15.toString();
        kotlin.jvm.internal.q.f(r16, "toString(...)");
        return r16;
    L5:
        return r10.toString();
    }

    public Regex(@NotNull String r10) {
        kotlin.jvm.internal.q.g(r10, "pattern");
        Pattern r11 = Pattern.compile(r10);
        kotlin.jvm.internal.q.f(r11, "compile(...)");
        this(r11);
    }

    public Regex(@NotNull String r10, @NotNull RegexOption r11) {
        kotlin.jvm.internal.q.g(r10, "pattern");
        kotlin.jvm.internal.q.g(r11, "option");
        Pattern r12 = Pattern.compile(r10, a.a(Companion, r11.getValue()));
        kotlin.jvm.internal.q.f(r12, "compile(...)");
        this(r12);
    }

    public Regex(@NotNull String r10, @NotNull Set<? extends RegexOption> r11) {
        kotlin.jvm.internal.q.g(r10, "pattern");
        kotlin.jvm.internal.q.g(r11, "options");
        Pattern r12 = Pattern.compile(r10, a.a(Companion, f.e(r11)));
        kotlin.jvm.internal.q.f(r12, "compile(...)");
        this(r12);
    }
}
