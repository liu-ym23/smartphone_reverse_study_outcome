package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.message.model.n5;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/ui/GiftMarqueeView;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftMarqueeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f78505a;

    public GiftMarqueeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftMarqueeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f78505a != null) goto L5;
        this.f78505a = new LinkedHashMap();
    L5:
        View r101 = this.f78505a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f78505a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(n5 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "giftMessage");
        if (r101 == false) goto L5;
        TextView r102 = (TextView) a(R.id.tv_gift_count);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r102.setText(String.format("x%s", Arrays.copyOf(new Object[]{Long.valueOf(r100.getRepeatCount())}, 1)));
        return;
    L5:
        h1 r104 = r100.getGift();
        if (r104 == null) goto L10;
        k r105 = r104.getImage();
        if (r105 == null) goto L10;
        ImageUtil.loadImage((ImageView) a(R.id.gift_icon), r105, 0);
    L10:
        TextView r106 = (TextView) a(R.id.tv_from_user);
        IBaseUser r107 = r100.getFromUser();
        String r108 = "";
        if (r107 == null) goto L15;
        String r109 = r107.getNickName();
        if (r109 == null) goto L15;
    L16:
        r106.setText(r109);
        TextView r110 = (TextView) a(R.id.tv_to_user);
        IBaseUser r111 = r100.getToUser();
        if (r111 == null) goto L21;
        String r112 = r111.getNickName();
        if (r112 == null) goto L21;
        r108 = r112;
    L21:
        r110.setText(r108);
        TextView r113 = (TextView) a(R.id.tv_gift_count);
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        r113.setText(String.format("x%s", Arrays.copyOf(new Object[]{Long.valueOf(r100.getRepeatCount())}, 1)));
        return;
    L15:
        r109 = "";
        goto L16
    }

    public GiftMarqueeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f78505a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_guest_link_gift_marquee_view, this, true);
    }

    public /* synthetic */ GiftMarqueeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
