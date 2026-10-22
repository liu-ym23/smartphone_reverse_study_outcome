package com.stepos.taskrobot.llmapi.stepfun;

import java.util.Map;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.android.llm.base.ContentBuilder;
import stepai.android.llm.base.ImageContentBuilder;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4041a = 1;
    public final /* synthetic */ ZyqlStepService b;
    public final /* synthetic */ MessageContent c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ Map e;

    public /* synthetic */ o(ZyqlStepService zyqlStepService, MessageContent.Image image, Map map, Map map2) {
        this.b = zyqlStepService;
        this.c = image;
        this.d = map;
        this.e = map2;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4041a) {
            case 0:
                return ZyqlStepService.chat$lambda$2$0$0$0$0(this.c, this.b, this.d, this.e, (ContentBuilder) obj);
            default:
                return ZyqlStepService.chat$lambda$2$0$0$0$0$0(this.b, this.c, this.d, this.e, (ImageContentBuilder) obj);
        }
    }

    public /* synthetic */ o(MessageContent messageContent, ZyqlStepService zyqlStepService, Map map, Map map2) {
        this.c = messageContent;
        this.b = zyqlStepService;
        this.d = map;
        this.e = map2;
    }
}
