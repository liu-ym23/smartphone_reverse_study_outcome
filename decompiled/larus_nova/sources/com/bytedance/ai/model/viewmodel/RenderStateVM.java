package com.bytedance.ai.model.viewmodel;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.assem.arch.viewModel.h;
import i5.b;
import i5.c;
import i5.d;
import i5.e;
import i5.f;
import i5.g;
import i5.i;
import i5.j;
import i5.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class RenderStateVM extends AssemViewModel<g> {
    public static final List<Class<?>> RENDER_STATE_LIST = null;

    public static /* synthetic */ g yo(Object r100, g r101) {
        return lambda$updateState$0(r100, r101);
    }

    static {
        RENDER_STATE_LIST = Collections.unmodifiableList(Arrays.asList(new Class[]{d.class, c.class, f.class, j.class, b.class, e.class, i.class, k.class}));
    }

    @Override // com.bytedance.assem.arch.viewModel.AssemViewModel
    public g defaultState() {
        return new g();
    }

    public RenderStateVM() {
    }

    @Override // com.bytedance.assem.arch.viewModel.AssemViewModel
    public /* bridge */ /* synthetic */ h defaultState() {
        return defaultState();
    }

    public void updateState(final Object r100) {
        Iterator<Class<?>> r101 = RENDER_STATE_LIST.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next() != r100.getClass()) goto L4;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        setState(new i5.h(r100));
        return;
    L13:
        throw new IllegalArgumentException("RenderState doesn't support state of " + r100.getClass());
    L8:
        r102 = false;
        goto L9
    }

    private static g lambda$updateState$0(Object r100, g r101) {
        r101.getClass();
        return new g(r100);
    }
}
