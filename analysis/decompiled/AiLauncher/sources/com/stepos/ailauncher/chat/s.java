package com.stepos.ailauncher.chat;

import V0.CreationExtras;
import android.content.Context;
import android.view.T;
import android.view.U;
import android.view.V;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018*\u0004\b\u0019\u0010\u001a¨\u0006\u001e²\u0006\f\u0010\u001d\u001a\u00020\u001c8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/stepos/ailauncher/chat/s;", "Lcom/stepos/ailauncher/chat/c;", "Landroid/content/Context;", "context", "", "usedInActivity", "isFakeMode", "<init>", "(Landroid/content/Context;ZZ)V", "", "maxCount", "LY8/t;", "f", "(I)V", Const.INTENT_KEY_UMID, "()V", "release", "LY8/h;", "Lcom/stepos/ailauncher/chat/PickFileMediatorInDialog;", "moreMenuPickerDelegate", "LY8/h;", "pickFileImpl", "Lcom/stepos/ailauncher/chat/c;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/PickFileMediatorInDialog;", "getMoreMenuPicker$delegate", "(Lcom/stepos/ailauncher/chat/s;)Ljava/lang/Object;", "moreMenuPicker", "Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;", "viewModel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s implements com.stepos.ailauncher.chat.c {
    private final Y8.h<PickFileMediatorInDialog> moreMenuPickerDelegate;
    private final com.stepos.ailauncher.chat.c pickFileImpl;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5063a<U.c> {
        final /* synthetic */ b.q $this_viewModels;

        public a(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final U.c invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5063a<V> {
        final /* synthetic */ b.q $this_viewModels;

        public b(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final V invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5063a<CreationExtras> {
        final /* synthetic */ InterfaceC5063a $extrasProducer;
        final /* synthetic */ b.q $this_viewModels;

        public c(InterfaceC5063a interfaceC5063a, b.q qVar) {
            this.$extrasProducer = interfaceC5063a;
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            InterfaceC5063a interfaceC5063a = this.$extrasProducer;
            return (interfaceC5063a == null || (creationExtras = (CreationExtras) interfaceC5063a.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : creationExtras;
        }
    }

    public s(final Context context, boolean z10, final boolean z11) {
        com.stepos.ailauncher.chat.c pickFileMediatorInDialog;
        kotlin.jvm.internal.p.i(context, "context");
        this.moreMenuPickerDelegate = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return s.c(context, z11);
            }
        });
        if (z10 && (context instanceof androidx.appcompat.app.d)) {
            b.q qVar = (b.q) context;
            pickFileMediatorInDialog = new n((androidx.appcompat.app.d) context, e(new T(kotlin.jvm.internal.t.b(PickFileMediatorViewModel.class), new b(qVar), new a(qVar), new c(null, qVar))), null, false, null, 28, null);
        } else {
            pickFileMediatorInDialog = new PickFileMediatorInDialog(context, z11, false, 4, null);
        }
        this.pickFileImpl = pickFileMediatorInDialog;
    }

    public static final PickFileMediatorInDialog c(Context context, boolean z10) {
        return new PickFileMediatorInDialog(context, z10, true);
    }

    public static final PickFileMediatorViewModel e(Y8.h<PickFileMediatorViewModel> hVar) {
        return hVar.getValue();
    }

    public final PickFileMediatorInDialog b() {
        return this.moreMenuPickerDelegate.getValue();
    }

    public final void d() {
        b().e();
    }

    public final void f(int maxCount) {
        b().h(maxCount);
    }

    @Override // com.stepos.ailauncher.chat.c
    public void release() {
        this.pickFileImpl.release();
        if (this.moreMenuPickerDelegate.isInitialized()) {
            b().release();
        }
    }

    public /* synthetic */ s(Context context, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? false : z11);
    }
}
