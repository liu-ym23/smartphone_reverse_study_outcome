package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f118773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f118774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f118775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup.LayoutParams f118776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f118777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f118778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f118779g;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d2 f118780a;

        public a(d2 r100) {
            this.f118780a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            this.f118780a.getClass();
            StringBuilder r102 = new StringBuilder("Rev_smoothEnterRoom receive show frame view mock ");
            if (r101 == null) goto L5;
            Object r103 = r101.getData();
        L6:
            r102.append(r103);
            ALogger.d("RevFeedViewHandleWidget", r102.toString());
            if (r101 == null) goto L16;
            Bitmap r104 = (Bitmap) r101.getData(null);
            if (r104 == null) goto L17;
            ImageView r105 = this.f118780a.f118779g;
            if (r105 == null) goto L14;
            r105.setImageBitmap(r104);
        L14:
            this.f118780a.a("leave");
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d2 f118781a;

        public b(d2 r100) {
            this.f118781a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) ((KVData) r100).getData();
            if (r101 != null) goto L5;
            r101 = 0;
        L5:
            int r102 = r101.intValue();
            String r103 = null;
            if (gd0.v.a(r102, 4) == false) goto L18;
            KeyEvent.Callback r104 = this.f118781a.f118774b;
            boolean r105 = r104 instanceof qc0.f;
            if (r105 == false) goto L30;
            if (r105 == true) goto L11;
            r104 = null;
        L11:
            qc0.f r106 = (qc0.f) r104;
            if (r106 == null) goto L15;
            r103 = r106.getFeedViewName();
        L15:
            if ((!Intrinsics.areEqual(r103, "RevPkFullFeedView")) == false) goto L31;
            this.f118781a.a("event");
            return;
        L31:
            return;
        L30:
            return;
        L18:
            if (gd0.v.a(r102, 64) == false) goto L33;
            KeyEvent.Callback r107 = this.f118781a.f118774b;
            boolean r108 = r107 instanceof qc0.f;
            if (r108 == false) goto L34;
            if (r108 == true) goto L23;
            r107 = null;
        L23:
            qc0.f r109 = (qc0.f) r107;
            if (r109 == null) goto L27;
            r103 = r109.getFeedViewName();
        L27:
            if ((!Intrinsics.areEqual(r103, "RevMultiAnchorFeedView")) == false) goto L35;
            this.f118781a.a("event");
            return;
        L35:
            return;
        L34:
            return;
        }
    }

    public static final class c {
    }

    static {
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (Intrinsics.areEqual(r100, "leave") == false) goto L15;
        DataCenter r101 = this.f118777e;
        if (r101 == null) goto L7;
        qc0.d r102 = (qc0.d) r101.get("data_rev_enter_room_feed_view_data", null);
    L8:
        if (r102 == null) goto L12;
        Function0<Unit> r103 = r102.a();
        if (r103 == null) goto L12;
        Unit r104 = r103.invoke();
    L12:
        DataCenter r105 = this.f118777e;
        if (r105 == null) goto L15;
        r105.put("data_rev_enter_room_feed_view_data", null);
        goto L15
    L7:
        r102 = null;
    L15:
        View r106 = this.f118774b;
        if (r106 != null) goto L18;
    L36:
        return false;
    L18:
        if (this.f118775c == null) goto L36;
        if (r106.getParent() != this.f118778f) goto L36;
        ALogger.d("RevFeedViewHandleWidget", "Rev_smoothEnterRoom: remove & back to feed from ".concat(r100));
        FrameLayout r107 = this.f118778f;
        if (r107 == null) goto L25;
        r107.removeView(this.f118774b);
    L25:
        if ((!Intrinsics.areEqual(r100, "event")) == false) goto L32;
        ViewGroup r108 = this.f118775c;
        if (r108 == null) goto L29;
        r108.addView(this.f118774b, this.f118776d);
    L29:
        DataCenter r109 = this.f118777e;
        if (r109 == null) goto L32;
        r109.put("data_rev_enter_room_feed_view_data", null);
    L32:
        this.f118774b = null;
        this.f118775c = null;
        this.f118776d = null;
        ILinkServiceExternal r110 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r110 == null) goto L35;
        r110.updateEnterRoomViewMock(false);
    L35:
        return true;
    }

    public d2(DataCenter r100, FrameLayout r101, ImageView r102) {
        this.f118777e = r100;
        this.f118778f = r101;
        this.f118779g = r102;
        this.f118773a = new CompositeDisposable();
        if (r100 == null) goto L5;
        r100.observe("cmd_rev_leave_room_show_view_mock", new a(this));
    L5:
        if (r100 == null) goto L8;
        r100.observe("data_link_state", new b(this));
        return;
    }
}
