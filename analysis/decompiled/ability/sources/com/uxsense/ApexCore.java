package com.uxsense;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.pattern.ParentFilter;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.core.pattern.ViewTreeMatcher;
import com.uxsense.core.utils.ApexLogger;
import com.uxsense.core.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/uxsense/ApexCore;", "", AppAgent.CONSTRUCT, "()V", "Lcom/uxsense/core/utils/Logger;", "logger", "LC7/r;", "initLogger", "(Lcom/uxsense/core/utils/Logger;)V", "useAndroidLogger", "Lcom/uxsense/core/base/parse/KViewNode;", "root", "Lcom/uxsense/core/pattern/ViewPattern;", "pattern", "Lcom/uxsense/core/pattern/ParentFilter;", "parentFilter", "", "Lcom/uxsense/core/pattern/PatternMatchResult;", "match", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/ViewPattern;Lcom/uxsense/core/pattern/ParentFilter;)Ljava/util/List;", "Lcom/uxsense/core/pattern/ViewTreeMatcher;", "viewTreeMatcher", "(Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/core/pattern/ViewTreeMatcher;)Ljava/util/List;", "", "TAG", "Ljava/lang/String;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexCore {
    public static final ApexCore INSTANCE = new ApexCore();
    private static final String TAG = "ApexCore";

    private ApexCore() {
    }

    public static /* synthetic */ List match$default(ApexCore apexCore, KViewNode kViewNode, ViewPattern viewPattern, ParentFilter parentFilter, int i, Object obj) {
        if ((i & 4) != 0) {
            parentFilter = null;
        }
        return apexCore.match(kViewNode, viewPattern, parentFilter);
    }

    public final void initLogger(Logger logger) {
        k.f(logger, "logger");
        ApexLogger.INSTANCE.setLogger(logger);
    }

    public final List<PatternMatchResult> match(KViewNode root, ViewPattern pattern, ParentFilter parentFilter) {
        k.f(root, "root");
        k.f(pattern, "pattern");
        return match(root, new ViewTreeMatcher(pattern, parentFilter));
    }

    public final void useAndroidLogger() {
        ApexLogger.INSTANCE.setLogger(new AndroidLogger());
    }

    public final List<PatternMatchResult> match(KViewNode root, ViewTreeMatcher viewTreeMatcher) {
        k.f(root, "root");
        k.f(viewTreeMatcher, "viewTreeMatcher");
        return ViewTreeMatcher.matchAll$default(viewTreeMatcher, root, false, 2, null);
    }
}
