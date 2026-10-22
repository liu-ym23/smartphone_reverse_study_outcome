package com.android.server.notification;

import android.R;
import android.app.ActivityManager;
import android.app.INotificationManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.Uri;
import android.os.Binder;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Slog;
import com.android.server.alwaysonrecord.RequestHolder;
import com.android.server.am.HostingRecord;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.pm.PackageManagerService;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationShellCmd extends ShellCommand {
    public static final String CHANNEL_ID = "shell_cmd";
    public static final int CHANNEL_IMP = 3;
    public static final String CHANNEL_NAME = "Shell command";
    public static final int NOTIFICATION_ID = 2020;
    private static final String NOTIFY_USAGE = "usage: cmd notification post [flags] <tag> <text>\n\nflags:\n  -h|--help\n  -v|--verbose\n  -t|--title <text>\n  -i|--icon <iconspec>\n  -I|--large-icon <iconspec>\n  -S|--style <style> [styleargs]\n  -c|--content-intent <intentspec>\n\nstyles: (default none)\n  bigtext\n  bigpicture --picture <iconspec>\n  inbox --line <text> --line <text> ...\n  messaging --conversation <title> --message <who>:<text> ...\n  media\n\nan <iconspec> is one of\n  file:///data/local/tmp/<img.png>\n  content://<provider>/<path>\n  @[<package>:]drawable/<img>\n  data:base64,<B64DATA==>\n\nan <intentspec> is (broadcast|service|activity) <args>\n  <args> are as described in `am start`";
    private static final String TAG = "NotifShellCmd";
    private static final String USAGE = "usage: cmd notification SUBCMD [args]\n\nSUBCMDs:\n  allow_listener COMPONENT [user_id (current user if not specified)]\n  disallow_listener COMPONENT [user_id (current user if not specified)]\n  allow_assistant COMPONENT [user_id (current user if not specified)]\n  remove_assistant COMPONENT [user_id (current user if not specified)]\n  set_dnd [on|none (same as on)|priority|alarms|all|off (same as all)]\n  allow_dnd PACKAGE [user_id (current user if not specified)]\n  disallow_dnd PACKAGE [user_id (current user if not specified)]\n  reset_assistant_user_set [user_id (current user if not specified)]\n  get_approved_assistant [user_id (current user if not specified)]\n  post [--help | flags] TAG TEXT\n  set_bubbles PACKAGE PREFERENCE (0=none 1=all 2=selected) [user_id (current user if not specified)]\n  set_bubbles_channel PACKAGE CHANNEL_ID ALLOW [user_id (current user if not specified)]\n  list\n  get <notification-key>\n  snooze --for <msec> <notification-key>\n  unsnooze <notification-key>\n  set_exempt_th_force_grouping [true|false]\n  redact_otp_from_untrusted_listeners [true|false]\n";
    private final INotificationManager mBinderService;
    private final NotificationManagerService mDirectService;
    private final PackageManager mPm;

    private static class ShellNls extends NotificationListenerService {
        private static ShellNls sNotificationListenerInstance;
        boolean isConnected;

        /* synthetic */ ShellNls(NotificationShellCmdIA r1) {
            this();
        }

        private ShellNls() {
        }

        static {
            sNotificationListenerInstance = null;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onListenerConnected() {
            super.onListenerConnected();
            sNotificationListenerInstance = this;
            this.isConnected = true;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onListenerDisconnected() {
            this.isConnected = false;
        }

        public static ShellNls getInstance() {
            return sNotificationListenerInstance;
        }
    }

    public NotificationShellCmd(NotificationManagerService service) {
        this.mDirectService = service;
        this.mBinderService = service.getBinderService();
        this.mPm = this.mDirectService.getContext().getPackageManager();
    }

    protected boolean checkShellCommandPermission(int callingUid) {
        if (callingUid != 0) goto L4;
    L7:
        return true;
    L4:
        if (callingUid == 2000) goto L7;
        return false;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L5;
        String callingPackage = null;
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        if (callingUid != 0) goto L309;
        callingPackage = "root";
    L20:
        Binder.restoreCallingIdentity(identity);
        PrintWriter pw = getOutPrintWriter();
        if (checkShellCommandPermission(callingUid) == true) goto L304;
        Slog.e(TAG, "error: permission denied: callingUid=" + callingUid + " callingPackage=" + callingPackage);
        pw.println("error: permission denied: callingUid=" + callingUid + " callingPackage=" + callingPackage);
        return 255;
    L304:
        String r0 = cmd.replace('-', '_');     // Catch: Exception -> L173
        switch(r0.hashCode()) {
            case -2056114370: goto L93;
            case -1736066994: goto L90;
            case -1325770982: goto L87;
            case -1039689911: goto L84;
            case -897610266: goto L81;
            case -432999190: goto L78;
            case -429832618: goto L75;
            case -414550305: goto L72;
            case -11106881: goto L69;
            case 102230: goto L66;
            case 3322014: goto L63;
            case 3446944: goto L60;
            case 212123274: goto L57;
            case 372345636: goto L54;
            case 683492127: goto L51;
            case 1159530975: goto L48;
            case 1257269496: goto L45;
            case 1620016923: goto L42;
            case 1985310653: goto L39;
            case 2110474600: goto L34;
            default: goto L95;
        };
    L95:
        byte r1 = -1;
    L96:
        NotificationShellCmdIA r11 = null;
        switch(r1) {
            case 0: goto L266;
            case 1: goto L262;
            case 2: goto L258;
            case 3: goto L250;
            case 4: goto L242;
            case 5: goto L234;
            case 6: goto L226;
            case 7: goto L222;
            case 8: goto L215;
            case 9: goto L205;
            case 10: goto L201;
            case 11: goto L200;
            case 12: goto L200;
            case 13: goto L195;
            case 14: goto L190;
            case 15: goto L185;
            case 16: goto L177;
            case 17: goto L117;
            case 18: goto L108;
            case 19: goto L100;
            default: goto L99;
        };
    L100:
        String arg = getNextArgRequired();     // Catch: Exception -> L36
        if ("true".equals(arg) == true) goto L106;
        if ("1".equals(arg) == true) goto L106;
        int allow = 0;
    L107:
        Settings.Global.putInt(this.mDirectService.getContext().getContentResolver(), "redact_otp_notifications_from_untrusted_listeners", allow);     // Catch: Exception -> L36
        return 0;
    L106:
        allow = 1;
        goto L107
    L108:
        String arg2 = getNextArgRequired();     // Catch: Exception -> L36
        if ("true".equals(arg2) == true) goto L114;
        if ("1".equals(arg2) == true) goto L114;
        boolean exemptTestHarnessFromForceGrouping = false;
    L115:
        this.mDirectService.setTestHarnessExempted(exemptTestHarnessFromForceGrouping);     // Catch: Exception -> L36
        return 0;
    L114:
        exemptTestHarnessFromForceGrouping = true;
        goto L115
    L117:
        String subflag = getNextArg();     // Catch: Exception -> L173
        if (subflag != null) goto L122;
        subflag = "help";
    L125:
        String flagarg = getNextArg();     // Catch: Exception -> L173
        String key = getNextArg();     // Catch: Exception -> L173
        if (key != null) goto L128;
        subflag = "help";
    L128:
        String criterion = null;
        switch(subflag.hashCode()) {
            case -1992012396: goto L147;
            case -861311717: goto L144;
            case 101577: goto L141;
            case 111443806: goto L138;
            case 383913633: goto L135;
            case 951530927: goto L132;
            default: goto L149;
        };
    L149:
        byte r16 = -1;
    L150:
        switch(r16) {
            case 0: goto L154;
            case 1: goto L154;
            case 2: goto L154;
            case 3: goto L153;
            case 4: goto L153;
            case 5: goto L153;
            default: goto L151;
        };
    L151:
        pw.println("usage: cmd notification snooze (--for <msec> | --context <snooze-criterion-id>) <key>");     // Catch: Exception -> L36
        return 1;
    L153:
        long duration = Long.parseLong(flagarg);     // Catch: Exception -> L36
    L156:
        if (duration > 0) goto L162;
        if (criterion != null) goto L162;
        pw.println("error: invalid value for --" + subflag + ": " + flagarg);     // Catch: Exception -> L36
        return 1;
    L162:
        ShellNls nls = new ShellNls(r11);     // Catch: Exception -> L173
        nls.registerAsSystemService(this.mDirectService.getContext(), new ComponentName(nls.getClass().getPackageName(), nls.getClass().getName()), ActivityManager.getCurrentUser());     // Catch: Exception -> L173
        if (waitForBind(nls) == true) goto L167;
        pw.println("error: could not bind a listener in time");     // Catch: Exception -> L36
        return 1;
    L167:
        if (duration <= 0) goto L175;
        pw.println(String.format("snoozing <%s> until time: %s", new Object[]{key, new Date(System.currentTimeMillis() + duration)}));     // Catch: Exception -> L171
        nls.snoozeNotification(key, duration);     // Catch: Exception -> L171
    L176:
        waitForSnooze(nls, key);     // Catch: Exception -> L171
        nls.unregisterAsSystemService();     // Catch: Exception -> L171
        waitForUnbind(nls);     // Catch: Exception -> L171
        return 0;
    L175:
        pw.println(String.format("snoozing <%s> until criterion: %s", new Object[]{key, criterion}));     // Catch: Exception -> L171
        nls.snoozeNotification(key, criterion);     // Catch: Exception -> L171
        goto L176
    L154:
        criterion = flagarg;
        duration = 0;
        goto L156
    L132:
        if (subflag.equals("context") == false) goto L313;
        r16 = 0;
        goto L150
    L313:
        r16 = -1;
        goto L150
    L135:
        if (subflag.equals("criterion") == false) goto L314;
        r16 = 2;
        goto L150
    L314:
        r16 = -1;
        goto L150
    L138:
        if (subflag.equals("until") == false) goto L315;
        r16 = 3;
        goto L150
    L315:
        r16 = -1;
        goto L150
    L141:
        if (subflag.equals("for") == false) goto L316;
        r16 = 4;
        goto L150
    L316:
        r16 = -1;
        goto L150
    L144:
        if (subflag.equals("condition") == false) goto L317;
        r16 = 1;
        goto L150
    L317:
        r16 = -1;
        goto L150
    L147:
        if (subflag.equals(RequestHolder.KEY_DURATION) == false) goto L318;
        r16 = 5;
        goto L150
    L318:
        r16 = -1;
        goto L150
    L122:
        if (subflag.startsWith("--") == false) goto L125;
        subflag = subflag.substring(2);     // Catch: Exception -> L36
        goto L125
    L177:
        boolean mute = false;
        String key2 = getNextArgRequired();     // Catch: Exception -> L171
        if ("--mute".equals(key2) == false) goto L181;
        mute = true;
        key2 = getNextArgRequired();     // Catch: Exception -> L171
    L181:
        if (this.mDirectService.mSnoozeHelper.getNotification(key2) == null) goto L183;
        pw.println("unsnoozing: " + key2);     // Catch: Exception -> L171
        this.mDirectService.unsnoozeNotificationInt(key2, null, mute);     // Catch: Exception -> L171
        return 0;
    L183:
        pw.println("error: no snoozed otification matching key: " + key2);     // Catch: Exception -> L171
        return 1;
    L185:
        new StringBuilder();     // Catch: Exception -> L171
        SnoozeHelper sh = this.mDirectService.mSnoozeHelper;     // Catch: Exception -> L171
        Iterator<NotificationRecord> r5 = sh.getSnoozed().iterator();     // Catch: Exception -> L171
    L187:
        if (r5.hasNext() == false) goto L324;
        NotificationRecord nr = r5.next();     // Catch: Exception -> L171
        String pkg = nr.getSbn().getPackageName();     // Catch: Exception -> L171
        String key3 = nr.getKey();     // Catch: Exception -> L171
        pw.println(key3 + " snoozed, time=" + sh.getSnoozeTimeForUnpostedNotification(nr.getUserId(), pkg, key3) + " context=" + sh.getSnoozeContextForUnpostedNotification(nr.getUserId(), pkg, key3));     // Catch: Exception -> L171
        goto L187
    L324:
        return 0;
    L190:
        String key4 = getNextArgRequired();     // Catch: Exception -> L171
        NotificationRecord nr2 = this.mDirectService.getNotificationRecord(key4);     // Catch: Exception -> L171
        if (nr2 == null) goto L193;
        nr2.dump(pw, "", this.mDirectService.getContext(), false);     // Catch: Exception -> L171
        return 0;
    L193:
        pw.println("error: no active notification matching key: " + key4);     // Catch: Exception -> L171
        return 1;
    L195:
        Iterator<String> r2 = this.mDirectService.mNotificationsByKey.keySet().iterator();     // Catch: Exception -> L171
    L197:
        if (r2.hasNext() == false) goto L326;
        pw.println(r2.next());     // Catch: Exception -> L171
        goto L197
    L326:
        return 0;
    L200:
        doNotify(pw, callingPackage, callingUid);     // Catch: Exception -> L171
        return 0;
    L201:
        String packageName = getNextArgRequired();     // Catch: Exception -> L171
        String channelId = getNextArgRequired();     // Catch: Exception -> L171
        boolean allow2 = Boolean.parseBoolean(getNextArgRequired());     // Catch: Exception -> L171
        int userId = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L204;
        userId = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L204:
        NotificationChannel channel = this.mBinderService.getNotificationChannel(callingPackage, userId, packageName, channelId);     // Catch: Exception -> L171
        channel.setAllowBubbles(allow2);     // Catch: Exception -> L171
        int appUid = UserHandle.getUid(userId, this.mPm.getPackageUid(packageName, 0));     // Catch: Exception -> L171
        this.mBinderService.updateNotificationChannelForPackage(packageName, appUid, channel);     // Catch: Exception -> L171
        return 0;
    L205:
        String packageName2 = getNextArgRequired();     // Catch: Exception -> L171
        int preference = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
        if (preference > 3) goto L213;
        if (preference < 0) goto L213;
        int userId2 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L212;
        userId2 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L212:
        int appUid2 = UserHandle.getUid(userId2, this.mPm.getPackageUid(packageName2, 0));     // Catch: Exception -> L171
        this.mBinderService.setBubblesAllowed(packageName2, appUid2, preference);     // Catch: Exception -> L171
        return 0;
    L213:
        pw.println("Invalid preference - must be between 0-3 (0=none 1=all 2=selected)");     // Catch: Exception -> L171
        return -1;
    L215:
        int userId3 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L218;
        userId3 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L218:
        ComponentName approvedAssistant = this.mDirectService.getApprovedAssistant(userId3);     // Catch: Exception -> L171
        if (approvedAssistant != null) goto L221;
        pw.println("null");     // Catch: Exception -> L171
        return 0;
    L221:
        pw.println(approvedAssistant.flattenToString());     // Catch: Exception -> L171
        return 0;
    L222:
        int userId4 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L225;
        userId4 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L225:
        this.mDirectService.resetAssistantUserSet(userId4);     // Catch: Exception -> L171
        return 0;
    L226:
        ComponentName cn = ComponentName.unflattenFromString(getNextArgRequired());     // Catch: Exception -> L171
        if (cn != null) goto L230;
        pw.println("Invalid assistant - must be a ComponentName");     // Catch: Exception -> L171
        return -1;
    L230:
        int userId5 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L233;
        userId5 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L233:
        this.mBinderService.setNotificationAssistantAccessGrantedForUser(cn, userId5, false);     // Catch: Exception -> L171
        return 0;
    L234:
        ComponentName cn2 = ComponentName.unflattenFromString(getNextArgRequired());     // Catch: Exception -> L171
        if (cn2 != null) goto L238;
        pw.println("Invalid assistant - must be a ComponentName");     // Catch: Exception -> L171
        return -1;
    L238:
        int userId6 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L241;
        userId6 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L241:
        this.mBinderService.setNotificationAssistantAccessGrantedForUser(cn2, userId6, true);     // Catch: Exception -> L171
        return 0;
    L242:
        ComponentName cn3 = ComponentName.unflattenFromString(getNextArgRequired());     // Catch: Exception -> L171
        if (cn3 != null) goto L246;
        pw.println("Invalid listener - must be a ComponentName");     // Catch: Exception -> L171
        return -1;
    L246:
        int userId7 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L249;
        userId7 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L249:
        this.mBinderService.setNotificationListenerAccessGrantedForUser(cn3, userId7, false, true);     // Catch: Exception -> L171
        return 0;
    L250:
        ComponentName cn4 = ComponentName.unflattenFromString(getNextArgRequired());     // Catch: Exception -> L171
        if (cn4 != null) goto L254;
        pw.println("Invalid listener - must be a ComponentName");     // Catch: Exception -> L171
        return -1;
    L254:
        int userId8 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L257;
        userId8 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L257:
        this.mBinderService.setNotificationListenerAccessGrantedForUser(cn4, userId8, true, true);     // Catch: Exception -> L171
        return 0;
    L258:
        String packageName3 = getNextArgRequired();     // Catch: Exception -> L171
        int userId9 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L261;
        userId9 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L261:
        this.mBinderService.setNotificationPolicyAccessGrantedForUser(packageName3, userId9, false);     // Catch: Exception -> L171
        return 0;
    L262:
        String packageName4 = getNextArgRequired();     // Catch: Exception -> L171
        int userId10 = ActivityManager.getCurrentUser();     // Catch: Exception -> L171
        if (peekNextArg() == null) goto L265;
        userId10 = Integer.parseInt(getNextArgRequired());     // Catch: Exception -> L171
    L265:
        this.mBinderService.setNotificationPolicyAccessGrantedForUser(packageName4, userId10, true);     // Catch: Exception -> L171
        return 0;
    L266:
        String mode = getNextArgRequired();     // Catch: Exception -> L171
        int interruptionFilter = 0;
        switch(mode.hashCode()) {
            case -1415196606: goto L285;
            case -1165461084: goto L282;
            case 3551: goto L279;
            case 96673: goto L276;
            case 109935: goto L273;
            case 3387192: goto L270;
            default: goto L287;
        };     // Catch: Exception -> L171
    L287:
        byte r10 = -1;
    L288:
        switch(r10) {
            case 0: goto L293;
            case 1: goto L293;
            case 2: goto L292;
            case 3: goto L291;
            case 4: goto L290;
            case 5: goto L290;
            default: goto L294;
        };     // Catch: Exception -> L171
    L290:
        interruptionFilter = 1;
        goto L294
    L291:
        interruptionFilter = 4;
        goto L294
    L292:
        interruptionFilter = 2;
        goto L294
    L293:
        interruptionFilter = 3;
    L294:
        int filter = interruptionFilter;
        this.mBinderService.setInterruptionFilter(callingPackage, filter, true);     // Catch: Exception -> L171
        return 0;
    L270:
        if (mode.equals("none") == false) goto L287;
        r10 = 0;
        goto L288
    L273:
        if (mode.equals("off") == false) goto L287;
        r10 = 5;
        goto L288
    L276:
        if (mode.equals(IZswContentProviderHelper.DUMP_ALL) == false) goto L287;
        r10 = 4;
        goto L288
    L279:
        if (mode.equals("on") == false) goto L287;
        r10 = 1;
        goto L288
    L282:
        if (mode.equals("priority") == false) goto L287;
        r10 = 2;
        goto L288
    L285:
        if (mode.equals("alarms") == false) goto L287;
        r10 = 3;
        goto L288
    L99:
        return handleDefaultCommands(cmd);
    L171:
        e = e;
    L296:
        pw.println("Error occurred. Check logcat for details. " + e.getMessage());
        Slog.e(NotificationManagerService.TAG, "Error running shell command", e);
        return 0;
    L34:
        if (r0.equals("allow_assistant") == false) goto L95;
        r1 = 5;
        goto L96
    L39:
        if (r0.equals("set_dnd") == false) goto L95;
        r1 = 0;
        goto L96
    L42:
        if (r0.equals("redact_otp_from_untrusted_listeners") == false) goto L95;
        r1 = ParameterName.FILM_MODE;
        goto L96
    L45:
        if (r0.equals("disallow_listener") == false) goto L95;
        r1 = 4;
        goto L96
    L48:
        if (r0.equals("set_exempt_th_force_grouping") == false) goto L95;
        r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L96
    L51:
        if (r0.equals("reset_assistant_user_set") == false) goto L95;
        r1 = 7;
        goto L96
    L54:
        if (r0.equals("allow_dnd") == false) goto L95;
        r1 = 1;
        goto L96
    L57:
        if (r0.equals("set_bubbles") == false) goto L95;
        r1 = 9;
        goto L96
    L60:
        if (r0.equals("post") == false) goto L95;
        r1 = 11;
        goto L96
    L63:
        if (r0.equals("list") == false) goto L95;
        r1 = 13;
        goto L96
    L66:
        if (r0.equals("get") == false) goto L95;
        r1 = 14;
        goto L96
    L69:
        if (r0.equals("unsnooze") == false) goto L95;
        r1 = 16;
        goto L96
    L72:
        if (r0.equals("get_approved_assistant") == false) goto L95;
        r1 = 8;
        goto L96
    L75:
        if (r0.equals("disallow_dnd") == false) goto L95;
        r1 = 2;
        goto L96
    L78:
        if (r0.equals("allow_listener") == false) goto L95;
        r1 = 3;
        goto L96
    L81:
        if (r0.equals("snooze") == false) goto L95;
        r1 = ParameterName.DE_CONTOUR;
        goto L96
    L84:
        if (r0.equals("notify") == false) goto L95;
        r1 = 12;
        goto L96
    L87:
        if (r0.equals("disallow_assistant") == false) goto L95;
        r1 = 6;
        goto L96
    L90:
        if (r0.equals("set_bubbles_channel") == false) goto L95;
        r1 = 10;
        goto L96
    L93:
        if (r0.equals("snoozed") == false) goto L95;
        r1 = 15;
    L36:
        e = e;
    L173:
        e = e;
        goto L296
    L309:
        String[] packages = this.mPm.getPackagesForUid(callingUid);     // Catch: Throwable -> L9 Exception -> L11
        if (packages == null) goto L20;
        if (packages.length <= 0) goto L20;
        callingPackage = packages[0];     // Catch: Throwable -> L9 Exception -> L11
        goto L20
    L11:
        e = move-exception;
        Slog.e(TAG, "failed to get caller pkg", e);     // Catch: Throwable -> L299
    L299:
        th = th;
    L301:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L9:
        th = th;
        goto L301
    L5:
        return handleDefaultCommands(cmd);
    }

    void ensureChannel(String callingPackage, int callingUid) throws RemoteException {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 3);
        this.mBinderService.createNotificationChannels(callingPackage, new ParceledListSlice(Collections.singletonList(channel)));
        Slog.v(NotificationManagerService.TAG, "created channel: " + this.mBinderService.getNotificationChannel(callingPackage, UserHandle.getUserId(callingUid), callingPackage, CHANNEL_ID));
    }

    Icon parseIcon(Resources res, String encoded) throws IllegalArgumentException {
        if (TextUtils.isEmpty(encoded) == false) goto L6;
        return null;
    L6:
        if (encoded.startsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L9;
        encoded = "file://" + encoded;
    L9:
        if (encoded.startsWith("http:") == false) goto L11;
    L32:
        Uri asUri = Uri.parse(encoded);
        return Icon.createWithContentUri(asUri);
    L11:
        if (encoded.startsWith("https:") == true) goto L32;
        if (encoded.startsWith("content:") == true) goto L32;
        if (encoded.startsWith("file:") == true) goto L32;
        if (encoded.startsWith("android.resource:") == true) goto L32;
        if (encoded.startsWith("@") == false) goto L28;
        int resid = res.getIdentifier(encoded.substring(1), "drawable", PackageManagerService.PLATFORM_PACKAGE_NAME);
        if (resid != 0) goto L24;
    L31:
        return null;
    L24:
        return Icon.createWithResource(res, resid);
    L28:
        if (encoded.startsWith("data:") == false) goto L31;
        byte[] bits = Base64.decode(encoded.substring(encoded.indexOf(44) + 1), 0);
        return Icon.createWithData(bits, 0, bits.length);
    }

    private int doNotify(PrintWriter pw, String callingPackage, int callingUid) throws RemoteException, URISyntaxException {
        Context context = this.mDirectService.getContext();
        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(context, CHANNEL_ID);
        Icon smallIcon = null;
        boolean verbose = false;
        Notification.BigPictureStyle bigPictureStyle = null;
        Notification.BigTextStyle bigTextStyle = null;
        Notification.InboxStyle inboxStyle = null;
        Notification.MessagingStyle messagingStyle = null;
    L3:
        String opt = getNextOption();
        Icon smallIcon2 = smallIcon;
        if (opt == null) goto L208;
        boolean large = false;
        switch(opt.hashCode()) {
            case -1954060697: goto L96;
            case -1613915119: goto L93;
            case -1613324104: goto L90;
            case -1210178960: goto L87;
            case -1183762788: goto L84;
            case -853380573: goto L81;
            case -45879957: goto L78;
            case 1468: goto L75;
            case 1478: goto L72;
            case 1494: goto L69;
            case 1499: goto L66;
            case 1500: goto L63;
            case 1511: goto L60;
            case 1513: goto L57;
            case 3226745: goto L54;
            case 43017097: goto L51;
            case 110371416: goto L48;
            case 704999290: goto L45;
            case 705941520: goto L42;
            case 758833716: goto L39;
            case 808239966: goto L36;
            case 1216250940: goto L33;
            case 1247228052: goto L30;
            case 1270815917: goto L27;
            case 1271769229: goto L24;
            case 1333069025: goto L21;
            case 1333096985: goto L18;
            case 1333192084: goto L15;
            case 1737088994: goto L12;
            case 1993764811: goto L9;
            default: goto L98;
        };
    L98:
        byte r10 = -1;
    L99:
        switch(r10) {
            case 0: goto L206;
            case 1: goto L206;
            case 2: goto L204;
            case 3: goto L204;
            case 4: goto L204;
            case 5: goto L196;
            case 6: goto L196;
            case 7: goto L196;
            case 8: goto L196;
            case 9: goto L196;
            case 10: goto L197;
            case 11: goto L197;
            case 12: goto L197;
            case 13: goto L167;
            case 14: goto L167;
            case 15: goto L167;
            case 16: goto L167;
            case 17: goto L167;
            case 18: goto L136;
            case 19: goto L136;
            case 20: goto L131;
            case 21: goto L131;
            case 22: goto L131;
            case 23: goto L119;
            case 24: goto L114;
            case 25: goto L106;
            case 26: goto L102;
            default: goto L100;
        };
    L102:
        if (messagingStyle == null) goto L105;
        messagingStyle.setConversationTitle(getNextArgRequired());
        inboxStyle = inboxStyle;
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
    L205:
        messagingStyle = messagingStyle;
        inboxStyle = inboxStyle;
        bigPictureStyle = bigPictureStyle;
    L207:
        context = context;
        smallIcon = smallIcon2;
        verbose = verbose;
        goto L3
    L105:
        throw new IllegalArgumentException("--conversation requires --style messaging");
    L106:
        if (messagingStyle == null) goto L112;
        String arg = getNextArgRequired();
        String[] parts = arg.split(":", 2);
        if (parts.length <= 1) goto L110;
        messagingStyle.addMessage(parts[1], System.currentTimeMillis(), parts[0]);
        inboxStyle = inboxStyle;
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
        goto L205
    L110:
        messagingStyle.addMessage(parts[0], System.currentTimeMillis(), new String[]{messagingStyle.getUserDisplayName().toString(), "Them"}[messagingStyle.getMessages().size() % 2]);
        inboxStyle = inboxStyle;
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
        goto L205
    L112:
        throw new IllegalArgumentException("--message requires --style messaging");
    L131:
        inboxStyle = inboxStyle;
        if (bigTextStyle == null) goto L135;
        bigTextStyle.bigText(getNextArgRequired());
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
        goto L205
    L135:
        throw new IllegalArgumentException("--bigtext requires --style bigtext");
    L136:
        Notification.InboxStyle inboxStyle2 = inboxStyle;
        String styleSpec = getNextArgRequired().toLowerCase();
        switch(styleSpec.hashCode()) {
            case -1440008444: goto L152;
            case -114212307: goto L149;
            case -44548098: goto L146;
            case 100344454: goto L143;
            case 103772132: goto L140;
            default: goto L154;
        };
    L154:
        byte r9 = -1;
    L155:
        switch(r9) {
            case 0: goto L165;
            case 1: goto L164;
            case 2: goto L163;
            case 3: goto L159;
            case 4: goto L158;
            default: goto L157;
        };
    L158:
        Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
        builder.setStyle(mediaStyle);
    L166:
        context = context;
        verbose = verbose;
        smallIcon2 = smallIcon2;
        inboxStyle = inboxStyle2;
        goto L207
    L159:
        String name = "You";
        if ("--user".equals(peekNextArg()) == false) goto L162;
        getNextArg();
        name = getNextArgRequired();
    L162:
        messagingStyle = new Notification.MessagingStyle(new Person.Builder().setName(name).build());
        builder.setStyle(messagingStyle);
        goto L166
    L163:
        Notification.InboxStyle inboxStyle3 = new Notification.InboxStyle();
        builder.setStyle(inboxStyle3);
        inboxStyle2 = inboxStyle3;
        goto L166
    L164:
        bigPictureStyle = new Notification.BigPictureStyle();
        builder.setStyle(bigPictureStyle);
        goto L166
    L165:
        bigTextStyle = new Notification.BigTextStyle();
        builder.setStyle(bigTextStyle);
        goto L166
    L157:
        throw new IllegalArgumentException("unrecognized notification style: " + styleSpec);
    L140:
        if (styleSpec.equals("media") == false) goto L256;
        r9 = 4;
        goto L155
    L256:
        r9 = -1;
        goto L155
    L143:
        if (styleSpec.equals("inbox") == false) goto L257;
        r9 = 2;
        goto L155
    L257:
        r9 = -1;
        goto L155
    L146:
        if (styleSpec.equals("bigpicture") == false) goto L258;
        r9 = 1;
        goto L155
    L258:
        r9 = -1;
        goto L155
    L149:
        if (styleSpec.equals("bigtext") == false) goto L259;
        r9 = 0;
        goto L155
    L259:
        r9 = -1;
        goto L155
    L152:
        if (styleSpec.equals("messaging") == false) goto L260;
        r9 = 3;
        goto L155
    L260:
        r9 = -1;
        goto L155
    L167:
        inboxStyle = inboxStyle;
        byte r0 = 1;
        String intentKind = null;
        String r7 = peekNextArg();
        switch(r7.hashCode()) {
            case -1655966961: goto L177;
            case -1618876223: goto L174;
            case 1984153269: goto L171;
            default: goto L179;
        };
    L179:
        r0 = -1;
    L180:
        switch(r0) {
            case 0: goto L182;
            case 1: goto L182;
            case 2: goto L182;
            default: goto L183;
        };
    L182:
        intentKind = getNextArg();
    L183:
        Intent intent = Intent.parseCommandArgs(this, null);
        if (intent.getData() != null) goto L188;
        intent.setData(Uri.parse("xyz:" + System.currentTimeMillis()));
    L188:
        if ("broadcast".equals(intentKind) == false) goto L191;
        PendingIntent pi = PendingIntent.getBroadcastAsUser(context, 0, intent, AudioFormat.DTS_HD, UserHandle.CURRENT);
        messagingStyle = messagingStyle;
    L194:
        builder.setContentIntent(pi);
        goto L205
    L191:
        if (HostingRecord.HOSTING_TYPE_SERVICE.equals(intentKind) == false) goto L193;
        pi = PendingIntent.getService(context, 0, intent, AudioFormat.DTS_HD);
        messagingStyle = messagingStyle;
        goto L194
    L193:
        messagingStyle = messagingStyle;
        pi = PendingIntent.getActivityAsUser(context, 0, intent, AudioFormat.DTS_HD, null, UserHandle.CURRENT);
        goto L194
    L171:
        if (r7.equals(HostingRecord.HOSTING_TYPE_SERVICE) == true) goto L180;
        r0 = -1;
        goto L180
    L174:
        if (r7.equals("broadcast") == false) goto L262;
        r0 = 0;
        goto L180
    L262:
        r0 = -1;
        goto L180
    L177:
        if (r7.equals(HostingRecord.HOSTING_TYPE_ACTIVITY) == false) goto L263;
        r0 = 2;
        goto L180
    L263:
        r0 = -1;
        goto L180
    L196:
        large = true;
        goto L197
    L204:
        inboxStyle = inboxStyle;
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
        builder.setContentTitle(getNextArgRequired());
        goto L205
    L206:
        context = context;
        smallIcon2 = smallIcon2;
        verbose = true;
        bigPictureStyle = bigPictureStyle;
        goto L207
    L114:
        if (inboxStyle == null) goto L117;
        inboxStyle.addLine(getNextArgRequired());
        inboxStyle = inboxStyle;
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
        goto L205
    L117:
        throw new IllegalArgumentException("--line requires --style inbox");
    L119:
        if (bigPictureStyle == null) goto L130;
        String pictureSpec = getNextArgRequired();
        Icon pictureAsIcon = parseIcon(res, pictureSpec);
        if (pictureAsIcon == null) goto L128;
        Drawable d = pictureAsIcon.loadDrawable(context);
        if ((d instanceof BitmapDrawable) == false) goto L126;
        bigPictureStyle.bigPicture(((BitmapDrawable) d).getBitmap());
        inboxStyle = inboxStyle;
        context = context;
        verbose = verbose;
        bigPictureStyle = bigPictureStyle;
        smallIcon2 = smallIcon2;
        messagingStyle = messagingStyle;
        goto L205
    L126:
        throw new IllegalArgumentException("not a bitmap: " + pictureSpec);
    L128:
        throw new IllegalArgumentException("bad picture spec: " + pictureSpec);
    L130:
        throw new IllegalArgumentException("--picture requires --style bigpicture");
    L197:
        String iconSpec = getNextArgRequired();
        Icon icon = parseIcon(res, iconSpec);
        if (icon == null) goto L199;
        if (large == false) goto L203;
        builder.setLargeIcon(icon);
        goto L205
    L203:
        smallIcon2 = icon;
        messagingStyle = messagingStyle;
        inboxStyle = inboxStyle;
        bigPictureStyle = bigPictureStyle;
        goto L207
    L199:
        pw.println("error: invalid icon: " + iconSpec);
        return -1;
    L100:
        pw.println(NOTIFY_USAGE);
        return 0;
    L9:
        if (opt.equals("large-icon") == false) goto L264;
        r10 = 9;
        goto L99
    L264:
        r10 = -1;
        goto L99
    L12:
        if (opt.equals("--verbose") == false) goto L265;
        r10 = 1;
        goto L99
    L265:
        r10 = -1;
        goto L99
    L15:
        if (opt.equals("--line") == false) goto L266;
        r10 = ParameterName.GLOBE_DIMMING;
        goto L99
    L266:
        r10 = -1;
        goto L99
    L18:
        if (opt.equals("--icon") == false) goto L267;
        r10 = 11;
        goto L99
    L267:
        r10 = -1;
        goto L99
    L21:
        if (opt.equals("--help") == false) goto L268;
        r10 = ParameterName.GAMUT_MAPPING;
        goto L99
    L268:
        r10 = -1;
        goto L99
    L24:
        if (opt.equals("--bigtext") == false) goto L269;
        r10 = ParameterName.BLUE_STRETCH;
        goto L99
    L269:
        r10 = -1;
        goto L99
    L27:
        if (opt.equals("--bigText") == false) goto L270;
        r10 = ParameterName.BLACK_STRETCH;
        goto L99
    L270:
        r10 = -1;
        goto L99
    L30:
        if (opt.equals("--largeicon") == false) goto L271;
        r10 = 7;
        goto L99
    L271:
        r10 = -1;
        goto L99
    L33:
        if (opt.equals("--intent") == false) goto L272;
        r10 = 16;
        goto L99
    L272:
        r10 = -1;
        goto L99
    L36:
        if (opt.equals("--picture") == false) goto L273;
        r10 = ParameterName.COLOR_TEMPERATURE;
        goto L99
    L273:
        r10 = -1;
        goto L99
    L39:
        if (opt.equals("largeicon") == false) goto L274;
        r10 = 8;
        goto L99
    L274:
        r10 = -1;
        goto L99
    L42:
        if (opt.equals("--content-intent") == false) goto L275;
        r10 = 14;
        goto L99
    L275:
        r10 = -1;
        goto L99
    L45:
        if (opt.equals("--big-text") == false) goto L276;
        r10 = ParameterName.COLOR_TUNE;
        goto L99
    L276:
        r10 = -1;
        goto L99
    L48:
        if (opt.equals("title") == false) goto L277;
        r10 = 4;
        goto L99
    L277:
        r10 = -1;
        goto L99
    L51:
        if (opt.equals("--wtf") == false) goto L278;
        r10 = ParameterName.PC_MODE;
        goto L99
    L278:
        r10 = -1;
        goto L99
    L54:
        if (opt.equals("icon") == false) goto L279;
        r10 = 12;
        goto L99
    L279:
        r10 = -1;
        goto L99
    L57:
        if (opt.equals("-v") == false) goto L280;
        r10 = 0;
        goto L99
    L280:
        r10 = -1;
        goto L99
    L60:
        if (opt.equals("-t") == false) goto L281;
        r10 = 2;
        goto L99
    L281:
        r10 = -1;
        goto L99
    L63:
        if (opt.equals("-i") == false) goto L282;
        r10 = 10;
        goto L99
    L282:
        r10 = -1;
        goto L99
    L66:
        if (opt.equals("-h") == false) goto L283;
        r10 = ParameterName.LEVEL_RANGE;
        goto L99
    L283:
        r10 = -1;
        goto L99
    L69:
        if (opt.equals("-c") == false) goto L284;
        r10 = 13;
        goto L99
    L284:
        r10 = -1;
        goto L99
    L72:
        if (opt.equals("-S") == false) goto L285;
        r10 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L99
    L285:
        r10 = -1;
        goto L99
    L75:
        if (opt.equals("-I") == false) goto L286;
        r10 = 5;
        goto L99
    L286:
        r10 = -1;
        goto L99
    L78:
        if (opt.equals("--large-icon") == false) goto L287;
        r10 = 6;
        goto L99
    L287:
        r10 = -1;
        goto L99
    L81:
        if (opt.equals("--conversation") == false) goto L288;
        r10 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L99
    L288:
        r10 = -1;
        goto L99
    L84:
        if (opt.equals("intent") == false) goto L289;
        r10 = ParameterName.DE_CONTOUR;
        goto L99
    L289:
        r10 = -1;
        goto L99
    L87:
        if (opt.equals("content-intent") == false) goto L290;
        r10 = 15;
        goto L99
    L290:
        r10 = -1;
        goto L99
    L90:
        if (opt.equals("--title") == false) goto L291;
        r10 = 3;
        goto L99
    L291:
        r10 = -1;
        goto L99
    L93:
        if (opt.equals("--style") == false) goto L292;
        r10 = ParameterName.FILM_MODE;
        goto L99
    L292:
        r10 = -1;
        goto L99
    L96:
        if (opt.equals("--message") == false) goto L293;
        r10 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L99
    L293:
        r10 = -1;
        goto L99
    L208:
        Context context2 = context;
        boolean verbose2 = verbose;
        String tag = getNextArg();
        String text = getNextArg();
        if (tag == null) goto L233;
        if (text == null) goto L233;
        builder.setContentText(text);
        if (smallIcon2 != null) goto L215;
        builder.setSmallIcon(R.drawable.stat_notify_chat);
    L216:
        ensureChannel(callingPackage, callingUid);
        Notification n = builder.build();
        pw.println("posting:\n  " + n);
        Slog.v("NotificationManager", "posting: " + n);
        this.mBinderService.enqueueNotificationWithTag(callingPackage, callingPackage, tag, NOTIFICATION_ID, n, UserHandle.getUserId(callingUid));
        if (verbose2 == false) goto L230;
        NotificationRecord nr = this.mDirectService.findNotificationLocked(callingPackage, tag, NOTIFICATION_ID, UserHandle.getUserId(callingUid));
        NotificationRecord nr2 = nr;
        int tries = 3;
    L219:
        int tries2 = tries - 1;
        if (tries <= 0) goto L227;
        if (nr2 != null) goto L227;
        pw.println("waiting for notification to post...");     // Catch: InterruptedException -> L225
        Thread.sleep(500);     // Catch: InterruptedException -> L225
    L226:
        nr2 = this.mDirectService.findNotificationLocked(callingPackage, tag, NOTIFICATION_ID, UserHandle.getUserId(callingUid));
        tries = tries2;
    L227:
        if (nr2 != null) goto L229;
        pw.println("warning: couldn't find notification after enqueueing");
        return 0;
    L229:
        pw.println("posted: ");
        nr2.dump(pw, "  ", context2, false);
        return 0;
    L230:
        return 0;
    L215:
        builder.setSmallIcon(smallIcon2);
    L233:
        pw.println(NOTIFY_USAGE);
        return -1;
    }

    private void waitForSnooze(ShellNls nls, String key) {
        int i = 0;
    L4:
        if (i >= 20) goto L18;
        StatusBarNotification[] sbns = nls.getSnoozedNotifications();
        int r2 = sbns.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L19;
        StatusBarNotification sbn = sbns[r3];
        if (sbn.getKey().equals(key) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return;
    L19:
        Thread.sleep(100);     // Catch: InterruptedException -> L14
    L16:
        i = i + 1;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private boolean waitForBind(ShellNls nls) {
        int i = 0;
    L4:
        if (i >= 20) goto L15;
        if (nls.isConnected == true) goto L7;
        Thread.sleep(100);     // Catch: InterruptedException -> L12
    L14:
        i = i + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L7:
        Slog.i(TAG, "Bound Shell NLS");
        return true;
    L15:
        return false;
    }

    private void waitForUnbind(ShellNls nls) {
        int i = 0;
    L4:
        if (i >= 10) goto L16;
        if (nls.isConnected == false) goto L7;
        Thread.sleep(100);     // Catch: InterruptedException -> L12
    L14:
        i = i + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L7:
        Slog.i(TAG, "Unbound Shell NLS");
        return;
    }

    public void onHelp() {
        getOutPrintWriter().println(USAGE);
    }
}
