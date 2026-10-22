package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ}\u0010\u001a\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "channelId", "", "seqId", "logId", "service", "method", "", "encoding", "type", "", WsConstants.KEY_PAYLOAD, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "a", "(IJJIILjava/lang/String;Ljava/lang/String;[BLjava/util/HashMap;)V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WsMsgReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11970a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f11970a = new a(null);
    }

    public WsMsgReceiver() {
    }

    public abstract void a(int r10, long r11, long r12, int r13, int r14, String r15, String r16, byte[] r17, HashMap r18);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r21, Intent r22) {
        Log.d("WsMsgReceiver", "onReceive() called with: context = " + r21 + ", intent = " + r22);
        byte[] r10 = null;
        if (r22 == null) goto L5;
        Integer r11 = Integer.valueOf(r22.getIntExtra(WsConstants.KEY_CHANNEL_ID, 0));
    L7:
        if (r22 == null) goto L9;
        Long r12 = Long.valueOf(r22.getLongExtra("seq_id", 0));
    L10:
        if (r22 == null) goto L12;
        Long r13 = Long.valueOf(r22.getLongExtra(ReportProtocal.KEY_LOG_ID, 0));
    L13:
        if (r22 == null) goto L15;
        Integer r14 = Integer.valueOf(r22.getIntExtra("service", 0));
    L16:
        if (r22 == null) goto L18;
        Integer r15 = Integer.valueOf(r22.getIntExtra("method", 0));
    L19:
        if (r22 == null) goto L21;
        Serializable r16 = r22.getSerializableExtra("ws_headers");
    L22:
        if (r16 == null) goto L35;
        HashMap r19 = (HashMap) r16;
        if (r22 == null) goto L26;
        String r17 = r22.getStringExtra("payload_type");
    L27:
        if (r22 == null) goto L29;
        String r18 = r22.getStringExtra("payload_encoding");
    L30:
        if (r22 == null) goto L32;
        r10 = r22.getByteArrayExtra(WsConstants.KEY_PAYLOAD);
    L32:
        q.d(r11);
        int r20 = r11.intValue();
        q.d(r12);
        long r110 = r12.longValue();
        q.d(r13);
        long r111 = r13.longValue();
        q.d(r14);
        int r112 = r14.intValue();
        q.d(r15);
        a(r20, r110, r111, r112, r15.intValue(), r18, r17, r10, r19);
        return;
    L29:
        r18 = null;
        goto L30
    L26:
        r17 = null;
        goto L27
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L21:
        r16 = null;
        goto L22
    L18:
        r15 = null;
        goto L19
    L15:
        r14 = null;
        goto L16
    L12:
        r13 = null;
        goto L13
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }
}
