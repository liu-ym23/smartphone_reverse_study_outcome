package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/migu/play/d;", "", "<init>", "()V", "", "APP_ID", "Ljava/lang/String;", "APP_KEY", "", Const.INTENT_KEY_APIKEY, "()Z", "isConfigured", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3356d {
    public static final String APP_ID = "bridge_sdk_014313E";
    public static final String APP_KEY = "c64030dd474a3f49";
    public static final C3356d INSTANCE = new C3356d();

    public final boolean a() {
        return APP_ID.length() > 0 && APP_KEY.length() > 0;
    }
}
