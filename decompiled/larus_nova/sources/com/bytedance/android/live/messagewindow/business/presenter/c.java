package com.bytedance.android.live.messagewindow.business.presenter;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import zg1.i1;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f82972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f82973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IRoom f82974c;

    public c(b r100, View r101, IRoom r102) {
        this.f82972a = r100;
        this.f82973b = r101;
        this.f82974c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i1 r101 = (i1) r100;
        Float r102 = null;
        float r103 = 0.0f;
        if (r101 != null) goto L5;
    L27:
        View r104 = this.f82973b;
        if (r104 == null) goto L33;
        float r105 = -r101.f571849a;
        Float r106 = this.f82972a.f82969f;
        if (r106 == null) goto L32;
        r103 = r106.floatValue();
    L32:
        r104.setTranslationY(r105 + r103);
    L33:
        this.f82972a.f82969f = null;
        return;
    L5:
        if (r101.f571850b != true) goto L27;
        b r107 = this.f82972a;
        if (r107.f82969f != null) goto L13;
        View r108 = this.f82973b;
        if (r108 == null) goto L11;
        r102 = Float.valueOf(r108.getTranslationY());
    L11:
        r107.f82969f = r102;
    L13:
        if (PadConfigUtils.a() == true) goto L21;
        IRoom r109 = this.f82974c;
        if (r109 != null) goto L17;
    L18:
        View r110 = this.f82973b;
        if (r110 == null) goto L35;
        r110.setTranslationY((-r101.f571849a) + a1.e(r110));
        return;
    L35:
        return;
    L17:
        if (r109.isMergeVSRoom() != true) goto L18;
    L21:
        View r111 = this.f82973b;
        if (r111 == null) goto L37;
        float r112 = -r101.f571849a;
        float r113 = s1.j(R.dimen.ttlive_input_dialog_input_container_height);
        View r114 = this.f82973b;
        if (r114 == null) goto L26;
        r103 = a1.e(r114);
    L26:
        r111.setTranslationY(r112 - (r113 - r103));
        return;
    }
}
