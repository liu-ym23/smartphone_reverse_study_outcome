package com.bytedance.android.livesdk.chatroom.vs_inject_api.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class SendReplayTextEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f118382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Sender f118383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f118384c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_inject_api/model/SendReplayTextEvent$Sender;", "", "Unknown", "CommentWidget", "Lottery", "VsPlusOne", "vs-inject-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Sender extends Enum<Sender> {
        public static final Sender CommentWidget = null;
        public static final Sender Lottery = null;
        public static final Sender Unknown = null;
        public static final Sender VsPlusOne = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Sender[] f118385a = null;

        static {
            Sender r100 = new Sender("Unknown", 0);
            Unknown = r100;
            Sender r101 = new Sender("CommentWidget", 1);
            CommentWidget = r101;
            Sender r102 = new Sender("Lottery", 2);
            Lottery = r102;
            Sender r103 = new Sender("VsPlusOne", 3);
            VsPlusOne = r103;
            f118385a = new Sender[]{r100, r101, r102, r103};
        }

        public static Sender valueOf(String r100) {
            return (Sender) r27.a.a(Sender.class, r100);
        }

        public static Sender[] values() {
            return (Sender[]) f118385a.clone();
        }

        public Sender(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public SendReplayTextEvent() {
        this.f118382a = "";
        this.f118383b = Sender.Unknown;
        this.f118384c = MapsKt.emptyMap();
    }
}
