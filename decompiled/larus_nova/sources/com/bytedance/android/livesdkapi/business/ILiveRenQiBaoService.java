package com.bytedance.android.livesdkapi.business;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0017J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J:\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/ILiveRenQiBaoService;", "Lcom/bytedance/android/live/base/IService;", "renQiBaoMonitor", "", "serviceName", "", "status", "", "extra", "Lorg/json/JSONObject;", "showDialogContent", "renQiBaoDialog", "Landroid/app/Dialog;", "isShow", "", "showRenQiBaoDialog", "ctx", "Landroid/content/Context;", "params", "", "schemaPath", "onDialogListener", "Lcom/bytedance/android/livesdkapi/business/OnLiveRenQiBaoDialogListener;", "DEFAULT", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRenQiBaoService extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J8\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/business/ILiveRenQiBaoService$DEFAULT;", "Lcom/bytedance/android/livesdkapi/business/ILiveRenQiBaoService;", "()V", "renQiBaoMonitor", "", "serviceName", "", "status", "", "extra", "Lorg/json/JSONObject;", "showDialogContent", "renQiBaoDialog", "Landroid/app/Dialog;", "isShow", "", "showRenQiBaoDialog", "ctx", "Landroid/content/Context;", "params", "", "schemaPath", "onDialogListener", "Lcom/bytedance/android/livesdkapi/business/OnLiveRenQiBaoDialogListener;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DEFAULT implements ILiveRenQiBaoService {
        public DEFAULT() {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService
        public void renQiBaoMonitor(String r100, int r101, JSONObject r102) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService
        public void showDialogContent(Dialog r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "renQiBaoDialog");
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService
        public Dialog showRenQiBaoDialog(Context r100, Map<String, String> r101, String r102, OnLiveRenQiBaoDialogListener r103) {
            Intrinsics.checkNotNullParameter(r100, "ctx");
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "schemaPath");
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ Dialog showRenQiBaoDialog$default(ILiveRenQiBaoService r100, Context r101, Map r102, String r103, OnLiveRenQiBaoDialogListener r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.showRenQiBaoDialog(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showRenQiBaoDialog");
        }
    }

    void renQiBaoMonitor(String r100, int r101, JSONObject r102);

    void showDialogContent(Dialog r100, boolean r101);

    Dialog showRenQiBaoDialog(Context r100, Map<String, String> r101, String r102, OnLiveRenQiBaoDialogListener r103);
}
