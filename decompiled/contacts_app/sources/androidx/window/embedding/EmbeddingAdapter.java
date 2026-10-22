package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tJ(\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0007J(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0007J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0007J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J*\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\u000fH\u0082\u0002¢\u0006\u0002\u0010 J*\u0010!\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\u000fH\u0082\u0002¢\u0006\u0002\u0010 ¨\u0006\""}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "()V", "translate", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "", "splitInfoList", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "rules", "Landroidx/window/embedding/EmbeddingRule;", "translateActivityIntentPredicates", "Ljava/util/function/Predicate;", "Landroid/util/Pair;", "Landroid/app/Activity;", "Landroid/content/Intent;", "splitPairFilters", "Landroidx/window/embedding/SplitPairFilter;", "translateActivityPairPredicates", "translateActivityPredicates", "activityFilters", "Landroidx/window/embedding/ActivityFilter;", "translateIntentPredicates", "translateParentMetricsPredicate", "Landroid/view/WindowMetrics;", "splitRule", "Landroidx/window/embedding/SplitRule;", "component1", "F", ExifInterface.LATITUDE_SOUTH, "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmbeddingAdapter {
    /* JADX INFO: renamed from: $r8$lambda$-QlFe7fckaSVTLCegr9_8uxVaa4, reason: not valid java name */
    public static /* synthetic */ boolean m89$r8$lambda$QlFe7fckaSVTLCegr9_8uxVaa4(Set r0, Activity r1) {
        return m94translateActivityPredicates$lambda6(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$nSea4sfI4EFFkXqov0va87aZ_68(SplitRule r0, WindowMetrics r1) {
        return m96translateParentMetricsPredicate$lambda4(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$x8eGFLpnqP7STokqkg3obw9dl5Q(EmbeddingAdapter r0, Set r1, Pair r2) {
        return m92translateActivityIntentPredicates$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$xf-Lop7h3ngH6EmzyuDyOYtb8Lk, reason: not valid java name */
    public static /* synthetic */ boolean m90$r8$lambda$xfLop7h3ngH6EmzyuDyOYtb8Lk(EmbeddingAdapter r0, Set r1, Pair r2) {
        return m93translateActivityPairPredicates$lambda1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$yScxR8XDNmwEhhX_T4Oe1hesc-c, reason: not valid java name */
    public static /* synthetic */ boolean m91$r8$lambda$yScxR8XDNmwEhhX_T4Oe1hescc(Set r0, Intent r1) {
        return m95translateIntentPredicates$lambda8(r0, r1);
    }

    public EmbeddingAdapter() {
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "splitInfoList");
        List<? extends androidx.window.extensions.embedding.SplitInfo> r4 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.add(translate((androidx.window.extensions.embedding.SplitInfo) r5.next()));
        goto L4
    L7:
        return r0;
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo r5) {
        androidx.window.extensions.embedding.ActivityStack r4 = r5.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(r4, "splitInfo.primaryActivityStack");
        boolean r0 = false;
        boolean r1 = r4.isEmpty();     // Catch: NoSuchMethodError -> L5
    L6:
        List r6 = r4.getActivities();
        Intrinsics.checkNotNullExpressionValue(r6, "primaryActivityStack.activities");
        ActivityStack r2 = new ActivityStack(r6, r1);
        androidx.window.extensions.embedding.ActivityStack r7 = r5.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(r7, "splitInfo.secondaryActivityStack");
        r0 = r7.isEmpty();     // Catch: NoSuchMethodError -> L10
    L8:
        List r8 = r7.getActivities();
        Intrinsics.checkNotNullExpressionValue(r8, "secondaryActivityStack.activities");
        return new SplitInfo(r2, new ActivityStack(r8, r0), r5.getSplitRatio());
    L5:
        r1 = false;
        goto L6
    }

    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(final Set<SplitPairFilter> r2) {
        Intrinsics.checkNotNullParameter(r2, "splitPairFilters");
        return new EmbeddingAdapter$$ExternalSyntheticLambda4(this, r2);
    }

    /* JADX INFO: renamed from: translateActivityPairPredicates$lambda-1, reason: not valid java name */
    private static final boolean m93translateActivityPairPredicates$lambda1(EmbeddingAdapter r2, Set r3, Pair r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$splitPairFilters");
        Intrinsics.checkNotNullExpressionValue(r4, "(first, second)");
        Activity r0 = (Activity) r2.component1(r4);
        Activity r5 = (Activity) r2.component2(r4);
        Set r6 = r3;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        if (((SplitPairFilter) r7.next()).matchesActivityPair(r0, r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r6.isEmpty() == false) goto L7;
        return false;
    }

    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(final Set<SplitPairFilter> r2) {
        Intrinsics.checkNotNullParameter(r2, "splitPairFilters");
        return new EmbeddingAdapter$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: translateActivityIntentPredicates$lambda-3, reason: not valid java name */
    private static final boolean m92translateActivityIntentPredicates$lambda3(EmbeddingAdapter r2, Set r3, Pair r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$splitPairFilters");
        Intrinsics.checkNotNullExpressionValue(r4, "(first, second)");
        Activity r0 = (Activity) r2.component1(r4);
        Intent r5 = (Intent) r2.component2(r4);
        Set r6 = r3;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        if (((SplitPairFilter) r7.next()).matchesActivityIntentPair(r0, r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r6.isEmpty() == false) goto L7;
        return false;
    }

    public final Predicate<WindowMetrics> translateParentMetricsPredicate(final SplitRule r1) {
        Intrinsics.checkNotNullParameter(r1, "splitRule");
        return new EmbeddingAdapter$$ExternalSyntheticLambda2(r1);
    }

    /* JADX INFO: renamed from: translateParentMetricsPredicate$lambda-4, reason: not valid java name */
    private static final boolean m96translateParentMetricsPredicate$lambda4(SplitRule r1, WindowMetrics r2) {
        Intrinsics.checkNotNullParameter(r1, "$splitRule");
        Intrinsics.checkNotNullExpressionValue(r2, "windowMetrics");
        return r1.checkParentMetrics(r2);
    }

    public final Predicate<Activity> translateActivityPredicates(final Set<ActivityFilter> r1) {
        Intrinsics.checkNotNullParameter(r1, "activityFilters");
        return new EmbeddingAdapter$$ExternalSyntheticLambda1(r1);
    }

    /* JADX INFO: renamed from: translateActivityPredicates$lambda-6, reason: not valid java name */
    private static final boolean m94translateActivityPredicates$lambda6(Set r3, Activity r4) {
        Intrinsics.checkNotNullParameter(r3, "$activityFilters");
        Set r5 = r3;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        ActivityFilter r0 = (ActivityFilter) r6.next();
        Intrinsics.checkNotNullExpressionValue(r4, "activity");
        if (r0.matchesActivity(r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return false;
    }

    public final Predicate<Intent> translateIntentPredicates(final Set<ActivityFilter> r1) {
        Intrinsics.checkNotNullParameter(r1, "activityFilters");
        return new EmbeddingAdapter$$ExternalSyntheticLambda3(r1);
    }

    /* JADX INFO: renamed from: translateIntentPredicates$lambda-8, reason: not valid java name */
    private static final boolean m95translateIntentPredicates$lambda8(Set r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r3, "$activityFilters");
        Set r5 = r3;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        ActivityFilter r0 = (ActivityFilter) r6.next();
        Intrinsics.checkNotNullExpressionValue(r4, MemorySourceLinkType.INTENT);
        if (r0.matchesIntent(r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return false;
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Set<? extends EmbeddingRule> r8) {
        Intrinsics.checkNotNullParameter(r8, "rules");
        Set<? extends EmbeddingRule> r9 = r8;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        EmbeddingRule r1 = (EmbeddingRule) r10.next();
        if ((r1 instanceof SplitPairRule) == false) goto L9;
        SplitPairRule r3 = (SplitPairRule) r1;
        androidx.window.extensions.embedding.SplitPairRule r2 = new androidx.window.extensions.embedding.SplitPairRule.Builder(translateActivityPairPredicates(r3.getFilters()), translateActivityIntentPredicates(r3.getFilters()), translateParentMetricsPredicate((SplitRule) r1)).setSplitRatio(r3.getSplitRatio()).setLayoutDirection(r3.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(r3.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(r3.getFinishSecondaryWithPrimary()).setShouldClearTop(r3.getClearTop()).build();
        Intrinsics.checkNotNullExpressionValue(r2, "SplitPairRuleBuilder(\n  …                 .build()");
    L14:
        r0.add((androidx.window.extensions.embedding.EmbeddingRule) r2);
        goto L4
    L9:
        if ((r1 instanceof SplitPlaceholderRule) == false) goto L12;
        SplitPlaceholderRule r4 = (SplitPlaceholderRule) r1;
        r2 = new androidx.window.extensions.embedding.SplitPlaceholderRule.Builder(r4.getPlaceholderIntent(), translateActivityPredicates(r4.getFilters()), translateIntentPredicates(r4.getFilters()), translateParentMetricsPredicate((SplitRule) r1)).setSplitRatio(r4.getSplitRatio()).setLayoutDirection(r4.getLayoutDirection()).build();
        Intrinsics.checkNotNullExpressionValue(r2, "SplitPlaceholderRuleBuil…                 .build()");
        goto L14
    L12:
        if ((r1 instanceof ActivityRule) == false) goto L16;
        ActivityRule r5 = (ActivityRule) r1;
        r2 = new androidx.window.extensions.embedding.ActivityRule.Builder(translateActivityPredicates(r5.getFilters()), translateIntentPredicates(r5.getFilters())).setShouldAlwaysExpand(r5.getAlwaysExpand()).build();
        Intrinsics.checkNotNullExpressionValue(r2, "ActivityRuleBuilder(\n   …                 .build()");
        goto L14
    L16:
        throw new IllegalArgumentException("Unsupported rule type");
    L18:
        return CollectionsKt.toSet(r0);
    }

    private final <F, S> F component1(Pair<F, S> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (F) r1.first;
    }

    private final <F, S> S component2(Pair<F, S> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (S) r1.second;
    }
}
