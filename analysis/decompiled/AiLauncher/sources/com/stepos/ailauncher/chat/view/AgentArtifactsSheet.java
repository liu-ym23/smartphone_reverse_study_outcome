package com.stepos.ailauncher.chat.view;

import A7.C0746n;
import Ua.C1060i;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$id;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.adapter.C2507m;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.AgentArtifactsSheet;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\"¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/view/AgentArtifactsSheet;", "", "<init>", "()V", "Landroid/content/Context;", "context", "ownerKey", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifacts", "Lkotlin/Function2;", "", "LY8/t;", "onArtifactExpose", "Lkotlin/Function1;", "onArtifactClick", "Lcom/google/android/material/bottomsheet/a;", "m", "(Landroid/content/Context;Ljava/lang/Object;Ljava/util/List;Lp9/p;Lp9/l;)Lcom/google/android/material/bottomsheet/a;", VoiceWakeupReceiver.EXTRA_STATE, "", "r", "(I)Ljava/lang/String;", "Landroid/view/View;", ChatTracker.CONTENT_SHEET, C3081a.FOCUS_DIALOG_NAME, "panelLayerId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;Lcom/google/android/material/bottomsheet/a;Ljava/lang/String;)V", "LUa/M;", "sheetScope", "LUa/M;", "", "HALF_RATIO", "F", "EXPANDED_TOP_DP", "SHEET_BLUR_RADIUS_DP", "SHEET_TOP_RADIUS_DP", "SETTLE_MOVE_DELTA", "FLING_OFFSET_PER_SEC", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentArtifactsSheet {
    private static final float EXPANDED_TOP_DP = 40.0f;
    private static final float FLING_OFFSET_PER_SEC = 1.5f;
    private static final float HALF_RATIO = 0.43f;
    private static final float SETTLE_MOVE_DELTA = 0.15f;
    private static final float SHEET_BLUR_RADIUS_DP = 20.0f;
    private static final float SHEET_TOP_RADIUS_DP = 24.0f;
    public static final AgentArtifactsSheet INSTANCE = new AgentArtifactsSheet();
    private static final Ua.M sheetScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/AgentArtifactsSheet$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ Ref$ObjectRef<y7.E> $handle;

        public a(Ref$ObjectRef<y7.E> ref$ObjectRef) {
            this.$handle = ref$ObjectRef;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            Ref$ObjectRef<y7.E> ref$ObjectRef = this.$handle;
            y7.E e10 = ref$ObjectRef.f34820a;
            ref$ObjectRef.f34820a = null;
            if (e10 != null) {
                e10.g();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/AgentArtifactsSheet$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public b(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            int width = view.getWidth();
            int height = view.getHeight();
            float f10 = this.$radiusPx;
            outline.setRoundRect(0, 0, width, height + ((int) f10), f10);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/view/AgentArtifactsSheet$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$g;", "Landroid/view/View;", "bottomSheet", "", "newState", "LY8/t;", "c", "(Landroid/view/View;I)V", "", "slideOffset", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends BottomSheetBehavior.g {
        final /* synthetic */ Ref$BooleanRef $dragStartCaptured;
        final /* synthetic */ Ref$FloatRef $dragStartOffset;
        final /* synthetic */ Ref$FloatRef $lastSlideOffset;
        final /* synthetic */ Ref$LongRef $lastSlideTimeMs;
        final /* synthetic */ Ref$IntRef $lastStableState;
        final /* synthetic */ Ref$FloatRef $slideVelPerSec;
        final /* synthetic */ BottomSheetBehavior<View> $this_apply;
        final /* synthetic */ Ref$BooleanRef $userDragging;

        public c(Ref$IntRef ref$IntRef, Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, Ref$LongRef ref$LongRef, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, Ref$FloatRef ref$FloatRef3, BottomSheetBehavior<View> bottomSheetBehavior) {
            this.$lastStableState = ref$IntRef;
            this.$userDragging = ref$BooleanRef;
            this.$dragStartCaptured = ref$BooleanRef2;
            this.$lastSlideTimeMs = ref$LongRef;
            this.$slideVelPerSec = ref$FloatRef;
            this.$lastSlideOffset = ref$FloatRef2;
            this.$dragStartOffset = ref$FloatRef3;
            this.$this_apply = bottomSheetBehavior;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void e(kotlin.jvm.internal.Ref$BooleanRef r1, kotlin.jvm.internal.Ref$BooleanRef r2, kotlin.jvm.internal.Ref$FloatRef r3, kotlin.jvm.internal.Ref$FloatRef r4, kotlin.jvm.internal.Ref$FloatRef r5, kotlin.jvm.internal.Ref$IntRef r6, com.google.android.material.bottomsheet.BottomSheetBehavior r7) {
            /*
                boolean r0 = r1.f34815a
                if (r0 != 0) goto L5
                goto L4f
            L5:
                r0 = 0
                r1.f34815a = r0
                boolean r1 = r2.f34815a
                if (r1 == 0) goto L12
                float r1 = r3.f34817a
                float r2 = r4.f34817a
                float r1 = r1 - r2
                goto L13
            L12:
                r1 = 0
            L13:
                float r2 = r5.f34817a
                r3 = -1077936128(0xffffffffbfc00000, float:-1.5)
                int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                r4 = 1
                if (r3 < 0) goto L26
                r3 = -1105618534(0xffffffffbe19999a, float:-0.15)
                int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r3 >= 0) goto L24
                goto L26
            L24:
                r3 = r0
                goto L27
            L26:
                r3 = r4
            L27:
                r5 = 1069547520(0x3fc00000, float:1.5)
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 > 0) goto L34
                r2 = 1041865114(0x3e19999a, float:0.15)
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 <= 0) goto L35
            L34:
                r0 = r4
            L35:
                int r1 = r6.f34818a
                r2 = 6
                r4 = 3
                if (r1 != r4) goto L40
                if (r3 == 0) goto L3e
                goto L46
            L3e:
                r2 = r4
                goto L46
            L40:
                if (r0 == 0) goto L43
                goto L3e
            L43:
                if (r3 == 0) goto L46
                r2 = 5
            L46:
                int r1 = r7.S()
                if (r1 == r2) goto L4f
                r7.x0(r2)
            L4f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.AgentArtifactsSheet.c.e(kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$BooleanRef, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$IntRef, com.google.android.material.bottomsheet.BottomSheetBehavior):void");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View bottomSheet, float slideOffset) {
            kotlin.jvm.internal.p.i(bottomSheet, "bottomSheet");
            if (this.$userDragging.f34815a) {
                Ref$BooleanRef ref$BooleanRef = this.$dragStartCaptured;
                if (!ref$BooleanRef.f34815a) {
                    this.$dragStartOffset.f34817a = slideOffset;
                    ref$BooleanRef.f34815a = true;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = this.$lastSlideTimeMs.f34819a;
            if (j10 > 0) {
                this.$slideVelPerSec.f34817a = ((slideOffset - this.$lastSlideOffset.f34817a) * 1000.0f) / C5685n.g(jCurrentTimeMillis - j10, 1L);
            }
            this.$lastSlideTimeMs.f34819a = jCurrentTimeMillis;
            this.$lastSlideOffset.f34817a = slideOffset;
            C4148a.d("ArtifactsSheet", "onSlide offset=" + slideOffset + " vel=" + this.$slideVelPerSec.f34817a + " top=" + bottomSheet.getTop(), false, 4, null);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View bottomSheet, int newState) {
            kotlin.jvm.internal.p.i(bottomSheet, "bottomSheet");
            AgentArtifactsSheet agentArtifactsSheet = AgentArtifactsSheet.INSTANCE;
            C4148a.d("ArtifactsSheet", "onStateChanged -> " + agentArtifactsSheet.r(newState) + ", lastStable=" + agentArtifactsSheet.r(this.$lastStableState.f34818a), false, 4, null);
            if (newState == 1) {
                this.$userDragging.f34815a = true;
                this.$dragStartCaptured.f34815a = false;
                this.$lastSlideTimeMs.f34819a = 0L;
                this.$slideVelPerSec.f34817a = 0.0f;
                return;
            }
            if (newState != 2) {
                if (newState == 3 || newState == 6) {
                    this.$lastStableState.f34818a = newState;
                    return;
                }
                return;
            }
            final Ref$BooleanRef ref$BooleanRef = this.$userDragging;
            final Ref$BooleanRef ref$BooleanRef2 = this.$dragStartCaptured;
            final Ref$FloatRef ref$FloatRef = this.$lastSlideOffset;
            final Ref$FloatRef ref$FloatRef2 = this.$dragStartOffset;
            final Ref$FloatRef ref$FloatRef3 = this.$slideVelPerSec;
            final Ref$IntRef ref$IntRef = this.$lastStableState;
            final BottomSheetBehavior<View> bottomSheetBehavior = this.$this_apply;
            bottomSheet.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    AgentArtifactsSheet.c.e(ref$BooleanRef, ref$BooleanRef2, ref$FloatRef, ref$FloatRef2, ref$FloatRef3, ref$IntRef, bottomSheetBehavior);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, y7.E] */
    public static final void j(View view, Ref$ObjectRef ref$ObjectRef) {
        if (view.isAttachedToWindow()) {
            final float f10 = view.getResources().getDisplayMetrics().density * 20.0f;
            ?? U10 = y7.H.a(s7.p.f40121a, view).x(true).j(y7.G.f43879a.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.k
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentArtifactsSheet.k(f10, (C0746n) obj);
                }
            }).u();
            if (U10.c() == 0) {
                return;
            }
            ref$ObjectRef.f34820a = U10;
            view.addOnAttachStateChangeListener(new a(ref$ObjectRef));
        }
    }

    public static final Y8.t k(float f10, C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(f10);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(String str, Ref$ObjectRef ref$ObjectRef, DialogInterface dialogInterface) {
        com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
        y7.E e10 = (y7.E) ref$ObjectRef.f34820a;
        if (e10 != null) {
            e10.g();
        }
        ref$ObjectRef.f34820a = null;
    }

    public static final Y8.t n(com.google.android.material.bottomsheet.a aVar, InterfaceC5074l interfaceC5074l, SessionArtifact artifact) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        aVar.dismiss();
        interfaceC5074l.invoke(artifact);
        return Y8.t.f7040a;
    }

    public static final void o(com.google.android.material.bottomsheet.a aVar, Context context, DialogInterface dialogInterface) {
        View decorView;
        Window window = aVar.getWindow();
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = context.getSystemService("window");
            kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            window.setLayout(-1, displayMetrics.heightPixels);
            window.setGravity(48);
        }
        int[] iArr = {R$id.container, R$id.coordinator, R$id.design_bottom_sheet};
        for (int i10 = 0; i10 < 3; i10++) {
            View viewFindViewById = aVar.findViewById(iArr[i10]);
            if (viewFindViewById != null) {
                viewFindViewById.setFitsSystemWindows(false);
            }
        }
        Window window2 = aVar.getWindow();
        if (window2 == null || (decorView = window2.getDecorView()) == null) {
            return;
        }
        decorView.requestApplyInsets();
    }

    public static final boolean p(com.google.android.material.bottomsheet.a aVar) {
        return aVar.isShowing();
    }

    public static final Y8.t q(com.google.android.material.bottomsheet.a aVar) {
        if (aVar.isShowing()) {
            aVar.dismiss();
        }
        return Y8.t.f7040a;
    }

    public final void i(final View sheet, com.google.android.material.bottomsheet.a dialog, final String panelLayerId) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        sheet.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.i
            @Override // java.lang.Runnable
            public final void run() {
                AgentArtifactsSheet.j(sheet, ref$ObjectRef);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.view.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AgentArtifactsSheet.l(panelLayerId, ref$ObjectRef, dialogInterface);
            }
        });
    }

    public final com.google.android.material.bottomsheet.a m(final Context context, Object ownerKey, List<SessionArtifact> artifacts, p9.p<? super SessionArtifact, ? super Integer, Y8.t> onArtifactExpose, final InterfaceC5074l<? super SessionArtifact, Y8.t> onArtifactClick) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        kotlin.jvm.internal.p.i(onArtifactExpose, "onArtifactExpose");
        kotlin.jvm.internal.p.i(onArtifactClick, "onArtifactClick");
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context, R$style.ChatArtifactsSheetTheme);
        String strC = com.stepos.ailauncher.chat.panelui.i.INSTANCE.c("artifacts_sheet");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.sheet_agent_artifacts, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.stepos.ailauncher.chat.R$id.rv_artifacts);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentArtifactsSheet.n(aVar, onArtifactClick, (SessionArtifact) obj);
                }
            };
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = artifacts.iterator();
            while (it.hasNext()) {
                String fileId = ((SessionArtifact) it.next()).getFileId();
                if (fileId == null || La.H.x0(fileId)) {
                    fileId = null;
                }
                if (fileId != null) {
                    arrayList.add(fileId);
                }
            }
            List listG0 = Z8.F.g0(arrayList);
            if (listG0.isEmpty()) {
                recyclerView.setAdapter(new C2507m(artifacts, kotlin.collections.a.i(), interfaceC5074l, onArtifactExpose));
            } else {
                C1060i.d(sheetScope, null, null, new AgentArtifactsSheet$show$1$1(recyclerView, artifacts, interfaceC5074l, onArtifactExpose, listG0, null), 3, null);
            }
        }
        aVar.setContentView(viewInflate);
        Window window = aVar.getWindow();
        if (window != null) {
            window.addFlags(512);
        }
        viewInflate.setPadding(0, 0, 0, O6.b.INSTANCE.a(context));
        if (!(context instanceof Activity)) {
            com.stepos.ailauncher.container.dialog.f.h(aVar.getWindow(), context);
        }
        View viewFindViewById = aVar.findViewById(R$id.design_bottom_sheet);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(0);
            float f10 = context.getResources().getDisplayMetrics().density * 24.0f;
            viewFindViewById.setClipToOutline(true);
            viewFindViewById.setOutlineProvider(new b(f10));
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.height = -1;
            viewFindViewById.setLayoutParams(layoutParams);
            BottomSheetBehavior bottomSheetBehaviorO = BottomSheetBehavior.O(viewFindViewById);
            bottomSheetBehaviorO.m0(false);
            bottomSheetBehaviorO.o0(HALF_RATIO);
            bottomSheetBehaviorO.l0((int) (context.getResources().getDisplayMetrics().density * 40.0f));
            bottomSheetBehaviorO.p0(true);
            bottomSheetBehaviorO.w0(true);
            bottomSheetBehaviorO.x0(6);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.f34818a = 6;
            Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            ref$FloatRef.f34817a = 1.0f;
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            ref$FloatRef2.f34817a = 1.0f;
            bottomSheetBehaviorO.A(new c(ref$IntRef, new Ref$BooleanRef(), new Ref$BooleanRef(), new Ref$LongRef(), new Ref$FloatRef(), ref$FloatRef, ref$FloatRef2, bottomSheetBehaviorO));
            INSTANCE.i(viewFindViewById, aVar, strC);
        }
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.stepos.ailauncher.chat.view.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AgentArtifactsSheet.o(aVar, context, dialogInterface);
            }
        });
        if (com.stepos.ailauncher.container.dialog.f.q(aVar, "artifactsSheet")) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.e(strC, PanelHomePolicy.DISMISS_TOP_ONLY, ownerKey, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.g
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(AgentArtifactsSheet.p(aVar));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.h
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AgentArtifactsSheet.q(aVar);
                }
            }, new com.stepos.ailauncher.chat.panelui.c(aVar));
        }
        return aVar;
    }

    public final String r(int state) {
        switch (state) {
            case 1:
                return "DRAGGING";
            case 2:
                return "SETTLING";
            case 3:
                return "EXPANDED";
            case 4:
                return "COLLAPSED";
            case 5:
                return "HIDDEN";
            case 6:
                return "HALF";
            default:
                return "?" + state;
        }
    }
}
