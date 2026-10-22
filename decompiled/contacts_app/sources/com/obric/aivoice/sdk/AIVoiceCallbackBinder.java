package com.obric.aivoice.sdk;

import android.os.Bundle;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.data.IdlKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AIVoiceCallbackBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder;", "Lcom/obric/aivoice/AIVoiceListener$Stub;", "()V", "getVersion", "", "onAsrResponse", "taskId", "", "resp", "onResult", "", ApmTrafficStats.TTNET_RESPONSE, "Landroid/os/Bundle;", "onTtsResponse", "data", "", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceCallbackBinder extends AIVoiceListener.Stub {
    public static final Companion Companion = null;
    public static final String TAG = "AIVoiceCallbackBinder";
    private static final int VERSION = 1;

    /* JADX INFO: compiled from: AIVoiceCallbackBinder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder$Companion;", "", "()V", "TAG", "", VCardConstants.PROPERTY_VERSION, "", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int getVersion() {
        return 1;
    }

    public AIVoiceCallbackBinder() {
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int onAsrResponse(String r3, String r4) {
        String r2 = r3;
        boolean r0 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L18;
        String r6 = r4;
        if (r6 != null) goto L13;
    L16:
        if (r0 == true) goto L18;
        AIVoiceTask.INSTANCE.onAsrResult(r3, r4);
        goto L18
    L13:
        if (r6.length() == 0) goto L16;
        r0 = false;
    L18:
        return 0;
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int onTtsResponse(String r3, byte[] r4, String r5) {
        String r2 = r3;
        boolean r1 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L25;
        if (r4 == null) goto L25;
        if (r4.length != 0) goto L14;
        boolean r7 = true;
    L16:
        if ((!r7) == false) goto L25;
        String r8 = r5;
        if (r8 != null) goto L20;
    L23:
        if (r1 == true) goto L25;
        AIVoiceTask.INSTANCE.onTtsResult(r3, r4, r5);
        goto L25
    L20:
        if (r8.length() == 0) goto L23;
        r1 = false;
        goto L23
    L14:
        r7 = false;
    L25:
        return 0;
    L5:
        if (r2.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public void onResult(Bundle r2) {
        Integer r1 = null;
        if (r2 == null) goto L5;
        Boolean r0 = Boolean.valueOf(r2.getBoolean(IdlKeys.Args_OfflineServerStatus));
    L6:
        if (r2 == null) goto L8;
        r1 = Integer.valueOf(r2.getInt(IdlKeys.Args_OfflineWorkMode));
    L8:
        if (r0 == null) goto L12;
        if (r1 == null) goto L13;
        AIVoiceManagerInner.INSTANCE.onOfflineStatusChanged(r0.booleanValue(), r1.intValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
