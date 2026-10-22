package com.stepos.stepclaw.memory.search;

import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import com.stepos.stepclaw.memory.utils.TokenEstimator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/memory/search/FormatStage;", "Lcom/stepos/stepclaw/memory/search/SearchStage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxEntries", "maxFormatTokens", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categoryTokenWeights", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(IILjava/util/Map;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/search/SearchContext;", "context", "Lb5/a0;", "execute", "(Lcom/stepos/stepclaw/memory/search/SearchContext;Lf5/c;)Ljava/lang/Object;", "I", "Ljava/util/Map;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FormatStage implements SearchStage {
    private static final int SEPARATOR_TOKENS = TokenEstimator.INSTANCE.estimate("\n\n");
    private static final String TAG = "FormatStage";
    private final Map<String, Float> categoryTokenWeights;
    private final MemoryLogger logger;
    private final int maxEntries;
    private final int maxFormatTokens;

    public FormatStage(int i8, int i9, Map<String, Float> categoryTokenWeights, MemoryLogger logger) {
        p.e(categoryTokenWeights, "categoryTokenWeights");
        p.e(logger, "logger");
        this.maxEntries = i8;
        this.maxFormatTokens = i9;
        this.categoryTokenWeights = categoryTokenWeights;
        this.logger = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$1$0(List list, String str, float f3, int i8, w wVar) {
        int i9 = 0;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (p.a(((RetrievalResult) it.next()).getCategory(), str) && (i9 = i9 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        int i10 = wVar.f3684a;
        StringBuilder sb = new StringBuilder("category=");
        sb.append(str);
        sb.append(" weight=");
        sb.append(f3);
        sb.append(" budget=");
        a8.b.z(sb, i8, " selected=", i9, " (~");
        return m0.f.e(sb, i10, " tokens)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String execute$lambda$4(List list, w wVar, FormatStage formatStage) {
        int size = list.size();
        int i8 = wVar.f3684a;
        return m0.f.e(a8.b.t("formatted ", size, " entries (~", i8, " tokens, globalCap="), formatStage.maxFormatTokens, ")");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0100  */
    @Override // com.stepos.stepclaw.memory.search.SearchStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.stepclaw.memory.search.SearchContext r24, f5.c r25) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.FormatStage.execute(com.stepos.stepclaw.memory.search.SearchContext, f5.c):java.lang.Object");
    }

    public /* synthetic */ FormatStage(int i8, int i9, Map map, MemoryLogger memoryLogger, int i10, i iVar) {
        this((i10 & 1) != 0 ? 50 : i8, (i10 & 2) != 0 ? 2000 : i9, (i10 & 4) != 0 ? t.f1093a : map, memoryLogger);
    }
}
