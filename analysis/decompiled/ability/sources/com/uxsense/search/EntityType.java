package com.uxsense.search;

import B9.T;
import C7.f;
import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import x9.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/uxsense/search/EntityType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "CREATION", "COMMENT", "USER", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntityType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ EntityType[] $VALUES;
    private static final f $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final EntityType CREATION = new EntityType("CREATION", 0);
    public static final EntityType COMMENT = new EntityType("COMMENT", 1);
    public static final EntityType USER = new EntityType("USER", 2);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/search/EntityType$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/search/EntityType;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) EntityType.$cachedSerializer$delegate.getF4884a();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    private static final /* synthetic */ EntityType[] $values() {
        return new EntityType[]{CREATION, COMMENT, USER};
    }

    static {
        EntityType[] entityTypeArr$values = $values();
        $VALUES = entityTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(entityTypeArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.uxsense.parse.a(8));
    }

    private EntityType(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _init_$_anonymous_() {
        return T.d("com.uxsense.search.EntityType", values());
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static EntityType valueOf(String str) {
        return (EntityType) Enum.valueOf(EntityType.class, str);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }
}
