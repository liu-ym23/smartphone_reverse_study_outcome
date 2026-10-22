package com.bytedance.android.live.room.discovery.inspector;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialInspectorWidget f99547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f99548b;

    public c(OfficialInspectorWidget r100, l r101) {
        this.f99547a = r100;
        this.f99548b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        StringBuilder r102 = new StringBuilder("download icon error, ImageMode: ");
        ImageModel r103 = this.f99548b.f99559b;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.toString();
    L6:
        r102.append(r105);
        r102.append(", error: ");
        if (r101 == null) goto L9;
        r104 = r101.toString();
    L9:
        r102.append(r104);
        ALogger.e("OfficialInspectorWidget", r102.toString());
        ImageView r106 = this.f99547a.f99532b;
        if (r106 == null) goto L12;
        r106.setVisibility(8);
    L12:
        Disposable r107 = this.f99547a.f99536f;
        if (r107 != null) goto L15;
    L16:
        Disposable r108 = this.f99547a.f99536f;
        if (r108 == null) goto L19;
        r108.dispose();
    L19:
        OfficialInspectorWidget r109 = this.f99547a;
        l r110 = this.f99548b;
        r109.getClass();
        if (r110.f99558a == false) goto L25;
        TextView r111 = r109.f99533c;
        if (r111 == null) goto L26;
        r111.post(new e(r109, r110));
        return;
    L26:
        return;
    L25:
        return;
    L15:
        if (r107.isDisposed() == true) goto L19;
    L5:
        r105 = null;
        goto L6
    }
}
