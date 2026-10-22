package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateWidget;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateWidget$CreateWidgetInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateWidget$CreateWidgetOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "CreateWidgetInput", "CreateWidgetOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbCreateWidget extends AbsJSBMethod<CreateWidgetInput, CreateWidgetOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateWidget$CreateWidgetInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "schema", "", "data", "Lorg/json/JSONObject;", "draggable", "", "position", "autoShow", "source", "(Ljava/lang/String;Lorg/json/JSONObject;ZLorg/json/JSONObject;ZLjava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreateWidgetInput implements IJSBParams {
        public boolean autoShow;
        public JSONObject data;
        public boolean draggable;
        public JSONObject position;
        public String schema;
        public String source;

        public CreateWidgetInput() {
            this(null, null, false, null, false, null, 63, null);
        }

        public CreateWidgetInput(String r100, JSONObject r101, boolean r102, JSONObject r103, boolean r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r103, "position");
            Intrinsics.checkNotNullParameter(r105, "source");
            this.schema = r100;
            this.data = r101;
            this.draggable = r102;
            this.position = r103;
            this.autoShow = r104;
            this.source = r105;
        }

        public /* synthetic */ CreateWidgetInput(String r100, JSONObject r101, boolean r102, JSONObject r103, boolean r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            String r114 = "";
        L7:
            if ((r112 & 2) == 0) goto L9;
            r101 = new JSONObject();
        L9:
            JSONObject r104 = r101;
            if ((r112 & 4) == 0) goto L12;
            boolean r105 = true;
        L14:
            if ((r112 & 8) == 0) goto L16;
            r103 = new JSONObject();
        L16:
            JSONObject r106 = r103;
            if ((r112 & 16) == 0) goto L19;
            boolean r107 = true;
        L21:
            if ((r112 & 32) == 0) goto L23;
            String r115 = "";
        L24:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L23:
            r115 = r111;
            goto L24
        L19:
            r107 = r110;
            goto L21
        L12:
            r105 = r102;
            goto L14
        L5:
            r114 = r100;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbCreateWidget$CreateWidgetOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "widgetId", "", "success", "", "(Ljava/lang/String;Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreateWidgetOutput extends JSBBaseOutput {
        public boolean success;
        public String widgetId;

        /* JADX WARN: Multi-variable type inference failed */
        public CreateWidgetOutput() {
            String r100 = null;
            this(r100, false, 3, 0 == true ? 1 : 0);
        }

        public CreateWidgetOutput(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "widgetId");
            this.widgetId = r100;
            this.success = r101;
        }

        public /* synthetic */ CreateWidgetOutput(String r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = false;
        L8:
            this(r100, r101);
        }
    }

    public AbsJsbCreateWidget() {
        this.name = "ttcjpay.createWidget";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
