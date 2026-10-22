package com.stepos.ailauncher.express.screenops;

import Ua.C1056g;
import Ua.Y;
import W3.EditTextNode;
import W3.SetTextTarget;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/express/screenops/ScreenOpsRepository;", "", "<init>", "()V", "", "packageName", "Lcom/stepos/ailauncher/express/screenops/ScreenOpsRepository$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "LW3/h;", "targets", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsRepository {
    public static final ScreenOpsRepository INSTANCE = new ScreenOpsRepository();
    private static final String TAG = "ScreenOpsRepo";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/express/screenops/ScreenOpsRepository$a;", "", "", "LW3/a;", "nodes", "", "extra", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.screenops.ScreenOpsRepository$a, reason: from toString */
    public static final /* data */ class Snapshot {
        private final String extra;
        private final List<EditTextNode> nodes;

        public Snapshot(List<EditTextNode> nodes, String extra) {
            p.i(nodes, "nodes");
            p.i(extra, "extra");
            this.nodes = nodes;
            this.extra = extra;
        }

        /* renamed from: a, reason: from getter */
        public final String getExtra() {
            return this.extra;
        }

        public final List<EditTextNode> b() {
            return this.nodes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return p.d(this.nodes, snapshot.nodes) && p.d(this.extra, snapshot.extra);
        }

        public int hashCode() {
            return (this.nodes.hashCode() * 31) + this.extra.hashCode();
        }

        public String toString() {
            return "Snapshot(nodes=" + this.nodes + ", extra=" + this.extra + ")";
        }
    }

    public final Object a(String str, InterfaceC4014c<? super Snapshot> interfaceC4014c) {
        return C1056g.j(Y.b(), new ScreenOpsRepository$getSnapshot$2(str, null), interfaceC4014c);
    }

    public final Object b(List<SetTextTarget> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new ScreenOpsRepository$setEditTexts$2(list, null), interfaceC4014c);
    }
}
