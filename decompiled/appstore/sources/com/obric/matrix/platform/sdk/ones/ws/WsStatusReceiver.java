package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u000fB-\u0012$\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR2\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "Landroid/content/BroadcastReceiver;", "Lkotlin/Function4;", "", "", "", "listener", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "Lkotlin/jvm/functions/Function4;", "b", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WsStatusReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11971b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function4 f11972a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f11971b = new a(null);
    }

    public WsStatusReceiver(Function4 r10) {
        q.g(r10, "listener");
        this.f11972a = r10;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        Log.d("WsStatusReceiver", "onReceive() called with: context = " + r10 + ", intent = " + r11);
        Boolean r12 = null;
        if (r11 == null) goto L5;
        Integer r13 = Integer.valueOf(r11.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r11 == null) goto L8;
        Integer r14 = Integer.valueOf(r11.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r11 == null) goto L11;
        Integer r15 = Integer.valueOf(r11.getIntExtra("ws_connection_state", 0));
    L12:
        if (r11 == null) goto L14;
        r12 = Boolean.valueOf(r11.getBooleanExtra("ws_is_connected", false));
    L14:
        Function4 r16 = this.f11972a;
        q.d(r14);
        q.d(r15);
        q.d(r13);
        q.d(r12);
        r16.invoke(r14, r15, r13, r12);
        return;
    L11:
        r15 = null;
        goto L12
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }
}
