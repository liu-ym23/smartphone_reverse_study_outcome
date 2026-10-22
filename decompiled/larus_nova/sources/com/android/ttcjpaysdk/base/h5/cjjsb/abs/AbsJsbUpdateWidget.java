package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUpdateWidget;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUpdateWidget$UpdateWidgetInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUpdateWidget$UpdateWidgetOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "UpdateWidgetInput", "UpdateWidgetOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbUpdateWidget extends AbsJSBMethod<UpdateWidgetInput, UpdateWidgetOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUpdateWidget$UpdateWidgetInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "widgetId", "", "action", "peekValue", "", "peekType", "position", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UpdateWidgetInput implements IJSBParams {
        public String action;
        public String peekType;
        public int peekValue;
        public JSONObject position;
        public String widgetId;

        public UpdateWidgetInput() {
            this(null, null, 0, null, null, 31, null);
        }

        public UpdateWidgetInput(String r100, String r101, int r102, String r103, JSONObject r104) {
            Intrinsics.checkNotNullParameter(r100, "widgetId");
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r103, "peekType");
            Intrinsics.checkNotNullParameter(r104, "position");
            this.widgetId = r100;
            this.action = r101;
            this.peekValue = r102;
            this.peekType = r103;
            this.position = r104;
        }

        public /* synthetic */ UpdateWidgetInput(String r100, String r101, int r102, String r103, JSONObject r104, int r105, DefaultConstructorMarker r110) {
            String r106 = "";
            if ((r105 & 1) == 0) goto L5;
            String r111 = "";
        L7:
            if ((r105 & 2) != 0) goto L11;
            r106 = r101;
        L11:
            if ((r105 & 4) == 0) goto L13;
            int r107 = 22;
        L15:
            if ((r105 & 8) == 0) goto L17;
            r103 = "pixel";
        L17:
            String r108 = r103;
            if ((r105 & 16) == 0) goto L20;
            r104 = new JSONObject();
        L20:
            String r109 = r111;
            String r112 = r106;
            int r113 = r107;
            this(r109, r112, r113, r108, r104);
            return;
        L13:
            r107 = r102;
            goto L15
        L5:
            r111 = r100;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbUpdateWidget$UpdateWidgetOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "success", "", "(Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UpdateWidgetOutput extends JSBBaseOutput {
        public boolean success;

        public UpdateWidgetOutput() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public UpdateWidgetOutput(boolean r100) {
            this.success = r100;
        }

        public /* synthetic */ UpdateWidgetOutput(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    public AbsJsbUpdateWidget() {
        this.name = "ttcjpay.updateWidget";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
