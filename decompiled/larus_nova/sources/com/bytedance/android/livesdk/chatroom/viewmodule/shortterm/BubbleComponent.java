package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bytedance.android.live.base.model.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c1;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import j40.f4;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/shortterm/BubbleComponent;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "f", "I", "getType", "()I", "type", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleComponent implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f115501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.view.k f115502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f115503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f115504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.p f115505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f115506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f115507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f115508h;

    public final void a() {
        if (c1.f65269a.getValue().booleanValue() == true) goto L6;
        return;
    L6:
        if (e5.n() == false) goto L10;
        ALogger.d(this.f115501a, "landcape dont allow show");
        return;
    L10:
        if (this.f115507g != 0) goto L13;
        this.f115507g = System.currentTimeMillis();
    L13:
        if (this.f115505e != null) goto L16;
        return;
    L16:
        if (this.f115504d.getParent() != null) goto L18;
        return;
    L18:
        com.bytedance.android.live.base.model.p r100 = this.f115505e;
        r r101 = r100.uIModel;
        if (r101 != null) goto L21;
        return;
    L21:
        int r102 = r100.strategy;
        if (r102 == (-1)) goto L52;
        String r103 = "";
        if (r102 != 4) goto L26;
        int r104 = this.f115506f;
        String r105 = r100.f58903id;
        if (r105 == null) goto L43;
        r103 = r105;
    L43:
        String r106 = String.valueOf(r104) + r103;
        long r107 = this.f115507g;
        int r108 = q.f115581a;
        Intrinsics.checkNotNullParameter(r106, "key");
        com.bytedance.android.livesdk.sharedpref.e<Map<String, Pair<Long, Integer>>> r109 = f4.f497213p;
        Pair<Long, Integer> r110 = r109.getValue().get(r106);
        if (r110 != null) goto L46;
    L50:
        int r111 = 1;
    L51:
        r109.getValue().put(r106, new Pair(Long.valueOf(r107), Integer.valueOf(r111)));
        goto L52
    L46:
        if (TimeUtils.isToday(r110.getFirst().longValue(), r107) == false) goto L50;
        r111 = r110.getSecond().intValue() + 1;
        if (r111 <= 1) goto L51;
    L49:
        boolean r112 = false;
    L53:
        if (r112 == true) goto L56;
        ALogger.d(this.f115501a, "should not show,strategy is " + this.f115505e.strategy);
        return;
    L56:
        View r113 = this.f115504d.getRootView();
        if (r113 == null) goto L66;
        View r114 = r113.findViewById(R.id.short_term_indicator_scroll_view);
        if (r114 == null) goto L66;
        int[] r115 = new int[2];
        int[] r116 = new int[2];
        r114.getLocationOnScreen(r115);
        this.f115504d.getLocationOnScreen(r116);
        int r117 = r115[0];
        if (r117 > r116[0]) goto L66;
        if ((r117 + r114.getWidth()) < (r116[0] + this.f115504d.getWidth())) goto L66;
        boolean r118 = true;
    L67:
        if (r118 == true) goto L78;
        ALogger.d(this.f115501a, "is not visible");
        return;
    L78:
        Context r119 = this.f115503c;     // Catch: Throwable -> L75
        if (r119 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.view.k.a r120 = new com.bytedance.android.livesdk.chatroom.view.k.a((Activity) r119);     // Catch: Throwable -> L75
        String r121 = r101.text;     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r121, "str");     // Catch: Throwable -> L75
        r120.f524274e = r121;     // Catch: Throwable -> L75
        r120.f524270a = Color.parseColor(r101.bgColor);     // Catch: Throwable -> L75
        r120.f524276g = UtilityKotlinExtentionsKt.h(r101.textSize);     // Catch: Throwable -> L75
        r120.f524277h = Color.parseColor(r101.textColor);     // Catch: Throwable -> L75
        r120.f524273d = this.f115505e.duration;     // Catch: Throwable -> L75
        c r122 = new c(this);     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r122, "listener");     // Catch: Throwable -> L75
        r120.f524278i = r122;     // Catch: Throwable -> L75
        r120.f524272c = false;     // Catch: Throwable -> L75
        r120.f524281l = false;     // Catch: Throwable -> L75
        com.bytedance.android.livesdk.chatroom.view.k r123 = new com.bytedance.android.livesdk.chatroom.view.k(r120);     // Catch: Throwable -> L75
        this.f115502b = r123;     // Catch: Throwable -> L75
        r123.d(this.f115504d);     // Catch: Throwable -> L75
        Ref.IntRef r124 = new Ref.IntRef();     // Catch: Throwable -> L75
        r124.element = -1;     // Catch: Throwable -> L75
        Ref.IntRef r125 = new Ref.IntRef();     // Catch: Throwable -> L75
        r125.element = -1;     // Catch: Throwable -> L75
        this.f115504d.getViewTreeObserver().addOnGlobalLayoutListener(new b(this, r123, new int[2], r124, r125));     // Catch: Throwable -> L75
        return;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        ALogger.e(this.f115501a, th);
        return;
    L66:
        r118 = false;
        goto L67
    L26:
        if (r102 != 5) goto L49;
        int r126 = this.f115506f;
        String r127 = r100.f58903id;
        if (r127 == null) goto L32;
        r103 = r127;
    L32:
        String r128 = String.valueOf(r126) + r103;
        long r129 = this.f115507g;
        int r130 = q.f115581a;
        Intrinsics.checkNotNullParameter(r128, "key");
        com.bytedance.android.livesdk.sharedpref.e<Map<String, Pair<Long, Integer>>> r131 = f4.f497213p;
        Pair<Long, Integer> r132 = r131.getValue().get(r128);
        if (r132 == null) goto L37;
        int r133 = r132.getSecond().intValue() + 1;
        if (r133 > 1) goto L49;
    L38:
        r131.getValue().put(r128, new Pair(Long.valueOf(r129), Integer.valueOf(r133)));
        goto L52
    L37:
        r133 = 1;
    L52:
        r112 = true;
        goto L53
    }

    public final Context getContext() {
        return this.f115503c;
    }

    public final int getType() {
        return this.f115506f;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getKey().length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L44;
        String r103 = r101.getKey();
        int r104 = r103.hashCode();
        if (r104 == (-1357019912)) goto L19;
        if (r104 == 1060055221) goto L16;
        return;
    L16:
        if (r103.equals("data_keyboard_status") == false) goto L37;
    L20:
        Boolean r105 = (Boolean) r101.getData();
        if (r105 != null) goto L24;
        return;
    L24:
        if (r105.booleanValue() == false) goto L30;
        com.bytedance.android.livesdk.chatroom.view.k r106 = this.f115502b;
        if (r106 == null) goto L39;
        View r107 = r106.getContentView();
        if (r107 == null) goto L40;
        r107.setVisibility(8);
        return;
    L40:
        return;
    L39:
        return;
    L30:
        com.bytedance.android.livesdk.chatroom.view.k r108 = this.f115502b;
        if (r108 == null) goto L42;
        View r109 = r108.getContentView();
        if (r109 == null) goto L43;
        r109.setVisibility(0);
        return;
    L43:
        return;
    L42:
        return;
    L37:
        return;
    L19:
        if (r103.equals("data_pre_show_keyboard") == true) goto L20;
        return;
    L44:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public BubbleComponent(Context r100, CommonIconTemplate r101, com.bytedance.android.live.base.model.p r102, int r103, long r104, DataCenter r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r105, "dataCenter");
        this.f115503c = r100;
        this.f115504d = r101;
        this.f115505e = r102;
        this.f115506f = r103;
        this.f115507g = r104;
        this.f115508h = r105;
        this.f115501a = "BubbleComponent";
        r105.observe("data_pre_show_keyboard", this).observe("data_keyboard_status", this);
    }
}
