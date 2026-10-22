package com.bytedance.android.livesdk.dislike.layout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.dislike.action.y;
import com.bytedance.android.livesdk.dislike.z;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nt1.e;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/ShareFansItemLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/z;", MapController.ITEM_LAYER_TAG, "", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareFansItemLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f122154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f122155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f122156c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareFansItemLayout f122157a;

        public a(ShareFansItemLayout r100) {
            this.f122157a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            z r101 = this.f122157a.f122156c;
            if (r101 == null) goto L7;
            pt1.a r102 = r101.f122246c;
        L8:
            r100.setTag(r102);
            z r103 = this.f122157a.f122156c;
            if (r103 == null) goto L14;
            y r104 = r103.f122247d;
            if (r104 == null) goto L15;
            r104.b(r100);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareFansItemLayout f122158a;

        public b(ShareFansItemLayout r100) {
            this.f122158a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            z r101 = this.f122158a.f122156c;
            if (r101 == null) goto L7;
            pt1.a r102 = r101.f122246c;
        L8:
            r100.setTag(r102);
            z r103 = this.f122158a.f122156c;
            if (r103 == null) goto L14;
            y r104 = r103.f122247d;
            if (r104 == null) goto L15;
            r104.b(r100);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareFansItemLayout f122159a;

        public c(ShareFansItemLayout r100) {
            this.f122159a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            z r101 = this.f122159a.f122156c;
            if (r101 == null) goto L7;
            pt1.a r102 = r101.f122246c;
        L8:
            r100.setTag(r102);
            z r103 = this.f122159a.f122156c;
            if (r103 == null) goto L14;
            y r104 = r103.f122247d;
            if (r104 == null) goto L15;
            r104.b(r100);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    public ShareFansItemLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(getContext(), R.layout.ttlive_dialog_share_fans_item, this);
        TextView r101 = (TextView) findViewById(R.id.share_button);
        if (r101 == null) goto L5;
        r101.setOnClickListener(new c(this));
        r101.setOnTouchListener(new e(this));
        Unit r102 = Unit.INSTANCE;
    L6:
        this.f122154a = r101;
        this.f122155b = (TextView) findViewById(R.id.shared_button);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void update(z r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f122156c = r100;
        pt1.a r101 = r100.f122246c;
        r101.getClass();
        pt1.a.f530630e.getClass();
        ArrayList r102 = pt1.a.b.a();
        if (r102 == null) goto L12;
        Room r103 = r101.f530631a;
        if (r103 == null) goto L7;
        long r104 = r103.getRoomId();
    L9:
        if (r102.contains(Long.valueOf(r104)) == false) goto L12;
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        b(this.f122154a, 0);
        b(this.f122155b, 8);
        return;
    L16:
        b(this.f122154a, 8);
        b(this.f122155b, 0);
        return;
    L7:
        r104 = 0;
    L12:
        r105 = true;
        goto L14
    }

    public ShareFansItemLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View.inflate(getContext(), R.layout.ttlive_dialog_share_fans_item, this);
        TextView r102 = (TextView) findViewById(R.id.share_button);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new b(this));
        r102.setOnTouchListener(new e(this));
        Unit r103 = Unit.INSTANCE;
    L6:
        this.f122154a = r102;
        this.f122155b = (TextView) findViewById(R.id.shared_button);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void b(View r100, int r101) {
        if (r100 != null) goto L4;
    L5:
        if (r100 == null) goto L9;
        r100.setVisibility(r101);
        return;
    L9:
        return;
    L4:
        if (r100.getVisibility() != r101) goto L5;
    }

    public ShareFansItemLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(getContext(), R.layout.ttlive_dialog_share_fans_item, this);
        TextView r103 = (TextView) findViewById(R.id.share_button);
        if (r103 == null) goto L5;
        r103.setOnClickListener(new a(this));
        r103.setOnTouchListener(new e(this));
        Unit r104 = Unit.INSTANCE;
    L6:
        this.f122154a = r103;
        this.f122155b = (TextView) findViewById(R.id.shared_button);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void a(ShareFansItemLayout r100, boolean r101, View r102) {
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
