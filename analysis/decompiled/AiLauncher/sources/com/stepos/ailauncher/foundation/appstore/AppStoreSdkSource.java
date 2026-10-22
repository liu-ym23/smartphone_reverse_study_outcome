package com.stepos.ailauncher.foundation.appstore;

import Ua.InterfaceC1066l;
import Y8.t;
import Z8.C1173v;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepos.ailauncher.foundation.appstore.api.AppDetailDto;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\t\u0010\bJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u0013*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%RT\u0010)\u001aB\u0012\f\u0012\n '*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n '*\u0004\u0018\u00010(0( '* \u0012\f\u0012\n '*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n '*\u0004\u0018\u00010(0(\u0018\u00010&0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/AppStoreSdkSource;", "", "<init>", "()V", "", "packageName", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailDto;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "code", "data", "LY8/t;", "f", "(Ljava/lang/String;ILjava/lang/String;)V", "raw", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailDto;", "Lcom/google/gson/JsonObject;", "obj", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", "key", "e", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonObject;", "TAG", "Ljava/lang/String;", "API_DETAIL", "PARAM_PKG", "CODE_SUCCESS", "I", "", "TIMEOUT_MS", "J", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "rawLogged", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppStoreSdkSource {
    private static final String API_DETAIL = "detail";
    private static final int CODE_SUCCESS = 0;
    private static final String PARAM_PKG = "pkg";
    private static final String TAG = "AppStoreSdkSource";
    private static final long TIMEOUT_MS = 20000;
    public static final AppStoreSdkSource INSTANCE = new AppStoreSdkSource();
    private static final Gson gson = new Gson();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> rawLogged = ConcurrentHashMap.newKeySet();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements AppCenterSdk.Listener {
        final /* synthetic */ InterfaceC1066l<String> $cont;
        final /* synthetic */ String $packageName;
        final /* synthetic */ AtomicBoolean $resumed;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, AtomicBoolean atomicBoolean, InterfaceC1066l<? super String> interfaceC1066l) {
            this.$packageName = str;
            this.$resumed = atomicBoolean;
            this.$cont = interfaceC1066l;
        }

        @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
        public final void onCallback(int i10, String str) {
            AtomicBoolean atomicBoolean;
            InterfaceC1066l<String> interfaceC1066l;
            AppStoreSdkSource.INSTANCE.f(this.$packageName, i10, str);
            if (i10 == 0) {
                atomicBoolean = this.$resumed;
                interfaceC1066l = this.$cont;
            } else {
                atomicBoolean = this.$resumed;
                interfaceC1066l = this.$cont;
                str = null;
            }
            AppStoreSdkSource.j(atomicBoolean, interfaceC1066l, str);
        }
    }

    public static final void j(AtomicBoolean atomicBoolean, InterfaceC1066l<? super String> interfaceC1066l, String str) {
        if (atomicBoolean.compareAndSet(false, true) && interfaceC1066l.b()) {
            interfaceC1066l.resumeWith(Result.b(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r6, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appstore.api.AppDetailDto> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$1 r0 = (com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$1 r0 = new com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r7)
            goto L4b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.C4849c.b(r7)
            com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$raw$1 r7 = new com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource$fetchDetail$raw$1
            r7.<init>(r6, r4)
            r0.L$0 = r6
            r0.label = r3
            r2 = 20000(0x4e20, double:9.8813E-320)
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r2, r7, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L6d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "detail 无响应（20000ms 超时）pkg="
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = " —— 检查 <queries> 声明、com.stepos.appstore 是否安装、AppCenterSdk init 是否成功"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = 0
            r7 = 4
            java.lang.String r0 = "AppStoreSdkSource"
            h8.C4148a.u(r0, r5, r6, r7, r4)
            return r4
        L6d:
            com.stepos.ailauncher.foundation.appstore.api.AppDetailDto r5 = r5.g(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.AppStoreSdkSource.d(java.lang.String, e9.c):java.lang.Object");
    }

    public final JsonObject e(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            if (!jsonElement.isJsonObject()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                return jsonElement.getAsJsonObject();
            }
        }
        return null;
    }

    public final void f(String packageName, int code, String data) {
        if (rawLogged.add(packageName)) {
            C4148a.k(TAG, "detail 原始响应 pkg=" + packageName + " code=" + code + " data=" + data, false, 4, null);
        }
    }

    public final AppDetailDto g(String packageName, String raw) {
        Object objB;
        Object objB2;
        JsonObject jsonObjectH;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonElement string = JsonParser.parseString(raw);
            if (string.isJsonObject()) {
                JsonObject asJsonObject = string.getAsJsonObject();
                p.f(asJsonObject);
                jsonObjectH = h(asJsonObject);
            } else {
                jsonObjectH = null;
            }
            objB = Result.b(jsonObjectH);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "detail 响应不是合法 JSON pkg=" + packageName, thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JsonObject jsonObject = (JsonObject) objB;
        if (jsonObject == null) {
            C4148a.u(TAG, "detail 响应里找不到可用的详情对象 pkg=" + packageName + "（见上一条原始响应日志）", false, 4, null);
            return null;
        }
        try {
            objB2 = Result.b((AppDetailDto) gson.fromJson((JsonElement) jsonObject, AppDetailDto.class));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            C4148a.t(TAG, "detail 详情对象反序列化失败 pkg=" + packageName, thE2, false, 8, null);
        }
        return (AppDetailDto) (Result.g(objB2) ? null : objB2);
    }

    public final JsonObject h(JsonObject obj) {
        JsonObject jsonObjectE = e(obj, "data");
        if (jsonObjectE != null) {
            return jsonObjectE;
        }
        JsonObject jsonObjectE2 = e(obj, UxipConstants.f30680s);
        if (jsonObjectE2 != null) {
            return jsonObjectE2;
        }
        List listP = C1173v.p("name", ContentDisposition.Parameters.Size, "description", "icon", "version_name", "publisher");
        if ((listP instanceof Collection) && listP.isEmpty()) {
            return null;
        }
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            if (obj.has((String) it.next())) {
                return obj;
            }
        }
        return null;
    }

    public final Object i(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        Object objB;
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        a aVar = new a(str, atomicBoolean, cVar);
        try {
            Result.Companion companion = Result.INSTANCE;
            AppCenterSdk.getInstance().requestApi("detail", Q.f(Y8.j.a(PARAM_PKG, str)), aVar);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "requestApi 抛异常 pkg=" + str, thE, false, 8, null);
            j(atomicBoolean, cVar, null);
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }
}
