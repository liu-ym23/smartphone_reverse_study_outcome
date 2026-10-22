package com.android.server.pm;

import android.R;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.media.AudioFocusInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.audiopolicy.AudioPolicy;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArraySet;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BackgroundUserSoundNotifier {
    private static final String ACTION_DISMISS_NOTIFICATION = "com.android.server.ACTION_DISMISS_NOTIFICATION";
    public static final String ACTION_MUTE_SOUND = "com.android.server.ACTION_MUTE_BG_USER";
    private static final String ACTION_SWITCH_USER = "com.android.server.ACTION_SWITCH_TO_USER";
    private static final String BUSN_CHANNEL_ID = "bg_user_sound_channel";
    private static final String BUSN_CHANNEL_NAME = "BackgroundUserSound";
    private static final boolean DEBUG = false;
    private static final String EXTRA_NOTIFICATION_CLIENT_UID = "com.android.server.EXTRA_CLIENT_UID";
    private static final String LOG_TAG = null;
    BackgroundUserListener mBgUserListener;
    AudioPolicy mFocusControlAudioPolicy;
    int mNotificationClientUid;
    Set<Integer> mNotificationClientUids;
    final NotificationManager mNotificationManager;
    private final Context mSystemUserContext;
    private final UserManager mUserManager;

    final class BackgroundUserListener extends AudioPolicy.AudioPolicyFocusListener {
        final /* synthetic */ BackgroundUserSoundNotifier this$0;

        BackgroundUserListener(BackgroundUserSoundNotifier this$0) {
            this.this$0 = this$0;
        }

        public void onAudioFocusGrant(AudioFocusInfo afi, int requestResult) {
            this.this$0.notifyForegroundUserAboutSoundIfNecessary(afi);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public void onAudioFocusLoss(AudioFocusInfo afi, boolean wasNotified) {
            this.this$0.dismissNotificationIfNecessary(afi.getClientUid());
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m6610$$Nest$fgetmUserManager(BackgroundUserSoundNotifier r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mdismissNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6611$$Nest$mdismissNotification(BackgroundUserSoundNotifier r0, int r1) {
        r0.dismissNotification(r1);
    }

    static {
        LOG_TAG = BackgroundUserSoundNotifier.class.getSimpleName();
    }

    public BackgroundUserSoundNotifier(Context context) {
        this.mNotificationClientUid = -1;
        this.mNotificationClientUids = new ArraySet();
        this.mSystemUserContext = context;
        this.mNotificationManager = (NotificationManager) this.mSystemUserContext.getSystemService(NotificationManager.class);
        this.mUserManager = (UserManager) this.mSystemUserContext.getSystemService(UserManager.class);
        createNotificationChannel();
        setupFocusControlAudioPolicy();
    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(BUSN_CHANNEL_ID, BUSN_CHANNEL_NAME, 4);
        channel.setSound(null, null);
        this.mNotificationManager.createNotificationChannel(channel);
    }

    private void setupFocusControlAudioPolicy() {
        ActivityManager am = (ActivityManager) this.mSystemUserContext.getSystemService(ActivityManager.class);
        registerReceiver(am);
        this.mBgUserListener = new BackgroundUserListener(this);
        AudioPolicy.Builder focusControlPolicyBuilder = new AudioPolicy.Builder(this.mSystemUserContext);
        focusControlPolicyBuilder.setLooper(Looper.getMainLooper());
        focusControlPolicyBuilder.setAudioPolicyFocusListener(this.mBgUserListener);
        this.mFocusControlAudioPolicy = focusControlPolicyBuilder.build();
        int status = ((AudioManager) this.mSystemUserContext.getSystemService(AudioManager.class)).registerAudioPolicy(this.mFocusControlAudioPolicy);
        if (status == 0) goto L6;
        Log.w(LOG_TAG, "Could not register the service's focus control audio policy, error: " + status);
        return;
    }

    BackgroundUserListener getAudioPolicyFocusListener() {
        return this.mBgUserListener;
    }

    private void registerReceiver(final ActivityManager activityManager) {
        BroadcastReceiver backgroundUserNotificationBroadcastReceiver = new AnonymousClass1(this, activityManager);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_MUTE_SOUND);
        filter.addAction(ACTION_SWITCH_USER);
        filter.addAction(ACTION_DISMISS_NOTIFICATION);
        this.mSystemUserContext.registerReceiver(backgroundUserNotificationBroadcastReceiver, filter, 4);
    }

    void muteAlarmSounds(int notificationClientUid) {
        AudioManager audioManager = (AudioManager) this.mSystemUserContext.getSystemService(AudioManager.class);
        if (audioManager == null) goto L13;
        Iterator<AudioPlaybackConfiguration> r1 = audioManager.getActivePlaybackConfigurations().iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        AudioPlaybackConfiguration apc = r1.next();
        if (apc.getClientUid() != notificationClientUid) goto L6;
        if (apc.getPlayerProxy() == null) goto L6;
        apc.getPlayerProxy().stop();
    L13:
        AudioFocusInfo currentAfi = getAudioFocusInfoForNotification(notificationClientUid);
        if (currentAfi == null) goto L24;
        this.mFocusControlAudioPolicy.sendFocusLossAndUpdate(currentAfi);
        return;
    }

    void notifyForegroundUserAboutSoundIfNecessary(AudioFocusInfo afi) throws RemoteException {
        if (afi != null) goto L4;
        return;
    L4:
        Context foregroundContext = this.mSystemUserContext.createContextAsUser(UserHandle.of(ActivityManager.getCurrentUser()), 0);
        int userId = UserHandle.getUserId(afi.getClientUid());
        int usage = afi.getAttributes().getUsage();
        if (this.mUserManager.isProfile(userId) == false) goto L7;
        UserInfo userInfo = this.mUserManager.getProfileParent(userId);
    L8:
        ActivityManager activityManager = (ActivityManager) foregroundContext.getSystemService(ActivityManager.class);
        if (userInfo != null) goto L11;
        return;
    L11:
        if (activityManager.isProfileForeground(userInfo.getUserHandle()) == false) goto L13;
        return;
    L13:
        if (isNotificationShown(afi.getClientUid()) == false) goto L15;
        return;
    L15:
        if (usage != 4) goto L21;
        this.mNotificationClientUids.add(Integer.valueOf(afi.getClientUid()));
        this.mNotificationManager.notifyAsUser(LOG_TAG, afi.getClientUid(), createNotification(userInfo.name, foregroundContext, afi.getClientUid()), foregroundContext.getUser());
        return;
    L21:
        return;
    L7:
        userInfo = this.mUserManager.getUserInfo(userId);
        goto L8
    }

    void dismissNotificationIfNecessary(int notificationClientUid) {
        if (getAudioFocusInfoForNotification(notificationClientUid) == null) goto L5;
        return;
    L5:
        if (isNotificationShown(notificationClientUid) == false) goto L9;
        dismissNotification(notificationClientUid);
        this.mNotificationClientUids.remove(Integer.valueOf(notificationClientUid));
        return;
    }

    private void dismissNotification(int notificationClientUid) {
        this.mNotificationManager.cancelAsUser(LOG_TAG, notificationClientUid, UserHandle.ALL);
    }

    AudioFocusInfo getAudioFocusInfoForNotification(int notificationClientUid) {
        if (notificationClientUid < 0) goto L10;
        List<AudioFocusInfo> stack = this.mFocusControlAudioPolicy.getFocusStack();
        int i = stack.size() - 1;
    L4:
        if (i < 0) goto L14;
        if (stack.get(i).getClientUid() == notificationClientUid) goto L8;
        i = i - 1;
        goto L4
    L8:
        return stack.get(i);
    L14:
        return null;
    L10:
        return null;
    }

    private PendingIntent createPendingIntent(String intentAction, int notificationClientUid) {
        Intent intent = new Intent(intentAction);
        intent.putExtra(EXTRA_NOTIFICATION_CLIENT_UID, notificationClientUid);
        return PendingIntent.getBroadcast(this.mSystemUserContext, notificationClientUid, intent, 67108864);
    }

    Notification createNotification(String userName, Context fgContext, int notificationClientUid) {
        String title = fgContext.getString(R.string.capability_desc_canControlMagnification, new Object[]{userName});
        PendingIntent mutePI = createPendingIntent(ACTION_MUTE_SOUND, notificationClientUid);
        PendingIntent switchPI = createPendingIntent(ACTION_SWITCH_USER, notificationClientUid);
        PendingIntent dismissNotificationPI = createPendingIntent(ACTION_DISMISS_NOTIFICATION, notificationClientUid);
        Notification.Action mute = new Notification.Action.Builder(null, fgContext.getString(R.string.call_notification_screening_text), mutePI).build();
        Notification.Action switchUser = new Notification.Action.Builder(null, fgContext.getString(R.string.candidates_style), switchPI).build();
        Notification.Builder notificationBuilder = new Notification.Builder(this.mSystemUserContext, BUSN_CHANNEL_ID).setSmallIcon(R.drawable.ic_private_profile_badge).setTicker(title).setCategory("reminder").setWhen(0).setOngoing(true).setColor(fgContext.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentIntent(mutePI).setAutoCancel(true).setDeleteIntent(dismissNotificationPI).setVisibility(1);
        if (this.mUserManager.isUserSwitcherEnabled() == true) goto L5;
    L7:
        notificationBuilder.setActions(new Notification.Action[]{mute});
    L9:
        return notificationBuilder.build();
    L5:
        if (this.mUserManager.getUserSwitchability(fgContext.getUser()) != 0) goto L7;
        notificationBuilder.setActions(new Notification.Action[]{mute, switchUser});
        goto L9
    }

    private boolean isNotificationShown(int notificationClientUid) {
        return this.mNotificationClientUids.contains(Integer.valueOf(notificationClientUid));
    }
}
