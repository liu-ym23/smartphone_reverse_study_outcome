package e2;

import android.content.Context;
import b2.C0366a;
import d2.C0537b;
import d2.c;
import d2.d;
import d2.f;
import d2.g;

/* loaded from: classes.dex */
public interface b {
    void onMessage(Context context, String str, String str2);

    void onNotificationArrived(Context context, C0366a c0366a);

    void onNotificationClicked(Context context, C0366a c0366a);

    void onPushStatus(Context context, C0537b c0537b);

    void onRegisterStatus(Context context, c cVar);

    void onSubAliasStatus(Context context, d dVar);

    void onSubTagsStatus(Context context, f fVar);

    void onUnRegisterStatus(Context context, g gVar);
}
