package com.stepos.ailauncher.chat;

import V0.CreationExtras;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.T;
import android.view.U;
import android.view.V;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.PickFileMediatorActivity;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import h8.C4148a;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001b\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/chat/PickFileMediatorActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onStop", "onDestroy", "Landroid/content/Intent;", "intent", "x", "(Landroid/content/Intent;)V", "w", "", "needDestroySelf", "Z", "Lcom/stepos/ailauncher/chat/wake/homebar/d;", "homeBarDisableSession$delegate", "LY8/h;", "y", "()Lcom/stepos/ailauncher/chat/wake/homebar/d;", "homeBarDisableSession", "com/stepos/ailauncher/chat/PickFileMediatorActivity$b", "pickFileInterceptor", "Lcom/stepos/ailauncher/chat/PickFileMediatorActivity$b;", "Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;", "viewModel$delegate", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;", "viewModel", "Lcom/stepos/ailauncher/chat/n;", "pickFileMediator$delegate", "z", "()Lcom/stepos/ailauncher/chat/n;", "pickFileMediator", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PickFileMediatorActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PickFileMediatorActivity";
    private static volatile PickFileMediatorActivity liveInstance;
    private boolean needDestroySelf;

    /* renamed from: homeBarDisableSession$delegate, reason: from kotlin metadata */
    private final Y8.h homeBarDisableSession = new T(kotlin.jvm.internal.t.b(com.stepos.ailauncher.chat.wake.homebar.d.class), new d(this), new c(this), new e(null, this));
    private final b pickFileInterceptor = new b();

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Y8.h viewModel = new T(kotlin.jvm.internal.t.b(PickFileMediatorViewModel.class), new g(this), new f(this), new h(null, this));

    /* renamed from: pickFileMediator$delegate, reason: from kotlin metadata */
    private final Y8.h pickFileMediator = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.o
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return PickFileMediatorActivity.B(this.f25619a);
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/PickFileMediatorActivity$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/PickFileMediatorActivity;", "liveInstance", "Lcom/stepos/ailauncher/chat/PickFileMediatorActivity;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.PickFileMediatorActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final void c(PickFileMediatorActivity pickFileMediatorActivity) {
            if (pickFileMediatorActivity.isFinishing() || pickFileMediatorActivity.isDestroyed()) {
                return;
            }
            C4148a.k(PickFileMediatorActivity.TAG, "finishIfShowing (HOME dismiss) → finishAndRemoveTask once", false, 4, null);
            pickFileMediatorActivity.y().i();
            com.stepos.ailauncher.chat.e.INSTANCE.c(Y8.j.a("com.stepos.voiceassistant.ACTION.FILE_PICK_CANCEL", null));
            w.b(pickFileMediatorActivity);
        }

        public final void b() {
            final PickFileMediatorActivity pickFileMediatorActivity = PickFileMediatorActivity.liveInstance;
            if (pickFileMediatorActivity == null) {
                return;
            }
            pickFileMediatorActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.p
                @Override // java.lang.Runnable
                public final void run() {
                    PickFileMediatorActivity.Companion.c(pickFileMediatorActivity);
                }
            });
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/PickFileMediatorActivity$b", "Lcom/stepos/ailauncher/chat/b;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "c", Const.INTENT_KEY_PKGNAME, "", "hasException", Const.INTENT_KEY_UMID, "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends com.stepos.ailauncher.chat.b {
        public b() {
        }

        @Override // com.stepos.ailauncher.chat.b, com.stepos.ailauncher.chat.f
        public void a() {
            super.a();
            PickFileMediatorActivity.this.y().i();
            PickFileMediatorActivity.this.needDestroySelf = false;
        }

        @Override // com.stepos.ailauncher.chat.b, com.stepos.ailauncher.chat.f
        public void b() {
            super.b();
            w.c(PickFileMediatorActivity.this);
        }

        @Override // com.stepos.ailauncher.chat.b, com.stepos.ailauncher.chat.f
        public void c() {
            super.c();
            w.c(PickFileMediatorActivity.this);
        }

        @Override // com.stepos.ailauncher.chat.b, com.stepos.ailauncher.chat.f
        public void d(boolean hasException) {
            super.d(hasException);
            w.c(PickFileMediatorActivity.this);
            if (hasException) {
                Z0.a.b(PickFileMediatorActivity.this).d(new Intent("com.stepos.ailauncher.ACTION_RESHOW_FLOAT_WINDOW"));
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5063a<U.c> {
        final /* synthetic */ b.q $this_viewModels;

        public c(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final U.c invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d implements InterfaceC5063a<V> {
        final /* synthetic */ b.q $this_viewModels;

        public d(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final V invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC5063a<CreationExtras> {
        final /* synthetic */ InterfaceC5063a $extrasProducer;
        final /* synthetic */ b.q $this_viewModels;

        public e(InterfaceC5063a interfaceC5063a, b.q qVar) {
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class f implements InterfaceC5063a<U.c> {
        final /* synthetic */ b.q $this_viewModels;

        public f(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final U.c invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class g implements InterfaceC5063a<V> {
        final /* synthetic */ b.q $this_viewModels;

        public g(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final V invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class h implements InterfaceC5063a<CreationExtras> {
        final /* synthetic */ InterfaceC5063a $extrasProducer;
        final /* synthetic */ b.q $this_viewModels;

        public h(InterfaceC5063a interfaceC5063a, b.q qVar) {
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

    public static final n B(PickFileMediatorActivity pickFileMediatorActivity) {
        return new n(pickFileMediatorActivity, pickFileMediatorActivity.A(), pickFileMediatorActivity.pickFileInterceptor, false, "relay_pick_file_result", 8, null);
    }

    public final PickFileMediatorViewModel A() {
        return (PickFileMediatorViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        liveInstance = this;
        if (getIntent().getBooleanExtra(com.stepos.ailauncher.chat.wake.homebar.d.EXTRA_FROM_MORE_MENU, false)) {
            String stringExtra = getIntent().getStringExtra(q.EXTRA_BIZ_TYPE);
            if (kotlin.jvm.internal.p.d(stringExtra, PickFileType.TYPE_IMAGE.getValue())) {
                y().f(HomeBarDisableManager.Scene.MORE_GALLERY, this, getTaskId());
            } else if (kotlin.jvm.internal.p.d(stringExtra, PickFileType.TYPE_DOC.getValue())) {
                y().f(HomeBarDisableManager.Scene.MORE_FILE_PICKER, this, getTaskId());
            }
        }
        z().y(getIntent().getBooleanExtra(q.EXTRA_IS_FROM_FAKE_MODE, false));
        if (savedInstanceState != null) {
            return;
        }
        try {
            String stringExtra2 = getIntent().getStringExtra(q.EXTRA_BIZ_TYPE);
            if (kotlin.jvm.internal.p.d(stringExtra2, PickFileType.TYPE_IMAGE.getValue())) {
                z().u(getIntent().getIntExtra(q.EXTRA_PICK_LIMIT, 10));
                return;
            }
            if (kotlin.jvm.internal.p.d(stringExtra2, PickFileType.TYPE_DOC.getValue())) {
                z().s();
                return;
            }
            if (kotlin.jvm.internal.p.d(stringExtra2, PickFileType.TYPE_ERASER_IMAGE.getValue())) {
                Intent intent = getIntent();
                kotlin.jvm.internal.p.h(intent, "getIntent(...)");
                x(intent);
            } else {
                if (!kotlin.jvm.internal.p.d(stringExtra2, PickFileType.TYPE_AI_EXPAND_IMAGE.getValue())) {
                    w.c(this);
                    return;
                }
                Intent intent2 = getIntent();
                kotlin.jvm.internal.p.h(intent2, "getIntent(...)");
                w(intent2);
            }
        } catch (Exception e10) {
            C4148a.g(TAG, "Cannot launch picker", e10, false, 8, null);
            y().i();
            this.pickFileInterceptor.c();
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        if (liveInstance == this) {
            liveInstance = null;
        }
        super.onDestroy();
        C4148a.d(TAG, "onDestroy", false, 4, null);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        super.onPause();
        C4148a.h(TAG, "onPause", false, 4, null);
        this.needDestroySelf = true;
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        C4148a.h(TAG, "onResume", false, 4, null);
        if (this.needDestroySelf) {
            w.c(this);
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        super.onStop();
        C4148a.h(TAG, "onStop", false, 4, null);
    }

    public final void w(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(q.EXTRA_PIC_URI);
        if (uri == null) {
            w.c(this);
        } else {
            z().q(uri);
        }
    }

    public final void x(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(q.EXTRA_PIC_URI);
        if (uri == null) {
            w.c(this);
        } else {
            z().r(uri);
        }
    }

    public final com.stepos.ailauncher.chat.wake.homebar.d y() {
        return (com.stepos.ailauncher.chat.wake.homebar.d) this.homeBarDisableSession.getValue();
    }

    public final n z() {
        return (n) this.pickFileMediator.getValue();
    }
}
