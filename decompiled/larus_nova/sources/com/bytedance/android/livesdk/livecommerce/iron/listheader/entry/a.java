package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.c;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f148812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECDraweeView f148813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f148814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECPromotionEntry f148815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f148816e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC2302a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f148817a;

        public ViewOnAttachStateChangeListenerC2302a(a r100) {
            this.f148817a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f148817a.setAttached(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f148817a.setAttached(false);
        }
    }

    public static final class b {
    }

    static {
    }

    public final void setAttached(boolean r100) {
    }

    public final Map<String, String> getParams() {
        return this.f148816e;
    }

    public a(Context r100) {
        super(r100);
        setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(44)));
        setGravity(16);
        setOrientation(0);
        o0.c(this, 16);
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC2302a(this));
    }

    public final void setParams(Map<String, String> r100) {
        this.f148816e = r100;
    }
}
