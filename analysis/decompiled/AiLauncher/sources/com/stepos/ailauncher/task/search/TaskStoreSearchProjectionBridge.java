package com.stepos.ailauncher.task.search;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import eb.InterfaceC4021a;
import eb.f;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u0014\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/task/search/TaskStoreSearchProjectionBridge;", "", "<init>", "()V", "LY8/t;", "c", Const.INTENT_KEY_PKGNAME, "(Le9/c;)Ljava/lang/Object;", "LUa/M;", "scope", "LUa/M;", "", "installed", "Z", "", "lastReplacedUid", "Ljava/lang/String;", "Leb/a;", "replaceMutex", "Leb/a;", "com/stepos/ailauncher/task/search/TaskStoreSearchProjectionBridge$observer$1", "observer", "Lcom/stepos/ailauncher/task/search/TaskStoreSearchProjectionBridge$observer$1;", "TAG", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreSearchProjectionBridge {
    private static final String TAG = "TaskSearchProjection";
    private static volatile boolean installed;
    private static volatile String lastReplacedUid;
    public static final TaskStoreSearchProjectionBridge INSTANCE = new TaskStoreSearchProjectionBridge();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final InterfaceC4021a replaceMutex = f.b(false, 1, null);
    private static final TaskStoreSearchProjectionBridge$observer$1 observer = new TaskStoreSearchProjectionBridge$observer$1();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:54:0x00f8, B:56:0x0104, B:59:0x010c, B:60:0x0131, B:58:0x010a, B:45:0x00cb, B:47:0x00d3, B:49:0x00d9, B:50:0x00e0, B:37:0x00a8, B:39:0x00b0, B:41:0x00b8), top: B:67:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:54:0x00f8, B:56:0x0104, B:59:0x010c, B:60:0x0131, B:58:0x010a, B:45:0x00cb, B:47:0x00d3, B:49:0x00d9, B:50:0x00e0, B:37:0x00a8, B:39:0x00b0, B:41:0x00b8), top: B:67:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:54:0x00f8, B:56:0x0104, B:59:0x010c, B:60:0x0131, B:58:0x010a, B:45:0x00cb, B:47:0x00d3, B:49:0x00d9, B:50:0x00e0, B:37:0x00a8, B:39:0x00b0, B:41:0x00b8), top: B:67:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge.b(e9.c):java.lang.Object");
    }

    public final void c() {
        if (installed) {
            return;
        }
        synchronized (this) {
            if (installed) {
                return;
            }
            TaskStoreModule.INSTANCE.K(observer);
            installed = true;
            t tVar = t.f7040a;
            C1060i.d(scope, null, null, new TaskStoreSearchProjectionBridge$install$2(null), 3, null);
        }
    }
}
