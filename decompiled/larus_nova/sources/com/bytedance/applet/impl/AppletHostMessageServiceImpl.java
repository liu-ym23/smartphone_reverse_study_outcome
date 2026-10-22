package com.bytedance.applet.impl;

import android.app.Application;
import android.content.Context;
import com.bytedance.ai.api.model.output.AIOutputContentType;
import com.bytedance.applet.context.ContextManager;
import com.bytedance.applet.event.EventDispatcher;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.applet.utils.PendingPushMessageQueue;
import com.bytedance.applet.utils.SuspendReceiveMessage;
import com.bytedance.applet.utils.WidgetContentManager;
import com.bytedance.common.utility.NetworkUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class AppletHostMessageServiceImpl implements r4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f191832a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191833a = null;

        static {
            int[] r100 = new int[AIOutputContentType.values().length];
            r100[AIOutputContentType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AIOutputContentType.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f191833a = r100;
        }
    }

    static {
    }

    public AppletHostMessageServiceImpl() {
    }

    @Override // r4.h
    public final j2.a j(j2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        AIOutputContentType r101 = r100.getType();
        int r102 = b.f191833a[r101.ordinal()];
        int r103 = 1;
        if (r102 != 1) goto L5;
        r103 = 100;
    L10:
        MessageUtils r104 = MessageUtils.f192258a;
        String r105 = r100.f496897b;
        r104.getClass();
        com.larus.bmhome.chat.model.repo.a2 r106 = MessageUtils.c(r105, r103, null, null);
        return new j2.a(r106.b(), r106.a(), r106.c(), r106.d());
    L5:
        if (r102 == 2) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    @Override // r4.h
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        ContextManager.f191491a.getClass();
        ContextManager.d(r100, r101);
    }

    @Override // r4.h
    public final Object e(String r100, Continuation<? super String> r101) {
        return MessageUtils.f192258a.g(r100, r101);
    }

    @Override // r4.h
    public final void g(Map<String, String> r100, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r100.isEmpty() == false) goto L5;
        String r101 = null;
    L9:
        FLogger.f375446a.d("AppletHostMessageServiceImpl", "createLocalMsg content " + r101);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletHostMessageServiceImpl$createLocalMsg$1(r101, r110, null), 3, null);
        return;
    L5:
        String r102 = r100.get(IFlowAppIntentIDL.PARAM_APPLET_ID);
        String r103 = r100.get("widgetName");
        String r104 = r100.get("widgetData");
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        JSONObject r105 = new JSONObject();
        r105.put("applet_id", r102);
        r105.put("response_for_model", "");
        r105.put("widget_data", r104);
        r105.put("widget_id", r103);
        r101 = r105.toString();
        goto L9
    }

    @Override // r4.h
    public final Object h(j2.b r210, Continuation<? super Boolean> r211) {
        if ((r211 instanceof AppletHostMessageServiceImpl$syncBotReply$1) == false) goto L7;
        AppletHostMessageServiceImpl$syncBotReply$1 r100 = (AppletHostMessageServiceImpl$syncBotReply$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r111 = "createMessage type:";
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        j2.b r104 = (j2.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r105 = "AppletServiceImpl";
        r111 = r111;
    L38:
        Boolean r106 = (Boolean) r102;
        FLogger.f375446a.d(r105, r111 + r104.getType().name() + "  receiveMsgResult " + r106);
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SuspendReceiveMessage r107 = (SuspendReceiveMessage) r100.L$2;
        String r108 = (String) r100.L$1;
        j2.b r109 = (j2.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r105 = "AppletServiceImpl";
    L27:
        boolean r112 = ((Boolean) r102).booleanValue();
        FLogger.f375446a.d(r105, r111 + r109.getType().name() + " saveBotResult " + r112);
        if (r112 == true) goto L34;
        r107.getClass();
        EventDispatcher r113 = EventDispatcher.f191774a;
        SuspendReceiveMessage.a r114 = r107.f192274c;
        Intrinsics.checkNotNullParameter(r114, "listener");
        EventDispatcher.f191781h.remove(r114);
        Function1<? super Boolean, Unit> r115 = r107.f192272a;
        if (r115 == null) goto L33;
        r115.invoke(Boolean.FALSE);
    L33:
        return Boxing.boxBoolean(false);
    L34:
        r100.L$0 = r109;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 2;
        r102 = r107.a(r108, r100);
        if (r102 != r110) goto L37;
        return r110;
    L37:
        r104 = r109;
        goto L38
    L16:
        ResultKt.throwOnFailure(r102);
        int r116 = wf9.b.f559489a;
        String r117 = com.flow.kmp.common.util.i.a();
        SuspendReceiveMessage r118 = new SuspendReceiveMessage();
        EventDispatcher r119 = EventDispatcher.f191774a;
        SuspendReceiveMessage.a r120 = r118.f192274c;
        Intrinsics.checkNotNullParameter(r120, "listener");
        EventDispatcher.f191781h.add(r120);
        int r121 = b.f191833a[r210.getType().ordinal()];
        if (r121 == 1) goto L22;
        if (r121 != 2) goto L21;
        int r122 = 1;
    L23:
        MessageUtils r123 = MessageUtils.f192258a;
        String r124 = r210.f496899d;
        String r125 = r210.f496901f;
        String r126 = r210.f496900e;
        String r127 = r210.f496897b;
        List<String> r128 = r210.f496903h;
        boolean r129 = r210.f496902g;
        Map<String, String> r130 = r210.f496898c;
        List<String> r131 = r210.f496904i;
        r100.L$0 = r210;
        r100.L$1 = r117;
        r100.L$2 = r118;
        r100.label = 1;
        r123.getClass();
        r107 = r118;
        r105 = "AppletServiceImpl";
        Object r132 = r123.b(r124, r125, r126, CollectionsKt.listOf(MessageUtils.c(r127, r122, r130, r117)), r128, r129, r131, r100);
        if (r132 != r110) goto L26;
        return r110;
    L26:
        r109 = r210;
        r108 = r117;
        r102 = r132;
        goto L27
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r122 = 100;
    L7:
        r100 = new AppletHostMessageServiceImpl$syncBotReply$1(this, r211);
        goto L8
    }

    @Override // r4.h
    public final void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        EventDispatcher r102 = EventDispatcher.f191774a;
        Intrinsics.checkNotNullParameter(r100, "botId");
        EventDispatcher.a r103 = EventDispatcher.k(r100);
        boolean r104 = true;
        r103.f191784b = true;
        r103.f191785c = true;
        jw3.c r105 = jw3.c.f500706a;
        jw3.a r106 = jw3.c.a();
        if (r106 != null) goto L5;
    L7:
        boolean r107 = false;
    L8:
        r103.f191786d = r107;
        if (r101 != null) goto L11;
    L14:
        if (r104 == true) goto L17;
        ((ConcurrentHashMap) EventDispatcher.f191779f).put(r101, r100);
        return;
    L17:
        return;
    L11:
        if (r101.length() == 0) goto L14;
        r104 = false;
        goto L14
    L5:
        if (r106.k() != true) goto L7;
        r107 = true;
        goto L8
    }

    @Override // r4.h
    public final void l(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        Intrinsics.checkNotNullParameter(r111, "msg");
        com.larus.bmhome.chat.model.repo.u1 r100 = zh8.a.f572196a.u1();
        MessageStatus r101 = MessageStatus.MessageStatus_INVISIBLE;
        com.larus.bmhome.chat.model.repo.u1.a.f(r100, r111, r110, "", MapsKt.mapOf(TuplesKt.to("hidden_force_context", "1")), new y(), r101, null, false, null, "utils#sendTextMessage", null, null, null, false, 27528);
    }

    public static final void n(Ref.ObjectRef<Application.ActivityLifecycleCallbacks> r100, Ref.ObjectRef<String> r101, Application r102) {
        Application.ActivityLifecycleCallbacks r103 = r100.element;
        if (r103 == null) goto L5;
        r102.unregisterActivityLifecycleCallbacks(r103);
    L5:
        r100.element = null;
        r101.element = null;
    }

    @Override // r4.h
    public final Object a(Context r110, String r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof AppletHostMessageServiceImpl$clearContext$1) == false) goto L7;
        AppletHostMessageServiceImpl$clearContext$1 r100 = (AppletHostMessageServiceImpl$clearContext$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L19:
        boolean r114 = ub8.d.a((ub8.b) r113);
    L22:
        return Boxing.boxBoolean(r114);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (NetworkUtils.isNetworkAvailable(r110) == false) goto L20;
        IConversationRepoService r115 = zh8.a.f572197b;
        IConversationRepoService.a.f(r115, r111, false, false, OmniBreakReason.OmniBreakReason_CLEAR_CONTEXT, 6);
        r100.label = 1;
        r113 = r115.n(r111, 3, "applet_service", r100);
        if (r113 != r102) goto L19;
        return r102;
    L20:
        r114 = false;
    L7:
        r100 = new AppletHostMessageServiceImpl$clearContext$1(this, r112);
        goto L8
    }

    @Override // r4.h
    public final void m(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r112, ControlRule.KEY_EXTRA_DATA);
        FLogger r100 = FLogger.f375446a;
        r100.i("AppletHostMessageServiceImpl", "sendFollowUpMessage, conversationId: " + r110 + ", prompt: " + r111 + ", extraData: " + r112);
        if (StringsKt.isBlank(r111) == false) goto L6;
        r100.w("AppletHostMessageServiceImpl", "sendFollowUpMessage skip, prompt is blank");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppletHostMessageServiceImpl$sendFollowUpMessage$1(r110, r111, r112, this, null), 3, null);
    }

    @Override // r4.h
    public final Object c(String r100, int r101, String r102, String r110, Continuation<? super Boolean> r111) {
        return MessageUtils.f192258a.m(r100, r101, r102, r110, r111);
    }

    @Override // r4.h
    public final void d(String r100, String r101, String r102, Map<String, String> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "cvsId");
        Intrinsics.checkNotNullParameter(r102, "botID");
        MessageUtils.f192258a.getClass();
        MessageUtils.l(r100, r101, r102, r103, r104);
    }

    @Override // r4.h
    public final Object f(String r100, String r101, String r102, String r110, Continuation<? super Boolean> r111) {
        WidgetContentManager r103 = WidgetContentManager.f192277a;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return r103.c(r100, r101, r102, r110, r111);
    }

    @Override // r4.h
    public final void i(String r100, String r101, String r102, List<j2.a> r110, List<String> r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r110, "messageContents");
        Map<String, List<PendingPushMessageQueue.a>> r103 = PendingPushMessageQueue.f192263a;
        List<j2.a> r113 = r110;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L4:
        if (r114.hasNext() == false) goto L6;
        j2.a r105 = (j2.a) r114.next();
        r104.add(new com.larus.bmhome.chat.model.repo.a2(r105.b(), r105.a(), r105.c(), r105.d()));
        goto L4
    L6:
        PendingPushMessageQueue.b(r100, r101, r102, r104, r111, r112);
    }
}
