package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class SpannableBuilder extends SpannableStringBuilder {
    private final Class<?> mWatcherClass;
    private final List<WatcherWrapper> mWatchers;

    private static class WatcherWrapper implements SpanWatcher, TextWatcher {
        private final AtomicInteger mBlockCalls;
        final Object mObject;

        WatcherWrapper(Object r3) {
            this.mBlockCalls = new AtomicInteger(0);
            this.mObject = r3;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            ((TextWatcher) ZeusTransformUtils.preCheckCast(this.mObject, TextWatcher.class, "com.obric.aiagent.plugin")).beforeTextChanged(r7, r4, r5, r6);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            ((TextWatcher) ZeusTransformUtils.preCheckCast(this.mObject, TextWatcher.class, "com.obric.aiagent.plugin")).onTextChanged(r7, r4, r5, r6);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            ((TextWatcher) ZeusTransformUtils.preCheckCast(this.mObject, TextWatcher.class, "com.obric.aiagent.plugin")).afterTextChanged(r4);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable r3, Object r4, int r5, int r6) {
            Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.aiagent.plugin");
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) ZeusTransformUtils.preCheckCast(this.mObject, SpanWatcher.class, "com.obric.aiagent.plugin")).onSpanAdded(r7, r4, r5, r6);
            return;
        L5:
            if (isEmojiSpan(r4) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable r3, Object r4, int r5, int r6) {
            Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.aiagent.plugin");
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) ZeusTransformUtils.preCheckCast(this.mObject, SpanWatcher.class, "com.obric.aiagent.plugin")).onSpanRemoved(r7, r4, r5, r6);
            return;
        L5:
            if (isEmojiSpan(r4) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable r10, Object r11, int r12, int r13, int r14, int r15) {
            Spannable r3 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r10, Spannable.class, "com.obric.aiagent.plugin");
            if (this.mBlockCalls.get() <= 0) goto L8;
            if (isEmojiSpan(r11) == false) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT >= 28) goto L13;
            if (r12 <= r13) goto L11;
            r12 = 0;
        L11:
            if (r14 <= r15) goto L13;
            int r5 = r12;
            int r7 = 0;
        L14:
            ((SpanWatcher) ZeusTransformUtils.preCheckCast(this.mObject, SpanWatcher.class, "com.obric.aiagent.plugin")).onSpanChanged(r3, r11, r5, r13, r7, r15);
            return;
        L13:
            r5 = r12;
            r7 = r14;
            goto L14
        }

        final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }

        private boolean isEmojiSpan(Object r1) {
            return ZeusTransformUtils.instanceOf(r1, EmojiSpan.class);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(char r1) {
        return append(r1);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* synthetic */ Editable append(CharSequence r3) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* synthetic */ Editable append(CharSequence r3, int r4, int r5) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r1) {
        return append(r1);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3, int r4, int r5) {
        return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable delete(int r1, int r2) {
        return delete(r1, r2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* synthetic */ Editable insert(int r3, CharSequence r4) {
        return insert(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* synthetic */ Editable insert(int r3, CharSequence r4, int r5, int r6) {
        return insert(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* synthetic */ Editable replace(int r3, int r4, CharSequence r5) {
        return replace(r3, r4, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* synthetic */ Editable replace(int r7, int r8, CharSequence r9, int r10, int r11) {
        return replace(r7, r8, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin"), r10, r11);
    }

    SpannableBuilder(Class<?> r2) {
        this.mWatchers = new ArrayList();
        androidx.core.util.g.a(r2, "watcherClass cannot be null");
        this.mWatcherClass = r2;
    }

    SpannableBuilder(Class<?> r3, CharSequence r4) {
        super((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        this.mWatchers = new ArrayList();
        androidx.core.util.g.a(r3, "watcherClass cannot be null");
        this.mWatcherClass = r3;
    }

    SpannableBuilder(Class<?> r3, CharSequence r4, int r5, int r6) {
        super((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"), r5, r6);
        this.mWatchers = new ArrayList();
        androidx.core.util.g.a(r3, "watcherClass cannot be null");
        this.mWatcherClass = r3;
    }

    public static SpannableBuilder create(Class<?> r2, CharSequence r3) {
        return new SpannableBuilder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private boolean isWatcher(Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (isWatcher(r1.getClass()) == false) goto L6;
        return true;
    }

    private boolean isWatcher(Class<?> r1) {
        if (this.mWatcherClass != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int r3, int r4) {
        return new SpannableBuilder(this.mWatcherClass, this, r3, r4);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object r2, int r3, int r4, int r5) {
        if (isWatcher(r2) == false) goto L5;
        WatcherWrapper r0 = new WatcherWrapper(r2);
        this.mWatchers.add(r0);
        r2 = r0;
    L5:
        super.setSpan(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int r2, int r3, Class<T> r4) {
        if (isWatcher(r4) == false) goto L10;
        WatcherWrapper[] r1 = (WatcherWrapper[]) ZeusTransformUtils.preCheckCast(super.getSpans(r2, r3, WatcherWrapper.class), WatcherWrapper[].class, "com.obric.aiagent.plugin");
        T[] r5 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4, r1.length), Object[].class, "com.obric.aiagent.plugin"));
        int r6 = 0;
    L6:
        if (r6 >= r1.length) goto L8;
        r5[r6] = r1[r6].mObject;
        r6 = r6 + 1;
        goto L6
    L8:
        return r5;
    L10:
        return (T[]) super.getSpans(r2, r3, r4);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object r2) {
        if (isWatcher(r2) == false) goto L7;
        WatcherWrapper r0 = getWatcherFor(r2);
        if (r0 == null) goto L8;
        r2 = r0;
    L8:
        super.removeSpan(r2);
        if (r0 == null) goto L12;
        this.mWatchers.remove(r0);
        return;
    L12:
        return;
    L7:
        r0 = null;
        goto L8
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object r2) {
        if (isWatcher(r2) == false) goto L8;
        WatcherWrapper r0 = getWatcherFor(r2);
        if (r0 == null) goto L8;
        r2 = r0;
    L8:
        return super.getSpanStart(r2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object r2) {
        if (isWatcher(r2) == false) goto L8;
        WatcherWrapper r0 = getWatcherFor(r2);
        if (r0 == null) goto L8;
        r2 = r0;
    L8:
        return super.getSpanEnd(r2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object r2) {
        if (isWatcher(r2) == false) goto L8;
        WatcherWrapper r0 = getWatcherFor(r2);
        if (r0 == null) goto L8;
        r2 = r0;
    L8:
        return super.getSpanFlags(r2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int r2, int r3, Class r4) {
        if (r4 != null) goto L4;
    L5:
        r4 = WatcherWrapper.class;
    L7:
        return super.nextSpanTransition(r2, r3, r4);
    L4:
        if (isWatcher(r4) == false) goto L7;
        goto L5
    }

    private WatcherWrapper getWatcherFor(Object r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mWatchers.size()) goto L9;
        WatcherWrapper r1 = (WatcherWrapper) ZeusTransformUtils.preCheckCast(this.mWatchers.get(r0), WatcherWrapper.class, "com.obric.aiagent.plugin");
        if (r1.mObject == r5) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public void beginBatchEdit() {
        blockWatchers();
    }

    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    private void blockWatchers() {
        int r0 = 0;
    L4:
        if (r0 >= this.mWatchers.size()) goto L6;
        ((WatcherWrapper) ZeusTransformUtils.preCheckCast(this.mWatchers.get(r0), WatcherWrapper.class, "com.obric.aiagent.plugin")).blockCalls();
        r0 = r0 + 1;
        goto L4
    }

    private void unblockwatchers() {
        int r0 = 0;
    L4:
        if (r0 >= this.mWatchers.size()) goto L6;
        ((WatcherWrapper) ZeusTransformUtils.preCheckCast(this.mWatchers.get(r0), WatcherWrapper.class, "com.obric.aiagent.plugin")).unblockCalls();
        r0 = r0 + 1;
        goto L4
    }

    private void fireWatchers() {
        int r1 = 0;
    L4:
        if (r1 >= this.mWatchers.size()) goto L6;
        ((WatcherWrapper) ZeusTransformUtils.preCheckCast(this.mWatchers.get(r1), WatcherWrapper.class, "com.obric.aiagent.plugin")).onTextChanged(this, 0, length(), length());
        r1 = r1 + 1;
        goto L4
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int r3, int r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        blockWatchers();
        super.replace(r3, r4, r6);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int r7, int r8, CharSequence r9, int r10, int r11) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        blockWatchers();
        super.replace(r7, r8, r3, r10, r11);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int r3, CharSequence r4) {
        super.insert(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int r3, CharSequence r4, int r5, int r6) {
        super.insert(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"), r5, r6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int r1, int r2) {
        super.delete(r1, r2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence r3) {
        super.append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char r1) {
        super.append(r1);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence r3, int r4, int r5) {
        super.append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence r3, Object r4, int r5) {
        super.append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5);
        return this;
    }
}
