package com.stepos.ailauncher.task.space;

import Z8.C1172u;
import Z8.C1173v;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;
import com.stepos.ailauncher.task.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemoryFileEditFragment$performDelete$1", f = "MemoryFileEditFragment.kt", l = {326}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MemoryFileEditFragment$performDelete$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Dialog $loadingDialog;
    final /* synthetic */ String $tabType;
    Object L$0;
    int label;
    final /* synthetic */ MemoryFileEditFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryFileEditFragment$performDelete$1(MemoryFileEditFragment memoryFileEditFragment, String str, Dialog dialog, InterfaceC4014c<? super MemoryFileEditFragment$performDelete$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = memoryFileEditFragment;
        this.$tabType = str;
        this.$loadingDialog = dialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MemoryFileEditFragment$performDelete$1(this.this$0, this.$tabType, this.$loadingDialog, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MemoryFileEditFragment$performDelete$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Bundle arguments = this.this$0.getArguments();
                List<String> stringArrayList = arguments != null ? arguments.getStringArrayList("memory_ids") : null;
                if (stringArrayList == null) {
                    stringArrayList = C1173v.m();
                }
                List<String> listE = stringArrayList;
                MemoryFileEditFragment memoryFileEditFragment = this.this$0;
                if (listE.isEmpty()) {
                    listE = C1172u.e(memoryFileEditFragment.memoryId);
                }
                List<String> list = listE;
                MemorySettingApi memorySettingApi = MemorySettingApi.INSTANCE;
                String str = this.$tabType;
                String str2 = this.this$0.memoryName;
                this.L$0 = g9.h.a(list);
                this.label = 1;
                obj = memorySettingApi.E(str, str2, list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            Set<String> set = (Set) obj;
            AmooMemoryDetailFragment amooMemoryDetailFragmentI0 = this.this$0.i0();
            if (set != null) {
                Toast.makeText(this.this$0.requireContext(), R$string.memory_delete_success, 0).show();
                if (amooMemoryDetailFragmentI0 != null) {
                    amooMemoryDetailFragmentI0.R(this.$tabType, set);
                }
                if (amooMemoryDetailFragmentI0 != null) {
                    amooMemoryDetailFragmentI0.Q();
                }
                C4109a.a(this.this$0.x());
            } else {
                if (amooMemoryDetailFragmentI0 != null) {
                    amooMemoryDetailFragmentI0.Q();
                }
                Toast.makeText(this.this$0.requireContext(), R$string.memory_delete_failed, 0).show();
            }
            this.this$0.isDeleting = false;
            this.$loadingDialog.dismiss();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            this.this$0.isDeleting = false;
            this.$loadingDialog.dismiss();
            throw th;
        }
    }
}
