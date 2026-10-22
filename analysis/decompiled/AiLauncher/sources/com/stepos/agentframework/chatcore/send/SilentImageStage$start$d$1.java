package com.stepos.agentframework.chatcore.send;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutKt;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.SilentImageStage$start$d$1", f = "SilentImageStage.kt", l = {41}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SilentImageStage$start$d$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ List<FileInfo> $list;
    int label;
    final /* synthetic */ SilentImageStage this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.SilentImageStage$start$d$1$1", f = "SilentImageStage.kt", l = {41}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.send.SilentImageStage$start$d$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Map<String, ? extends String>>, Object> {
        final /* synthetic */ List<FileInfo> $list;
        int label;
        final /* synthetic */ SilentImageStage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SilentImageStage silentImageStage, List<FileInfo> list, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = silentImageStage;
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$list, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
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
            p pVar = this.this$0.upload;
            List<FileInfo> list = this.$list;
            this.label = 1;
            Object objInvoke = pVar.invoke(list, this);
            return objInvoke == objG ? objG : objInvoke;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Map<String, ? extends String>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super Map<String, String>>) interfaceC4014c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SilentImageStage$start$d$1(SilentImageStage silentImageStage, List<FileInfo> list, InterfaceC4014c<? super SilentImageStage$start$d$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.this$0 = silentImageStage;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new SilentImageStage$start$d$1(this.this$0, this.$list, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
        return ((SilentImageStage$start$d$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long j10 = this.this$0.waitMs;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$list, null);
            this.label = 1;
            obj = TimeoutKt.e(j10, anonymousClass1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Map map = (Map) obj;
        return map == null ? kotlin.collections.a.i() : map;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Map<String, ? extends String>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Map<String, String>>) interfaceC4014c);
    }
}
