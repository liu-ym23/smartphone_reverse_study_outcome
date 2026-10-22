package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
class PlaybackStateCompatApi22 {
    private PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object r10) {
        return ((PlaybackState) r10).getExtras();
    }

    public static Object newInstance(int r10, long r11, long r12, float r13, long r14, CharSequence r16, long r17, List<Object> r19, long r20, Bundle r22) {
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
        r15.setExtras(r22);
        return r15.build();
    }
}
