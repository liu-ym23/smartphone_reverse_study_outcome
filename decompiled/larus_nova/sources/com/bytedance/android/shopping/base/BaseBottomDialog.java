package com.bytedance.android.shopping.base;

import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/base/BaseBottomDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseBottomDialog extends AppCompatDialog {

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBottomDialog f170683a;

        public b(BaseBottomDialog r100) {
            this.f170683a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Window r100 = this.f170683a.getWindow();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setWindowAnimations(R.style.Commerce_Dialog_Non_Enter_Animation);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public abstract View getRootView();

    @Override // android.app.Dialog
    public final void show() {
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L3:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L12
    L8:
        View r100 = getRootView();     // Catch: Exception -> L12
        if (r100 == null) goto L20;
        r100.postDelayed(new b(this), 300);     // Catch: Exception -> L12
        return;
    L20:
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L7:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L12
        super.show();     // Catch: Exception -> L12
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L12
        goto L8
    }
}
