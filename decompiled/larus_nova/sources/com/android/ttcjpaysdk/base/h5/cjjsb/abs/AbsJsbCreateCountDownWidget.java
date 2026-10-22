package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import androidx.camera.video.AudioStats;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateCountDownWidget;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateCountDownWidget$CreateCountDownWidgetInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateCountDownWidget$CreateCountDownWidgetOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CreateCountDownWidgetInput", "CreateCountDownWidgetOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCreateCountDownWidget extends AbsJSBMethod<CreateCountDownWidgetInput, CreateCountDownWidgetOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateCountDownWidget$CreateCountDownWidgetInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "action", "", "cache_data", "Lorg/json/JSONObject;", "schema", "taskData", "default_horizontal_side", "default_vertical_percent", "", "enable_horizontal_moving", "", "min_vertical_percent", "max_vertical_percent", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;DZDD)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreateCountDownWidgetInput implements IJSBParams {
        public String action;
        public JSONObject cache_data;
        public String default_horizontal_side;
        public double default_vertical_percent;
        public boolean enable_horizontal_moving;
        public double max_vertical_percent;
        public double min_vertical_percent;
        public String schema;
        public JSONObject taskData;

        public CreateCountDownWidgetInput() {
            this(null, null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, false, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 511, null);
        }

        public CreateCountDownWidgetInput(String r100, JSONObject r101, String r102, JSONObject r103, String r104, double r105, boolean r106, double r110, double r111) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "cache_data");
            Intrinsics.checkNotNullParameter(r102, "schema");
            Intrinsics.checkNotNullParameter(r103, "taskData");
            Intrinsics.checkNotNullParameter(r104, "default_horizontal_side");
            this.action = r100;
            this.cache_data = r101;
            this.schema = r102;
            this.taskData = r103;
            this.default_horizontal_side = r104;
            this.default_vertical_percent = r105;
            this.enable_horizontal_moving = r106;
            this.min_vertical_percent = r110;
            this.max_vertical_percent = r111;
        }

        public /* synthetic */ CreateCountDownWidgetInput(String r110, JSONObject r111, String r112, JSONObject r113, String r114, double r115, boolean r210, double r211, double r212, int r213, DefaultConstructorMarker r214) {
            if ((r213 & 1) == 0) goto L5;
            String r100 = "create_widget";
        L7:
            if ((r213 & 2) == 0) goto L9;
            JSONObject r101 = new JSONObject();
        L11:
            if ((r213 & 4) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r213 & 8) == 0) goto L17;
            JSONObject r103 = new JSONObject();
        L19:
            if ((r213 & 16) == 0) goto L21;
            String r104 = "right";
        L23:
            if ((r213 & 32) == 0) goto L25;
            double r105 = 0.7d;
        L27:
            if ((r213 & 64) == 0) goto L29;
            boolean r106 = false;
        L31:
            if ((r213 & 128) == 0) goto L33;
            double r107 = 0.05d;
        L35:
            if ((r213 & 256) == 0) goto L37;
            double r116 = 0.88d;
        L38:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r116);
            return;
        L37:
            r116 = r212;
            goto L38
        L33:
            r107 = r211;
            goto L35
        L29:
            r106 = r210;
            goto L31
        L25:
            r105 = r115;
            goto L27
        L21:
            r104 = r114;
            goto L23
        L17:
            r103 = r113;
            goto L19
        L13:
            r102 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateCountDownWidget$CreateCountDownWidgetOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "error_code", "", "error_msg", "", "cache_data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreateCountDownWidgetOutput extends JSBBaseOutput {
        public JSONObject cache_data;
        public int error_code;
        public String error_msg;

        public CreateCountDownWidgetOutput() {
            this(0, null, null, 7, null);
        }

        public CreateCountDownWidgetOutput(int r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "error_msg");
            Intrinsics.checkNotNullParameter(r102, "cache_data");
            this.error_code = r100;
            this.error_msg = r101;
            this.cache_data = r102;
        }

        public /* synthetic */ CreateCountDownWidgetOutput(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = new JSONObject();
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsJsbCreateCountDownWidget() {
        this.name = "ttcjpay.createCountDownWidget";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
