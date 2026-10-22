package n2;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3974a;

    public a(Application application) {
        if (application == null) {
            throw new IllegalArgumentException("context is null");
        }
        TextUtils.isEmpty("basic");
        this.f3974a = application.getApplicationContext();
        new ArrayList();
    }
}
