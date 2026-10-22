package com.bytedance.ai.bridge.method.calendar.remote;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35389a = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "Ljava/io/Serializable;", "namespace", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getName", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NodeInfo implements Serializable {
        private final String name;
        private final String namespace;

        public static /* synthetic */ NodeInfo copy$default(NodeInfo r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.namespace;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.name;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.namespace;
        }

        public final String component2() {
            return this.name;
        }

        public final NodeInfo copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "namespace");
            Intrinsics.checkNotNullParameter(r101, "name");
            return new NodeInfo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NodeInfo) == true) goto L8;
            return false;
        L8:
            NodeInfo r101 = (NodeInfo) r100;
            if (Intrinsics.areEqual(this.namespace, r101.namespace) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.namespace.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return this.namespace + ':' + this.name;
        }

        public final String getName() {
            return this.name;
        }

        public final String getNamespace() {
            return this.namespace;
        }

        public NodeInfo(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "namespace");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.namespace = r100;
            this.name = r101;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f35390a = null;

        static {
            f35390a = new a();
        }

        public a() {
        }
    }

    static {
        f35389a = a.f35390a;
    }
}
