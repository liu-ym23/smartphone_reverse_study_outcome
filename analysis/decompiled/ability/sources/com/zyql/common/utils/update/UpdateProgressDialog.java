package com.zyql.common.utils.update;

import A6.b;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/zyql/common/utils/update/UpdateProgressDialog;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "isForceUpdate", AppAgent.CONSTRUCT, "(Landroid/content/Context;Z)V", "Landroid/os/Bundle;", "savedInstanceState", "LC7/r;", AppAgent.ON_CREATE, "(Landroid/os/Bundle;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", "progress", "setProgress", "(I)V", "onDownloadComplete", "()V", "Z", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "tvProgress", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/ProgressBar;", "Landroid/widget/Button;", "btnCancel", "Landroid/widget/Button;", "Lkotlin/Function0;", "onCancelListener", "LS7/a;", "getOnCancelListener", "()LS7/a;", "setOnCancelListener", "(LS7/a;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateProgressDialog extends Dialog {
    private Button btnCancel;
    private final boolean isForceUpdate;
    private S7.a onCancelListener;
    private ProgressBar progressBar;
    private TextView tvProgress;
    private TextView tvTitle;

    public /* synthetic */ UpdateProgressDialog(Context context, boolean z10, int i, e eVar) {
        this(context, (i & 2) != 0 ? false : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$6(UpdateProgressDialog updateProgressDialog, View view) {
        S7.a aVar = updateProgressDialog.onCancelListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final S7.a getOnCancelListener() {
        return this.onCancelListener;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(40, 40, 40, 40);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(getContext());
        textView.setText(this.isForceUpdate ? "正在更新" : "下载更新");
        textView.setTextSize(18.0f);
        textView.setPadding(0, 0, 0, 20);
        textView.setGravity(17);
        this.tvTitle = textView;
        linearLayout.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding(0, 10, 0, 10);
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(200, -2));
        progressBar.setIndeterminate(false);
        this.progressBar = progressBar;
        linearLayout2.addView(progressBar);
        TextView textView2 = new TextView(getContext());
        textView2.setText("0%");
        textView2.setTextSize(14.0f);
        textView2.setPadding(20, 0, 0, 0);
        this.tvProgress = textView2;
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        if (!this.isForceUpdate) {
            Button button = new Button(getContext());
            button.setText("取消");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = 20;
            button.setLayoutParams(layoutParams);
            button.setOnClickListener(new b(this, 9));
            this.btnCancel = button;
            linearLayout.addView(button);
        }
        setContentView(linearLayout);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(Integer.MIN_VALUE));
        }
        setCancelable(false);
    }

    public final void onDownloadComplete() {
        TextView textView = this.tvTitle;
        if (textView == null) {
            k.n("tvTitle");
            throw null;
        }
        textView.setText("下载完成");
        TextView textView2 = this.tvProgress;
        if (textView2 == null) {
            k.n("tvProgress");
            throw null;
        }
        textView2.setText("准备安装...");
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            k.n("progressBar");
            throw null;
        }
        progressBar.setVisibility(8);
        Button button = this.btnCancel;
        if (button != null) {
            if (button != null) {
                button.setVisibility(8);
            } else {
                k.n("btnCancel");
                throw null;
            }
        }
    }

    public final void setOnCancelListener(S7.a aVar) {
        this.onCancelListener = aVar;
    }

    public final void setProgress(int progress) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            k.n("progressBar");
            throw null;
        }
        progressBar.setProgress(progress);
        TextView textView = this.tvProgress;
        if (textView == null) {
            k.n("tvProgress");
            throw null;
        }
        textView.setText(progress + "%");
    }

    public final void setTitle(String title) {
        k.f(title, "title");
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(title);
        } else {
            k.n("tvTitle");
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateProgressDialog(Context context, boolean z10) {
        super(context);
        k.f(context, "context");
        this.isForceUpdate = z10;
    }
}
