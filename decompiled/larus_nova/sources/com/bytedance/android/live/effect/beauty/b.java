package com.bytedance.android.live.effect.beauty;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BeautyModeSelectorAdapter f67111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f67112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f67113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BeautyModeSelectorAdapter.BeautyModeItemView f67114d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f67115a;

        public a(b r100) {
            this.f67115a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f67115a.f67111a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(BeautyModeSelectorAdapter r100, String r101, String r102, BeautyModeSelectorAdapter.BeautyModeItemView r103) {
        this.f67111a = r100;
        this.f67112b = r101;
        this.f67113c = r102;
        this.f67114d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if ((!Intrinsics.areEqual(this.f67111a.f67029b, this.f67112b)) == false) goto L6;
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().h().h(this.f67112b, this.f67113c);
        BeautyModeSelectorAdapter r102 = this.f67111a;
        String r103 = this.f67112b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f67029b = r103;
        this.f67114d.itemView.post(new a(this));
        return;
    }
}
