package com.stepos.ailauncher.chat;

import Ua.M;
import android.content.Intent;
import android.net.Uri;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleDocDataLegacy$2", f = "PickFileMediatorActivity.kt", l = {410, 428, 437}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PickFileMediatorViewModel$handleDocDataLegacy$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $isFromFakeMode;
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onHandleFinish;
    final /* synthetic */ p9.p<MainPagePreLoadAction, InterfaceC5074l<? super Intent, Y8.t>, Y8.t> $runInFakeModeBlock;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PickFileMediatorViewModel this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleDocDataLegacy$2$3", f = "PickFileMediatorActivity.kt", l = {438, 439, 440}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleDocDataLegacy$2$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Pair<String, Pair<String, Integer>> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Pair<String, Pair<String, Integer>> pair, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$result = pair;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.$result, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
        
            if (r7.a(r3, r6) != r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.C4849c.b(r7)
                goto L99
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                kotlin.C4849c.b(r7)
                goto L46
            L22:
                kotlin.C4849c.b(r7)
                goto L3b
            L26:
                kotlin.C4849c.b(r7)
                com.stepos.ailauncher.chat.e r7 = com.stepos.ailauncher.chat.e.INSTANCE
                java.lang.String r1 = "com.stepos.voiceassistant.ACTION.PICK_DOC_PRE"
                r5 = 0
                kotlin.Pair r1 = Y8.j.a(r1, r5)
                r6.label = r4
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L3b
                goto L98
            L3b:
                r6.label = r3
                r3 = 32
                java.lang.Object r7 = Ua.U.a(r3, r6)
                if (r7 != r0) goto L46
                goto L98
            L46:
                com.stepos.ailauncher.chat.e r7 = com.stepos.ailauncher.chat.e.INSTANCE
                android.os.Bundle r1 = new android.os.Bundle
                r1.<init>()
                kotlin.Pair<java.lang.String, kotlin.Pair<java.lang.String, java.lang.Integer>> r3 = r6.$result
                java.lang.Object r4 = r3.e()
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r5 = "path"
                r1.putString(r5, r4)
                java.lang.Object r4 = r3.f()
                kotlin.Pair r4 = (kotlin.Pair) r4
                java.lang.Object r4 = r4.e()
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r5 = "raw_file_name"
                r1.putString(r5, r4)
                java.lang.Object r3 = r3.f()
                kotlin.Pair r3 = (kotlin.Pair) r3
                java.lang.Object r3 = r3.f()
                java.lang.Number r3 = (java.lang.Number) r3
                int r3 = r3.intValue()
                java.lang.String r3 = java.lang.String.valueOf(r3)
                java.lang.String r4 = "raw_file_size"
                r1.putString(r4, r3)
                Y8.t r3 = Y8.t.f7040a
                kotlin.Pair r3 = new kotlin.Pair
                java.lang.String r4 = "com.stepos.voiceassistant.ACTION.PICK_DOC"
                r3.<init>(r4, r1)
                r6.label = r2
                java.lang.Object r6 = r7.a(r3, r6)
                if (r6 != r0) goto L99
            L98:
                return r0
            L99:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleDocDataLegacy$2.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PickFileMediatorViewModel$handleDocDataLegacy$2(PickFileMediatorViewModel pickFileMediatorViewModel, Uri uri, boolean z10, p9.p<? super MainPagePreLoadAction, ? super InterfaceC5074l<? super Intent, Y8.t>, Y8.t> pVar, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super PickFileMediatorViewModel$handleDocDataLegacy$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = pickFileMediatorViewModel;
        this.$uri = uri;
        this.$isFromFakeMode = z10;
        this.$runInFakeModeBlock = pVar;
        this.$onHandleFinish = interfaceC5074l;
    }

    public static final Y8.t i(Pair pair, Intent intent) {
        intent.putExtra("raw_file_name", (String) pair.e());
        intent.putExtra("raw_file_size", String.valueOf(((Number) pair.f()).intValue()));
        return Y8.t.f7040a;
    }

    public static final Y8.t n(Pair pair, Intent intent) {
        intent.putExtra("path", (String) pair.e());
        intent.putExtra("raw_file_name", (String) ((Pair) pair.f()).e());
        intent.putExtra("raw_file_size", String.valueOf(((Number) ((Pair) pair.f()).f()).intValue()));
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PickFileMediatorViewModel$handleDocDataLegacy$2(this.this$0, this.$uri, this.$isFromFakeMode, this.$runInFakeModeBlock, this.$onHandleFinish, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PickFileMediatorViewModel$handleDocDataLegacy$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
    
        if (Ua.C1056g.j(r3, r4, r7) == r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.PickFileMediatorViewModel$handleDocDataLegacy$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
