package com.android.ttcjpaysdk.integrated.counter.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingInput;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/jsb/abs/AbsJsbPayInfo;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingInput;", "Lcom/android/ttcjpaysdk/integrated/counter/jsb/abs/AbsJsbPayInfo$PayInfoOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "PayInfoOutput", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbPayInfo extends AbsJSBMethod<NothingInput, PayInfoOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/jsb/abs/AbsJsbPayInfo$PayInfoOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", CrashHianalyticsData.PROCESS_ID, "", "create_time", "", "process_info", "(Ljava/lang/String;JLjava/lang/String;)V", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PayInfoOutput extends JSBBaseOutput {
        public long create_time;
        public String process_id;
        public String process_info;

        public PayInfoOutput() {
            this(null, 0, null, 7, null);
        }

        public PayInfoOutput(String r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, CrashHianalyticsData.PROCESS_ID);
            Intrinsics.checkNotNullParameter(r102, "process_info");
            this.process_id = r100;
            this.create_time = r101;
            this.process_info = r102;
        }

        public /* synthetic */ PayInfoOutput(String r100, long r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsJsbPayInfo() {
        this.name = "ttcjpay.payInfo";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
