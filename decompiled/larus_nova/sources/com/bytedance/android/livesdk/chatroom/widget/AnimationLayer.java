package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AnimationLayer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationLayer extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public AnimationLayer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnimationLayer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public AnimationLayer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, r101, r102);
        FrameLayout r103 = new FrameLayout(getContext());
        r103.setClipChildren(false);
        r103.setTag("no_clip_children_container");
        addView(r103, -1, -1);
    }

    public /* synthetic */ AnimationLayer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
