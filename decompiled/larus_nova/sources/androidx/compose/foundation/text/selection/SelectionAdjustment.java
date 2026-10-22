package androidx.compose.foundation.text.selection;

import com.larksuite.component.card.protocol.data.person.Character;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SelectionAdjustment {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getNone", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", Character.TAG, "getCharacter", "Word", "getWord", "Paragraph", "getParagraph", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final SelectionAdjustment Character = null;
        private static final SelectionAdjustment CharacterWithWordAccelerate = null;
        private static final SelectionAdjustment None = null;
        private static final SelectionAdjustment Paragraph = null;
        private static final SelectionAdjustment Word = null;

        private Companion() {
        }

        public static /* synthetic */ Selection a(SelectionLayout r100) {
            return Character$lambda$1(r100);
        }

        public static /* synthetic */ Selection b(SelectionLayout r100) {
            return Paragraph$lambda$3(r100);
        }

        public static /* synthetic */ Selection c(SelectionLayout r100) {
            return None$lambda$0(r100);
        }

        public static /* synthetic */ Selection d(SelectionLayout r100) {
            return CharacterWithWordAccelerate$lambda$4(r100);
        }

        public static /* synthetic */ Selection e(SelectionLayout r100) {
            return Word$lambda$2(r100);
        }

        static {
            $$INSTANCE = new Companion();
            None = new l();
            Character = new m();
            Word = new n();
            Paragraph = new o();
            CharacterWithWordAccelerate = new p();
        }

        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        public final SelectionAdjustment getNone() {
            return None;
        }

        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        public final SelectionAdjustment getWord() {
            return Word;
        }

        private static final Selection Character$lambda$1(SelectionLayout r100) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(None.adjust(r100), r100);
        }

        private static final Selection CharacterWithWordAccelerate$lambda$4(SelectionLayout r100) {
            Selection r101 = r100.getPreviousSelection();
            if (r101 != null) goto L7;
            return Word.adjust(r100);
        L7:
            if (r100.isStartHandle() == false) goto L9;
            Selection.AnchorInfo r102 = r101.getStart();
            Selection.AnchorInfo r103 = SelectionAdjustmentKt.access$updateSelectionBoundary(r100, r100.getStartInfo(), r102);
            Selection.AnchorInfo r104 = r101.getEnd();
            Selection.AnchorInfo r105 = r103;
        L11:
            if (Intrinsics.areEqual(r103, r102) == false) goto L14;
            return r101;
        L14:
            if (r100.getCrossStatus() != CrossStatus.CROSSED) goto L16;
        L21:
            boolean r106 = true;
        L23:
            return SelectionAdjustmentKt.ensureAtLeastOneChar(new Selection(r105, r104, r106), r100);
        L16:
            if (r100.getCrossStatus() == CrossStatus.COLLAPSED) goto L18;
        L20:
            r106 = false;
            goto L23
        L18:
            if (r105.getOffset() <= r104.getOffset()) goto L20;
        L9:
            r102 = r101.getEnd();
            r103 = SelectionAdjustmentKt.access$updateSelectionBoundary(r100, r100.getEndInfo(), r102);
            r105 = r101.getStart();
            r104 = r103;
            goto L11
        }

        private static final Selection None$lambda$0(SelectionLayout r100) {
            Selection.AnchorInfo r101 = r100.getStartInfo().anchorForOffset(r100.getStartInfo().getRawStartHandleOffset());
            Selection.AnchorInfo r102 = r100.getEndInfo().anchorForOffset(r100.getEndInfo().getRawEndHandleOffset());
            if (r100.getCrossStatus() != CrossStatus.CROSSED) goto L5;
            boolean r103 = true;
        L7:
            return new Selection(r101, r102, r103);
        L5:
            r103 = false;
            goto L7
        }

        private static final Selection Paragraph$lambda$3(SelectionLayout r100) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(r100, SelectionAdjustment$Companion$Paragraph$1$1.INSTANCE);
        }

        private static final Selection Word$lambda$2(SelectionLayout r100) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(r100, SelectionAdjustment$Companion$Word$1$1.INSTANCE);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Selection adjust(SelectionLayout r100);
}
