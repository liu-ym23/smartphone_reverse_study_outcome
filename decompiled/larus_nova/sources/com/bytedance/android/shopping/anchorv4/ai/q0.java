package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.AIChatComponentHandle;
import com.bytedance.android.ec.base.api.ai.AIChatComponentParam;
import com.bytedance.android.ec.base.api.ai.AISnapshotRequest;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.MiniAppConfig;
import com.bytedance.android.ec.base.api.ai.conversation.AIChatSchemaParams;
import com.bytedance.android.ec.base.api.ai.conversation.SchemaResolver;
import com.bytedance.android.shopping.anchorv4.params.PdpAIConversationContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class q0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IECAIHostService f165681a;

    public q0() {
        IECAIHostService.Companion.getClass();
        IECAIHostService r100 = IECAIHostService.a.a();
        Intrinsics.checkNotNullParameter(r100, "hostService");
        this.f165681a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final boolean c() {
        boolean r100 = this.f165681a.isAIInputDelayAttachEnabled(ECAIConstants.SCENE_ECOM_PRODUCT);
        r0.a("isInputDelayAttachEnabled called, result=" + r100);
        return r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final MiniAppConfig getMiniAppConfig() {
        return this.f165681a.getMiniAppConfig();
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final boolean isEnabled() {
        boolean r100 = this.f165681a.isChatComponentEnabled(ECAIConstants.SCENE_ECOM_PRODUCT);
        r0.a("isEnabled called, result=" + r100);
        return r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r0.a("setExcludedFromCapture called, viewId=" + r100.getId() + ", excluded=true");
        this.f165681a.setExcludedFromCapture(r100, true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final AIChatComponentHandle b(String r100) {
        r0.a("createChatComponent called, conversationId=" + r100);
        AIChatComponentHandle r101 = this.f165681a.createChatComponent(AIChatComponentParam.copy$default(AIChatComponentParam.DEFAULT, r100, false, ECAIConstants.SCENE_ECOM_PRODUCT, null, 10, null));
        StringBuilder r102 = new StringBuilder("createChatComponent result, success=");
        if (r101 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r0.a(r102.toString());
        return r101;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final PdpAIConversationContext e(String r110) {
        AIChatSchemaParams r100 = SchemaResolver.parseAIParams(r110);
        String r101 = r100.getConversationId();
        boolean r102 = true;
        String r103 = null;
        if (r101 != null) goto L5;
    L11:
        PdpAIConversationContext r104 = null;
    L12:
        StringBuilder r105 = new StringBuilder("buildConversationContext called, schemaEmpty=");
        if (r110 != null) goto L15;
    L18:
        r105.append(r102);
        r105.append(", conversationId=");
        if (r104 == null) goto L21;
        String r111 = r104.getConversationId();
    L22:
        r105.append(r111);
        r105.append(", originMessageId=");
        if (r104 == null) goto L25;
        String r112 = r104.getOriginMessageId();
    L26:
        r105.append(r112);
        r105.append(", originBcmId=");
        if (r104 == null) goto L29;
        r103 = r104.getOriginBcmId();
    L29:
        r105.append(r103);
        r0.a(r105.toString());
        return r104;
    L25:
        r112 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L15:
        if (StringsKt.isBlank(r110) == true) goto L18;
        r102 = false;
        goto L18
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        String r106 = r101;
    L8:
        if (r106 == null) goto L11;
        r104 = new PdpAIConversationContext(r106, r100.getOriginMessageId(), r100.getOriginBcmId(), false, 8, null);
        goto L12
    L7:
        r106 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final void reportLog(AIStateLogRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f165681a.reportLog(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final void associateSnapshot(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshotId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        this.f165681a.associateSnapshot(r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.p0
    public final void d(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "snapshotId");
        this.f165681a.capture(new AISnapshotRequest(r100, r101));
    }
}
