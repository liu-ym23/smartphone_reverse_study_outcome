package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.view.WindowMetrics;
import androidx.window.core.PredicateAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\tJ\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u0016\u0010\u000f\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0003J\u0016\u0010\u0012\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0003J\u0016\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bH\u0003J\u001c\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bH\u0003J\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0003J\u001c\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0003J\u001c\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020%2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "(Landroidx/window/core/PredicateAdapter;)V", "translate", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "", "splitInfoList", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "rules", "Landroidx/window/embedding/EmbeddingRule;", "translateActivityIntentPredicates", "splitPairFilters", "Landroidx/window/embedding/SplitPairFilter;", "translateActivityPairPredicates", "translateActivityPredicates", "activityFilters", "Landroidx/window/embedding/ActivityFilter;", "translateActivityRule", "Landroidx/window/extensions/embedding/ActivityRule;", com.heytap.mcssdk.constant.b.f276366p, "Landroidx/window/embedding/ActivityRule;", "predicateClass", "Ljava/lang/Class;", "translateIntentPredicates", "translateParentMetricsPredicate", "splitRule", "Landroidx/window/embedding/SplitRule;", "translateSplitPairRule", "Landroidx/window/extensions/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitPairRule;", "translateSplitPlaceholderRule", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitPlaceholderRule;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmbeddingAdapter {
    private final PredicateAdapter predicateAdapter;

    public EmbeddingAdapter(PredicateAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "predicateAdapter");
        this.predicateAdapter = r100;
    }

    private final Object translateActivityIntentPredicates(final Set<SplitPairFilter> r100) {
        return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Intent.class), new AnonymousClass1(r100));
    }

    private final Object translateActivityPairPredicates(final Set<SplitPairFilter> r100) {
        return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Activity.class), new C88001(r100));
    }

    private final Object translateActivityPredicates(final Set<ActivityFilter> r100) {
        return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Activity.class), new C88011(r100));
    }

    private final Object translateIntentPredicates(final Set<ActivityFilter> r100) {
        return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Intent.class), new C88021(r100));
    }

    private final Object translateParentMetricsPredicate(final SplitRule r100) {
        return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(WindowMetrics.class), new C88031(r100));
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Set<? extends EmbeddingRule> r100) {
        Intrinsics.checkNotNullParameter(r100, "rules");
        Class<?> r101 = this.predicateAdapter.predicateClassOrNull$window_release();
        if (r101 == null) goto L5;
        Set<? extends EmbeddingRule> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L22;
        EmbeddingRule r105 = (EmbeddingRule) r104.next();
        if ((r105 instanceof SplitPairRule) == false) goto L13;
        androidx.window.extensions.embedding.SplitPairRule r106 = translateSplitPairRule((SplitPairRule) r105, r101);
    L18:
        r103.add((androidx.window.extensions.embedding.EmbeddingRule) r106);
        goto L8
    L13:
        if ((r105 instanceof SplitPlaceholderRule) == false) goto L16;
        r106 = translateSplitPlaceholderRule((SplitPlaceholderRule) r105, r101);
        goto L18
    L16:
        if ((r105 instanceof ActivityRule) == false) goto L20;
        r106 = translateActivityRule((ActivityRule) r105, r101);
        goto L18
    L20:
        throw new IllegalArgumentException("Unsupported rule type");
    L22:
        return CollectionsKt.toSet(r103);
    L5:
        return SetsKt.emptySet();
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo r100) {
        androidx.window.extensions.embedding.ActivityStack r101 = r100.getPrimaryActivityStack();
        boolean r102 = false;
        boolean r103 = r101.isEmpty();     // Catch: NoSuchMethodError -> L5
    L6:
        ActivityStack r104 = new ActivityStack(r101.getActivities(), r103);
        androidx.window.extensions.embedding.ActivityStack r105 = r100.getSecondaryActivityStack();
        r102 = r105.isEmpty();     // Catch: NoSuchMethodError -> L10
    L9:
        return new SplitInfo(r104, new ActivityStack(r105.getActivities(), r102), r100.getSplitRatio());
    L5:
        r103 = false;
        goto L6
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "splitInfoList");
        List<? extends androidx.window.extensions.embedding.SplitInfo> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(translate((androidx.window.extensions.embedding.SplitInfo) r103.next()));
        goto L4
    L6:
        return r102;
    }

    private final androidx.window.extensions.embedding.ActivityRule translateActivityRule(ActivityRule r100, Class<?> r101) {
        return ((androidx.window.extensions.embedding.ActivityRule.Builder) androidx.window.extensions.embedding.ActivityRule.Builder.class.getConstructor(new Class[]{r101, r101}).newInstance(new Object[]{translateActivityPredicates(r100.getFilters()), translateIntentPredicates(r100.getFilters())})).setShouldAlwaysExpand(r100.getAlwaysExpand()).build();
    }

    private final androidx.window.extensions.embedding.SplitPairRule translateSplitPairRule(SplitPairRule r100, Class<?> r101) {
        return ((androidx.window.extensions.embedding.SplitPairRule.Builder) androidx.window.extensions.embedding.SplitPairRule.Builder.class.getConstructor(new Class[]{r101, r101, r101}).newInstance(new Object[]{translateActivityPairPredicates(r100.getFilters()), translateActivityIntentPredicates(r100.getFilters()), translateParentMetricsPredicate(r100)})).setSplitRatio(r100.getSplitRatio()).setLayoutDirection(r100.getLayoutDirection()).setShouldClearTop(r100.getClearTop()).setFinishPrimaryWithSecondary(r100.getFinishPrimaryWithSecondary()).setFinishSecondaryWithPrimary(r100.getFinishSecondaryWithPrimary()).build();
    }

    private final androidx.window.extensions.embedding.SplitPlaceholderRule translateSplitPlaceholderRule(SplitPlaceholderRule r100, Class<?> r101) {
        return ((androidx.window.extensions.embedding.SplitPlaceholderRule.Builder) androidx.window.extensions.embedding.SplitPlaceholderRule.Builder.class.getConstructor(new Class[]{Intent.class, r101, r101, r101}).newInstance(new Object[]{r100.getPlaceholderIntent(), translateActivityPredicates(r100.getFilters()), translateIntentPredicates(r100.getFilters()), translateParentMetricsPredicate(r100)})).setSplitRatio(r100.getSplitRatio()).setLayoutDirection(r100.getLayoutDirection()).setSticky(r100.isSticky()).setFinishPrimaryWithSecondary(r100.getFinishPrimaryWithSecondary()).build();
    }
}
