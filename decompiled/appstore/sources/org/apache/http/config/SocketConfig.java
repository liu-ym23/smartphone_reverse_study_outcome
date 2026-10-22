package org.apache.http.config;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class SocketConfig implements Cloneable {
    public static final SocketConfig DEFAULT = null;
    private final int backlogSize;
    private final int rcvBufSize;
    private final int sndBufSize;
    private final boolean soKeepAlive;
    private final int soLinger;
    private final boolean soReuseAddress;
    private final int soTimeout;
    private final boolean tcpNoDelay;

    public static class Builder {
        private int backlogSize;
        private int rcvBufSize;
        private int sndBufSize;
        private boolean soKeepAlive;
        private int soLinger;
        private boolean soReuseAddress;
        private int soTimeout;
        private boolean tcpNoDelay;

        public Builder() {
            this.soLinger = -1;
            this.tcpNoDelay = true;
        }

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
        }

        public Builder setBacklogSize(int r10) {
            this.backlogSize = r10;
            return this;
        }

        public Builder setRcvBufSize(int r10) {
            this.rcvBufSize = r10;
            return this;
        }

        public Builder setSndBufSize(int r10) {
            this.sndBufSize = r10;
            return this;
        }

        public Builder setSoKeepAlive(boolean r10) {
            this.soKeepAlive = r10;
            return this;
        }

        public Builder setSoLinger(int r10) {
            this.soLinger = r10;
            return this;
        }

        public Builder setSoReuseAddress(boolean r10) {
            this.soReuseAddress = r10;
            return this;
        }

        public Builder setSoTimeout(int r10) {
            this.soTimeout = r10;
            return this;
        }

        public Builder setTcpNoDelay(boolean r10) {
            this.tcpNoDelay = r10;
            return this;
        }
    }

    static {
        DEFAULT = new Builder().build();
    }

    public SocketConfig(int r10, boolean r11, int r12, boolean r13, boolean r14, int r15, int r16, int r17) {
        this.soTimeout = r10;
        this.soReuseAddress = r11;
        this.soLinger = r12;
        this.soKeepAlive = r13;
        this.tcpNoDelay = r14;
        this.sndBufSize = r15;
        this.rcvBufSize = r16;
        this.backlogSize = r17;
    }

    public static Builder copy(SocketConfig r10) {
        Args.notNull(r10, "Socket config");
        return new Builder().setSoTimeout(r10.getSoTimeout()).setSoReuseAddress(r10.isSoReuseAddress()).setSoLinger(r10.getSoLinger()).setSoKeepAlive(r10.isSoKeepAlive()).setTcpNoDelay(r10.isTcpNoDelay()).setSndBufSize(r10.getSndBufSize()).setRcvBufSize(r10.getRcvBufSize()).setBacklogSize(r10.getBacklogSize());
    }

    public static Builder custom() {
        return new Builder();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m62clone();
    }

    public int getBacklogSize() {
        return this.backlogSize;
    }

    public int getRcvBufSize() {
        return this.rcvBufSize;
    }

    public int getSndBufSize() {
        return this.sndBufSize;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public String toString() {
        return "[soTimeout=" + this.soTimeout + ", soReuseAddress=" + this.soReuseAddress + ", soLinger=" + this.soLinger + ", soKeepAlive=" + this.soKeepAlive + ", tcpNoDelay=" + this.tcpNoDelay + ", sndBufSize=" + this.sndBufSize + ", rcvBufSize=" + this.rcvBufSize + ", backlogSize=" + this.backlogSize + "]";
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public SocketConfig m62clone() throws CloneNotSupportedException {
        return (SocketConfig) super.clone();
    }
}
