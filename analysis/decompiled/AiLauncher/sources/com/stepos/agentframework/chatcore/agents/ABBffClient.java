package com.stepos.agentframework.chatcore.agents;

import La.H;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.I;
import Ua.Y;
import Z8.C1173v;
import Z8.X;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import h8.C4148a;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.ChatAttachment;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.TaskSyncRemoteRequest;
import kotlin.VoteRequest;
import o4.C5000a;
import o4.InterfaceC5002c;
import p9.InterfaceC5063a;
import t4.InterfaceC5507a;
import w4.C5732a;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJZ\u0010'\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b'\u0010(J'\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J.\u00102\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0096@¢\u0006\u0004\b2\u00103J(\u00104\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0096@¢\u0006\u0004\b4\u00103J(\u00105\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0096@¢\u0006\u0004\b5\u00103J0\u00107\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b7\u00108J\u0018\u0010;\u001a\u00020-2\u0006\u0010:\u001a\u000209H\u0096@¢\u0006\u0004\b;\u0010<J\u0018\u0010>\u001a\u00020-2\u0006\u0010:\u001a\u00020=H\u0096@¢\u0006\u0004\b>\u0010?J\u0018\u0010A\u001a\u00020-2\u0006\u0010:\u001a\u00020@H\u0096@¢\u0006\u0004\bA\u0010BJ\u0018\u0010D\u001a\u00020-2\u0006\u0010:\u001a\u00020CH\u0096@¢\u0006\u0004\bD\u0010EJ8\u0010K\u001a\u00020\n2\u0006\u0010G\u001a\u00020F2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010I\u001a\u00020H2\u0006\u0010\u0016\u001a\u00020JH\u0096@¢\u0006\u0004\bK\u0010LJ,\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010M\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\bN\u00103J\u0012\u0010P\u001a\u0004\u0018\u00010OH\u0096@¢\u0006\u0004\bP\u0010QJ\u0012\u0010R\u001a\u0004\u0018\u00010OH\u0096@¢\u0006\u0004\bR\u0010QJ\u0018\u0010U\u001a\u00020T2\u0006\u0010:\u001a\u00020SH\u0096@¢\u0006\u0004\bU\u0010VJ:\u0010[\u001a\u00020-2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010a\u001a\n `*\u0004\u0018\u00010_0_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR&\u0010f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0d0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020h0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010gR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020j0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010gR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010q¨\u0006r"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/ABBffClient;", "Lcom/stepos/agentframework/chatcore/agents/u;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "", "e0", "(Lcom/stepos/agentframework/chatcore/agents/y;)Ljava/lang/String;", "LK6/n;", "LY8/t;", "c0", "(LK6/n;)V", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "close", "d0", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)V", "Lcom/stepos/agentframework/chatcore/agents/u$a;", "listener", "y", "(Lcom/stepos/agentframework/chatcore/agents/u$a;)V", "q", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "", "likeStatus", "taskId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "", "Lp4/a;", "N", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K", "s", "newTitle", "I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/G;", "request", "f", "(LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "e", "(LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", Const.INTENT_KEY_APIKEY, "(LK6/H;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "deviceId", "G", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Le9/c;)Ljava/lang/Object;", "m", "LK6/J;", "LK6/K;", Const.INTENT_KEY_UMID, "(LK6/J;Le9/c;)Ljava/lang/Object;", "requestId", "decision", "reason", "askUserQuestion", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "tag", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "noEscapeGson", "Lcom/google/gson/Gson;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "callbackCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/agentframework/adapter/netcore/n;", "inFlightCancelHandles", "Lcom/stepos/agentframework/chatcore/agents/ABBffClient$a;", "attachmentCache", "LUa/I;", "streamSerial", "LUa/I;", "Leb/a;", "streamMutex", "Leb/a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ABBffClient implements u {
    private final String tag = " [ABBffClient] ";
    private final Gson noEscapeGson = new GsonBuilder().disableHtmlEscaping().create();
    private final ConcurrentHashMap<AgentDispatcher.b, Set<Object>> callbackCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, com.stepos.agentframework.adapter.netcore.n> inFlightCancelHandles = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AttachmentMeta> attachmentCache = new ConcurrentHashMap<>();
    private final I streamSerial = I.t1(Y.b(), 1, null, 2, null);
    private final InterfaceC4021a streamMutex = eb.f.b(false, 1, null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/ABBffClient$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "fileId", "Ljava/lang/String;", "getFileId", "", ContentDisposition.Parameters.Size, "J", "c", "()J", "devicePath", "getDevicePath", ContentDisposition.Parameters.FileName, Const.INTENT_KEY_APIKEY, "mimeType", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.agents.ABBffClient$a, reason: from toString */
    public static final /* data */ class AttachmentMeta {
        private final String devicePath;
        private final String fileId;
        private final String filename;
        private final String mimeType;
        private final long size;

        /* renamed from: a, reason: from getter */
        public final String getFilename() {
            return this.filename;
        }

        /* renamed from: b, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: c, reason: from getter */
        public final long getSize() {
            return this.size;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttachmentMeta)) {
                return false;
            }
            AttachmentMeta attachmentMeta = (AttachmentMeta) other;
            return kotlin.jvm.internal.p.d(this.fileId, attachmentMeta.fileId) && this.size == attachmentMeta.size && kotlin.jvm.internal.p.d(this.devicePath, attachmentMeta.devicePath) && kotlin.jvm.internal.p.d(this.filename, attachmentMeta.filename) && kotlin.jvm.internal.p.d(this.mimeType, attachmentMeta.mimeType);
        }

        public int hashCode() {
            return (((((((this.fileId.hashCode() * 31) + Long.hashCode(this.size)) * 31) + this.devicePath.hashCode()) * 31) + this.filename.hashCode()) * 31) + this.mimeType.hashCode();
        }

        public String toString() {
            return "AttachmentMeta(fileId=" + this.fileId + ", size=" + this.size + ", devicePath=" + this.devicePath + ", filename=" + this.filename + ", mimeType=" + this.mimeType + ")";
        }
    }

    public static final void f0(AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference, ABBffClient aBBffClient, String str) {
        com.stepos.agentframework.adapter.netcore.n nVar = atomicReference.get();
        if (nVar == null) {
            return;
        }
        aBBffClient.inFlightCancelHandles.remove(str, nVar);
    }

    public static final void g0(AtomicBoolean atomicBoolean, AgentBusStreamBridge agentBusStreamBridge, AtomicBoolean atomicBoolean2, boolean z10, InterfaceC5063a<Y8.t> interfaceC5063a) {
        boolean z11 = false;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (z10 && !atomicBoolean2.get()) {
                z11 = true;
            }
            agentBusStreamBridge.l(z11, interfaceC5063a);
        }
    }

    public static /* synthetic */ void h0(AtomicBoolean atomicBoolean, AgentBusStreamBridge agentBusStreamBridge, AtomicBoolean atomicBoolean2, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        g0(atomicBoolean, agentBusStreamBridge, atomicBoolean2, z10, interfaceC5063a);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object B(Context context, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.B(context, str, str2, str3, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(java.lang.String r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super java.lang.String> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$createConversationSession$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.chatcore.agents.ABBffClient$createConversationSession$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$createConversationSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$createConversationSession$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$createConversationSession$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r7 = r0.L$3
            com.stepos.agentframework.chatcore.agents.ABBffClient r7 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r7
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L3a
            goto L70
        L3a:
            r7 = move-exception
            goto L77
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.C4849c.b(r10)
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.ApiManager r10 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r10 = r10.B(r2, r7, r9, r0)     // Catch: java.lang.Throwable -> L3a
            if (r10 != r1) goto L70
            return r1
        L70:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r7 = kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> L3a
            goto L81
        L77:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L81:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            r9 = 0
            if (r8 == 0) goto La3
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "createConversationSession failed: "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r10 = 4
            h8.C4148a.h(r6, r8, r3, r10, r9)
        La3:
            boolean r6 = kotlin.Result.g(r7)
            if (r6 == 0) goto Laa
            r7 = r9
        Laa:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.G(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void H(String toolCallId, int toolLikeStatus, String taskId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        int i10 = 1;
        if (toolLikeStatus != 1) {
            i10 = 2;
            if (toolLikeStatus != 2) {
                i10 = 3;
            }
        }
        C1060i.d(C1073o0.f6391a, Y.b(), null, new ABBffClient$toolLikeFeedback$1(new VoteRequest(null, taskId, toolCallId, i10, null, null, null, null, 240, null), this, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object I(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$renameConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.chatcore.agents.ABBffClient$renameConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$renameConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$renameConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$renameConversationRemote$1
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 != r4) goto L40
            java.lang.Object r6 = r0.L$4
            com.stepos.agentframework.chatcore.agents.ABBffClient r6 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r6
            java.lang.Object r6 = r0.L$3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L3e
            goto L7a
        L3e:
            r6 = move-exception
            goto L81
        L40:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L48:
            kotlin.C4849c.b(r10)
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3e
            com.stepos.agentframework.adapter.ApiManager r10 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3e
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3e
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L3e
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3e
            r0.L$4 = r6     // Catch: java.lang.Throwable -> L3e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3e
            r0.label = r4     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = r10.h0(r2, r8, r9, r0)     // Catch: java.lang.Throwable -> L3e
            if (r6 != r1) goto L7a
            return r1
        L7a:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L3e
            goto L8b
        L81:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L8b:
            java.lang.Throwable r6 = kotlin.Result.e(r6)
            if (r6 == 0) goto Lad
            java.lang.String r5 = r5.tag
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "renameConversationRemote failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 4
            r8 = 0
            h8.C4148a.h(r5, r6, r3, r7, r8)
        Lad:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.I(java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object K(java.lang.String r6, java.lang.String r7, java.lang.String r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$deleteConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.chatcore.agents.ABBffClient$deleteConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$deleteConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$deleteConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$deleteConversationRemote$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.L$3
            com.stepos.agentframework.chatcore.agents.ABBffClient r6 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3a
            goto L70
        L3a:
            r6 = move-exception
            goto L7f
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r9)
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.ApiManager r9 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L3a
            r0.label = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r9 = r9.E(r2, r8, r0)     // Catch: java.lang.Throwable -> L3a
            if (r9 != r1) goto L70
            return r1
        L70:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3a
            boolean r6 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3a
            java.lang.Boolean r6 = g9.C4109a.a(r6)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L3a
            goto L89
        L7f:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L89:
            java.lang.Throwable r7 = kotlin.Result.e(r6)
            if (r7 == 0) goto Lab
            java.lang.String r5 = r5.tag
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "deleteConversationRemote failed: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r8 = 4
            r9 = 0
            h8.C4148a.h(r5, r7, r4, r8, r9)
        Lab:
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            boolean r7 = kotlin.Result.g(r6)
            if (r7 == 0) goto Lb6
            r6 = r5
        Lb6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.K(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object N(java.lang.String r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super java.util.List<p4.AgentRemoteChatMessage>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.N(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.stepos.agentframework.chatcore.agents.ABBffClient$send$eventListener$1, java.lang.Object] */
    @Override // com.stepos.agentframework.chatcore.agents.u
    public InterfaceC5002c S(RequestParameter parameter, final AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(callback, "callback");
        final String strE0 = e0(parameter);
        com.stepos.agentframework.adapter.netcore.n nVarRemove = this.inFlightCancelHandles.remove(strE0);
        if (nVarRemove != null) {
            if (nVarRemove.getCancelled()) {
                nVarRemove = null;
            }
            if (nVarRemove != null) {
                nVarRemove.cancel("client.superseded");
            }
        }
        C5000a c5000a = new C5000a();
        final AtomicReference atomicReference = new AtomicReference(null);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicReference atomicReference2 = new AtomicReference("user.abort");
        final AgentBusStreamBridge agentBusStreamBridge = new AgentBusStreamBridge(callback, 0L, 2, null);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        c5000a.b(new C5000a.InterfaceC0479a() { // from class: com.stepos.agentframework.chatcore.agents.ABBffClient$send$2
            @Override // o4.C5000a.InterfaceC0479a
            public void cancel(String reason) {
                kotlin.jvm.internal.p.i(reason, "reason");
                atomicBoolean.set(true);
                atomicReference2.set(reason);
                com.stepos.agentframework.adapter.netcore.n nVar = atomicReference.get();
                if (nVar != null) {
                    nVar.cancel(reason);
                }
                ABBffClient.f0(atomicReference, this, strE0);
                C1060i.d(C1073o0.f6391a, this.streamSerial, null, new ABBffClient$send$2$cancel$1(this, callback, atomicBoolean2, agentBusStreamBridge, atomicBoolean, null), 2, null);
            }
        });
        ?? r12 = new com.stepos.agentframework.adapter.netcore.h() { // from class: com.stepos.agentframework.chatcore.agents.ABBffClient$send$eventListener$1
            @Override // com.stepos.agentframework.adapter.netcore.h
            public /* bridge */ void a() {
                super.a();
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void b(C0918n chatRequestInfo, Integer code, String message) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                C1060i.d(C1073o0.f6391a, this.this$0.streamSerial, null, new ABBffClient$send$eventListener$1$onFailure$1(this.this$0, callback, code, message, atomicReference, strE0, atomicBoolean2, agentBusStreamBridge, atomicBoolean, null), 2, null);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void c(C0918n chatRequestInfo, boolean success, Integer code, String message) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                callback.b(success, code, message);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public /* bridge */ void d() {
                super.d();
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void e(C0918n chatRequestInfo, String runId, List<ReferenceSource> sources) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                kotlin.jvm.internal.p.i(runId, "runId");
                kotlin.jvm.internal.p.i(sources, "sources");
                callback.g(runId, sources);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void f(C0918n chatRequestInfo) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void g(C0918n chatRequestInfo, C0917m chatReplyInfo) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
                C1060i.d(C1073o0.f6391a, this.this$0.streamSerial, null, new ABBffClient$send$eventListener$1$onEvent$1(this.this$0, chatReplyInfo, agentBusStreamBridge, null), 2, null);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public /* bridge */ void h(C0918n c0918n, String str, String str2, String str3) {
                super.h(c0918n, str, str2, str3);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public /* bridge */ void i(Object obj) {
                super.i(obj);
            }

            @Override // com.stepos.agentframework.adapter.netcore.h
            public void j(C0918n chatRequestInfo) {
                kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
                C1060i.d(C1073o0.f6391a, this.this$0.streamSerial, null, new ABBffClient$send$eventListener$1$onClosed$1(this.this$0, callback, atomicReference, strE0, atomicBoolean2, agentBusStreamBridge, atomicBoolean, null), 2, null);
            }
        };
        this.callbackCache.put(callback, X.d(r12));
        C1060i.d(C1073o0.f6391a, Y.b(), null, new ABBffClient$send$3(parameter, r12, atomicReference, this, strE0, atomicBoolean, atomicReference2, callback, null), 2, null);
        return c5000a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object U(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.U(str, str2, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(kotlin.TaskInteractRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$interactTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.ABBffClient$interactTask$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$interactTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$interactTask$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$interactTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.ABBffClient r7 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r7
            java.lang.Object r7 = r0.L$0
            K6.H r7 = (kotlin.TaskInteractRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.Q(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "interactTask failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.a(K6.H, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.b(str, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, e9.InterfaceC4014c<? super java.lang.Boolean> r17) throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$sendApproval$1
            if (r1 == 0) goto L16
            r1 = r0
            com.stepos.agentframework.chatcore.agents.ABBffClient$sendApproval$1 r1 = (com.stepos.agentframework.chatcore.agents.ABBffClient$sendApproval$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r9 = r1
            goto L1c
        L16:
            com.stepos.agentframework.chatcore.agents.ABBffClient$sendApproval$1 r1 = new com.stepos.agentframework.chatcore.agents.ABBffClient$sendApproval$1
            r1.<init>(r11, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r9.label
            r10 = 0
            r3 = 1
            if (r2 == 0) goto L51
            if (r2 != r3) goto L49
            java.lang.Object r11 = r9.L$5
            com.stepos.agentframework.chatcore.agents.ABBffClient r11 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r11
            java.lang.Object r11 = r9.L$4
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r9.L$3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r9.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r9.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r9.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L46
            goto L90
        L46:
            r0 = move-exception
            r11 = r0
            goto L9f
        L49:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L51:
            kotlin.C4849c.b(r0)
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.stepos.agentframework.adapter.ApiManager r2 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.stepos.agentframework.adapter.netcore.ApiType r0 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L46
            r9.L$0 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L46
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r14)     // Catch: java.lang.Throwable -> L46
            r9.L$2 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r15)     // Catch: java.lang.Throwable -> L46
            r9.L$3 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = g9.h.a(r16)     // Catch: java.lang.Throwable -> L46
            r9.L$4 = r4     // Catch: java.lang.Throwable -> L46
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L46
            r9.L$5 = r11     // Catch: java.lang.Throwable -> L46
            r9.I$0 = r10     // Catch: java.lang.Throwable -> L46
            r9.label = r3     // Catch: java.lang.Throwable -> L46
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r3 = r0
            java.lang.Object r0 = r2.i0(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L46
            if (r0 != r1) goto L90
            return r1
        L90:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L46
            boolean r11 = r0.booleanValue()     // Catch: java.lang.Throwable -> L46
            java.lang.Boolean r11 = g9.C4109a.a(r11)     // Catch: java.lang.Throwable -> L46
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L46
            goto La9
        L9f:
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        La9:
            java.lang.Throwable r12 = kotlin.Result.e(r11)
            if (r12 != 0) goto Lb0
            goto Lb4
        Lb0:
            java.lang.Boolean r11 = g9.C4109a.a(r10)
        Lb4:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.c(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final void c0(C0918n c0918n) {
        int i10;
        String str;
        String url;
        List<AbstractC0913i> listJ = c0918n.j();
        if (listJ == null) {
            listJ = C1173v.m();
        }
        if (listJ.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractC0913i abstractC0913i = (AbstractC0913i) it.next();
            if (abstractC0913i instanceof AbstractC0913i.Image) {
                url = ((AbstractC0913i.Image) abstractC0913i).getUrl();
            } else if (abstractC0913i instanceof AbstractC0913i.File) {
                url = ((AbstractC0913i.File) abstractC0913i).getUrl();
            } else {
                str = null;
                if (str == null && !H.x0(str)) {
                    AttachmentMeta attachmentMeta = this.attachmentCache.get(str);
                    arrayList.add(new ChatAttachment("remote_url", str, attachmentMeta != null ? attachmentMeta.getMimeType() : null, attachmentMeta != null ? (int) attachmentMeta.getSize() : 0, attachmentMeta != null ? attachmentMeta.getFilename() : null, "1"));
                }
            }
            str = url;
            if (str == null) {
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        c0918n.x(arrayList);
        String str2 = this.tag;
        int size = arrayList.size();
        if (arrayList.isEmpty()) {
            i10 = 0;
        } else {
            Iterator it2 = arrayList.iterator();
            i10 = 0;
            while (it2.hasNext()) {
                if (((ChatAttachment) it2.next()).getMime() != null && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        C4148a.k(str2, "populateAttachments size:" + size + " (cacheHit=" + i10 + ")", false, 4, null);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void close() {
        this.callbackCache.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(kotlin.TranscriptAppendRequest r19, e9.InterfaceC4014c<? super kotlin.TranscriptAppendResult> r20) throws java.lang.Throwable {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            boolean r2 = r0 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$1
            if (r2 == 0) goto L17
            r2 = r0
            com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$1 r2 = (com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$1 r2 = new com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$1
            r2.<init>(r1, r0)
        L1c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r2.label
            r5 = 0
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L41
            if (r4 != r7) goto L39
            java.lang.Object r3 = r2.L$1
            com.stepos.agentframework.chatcore.agents.ABBffClient r3 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r3
            java.lang.Object r2 = r2.L$0
            K6.J r2 = (kotlin.TranscriptAppendRequest) r2
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L37
            goto L66
        L37:
            r0 = move-exception
            goto L83
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.C4849c.b(r0)
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L37
            com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$2$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$appendTranscript$2$1     // Catch: java.lang.Throwable -> L37
            r4 = r19
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L37
            r2.L$0 = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L37
            r2.L$1 = r4     // Catch: java.lang.Throwable -> L37
            r2.I$0 = r6     // Catch: java.lang.Throwable -> L37
            r2.label = r7     // Catch: java.lang.Throwable -> L37
            r7 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.e(r7, r0, r2)     // Catch: java.lang.Throwable -> L37
            if (r0 != r3) goto L66
            return r3
        L66:
            K6.K r0 = (kotlin.TranscriptAppendResult) r0     // Catch: java.lang.Throwable -> L37
            if (r0 != 0) goto L7e
            K6.K r7 = new K6.K     // Catch: java.lang.Throwable -> L37
            java.lang.String r14 = "timeout"
            java.lang.String r15 = "appendTranscript timeout 3000ms"
            r16 = 62
            r17 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L37
            r0 = r7
        L7e:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L37
            goto L8d
        L83:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L8d:
            java.lang.Throwable r2 = kotlin.Result.e(r0)
            if (r2 == 0) goto Lae
            java.lang.String r1 = r1.tag
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "appendTranscript failed: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 4
            h8.C4148a.h(r1, r2, r6, r3, r5)
        Lae:
            java.lang.Throwable r1 = kotlin.Result.e(r0)
            if (r1 != 0) goto Lb5
            goto Lca
        Lb5:
            K6.K r2 = new K6.K
            java.lang.String r10 = r1.getMessage()
            r11 = 62
            r12 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "exception"
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r2
        Lca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.d(K6.J, e9.c):java.lang.Object");
    }

    public void d0(AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.callbackCache.remove(callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(kotlin.TaskCancelRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$cancelTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.ABBffClient$cancelTask$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$cancelTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$cancelTask$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$cancelTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.ABBffClient r7 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r7
            java.lang.Object r7 = r0.L$0
            K6.F r7 = (kotlin.TaskCancelRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.p(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cancelTask failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.e(K6.F, e9.c):java.lang.Object");
    }

    public final String e0(RequestParameter parameter) {
        String sessionId;
        if (parameter.getIsToolResult()) {
            Object extra = parameter.getExtra();
            C0917m c0917m = extra instanceof C0917m ? (C0917m) extra : null;
            sessionId = c0917m != null ? c0917m.getConversationId() : null;
        } else {
            sessionId = parameter.getSessionId();
        }
        String string = sessionId != null ? H.D1(sessionId).toString() : null;
        return string == null ? "" : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(kotlin.TaskDeleteRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$deleteTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.ABBffClient$deleteTask$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$deleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$deleteTask$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$deleteTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.ABBffClient r7 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r7
            java.lang.Object r7 = r0.L$0
            K6.G r7 = (kotlin.TaskDeleteRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.F(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deleteTask failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.f(K6.G, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(kotlin.TaskBatchDeleteRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$batchDeleteTasks$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.agents.ABBffClient$batchDeleteTasks$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$batchDeleteTasks$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$batchDeleteTasks$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$batchDeleteTasks$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.agents.ABBffClient r7 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r7
            java.lang.Object r7 = r0.L$0
            K6.E r7 = (kotlin.TaskBatchDeleteRequest) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5c
        L32:
            r7 = move-exception
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r8 = r8.o(r2, r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r8 != r1) goto L5c
            return r1
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L32
            boolean r7 = r8.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r7 = g9.C4109a.a(r7)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L75
        L6b:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L75:
            java.lang.Throwable r8 = kotlin.Result.e(r7)
            if (r8 == 0) goto L97
            java.lang.String r6 = r6.tag
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "batchDeleteTasks failed: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0 = 4
            r1 = 0
            h8.C4148a.h(r6, r8, r4, r0, r1)
        L97:
            java.lang.Boolean r6 = g9.C4109a.a(r4)
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La2
            r7 = r6
        La2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.g(K6.E, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public boolean h() {
        return ApiManager.INSTANCE.S(ApiType.AGENTBUS_BFF);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object i(InterfaceC4014c interfaceC4014c) {
        return null;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.j(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object k(String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return super.k(str, str2, list, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object l(TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.l(taskSyncRemoteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object m(InterfaceC4014c interfaceC4014c) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, e9.InterfaceC4014c<? super Y8.t> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.n(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void q(u.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object r(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c) {
        return new C5732a(str, "AgentBus", "Agent via AgentBus", "", "", null, 32, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s(java.lang.String r6, java.lang.String r7, java.lang.String r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.chatcore.agents.ABBffClient$clearConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.chatcore.agents.ABBffClient$clearConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.ABBffClient$clearConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ABBffClient$clearConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.ABBffClient$clearConversationRemote$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r6 = r0.L$3
            com.stepos.agentframework.chatcore.agents.ABBffClient r6 = (com.stepos.agentframework.chatcore.agents.ABBffClient) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3a
            goto L70
        L3a:
            r6 = move-exception
            goto L77
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r9)
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.ApiManager r9 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS_BFF     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = r9.y(r2, r8, r0)     // Catch: java.lang.Throwable -> L3a
            if (r6 != r1) goto L70
            return r1
        L70:
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L3a
            goto L81
        L77:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L81:
            java.lang.Throwable r6 = kotlin.Result.e(r6)
            if (r6 == 0) goto La3
            java.lang.String r5 = r5.tag
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "clearConversationRemote failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r7 = 4
            r8 = 0
            h8.C4148a.h(r5, r6, r3, r7, r8)
        La3:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ABBffClient.s(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ InterfaceC5002c w(String str, String str2, AgentDispatcher.b bVar) {
        return super.w(str, str2, bVar);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object x(Context context, String str, String str2, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void y(u.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
    }
}
