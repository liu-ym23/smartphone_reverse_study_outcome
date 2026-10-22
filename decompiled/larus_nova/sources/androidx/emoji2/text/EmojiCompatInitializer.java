package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context r100) {
            super(new BackgroundDefaultLoader(r100));
            setMetadataLoadStrategy(1);
        }
    }

    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        public static /* synthetic */ void a(BackgroundDefaultLoader r100, EmojiCompat.MetadataRepoLoaderCallback r101, ThreadPoolExecutor r102) {
            r100.lambda$load$0(r101, r102);
        }

        public BackgroundDefaultLoader(Context r100) {
            this.mContext = r100.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.MetadataRepoLoaderCallback r100) {
            final ThreadPoolExecutor r101 = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            r101.execute(new c(this, r100, r101));
        }

        private /* synthetic */ void lambda$load$0(EmojiCompat.MetadataRepoLoaderCallback r100, ThreadPoolExecutor r101) {
            doLoad(r100, r101);
        }

        public void doLoad(final EmojiCompat.MetadataRepoLoaderCallback r100, final ThreadPoolExecutor r101) {
            FontRequestEmojiCompatConfig r102 = DefaultEmojiCompatConfig.create(this.mContext);     // Catch: Throwable -> L7
            if (r102 == null) goto L6;
            r102.setLoadingExecutor(r101);     // Catch: Throwable -> L7
            r102.getMetadataRepoLoader().load(new AnonymousClass1(this, r100, r101));     // Catch: Throwable -> L7
            return;
        L6:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            r100.onFailed(th);
            r101.shutdown();
        }
    }

    public static class LoadEmojiCompatRunnable implements Runnable {
        public LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable__run$___twin___() {
            TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L7
            if (EmojiCompat.isConfigured() == false) goto L5;
            EmojiCompat.get().load();     // Catch: Throwable -> L7
        L5:
            TraceCompat.endSection();
            return;
        L7:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable_com_larus_apm_impl_protector_RunnableLancet_run(LoadEmojiCompatRunnable r100) {
            r100.androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    public void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), 500);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Boolean create(Context r100) {
        EmojiCompat.init(new BackgroundDefaultConfig(r100));
        delayUntilFirstResume(r100);
        return Boolean.TRUE;
    }

    public void delayUntilFirstResume(Context r100) {
        final Lifecycle r101 = ((LifecycleOwner) AppInitializer.getInstance(r100).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        r101.addObserver(new AnonymousClass1(this, r101));
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Boolean create(Context r100) {
        return create(r100);
    }
}
