package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PlaybackStateCompatApi22 {
    private PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object r100) {
        return ((PlaybackState) r100).getExtras();
    }

    public static Object newInstance(int r100, long r101, long r110, float r111, long r112, CharSequence r113, long r114, List<Object> r115, long r210, Bundle r211) {
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
        r102.setExtras(r211);
        return r102.build();
    }
}
