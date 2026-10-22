package com.stepos.agentframework.adapter.coze;

import C7.f;
import C7.r;
import D7.w;
import J7.c;
import J9.i;
import S7.o;
import V4.AbstractC0262i;
import V4.C0258e;
import V4.C0259f;
import V4.C0260g;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.coze.bean.AgentDetailResult;
import com.stepos.agentframework.adapter.coze.bean.CreateConversation;
import com.stepos.agentframework.adapter.coze.bean.CreateConversationResult;
import com.stepos.agentframework.adapter.coze.bean.LikeBody;
import com.stepos.agentframework.adapter.coze.bean.Message;
import com.stepos.agentframework.adapter.coze.bean.Thinking;
import com.stepos.agentframework.adapter.coze.callback.EventListener;
import com.stepos.agentframework.adapter.coze.util.UriToPathUtil;
import com.stepos.agentframework.adapter.netcore.ILogger;
import j9.AbstractC1607a;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001b\u0010\u0013JB\u0010\"\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\b2 \u0010!\u001a\u001c\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\u0086@¢\u0006\u0004\b\"\u0010#JJ\u0010\"\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2 \u0010!\u001a\u001c\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\u0086@¢\u0006\u0004\b\"\u0010$JJ\u0010\"\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2 \u0010!\u001a\u001c\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\u0086@¢\u0006\u0004\b\"\u0010'J\u0090\u0001\u00106\u001a\u0002052\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\b2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\b\b\u0002\u0010-\u001a\u00020\u00012(\b\u0002\u00100\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001022\u0006\u0010!\u001a\u000204H\u0086@¢\u0006\u0004\b6\u00107J#\u00109\u001a\b\u0012\u0004\u0012\u0002080*2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\f2\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\u0011\u0010A\u001a\u00020\b*\u00020\b¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\bH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\bH\u0002¢\u0006\u0004\bG\u0010FR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001f\u0010Q\u001a\n P*\u0004\u0018\u00010O0O8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010U¨\u0006W"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/CozeClient;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "timeOut", "", BffConstant.Type.Url, "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", "LC7/r;", "init", "(Landroid/content/Context;JLjava/lang/String;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "secretKey", "botId", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult;", "getAgentDetail", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "conversationId", "messageId", "isLike", "feedBack", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "bot_id", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult;", "createConversation", "Ljava/io/File;", BffConstant.Type.File, "Lkotlin/Function3;", "", "", "callback", "uploadFile", "(Ljava/io/File;Ljava/lang/String;LS7/o;LH7/c;)Ljava/lang/Object;", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;LS7/o;LH7/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "uri", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;LS7/o;LH7/c;)Ljava/lang/Object;", "agentId", "cvId", "", "LV4/i;", "query", "tag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "toolOutputs", "chatId", "Lcom/stepos/agentframework/adapter/coze/bean/Thinking;", "thinking", "Lcom/stepos/agentframework/adapter/coze/callback/EventListener;", "LR9/a;", "requestChatStreaming", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/util/HashMap;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/Thinking;Lcom/stepos/agentframework/adapter/coze/callback/EventListener;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/coze/bean/Message;", "query2Messages", "(Ljava/util/List;)Ljava/util/List;", "LU9/a;", "eventSource", "cancel", "(LU9/a;)V", "getAndroid_ID", "(Landroid/content/Context;)Ljava/lang/String;", "md5", "(Ljava/lang/String;)Ljava/lang/String;", "getFileName", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "generateId", "()Ljava/lang/String;", "getUserId", "Lcom/stepos/agentframework/adapter/coze/NetImpl;", "netImpl", "Lcom/stepos/agentframework/adapter/coze/NetImpl;", "getNetImpl", "()Lcom/stepos/agentframework/adapter/coze/NetImpl;", "setNetImpl", "(Lcom/stepos/agentframework/adapter/coze/NetImpl;)V", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "Landroid/content/Context;", "Companion", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CozeClient {
    public static final String BEARER = " Bearer";
    private Context context;
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    public NetImpl netImpl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CozeClient";
    private static final String URL = "https://api.coze.cn/";
    private static final f instance$delegate = kotlin.a.b(LazyThreadSafetyMode.f4885a, new com.stepos.ability.voicewakeup.service.f(1));
    private static final Set<String> conversationIds = new LinkedHashSet();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR!\u0010\u0010\u001a\u00020\n8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/CozeClient$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "URL", "Ljava/lang/String;", "getURL", "()Ljava/lang/String;", "getURL$annotations", "Lcom/stepos/agentframework/adapter/coze/CozeClient;", "instance$delegate", "LC7/f;", "getInstance", "()Lcom/stepos/agentframework/adapter/coze/CozeClient;", "getInstance$annotations", "instance", "TAG", "getTAG", "", "conversationIds", "Ljava/util/Set;", "getConversationIds", "()Ljava/util/Set;", "BEARER", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ void getInstance$annotations() {
        }

        public static /* synthetic */ void getURL$annotations() {
        }

        public final Set<String> getConversationIds() {
            return CozeClient.conversationIds;
        }

        public final CozeClient getInstance() {
            return (CozeClient) CozeClient.instance$delegate.getF4884a();
        }

        public final String getTAG() {
            return CozeClient.TAG;
        }

        public final String getURL() {
            return CozeClient.URL;
        }

        private Companion() {
        }
    }

    @c(c = "com.stepos.agentframework.adapter.coze.CozeClient", f = "CozeClient.kt", l = {290}, m = "requestChatStreaming", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeClient$requestChatStreaming$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CozeClient.this.requestChatStreaming(null, null, null, null, null, null, null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.coze.CozeClient", f = "CozeClient.kt", l = {106}, m = "uploadFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C10851(H7.c<? super C10851> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CozeClient.this.uploadFile(null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.coze.CozeClient", f = "CozeClient.kt", l = {131}, m = "uploadFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CozeClient.this.uploadFile((Context) null, (String) null, (File) null, (o) null, this);
        }
    }

    private final String generateId() {
        String string = UUID.randomUUID().toString();
        k.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getFileName(android.content.Context r10, android.net.Uri r11) {
        /*
            r9 = this;
            java.lang.String r9 = r11.getScheme()
            java.lang.String r0 = "content"
            boolean r9 = kotlin.jvm.internal.k.b(r9, r0)
            r1 = -1
            r2 = 0
            if (r9 == 0) goto L53
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Exception -> L4c
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            r4 = r11
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L49
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch: java.lang.Exception -> L49
            r10 = r9
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L38
            boolean r11 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L35
            if (r11 == 0) goto L38
            java.lang.String r11 = "_display_name"
            int r11 = r10.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L35
            if (r11 == r1) goto L38
            java.lang.String r10 = r10.getString(r11)     // Catch: java.lang.Throwable -> L35
            goto L39
        L35:
            r0 = move-exception
            r10 = r0
            goto L42
        L38:
            r10 = r2
        L39:
            D7.N.t(r9, r2)     // Catch: java.lang.Exception -> L3e
            r2 = r10
            goto L54
        L3e:
            r0 = move-exception
            r9 = r0
            r2 = r10
            goto L4f
        L42:
            throw r10     // Catch: java.lang.Throwable -> L43
        L43:
            r0 = move-exception
            r11 = r0
            D7.N.t(r9, r10)     // Catch: java.lang.Exception -> L49
            throw r11     // Catch: java.lang.Exception -> L49
        L49:
            r0 = move-exception
        L4a:
            r9 = r0
            goto L4f
        L4c:
            r0 = move-exception
            r4 = r11
            goto L4a
        L4f:
            r9.printStackTrace()
            goto L54
        L53:
            r4 = r11
        L54:
            if (r2 != 0) goto L72
            java.lang.String r2 = r4.getPath()
            kotlin.jvm.internal.k.c(r2)
            r9 = 0
            r10 = 6
            r11 = 47
            int r9 = j9.m.v0(r2, r11, r9, r10)
            if (r9 == r1) goto L72
            int r9 = r9 + 1
            java.lang.String r2 = r2.substring(r9)
            java.lang.String r9 = "substring(...)"
            kotlin.jvm.internal.k.e(r2, r9)
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeClient.getFileName(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static final CozeClient getInstance() {
        return INSTANCE.getInstance();
    }

    public static final String getURL() {
        return INSTANCE.getURL();
    }

    private final String getUserId() {
        Context context = this.context;
        if (context != null) {
            return md5(getAndroid_ID(context));
        }
        k.n("context");
        throw null;
    }

    public static /* synthetic */ void init$default(CozeClient cozeClient, Context context, long j5, String str, ILogger iLogger, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 200;
        }
        long j6 = j5;
        if ((i & 4) != 0) {
            str = URL;
        }
        cozeClient.init(context, j6, str, iLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CozeClient instance_delegate$lambda$0() {
        return new CozeClient();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object requestChatStreaming$default(CozeClient cozeClient, String str, String str2, String str3, List list, Object obj, HashMap map, String str4, Thinking thinking, EventListener eventListener, H7.c cVar, int i, Object obj2) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            list = null;
        }
        if ((i & 16) != 0) {
            obj = "";
        }
        if ((i & 32) != 0) {
            map = null;
        }
        if ((i & 64) != 0) {
            str4 = null;
        }
        if ((i & 128) != 0) {
            thinking = null;
        }
        return cozeClient.requestChatStreaming(str, str2, str3, list, obj, map, str4, thinking, eventListener, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadFile$lambda$0(o oVar, long j5, long j6, boolean z10) {
        int i = (int) ((100 * j5) / j6);
        StringBuilder sb = new StringBuilder("上传进度: ");
        sb.append(i);
        sb.append("% (");
        sb.append(j5);
        b.y(j6, "/", "), 是否完成: ", sb);
        sb.append(z10);
        System.out.println((Object) sb.toString());
        oVar.invoke(Integer.valueOf(i), Boolean.FALSE, "");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadFile$lambda$1(o oVar, long j5, long j6, boolean z10) {
        int i = (int) ((100 * j5) / j6);
        if (i > 99) {
            i = 99;
        }
        StringBuilder sb = new StringBuilder("上传进度: ");
        sb.append(i);
        sb.append("% (");
        sb.append(j5);
        b.y(j6, "/", "), 是否完成: ", sb);
        sb.append(z10);
        System.out.println((Object) sb.toString());
        oVar.invoke(Integer.valueOf(i), Boolean.FALSE, "");
        return r.f317a;
    }

    public final void cancel(U9.a eventSource) {
        if (eventSource != null) {
            i iVar = ((R9.a) eventSource).f1160a;
            if (iVar != null) {
                iVar.cancel();
            } else {
                k.n("call");
                throw null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object createConversation(String str, String str2, H7.c<? super CreateConversationResult> cVar) {
        return ((Api) getNetImpl().create(Api.class)).createConversation(B7.a.k(" Bearer ", str), new CreateConversation(str2, null, 2, 0 == true ? 1 : 0), cVar);
    }

    public final Object feedBack(String str, String str2, String str3, String str4, H7.c<? super r> cVar) {
        Api api = (Api) getNetImpl().create(Api.class);
        String strK = B7.a.k(" Bearer ", str);
        LikeBody likeBody = new LikeBody();
        likeBody.setFeedbackType(str4);
        Object objFeedback = api.feedback(strK, str2, str3, likeBody, cVar);
        return objFeedback == CoroutineSingletons.f4909a ? objFeedback : r.f317a;
    }

    public final Object getAgentDetail(String str, String str2, H7.c<? super AgentDetailResult> cVar) {
        return Api.getAgentDetail$default((Api) getNetImpl().create(Api.class), B7.a.k(" Bearer ", str), str2, false, cVar, 4, null);
    }

    public final String getAndroid_ID(Context context) {
        k.f(context, "context");
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        k.e(string, "getString(...)");
        return string;
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final NetImpl getNetImpl() {
        NetImpl netImpl = this.netImpl;
        if (netImpl != null) {
            return netImpl;
        }
        k.n("netImpl");
        throw null;
    }

    public final void init(Context context, long timeOut, String url, ILogger logger) {
        k.f(context, "context");
        k.f(url, "url");
        k.f(logger, "logger");
        setNetImpl(new NetImpl(url, timeOut, logger));
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
    }

    public final String md5(String str) throws NoSuchAlgorithmException {
        k.f(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            k.e(messageDigest, "getInstance(...)");
            byte[] bytes = str.getBytes(AbstractC1607a.f4778a);
            k.e(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            k.e(bArrDigest, "digest(...)");
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            String string = stringBuffer.toString();
            k.e(string, "toString(...)");
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final List<Message> query2Messages(List<? extends AbstractC0262i> query) {
        ArrayList arrayList = new ArrayList();
        List<? extends AbstractC0262i> list = query;
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        List<? extends AbstractC0262i> list2 = query;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (!(((AbstractC0262i) it.next()) instanceof C0260g)) {
                    ArrayList arrayList2 = new ArrayList(w.c0(list2, 10));
                    for (AbstractC0262i abstractC0262i : list2) {
                        MessageItem messageItem = new MessageItem();
                        if (abstractC0262i instanceof C0260g) {
                            messageItem.setType("text");
                            messageItem.setText(((C0260g) abstractC0262i).b);
                        } else if (abstractC0262i instanceof C0259f) {
                            messageItem.setType("image");
                            C0259f c0259f = (C0259f) abstractC0262i;
                            c0259f.getClass();
                            messageItem.setFile_id(null);
                            String str = c0259f.b;
                            messageItem.setText(str != null ? str : null);
                        } else if (abstractC0262i instanceof C0258e) {
                            messageItem.setType(BffConstant.Type.File);
                            messageItem.setText(((C0258e) abstractC0262i).b);
                            messageItem.setFile_id(null);
                        }
                        arrayList2.add(messageItem);
                    }
                    Message message = new Message();
                    message.setContent(this.gson.toJson(arrayList2));
                    message.setContent_type("object_string");
                    return H4.o.M(message);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(w.c0(list2, 10));
        for (AbstractC0262i abstractC0262i2 : list2) {
            Message message2 = new Message();
            k.d(abstractC0262i2, "null cannot be cast to non-null type com.stepos.common.ChatContent.Text");
            message2.setContent(((C0260g) abstractC0262i2).b);
            message2.setContent_type("text");
            arrayList3.add(message2);
        }
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestChatStreaming(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.List<? extends V4.AbstractC0262i> r20, java.lang.Object r21, java.util.HashMap<java.lang.String, java.lang.Object> r22, java.lang.String r23, com.stepos.agentframework.adapter.coze.bean.Thinking r24, com.stepos.agentframework.adapter.coze.callback.EventListener r25, H7.c<? super R9.a> r26) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeClient.requestChatStreaming(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Object, java.util.HashMap, java.lang.String, com.stepos.agentframework.adapter.coze.bean.Thinking, com.stepos.agentframework.adapter.coze.callback.EventListener, H7.c):java.lang.Object");
    }

    public final void setNetImpl(NetImpl netImpl) {
        k.f(netImpl, "<set-?>");
        this.netImpl = netImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadFile(java.io.File r7, java.lang.String r8, S7.o r9, H7.c<? super C7.r> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.coze.CozeClient.C10851
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$1 r0 = (com.stepos.agentframework.adapter.coze.CozeClient.C10851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$1 r0 = new com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r6 = r0.L$5
            F9.C r6 = (F9.C) r6
            java.lang.Object r6 = r0.L$4
            com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody r6 = (com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody) r6
            java.lang.Object r6 = r0.L$3
            F9.K r6 = (F9.K) r6
            java.lang.Object r6 = r0.L$2
            r9 = r6
            S7.o r9 = (S7.o) r9
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.io.File r6 = (java.io.File) r6
            kotlin.b.b(r10)
            goto L9d
        L40:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L48:
            kotlin.b.b(r10)
            F9.J r10 = F9.K.Companion
            java.util.regex.Pattern r2 = F9.B.e
            java.lang.String r2 = "multipart/form-data"
            F9.B r2 = F9.AbstractC0226d.j(r2)
            r10.getClass()
            java.lang.String r10 = "<this>"
            kotlin.jvm.internal.k.f(r7, r10)
            F9.H r10 = new F9.H
            r4 = 0
            r10.<init>(r2, r7, r4)
            com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody r2 = new com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody
            com.stepos.agentframework.adapter.coze.a r5 = new com.stepos.agentframework.adapter.coze.a
            r5.<init>(r9, r4)
            r2.<init>(r10, r5)
            java.lang.String r7 = r7.getName()
            F9.C r7 = F9.AbstractC0226d.d(r7, r2)
            com.stepos.agentframework.adapter.coze.NetImpl r6 = r6.getNetImpl()
            java.lang.Class<com.stepos.agentframework.adapter.coze.Api> r10 = com.stepos.agentframework.adapter.coze.Api.class
            java.lang.Object r6 = r6.create(r10)
            com.stepos.agentframework.adapter.coze.Api r6 = (com.stepos.agentframework.adapter.coze.Api) r6
            java.lang.String r10 = " Bearer "
            java.lang.String r8 = B7.a.k(r10, r8)
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r10
            r0.L$5 = r10
            r0.label = r3
            java.lang.Object r10 = r6.uploadFile(r8, r7, r0)
            if (r10 != r1) goto L9d
            return r1
        L9d:
            com.stepos.agentframework.adapter.coze.bean.UploadFileResult r10 = (com.stepos.agentframework.adapter.coze.bean.UploadFileResult) r10
            java.lang.Integer r6 = new java.lang.Integer
            r7 = 100
            r6.<init>(r7)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            com.stepos.agentframework.adapter.coze.bean.UploadFileResult$Data r8 = r10.getData()
            java.lang.String r8 = r8.getId()
            r9.invoke(r6, r7, r8)
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeClient.uploadFile(java.io.File, java.lang.String, S7.o, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadFile(android.content.Context r5, java.lang.String r6, java.io.File r7, S7.o r8, H7.c<? super C7.r> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof com.stepos.agentframework.adapter.coze.CozeClient.AnonymousClass2
            if (r5 == 0) goto L13
            r5 = r9
            com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2 r5 = (com.stepos.agentframework.adapter.coze.CozeClient.AnonymousClass2) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.label = r0
            goto L18
        L13:
            com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2 r5 = new com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2
            r5.<init>(r9)
        L18:
            java.lang.Object r9 = r5.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L4c
            if (r1 != r2) goto L44
            java.lang.Object r4 = r5.L$6
            F9.C r4 = (F9.C) r4
            java.lang.Object r4 = r5.L$5
            com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody r4 = (com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody) r4
            java.lang.Object r4 = r5.L$4
            F9.K r4 = (F9.K) r4
            java.lang.Object r4 = r5.L$3
            r8 = r4
            S7.o r8 = (S7.o) r8
            java.lang.Object r4 = r5.L$2
            java.io.File r4 = (java.io.File) r4
            java.lang.Object r4 = r5.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r5.L$0
            android.content.Context r4 = (android.content.Context) r4
            kotlin.b.b(r9)
            goto La3
        L44:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L4c:
            kotlin.b.b(r9)
            F9.J r9 = F9.K.Companion
            java.util.regex.Pattern r1 = F9.B.e
            java.lang.String r1 = "multipart/form-data"
            F9.B r1 = F9.AbstractC0226d.j(r1)
            r9.getClass()
            java.lang.String r9 = "<this>"
            kotlin.jvm.internal.k.f(r7, r9)
            F9.H r9 = new F9.H
            r3 = 0
            r9.<init>(r1, r7, r3)
            com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody r1 = new com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody
            com.stepos.agentframework.adapter.coze.a r3 = new com.stepos.agentframework.adapter.coze.a
            r3.<init>(r8, r2)
            r1.<init>(r9, r3)
            java.lang.String r7 = r7.getPath()
            F9.C r7 = F9.AbstractC0226d.d(r7, r1)
            com.stepos.agentframework.adapter.coze.NetImpl r4 = r4.getNetImpl()
            java.lang.Class<com.stepos.agentframework.adapter.coze.Api> r9 = com.stepos.agentframework.adapter.coze.Api.class
            java.lang.Object r4 = r4.create(r9)
            com.stepos.agentframework.adapter.coze.Api r4 = (com.stepos.agentframework.adapter.coze.Api) r4
            java.lang.String r9 = " Bearer "
            java.lang.String r6 = B7.a.k(r9, r6)
            r9 = 0
            r5.L$0 = r9
            r5.L$1 = r9
            r5.L$2 = r9
            r5.L$3 = r8
            r5.L$4 = r9
            r5.L$5 = r9
            r5.L$6 = r9
            r5.label = r2
            java.lang.Object r9 = r4.uploadFile(r6, r7, r5)
            if (r9 != r0) goto La3
            return r0
        La3:
            com.stepos.agentframework.adapter.coze.bean.UploadFileResult r9 = (com.stepos.agentframework.adapter.coze.bean.UploadFileResult) r9
            java.lang.Integer r4 = new java.lang.Integer
            r5 = 100
            r4.<init>(r5)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            com.stepos.agentframework.adapter.coze.bean.UploadFileResult$Data r6 = r9.getData()
            java.lang.String r6 = r6.getId()
            r8.invoke(r4, r5, r6)
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeClient.uploadFile(android.content.Context, java.lang.String, java.io.File, S7.o, H7.c):java.lang.Object");
    }

    public final Object uploadFile(Context context, String str, Uri uri, o oVar, H7.c<? super r> cVar) {
        Object objUploadFile = uploadFile(context, str, new File(UriToPathUtil.getRealPath(context, uri)), oVar, cVar);
        return objUploadFile == CoroutineSingletons.f4909a ? objUploadFile : r.f317a;
    }
}
