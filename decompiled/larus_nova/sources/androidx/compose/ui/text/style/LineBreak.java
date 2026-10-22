package androidx.compose.ui.text.style;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fJ+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", BuyNowCloseMethod.MASK, "", "constructor-impl", "(I)I", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "(III)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-gijOMQM", "(IIII)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class LineBreak {
    public static final Companion Companion = null;
    private static final int Heading = 0;
    private static final int Paragraph = 0;
    private static final int Simple = 0;
    private static final int Unspecified = 0;
    private final int mask;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak;", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "()I", "I", "Heading", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", "Paragraph", "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getHeading-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7332getHeadingrAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getParagraph-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7333getParagraphrAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7334getSimplerAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-rAG3T2k$annotations, reason: not valid java name */
        public static /* synthetic */ void m7335getUnspecifiedrAG3T2k$annotations() {
        }

        /* JADX INFO: renamed from: getHeading-rAG3T2k, reason: not valid java name */
        public final int m7336getHeadingrAG3T2k() {
            return LineBreak.access$getHeading$cp();
        }

        /* JADX INFO: renamed from: getParagraph-rAG3T2k, reason: not valid java name */
        public final int m7337getParagraphrAG3T2k() {
            return LineBreak.access$getParagraph$cp();
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m7338getSimplerAG3T2k() {
            return LineBreak.access$getSimple$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m7339getUnspecifiedrAG3T2k() {
            return LineBreak.access$getUnspecified$cp();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Strategy {
        private static final int Balanced = 0;
        public static final Companion Companion = null;
        private static final int HighQuality = 0;
        private static final int Simple = 0;
        private static final int Unspecified = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getSimple-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Balanced", "getBalanced-fcGXIks", "Unspecified", "getUnspecified-fcGXIks", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m7347getBalancedfcGXIks() {
                return Strategy.access$getBalanced$cp();
            }

            /* JADX INFO: renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m7348getHighQualityfcGXIks() {
                return Strategy.access$getHighQuality$cp();
            }

            /* JADX INFO: renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m7349getSimplefcGXIks() {
                return Strategy.access$getSimple$cp();
            }

            /* JADX INFO: renamed from: getUnspecified-fcGXIks, reason: not valid java name */
            public final int m7350getUnspecifiedfcGXIks() {
                return Strategy.access$getUnspecified$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m7340boximpl(int r100) {
            return new Strategy(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m7341constructorimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7342equalsimpl(int r100, Object r101) {
            if ((r101 instanceof Strategy) == true) goto L6;
            return false;
        L6:
            if (r100 == ((Strategy) r101).m7346unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7343equalsimpl0(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7344hashCodeimpl(int r100) {
            return r100;
        }

        public boolean equals(Object r100) {
            return m7342equalsimpl(this.value, r100);
        }

        public int hashCode() {
            return m7344hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m7346unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Simple = m7341constructorimpl(1);
            HighQuality = m7341constructorimpl(2);
            Balanced = m7341constructorimpl(3);
            Unspecified = m7341constructorimpl(0);
        }

        public String toString() {
            return m7345toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getBalanced$cp() {
            return Balanced;
        }

        public static final /* synthetic */ int access$getHighQuality$cp() {
            return HighQuality;
        }

        public static final /* synthetic */ int access$getSimple$cp() {
            return Simple;
        }

        public static final /* synthetic */ int access$getUnspecified$cp() {
            return Unspecified;
        }

        private /* synthetic */ Strategy(int r100) {
            this.value = r100;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7345toStringimpl(int r100) {
            if (m7343equalsimpl0(r100, Simple) == false) goto L6;
            return "Strategy.Simple";
        L6:
            if (m7343equalsimpl0(r100, HighQuality) == false) goto L9;
            return "Strategy.HighQuality";
        L9:
            if (m7343equalsimpl0(r100, Balanced) == false) goto L12;
            return "Strategy.Balanced";
        L12:
            if (m7343equalsimpl0(r100, Unspecified) == false) goto L14;
            return "Strategy.Unspecified";
        L14:
            return "Invalid";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class Strictness {
        public static final Companion Companion = null;
        private static final int Default = 0;
        private static final int Loose = 0;
        private static final int Normal = 0;
        private static final int Strict = 0;
        private static final int Unspecified = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "Unspecified", "getUnspecified-usljTpc", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m7358getDefaultusljTpc() {
                return Strictness.access$getDefault$cp();
            }

            /* JADX INFO: renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m7359getLooseusljTpc() {
                return Strictness.access$getLoose$cp();
            }

            /* JADX INFO: renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m7360getNormalusljTpc() {
                return Strictness.access$getNormal$cp();
            }

            /* JADX INFO: renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m7361getStrictusljTpc() {
                return Strictness.access$getStrict$cp();
            }

            /* JADX INFO: renamed from: getUnspecified-usljTpc, reason: not valid java name */
            public final int m7362getUnspecifiedusljTpc() {
                return Strictness.access$getUnspecified$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m7351boximpl(int r100) {
            return new Strictness(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m7352constructorimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7353equalsimpl(int r100, Object r101) {
            if ((r101 instanceof Strictness) == true) goto L6;
            return false;
        L6:
            if (r100 == ((Strictness) r101).m7357unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7354equalsimpl0(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7355hashCodeimpl(int r100) {
            return r100;
        }

        public boolean equals(Object r100) {
            return m7353equalsimpl(this.value, r100);
        }

        public int hashCode() {
            return m7355hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m7357unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Default = m7352constructorimpl(1);
            Loose = m7352constructorimpl(2);
            Normal = m7352constructorimpl(3);
            Strict = m7352constructorimpl(4);
            Unspecified = m7352constructorimpl(0);
        }

        public String toString() {
            return m7356toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getDefault$cp() {
            return Default;
        }

        public static final /* synthetic */ int access$getLoose$cp() {
            return Loose;
        }

        public static final /* synthetic */ int access$getNormal$cp() {
            return Normal;
        }

        public static final /* synthetic */ int access$getStrict$cp() {
            return Strict;
        }

        public static final /* synthetic */ int access$getUnspecified$cp() {
            return Unspecified;
        }

        private /* synthetic */ Strictness(int r100) {
            this.value = r100;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7356toStringimpl(int r100) {
            if (m7354equalsimpl0(r100, Default) == false) goto L6;
            return "Strictness.None";
        L6:
            if (m7354equalsimpl0(r100, Loose) == false) goto L9;
            return "Strictness.Loose";
        L9:
            if (m7354equalsimpl0(r100, Normal) == false) goto L12;
            return "Strictness.Normal";
        L12:
            if (m7354equalsimpl0(r100, Strict) == false) goto L15;
            return "Strictness.Strict";
        L15:
            if (m7354equalsimpl0(r100, Unspecified) == false) goto L17;
            return "Strictness.Unspecified";
        L17:
            return "Invalid";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class WordBreak {
        public static final Companion Companion = null;
        private static final int Default = 0;
        private static final int Phrase = 0;
        private static final int Unspecified = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "Unspecified", "getUnspecified-jp8hJ3c", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX INFO: renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m7370getDefaultjp8hJ3c() {
                return WordBreak.access$getDefault$cp();
            }

            /* JADX INFO: renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m7371getPhrasejp8hJ3c() {
                return WordBreak.access$getPhrase$cp();
            }

            /* JADX INFO: renamed from: getUnspecified-jp8hJ3c, reason: not valid java name */
            public final int m7372getUnspecifiedjp8hJ3c() {
                return WordBreak.access$getUnspecified$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m7363boximpl(int r100) {
            return new WordBreak(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m7364constructorimpl(int r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7365equalsimpl(int r100, Object r101) {
            if ((r101 instanceof WordBreak) == true) goto L6;
            return false;
        L6:
            if (r100 == ((WordBreak) r101).m7369unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7366equalsimpl0(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7367hashCodeimpl(int r100) {
            return r100;
        }

        public boolean equals(Object r100) {
            return m7365equalsimpl(this.value, r100);
        }

        public int hashCode() {
            return m7367hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m7369unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Default = m7364constructorimpl(1);
            Phrase = m7364constructorimpl(2);
            Unspecified = m7364constructorimpl(0);
        }

        public String toString() {
            return m7368toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getDefault$cp() {
            return Default;
        }

        public static final /* synthetic */ int access$getPhrase$cp() {
            return Phrase;
        }

        public static final /* synthetic */ int access$getUnspecified$cp() {
            return Unspecified;
        }

        private /* synthetic */ WordBreak(int r100) {
            this.value = r100;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7368toStringimpl(int r100) {
            if (m7366equalsimpl0(r100, Default) == false) goto L6;
            return "WordBreak.None";
        L6:
            if (m7366equalsimpl0(r100, Phrase) == false) goto L9;
            return "WordBreak.Phrase";
        L9:
            if (m7366equalsimpl0(r100, Unspecified) == false) goto L11;
            return "WordBreak.Unspecified";
        L11:
            return "Invalid";
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m7319boximpl(int r100) {
        return new LineBreak(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m7320constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7324equalsimpl(int r100, Object r101) {
        if ((r101 instanceof LineBreak) == true) goto L6;
        return false;
    L6:
        if (r100 == ((LineBreak) r101).m7331unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7325equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7329hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m7324equalsimpl(this.mask, r100);
    }

    public int hashCode() {
        return m7329hashCodeimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m7331unboximpl() {
        return this.mask;
    }

    static {
        Companion = new Companion(null);
        Strategy.Companion r100 = Strategy.Companion;
        int r101 = r100.m7349getSimplefcGXIks();
        Strictness.Companion r102 = Strictness.Companion;
        int r103 = r102.m7360getNormalusljTpc();
        WordBreak.Companion r104 = WordBreak.Companion;
        Simple = m7320constructorimpl(LineBreak_androidKt.access$packBytes(r101, r103, r104.m7370getDefaultjp8hJ3c()));
        Heading = m7320constructorimpl(LineBreak_androidKt.access$packBytes(r100.m7347getBalancedfcGXIks(), r102.m7359getLooseusljTpc(), r104.m7371getPhrasejp8hJ3c()));
        Paragraph = m7320constructorimpl(LineBreak_androidKt.access$packBytes(r100.m7348getHighQualityfcGXIks(), r102.m7361getStrictusljTpc(), r104.m7370getDefaultjp8hJ3c()));
        Unspecified = m7320constructorimpl(0);
    }

    public String toString() {
        return m7330toStringimpl(this.mask);
    }

    public static final /* synthetic */ int access$getHeading$cp() {
        return Heading;
    }

    public static final /* synthetic */ int access$getParagraph$cp() {
        return Paragraph;
    }

    public static final /* synthetic */ int access$getSimple$cp() {
        return Simple;
    }

    public static final /* synthetic */ int access$getUnspecified$cp() {
        return Unspecified;
    }

    private /* synthetic */ LineBreak(int r100) {
        this.mask = r100;
    }

    /* JADX INFO: renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m7326getStrategyfcGXIks(int r100) {
        return Strategy.m7341constructorimpl(LineBreak_androidKt.access$unpackByte1(r100));
    }

    /* JADX INFO: renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m7327getStrictnessusljTpc(int r100) {
        return Strictness.m7352constructorimpl(LineBreak_androidKt.access$unpackByte2(r100));
    }

    /* JADX INFO: renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m7328getWordBreakjp8hJ3c(int r100) {
        return WordBreak.m7364constructorimpl(LineBreak_androidKt.access$unpackByte3(r100));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7330toStringimpl(int r100) {
        return "LineBreak(strategy=" + Strategy.m7345toStringimpl(m7326getStrategyfcGXIks(r100)) + ", strictness=" + Strictness.m7356toStringimpl(m7327getStrictnessusljTpc(r100)) + ", wordBreak=" + WordBreak.m7368toStringimpl(m7328getWordBreakjp8hJ3c(r100)) + ')';
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m7321constructorimpl(int r100, int r101, int r102) {
        return m7320constructorimpl(LineBreak_androidKt.access$packBytes(r100, r101, r102));
    }

    /* JADX INFO: renamed from: copy-gijOMQM, reason: not valid java name */
    public static final int m7322copygijOMQM(int r100, int r101, int r102, int r103) {
        return m7321constructorimpl(r101, r102, r103);
    }

    /* JADX INFO: renamed from: copy-gijOMQM$default, reason: not valid java name */
    public static /* synthetic */ int m7323copygijOMQM$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = m7326getStrategyfcGXIks(r100);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = m7327getStrictnessusljTpc(r100);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = m7328getWordBreakjp8hJ3c(r100);
    L12:
        return m7322copygijOMQM(r100, r101, r102, r103);
    }
}
