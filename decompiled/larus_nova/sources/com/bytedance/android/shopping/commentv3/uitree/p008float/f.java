package com.bytedance.android.shopping.commentv3.uitree.p008float;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.CommentBtmId;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import ic3.e;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t53.b;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements com.bytedance.android.shopping.commentv3.uitree.list.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatWindowUI f172817a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f172818a;

        public a(f r100) {
            this.f172818a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FloatWindowUI r100 = this.f172818a.f172817a;     // Catch: Throwable -> L6
            int r101 = FloatWindowUI.f172804o;     // Catch: Throwable -> L6
            View r102 = r100.f172662c;     // Catch: Throwable -> L6
            if (r102 == null) goto L9;
            r102.requestLayout();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.f
    public final void b() {
    }

    public f(FloatWindowUI r100) {
        this.f172817a = r100;
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.f
    public final void a(int r110) {
        FloatWindowUI r100 = this.f172817a;
        r100.f172809m = r110;
        if (r110 <= ((Number) r100.f172810n.getValue()).intValue()) goto L59;
        ImageView r111 = this.f172817a.f172805i;
        fc3.a r101 = null;
        if (r111 != null) goto L7;
    L8:
        ImageView r112 = this.f172817a.f172805i;
        if (r112 == null) goto L11;
        r112.setAlpha(0.5f);
    L11:
        ImageView r113 = this.f172817a.f172805i;
        if (r113 == null) goto L14;
        ExtensionsKt.visible(r113);
    L14:
        Context r114 = this.f172817a.getContext();
        if (r114 == null) goto L27;
        b r102 = b.f544622a;
        com.bytedance.android.shopping.commentv3.data.b r103 = this.f172817a.f172664e;
        if (r103 == null) goto L21;
        CommentParams r104 = r103.f172736a;
        if (r104 == null) goto L21;
        String r105 = r104.getProductId();
    L22:
        r102.getClass();
        b.c(r114, true, r105);
        int r115 = e.f489165a;
        com.bytedance.android.shopping.commentv3.data.b r116 = this.f172817a.f172664e;
        if (r116 == null) goto L25;
        fc3.a r106 = r116.f172737b;
    L26:
        e.a.a(r106, EventName.SHOW.getEvent(), EntranceType.LIST_IMAGE_SCROLL_TOP.getType(), new LinkedHashMap(), CommentBtmId.FLOAT_TO_TOP.getId(), this.f172817a.f172805i, 48);
        goto L27
    L25:
        r106 = null;
    L21:
        r105 = null;
    L27:
        ImageView r117 = this.f172817a.f172806j;
        if (r117 != null) goto L30;
    L31:
        c r118 = (c) this.f172817a.f172669b.getValue();
        if (r118 == null) goto L59;
        if (r118.f172814b != true) goto L59;
        ImageView r119 = this.f172817a.f172806j;
        if (r119 == null) goto L38;
        r119.setAlpha(0.5f);
    L38:
        ImageView r120 = this.f172817a.f172806j;
        if (r120 == null) goto L42;
        ExtensionsKt.visible(r120);
    L42:
        if (this.f172817a.getContext() == null) goto L59;
        b r121 = b.f544622a;
        com.bytedance.android.shopping.commentv3.data.b r107 = this.f172817a.f172664e;
        String r108 = "pic";
        if (r107 != null) goto L46;
    L48:
        String r109 = "list";
    L49:
        Context r122 = this.f172817a.getContext();
        r121.getClass();
        Intrinsics.checkNotNullParameter(r109, "commentSwitchType");
        u53.e r123 = new u53.e();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r123.f548816a = r109;
        t53.e.c(r123, r122, null);
        int r124 = e.f489165a;
        com.bytedance.android.shopping.commentv3.data.b r125 = this.f172817a.f172664e;
        if (r125 == null) goto L52;
        r101 = r125.f172737b;
    L52:
        fc3.a r126 = r101;
        String r127 = EventName.SHOW.getEvent();
        String r128 = EntranceType.LIST_PIC_MODE_SWITCH.getType();
        Pair[] r129 = new Pair[1];
        com.bytedance.android.shopping.commentv3.data.b r130 = this.f172817a.f172664e;
        if (r130 != null) goto L55;
    L57:
        r108 = "list";
    L58:
        r129[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMENT_SWITCH_TYPE, r108);
        e.a.a(r126, r127, r128, MapsKt.mutableMapOf(r129), CommentBtmId.FLOAT_MULTI_SWITCH.getId(), this.f172817a.f172806j, 48);
        goto L59
    L55:
        if (r130.c() != true) goto L57;
    L46:
        if (r107.c() != true) goto L48;
        r109 = "pic";
        goto L49
    L30:
        if (r117.getVisibility() == 0) goto L59;
    L7:
        if (r111.getVisibility() == 0) goto L27;
    L59:
        FloatWindowUI r131 = this.f172817a;
        if (r131.f172809m > ((Number) r131.f172810n.getValue()).intValue()) goto L79;
        ImageView r132 = this.f172817a.f172805i;
        if (r132 != null) goto L64;
    L65:
        ImageView r133 = this.f172817a.f172805i;
        if (r133 == null) goto L68;
        ExtensionsKt.gone(r133);
    L68:
        ImageView r134 = this.f172817a.f172806j;
        if (r134 != null) goto L71;
    L72:
        ImageView r135 = this.f172817a.f172806j;
        if (r135 == null) goto L75;
        ExtensionsKt.gone(r135);
    L75:
        View r136 = this.f172817a.f172662c;
        if (r136 == null) goto L80;
        r136.post(new a(this));
        return;
    L80:
        return;
    L71:
        if (r134.getVisibility() == 8) goto L75;
    L64:
        if (r132.getVisibility() == 8) goto L68;
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.f
    public final void c(int r100) {
        ImageView r101 = this.f172817a.f172805i;
        if (r101 != null) goto L5;
    L14:
        ImageView r102 = this.f172817a.f172806j;
        if (r102 != null) goto L17;
        return;
    L17:
        if (r102.getVisibility() != 0) goto L28;
        if (r100 != 1) goto L22;
        ImageView r103 = this.f172817a.f172806j;
        if (r103 == null) goto L29;
        r103.setAlpha(0.5f);
        return;
    L29:
        return;
    L22:
        if (r100 != 0) goto L31;
        ImageView r104 = this.f172817a.f172806j;
        if (r104 == null) goto L32;
        r104.setAlpha(1.0f);
        return;
    L32:
        return;
    L31:
        return;
    L28:
        return;
    L5:
        if (r101.getVisibility() != 0) goto L14;
        if (r100 != 1) goto L10;
        ImageView r105 = this.f172817a.f172805i;
        if (r105 == null) goto L14;
        r105.setAlpha(0.5f);
        goto L14
    L10:
        if (r100 != 0) goto L14;
        ImageView r106 = this.f172817a.f172805i;
        if (r106 == null) goto L14;
        r106.setAlpha(1.0f);
        goto L14
    }
}
