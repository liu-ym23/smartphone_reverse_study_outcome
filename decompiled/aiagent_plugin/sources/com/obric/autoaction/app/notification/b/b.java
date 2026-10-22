package com.obric.autoaction.app.notification.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: INotificationNotifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: INotificationNotifier.kt */
    public static final class a {
        public static void a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            com.obric.autoaction.app.notification.a.c.f24568a.a().a(r3);
        }

        public static String b(b r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
            String r0 = r5.b();
            if (r0 == null) goto L7;
            return "T/" + r0 + '/' + r5.e();
        L7:
            return "C/" + r5.getClass().getSimpleName() + '/' + r5.e();
        }
    }

    String b();

    String d();

    int e();
}
