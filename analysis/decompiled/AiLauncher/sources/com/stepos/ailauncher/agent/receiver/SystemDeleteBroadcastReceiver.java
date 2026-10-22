package com.stepos.ailauncher.agent.receiver;

import La.C0953c;
import La.D;
import La.H;
import Y8.j;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import a5.ReceivedPayload;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.core.app.j;
import androidx.core.app.m;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.receiver.NotifyBody;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.agent.receiver.b;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import h8.C4148a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120 *\b\u0012\u0004\u0012\u00020\u00120 H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120 *\b\u0012\u0004\u0012\u00020\u00120 H\u0002¢\u0006\u0004\b#\u0010\"J#\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120 *\u0004\u0018\u00010\u001b2\u0006\u0010$\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120 *\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u0012H\u0002¢\u0006\u0004\b,\u0010-J'\u0010/\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u00100J;\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012052\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0002¢\u0006\u0004\b6\u00107J9\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/agent/receiver/SystemDeleteBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "f", "e", "Lcom/stepos/ailauncher/agent/receiver/a;", SystemDeleteBroadcastReceiver.KEY_NOTIFY_BODY, "Lcom/stepos/ailauncher/agent/receiver/b$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/agent/receiver/a;)Lcom/stepos/ailauncher/agent/receiver/b$a;", "", "sessionId", "n", "(Landroid/content/Context;Ljava/lang/String;)V", "La5/a;", "p", "(Landroid/content/Context;Landroid/content/Intent;)La5/a;", "Landroid/net/Uri;", SystemDeleteBroadcastReceiver.EXTRA_PAYLOAD_URI, "Lorg/json/JSONObject;", "m", "(Landroid/content/Context;Landroid/net/Uri;)Lorg/json/JSONObject;", "l", "(Landroid/content/Intent;)Landroid/net/Uri;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "key", "r", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/List;", "Lorg/json/JSONArray;", "q", "(Lorg/json/JSONArray;)Ljava/util/List;", "path", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Z", "deleteCount", "k", "(Landroid/content/Context;Ljava/lang/String;Lcom/stepos/ailauncher/agent/receiver/b$a;)V", "", "imageCount", "videoCount", "fileCount", "Lkotlin/Pair;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;III)Lkotlin/Pair;", "c", "(Landroid/content/Context;Ljava/lang/String;III)Landroid/content/Intent;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SystemDeleteBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_ABILITY_NOTIFY = "com.zyql.stepclaw.action.ABILITY_NOTIFY";
    public static final String ACTION_TRASH_HOOK_RUN_FINISHED = "com.zyql.stepclaw.action.TRASH_HOOK_RUN_FINISHED";
    public static final String EXTRA_ALL_PATHS = "allPaths";
    public static final String EXTRA_FILE_PATHS = "filePaths";
    public static final String EXTRA_FILE_PATH_COUNT = "filePathCount";
    public static final String EXTRA_METHODS = "methods";
    public static final String EXTRA_PATH_COUNT = "pathCount";
    public static final String EXTRA_PAYLOAD_MODE = "payloadMode";
    public static final String EXTRA_PAYLOAD_TOKEN = "payloadToken";
    public static final String EXTRA_PAYLOAD_URI = "payloadUri";
    public static final String EXTRA_PHOTO_PATHS = "photoPaths";
    public static final String EXTRA_PHOTO_PATH_COUNT = "photoPathCount";
    public static final String EXTRA_RUN_ID = "runId";
    public static final String EXTRA_SESSION_ID = "sessionId";
    public static final String EXTRA_SESSION_ID_UNDERSCORE = "session_id";
    public static final String EXTRA_SESSION_KEY = "sessionKey";
    public static final String EXTRA_SOURCES = "sources";
    public static final String EXTRA_TERMINAL_STATE = "terminalState";
    public static final String KEY_NOTIFY_BODY = "notifyBody";
    private static final String NOTIFY_CHANNEL_ID = "trash_hook_delete_result_high_v2";
    public static final String PAYLOAD_MODE_INLINE = "inline";
    public static final String PAYLOAD_MODE_POINTER = "pointer";
    private static final String TAG = "SystemDeleteReceiver";

    public static final t o(String str, SystemDeleteBroadcastReceiver systemDeleteBroadcastReceiver, Context context, String it) {
        p.i(it, "it");
        a5.b.INSTANCE.b(str);
        b.DeleteCount deleteCountG = b.INSTANCE.g(str);
        y yVar = y.f34840a;
        String str2 = String.format("received session complete callback, sessionId=%s, finalCount=%s", Arrays.copyOf(new Object[]{str, deleteCountG == null ? "(none)" : deleteCountG}, 2));
        p.h(str2, "format(...)");
        C4148a.k(TAG, str2, false, 4, null);
        if (deleteCountG != null) {
            systemDeleteBroadcastReceiver.k(context, str, deleteCountG);
        }
        return t.f7040a;
    }

    public final Pair<String, String> b(Context context, int imageCount, int videoCount, int fileCount) {
        String str;
        List listC = C1172u.c();
        if (imageCount > 0) {
            String string = context.getString(R$string.trash_notify_item_image, Integer.valueOf(imageCount));
            p.h(string, "getString(...)");
            listC.add(string);
        }
        if (videoCount > 0) {
            String string2 = context.getString(R$string.trash_notify_item_video, Integer.valueOf(videoCount));
            p.h(string2, "getString(...)");
            listC.add(string2);
        }
        if (fileCount > 0) {
            String string3 = context.getString(R$string.trash_notify_item_file, Integer.valueOf(fileCount));
            p.h(string3, "getString(...)");
            listC.add(string3);
        }
        List listA = C1172u.a(listC);
        int size = listA.size();
        if (size == 0) {
            str = "";
        } else if (size == 1) {
            Object objQ0 = F.q0(listA);
            p.h(objQ0, "first(...)");
            str = (String) objQ0;
        } else if (size != 2) {
            str = listA.get(0) + "、" + listA.get(1) + "和" + listA.get(2);
        } else {
            str = listA.get(0) + "和" + listA.get(1);
        }
        String string4 = context.getString(R$string.trash_notify_title_deleted, str);
        p.h(string4, "getString(...)");
        return j.a(string4, context.getString(R$string.trash_notify_text_deleted_generic));
    }

    public final Intent c(Context context, String sessionId, int imageCount, int videoCount, int fileCount) {
        Integer num;
        String str;
        boolean z10 = imageCount > 0;
        boolean z11 = videoCount > 0;
        boolean z12 = fileCount > 0;
        String str2 = (z12 && (z10 || z11)) ? "home_with_mixed_types" : (z10 || z11) ? "gallery_only_image_or_video" : z12 ? "file_only" : "none";
        Intent intent = (z12 && (z10 || z11)) ? new Intent("flyme.intent.action.PERMISSION_AND_PRIVACY_MANAGER") : (z10 || z11) ? new Intent("com.stepos.media.gallery.action.ENTER_TRASH_BIN") : z12 ? new Intent("meizu.intent.action.VIEW_ALL_TRASH_FILE") : new Intent("flyme.intent.action.PERMISSION_AND_PRIVACY_MANAGER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        y yVar = y.f34840a;
        String action = intent.getAction();
        if (action == null) {
            action = "(none)";
        }
        String str3 = intent.getPackage();
        if (str3 == null) {
            str3 = "(none)";
        }
        String str4 = String.format("buildTrashJumpIntent, scene=%s sessionId=%s action=%s package=%s", Arrays.copyOf(new Object[]{str2, sessionId, action, str3}, 4));
        p.h(str4, "format(...)");
        C4148a.k(TAG, str4, false, 4, null);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        Integer numValueOf = Integer.valueOf(imageCount);
        Integer numValueOf2 = Integer.valueOf(videoCount);
        Integer numValueOf3 = Integer.valueOf(fileCount);
        String action2 = intent.getAction();
        if (action2 == null) {
            action2 = "(none)";
        }
        String str5 = intent.getPackage();
        if (str5 == null) {
            str = "(none)";
            num = numValueOf3;
        } else {
            num = numValueOf3;
            str = str5;
        }
        String str6 = String.format("trash notify target activity not found, sessionId=%s imageCount=%d videoCount=%d fileCount=%d action=%s package=%s", Arrays.copyOf(new Object[]{sessionId, numValueOf, numValueOf2, num, action2, str}, 6));
        p.h(str6, "format(...)");
        C4148a.u(TAG, str6, false, 4, null);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            String str7 = String.format("fallback app launch intent is null, sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            p.h(str7, "format(...)");
            C4148a.h(TAG, str7, false, 4, null);
            return null;
        }
        launchIntentForPackage.addFlags(335544320);
        launchIntentForPackage.putExtra("extra_from_trash_hook_notify", true);
        launchIntentForPackage.putExtra("extra_session_id", sessionId);
        String str8 = String.format("fallback to app launch intent, sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
        p.h(str8, "format(...)");
        C4148a.k(TAG, str8, false, 4, null);
        return launchIntentForPackage;
    }

    public final void d(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            return;
        }
        if (notificationManager.getNotificationChannel(NOTIFY_CHANNEL_ID) != null) {
            y yVar = y.f34840a;
            String str = String.format("notification channel already exists, channelId=%s", Arrays.copyOf(new Object[]{NOTIFY_CHANNEL_ID}, 1));
            p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFY_CHANNEL_ID, context.getString(R$string.trash_notify_channel_name), 4);
        notificationChannel.setDescription(context.getString(R$string.trash_notify_channel_description));
        notificationChannel.enableVibration(true);
        notificationChannel.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannel);
        y yVar2 = y.f34840a;
        String str2 = String.format("notification channel created, channelId=%s", Arrays.copyOf(new Object[]{NOTIFY_CHANNEL_ID}, 1));
        p.h(str2, "format(...)");
        C4148a.k(TAG, str2, false, 4, null);
    }

    public final void e(Context context, Intent intent) {
        Object objB;
        String string;
        String string2;
        try {
            Result.Companion companion = Result.INSTANCE;
            String stringExtra = intent.getStringExtra("session_id");
            string = stringExtra != null ? H.D1(stringExtra).toString() : null;
            if (string == null || string.length() == 0) {
                string = null;
            }
            if (string == null) {
                String stringExtra2 = intent.getStringExtra("sessionId");
                string = stringExtra2 != null ? H.D1(stringExtra2).toString() : null;
                if (string == null || string.length() == 0) {
                    string = null;
                }
                if (string == null) {
                    throw new IllegalStateException("missing session_id/sessionId in ABILITY_NOTIFY");
                }
            }
            String stringExtra3 = intent.getStringExtra(KEY_NOTIFY_BODY);
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            string2 = H.D1(stringExtra3).toString();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (string2.length() <= 0) {
            throw new IllegalArgumentException("missing notifyBody in ABILITY_NOTIFY");
        }
        y yVar = y.f34840a;
        String str = String.format("onReceive get notifyBodyRaw=%s", Arrays.copyOf(new Object[]{string2}, 1));
        p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        NotifyBody notifyBodyA = NotifyBody.INSTANCE.a(string2);
        if (notifyBodyA.a().isEmpty()) {
            String str2 = String.format("ABILITY_NOTIFY ignored because notifyBody.data is empty, sessionId=%s", Arrays.copyOf(new Object[]{string}, 1));
            p.h(str2, "format(...)");
            C4148a.u(TAG, str2, false, 4, null);
            return;
        }
        b.DeleteCount deleteCountH = h(notifyBodyA);
        if (deleteCountH.getImageCount() <= 0 && deleteCountH.getVideoCount() <= 0 && deleteCountH.getFileCount() <= 0) {
            String str3 = String.format("ABILITY_NOTIFY ignored because all count delta <= 0, sessionId=%s, notifyBody=%s", Arrays.copyOf(new Object[]{string, string2}, 2));
            p.h(str3, "format(...)");
            C4148a.u(TAG, str3, false, 4, null);
            return;
        }
        String str4 = String.format("ability-notify parsed sessionId=%s +image=%d +video=%d +file=%d total=%s", Arrays.copyOf(new Object[]{string, Integer.valueOf(deleteCountH.getImageCount()), Integer.valueOf(deleteCountH.getVideoCount()), Integer.valueOf(deleteCountH.getFileCount()), b.INSTANCE.c(string, deleteCountH.getImageCount(), deleteCountH.getFileCount(), deleteCountH.getVideoCount())}, 5));
        p.h(str4, "format(...)");
        C4148a.k(TAG, str4, false, 4, null);
        n(context, string);
        objB = Result.b(t.f7040a);
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "ability-notify receiver failed to resolve payload", thE, false, 8, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123 A[Catch: all -> 0x0166, TryCatch #0 {all -> 0x0166, blocks: (B:3:0x0004, B:5:0x0011, B:13:0x0024, B:17:0x0052, B:21:0x005a, B:25:0x00d4, B:29:0x00dd, B:32:0x00eb, B:36:0x0106, B:38:0x0123, B:40:0x0144, B:39:0x012b, B:12:0x001f), top: B:48:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012b A[Catch: all -> 0x0166, TryCatch #0 {all -> 0x0166, blocks: (B:3:0x0004, B:5:0x0011, B:13:0x0024, B:17:0x0052, B:21:0x005a, B:25:0x00d4, B:29:0x00dd, B:32:0x00eb, B:36:0x0106, B:38:0x0123, B:40:0x0144, B:39:0x012b, B:12:0x001f), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.content.Context r34, android.content.Intent r35) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver.f(android.content.Context, android.content.Intent):void");
    }

    public final boolean g(String path) {
        String strQ1 = H.q1(path, '.', "");
        Locale US = Locale.US;
        p.h(US, "US");
        String lowerCase = strQ1.toLowerCase(US);
        p.h(lowerCase, "toLowerCase(...)");
        if (H.x0(lowerCase)) {
            return false;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        return D.X(mimeTypeFromExtension != null ? mimeTypeFromExtension : "", "image/", false, 2, null);
    }

    public final b.DeleteCount h(NotifyBody notifyBody) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (NotifyBody.NotifyBodyItem notifyBodyItem : notifyBody.a()) {
            int deletedNumber = notifyBodyItem.getDeletedNumber();
            if (deletedNumber > 0) {
                String type = notifyBodyItem.getType();
                Locale US = Locale.US;
                p.h(US, "US");
                String lowerCase = type.toLowerCase(US);
                p.h(lowerCase, "toLowerCase(...)");
                if (H.g0(lowerCase, "image", false, 2, null) || H.g0(lowerCase, "photo", false, 2, null) || H.g0(lowerCase, "pic", false, 2, null)) {
                    i10 += deletedNumber;
                } else if (H.g0(lowerCase, "video", false, 2, null)) {
                    i11 += deletedNumber;
                } else {
                    if (!H.g0(lowerCase, Const.STR_FILE, false, 2, null) && !H.g0(lowerCase, ChatTracker.CONTENT_DOC, false, 2, null) && !H.g0(lowerCase, "text", false, 2, null)) {
                        y yVar = y.f34840a;
                        String str = String.format("unknown notifyBody.type=%s, fallback to file count", Arrays.copyOf(new Object[]{notifyBodyItem.getType()}, 1));
                        p.h(str, "format(...)");
                        C4148a.u(TAG, str, false, 4, null);
                    }
                    i12 += deletedNumber;
                }
            }
        }
        return new b.DeleteCount(i10, i11, i12);
    }

    public final List<String> i(List<String> list) {
        return j(list);
    }

    public final List<String> j(List<String> list) {
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void k(Context context, String sessionId, b.DeleteCount deleteCount) {
        String str;
        String action;
        int imageCount = deleteCount.getImageCount();
        int videoCount = deleteCount.getVideoCount();
        int fileCount = deleteCount.getFileCount();
        if (imageCount <= 0 && videoCount <= 0 && fileCount <= 0) {
            y yVar = y.f34840a;
            String str2 = String.format("skip notify because image/video/file count are all zero, sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            p.h(str2, "format(...)");
            C4148a.u(TAG, str2, false, 4, null);
            return;
        }
        if (androidx.core.content.a.a(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            y yVar2 = y.f34840a;
            String str3 = String.format("skip notify delete result because POST_NOTIFICATIONS not granted, sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            p.h(str3, "format(...)");
            C4148a.u(TAG, str3, false, 4, null);
            return;
        }
        d(context);
        Pair<String, String> pairB = b(context, imageCount, videoCount, fileCount);
        String strA = pairB.a();
        String strB = pairB.b();
        Intent intentC = c(context, sessionId, imageCount, videoCount, fileCount);
        PendingIntent activity = intentC != null ? PendingIntent.getActivity(context, sessionId.hashCode(), intentC, 201326592) : null;
        Resources resources = context.getResources();
        int i10 = R$drawable.icon_app_note;
        Notification notificationB = new j.d(context, NOTIFY_CHANNEL_ID).p(i10).m(BitmapFactory.decodeResource(resources, i10)).j(strA).i(strB).q(new j.b().h(strB)).e(true).o(1).f("event").k(-1).h(activity).b();
        p.h(notificationB, "build(...)");
        m.b(context).d(sessionId.hashCode(), notificationB);
        y yVar3 = y.f34840a;
        String str4 = String.format("notifyDeleteResult posted, sessionId=%s imageCount=%d videoCount=%d fileCount=%d contentTitle=%s clickIntentAction=%s clickIntentPackage=%s", Arrays.copyOf(new Object[]{sessionId, Integer.valueOf(imageCount), Integer.valueOf(videoCount), Integer.valueOf(fileCount), strA, (intentC == null || (action = intentC.getAction()) == null) ? "(none)" : action, (intentC == null || (str = intentC.getPackage()) == null) ? "(none)" : str}, 7));
        p.h(str4, "format(...)");
        C4148a.k(TAG, str4, false, 4, null);
    }

    public final Uri l(Intent intent) {
        return (Uri) intent.getParcelableExtra(EXTRA_PAYLOAD_URI, Uri.class);
    }

    public final JSONObject m(Context context, Uri payloadUri) throws IOException {
        if (payloadUri == null) {
            throw new IllegalStateException("missing payloadUri");
        }
        y yVar = y.f34840a;
        String str = String.format("read pointer payload, uri=%s", Arrays.copyOf(new Object[]{payloadUri}, 1));
        p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(payloadUri);
        if (inputStreamOpenInputStream != null) {
            try {
                String strE = l9.m.e(new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD));
                l9.b.a(inputStreamOpenInputStream, null);
                if (strE != null) {
                    JSONObject jSONObject = new JSONObject(strE);
                    String str2 = String.format("pointer payload parsed, uri=%s photoCount=%d fileCount=%d allCount=%d", Arrays.copyOf(new Object[]{payloadUri, Integer.valueOf(r(jSONObject, EXTRA_PHOTO_PATHS).size()), Integer.valueOf(r(jSONObject, EXTRA_FILE_PATHS).size()), Integer.valueOf(r(jSONObject, EXTRA_ALL_PATHS).size())}, 4));
                    p.h(str2, "format(...)");
                    C4148a.k(TAG, str2, false, 4, null);
                    return jSONObject;
                }
            } finally {
            }
        }
        throw new IllegalStateException(("failed to open payloadUri=" + payloadUri).toString());
    }

    public final void n(final Context context, final String sessionId) {
        if (!a5.b.INSTANCE.a(sessionId)) {
            y yVar = y.f34840a;
            String str = String.format("awaitSessionComplete already registered, sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            return;
        }
        y yVar2 = y.f34840a;
        String str2 = String.format("register awaitSessionComplete callback, sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
        p.h(str2, "format(...)");
        C4148a.k(TAG, str2, false, 4, null);
        AgentConfig.INSTANCE.a().n().A0(sessionId, new InterfaceC5074l() { // from class: a5.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SystemDeleteBroadcastReceiver.o(sessionId, this, context, (String) obj);
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    @SuppressLint({"MissingPermission"})
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            C4148a.u(TAG, "onReceive ignored because context is null", false, 4, null);
            return;
        }
        if (intent == null) {
            C4148a.u(TAG, "onReceive ignored because intent is null", false, 4, null);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (!p.d(action, ACTION_TRASH_HOOK_RUN_FINISHED) && !p.d(action, ACTION_ABILITY_NOTIFY)) {
            y yVar = y.f34840a;
            String action2 = intent.getAction();
            if (action2 == null) {
                action2 = "(null)";
            }
            String str = String.format("onReceive ignored because action not match, action=%s", Arrays.copyOf(new Object[]{action2}, 1));
            p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            return;
        }
        if (C5.b.a(context, this, "system_delete")) {
            y yVar2 = y.f34840a;
            String str2 = String.format("onReceive start, action=%s hasExtras=%s", Arrays.copyOf(new Object[]{action, Boolean.valueOf(intent.getExtras() != null)}, 2));
            p.h(str2, "format(...)");
            C4148a.k(TAG, str2, false, 4, null);
            if (p.d(action, ACTION_TRASH_HOOK_RUN_FINISHED)) {
                f(context, intent);
            } else if (p.d(action, ACTION_ABILITY_NOTIFY)) {
                e(context, intent);
            }
        }
    }

    public final ReceivedPayload p(Context context, Intent intent) throws IOException {
        JSONObject jSONObjectM;
        List listI;
        List listI2;
        List<String> listI3;
        String stringExtra = intent.getStringExtra(EXTRA_SESSION_KEY);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String string = H.D1(stringExtra).toString();
        if (string.length() <= 0) {
            throw new IllegalArgumentException("missing sessionKey");
        }
        String stringExtra2 = intent.getStringExtra(EXTRA_PAYLOAD_MODE);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String string2 = H.D1(stringExtra2).toString();
        if (string2.length() <= 0) {
            throw new IllegalArgumentException("missing payloadMode");
        }
        Uri uriL = l(intent);
        if (p.d(string2, "inline")) {
            jSONObjectM = null;
        } else {
            if (!p.d(string2, PAYLOAD_MODE_POINTER)) {
                throw new IllegalStateException(("unsupported payloadMode=" + string2).toString());
            }
            jSONObjectM = m(context, uriL);
        }
        if (p.d(string2, "inline")) {
            List<String> stringArrayListExtra = intent.getStringArrayListExtra(EXTRA_PHOTO_PATHS);
            if (stringArrayListExtra == null) {
                stringArrayListExtra = C1173v.m();
            }
            listI = i(stringArrayListExtra);
        } else {
            listI = p.d(string2, PAYLOAD_MODE_POINTER) ? i(r(jSONObjectM, EXTRA_PHOTO_PATHS)) : C1173v.m();
        }
        if (p.d(string2, "inline")) {
            List<String> stringArrayListExtra2 = intent.getStringArrayListExtra(EXTRA_FILE_PATHS);
            if (stringArrayListExtra2 == null) {
                stringArrayListExtra2 = C1173v.m();
            }
            listI2 = i(stringArrayListExtra2);
        } else {
            listI2 = p.d(string2, PAYLOAD_MODE_POINTER) ? i(r(jSONObjectM, EXTRA_FILE_PATHS)) : C1173v.m();
        }
        if (p.d(string2, "inline")) {
            List<String> stringArrayListExtra3 = intent.getStringArrayListExtra(EXTRA_ALL_PATHS);
            if (stringArrayListExtra3 == null) {
                stringArrayListExtra3 = C1173v.m();
            }
            listI3 = i(stringArrayListExtra3);
        } else {
            listI3 = p.d(string2, PAYLOAD_MODE_POINTER) ? i(r(jSONObjectM, EXTRA_ALL_PATHS)) : C1173v.m();
        }
        if (listI.isEmpty()) {
            listI = new ArrayList();
            for (Object obj : listI3) {
                if (g((String) obj)) {
                    listI.add(obj);
                }
            }
        }
        List list = listI;
        if (listI2.isEmpty()) {
            listI2 = new ArrayList();
            for (Object obj2 : listI3) {
                if (!g((String) obj2)) {
                    listI2.add(obj2);
                }
            }
        }
        List list2 = listI2;
        String stringExtra3 = intent.getStringExtra("sessionId");
        String string3 = stringExtra3 != null ? H.D1(stringExtra3).toString() : null;
        String str = (string3 == null || string3.length() == 0) ? null : string3;
        String stringExtra4 = intent.getStringExtra(EXTRA_RUN_ID);
        String string4 = stringExtra4 != null ? H.D1(stringExtra4).toString() : null;
        if (string4 == null || string4.length() == 0) {
            string4 = null;
        }
        String stringExtra5 = intent.getStringExtra(EXTRA_TERMINAL_STATE);
        String str2 = stringExtra5 == null ? "" : stringExtra5;
        String stringExtra6 = intent.getStringExtra(EXTRA_PAYLOAD_TOKEN);
        String string5 = stringExtra6 != null ? H.D1(stringExtra6).toString() : null;
        String str3 = (string5 == null || string5.length() == 0) ? null : string5;
        int intExtra = intent.getIntExtra(EXTRA_PATH_COUNT, list.size() + list2.size());
        int intExtra2 = intent.getIntExtra(EXTRA_PHOTO_PATH_COUNT, list.size());
        int intExtra3 = intent.getIntExtra(EXTRA_FILE_PATH_COUNT, list2.size());
        List<String> stringArrayListExtra4 = intent.getStringArrayListExtra(EXTRA_SOURCES);
        if (stringArrayListExtra4 == null) {
            stringArrayListExtra4 = C1173v.m();
        }
        List<String> listJ = j(stringArrayListExtra4);
        List<String> stringArrayListExtra5 = intent.getStringArrayListExtra(EXTRA_METHODS);
        if (stringArrayListExtra5 == null) {
            stringArrayListExtra5 = C1173v.m();
        }
        return new ReceivedPayload(string, str, string4, str2, string2, str3, uriL, intExtra, intExtra2, intExtra3, listJ, j(stringArrayListExtra5), list, list2);
    }

    public final List<String> q(JSONArray jSONArray) {
        if (jSONArray == null) {
            return C1173v.m();
        }
        List listC = C1172u.c();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            String strOptString = jSONArray.optString(i10);
            p.h(strOptString, "optString(...)");
            String string = H.D1(strOptString).toString();
            if (string.length() > 0) {
                listC.add(string);
            }
        }
        return C1172u.a(listC);
    }

    public final List<String> r(JSONObject jSONObject, String str) {
        return q(jSONObject != null ? jSONObject.optJSONArray(str) : null);
    }
}
