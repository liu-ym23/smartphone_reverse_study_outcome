package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.view.View;
import androidx.lifecycle.LiveData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f149732a;

    public h(i r100) {
        this.f149732a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveFlashMultiSelectDialogFragment r101 = this.f149732a.f149733a;
        Function1<? super List<String>, Unit> r102 = r101.f149706k;
        if (r102 == null) goto L24;
        LiveFlashMultiSelectViewModel r103 = (LiveFlashMultiSelectViewModel) r101.f147650g;
        if (r103 == null) goto L14;
        LiveData<List<k>> r104 = r103.getCurrentStringListLiveData();
        if (r104 == null) goto L14;
        List<k> r105 = r104.getValue();
        if (r105 == null) goto L14;
        List<k> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L15;
        r107.add(((k) r108.next()).f149736a);
    L15:
        Unit r109 = r102.invoke(r107);
    L14:
        r107 = new ArrayList();
    L24:
        this.f149732a.f149733a.dismiss();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r110 = DialogFragmentLancet.sLastShowStack;
        if (r110 == null) goto L27;
        com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
