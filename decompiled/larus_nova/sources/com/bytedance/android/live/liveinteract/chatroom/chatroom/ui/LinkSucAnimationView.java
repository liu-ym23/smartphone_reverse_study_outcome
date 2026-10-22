package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkSucAnimationView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "Landroid/widget/ImageView;", "guestAvatar", "", "setGuestAvatar", "Landroid/widget/TextView;", "guestName", "setGuestName", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LinkSucAnimationView$a;", "callback", "setCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkSucAnimationView extends HSImageView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f72383j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f72384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f72385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IMatchEffect f72386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f72387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public py.k f72388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f72389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f72390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f72391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f72392i;

    public interface a {
        void g();

        void h();
    }

    public static final class b {
    }

    static {
    }

    public LinkSucAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LinkSucAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f72391h = true;
        this.f72392i = false;
    }

    public static final /* synthetic */ Function0 f(LinkSucAnimationView r100) {
        Function0<Unit> r101 = r100.f72390g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskEnd");
    L5:
        return r101;
    }

    public final void setCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ALogger.i("LinkSucAnimationView", "setCallback, callback=" + r100);
        this.f72389f = r100;
    }

    public final void setGuestAvatar(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "guestAvatar");
        ALogger.i("LinkSucAnimationView", "setGuestAvatar, avatar=" + r100);
        this.f72384a = r100;
    }

    public final void setGuestName(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "guestName");
        ALogger.i("LinkSucAnimationView", "setGuestName, guestName=" + r100);
        this.f72385b = r100;
    }

    public LinkSucAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ LinkSucAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
