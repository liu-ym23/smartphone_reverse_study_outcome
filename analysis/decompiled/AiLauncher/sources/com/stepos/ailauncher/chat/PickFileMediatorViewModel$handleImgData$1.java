package com.stepos.ailauncher.chat;

import Ua.M;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.MapAspectFrameLayout;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1", f = "PickFileMediatorActivity.kt", l = {369, 376, 386}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PickFileMediatorViewModel$handleImgData$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $isFromFakeMode;
    final /* synthetic */ InterfaceC5063a<Y8.t> $onHandleFinish;
    final /* synthetic */ String $resultAction;
    final /* synthetic */ p9.p<MainPagePreLoadAction, InterfaceC5074l<? super Intent, Y8.t>, Y8.t> $runInFakeModeBlock;
    final /* synthetic */ List<Uri> $uris;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PickFileMediatorViewModel this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1$1", f = "PickFileMediatorActivity.kt", l = {MapAspectFrameLayout.DESIGN_WIDTH, 371}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        
            if (Ua.U.a(32, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r6)
                goto L3e
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.C4849c.b(r6)
                goto L33
            L1e:
                kotlin.C4849c.b(r6)
                com.stepos.ailauncher.chat.e r6 = com.stepos.ailauncher.chat.e.INSTANCE
                java.lang.String r1 = "com.stepos.voiceassistant.ACTION.PICK_IMG_PRE"
                r4 = 0
                kotlin.Pair r1 = Y8.j.a(r1, r4)
                r5.label = r3
                java.lang.Object r6 = r6.a(r1, r5)
                if (r6 != r0) goto L33
                goto L3d
            L33:
                r5.label = r2
                r1 = 32
                java.lang.Object r5 = Ua.U.a(r1, r5)
                if (r5 != r0) goto L3e
            L3d:
                return r0
            L3e:
                Y8.t r5 = Y8.t.f7040a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1$3", f = "PickFileMediatorActivity.kt", l = {387}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ String $path;
        final /* synthetic */ String $resultAction;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, String str2, String str3, Uri uri, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$resultAction = str;
            this.$name = str2;
            this.$path = str3;
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.$resultAction, this.$name, this.$path, this.$uri, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                e eVar = e.INSTANCE;
                String str = this.$resultAction;
                Bundle bundle = new Bundle();
                String str2 = this.$name;
                String str3 = this.$path;
                Uri uri = this.$uri;
                bundle.putString("file_name", str2);
                bundle.putString("path", str3);
                bundle.putParcelable(q.EXTRA_PIC_URI, uri);
                Y8.t tVar = Y8.t.f7040a;
                Pair<String, Bundle> pair = new Pair<>(str, bundle);
                this.label = 1;
                if (eVar.a(pair, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PickFileMediatorViewModel$handleImgData$1(List<? extends Uri> list, PickFileMediatorViewModel pickFileMediatorViewModel, boolean z10, p9.p<? super MainPagePreLoadAction, ? super InterfaceC5074l<? super Intent, Y8.t>, Y8.t> pVar, InterfaceC5063a<Y8.t> interfaceC5063a, String str, InterfaceC4014c<? super PickFileMediatorViewModel$handleImgData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$uris = list;
        this.this$0 = pickFileMediatorViewModel;
        this.$isFromFakeMode = z10;
        this.$runInFakeModeBlock = pVar;
        this.$onHandleFinish = interfaceC5063a;
        this.$resultAction = str;
    }

    public static final Y8.t h(String str, Uri uri, Intent intent) {
        intent.putExtra("path", str);
        intent.putExtra(q.EXTRA_PIC_URI, uri);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PickFileMediatorViewModel$handleImgData$1(this.$uris, this.this$0, this.$isFromFakeMode, this.$runInFakeModeBlock, this.$onHandleFinish, this.$resultAction, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PickFileMediatorViewModel$handleImgData$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        if (Ua.C1056g.j(r2, r10, r17) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ad -> B:16:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00eb -> B:16:0x0064). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleImgData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
