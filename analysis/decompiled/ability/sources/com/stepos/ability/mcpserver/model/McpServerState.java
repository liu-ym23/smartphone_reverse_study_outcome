package com.stepos.ability.mcpserver.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpServerState;", "", "NotStarted", "Running", "Failed", "Lcom/stepos/ability/mcpserver/model/McpServerState$Failed;", "Lcom/stepos/ability/mcpserver/model/McpServerState$NotStarted;", "Lcom/stepos/ability/mcpserver/model/McpServerState$Running;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface McpServerState {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpServerState$Failed;", "Lcom/stepos/ability/mcpserver/model/McpServerState;", "reason", "", "portInUse", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Z)V", "getReason", "()Ljava/lang/String;", "getPortInUse", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed implements McpServerState {
        private final boolean portInUse;
        private final String reason;

        public Failed(String reason, boolean z10) {
            k.f(reason, "reason");
            this.reason = reason;
            this.portInUse = z10;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.reason;
            }
            if ((i & 2) != 0) {
                z10 = failed.portInUse;
            }
            return failed.copy(str, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPortInUse() {
            return this.portInUse;
        }

        public final Failed copy(String reason, boolean portInUse) {
            k.f(reason, "reason");
            return new Failed(reason, portInUse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return k.b(this.reason, failed.reason) && this.portInUse == failed.portInUse;
        }

        public final boolean getPortInUse() {
            return this.portInUse;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return Boolean.hashCode(this.portInUse) + (this.reason.hashCode() * 31);
        }

        public String toString() {
            return "Failed(reason=" + this.reason + ", portInUse=" + this.portInUse + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpServerState$NotStarted;", "Lcom/stepos/ability/mcpserver/model/McpServerState;", AppAgent.CONSTRUCT, "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotStarted implements McpServerState {
        public static final NotStarted INSTANCE = new NotStarted();

        private NotStarted() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof NotStarted);
        }

        public int hashCode() {
            return 2095907709;
        }

        public String toString() {
            return "NotStarted";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpServerState$Running;", "Lcom/stepos/ability/mcpserver/model/McpServerState;", "port", "", AppAgent.CONSTRUCT, "(I)V", "getPort", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Running implements McpServerState {
        private final int port;

        public Running(int i) {
            this.port = i;
        }

        public static /* synthetic */ Running copy$default(Running running, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = running.port;
            }
            return running.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        public final Running copy(int port) {
            return new Running(port);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Running) && this.port == ((Running) other).port;
        }

        public final int getPort() {
            return this.port;
        }

        public int hashCode() {
            return Integer.hashCode(this.port);
        }

        public String toString() {
            return a.i(this.port, "Running(port=", ")");
        }
    }
}
