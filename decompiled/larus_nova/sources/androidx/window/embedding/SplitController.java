package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fJ\u0006\u0010\u0012\u001a\u00020\tJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007J\u001a\u0010\u0019\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fJ\u0016\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/window/embedding/SplitController;", "", "()V", "embeddingBackend", "Landroidx/window/embedding/EmbeddingBackend;", "staticSplitRules", "", "Landroidx/window/embedding/EmbeddingRule;", "addSplitListener", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "clearRegisteredRules", "getSplitRules", "isActivityEmbedded", "", "isSplitSupported", "registerRule", com.heytap.mcssdk.constant.b.f276366p, "removeSplitListener", "setStaticSplitRules", "staticRules", "unregisterRule", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitController {
    public static final Companion Companion = null;
    private static volatile SplitController globalInstance;
    private static final ReentrantLock globalLock = null;
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;
    private Set<? extends EmbeddingRule> staticSplitRules;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/window/embedding/SplitController$Companion;", "", "()V", "globalInstance", "Landroidx/window/embedding/SplitController;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "sDebug", "", "getInstance", "initialize", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "staticRuleResourceId", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final SplitController getInstance() {
            if (SplitController.access$getGlobalInstance$cp() != null) goto L13;
            ReentrantLock r100 = SplitController.access$getGlobalLock$cp();
            r100.lock();
        L10:
            th = move-exception;
            r100.unlock();
            throw th;
        L6:
            if (SplitController.access$getGlobalInstance$cp() != null) goto L8;
            SplitController.access$setGlobalInstance$cp(new SplitController(null));     // Catch: Throwable -> L10
        L8:
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
            r100.unlock();
        L13:
            SplitController r102 = SplitController.access$getGlobalInstance$cp();
            Intrinsics.checkNotNull(r102);
            return r102;
        }

        @JvmStatic
        public final void initialize(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Set<EmbeddingRule> r102 = new SplitRuleParser().parseSplitRules$window_release(r100, r101);
            SplitController r103 = getInstance();
            if (r102 != null) goto L5;
            r102 = SetsKt.emptySet();
        L5:
            SplitController.access$setStaticSplitRules(r103, r102);
        }
    }

    public /* synthetic */ SplitController(DefaultConstructorMarker r100) {
        this();
    }

    @JvmStatic
    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void initialize(Context r100, int r101) {
        Companion.initialize(r100, r101);
    }

    static {
        Companion = new Companion(null);
        globalLock = new ReentrantLock();
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    public final Set<EmbeddingRule> getSplitRules() {
        return CollectionsKt.toSet(this.embeddingBackend.getSplitRules());
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    private SplitController() {
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        this.staticSplitRules = SetsKt.emptySet();
    }

    public static final /* synthetic */ SplitController access$getGlobalInstance$cp() {
        return globalInstance;
    }

    public static final /* synthetic */ ReentrantLock access$getGlobalLock$cp() {
        return globalLock;
    }

    public static final /* synthetic */ void access$setGlobalInstance$cp(SplitController r100) {
        globalInstance = r100;
    }

    private final void setStaticSplitRules(Set<? extends EmbeddingRule> r100) {
        this.staticSplitRules = r100;
        this.embeddingBackend.setSplitRules(r100);
    }

    public final boolean isActivityEmbedded(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.embeddingBackend.isActivityEmbedded(r100);
    }

    public final void registerRule(EmbeddingRule r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        this.embeddingBackend.registerRule(r100);
    }

    public final void removeSplitListener(Consumer<List<SplitInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(r100);
    }

    public final void unregisterRule(EmbeddingRule r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        this.embeddingBackend.unregisterRule(r100);
    }

    public static final /* synthetic */ void access$setStaticSplitRules(SplitController r100, Set r101) {
        r100.setStaticSplitRules(r101);
    }

    public final void addSplitListener(Activity r100, Executor r101, Consumer<List<SplitInfo>> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "executor");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(r100, r101, r102);
    }
}
