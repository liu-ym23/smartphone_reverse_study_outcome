package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i0 extends BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f149594c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f149595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f149596b;

        public a(i0 r100, b r101) {
            this.f149595a = r100;
            this.f149596b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveFlashViewModel r101 = this.f149595a.f149510a;
            if (r101 == null) goto L8;
            MutableLiveData<b> r102 = r101.getItemClickObserver();
            if (r102 == null) goto L9;
            r102.postValue(this.f149596b);
            return;
        L9:
            return;
        }
    }

    public i0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149594c = r100.findViewById(R.id.iv_right_arrow);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        if ((r100 instanceof f) == true) goto L5;
        b r102 = null;
    L6:
        f r103 = (f) r102;
        if (r103 != null) goto L9;
    L12:
        this.itemView.setOnClickListener(new a(this, r100));
        return;
    L9:
        if (r103.f149579b == false) goto L11;
        this.f149594c.setRotation(180.0f);
        goto L12
    L11:
        this.f149594c.setRotation(0.0f);
        goto L12
    L5:
        r102 = r100;
        goto L6
    }
}
