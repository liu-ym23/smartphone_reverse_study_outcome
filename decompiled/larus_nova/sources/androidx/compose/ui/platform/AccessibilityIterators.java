package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators;", "", "<init>", "()V", "TextSegmentIterator", "AbstractTextSegmentIterator", "CharacterTextSegmentIterator", "WordTextSegmentIterator", "ParagraphTextSegmentIterator", "LineTextSegmentIterator", "PageTextSegmentIterator", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AccessibilityIterators {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", MonitorConstants.SEGMENT, "", "initialize", "", "getRange", "start", "", "end", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        public static final int $stable = 8;
        private final int[] segment;
        protected String text;

        public final String getText() {
            String r100 = this.text;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("text");
            return null;
        }

        public AbstractTextSegmentIterator() {
            this.segment = new int[2];
        }

        public void initialize(String r100) {
            setText(r100);
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final int[] getRange(int r100, int r101) {
            if (r100 < 0) goto L8;
            if (r101 < 0) goto L10;
            if (r100 == r101) goto L11;
            int[] r102 = this.segment;
            r102[0] = r100;
            r102[1] = r101;
            return r102;
        L11:
            return null;
        L10:
            return null;
        L8:
            return null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "initialize", "", "text", "", "following", "", "current", "", "preceding", "onLocaleChanged", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private static CharacterTextSegmentIterator instance;
        private BreakIterator impl;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator$Companion;", "", "<init>", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final CharacterTextSegmentIterator getInstance(Locale r100) {
                if (CharacterTextSegmentIterator.access$getInstance$cp() != null) goto L5;
                CharacterTextSegmentIterator.access$setInstance$cp(new CharacterTextSegmentIterator(r100, null));
            L5:
                CharacterTextSegmentIterator r101 = CharacterTextSegmentIterator.access$getInstance$cp();
                Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                return r101;
            }
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
        }

        public /* synthetic */ CharacterTextSegmentIterator(Locale r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public static final /* synthetic */ CharacterTextSegmentIterator access$getInstance$cp() {
            return instance;
        }

        private CharacterTextSegmentIterator(Locale r100) {
            onLocaleChanged(r100);
        }

        public static final /* synthetic */ void access$setInstance$cp(CharacterTextSegmentIterator r100) {
            instance = r100;
        }

        private final void onLocaleChanged(Locale r100) {
            this.impl = BreakIterator.getCharacterInstance(r100);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int r100) {
            int r101 = getText().length();
            if (r101 > 0) goto L5;
            return null;
        L5:
            if (r100 < r101) goto L7;
            return null;
        L7:
            if (r100 >= 0) goto L9;
            r100 = 0;
        L9:
            BreakIterator r102 = this.impl;
            if (r102 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r102 = null;
        L13:
            if (r102.isBoundary(r100) == true) goto L20;
            BreakIterator r103 = this.impl;
            if (r103 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r103 = null;
        L17:
            r100 = r103.following(r100);
            if (r100 != (-1)) goto L9;
            return null;
        L20:
            BreakIterator r104 = this.impl;
            if (r104 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r104 = null;
        L23:
            int r105 = r104.following(r100);
            if (r105 != (-1)) goto L27;
            return null;
        L27:
            return getRange(r100, r105);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(String r100) {
            super.initialize(r100);
            BreakIterator r101 = this.impl;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r101 = null;
        L5:
            r101.setText(r100);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int r100) {
            int r101 = getText().length();
            if (r101 > 0) goto L5;
            return null;
        L5:
            if (r100 > 0) goto L7;
            return null;
        L7:
            if (r100 <= r101) goto L9;
            r100 = r101;
        L9:
            BreakIterator r102 = this.impl;
            if (r102 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r102 = null;
        L13:
            if (r102.isBoundary(r100) == true) goto L20;
            BreakIterator r103 = this.impl;
            if (r103 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r103 = null;
        L17:
            r100 = r103.preceding(r100);
            if (r100 != (-1)) goto L9;
            return null;
        L20:
            BreakIterator r104 = this.impl;
            if (r104 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r104 = null;
        L23:
            int r105 = r104.preceding(r100);
            if (r105 != (-1)) goto L27;
            return null;
        L27:
            return getRange(r105, r100);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "initialize", "", "text", "", "following", "", "current", "", "preceding", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LineTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private static final ResolvedTextDirection DirectionEnd = null;
        private static final ResolvedTextDirection DirectionStart = null;
        private static LineTextSegmentIterator lineInstance;
        private TextLayoutResult layoutResult;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator$Companion;", "", "<init>", "()V", "lineInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "DirectionStart", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionEnd", "getInstance", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final LineTextSegmentIterator getInstance() {
                if (LineTextSegmentIterator.access$getLineInstance$cp() != null) goto L5;
                LineTextSegmentIterator.access$setLineInstance$cp(new LineTextSegmentIterator(null));
            L5:
                LineTextSegmentIterator r100 = LineTextSegmentIterator.access$getLineInstance$cp();
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                return r100;
            }
        }

        public /* synthetic */ LineTextSegmentIterator(DefaultConstructorMarker r100) {
            this();
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
            DirectionStart = ResolvedTextDirection.Rtl;
            DirectionEnd = ResolvedTextDirection.Ltr;
        }

        private LineTextSegmentIterator() {
        }

        public static final /* synthetic */ LineTextSegmentIterator access$getLineInstance$cp() {
            return lineInstance;
        }

        public static final /* synthetic */ void access$setLineInstance$cp(LineTextSegmentIterator r100) {
            lineInstance = r100;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int r100) {
            if (getText().length() > 0) goto L6;
            return null;
        L6:
            if (r100 < getText().length()) goto L9;
            return null;
        L9:
            if (r100 >= 0) goto L14;
            TextLayoutResult r101 = this.layoutResult;
            if (r101 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r101 = null;
        L13:
            int r102 = r101.getLineForOffset(0);
        L21:
            TextLayoutResult r103 = this.layoutResult;
            if (r103 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r103 = null;
        L25:
            if (r102 < r103.getLineCount()) goto L28;
            return null;
        L28:
            return getRange(getLineEdgeIndex(r102, DirectionStart), getLineEdgeIndex(r102, DirectionEnd) + 1);
        L14:
            TextLayoutResult r104 = this.layoutResult;
            if (r104 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r104 = null;
        L17:
            int r105 = r104.getLineForOffset(r100);
            if (getLineEdgeIndex(r105, DirectionStart) != r100) goto L20;
            r102 = r105;
            goto L21
        L20:
            r102 = r105 + 1;
            goto L21
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int r100) {
            if (getText().length() > 0) goto L5;
            return null;
        L5:
            if (r100 > 0) goto L8;
            return null;
        L8:
            if (r100 <= getText().length()) goto L13;
            TextLayoutResult r101 = this.layoutResult;
            if (r101 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r101 = null;
        L12:
            int r102 = r101.getLineForOffset(getText().length());
        L20:
            if (r102 >= 0) goto L23;
            return null;
        L23:
            return getRange(getLineEdgeIndex(r102, DirectionStart), getLineEdgeIndex(r102, DirectionEnd) + 1);
        L13:
            TextLayoutResult r103 = this.layoutResult;
            if (r103 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r103 = null;
        L16:
            int r104 = r103.getLineForOffset(r100);
            if ((getLineEdgeIndex(r104, DirectionEnd) + 1) != r100) goto L19;
            r102 = r104;
            goto L20
        L19:
            r102 = r104 - 1;
            goto L20
        }

        private final int getLineEdgeIndex(int r100, ResolvedTextDirection r101) {
            TextLayoutResult r102 = this.layoutResult;
            TextLayoutResult r103 = null;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r102 = null;
        L5:
            int r104 = r102.getLineStart(r100);
            TextLayoutResult r105 = this.layoutResult;
            if (r105 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r105 = null;
        L9:
            if (r101 == r105.getParagraphDirection(r104)) goto L15;
            TextLayoutResult r106 = this.layoutResult;
            if (r106 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        L20:
            return r103.getLineStart(r100);
        L13:
            r103 = r106;
            goto L20
        L15:
            TextLayoutResult r107 = this.layoutResult;
            if (r107 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r107 = null;
        L19:
            return TextLayoutResult.getLineEnd$default(r107, r100, false, 2, null) - 1;
        }

        public final void initialize(String r100, TextLayoutResult r101) {
            setText(r100);
            this.layoutResult = r101;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "tempRect", "Landroid/graphics/Rect;", "initialize", "", "text", "", "following", "", "current", "", "preceding", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PageTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private static final ResolvedTextDirection DirectionEnd = null;
        private static final ResolvedTextDirection DirectionStart = null;
        private static PageTextSegmentIterator pageInstance;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;
        private Rect tempRect;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator$Companion;", "", "<init>", "()V", "pageInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "DirectionStart", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionEnd", "getInstance", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final PageTextSegmentIterator getInstance() {
                if (PageTextSegmentIterator.access$getPageInstance$cp() != null) goto L5;
                PageTextSegmentIterator.access$setPageInstance$cp(new PageTextSegmentIterator(null));
            L5:
                PageTextSegmentIterator r100 = PageTextSegmentIterator.access$getPageInstance$cp();
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                return r100;
            }
        }

        public /* synthetic */ PageTextSegmentIterator(DefaultConstructorMarker r100) {
            this();
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
            DirectionStart = ResolvedTextDirection.Rtl;
            DirectionEnd = ResolvedTextDirection.Ltr;
        }

        private PageTextSegmentIterator() {
            this.tempRect = new Rect();
        }

        public static final /* synthetic */ PageTextSegmentIterator access$getPageInstance$cp() {
            return pageInstance;
        }

        public static final /* synthetic */ void access$setPageInstance$cp(PageTextSegmentIterator r100) {
            pageInstance = r100;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int r100) {
            TextLayoutResult r101 = null;
            if (getText().length() > 0) goto L6;
            return null;
        L6:
            if (r100 < getText().length()) goto L39;
            return null;
        L39:
            SemanticsNode r102 = this.node;     // Catch: IllegalStateException -> L38
            if (r102 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("node");     // Catch: IllegalStateException -> L38
            r102 = null;
        L11:
            androidx.compose.ui.geometry.Rect r103 = r102.getBoundsInRoot();     // Catch: IllegalStateException -> L38
            int r104 = Math.round(r103.getBottom() - r103.getTop());     // Catch: IllegalStateException -> L38
            int r105 = RangesKt.coerceAtLeast(0, r100);
            TextLayoutResult r106 = this.layoutResult;
            if (r106 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r106 = null;
        L15:
            int r107 = r106.getLineForOffset(r105);
            TextLayoutResult r108 = this.layoutResult;
            if (r108 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r108 = null;
        L18:
            float r109 = r108.getLineTop(r107) + r104;
            TextLayoutResult r110 = this.layoutResult;
            if (r110 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r110 = null;
        L21:
            TextLayoutResult r111 = this.layoutResult;
            if (r111 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r111 = null;
        L25:
            if (r109 >= r110.getLineTop(r111.getLineCount() - 1)) goto L31;
            TextLayoutResult r112 = this.layoutResult;
            if (r112 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        L30:
            int r113 = r101.getLineForVerticalPosition(r109);
        L37:
            return getRange(r105, getLineEdgeIndex(r113 - 1, DirectionEnd) + 1);
        L29:
            r101 = r112;
            goto L30
        L31:
            TextLayoutResult r114 = this.layoutResult;
            if (r114 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        L35:
            r113 = r101.getLineCount();
            goto L37
        L34:
            r101 = r114;
        L38:
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int r100) {
            TextLayoutResult r101 = null;
            if (getText().length() > 0) goto L5;
            return null;
        L5:
            if (r100 > 0) goto L32;
            return null;
        L32:
            SemanticsNode r102 = this.node;     // Catch: IllegalStateException -> L31
            if (r102 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("node");     // Catch: IllegalStateException -> L31
            r102 = null;
        L10:
            androidx.compose.ui.geometry.Rect r103 = r102.getBoundsInRoot();     // Catch: IllegalStateException -> L31
            int r104 = Math.round(r103.getBottom() - r103.getTop());     // Catch: IllegalStateException -> L31
            int r105 = RangesKt.coerceAtMost(getText().length(), r100);
            TextLayoutResult r106 = this.layoutResult;
            if (r106 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r106 = null;
        L14:
            int r107 = r106.getLineForOffset(r105);
            TextLayoutResult r108 = this.layoutResult;
            if (r108 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r108 = null;
        L17:
            float r109 = r108.getLineTop(r107) - r104;
            if (r109 <= 0.0f) goto L24;
            TextLayoutResult r110 = this.layoutResult;
            if (r110 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        L23:
            int r111 = r101.getLineForVerticalPosition(r109);
        L26:
            if (r105 != getText().length()) goto L30;
            if (r111 >= r107) goto L30;
            r111 = r111 + 1;
        L30:
            return getRange(getLineEdgeIndex(r111, DirectionStart), r105);
        L22:
            r101 = r110;
            goto L23
        L24:
            r111 = 0;
        L31:
            return null;
        }

        private final int getLineEdgeIndex(int r100, ResolvedTextDirection r101) {
            TextLayoutResult r102 = this.layoutResult;
            TextLayoutResult r103 = null;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r102 = null;
        L5:
            int r104 = r102.getLineStart(r100);
            TextLayoutResult r105 = this.layoutResult;
            if (r105 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r105 = null;
        L9:
            if (r101 == r105.getParagraphDirection(r104)) goto L15;
            TextLayoutResult r106 = this.layoutResult;
            if (r106 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        L20:
            return r103.getLineStart(r100);
        L13:
            r103 = r106;
            goto L20
        L15:
            TextLayoutResult r107 = this.layoutResult;
            if (r107 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            r107 = null;
        L19:
            return TextLayoutResult.getLineEnd$default(r107, r100, false, 2, null) - 1;
        }

        public final void initialize(String r100, TextLayoutResult r101, SemanticsNode r102) {
            setText(r100);
            this.layoutResult = r101;
            this.node = r102;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", "following", "", "current", "", "preceding", "isStartBoundary", "", "index", "isEndBoundary", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private static ParagraphTextSegmentIterator instance;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator$Companion;", "", "<init>", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final ParagraphTextSegmentIterator getInstance() {
                if (ParagraphTextSegmentIterator.access$getInstance$cp() != null) goto L5;
                ParagraphTextSegmentIterator.access$setInstance$cp(new ParagraphTextSegmentIterator(null));
            L5:
                ParagraphTextSegmentIterator r100 = ParagraphTextSegmentIterator.access$getInstance$cp();
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                return r100;
            }
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
        }

        public /* synthetic */ ParagraphTextSegmentIterator(DefaultConstructorMarker r100) {
            this();
        }

        private ParagraphTextSegmentIterator() {
        }

        public static final /* synthetic */ ParagraphTextSegmentIterator access$getInstance$cp() {
            return instance;
        }

        public static final /* synthetic */ void access$setInstance$cp(ParagraphTextSegmentIterator r100) {
            instance = r100;
        }

        private final boolean isEndBoundary(int r100) {
            if (r100 > 0) goto L4;
        L10:
            return false;
        L4:
            if (getText().charAt(r100 - 1) == '\n') goto L10;
            if (r100 != getText().length()) goto L8;
        L9:
            return true;
        L8:
            if (getText().charAt(r100) != '\n') goto L10;
            goto L9
        }

        private final boolean isStartBoundary(int r100) {
            if (getText().charAt(r100) != '\n') goto L5;
        L9:
            return false;
        L5:
            if (r100 != 0) goto L7;
            return true;
        L7:
            if (getText().charAt(r100 - 1) != '\n') goto L9;
            return true;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int r100) {
            int r101 = getText().length();
            if (r101 > 0) goto L5;
            return null;
        L5:
            if (r100 < r101) goto L7;
            return null;
        L7:
            if (r100 >= 0) goto L9;
            r100 = 0;
        L9:
            if (r100 >= r101) goto L15;
            if (getText().charAt(r100) != '\n') goto L15;
            if (isStartBoundary(r100) == true) goto L15;
            r100 = r100 + 1;
        L15:
            if (r100 < r101) goto L17;
            return null;
        L17:
            int r102 = r100 + 1;
        L18:
            if (r102 >= r101) goto L23;
            if (isEndBoundary(r102) == true) goto L23;
            r102 = r102 + 1;
        L23:
            return getRange(r100, r102);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int r100) {
            int r101 = getText().length();
            if (r101 > 0) goto L5;
            return null;
        L5:
            if (r100 > 0) goto L7;
            return null;
        L7:
            if (r100 <= r101) goto L9;
            r100 = r101;
        L9:
            if (r100 <= 0) goto L15;
            if (getText().charAt(r100 - 1) != '\n') goto L15;
            if (isEndBoundary(r100) == true) goto L15;
            r100 = r100 - 1;
        L15:
            if (r100 > 0) goto L17;
            return null;
        L17:
            int r102 = r100 - 1;
        L18:
            if (r102 <= 0) goto L23;
            if (isStartBoundary(r102) == true) goto L23;
            r102 = r102 - 1;
        L23:
            return getRange(r102, r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "following", "", "current", "", "preceding", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface TextSegmentIterator {
        int[] following(int r100);

        int[] preceding(int r100);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "initialize", "", "text", "", "onLocaleChanged", "following", "", "current", "", "preceding", "isStartBoundary", "", "index", "isEndBoundary", "isLetterOrDigit", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WordTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private static WordTextSegmentIterator instance;
        private BreakIterator impl;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator$Companion;", "", "<init>", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final WordTextSegmentIterator getInstance(Locale r100) {
                if (WordTextSegmentIterator.access$getInstance$cp() != null) goto L5;
                WordTextSegmentIterator.access$setInstance$cp(new WordTextSegmentIterator(r100, null));
            L5:
                WordTextSegmentIterator r101 = WordTextSegmentIterator.access$getInstance$cp();
                Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                return r101;
            }
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
        }

        public /* synthetic */ WordTextSegmentIterator(Locale r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public static final /* synthetic */ WordTextSegmentIterator access$getInstance$cp() {
            return instance;
        }

        private WordTextSegmentIterator(Locale r100) {
            onLocaleChanged(r100);
        }

        public static final /* synthetic */ void access$setInstance$cp(WordTextSegmentIterator r100) {
            instance = r100;
        }

        private final boolean isEndBoundary(int r100) {
            if (r100 > 0) goto L4;
        L10:
            return false;
        L4:
            if (isLetterOrDigit(r100 - 1) == false) goto L10;
            if (r100 != getText().length()) goto L8;
        L9:
            return true;
        L8:
            if (isLetterOrDigit(r100) == true) goto L10;
            goto L9
        }

        private final boolean isLetterOrDigit(int r100) {
            if (r100 >= 0) goto L4;
            return false;
        L4:
            if (r100 < getText().length()) goto L6;
            return false;
        L6:
            return Character.isLetterOrDigit(getText().codePointAt(r100));
        }

        private final boolean isStartBoundary(int r100) {
            if (isLetterOrDigit(r100) == true) goto L5;
        L9:
            return false;
        L5:
            if (r100 != 0) goto L7;
            return true;
        L7:
            if (isLetterOrDigit(r100 - 1) == true) goto L9;
            return true;
        }

        private final void onLocaleChanged(Locale r100) {
            this.impl = BreakIterator.getWordInstance(r100);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int r100) {
            if (getText().length() > 0) goto L6;
            return null;
        L6:
            if (r100 < getText().length()) goto L8;
            return null;
        L8:
            if (r100 >= 0) goto L11;
            r100 = 0;
        L11:
            if (isLetterOrDigit(r100) == true) goto L20;
            if (isStartBoundary(r100) == true) goto L20;
            BreakIterator r101 = this.impl;
            if (r101 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r101 = null;
        L17:
            r100 = r101.following(r100);
            if (r100 != (-1)) goto L11;
            return null;
        L20:
            BreakIterator r102 = this.impl;
            if (r102 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r102 = null;
        L23:
            int r103 = r102.following(r100);
            if (r103 != (-1)) goto L26;
        L30:
            return null;
        L26:
            if (isEndBoundary(r103) == false) goto L30;
            return getRange(r100, r103);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(String r100) {
            super.initialize(r100);
            BreakIterator r101 = this.impl;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r101 = null;
        L5:
            r101.setText(r100);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int r100) {
            int r101 = getText().length();
            if (r101 > 0) goto L5;
            return null;
        L5:
            if (r100 > 0) goto L7;
            return null;
        L7:
            if (r100 <= r101) goto L10;
            r100 = r101;
        L10:
            if (r100 <= 0) goto L21;
            if (isLetterOrDigit(r100 - 1) == true) goto L21;
            if (isEndBoundary(r100) == true) goto L21;
            BreakIterator r102 = this.impl;
            if (r102 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r102 = null;
        L18:
            r100 = r102.preceding(r100);
            if (r100 != (-1)) goto L10;
            return null;
        L21:
            BreakIterator r103 = this.impl;
            if (r103 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            r103 = null;
        L24:
            int r104 = r103.preceding(r100);
            if (r104 != (-1)) goto L27;
        L31:
            return null;
        L27:
            if (isStartBoundary(r104) == false) goto L31;
            return getRange(r104, r100);
        }
    }

    public AccessibilityIterators() {
    }
}
