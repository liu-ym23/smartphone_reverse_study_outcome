package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PlaybackStateCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: compiled from: PlaybackStateCompatApi21.java */
    static final class a {
        public static String a(Object r2) {
            return ((PlaybackState.CustomAction) ZeusTransformUtils.preCheckCast(r2, PlaybackState.CustomAction.class, "com.obric.aiagent.plugin")).getAction();
        }

        public static CharSequence b(Object r2) {
            return ((PlaybackState.CustomAction) ZeusTransformUtils.preCheckCast(r2, PlaybackState.CustomAction.class, "com.obric.aiagent.plugin")).getName();
        }

        public static int c(Object r2) {
            return ((PlaybackState.CustomAction) ZeusTransformUtils.preCheckCast(r2, PlaybackState.CustomAction.class, "com.obric.aiagent.plugin")).getIcon();
        }

        public static Bundle d(Object r2) {
            return ((PlaybackState.CustomAction) ZeusTransformUtils.preCheckCast(r2, PlaybackState.CustomAction.class, "com.obric.aiagent.plugin")).getExtras();
        }

        public static Object a(String r2, CharSequence r3, int r4, Bundle r5) {
            PlaybackState.CustomAction.Builder r0 = new PlaybackState.CustomAction.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
            r0.setExtras(r5);
            return r0.build();
        }
    }

    public static int a(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getState();
    }

    public static long b(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getPosition();
    }

    public static long c(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getBufferedPosition();
    }

    public static float d(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getPlaybackSpeed();
    }

    public static long e(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getActions();
    }

    public static CharSequence f(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getErrorMessage();
    }

    public static long g(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getLastPositionUpdateTime();
    }

    public static List<Object> h(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getCustomActions();
    }

    public static long i(Object r2) {
        return ((PlaybackState) ZeusTransformUtils.preCheckCast(r2, PlaybackState.class, "com.obric.aiagent.plugin")).getActiveQueueItemId();
    }

    public static Object a(int r11, long r12, long r14, float r16, long r17, CharSequence r19, long r20, List<Object> r22, long r23) {
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
        return r10.build();
    }
}
