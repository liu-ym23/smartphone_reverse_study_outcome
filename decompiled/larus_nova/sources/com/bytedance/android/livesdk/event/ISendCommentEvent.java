package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface ISendCommentEvent extends j {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/event/ISendCommentEvent$Sender;", "", "Unknown", "CommentWidget", "Lottery", "VsPlusOne", "SubscribeJSB", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Sender extends Enum<Sender> {
        public static final Sender CommentWidget = null;
        public static final Sender Lottery = null;
        public static final Sender SubscribeJSB = null;
        public static final Sender Unknown = null;
        public static final Sender VsPlusOne = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Sender[] f123312a = null;

        static {
            Sender r100 = new Sender("Unknown", 0);
            Unknown = r100;
            Sender r101 = new Sender("CommentWidget", 1);
            CommentWidget = r101;
            Sender r102 = new Sender("Lottery", 2);
            Lottery = r102;
            Sender r103 = new Sender("VsPlusOne", 3);
            VsPlusOne = r103;
            Sender r104 = new Sender("SubscribeJSB", 4);
            SubscribeJSB = r104;
            f123312a = new Sender[]{r100, r101, r102, r103, r104};
        }

        public static Sender valueOf(String r100) {
            return (Sender) r27.a.a(Sender.class, r100);
        }

        public static Sender[] values() {
            return (Sender[]) f123312a.clone();
        }

        public Sender(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static <T> T a(ISendCommentEvent r100, String r101, T r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Object r103 = r100.a().get(r101);
            if ((r103 instanceof Object) == true) goto L5;
            r103 = null;
        L5:
            if (r103 != null) goto L8;
            return r102;
        L8:
            return (T) r103;
        }
    }

    Map<String, Object> a();
}
