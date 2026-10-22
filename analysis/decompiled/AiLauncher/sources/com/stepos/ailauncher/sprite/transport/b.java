package com.stepos.ailauncher.sprite.transport;

import android.content.Intent;
import android.os.IBinder;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sprite.transport.ISpriteTransport;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/b;", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportService;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Companion", Const.INTENT_KEY_APIKEY, "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends SpriteTransportService {
    private static final a Companion = new a(null);
    private static final String TAG = "SecuredSpriteTransport";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/b$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Override // com.stepos.ailauncher.sprite.transport.SpriteTransportService, android.app.Service
    public IBinder onBind(Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action == null || p.d(action, SpriteConstants.ACTION_BIND)) {
            ISpriteTransport iSpriteTransportAsInterface = ISpriteTransport.Stub.asInterface(super.onBind(intent));
            return iSpriteTransportAsInterface == null ? com.stepos.ailauncher.sprite.transport.a.INSTANCE : new CheckedSpriteTransportBinder(this, iSpriteTransportAsInterface);
        }
        C4148a.u(TAG, "onBind rejected: unexpected action", false, 4, null);
        return com.stepos.ailauncher.sprite.transport.a.INSTANCE;
    }
}
