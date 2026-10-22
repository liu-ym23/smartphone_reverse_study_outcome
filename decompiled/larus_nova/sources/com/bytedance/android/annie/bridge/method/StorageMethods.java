package com.bytedance.android.annie.bridge.method;

import android.content.SharedPreferences;
import com.bytedance.android.annie.bridge.method.abs.GetStorageItemResultModel;
import com.bytedance.android.annie.bridge.method.abs.RemoveStorageItemResultModel;
import com.bytedance.android.annie.bridge.method.abs.SetStorageItemResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class StorageMethods {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38501a = 0;

    @XBridgeMethod(biz = "webcast_sdk", name = "getStorageItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageMethods$GetStorageItemMethod;", "Le7/i;", "Le7/i0;", "Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "", AbsMethodDelegate.TAG_INVOKE, "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class GetStorageItemMethod extends e7.i<e7.i0, GetStorageItemResultModel> {
        public GetStorageItemMethod() {
        }

        public void invoke(e7.i0 r100, CallContext r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            GetStorageItemResultModel r102 = new GetStorageItemResultModel();
            String r103 = r100.b();
            String r104 = r100.b();
            if (r104 != null) goto L5;
        L8:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            finishWithFailure();
            return;
        L12:
            String r106 = r100.a();
            if (r106 != null) goto L15;
            int r107 = StorageMethods.f38501a;
            r106 = "js_kv_methods_20191113";
        L15:
            int r108 = StorageMethods.f38501a;
            SharedPreferences r109 = r101.getContext().getSharedPreferences(r106, 0);
            r102.a(GetStorageItemResultModel.Code.Success);
            Object r110 = null;
            String r111 = r109.getString(r103, null);
            if (r111 == null) goto L28;
            Gson r112 = new Gson();
            StorageValue r113 = (StorageValue) GsonProtectorUtils.fromJson(r112, r111, StorageValue.class);
            String r114 = r113.getValue();
            StorageDataType r115 = StorageDataType.valueOf(r113.getType());
            switch(a.f38502a[r115.ordinal()]) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                default: goto L26;
            };
        L20:
            r110 = GsonProtectorUtils.fromJson(r112, r114, Map.class);
            goto L26
        L21:
            r110 = GsonProtectorUtils.fromJson(r112, r114, List.class);
            goto L26
        L22:
            r110 = r114;
            goto L26
        L23:
            r110 = Double.valueOf(CastDoubleProtector.parseDouble(r114));
            goto L26
        L24:
            r110 = Integer.valueOf(CastIntegerProtector.parseInt(r114));
            goto L26
        L25:
            r110 = Boolean.valueOf(Boolean.parseBoolean(r114));
        L26:
            if (r110 == null) goto L28;
            r102.b(r110);
        L28:
            r102.c("SUCCESS");
            finishWithResult(r102);
            return;
        L5:
            if (StringsKt.isBlank(r104) == true) goto L8;
            r105 = false;
            goto L9
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public /* bridge */ /* synthetic */ void invoke(Object r100, CallContext r101) {
            invoke((e7.i0) r100, r101);
        }
    }

    @XBridgeMethod(biz = "webcast_sdk", name = "removeStorageItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageMethods$RemoveStorageItemMethod;", "Le7/t;", "Le7/r0;", "Lcom/bytedance/android/annie/bridge/method/abs/RemoveStorageItemResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "", AbsMethodDelegate.TAG_INVOKE, "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class RemoveStorageItemMethod extends e7.t<e7.r0, RemoveStorageItemResultModel> {
        public RemoveStorageItemMethod() {
        }

        public void invoke(e7.r0 r100, CallContext r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r102 = r100.b();
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            finishWithFailure();
            return;
        L12:
            String r104 = r100.b();
            String r105 = r100.a();
            if (r105 != null) goto L15;
            int r106 = StorageMethods.f38501a;
            r105 = "js_kv_methods_20191113";
        L15:
            RemoveStorageItemResultModel r107 = new RemoveStorageItemResultModel();
            r107.a(RemoveStorageItemResultModel.Code.Success);
            r107.b("SUCCESS");
            int r108 = StorageMethods.f38501a;
            if (r101.getContext().getSharedPreferences(r105, 0).edit().remove(r104).commit() == false) goto L18;
            finishWithResult(r107);
            return;
        L18:
            finishWithFailure();
            return;
        L5:
            if (StringsKt.isBlank(r102) == true) goto L8;
            r103 = false;
            goto L9
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public /* bridge */ /* synthetic */ void invoke(Object r100, CallContext r101) {
            invoke((e7.r0) r100, r101);
        }
    }

    @XBridgeMethod(biz = "webcast_sdk", name = "setStorageItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageMethods$SetStorageItemMethod;", "Le7/a0;", "Le7/w0;", "Lcom/bytedance/android/annie/bridge/method/abs/SetStorageItemResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "", AbsMethodDelegate.TAG_INVOKE, "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class SetStorageItemMethod extends e7.a0<e7.w0, SetStorageItemResultModel> {
        public SetStorageItemMethod() {
        }

        public void invoke(e7.w0 r100, CallContext r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r102 = r100.c();
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            finishWithFailure();
            return;
        L12:
            String r104 = r100.a();
            if (r104 != null) goto L15;
            int r105 = StorageMethods.f38501a;
            r104 = "js_kv_methods_20191113";
        L15:
            SetStorageItemResultModel r106 = new SetStorageItemResultModel();
            r106.a(SetStorageItemResultModel.Code.Success);
            r106.b("SUCCESS");
            Object r107 = r100.b();
            if (r107 == null) goto L51;
            int r108 = StorageMethods.f38501a;
            Gson r109 = new Gson();
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L39
            if ((r107 instanceof Boolean) == false) goto L22;
            String r111 = r109.toJson(new StorageValue(StorageDataType.Boolean.name(), r107.toString()));     // Catch: Throwable -> L39
        L37:
            Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L39
        L42:
            if (Result.m9455isFailureimpl(r112) == false) goto L44;
            r112 = null;
        L44:
            String r113 = (String) r112;
            if (r113 == null) goto L51;
            int r114 = StorageMethods.f38501a;
            if (r101.getContext().getSharedPreferences(r104, 0).edit().putString(r100.c(), r113).commit() == false) goto L49;
            finishWithResult(r106);
            return;
        L49:
            finishWithFailure();
            return;
        L22:
            if ((r107 instanceof Integer) == false) goto L25;
            r111 = r109.toJson(new StorageValue(StorageDataType.Int.name(), r107.toString()));     // Catch: Throwable -> L39
            goto L37
        L25:
            if ((r107 instanceof Double) == false) goto L28;
            r111 = r109.toJson(new StorageValue(StorageDataType.Number.name(), r107.toString()));     // Catch: Throwable -> L39
            goto L37
        L28:
            if ((r107 instanceof String) == false) goto L31;
            r111 = r109.toJson(new StorageValue(StorageDataType.String.name(), r107.toString()));     // Catch: Throwable -> L39
            goto L37
        L31:
            if ((r107 instanceof List) == false) goto L34;
            r111 = r109.toJson(new StorageValue(StorageDataType.List.name(), r109.toJson(r107)));     // Catch: Throwable -> L39
            goto L37
        L34:
            if ((r107 instanceof Map) == false) goto L36;
            r111 = r109.toJson(new StorageValue(StorageDataType.Map.name(), r109.toJson(r107)));     // Catch: Throwable -> L39
            goto L37
        L36:
            r111 = "";
        L39:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L51:
            finishWithFailure();
            return;
        L5:
            if (StringsKt.isBlank(r102) == true) goto L8;
            r103 = false;
            goto L9
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public /* bridge */ /* synthetic */ void invoke(Object r100, CallContext r101) {
            invoke((e7.w0) r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38502a = null;

        static {
            int[] r100 = new int[StorageDataType.values().length];
            r100[StorageDataType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[StorageDataType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[StorageDataType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[StorageDataType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[StorageDataType.List.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[StorageDataType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f38502a = r100;
        }
    }

    static {
    }

    public StorageMethods() {
    }
}
