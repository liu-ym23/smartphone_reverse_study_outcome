package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJP\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u000eR\u0011\u0010 \u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"LK6/t;", "", "", "name", "", "children", "fileId", "mime", "fileName", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LK6/t;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "Ljava/util/List;", "c", "()Ljava/util/List;", Const.INTENT_KEY_UMID, "getMime", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "isFolder", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.t, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FolderNode {
    private final List<FolderNode> children;
    private final String fileId;
    private final String fileName;
    private final String mime;
    private final String name;

    public FolderNode() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FolderNode b(FolderNode folderNode, String str, List list, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = folderNode.name;
        }
        if ((i10 & 2) != 0) {
            list = folderNode.children;
        }
        if ((i10 & 4) != 0) {
            str2 = folderNode.fileId;
        }
        if ((i10 & 8) != 0) {
            str3 = folderNode.mime;
        }
        if ((i10 & 16) != 0) {
            str4 = folderNode.fileName;
        }
        String str5 = str4;
        String str6 = str2;
        return folderNode.a(str, list, str6, str3, str5);
    }

    public final FolderNode a(String name, List<FolderNode> children, String fileId, String mime, String fileName) {
        p.i(name, "name");
        return new FolderNode(name, children, fileId, mime, fileName);
    }

    public final List<FolderNode> c() {
        return this.children;
    }

    /* renamed from: d, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: e, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderNode)) {
            return false;
        }
        FolderNode folderNode = (FolderNode) other;
        return p.d(this.name, folderNode.name) && p.d(this.children, folderNode.children) && p.d(this.fileId, folderNode.fileId) && p.d(this.mime, folderNode.mime) && p.d(this.fileName, folderNode.fileName);
    }

    /* renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final boolean g() {
        String str = this.fileId;
        return str == null || str.length() == 0;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        List<FolderNode> list = this.children;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.fileId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mime;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileName;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "FolderNode(name=" + this.name + ", children=" + this.children + ", fileId=" + this.fileId + ", mime=" + this.mime + ", fileName=" + this.fileName + ")";
    }

    public FolderNode(String name, List<FolderNode> list, String str, String str2, String str3) {
        p.i(name, "name");
        this.name = name;
        this.children = list;
        this.fileId = str;
        this.mime = str2;
        this.fileName = str3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ FolderNode(java.lang.String r2, java.util.List r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.i r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Lc
            r3 = r0
        Lc:
            r8 = r7 & 4
            if (r8 == 0) goto L11
            r4 = r0
        L11:
            r8 = r7 & 8
            if (r8 == 0) goto L16
            r5 = r0
        L16:
            r7 = r7 & 16
            if (r7 == 0) goto L21
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L27
        L21:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L27:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.FolderNode.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
