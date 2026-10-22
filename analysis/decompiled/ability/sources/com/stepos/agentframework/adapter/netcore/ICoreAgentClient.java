package com.stepos.agentframework.adapter.netcore;

import C7.r;
import H7.c;
import S7.p;
import V4.A;
import V4.AbstractC0255b;
import V4.B;
import V4.C;
import V4.C0254a;
import V4.D;
import V4.E;
import V4.F;
import V4.G;
import V4.H;
import V4.I;
import V4.l;
import V4.q;
import V4.x;
import V4.y;
import V4.z;
import android.content.Context;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016JH\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00172&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00060\u0018H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\n\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020%H\u0096@¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020%H\u0096@¢\u0006\u0004\b(\u0010'J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020)H\u0096@¢\u0006\u0004\b*\u0010+J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020,H\u0096@¢\u0006\u0004\b-\u0010.J\u0018\u00100\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020/H\u0096@¢\u0006\u0004\b0\u00101J\u0018\u00103\u001a\u00020\u00112\u0006\u0010\n\u001a\u000202H\u0096@¢\u0006\u0004\b3\u00104J\u0018\u00106\u001a\u00020\u00112\u0006\u0010\n\u001a\u000205H\u0096@¢\u0006\u0004\b6\u00107J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\n\u001a\u000208H\u0096@¢\u0006\u0004\b9\u0010:J\u0018\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020;H\u0096@¢\u0006\u0004\b=\u0010>J\u0018\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001aH\u0096@¢\u0006\u0004\bB\u0010AJ \u0010D\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001aH\u0096@¢\u0006\u0004\bD\u0010EJ\u0010\u0010G\u001a\u00020FH\u0096@¢\u0006\u0004\bG\u0010HJ\u0012\u0010I\u001a\u0004\u0018\u00010\u001aH\u0096@¢\u0006\u0004\bI\u0010HJ\u001a\u0010K\u001a\u0004\u0018\u00010\u001a2\u0006\u0010J\u001a\u00020\u001aH\u0096@¢\u0006\u0004\bK\u0010AJ \u0010M\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u001aH\u0096@¢\u0006\u0004\bM\u0010EJ\u001a\u0010O\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020\u001aH\u0096@¢\u0006\u0004\bO\u0010AJ \u0010P\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u001aH\u0096@¢\u0006\u0004\bP\u0010EJ\u000f\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010RR\u0014\u0010J\u001a\u00020S8&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006VÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", "LC7/r;", "init", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "listener", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "LV4/q;", "", "feedback", "(LV4/q;LH7/c;)Ljava/lang/Object;", "LV4/I;", "vote", "(LV4/I;LH7/c;)Ljava/lang/Object;", "LV4/H;", "Lkotlin/Function4;", "", "", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "uploadFile", "(Landroid/content/Context;LV4/H;LS7/p;LH7/c;)Ljava/lang/Object;", "LV4/b;", "LV4/a;", "getAgentDetail", "(LV4/b;LH7/c;)Ljava/lang/Object;", "isAvailable", "onNetworkChanged", "(Z)V", "LV4/F;", "pauseTask", "(LV4/F;LH7/c;)Ljava/lang/Object;", "resumeTask", "LV4/C;", "deleteTask", "(LV4/C;LH7/c;)Ljava/lang/Object;", "LV4/E;", "renameTask", "(LV4/E;LH7/c;)Ljava/lang/Object;", "LV4/A;", "batchDeleteTasks", "(LV4/A;LH7/c;)Ljava/lang/Object;", "LV4/G;", "retryTask", "(LV4/G;LH7/c;)Ljava/lang/Object;", "LV4/B;", "cancelTask", "(LV4/B;LH7/c;)Ljava/lang/Object;", "LV4/D;", "interactTask", "(LV4/D;LH7/c;)Ljava/lang/Object;", "LV4/y;", "LV4/z;", "syncHistory", "(LV4/y;LH7/c;)Ljava/lang/Object;", "sessionKey", "deleteSession", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "clearSession", "title", "renameSession", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "LV4/x;", "syncConversations", "(LH7/c;)Ljava/lang/Object;", "createSession", "type", "readCoreFile", "content", "writeCoreFile", SingleFileBundle.KEY_PATH, "readFile", "writeFile", "destroy", "()V", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICoreAgentClient {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object batchDeleteTasks(ICoreAgentClient iCoreAgentClient, A a3, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.batchDeleteTasks(a3, cVar);
        }

        @Deprecated
        public static Object cancelTask(ICoreAgentClient iCoreAgentClient, B b, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.cancelTask(b, cVar);
        }

        @Deprecated
        public static Object clearSession(ICoreAgentClient iCoreAgentClient, String str, c<? super r> cVar) {
            return ICoreAgentClient.super.clearSession(str, cVar);
        }

        @Deprecated
        public static Object createSession(ICoreAgentClient iCoreAgentClient, c<? super String> cVar) {
            return ICoreAgentClient.super.createSession(cVar);
        }

        @Deprecated
        public static Object deleteSession(ICoreAgentClient iCoreAgentClient, String str, c<? super r> cVar) {
            return ICoreAgentClient.super.deleteSession(str, cVar);
        }

        @Deprecated
        public static Object deleteTask(ICoreAgentClient iCoreAgentClient, C c, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.deleteTask(c, cVar);
        }

        @Deprecated
        public static void destroy(ICoreAgentClient iCoreAgentClient) {
            ICoreAgentClient.super.destroy();
        }

        @Deprecated
        public static Object feedback(ICoreAgentClient iCoreAgentClient, q qVar, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.feedback(qVar, cVar);
        }

        @Deprecated
        public static Object getAgentDetail(ICoreAgentClient iCoreAgentClient, AbstractC0255b abstractC0255b, c<? super C0254a> cVar) {
            return ICoreAgentClient.super.getAgentDetail(abstractC0255b, cVar);
        }

        @Deprecated
        public static void init(ICoreAgentClient iCoreAgentClient, Context context, ILogger logger) {
            k.f(context, "context");
            k.f(logger, "logger");
            ICoreAgentClient.super.init(context, logger);
        }

        @Deprecated
        public static Object interactTask(ICoreAgentClient iCoreAgentClient, D d, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.interactTask(d, cVar);
        }

        @Deprecated
        public static void onNetworkChanged(ICoreAgentClient iCoreAgentClient, boolean z10) {
            ICoreAgentClient.super.onNetworkChanged(z10);
        }

        @Deprecated
        public static Object pauseTask(ICoreAgentClient iCoreAgentClient, F f, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.pauseTask(f, cVar);
        }

        @Deprecated
        public static Object readCoreFile(ICoreAgentClient iCoreAgentClient, String str, c<? super String> cVar) {
            return ICoreAgentClient.super.readCoreFile(str, cVar);
        }

        @Deprecated
        public static Object readFile(ICoreAgentClient iCoreAgentClient, String str, c<? super String> cVar) {
            return ICoreAgentClient.super.readFile(str, cVar);
        }

        @Deprecated
        public static Object renameSession(ICoreAgentClient iCoreAgentClient, String str, String str2, c<? super r> cVar) {
            return ICoreAgentClient.super.renameSession(str, str2, cVar);
        }

        @Deprecated
        public static Object renameTask(ICoreAgentClient iCoreAgentClient, E e, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.renameTask(e, cVar);
        }

        @Deprecated
        public static Object resumeTask(ICoreAgentClient iCoreAgentClient, F f, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.resumeTask(f, cVar);
        }

        @Deprecated
        public static Object retryTask(ICoreAgentClient iCoreAgentClient, G g, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.retryTask(g, cVar);
        }

        @Deprecated
        public static Object syncConversations(ICoreAgentClient iCoreAgentClient, c<? super x> cVar) {
            return ICoreAgentClient.super.syncConversations(cVar);
        }

        @Deprecated
        public static Object syncHistory(ICoreAgentClient iCoreAgentClient, y yVar, c<? super z> cVar) {
            return ICoreAgentClient.super.syncHistory(yVar, cVar);
        }

        @Deprecated
        public static Object uploadFile(ICoreAgentClient iCoreAgentClient, Context context, H h, p pVar, c<? super r> cVar) {
            return ICoreAgentClient.super.uploadFile(context, h, pVar, cVar);
        }

        @Deprecated
        public static Object vote(ICoreAgentClient iCoreAgentClient, I i, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.vote(i, cVar);
        }

        @Deprecated
        public static Object writeCoreFile(ICoreAgentClient iCoreAgentClient, String str, String str2, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.writeCoreFile(str, str2, cVar);
        }

        @Deprecated
        public static Object writeFile(ICoreAgentClient iCoreAgentClient, String str, String str2, c<? super Boolean> cVar) {
            return ICoreAgentClient.super.writeFile(str, str2, cVar);
        }
    }

    static Object batchDeleteTasks$suspendImpl(ICoreAgentClient iCoreAgentClient, A a3, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object cancelTask$suspendImpl(ICoreAgentClient iCoreAgentClient, B b, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static /* synthetic */ Object clearSession$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object createSession$suspendImpl(ICoreAgentClient iCoreAgentClient, c<? super String> cVar) {
        return null;
    }

    static /* synthetic */ Object deleteSession$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, c<? super r> cVar) {
        return r.f317a;
    }

    static Object deleteTask$suspendImpl(ICoreAgentClient iCoreAgentClient, C c, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object feedback$suspendImpl(ICoreAgentClient iCoreAgentClient, q qVar, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static /* synthetic */ Object getAgentDetail$suspendImpl(ICoreAgentClient iCoreAgentClient, AbstractC0255b abstractC0255b, c<? super C0254a> cVar) {
        return null;
    }

    static Object interactTask$suspendImpl(ICoreAgentClient iCoreAgentClient, D d, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object pauseTask$suspendImpl(ICoreAgentClient iCoreAgentClient, F f, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static /* synthetic */ Object readCoreFile$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, c<? super String> cVar) {
        return null;
    }

    static /* synthetic */ Object readFile$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, c<? super String> cVar) {
        return null;
    }

    static /* synthetic */ Object renameSession$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, String str2, c<? super r> cVar) {
        return r.f317a;
    }

    static Object renameTask$suspendImpl(ICoreAgentClient iCoreAgentClient, E e, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object resumeTask$suspendImpl(ICoreAgentClient iCoreAgentClient, F f, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object retryTask$suspendImpl(ICoreAgentClient iCoreAgentClient, G g, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static /* synthetic */ Object syncConversations$suspendImpl(ICoreAgentClient iCoreAgentClient, c<? super x> cVar) {
        return new x(null, false, null, 7);
    }

    static /* synthetic */ Object syncHistory$suspendImpl(ICoreAgentClient iCoreAgentClient, y yVar, c<? super z> cVar) {
        return new z(null, false, null, 7);
    }

    static /* synthetic */ Object uploadFile$suspendImpl(ICoreAgentClient iCoreAgentClient, Context context, H h, p pVar, c<? super r> cVar) {
        return r.f317a;
    }

    static Object vote$suspendImpl(ICoreAgentClient iCoreAgentClient, I i, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object writeCoreFile$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, String str2, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    static Object writeFile$suspendImpl(ICoreAgentClient iCoreAgentClient, String str, String str2, c<? super Boolean> cVar) {
        return Boolean.FALSE;
    }

    default Object batchDeleteTasks(A a3, c<? super Boolean> cVar) {
        return batchDeleteTasks$suspendImpl(this, a3, cVar);
    }

    default Object cancelTask(B b, c<? super Boolean> cVar) {
        return cancelTask$suspendImpl(this, b, cVar);
    }

    Object chat(l lVar, EventListener eventListener, c<? super ICancelHandle> cVar);

    default Object clearSession(String str, c<? super r> cVar) {
        return clearSession$suspendImpl(this, str, cVar);
    }

    default Object createSession(c<? super String> cVar) {
        return createSession$suspendImpl(this, cVar);
    }

    default Object deleteSession(String str, c<? super r> cVar) {
        return deleteSession$suspendImpl(this, str, cVar);
    }

    default Object deleteTask(C c, c<? super Boolean> cVar) {
        return deleteTask$suspendImpl(this, c, cVar);
    }

    default void destroy() {
    }

    default Object feedback(q qVar, c<? super Boolean> cVar) {
        return feedback$suspendImpl(this, qVar, cVar);
    }

    default Object getAgentDetail(AbstractC0255b abstractC0255b, c<? super C0254a> cVar) {
        return getAgentDetail$suspendImpl(this, abstractC0255b, cVar);
    }

    ApiType getType();

    default void init(Context context, ILogger logger) {
        k.f(context, "context");
        k.f(logger, "logger");
    }

    default Object interactTask(D d, c<? super Boolean> cVar) {
        return interactTask$suspendImpl(this, d, cVar);
    }

    default void onNetworkChanged(boolean isAvailable) {
    }

    default Object pauseTask(F f, c<? super Boolean> cVar) {
        return pauseTask$suspendImpl(this, f, cVar);
    }

    default Object readCoreFile(String str, c<? super String> cVar) {
        return readCoreFile$suspendImpl(this, str, cVar);
    }

    default Object readFile(String str, c<? super String> cVar) {
        return readFile$suspendImpl(this, str, cVar);
    }

    default Object renameSession(String str, String str2, c<? super r> cVar) {
        return renameSession$suspendImpl(this, str, str2, cVar);
    }

    default Object renameTask(E e, c<? super Boolean> cVar) {
        return renameTask$suspendImpl(this, e, cVar);
    }

    default Object resumeTask(F f, c<? super Boolean> cVar) {
        return resumeTask$suspendImpl(this, f, cVar);
    }

    default Object retryTask(G g, c<? super Boolean> cVar) {
        return retryTask$suspendImpl(this, g, cVar);
    }

    default Object syncConversations(c<? super x> cVar) {
        return syncConversations$suspendImpl(this, cVar);
    }

    default Object syncHistory(y yVar, c<? super z> cVar) {
        return syncHistory$suspendImpl(this, yVar, cVar);
    }

    default Object uploadFile(Context context, H h, p pVar, c<? super r> cVar) {
        return uploadFile$suspendImpl(this, context, h, pVar, cVar);
    }

    default Object vote(I i, c<? super Boolean> cVar) {
        return vote$suspendImpl(this, i, cVar);
    }

    default Object writeCoreFile(String str, String str2, c<? super Boolean> cVar) {
        return writeCoreFile$suspendImpl(this, str, str2, cVar);
    }

    default Object writeFile(String str, String str2, c<? super Boolean> cVar) {
        return writeFile$suspendImpl(this, str, str2, cVar);
    }
}
