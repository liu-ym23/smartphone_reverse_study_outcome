package com.stepos.stepclaw.bridge.memory;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import x5.f;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/bridge/memory/MemoryMessage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "role", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "Companion", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MemoryMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final String role;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/stepclaw/bridge/memory/MemoryMessage$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "line", "removeLeadingBracket", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lb5/a0;", "appendLine", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "text", "stripMetaAndNormalize", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    public MemoryMessage(String role, String content) {
        p.e(role, "role");
        p.e(content, "content");
        this.role = role;
        this.content = content;
    }

    public static /* synthetic */ MemoryMessage copy$default(MemoryMessage memoryMessage, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = memoryMessage.role;
        }
        if ((i8 & 2) != 0) {
            str2 = memoryMessage.content;
        }
        return memoryMessage.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final MemoryMessage copy(String role, String content) {
        p.e(role, "role");
        p.e(content, "content");
        return new MemoryMessage(role, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryMessage)) {
            return false;
        }
        MemoryMessage memoryMessage = (MemoryMessage) other;
        return p.a(this.role, memoryMessage.role) && p.a(this.content, memoryMessage.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return this.content.hashCode() + (this.role.hashCode() * 31);
    }

    public String toString() {
        return b.q("MemoryMessage(role=", this.role, ", content=", this.content, ")");
    }
}
