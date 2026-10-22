package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/view/ChatChannelAvatarView;", "Landroid/widget/FrameLayout;", "", "Lpy/k;", "list", "", "setAvatarData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f134417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f134418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f134419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f134420d;

    public ChatChannelAvatarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatChannelAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setAvatarData(List<? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (r100.isEmpty() == false) goto L6;
        UtilityKotlinExtentionsKt.t(this.f134417a);
        UtilityKotlinExtentionsKt.t(this.f134418b);
        return;
    L6:
        if (r100.size() != 1) goto L9;
        UtilityKotlinExtentionsKt.w(this.f134417a);
        UtilityKotlinExtentionsKt.t(this.f134418b);
        ImageUtil.loadImage(this.f134417a, (k) CollectionsKt.first(r100), 0);
        return;
    L9:
        if (r100.size() < 2) goto L14;
        UtilityKotlinExtentionsKt.t(this.f134417a);
        UtilityKotlinExtentionsKt.w(this.f134418b);
        ImageUtil.loadImage(this.f134420d, (k) CollectionsKt.first(r100), 0);
        ImageUtil.loadImage(this.f134419c, (k) ListProtector.get(r100, 1), 0);
        return;
    }

    public ChatChannelAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.ttlive_chat_channel_avatar, this);
        this.f134417a = (HSImageView) findViewById(R.id.single_avatar);
        this.f134418b = (RelativeLayout) findViewById(R.id.multi_avatar_container);
        this.f134419c = (HSImageView) findViewById(R.id.top_avatar);
        this.f134420d = (HSImageView) findViewById(R.id.bottom_avatar);
    }

    public /* synthetic */ ChatChannelAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
