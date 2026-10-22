package com.stepos.ability.voicewakeup.service;

import C7.r;
import com.stepos.agentframework.adapter.coze.CozeClient;
import com.stepos.agentframework.adapter.dify.DifyClient;
import com.stepos.motionkit.fx.backend.GlesRenderer;
import com.stepos.motionkit.fx.backend.sf.SfDrawableUniformSetter;
import com.stepos.taskrobot.dictionary.DictionaryHttpClient;
import com.stepos.taskrobot.llmapi.stepfun.trace.TraceParams;
import com.uxsense.base.metadata.Chat;
import com.uxsense.base.metadata.ChatMessage;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.CommentChunk;
import com.uxsense.base.metadata.CommentIndex;
import com.uxsense.base.metadata.CommentStatus;
import com.uxsense.base.metadata.Creation;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3327a;

    public /* synthetic */ f(int i) {
        this.f3327a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f3327a) {
            case 0:
                l.f3335q++;
                l lVar = l.f3333a;
                l.v(false);
                lVar.l();
                return r.f317a;
            case 1:
                return CozeClient.instance_delegate$lambda$0();
            case 2:
                return DifyClient.instance_delegate$lambda$0();
            case 3:
                return GlesRenderer.releaseGL$lambda$13();
            case 4:
                return SfDrawableUniformSetter.methodSetFloat_delegate$lambda$0();
            case 5:
                return SfDrawableUniformSetter.methodSetFloat2_delegate$lambda$1();
            case 6:
                return SfDrawableUniformSetter.methodSetFloat3_delegate$lambda$2();
            case 7:
                return SfDrawableUniformSetter.methodSetFloat4_delegate$lambda$3();
            case 8:
                return SfDrawableUniformSetter.methodSetInt_delegate$lambda$4();
            case 9:
                return Long.valueOf(System.currentTimeMillis());
            case 10:
                return DictionaryHttpClient.gson_delegate$lambda$0();
            case 11:
                return TraceParams.ACCESS_KEY_delegate$lambda$0();
            case 12:
                return TraceParams.SECRET_KEY_delegate$lambda$0();
            case 13:
                return Chat._childSerializers$_anonymous_();
            case 14:
                return Chat._childSerializers$_anonymous_$0();
            case 15:
                return ChatMessage._childSerializers$_anonymous_();
            case 16:
                return ChatMessage._childSerializers$_anonymous_$0();
            case 17:
                return ChatMessage._childSerializers$_anonymous_$1();
            case 18:
                return Comment._childSerializers$_anonymous_();
            case 19:
                return Comment._childSerializers$_anonymous_$0();
            case 20:
                return CommentChunk._childSerializers$_anonymous_();
            case 21:
                return CommentIndex._childSerializers$_anonymous_();
            case 22:
                return CommentIndex._childSerializers$_anonymous_$0();
            case 23:
                return CommentStatus._init_$_anonymous_();
            case 24:
                return Creation._childSerializers$_anonymous_();
            case 25:
                return Creation._childSerializers$_anonymous_$10();
            case 26:
                return Creation._childSerializers$_anonymous_$11();
            case 27:
                return Creation._childSerializers$_anonymous_$12();
            case 28:
                return Creation._childSerializers$_anonymous_$13();
            default:
                return Creation._childSerializers$_anonymous_$14();
        }
    }
}
