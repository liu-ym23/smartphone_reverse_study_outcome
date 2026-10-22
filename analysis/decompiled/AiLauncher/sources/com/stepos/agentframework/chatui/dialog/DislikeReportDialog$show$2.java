package com.stepos.agentframework.chatui.dialog;

import Ua.C1056g;
import Ua.Y;
import android.widget.Button;
import android.widget.EditText;
import com.stepos.agentframework.chatui.dialog.DislikeReportDialog;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.dialog.DislikeReportDialog$show$2", f = "DislikeReportDialog.kt", l = {146}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class DislikeReportDialog$show$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ EditText $feedbackInput;
    final /* synthetic */ DislikeReportDialog.c $reasonAdapter;
    final /* synthetic */ Button $submitButton;
    int label;
    final /* synthetic */ DislikeReportDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DislikeReportDialog$show$2(DislikeReportDialog dislikeReportDialog, DislikeReportDialog.c cVar, Button button, EditText editText, InterfaceC4014c<? super DislikeReportDialog$show$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = dislikeReportDialog;
        this.$reasonAdapter = cVar;
        this.$submitButton = button;
        this.$feedbackInput = editText;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DislikeReportDialog$show$2(this.this$0, this.$reasonAdapter, this.$submitButton, this.$feedbackInput, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((DislikeReportDialog$show$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Y.b();
            DislikeReportDialog$show$2$remote$1 dislikeReportDialog$show$2$remote$1 = new DislikeReportDialog$show$2$remote$1(null);
            this.label = 1;
            obj = C1056g.j(iB, dislikeReportDialog$show$2$remote$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        List<String> list = (List) obj;
        if (!list.isEmpty() && !this.this$0.H()) {
            this.this$0.selectedReasons.clear();
            this.$reasonAdapter.submitList(list);
            DislikeReportDialog dislikeReportDialog = this.this$0;
            Button button = this.$submitButton;
            kotlin.jvm.internal.p.f(button);
            EditText editText = this.$feedbackInput;
            kotlin.jvm.internal.p.f(editText);
            dislikeReportDialog.o0(button, editText);
        }
        return Y8.t.f7040a;
    }
}
