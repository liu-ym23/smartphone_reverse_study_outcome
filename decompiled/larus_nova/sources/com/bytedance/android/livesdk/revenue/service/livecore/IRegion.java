package com.bytedance.android.livesdk.revenue.service.livecore;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import gr2.o;
import kotlin.Metadata;
import xh6.b;
import xh6.c;

/* JADX INFO: loaded from: classes11.dex */
public interface IRegion extends c, b {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IRegion$Status;", "", "", "toSeiFormat", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FOREGROUND", "BACKGROUND", "GAMEFULL", "UNKNOWN", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Status extends Enum<Status> {
        public static final Status BACKGROUND = null;
        public static final a Companion = null;
        public static final Status FOREGROUND = null;
        public static final Status GAMEFULL = null;
        public static final int SEI_STATUS_BACKGROUND = 1;
        public static final int SEI_STATUS_FOREGROUND = 0;
        public static final int SEI_STATUS_GAME_FULL = 2;
        public static final Status UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f157401a = null;

        public static final class a {
            public a() {
            }
        }

        static {
            Status r100 = new Status("FOREGROUND", 0);
            FOREGROUND = r100;
            Status r101 = new Status("BACKGROUND", 1);
            BACKGROUND = r101;
            Status r102 = new Status("GAMEFULL", 2);
            GAMEFULL = r102;
            Status r103 = new Status("UNKNOWN", 3);
            UNKNOWN = r103;
            f157401a = new Status[]{r100, r101, r102, r103};
            Companion = new a();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f157401a.clone();
        }

        public final int toSeiFormat() {
            if (this != FOREGROUND) goto L6;
            return 0;
        L6:
            if (this != BACKGROUND) goto L10;
            return 1;
        L10:
            if (this != GAMEFULL) goto L13;
            return 2;
        L13:
            return 0;
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IRegion$Type;", "", "", "toSeiFormat", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "VIDEO", "AUDIO", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Type extends Enum<Type> {
        public static final Type AUDIO = null;
        public static final a Companion = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f157402a = null;

        public static final class a {
            public a() {
            }
        }

        static {
            Type r100 = new Type("UNKNOWN", 0);
            UNKNOWN = r100;
            Type r101 = new Type("VIDEO", 1);
            VIDEO = r101;
            Type r102 = new Type("AUDIO", 2);
            AUDIO = r102;
            f157402a = new Type[]{r100, r101, r102};
            Companion = new a();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f157402a.clone();
        }

        public final int toSeiFormat() {
            if (this != VIDEO) goto L7;
            return 1;
        L7:
            if (this != AUDIO) goto L10;
            return 2;
        L10:
            return 0;
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean C1();

    o C4(double r100, double r101);

    o D3(double r100, double r101);

    void J1(Status r100);

    int M4();

    void S3(boolean r100);

    boolean d2();

    double getHeight();

    String getInteractId();

    Type getMediaType();

    Status getStatus();

    double getWidth();

    double getX();

    double getY();

    o i3(boolean r100);

    void l1(Type r100);

    void m2();

    o w3(int r100);

    boolean z4();
}
