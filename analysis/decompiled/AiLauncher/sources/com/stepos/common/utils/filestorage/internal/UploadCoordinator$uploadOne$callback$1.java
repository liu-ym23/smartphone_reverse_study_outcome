package com.stepos.common.utils.filestorage.internal;

import P6.CreateUploadSessionResponse;
import P6.TosCallbackBody;
import Ua.M;
import Y8.t;
import android.content.Context;
import android.net.Uri;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LP6/j;", "<anonymous>", "(LUa/M;)LP6/j;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadOne$callback$1", f = "UploadCoordinator.kt", l = {242}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadOne$callback$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super TosCallbackBody>, Object> {
    final /* synthetic */ String $contentType;
    final /* synthetic */ Context $context;
    final /* synthetic */ Long $fileSize;
    final /* synthetic */ CreateUploadSessionResponse $session;
    final /* synthetic */ a $tracker;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ UploadCoordinator this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadOne$callback$1$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<Long, t> {
        public AnonymousClass1(Object obj) {
            super(1, obj, a.class, "onBytesRead", "onBytesRead(J)V", 0);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Long l10) {
            l(l10.longValue());
            return t.f7040a;
        }

        public final void l(long j10) {
            ((a) this.receiver).d(j10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCoordinator$uploadOne$callback$1(UploadCoordinator uploadCoordinator, Context context, CreateUploadSessionResponse createUploadSessionResponse, Uri uri, String str, Long l10, a aVar, InterfaceC4014c<? super UploadCoordinator$uploadOne$callback$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = uploadCoordinator;
        this.$context = context;
        this.$session = createUploadSessionResponse;
        this.$uri = uri;
        this.$contentType = str;
        this.$fileSize = l10;
        this.$tracker = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UploadCoordinator$uploadOne$callback$1(this.this$0, this.$context, this.$session, this.$uri, this.$contentType, this.$fileSize, this.$tracker, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TosCallbackBody> interfaceC4014c) {
        return ((UploadCoordinator$uploadOne$callback$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TosUploader tosUploader = this.this$0.tos;
        Context context = this.$context;
        String uploadUrl = this.$session.getUploadUrl();
        Uri uri = this.$uri;
        String str = this.$contentType;
        Long l10 = this.$fileSize;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$tracker);
        this.label = 1;
        Object objF = tosUploader.f(context, uploadUrl, uri, str, l10, anonymousClass1, this);
        return objF == objG ? objG : objF;
    }
}
