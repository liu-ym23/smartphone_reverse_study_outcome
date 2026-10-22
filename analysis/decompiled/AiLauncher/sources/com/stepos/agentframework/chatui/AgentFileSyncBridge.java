package com.stepos.agentframework.chatui;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002#\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R<\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rRF\u0010\u0012\u001a \b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010\t\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rRH\u0010\u0016\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0016\u0010\t\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rRJ\u0010\u001c\u001a$\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/chatui/AgentFileSyncBridge;", "", "<init>", "()V", "Lkotlin/Function2;", "Landroid/content/Context;", "Lu4/m$d;", "", "folderTreeLauncher", "Lp9/p;", Const.INTENT_KEY_PKGNAME, "()Lp9/p;", "f", "(Lp9/p;)V", "getFolderTreeLauncher$annotations", "", "Le9/c;", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", "fetcher", Const.INTENT_KEY_APIKEY, "e", "getFetcher$annotations", "urlFetcher", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getUrlFetcher$annotations", "Lkotlin/Function4;", "LY8/t;", "previewLauncher", "Lp9/r;", "c", "()Lp9/r;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/r;)V", "getPreviewLauncher$annotations", "Status", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentFileSyncBridge {
    public static final AgentFileSyncBridge INSTANCE = new AgentFileSyncBridge();
    private static p9.p<? super String, ? super InterfaceC4014c<? super Result>, ? extends Object> fetcher;
    private static p9.p<? super Context, ? super m.FolderMessage, Boolean> folderTreeLauncher;
    private static p9.r<? super Context, ? super Result, ? super String, ? super String, Y8.t> previewLauncher;
    private static p9.p<? super String, ? super InterfaceC4014c<? super String>, ? extends Object> urlFetcher;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$Status;", "", "<init>", "(Ljava/lang/String;I)V", "SYNCING", "READY", "FAILED", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status SYNCING = new Status("SYNCING", 0);
        public static final Status READY = new Status("READY", 1);
        public static final Status FAILED = new Status("FAILED", 2);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SYNCING, READY, FAILED};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = kotlin.enums.a.a(statusArr$values);
        }

        private Status(String str, int i10) {
        }

        public static InterfaceC4149a<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public static final p9.p<String, InterfaceC4014c<? super Result>, Object> a() {
        return fetcher;
    }

    public static final p9.p<Context, m.FolderMessage, Boolean> b() {
        return folderTreeLauncher;
    }

    public static final p9.r<Context, Result, String, String, Y8.t> c() {
        return previewLauncher;
    }

    public static final p9.p<String, InterfaceC4014c<? super String>, Object> d() {
        return urlFetcher;
    }

    public static final void e(p9.p<? super String, ? super InterfaceC4014c<? super Result>, ? extends Object> pVar) {
        fetcher = pVar;
    }

    public static final void f(p9.p<? super Context, ? super m.FolderMessage, Boolean> pVar) {
        folderTreeLauncher = pVar;
    }

    public static final void g(p9.r<? super Context, ? super Result, ? super String, ? super String, Y8.t> rVar) {
        previewLauncher = rVar;
    }

    public static final void h(p9.p<? super String, ? super InterfaceC4014c<? super String>, ? extends Object> pVar) {
        urlFetcher = pVar;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b \u0010\u0011R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b$\u0010\u0011R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b%\u0010\u0011R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b&\u0010\u0011¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", "", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$Status;", "status", "", "fileName", "markdownText", "url", "mime", "", ContentDisposition.Parameters.Size, "fileId", "tosFileId", "previewUrl", "<init>", "(Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$Status;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$Status;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$Status;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.AgentFileSyncBridge$a, reason: from toString */
    public static final /* data */ class Result {
        private final String fileId;
        private final String fileName;
        private final String markdownText;
        private final String mime;
        private final String previewUrl;
        private final Long size;
        private final Status status;
        private final String tosFileId;
        private final String url;

        public Result(Status status, String str, String str2, String str3, String str4, Long l10, String str5, String str6, String str7) {
            kotlin.jvm.internal.p.i(status, "status");
            this.status = status;
            this.fileName = str;
            this.markdownText = str2;
            this.url = str3;
            this.mime = str4;
            this.size = l10;
            this.fileId = str5;
            this.tosFileId = str6;
            this.previewUrl = str7;
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
        public final String getMarkdownText() {
            return this.markdownText;
        }

        /* renamed from: d, reason: from getter */
        public final String getMime() {
            return this.mime;
        }

        /* renamed from: e, reason: from getter */
        public final String getPreviewUrl() {
            return this.previewUrl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.status == result.status && kotlin.jvm.internal.p.d(this.fileName, result.fileName) && kotlin.jvm.internal.p.d(this.markdownText, result.markdownText) && kotlin.jvm.internal.p.d(this.url, result.url) && kotlin.jvm.internal.p.d(this.mime, result.mime) && kotlin.jvm.internal.p.d(this.size, result.size) && kotlin.jvm.internal.p.d(this.fileId, result.fileId) && kotlin.jvm.internal.p.d(this.tosFileId, result.tosFileId) && kotlin.jvm.internal.p.d(this.previewUrl, result.previewUrl);
        }

        /* renamed from: f, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        /* renamed from: g, reason: from getter */
        public final Status getStatus() {
            return this.status;
        }

        /* renamed from: h, reason: from getter */
        public final String getTosFileId() {
            return this.tosFileId;
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            String str = this.fileName;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.markdownText;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.url;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.mime;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Long l10 = this.size;
            int iHashCode6 = (iHashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31;
            String str5 = this.fileId;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.tosFileId;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.previewUrl;
            return iHashCode8 + (str7 != null ? str7.hashCode() : 0);
        }

        /* renamed from: i, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public String toString() {
            return "Result(status=" + this.status + ", fileName=" + this.fileName + ", markdownText=" + this.markdownText + ", url=" + this.url + ", mime=" + this.mime + ", size=" + this.size + ", fileId=" + this.fileId + ", tosFileId=" + this.tosFileId + ", previewUrl=" + this.previewUrl + ")";
        }

        public /* synthetic */ Result(Status status, String str, String str2, String str3, String str4, Long l10, String str5, String str6, String str7, int i10, kotlin.jvm.internal.i iVar) {
            this(status, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : l10, (i10 & 64) != 0 ? null : str5, (i10 & 128) != 0 ? null : str6, (i10 & 256) != 0 ? null : str7);
        }
    }
}
