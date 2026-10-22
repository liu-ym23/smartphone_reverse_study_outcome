package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingInput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetH5InitTime;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetH5InitTime$GetH5InitTimeOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetH5InitTimeOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbGetH5InitTime extends AbsJSBMethod<NothingInput, GetH5InitTimeOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetH5InitTime$GetH5InitTimeOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "time", "", "timestamp", "timestamp_on_create", "timestamp_load_url", "timestamp_load_resource", "timestamp_on_page_started", "(JJJJJJ)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetH5InitTimeOutput extends JSBBaseOutput {
        public long time;
        public long timestamp;
        public long timestamp_load_resource;
        public long timestamp_load_url;
        public long timestamp_on_create;
        public long timestamp_on_page_started;

        public GetH5InitTimeOutput() {
            this(0, 0, 0, 0, 0, 0, 63, null);
        }

        public GetH5InitTimeOutput(long r100, long r101, long r102, long r103, long r104, long r110) {
            this.time = r100;
            this.timestamp = r101;
            this.timestamp_on_create = r102;
            this.timestamp_load_url = r103;
            this.timestamp_load_resource = r104;
            this.timestamp_on_page_started = r110;
        }

        public /* synthetic */ GetH5InitTimeOutput(long r110, long r111, long r112, long r210, long r211, long r212, int r213, DefaultConstructorMarker r214) {
            long r100 = 0;
            if ((r213 & 1) == 0) goto L5;
            long r101 = 0;
        L7:
            if ((r213 & 2) == 0) goto L9;
            long r102 = 0;
        L11:
            if ((r213 & 4) == 0) goto L13;
            long r103 = 0;
        L15:
            if ((r213 & 8) == 0) goto L17;
            long r104 = 0;
        L19:
            if ((r213 & 16) == 0) goto L21;
            long r113 = 0;
        L23:
            if ((r213 & 32) != 0) goto L26;
            r100 = r212;
        L26:
            this(r101, r102, r103, r104, r113, r100);
            return;
        L21:
            r113 = r211;
            goto L23
        L17:
            r104 = r210;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    public AbsJsbGetH5InitTime() {
        this.name = "ttcjpay.getH5InitTime";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
