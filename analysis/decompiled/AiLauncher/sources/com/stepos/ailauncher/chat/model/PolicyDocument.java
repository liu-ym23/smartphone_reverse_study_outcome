package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.R$string;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/model/PolicyDocument;", "", "assetName", "", "titleRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getAssetName", "()Ljava/lang/String;", "getTitleRes", "()I", "PRIVACY_POLICY", "USER_AGREEMENT", "VOICEPRINT_AUTH", "IMPROVEMENT_PLAN", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyDocument {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PolicyDocument[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String assetName;
    private final int titleRes;
    public static final PolicyDocument PRIVACY_POLICY = new PolicyDocument("PRIVACY_POLICY", 0, "pp_15.html", R$string.policy_auth_pp);
    public static final PolicyDocument USER_AGREEMENT = new PolicyDocument("USER_AGREEMENT", 1, "up_2.html", R$string.policy_auth_pu);
    public static final PolicyDocument VOICEPRINT_AUTH = new PolicyDocument("VOICEPRINT_AUTH", 2, "vrs_2.html", R$string.policy_auth_vrs);
    public static final PolicyDocument IMPROVEMENT_PLAN = new PolicyDocument("IMPROVEMENT_PLAN", 3, "ueip_2.html", R$string.policy_auth_ueip);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/model/PolicyDocument$Companion;", "", "<init>", "()V", "fromName", "Lcom/stepos/ailauncher/chat/model/PolicyDocument;", "name", "", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final PolicyDocument fromName(String name) {
            PolicyDocument next;
            Iterator<PolicyDocument> it = PolicyDocument.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.d(next.name(), name)) {
                    break;
                }
            }
            PolicyDocument policyDocument = next;
            return policyDocument == null ? PolicyDocument.PRIVACY_POLICY : policyDocument;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PolicyDocument[] $values() {
        return new PolicyDocument[]{PRIVACY_POLICY, USER_AGREEMENT, VOICEPRINT_AUTH, IMPROVEMENT_PLAN};
    }

    static {
        PolicyDocument[] policyDocumentArr$values = $values();
        $VALUES = policyDocumentArr$values;
        $ENTRIES = a.a(policyDocumentArr$values);
        INSTANCE = new Companion(null);
    }

    private PolicyDocument(String str, int i10, String str2, int i11) {
        this.assetName = str2;
        this.titleRes = i11;
    }

    public static InterfaceC4149a<PolicyDocument> getEntries() {
        return $ENTRIES;
    }

    public static PolicyDocument valueOf(String str) {
        return (PolicyDocument) Enum.valueOf(PolicyDocument.class, str);
    }

    public static PolicyDocument[] values() {
        return (PolicyDocument[]) $VALUES.clone();
    }

    public final String getAssetName() {
        return this.assetName;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
