package com.bytedance.android.live.room.api.messagewindow.schedule;

import j71.a;
import kotlin.Metadata;
import v61.c;

/* JADX INFO: loaded from: classes47.dex */
public class ScheduleParams<Window extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f99028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Enqueue f99029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Window f99030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b71.a f99031d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/schedule/ScheduleParams$Enqueue;", "", "Tail", "Head", "Immediately", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Enqueue extends Enum<Enqueue> {
        public static final Enqueue Head = null;
        public static final Enqueue Immediately = null;
        public static final Enqueue Tail = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Enqueue[] f99032a = null;

        static {
            Enqueue r100 = new Enqueue("Tail", 0);
            Tail = r100;
            Enqueue r101 = new Enqueue("Head", 1);
            Head = r101;
            Enqueue r102 = new Enqueue("Immediately", 2);
            Immediately = r102;
            f99032a = new Enqueue[]{r100, r101, r102};
        }

        public static Enqueue valueOf(String r100) {
            return (Enqueue) r27.a.a(Enqueue.class, r100);
        }

        public static Enqueue[] values() {
            return (Enqueue[]) f99032a.clone();
        }

        public Enqueue(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ScheduleParams() {
        this.f99028a = a.c.f497566b;
        this.f99029b = Enqueue.Tail;
        this.f99031d = new b71.a.b();
    }
}
