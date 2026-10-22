package com.stepos.agentframework.chatcore.send;

import La.H;
import Ua.Q;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.C0919o;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 %2\u00020\u0001:\u0001&B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012F\u0010\t\u001aB\u0012&\u0012$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\b0\u0004\u00124\u0010\r\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cRT\u0010\t\u001aB\u0012&\u0012$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dRB\u0010\r\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R*\u0010#\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/SilentImageStage;", "", "", "waitMs", "Lkotlin/Function1;", "Le9/c;", "", "", "LUa/Q;", Parameters.LAUNCH, "Lkotlin/Function2;", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "upload", "<init>", "(JLp9/l;Lp9/p;)V", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/send/e;)V", "images", "f", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatcore/send/e;)Ljava/util/List;", "J", "Lp9/l;", "Lp9/p;", "name", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "deferred", "LUa/Q;", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SilentImageStage {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "SilentImageStage";
    private volatile Q<? extends Map<String, String>> deferred;
    private final InterfaceC5074l<InterfaceC5074l<? super InterfaceC4014c<? super Map<String, String>>, ? extends Object>, Q<Map<String, String>>> launch;
    private final String name;
    private final p<List<FileInfo>, InterfaceC4014c<? super Map<String, String>>, Object> upload;
    private final long waitMs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/SilentImageStage$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SilentImageStage(long j10, InterfaceC5074l<? super InterfaceC5074l<? super InterfaceC4014c<? super Map<String, String>>, ? extends Object>, ? extends Q<? extends Map<String, String>>> launch, p<? super List<FileInfo>, ? super InterfaceC4014c<? super Map<String, String>>, ? extends Object> upload) {
        kotlin.jvm.internal.p.i(launch, "launch");
        kotlin.jvm.internal.p.i(upload, "upload");
        this.waitMs = j10;
        this.launch = launch;
        this.upload = upload;
        this.name = "SILENT_IMAGE";
    }

    public static final t i(SilentImageStage silentImageStage, Throwable th) {
        C0919o.c(silentImageStage.getName(), "问屏上传结束", true);
        return t.f7040a;
    }

    public void d() {
        this.deferred = null;
    }

    /* renamed from: e, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.util.List<com.stepos.agentframework.chatcore.file.FileInfo> r6, e9.InterfaceC4014c<? super java.util.List<com.stepos.agentframework.chatcore.file.FileInfo>> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.send.SilentImageStage.f(java.util.List, e9.c):java.lang.Object");
    }

    public final List<FileInfo> g(SendContext ctx) {
        List<FileInfo> listF = ctx.f();
        if (listF != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                FileInfo fileInfo = (FileInfo) obj;
                if (fileInfo.getSilent() && fileInfo.getFilePath().length() > 0 && H.x0(fileInfo.getFileUrl())) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    public void h(SendContext ctx) {
        kotlin.jvm.internal.p.i(ctx, "ctx");
        List<FileInfo> listG = g(ctx);
        List<FileInfo> list = listG;
        if (list == null || list.isEmpty()) {
            this.deferred = null;
            return;
        }
        C0919o.b(getName(), "问屏上传开始(n=" + listG.size() + ")");
        Q<Map<String, String>> qInvoke = this.launch.invoke(new SilentImageStage$start$d$1(this, listG, null));
        qInvoke.J(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.send.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SilentImageStage.i(this.f22463a, (Throwable) obj);
            }
        });
        this.deferred = qInvoke;
    }
}
