package com.smt.obric.appstore.domain.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedanceos.common.toolbox.j;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.download.base.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/smt/obric/appstore/domain/downloader/ODownloaderReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ODownloaderReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18049a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f18049a = new a(null);
    }

    public ODownloaderReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        q.g(r10, "context");
        q.g(r11, MemorySourceLinkType.INTENT);
        j.n("[AppStatus][ODownloader][ODownloaderReceiver][Callback] onReceive action=" + r11.getAction());
        String r12 = r11.getAction();     // Catch: Exception -> L15
        if (r12 != null) goto L7;
        return;
    L7:
        switch(r12.hashCode()) {
            case -1420842128: goto L26;
            case -1335094989: goto L23;
            case -105954129: goto L20;
            case 752717630: goto L10;
            default: goto L70;
        };
    L70:
        return;
    L10:
        if (r12.equals("com.obric.downloader.action.DOWNLOAD_CORE_ERROR") == false) goto L58;
        DownloadInfo r13 = (DownloadInfo) r11.getParcelableExtra("extra_downloadinfo");     // Catch: Exception -> L15
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L15
        r14.append("[AppStatus][ODownloader][ODownloaderReceiver][Callback] DOWNLOAD_CORE_ERROR，task failed, ");     // Catch: Exception -> L15
        if (r13 == null) goto L17;
        String r15 = c.a(r13);     // Catch: Exception -> L15
    L18:
        r14.append(r15);     // Catch: Exception -> L15
        j.n(r14.toString());     // Catch: Exception -> L15
        return;
    L17:
        r15 = null;
        goto L18
    L58:
        return;
    L20:
        if (r12.equals("com.obric.downloader.action.DOWNLOAD_COMPLETE") == false) goto L60;
    L28:
        DownloadInfo r16 = (DownloadInfo) r11.getParcelableExtra("extra_downloadinfo");     // Catch: Exception -> L15
        if (r16 != null) goto L32;
        j.p("[AppStatus][ODownloader][ODownloaderReceiver][Callback] !!! SDK ERROR !!! onReceive download terminated events, info is null, action=" + r11.getAction());     // Catch: Exception -> L15
        return;
    L32:
        j.n("[AppStatus][ODownloader][ODownloaderReceiver][Callback] onReceive download terminated events, " + c.a(r16) + ", action=" + r11.getAction());     // Catch: Exception -> L15
        String r17 = r11.getAction();     // Catch: Exception -> L15
        if (r17 == null) goto L63;
        int r18 = r17.hashCode();     // Catch: Exception -> L15
        if (r18 == (-1420842128)) goto L50;
        if (r18 == (-1335094989)) goto L46;
        if (r18 == (-105954129)) goto L42;
        return;
    L42:
        if (r17.equals("com.obric.downloader.action.DOWNLOAD_COMPLETE") == false) goto L65;
        ODownloader.f18038a.q(r16);     // Catch: Exception -> L15
        return;
    L65:
        return;
    L46:
        if (r17.equals("com.obric.downloader.action.DOWNLOAD_FAILED") == false) goto L67;
        ODownloader.f18038a.p(r16);     // Catch: Exception -> L15
        return;
    L67:
        return;
    L50:
        if (r17.equals("com.obric.downloader.action.DOWNLOAD_CANCEL") == false) goto L69;
        ODownloader.f18038a.o(r16);     // Catch: Exception -> L15
        return;
    L69:
        return;
    L63:
        return;
    L60:
        return;
    L23:
        if (r12.equals("com.obric.downloader.action.DOWNLOAD_FAILED") == true) goto L28;
        return;
    L26:
        if (r12.equals("com.obric.downloader.action.DOWNLOAD_CANCEL") == true) goto L28;
        return;
    L15:
        e = move-exception;
        j.q("[AppStatus][ODownloader][ODownloaderReceiver][Callback] onReceive exception: ", e);
    }
}
