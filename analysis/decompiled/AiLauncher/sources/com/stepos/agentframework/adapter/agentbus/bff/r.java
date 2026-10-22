package com.stepos.agentframework.adapter.agentbus.bff;

import La.H;
import La.K;
import Z8.C1173v;
import Z8.F;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0013\u001c\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jy\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/r;", "", "<init>", "()V", "", "sessionId", "replyTo", BundleContentBridge.KEY_ROLE, "messagePartial", "delta", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "Lcom/stepos/agentframework/adapter/agentbus/bff/r$c;", "toolCalls", "Lcom/stepos/agentframework/adapter/agentbus/bff/r$a;", "attachments", "", "metadata", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "query", UxipConstants.f30685x, "c", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/adapter/agentbus/bff/r$b;", "e", "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/agentbus/bff/r$b;)V", "s", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "", x5.d.EXTRA_ENABLED, "Z", "", "MAX", "I", "Ljava/text/SimpleDateFormat;", "ts", "Ljava/text/SimpleDateFormat;", "Ljava/util/ArrayDeque;", "buffer", "Ljava/util/ArrayDeque;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class r {
    private static final int MAX = 80;
    public static boolean enabled;
    public static final r INSTANCE = new r();
    private static final SimpleDateFormat ts = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
    private static final ArrayDeque<Entry> buffer = new ArrayDeque<>();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/r$a;", "", "", "fileId", "mime", "fileName", "fileStatus", "", ContentDisposition.Parameters.Size, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "J", "e", "()J", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.r$a, reason: from toString */
    public static final /* data */ class AttachmentDump {
        private final String fileId;
        private final String fileName;
        private final String fileStatus;
        private final String mime;
        private final long size;

        public AttachmentDump(String str, String str2, String str3, String str4, long j10) {
            this.fileId = str;
            this.mime = str2;
            this.fileName = str3;
            this.fileStatus = str4;
            this.size = j10;
        }

        /* renamed from: a, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: b, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: c, reason: from getter */
        public final String getFileStatus() {
            return this.fileStatus;
        }

        /* renamed from: d, reason: from getter */
        public final String getMime() {
            return this.mime;
        }

        /* renamed from: e, reason: from getter */
        public final long getSize() {
            return this.size;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttachmentDump)) {
                return false;
            }
            AttachmentDump attachmentDump = (AttachmentDump) other;
            return kotlin.jvm.internal.p.d(this.fileId, attachmentDump.fileId) && kotlin.jvm.internal.p.d(this.mime, attachmentDump.mime) && kotlin.jvm.internal.p.d(this.fileName, attachmentDump.fileName) && kotlin.jvm.internal.p.d(this.fileStatus, attachmentDump.fileStatus) && this.size == attachmentDump.size;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.mime;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.fileName;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.fileStatus;
            return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Long.hashCode(this.size);
        }

        public String toString() {
            return "AttachmentDump(fileId=" + this.fileId + ", mime=" + this.mime + ", fileName=" + this.fileName + ", fileStatus=" + this.fileStatus + ", size=" + this.size + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/r$b;", "", "", o0.TRACK_STATUS_TERMINAL, "hasAttachment", "", "text", "<init>", "(ZZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.r$b, reason: from toString */
    public static final /* data */ class Entry {
        private final boolean hasAttachment;
        private final boolean terminal;
        private final String text;

        public Entry(boolean z10, boolean z11, String text) {
            kotlin.jvm.internal.p.i(text, "text");
            this.terminal = z10;
            this.hasAttachment = z11;
            this.text = text;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasAttachment() {
            return this.hasAttachment;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getTerminal() {
            return this.terminal;
        }

        /* renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return this.terminal == entry.terminal && this.hasAttachment == entry.hasAttachment && kotlin.jvm.internal.p.d(this.text, entry.text);
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.terminal) * 31) + Boolean.hashCode(this.hasAttachment)) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Entry(terminal=" + this.terminal + ", hasAttachment=" + this.hasAttachment + ", text=" + this.text + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/r$c;", "", "", "name", "toolId", "args", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.r$c, reason: from toString */
    public static final /* data */ class ToolCallDump {
        private final String args;
        private final String name;
        private final String toolId;

        public ToolCallDump(String str, String str2, String str3) {
            this.name = str;
            this.toolId = str2;
            this.args = str3;
        }

        /* renamed from: a, reason: from getter */
        public final String getArgs() {
            return this.args;
        }

        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: c, reason: from getter */
        public final String getToolId() {
            return this.toolId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolCallDump)) {
                return false;
            }
            ToolCallDump toolCallDump = (ToolCallDump) other;
            return kotlin.jvm.internal.p.d(this.name, toolCallDump.name) && kotlin.jvm.internal.p.d(this.toolId, toolCallDump.toolId) && kotlin.jvm.internal.p.d(this.args, toolCallDump.args);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.toolId;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.args;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "ToolCallDump(name=" + this.name + ", toolId=" + this.toolId + ", args=" + this.args + ")";
        }
    }

    public final void a(Entry e10) {
        buffer.addFirst(e10);
        while (true) {
            ArrayDeque<Entry> arrayDeque = buffer;
            if (arrayDeque.size() <= 80) {
                return;
            } else {
                arrayDeque.removeLast();
            }
        }
    }

    public final synchronized void b(String sessionId, String replyTo, String role, String messagePartial, String delta, String content, List<ToolCallDump> toolCalls, List<AttachmentDump> attachments, Map<String, String> metadata) {
        String str = messagePartial;
        synchronized (this) {
            try {
                kotlin.jvm.internal.p.i(toolCalls, "toolCalls");
                kotlin.jvm.internal.p.i(attachments, "attachments");
                kotlin.jvm.internal.p.i(metadata, "metadata");
                if (enabled) {
                    boolean zD = kotlin.jvm.internal.p.d(str, "false");
                    if (zD) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("【");
                        sb2.append(ts.format(new Date()));
                        sb2.append("】 ");
                        sb2.append("◀ 终帧");
                        sb2.append("  role=");
                        sb2.append(role == null ? O6.l.DATE_SEPARATOR : role);
                        sb2.append(" partial=");
                        if (str == null) {
                            str = O6.l.DATE_SEPARATOR;
                        }
                        sb2.append(str);
                        sb2.append('\n');
                        sb2.append("📍SID: ");
                        sb2.append(sessionId == null ? O6.l.DATE_SEPARATOR : sessionId);
                        sb2.append('\n');
                        sb2.append("reply=");
                        sb2.append(d(replyTo));
                        sb2.append('\n');
                        if (delta != null && delta.length() != 0) {
                            sb2.append("delta=");
                            sb2.append(K.R1(delta, 500));
                            sb2.append('\n');
                        }
                        if (content != null && content.length() != 0) {
                            sb2.append("content=");
                            sb2.append(K.R1(content, 1500));
                            sb2.append('\n');
                        }
                        if (!toolCalls.isEmpty()) {
                            sb2.append("toolCalls(");
                            sb2.append(toolCalls.size());
                            sb2.append("):\n");
                            for (ToolCallDump toolCallDump : toolCalls) {
                                sb2.append("  · name=");
                                sb2.append(toolCallDump.getName());
                                sb2.append(" id=");
                                sb2.append(toolCallDump.getToolId());
                                String args = toolCallDump.getArgs();
                                if (args != null && args.length() != 0) {
                                    sb2.append(" args=");
                                    sb2.append(K.R1(toolCallDump.getArgs(), 600));
                                }
                                sb2.append('\n');
                            }
                        }
                        if (!attachments.isEmpty()) {
                            sb2.append("attachments(");
                            sb2.append(attachments.size());
                            sb2.append("):\n");
                            int i10 = 0;
                            for (Object obj : attachments) {
                                int i11 = i10 + 1;
                                if (i10 < 0) {
                                    C1173v.w();
                                }
                                AttachmentDump attachmentDump = (AttachmentDump) obj;
                                sb2.append("  [");
                                sb2.append(i10);
                                sb2.append("] fileId=");
                                sb2.append(attachmentDump.getFileId());
                                sb2.append(" mime=");
                                sb2.append(attachmentDump.getMime());
                                sb2.append(" name=");
                                sb2.append(attachmentDump.getFileName());
                                sb2.append(" status=");
                                sb2.append(attachmentDump.getFileStatus());
                                sb2.append(" size=");
                                sb2.append(attachmentDump.getSize());
                                sb2.append('\n');
                                i10 = i11;
                            }
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<String, String> entry : metadata.entrySet()) {
                            if (Y.j("approval", "reasoning", "code", "error_message", "request_id", "seq_no", "message_partial").contains(entry.getKey())) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        if (!linkedHashMap.isEmpty()) {
                            sb2.append("meta=");
                            sb2.append(K.R1(linkedHashMap.toString(), 600));
                            sb2.append('\n');
                        }
                        boolean z10 = !attachments.isEmpty();
                        String string = sb2.toString();
                        kotlin.jvm.internal.p.h(string, "toString(...)");
                        a(new Entry(zD, z10, string));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void c(String query, String response) {
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(response, "response");
        if (enabled) {
            String str = "【" + ts.format(new Date()) + "】 ⇄ GetFileSync\n→ " + K.R1(query, 600) + "\n← " + K.R1(response, 1500) + '\n';
            kotlin.jvm.internal.p.h(str, "toString(...)");
            a(new Entry(false, true, str));
        }
    }

    public final String d(String s10) {
        if (s10 == null || H.x0(s10)) {
            return O6.l.DATE_SEPARATOR;
        }
        if (s10.length() <= 12) {
            return s10;
        }
        return "…" + K.S1(s10, 10);
    }

    public final synchronized List<Entry> e() {
        return F.m1(buffer);
    }
}
