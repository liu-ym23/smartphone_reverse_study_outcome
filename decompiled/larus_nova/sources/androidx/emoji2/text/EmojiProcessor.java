package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    /* JADX INFO: loaded from: classes17.dex */
    public static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        public static int findIndexBackward(CharSequence r100, int r101, int r102) {
            int r103 = r100.length();
            if (r101 < 0) goto L30;
            if (r103 < r101) goto L30;
            if (r102 >= 0) goto L9;
            return -1;
        L9:
            boolean r104 = false;
        L10:
            if (r102 == 0) goto L11;
            r101 = r101 - 1;
            if (r101 < 0) goto L14;
            char r105 = r100.charAt(r101);
            if (r104 == true) goto L20;
            if (Character.isSurrogate(r105) == false) goto L25;
            if (Character.isHighSurrogate(r105) == true) goto L28;
            r104 = true;
            goto L10
        L28:
            return -1;
        L25:
            r102 = r102 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r105) == false) goto L21;
            r102 = r102 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r104 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r101;
        L30:
            return -1;
        }

        public static int findIndexForward(CharSequence r100, int r101, int r102) {
            int r103 = r100.length();
            if (r101 < 0) goto L29;
            if (r103 < r101) goto L29;
            if (r102 >= 0) goto L9;
            return -1;
        L9:
            boolean r104 = false;
        L10:
            if (r102 == 0) goto L11;
            if (r101 >= r103) goto L13;
            char r105 = r100.charAt(r101);
            if (r104 == true) goto L19;
            if (Character.isSurrogate(r105) == false) goto L24;
            if (Character.isLowSurrogate(r105) == true) goto L27;
            r101 = r101 + 1;
            r104 = true;
            goto L10
        L27:
            return -1;
        L24:
            r102 = r102 - 1;
            r101 = r101 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r105) == false) goto L20;
            r102 = r102 - 1;
            r101 = r101 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r104 == false) goto L15;
            return -1;
        L15:
            return r103;
        L11:
            return r101;
        L29:
            return -1;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
        private final EmojiCompat.SpanFactory mSpanFactory;
        public UnprecomputeTextOnModificationSpannable spannable;

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public /* bridge */ /* synthetic */ UnprecomputeTextOnModificationSpannable getResult() {
            return getResult();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }

        public EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable r100, EmojiCompat.SpanFactory r101) {
            this.spannable = r100;
            this.mSpanFactory = r101;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence r100, int r101, int r102, TypefaceEmojiRasterizer r103) {
            if (r103.isPreferredSystemRender() == false) goto L6;
            return true;
        L6:
            if (this.spannable == null) goto L8;
        L12:
            EmojiSpan r104 = this.mSpanFactory.createSpan(r103);
            this.spannable.setSpan(r104, r101, r102, 33);
            return true;
        L8:
            if ((r100 instanceof Spannable) == false) goto L10;
            Spannable r105 = (Spannable) r100;
        L11:
            this.spannable = new UnprecomputeTextOnModificationSpannable(r105);
            goto L12
        L10:
            r105 = new SpannableString(r100);
            goto L11
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface EmojiProcessCallback<T> {
        T getResult();

        boolean handleEmoji(CharSequence r100, int r101, int r102, TypefaceEmojiRasterizer r103);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {
        public int end;
        private final int mOffset;
        public int start;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public EmojiProcessLookupCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public /* bridge */ /* synthetic */ EmojiProcessLookupCallback getResult() {
            return getResult();
        }

        public EmojiProcessLookupCallback(int r100) {
            this.start = -1;
            this.end = -1;
            this.mOffset = r100;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence r100, int r101, int r102, TypefaceEmojiRasterizer r103) {
            int r104 = this.mOffset;
            if (r101 > r104) goto L7;
            if (r104 >= r102) goto L7;
            this.start = r101;
            this.end = r102;
            return false;
        L7:
            if (r102 > r104) goto L10;
            return true;
        L10:
            return false;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {
        private final String mExclusion;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public MarkExclusionCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public /* bridge */ /* synthetic */ MarkExclusionCallback getResult() {
            return getResult();
        }

        public MarkExclusionCallback(String r100) {
            this.mExclusion = r100;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence r100, int r101, int r102, TypefaceEmojiRasterizer r103) {
            if (TextUtils.equals(r100.subSequence(r101, r102), this.mExclusion) == false) goto L6;
            r103.setExclusion(true);
            return false;
        L6:
            return true;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState;
        private final boolean mUseEmojiAsDefaultStyle;

        private static boolean isEmojiStyle(int r100) {
            if (r100 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTextStyle(int r100) {
            if (r100 != 65038) goto L5;
            return true;
        L5:
            return false;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() == false) goto L6;
            return true;
        L6:
            if (isEmojiStyle(this.mLastCodepoint) == false) goto L9;
            return true;
        L9:
            if (this.mUseEmojiAsDefaultStyle == true) goto L11;
        L16:
            return false;
        L11:
            if (this.mEmojiAsDefaultStyleExceptions != null) goto L13;
            return true;
        L13:
            int r100 = this.mCurrentNode.getData().getCodepointAt(0);
            if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, r100) >= 0) goto L16;
            return true;
        }

        public TypefaceEmojiRasterizer getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        public TypefaceEmojiRasterizer getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        public boolean isInFlushableState() {
            if (this.mState == 2) goto L5;
        L11:
            return false;
        L5:
            if (this.mCurrentNode.getData() == null) goto L11;
            if (this.mCurrentDepth <= 1) goto L9;
            return true;
        L9:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L11;
            return true;
        }

        public int check(int r100) {
            MetadataRepo.Node r101 = this.mCurrentNode.get(r100);
            int r102 = 2;
            if (this.mState == 2) goto L7;
            if (r101 != null) goto L6;
            r102 = reset();
        L25:
            this.mLastCodepoint = r100;
            return r102;
        L6:
            this.mState = 2;
            this.mCurrentNode = r101;
            this.mCurrentDepth = 1;
            goto L25
        L7:
            if (r101 == null) goto L10;
            this.mCurrentNode = r101;
            this.mCurrentDepth++;
            goto L25
        L10:
            if (isTextStyle(r100) == false) goto L13;
            r102 = reset();
            goto L25
        L13:
            if (isEmojiStyle(r100) == true) goto L25;
            if (this.mCurrentNode.getData() == null) goto L24;
            r102 = 3;
            if (this.mCurrentDepth == 1) goto L20;
            this.mFlushNode = this.mCurrentNode;
            reset();
            goto L25
        L20:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L22;
            this.mFlushNode = this.mCurrentNode;
            reset();
            goto L25
        L22:
            r102 = reset();
            goto L25
        L24:
            r102 = reset();
            goto L25
        }

        public ProcessorSm(MetadataRepo.Node r100, boolean r101, int[] r102) {
            this.mState = 1;
            this.mRootNode = r100;
            this.mCurrentNode = r100;
            this.mUseEmojiAsDefaultStyle = r101;
            this.mEmojiAsDefaultStyleExceptions = r102;
        }
    }

    private static boolean hasInvalidSelection(int r100, int r101) {
        if (r100 == (-1)) goto L8;
        if (r101 == (-1)) goto L8;
        if (r100 != r101) goto L8;
        return false;
    L8:
        return true;
    }

    private static boolean hasModifiers(KeyEvent r100) {
        return !KeyEvent.metaStateHasNoModifiers(r100.getMetaState());
    }

    private void initExclusions(Set<int[]> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<int[]> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        int[] r102 = r101.next();
        String r103 = new String(r102, 0, r102.length);
        MarkExclusionCallback r104 = new MarkExclusionCallback(r103);
        process(r103, 0, r103.length(), 1, true, r104);
        goto L7
    }

    public int getEmojiMatch(CharSequence r100) {
        return getEmojiMatch(r100, this.mMetadataRepo.getMetadataVersion());
    }

    public int getEmojiEnd(CharSequence r110, int r111) {
        if (r111 >= 0) goto L4;
        return -1;
    L4:
        if (r111 < r110.length()) goto L7;
        return -1;
    L7:
        if ((r110 instanceof Spanned) == false) goto L13;
        Spanned r100 = (Spanned) r110;
        EmojiSpan[] r101 = (EmojiSpan[]) r100.getSpans(r111, r111 + 1, EmojiSpan.class);
        if (r101.length <= 0) goto L13;
        return r100.getSpanEnd(r101[0]);
    L13:
        return ((EmojiProcessLookupCallback) process(r110, Math.max(0, r111 - 16), Math.min(r110.length(), r111 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(r111))).end;
    }

    public int getEmojiMatch(CharSequence r110, int r111) {
        ProcessorSm r100 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r101 = r110.length();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102 >= r101) goto L20;
        int r105 = Character.codePointAt(r110, r102);
        int r106 = r100.check(r105);
        TypefaceEmojiRasterizer r112 = r100.getCurrentMetadata();
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L9;
        r102 = r102 + Character.charCount(r105);
    L16:
        if (r112 == null) goto L4;
        if (r112.getCompatAdded() > r111) goto L4;
        r104 = r104 + 1;
        goto L4
    L9:
        if (r106 != 3) goto L16;
        r112 = r100.getFlushMetadata();
        if (r112.getCompatAdded() > r111) goto L16;
        r103 = r103 + 1;
        goto L16
    L15:
        r102 = r102 + Character.charCount(r105);
        r104 = 0;
        goto L16
    L20:
        if (r103 == 0) goto L23;
        return 2;
    L23:
        if (r100.isInFlushableState() == true) goto L25;
    L27:
        if (r104 != 0) goto L29;
        return 0;
    L29:
        return 2;
    L25:
        if (r100.getCurrentMetadata().getCompatAdded() > r111) goto L27;
        return 1;
    }

    public int getEmojiStart(CharSequence r110, int r111) {
        if (r111 >= 0) goto L4;
        return -1;
    L4:
        if (r111 < r110.length()) goto L7;
        return -1;
    L7:
        if ((r110 instanceof Spanned) == false) goto L13;
        Spanned r100 = (Spanned) r110;
        EmojiSpan[] r101 = (EmojiSpan[]) r100.getSpans(r111, r111 + 1, EmojiSpan.class);
        if (r101.length <= 0) goto L13;
        return r100.getSpanStart(r101[0]);
    L13:
        return ((EmojiProcessLookupCallback) process(r110, Math.max(0, r111 - 16), Math.min(r110.length(), r111 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(r111))).start;
    }

    private static boolean delete(Editable r100, KeyEvent r101, boolean r102) {
        if (hasModifiers(r101) == false) goto L5;
        return false;
    L5:
        int r103 = Selection.getSelectionStart(r100);
        int r104 = Selection.getSelectionEnd(r100);
        if (hasInvalidSelection(r103, r104) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r105 = (EmojiSpan[]) r100.getSpans(r103, r104, EmojiSpan.class);
        if (r105 != null) goto L11;
    L24:
        return false;
    L11:
        if (r105.length <= 0) goto L24;
        int r106 = r105.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L24;
        EmojiSpan r108 = r105[r107];
        int r109 = r100.getSpanStart(r108);
        int r110 = r100.getSpanEnd(r108);
        if (r102 == false) goto L17;
        if (r109 != r103) goto L17;
    L21:
        r100.delete(r109, r110);
        return true;
    L17:
        if (r102 == true) goto L19;
        if (r110 == r103) goto L21;
    L19:
        if (r103 <= r109) goto L23;
        if (r103 < r110) goto L21;
    L23:
        r107 = r107 + 1;
        goto L13
    }

    public static boolean handleOnKeyDown(Editable r100, int r101, KeyEvent r102) {
        if (r101 != 67) goto L5;
        boolean r103 = delete(r100, r102, false);
    L9:
        if (r103 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r100);
        return true;
    L12:
        return false;
    L5:
        if (r101 == 112) goto L7;
        r103 = false;
        goto L9
    L7:
        r103 = delete(r100, r102, true);
        goto L9
    }

    private boolean hasGlyph(CharSequence r100, int r101, int r102, TypefaceEmojiRasterizer r103) {
        if (r103.getHasGlyph() != 0) goto L6;
        r103.setHasGlyph(this.mGlyphChecker.hasGlyph(r100, r101, r102, r103.getSdkAdded()));
    L6:
        if (r103.getHasGlyph() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean handleDeleteSurroundingText(InputConnection r100, Editable r101, int r102, int r103, boolean r104) {
        if (r101 == null) goto L27;
        if (r100 == null) goto L27;
        if (r102 < 0) goto L27;
        if (r103 < 0) goto L27;
        int r105 = Selection.getSelectionStart(r101);
        int r106 = Selection.getSelectionEnd(r101);
        if (hasInvalidSelection(r105, r106) == false) goto L12;
        return false;
    L12:
        if (r104 == false) goto L17;
        int r107 = CodepointIndexFinder.findIndexBackward(r101, r105, Math.max(r102, 0));
        int r108 = CodepointIndexFinder.findIndexForward(r101, r106, Math.max(r103, 0));
        if (r107 == (-1)) goto L16;
        if (r108 == (-1)) goto L16;
    L18:
        EmojiSpan[] r109 = (EmojiSpan[]) r101.getSpans(r107, r108, EmojiSpan.class);
        if (r109 == null) goto L27;
        if (r109.length <= 0) goto L27;
        int r110 = r109.length;
        int r111 = 0;
    L23:
        if (r111 >= r110) goto L25;
        EmojiSpan r112 = r109[r111];
        int r113 = r101.getSpanStart(r112);
        int r114 = r101.getSpanEnd(r112);
        r107 = Math.min(r113, r107);
        r108 = Math.max(r114, r108);
        r111 = r111 + 1;
        goto L23
    L25:
        int r115 = Math.max(r107, 0);
        int r116 = Math.min(r108, r101.length());
        r100.beginBatchEdit();
        r101.delete(r115, r116);
        r100.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r107 = Math.max(r105 - r102, 0);
        r108 = Math.min(r106 + r103, r101.length());
    L27:
        return false;
    }

    public CharSequence process(CharSequence r110, int r111, int r112, int r113, boolean r114) {
        boolean r100 = r110 instanceof SpannableBuilder;
        if (r100 == false) goto L5;
        ((SpannableBuilder) r110).beginBatchEdit();
    L5:
        if (r100 == false) goto L53;
    L15:
        UnprecomputeTextOnModificationSpannable r101 = new UnprecomputeTextOnModificationSpannable((Spannable) r110);     // Catch: Throwable -> L49
    L17:
        if (r101 == null) goto L28;
        EmojiSpan[] r102 = (EmojiSpan[]) r101.getSpans(r111, r112, EmojiSpan.class);     // Catch: Throwable -> L49
        if (r102 == null) goto L28;
        if (r102.length <= 0) goto L28;
        int r103 = r102.length;     // Catch: Throwable -> L49
        int r104 = 0;
    L23:
        if (r104 >= r103) goto L28;
        EmojiSpan r105 = r102[r104];     // Catch: Throwable -> L49
        int r106 = r101.getSpanStart(r105);     // Catch: Throwable -> L49
        int r107 = r101.getSpanEnd(r105);     // Catch: Throwable -> L49
        if (r106 == r112) goto L27;
        r101.removeSpan(r105);     // Catch: Throwable -> L49
    L27:
        r111 = Math.min(r106, r111);     // Catch: Throwable -> L49
        r112 = Math.max(r107, r112);     // Catch: Throwable -> L49
        r104 = r104 + 1;     // Catch: Throwable -> L49
    L28:
        int r108 = r111;
        int r109 = r112;
        if (r108 != r109) goto L31;
    L46:
        if (r100 == false) goto L48;
        ((SpannableBuilder) r110).endBatchEdit();
    L48:
        return r110;
    L31:
        if (r108 >= r110.length()) goto L46;
        if (r113 == Integer.MAX_VALUE) goto L37;
        if (r101 == null) goto L37;
        r113 = r113 - ((EmojiSpan[]) r101.getSpans(0, r101.length(), EmojiSpan.class)).length;     // Catch: Throwable -> L49
    L37:
        UnprecomputeTextOnModificationSpannable r115 = (UnprecomputeTextOnModificationSpannable) process(r110, r108, r109, r113, r114, new EmojiProcessAddSpanCallback(r101, this.mSpanFactory));     // Catch: Throwable -> L49
        if (r115 == null) goto L43;
        Spannable r116 = r115.getUnwrappedSpannable();     // Catch: Throwable -> L49
        if (r100 == false) goto L42;
        ((SpannableBuilder) r110).endBatchEdit();
    L42:
        return r116;
    L49:
        th = move-exception;
        if (r100 == false) goto L52;
        ((SpannableBuilder) r110).endBatchEdit();
    L52:
        throw th;
    L43:
        if (r100 == false) goto L45;
        ((SpannableBuilder) r110).endBatchEdit();
    L45:
        return r110;
    L53:
        if ((r110 instanceof Spannable) == true) goto L15;
        if ((r110 instanceof Spanned) == true) goto L12;
    L14:
        r101 = null;
        goto L17
    L12:
        if (((Spanned) r110).nextSpanTransition(r111 - 1, r112 + 1, EmojiSpan.class) > r112) goto L14;
        r101 = new UnprecomputeTextOnModificationSpannable(r110);     // Catch: Throwable -> L49
        goto L17
    }

    public EmojiProcessor(MetadataRepo r100, EmojiCompat.SpanFactory r101, EmojiCompat.GlyphChecker r102, boolean r103, int[] r104, Set<int[]> r105) {
        this.mSpanFactory = r101;
        this.mMetadataRepo = r100;
        this.mGlyphChecker = r102;
        this.mUseEmojiAsDefaultStyle = r103;
        this.mEmojiAsDefaultStyleExceptions = r104;
        initExclusions(r105);
    }

    private <T> T process(CharSequence r100, int r110, int r111, int r112, boolean r113, EmojiProcessCallback<T> r114) {
        ProcessorSm r101 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r102 = Character.codePointAt(r100, r110);
        int r103 = 0;
        boolean r104 = true;
    L3:
        int r105 = r110;
    L4:
        if (r110 >= r111) goto L26;
        if (r103 >= r112) goto L26;
        if (r104 == false) goto L26;
        int r106 = r101.check(r102);
        if (r106 != 1) goto L10;
        r105 = r105 + Character.charCount(Character.codePointAt(r100, r105));
        if (r105 >= r111) goto L24;
        r102 = Character.codePointAt(r100, r105);
    L24:
        r110 = r105;
        goto L4
    L10:
        if (r106 != 2) goto L12;
        r110 = r110 + Character.charCount(r102);
        if (r110 >= r111) goto L4;
        r102 = Character.codePointAt(r100, r110);
        goto L4
    L12:
        if (r106 != 3) goto L4;
        if (r113 == true) goto L17;
        if (hasGlyph(r100, r105, r110, r101.getFlushMetadata()) == true) goto L3;
    L17:
        r103 = r103 + 1;
        r104 = r114.handleEmoji(r100, r105, r110, r101.getFlushMetadata());
    L26:
        if (r101.isInFlushableState() == false) goto L34;
        if (r103 >= r112) goto L34;
        if (r104 == false) goto L34;
        if (r113 == false) goto L31;
    L32:
        r114.handleEmoji(r100, r105, r110, r101.getCurrentMetadata());
        goto L34
    L31:
        if (hasGlyph(r100, r105, r110, r101.getCurrentMetadata()) == false) goto L32;
    L34:
        return r114.getResult();
    }
}
