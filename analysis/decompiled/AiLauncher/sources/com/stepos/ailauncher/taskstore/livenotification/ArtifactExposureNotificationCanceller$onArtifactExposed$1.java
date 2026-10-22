package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.ArtifactExposureNotificationCanceller$onArtifactExposed$1", f = "ArtifactExposureNotificationCanceller.kt", l = {66, 82}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactExposureNotificationCanceller$onArtifactExposed$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $taskId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactExposureNotificationCanceller$onArtifactExposed$1(String str, String str2, Context context, InterfaceC4014c<? super ArtifactExposureNotificationCanceller$onArtifactExposed$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$reason = str2;
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ArtifactExposureNotificationCanceller$onArtifactExposed$1 artifactExposureNotificationCanceller$onArtifactExposed$1 = new ArtifactExposureNotificationCanceller$onArtifactExposed$1(this.$taskId, this.$reason, this.$appContext, interfaceC4014c);
        artifactExposureNotificationCanceller$onArtifactExposed$1.L$0 = obj;
        return artifactExposureNotificationCanceller$onArtifactExposed$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactExposureNotificationCanceller$onArtifactExposed$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0124 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:7:0x0035, B:31:0x011c, B:33:0x0124, B:35:0x0131, B:36:0x0135, B:38:0x0141, B:39:0x016f, B:37:0x0139, B:14:0x005b, B:21:0x009c, B:23:0x00a0, B:24:0x00bc, B:26:0x00c6, B:27:0x00ec, B:17:0x006f), top: B:47:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0139 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:7:0x0035, B:31:0x011c, B:33:0x0124, B:35:0x0131, B:36:0x0135, B:38:0x0141, B:39:0x016f, B:37:0x0139, B:14:0x005b, B:21:0x009c, B:23:0x00a0, B:24:0x00bc, B:26:0x00c6, B:27:0x00ec, B:17:0x006f), top: B:47:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.ArtifactExposureNotificationCanceller$onArtifactExposed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
