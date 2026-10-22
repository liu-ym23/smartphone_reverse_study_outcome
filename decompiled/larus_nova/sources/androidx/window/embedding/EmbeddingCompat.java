package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/embedding/EmbeddingCompat;", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "embeddingExtension", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "adapter", "Landroidx/window/embedding/EmbeddingAdapter;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/ConsumerAdapter;)V", "isActivityEmbedded", "", "activity", "Landroid/app/Activity;", "setEmbeddingCallback", "", "embeddingCallback", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "setSplitRules", "rules", "", "Landroidx/window/embedding/EmbeddingRule;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmbeddingCompat implements EmbeddingInterfaceCompat {
    public static final Companion Companion = null;
    public static final boolean DEBUG = true;
    private static final String TAG = "EmbeddingCompat";
    private final EmbeddingAdapter adapter;
    private final ConsumerAdapter consumerAdapter;
    private final ActivityEmbeddingComponent embeddingExtension;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\r\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/embedding/EmbeddingCompat$Companion;", "", "()V", "DEBUG", "", "TAG", "", "embeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "getExtensionApiLevel", "", "()Ljava/lang/Integer;", "isEmbeddingAvailable", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ Unit a(Object r100, Method r101, Object[] r102) {
            return m7959embeddingComponent$lambda0(r100, r101, r102);
        }

        public static /* synthetic */ Unit b(Object r100, Method r101, Object[] r102) {
            return m7960embeddingComponent$lambda1(r100, r101, r102);
        }

        public final Integer getExtensionApiLevel() {
            return Integer.valueOf(WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel());
        L8:
            return null;
        }

        public final boolean isEmbeddingAvailable() {
            if (WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent() == null) goto L10;
            return true;
        L10:
            return false;
        L11:
            return false;
        }

        public final ActivityEmbeddingComponent embeddingComponent() {
            if (isEmbeddingAvailable() == false) goto L11;
            ActivityEmbeddingComponent r100 = WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent();
            if (r100 != null) goto L17;
            Object r101 = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new a());
            if (r101 == null) goto L10;
            return (ActivityEmbeddingComponent) r101;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        L17:
            return r100;
        L11:
            Object r102 = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new b());
            if (r102 == null) goto L16;
            return (ActivityEmbeddingComponent) r102;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        }

        /* JADX INFO: renamed from: embeddingComponent$lambda-0, reason: not valid java name */
        private static final Unit m7959embeddingComponent$lambda0(Object r100, Method r101, Object[] r102) {
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: embeddingComponent$lambda-1, reason: not valid java name */
        private static final Unit m7960embeddingComponent$lambda1(Object r100, Method r101, Object[] r102) {
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ EmbeddingAdapter access$getAdapter$p(EmbeddingCompat r100) {
        return r100.adapter;
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public boolean isActivityEmbedded(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.embeddingExtension.isActivityEmbedded(r100);
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setEmbeddingCallback(final EmbeddingInterfaceCompat.EmbeddingCallbackInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "embeddingCallback");
        this.consumerAdapter.addConsumer(this.embeddingExtension, Reflection.getOrCreateKotlinClass(List.class), "setSplitInfoCallback", new AnonymousClass1(r100, this));
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setSplitRules(Set<? extends EmbeddingRule> r100) {
        Intrinsics.checkNotNullParameter(r100, "rules");
        Set<androidx.window.extensions.embedding.EmbeddingRule> r101 = this.adapter.translate(r100);
        this.embeddingExtension.setEmbeddingRules(r101);
    }

    public EmbeddingCompat(ActivityEmbeddingComponent r100, EmbeddingAdapter r101, ConsumerAdapter r102) {
        Intrinsics.checkNotNullParameter(r100, "embeddingExtension");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "consumerAdapter");
        this.embeddingExtension = r100;
        this.adapter = r101;
        this.consumerAdapter = r102;
    }
}
