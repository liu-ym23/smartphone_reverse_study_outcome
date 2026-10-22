package com.obric.agent.message;

import com.obric.agent.im.c;
import com.obric.agent.im.d;
import com.obric.agent.k;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.BlockContent;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.TextBlock;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.memorydata.sdk.memory.MemoryServiceProxy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.n;
import d.n.j;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MessageCollectServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageCollectServiceImpl implements d, IMessageCollectService {
    private static final int BLOCK_TYPE_ARTIFACT = 10030;
    private static final int BLOCK_TYPE_ATTACHMENT = 10052;
    private static final int BLOCK_TYPE_DEEP_THINK = 10040;
    private static final int BLOCK_TYPE_FILE = 10020;
    private static final int BLOCK_TYPE_FILE_OPERATION = 10019;
    private static final int BLOCK_TYPE_GEN_IMAGE = 10010;
    private static final int BLOCK_TYPE_HEADER_TEXT = 10003;
    private static final int BLOCK_TYPE_IMAGE = 10012;
    private static final int BLOCK_TYPE_LYNX = 10067;
    private static final int BLOCK_TYPE_MEMORY = 10055;
    private static final int BLOCK_TYPE_TEXT = 10000;
    private static final int BLOCK_TYPE_WIDGET = 10017;
    private static final String COLLECTION_ID = "collection_id";
    private static final String CONTENT_TYPE_FILE = "file";
    private static final String CONTENT_TYPE_IMAGE = "image";
    private static final String CONTENT_TYPE_TEXT = "text";
    private static final String CONTENT_TYPE_UNKNOWN = "unknown";
    private static final String CONTENT_TYPE_WIDGET = "widget";
    public static final a Companion = null;
    private static final String DORA_SUB_BIZ_G = "DoraG";
    private static final String EXT_KEY_DORA_SUB_BIZ = "dora_sub_biz";
    private static final String KEY_COLLECTION_ID = "collectionId";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_CONTENT_TYPE = "contentType";
    private static final String KEY_CONTENT_VALUE = "contentValue";
    private static final String KEY_CREATE_TIME = "createTime";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_OMNI_ID = "omniId";
    private static final String KEY_OMNI_STATE = "omniState";
    private static final String KEY_REPLY_ID = "replyId";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_TYPE = "type";
    private static final String SOURCE_DORA_G = "doraG";
    private static final String TAG = "MessageCollectServiceIm";
    private static final String TYPE_NORMAL = "normal";
    private static final String TYPE_OMNI = "omni";
    private final am scope;

    /* JADX INFO: compiled from: MessageCollectServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MessageCollectServiceImpl.kt */
    @f(b = "MessageCollectServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.message.MessageCollectServiceImpl$reportMessageToMemory$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MessageCollectServiceImpl f15198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IMMessage f15199c;

        b(MessageCollectServiceImpl r3, IMMessage r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15198b = r3;
            this.f15199c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f15198b, this.f15199c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15197a != 0) goto L11;
            o.a(r4);
            JSONArray r5 = MessageCollectServiceImpl.access$buildContentArray(this.f15198b, this.f15199c);
            if (r5.length() != 0) goto L8;
            ISecureLogDepend.Companion.w(MessageCollectServiceImpl.TAG, "reportMessage content is empty, skip");
            return x.f38692a;
        L8:
            String r3 = MessageCollectServiceImpl.access$buildMemoryJson(this.f15198b, this.f15199c, r5);
            ISecureLogDepend.Companion.i(MessageCollectServiceImpl.TAG, "reportMessageToMemory json = " + r3);
            MemoryServiceProxy.f33843a.a(r3);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ String lambda$7QrbOnUCG7sIp3p6UCnCcJ78O2w(Block r0) {
        return extractMainText$lambda$13(r0);
    }

    public static /* synthetic */ boolean lambda$9f_rQKUK1ym2kuJNCTTZEhEdGyM(String r0) {
        return extractMainText$lambda$14(r0);
    }

    /* JADX INFO: renamed from: lambda$C-0AO4-NQf_rYwpPF5BRiFKPyDo, reason: not valid java name */
    public static /* synthetic */ boolean m90lambda$C0AO4NQf_rYwpPF5BRiFKPyDo(String r0) {
        return buildBlockContentArray$lambda$6(r0);
    }

    public static /* synthetic */ boolean lambda$UW4czVQx4P9ld75yszqanyFi988(Block r0) {
        return extractMainText$lambda$12(r0);
    }

    public static /* synthetic */ Thread lambda$htWtPZYeeeoe_jkXRurCh0kXokI(Runnable r0) {
        return scope$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$pcthNpLHkwuRxFB2h-ZfCE8sKPA, reason: not valid java name */
    public static /* synthetic */ boolean m91lambda$pcthNpLHkwuRxFB2hZfCE8sKPA(Block r0) {
        return extractMainText$lambda$11(r0);
    }

    public static /* synthetic */ String lambda$vGTTh91FGHpot9LYp9JfmZ1mqWQ(MessageCollectServiceImpl r0, Block r1) {
        return buildBlockContentArray$lambda$5(r0, r1);
    }

    private final String mapBlockType(int r1) {
        if (r1 != 10000) goto L5;
    L28:
        return CONTENT_TYPE_TEXT;
    L5:
        if (r1 == 10003) goto L28;
        if (r1 != 10010) goto L9;
    L27:
        return CONTENT_TYPE_IMAGE;
    L9:
        if (r1 == 10012) goto L27;
        if (r1 != 10017) goto L13;
    L26:
        return CONTENT_TYPE_WIDGET;
    L13:
        if (r1 != BLOCK_TYPE_ARTIFACT) goto L15;
    L25:
        return CONTENT_TYPE_FILE;
    L15:
        if (r1 == BLOCK_TYPE_ATTACHMENT) goto L25;
        if (r1 == BLOCK_TYPE_MEMORY) goto L26;
        if (r1 == BLOCK_TYPE_LYNX) goto L26;
        if (r1 == 10019) goto L25;
        if (r1 == 10020) goto L25;
        return "unknown";
    }

    private final String mapContentType(int r1) {
        if (r1 != 1) goto L5;
    L16:
        return CONTENT_TYPE_TEXT;
    L5:
        if (r1 == 11) goto L16;
        if (r1 != 100) goto L9;
        return CONTENT_TYPE_WIDGET;
    L9:
        if (r1 != 6) goto L11;
        return CONTENT_TYPE_IMAGE;
    L11:
        if (r1 == 7) goto L13;
        return "unknown";
    L13:
        return CONTENT_TYPE_FILE;
    }

    @Override // com.obric.agent.im.d
    public void onRegenMessage(IMMessage r1) {
        d.h.b.o.e(r1, "message");
    }

    public MessageCollectServiceImpl() {
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$MessageCollectServiceImpl$htWtPZYeeeoe_jkXRurCh0kXokI.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        this.scope = an.a((g) ZeusTransformUtils.preCheckCast(br.a(r0), g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ JSONArray access$buildContentArray(MessageCollectServiceImpl r0, IMMessage r1) {
        return r0.buildContentArray(r1);
    }

    public static final /* synthetic */ String access$buildMemoryJson(MessageCollectServiceImpl r0, IMMessage r1, JSONArray r2) {
        return r0.buildMemoryJson(r1, r2);
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "message-collect-dispatcher");
    }

    @Override // com.obric.agent.message.IMessageCollectService
    public void start() {
        k.f15191a.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.im.d
    public void onSendMessage(IMMessage r3) {
        d.h.b.o.e(r3, "message");
        if (r3.getMessageStatusLocal() != 11) goto L6;
        reportMessageToMemory(r3);
        return;
    }

    @Override // com.obric.agent.im.d
    public void onReceiveMessage(IMMessage r2) {
        d.h.b.o.e(r2, "message");
        reportReceivedIfFinal(r2);
    }

    @Override // com.obric.agent.im.d
    public void onUpdateMessage(IMMessage r3) {
        d.h.b.o.e(r3, "message");
        if (isDoraGMessage(r3) == true) goto L5;
    L8:
        reportReceivedIfFinal(r3);
        return;
    L5:
        if (com.obric.agent.message.a.a(r3.getUserType(), r3.getMessageStatusLocal()) == false) goto L8;
        reportMessageToMemory(r3);
    }

    @Override // com.obric.agent.im.d
    public void onInsertMessageList(List<IMMessage> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "messageList");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        reportMessageToMemory((IMMessage) ZeusTransformUtils.preCheckCast(r6.next(), IMMessage.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void reportReceivedIfFinal(IMMessage r3) {
        if (r3.getMessageStatusLocal() != 21) goto L6;
        reportMessageToMemory(r3);
        return;
    }

    private final void reportMessageToMemory(IMMessage r10) {
        if (r10.getMessageStatus() == c.f14586c.f14589b) goto L6;
        ISecureLogDepend.Companion.w(TAG, "reportMessage is invisible, skip");
        return;
    L6:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getContent(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L22;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r10.getContentBlock(), Collection.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L17;
    L18:
        r1 = true;
    L19:
        if (r1 == false) goto L22;
        ISecureLogDepend.Companion.w(TAG, "reportMessage has no content and contentBlock, skip");
        return;
    L17:
        if (r3.isEmpty() == false) goto L19;
    L22:
        i.a(this.scope, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L9:
        if (r0.length() == 0) goto L12;
        r2 = false;
        goto L13
    }

    private final String buildMemoryJson(IMMessage r10, JSONArray r11) {
        Map<String, String> r0 = r10.getExt();
        Object r1 = null;
        if (r0 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L6:
        Object r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r0 == null) goto L11;
        Object r5 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        JSONObject r6 = new JSONObject();
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getMessageId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r7.length() != 0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        r7 = r10.getLocalMessageId();
    L20:
        r6.put(KEY_MESSAGE_ID, r7);
        Object r9 = r10.getReplyId();
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        r6.put(KEY_REPLY_ID, r9);
        if (r0 == null) goto L26;
        r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(COLLECTION_ID), String.class, "com.obric.aiagent.plugin");
    L26:
        if (r1 == null) goto L29;
        r4 = r1;
    L29:
        r6.put(KEY_COLLECTION_ID, r4);
        r6.put(KEY_CREATE_TIME, r10.getCreateTime());
        r6.put("type", resolveTaskType(r0, r3));
        r6.put(KEY_OMNI_ID, r3);
        r6.put(KEY_OMNI_STATE, r5);
        r6.put("content", r11);
        String r12 = r6.toString();
        d.h.b.o.c(r12, "toString(...)");
        return r12;
    L17:
        r8 = false;
        goto L18
    L11:
        r5 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    private final boolean isDoraGMessage(IMMessage r2) {
        Map<String, String> r1 = r2.getExt();
        if (r1 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(EXT_KEY_DORA_SUB_BIZ), String.class, "com.obric.aiagent.plugin");
    L7:
        return d.h.b.o.a(r3, DORA_SUB_BIZ_G);
    L5:
        r3 = null;
        goto L7
    }

    private final String resolveTaskType(Map<String, String> r2, String r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        int r5 = ((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length();
        boolean r6 = true;
        if (r5 <= 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
    L17:
        if (r6 == false) goto L19;
        return TYPE_OMNI;
    L19:
        return "normal";
    L12:
        if (d.h.b.o.a(r4, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == true) goto L17;
        if (d.h.b.o.a(r4, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == true) goto L17;
        r6 = false;
        goto L17
    L9:
        r7 = false;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private final JSONArray buildContentArray(IMMessage r6) {
        Map<String, String> r0 = r6.getExt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get(EXT_KEY_DORA_SUB_BIZ), String.class, "com.obric.aiagent.plugin");
    L7:
        if (d.h.b.o.a(r2, DORA_SUB_BIZ_G) == false) goto L9;
        String r3 = SOURCE_DORA_G;
    L11:
        if (r6.isBlockType() == true) goto L13;
        String r4 = mapContentType(r6.getContentType());
        JSONArray r5 = new JSONArray();
        if (d.h.b.o.a(r4, CONTENT_TYPE_TEXT) == false) goto L17;
        r1 = com.obric.agent.im.b.a(r6);
    L17:
        r5.put(buildContentItem(r4, r1, r3));
        return r5;
    L13:
        return buildBlockContentArray(r6, r3);
    L9:
        r3 = null;
        goto L11
    L5:
        r2 = null;
        goto L7
    }

    private final JSONArray buildBlockContentArray(IMMessage r5, String r6) {
        List<Block> r7 = resolveBlocks(r5);
        JSONArray r0 = new JSONArray();
        String r1 = extractMainText(r7);
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        r0.put(buildContentItem(CONTENT_TYPE_TEXT, r1, r6));
    L11:
        if (r7 == null) goto L24;
        j r8 = p.y((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L24;
        j r9 = d.n.m.d(r8, new $$Lambda$MessageCollectServiceImpl$vGTTh91FGHpot9LYp9JfmZ1mqWQ(this));
        if (r9 == null) goto L24;
        j r10 = d.n.m.a(r9, $$Lambda$MessageCollectServiceImpl$C0AO4NQf_rYwpPF5BRiFKPyDo.INSTANCE);
        if (r10 == null) goto L24;
        j r11 = d.n.m.j(r10);
        if (r11 == null) goto L24;
        Iterator r12 = r11.a();
    L22:
        if (r12.hasNext() == false) goto L24;
        r0.put(buildContentItem((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin"), null, r6));
    L24:
        return r0;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private static final String buildBlockContentArray$lambda$5(MessageCollectServiceImpl r1, Block r2) {
        d.h.b.o.e(r2, "it");
        return r1.mapBlockType(r2.getBlockType());
    }

    private static final boolean buildBlockContentArray$lambda$6(String r1) {
        d.h.b.o.e(r1, "it");
        return !d.h.b.o.a(r1, CONTENT_TYPE_TEXT);
    }

    private final List<Block> resolveBlocks(IMMessage r5) {
        List<Block> r0 = r5.getContentBlock();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        String r6 = r5.getContent();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L10;
    L13:
        Object r3 = null;
        if (r1 == false) goto L26;
        return null;
    L26:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L18
        MessageCollectServiceImpl r7 = (MessageCollectServiceImpl) ZeusTransformUtils.preCheckCast(this, MessageCollectServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Object r8 = n.f((List) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r6, new MessageCollectServiceImpl$resolveBlocks$2$1().getType()), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
    L20:
        Throwable r9 = n.c(r8);
        if (r9 != null) goto L23;
        r3 = r8;
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L23:
        ISecureLogDepend.Companion.w(TAG, "resolveBlocks parse content failed: " + r9.getMessage());
    L18:
        th = move-exception;
        n.a r10 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L20
    L10:
        if (r2.length() == 0) goto L13;
        r1 = false;
        goto L13
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
        return r0;
    }

    private final String extractMainText(List<Block> r12) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        CharSequence r13 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(d.n.m.a(d.n.m.a(d.n.m.e(d.n.m.a(d.n.m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$MessageCollectServiceImpl$pcthNpLHkwuRxFB2hZfCE8sKPA.INSTANCE), $$Lambda$MessageCollectServiceImpl$UW4czVQx4P9ld75yszqanyFi988.INSTANCE), $$Lambda$MessageCollectServiceImpl$7QrbOnUCG7sIp3p6UCnCcJ78O2w.INSTANCE), $$Lambda$MessageCollectServiceImpl$9f_rQKUK1ym2kuJNCTTZEhEdGyM.INSTANCE), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null), CharSequence.class, "com.obric.aiagent.plugin");
        if (r14.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        r13 = r14;
    L13:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L8:
        r1 = false;
        goto L9
    }

    private static final boolean extractMainText$lambda$11(Block r3) {
        d.h.b.o.e(r3, "it");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getParentId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (r3.getBlockType() != BLOCK_TYPE_DEEP_THINK) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final boolean extractMainText$lambda$12(Block r2) {
        d.h.b.o.e(r2, "it");
        if (r2.getBlockType() != 10000) goto L5;
    L8:
        return true;
    L5:
        if (r2.getBlockType() == 10003) goto L8;
        return false;
    }

    private static final String extractMainText$lambda$13(Block r1) {
        d.h.b.o.e(r1, "it");
        BlockContent r2 = r1.getContent();
        if (r2 == null) goto L7;
        TextBlock r3 = r2.getTextBlock();
        if (r3 == null) goto L7;
        return r3.text;
    L7:
        return null;
    }

    private static final boolean extractMainText$lambda$14(String r2) {
        d.h.b.o.e(r2, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final JSONObject buildContentItem(String r2, String r3, String r4) {
        JSONObject r1 = new JSONObject();
        r1.put(KEY_CONTENT_TYPE, r2);
        if (d.h.b.o.a(r2, CONTENT_TYPE_TEXT) == false) goto L7;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r1.put(KEY_CONTENT_VALUE, r3);
    L7:
        if (r4 == null) goto L9;
        r1.put("source", r4);
    L9:
        return r1;
    }
}
