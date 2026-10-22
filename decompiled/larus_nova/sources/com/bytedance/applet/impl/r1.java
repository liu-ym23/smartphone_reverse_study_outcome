package com.bytedance.applet.impl;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.assistant.interaction.impl.AssistantInteractionService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 implements w4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.api.m f192004a;

    public r1(AssistantInteractionService.C116191 r100) {
        this.f192004a = r100;
    }

    @Override // w4.a
    public final void c(String r100, String r101, String r102, com.bytedance.applet.event.j r103) {
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r102, "questionId");
        Intrinsics.checkNotNullParameter(r103, "responseCallback");
    }

    @Override // w4.a
    public final void a(String r110, String r111, String r112, String r113, String r114, Map r115, String r210, String r211, Long r212, Integer r213, com.bytedance.applet.event.j r214) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "apiName");
        Intrinsics.checkNotNullParameter(r114, "param");
        Intrinsics.checkNotNullParameter(r210, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r211, "questionId");
        Intrinsics.checkNotNullParameter(r214, "responseCallback");
        this.f192004a.onUIAction(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    @Override // w4.a
    public final void b(String r110, String r111, String r112, String r113, String r114, Map r115, String r210, String r211, Long r212, Integer r213, com.bytedance.applet.event.j r214) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "eventName");
        Intrinsics.checkNotNullParameter(r114, "data");
        Intrinsics.checkNotNullParameter(r210, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r211, "questionId");
        Intrinsics.checkNotNullParameter(r214, "responseCallback");
        this.f192004a.onServerAction(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }
}
