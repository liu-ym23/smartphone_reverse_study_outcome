package com.bytedance.android.live.profit.redpacket.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/e;", "", "message", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "c", "(Ljava/lang/Object;)V", "api", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setApi", "<init>", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.luckyBox.LuckyBoxLazyLoadParams")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f88663a = null;

    @SerializedName("api")
    private Object api;

    @SerializedName("message")
    private Object message;

    public static final class a implements uh7.c.b<e> {
        public a() {
        }

        @Override // uh7.c.b
        public final void a() {
            a r100 = e.f88663a;
        }

        @Override // uh7.c.b
        public final boolean b(KClass<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), r100);
        }

        public static JsonObject f(e r100, uh7.c.a r101) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return uh7.c.b.a.a(r100, r101);
        }

        @Override // uh7.c.b
        public final /* bridge */ /* synthetic */ JsonObject e(Object r100, uh7.c.a r101) {
            return f((e) r100, r101);
        }

        @Override // uh7.c.b
        public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, uh7.c.a r102) {
            e r103 = (e) r101;
            Intrinsics.checkNotNullParameter(r100, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Object r104 = r103.b();
            Object r105 = null;
            if ((r104 instanceof byte[]) == true) goto L5;
            r104 = null;
        L5:
            byte[] r106 = (byte[]) r104;
            if (r106 == null) goto L8;
            r100.b(r106, 1);
        L8:
            Object r107 = r103.a();
            if ((r107 instanceof byte[]) == false) goto L12;
            r105 = r107;
        L12:
            byte[] r108 = (byte[]) r105;
            if (r108 == null) goto L16;
            r100.b(r108, 2);
            return;
        }

        @Override // uh7.c.b
        public final Object d(KClass r100, JsonObject r101, uh7.c.a r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            return (e) r102.a(r101, r100);
        }
    }

    static {
        f88663a = new a();
    }

    public e() {
    }

    public final Object a() {
        return this.api;
    }

    public final Object b() {
        return this.message;
    }

    public final void c(Object r100) {
        this.message = r100;
    }
}
