package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbShowToast;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbShowToast$ShowToastInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "ShowToastInput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbShowToast extends AbsJSBMethod<ShowToastInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbShowToast$ShowToastInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "type", "", "style", "message", "sub_message", "image_type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowToastInput implements IJSBParams {
        public int image_type;
        public String message;
        public String style;
        public String sub_message;
        public String type;

        public ShowToastInput() {
            this(null, null, null, null, 0, 31, null);
        }

        public ShowToastInput(String r100, String r101, String r102, String r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "style");
            Intrinsics.checkNotNullParameter(r102, "message");
            Intrinsics.checkNotNullParameter(r103, "sub_message");
            this.type = r100;
            this.style = r101;
            this.message = r102;
            this.sub_message = r103;
            this.image_type = r104;
        }

        public /* synthetic */ ShowToastInput(String r100, String r101, String r102, String r103, int r104, int r105, DefaultConstructorMarker r110) {
            String r106 = "";
            if ((r105 & 1) == 0) goto L5;
            String r111 = "";
        L7:
            if ((r105 & 2) == 0) goto L9;
            String r107 = "";
        L11:
            if ((r105 & 4) == 0) goto L13;
            String r108 = "";
        L15:
            if ((r105 & 8) != 0) goto L19;
            r106 = r103;
        L19:
            if ((r105 & 16) == 0) goto L21;
            int r109 = 0;
        L22:
            this(r111, r107, r108, r106, r109);
            return;
        L21:
            r109 = r104;
            goto L22
        L13:
            r108 = r102;
            goto L15
        L9:
            r107 = r101;
            goto L11
        L5:
            r111 = r100;
            goto L7
        }
    }

    public AbsJsbShowToast() {
        this.name = "ttcjpay.showToast";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
