package com.bytedance.android.livesdk.asr;

import android.view.View;
import java.util.Objects;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftASRDebugDialog f103955a;

    public a(GiftASRDebugDialog r100) {
        this.f103955a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        GiftASRDebugDialog r101 = this.f103955a;
        int r102 = GiftASRDebugDialog.f103939h;
        r101.getClass();
        Objects.toString(this.f103955a.f103943g);
        GiftASRDebugDialog r103 = this.f103955a;
        ButtonStatus r104 = r103.f103943g;
        ButtonStatus r105 = ButtonStatus.Recognizing;
        if (r104 != r105) goto L6;
        r103.getClass();
        throw null;
    L6:
        CollectionsKt.listOf(new String[]{"家人们", "关注"});
        GiftASRDebugDialog r106 = this.f103955a;
        r106.f103943g = r105;
        r106.S90();
        this.f103955a.getClass();
        throw null;
    }
}
