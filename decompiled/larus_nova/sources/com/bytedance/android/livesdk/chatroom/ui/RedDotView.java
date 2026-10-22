package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/RedDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;", "getRedDot", "()Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;", "setRedDot", "(Lcom/bytedance/android/livesdk/reddot/RedDotDelegate;)V", "redDot", "", "b", "Z", "isShowing", "()Z", "setShowing", "(Z)V", "c", "isAnchor", "setAnchor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedDotView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f112465d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RedDotDelegate f112466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f112467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112468c;

    public RedDotView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RedDotView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean j() {
        RedDotDelegate r100 = this.f112466a;
        boolean r101 = false;
        if (r100 == null) goto L5;
        r101 = r100.a(false);
    L5:
        if (r101 == true) goto L13;
        RedDotDelegate r102 = this.f112466a;
        if (r102 == null) goto L13;
        if (r102.d() == true) goto L13;
        RedDotDelegate r103 = this.f112466a;
        if (r103 == null) goto L13;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = r103.c();
        Boolean r105 = Boolean.TRUE;
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
    L13:
        return r101;
    }

    public final void l() {
        if (this.f112467b == false) goto L31;
        RedDotDelegate r100 = this.f112466a;
        if (r100 != null) goto L7;
    L9:
        RedDotDelegate r101 = this.f112466a;
        if (r101 == null) goto L16;
        com.bytedance.android.livesdk.reddot.a r102 = r101.f157075a;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L14:
        String r103 = r102.f157083a;
        if (r103 == null) goto L16;
    L17:
        Map<String, String> r104 = MapsKt.mapOf(TuplesKt.to("spot_name", r103));
        if (this.f112468c == false) goto L24;
        Pair[] r105 = new Pair[2];
        r105[0] = TuplesKt.to("spot_title", "礼物");
        if (this.f112468c == false) goto L22;
        String r106 = "anchor";
    L23:
        r105[1] = TuplesKt.to("user_type", r106);
        r104 = MapsKt.plus(r104, MapsKt.mapOf(r105));
        goto L24
    L22:
        r106 = "user";
    L24:
        qm0.b r107 = om0.c.g();
        if (r107 == null) goto L27;
        r107.sendLog("livesdk_room_spot_click", r104, new Object[]{am2.x.class, s80.a.f540946a});
    L27:
        RedDotDelegate r108 = this.f112466a;
        if (r108 == null) goto L32;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r109 = r108.c();
        Boolean r110 = Boolean.TRUE;
        r109.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r109, r110);
        return;
    L32:
        return;
    L16:
        r103 = "";
        goto L17
    L7:
        if (r100.d() != true) goto L9;
    }

    public final void o() {
        RedDotDelegate r100 = this.f112466a;
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = r100.c();
        Boolean r102 = Boolean.FALSE;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = r100.f157079e;
        if (r103 == null) goto L9;
        com.bytedance.android.livesdk.sharedpref.f.d(r103, 0);
        return;
    L9:
        return;
    }

    public final RedDotDelegate getRedDot() {
        return this.f112466a;
    }

    public final void setAnchor(boolean r100) {
        this.f112468c = r100;
    }

    public final void setRedDot(RedDotDelegate r100) {
        this.f112466a = r100;
    }

    public final void setShowing(boolean r100) {
        this.f112467b = r100;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r100) {
        if (r100 == 0) goto L5;
    L33:
        if (r100 == 0) goto L38;
        RedDotDelegate r101 = this.f112466a;
        if (r101 == null) goto L37;
        r101.f157080f = false;
    L37:
        this.f112467b = false;
    L38:
        super.setVisibility(r100);
        return;
    L5:
        if (getVisibility() == 0) goto L33;
        RedDotDelegate r102 = this.f112466a;
        if (r102 != null) goto L9;
    L11:
        RedDotDelegate r103 = this.f112466a;
        if (r103 == null) goto L18;
        com.bytedance.android.livesdk.reddot.a r104 = r103.f157075a;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L16:
        String r105 = r104.f157083a;
        if (r105 == null) goto L18;
    L19:
        Map<String, String> r106 = MapsKt.mapOf(TuplesKt.to("spot_name", r105));
        if (this.f112468c == false) goto L26;
        Pair[] r107 = new Pair[2];
        r107[0] = TuplesKt.to("spot_title", "礼物");
        if (this.f112468c == false) goto L24;
        String r108 = "anchor";
    L25:
        r107[1] = TuplesKt.to("user_type", r108);
        r106 = MapsKt.plus(r106, MapsKt.mapOf(r107));
        goto L26
    L24:
        r108 = "user";
    L26:
        qm0.b r109 = om0.c.g();
        if (r109 == null) goto L29;
        r109.sendLog("livesdk_room_spot_show", r106, new Object[]{am2.x.class, s80.a.f540946a});
    L29:
        RedDotDelegate r110 = this.f112466a;
        if (r110 == null) goto L32;
        r110.e();
    L32:
        this.f112467b = true;
    L18:
        r105 = "";
        goto L19
    L9:
        if (r102.d() != true) goto L11;
        goto L11
    }

    public final RedDotDelegate n(RedDotDelegate r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dot");
        this.f112466a = r100;
        boolean r102 = false;
        if (r100 == null) goto L5;
        r100.f157080f = false;
    L5:
        if (r101 == null) goto L7;
        r102 = r101.booleanValue();
    L7:
        this.f112468c = r102;
        return this.f112466a;
    }

    public RedDotView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setBackgroundResource(R.drawable.ttlive_ic_red_dot);
    }

    public /* synthetic */ RedDotView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final RedDotDelegate m(com.bytedance.android.livesdk.reddot.a r100, TreeSet<RedDotDelegate> r101, Function0<Boolean> r102, Boolean r103) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f112466a != null) goto L11;
        RedDotDelegate r104 = com.bytedance.android.livesdk.reddot.b.b(r100, r102);
        this.f112466a = r104;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNullParameter(r104, "redDotDelegate");
        Intrinsics.checkNotNullParameter(r101, "dotSet");
        r101.add(r104);
        r104.f157076b = r101;
    L11:
        if (r103 == null) goto L13;
        boolean r105 = r103.booleanValue();
    L14:
        this.f112468c = r105;
        RedDotDelegate r106 = this.f112466a;
        if (r106 == null) goto L17;
        r106.f157080f = false;
    L17:
        return r106;
    L13:
        r105 = false;
        goto L14
    }
}
