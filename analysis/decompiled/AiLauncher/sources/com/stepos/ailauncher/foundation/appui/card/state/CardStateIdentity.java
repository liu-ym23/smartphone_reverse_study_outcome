package com.stepos.ailauncher.foundation.appui.card.state;

import La.C0953c;
import Z8.C1173v;
import Z8.F;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.state.CardStateIdentity;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0018BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001c\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\r¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/state/c;", "", "", "templateType", "bizChannel", "accountScope", "taskId", "revisionFingerprint", "sourceMessageId", "sourceToolCallId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "e", Const.INTENT_KEY_UMID, "getSourceMessageId", "getSourceToolCallId", "c", "recordId", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.state.c, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class CardStateIdentity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("account_scope")
    private final String accountScope;

    @SerializedName("biz_channel")
    private final String bizChannel;

    @SerializedName("revision_fingerprint")
    private final String revisionFingerprint;

    @SerializedName("source_message_id")
    private final String sourceMessageId;

    @SerializedName("source_tool_call_id")
    private final String sourceToolCallId;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("template_type")
    private final String templateType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/state/c$a;", "", "<init>", "()V", "", "accountId", "f", "(Ljava/lang/String;)Ljava/lang/String;", "", "parts", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Ljava/lang/String;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.state.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final CharSequence e(String str) {
            return str == null ? "" : str;
        }

        public static final CharSequence h(byte b10) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b10 & 255)}, 1));
            p.h(str, "format(...)");
            return str;
        }

        public final String d(List<String> parts) {
            p.i(parts, "parts");
            return g(F.A0(parts, Const.STR_MART_WELL, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.state.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return CardStateIdentity.Companion.e((String) obj);
                }
            }, 30, null));
        }

        public final String f(String accountId) {
            p.i(accountId, "accountId");
            return g(accountId);
        }

        public final String g(String value) throws NoSuchAlgorithmException {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = value.getBytes(C0953c.UTF_8);
            p.h(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            p.h(bArrDigest, "digest(...)");
            return r.v0(bArrDigest, "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.state.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return CardStateIdentity.Companion.h(((Byte) obj).byteValue());
                }
            }, 30, null);
        }

        public Companion() {
        }
    }

    public CardStateIdentity(String templateType, String str, String accountScope, String taskId, String str2, String str3, String str4) {
        p.i(templateType, "templateType");
        p.i(accountScope, "accountScope");
        p.i(taskId, "taskId");
        this.templateType = templateType;
        this.bizChannel = str;
        this.accountScope = accountScope;
        this.taskId = taskId;
        this.revisionFingerprint = str2;
        this.sourceMessageId = str3;
        this.sourceToolCallId = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getAccountScope() {
        return this.accountScope;
    }

    /* renamed from: b, reason: from getter */
    public final String getBizChannel() {
        return this.bizChannel;
    }

    public final String c() {
        Companion companion = INSTANCE;
        String str = this.accountScope;
        String str2 = this.templateType;
        String str3 = this.bizChannel;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.taskId;
        String str5 = this.revisionFingerprint;
        return companion.g(F.A0(C1173v.p(str, str2, str3, str4, str5 != null ? str5 : ""), "|", null, null, 0, null, null, 62, null));
    }

    /* renamed from: d, reason: from getter */
    public final String getRevisionFingerprint() {
        return this.revisionFingerprint;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardStateIdentity)) {
            return false;
        }
        CardStateIdentity cardStateIdentity = (CardStateIdentity) other;
        return p.d(this.templateType, cardStateIdentity.templateType) && p.d(this.bizChannel, cardStateIdentity.bizChannel) && p.d(this.accountScope, cardStateIdentity.accountScope) && p.d(this.taskId, cardStateIdentity.taskId) && p.d(this.revisionFingerprint, cardStateIdentity.revisionFingerprint) && p.d(this.sourceMessageId, cardStateIdentity.sourceMessageId) && p.d(this.sourceToolCallId, cardStateIdentity.sourceToolCallId);
    }

    /* renamed from: f, reason: from getter */
    public final String getTemplateType() {
        return this.templateType;
    }

    public int hashCode() {
        int iHashCode = this.templateType.hashCode() * 31;
        String str = this.bizChannel;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.accountScope.hashCode()) * 31) + this.taskId.hashCode()) * 31;
        String str2 = this.revisionFingerprint;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sourceMessageId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sourceToolCallId;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CardStateIdentity(templateType=" + this.templateType + ", bizChannel=" + this.bizChannel + ", accountScope=" + this.accountScope + ", taskId=" + this.taskId + ", revisionFingerprint=" + this.revisionFingerprint + ", sourceMessageId=" + this.sourceMessageId + ", sourceToolCallId=" + this.sourceToolCallId + ")";
    }
}
