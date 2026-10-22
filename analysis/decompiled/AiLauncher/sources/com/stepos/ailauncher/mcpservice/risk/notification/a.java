package com.stepos.ailauncher.mcpservice.risk.notification;

import La.H;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.mcpservice.R$color;
import com.stepos.ailauncher.mcpservice.R$drawable;
import com.stepos.ailauncher.mcpservice.R$id;
import com.stepos.ailauncher.mcpservice.R$layout;
import com.stepos.ailauncher.mcpservice.R$string;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementButton;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementParams;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J=\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\n¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J1\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b0\u00101J;\u00102\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0015H\u0002¢\u0006\u0004\b8\u0010,R\u0014\u00109\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010=\u001a\u00020<8\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/notification/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "", "notificationId", "Landroid/app/PendingIntent;", "contentIntent", "", "dismissOnAction", "pinned", "operation", "Landroid/os/Bundle;", "capsuleOverride", "LY8/t;", "l", "(Landroid/content/Context;Lcom/stepos/ailauncher/mcpservice/risk/p;ILandroid/app/PendingIntent;ZZILandroid/os/Bundle;)V", "", "requestId", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)V", "e", "(Landroid/content/Context;I)V", "buttonId", "requestCode", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)Landroid/app/PendingIntent;", "text", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "style", "", "n", "(Landroid/content/Context;Ljava/lang/String;Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;)Ljava/lang/CharSequence;", "Landroid/graphics/drawable/Icon;", "icon", "pendingIntent", "Landroid/app/Notification$Action;", "f", "(Landroid/content/Context;Landroid/graphics/drawable/Icon;Ljava/lang/String;Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;Ljava/lang/String;Landroid/app/PendingIntent;)Landroid/app/Notification$Action;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)V", "Landroid/content/Intent;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/mcpservice/risk/p;ZILandroid/os/Bundle;)Landroid/os/Bundle;", "capsule", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Landroid/os/Bundle;)V", "level", "k", "TAG", "Ljava/lang/String;", "CHANNEL_ID", "", "TIMEOUT_AFTER_MS", "J", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private static final String CHANNEL_ID = "risk_statement_live_silent";
    public static final a INSTANCE = new a();
    private static final String TAG = "RiskStatementLiveNotif";
    private static final long TIMEOUT_AFTER_MS = 14400000;

    public static /* synthetic */ PendingIntent c(a aVar, Context context, String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 0;
        }
        return aVar.b(context, str, str2, i10, i11);
    }

    public static /* synthetic */ void m(a aVar, Context context, RiskStatementParams riskStatementParams, int i10, PendingIntent pendingIntent, boolean z10, boolean z11, int i11, Bundle bundle, int i12, Object obj) {
        Bundle bundle2;
        a aVar2;
        Context context2;
        RiskStatementParams riskStatementParams2;
        if ((i12 & 4) != 0) {
            i10 = aVar.g(riskStatementParams.getRequestId());
        }
        int i13 = i10;
        PendingIntent pendingIntent2 = (i12 & 8) != 0 ? null : pendingIntent;
        boolean z12 = (i12 & 16) != 0 ? true : z10;
        boolean z13 = (i12 & 32) != 0 ? true : z11;
        int i14 = (i12 & 64) != 0 ? 0 : i11;
        if ((i12 & 128) != 0) {
            bundle2 = null;
            aVar2 = aVar;
            riskStatementParams2 = riskStatementParams;
            context2 = context;
        } else {
            bundle2 = bundle;
            aVar2 = aVar;
            context2 = context;
            riskStatementParams2 = riskStatementParams;
        }
        aVar2.l(context2, riskStatementParams2, i13, pendingIntent2, z12, z13, i14, bundle2);
    }

    public final Bundle a(Context context, RiskStatementParams params, boolean pinned, int operation, Bundle capsuleOverride) {
        Bundle bundle = new Bundle();
        bundle.putInt("notification.live.operation", operation);
        bundle.putInt("notification.live.type", 9);
        bundle.putBoolean("notification.live.pinned", pinned);
        bundle.putBoolean("notification.live.feature.progressHide", true);
        bundle.putString("notification.live.titleOverlay", params.getTitle());
        bundle.putString("notification.live.contentOverlay", params.getBody());
        bundle.putString("notification.live.next.state.text", context.getString(R$string.risk_live_next_state_continue_task));
        bundle.putString("notification.live.task.state.desc", context.getString(R$string.risk_live_task_state_waiting));
        bundle.putString("notification.live.event", "LIVE_PENDING");
        bundle.putParcelable("notification.live.iconOverlay", Icon.createWithResource(context, R$drawable.risk_live_capsule_icon_pending_right));
        a aVar = INSTANCE;
        int iC = androidx.core.content.a.c(context, aVar.k(params.getRiskLevel()));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("notification.live.capsuleStatus", 1);
        bundle2.putInt("notification.live.capsuleType", 9);
        bundle2.putParcelable("notification.live.capsuleIcon", Icon.createWithResource(context, R$drawable.risk_live_capsule_icon_pending));
        bundle2.putInt("notification.live.capsuleBgColor", iC);
        bundle2.putInt("notification.live.capsuleContentColor", -1);
        bundle2.putString("notification.live.capsuleContent", params.getTitle());
        bundle2.putBoolean("notification.live.capsuleRemind", false);
        aVar.j(context, bundle2);
        if (capsuleOverride != null) {
            bundle2.putAll(capsuleOverride);
        }
        bundle.putBundle("notification.live.capsule", bundle2);
        List<RiskStatementButton> listF = b.f(params.b());
        int size = listF.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = androidx.core.content.a.c(context, b.a(listF.get(i10).getStyle()));
        }
        bundle.putIntArray("notification.live.permission.button.bg.colors", iArr);
        int size2 = listF.size();
        int[] iArr2 = new int[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            iArr2[i11] = androidx.core.content.a.c(context, b.b(listF.get(i11).getStyle()));
        }
        bundle.putIntArray("notification.live.permission.button.text.colors", iArr2);
        return bundle;
    }

    public final PendingIntent b(Context context, String requestId, String buttonId, int requestCode, int notificationId) {
        p.i(context, "context");
        p.i(requestId, "requestId");
        p.i(buttonId, "buttonId");
        Context applicationContext = context.getApplicationContext();
        p.f(applicationContext);
        PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, requestCode, i(applicationContext, requestId, notificationId, buttonId), 201326592);
        p.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    public final void d(Context context, String requestId) {
        p.i(context, "context");
        p.i(requestId, "requestId");
        e(context, g(requestId));
    }

    public final void e(Context context, int notificationId) {
        p.i(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager != null) {
            notificationManager.cancel(notificationId);
        }
    }

    public final Notification.Action f(Context context, Icon icon, String text, RiskStatementButton.Style style, String buttonId, PendingIntent pendingIntent) {
        p.i(context, "context");
        p.i(icon, "icon");
        p.i(text, "text");
        p.i(style, "style");
        p.i(buttonId, "buttonId");
        p.i(pendingIntent, "pendingIntent");
        Notification.Action.Builder builder = new Notification.Action.Builder(icon, n(context, text, style), pendingIntent);
        Bundle bundle = new Bundle();
        bundle.putInt("notification.live.action.bg.color", androidx.core.content.a.c(context, b.a(style)));
        builder.addExtras(bundle);
        Notification.Action actionBuild = builder.build();
        p.h(actionBuild, "build(...)");
        return actionBuild;
    }

    public final int g(String requestId) {
        return C5685n.f(requestId.hashCode() & Integer.MAX_VALUE, 1);
    }

    public final void h(Context context) {
        Object systemService = context.getSystemService("notification");
        p.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, context.getString(R$string.risk_channel_name_mcp), 4);
        notificationChannel.setDescription(context.getString(R$string.risk_channel_desc_mcp));
        notificationChannel.setShowBadge(true);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    public final Intent i(Context context, String requestId, int notificationId, String buttonId) {
        Intent intent = new Intent(context, (Class<?>) RiskStatementActionReceiver.class);
        intent.setAction(RiskStatementActionReceiver.ACTION);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extra_request_id", requestId);
        intent.putExtra(RiskStatementActionReceiver.EXTRA_NOTIFICATION_ID, notificationId);
        if (buttonId != null && !H.x0(buttonId)) {
            intent.putExtra(RiskStatementActionReceiver.EXTRA_BUTTON_ID, buttonId);
        }
        if (buttonId == null) {
            buttonId = "cancel";
        }
        intent.setData(Uri.parse("risk-statement://" + requestId + "/" + buttonId));
        return intent;
    }

    public final void j(Context context, Bundle capsule) {
        String packageName = context.getPackageName();
        int i10 = R$layout.risk_live_capsule_remote_icon;
        RemoteViews remoteViews = new RemoteViews(packageName, i10);
        int i11 = R$id.capsule_remote_icon;
        remoteViews.setImageViewResource(i11, R$drawable.risk_live_capsule_icon_pending);
        t tVar = t.f7040a;
        capsule.putParcelable("notification.live.capsule.remote.view.left", remoteViews);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), i10);
        remoteViews2.setImageViewResource(i11, R$drawable.risk_live_capsule_icon_pending_right);
        capsule.putParcelable("notification.live.capsule.remote.view.right", remoteViews2);
    }

    public final int k(String level) {
        String lowerCase = level.toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return p.d(lowerCase, "high") ? R$color.risk_level_dot_high : p.d(lowerCase, "low") ? R$color.risk_level_dot_low : R$color.risk_level_dot_medium;
    }

    public final void l(Context context, RiskStatementParams params, int notificationId, PendingIntent contentIntent, boolean dismissOnAction, boolean pinned, int operation, Bundle capsuleOverride) {
        p.i(context, "context");
        p.i(params, "params");
        Context applicationContext = context.getApplicationContext();
        p.f(applicationContext);
        h(applicationContext);
        Object systemService = applicationContext.getSystemService("notification");
        p.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        Icon iconCreateWithResource = Icon.createWithResource(UxipConstants.f30662a, R.color.transparent);
        p.h(iconCreateWithResource, "createWithResource(...)");
        Object obj = null;
        Notification.Builder timeoutAfter = new Notification.Builder(applicationContext, CHANNEL_ID).setContentTitle(params.getTitle()).setContentText(params.getBody()).setSmallIcon(R$drawable.ic_risk_notification).setContentIntent(contentIntent == null ? PendingIntent.getBroadcast(applicationContext, notificationId, i(applicationContext, params.getRequestId(), notificationId, null), 201326592) : contentIntent).setOngoing(true).setOnlyAlertOnce(!pinned).setTimeoutAfter(14400000L);
        p.h(timeoutAfter, "setTimeoutAfter(...)");
        int i10 = dismissOnAction ? notificationId : 0;
        int i11 = 0;
        for (Object obj2 : b.f(params.b())) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            RiskStatementButton riskStatementButton = (RiskStatementButton) obj2;
            int i13 = (notificationId * 31) + i11 + 1;
            a aVar = INSTANCE;
            PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, i13, aVar.i(applicationContext, params.getRequestId(), i10, riskStatementButton.getId()), 201326592);
            String text = riskStatementButton.getText();
            RiskStatementButton.Style style = riskStatementButton.getStyle();
            String id = riskStatementButton.getId();
            p.f(broadcast);
            timeoutAfter.addAction(aVar.f(applicationContext, iconCreateWithResource, text, style, id, broadcast));
            i11 = i12;
            i10 = i10;
            obj = null;
        }
        Object obj3 = obj;
        timeoutAfter.addExtras(a(applicationContext, params, pinned, operation, capsuleOverride));
        try {
            notificationManager.notify(notificationId, timeoutAfter.build());
            String requestId = params.getRequestId();
            String title = params.getTitle();
            List<RiskStatementButton> listB = params.b();
            ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(((RiskStatementButton) it.next()).getId());
            }
            C4148a.k(TAG, "live notification shown | requestId=" + requestId + ", notificationId=" + notificationId + ", pinned=" + pinned + ", operation=" + operation + ", title=" + title + ", buttons=" + arrayList, false, 4, obj3);
        } catch (Throwable th) {
            C4148a.g(TAG, "live notification failed | requestId=" + params.getRequestId(), th, false, 8, null);
        }
    }

    public final CharSequence n(Context context, String text, RiskStatementButton.Style style) {
        p.i(context, "context");
        p.i(text, "text");
        p.i(style, "style");
        int iB = b.b(style);
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.a.c(context, iB)), 0, spannableString.length(), 33);
        return spannableString;
    }
}
