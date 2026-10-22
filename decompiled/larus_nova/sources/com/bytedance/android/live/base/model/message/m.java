package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import java.util.Comparator;

/* JADX INFO: loaded from: classes45.dex */
public final class m<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f58891a = null;

    static {
        f58891a = new m();
    }

    public m() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return (((EffectiveActivityEmojiGroup) r100).getStartTime() > ((EffectiveActivityEmojiGroup) r101).getStartTime() ? 1 : (((EffectiveActivityEmojiGroup) r100).getStartTime() == ((EffectiveActivityEmojiGroup) r101).getStartTime() ? 0 : -1));
    }
}
