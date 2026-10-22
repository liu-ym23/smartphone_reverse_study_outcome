package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u000b\f\r\u000e\u000f\u0010\u0011B\u0011\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "", "", "toString", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "Lcom/bytedance/android/live/profit/redpacket/n0;", "getInfo", "()Lcom/bytedance/android/live/profit/redpacket/n0;", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "Available", "Disposed", "Empty", "Expired", "Rushed", "Rushing", "Waiting", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Available;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Disposed;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Empty;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Expired;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Rushed;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Rushing;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Waiting;", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class RedPacketState {
    private final n0 info;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Available;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Available extends RedPacketState {
        public Available(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Disposed;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Disposed extends RedPacketState {
        public Disposed(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Empty;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Empty extends RedPacketState {
        public Empty(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Expired;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Expired extends RedPacketState {
        public Expired(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Rushed;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "result", "Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "getResult", "()Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Rushed extends RedPacketState {
        private final RedPacketRushResult result;

        public final RedPacketRushResult getResult() {
            return this.result;
        }

        public Rushed(n0 r100, RedPacketRushResult r101) {
            Intrinsics.checkNotNullParameter(r100, "info");
            Intrinsics.checkNotNullParameter(r101, "result");
            super(r100, null);
            this.result = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Rushing;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Rushing extends RedPacketState {
        public Rushing(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketState$Waiting;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketState;", "Lcom/bytedance/android/live/profit/redpacket/n0;", "info", "<init>", "(Lcom/bytedance/android/live/profit/redpacket/n0;)V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Waiting extends RedPacketState {
        public Waiting(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(r100, null);
        }
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.info + ')';
    }

    public final n0 getInfo() {
        return this.info;
    }

    private RedPacketState(n0 r100) {
        this.info = r100;
    }

    public /* synthetic */ RedPacketState(n0 r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
