package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PlaybackStateCompatApi22.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    public static Bundle a(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getExtras();
    }

    public static Object a(int r11, long r12, long r14, float r16, long r17, CharSequence r19, long r20, List<Object> r22, long r23, Bundle r25) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        PlaybackState.Builder r10 = new PlaybackState.Builder();
        r10.setState(r11, r12, r16, r20);
        r10.setBufferedPosition(r14);
        r10.setActions(r17);
        r10.setErrorMessage(r0);
        Iterator r1 = r2.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r10.addCustomAction((PlaybackState.CustomAction) ZeusTransformUtils.preCheckCast(r1.next(), PlaybackState.CustomAction.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        r10.setActiveQueueItemId(r23);
        r10.setExtras(r25);
        return r10.build();
    }
}
