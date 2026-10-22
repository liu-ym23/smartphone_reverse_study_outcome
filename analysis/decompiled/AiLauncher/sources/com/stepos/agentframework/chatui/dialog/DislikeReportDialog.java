package com.stepos.agentframework.chatui.dialog;

import Ua.C1060i;
import Ua.Y;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.stepos.agentframework.R$array;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.R$style;
import com.stepos.agentframework.chatui.dialog.DislikeReportDialog;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0003FGHB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u001f\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0013H\u0002¢\u0006\u0004\b%\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006I"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onDismissed", "<init>", "(Landroid/content/Context;Lp9/a;)V", "Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$b;", "listener", "L", "(Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$b;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "M", "(Landroid/view/View;)V", "F", "()V", "", "I", "()Z", "h0", "n0", "J", "m0", "K", "ctx", "G", "(Landroid/content/Context;)Z", ExifInterface.LONGITUDE_EAST, "Landroid/widget/Button;", "submitButton", "Landroid/widget/EditText;", "feedbackInput", "o0", "(Landroid/widget/Button;Landroid/widget/EditText;)V", "H", "Landroid/content/Context;", "Lp9/a;", "onSubmitListener", "Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$b;", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "selectedReasons", "Ljava/util/LinkedHashSet;", "Landroid/app/Dialog;", C3081a.FOCUS_DIALOG_NAME, "Landroid/app/Dialog;", "Lkotlinx/coroutines/g;", "fetchJob", "Lkotlinx/coroutines/g;", "Ljava/lang/ref/WeakReference;", "ownerRootRef", "Ljava/lang/ref/WeakReference;", "Ly7/E;", "closeGlassHandle", "Ly7/E;", "panelLayerId", "Ljava/lang/String;", "panelTracked", "Z", "Lcom/stepos/agentframework/chatui/panelui/a;", "recentsVisibility", "Lcom/stepos/agentframework/chatui/panelui/a;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "hostImeLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Companion", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DislikeReportDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float FEEDBACK_DIALOG_HEIGHT_REDUCTION_DP = 20.0f;
    private static final float NINE_SCREEN_HEIGHT_RATIO = 0.9f;
    private static final String TAG = "DislikeReportDialog";
    private static volatile DislikeReportDialog showingInstance;
    private y7.E closeGlassHandle;
    private final Context context;
    private Dialog dialog;
    private kotlinx.coroutines.g fetchJob;
    private ViewTreeObserver.OnGlobalLayoutListener hostImeLayoutListener;
    private final InterfaceC5063a<Y8.t> onDismissed;
    private b onSubmitListener;
    private WeakReference<View> ownerRootRef;
    private final String panelLayerId;
    private boolean panelTracked;
    private com.stepos.agentframework.chatui.panelui.a recentsVisibility;
    private final LinkedHashSet<String> selectedReasons;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR(\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "ownerRoot", "", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)Z", "Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog;", UxipConstants.f30680s, "showingInstance", "Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog;", "c", "()Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog;", "", "TAG", "Ljava/lang/String;", "", "NINE_SCREEN_HEIGHT_RATIO", "F", "FEEDBACK_DIALOG_HEIGHT_REDUCTION_DP", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.dialog.DislikeReportDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a() {
            DislikeReportDialog dislikeReportDialogC = c();
            if (dislikeReportDialogC == null) {
                return;
            }
            DislikeReportDialog.showingInstance = null;
            dislikeReportDialogC.m0();
            dislikeReportDialogC.F();
        }

        public final boolean b(View ownerRoot) {
            Object objB;
            DislikeReportDialog dislikeReportDialogC = c();
            if (dislikeReportDialogC == null) {
                return false;
            }
            WeakReference weakReference = dislikeReportDialogC.ownerRootRef;
            View view = weakReference != null ? (View) weakReference.get() : null;
            if ((ownerRoot != null && view != null && view != ownerRoot) || !dislikeReportDialogC.I()) {
                return false;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                dislikeReportDialogC.F();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE == null) {
                return true;
            }
            C4148a.u(DislikeReportDialog.TAG, "dismissAllShowingForWake failed: " + thE.getMessage(), false, 4, null);
            return true;
        }

        public final DislikeReportDialog c() {
            return DislikeReportDialog.showingInstance;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$b;", "", "", "", "reasons", "feedbackText", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Ljava/lang/String;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a(List<String> reasons, String feedbackText);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B/\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$c$a;", "", "", "reasons", "Lkotlin/Function2;", "", "LY8/t;", "onToggle", "<init>", "(Ljava/util/List;Lp9/p;)V", "newReasons", "submitList", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "f", "(Landroid/view/ViewGroup;I)Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$c$a;", "holder", "position", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$c$a;I)V", "getItemCount", "()I", "Ljava/util/List;", "Lp9/p;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selected", "Ljava/util/HashSet;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.Adapter<a> {
        private final p9.p<String, Boolean, Y8.t> onToggle;
        private List<String> reasons;
        private final HashSet<String> selected;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/DislikeReportDialog$c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/appcompat/widget/AppCompatTextView;", "reasonView", "<init>", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "Landroidx/appcompat/widget/AppCompatTextView;", Const.INTENT_KEY_APIKEY, "()Landroidx/appcompat/widget/AppCompatTextView;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a extends RecyclerView.ViewHolder {
            private final AppCompatTextView reasonView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AppCompatTextView reasonView) {
                super(reasonView);
                kotlin.jvm.internal.p.i(reasonView, "reasonView");
                this.reasonView = reasonView;
            }

            /* renamed from: a, reason: from getter */
            public final AppCompatTextView getReasonView() {
                return this.reasonView;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<String> reasons, p9.p<? super String, ? super Boolean, Y8.t> onToggle) {
            kotlin.jvm.internal.p.i(reasons, "reasons");
            kotlin.jvm.internal.p.i(onToggle, "onToggle");
            this.reasons = reasons;
            this.onToggle = onToggle;
            this.selected = new HashSet<>();
        }

        public static final void e(c cVar, String str, a aVar, View view) {
            boolean z10;
            if (cVar.selected.contains(str)) {
                cVar.selected.remove(str);
                z10 = false;
            } else {
                cVar.selected.add(str);
                z10 = true;
            }
            aVar.getReasonView().setSelected(z10);
            cVar.onToggle.invoke(str, Boolean.valueOf(z10));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(final a holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            final String str = this.reasons.get(position);
            holder.getReasonView().setText(str);
            holder.getReasonView().setSelected(this.selected.contains(str));
            ViewGroup.LayoutParams layoutParams = holder.getReasonView().getLayoutParams();
            kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            float f10 = 12;
            layoutParams2.setMarginEnd((int) (holder.getReasonView().getResources().getDisplayMetrics().density * f10));
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) (holder.getReasonView().getResources().getDisplayMetrics().density * f10);
            holder.getReasonView().setLayoutParams(layoutParams2);
            holder.getReasonView().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.dialog.A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DislikeReportDialog.c.e(this.f22876a, str, holder, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_dislike_reason, parent, false);
            kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            return new a((AppCompatTextView) viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.reasons.size();
        }

        public final void submitList(List<String> newReasons) {
            kotlin.jvm.internal.p.i(newReasons, "newReasons");
            this.reasons = newReasons;
            this.selected.clear();
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/stepos/agentframework/chatui/dialog/DislikeReportDialog$d", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "Landroidx/core/view/Z$a;", "bounds", "e", "(Landroidx/core/view/Z;Landroidx/core/view/Z$a;)Landroidx/core/view/Z$a;", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/core/view/Z;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends Z.b {
        final /* synthetic */ int $baseBottomPadding;
        final /* synthetic */ FeedbackDragDismissLayout $contentRoot;
        final /* synthetic */ int $displayH;
        final /* synthetic */ View $hostRoot;
        final /* synthetic */ Ref$IntRef $lastImeApplied;
        final /* synthetic */ NestedScrollView $scrollContent;
        final /* synthetic */ DislikeReportDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View view, DislikeReportDialog dislikeReportDialog, FeedbackDragDismissLayout feedbackDragDismissLayout, int i10, int i11, Ref$IntRef ref$IntRef, NestedScrollView nestedScrollView) {
            super(0);
            this.$hostRoot = view;
            this.this$0 = dislikeReportDialog;
            this.$contentRoot = feedbackDragDismissLayout;
            this.$displayH = i10;
            this.$baseBottomPadding = i11;
            this.$lastImeApplied = ref$IntRef;
            this.$scrollContent = nestedScrollView;
        }

        @Override // androidx.core.view.Z.b
        public void b(Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            C4148a.k(DislikeReportDialog.TAG, "[IME_DIAG] anim onEnd", false, 4, null);
            DislikeReportDialog.e0(this.$contentRoot, this.$hostRoot, this.$lastImeApplied, this.this$0, this.$displayH, this.$baseBottomPadding, this.$scrollContent, "animEnd");
        }

        @Override // androidx.core.view.Z.b
        public a0 d(a0 insets, List<Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            int i10 = insets.f(a0.o.b()).f41980d;
            View view = this.$hostRoot;
            kotlin.jvm.internal.p.f(view);
            int iMax = Math.max(i10, Math.max(DislikeReportDialog.O(view), DislikeReportDialog.f0(this.this$0, this.$hostRoot, this.$contentRoot, this.$displayH)));
            View view2 = this.$hostRoot;
            kotlin.jvm.internal.p.f(view2);
            C4148a.k(DislikeReportDialog.TAG, "[IME_DIAG] anim onProgress progIme=" + i10 + " hostIme=" + DislikeReportDialog.O(view2) + " visIme=" + DislikeReportDialog.f0(this.this$0, this.$hostRoot, this.$contentRoot, this.$displayH), false, 4, null);
            DislikeReportDialog.N(this.$hostRoot, this.$contentRoot, this.$baseBottomPadding, iMax);
            return insets;
        }

        @Override // androidx.core.view.Z.b
        public Z.a e(Z animation, Z.a bounds) {
            kotlin.jvm.internal.p.i(animation, "animation");
            kotlin.jvm.internal.p.i(bounds, "bounds");
            C4148a.k(DislikeReportDialog.TAG, "[IME_DIAG] anim onStart typeMask=" + animation.d() + " lower=" + bounds.a().f41980d + " upper=" + bounds.b().f41980d, false, 4, null);
            Z.a aVarE = super.e(animation, bounds);
            kotlin.jvm.internal.p.h(aVarE, "onStart(...)");
            return aVarE;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/dialog/DislikeReportDialog$e", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements View.OnAttachStateChangeListener {
        public e() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            y7.E e10 = DislikeReportDialog.this.closeGlassHandle;
            if (e10 != null) {
                e10.g();
            }
            DislikeReportDialog.this.closeGlassHandle = null;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/agentframework/chatui/dialog/DislikeReportDialog$f", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements TextWatcher {
        final /* synthetic */ EditText $feedbackInput;
        final /* synthetic */ Button $submitButton;

        public f(Button button, EditText editText) {
            this.$submitButton = button;
            this.$feedbackInput = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            DislikeReportDialog dislikeReportDialog = DislikeReportDialog.this;
            Button button = this.$submitButton;
            kotlin.jvm.internal.p.f(button);
            EditText editText = this.$feedbackInput;
            kotlin.jvm.internal.p.f(editText);
            dislikeReportDialog.o0(button, editText);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public DislikeReportDialog(Context context, InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(context, "context");
        this.context = context;
        this.onDismissed = interfaceC5063a;
        this.selectedReasons = new LinkedHashSet<>();
        this.panelLayerId = "dislike_report_" + System.identityHashCode(this);
    }

    public static final void N(View view, FeedbackDragDismissLayout feedbackDragDismissLayout, int i10, int i11) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        feedbackDragDismissLayout.getLocationOnScreen(iArr2);
        int height = (iArr[1] + view.getHeight()) - i11;
        int height2 = iArr2[1] + feedbackDragDismissLayout.getHeight();
        int iF = i11 > 0 ? C5685n.f(height2 - height, 0) : 0;
        C4148a.k(TAG, "[IME_DIAG] apply ime=" + i11 + " extra=" + iF + " base=" + i10 + " dialogBottomY=" + height2 + " keyboardTopY=" + height + " hostBottomY=" + (iArr[1] + view.getHeight()) + " crH=" + feedbackDragDismissLayout.getHeight(), false, 4, null);
        feedbackDragDismissLayout.setPadding(feedbackDragDismissLayout.getPaddingLeft(), feedbackDragDismissLayout.getPaddingTop(), feedbackDragDismissLayout.getPaddingRight(), i10 + iF);
    }

    public static final int O(View view) {
        t0.e eVarF;
        a0 a0VarB = androidx.core.view.N.B(view);
        if (a0VarB == null || (eVarF = a0VarB.f(a0.o.b())) == null) {
            return 0;
        }
        return eVarF.f41980d;
    }

    public static final Y8.t P(DislikeReportDialog dislikeReportDialog, Button button, EditText editText, String reason, boolean z10) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (z10) {
            dislikeReportDialog.selectedReasons.add(reason);
        } else {
            dislikeReportDialog.selectedReasons.remove(reason);
        }
        kotlin.jvm.internal.p.f(button);
        kotlin.jvm.internal.p.f(editText);
        dislikeReportDialog.o0(button, editText);
        return Y8.t.f7040a;
    }

    public static final a0 Q(FeedbackDragDismissLayout feedbackDragDismissLayout, View view, Ref$IntRef ref$IntRef, DislikeReportDialog dislikeReportDialog, int i10, int i11, NestedScrollView nestedScrollView, View view2, a0 insets) {
        kotlin.jvm.internal.p.i(view2, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        C4148a.k(TAG, "[IME_DIAG] applyWindowInsets(dialog) ime=" + insets.f(a0.o.b()).f41980d + " nav=" + insets.f(a0.o.e()).f41980d, false, 4, null);
        e0(feedbackDragDismissLayout, view, ref$IntRef, dislikeReportDialog, i10, i11, nestedScrollView, "applyInsets");
        return insets;
    }

    public static final void R(FeedbackDragDismissLayout feedbackDragDismissLayout, View view, Ref$IntRef ref$IntRef, DislikeReportDialog dislikeReportDialog, int i10, int i11, NestedScrollView nestedScrollView) {
        e0(feedbackDragDismissLayout, view, ref$IntRef, dislikeReportDialog, i10, i11, nestedScrollView, "hostLayout");
    }

    public static final void S(FeedbackDragDismissLayout feedbackDragDismissLayout, View view, Ref$IntRef ref$IntRef, DislikeReportDialog dislikeReportDialog, int i10, int i11, NestedScrollView nestedScrollView) {
        e0(feedbackDragDismissLayout, view, ref$IntRef, dislikeReportDialog, i10, i11, nestedScrollView, "dialogLayout");
    }

    public static final void T(FeedbackDragDismissLayout feedbackDragDismissLayout) {
        androidx.core.view.N.e0(feedbackDragDismissLayout);
    }

    public static final void U(DislikeReportDialog dislikeReportDialog, View view) {
        Dialog dialog = dislikeReportDialog.dialog;
        if (dialog != null && dialog.isShowing() && view.isAttachedToWindow() && dislikeReportDialog.closeGlassHandle == null) {
            float width = view.getWidth() > 0 ? view.getWidth() / 2.0f : dislikeReportDialog.context.getResources().getDisplayMetrics().density * 12.0f;
            s7.p pVar = s7.p.f40121a;
            kotlin.jvm.internal.p.f(view);
            y7.B bI = y7.H.a(pVar, view).x(false).i(y7.o.INSTANCE.l());
            bI.w(width);
            y7.E eU = bI.u();
            if (eU.c() == 0) {
                eU.g();
                dislikeReportDialog.closeGlassHandle = null;
            } else {
                dislikeReportDialog.closeGlassHandle = eU;
                view.setBackground(null);
            }
        }
    }

    public static final void V(Button button, DislikeReportDialog dislikeReportDialog, EditText editText, View view) {
        String string;
        if (button.isEnabled()) {
            b bVar = dislikeReportDialog.onSubmitListener;
            if (bVar != null) {
                List<String> listM1 = Z8.F.m1(dislikeReportDialog.selectedReasons);
                Editable text = editText.getText();
                String string2 = (text == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
                if (string2 == null) {
                    string2 = "";
                }
                bVar.a(listM1, string2);
            }
            dislikeReportDialog.F();
        }
    }

    public static final void W(DislikeReportDialog dislikeReportDialog, View view) {
        dislikeReportDialog.F();
    }

    public static final void X(View view, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.i(nestedScrollView2, "<unused var>");
        b0(view, nestedScrollView);
    }

    public static final void Y(View view, NestedScrollView nestedScrollView) {
        b0(view, nestedScrollView);
    }

    public static final void Z(DislikeReportDialog dislikeReportDialog, DialogInterface dialogInterface) {
        dislikeReportDialog.n0();
        dislikeReportDialog.m0();
        dislikeReportDialog.K();
        kotlinx.coroutines.g gVar = dislikeReportDialog.fetchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        dislikeReportDialog.fetchJob = null;
        dislikeReportDialog.selectedReasons.clear();
        y7.E e10 = dislikeReportDialog.closeGlassHandle;
        if (e10 != null) {
            e10.g();
        }
        dislikeReportDialog.closeGlassHandle = null;
        InterfaceC5063a<Y8.t> interfaceC5063a = dislikeReportDialog.onDismissed;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t a0(DislikeReportDialog dislikeReportDialog) {
        Window window;
        Dialog dialog = dislikeReportDialog.dialog;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setWindowAnimations(0);
        }
        dislikeReportDialog.F();
        return Y8.t.f7040a;
    }

    public static final void b0(View view, NestedScrollView nestedScrollView) {
        view.setVisibility(nestedScrollView.canScrollVertically(-1) ? 0 : 8);
    }

    public static final void c0(final NestedScrollView nestedScrollView) {
        nestedScrollView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.q
            @Override // java.lang.Runnable
            public final void run() {
                DislikeReportDialog.d0(nestedScrollView);
            }
        });
    }

    public static final void d0(NestedScrollView nestedScrollView) {
        View childAt = nestedScrollView.getChildAt(0);
        if (childAt != null) {
            nestedScrollView.Q(0, childAt.getBottom());
        }
    }

    public static final void e0(FeedbackDragDismissLayout feedbackDragDismissLayout, View view, Ref$IntRef ref$IntRef, DislikeReportDialog dislikeReportDialog, int i10, int i11, NestedScrollView nestedScrollView, String str) {
        kotlin.jvm.internal.p.f(feedbackDragDismissLayout);
        int iO = O(feedbackDragDismissLayout);
        kotlin.jvm.internal.p.f(view);
        int iO2 = O(view);
        int iF0 = f0(dislikeReportDialog, view, feedbackDragDismissLayout, i10);
        int iMax = Math.max(iO, Math.max(iO2, iF0));
        C4148a.k(TAG, "[IME_DIAG] sync(" + str + ") dialogIme=" + iO + " hostIme=" + iO2 + " visIme=" + iF0 + " -> ime=" + iMax, false, 4, null);
        if (iMax == ref$IntRef.f34818a) {
            return;
        }
        ref$IntRef.f34818a = iMax;
        N(view, feedbackDragDismissLayout, i11, iMax);
        if (iMax > 0) {
            c0(nestedScrollView);
        }
    }

    public static final int f0(DislikeReportDialog dislikeReportDialog, View view, FeedbackDragDismissLayout feedbackDragDismissLayout, int i10) {
        int i11 = (int) (80 * dislikeReportDialog.context.getResources().getDisplayMetrics().density);
        kotlin.jvm.internal.p.f(view);
        int iG0 = g0(i10, i11, view);
        kotlin.jvm.internal.p.f(feedbackDragDismissLayout);
        return Math.max(iG0, g0(i10, i11, feedbackDragDismissLayout));
    }

    public static final int g0(int i10, int i11, View view) {
        t0.e eVarF;
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int iF = C5685n.f(i10 - rect.bottom, 0);
        a0 a0VarB = androidx.core.view.N.B(view);
        if (iF > ((a0VarB == null || (eVarF = a0VarB.f(a0.o.e())) == null) ? 0 : eVarF.f41980d) + i11) {
            return iF;
        }
        return 0;
    }

    public static final boolean i0(DislikeReportDialog dislikeReportDialog) {
        return dislikeReportDialog.I();
    }

    public static final Y8.t j0(DislikeReportDialog dislikeReportDialog) {
        dislikeReportDialog.F();
        return Y8.t.f7040a;
    }

    public static final boolean k0(DislikeReportDialog dislikeReportDialog) {
        com.stepos.agentframework.chatui.panelui.a aVar = dislikeReportDialog.recentsVisibility;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    public static final boolean l0(DislikeReportDialog dislikeReportDialog) {
        com.stepos.agentframework.chatui.panelui.a aVar = dislikeReportDialog.recentsVisibility;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public final boolean E() {
        if (G(this.context) || Settings.canDrawOverlays(this.context)) {
            return true;
        }
        C4148a.h(TAG, "skip show: no activity token and overlay permission denied, context=" + this.context.getClass().getName(), false, 4, null);
        return false;
    }

    public final void F() {
        n0();
        m0();
        K();
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.recentsVisibility = null;
        this.dialog = null;
        this.ownerRootRef = null;
    }

    public final boolean G(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return true;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return false;
    }

    public final boolean H() {
        return kotlin.jvm.internal.p.d(this.context.getResources().getConfiguration().getLocales().get(0).getLanguage(), Locale.ENGLISH.getLanguage());
    }

    public final boolean I() {
        Dialog dialog = this.dialog;
        return dialog != null && dialog.isShowing();
    }

    public final void J() {
        showingInstance = this;
    }

    public final void K() {
        View view;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.hostImeLayoutListener;
        if (onGlobalLayoutListener == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = null;
        this.hostImeLayoutListener = null;
        WeakReference<View> weakReference = this.ownerRootRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            viewTreeObserver = view.getViewTreeObserver();
        }
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public final void L(b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onSubmitListener = listener;
    }

    public final void M(View anchor) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        Dialog dialog = this.dialog;
        if ((dialog == null || !dialog.isShowing()) && E()) {
            View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.dialog_dislike_report, (ViewGroup) null, false);
            final Button button = (Button) viewInflate.findViewById(R$id.btn_submit);
            final EditText editText = (EditText) viewInflate.findViewById(R$id.et_feedback);
            RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.rv_reasons);
            final NestedScrollView nestedScrollView = (NestedScrollView) viewInflate.findViewById(R$id.scroll_content);
            final View viewFindViewById = viewInflate.findViewById(R$id.top_fade);
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.context);
            flexboxLayoutManager.d0(0);
            flexboxLayoutManager.e0(1);
            flexboxLayoutManager.f0(0);
            flexboxLayoutManager.c0(0);
            recyclerView.setLayoutManager(flexboxLayoutManager);
            String[] stringArray = this.context.getResources().getStringArray(R$array.chat_dislike_reasons);
            kotlin.jvm.internal.p.h(stringArray, "getStringArray(...)");
            c cVar = new c(Z8.r.T0(stringArray), new p9.p() { // from class: com.stepos.agentframework.chatui.dialog.j
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return DislikeReportDialog.P(this.f22903a, button, editText, (String) obj, ((Boolean) obj2).booleanValue());
                }
            });
            recyclerView.setAdapter(cVar);
            this.fetchJob = C1060i.d(kotlinx.coroutines.d.a(Y.c()), null, null, new DislikeReportDialog$show$2(this, cVar, button, editText, null), 3, null);
            editText.addTextChangedListener(new f(button, editText));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.dialog.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DislikeReportDialog.V(button, this, editText, view);
                }
            });
            final View viewFindViewById2 = viewInflate.findViewById(R$id.btn_close);
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.dialog.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DislikeReportDialog.W(this.f22931a, view);
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.e() { // from class: com.stepos.agentframework.chatui.dialog.v
                @Override // androidx.core.widget.NestedScrollView.e
                public final void a(NestedScrollView nestedScrollView2, int i10, int i11, int i12, int i13) {
                    DislikeReportDialog.X(viewFindViewById, nestedScrollView, nestedScrollView2, i10, i11, i12, i13);
                }
            });
            nestedScrollView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.w
                @Override // java.lang.Runnable
                public final void run() {
                    DislikeReportDialog.Y(viewFindViewById, nestedScrollView);
                }
            });
            Dialog dialog2 = new Dialog(this.context, R$style.DislikeReportDialogStyle);
            dialog2.setContentView(viewInflate);
            dialog2.setCanceledOnTouchOutside(true);
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.agentframework.chatui.dialog.x
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DislikeReportDialog.Z(this.f22936a, dialogInterface);
                }
            });
            Window window = dialog2.getWindow();
            if (window != null) {
                Context context = window.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                if (!G(context)) {
                    window.setType(2038);
                }
                androidx.core.view.Y.b(window, false);
                window.setLayout(-1, C5685n.f(((int) (r3.heightPixels * 0.9f)) - ((int) ((window.getContext().getResources().getDisplayMetrics().density * 20.0f) + 0.5f)), 0));
                window.setGravity(80);
                window.setSoftInputMode(16);
            }
            this.dialog = dialog2;
            this.recentsVisibility = new com.stepos.agentframework.chatui.panelui.a(dialog2);
            J();
            this.ownerRootRef = new WeakReference<>(anchor.getRootView());
            Dialog dialog3 = this.dialog;
            if (dialog3 != null) {
                dialog3.show();
            }
            Dialog dialog4 = this.dialog;
            if (dialog4 == null || !dialog4.isShowing()) {
                m0();
            } else {
                h0();
            }
            final FeedbackDragDismissLayout feedbackDragDismissLayout = (FeedbackDragDismissLayout) viewInflate.findViewById(R$id.dislike_content_root);
            feedbackDragDismissLayout.setOnDismissRequested(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return DislikeReportDialog.a0(this.f22937a);
                }
            });
            final View rootView = anchor.getRootView();
            final int paddingBottom = feedbackDragDismissLayout.getPaddingBottom();
            final int i10 = this.context.getResources().getDisplayMetrics().heightPixels;
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.f34818a = -1;
            androidx.core.view.N.u0(feedbackDragDismissLayout, new androidx.core.view.A() { // from class: com.stepos.agentframework.chatui.dialog.z
                @Override // androidx.core.view.A
                public final a0 a(View view, a0 a0Var) {
                    return DislikeReportDialog.Q(feedbackDragDismissLayout, rootView, ref$IntRef, this, i10, paddingBottom, nestedScrollView, view, a0Var);
                }
            });
            androidx.core.view.N.E0(feedbackDragDismissLayout, new d(rootView, this, feedbackDragDismissLayout, i10, paddingBottom, ref$IntRef, nestedScrollView));
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.agentframework.chatui.dialog.k
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    DislikeReportDialog.R(feedbackDragDismissLayout, rootView, ref$IntRef, this, i10, paddingBottom, nestedScrollView);
                }
            };
            this.hostImeLayoutListener = onGlobalLayoutListener;
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
            feedbackDragDismissLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.agentframework.chatui.dialog.l
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    DislikeReportDialog.S(feedbackDragDismissLayout, rootView, ref$IntRef, this, i10, paddingBottom, nestedScrollView);
                }
            });
            feedbackDragDismissLayout.post(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.r
                @Override // java.lang.Runnable
                public final void run() {
                    DislikeReportDialog.T(feedbackDragDismissLayout);
                }
            });
            viewFindViewById2.post(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.s
                @Override // java.lang.Runnable
                public final void run() {
                    DislikeReportDialog.U(this.f22926a, viewFindViewById2);
                }
            });
            viewFindViewById2.addOnAttachStateChangeListener(new e());
        }
    }

    public final void h0() {
        if (this.panelTracked) {
            return;
        }
        this.panelTracked = true;
        com.stepos.agentframework.chatui.panelui.f fVar = com.stepos.agentframework.chatui.panelui.f.INSTANCE;
        String str = this.panelLayerId;
        PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
        WeakReference<View> weakReference = this.ownerRootRef;
        fVar.b(str, panelHomePolicy, weakReference != null ? weakReference.get() : null, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DislikeReportDialog.i0(this.f22920a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DislikeReportDialog.j0(this.f22921a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DislikeReportDialog.k0(this.f22922a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DislikeReportDialog.l0(this.f22923a));
            }
        });
    }

    public final void m0() {
        if (showingInstance == this) {
            showingInstance = null;
        }
    }

    public final void n0() {
        if (this.panelTracked) {
            this.panelTracked = false;
            com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(this.panelLayerId);
        }
    }

    public final void o0(Button submitButton, EditText feedbackInput) {
        boolean z10;
        String string;
        String string2;
        Editable text = feedbackInput.getText();
        boolean z11 = true;
        boolean z12 = (text == null || (string = text.toString()) == null || (string2 = La.H.D1(string).toString()) == null || string2.length() <= 0) ? false : true;
        String string3 = this.context.getString(R$string.chat_dislike_feedback_other);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        LinkedHashSet<String> linkedHashSet = this.selectedReasons;
        if (linkedHashSet == null || !linkedHashSet.isEmpty()) {
            for (String str : linkedHashSet) {
                if (kotlin.jvm.internal.p.d(str, "其它") || kotlin.jvm.internal.p.d(str, "其他") || kotlin.jvm.internal.p.d(str, string3)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (!z12 && (this.selectedReasons.isEmpty() || z10)) {
            z11 = false;
        }
        submitButton.setEnabled(z11);
    }
}
