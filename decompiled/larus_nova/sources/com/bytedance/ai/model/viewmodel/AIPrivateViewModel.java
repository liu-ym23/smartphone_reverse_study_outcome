package com.bytedance.ai.model.viewmodel;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.assem.arch.viewModel.h;
import java.util.HashMap;
import java.util.Iterator;
import u4.b;
import u4.g;

/* JADX INFO: loaded from: classes43.dex */
public class AIPrivateViewModel extends AssemViewModel<i5.a> {

    public static class a implements a6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f36946a;

        @Override // a6.a
        public final b getIStorage() {
            return this.f36946a;
        }

        public a(String r100) {
            this.f36946a = new g(false, r100);
        }
    }

    @Override // com.bytedance.assem.arch.viewModel.AssemViewModel
    public i5.a defaultState() {
        return new i5.a(new HashMap());
    }

    @Override // com.bytedance.assem.arch.viewModel.AssemViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Iterator<a6.a> r100 = getState().f488261a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getIStorage().cleanup();
        goto L4
    L6:
        super.onCleared();
    }

    public AIPrivateViewModel() {
    }

    @Override // com.bytedance.assem.arch.viewModel.AssemViewModel
    public /* bridge */ /* synthetic */ h defaultState() {
        return defaultState();
    }

    public a6.a getIAIViewModel(String r100) {
        i5.a r101 = getState();
        a6.a r102 = r101.f488261a.get(r100);
        if (r102 != null) goto L6;
        a r103 = new a(r100);
        r101.f488261a.put(r100, r103);
        return r103;
    L6:
        return r102;
    }
}
