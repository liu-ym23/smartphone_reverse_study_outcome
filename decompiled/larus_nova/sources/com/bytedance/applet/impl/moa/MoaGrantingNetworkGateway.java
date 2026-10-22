package com.bytedance.applet.impl.moa;

import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes14.dex */
public final class MoaGrantingNetworkGateway {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MoaGrantingNetworkGateway f191973a = null;

    static {
        f191973a = new MoaGrantingNetworkGateway();
    }

    public MoaGrantingNetworkGateway() {
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0158 -> B:44:0x015c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x016a -> B:46:0x0170). Please report as a decompilation issue!!! */
    public final Object a(Map<String, ? extends Object> r210, Continuation<? super Boolean> r211) {
        if ((r211 instanceof MoaGrantingNetworkGateway$completeGranting$1) == false) goto L7;
        MoaGrantingNetworkGateway$completeGranting$1 r100 = (MoaGrantingNetworkGateway$completeGranting$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        ?? r106 = 1;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r107 = r100.I$1;
        int r108 = r100.I$0;
        Ref.LongRef r109 = (Ref.LongRef) r100.L$1;
        Map<String, ? extends Object> r110 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r102);
        int r111 = 2;
    L44:
        r109.element *= (long) r111;
        int r112 = r108;
        int r113 = r107;
        Object r114 = r103;
        MoaGrantingNetworkGateway$completeGranting$1 r115 = r100;
        Ref.LongRef r116 = r109;
    L46:
        int r117 = r113 + 1;
        Map<String, ? extends Object> r118 = r110;
        r105 = true;
    L17:
        if (r117 >= r112) goto L50;
        MoaAskHumanResultApi.a r119 = MoaAskHumanResultApi.f191971a;
        r115.L$0 = r118;
        r115.L$1 = r116;
        r115.I$0 = r112;
        r115.I$1 = r117;
        r115.I$2 = r117;
        r115.label = r105 ? 1 : 0;
        r119.getClass();
        FlowHttpConnection r120 = FlowHttpConnection.f359975a;
        int r121 = r112;
        int r122 = r117;
        Object r123 = FlowHttpConnection.g(ServiceType.MAIN_BOT, MoaAskHumanResultApi.class, new MoaAskHumanResultApi$Companion$uploadResult$2(r118, null), true, "/alice/office/tool_local/upload_ask_human_warn_result", null, null, r115, 224);
        if (r123 != r114) goto L21;
        return r114;
    L21:
        Map<String, ? extends Object> r124 = r118;
        Ref.LongRef r125 = r116;
        r100 = r115;
        r103 = r114;
        r102 = r123;
        int r126 = r121;
        int r127 = r122;
        r113 = r127;
        r106 = r105;
    L22:
        dm9.a r128 = (dm9.a) r102;
        boolean r129 = r128 instanceof dm9.a.b;
        if (r129 == true) goto L25;
    L27:
        boolean r130 = false;
    L29:
        if (r130 == false) goto L32;
        FLogger.f375446a.i("MoaGrantingNetwork", "upload result succeeded, attempt=" + (r127 + r106));
        return Boxing.boxBoolean(r106);
    L32:
        FLogger r131 = FLogger.f375446a;
        StringBuilder r132 = new StringBuilder("upload result failed, attempt=");
        r132.append(r127 + 1);
        r132.append(", error=");
        if (r129 == false) goto L36;
        StringBuilder r133 = new StringBuilder("biz_error:");
        dm9.a.b r134 = (dm9.a.b) r128;
        r133.append(r134.f469231a.getCode());
        r133.append(':');
        r133.append(r134.f469231a.getMsg());
        String r135 = r133.toString();
    L38:
        r132.append(r135);
        r131.e("MoaGrantingNetwork", r132.toString());
        r111 = 2;
        if (r127 >= 2) goto L45;
        long r136 = r125.element;
        r100.L$0 = r124;
        r100.L$1 = r125;
        r100.I$0 = r126;
        r100.I$1 = r113;
        r100.label = 2;
        if (DelayKt.delay(r136, r100) != r103) goto L43;
        return r103;
    L43:
        r107 = r113;
        r108 = r126;
        r109 = r125;
        r110 = r124;
        goto L44
    L45:
        r114 = r103;
        r112 = r126;
        r115 = r100;
        r116 = r125;
        r110 = r124;
        goto L46
    L36:
        if ((r128 instanceof dm9.a.C5690a) == false) goto L48;
        StringBuilder r137 = new StringBuilder("http_error:");
        dm9.a.C5690a r138 = (dm9.a.C5690a) r128;
        r137.append(r138.f469228a);
        r137.append(':');
        r137.append(r138.f469229b);
        r135 = r137.toString();
        goto L38
    L48:
        throw new NoWhenBranchMatchedException();
    L25:
        if (((dm9.a.b) r128).f469231a.isSuccess() == false) goto L27;
        r130 = true;
        goto L29
    L50:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r127 = r100.I$2;
        r113 = r100.I$1;
        r126 = r100.I$0;
        r125 = (Ref.LongRef) r100.L$1;
        r124 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L22
    L16:
        ResultKt.throwOnFailure(r102);
        Ref.LongRef r139 = new Ref.LongRef();
        r139.element = 1000;
        r114 = r103;
        r112 = 3;
        r117 = 0;
        r115 = r100;
        r116 = r139;
        r118 = r210;
    L7:
        r100 = new MoaGrantingNetworkGateway$completeGranting$1(this, r211);
        goto L8
    }
}
