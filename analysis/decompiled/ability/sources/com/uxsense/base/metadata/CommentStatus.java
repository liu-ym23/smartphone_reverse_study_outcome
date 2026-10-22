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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/uxsense/base/metadata/CommentStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "NORMAL", "DELETED", "COLLAPSED", "PENDING", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommentStatus {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ CommentStatus[] $VALUES;
    private static final f $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final CommentStatus NORMAL = new CommentStatus("NORMAL", 0);
    public static final CommentStatus DELETED = new CommentStatus("DELETED", 1);
    public static final CommentStatus COLLAPSED = new CommentStatus("COLLAPSED", 2);
    public static final CommentStatus PENDING = new CommentStatus("PENDING", 3);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/CommentStatus$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/CommentStatus;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) CommentStatus.$cachedSerializer$delegate.getF4884a();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    private static final /* synthetic */ CommentStatus[] $values() {
        return new CommentStatus[]{NORMAL, DELETED, COLLAPSED, PENDING};
    }

    static {
        CommentStatus[] commentStatusArr$values = $values();
        $VALUES = commentStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(commentStatusArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new com.stepos.ability.voicewakeup.service.f(23));
    }

    private CommentStatus(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _init_$_anonymous_() {
        return T.d("com.uxsense.base.metadata.CommentStatus", values());
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static CommentStatus valueOf(String str) {
        return (CommentStatus) Enum.valueOf(CommentStatus.class, str);
    }

    public static CommentStatus[] values() {
        return (CommentStatus[]) $VALUES.clone();
    }
}
