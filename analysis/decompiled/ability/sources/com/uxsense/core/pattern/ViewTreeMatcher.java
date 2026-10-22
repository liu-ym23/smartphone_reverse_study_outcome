package com.uxsense.core.pattern;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.utils.ApexLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR.\u0010\u001f\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/uxsense/core/pattern/ViewTreeMatcher;", "", "Lcom/uxsense/core/pattern/ViewPattern;", "pattern", "Lcom/uxsense/core/pattern/ParentFilter;", "parentFilter", AppAgent.CONSTRUCT, "(Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/core/pattern/ParentFilter;)V", "Lcom/uxsense/core/base/parse/KViewNode;", "node", "Lcom/uxsense/core/pattern/MatchContext;", "context", "", "useCache", "", "Lcom/uxsense/core/pattern/PatternMatchResult;", "results", "matchNode", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;ZLjava/util/List;)Z", "LC7/r;", "matchWithParentFilter", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/MatchContext;ZLjava/util/List;)V", "root", "", "matchAll", "(Lcom/uxsense/core/base/parse/KViewNode;Z)Ljava/util/List;", "Lcom/uxsense/core/pattern/ViewPattern;", "Lcom/uxsense/core/pattern/ParentFilter;", "", "Lkotlin/Pair;", "", "matchCache", "Ljava/util/Map;", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewTreeMatcher {
    private static final String TAG = "ViewTreeMatcher";
    private final Map<Pair<Integer, ViewPattern>, PatternMatchResult> matchCache;
    private final ParentFilter parentFilter;
    private final ViewPattern pattern;

    public ViewTreeMatcher(ViewPattern pattern, ParentFilter parentFilter) {
        k.f(pattern, "pattern");
        this.pattern = pattern;
        this.parentFilter = parentFilter;
        this.matchCache = new LinkedHashMap();
    }

    public static /* synthetic */ List matchAll$default(ViewTreeMatcher viewTreeMatcher, KViewNode kViewNode, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        return viewTreeMatcher.matchAll(kViewNode, z10);
    }

    private final boolean matchNode(KViewNode node, MatchContext context, boolean useCache, List<PatternMatchResult> results) {
        PatternMatchResult patternMatchResultMatch;
        Pair<Integer, ViewPattern> pair = new Pair<>(Integer.valueOf(node.hashCode()), this.pattern);
        if (useCache && this.matchCache.containsKey(pair)) {
            patternMatchResultMatch = this.matchCache.get(pair);
        } else {
            patternMatchResultMatch = this.pattern.match(node, context);
            if (useCache) {
                this.matchCache.put(pair, patternMatchResultMatch);
            }
        }
        if (patternMatchResultMatch != null) {
            results.add(patternMatchResultMatch);
            return true;
        }
        Iterator<KViewNode> it = node.getChildren().iterator();
        while (it.hasNext()) {
            matchNode(it.next(), context, useCache, results);
        }
        return false;
    }

    private final void matchWithParentFilter(KViewNode node, MatchContext context, boolean useCache, List<PatternMatchResult> results) {
        ParentFilter parentFilter = this.parentFilter;
        k.c(parentFilter);
        if (parentFilter.matches(node)) {
            ApexLogger.d$default(TAG, "找到符合条件的父节点: " + node.getClassName(), null, 4, null);
            Iterator<KViewNode> it = node.getChildren().iterator();
            while (it.hasNext()) {
                matchNode(it.next(), context, useCache, results);
            }
        }
        Iterator<KViewNode> it2 = node.getChildren().iterator();
        while (it2.hasNext()) {
            matchWithParentFilter(it2.next(), context, useCache, results);
        }
    }

    public final List<PatternMatchResult> matchAll(KViewNode root, boolean useCache) {
        k.f(root, "root");
        if (useCache) {
            this.matchCache.clear();
        }
        MatchContext matchContext = new MatchContext(null, false, 0, null, 15, null);
        ArrayList arrayList = new ArrayList();
        if (this.parentFilter == null) {
            matchNode(root, matchContext, useCache, arrayList);
        } else {
            matchWithParentFilter(root, matchContext, useCache, arrayList);
        }
        ApexLogger.i$default(TAG, "共匹配到 " + arrayList.size() + " 个结果", null, 4, null);
        return arrayList;
    }

    public /* synthetic */ ViewTreeMatcher(ViewPattern viewPattern, ParentFilter parentFilter, int i, e eVar) {
        this(viewPattern, (i & 2) != 0 ? null : parentFilter);
    }
}
