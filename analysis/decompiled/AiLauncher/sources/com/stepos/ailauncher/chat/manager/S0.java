package com.stepos.ailauncher.chat.manager;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/manager/S0;", "", "<init>", "()V", "", "text", "", "Landroid/net/Uri;", "uris", "LY8/t;", "e", "(Ljava/lang/String;Ljava/util/List;)V", "", "c", "()Z", "reason", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)Z", "Lcom/stepos/ailauncher/chat/manager/S0$a;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/manager/S0$a;", "TAG", "Ljava/lang/String;", "", "TTL_MS", "J", AuthSessionDto.STATUS_PENDING, "Lcom/stepos/ailauncher/chat/manager/S0$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S0 {
    private static final String TAG = "SystemSharePending";
    private static volatile Payload pending;
    public static final S0 INSTANCE = new S0();
    private static final long TTL_MS = TimeUnit.MINUTES.toMillis(5);

    public final synchronized void a(String reason) {
        try {
            kotlin.jvm.internal.p.i(reason, "reason");
            if (pending != null) {
                Log.d(TAG, "clear reason=" + reason);
            }
            pending = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Payload b() {
        Payload payload = pending;
        if (payload == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - payload.getCreatedAt();
        if (jElapsedRealtime <= TTL_MS) {
            return payload;
        }
        Log.d(TAG, "expired age=" + jElapsedRealtime + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        pending = null;
        return null;
    }

    public final synchronized boolean c() {
        return b() != null;
    }

    public final synchronized boolean d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Payload payloadB = b();
        if (payloadB == null) {
            return false;
        }
        Log.d(TAG, "resumeWake uriCount=" + payloadB.c().size());
        WakeService.Companion companion = WakeService.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        companion.K1(applicationContext, payloadB.getText(), payloadB.c());
        return true;
    }

    public final synchronized void e(String text, List<? extends Uri> uris) {
        try {
            kotlin.jvm.internal.p.i(uris, "uris");
            pending = new Payload((text == null || La.H.x0(text)) ? null : text, uris, 0L, 4, null);
            int length = text != null ? text.length() : 0;
            Log.d(TAG, "stash textLen=" + length + " uriCount=" + uris.size());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/S0$a;", "", "", "text", "", "Landroid/net/Uri;", "uris", "", "createdAt", "<init>", "(Ljava/lang/String;Ljava/util/List;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "c", "()Ljava/util/List;", "J", Const.INTENT_KEY_APIKEY, "()J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.S0$a, reason: from toString */
    public static final /* data */ class Payload {
        private final long createdAt;
        private final String text;
        private final List<Uri> uris;

        /* JADX WARN: Multi-variable type inference failed */
        public Payload(String str, List<? extends Uri> uris, long j10) {
            kotlin.jvm.internal.p.i(uris, "uris");
            this.text = str;
            this.uris = uris;
            this.createdAt = j10;
        }

        /* renamed from: a, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final List<Uri> c() {
            return this.uris;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Payload)) {
                return false;
            }
            Payload payload = (Payload) other;
            return kotlin.jvm.internal.p.d(this.text, payload.text) && kotlin.jvm.internal.p.d(this.uris, payload.uris) && this.createdAt == payload.createdAt;
        }

        public int hashCode() {
            String str = this.text;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.uris.hashCode()) * 31) + Long.hashCode(this.createdAt);
        }

        public String toString() {
            return "Payload(text=" + this.text + ", uris=" + this.uris + ", createdAt=" + this.createdAt + ")";
        }

        public /* synthetic */ Payload(String str, List list, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, list, (i10 & 4) != 0 ? SystemClock.elapsedRealtime() : j10);
        }
    }
}
