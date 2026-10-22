package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdk.gift.model.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetSettings;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetSettings$GetSettingsInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetSettings$GetSettingsOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetSettingsInput", "GetSettingsOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbGetSettings extends AbsJSBMethod<GetSettingsInput, GetSettingsOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetSettings$GetSettingsInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "new_struct", "", SlcCommonAction.KEY_PARAMS, "", "", "key_list", "(ZLjava/util/List;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetSettingsInput implements IJSBParams {
        public List<String> fields;
        public String key_list;
        public boolean new_struct;

        public GetSettingsInput() {
            this(false, null, null, 7, null);
        }

        public GetSettingsInput(boolean r100, List<String> r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_PARAMS);
            Intrinsics.checkNotNullParameter(r102, "key_list");
            this.new_struct = r100;
            this.fields = r101;
            this.key_list = r102;
        }

        public /* synthetic */ GetSettingsInput(boolean r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = CollectionsKt.emptyList();
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetSettings$GetSettingsOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "data", "Lorg/json/JSONObject;", n.KEY_PLUGINS, "data_json_str", "", "plugins_json_str", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetSettingsOutput extends JSBBaseOutput {
        public JSONObject data;
        public String data_json_str;
        public JSONObject plugins;
        public String plugins_json_str;

        public GetSettingsOutput() {
            this(null, null, null, null, 15, null);
        }

        public GetSettingsOutput(JSONObject r100, JSONObject r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, n.KEY_PLUGINS);
            Intrinsics.checkNotNullParameter(r102, "data_json_str");
            Intrinsics.checkNotNullParameter(r103, "plugins_json_str");
            this.data = r100;
            this.plugins = r101;
            this.data_json_str = r102;
            this.plugins_json_str = r103;
        }

        public /* synthetic */ GetSettingsOutput(JSONObject r100, JSONObject r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = new JSONObject();
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = new JSONObject();
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = "";
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public AbsJsbGetSettings() {
        this.name = "ttcjpay.getSettings";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
