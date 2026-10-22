package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* JADX INFO: loaded from: classes.dex */
final class EmojiEditableFactory extends Editable.Factory {
    private static final Object INSTANCE_LOCK = null;
    private static volatile Editable.Factory sInstance;
    private static Class<?> sWatcherClass;

    static {
        INSTANCE_LOCK = new Object();
    }

    private EmojiEditableFactory() {
        sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, getClass().getClassLoader());     // Catch: Throwable -> L5
        return;
    }

    public static Editable.Factory getInstance() {
        if (sInstance != null) goto L15;
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new EmojiEditableFactory();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence r2) {
        Class<?> r0 = sWatcherClass;
        if (r0 == null) goto L7;
        return SpannableBuilder.create(r0, r2);
    L7:
        return super.newEditable(r2);
    }
}
