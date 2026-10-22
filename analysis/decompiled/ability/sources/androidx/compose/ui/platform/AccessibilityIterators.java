package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import io.modelcontextprotocol.spec.McpSchema;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators;", "", AppAgent.CONSTRUCT, "()V", "TextSegmentIterator", "AbstractTextSegmentIterator", "CharacterTextSegmentIterator", "WordTextSegmentIterator", "ParagraphTextSegmentIterator", "LineTextSegmentIterator", "PageTextSegmentIterator", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AccessibilityIterators {
    public static final int $stable = 0;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0004¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u00020\u00048\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", AppAgent.CONSTRUCT, "()V", "", "text", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Ljava/lang/String;)V", "", "start", "end", "", "getRange", "(II)[I", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", RequestInfo.FUNCTION_SET_TEXT, "segment", "[I", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        public static final int $stable = 8;
        private final int[] segment = new int[2];
        protected String text;

        public final int[] getRange(int start, int end) {
            if (start < 0 || end < 0 || start == end) {
                return null;
            }
            int[] iArr = this.segment;
            iArr[0] = start;
            iArr[1] = end;
            return iArr;
        }

        public final String getText() {
            String str = this.text;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.k.n("text");
            throw null;
        }

        public void initialize(String text) {
            setText(text);
        }

        public final void setText(String str) {
            this.text = str;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Ljava/util/Locale;", "locale", AppAgent.CONSTRUCT, "(Ljava/util/Locale;)V", "LC7/r;", "onLocaleChanged", "", "text", McpSchema.METHOD_INITIALIZE, "(Ljava/lang/String;)V", "", "current", "", "following", "(I)[I", "preceding", "Ljava/text/BreakIterator;", "impl", "Ljava/text/BreakIterator;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {
        private static CharacterTextSegmentIterator instance;
        private BreakIterator impl;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator$Companion;", "", AppAgent.CONSTRUCT, "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final CharacterTextSegmentIterator getInstance(Locale locale) {
                if (CharacterTextSegmentIterator.instance == null) {
                    CharacterTextSegmentIterator.instance = new CharacterTextSegmentIterator(locale, null);
                }
                CharacterTextSegmentIterator characterTextSegmentIterator = CharacterTextSegmentIterator.instance;
                kotlin.jvm.internal.k.d(characterTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                return characterTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ CharacterTextSegmentIterator(Locale locale, kotlin.jvm.internal.e eVar) {
            this(locale);
        }

        private final void onLocaleChanged(Locale locale) {
            this.impl = BreakIterator.getCharacterInstance(locale);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int current) {
            int length = getText().length();
            if (length <= 0 || current >= length) {
                return null;
            }
            if (current < 0) {
                current = 0;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.k.n("impl");
                    throw null;
                }
                if (breakIterator.isBoundary(current)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        kotlin.jvm.internal.k.n("impl");
                        throw null;
                    }
                    int iFollowing = breakIterator2.following(current);
                    if (iFollowing == -1) {
                        return null;
                    }
                    return getRange(current, iFollowing);
                }
                BreakIterator breakIterator3 = this.impl;
                if (breakIterator3 == null) {
                    kotlin.jvm.internal.k.n("impl");
                    throw null;
                }
                current = breakIterator3.following(current);
            } while (current != -1);
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(String text) {
            super.initialize(text);
            BreakIterator breakIterator = this.impl;
            if (breakIterator != null) {
                breakIterator.setText(text);
            } else {
                kotlin.jvm.internal.k.n("impl");
                throw null;
            }
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int current) {
            int length = getText().length();
            if (length <= 0 || current <= 0) {
                return null;
            }
            if (current > length) {
                current = length;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.k.n("impl");
                    throw null;
                }
                if (breakIterator.isBoundary(current)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        kotlin.jvm.internal.k.n("impl");
                        throw null;
                    }
                    int iPreceding = breakIterator2.preceding(current);
                    if (iPreceding == -1) {
                        return null;
                    }
                    return getRange(iPreceding, current);
                }
                BreakIterator breakIterator3 = this.impl;
                if (breakIterator3 == null) {
                    kotlin.jvm.internal.k.n("impl");
                    throw null;
                }
                current = breakIterator3.preceding(current);
            } while (current != -1);
            return null;
        }

        private CharacterTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", AppAgent.CONSTRUCT, "()V", "", "lineNumber", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "direction", "getLineEdgeIndex", "(ILandroidx/compose/ui/text/style/ResolvedTextDirection;)I", "", "text", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Ljava/lang/String;Landroidx/compose/ui/text/TextLayoutResult;)V", "current", "", "following", "(I)[I", "preceding", "Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LineTextSegmentIterator extends AbstractTextSegmentIterator {
        private static LineTextSegmentIterator lineInstance;
        private TextLayoutResult layoutResult;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator$Companion;", "", AppAgent.CONSTRUCT, "()V", "lineInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "DirectionStart", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionEnd", "getInstance", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final LineTextSegmentIterator getInstance() {
                if (LineTextSegmentIterator.lineInstance == null) {
                    LineTextSegmentIterator.lineInstance = new LineTextSegmentIterator(null);
                }
                LineTextSegmentIterator lineTextSegmentIterator = LineTextSegmentIterator.lineInstance;
                kotlin.jvm.internal.k.d(lineTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                return lineTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ LineTextSegmentIterator(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final int getLineEdgeIndex(int lineNumber, ResolvedTextDirection direction) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            if (textLayoutResult == null) {
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            int lineStart = textLayoutResult.getLineStart(lineNumber);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 == null) {
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            if (direction != textLayoutResult2.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 != null) {
                    return textLayoutResult3.getLineStart(lineNumber);
                }
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            if (this.layoutResult != null) {
                return TextLayoutResult.getLineEnd$default(r4, lineNumber, false, 2, null) - 1;
            }
            kotlin.jvm.internal.k.n("layoutResult");
            throw null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int current) {
            int lineForOffset;
            if (getText().length() <= 0 || current >= getText().length()) {
                return null;
            }
            if (current < 0) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                lineForOffset = textLayoutResult.getLineForOffset(0);
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                int lineForOffset2 = textLayoutResult2.getLineForOffset(current);
                lineForOffset = getLineEdgeIndex(lineForOffset2, DirectionStart) == current ? lineForOffset2 : lineForOffset2 + 1;
            }
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            if (lineForOffset >= textLayoutResult3.getLineCount()) {
                return null;
            }
            return getRange(getLineEdgeIndex(lineForOffset, DirectionStart), getLineEdgeIndex(lineForOffset, DirectionEnd) + 1);
        }

        public final void initialize(String text, TextLayoutResult layoutResult) {
            setText(text);
            this.layoutResult = layoutResult;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int current) {
            int lineForOffset;
            if (getText().length() <= 0 || current <= 0) {
                return null;
            }
            if (current > getText().length()) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                lineForOffset = textLayoutResult.getLineForOffset(getText().length());
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                int lineForOffset2 = textLayoutResult2.getLineForOffset(current);
                lineForOffset = getLineEdgeIndex(lineForOffset2, DirectionEnd) + 1 == current ? lineForOffset2 : lineForOffset2 - 1;
            }
            if (lineForOffset < 0) {
                return null;
            }
            return getRange(getLineEdgeIndex(lineForOffset, DirectionStart), getLineEdgeIndex(lineForOffset, DirectionEnd) + 1);
        }

        private LineTextSegmentIterator() {
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", AppAgent.CONSTRUCT, "()V", "", "lineNumber", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "direction", "getLineEdgeIndex", "(ILandroidx/compose/ui/text/style/ResolvedTextDirection;)I", "", "text", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "Landroidx/compose/ui/semantics/SemanticsNode;", "node", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Ljava/lang/String;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/semantics/SemanticsNode;)V", "current", "", "following", "(I)[I", "preceding", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroid/graphics/Rect;", "tempRect", "Landroid/graphics/Rect;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PageTextSegmentIterator extends AbstractTextSegmentIterator {
        private static PageTextSegmentIterator pageInstance;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;
        private Rect tempRect;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator$Companion;", "", AppAgent.CONSTRUCT, "()V", "pageInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "DirectionStart", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionEnd", "getInstance", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final PageTextSegmentIterator getInstance() {
                if (PageTextSegmentIterator.pageInstance == null) {
                    PageTextSegmentIterator.pageInstance = new PageTextSegmentIterator(null);
                }
                PageTextSegmentIterator pageTextSegmentIterator = PageTextSegmentIterator.pageInstance;
                kotlin.jvm.internal.k.d(pageTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                return pageTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ PageTextSegmentIterator(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final int getLineEdgeIndex(int lineNumber, ResolvedTextDirection direction) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            if (textLayoutResult == null) {
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            int lineStart = textLayoutResult.getLineStart(lineNumber);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 == null) {
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            if (direction != textLayoutResult2.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 != null) {
                    return textLayoutResult3.getLineStart(lineNumber);
                }
                kotlin.jvm.internal.k.n("layoutResult");
                throw null;
            }
            if (this.layoutResult != null) {
                return TextLayoutResult.getLineEnd$default(r4, lineNumber, false, 2, null) - 1;
            }
            kotlin.jvm.internal.k.n("layoutResult");
            throw null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int current) {
            int lineCount;
            if (getText().length() <= 0 || current >= getText().length()) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    kotlin.jvm.internal.k.n("node");
                    throw null;
                }
                androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                int iRound = Math.round(boundsInRoot.getBottom() - boundsInRoot.getTop());
                if (current <= 0) {
                    current = 0;
                }
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                int lineForOffset = textLayoutResult.getLineForOffset(current);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                float lineTop = textLayoutResult2.getLineTop(lineForOffset) + iRound;
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                if (textLayoutResult3 == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                if (lineTop < textLayoutResult3.getLineTop(textLayoutResult3.getLineCount() - 1)) {
                    TextLayoutResult textLayoutResult4 = this.layoutResult;
                    if (textLayoutResult4 == null) {
                        kotlin.jvm.internal.k.n("layoutResult");
                        throw null;
                    }
                    lineCount = textLayoutResult4.getLineForVerticalPosition(lineTop);
                } else {
                    TextLayoutResult textLayoutResult5 = this.layoutResult;
                    if (textLayoutResult5 == null) {
                        kotlin.jvm.internal.k.n("layoutResult");
                        throw null;
                    }
                    lineCount = textLayoutResult5.getLineCount();
                }
                return getRange(current, getLineEdgeIndex(lineCount - 1, DirectionEnd) + 1);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        public final void initialize(String text, TextLayoutResult layoutResult, SemanticsNode node) {
            setText(text);
            this.layoutResult = layoutResult;
            this.node = node;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int current) {
            int lineForVerticalPosition;
            if (getText().length() <= 0 || current <= 0) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    kotlin.jvm.internal.k.n("node");
                    throw null;
                }
                androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                int iRound = Math.round(boundsInRoot.getBottom() - boundsInRoot.getTop());
                int length = getText().length();
                if (length <= current) {
                    current = length;
                }
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                int lineForOffset = textLayoutResult.getLineForOffset(current);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.k.n("layoutResult");
                    throw null;
                }
                float lineTop = textLayoutResult2.getLineTop(lineForOffset) - iRound;
                if (lineTop > 0.0f) {
                    TextLayoutResult textLayoutResult3 = this.layoutResult;
                    if (textLayoutResult3 == null) {
                        kotlin.jvm.internal.k.n("layoutResult");
                        throw null;
                    }
                    lineForVerticalPosition = textLayoutResult3.getLineForVerticalPosition(lineTop);
                } else {
                    lineForVerticalPosition = 0;
                }
                if (current == getText().length() && lineForVerticalPosition < lineForOffset) {
                    lineForVerticalPosition++;
                }
                return getRange(getLineEdgeIndex(lineForVerticalPosition, DirectionStart), current);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        private PageTextSegmentIterator() {
            this.tempRect = new Rect();
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", AppAgent.CONSTRUCT, "()V", "following", "", "current", "", "preceding", "isStartBoundary", "", "index", "isEndBoundary", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        private static ParagraphTextSegmentIterator instance;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator$Companion;", "", AppAgent.CONSTRUCT, "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final ParagraphTextSegmentIterator getInstance() {
                if (ParagraphTextSegmentIterator.instance == null) {
                    ParagraphTextSegmentIterator.instance = new ParagraphTextSegmentIterator(null);
                }
                ParagraphTextSegmentIterator paragraphTextSegmentIterator = ParagraphTextSegmentIterator.instance;
                kotlin.jvm.internal.k.d(paragraphTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                return paragraphTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ ParagraphTextSegmentIterator(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final boolean isEndBoundary(int index) {
            if (index <= 0 || getText().charAt(index - 1) == '\n') {
                return false;
            }
            return index == getText().length() || getText().charAt(index) == '\n';
        }

        private final boolean isStartBoundary(int index) {
            if (getText().charAt(index) != '\n') {
                return index == 0 || getText().charAt(index - 1) == '\n';
            }
            return false;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int current) {
            int length = getText().length();
            if (length <= 0 || current >= length) {
                return null;
            }
            if (current < 0) {
                current = 0;
            }
            while (current < length && getText().charAt(current) == '\n' && !isStartBoundary(current)) {
                current++;
            }
            if (current >= length) {
                return null;
            }
            int i = current + 1;
            while (i < length && !isEndBoundary(i)) {
                i++;
            }
            return getRange(current, i);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int current) {
            int length = getText().length();
            if (length <= 0 || current <= 0) {
                return null;
            }
            if (current > length) {
                current = length;
            }
            while (current > 0 && getText().charAt(current - 1) == '\n' && !isEndBoundary(current)) {
                current--;
            }
            if (current <= 0) {
                return null;
            }
            int i = current - 1;
            while (i > 0 && !isStartBoundary(i)) {
                i--;
            }
            return getRange(i, current);
        }

        private ParagraphTextSegmentIterator() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "following", "", "current", "", "preceding", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface TextSegmentIterator {
        int[] following(int current);

        int[] preceding(int current);
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Ljava/util/Locale;", "locale", AppAgent.CONSTRUCT, "(Ljava/util/Locale;)V", "LC7/r;", "onLocaleChanged", "", "index", "", "isStartBoundary", "(I)Z", "isEndBoundary", "isLetterOrDigit", "", "text", McpSchema.METHOD_INITIALIZE, "(Ljava/lang/String;)V", "current", "", "following", "(I)[I", "preceding", "Ljava/text/BreakIterator;", "impl", "Ljava/text/BreakIterator;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WordTextSegmentIterator extends AbstractTextSegmentIterator {
        private static WordTextSegmentIterator instance;
        private BreakIterator impl;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator$Companion;", "", AppAgent.CONSTRUCT, "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
                this();
            }

            public final WordTextSegmentIterator getInstance(Locale locale) {
                if (WordTextSegmentIterator.instance == null) {
                    WordTextSegmentIterator.instance = new WordTextSegmentIterator(locale, null);
                }
                WordTextSegmentIterator wordTextSegmentIterator = WordTextSegmentIterator.instance;
                kotlin.jvm.internal.k.d(wordTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                return wordTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ WordTextSegmentIterator(Locale locale, kotlin.jvm.internal.e eVar) {
            this(locale);
        }

        private final boolean isEndBoundary(int index) {
            if (index <= 0 || !isLetterOrDigit(index - 1)) {
                return false;
            }
            return index == getText().length() || !isLetterOrDigit(index);
        }

        private final boolean isLetterOrDigit(int index) {
            if (index < 0 || index >= getText().length()) {
                return false;
            }
            return Character.isLetterOrDigit(getText().codePointAt(index));
        }

        private final boolean isStartBoundary(int index) {
            if (isLetterOrDigit(index)) {
                return index == 0 || !isLetterOrDigit(index - 1);
            }
            return false;
        }

        private final void onLocaleChanged(Locale locale) {
            this.impl = BreakIterator.getWordInstance(locale);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] following(int current) {
            if (getText().length() <= 0 || current >= getText().length()) {
                return null;
            }
            if (current < 0) {
                current = 0;
            }
            while (!isLetterOrDigit(current) && !isStartBoundary(current)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.k.n("impl");
                    throw null;
                }
                current = breakIterator.following(current);
                if (current == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                kotlin.jvm.internal.k.n("impl");
                throw null;
            }
            int iFollowing = breakIterator2.following(current);
            if (iFollowing == -1 || !isEndBoundary(iFollowing)) {
                return null;
            }
            return getRange(current, iFollowing);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(String text) {
            super.initialize(text);
            BreakIterator breakIterator = this.impl;
            if (breakIterator != null) {
                breakIterator.setText(text);
            } else {
                kotlin.jvm.internal.k.n("impl");
                throw null;
            }
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int current) {
            int length = getText().length();
            if (length <= 0 || current <= 0) {
                return null;
            }
            if (current > length) {
                current = length;
            }
            while (current > 0 && !isLetterOrDigit(current - 1) && !isEndBoundary(current)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.k.n("impl");
                    throw null;
                }
                current = breakIterator.preceding(current);
                if (current == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                kotlin.jvm.internal.k.n("impl");
                throw null;
            }
            int iPreceding = breakIterator2.preceding(current);
            if (iPreceding == -1 || !isStartBoundary(iPreceding)) {
                return null;
            }
            return getRange(iPreceding, current);
        }

        private WordTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }
    }
}
