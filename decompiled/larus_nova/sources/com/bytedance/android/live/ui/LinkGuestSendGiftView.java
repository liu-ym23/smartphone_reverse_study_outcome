package com.bytedance.android.live.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.bk1;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import j40.l2;
import j40.n0;
import j40.n1;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R0\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/ui/LinkGuestSendGiftView;", "Landroid/widget/FrameLayout;", "", "resId", "", "setBackground", "Lcom/bytedance/android/live/core/widget/HSImageView;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getFansTicketIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "fansTicketIcon", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "getGuestSendGiftContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "guestSendGiftContainer", "", "value", "f", "Z", "getAllowSendGift", "()Z", "setAllowSendGift", "(Z)V", "getAllowSendGift$annotations", "()V", "allowSendGift", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LinkGuestSendGiftView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f101954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f101955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m<String, View> f101956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f101957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f101958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f101959f;

    public LinkGuestSendGiftView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LinkGuestSendGiftView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Deprecated(message = "Please use 'setVisibility' to set visibility")
    public static /* synthetic */ void getAllowSendGift$annotations() {
    }

    private final HSImageView getFansTicketIcon() {
        return (HSImageView) this.f101957d.getValue();
    }

    private final ConstraintLayout getGuestSendGiftContainer() {
        return (ConstraintLayout) this.f101958e.getValue();
    }

    public boolean a() {
        if ((n0.f497267a.getValue().intValue() & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getAllowSendGift() {
        return this.f101959f;
    }

    public final void b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (this.f101954a == false) goto L14;
    L15:
        this.f101954a = false;
        this.f101956c.update(r100);
        this.f101955b = r100;
        return;
    L14:
        if ((true ^ Intrinsics.areEqual(this.f101955b, r100)) == true) goto L15;
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void c(int r100) {
        UIUtils.updateLayout(getFansTicketIcon(), r100, r100);
        this.f101956c.a();
    }

    public final void setAllowSendGift(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        this.f101959f = r100;
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public final void setBackground(int r100) {
        getGuestSendGiftContainer().setBackgroundResource(r100);
    }

    public LinkGuestSendGiftView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f101954a = true;
        this.f101955b = "0";
        this.f101957d = LazyKt.lazy(new LinkGuestSendGiftView$fansTicketIcon$2(this));
        if (a() == false) goto L5;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_link_guest_send_gift_view_v2, this);
        this.f101956c = new u(this);
    L6:
        rs1.d r103 = l2.f497257a.getValue();
        if (r103 != null) goto L9;
        ImageLoader.bindDrawableResource(getFansTicketIcon(), R.drawable.ttlive_link_guest_gift_default_icon);
    L21:
        this.f101958e = LazyKt.lazy(new LinkGuestSendGiftView$guestSendGiftContainer$2(this));
        return;
    L9:
        if (n1.f497268a.getValue().booleanValue() == false) goto L11;
        String r104 = r103.b();
    L12:
        if (r104 != null) goto L14;
    L19:
        ImageLoader.bindDrawableResource(getFansTicketIcon(), R.drawable.ttlive_link_guest_gift_default_icon);
        goto L21
    L14:
        if (r104.length() <= 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 != true) goto L19;
        a1.n(getFansTicketIcon(), "https://" + bk1.f119877d + '/' + r104);
        goto L21
    L16:
        r105 = false;
        goto L17
    L11:
        r104 = r103.a();
        goto L12
    L5:
        LayoutInflater.from(r100).inflate(R.layout.ttlive_link_guest_send_gift_view_v1, this);
        this.f101956c = new v(this);
        goto L6
    }

    public /* synthetic */ LinkGuestSendGiftView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
