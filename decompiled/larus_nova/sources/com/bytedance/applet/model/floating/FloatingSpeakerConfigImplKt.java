package com.bytedance.applet.model.floating;

import android.app.Activity;
import android.os.Looper;
import android.view.Window;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.media.MediaResourceManager;
import com.larus.utils.t0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class FloatingSpeakerConfigImplKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z f192113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g2.a f192114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f192115c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f192116d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f192117e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f192118f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f192119g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f192120h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Job f192121i;

    public static final class a implements IIMCallback<List<? extends Message>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<List<Message>> f192122a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        public a(kotlinx.coroutines.j r100) {
            this.f192122a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            kotlinx.coroutines.i<List<Message>> r101 = this.f192122a;
            Result.Companion r102 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(CollectionsKt.emptyList()));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends Message> r100) {
            List<? extends Message> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f192122a.resumeWith(Result.m9449constructorimpl(r101));
        }
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.applet.model.floating.f] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.applet.model.floating.o] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.applet.model.floating.r] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.applet.model.floating.d] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.applet.model.floating.s] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.applet.model.floating.t] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.applet.model.floating.u] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.applet.model.floating.v] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.applet.model.floating.w] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.applet.model.floating.x] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.applet.model.floating.y] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedance.applet.model.floating.e] */
    static {
        f192114b = new g2.a(new d(), new s(), new t(), new u(), new v(), new w(), new x(), new y(), new e(), new f(), new o(), new r());
        f192115c = 500;
        f192116d = "1";
        f192117e = "asr_input";
        f192118f = "user_input";
        f192119g = "bot_resp";
        f192120h = 8000;
    }

    public static final void e() {
        z r100 = f192113a;
        if (r100 != null) goto L5;
        return;
    L5:
        f192113a = null;
        if (r100.f192152b == false) goto L9;
        fa9.e.f476067a.f("voice_input", r100.f192151a);
        return;
    L9:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L18;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L19;
        r102.clearFlags(128);
        return;
    L19:
        return;
    L18:
        return;
    L15:
        t0.f375468a.post(new g());
    }

    public static final void b(Message r100) {
        if (com.larus.media.o.a() == false) goto L10;
        MediaResourceManager.a r101 = new MediaResourceManager.a();
        if (r100 == null) goto L7;
        String r102 = r100.getLocalMessageId();
    L8:
        r101.f358958b = r102;
        r101.f358959c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r103 = MediaResourceManager.f358950a;
        MediaResourceManager.d(r101);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public static final void c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FloatingSpeakerConfigImplKt$deleteOnNoAudioContent$1(r100, null), 3, null);
    }

    public static final Object a(String r100, Continuation r110) {
        if ((r110 instanceof FloatingSpeakerConfigImplKt$initChatData$1) == false) goto L7;
        FloatingSpeakerConfigImplKt$initChatData$1 r101 = (FloatingSpeakerConfigImplKt$initChatData$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        JSONArray r105 = (JSONArray) r101.L$1;
        JSONObject r106 = (JSONObject) r101.L$0;
        ResultKt.throwOnFailure(r111);
        JSONObject r107 = r106;
    L18:
        Iterator r112 = ((List) r111).iterator();
    L20:
        if (r112.hasNext() == false) goto L53;
        Message r108 = (Message) r112.next();
        String r109 = r108.getContent();
        if (r109 != null) goto L24;
    L27:
        boolean r113 = true;
    L28:
        if (r113 == true) goto L20;
        if (com.larus.bmhome.chat.bean.d.G0(r108) == false) goto L38;
        if (r108.getContentType() != 1) goto L38;
        if (r108.getSourceFromAsr() == false) goto L38;
        JSONObject r114 = new JSONObject();
        r114.put("type", f192117e);
        r114.put("data", r108.getContent());
        r114.put("time", String.valueOf(r108.getCreateTime()));
        r105.put(r114);
    L38:
        if (com.larus.bmhome.chat.bean.d.G0(r108) == false) goto L47;
        if (r108.getMessageStatusLocal() != 11) goto L47;
        if (r108.getContentType() == 1) goto L47;
        if (r108.getSourceFromAsr() == false) goto L47;
        JSONObject r115 = new JSONObject();
        r115.put("type", f192118f);
        r115.put("data", r108.getContent());
        r115.put("time", String.valueOf(r108.getCreateTime()));
        r105.put(r115);
    L47:
        if (com.larus.bmhome.chat.bean.d.G0(r108) == true) goto L20;
        String r116 = r108.getContent();
        if (r116 == null) goto L20;
        if (r116.length() > f192120h) goto L20;
        JSONObject r117 = new JSONObject();
        r117.put("type", f192119g);
        JSONObject r118 = new JSONObject();
        r118.put("content", r116);
        r118.put("content_type", r108.getContentType());
        Unit r119 = Unit.INSTANCE;
        r117.put("data", r118.toString());
        r117.put("time", String.valueOf(r108.getCreateTime()));
        r105.put(r117);
        goto L20
    L24:
        if (r109.length() == 0) goto L27;
        r113 = false;
        goto L28
    L53:
        r107.put("chat_context", r105);
        ISettingRepoService r120 = zh8.a.f572198c;
        r107.put(SpeechEngineDefines.PARAMS_KEY_ASR_LANGUAGE_STRING, r120.S0());
        r107.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r120.Z(r120.S0()));
        r107.put("speech_language", r120.Q0());
        Object r121 = r107;
    L54:
        return r121;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        JSONObject r122 = new JSONObject();
        JSONArray r123 = new JSONArray();
        r101.L$0 = r122;
        r101.L$1 = r123;
        r101.label = 1;
        Object r124 = d(r100, null, r101);
        r121 = r103;
        if (r124 == r103) goto L54;
        r107 = r122;
        r111 = r124;
        r105 = r123;
    L7:
        r101 = new FloatingSpeakerConfigImplKt$initChatData$1(r110);
        goto L8
    }

    public static final Object d(String r210, wc9.e r211, Continuation<? super List<Message>> r212) {
        if ((r212 instanceof FloatingSpeakerConfigImplKt$getMessageList$1) == false) goto L7;
        FloatingSpeakerConfigImplKt$getMessageList$1 r100 = (FloatingSpeakerConfigImplKt$getMessageList$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        MessageListRequest r105 = (MessageListRequest) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L34:
        return r102;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r107 = r102;
        String r108 = r106;
    L21:
        wc9.e r109 = (wc9.e) r107;
    L23:
        String r110 = r108;
        if (r109 == null) goto L28;
        Integer r111 = r109.f559207j;
        if (r111 == null) goto L28;
        int r112 = r111.intValue();
    L29:
        int r113 = ChatMessageReceiverModel.P;
        boolean r114 = false;
        MessageListRequest r115 = new MessageListRequest(r110, r112, 0, ((Number) com.larus.im.internal.core.message.utils.h.f347869a.getValue()).intValue(), Long.MIN_VALUE, null, r114, 100, null);
        r100.L$0 = r115;
        r100.label = 2;
        kotlinx.coroutines.j r116 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r116.C();
        com.larus.im.d.e().getMessageListFromLocal(r115, new a(r116));
        r102 = r116.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L32:
        if (r102 != r103) goto L34;
        return r103;
    L28:
        r112 = 0;
        goto L29
    L16:
        ResultKt.throwOnFailure(r102);
        if (r211 != null) goto L22;
        IConversationRepoService r117 = zh8.a.f572197b;
        r108 = r210;
        r100.L$0 = r108;
        r100.label = 1;
        r107 = IConversationRepoService.a.c(r117, r210, false, null, r100, 6);
        if (r107 != r103) goto L21;
        return r103;
    L22:
        r108 = r210;
        r109 = r211;
    L7:
        r100 = new FloatingSpeakerConfigImplKt$getMessageList$1(r212);
        goto L8
    }
}
