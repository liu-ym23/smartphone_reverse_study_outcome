package com.stepos.ailauncher.chat;

import V0.CreationExtras;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.T;
import android.view.U;
import android.view.V;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.TransferActivity;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/TransferActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "onDestroy", "outState", "onSaveInstanceState", "", "removeTask", "v", "(Z)V", "childShown", "Z", "Lcom/stepos/ailauncher/chat/wake/homebar/d;", "homeBarDisableSession$delegate", "LY8/h;", "w", "()Lcom/stepos/ailauncher/chat/wake/homebar/d;", "homeBarDisableSession", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransferActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "TransferActivity";
    private static volatile TransferActivity liveInstance;
    private static volatile InterfaceC5074l<? super Activity, Y8.t> pendingCallback;
    private boolean childShown;

    /* renamed from: homeBarDisableSession$delegate, reason: from kotlin metadata */
    private final Y8.h homeBarDisableSession = new T(kotlin.jvm.internal.t.b(com.stepos.ailauncher.chat.wake.homebar.d.class), new c(this), new b(this), new d(null, this));

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0003R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/TransferActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Landroid/app/Activity;", "LY8/t;", "callback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;Lp9/l;)V", "", "fromMoreMenu", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;ZLp9/l;)V", "c", Const.INTENT_KEY_UMID, "f", "", "TAG", "Ljava/lang/String;", "pendingCallback", "Lp9/l;", "Lcom/stepos/ailauncher/chat/TransferActivity;", "liveInstance", "Lcom/stepos/ailauncher/chat/TransferActivity;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.TransferActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final void e(TransferActivity transferActivity) {
            transferActivity.v(true);
        }

        public static final void g(TransferActivity transferActivity) {
            transferActivity.v(false);
        }

        public final void c() {
            TransferActivity.pendingCallback = null;
        }

        public final void d() {
            final TransferActivity transferActivity = TransferActivity.liveInstance;
            if (transferActivity == null) {
                return;
            }
            transferActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.z
                @Override // java.lang.Runnable
                public final void run() {
                    TransferActivity.Companion.e(transferActivity);
                }
            });
        }

        public final void f() {
            final TransferActivity transferActivity = TransferActivity.liveInstance;
            if (transferActivity == null) {
                return;
            }
            transferActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.A
                @Override // java.lang.Runnable
                public final void run() {
                    TransferActivity.Companion.g(transferActivity);
                }
            });
        }

        public final void h(Context context, InterfaceC5074l<? super Activity, Y8.t> callback) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(callback, "callback");
            i(context, false, callback);
        }

        public final void i(Context context, boolean fromMoreMenu, InterfaceC5074l<? super Activity, Y8.t> callback) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(callback, "callback");
            TransferActivity.pendingCallback = callback;
            Intent intentAddFlags = new Intent(context, (Class<?>) TransferActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            kotlin.jvm.internal.p.h(intentAddFlags, "addFlags(...)");
            Intent intentPutExtra = w.a(intentAddFlags).putExtra(com.stepos.ailauncher.chat.wake.homebar.d.EXTRA_FROM_MORE_MENU, fromMoreMenu);
            kotlin.jvm.internal.p.h(intentPutExtra, "putExtra(...)");
            context.startActivity(intentPutExtra, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5063a<U.c> {
        final /* synthetic */ b.q $this_viewModels;

        public b(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final U.c invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5063a<V> {
        final /* synthetic */ b.q $this_viewModels;

        public c(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final V invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d implements InterfaceC5063a<CreationExtras> {
        final /* synthetic */ InterfaceC5063a $extrasProducer;
        final /* synthetic */ b.q $this_viewModels;

        public d(InterfaceC5063a interfaceC5063a, b.q qVar) {
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

    private final com.stepos.ailauncher.chat.wake.homebar.d w() {
        return (com.stepos.ailauncher.chat.wake.homebar.d) this.homeBarDisableSession.getValue();
    }

    public static final void x(TransferActivity transferActivity) {
        if (transferActivity.isFinishing() || transferActivity.isDestroyed()) {
            return;
        }
        Log.d(TAG, "onResume after camera → finish quietly");
        transferActivity.v(false);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.childShown = savedInstanceState != null ? savedInstanceState.getBoolean("camera_child_shown") : false;
        overridePendingTransition(0, 0);
        liveInstance = this;
        if (getIntent().getBooleanExtra(com.stepos.ailauncher.chat.wake.homebar.d.EXTRA_FROM_MORE_MENU, false)) {
            w().f(HomeBarDisableManager.Scene.MORE_CAMERA, this, getTaskId());
        }
        InterfaceC5074l<? super Activity, Y8.t> interfaceC5074l = pendingCallback;
        pendingCallback = null;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(this);
        }
        Log.d(TAG, "onCreate: 创建");
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        if (liveInstance == this) {
            liveInstance = null;
        }
        pendingCallback = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        Log.d(TAG, "onPause");
        this.childShown = true;
        super.onPause();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.childShown) {
            getWindow().getDecorView().post(new Runnable() { // from class: com.stepos.ailauncher.chat.y
                @Override // java.lang.Runnable
                public final void run() {
                    TransferActivity.x(this.f26905a);
                }
            });
        }
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        outState.putBoolean("camera_child_shown", this.childShown);
        super.onSaveInstanceState(outState);
    }

    public final void v(boolean removeTask) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        w().i();
        pendingCallback = null;
        if (removeTask) {
            Log.d(TAG, "finishAndRemoveTask (HOME dismiss)");
            w.b(this);
        } else {
            Log.d(TAG, "finishWithoutTransition");
            w.c(this);
        }
    }
}
