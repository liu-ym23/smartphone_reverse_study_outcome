package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor", f = "AppInstallActor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 8, 8, 9}, l = {967, 989, 995, 1003, 1021, 1029, 1039, 1041, 1046, 1050}, m = "syncWithDownloadInfo", n = {"this", "msg", "actorMailbox", "this", "msg", "actorMailbox", "newStatus", "$this$syncWithDownloadInfo_u24lambda_u2414", "this", "msg", "actorMailbox", "newStatus", "$this$syncWithDownloadInfo_u24lambda_u2414", "this", "msg", "actorMailbox", "newStatus", "$this$syncWithDownloadInfo_u24lambda_u2414", "this", "msg", "actorMailbox", "newStatus", "downloadInfo", "updated", "this", "msg", "actorMailbox", "newStatus", "downloadInfo", "updated", "updateCase", "this", "actorMailbox", "downloadInfo", "task", "ack", "task"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
public final class AppInstallActor$syncWithDownloadInfo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$syncWithDownloadInfo$1(AppInstallActor r10, Continuation<? super AppInstallActor$syncWithDownloadInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppInstallActor.E(this.this$0, null, null, this);
    }
}
