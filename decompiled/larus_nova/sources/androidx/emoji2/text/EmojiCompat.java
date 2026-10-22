package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class EmojiCompat {
    private static final Object CONFIG_LOCK = null;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = null;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile EmojiCompat sInstance;
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;
    private final CompatInternal mHelper;
    private final Set<InitCallback> mInitCallbacks;
    private final ReadWriteLock mInitLock;
    private volatile int mLoadState;
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    private final SpanFactory mSpanFactory;
    final boolean mUseEmojiAsDefaultStyle;

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    public static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        public String getAssetSignature() {
            return "";
        }

        public int getEmojiEnd(CharSequence r100, int r101) {
            return -1;
        }

        public int getEmojiMatch(CharSequence r100, int r101) {
            return 0;
        }

        public int getEmojiStart(CharSequence r100, int r101) {
            return -1;
        }

        public boolean hasEmojiGlyph(CharSequence r100) {
            return false;
        }

        public boolean hasEmojiGlyph(CharSequence r100, int r101) {
            return false;
        }

        public CharSequence process(CharSequence r100, int r101, int r102, int r103, boolean r104) {
            return r100;
        }

        public void updateEditorInfoAttrs(EditorInfo r100) {
        }

        public void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        public CompatInternal(EmojiCompat r100) {
            this.mEmojiCompat = r100;
        }
    }

    public static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public String getAssetSignature() {
            String r100 = this.mMetadataRepo.getMetadataList().sourceSha();
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public void loadMetadata() {
            MetadataRepoLoaderCallback r100 = new AnonymousClass1(this);     // Catch: Throwable -> L4
            this.mEmojiCompat.mMetadataLoader.load(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.mEmojiCompat.onMetadataLoadFailed(th);
        }

        public CompatInternal19(EmojiCompat r100) {
            super(r100);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public boolean hasEmojiGlyph(CharSequence r100) {
            if (this.mProcessor.getEmojiMatch(r100) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public void onMetadataLoadSuccess(MetadataRepo r110) {
            if (r110 != null) goto L5;
            this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.mMetadataRepo = r110;
            MetadataRepo r100 = this.mMetadataRepo;
            SpanFactory r101 = EmojiCompat.access$000(this.mEmojiCompat);
            GlyphChecker r102 = EmojiCompat.access$100(this.mEmojiCompat);
            EmojiCompat r103 = this.mEmojiCompat;
            this.mProcessor = new EmojiProcessor(r100, r101, r102, r103.mUseEmojiAsDefaultStyle, r103.mEmojiAsDefaultStyleExceptions, EmojiExclusions.getEmojiExclusions());
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public void updateEditorInfoAttrs(EditorInfo r100) {
            r100.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            r100.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiEnd(CharSequence r100, int r101) {
            return this.mProcessor.getEmojiEnd(r100, r101);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiMatch(CharSequence r100, int r101) {
            return this.mProcessor.getEmojiMatch(r100, r101);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiStart(CharSequence r100, int r101) {
            return this.mProcessor.getEmojiStart(r100, r101);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public boolean hasEmojiGlyph(CharSequence r100, int r101) {
            if (this.mProcessor.getEmojiMatch(r100, r101) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public CharSequence process(CharSequence r100, int r101, int r102, int r110, boolean r111) {
            return this.mProcessor.process(r100, r101, r102, r110, r111);
        }
    }

    public static abstract class Config {
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor;
        boolean mEmojiSpanIndicatorEnabled;
        GlyphChecker mGlyphChecker;
        Set<InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy;
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        SpanFactory mSpanFactory;
        boolean mUseEmojiAsDefaultStyle;

        public final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        public Config(MetadataRepoLoader r100) {
            this.mEmojiSpanIndicatorColor = FakePickerAvatarCreator.GREEN;
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            Preconditions.checkNotNull(r100, "metadataLoader cannot be null.");
            this.mMetadataLoader = r100;
        }

        public Config registerInitCallback(InitCallback r100) {
            Preconditions.checkNotNull(r100, "initCallback cannot be null");
            if (this.mInitCallbacks != null) goto L5;
            this.mInitCallbacks = new ArraySet();
        L5:
            this.mInitCallbacks.add(r100);
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int r100) {
            this.mEmojiSpanIndicatorColor = r100;
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean r100) {
            this.mEmojiSpanIndicatorEnabled = r100;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker r100) {
            Preconditions.checkNotNull(r100, "GlyphChecker cannot be null");
            this.mGlyphChecker = r100;
            return this;
        }

        public Config setMetadataLoadStrategy(int r100) {
            this.mMetadataLoadStrategy = r100;
            return this;
        }

        public Config setReplaceAll(boolean r100) {
            this.mReplaceAll = r100;
            return this;
        }

        public Config setSpanFactory(SpanFactory r100) {
            this.mSpanFactory = r100;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean r100) {
            return setUseEmojiAsDefaultStyle(r100, null);
        }

        public Config unregisterInitCallback(InitCallback r100) {
            Preconditions.checkNotNull(r100, "initCallback cannot be null");
            Set<InitCallback> r101 = this.mInitCallbacks;
            if (r101 == null) goto L5;
            r101.remove(r100);
        L5:
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean r100, List<Integer> r101) {
            this.mUseEmojiAsDefaultStyle = r100;
            if (r100 == false) goto L10;
            if (r101 == null) goto L10;
            this.mEmojiAsDefaultStyleExceptions = new int[r101.size()];
            Iterator<Integer> r102 = r101.iterator();
            int r103 = 0;
        L7:
            if (r102.hasNext() == false) goto L9;
            Integer r104 = r102.next();
            this.mEmojiAsDefaultStyleExceptions[r103] = r104.intValue();
            r103 = r103 + 1;
            goto L7
        L9:
            Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
        L11:
            return this;
        L10:
            this.mEmojiAsDefaultStyleExceptions = null;
            goto L11
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class DefaultSpanFactory implements SpanFactory {
        public DefaultSpanFactory() {
        }

        @Override // androidx.emoji2.text.EmojiCompat.SpanFactory
        public EmojiSpan createSpan(TypefaceEmojiRasterizer r100) {
            return new TypefaceEmojiSpan(r100);
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(CharSequence r100, int r101, int r102, int r103);
    }

    public static abstract class InitCallback {
        public InitCallback() {
        }

        public void onFailed(Throwable r100) {
        }

        public void onInitialized() {
        }
    }

    public static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        @Override // java.lang.Runnable
        public void run() {
            androidx_emoji2_text_EmojiCompat$ListenerDispatcher_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_emoji2_text_EmojiCompat$ListenerDispatcher__run$___twin___() {
            int r100 = this.mInitCallbacks.size();
            int r101 = 0;
            if (this.mLoadState == 1) goto L6;
        L4:
            if (r101 >= r100) goto L8;
            ((InitCallback) ListProtector.get(this.mInitCallbacks, r101)).onFailed(this.mThrowable);
            r101 = r101 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r101 >= r100) goto L11;
            ((InitCallback) ListProtector.get(this.mInitCallbacks, r101)).onInitialized();
            r101 = r101 + 1;
            goto L6
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_emoji2_text_EmojiCompat$ListenerDispatcher_com_larus_apm_impl_protector_RunnableLancet_run(ListenerDispatcher r100) {
            r100.androidx_emoji2_text_EmojiCompat$ListenerDispatcher__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public ListenerDispatcher(InitCallback r100, int r101) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.checkNotNull(r100, "initCallback cannot be null")}), r101, null);
        }

        public ListenerDispatcher(Collection<InitCallback> r100, int r101) {
            this(r100, r101, null);
        }

        public ListenerDispatcher(Collection<InitCallback> r100, int r101, Throwable r102) {
            Preconditions.checkNotNull(r100, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(r100);
            this.mLoadState = r101;
            this.mThrowable = r102;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback r100);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public MetadataRepoLoaderCallback() {
        }

        public abstract void onFailed(Throwable r100);

        public abstract void onLoaded(MetadataRepo r100);
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    public interface SpanFactory {
        EmojiSpan createSpan(TypefaceEmojiRasterizer r100);
    }

    static {
        INSTANCE_LOCK = new Object();
        CONFIG_LOCK = new Object();
    }

    public static EmojiCompat get() {
        Object r100 = INSTANCE_LOCK;
        monitor-enter(r100);
        EmojiCompat r101 = sInstance;     // Catch: Throwable -> L11
        if (r101 == null) goto L7;
        boolean r102 = true;
    L8:
        Preconditions.checkState(r102, NOT_INITIALIZED_ERROR_TEXT);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L7:
        r102 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean isConfigured() {
        if (sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
    L10:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mMetadataLoadStrategy != 0) goto L6;
        this.mLoadState = 0;     // Catch: Throwable -> L10
    L6:
        this.mInitLock.writeLock().unlock();
        if (getLoadState() != 0) goto L15;
        this.mHelper.loadMetadata();
        return;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        int r100 = this.mLoadState;     // Catch: Throwable -> L6
        this.mInitLock.readLock().unlock();
        return r100;
    L6:
        th = move-exception;
        this.mInitLock.readLock().unlock();
        throw th;
    }

    public void load() {
        boolean r100 = true;
        if (this.mMetadataLoadStrategy == 1) goto L6;
        r100 = false;
    L6:
        Preconditions.checkState(r100, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized() == false) goto L9;
        return;
    L9:
        this.mInitLock.writeLock().lock();
    L17:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L11:
        if (this.mLoadState != 0) goto L14;
        this.mInitLock.writeLock().unlock();
        return;
    L14:
        this.mLoadState = 0;     // Catch: Throwable -> L17
        this.mInitLock.writeLock().unlock();
        this.mHelper.loadMetadata();
    }

    public void onMetadataLoadSuccess() {
        ArrayList r100 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;     // Catch: Throwable -> L6
        r100.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r100, this.mLoadState));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    private boolean isInitialized() {
        if (getLoadState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    private EmojiCompat(Config r100) {
        this.mInitLock = new ReentrantReadWriteLock();
        this.mLoadState = 3;
        this.mReplaceAll = r100.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = r100.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = r100.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = r100.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = r100.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = r100.mMetadataLoader;
        this.mMetadataLoadStrategy = r100.mMetadataLoadStrategy;
        this.mGlyphChecker = r100.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet r101 = new ArraySet();
        this.mInitCallbacks = r101;
        SpanFactory r102 = r100.mSpanFactory;
        if (r102 != null) goto L6;
        r102 = new DefaultSpanFactory();
    L6:
        this.mSpanFactory = r102;
        Set<InitCallback> r103 = r100.mInitCallbacks;
        if (r103 != null) goto L9;
    L11:
        this.mHelper = new CompatInternal19(this);
        loadMetadata();
        return;
    L9:
        if (r103.isEmpty() == true) goto L11;
        r101.addAll(r100.mInitCallbacks);
        goto L11
    }

    public static /* synthetic */ SpanFactory access$000(EmojiCompat r100) {
        return r100.mSpanFactory;
    }

    public static /* synthetic */ GlyphChecker access$100(EmojiCompat r100) {
        return r100.mGlyphChecker;
    }

    public static EmojiCompat init(Config r100) {
        EmojiCompat r101 = sInstance;
        if (r101 != null) goto L14;
        Object r102 = INSTANCE_LOCK;
        monitor-enter(r102);
        r101 = sInstance;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new EmojiCompat(r100);     // Catch: Throwable -> L11
        sInstance = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r101;
    }

    public static EmojiCompat reset(Config r100) {
        Object r101 = INSTANCE_LOCK;
        monitor-enter(r101);
        EmojiCompat r102 = new EmojiCompat(r100);     // Catch: Throwable -> L7
        sInstance = r102;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static void skipDefaultConfigurationLookup(boolean r100) {
        Object r101 = CONFIG_LOCK;
        monitor-enter(r101);
        sHasDoneDefaultConfigLookup = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasEmojiGlyph(CharSequence r100) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r100, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r100);
    }

    public void onMetadataLoadFailed(Throwable r100) {
        ArrayList r101 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;     // Catch: Throwable -> L6
        r101.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r101, this.mLoadState, r100));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public CharSequence process(CharSequence r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return process(r100, 0, r101);
    L5:
        r101 = r100.length();
        goto L7
    }

    public void registerInitCallback(InitCallback r100) {
        Preconditions.checkNotNull(r100, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
    L12:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mLoadState != 1) goto L6;
    L9:
        this.mMainHandler.post(new ListenerDispatcher(r100, this.mLoadState));     // Catch: Throwable -> L12
    L10:
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        if (this.mLoadState == 2) goto L9;
        this.mInitCallbacks.add(r100);     // Catch: Throwable -> L12
        goto L10
    }

    public void unregisterInitCallback(InitCallback r100) {
        Preconditions.checkNotNull(r100, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        this.mInitCallbacks.remove(r100);     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public void updateEditorInfo(EditorInfo r100) {
        if (isInitialized() == false) goto L11;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.extras != null) goto L9;
        r100.extras = new Bundle();
    L9:
        this.mHelper.updateEditorInfoAttrs(r100);
        return;
    }

    public static EmojiCompat init(Context r100) {
        return init(r100, null);
    }

    public static EmojiCompat reset(EmojiCompat r100) {
        Object r101 = INSTANCE_LOCK;
        monitor-enter(r101);
        sInstance = r100;     // Catch: Throwable -> L7
        EmojiCompat r102 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static EmojiCompat init(Context r100, DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory r101) {
        if (sHasDoneDefaultConfigLookup == true) goto L5;
        if (r101 != null) goto L9;
        r101 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
    L9:
        Config r102 = r101.create(r100);
        Object r103 = CONFIG_LOCK;
        monitor-enter(r103);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (sHasDoneDefaultConfigLookup == true) goto L16;
        if (r102 == null) goto L15;
        init(r102);     // Catch: Throwable -> L19
    L15:
        sHasDoneDefaultConfigLookup = true;     // Catch: Throwable -> L19
    L16:
        EmojiCompat r104 = sInstance;     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
        return r104;
    L5:
        return sInstance;
    }

    public int getEmojiEnd(CharSequence r100, int r101) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r100, "charSequence cannot be null");
        return this.mHelper.getEmojiEnd(r100, r101);
    }

    public int getEmojiMatch(CharSequence r100, int r101) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r100, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(r100, r101);
    }

    public int getEmojiStart(CharSequence r100, int r101) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r100, "charSequence cannot be null");
        return this.mHelper.getEmojiStart(r100, r101);
    }

    public boolean hasEmojiGlyph(CharSequence r100, int r101) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r100, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r100, r101);
    }

    public static boolean handleOnKeyDown(Editable r100, int r101, KeyEvent r102) {
        return EmojiProcessor.handleOnKeyDown(r100, r101, r102);
    }

    public CharSequence process(CharSequence r100, int r101, int r102) {
        return process(r100, r101, r102, Integer.MAX_VALUE);
    }

    public CharSequence process(CharSequence r100, int r101, int r102, int r110) {
        return process(r100, r101, r102, r110, 0);
    }

    public static boolean handleDeleteSurroundingText(InputConnection r100, Editable r101, int r102, int r103, boolean r104) {
        return EmojiProcessor.handleDeleteSurroundingText(r100, r101, r102, r103, r104);
    }

    public CharSequence process(CharSequence r100, int r101, int r110, int r111, int r112) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(r101, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(r110, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(r111, "maxEmojiCount cannot be negative");
        if (r101 > r110) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "start should be <= than end");
        if (r100 != null) goto L11;
        return null;
    L11:
        if (r101 > r100.length()) goto L13;
        boolean r103 = true;
    L14:
        Preconditions.checkArgument(r103, "start should be < than charSequence length");
        if (r110 > r100.length()) goto L17;
        boolean r104 = true;
    L18:
        Preconditions.checkArgument(r104, "end should be < than charSequence length");
        if (r100.length() == 0) goto L30;
        if (r101 == r110) goto L31;
        if (r112 != 1) goto L24;
        boolean r105 = true;
    L29:
        return this.mHelper.process(r100, r101, r110, r111, r105);
    L24:
        if (r112 == 2) goto L26;
        r105 = this.mReplaceAll;
        goto L29
    L26:
        r105 = false;
        goto L29
    L31:
        return r100;
    L30:
        return r100;
    L17:
        r104 = false;
        goto L18
    L13:
        r103 = false;
        goto L14
    L5:
        r102 = false;
        goto L6
    }
}
