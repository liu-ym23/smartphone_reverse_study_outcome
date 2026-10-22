package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.DispatchCallbackLinearLayout;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.larus.nova.R;
import g52.b;
import h52.c;
import k52.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/base/AbsPublicScreenMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lg52/b;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPublicScreenMessageViewHolder extends RecyclerView.ViewHolder implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f133721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f133722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DispatchCallbackLinearLayout f133723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NoMoreSpaceTextView f133724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f133725e;

    public abstract void T3(c r100);

    public final void d3() {
        DispatchCallbackLinearLayout r100 = this.f133723c;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f133722b == false) goto L8;
        int r101 = l.f133643a;
        int r102 = l.f133643a;
    L9:
        Drawable r103 = r100.getBackground();
        Drawable r104 = null;
        if ((r103 instanceof GradientDrawable) == true) goto L12;
        r103 = null;
    L12:
        GradientDrawable r105 = (GradientDrawable) r103;
        if (r105 != null) goto L19;
        r100.setBackgroundResource(R.drawable.ttlive_bg_message_item_v2);
        Drawable r106 = r100.getBackground();
        if ((r106 instanceof GradientDrawable) == false) goto L18;
        r104 = r106;
    L18:
        r105 = (GradientDrawable) r104;
    L19:
        if (r105 == null) goto L22;
        r105.setColor(r102);
        return;
    L22:
        return;
    L8:
        int r107 = l.f133643a;
        r102 = l.f133644b;
        goto L9
    }

    @Override // g52.b
    public final void c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f133722b = true;
        d3();
        return;
    L5:
        if (r101 != 1) goto L7;
        this.f133722b = false;
        d3();
        return;
    L7:
        if (r101 != 3) goto L15;
        this.f133722b = false;
        d3();
        return;
    }

    public AbsPublicScreenMessageViewHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "pipelineConfig");
        super(r100);
        this.f133725e = r101;
        DispatchCallbackLinearLayout r102 = (DispatchCallbackLinearLayout) r100.findViewById(R.id.background);
        this.f133723c = r102;
        NoMoreSpaceTextView r103 = (NoMoreSpaceTextView) r100.findViewById(R.id.content);
        this.f133724d = r103;
        if (r102 == null) goto L5;
        r102.setDispatchCallback(this);
    L5:
        if (r103 == null) goto L8;
        r103.setMovementMethod(u.a());
        r103.setHighlightColor(0);
        t.a(r103);
        return;
    }
}
