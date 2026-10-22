package com.bytedance.android.live.revenue.platform.network.api;

import android.util.Base64;
import com.alipay.sdk.m.p.e;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.h;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.adapter.internal.CommonCode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.NetworkService")
public interface IDynamicHostNetworkService extends uh7.a, dy0.d {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$ContentType;", "", "JSON", "PROTOBUF", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ContentType extends Enum<ContentType> {
        public static final ContentType JSON = null;
        public static final ContentType PROTOBUF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentType[] f91484a = null;

        static {
            ContentType r100 = new ContentType("JSON", 0);
            JSON = r100;
            ContentType r101 = new ContentType("PROTOBUF", 1);
            PROTOBUF = r101;
            f91484a = new ContentType[]{r100, r101};
        }

        public static ContentType valueOf(String r100) {
            return (ContentType) r27.a.a(ContentType.class, r100);
        }

        public static ContentType[] values() {
            return (ContentType[]) f91484a.clone();
        }

        public ContentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(IDynamicHostNetworkService_FormPostBodySerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$a;", "Lvh7/j;", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpRequest.FormPostRequestBody")
    public interface a extends j<a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService$a$a, reason: collision with other inner class name */
        @JsonAdapter(IDynamicHostNetworkService_FormPostBodySerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C1411a {
        }

        @FieldName(name = "content")
        Map<String, String> getContent();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0015\u000eB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b;", "", "", "statusCode", "I", "c", "()I", "f", "(I)V", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "headers", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "e", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", ContainerPosition.BODY, "Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", "d", "(Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpResponse")
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1413b f91485a = null;

        @SerializedName(ContainerPosition.BODY)
        private a body;

        @SerializedName("headers")
        private Map<String, String> headers;

        @SerializedName("status_code")
        private int statusCode;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$b$a;", "", "", "contentType", "I", "b", "()I", "d", "(I)V", "content", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "c", "(Ljava/lang/Object;)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
        @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpResponse.Body")
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1412a f91486a = null;

            @SerializedName("content")
            private Object content;

            @SerializedName("content_type")
            private int contentType;

            /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService$b$a$a, reason: collision with other inner class name */
            public static final class C1412a implements uh7.c.b<a> {
                public C1412a() {
                }

                @Override // uh7.c.b
                public final void a() {
                    C1412a r100 = a.f91486a;
                }

                @Override // uh7.c.b
                public final boolean b(KClass<?> r100) {
                    Intrinsics.checkNotNullParameter(r100, "type");
                    return Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(a.class));
                }

                @Override // uh7.c.b
                public final JsonObject e(Object r100, uh7.c.a r101) {
                    a r102 = (a) r100;
                    Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                    Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                    JsonObject r103 = new JsonObject();
                    r103.addProperty("content_type", Integer.valueOf(r102.b()));
                    Object r104 = r102.a();
                    if (r104 != null) goto L6;
                L11:
                    return r103;
                L6:
                    if ((r104 instanceof byte[]) == false) goto L9;
                    int r105 = com.bytedance.revenue.platform.api.core.a.f267505a;
                    byte[] r106 = (byte[]) r104;
                    Intrinsics.checkNotNullParameter(r106, "input");
                    r103.addProperty("content", Base64.encodeToString(r106, 2));
                    goto L11
                L9:
                    if ((r104 instanceof JsonElement) == false) goto L13;
                    r103.add("content", (JsonElement) r104);
                    goto L11
                L13:
                    throw new IllegalStateException(("unknown type of content: " + r104).toString());
                }

                @Override // uh7.c.b
                public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, uh7.c.a r102) {
                    a r103 = (a) r101;
                    Intrinsics.checkNotNullParameter(r100, "$this$writeProtobuf");
                    Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                    Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
                    com.bytedance.tools.kcp.modelx.runtime.protobuf.b r104 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(r100.f271000b);
                    r104.c(r103.b(), 1);
                    Object r105 = r103.a();
                    if (r105 != null) goto L6;
                L11:
                    MessagePayload r106 = r104.a(4);
                    if (r100.f271000b == true) goto L14;
                L15:
                    ((ArrayList) r100.f270999a).add(r106);
                    return;
                L14:
                    if (r106.d() == true) goto L15;
                    return;
                L6:
                    if ((r105 instanceof byte[]) == false) goto L9;
                    r104.b((byte[]) r105, 2);
                    goto L11
                L9:
                    if ((r105 instanceof JsonElement) == false) goto L18;
                    r104.d(r105.toString(), 2);
                    goto L11
                L18:
                    throw new IllegalStateException(("unknown type of content: " + r105).toString());
                }

                @Override // uh7.c.b
                public final Object d(KClass r100, JsonObject r101, uh7.c.a r102) {
                    Intrinsics.checkNotNullParameter(r100, "type");
                    Intrinsics.checkNotNullParameter(r101, "jsonObject");
                    Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
                    a r103 = new a();
                    JsonElement r104 = r101.get("content_type");
                    if (r104 == null) goto L5;
                    r103.d(r104.getAsInt());
                L5:
                    JsonElement r105 = r101.get("content");
                    if (r105 == null) goto L16;
                    int r106 = r103.b();
                    if (r106 != ContentType.JSON.ordinal()) goto L11;
                    Object r107 = GsonProtectorUtils.parse(new JsonParser(), r105.getAsString()).getAsJsonObject();
                L13:
                    r103.c(r107);
                    goto L16
                L11:
                    if (r106 != ContentType.PROTOBUF.ordinal()) goto L15;
                    int r108 = com.bytedance.revenue.platform.api.core.a.f267505a;
                    r107 = com.bytedance.revenue.platform.api.core.a.a(r105.getAsString());
                    goto L13
                L15:
                    throw new IllegalStateException(("Unknown content type " + r103.b()).toString());
                L16:
                    return r103;
                }
            }

            static {
                f91486a = new C1412a();
            }

            public a() {
                this.contentType = ContentType.JSON.ordinal();
            }

            public final Object a() {
                return this.content;
            }

            public final int b() {
                return this.contentType;
            }

            public final void c(Object r100) {
                this.content = r100;
            }

            public final void d(int r100) {
                this.contentType = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.api.IDynamicHostNetworkService$b$b, reason: collision with other inner class name */
        public static final class C1413b implements uh7.c.b<b> {
            public C1413b() {
            }

            @Override // uh7.c.b
            public final void a() {
                C1413b r100 = b.f91485a;
            }

            @Override // uh7.c.b
            public final boolean b(KClass<?> r100) {
                Intrinsics.checkNotNullParameter(r100, "type");
                return Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(b.class));
            }

            @Override // uh7.c.b
            public final JsonObject e(Object r100, uh7.c.a r101) {
                b r102 = (b) r100;
                Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                JsonObject r103 = new JsonObject();
                r103.addProperty("status_code", Integer.valueOf(r102.c()));
                Map<String, String> r104 = r102.b();
                r103.add("header", GsonProtectorUtils.toJsonTree(l97.a.f508113a, r104));
                a r105 = r102.a();
                if (r105 == null) goto L5;
                r103.add(ContainerPosition.BODY, r101.b(r105));
            L5:
                return r103;
            }

            @Override // uh7.c.b
            public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r110, Object r111, uh7.c.a r112) {
                b r113 = (b) r111;
                Intrinsics.checkNotNullParameter(r110, "$this$writeProtobuf");
                Intrinsics.checkNotNullParameter(r113, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
                r110.c(r113.c(), 1);
                Iterator<Map.Entry<String, String>> r100 = r113.b().entrySet().iterator();
            L4:
                if (r100.hasNext() == false) goto L25;
                Map.Entry<String, String> r101 = r100.next();
                boolean r102 = r110.f271000b;
                ArrayList r103 = new ArrayList();
                String r104 = r101.getKey();
                Intrinsics.checkNotNullParameter(r104, "value");
                boolean r105 = false;
                if (r102 == true) goto L8;
            L12:
                r103.add(new h(1, r104));
            L13:
                String r106 = r101.getValue();
                Intrinsics.checkNotNullParameter(r106, "value");
                if (r102 == true) goto L16;
            L19:
                r103.add(new h(2, r106));
            L20:
                MessagePayload r107 = new MessagePayload(2, r103);
                if (r110.f271000b == false) goto L24;
                if (r107.d() == false) goto L4;
            L24:
                ((ArrayList) r110.f270999a).add(r107);
                goto L4
            L16:
                if (r106.length() <= 0) goto L18;
                r105 = true;
            L18:
                if (r105 == false) goto L20;
            L8:
                if (r104.length() <= 0) goto L10;
                boolean r108 = true;
            L11:
                if (r108 == false) goto L13;
            L10:
                r108 = false;
                goto L11
            L25:
                a r114 = r113.a();
                if (r114 == null) goto L35;
                r112.c(r110, r114);
                return;
            }

            @Override // uh7.c.b
            public final Object d(KClass r100, JsonObject r101, uh7.c.a r102) {
                Intrinsics.checkNotNullParameter(r100, "type");
                Intrinsics.checkNotNullParameter(r101, "jsonObject");
                Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
                b r103 = new b();
                JsonElement r104 = r101.get("zd");
                if (r104 == null) goto L5;
                r103.f(r104.getAsInt());
            L5:
                JsonElement r105 = r101.get("headers");
                if (r105 == null) goto L13;
                JsonObject r106 = r105.getAsJsonObject();
                if (r106 == null) goto L13;
                Iterator<T> r107 = r106.keySet().iterator();
            L11:
                if (r107.hasNext() == false) goto L13;
                String r108 = (String) r107.next();
                Map<String, String> r109 = r103.b();
                JsonElement r110 = r106.get(r108);
                Intrinsics.checkNotNull(r110);
                r109.put(r108, r110.getAsString());
            L13:
                JsonElement r111 = r101.get(ContainerPosition.BODY);
                if (r111 == null) goto L20;
                JsonObject r112 = r111.getAsJsonObject();
                if (r112 == null) goto L20;
                a r113 = (a) r102.a(r112, Reflection.getOrCreateKotlinClass(a.class));
                if (r113 == null) goto L20;
                r103.d(r113);
            L20:
                return r103;
            }
        }

        static {
            f91485a = new C1413b();
        }

        public b() {
            this.statusCode = 200;
            this.headers = new LinkedHashMap();
        }

        public final a a() {
            return this.body;
        }

        public final Map<String, String> b() {
            return this.headers;
        }

        public final int c() {
            return this.statusCode;
        }

        public final void d(a r100) {
            this.body = r100;
        }

        public final void e(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.headers = r100;
        }

        public final void f(int r100) {
            this.statusCode = r100;
        }
    }

    @JsonAdapter(IDynamicHostNetworkService_JsonPostBodySerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$c;", "Lvh7/j;", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.SendHttpRequest.JsonPostRequestBody")
    public interface c extends j<c> {

        @JsonAdapter(IDynamicHostNetworkService_JsonPostBodySerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @FieldName(name = "content")
        String getContent();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/IDynamicHostNetworkService$d;", "", "data", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "b", "(Ljava/lang/Object;)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "webcast.revenue.biz.foundation.RegisterMessageResponse")
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f91487a = null;

        @SerializedName("data")
        private Object data;

        public static final class a implements uh7.c.b<d> {
            public a() {
            }

            @Override // uh7.c.b
            public final void a() {
                a r100 = d.f91487a;
            }

            @Override // uh7.c.b
            public final boolean b(KClass<?> r100) {
                Intrinsics.checkNotNullParameter(r100, "type");
                return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(d.class), r100);
            }

            @Override // uh7.c.b
            public final JsonObject e(Object r100, uh7.c.a r101) {
                d r102 = (d) r100;
                Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                JsonObject r103 = new JsonObject();
                Object r104 = r102.a();
                if (r104 == null) goto L5;
                int r105 = com.bytedance.revenue.platform.api.core.a.f267505a;
                byte[] r106 = (byte[]) r104;
                Intrinsics.checkNotNullParameter(r106, "input");
                r103.addProperty("data", Base64.encodeToString(r106, 2));
            L5:
                return r103;
            }

            @Override // uh7.c.b
            public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, uh7.c.a r102) {
                d r103 = (d) r101;
                Intrinsics.checkNotNullParameter(r100, "$this$writeProtobuf");
                Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
                Object r104 = r103.a();
                if (r104 == null) goto L6;
                r100.b((byte[]) r104, 1);
                return;
            }

            @Override // uh7.c.b
            public final Object d(KClass r100, JsonObject r101, uh7.c.a r102) {
                Intrinsics.checkNotNullParameter(r100, "type");
                Intrinsics.checkNotNullParameter(r101, "jsonObject");
                Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
                d r103 = new d();
                JsonElement r104 = r101.get("data");
                if (r104 != null) goto L5;
            L13:
                return r103;
            L5:
                if (r104.isJsonObject() == false) goto L8;
                Object r105 = r104.getAsJsonObject();
            L10:
                r103.b(r105);
                goto L13
            L8:
                if (r104.isJsonPrimitive() == false) goto L12;
                int r106 = com.bytedance.revenue.platform.api.core.a.f267505a;
                r105 = com.bytedance.revenue.platform.api.core.a.a(r104.getAsString());
                goto L10
            L12:
                throw new IllegalStateException(("unknown data type: " + r104).toString());
            }
        }

        static {
            f91487a = new a();
        }

        public d() {
        }

        public final Object a() {
            return this.data;
        }

        public final void b(Object r100) {
            this.data = r100;
        }
    }

    @BindsRpc(rpcName = "RegisterMessage")
    Observable<d> registerMessage(i57.a r100, @RpcParam(paramName = e.f25671s) String r101, @RpcParam(paramName = "wrds") Boolean r102, @RpcParam(paramName = "wrds_subkey") String r103, @RpcParam(paramName = "message_type") Integer r104);

    @BindsRpc(rpcName = "SendHttp")
    Single<b> requestHttp(@RpcParam(paramName = "path") String r100, @RpcParam(paramName = e.f25671s) String r101, @RpcParam(paramName = "queries") Map<String, String> r102, @RpcParam(paramName = "headers") Map<String, String> r103, @RpcParam(paramName = "preferred_response_body_content_type") int r104, @RpcParam(paramName = CommonCode.MapKey.JSON_BODY) c r105, @RpcParam(paramName = "form_body") a r106);
}
