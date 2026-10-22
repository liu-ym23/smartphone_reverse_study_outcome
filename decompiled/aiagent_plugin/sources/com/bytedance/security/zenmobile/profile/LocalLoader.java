package com.bytedance.security.zenmobile.profile;

import android.content.Context;
import com.bytedance.security.zenmobile.helpers.ResourceLoader;
import com.bytedance.security.zenmobile.io.Profile;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class LocalLoader {
    static final String RESOURCE_FORMAT = "zen-profiles/%s.json";

    public LocalLoader() {
    }

    public Profile getProfile(Context r2, String r3) {
        return Profile.fromJson(ResourceLoader.loadString((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), String.format(RESOURCE_FORMAT, new Object[]{r3})));
    }

    public Profile getProfile(Context r4, String[] r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Profile[] r0 = new Profile[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L7;
        r0[r1] = getProfile(r6, r5[r1]);
        r1 = r1 + 1;
        goto L4
    L7:
        return Profile.mergeProfiles(r0);
    }
}
