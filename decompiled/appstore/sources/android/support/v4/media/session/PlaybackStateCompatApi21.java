package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class PlaybackStateCompatApi21 {

    public static final class CustomAction {
        private CustomAction() {
        }

        public static String getAction(Object r10) {
            return ((PlaybackState.CustomAction) r10).getAction();
        }

        public static Bundle getExtras(Object r10) {
            return ((PlaybackState.CustomAction) r10).getExtras();
        }

        public static int getIcon(Object r10) {
            return ((PlaybackState.CustomAction) r10).getIcon();
        }

        public static CharSequence getName(Object r10) {
            return ((PlaybackState.CustomAction) r10).getName();
        }

        public static Object newInstance(String r10, CharSequence r11, int r12, Bundle r13) {
            PlaybackState.CustomAction.Builder r14 = new PlaybackState.CustomAction.Builder(r10, r11, r12);
            r14.setExtras(r13);
            return r14.build();
        }
    }

    private PlaybackStateCompatApi21() {
    }

    public static long getActions(Object r10) {
        return ((PlaybackState) r10).getActions();
    }

    public static long getActiveQueueItemId(Object r10) {
        return ((PlaybackState) r10).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object r10) {
        return ((PlaybackState) r10).getBufferedPosition();
    }

    public static List<Object> getCustomActions(Object r10) {
        return ((PlaybackState) r10).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object r10) {
        return ((PlaybackState) r10).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object r10) {
        return ((PlaybackState) r10).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object r10) {
        return ((PlaybackState) r10).getPlaybackSpeed();
    }

    public static long getPosition(Object r10) {
        return ((PlaybackState) r10).getPosition();
    }

    public static int getState(Object r10) {
        return ((PlaybackState) r10).getState();
    }

    public static Object newInstance(int r10, long r11, long r12, float r13, long r14, CharSequence r16, long r17, List<Object> r19, long r20) {
        PlaybackState.Builder r15 = new PlaybackState.Builder();
        r15.setState(r10, r11, r13, r17);
        r15.setBufferedPosition(r12);
        r15.setActions(r14);
        r15.setErrorMessage(r16);
        Iterator<Object> r18 = r19.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        r15.addCustomAction((PlaybackState.CustomAction) r18.next());
        goto L4
    L6:
        r15.setActiveQueueItemId(r20);
        return r15.build();
    }
}
