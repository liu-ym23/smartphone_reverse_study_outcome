package com.stepos.ailauncher.chat;

import Ua.M;
import Ua.U;
import android.app.ActivityOptions;
import android.content.Intent;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.PickFileMediatorInDialog$pickFile$1", f = "PickFileMediatorActivity.kt", l = {889}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PickFileMediatorInDialog$pickFile$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $maxImageCount;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ PickFileMediatorInDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickFileMediatorInDialog$pickFile$1(PickFileMediatorInDialog pickFileMediatorInDialog, String str, int i10, InterfaceC4014c<? super PickFileMediatorInDialog$pickFile$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = pickFileMediatorInDialog;
        this.$type = str;
        this.$maxImageCount = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PickFileMediatorInDialog$pickFile$1(this.this$0, this.$type, this.$maxImageCount, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PickFileMediatorInDialog$pickFile$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                C4148a.d("PickFileMediatorInDialog", "pick file action start!", false, 4, null);
                Z0.a.b(this.this$0.context).d(new Intent("com.stepos.ailauncher.ACTION_HIDE_FLOAT_WINDOW"));
                this.label = 1;
                if (U.a(200L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            Intent intent = new Intent(this.this$0.context, (Class<?>) PickFileMediatorActivity.class);
            String str = this.$type;
            PickFileMediatorInDialog pickFileMediatorInDialog = this.this$0;
            int i11 = this.$maxImageCount;
            intent.addFlags(343998464);
            intent.putExtra(q.EXTRA_BIZ_TYPE, str);
            intent.putExtra(com.stepos.ailauncher.chat.wake.homebar.d.EXTRA_FROM_MORE_MENU, pickFileMediatorInDialog.fromMoreMenu);
            intent.putExtra(q.EXTRA_IS_FROM_FAKE_MODE, pickFileMediatorInDialog.isFakeMode);
            intent.putExtra(q.EXTRA_PICK_LIMIT, i11);
            intent.putExtra("exit", false);
            this.this$0.context.startActivity(intent, ActivityOptions.makeCustomAnimation(this.this$0.context, 0, 0).toBundle());
        } catch (Exception e10) {
            C4148a.h("PickFileMediatorInDialog", String.valueOf(e10.getMessage()), false, 4, null);
        }
        return Y8.t.f7040a;
    }
}
