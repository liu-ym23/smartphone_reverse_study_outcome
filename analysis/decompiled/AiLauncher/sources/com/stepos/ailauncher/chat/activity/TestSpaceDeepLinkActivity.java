package com.stepos.ailauncher.chat.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/TestSpaceDeepLinkActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TestSpaceDeepLinkActivity extends Activity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/TestSpaceDeepLinkActivity$a;", "", "<init>", "()V", "Landroid/net/Uri;", "uri", "", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;)Z", "Landroid/content/Context;", "context", "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/Intent;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.TestSpaceDeepLinkActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Intent a(Context context, Uri uri) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(uri, "uri");
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setClassName(context, "com.stepos.ailauncher.task.space.RepairActivity");
            return intent;
        }

        public final boolean b(Uri uri) {
            String path;
            kotlin.jvm.internal.p.i(uri, "uri");
            return ((kotlin.jvm.internal.p.d(uri.getScheme(), "stepos") && kotlin.jvm.internal.p.d(uri.getHost(), DidiCardProvider.MARKET_SOURCE)) || (kotlin.jvm.internal.p.d(uri.getScheme(), "https") && kotlin.jvm.internal.p.d(uri.getHost(), "amoo.stepos.com"))) && (path = uri.getPath()) != null && La.D.X(path, "/testspace", false, 2, null);
        }

        public Companion() {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Uri data = intent != null ? intent.getData() : null;
        if (data != null) {
            Companion companion = INSTANCE;
            if (companion.b(data)) {
                Context applicationContext = getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                C2739j.C(applicationContext, companion.a(this, data), null, 4, null);
            }
        }
        finish();
    }
}
