package com.uxsense.base.metadata;

import B9.T;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.volcengine.tos.model.acl.ACLConst;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import x9.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/uxsense/base/metadata/MessageStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SENDING", "SENT", "DELIVERED", ACLConst.PERMISSION_TYPE_READ, "FAILED", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageStatus {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ MessageStatus[] $VALUES;
    private static final f $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final MessageStatus SENDING = new MessageStatus("SENDING", 0);
    public static final MessageStatus SENT = new MessageStatus("SENT", 1);
    public static final MessageStatus DELIVERED = new MessageStatus("DELIVERED", 2);
    public static final MessageStatus READ = new MessageStatus(ACLConst.PERMISSION_TYPE_READ, 3);
    public static final MessageStatus FAILED = new MessageStatus("FAILED", 4);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/MessageStatus$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/MessageStatus;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) MessageStatus.$cachedSerializer$delegate.getF4884a();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    private static final /* synthetic */ MessageStatus[] $values() {
        return new MessageStatus[]{SENDING, SENT, DELIVERED, READ, FAILED};
    }

    static {
        MessageStatus[] messageStatusArr$values = $values();
        $VALUES = messageStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(messageStatusArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new a(5));
    }

    private MessageStatus(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _init_$_anonymous_() {
        return T.d("com.uxsense.base.metadata.MessageStatus", values());
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static MessageStatus valueOf(String str) {
        return (MessageStatus) Enum.valueOf(MessageStatus.class, str);
    }

    public static MessageStatus[] values() {
        return (MessageStatus[]) $VALUES.clone();
    }
}
