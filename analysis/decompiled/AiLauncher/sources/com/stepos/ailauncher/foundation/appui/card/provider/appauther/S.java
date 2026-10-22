package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.view.C1315c;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002DEB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b.\u0010\u0013Jc\u00108\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00102\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b03¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0001¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b<\u0010\u0017R\u0014\u0010=\u001a\u0002008\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u0002008\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010A\u001a\u00020@8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010\u000fR\u0018\u0010B\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$a;", "session", "", "cancelled", "LY8/t;", "u", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$a;Z)V", "x", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$a;)V", "retry", "R", "J", "Landroid/view/View;", "view", "C", "(Landroid/view/View;)Z", "q", Parameters.ROOT, "z", "(Landroid/view/View;)V", "s", "Landroid/view/MotionEvent;", "event", "D", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Landroid/widget/EditText;", "input", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/widget/EditText;)V", "Landroid/text/Editable;", "editable", "", "replacement", "F", "(Landroid/text/Editable;Ljava/lang/CharSequence;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;", "r", "(Landroid/view/View;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;", LinkHeader.Parameters.Anchor, "G", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;)V", "hostRoot", ExifInterface.LONGITUDE_EAST, "owner", "", "title", "initial", "Lkotlin/Function1;", "onValueChanged", "Lkotlin/Function0;", "onCancel", "onConfirm", "L", "(Ljava/lang/Object;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/a;Lp9/l;)V", "w", "(Ljava/lang/Object;)V", "v", "TAG_EVENT_SHOW", "Ljava/lang/String;", "TAG_EVENT_CONFIRM", "", "IME_RETRY_DELAY_MS", "showing", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$a;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S {
    private static final long IME_RETRY_DELAY_MS = 160;
    public static final S INSTANCE = new S();
    private static final String TAG_EVENT_CONFIRM = "auther.keydialog.confirm";
    private static final String TAG_EVENT_SHOW = "auther.keydialog.show";
    private static a showing;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$a;", "", "owner", "LT5/h;", "binding", "Landroid/view/ViewGroup;", "host", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;", "scrollAnchor", "Lkotlin/Function0;", "LY8/t;", "onCancel", "<init>", "(Ljava/lang/Object;LT5/h;Landroid/view/ViewGroup;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;Lp9/a;)V", "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Object;", "LT5/h;", Const.INTENT_KEY_APIKEY, "()LT5/h;", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;", "Lp9/a;", "f", "()Lp9/a;", "", "dispatchChanges", "Z", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Z)V", "Landroid/text/TextWatcher;", "watcher", "Landroid/text/TextWatcher;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroid/text/TextWatcher;", "m", "(Landroid/text/TextWatcher;)V", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "imeFocusListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", Const.INTENT_KEY_UMID, "()Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "k", "(Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;)V", "Ljava/lang/Runnable;", "imeRetryRunnable", "Ljava/lang/Runnable;", "e", "()Ljava/lang/Runnable;", "l", "(Ljava/lang/Runnable;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final T5.h binding;
        private boolean dispatchChanges;
        private final ViewGroup host;
        private ViewTreeObserver.OnWindowFocusChangeListener imeFocusListener;
        private Runnable imeRetryRunnable;
        private final InterfaceC5063a<Y8.t> onCancel;
        private final Object owner;
        private final b scrollAnchor;
        public TextWatcher watcher;

        public a(Object owner, T5.h binding, ViewGroup host, b bVar, InterfaceC5063a<Y8.t> onCancel) {
            kotlin.jvm.internal.p.i(owner, "owner");
            kotlin.jvm.internal.p.i(binding, "binding");
            kotlin.jvm.internal.p.i(host, "host");
            kotlin.jvm.internal.p.i(onCancel, "onCancel");
            this.owner = owner;
            this.binding = binding;
            this.host = host;
            this.scrollAnchor = bVar;
            this.onCancel = onCancel;
            this.dispatchChanges = true;
        }

        /* renamed from: a, reason: from getter */
        public final T5.h getBinding() {
            return this.binding;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDispatchChanges() {
            return this.dispatchChanges;
        }

        /* renamed from: c, reason: from getter */
        public final ViewGroup getHost() {
            return this.host;
        }

        /* renamed from: d, reason: from getter */
        public final ViewTreeObserver.OnWindowFocusChangeListener getImeFocusListener() {
            return this.imeFocusListener;
        }

        /* renamed from: e, reason: from getter */
        public final Runnable getImeRetryRunnable() {
            return this.imeRetryRunnable;
        }

        public final InterfaceC5063a<Y8.t> f() {
            return this.onCancel;
        }

        /* renamed from: g, reason: from getter */
        public final Object getOwner() {
            return this.owner;
        }

        /* renamed from: h, reason: from getter */
        public final b getScrollAnchor() {
            return this.scrollAnchor;
        }

        public final TextWatcher i() {
            TextWatcher textWatcher = this.watcher;
            if (textWatcher != null) {
                return textWatcher;
            }
            kotlin.jvm.internal.p.A("watcher");
            return null;
        }

        public final void j(boolean z10) {
            this.dispatchChanges = z10;
        }

        public final void k(ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener) {
            this.imeFocusListener = onWindowFocusChangeListener;
        }

        public final void l(Runnable runnable) {
            this.imeRetryRunnable = runnable;
        }

        public final void m(TextWatcher textWatcher) {
            kotlin.jvm.internal.p.i(textWatcher, "<set-?>");
            this.watcher = textWatcher;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/S$b;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "itemView", "", "position", "offsetFromBottom", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;II)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "Landroidx/recyclerview/widget/RecyclerView;", Const.INTENT_KEY_APIKEY, "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final View itemView;
        private final int offsetFromBottom;
        private final int position;
        private final RecyclerView recyclerView;

        public b(RecyclerView recyclerView, View itemView, int i10, int i11) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.recyclerView = recyclerView;
            this.itemView = itemView;
            this.position = i10;
            this.offsetFromBottom = i11;
        }

        /* renamed from: a, reason: from getter */
        public final RecyclerView getRecyclerView() {
            return this.recyclerView;
        }

        public final void b() {
            if (this.recyclerView.isAttachedToWindow()) {
                RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null) {
                    return;
                }
                int childAdapterPosition = this.recyclerView.getChildAdapterPosition(this.itemView);
                if (childAdapterPosition == -1) {
                    childAdapterPosition = this.position;
                }
                if (childAdapterPosition == -1) {
                    return;
                }
                linearLayoutManager.scrollToPositionWithOffset(childAdapterPosition, this.offsetFromBottom);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/appauther/S$c", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "LY8/t;", "onWindowFocusChanged", "(Z)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements ViewTreeObserver.OnWindowFocusChangeListener {
        final /* synthetic */ EditText $input;
        final /* synthetic */ a $session;

        public c(EditText editText, a aVar) {
            this.$input = editText;
            this.$session = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            if (hasFocus) {
                if (this.$input.getViewTreeObserver().isAlive()) {
                    this.$input.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                }
                this.$session.k(null);
                S s10 = S.INSTANCE;
                s10.R(this.$session, false);
                s10.J(this.$session);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/appauther/S$d", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "LY8/t;", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "st", "c", Const.INTENT_KEY_APIKEY, "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", Const.INTENT_KEY_PKGNAME, "onTextChanged", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements TextWatcher {
        final /* synthetic */ View $anchor;
        final /* synthetic */ T5.h $binding;
        final /* synthetic */ String $initial;
        final /* synthetic */ InterfaceC5074l<String, Y8.t> $onValueChanged;
        final /* synthetic */ a $session;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a aVar, InterfaceC5074l<? super String, Y8.t> interfaceC5074l, T5.h hVar, String str, View view) {
            this.$session = aVar;
            this.$onValueChanged = interfaceC5074l;
            this.$binding = hVar;
            this.$initial = str;
            this.$anchor = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            S.Q(this.$binding, this.$initial, this.$anchor);
            if (this.$session.getDispatchChanges()) {
                InterfaceC5074l<String, Y8.t> interfaceC5074l = this.$onValueChanged;
                String string = s10 != null ? s10.toString() : null;
                if (string == null) {
                    string = "";
                }
                interfaceC5074l.invoke(string);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int st, int c10, int a10) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int st, int b10, int c10) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/appauther/S$e", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements View.OnAttachStateChangeListener {
        final /* synthetic */ a $session;

        public e(a aVar) {
            this.$session = aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            a aVar = S.showing;
            a aVar2 = this.$session;
            if (aVar == aVar2) {
                S.INSTANCE.u(aVar2, false);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/appauther/S$f", "Landroidx/core/view/Z$b;", "Landroidx/core/view/a0;", "insets", "", "Landroidx/core/view/Z;", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", "animation", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/core/view/Z;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends Z.b {
        final /* synthetic */ b $scrollAnchor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar) {
            super(1);
            this.$scrollAnchor = bVar;
        }

        @Override // androidx.core.view.Z.b
        public void b(Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            super.b(animation);
            if ((animation.d() & a0.o.b()) != 0) {
                S.INSTANCE.G(this.$scrollAnchor);
            }
        }

        @Override // androidx.core.view.Z.b
        public a0 d(a0 insets, List<Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            return insets;
        }
    }

    public static final C1315c B(EditText editText, View view, C1315c payload) {
        String string;
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(payload, "payload");
        Editable text = editText.getText();
        int itemCount = payload.a().getItemCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < itemCount; i10++) {
            CharSequence charSequenceCoerceToText = payload.a().getItemAt(i10).coerceToText(editText.getContext());
            if (charSequenceCoerceToText != null && (string = charSequenceCoerceToText.toString()) != null) {
                if (z10) {
                    text.insert(C5685n.f(Selection.getSelectionEnd(text), 0), "\n");
                    text.insert(C5685n.f(Selection.getSelectionEnd(text), 0), string);
                } else {
                    S s10 = INSTANCE;
                    kotlin.jvm.internal.p.f(text);
                    s10.F(text, string);
                }
                z10 = true;
            }
        }
        if (z10) {
            return null;
        }
        return payload;
    }

    public static final void H(RecyclerView recyclerView, final b bVar) {
        recyclerView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.Q
            @Override // java.lang.Runnable
            public final void run() {
                S.I(bVar);
            }
        });
    }

    public static final void I(b bVar) {
        bVar.b();
    }

    public static final void K(a aVar, EditText editText) {
        if (showing == aVar && editText.isAttachedToWindow() && editText.hasFocus()) {
            S s10 = INSTANCE;
            if (s10.C(editText)) {
                return;
            }
            s10.R(aVar, true);
        }
    }

    public static final void M(a aVar, View view) {
        INSTANCE.u(aVar, true);
    }

    public static final void N(T5.h hVar, a aVar, InterfaceC5074l interfaceC5074l, View view) {
        String string;
        if (hVar.btnKeyDialogConfirm.isEnabled()) {
            Editable text = hVar.etKeyDialogInput.getText();
            String string2 = (text == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
            if (string2 == null) {
                string2 = "";
            }
            R5.b.INSTANCE.c(TAG_EVENT_CONFIRM, Y8.j.a("len", Integer.valueOf(string2.length())));
            INSTANCE.u(aVar, false);
            interfaceC5074l.invoke(string2);
        }
    }

    public static final void O(View view) {
    }

    public static final boolean P(a aVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            S s10 = INSTANCE;
            kotlin.jvm.internal.p.f(view);
            kotlin.jvm.internal.p.f(motionEvent);
            if (!s10.D(view, motionEvent)) {
                s10.u(aVar, true);
            }
        }
        return true;
    }

    public static final void Q(T5.h hVar, String str, View view) {
        String string;
        String string2;
        Editable text = hVar.etKeyDialogInput.getText();
        boolean z10 = !(text == null || (string = text.toString()) == null || (string2 = La.H.D1(string).toString()) == null || string2.length() <= 0) || La.H.D1(str).toString().length() > 0;
        hVar.btnKeyDialogConfirm.setEnabled(z10);
        hVar.btnKeyDialogConfirm.setTextColor(androidx.core.content.a.c(view.getContext(), z10 ? R$color.card_text_primary : R$color.card_text_secondary));
    }

    public static final void t(FrameLayout frameLayout) {
        ViewParent parent = frameLayout.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(frameLayout);
        }
    }

    public static final void y(a aVar) {
        S s10 = INSTANCE;
        s10.R(aVar, false);
        s10.J(aVar);
    }

    public final void A(final EditText input) {
        androidx.core.view.N.v0(input, new String[]{"text/*"}, new androidx.core.view.B() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.O
            @Override // androidx.core.view.B
            public final C1315c a(View view, C1315c c1315c) {
                return S.B(input, view, c1315c);
            }
        });
    }

    public final boolean C(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        return rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsets.Type.ime());
    }

    public final boolean D(View view, MotionEvent event) {
        t0.e eVarF;
        a0 a0VarB = androidx.core.view.N.B(view);
        int i10 = (a0VarB == null || (eVarF = a0VarB.f(a0.o.b())) == null) ? 0 : eVarF.f41980d;
        return i10 > 0 && event.getY() >= ((float) (view.getHeight() - i10));
    }

    public final boolean E(View hostRoot) {
        kotlin.jvm.internal.p.i(hostRoot, "hostRoot");
        a aVar = showing;
        if (aVar == null) {
            return false;
        }
        FrameLayout frameLayoutB = aVar.getBinding().b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        if (frameLayoutB.isAttachedToWindow()) {
            return (aVar.getHost().getRootView() == hostRoot.getRootView()) || (aVar.getHost().getWindowToken() != null && aVar.getHost().getWindowToken() == hostRoot.getWindowToken());
        }
        return false;
    }

    public final void F(Editable editable, CharSequence replacement) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, replacement);
    }

    public final void G(final b anchor) {
        if (anchor == null) {
            return;
        }
        final RecyclerView recyclerView = anchor.getRecyclerView();
        recyclerView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.I
            @Override // java.lang.Runnable
            public final void run() {
                S.H(recyclerView, anchor);
            }
        });
    }

    public final void J(final a session) {
        final EditText etKeyDialogInput = session.getBinding().etKeyDialogInput;
        kotlin.jvm.internal.p.h(etKeyDialogInput, "etKeyDialogInput");
        Runnable imeRetryRunnable = session.getImeRetryRunnable();
        if (imeRetryRunnable != null) {
            etKeyDialogInput.removeCallbacks(imeRetryRunnable);
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.P
            @Override // java.lang.Runnable
            public final void run() {
                S.K(session, etKeyDialogInput);
            }
        };
        session.l(runnable);
        etKeyDialogInput.postDelayed(runnable, IME_RETRY_DELAY_MS);
    }

    public final void L(Object owner, View anchor, String title, String initial, InterfaceC5074l<? super String, Y8.t> onValueChanged, InterfaceC5063a<Y8.t> onCancel, final InterfaceC5074l<? super String, Y8.t> onConfirm) {
        T5.h binding;
        FrameLayout frameLayoutB;
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(initial, "initial");
        kotlin.jvm.internal.p.i(onValueChanged, "onValueChanged");
        kotlin.jvm.internal.p.i(onCancel, "onCancel");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        a aVar = showing;
        if (aVar == null || (binding = aVar.getBinding()) == null || (frameLayoutB = binding.b()) == null || !frameLayoutB.isAttachedToWindow()) {
            if (aVar != null) {
                u(aVar, false);
            }
            View rootView = anchor.getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup == null || viewGroup == anchor) {
                return;
            }
            b bVarR = r(anchor);
            final T5.h hVarC = T5.h.c(LayoutInflater.from(anchor.getContext()));
            kotlin.jvm.internal.p.h(hVarC, "inflate(...)");
            FrameLayout frameLayoutB2 = hVarC.b();
            kotlin.jvm.internal.p.h(frameLayoutB2, "getRoot(...)");
            hVarC.tvKeyDialogTitle.setText(title);
            hVarC.btnKeyDialogCancel.setText(AbstractC3297l.LABEL_DIALOG_CANCEL);
            hVarC.btnKeyDialogConfirm.setText(AbstractC3297l.LABEL_DIALOG_CONFIRM);
            EditText editText = hVarC.etKeyDialogInput;
            editText.setInputType(524289);
            editText.setImeOptions(editText.getImeOptions() | 16777216);
            editText.setText(initial);
            Editable text = editText.getText();
            editText.setSelection(text != null ? text.length() : 0);
            EditText etKeyDialogInput = hVarC.etKeyDialogInput;
            kotlin.jvm.internal.p.h(etKeyDialogInput, "etKeyDialogInput");
            A(etKeyDialogInput);
            final a aVar2 = new a(owner, hVarC, viewGroup, bVarR, onCancel);
            aVar2.m(new d(aVar2, onValueChanged, hVarC, initial, anchor));
            hVarC.etKeyDialogInput.addTextChangedListener(aVar2.i());
            frameLayoutB2.addOnAttachStateChangeListener(new e(aVar2));
            Q(hVarC, initial, anchor);
            hVarC.btnKeyDialogCancel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.J
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S.M(aVar2, view);
                }
            });
            hVarC.btnKeyDialogConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.K
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S.N(hVarC, aVar2, onConfirm, view);
                }
            });
            hVarC.llKeyDialogPanel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.L
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S.O(view);
                }
            });
            hVarC.flKeyDialogScrim.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.M
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return S.P(aVar2, view, motionEvent);
                }
            });
            androidx.core.view.N.E0(frameLayoutB2, new f(bVarR));
            viewGroup.addView(frameLayoutB2, new ViewGroup.LayoutParams(-1, -1));
            showing = aVar2;
            R5.b.INSTANCE.c(TAG_EVENT_SHOW, Y8.j.a("hasInitial", Boolean.valueOf(initial.length() > 0)));
            x(aVar2);
        }
    }

    public final void R(a session, boolean retry) {
        EditText etKeyDialogInput = session.getBinding().etKeyDialogInput;
        kotlin.jvm.internal.p.h(etKeyDialogInput, "etKeyDialogInput");
        if (showing == session && etKeyDialogInput.isAttachedToWindow()) {
            if (!etKeyDialogInput.hasFocus()) {
                etKeyDialogInput.requestFocus();
            }
            WindowInsetsController windowInsetsController = etKeyDialogInput.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            R5.b.INSTANCE.c("auther.keydialog.ime.show", Y8.j.a("retry", Boolean.valueOf(retry)), Y8.j.a("hasWindowFocus", Boolean.valueOf(etKeyDialogInput.hasWindowFocus())), Y8.j.a("hasInputFocus", Boolean.valueOf(etKeyDialogInput.hasFocus())), Y8.j.a("imeVisible", Boolean.valueOf(C(etKeyDialogInput))));
        }
    }

    public final void q(a session) {
        EditText etKeyDialogInput = session.getBinding().etKeyDialogInput;
        kotlin.jvm.internal.p.h(etKeyDialogInput, "etKeyDialogInput");
        ViewTreeObserver.OnWindowFocusChangeListener imeFocusListener = session.getImeFocusListener();
        if (imeFocusListener != null && etKeyDialogInput.getViewTreeObserver().isAlive()) {
            etKeyDialogInput.getViewTreeObserver().removeOnWindowFocusChangeListener(imeFocusListener);
        }
        session.k(null);
        Runnable imeRetryRunnable = session.getImeRetryRunnable();
        if (imeRetryRunnable != null) {
            etKeyDialogInput.removeCallbacks(imeRetryRunnable);
        }
        session.l(null);
    }

    public final b r(View view) {
        int childAdapterPosition;
        View view2 = view;
        while (true) {
            if (view2 == null) {
                view2 = null;
                break;
            }
            if (view2 instanceof RecyclerView) {
                break;
            }
            Object parent = view2.getParent();
            view2 = parent instanceof View ? (View) parent : null;
        }
        RecyclerView recyclerView = (RecyclerView) view2;
        if (recyclerView == null) {
            return null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return null;
        }
        while (view != null && view.getParent() != recyclerView) {
            Object parent2 = view.getParent();
            view = parent2 instanceof View ? (View) parent2 : null;
        }
        if (view == null || (childAdapterPosition = recyclerView.getChildAdapterPosition(view)) == -1) {
            return null;
        }
        return new b(recyclerView, view, childAdapterPosition, (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - linearLayoutManager.getDecoratedBottom(view));
    }

    public final void s(a session) {
        final FrameLayout frameLayoutB = session.getBinding().b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        if (showing == session) {
            showing = null;
        }
        frameLayoutB.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.H
            @Override // java.lang.Runnable
            public final void run() {
                S.t(frameLayoutB);
            }
        });
    }

    public final void u(a session, boolean cancelled) {
        T5.h binding = session.getBinding();
        if (cancelled) {
            session.f().invoke();
        }
        q(session);
        FrameLayout frameLayoutB = binding.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        z(frameLayoutB);
        session.j(false);
        binding.etKeyDialogInput.removeTextChangedListener(session.i());
        binding.etKeyDialogInput.setText((CharSequence) null);
        s(session);
        G(session.getScrollAnchor());
    }

    public final void v(View hostRoot) {
        kotlin.jvm.internal.p.i(hostRoot, "hostRoot");
        a aVar = showing;
        if (aVar == null) {
            return;
        }
        boolean z10 = aVar.getHost().getRootView() == hostRoot.getRootView();
        boolean z11 = aVar.getHost().getWindowToken() != null && aVar.getHost().getWindowToken() == hostRoot.getWindowToken();
        if (z10 || z11) {
            u(aVar, false);
        }
    }

    public final void w(Object owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        a aVar = showing;
        if (aVar != null && aVar.getOwner() == owner) {
            u(aVar, false);
        }
    }

    public final void x(final a session) {
        EditText etKeyDialogInput = session.getBinding().etKeyDialogInput;
        kotlin.jvm.internal.p.h(etKeyDialogInput, "etKeyDialogInput");
        etKeyDialogInput.requestFocus();
        if (etKeyDialogInput.hasWindowFocus()) {
            etKeyDialogInput.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.N
                @Override // java.lang.Runnable
                public final void run() {
                    S.y(session);
                }
            });
            return;
        }
        c cVar = new c(etKeyDialogInput, session);
        session.k(cVar);
        etKeyDialogInput.getViewTreeObserver().addOnWindowFocusChangeListener(cVar);
    }

    public final void z(View root) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = root.getContext().getSystemService("input_method");
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            Result.b(inputMethodManager != null ? Boolean.valueOf(inputMethodManager.hideSoftInputFromWindow(root.getWindowToken(), 0)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }
}
