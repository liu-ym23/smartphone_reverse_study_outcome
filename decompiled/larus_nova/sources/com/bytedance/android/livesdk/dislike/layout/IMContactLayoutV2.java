package com.bytedance.android.livesdk.dislike.layout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dislike.action.l;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMContactLayoutV2;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/l;", MapController.ITEM_LAYER_TAG, "", "update", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "setFragment", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMContactLayoutV2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMContactDescItemLayoutV2 f122128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f122129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f122130c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122131a;

        public a(String r100) {
            this.f122131a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            f2.c(this.f122131a, 0);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMContactLayoutV2 f122132a;

        public b(IMContactLayoutV2 r100) {
            this.f122132a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            l r101 = this.f122132a.f122129b;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    public IMContactLayoutV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(getContext(), R.layout.ttlive_dialog_long_press_im_contact, this);
        this.f122128a = (IMContactDescItemLayoutV2) findViewById(R.id.desc_layout);
        this.f122130c = (FrameLayout) findViewById(R.id.im_button_area);
    }

    public final void setFragment(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f122128a.setFragment(r100);
    }

    public final void update(com.bytedance.android.livesdk.dislike.l r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f122129b = r100.f122120d;
        this.f122128a.update(r100.f122119c);
    }

    public IMContactLayoutV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View.inflate(getContext(), R.layout.ttlive_dialog_long_press_im_contact, this);
        this.f122128a = (IMContactDescItemLayoutV2) findViewById(R.id.desc_layout);
        this.f122130c = (FrameLayout) findViewById(R.id.im_button_area);
    }

    public final void b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "tipContent");
        if (r100 == false) goto L10;
        FrameLayout r102 = this.f122130c;
        if (r102 == null) goto L14;
        TextView r103 = (TextView) r102.findViewById(R.id.im_button_text);
        if (r103 == null) goto L9;
        r103.setBackground(s1.m(R.drawable.ttlive_bg_long_press_im_btn_grey));
    L9:
        r102.setOnClickListener(new a(r101));
        return;
    L14:
        return;
    L10:
        FrameLayout r104 = this.f122130c;
        if (r104 == null) goto L16;
        r104.setOnClickListener(new b(this));
        r104.setOnTouchListener(new nt1.a(this));
        return;
    }

    public IMContactLayoutV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(getContext(), R.layout.ttlive_dialog_long_press_im_contact, this);
        this.f122128a = (IMContactDescItemLayoutV2) findViewById(R.id.desc_layout);
        this.f122130c = (FrameLayout) findViewById(R.id.im_button_area);
    }

    public static final void a(IMContactLayoutV2 r100, boolean r101, View r102) {
        r100.getClass();
        float[] r103 = new float[2];
        float r104 = 1.0f;
        if (r101 == false) goto L5;
        float r105 = 1.0f;
    L6:
        r103[0] = r105;
        if (r101 == false) goto L9;
        r104 = 0.75f;
    L9:
        r103[1] = r104;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r102, "alpha", r103);
        r106.setDuration(100);
        r106.start();
        return;
    L5:
        r105 = 0.75f;
        goto L6
    }
}
