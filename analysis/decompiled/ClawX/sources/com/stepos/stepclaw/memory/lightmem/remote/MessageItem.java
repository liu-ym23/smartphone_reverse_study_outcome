package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import x5.f;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002+,B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0017R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010#\u0012\u0004\b'\u0010(\u001a\u0004\b&\u0010\u0017R\u0011\u0010*\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010\u0017¨\u0006-"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "role", "content", "timeStamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRole", "getContent", "getTimeStamp", "getTimeStamp$annotations", "()V", "getCleanContent", "cleanContent", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class MessageItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final String role;
    private final String timeStamp;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0007J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "line", "removeLeadingBracket", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lb5/a0;", "appendLine", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "text", "stripMetaAndNormalize", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "serializer", "()Lkotlinx/serialization/KSerializer;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final void appendLine(StringBuilder sb, String line) {
            if (sb.length() == 0) {
                sb.append(line);
            } else {
                sb.append('\n');
                sb.append(line);
            }
        }

        private final String removeLeadingBracket(String line) {
            int iQ1;
            if (!u.c1(line, "[", false) || (iQ1 = n.q1(line, AbstractJsonLexerKt.END_LIST, 0, 6)) == -1) {
                return line;
            }
            String strSubstring = line.substring(iQ1 + 1);
            p.d(strSubstring, "substring(...)");
            return n.W1(strSubstring).toString();
        }

        public final KSerializer<MessageItem> serializer() {
            return MessageItem$$serializer.INSTANCE;
        }

        public final String stripMetaAndNormalize(String text) {
            p.e(text, "text");
            StringBuilder sb = new StringBuilder(text.length());
            Iterator it = n.x1(text).iterator();
            boolean z = false;
            boolean z2 = false;
            boolean z8 = false;
            while (true) {
                f fVar = (f) it;
                if (!fVar.hasNext()) {
                    String string = sb.toString();
                    p.d(string, "toString(...)");
                    return n.T1(string).toString();
                }
                String strRemoveLeadingBracket = (String) fVar.next();
                String string2 = n.T1(strRemoveLeadingBracket).toString();
                if (!z && u.V0(string2, "(untrusted metadata):", false)) {
                    z2 = true;
                } else if (z2 && p.a(string2, "```json")) {
                    z2 = false;
                    z = true;
                } else if (z2) {
                    appendLine(sb, strRemoveLeadingBracket);
                    z2 = false;
                } else if (z && p.a(string2, "```")) {
                    z = false;
                } else if (!z) {
                    if (!z8 && string2.length() > 0) {
                        strRemoveLeadingBracket = removeLeadingBracket(string2);
                        z8 = true;
                    }
                    appendLine(sb, strRemoveLeadingBracket);
                }
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ MessageItem(int i8, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 3, MessageItem$$serializer.INSTANCE.getDescriptor());
        }
        this.role = str;
        this.content = str2;
        if ((i8 & 4) == 0) {
            this.timeStamp = null;
        } else {
            this.timeStamp = str3;
        }
    }

    public static /* synthetic */ MessageItem copy$default(MessageItem messageItem, String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = messageItem.role;
        }
        if ((i8 & 2) != 0) {
            str2 = messageItem.content;
        }
        if ((i8 & 4) != 0) {
            str3 = messageItem.timeStamp;
        }
        return messageItem.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(MessageItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.role);
        output.encodeStringElement(serialDesc, 1, self.content);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.timeStamp == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.timeStamp);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public final MessageItem copy(String role, String content, String timeStamp) {
        p.e(role, "role");
        p.e(content, "content");
        return new MessageItem(role, content, timeStamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageItem)) {
            return false;
        }
        MessageItem messageItem = (MessageItem) other;
        return p.a(this.role, messageItem.role) && p.a(this.content, messageItem.content) && p.a(this.timeStamp, messageItem.timeStamp);
    }

    public final String getCleanContent() {
        return (p.a(this.role, "user") || p.a(this.role, "assistant")) ? INSTANCE.stripMetaAndNormalize(this.content) : this.content;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        int iF = b.f(this.role.hashCode() * 31, 31, this.content);
        String str = this.timeStamp;
        return iF + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.role;
        String str2 = this.content;
        return m0.f.f(b.v("MessageItem(role=", str, ", content=", str2, ", timeStamp="), this.timeStamp, ")");
    }

    public MessageItem(String role, String content, String str) {
        p.e(role, "role");
        p.e(content, "content");
        this.role = role;
        this.content = content;
        this.timeStamp = str;
    }

    public /* synthetic */ MessageItem(String str, String str2, String str3, int i8, i iVar) {
        this(str, str2, (i8 & 4) != 0 ? null : str3);
    }

    @SerialName("time_stamp")
    public static /* synthetic */ void getTimeStamp$annotations() {
    }
}
