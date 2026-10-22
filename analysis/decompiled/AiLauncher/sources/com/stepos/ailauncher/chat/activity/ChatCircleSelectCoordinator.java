package com.stepos.ailauncher.chat.activity;

import Ua.C1060i;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.fragment.ChatInputFragment;
import com.stepos.ailauncher.chat.view.FloatInputView;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.circle.CircleSelectController;
import com.stepos.ailauncher.screenshot.ScreenshotClient;
import h8.C4148a;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u001f\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0011\u00101\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b0\u0010\b¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatCircleSelectCoordinator;", "", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", "<init>", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "", "v", "()Z", "LY8/t;", "l", "()V", "n", "hidden", "u", "(Z)V", "r", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/net/Uri;", "uri", "", "screenshotRound", "q", "(Landroid/net/Uri;J)V", "p", "s", "Landroidx/constraintlayout/widget/ConstraintLayout;", "m", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "t", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "LUa/M;", "scope", "LUa/M;", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "screenshotClient", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "Lkotlinx/coroutines/g;", "captureJob", "Lkotlinx/coroutines/g;", "Lcom/stepos/ailauncher/chat/activity/I0;", "authorizationGate", "Lcom/stepos/ailauncher/chat/activity/I0;", "Lcom/stepos/ailauncher/chat/wake/circle/CircleSelectController;", "controller", "Lcom/stepos/ailauncher/chat/wake/circle/CircleSelectController;", "overlay", "Landroidx/constraintlayout/widget/ConstraintLayout;", "o", "isActive", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatCircleSelectCoordinator {
    private static final String TAG = "ChatCircleSelect";
    private final ChatActivity activity;
    private I0 authorizationGate;
    private kotlinx.coroutines.g captureJob;
    private CircleSelectController controller;
    private ConstraintLayout overlay;
    private final Ua.M scope;
    private ScreenshotClient screenshotClient;

    public ChatCircleSelectCoordinator(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        this.activity = activity;
        this.scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
    }

    public static final Y8.t i(ChatCircleSelectCoordinator chatCircleSelectCoordinator) throws Resources.NotFoundException {
        chatCircleSelectCoordinator.activity.v8();
        return Y8.t.f7040a;
    }

    public static final Y8.t j(ChatCircleSelectCoordinator chatCircleSelectCoordinator) throws Resources.NotFoundException {
        chatCircleSelectCoordinator.activity.g1();
        return Y8.t.f7040a;
    }

    public static final Y8.t k(FloatInputView floatInputView, ChatCircleSelectCoordinator chatCircleSelectCoordinator) throws Resources.NotFoundException {
        if (!floatInputView.Tc()) {
            chatCircleSelectCoordinator.activity.g1();
        }
        return Y8.t.f7040a;
    }

    public final boolean h() {
        if (CircleSelectController.INSTANCE.e() || !this.activity.j6()) {
            C4148a.d(TAG, "skip activation: session cancelled or wake surface changed", false, 4, null);
            return false;
        }
        ChatInputFragment residentInput = this.activity.getResidentInput();
        final FloatInputView inputView = residentInput != null ? residentInput.getInputView() : null;
        if (inputView == null) {
            C4148a.u(TAG, "activateController: inputView not ready, skip", false, 4, null);
            return false;
        }
        CircleSelectController circleSelectController = this.controller;
        if (circleSelectController != null) {
            circleSelectController.N0();
        }
        this.controller = null;
        ConstraintLayout constraintLayoutM = m();
        ChatActivity chatActivity = this.activity;
        View viewT6 = chatActivity.t6();
        ChatInputFragment residentInput2 = this.activity.getResidentInput();
        CircleSelectController circleSelectController2 = new CircleSelectController(chatActivity, constraintLayoutM, viewT6, inputView, residentInput2 != null ? residentInput2.getCircleSelectChipHost() : null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.o0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatCircleSelectCoordinator.i(this.f24859a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.p0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatCircleSelectCoordinator.j(this.f24863a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatCircleSelectCoordinator.k(inputView, this);
            }
        });
        this.controller = circleSelectController2;
        circleSelectController2.Y();
        this.activity.da();
        return o();
    }

    public final void l() {
        FloatInputView inputView;
        kotlinx.coroutines.g gVar = this.captureJob;
        if (gVar == null || !gVar.b()) {
            CircleSelectController.INSTANCE.h();
            ChatInputFragment residentInput = this.activity.getResidentInput();
            if (residentInput != null && (inputView = residentInput.getInputView()) != null) {
                inputView.rc();
            }
            s();
            I0 i02 = new I0();
            this.authorizationGate = i02;
            Context applicationContext = this.activity.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            ScreenshotClient screenshotClient = new ScreenshotClient(applicationContext);
            this.screenshotClient = screenshotClient;
            this.captureJob = C1060i.d(this.scope, null, null, new ChatCircleSelectCoordinator$beginCapture$1(screenshotClient, i02, this, WakeService.INSTANCE.C0().g(), null), 3, null);
        }
    }

    public final ConstraintLayout m() {
        t();
        ConstraintLayout constraintLayout = new ConstraintLayout(this.activity);
        int iIntValue = -1;
        constraintLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        constraintLayout.setClickable(false);
        constraintLayout.setFocusable(false);
        ViewGroup viewGroupS6 = this.activity.s6();
        ViewParent parent = this.activity.t6().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            Integer numValueOf = viewGroupS6 != null ? Integer.valueOf(viewGroupS6.indexOfChild(viewGroup)) : null;
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            }
        }
        if (iIntValue >= 0) {
            if (viewGroupS6 != null) {
                viewGroupS6.addView(constraintLayout, iIntValue);
            }
        } else if (viewGroupS6 != null) {
            viewGroupS6.addView(constraintLayout);
        }
        this.overlay = constraintLayout;
        return constraintLayout;
    }

    public final boolean n() {
        CircleSelectController circleSelectController = this.controller;
        return circleSelectController != null && circleSelectController.D0();
    }

    public final boolean o() {
        CircleSelectController circleSelectController = this.controller;
        return circleSelectController != null && circleSelectController.H0();
    }

    public final void p() {
        FloatInputView inputView;
        I0 i02 = this.authorizationGate;
        if (i02 != null) {
            i02.a();
        }
        C4148a.d(TAG, "capture failed, tearing down circle select (silent degradation)", false, 4, null);
        ChatInputFragment residentInput = this.activity.getResidentInput();
        if (residentInput != null && (inputView = residentInput.getInputView()) != null) {
            inputView.L8();
        }
        CircleSelectController circleSelectController = this.controller;
        if (circleSelectController != null) {
            circleSelectController.N0();
        }
        this.controller = null;
        t();
        this.activity.da();
    }

    public final void q(Uri uri, long screenshotRound) {
        ChatInputFragment residentInput = this.activity.getResidentInput();
        FloatInputView inputView = residentInput != null ? residentInput.getInputView() : null;
        if (inputView == null) {
            C4148a.u(TAG, "onCaptureSuccess: inputView not ready, skip silent screenshot", false, 4, null);
        } else {
            inputView.g9(uri, screenshotRound);
        }
    }

    public final void r() {
        CircleSelectController circleSelectController = this.controller;
        if (circleSelectController != null) {
            circleSelectController.N0();
        }
        this.controller = null;
        s();
        t();
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
        this.activity.da();
    }

    public final void s() {
        I0 i02 = this.authorizationGate;
        if (i02 != null) {
            i02.a();
        }
        this.authorizationGate = null;
        kotlinx.coroutines.g gVar = this.captureJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.captureJob = null;
        ScreenshotClient screenshotClient = this.screenshotClient;
        if (screenshotClient != null) {
            screenshotClient.i();
        }
        this.screenshotClient = null;
    }

    public final void t() {
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout != null) {
            ViewParent parent = constraintLayout.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(constraintLayout);
            }
        }
        this.overlay = null;
    }

    public final void u(boolean hidden) {
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(hidden ? 4 : 0);
        }
    }

    public final boolean v() {
        CircleSelectController circleSelectController = this.controller;
        return circleSelectController != null && circleSelectController.V0();
    }
}
