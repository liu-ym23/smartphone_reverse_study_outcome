package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.TopicDismissTrigger;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface m {

    public interface a {
        void a(TriggerKey r100);
    }

    public interface b {
        TopicDismissTrigger a(DataCenter r100, b6.b r101);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f133451a;

        public c() {
            this.f133451a = new ArrayList();
        }
    }

    void a(a r100);

    void b(b6.b r100);

    void release();
}
