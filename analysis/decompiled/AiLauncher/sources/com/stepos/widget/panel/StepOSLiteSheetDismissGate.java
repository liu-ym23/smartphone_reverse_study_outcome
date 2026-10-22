package com.stepos.widget.panel;

import Y8.t;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate;", "", "<init>", "()V", "Lkotlin/Function1;", "", "LY8/t;", "onResolved", "Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;", "request", "(Lp9/l;)Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;", "invalidate", AuthSessionDto.STATUS_PENDING, "Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;", "isPending", "()Z", "Decision", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetDismissGate {
    private Decision pending;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetDismissGate$Decision;", "", "Lkotlin/Function1;", "", "LY8/t;", "action", "<init>", "(Lp9/l;)V", "confirmed", "resolve", "(Z)V", "invalidate", "()V", "Lp9/l;", "isPending", "()Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Decision {
        private InterfaceC5074l<? super Boolean, t> action;

        public Decision(InterfaceC5074l<? super Boolean, t> interfaceC5074l) {
            this.action = interfaceC5074l;
        }

        public final void invalidate() {
            this.action = null;
        }

        public final boolean isPending() {
            return this.action != null;
        }

        public final void resolve(boolean confirmed) {
            InterfaceC5074l<? super Boolean, t> interfaceC5074l = this.action;
            if (interfaceC5074l == null) {
                return;
            }
            this.action = null;
            interfaceC5074l.invoke(Boolean.valueOf(confirmed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t request$lambda$0(StepOSLiteSheetDismissGate stepOSLiteSheetDismissGate, InterfaceC5074l interfaceC5074l, boolean z10) {
        stepOSLiteSheetDismissGate.pending = null;
        interfaceC5074l.invoke(Boolean.valueOf(z10));
        return t.f7040a;
    }

    public final void invalidate() {
        Decision decision = this.pending;
        if (decision != null) {
            decision.invalidate();
        }
        this.pending = null;
    }

    public final boolean isPending() {
        return this.pending != null;
    }

    public final Decision request(final InterfaceC5074l<? super Boolean, t> onResolved) {
        kotlin.jvm.internal.p.i(onResolved, "onResolved");
        if (isPending()) {
            return null;
        }
        Decision decision = new Decision(new InterfaceC5074l() { // from class: com.stepos.widget.panel.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSLiteSheetDismissGate.request$lambda$0(this.f31296a, onResolved, ((Boolean) obj).booleanValue());
            }
        });
        this.pending = decision;
        return decision;
    }
}
