package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/CommonIconEntryView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonIconEntryView extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public CommonIconEntryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonIconEntryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(String r100, q.a r101) {
        Intrinsics.checkNotNullParameter(r100, "bgImageUrl");
        HSImageView r102 = new HSImageView(getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrescoLoader.with(r102.getContext()).load(r100).actualScaleType(ImageView.ScaleType.FIT_XY).into(r102);
        Unit r103 = Unit.INSTANCE;
        addView(r102);
        if (r101 == null) goto L15;
        int r104 = r101.baseWidth;
        if (r104 > 0) goto L7;
    L9:
        List<q.a.C0939a> r105 = r101.layers;
        if (r105 == null) goto L17;
        Iterator<T> r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L18;
        q.a.C0939a r107 = (q.a.C0939a) r106.next();
        ImageView r108 = new HSImageView(getContext());
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r107.width), UtilityKotlinExtentionsKt.i(r107.height));
        r109.leftMargin = UtilityKotlinExtentionsKt.i(r107.f58927x);
        r109.topMargin = UtilityKotlinExtentionsKt.i(r107.f58928y);
        Unit r110 = Unit.INSTANCE;
        r108.setLayoutParams(r109);
        FrescoLoader.with(r108.getContext()).load(r107.url).cornersRadius(UtilityKotlinExtentionsKt.i(r107.radius)).actualScaleType(ImageView.ScaleType.FIT_XY).into(r108);
        addView(r108);
        goto L13
    L18:
        return;
    L17:
        return;
    L7:
        if (r101.baseHeight <= 0) goto L9;
        UIUtils.updateLayout(this, UtilityKotlinExtentionsKt.i(r104), UtilityKotlinExtentionsKt.i(r101.baseHeight));
        goto L9
    }

    public CommonIconEntryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(80), UtilityKotlinExtentionsKt.i(96)));
    }

    public /* synthetic */ CommonIconEntryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
