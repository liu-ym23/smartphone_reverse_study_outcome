package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.core.setting.l3;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;

/* JADX INFO: loaded from: classes8.dex */
public final class x0 extends com.bytedance.android.livesdk.feed.tab.repository.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f124600d = false;

    public static final class a {
        public static NewTabRepository a() {
            return (NewTabRepository) NewTabRepository.f124511d.getValue();
        }

        public static com.bytedance.android.livesdk.feed.tab.repository.l b() {
            if (x0.f124600d == false) goto L6;
            return (NewTabRepository) NewTabRepository.f124511d.getValue();
        L6:
            return com.bytedance.android.livesdk.feed.tab.repository.p.f();
        }
    }

    static {
        f124600d = l3.f65349a.getValue().booleanValue();
    }
}
