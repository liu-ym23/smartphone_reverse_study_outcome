package com.stepos.taskrobot.llmapi.stepfun.view;

import C7.r;
import N9.j;
import S7.k;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowType;
import com.stepos.statsrpk.service.c;
import com.stepos.taskrobot.llmapi.stepfun.R;
import com.stepos.taskrobot.llmapi.stepfun.view.InfoDebugWindow;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/InfoDebugWindow;", "", "Landroid/view/WindowManager;", "wm", "Landroid/view/View;", "rootView", AppAgent.CONSTRUCT, "(Landroid/view/WindowManager;Landroid/view/View;)V", "LC7/r;", "dismiss", "()V", "Landroid/view/WindowManager;", "Landroid/view/View;", "", "dismissed", "Z", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InfoDebugWindow {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "InfoDebugWindow";
    private volatile boolean dismissed;
    private final View rootView;
    private final WindowManager wm;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/InfoDebugWindow$Companion;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Landroid/view/WindowManager$LayoutParams;", "makeLayoutParams", "(Landroid/content/Context;)Landroid/view/WindowManager$LayoutParams;", "", "message", "Lkotlin/Function1;", "LC7/r;", "onSubmit", "Lkotlin/Function0;", "onCancel", "Lcom/stepos/taskrobot/llmapi/stepfun/view/InfoDebugWindow;", "show", "(Landroid/content/Context;Ljava/lang/String;LS7/k;LS7/a;)Lcom/stepos/taskrobot/llmapi/stepfun/view/InfoDebugWindow;", "TAG", "Ljava/lang/String;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final WindowManager.LayoutParams makeLayoutParams(Context context) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams((int) (320 * context.getResources().getDisplayMetrics().density), -2, WindowType.APPLICATION_OVERLAY, 2, -3);
            layoutParams.gravity = 17;
            layoutParams.dimAmount = 0.4f;
            layoutParams.softInputMode = 20;
            return layoutParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void show$lambda$0(EditText editText, InfoDebugWindow infoDebugWindow, k kVar, View view) {
            String string = editText.getText().toString();
            infoDebugWindow.dismiss();
            kVar.invoke(string);
        }

        public final InfoDebugWindow show(Context context, String message, final k onSubmit, S7.a onCancel) {
            kotlin.jvm.internal.k.f(context, "context");
            kotlin.jvm.internal.k.f(message, "message");
            kotlin.jvm.internal.k.f(onSubmit, "onSubmit");
            kotlin.jvm.internal.k.f(onCancel, "onCancel");
            Object systemService = context.getSystemService("window");
            kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.info_debug_window, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.info_debug_message);
            final EditText editText = (EditText) viewInflate.findViewById(R.id.info_debug_input);
            Button button = (Button) viewInflate.findViewById(R.id.info_debug_submit);
            Button button2 = (Button) viewInflate.findViewById(R.id.info_debug_cancel);
            textView.setText(message);
            final InfoDebugWindow infoDebugWindow = new InfoDebugWindow(windowManager, viewInflate, null);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.taskrobot.llmapi.stepfun.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InfoDebugWindow.Companion.show$lambda$0(editText, infoDebugWindow, onSubmit, view);
                }
            });
            button2.setOnClickListener(new A6.b(onCancel, 8));
            windowManager.addView(viewInflate, makeLayoutParams(context));
            editText.requestFocus();
            j.H("InfoDebugWindow shown, message=\"" + message + "\"", InfoDebugWindow.TAG);
            return infoDebugWindow;
        }

        private Companion() {
        }
    }

    public /* synthetic */ InfoDebugWindow(WindowManager windowManager, View view, e eVar) {
        this(windowManager, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$0(InfoDebugWindow infoDebugWindow) {
        Object objA;
        try {
            infoDebugWindow.wm.removeViewImmediate(infoDebugWindow.rootView);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            c.n("dismiss failed: ", thA.getMessage(), TAG);
        }
    }

    public final void dismiss() {
        if (this.dismissed) {
            return;
        }
        this.dismissed = true;
        new Handler(Looper.getMainLooper()).post(new D6.b(this, 27));
    }

    private InfoDebugWindow(WindowManager windowManager, View view) {
        this.wm = windowManager;
        this.rootView = view;
    }
}
