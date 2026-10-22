package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes17.dex */
public final class SpannableBuilder extends SpannableStringBuilder {
    private final Class<?> mWatcherClass;
    private final List<WatcherWrapper> mWatchers;

    public static class WatcherWrapper implements TextWatcher, SpanWatcher {
        private final AtomicInteger mBlockCalls;
        final Object mObject;

        public final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        public final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }

        public WatcherWrapper(Object r100) {
            this.mBlockCalls = new AtomicInteger(0);
            this.mObject = r100;
        }

        private boolean isEmojiSpan(Object r100) {
            return r100 instanceof EmojiSpan;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r100) {
            ((TextWatcher) this.mObject).afterTextChanged(r100);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            ((TextWatcher) this.mObject).beforeTextChanged(r100, r101, r102, r103);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanAdded(r100, r101, r102, r103);
            return;
        L5:
            if (isEmojiSpan(r101) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
            if (this.mBlockCalls.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.mObject).onSpanRemoved(r100, r101, r102, r103);
            return;
        L5:
            if (isEmojiSpan(r101) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            ((TextWatcher) this.mObject).onTextChanged(r100, r101, r102, r103);
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable r100, Object r110, int r111, int r112, int r113, int r114) {
            if (this.mBlockCalls.get() <= 0) goto L8;
            if (isEmojiSpan(r110) == false) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT < 28) goto L10;
        L14:
            int r101 = r111;
            int r102 = r113;
        L15:
            ((SpanWatcher) this.mObject).onSpanChanged(r100, r110, r101, r112, r102, r114);
            return;
        L10:
            if (r111 <= r112) goto L12;
            r111 = 0;
        L12:
            if (r113 <= r114) goto L14;
            r101 = r111;
            r102 = 0;
            goto L15
        }
    }

    private void blockWatchers() {
        int r100 = 0;
    L4:
        if (r100 >= this.mWatchers.size()) goto L6;
        ((WatcherWrapper) ListProtector.get(this.mWatchers, r100)).blockCalls();
        r100 = r100 + 1;
        goto L4
    }

    private void fireWatchers() {
        int r100 = 0;
    L4:
        if (r100 >= this.mWatchers.size()) goto L6;
        ((WatcherWrapper) ListProtector.get(this.mWatchers, r100)).onTextChanged(this, 0, length(), length());
        r100 = r100 + 1;
        goto L4
    }

    private void unblockwatchers() {
        int r100 = 0;
    L4:
        if (r100 >= this.mWatchers.size()) goto L6;
        ((WatcherWrapper) ListProtector.get(this.mWatchers, r100)).unblockCalls();
        r100 = r100 + 1;
        goto L4
    }

    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    public void beginBatchEdit() {
        blockWatchers();
    }

    public SpannableBuilder(Class<?> r100) {
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r100, "watcherClass cannot be null");
        this.mWatcherClass = r100;
    }

    private WatcherWrapper getWatcherFor(Object r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mWatchers.size()) goto L9;
        WatcherWrapper r102 = (WatcherWrapper) ListProtector.get(this.mWatchers, r101);
        if (r102.mObject == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    private boolean isWatcher(Object r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (isWatcher(r100.getClass()) == false) goto L6;
        return true;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(char r100) {
        return append(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object r100) {
        if (isWatcher(r100) == false) goto L8;
        WatcherWrapper r101 = getWatcherFor(r100);
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        return super.getSpanEnd(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object r100) {
        if (isWatcher(r100) == false) goto L8;
        WatcherWrapper r101 = getWatcherFor(r100);
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        return super.getSpanFlags(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object r100) {
        if (isWatcher(r100) == false) goto L8;
        WatcherWrapper r101 = getWatcherFor(r100);
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        return super.getSpanStart(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object r100) {
        if (isWatcher(r100) == false) goto L7;
        WatcherWrapper r101 = getWatcherFor(r100);
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        super.removeSpan(r100);
        if (r101 == null) goto L12;
        this.mWatchers.remove(r101);
        return;
    L12:
        return;
    L7:
        r101 = null;
        goto L8
    }

    private boolean isWatcher(Class<?> r100) {
        if (this.mWatcherClass != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(CharSequence r100) {
        return append(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r100) throws IOException {
        return append(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100) throws IOException {
        return append(r100);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char r100) {
        super.append(r100);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence r100) {
        super.append(r100);
        return this;
    }

    public SpannableBuilder(Class<?> r100, CharSequence r101) {
        super(r101);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r100, "watcherClass cannot be null");
        this.mWatcherClass = r100;
    }

    public static SpannableBuilder create(Class<?> r100, CharSequence r101) {
        return new SpannableBuilder(r100, r101);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable delete(int r100, int r101) {
        return delete(r100, r101);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable insert(int r100, CharSequence r101) {
        return insert(r100, r101);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return new SpannableBuilder(this.mWatcherClass, this, r100, r101);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int r100, int r101) {
        super.delete(r100, r101);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int r100, CharSequence r101) {
        super.insert(r100, r101);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Editable append(CharSequence r100, int r101, int r102) {
        return append(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int r100, int r101, Class<T> r102) {
        if (isWatcher(r102) == false) goto L10;
        WatcherWrapper[] r103 = (WatcherWrapper[]) super.getSpans(r100, r101, WatcherWrapper.class);
        T[] r104 = (T[]) ((Object[]) Array.newInstance(r102, r103.length));
        int r105 = 0;
    L6:
        if (r105 >= r103.length) goto L8;
        r104[r105] = r103[r105].mObject;
        r105 = r105 + 1;
        goto L6
    L8:
        return r104;
    L10:
        return (T[]) super.getSpans(r100, r101, r102);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int r100, int r101, Class r102) {
        if (r102 != null) goto L4;
    L5:
        r102 = WatcherWrapper.class;
    L7:
        return super.nextSpanTransition(r100, r101, r102);
    L4:
        if (isWatcher(r102) == false) goto L7;
        goto L5
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int r100, int r101, CharSequence r102) {
        blockWatchers();
        super.replace(r100, r101, r102);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r100, int r101, int r102) throws IOException {
        return append(r100, r101, r102);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable replace(int r100, int r101, CharSequence r102) {
        return replace(r100, r101, r102);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence r100, int r101, int r102) {
        super.append(r100, r101, r102);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence r100, Object r101, int r102) {
        super.append(r100, r101, r102);
        return this;
    }

    public SpannableBuilder(Class<?> r100, CharSequence r101, int r102, int r103) {
        super(r101, r102, r103);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(r100, "watcherClass cannot be null");
        this.mWatcherClass = r100;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable insert(int r100, CharSequence r101, int r102, int r103) {
        return insert(r100, r101, r102, r103);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object r100, int r101, int r102, int r103) {
        if (isWatcher(r100) == false) goto L5;
        WatcherWrapper r104 = new WatcherWrapper(r100);
        this.mWatchers.add(r104);
        r100 = r104;
    L5:
        super.setSpan(r100, r101, r102, r103);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int r100, CharSequence r101, int r102, int r103) {
        super.insert(r100, r101, r102, r103);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int r100, int r101, CharSequence r102, int r103, int r104) {
        blockWatchers();
        super.replace(r100, r101, r102, r103, r104);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public /* bridge */ /* synthetic */ Editable replace(int r100, int r101, CharSequence r102, int r103, int r104) {
        return replace(r100, r101, r102, r103, r104);
    }
}
