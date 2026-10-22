package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDisallowCapture;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDisallowCapture$DisallowCaptureInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "DisallowCaptureInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbDisallowCapture extends AbsJSBMethod<DisallowCaptureInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDisallowCapture$DisallowCaptureInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "disallow", "", "is_all_window", "(II)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DisallowCaptureInput implements IJSBParams {
        public int disallow;
        public int is_all_window;

        public DisallowCaptureInput() {
            int r100 = 0;
            this(r100, r100, 3, null);
        }

        public DisallowCaptureInput(int r100, int r101) {
            this.disallow = r100;
            this.is_all_window = r101;
        }

        public /* synthetic */ DisallowCaptureInput(int r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    public AbsJsbDisallowCapture() {
        this.name = "ttcjpay.disallowCapture";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
