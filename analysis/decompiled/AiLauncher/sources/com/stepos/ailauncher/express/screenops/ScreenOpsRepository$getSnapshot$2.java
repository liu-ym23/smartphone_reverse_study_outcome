package com.stepos.ailauncher.express.screenops;

import Ua.M;
import W3.EditTextNode;
import W3.b;
import W3.f;
import Y8.t;
import Z8.C1173v;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.express.screenops.ScreenOpsRepository;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/express/screenops/ScreenOpsRepository$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/express/screenops/ScreenOpsRepository$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.express.screenops.ScreenOpsRepository$getSnapshot$2", f = "ScreenOpsRepository.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScreenOpsRepository$getSnapshot$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super ScreenOpsRepository.Snapshot>, Object> {
    final /* synthetic */ String $packageName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsRepository$getSnapshot$2(String str, InterfaceC4014c<? super ScreenOpsRepository$getSnapshot$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$packageName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ScreenOpsRepository$getSnapshot$2(this.$packageName, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super ScreenOpsRepository.Snapshot> interfaceC4014c) {
        return ((ScreenOpsRepository$getSnapshot$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        b bVarA = f.f6652a.a(this.$packageName);
        if (!(bVarA instanceof b.Success)) {
            if (!(bVarA instanceof b.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            b.Failure failure = (b.Failure) bVarA;
            Log.w("ScreenOpsRepo", "getEditContent fail pkg=" + this.$packageName + " code=" + failure.getCode() + " msg=" + failure.getMessage());
            return new ScreenOpsRepository.Snapshot(C1173v.m(), "");
        }
        b.Success success = (b.Success) bVarA;
        Log.d("ScreenOpsRepo", "getEditContent ok pkg=" + this.$packageName + " nodes=" + success.b().size() + " extra=" + success.getExtra());
        int i10 = 0;
        for (Object obj2 : success.b()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            EditTextNode editTextNode = (EditTextNode) obj2;
            Log.d("ScreenOpsRepo", "  node[" + i10 + "] viewId=" + editTextNode.getViewId() + " focused=" + editTextNode.getIsFocused() + " editable=" + editTextNode.getIsEditable() + " pos=(" + editTextNode.getX() + Const.STR_MART_COMMA + editTextNode.getY() + ") size=" + editTextNode.getWidth() + "x" + editTextNode.getHeight() + " text='" + editTextNode.getText() + "' hint='" + editTextNode.getHint() + "'");
            i10 = i11;
        }
        return new ScreenOpsRepository.Snapshot(success.b(), success.getExtra());
    }
}
