package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import Ac.f;
import Ac.t;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import yc.v;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusApi;", "", "", "thirdUid", "deviceId", "Lyc/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "status", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DidiAuthStatusApi {
    @f("didi/oauth/status")
    Object status(@t("third_uid") String str, @t(Parameters.DEVICE_ID) String str2, InterfaceC4014c<? super v<DidiAuthStatusDto>> interfaceC4014c);
}
