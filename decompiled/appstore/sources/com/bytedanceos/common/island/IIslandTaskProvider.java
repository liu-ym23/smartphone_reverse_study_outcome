package com.bytedanceos.common.island;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0016"}, d2 = {"Lcom/bytedanceos/common/island/IIslandTaskProvider;", "", "createTask", "", "type", "", "appInfo", "Lcom/bytedanceos/common/model/AppInfo;", "dispatchAction", AppPermissionActivity.EXTRA_APP_PKG, "", "handleCachedTasks", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBind", "isRebind", "", "onTaskRemoved", "target", "onTaskUpdate", "action", "readCachedTask", "Companion", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IIslandTaskProvider {

    @NotNull
    public static final Companion Companion = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f9827a = null;

        static {
            f9827a = new Companion();
        }

        public Companion() {
        }

        public static final /* synthetic */ IIslandTaskProvider a(Companion r10) {
            return r10.d();
        }

        public final void b(int r10, AppInfo r11) {
            q.g(r11, "appInfo");
            IIslandTaskProvider r12 = d();
            if (r12 == null) goto L6;
            r12.createTask(r10, r11);
            return;
        }

        public final void c(String r10) {
            q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
            IIslandTaskProvider r11 = d();
            if (r11 == null) goto L6;
            r11.dispatchAction(r10);
            return;
        }

        public final IIslandTaskProvider d() {
            return null;
        }

        public final void e() {
            if (d() == null) goto L6;
            h.d(y0.f21772a, null, null, new IIslandTaskProvider$Companion$handleCachedIslandTask$1$1(null), 3, null);
            return;
        }

        public final void f(boolean r10) {
            IIslandTaskProvider r11 = d();
            if (r11 == null) goto L6;
            r11.onBind(r10);
            return;
        }

        public final void g(AppInfo r10) {
            q.g(r10, "target");
            IIslandTaskProvider r11 = d();
            if (r11 == null) goto L6;
            r11.onTaskRemoved(r10);
            return;
        }

        public final void h(String r10, AppInfo r11) {
            q.g(r10, "action");
            IIslandTaskProvider r12 = d();
            if (r12 == null) goto L6;
            r12.onTaskUpdate(r10, r11);
            return;
        }

        public final void i() {
            IIslandTaskProvider r10 = d();
            if (r10 == null) goto L6;
            r10.readCachedTask();
            return;
        }
    }

    static {
        Companion = Companion.f9827a;
    }

    @JvmStatic
    static void createIslandTask(int r10, @NotNull AppInfo r11) {
        Companion.b(r10, r11);
    }

    @JvmStatic
    static void dispatchTaskAction(@NotNull String r10) {
        Companion.c(r10);
    }

    @JvmStatic
    static void handleCachedIslandTask() {
        Companion.e();
    }

    @JvmStatic
    static void onIslandBind(boolean r10) {
        Companion.f(r10);
    }

    @JvmStatic
    static void onTaskCancel(@NotNull AppInfo r10) {
        Companion.g(r10);
    }

    @JvmStatic
    static void onTaskProgressUpdate(@NotNull String r10, @Nullable AppInfo r11) {
        Companion.h(r10, r11);
    }

    @JvmStatic
    static void readCachedIslandTask() {
        Companion.i();
    }

    void createTask(int r10, @NotNull AppInfo r11);

    void dispatchAction(@NotNull String r10);

    @Nullable
    Object handleCachedTasks(@NotNull Continuation<? super Unit> r10);

    void onBind(boolean r10);

    void onTaskRemoved(@NotNull AppInfo r10);

    void onTaskUpdate(@NotNull String r10, @Nullable AppInfo r11);

    void readCachedTask();
}
