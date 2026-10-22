package stepos.app;

import android.content.Context;
import android.media.StepOSRingtoneInfo;
import android.media.StepOSRingtoneManagerStub;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSRingtoneManager {
    public static final int TYPE_CALENDAR = 1024;
    public static final int TYPE_EMAIL = 512;
    public static final int TYPE_MMS = 256;
    public static final int TYPE_RINGTONE_1 = 2048;
    public static final int TYPE_RINGTONE_2 = 4096;

    public static Uri getActualDefaultRingtoneUri(Context context, int type) {
        return StepOSRingtoneManagerStub.get().getActualDefaultRingtoneUri(context, type);
    }

    public static boolean isUserSilenced(Context context, int type) {
        return StepOSRingtoneManagerStub.get().isUserSilenced(context, type);
    }

    public static Uri getDefaultUri(int type) {
        return StepOSRingtoneManagerStub.get().getDefaultUri(type);
    }

    public static Uri getDefaultRingtoneUri(Context context, int type) {
        return StepOSRingtoneManagerStub.get().getDefaultRingtoneUri(context, type);
    }

    public static StepOSRingtoneInfo getRingtoneInfo(Context context, Uri mediaUri) {
        return StepOSRingtoneManagerStub.get().getRingtoneInfo(context, mediaUri);
    }

    public static List<StepOSRingtoneInfo> getAllRingtoneInfos(Context context, int type, boolean includeInternal, boolean includeExternal) {
        return StepOSRingtoneManagerStub.get().getAllRingtoneInfos(context, type, includeInternal, includeExternal);
    }

    public static List<StepOSRingtoneInfo> getRingtoneInfos(Context context, int type, String fileName) {
        return StepOSRingtoneManagerStub.get().getRingtoneInfos(context, type, fileName);
    }

    public static String getDefaultDisplayName(Context context, int type) {
        return StepOSRingtoneManagerStub.get().getDefaultDisplayName(context, type);
    }

    public static void setActualDefaultRingtoneUri(Context context, int type, Uri ringtoneUri) {
        StepOSRingtoneManagerStub.get().setActualDefaultRingtoneUri(context, type, ringtoneUri);
    }

    public static Uri checkRingtoneUri(Context context, Uri uri, int streamType) {
        return StepOSRingtoneManagerStub.get().checkRingtoneUri(context, uri, streamType);
    }

    public static boolean isRingtoneExist(Context context, Uri uri) {
        return StepOSRingtoneManagerStub.get().isRingtoneExist(context, uri);
    }

    public static boolean isStepOSType(int type) {
        return StepOSRingtoneManagerStub.get().isStepOSType(type);
    }

    public static void ensureDefaultRingtones(Context context) {
        StepOSRingtoneManagerStub.get().ensureDefaultRingtones(context);
    }

    public static void onMediaReady(Context context) {
        StepOSRingtoneManagerStub.get().onMediaReady(context);
    }

    private StepOSRingtoneManager() {
    }
}
