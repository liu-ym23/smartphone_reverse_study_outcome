package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: IslandSessionEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum TransitionAnimation extends Enum<TransitionAnimation> {
    private static final /* synthetic */ TransitionAnimation[] $VALUES = null;
    public static final Companion Companion = null;
    public static final TransitionAnimation SCALE = null;
    public static final TransitionAnimation VIBRATE = null;

    /* JADX INFO: compiled from: IslandSessionEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final TransitionAnimation fromString(String r2) {
            o.e(r2, "value");
            n.a r1 = n.f38560a;     // Catch: Throwable -> L5
            Object r3 = n.f(TransitionAnimation.valueOf(r2));     // Catch: Throwable -> L5
        L8:
            if (n.b(r3) == false) goto L11;
            r3 = null;
        L11:
            return (TransitionAnimation) ZeusTransformUtils.preCheckCast(r3, TransitionAnimation.class, "com.obric.aiagent.plugin");
        L5:
            th = move-exception;
            n.a r4 = n.f38560a;
            r3 = n.f(d.o.a(th));
            goto L8
        }
    }

    private static final /* synthetic */ TransitionAnimation[] $values() {
        return new TransitionAnimation[]{SCALE, VIBRATE};
    }

    public static TransitionAnimation valueOf(String r2) {
        return (TransitionAnimation) ZeusTransformUtils.preCheckCast(Enum.valueOf(TransitionAnimation.class, r2), TransitionAnimation.class, "com.obric.aiagent.plugin");
    }

    public static TransitionAnimation[] values() {
        return (TransitionAnimation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TransitionAnimation[].class, "com.obric.aiagent.plugin");
    }

    private TransitionAnimation(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SCALE = new TransitionAnimation("SCALE", 0);
        VIBRATE = new TransitionAnimation("VIBRATE", 1);
        $VALUES = $values();
        Companion = new Companion(null);
    }
}
