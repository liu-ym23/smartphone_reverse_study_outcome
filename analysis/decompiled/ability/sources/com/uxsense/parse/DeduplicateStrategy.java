package com.uxsense.parse;

import B9.T;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/DeduplicateStrategy;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "NONE", "SKIP", "UPDATE", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeduplicateStrategy {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ DeduplicateStrategy[] $VALUES;
    private static final f $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final DeduplicateStrategy NONE = new DeduplicateStrategy("NONE", 0);
    public static final DeduplicateStrategy SKIP = new DeduplicateStrategy("SKIP", 1);
    public static final DeduplicateStrategy UPDATE = new DeduplicateStrategy("UPDATE", 2);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/parse/DeduplicateStrategy$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/parse/DeduplicateStrategy;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ x9.b get$cachedSerializer() {
            return (x9.b) DeduplicateStrategy.$cachedSerializer$delegate.getF4884a();
        }

        public final x9.b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    private static final /* synthetic */ DeduplicateStrategy[] $values() {
        return new DeduplicateStrategy[]{NONE, SKIP, UPDATE};
    }

    static {
        DeduplicateStrategy[] deduplicateStrategyArr$values = $values();
        $VALUES = deduplicateStrategyArr$values;
        $ENTRIES = kotlin.enums.a.a(deduplicateStrategyArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.base.metadata.a(21));
    }

    private DeduplicateStrategy(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ x9.b _init_$_anonymous_() {
        return T.d("com.uxsense.parse.DeduplicateStrategy", values());
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static DeduplicateStrategy valueOf(String str) {
        return (DeduplicateStrategy) Enum.valueOf(DeduplicateStrategy.class, str);
    }

    public static DeduplicateStrategy[] values() {
        return (DeduplicateStrategy[]) $VALUES.clone();
    }
}
