package com.bytedance.applet.debugger;

import com.bytedance.ai.api.DebuggerMode;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class DebuggerConversationCreator {

    public static final class a {
    }

    static {
    }

    public DebuggerConversationCreator() {
    }

    public final Object b(w r210, Continuation<? super x> r211) {
        w r100 = r210;
        if ((r211 instanceof DebuggerConversationCreator$create$1) == false) goto L7;
        DebuggerConversationCreator$create$1 r101 = (DebuggerConversationCreator$create$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L23;
        if (r104 == 1) goto L20;
        if (r104 == 2) goto L17;
        if (r104 != 3) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L62
    L58:
        Object r105 = new x.a("remote_conversation_unavailable", true);     // Catch: Throwable -> L62
    L60:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L62
    L64:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L73;
        FLogger.f375446a.e("DebuggerConversationCreator", "create remote Debugger conversation failed", r107);
        return new x.a("remote_create_failed", true);
    L73:
        return r106;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r108 = (String) r101.L$2;
        DebuggerConversationCreator r109 = (DebuggerConversationCreator) r101.L$1;
        w r111 = (w) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L62
        DebuggerConversationCreator r112 = r109;
        Object r113 = r103;
        Object r114 = r110;
    L46:
        if (r113 == null) goto L48;
        boolean r115 = true;
    L50:
        if (r115 == false) goto L52;
        r105 = new x.b(r108, r111.f191758a);     // Catch: Throwable -> L62
        goto L60
    L52:
        if ((!StringsKt.isBlank(r108)) == false) goto L58;
        if (com.larus.im.j.f(r108) == true) goto L58;
        String r116 = r111.f191758a;     // Catch: Throwable -> L62
        r101.L$0 = null;     // Catch: Throwable -> L62
        r101.L$1 = null;     // Catch: Throwable -> L62
        r101.L$2 = null;     // Catch: Throwable -> L62
        r101.label = 3;     // Catch: Throwable -> L62
        if (r112.a(r108, r116, r101) != r114) goto L58;
        return r114;
    L48:
        String r117 = r108;
        r100 = r111;
    L49:
        r111 = r100;
        r108 = r117;
        r115 = false;
        goto L50
    L20:
        DebuggerConversationCreator r118 = (DebuggerConversationCreator) r101.L$1;
        w r119 = (w) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L62
        r112 = r118;
        r100 = r119;
        Object r120 = r103;
        r114 = r110;
    L32:
        wc9.e r121 = (wc9.e) r120;     // Catch: Throwable -> L62
        if (r121 == null) goto L35;
        r117 = r121.f559198a;     // Catch: Throwable -> L62
    L36:
        if (r117 != null) goto L39;
        r117 = "";
    L39:
        if ((!StringsKt.isBlank(r117)) == false) goto L49;
        if (com.larus.im.j.f(r117) == true) goto L49;
        IConversationRepoService r122 = zh8.a.f572197b;     // Catch: Throwable -> L62
        r101.L$0 = r100;     // Catch: Throwable -> L62
        r101.L$1 = r112;     // Catch: Throwable -> L62
        r101.L$2 = r117;     // Catch: Throwable -> L62
        r101.label = 2;     // Catch: Throwable -> L62
        r113 = IConversationRepoService.a.c(r122, r117, false, null, r101, 6);     // Catch: Throwable -> L62
        if (r113 != r114) goto L45;
        return r114;
    L45:
        r111 = r100;
        r108 = r117;
        goto L46
    L35:
        r117 = null;
        goto L36
    L23:
        ResultKt.throwOnFailure(r103);
        if (StringsKt.isBlank(r100.f191758a) == true) goto L70;
        if (StringsKt.isBlank(r100.f191759b) == true) goto L70;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L62
        IConversationRepoService r124 = zh8.a.f572197b;     // Catch: Throwable -> L62
        String r125 = r100.f191758a;     // Catch: Throwable -> L62
        String r126 = r100.f191759b;     // Catch: Throwable -> L62
        LinkedHashMap r127 = new LinkedHashMap();     // Catch: Throwable -> L62
        r127.put("doubao_miniapp_debug_flag", "true");     // Catch: Throwable -> L62
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L62
        r101.L$0 = r100;     // Catch: Throwable -> L62
        r101.L$1 = this;     // Catch: Throwable -> L62
        r101.label = 1;     // Catch: Throwable -> L62
        r114 = r110;
        r120 = IConversationRepoService.a.a(r124, r125, 3, r126, null, false, null, null, null, r127, r101, 240);     // Catch: Throwable -> L62
        if (r120 != r114) goto L31;
        return r114;
    L31:
        r112 = this;
    L70:
        return new x.a("invalid_create_request", false);
    L62:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new DebuggerConversationCreator$create$1(this, r211);
        goto L8
    }

    public final Object a(String r100, String r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof DebuggerConversationCreator$cleanup$1) == false) goto L7;
        DebuggerConversationCreator$cleanup$1 r103 = (DebuggerConversationCreator$cleanup$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L17;
        if (r107 != 1) goto L16;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L13
    L25:
        Object r108 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r105).booleanValue()));     // Catch: Throwable -> L13
    L28:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L32;
        FLogger.f375446a.e("DebuggerConversationCreator", "cleanup Debugger conversation failed", r109);
    L32:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r105);
        if (StringsKt.isBlank(r100) == true) goto L34;
        if (com.larus.im.j.f(r100) == true) goto L34;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L13
        IConversationRepoService r111 = zh8.a.f572197b;     // Catch: Throwable -> L13
        ConversationDeleteMode r112 = ConversationDeleteMode.DeleteMode_RealDelete;     // Catch: Throwable -> L13
        r103.label = 1;     // Catch: Throwable -> L13
        r105 = r111.l(r100, r112, r101, r103);     // Catch: Throwable -> L13
        if (r105 != r106) goto L25;
        return r106;
    L34:
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new DebuggerConversationCreator$cleanup$1(this, r102);
        goto L8
    }

    public final Object c(String r100, DebuggerMode r110, Continuation<? super Pair<w, ? extends x>> r111) {
        if ((r111 instanceof DebuggerConversationCreator$createFromMainConversation$1) == false) goto L7;
        DebuggerConversationCreator$createFromMainConversation$1 r101 = (DebuggerConversationCreator$createFromMainConversation$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        w r105 = (w) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L41:
        return TuplesKt.to(r105, r112);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        wc9.e r106 = (wc9.e) r101.L$2;
        r110 = (DebuggerMode) r101.L$1;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        String r113 = (String) CollectionsKt.firstOrNull((List) r112);
        if (r113 != null) goto L31;
    L42:
        return null;
    L31:
        if ((!StringsKt.isBlank(r113)) == true) goto L34;
        r113 = null;
    L34:
        if (r113 == null) goto L42;
        w r108 = new w(r113, r106.f559198a, r110, r107);
        r101.L$0 = r108;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 3;
        r112 = b(r108, r101);
        if (r112 != r103) goto L39;
        return r103;
    L39:
        r105 = r108;
        goto L41
    L17:
        r110 = (DebuggerMode) r101.L$1;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L21:
        wc9.e r114 = (wc9.e) r112;
        if (r114 != null) goto L24;
        return null;
    L24:
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r114;
        r101.label = 2;
        Object r109 = ic8.n.c(r114, r101);
        if (r109 != r103) goto L27;
        return r103;
    L27:
        r107 = r100;
        r106 = r114;
        r112 = r109;
        goto L28
    L18:
        ResultKt.throwOnFailure(r112);
        IConversationRepoService r115 = zh8.a.f572197b;
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.label = 1;
        r112 = r115.f(r101);
        if (r112 != r103) goto L21;
        return r103;
    L7:
        r101 = new DebuggerConversationCreator$createFromMainConversation$1(this, r111);
        goto L8
    }
}
