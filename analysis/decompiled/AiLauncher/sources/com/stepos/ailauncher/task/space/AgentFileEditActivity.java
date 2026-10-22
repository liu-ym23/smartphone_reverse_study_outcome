package com.stepos.ailauncher.task.space;

import Ua.C1056g;
import Ua.C1060i;
import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import java.io.File;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import r6.C5221a;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J=\u0010%\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0014¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0004H\u0017¢\u0006\u0004\b2\u0010\u0003R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010\fR\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/stepos/ailauncher/task/space/AgentFileEditActivity;", "Lz5/a;", "<init>", "()V", "LY8/t;", "p0", "d0", "s0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Y", "(Le9/c;)Ljava/lang/Object;", "Z", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/String;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "t0", "(Ljava/lang/String;)Z", "b0", "u0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Ljava/io/File;", "U", "()Ljava/io/File;", "q0", "a0", ChatTracker.PREVIEW_LOADING, "c0", "(Z)V", ExifInterface.LONGITUDE_WEST, "title", "message", "positiveText", "negativeText", "Lkotlin/Function0;", "onPositive", "h0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "", "resId", "m0", "(I)V", "n0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "onBackPressed", "Lr6/a;", "binding", "Lr6/a;", "originalContent", "Ljava/lang/String;", "hasUnsavedChanges", "fileId", "Lkotlinx/coroutines/g;", "restoreJob", "Lkotlinx/coroutines/g;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity extends ActivityC6361a {
    private static final String CACHE_DIR_NAME = "agent_files";
    private static final String EXTRA_DESCRIPTION = "description";
    private static final String EXTRA_FILE_ID = "file_id";
    private static final String EXTRA_TITLE = "title";
    private static final int MAX_CONTENT_LENGTH = 20000;
    private static final int MIN_CONTENT_LENGTH = 20;
    private static final String TAG = "AILauncher-FileEdit";
    private static final long TOAST_DURATION_MS = 2000;
    private C5221a binding;
    private boolean hasUnsavedChanges;
    private kotlinx.coroutines.g restoreJob;
    private String originalContent = "";
    private String fileId = "";
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/task/space/AgentFileEditActivity$b", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            boolean z10 = !kotlin.jvm.internal.p.d(s10 != null ? s10.toString() : null, AgentFileEditActivity.this.originalContent);
            if (z10 != AgentFileEditActivity.this.hasUnsavedChanges) {
                AgentFileEditActivity.this.hasUnsavedChanges = z10;
                AgentFileEditActivity.this.s0();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public static final Y8.t X(AgentFileEditActivity agentFileEditActivity) {
        agentFileEditActivity.finish();
        return Y8.t.f7040a;
    }

    public static final void e0(AgentFileEditActivity agentFileEditActivity, View view) {
        agentFileEditActivity.W();
    }

    public static final void f0(AgentFileEditActivity agentFileEditActivity, View view) {
        agentFileEditActivity.b0();
    }

    public static final void g0(AgentFileEditActivity agentFileEditActivity, View view) {
        agentFileEditActivity.q0();
    }

    public static final void i0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void j0(View view) {
    }

    public static final void k0(Dialog dialog, InterfaceC5063a interfaceC5063a, View view) {
        dialog.dismiss();
        interfaceC5063a.invoke();
    }

    public static final void l0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void o0(WindowManager windowManager, View view) {
        try {
            windowManager.removeView(view);
        } catch (Exception unused) {
        }
    }

    public static final Y8.t r0(AgentFileEditActivity agentFileEditActivity) {
        agentFileEditActivity.a0();
        return Y8.t.f7040a;
    }

    public final String T() {
        String str = this.fileId;
        if (kotlin.jvm.internal.p.d(str, "soul")) {
            String string = getString(R$string.default_content_soul);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (!kotlin.jvm.internal.p.d(str, "user")) {
            return "";
        }
        String string2 = getString(R$string.default_content_user);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        return string2;
    }

    public final File U() {
        File file = new File(getCacheDir(), CACHE_DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, this.fileId + ".md");
    }

    public final void V() {
        if (!com.stepos.ailauncher.common.utils.I.INSTANCE.b(this)) {
            p0();
            return;
        }
        C5221a c5221a = this.binding;
        if (c5221a == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a = null;
        }
        c5221a.etContent.setEnabled(true);
        C5221a c5221a2 = this.binding;
        if (c5221a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a2 = null;
        }
        c5221a2.btnSave.setEnabled(false);
        C5221a c5221a3 = this.binding;
        if (c5221a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a3 = null;
        }
        c5221a3.btnSave.setAlpha(0.4f);
        C5221a c5221a4 = this.binding;
        if (c5221a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a4 = null;
        }
        c5221a4.btnRestore.setEnabled(true);
        C5221a c5221a5 = this.binding;
        if (c5221a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a5 = null;
        }
        c5221a5.btnRestore.setAlpha(1.0f);
        C1060i.d(C1398p.a(this), null, null, new AgentFileEditActivity$loadContent$1(this, null), 3, null);
    }

    public final void W() {
        if (!this.hasUnsavedChanges) {
            finish();
            return;
        }
        String string = getString(R$string.file_edit_discard_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.file_edit_discard_message);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.file_edit_discard_positive);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.file_edit_discard_negative);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        h0(string, string2, string3, string4, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentFileEditActivity.X(this.f28909a);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(e9.InterfaceC4014c<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.task.space.AgentFileEditActivity$readFromSdk$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.task.space.AgentFileEditActivity$readFromSdk$1 r0 = (com.stepos.ailauncher.task.space.AgentFileEditActivity$readFromSdk$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.space.AgentFileEditActivity$readFromSdk$1 r0 = new com.stepos.ailauncher.task.space.AgentFileEditActivity$readFromSdk$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.C4849c.b(r11)     // Catch: java.lang.Exception -> L29
            goto L55
        L29:
            r0 = move-exception
            r11 = r0
            r6 = r11
            goto L58
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.C4849c.b(r11)
            com.stepos.ailauncher.chat.manager.ClawVMManager$a r11 = com.stepos.ailauncher.chat.manager.ClawVMManager.INSTANCE     // Catch: java.lang.Exception -> L29
            com.stepos.ailauncher.chat.manager.ClawVMManager r11 = r11.a()     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r10.fileId     // Catch: java.lang.Exception -> L29
            java.util.Locale r4 = java.util.Locale.ROOT     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r2.toUpperCase(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r2, r4)     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r11 = r11.C(r10, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r11 != r1) goto L55
            return r1
        L55:
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Exception -> L29
            return r11
        L58:
            kotlin.jvm.internal.y r11 = kotlin.jvm.internal.y.f34840a
            java.lang.String r10 = r10.fileId
            java.lang.Object[] r10 = new java.lang.Object[]{r10}
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r11 = "Failed to read from SDK for %s"
            java.lang.String r5 = java.lang.String.format(r11, r10)
            java.lang.String r10 = "format(...)"
            kotlin.jvm.internal.p.h(r5, r10)
            r8 = 8
            r9 = 0
            java.lang.String r4 = "AILauncher-FileEdit"
            r7 = 0
            h8.C4148a.t(r4, r5, r6, r7, r8, r9)
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.AgentFileEditActivity.Y(e9.c):java.lang.Object");
    }

    public final Object Z(InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new AgentFileEditActivity$readLocalFile$2(this, null), interfaceC4014c);
    }

    public final void a0() {
        String str;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str2 = String.format("Restore default for %s", Arrays.copyOf(new Object[]{this.fileId}, 1));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        String str3 = this.fileId;
        if (kotlin.jvm.internal.p.d(str3, "user")) {
            str = "USER.md";
        } else {
            if (!kotlin.jvm.internal.p.d(str3, "soul")) {
                String str4 = String.format("Unknown fileId: %s, abort restore", Arrays.copyOf(new Object[]{this.fileId}, 1));
                kotlin.jvm.internal.p.h(str4, "format(...)");
                C4148a.u(TAG, str4, false, 4, null);
                return;
            }
            str = "SOUL.md";
        }
        n0("恢复默认中");
        c0(true);
        this.restoreJob = C1060i.d(C1398p.a(this), null, null, new AgentFileEditActivity$restoreDefault$1(str, this, null), 3, null);
    }

    public final void b0() {
        C5221a c5221a = this.binding;
        if (c5221a == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a = null;
        }
        C1060i.d(C1398p.a(this), null, null, new AgentFileEditActivity$saveContent$1(c5221a.etContent.getText().toString(), this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c0(boolean loading) {
        C5221a c5221a = null;
        if (!loading) {
            C5221a c5221a2 = this.binding;
            if (c5221a2 == null) {
                kotlin.jvm.internal.p.A("binding");
                c5221a2 = null;
            }
            Drawable drawable = c5221a2.btnRestore.getDrawable();
            Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
            if (animatable != null) {
                animatable.stop();
            }
            C5221a c5221a3 = this.binding;
            if (c5221a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c5221a3 = null;
            }
            c5221a3.btnRestore.setImageResource(R$drawable.ic_agent_file_restore);
            C5221a c5221a4 = this.binding;
            if (c5221a4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c5221a4 = null;
            }
            c5221a4.btnRestore.setEnabled(true);
            C5221a c5221a5 = this.binding;
            if (c5221a5 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c5221a = c5221a5;
            }
            c5221a.btnRestore.setAlpha(1.0f);
            return;
        }
        C5221a c5221a6 = this.binding;
        if (c5221a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a6 = null;
        }
        c5221a6.btnRestore.setEnabled(false);
        C5221a c5221a7 = this.binding;
        if (c5221a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a7 = null;
        }
        c5221a7.btnRestore.setAlpha(0.4f);
        C5221a c5221a8 = this.binding;
        if (c5221a8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a8 = null;
        }
        c5221a8.btnRestore.setImageResource(R$drawable.ic_repair_loading_spinner);
        C5221a c5221a9 = this.binding;
        if (c5221a9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a9 = null;
        }
        Drawable drawable2 = c5221a9.btnRestore.getDrawable();
        Animatable animatable2 = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    public final void d0() {
        C5221a c5221a = this.binding;
        C5221a c5221a2 = null;
        if (c5221a == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a = null;
        }
        c5221a.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentFileEditActivity.e0(this.f28920a, view);
            }
        });
        C5221a c5221a3 = this.binding;
        if (c5221a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a3 = null;
        }
        c5221a3.btnSave.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentFileEditActivity.f0(this.f28932a, view);
            }
        });
        C5221a c5221a4 = this.binding;
        if (c5221a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a4 = null;
        }
        c5221a4.btnRestore.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentFileEditActivity.g0(this.f29013a, view);
            }
        });
        C5221a c5221a5 = this.binding;
        if (c5221a5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c5221a2 = c5221a5;
        }
        c5221a2.etContent.addTextChangedListener(new b());
    }

    public final void h0(String title, String message, String positiveText, String negativeText, final InterfaceC5063a<Y8.t> onPositive) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R$layout.dialog_confirm);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
        }
        View viewFindViewById = dialog.findViewById(R$id.fl_overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentFileEditActivity.i0(dialog, view);
                }
            });
        }
        View viewFindViewById2 = dialog.findViewById(R$id.ll_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentFileEditActivity.j0(view);
                }
            });
        }
        ((TextView) dialog.findViewById(R$id.tv_dialog_title)).setText(title);
        ((TextView) dialog.findViewById(R$id.tv_dialog_message)).setText(message);
        TextView textView = (TextView) dialog.findViewById(R$id.btn_positive);
        textView.setText(positiveText);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentFileEditActivity.k0(dialog, onPositive, view);
            }
        });
        TextView textView2 = (TextView) dialog.findViewById(R$id.btn_negative);
        textView2.setText(negativeText);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentFileEditActivity.l0(dialog, view);
            }
        });
        dialog.show();
    }

    public final void m0(int resId) {
        String string = getString(resId);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        n0(string);
    }

    public final void n0(String message) {
        Object objB;
        Object systemService = getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        final WindowManager windowManager = (WindowManager) systemService;
        final View viewInflate = LayoutInflater.from(this).inflate(R$layout.layout_repair_toast, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R$id.tv_toast_message)).setText(message);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2038, 24, -3);
        layoutParams.gravity = 81;
        layoutParams.y = (int) (80 * getResources().getDisplayMetrics().density);
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager.addView(viewInflate, layoutParams);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "showCustomToast addView failed", thE, false, 8, null);
        }
        if (Result.h(objB)) {
            this.handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.task.space.j
                @Override // java.lang.Runnable
                public final void run() {
                    AgentFileEditActivity.o0(windowManager, viewInflate);
                }
            }, 2000L);
        }
    }

    @Override // b.q, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        W();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C5221a c5221aC = C5221a.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c5221aC, "inflate(...)");
        this.binding = c5221aC;
        C5221a c5221a = null;
        if (c5221aC == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221aC = null;
        }
        setContentView(c5221aC.b());
        String stringExtra = getIntent().getStringExtra(EXTRA_FILE_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.fileId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("title");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String stringExtra3 = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        String str = stringExtra3 != null ? stringExtra3 : "";
        C5221a c5221a2 = this.binding;
        if (c5221a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a2 = null;
        }
        c5221a2.tvTitle.setText(stringExtra2);
        C5221a c5221a3 = this.binding;
        if (c5221a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c5221a = c5221a3;
        }
        c5221a.tvDescription.setText(str);
        d0();
        V();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        kotlinx.coroutines.g gVar = this.restoreJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.restoreJob = null;
        super.onDestroy();
    }

    public final void p0() {
        C5221a c5221a = this.binding;
        C5221a c5221a2 = null;
        if (c5221a == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a = null;
        }
        c5221a.etContent.setText(getString(R$string.file_edit_no_network));
        C5221a c5221a3 = this.binding;
        if (c5221a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a3 = null;
        }
        c5221a3.etContent.setEnabled(false);
        C5221a c5221a4 = this.binding;
        if (c5221a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a4 = null;
        }
        c5221a4.btnSave.setEnabled(false);
        C5221a c5221a5 = this.binding;
        if (c5221a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a5 = null;
        }
        c5221a5.btnSave.setAlpha(0.4f);
        C5221a c5221a6 = this.binding;
        if (c5221a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a6 = null;
        }
        c5221a6.btnRestore.setEnabled(false);
        C5221a c5221a7 = this.binding;
        if (c5221a7 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c5221a2 = c5221a7;
        }
        c5221a2.btnRestore.setAlpha(0.4f);
        this.hasUnsavedChanges = false;
    }

    public final void q0() {
        String string = getString(R$string.file_edit_restore_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.file_edit_restore_message);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.file_edit_restore_positive);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.file_edit_restore_negative);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        h0(string, string2, string3, string4, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentFileEditActivity.r0(this.f29019a);
            }
        });
    }

    public final void s0() {
        C5221a c5221a = this.binding;
        C5221a c5221a2 = null;
        if (c5221a == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a = null;
        }
        c5221a.btnSave.setText(getString(R$string.file_edit_save));
        if (this.hasUnsavedChanges) {
            C5221a c5221a3 = this.binding;
            if (c5221a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c5221a3 = null;
            }
            c5221a3.btnSave.setEnabled(true);
            C5221a c5221a4 = this.binding;
            if (c5221a4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c5221a2 = c5221a4;
            }
            c5221a2.btnSave.setAlpha(1.0f);
            return;
        }
        C5221a c5221a5 = this.binding;
        if (c5221a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c5221a5 = null;
        }
        c5221a5.btnSave.setEnabled(false);
        C5221a c5221a6 = this.binding;
        if (c5221a6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c5221a2 = c5221a6;
        }
        c5221a2.btnSave.setAlpha(0.4f);
    }

    public final boolean t0(String content) {
        if (La.H.D1(content).toString().length() >= 20 && content.length() <= 20000) {
            return true;
        }
        m0(R$string.file_edit_save_validation_failed);
        return false;
    }

    public final Object u0(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ = C1056g.j(Ua.Y.b(), new AgentFileEditActivity$writeLocalFile$2(this, str, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
    }
}
