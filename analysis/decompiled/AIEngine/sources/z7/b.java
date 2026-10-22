package z7;

import android.content.Context;
import y7.c;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface b {
    void onMessage(Context context, String str, String str2);

    void onNotificationArrived(Context context, u7.a aVar);

    void onNotificationClicked(Context context, u7.a aVar);

    void onPushStatus(Context context, y7.a aVar);

    void onRegisterStatus(Context context, y7.b bVar);

    void onSubAliasStatus(Context context, c cVar);

    void onSubTagsStatus(Context context, d dVar);

    void onUnRegisterStatus(Context context, e eVar);
}
