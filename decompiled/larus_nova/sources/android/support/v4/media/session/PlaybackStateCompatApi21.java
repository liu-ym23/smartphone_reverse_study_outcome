package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PlaybackStateCompatApi21 {

    public static final class CustomAction {
        private CustomAction() {
        }

        public static String getAction(Object r100) {
            return ((PlaybackState.CustomAction) r100).getAction();
        }

        public static Bundle getExtras(Object r100) {
            return ((PlaybackState.CustomAction) r100).getExtras();
        }

        public static int getIcon(Object r100) {
            return ((PlaybackState.CustomAction) r100).getIcon();
        }

        public static CharSequence getName(Object r100) {
            return ((PlaybackState.CustomAction) r100).getName();
        }

        public static Object newInstance(String r100, CharSequence r101, int r102, Bundle r103) {
            PlaybackState.CustomAction.Builder r104 = new PlaybackState.CustomAction.Builder(r100, r101, r102);
            r104.setExtras(r103);
            return r104.build();
        }
    }

    private PlaybackStateCompatApi21() {
    }

    public static long getActions(Object r100) {
        return ((PlaybackState) r100).getActions();
    }

    public static long getActiveQueueItemId(Object r100) {
        return ((PlaybackState) r100).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object r100) {
        return ((PlaybackState) r100).getBufferedPosition();
    }

    public static List<Object> getCustomActions(Object r100) {
        return ((PlaybackState) r100).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object r100) {
        return ((PlaybackState) r100).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object r100) {
        return ((PlaybackState) r100).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object r100) {
        return ((PlaybackState) r100).getPlaybackSpeed();
    }

    public static long getPosition(Object r100) {
        return ((PlaybackState) r100).getPosition();
    }

    public static int getState(Object r100) {
        return ((PlaybackState) r100).getState();
    }

    public static Object newInstance(int r100, long r101, long r110, float r111, long r112, CharSequence r113, long r114, List<Object> r115, long r210) {
        PlaybackState.Builder r102 = new PlaybackState.Builder();
        r102.setState(r100, r101, r111, r114);
        r102.setBufferedPosition(r110);
        r102.setActions(r112);
        r102.setErrorMessage(r113);
        Iterator<Object> r103 = r115.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.addCustomAction((PlaybackState.CustomAction) r103.next());
        goto L4
    L6:
        r102.setActiveQueueItemId(r210);
        return r102.build();
    }
}
