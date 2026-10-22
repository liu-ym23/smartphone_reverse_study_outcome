package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetWidgetInfo;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetWidgetInfo$GetWidgetInfoInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetWidgetInfo$GetWidgetInfoOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetWidgetInfoInput", "GetWidgetInfoOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbGetWidgetInfo extends AbsJSBMethod<GetWidgetInfoInput, GetWidgetInfoOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetWidgetInfo$GetWidgetInfoInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "widgetIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "widgetId", "source", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetWidgetInfoInput implements IJSBParams {
        public String source;
        public String widgetId;
        public ArrayList<String> widgetIds;

        public GetWidgetInfoInput() {
            this(null, null, null, 7, null);
        }

        public GetWidgetInfoInput(ArrayList<String> r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "widgetIds");
            Intrinsics.checkNotNullParameter(r101, "widgetId");
            Intrinsics.checkNotNullParameter(r102, "source");
            this.widgetIds = r100;
            this.widgetId = r101;
            this.source = r102;
        }

        public /* synthetic */ GetWidgetInfoInput(ArrayList r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = new ArrayList();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006R\"\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetWidgetInfo$GetWidgetInfoOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "widgetInfos", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetWidgetInfoOutput extends JSBBaseOutput {
        public ArrayList<JSONObject> widgetInfos;

        /* JADX WARN: Multi-variable type inference failed */
        public GetWidgetInfoOutput() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public GetWidgetInfoOutput(ArrayList<JSONObject> r100) {
            Intrinsics.checkNotNullParameter(r100, "widgetInfos");
            this.widgetInfos = r100;
        }

        public /* synthetic */ GetWidgetInfoOutput(ArrayList r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new ArrayList();
        L5:
            this(r100);
        }
    }

    public AbsJsbGetWidgetInfo() {
        this.name = "ttcjpay.getWidgetInfo";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
