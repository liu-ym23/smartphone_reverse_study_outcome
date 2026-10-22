package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.FolderNode;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\n*\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u000f0\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionArtifactSource;", "", "<init>", "()V", "", "", "keys", "Lcom/stepos/ailauncher/chat/view/SessionArtifactSource$a;", "c", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "Lu4/m$d;", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "products", Const.INTENT_KEY_UMID, "(Lu4/m$d;Ljava/util/List;)Lu4/m$d;", "LK6/t;", "", "into", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Ljava/util/Set;)V", "TAG", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionArtifactSource {
    public static final SessionArtifactSource INSTANCE = new SessionArtifactSource();
    private static final String TAG = "SessionArtifactSource";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionArtifactSource$a;", "", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "products", "Lu4/m$d;", "fileTree", "<init>", "(Ljava/util/List;Lu4/m$d;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Lu4/m$d;", Const.INTENT_KEY_APIKEY, "()Lu4/m$d;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.SessionArtifactSource$a, reason: from toString */
    public static final /* data */ class Result {
        private final m.FolderMessage fileTree;
        private final List<SessionArtifact> products;

        public Result(List<SessionArtifact> products, m.FolderMessage folderMessage) {
            kotlin.jvm.internal.p.i(products, "products");
            this.products = products;
            this.fileTree = folderMessage;
        }

        /* renamed from: a, reason: from getter */
        public final m.FolderMessage getFileTree() {
            return this.fileTree;
        }

        public final List<SessionArtifact> b() {
            return this.products;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return kotlin.jvm.internal.p.d(this.products, result.products) && kotlin.jvm.internal.p.d(this.fileTree, result.fileTree);
        }

        public int hashCode() {
            int iHashCode = this.products.hashCode() * 31;
            m.FolderMessage folderMessage = this.fileTree;
            return iHashCode + (folderMessage == null ? 0 : folderMessage.hashCode());
        }

        public String toString() {
            return "Result(products=" + this.products + ", fileTree=" + this.fileTree + ")";
        }
    }

    public final void b(List<FolderNode> list, Set<String> set) {
        for (FolderNode folderNode : list) {
            String fileId = folderNode.getFileId();
            if (fileId != null) {
                if (La.H.x0(fileId)) {
                    fileId = null;
                }
                if (fileId != null) {
                    set.add(fileId);
                }
            }
            List<FolderNode> listC = folderNode.c();
            if (listC != null) {
                INSTANCE.b(listC, set);
            }
        }
    }

    public final Object c(List<String> list, InterfaceC4014c<? super Result> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new SessionArtifactSource$load$2(list, null), interfaceC4014c);
    }

    public final m.FolderMessage d(m.FolderMessage folderMessage, List<SessionArtifact> list) {
        if (list.isEmpty()) {
            return folderMessage;
        }
        HashSet hashSet = new HashSet();
        INSTANCE.b(folderMessage.n(), hashSet);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            FolderNode folderNode = null;
            if (!it.hasNext()) {
                break;
            }
            SessionArtifact sessionArtifact = (SessionArtifact) it.next();
            String fileId = sessionArtifact.getFileId();
            if (fileId != null) {
                String str = (La.H.x0(fileId) || !hashSet.add(fileId)) ? null : fileId;
                if (str != null) {
                    folderNode = new FolderNode(sessionArtifact.getName(), null, str, sessionArtifact.getMimeType(), sessionArtifact.getFileName(), 2, null);
                }
            }
            if (folderNode != null) {
                arrayList.add(folderNode);
            }
        }
        return arrayList.isEmpty() ? folderMessage : m.FolderMessage.l(folderMessage, null, Z8.F.S0(folderMessage.n(), arrayList), 1, null);
    }
}
