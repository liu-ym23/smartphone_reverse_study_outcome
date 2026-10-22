package com.stepos.ailauncher.task.detail.render;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import h9.InterfaceC4149a;
import java.util.Set;
import kotlin.Metadata;
import u6.C5578a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind$Kind;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind$Kind;", "", "c", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/lang/String;", "f", "mimeType", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "fileName", "mime", "e", "(Ljava/lang/String;)Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind$Kind;", "ext", Const.INTENT_KEY_PKGNAME, "", "PREVIEWABLE_DOC_EXTS", "Ljava/util/Set;", "IMAGE_EXTS", "getIMAGE_EXTS", "()Ljava/util/Set;", "CODE_EXTS", "Kind", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactRenderKind {
    public static final ArtifactRenderKind INSTANCE = new ArtifactRenderKind();
    private static final Set<String> PREVIEWABLE_DOC_EXTS = Y.j("pptx", ChatTracker.CONTENT_PPT, ChatTracker.CONTENT_DOC, "docx", "xls", "xlsx", "xlsm", "pdf");
    private static final Set<String> IMAGE_EXTS = Y.j("png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp", "svg", "heic", "heif", "avif");
    private static final Set<String> CODE_EXTS = Y.j("py", "js", "jsx", "mjs", "cjs", "ts", "tsx", "mts", "cts", "java", "kt", "kts", "go", "rs", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "cpp", "cc", "cxx", "hpp", "hxx", "cs", "swift", "rb", "php", "sh", "bash", "zsh", "fish", "sql", "json", "yaml", "yml", "toml", "ini", "cfg", "conf", "css", "scss", "sass", "less", "pl", "pm", "lua", "scala", "dart");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/task/detail/render/ArtifactRenderKind$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "HTML", "IMAGE", "FILE", "CODE", "FALLBACK", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Kind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind TEXT = new Kind("TEXT", 0);
        public static final Kind HTML = new Kind("HTML", 1);
        public static final Kind IMAGE = new Kind("IMAGE", 2);
        public static final Kind FILE = new Kind("FILE", 3);
        public static final Kind CODE = new Kind("CODE", 4);
        public static final Kind FALLBACK = new Kind("FALLBACK", 5);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{TEXT, HTML, IMAGE, FILE, CODE, FALLBACK};
        }

        static {
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = kotlin.enums.a.a(kindArr$values);
        }

        private Kind(String str, int i10) {
        }

        public static InterfaceC4149a<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0181 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.render.ArtifactRenderKind.a(java.lang.String):java.lang.String");
    }

    public final Kind b(String ext) {
        if (IMAGE_EXTS.contains(ext)) {
            return Kind.IMAGE;
        }
        if (kotlin.jvm.internal.p.d(ext, "html") || kotlin.jvm.internal.p.d(ext, "htm")) {
            return Kind.HTML;
        }
        if (kotlin.jvm.internal.p.d(ext, "md") || kotlin.jvm.internal.p.d(ext, "markdown") || kotlin.jvm.internal.p.d(ext, "txt")) {
            return Kind.TEXT;
        }
        if (CODE_EXTS.contains(ext)) {
            return Kind.CODE;
        }
        if (kotlin.jvm.internal.p.d(ext, "pdf") || PREVIEWABLE_DOC_EXTS.contains(ext)) {
            return Kind.FILE;
        }
        return null;
    }

    public final String c(SessionArtifact a10) {
        kotlin.jvm.internal.p.i(a10, "a");
        return u6.j.INSTANCE.e(a10.getMimeType(), a10.getFileName(), a10.getTitle(), a10.getCloudPath());
    }

    public final String d(String mimeType) {
        return u6.j.INSTANCE.g(mimeType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x011d, code lost:
    
        if (com.stepos.ailauncher.task.detail.render.ArtifactRenderKind.PREVIEWABLE_DOC_EXTS.contains(r4) == true) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.task.detail.render.ArtifactRenderKind.Kind e(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.render.ArtifactRenderKind.e(java.lang.String):com.stepos.ailauncher.task.detail.render.ArtifactRenderKind$Kind");
    }

    public final String f(SessionArtifact a10) {
        kotlin.jvm.internal.p.i(a10, "a");
        return u6.j.INSTANCE.i(a10.getFileName(), a10.getTitle(), a10.getCloudPath());
    }

    public final Kind g(SessionArtifact a10) {
        Kind kind;
        kotlin.jvm.internal.p.i(a10, "a");
        String strJ = u6.j.INSTANCE.j(a10.getMimeType());
        Kind kindE = strJ != null ? INSTANCE.e(strJ) : null;
        String strF = f(a10);
        Kind kindB = strF != null ? INSTANCE.b(strF) : null;
        Kind kind2 = Kind.HTML;
        if (kindE == kind2) {
            return kind2;
        }
        Kind kind3 = Kind.IMAGE;
        if (kindE == kind3) {
            return kind3;
        }
        Kind kind4 = Kind.FILE;
        if (kindE == kind4) {
            return kind4;
        }
        Kind kind5 = Kind.CODE;
        if (kindE == kind5 || (kindE == (kind = Kind.TEXT) && kindB == kind5)) {
            return kind5;
        }
        if (kindE == kind) {
            return kind;
        }
        if (kindB != null) {
            return kindB;
        }
        if (kindE != null) {
            return kindE;
        }
        String fileId = a10.getFileId();
        return (fileId == null || La.H.x0(fileId)) ? Kind.FALLBACK : kind4;
    }
}
