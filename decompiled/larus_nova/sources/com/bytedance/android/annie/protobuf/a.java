package com.bytedance.android.annie.protobuf;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f39760a;

    /* JADX INFO: renamed from: com.bytedance.android.annie.protobuf.a$a, reason: collision with other inner class name */
    public static final class CallableC0742a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CallableC0742a<V> f39761a = null;

        static {
            f39761a = new CallableC0742a();
        }

        public CallableC0742a() {
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            ExternalProtobufMessageDefinitions.f39738b.a();
            ExternalProtobufShrinkConfigs.f39748b.a();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements t9.c {
        public b() {
        }

        @Override // t9.c
        public final t9.b M0(JsonObject r100) {
            Intrinsics.checkNotNullParameter(r100, "def");
            return new com.bytedance.android.annie.protobuf.b(new ExternalProtobufMessageDefinitions("", r100), new ExternalProtobufShrinkConfigs("", new JsonObject()));
        }

        @Override // t9.c
        public final t9.b w0(String r100) {
            int r101 = com.bytedance.android.annie.protobuf.b.f39762c;
            ExternalProtobufMessageDefinitions.Companion r102 = ExternalProtobufMessageDefinitions.f39738b;
            if (r100 == null) goto L5;
            Object r103 = r102.f39736d.get(r100);
        L7:
            if (AnnieConfigSettingKeys.ENABLE_LATCH_PB_COMPLETE.a().booleanValue() == false) goto L18;
            ExternalProtobufShrinkConfigs.Companion r104 = ExternalProtobufShrinkConfigs.f39748b;
            if (r100 == null) goto L11;
            Object r105 = r104.f39736d.get(r100);
        L12:
            ExternalProtobufShrinkConfigs r106 = (ExternalProtobufShrinkConfigs) r105;
            if (r106 == null) goto L15;
        L23:
            if (r103 == null) goto L27;
            if (r106 != null) goto L26;
            return null;
        L26:
            return new com.bytedance.android.annie.protobuf.b((ExternalProtobufMessageDefinitions) r103, r106);
        L27:
            return null;
        L15:
            if (r100 != null) goto L17;
            r100 = "";
        L17:
            r106 = new ExternalProtobufShrinkConfigs(r100, new JsonObject());
            goto L23
        L11:
            r104.getClass();
            r105 = null;
            goto L12
        L18:
            ExternalProtobufShrinkConfigs.Companion r107 = ExternalProtobufShrinkConfigs.f39748b;
            if (r100 == null) goto L21;
            Object r108 = r107.f39736d.get(r100);
        L22:
            r106 = (ExternalProtobufShrinkConfigs) r108;
            goto L23
        L21:
            r107.getClass();
            r108 = null;
            goto L22
        L5:
            r102.getClass();
            r103 = null;
            goto L7
        }
    }

    static {
    }

    public static void a() {
        if (f39760a == false) goto L5;
        return;
    L5:
        f39760a = true;
        Observable.fromCallable(CallableC0742a.f39761a).subscribeOn(Schedulers.io()).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
        Annie.registerService$default(t9.c.class, new b(), null, 4, null);
    }
}
