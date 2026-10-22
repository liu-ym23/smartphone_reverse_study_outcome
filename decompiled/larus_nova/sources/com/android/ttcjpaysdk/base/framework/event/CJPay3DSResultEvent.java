package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPay3DSResultEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "status", "Lcom/android/ttcjpaysdk/base/framework/event/CJPay3DSResultEvent$Status;", "token", "", "(Lcom/android/ttcjpaysdk/base/framework/event/CJPay3DSResultEvent$Status;I)V", "Status", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPay3DSResultEvent extends BaseEvent {
    public Status status;
    public int token;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPay3DSResultEvent$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Cancel", "Success", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Cancel = null;
        public static final Status Success = null;
        private final String code;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Cancel, Success};
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            Cancel = new Status("Cancel", 0, "0");
            Success = new Status("Success", 1, "1");
            $VALUES = $values();
        }

        public final String getCode() {
            return this.code;
        }

        private Status(String r100, int r101, String r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public CJPay3DSResultEvent(Status r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.status = r100;
        this.token = r101;
    }
}
