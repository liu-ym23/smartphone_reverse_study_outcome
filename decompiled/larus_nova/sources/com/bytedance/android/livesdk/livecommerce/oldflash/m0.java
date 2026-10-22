package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m0 extends BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f149636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f149637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f149638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f149639f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f149640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.oldflash.b f149641b;

        public b(m0 r100, com.bytedance.android.livesdk.livecommerce.oldflash.b r101) {
            this.f149640a = r100;
            this.f149641b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveFlashViewModel r101 = this.f149640a.f149510a;
            if (r101 == null) goto L8;
            MutableLiveData<com.bytedance.android.livesdk.livecommerce.oldflash.b> r102 = r101.getItemClickObserver();
            if (r102 == null) goto L9;
            r102.postValue(this.f149641b);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public m0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149636c = (TextView) r100.findViewById(R.id.tv_content);
        this.f149637d = (TextView) r100.findViewById(R.id.tv_label);
        this.f149638e = (TextView) r100.findViewById(R.id.tv_user_input);
        Context r101 = r100.getContext();
        ECDisplayUtils.ScreenType r102 = ECDisplayUtils.f153036a;
        boolean r103 = false;
        if (r101 == null) goto L5;
        Resources r104 = r101.getResources();
        int r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels;
    L7:
        if (r105 >= w0.a(375.0f)) goto L9;
        r103 = true;
    L9:
        this.f149639f = r103;
        return;
    L5:
        r105 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(com.bytedance.android.livesdk.livecommerce.oldflash.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        if ((r100 instanceof l) == true) goto L5;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r102 = null;
    L6:
        l r103 = (l) r102;
        if (r103 == null) goto L31;
        TextView r104 = this.f149636c;
        String r105 = r103.f149626c;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r104.setText(new StringBuilder(r105));
        this.f149637d.setText(r103.f149573b);
        TextView r106 = this.f149638e;
        String r107 = r103.f149627d;
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        r106.setText(r107);
        CharSequence r108 = this.f149638e.getText();
        if (r108 != null) goto L17;
    L22:
        TextView r109 = this.f149638e;
        Context r110 = r109.getContext();
        if (this.f149639f == false) goto L25;
        int r111 = R.string.ec_live_flash_item_title_custom_less;
    L26:
        r109.setHint(th.a.g(r110, r111));
    L28:
        if (this.f149639f == false) goto L30;
        this.f149637d.setMaxWidth(w0.a(102.0f));
        goto L31
    L30:
        this.f149637d.setMaxWidth(w0.a(148.0f));
        goto L31
    L25:
        r111 = R.string.ec_live_flash_item_title_custom;
        goto L26
    L17:
        if (r108.length() <= 0) goto L19;
        boolean r112 = true;
    L20:
        if (r112 != true) goto L22;
        this.f149638e.setHint("");
        goto L28
    L19:
        r112 = false;
    L31:
        this.f149638e.setOnClickListener(new b(this, r100));
        return;
    L5:
        r102 = r100;
        goto L6
    }
}
