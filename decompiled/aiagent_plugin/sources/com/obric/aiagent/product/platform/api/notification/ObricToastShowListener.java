package com.obric.aiagent.product.platform.api.notification;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: ObricToastShowListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricToastShowListener {
    private static final String ASSISTANT_TOAST_LISTENER_CLASS = "android.app.AssistantNotificationManager$OnToastShowListener";
    private static final Companion Companion = null;
    private static final String OBRIC_TOAST_LISTENER_CLASS = "android.app.ObricNotificationManager$OnToastShowListener";
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    /* JADX INFO: compiled from: ObricToastShowListener.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: lambda$Cpv4-pSiI0EZyl9bWEuM4Ju2cgI, reason: not valid java name */
    public static /* synthetic */ Object m221lambda$Cpv4pSiI0EZyl9bWEuM4Ju2cgI(ObricToastShowListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$EXqHZsnRhATbm0zTp2EbbJJKrmY(ObricToastShowListener r0, ToastShowInfo r1) {
        return newFrameworkToastShowListenerProxy$lambda$3$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ptlz0OFVZSBZKb-zOEQ6cpsF1aY, reason: not valid java name */
    public static /* synthetic */ Object m222lambda$ptlz0OFVZSBZKbzOEQ6cpsF1aY(ObricToastShowListener r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    public abstract void onToastShown(ToastShowInfo r1);

    public ObricToastShowListener() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricToastShowListener$Cpv4pSiI0EZyl9bWEuM4Ju2cgI(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricToastShowListener$ptlz0OFVZSBZKbzOEQ6cpsF1aY(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    private static final Object obricStub_delegate$lambda$0(ObricToastShowListener r1) {
        return r1.newFrameworkToastShowListenerProxy(OBRIC_TOAST_LISTENER_CLASS);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    private static final Object assistantStub_delegate$lambda$1(ObricToastShowListener r1) {
        return r1.newFrameworkToastShowListenerProxy(ASSISTANT_TOAST_LISTENER_CLASS);
    }

    private final Object newFrameworkToastShowListenerProxy(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        final ObricToastShowListener r2 = (ObricToastShowListener) ZeusTransformUtils.preCheckCast(this, ObricToastShowListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Class r4 = ZeusTransformUtils.forName(r3, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        o.a(r4);     // Catch: Throwable -> L5
        Object r5 = n.f(ObricToastShowListenerKt.newObricToastShowListenerProxy(r4, new $$Lambda$ObricToastShowListener$EXqHZsnRhATbm0zTp2EbbJJKrmY(r2)));     // Catch: Throwable -> L5
    L8:
        if (n.b(r5) == false) goto L13;
        return null;
    L13:
        return r5;
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L8
    }

    private static final x newFrameworkToastShowListenerProxy$lambda$3$lambda$2(ObricToastShowListener r1, ToastShowInfo r2) {
        o.e(r2, DBDefinition.SEGMENT_INFO);
        r1.onToastShown(r2);
        return x.f38692a;
    }
}
