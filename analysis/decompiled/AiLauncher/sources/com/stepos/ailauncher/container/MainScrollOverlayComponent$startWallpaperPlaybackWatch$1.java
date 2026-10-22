package com.stepos.ailauncher.container;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.container.MainScrollOverlayComponent$startWallpaperPlaybackWatch$1", f = "MainScrollOverlayComponent.kt", l = {1885}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MainScrollOverlayComponent$startWallpaperPlaybackWatch$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ MainScrollOverlayComponent this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "open", "imePx", "", "nineSplit"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "com.stepos.ailauncher.container.MainScrollOverlayComponent$startWallpaperPlaybackWatch$1$1", f = "MainScrollOverlayComponent.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.container.MainScrollOverlayComponent$startWallpaperPlaybackWatch$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.r<Boolean, Integer, Boolean, InterfaceC4014c<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ boolean Z$0;
        /* synthetic */ boolean Z$1;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(4, interfaceC4014c);
        }

        public final Object f(boolean z10, int i10, boolean z11, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.Z$0 = z10;
            anonymousClass1.I$0 = i10;
            anonymousClass1.Z$1 = z11;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        @Override // p9.r
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Integer num, Boolean bool2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return f(bool.booleanValue(), num.intValue(), bool2.booleanValue(), interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z10 = this.Z$0;
            int i10 = this.I$0;
            boolean z11 = this.Z$1;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return C4109a.a(com.stepos.ailauncher.container.wallpaper.a.INSTANCE.v(z10, i10, z11));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ MainScrollOverlayComponent this$0;

        public a(MainScrollOverlayComponent mainScrollOverlayComponent) {
            this.this$0 = mainScrollOverlayComponent;
        }

        public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            this.this$0.d2(z10);
            return Y8.t.f7040a;
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainScrollOverlayComponent$startWallpaperPlaybackWatch$1(MainScrollOverlayComponent mainScrollOverlayComponent, InterfaceC4014c<? super MainScrollOverlayComponent$startWallpaperPlaybackWatch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = mainScrollOverlayComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MainScrollOverlayComponent$startWallpaperPlaybackWatch$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MainScrollOverlayComponent$startWallpaperPlaybackWatch$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b bVarQ = Xa.d.q(Xa.d.m(m0.INSTANCE.i(), b0.INSTANCE.a(), d0.INSTANCE.a(), new AnonymousClass1(null)));
            a aVar = new a(this.this$0);
            this.label = 1;
            if (bVarQ.collect(aVar, this) == objG) {
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
