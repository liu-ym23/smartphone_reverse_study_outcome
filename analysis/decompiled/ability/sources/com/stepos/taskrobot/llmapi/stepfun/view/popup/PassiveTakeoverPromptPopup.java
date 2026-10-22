package com.stepos.taskrobot.llmapi.stepfun.view.popup;

import A4.e;
import C7.r;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.android.material.textfield.g;
import com.stepos.taskrobot.llmapi.stepfun.R;
import com.stepos.taskrobot.llmapi.stepfun.view.blur.BlurCardView;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup;
import f6.AbstractC1436a;
import i9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 +2\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup;", "", "Landroidx/appcompat/app/AppCompatActivity;", "activity", AppAgent.CONSTRUCT, "(Landroidx/appcompat/app/AppCompatActivity;)V", "", "explain", "Landroid/view/View;", "createContentView", "(Ljava/lang/String;)Landroid/view/View;", "", "isShowing", "()Z", "anchor", "LC7/r;", "show", "(Landroid/view/View;Ljava/lang/String;)V", "dismiss", "()V", "text", "setExplain", "(Ljava/lang/String;)V", "restoreHandle", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup$Listener;", "listener", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup$Listener;", "getListener", "()Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup$Listener;", "setListener", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup$Listener;)V", "Landroid/widget/PopupWindow;", "popup", "Landroid/widget/PopupWindow;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/blur/BlurCardView;", "card", "Lcom/stepos/taskrobot/llmapi/stepfun/view/blur/BlurCardView;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger;", "dragger", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger;", "pendingShow", "Z", "Companion", "Listener", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PassiveTakeoverPromptPopup {
    private static final String TAG = "PassivePrompt";
    private final AppCompatActivity activity;
    private BlurCardView card;
    private HandleVerticalDragger dragger;
    private Listener listener;
    private boolean pendingShow;
    private PopupWindow popup;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup$Listener;", "", "LC7/r;", "onStopClicked", "()V", "onTakeoverClicked", "onHandlePulledUp", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Listener {
        void onHandlePulledUp();

        void onStopClicked();

        void onTakeoverClicked();
    }

    public PassiveTakeoverPromptPopup(AppCompatActivity activity) {
        k.f(activity, "activity");
        this.activity = activity;
    }

    private final View createContentView(String explain) throws Resources.NotFoundException {
        BlurCardView blurCardView = new BlurCardView(this.activity, null, 0, 6, null);
        blurCardView.setUp(R.layout.view_passive_takeover_prompt_v2, R.id.passive_card_body, this.activity.getResources().getDimensionPixelSize(R.dimen.passive_takeover_blur_radius), this.activity.getResources().getDimension(R.dimen.passive_takeover_card_corner_radius));
        blurCardView.setClickable(true);
        final int i = 0;
        blurCardView.getContentView().findViewById(R.id.row_takeover).setOnClickListener(new View.OnClickListener(this) { // from class: k6.c
            public final /* synthetic */ PassiveTakeoverPromptPopup b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                PassiveTakeoverPromptPopup passiveTakeoverPromptPopup = this.b;
                switch (i6) {
                    case 0:
                        PassiveTakeoverPromptPopup.createContentView$lambda$1(passiveTakeoverPromptPopup, view);
                        break;
                    default:
                        PassiveTakeoverPromptPopup.createContentView$lambda$2(passiveTakeoverPromptPopup, view);
                        break;
                }
            }
        });
        final int i6 = 1;
        blurCardView.getContentView().findViewById(R.id.row_stop).setOnClickListener(new View.OnClickListener(this) { // from class: k6.c
            public final /* synthetic */ PassiveTakeoverPromptPopup b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                PassiveTakeoverPromptPopup passiveTakeoverPromptPopup = this.b;
                switch (i62) {
                    case 0:
                        PassiveTakeoverPromptPopup.createContentView$lambda$1(passiveTakeoverPromptPopup, view);
                        break;
                    default:
                        PassiveTakeoverPromptPopup.createContentView$lambda$2(passiveTakeoverPromptPopup, view);
                        break;
                }
            }
        });
        ((TextView) blurCardView.getContentView().findViewById(R.id.text_explain)).setText(explain);
        View viewFindViewById = blurCardView.getContentView().findViewById(R.id.handle);
        float dimension = this.activity.getResources().getDimension(R.dimen.passive_takeover_v2_pull_trigger);
        float dimension2 = this.activity.getResources().getDimension(R.dimen.passive_takeover_v2_pull_max_rubber);
        l lVar = new l(this, 2);
        k.c(viewFindViewById);
        HandleVerticalDragger handleVerticalDragger = new HandleVerticalDragger(dimension, dimension2, -1000.0f, lVar, new AndroidEffects(viewFindViewById));
        HandleVerticalDraggerKt.bindTouchListener(handleVerticalDragger, viewFindViewById);
        this.card = blurCardView;
        this.dragger = handleVerticalDragger;
        return blurCardView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createContentView$lambda$1(PassiveTakeoverPromptPopup passiveTakeoverPromptPopup, View view) {
        AbstractC1436a.d(TAG, "row_takeover clicked → onTakeoverClicked", true);
        Listener listener = passiveTakeoverPromptPopup.listener;
        if (listener != null) {
            listener.onTakeoverClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createContentView$lambda$2(PassiveTakeoverPromptPopup passiveTakeoverPromptPopup, View view) {
        AbstractC1436a.d(TAG, "row_stop clicked → onStopClicked", true);
        Listener listener = passiveTakeoverPromptPopup.listener;
        if (listener != null) {
            listener.onStopClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createContentView$lambda$3(PassiveTakeoverPromptPopup passiveTakeoverPromptPopup) {
        Listener listener = passiveTakeoverPromptPopup.listener;
        if (listener != null) {
            listener.onHandlePulledUp();
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(PassiveTakeoverPromptPopup passiveTakeoverPromptPopup, String str, View view) {
        passiveTakeoverPromptPopup.pendingShow = false;
        if (passiveTakeoverPromptPopup.isShowing()) {
            passiveTakeoverPromptPopup.setExplain(str);
        } else if (view.getWindowToken() == null) {
            AbstractC1436a.e(TAG, "show(deferred): anchor still not attached, abort", true);
        } else {
            passiveTakeoverPromptPopup.show(view, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean show$lambda$2(PassiveTakeoverPromptPopup passiveTakeoverPromptPopup, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        AbstractC1436a.d(TAG, "setTouchInterceptor: ACTION_OUTSIDE → onTakeoverClicked", true);
        Listener listener = passiveTakeoverPromptPopup.listener;
        if (listener != null) {
            listener.onTakeoverClicked();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3(PassiveTakeoverPromptPopup passiveTakeoverPromptPopup) {
        passiveTakeoverPromptPopup.card = null;
        passiveTakeoverPromptPopup.dragger = null;
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.popup;
        boolean z10 = popupWindow != null && popupWindow.isShowing();
        AbstractC1436a.d(TAG, "dismiss: was showing=" + z10 + ", pendingShow=" + this.pendingShow, true);
        PopupWindow popupWindow2 = this.popup;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
        this.popup = null;
        this.card = null;
        this.dragger = null;
        this.pendingShow = false;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.popup;
        return popupWindow != null && popupWindow.isShowing();
    }

    public final void restoreHandle() {
        HandleVerticalDragger handleVerticalDragger;
        if (isShowing() && (handleVerticalDragger = this.dragger) != null) {
            handleVerticalDragger.restore();
        }
    }

    public final void setExplain(String text) {
        View contentView;
        TextView textView;
        k.f(text, "text");
        BlurCardView blurCardView = this.card;
        if (blurCardView == null || (contentView = blurCardView.getContentView()) == null || (textView = (TextView) contentView.findViewById(R.id.text_explain)) == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    public final void show(View anchor, String explain) {
        k.f(anchor, "anchor");
        k.f(explain, "explain");
        if (isShowing()) {
            setExplain(explain);
            return;
        }
        if (anchor.getWindowToken() == null) {
            if (this.pendingShow) {
                AbstractC1436a.d(TAG, "show: anchor not attached, already pending, skip re-post", true);
                return;
            }
            this.pendingShow = true;
            AbstractC1436a.d(TAG, "show: anchor windowToken=null, defer to anchor.post", true);
            anchor.post(new e(9, explain, this, anchor));
            return;
        }
        PopupWindow popupWindow = new PopupWindow(createContentView(explain), this.activity.getResources().getDimensionPixelSize(R.dimen.passive_takeover_card_width), -2, false);
        popupWindow.setClippingEnabled(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setAnimationStyle(0);
        popupWindow.setTouchInterceptor(new g(this, 3));
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: k6.b
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                PassiveTakeoverPromptPopup.show$lambda$3(this.f4822a);
            }
        });
        popupWindow.showAtLocation(anchor, 81, 0, this.activity.getResources().getDimensionPixelSize(R.dimen.fullscreen_overlay_margin_bottom));
        this.popup = popupWindow;
        AbstractC1436a.d(TAG, "show: popup shown, anchor=" + anchor + ", isShowing=" + popupWindow.isShowing() + ", focusable=" + popupWindow.isFocusable() + ", outsideTouchable=" + popupWindow.isOutsideTouchable(), true);
    }
}
