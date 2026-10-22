package com.uxsense.base.metadata;

import B9.T;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import x9.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/uxsense/base/metadata/CreationType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "VIDEO", "LIVE", "ARTICLE", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreationType {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ CreationType[] $VALUES;
    private static final f $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final CreationType TEXT = new CreationType("TEXT", 0);
    public static final CreationType IMAGE = new CreationType("IMAGE", 1);
    public static final CreationType VIDEO = new CreationType("VIDEO", 2);
    public static final CreationType LIVE = new CreationType("LIVE", 3);
    public static final CreationType ARTICLE = new CreationType("ARTICLE", 4);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/CreationType$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/CreationType;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) CreationType.$cachedSerializer$delegate.getF4884a();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    private static final /* synthetic */ CreationType[] $values() {
        return new CreationType[]{TEXT, IMAGE, VIDEO, LIVE, ARTICLE};
    }

    static {
        CreationType[] creationTypeArr$values = $values();
        $VALUES = creationTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(creationTypeArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new a(1));
    }

    private CreationType(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _init_$_anonymous_() {
        return T.d("com.uxsense.base.metadata.CreationType", values());
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static CreationType valueOf(String str) {
        return (CreationType) Enum.valueOf(CreationType.class, str);
    }

    public static CreationType[] values() {
        return (CreationType[]) $VALUES.clone();
    }
}
