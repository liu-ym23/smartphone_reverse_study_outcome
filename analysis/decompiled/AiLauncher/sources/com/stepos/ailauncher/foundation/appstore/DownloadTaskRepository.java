package com.stepos.ailauncher.foundation.appstore;

import Ua.C1056g;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Y8.t;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0082@¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/DownloadTaskRepository;", "", "<init>", "()V", "", "packageName", "Lkotlin/Function1;", "", "LY8/t;", "onResult", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lp9/l;)V", "", "f", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LUa/M;", "scope", "LUa/M;", "Leb/a;", "mutex", "Leb/a;", "LUa/Q;", "inflight", "LUa/Q;", "cached", "Ljava/util/Set;", "", "cachedAt", "J", "THROTTLE_MS", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadTaskRepository {
    private static final long THROTTLE_MS = 3000;
    private static volatile Set<String> cached;
    private static volatile long cachedAt;
    private static Q<? extends Set<String>> inflight;
    public static final DownloadTaskRepository INSTANCE = new DownloadTaskRepository();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(1:(1:(8:15|16|88|70|(1:72)|75|76|77)(2:17|18))(8:19|20|90|54|(1:56)|59|60|61))(7:21|82|22|49|50|(8:53|20|90|54|(0)|59|60|61)|68))(1:26))(3:28|(0)|68)|27|84|31|(9:33|(1:35)(1:36)|(1:38)|39|44|86|45|(4:48|49|50|(0))|68)|42|39|44|86|45|(0)|68|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ea, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00eb, code lost:
    
        r15 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00da A[Catch: all -> 0x00dd, TryCatch #4 {all -> 0x00dd, blocks: (B:54:0x00d6, B:56:0x00da, B:59:0x00e0), top: B:90:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107 A[Catch: all -> 0x010a, TryCatch #3 {all -> 0x010a, blocks: (B:70:0x0103, B:72:0x0107, B:75:0x010d), top: B:88:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(e9.InterfaceC4014c<? super java.util.Set<java.lang.String>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository.f(e9.c):java.lang.Object");
    }

    public final void g(String packageName, InterfaceC5074l<? super Boolean, t> onResult) {
        p.i(packageName, "packageName");
        p.i(onResult, "onResult");
        Set<String> set = cached;
        if (set != null) {
            if (SystemClock.elapsedRealtime() - cachedAt >= 3000) {
                set = null;
            }
            if (set != null) {
                onResult.invoke(Boolean.valueOf(set.contains(packageName)));
                return;
            }
        }
        C1060i.d(scope, null, null, new DownloadTaskRepository$hasTask$3(onResult, packageName, null), 3, null);
    }

    public final Object h(InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return C1056g.j(Y.b(), new DownloadTaskRepository$queryAllTasks$2(null), interfaceC4014c);
    }
}
