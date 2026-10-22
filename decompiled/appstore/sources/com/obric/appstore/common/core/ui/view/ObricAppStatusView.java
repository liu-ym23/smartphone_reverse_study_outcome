package com.obric.appstore.common.core.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.l0;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.bytedanceos.common.ui.widget.oui.OAppStatusView;
import com.obric.appstore.R;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.ui.app.AppStatusViewModel;
import com.smt.obric.appstore.ui.app.AppUIStatus;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.h;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sa.n;
import tc.l;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0014¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b(\u0010)J)\u0010,\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J#\u00104\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010H\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u00101R\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Lcom/bytedanceos/common/ui/widget/oui/OAppStatusView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/appstore/common/core/ui/view/AppStatusBtnStyle;", "style", "", "v", "(Lcom/obric/appstore/common/core/ui/view/AppStatusBtnStyle;)V", "Lcom/bytedanceos/common/model/AppInfo;", "appInfo", "updateDownloadStatus", "(Lcom/bytedanceos/common/model/AppInfo;)V", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "", "pageSource", "operateApp", "(Landroid/app/Activity;Landroid/view/View;Lcom/bytedanceos/common/model/AppInfo;Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "r", "()Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "Lcom/smt/obric/appstore/ui/app/AppUIStatus;", WsConstants.KEY_CONNECTION_STATE, ServerElements.INFO, "s", "(Lcom/smt/obric/appstore/ui/app/AppUIStatus;Lcom/bytedanceos/common/model/AppInfo;)V", AppPermissionActivity.EXTRA_APP_PKG, "status", "q", "(Ljava/lang/String;Lcom/smt/obric/appstore/ui/app/AppUIStatus;Lcom/bytedanceos/common/model/AppInfo;)Ljava/lang/String;", "", "visible", "w", "(Z)V", "resid", "drawableLeft", "t", "(ILjava/lang/Integer;)V", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "viewScope", "b", "Lcom/smt/obric/appstore/ui/app/AppStatusViewModel;", "appStatusViewModel", "c", "Landroid/app/Activity;", "Lsa/n;", "d", "Lsa/n;", "binding", "e", "Z", "getUseForHomeCard", "()Z", "setUseForHomeCard", "useForHomeCard", "Lcom/obric/oui/progress/ODownloadProgressView;", "f", "Lkotlin/Lazy;", "getDownloadView", "()Lcom/obric/oui/progress/ODownloadProgressView;", "downloadView", "g", "Lcom/obric/appstore/common/core/ui/view/AppStatusBtnStyle;", "h", "Lcom/bytedanceos/common/model/AppInfo;", "currInfo", "i", "Landroid/view/View$OnClickListener;", "clickListener", "", "j", "J", "lastRunningLogTime", "Lkotlinx/coroutines/Job;", "k", "Lkotlinx/coroutines/Job;", "uiRenderJob", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nObricAppStatusView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAppStatusView.kt\ncom/obric/appstore/common/core/ui/view/ObricAppStatusView\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,333:1\n181#2,3:334\n180#2,5:337\n262#3,2:342\n262#3,2:344\n*S KotlinDebug\n*F\n+ 1 ObricAppStatusView.kt\ncom/obric/appstore/common/core/ui/view/ObricAppStatusView\n*L\n65#1:334,3\n65#1:337,5\n244#1:342,2\n280#1:344,2\n*E\n"})
public final class ObricAppStatusView extends OUIConstraintLayout implements OAppStatusView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoroutineScope f10932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppStatusViewModel f10933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f10934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f10935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f10937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppStatusBtnStyle f10938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppInfo f10939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnClickListener f10940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f10942k;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10943a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10944b = null;

        static {
            int[] r10 = new int[AppUIStatus.Status.values().length];
            r10[AppUIStatus.Status.NotInstalled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L34:
            r10[AppUIStatus.Status.UpdateAvailable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L52:
            r10[AppUIStatus.Status.Installed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L42:
            r10[AppUIStatus.Status.DownloadPending.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L44:
            r10[AppUIStatus.Status.DownloadRunning.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L32:
            r10[AppUIStatus.Status.Installing.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L46:
            r10[AppUIStatus.Status.DownloadPaused.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            r10[AppUIStatus.Status.DownloadWaitWiFi.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L36:
            r10[AppUIStatus.Status.DownloadFailed.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L14:
            f10943a = r10;
            int[] r11 = new int[AppStatusBtnStyle.values().length];
            r11[AppStatusBtnStyle.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L54:
            r11[AppStatusBtnStyle.ACCENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L38:
            r11[AppStatusBtnStyle.DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L18:
            f10944b = r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1", f = "ObricAppStatusView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nObricAppStatusView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAppStatusView.kt\ncom/obric/appstore/common/core/ui/view/ObricAppStatusView$onAttachedToWindow$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ObricAppStatusView this$0;

        /* JADX INFO: renamed from: com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1$2", f = "ObricAppStatusView.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppStatusViewModel $vm;
            int label;
            final /* synthetic */ ObricAppStatusView this$0;

            /* JADX INFO: renamed from: com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1$2$a */
            public static final class a implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ObricAppStatusView f10945a;

                public a(ObricAppStatusView r10) {
                    this.f10945a = r10;
                }

                public final Object a(AppUIStatus r10, Continuation r11) {
                    ObricAppStatusView r12 = this.f10945a;
                    ObricAppStatusView.n(r12, r10, ObricAppStatusView.m(r12));
                    return Unit.f21064a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                    return a((AppUIStatus) r10, r11);
                }
            }

            public AnonymousClass2(AppStatusViewModel r10, ObricAppStatusView r11, Continuation<? super AnonymousClass2> r12) {
                this.$vm = r10;
                this.this$0 = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new AnonymousClass2(this.$vm, this.this$0, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L6;
                kotlin.c.b(r10);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                StateFlow r13 = this.$vm.p();
                a r14 = new a(this.this$0);
                this.label = 1;
                if (r13.collect(r14, this) != r11) goto L12;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        /* JADX INFO: renamed from: com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.common.core.ui.view.ObricAppStatusView$onAttachedToWindow$1$3", f = "ObricAppStatusView.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppStatusViewModel $vm;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ObricAppStatusView this$0;

            public AnonymousClass3(AppStatusViewModel r10, ObricAppStatusView r11, Continuation<? super AnonymousClass3> r12) {
                this.$vm = r10;
                this.this$0 = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                AnonymousClass3 r12 = new AnonymousClass3(this.$vm, this.this$0, r11);
                r12.L$0 = r10;
                return r12;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L6;
                kotlin.c.b(r10);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                final CoroutineScope r13 = (CoroutineScope) this.L$0;
                final Ref$ObjectRef r14 = new Ref$ObjectRef();
                SharedFlow r15 = this.$vm.o();
                final ObricAppStatusView r16 = this.this$0;
                FlowCollector r17 = new C01711(r14, r13, r16);
                this.label = 1;
                if (r15.collect(r17, this) != r11) goto L12;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass1(ObricAppStatusView r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L15;
            kotlin.c.b(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            AppStatusViewModel r12 = ObricAppStatusView.j(this.this$0);
            if (r12 == null) goto L9;
            CoroutineScope r13 = l0.a(r12);
            if (r13 == null) goto L9;
            d0.d(r13, null, 1, null);
        L9:
            AppStatusViewModel r14 = ObricAppStatusView.h(this.this$0);
            ObricAppStatusView.o(this.this$0, r14);
            AppInfo r15 = ObricAppStatusView.m(this.this$0);
            if (r15 == null) goto L12;
            r14.q(AppInfoKtxKt.newDomainEntity$default(r15, null, 1, null));
        L12:
            h.d(r11, null, null, new AnonymousClass2(r14, this.this$0, null), 3, null);
            h.d(r11, null, null, new AnonymousClass3(r14, this.this$0, null), 3, null);
            return Unit.f21064a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    @JvmOverloads
    public ObricAppStatusView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void g(ObricAppStatusView r10, View r11) {
        p(r10, r11);
    }

    private final ODownloadProgressView getDownloadView() {
        return (ODownloadProgressView) this.f10937f.getValue();
    }

    public static final /* synthetic */ AppStatusViewModel h(ObricAppStatusView r10) {
        return r10.r();
    }

    public static final /* synthetic */ Activity i(ObricAppStatusView r10) {
        return r10.f10934c;
    }

    public static final /* synthetic */ AppStatusViewModel j(ObricAppStatusView r10) {
        return r10.f10933b;
    }

    public static final /* synthetic */ n k(ObricAppStatusView r10) {
        return r10.f10935d;
    }

    public static final /* synthetic */ View.OnClickListener l(ObricAppStatusView r10) {
        return r10.f10940i;
    }

    public static final /* synthetic */ AppInfo m(ObricAppStatusView r10) {
        return r10.f10939h;
    }

    public static final /* synthetic */ void n(ObricAppStatusView r10, AppUIStatus r11, AppInfo r12) {
        r10.s(r11, r12);
    }

    public static final /* synthetic */ void o(ObricAppStatusView r10, AppStatusViewModel r11) {
        r10.f10933b = r11;
    }

    public static final void p(ObricAppStatusView r10, View r11) {
        q.g(r10, "this$0");
        View.OnClickListener r12 = r10.f10940i;
        if (r12 == null) goto L6;
        r12.onClick(r10);
        return;
    }

    public static /* synthetic */ void u(ObricAppStatusView r10, int r11, Integer r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.t(r11, r12);
    }

    public final boolean getUseForHomeCard() {
        return this.f10936e;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Job r10 = this.f10942k;
        if (r10 != null) goto L5;
    L7:
        this.f10942k = h.d(this.f10932a, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L5:
        if (r10.isActive() != true) goto L7;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isTemporarilyDetached() == true) goto L13;
        Job r10 = this.f10942k;
        if (r10 == null) goto L7;
        Job.a.b(r10, null, 1, null);
    L7:
        AppStatusViewModel r11 = this.f10933b;
        if (r11 == null) goto L14;
        CoroutineScope r12 = l0.a(r11);
        if (r12 == null) goto L15;
        d0.d(r12, null, 1, null);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.oui.OAppStatusView
    public void operateApp(Activity r10, View r11, AppInfo r12, String r13) {
        q.g(r10, "activity");
        q.g(r11, "v");
        q.g(r12, "appInfo");
        q.g(r13, "pageSource");
        this.f10934c = r10;
        AppInfo r14 = this.f10939h;
        if (r14 == null) goto L8;
        AppStatusViewModel r15 = this.f10933b;
        if (r15 == null) goto L9;
        r15.s(r10, AppInfoKtxKt.newDomainEntity$default(r14, null, 1, null), false, r13);
        return;
    L9:
        return;
    }

    public final String q(String r10, AppUIStatus r11, AppInfo r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append("pkg=");
        r13.append(r10);
        r13.append(" n=");
        Integer r14 = null;
        if (r12 == null) goto L5;
        String r15 = r12.appName;
    L6:
        r13.append(r15);
        r13.append(" dlId=");
        com.smt.obric.appstore.domain.app.entity.a r16 = r11.c();
        if (r16 == null) goto L9;
        Long r17 = r16.o();
    L10:
        r13.append(r17);
        r13.append(" loading=");
        r13.append(r11.d());
        r13.append(" status=");
        r13.append(r11.f());
        r13.append(" taskState=");
        com.smt.obric.appstore.domain.app.entity.a r18 = r11.c();
        if (r18 == null) goto L15;
        AppStatus r19 = r18.G();
        if (r19 == null) goto L15;
        String r20 = r19.getClass().getSimpleName();
    L16:
        r13.append(r20);
        r13.append(" dlProg=");
        com.smt.obric.appstore.domain.app.entity.a r21 = r11.c();
        if (r21 == null) goto L19;
        r14 = Integer.valueOf((int) r21.q());
    L19:
        r13.append(r14);
        return r13.toString();
    L15:
        r20 = null;
        goto L16
    L9:
        r17 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }

    public final AppStatusViewModel r() {
        return AppStatusViewModel.a.f18167a.a();
    }

    public final void s(AppUIStatus r12, AppInfo r13) {
        if (r13 == null) goto L5;
        String r10 = r13.appPackageName;
        if (r10 == null) goto L5;
    L8:
        com.smt.obric.appstore.domain.app.entity.a r11 = r12.c();
        int r14 = 0;
        if (r11 == null) goto L11;
        int r15 = (int) r11.q();
    L12:
        AppUIStatus.Status r16 = r12.f();
        if (r16 != null) goto L15;
        int r17 = -1;
    L16:
        boolean r18 = true;
        String r19 = null;
        switch(r17) {
            case -1: goto L30;
            case 0: goto L32;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L20;
            case 9: goto L19;
            default: goto L32;
        };
    L19:
        j.n("[AppStatus][OUIAppStatusView] renderState branch 7 " + q(r10, r12, r13));
        w(true);
        getDownloadView().setCurrentState(3);
        int r110 = R.string.download_retry;
        u(this, r110, null, 2, null);
        r19 = getContext().getString(r110);
        goto L32
    L20:
        j.n("[AppStatus][OUIAppStatusView] renderState branch 7 " + q(r10, r12, r13));
        w(false);
        int r111 = R.string.app_status_desc_continue;
        t(r111, Integer.valueOf(R.drawable.oic_download_continue));
        r19 = getContext().getString(r111);
        goto L32
    L21:
        j.n("[AppStatus][OUIAppStatusView] renderState branch 6 " + q(r10, r12, r13));
        w(true);
        getDownloadView().setCurrentState(0);
        r19 = getContext().getString(R.string.app_status_installing);
        goto L32
    L22:
        long r20 = System.currentTimeMillis();
        if ((r20 - this.f10941j) <= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L25;
        j.n("[AppStatus][OUIAppStatusView] renderState branch 5 " + q(r10, r12, r13));
        this.f10941j = r20;
    L25:
        w(true);
        getDownloadView().setCurrentState(2);
        getDownloadView().setProgress(r15);
        r19 = getContext().getString(R.string.pause_des_content, new Object[]{Integer.valueOf(r15)});
        goto L32
    L26:
        j.n("[AppStatus][OUIAppStatusView] renderState branch 4 " + q(r10, r12, r13));
        w(false);
        getDownloadView().setCurrentState(2);
        getDownloadView().setProgress(r15);
        int r112 = R.string.app_status_download_pending;
        u(this, r112, null, 2, null);
        r19 = getContext().getString(r112);
        goto L32
    L27:
        w(false);
        j.n("[AppStatus][OUIAppStatusView] renderState branch 3 " + q(r10, r12, r13));
        int r113 = R.string.open;
        u(this, r113, null, 2, null);
        r19 = getContext().getString(r113);
        goto L32
    L28:
        w(false);
        j.n("[AppStatus][OUIAppStatusView] renderState branch 2 " + q(r10, r12, r13));
        int r114 = R.string.update;
        u(this, r114, null, 2, null);
        r19 = getContext().getString(r114);
        goto L32
    L29:
        w(false);
        j.n("[AppStatus][OUIAppStatusView] renderState branch 1 " + q(r10, r12, r13));
        int r115 = R.string.install;
        u(this, r115, null, 2, null);
        r19 = getContext().getString(r115);
        goto L32
    L30:
        j.n("[AppStatus][OUIAppStatusView] renderState branch -1 " + q(r10, r12, r13));
    L32:
        if (r12.f() != null) goto L35;
        r18 = false;
    L35:
        j.n("[AppStatus][OUIAppStatusView] renderState setVisible " + r18 + ", status=" + r12.f());
        if (r18 == true) goto L39;
        r14 = 8;
    L39:
        setVisibility(r14);
        setContentDescription(r19);
        return;
    L15:
        r17 = a.f10943a[r16.ordinal()];
        goto L16
    L11:
        r15 = 0;
    L5:
        r10 = r12.e();
        if (r10 != null) goto L8;
        r10 = "";
        goto L8
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r10) {
        super.setOnClickListener(r10);
        this.f10940i = r10;
    }

    public final void setUseForHomeCard(boolean r10) {
        this.f10936e = r10;
    }

    public final void t(int r10, Integer r11) {
        int r12 = a.f10944b[this.f10938g.ordinal()];
        boolean r13 = true;
        if (r12 != 1) goto L5;
        this.f10935d.f24608b.setBackgroundColor(getContext().getColor(R.color.oui_fill_element_2));
        TextView r14 = this.f10935d.f24610d;
        Context r15 = getContext();
        int r16 = R.color.oui_accent_fg;
        r14.setTextColor(r15.getColor(r16));
    L13:
        ImageView r17 = this.f10935d.f24609c;
        q.f(r17, "appStatusButtonIc");
        int r18 = 0;
        if (r11 != null) goto L17;
        r13 = false;
    L17:
        if (r13 == true) goto L20;
        r18 = 8;
    L20:
        r17.setVisibility(r18);
        if (r11 == null) goto L26;
        Drawable r19 = c.a.b(getContext(), r11.intValue());
        if (r19 == null) goto L25;
        r19.setTint(ContextCompat.b(getContext(), r16));
    L25:
        this.f10935d.f24609c.setImageDrawable(r19);
    L26:
        this.f10935d.f24610d.setText(r10);
        return;
    L5:
        if (r12 != 2) goto L7;
        this.f10935d.f24608b.setBackgroundColor(getContext().getColor(R.color.oui_fill_element_2));
        TextView r20 = this.f10935d.f24610d;
        Context r21 = getContext();
        r16 = R.color.oui_on_dark_text_1;
        r20.setTextColor(r21.getColor(r16));
        goto L13
    L7:
        if (r12 != 3) goto L10;
        this.f10935d.f24608b.setBackgroundColor(getContext().getColor(R.color.oui_fill_element_2));
        TextView r22 = this.f10935d.f24610d;
        Context r23 = getContext();
        r16 = R.color.oui_accent_fg;
        r22.setTextColor(r23.getColor(r16));
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedanceos.common.ui.widget.oui.OAppStatusView
    public void updateDownloadStatus(AppInfo r10) {
        q.g(r10, "appInfo");
        this.f10939h = r10;
        if (r10.appPackageName == null) goto L10;
        AppStatusViewModel r11 = this.f10933b;
        if (r11 == null) goto L9;
        r11.q(AppInfoKtxKt.newDomainEntity$default(r10, null, 1, null));
        return;
    L9:
        return;
    }

    public final void v(AppStatusBtnStyle r10) {
        q.g(r10, "style");
        this.f10938g = r10;
    }

    public final void w(boolean r10) {
        l.p(getDownloadView(), r10);
        getDownloadView().setProgress(0);
        OUIConstraintLayout r11 = this.f10935d.f24608b;
        q.f(r11, "appStatusButton");
        l.p(r11, !r10);
    }

    @JvmOverloads
    public ObricAppStatusView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ObricAppStatusView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ObricAppStatusView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        this.f10932a = d0.a(kotlinx.coroutines.l0.c().e().plus(x1.b(null, 1, null)));
        n r13 = n.b(LayoutInflater.from(r10), this);
        r13.f24608b.setOnClickListener(new c(this));
        setMinimumWidth(yf.b.b(TypedValue.applyDimension(1, 52, Resources.getSystem().getDisplayMetrics())));
        q.f(r13, "apply(...)");
        this.f10935d = r13;
        this.f10937f = kotlin.b.b(new ObricAppStatusView$downloadView$2(this, r10));
        this.f10938g = AppStatusBtnStyle.DEFAULT;
    }
}
